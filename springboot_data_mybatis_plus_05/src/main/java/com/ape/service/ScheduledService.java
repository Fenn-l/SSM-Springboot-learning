package com.ape.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 定时任务调度演示
 *
 * 场景：每月1号凌晨汇总上月数据分析报表、每天凌晨分析前一天日志等定时操作。
 *
 * 关键点：
 * 1. 启动类上需加 @EnableScheduling 开启定时任务；
 * 2. 方法上标 @Scheduled，方法会按cron 表达式定时执行；
 * 3. cron 通过 cron 属性指定，格式为：秒 分 时 日 月 星期 [年]
 *    - 秒 分 时 日 月 星期 [年]
 *    - 3-6     ：3到6（范围）
 *    - 3,4,6   ：3、4、6（枚举）
 *    - 3/6     ：从3开始、每6（步长）
 *    - *       ：每（通配）
 * 4. 在线生成 cron 表达式：http://cron.qqe2.com/
 * 5. 定时任务方法【不能带参数】，否则启动报错。
 */
@Service
public class ScheduledService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledService.class);

    /**
     * 每天凌晨 2 点执行：分析前一天日志
     * cron：秒 分 时 日 月 星期
     * 0 0 2 * * ?   → 每天 02:00:00
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void analyzeLog() {
        log.info("【定时任务】每天凌晨2点：分析前一天日志 -> {}", new Date());
    }

    /**
     * 每周一凌晨 3 点执行：生成周报表
     * 0 0 3 ? * MON  → 每周一 03:00:00
     */
    @Scheduled(cron = "0 0 3 ? * MON")
    public void generateWeeklyReport() {
        log.info("【定时任务】每周一凌晨3点：生成周报表 -> {}", new Date());
    }

    /**
     * 每月 1 号凌晨 4 点执行：汇总上月数据分析报表
     * 0 0 4 1 * ?  → 每月1号 04:00:00
     */
    @Scheduled(cron = "0 0 4 1 * ?")
    public void generateMonthlyReport() {
        log.info("【定时任务】每月1号凌晨4点：汇总上月数据分析报表 -> {}", new Date());
    }

    /**
     * 每隔 10 秒执行一次（固定频率，不看cron）
     * initialDelay：程序启动后延迟多久开始执行（毫秒）
     * fixedRate：每隔多久执行一次（毫秒）
     */
    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void heartBeat() {
        log.info("【定时任务】心跳检查，每10秒执行一次 -> {}", new Date());
    }
}