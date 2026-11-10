package com.ape.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * 异步任务演示
 *
 * 场景：批量处理数据、批量发送邮件、批量发送短信等容易造成阻塞的操作，
 *      用异步方式执行以提高效率。
 *
 * 关键点：
 * 1. 启动类上需加 @EnableAsync 开启异步任务；
 * 2. 方法上标 @Async，该方法就会异步执行（由Spring 管理线程池调用）；
 * 3. @Async 方法内部不能再调用同类中的 @Async 方法（代理失效）；
 * 4. 返回 CompletableFuture 可以拿到异步执行结果。
 */
@Service
public class AsyncService {

    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    /**
     * 无返回值的异步方法：模拟批量发送短信
     *
     * @param userId 用户id
     */
    @Async
    public void sendSms(Integer userId) {
        log.info("【异步】开始给用户 {} 发送短信...", userId);
        //模拟耗时操作
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("【异步】给用户 {} 的短信发送完成", userId);
    }

    /**
     * 有返回值的异步方法：返回 CompletableFuture，
     * 调用方可通过 .get() 拿到执行结果，或 .join() 等待完成
     *
     * @param userId 用户id
     * @return CompletableFuture<String>
     */
    @Async
    public CompletableFuture<String> sendEmailAsync(Integer userId) {
        log.info("【异步】开始给用户 {} 发送邮件...", userId);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = "用户" + userId + "的邮件已发送完成";
        log.info("【异步】{}", result);
        return CompletableFuture.completedFuture(result);
    }

    /**
     * 模拟批量处理：循环调用自身的方法批量发送短信
     * 注意：这里调用的是【别的 Bean】的 @Async 方法才会异步；
     *      如果在同一个类内部直接 this.sendSms() 会走代理失效，变成同步。
     */
    public void batchSendSms(AsyncService asyncService) {
        for (int i = 1; i <= 5; i++) {
            asyncService.sendSms(i);
        }
    }
}