package com.ape.springboot_web_02_5.controller;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @version 1.0
 * @Author 王老师
 * @since 2023/4/12
 */
@Controller
@ResponseBody
public class UserController {

    //文件上传
    @RequestMapping("/fileupload")
    public String fileupload(MultipartFile upic,String uname){
        System.out.println("用户名:"+uname);
        System.out.println(upic);
        System.out.println(upic.getOriginalFilename());
        System.out.println(upic.getName());

        //方式1.将文件upic以流的方式写入当前服务器磁盘(应用服务器)
        //方式2.文件服务器（七牛云）
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "z7SQrBh786PzbvUpTHCQg41odtk-T64t1VXpPT3P";
        String secretKey = "sYNIDNB637ZjaL2UFMAb-7eLqnjrHYaQbJtXZdIJ";
        String bucket = "2026-01db";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        try {
            byte[] uploadBytes = upic.getBytes();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(uploadBytes, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);//获取文件名
                System.out.println(putRet.hash);//获取文件hash值
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }

        return "success";
    }
}
