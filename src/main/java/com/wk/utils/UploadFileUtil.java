package com.wk.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


@Slf4j
public class UploadFileUtil {

    public static String uploadFile(MultipartFile file, String filePath) {
        try {
            //没有就生成目录
            File createFile = new File(filePath);
            if (!createFile.exists()) {
                createFile.mkdirs();
            }
            //输入流
            FileInputStream fileInputStream = (FileInputStream) file.getInputStream();

            //存储路径
            String result = filePath + file.getOriginalFilename();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(result));

            //读文件
            byte[] bs = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            bos.flush();
            bos.close();

            //因为把  /user设置为了静态目录，服务会自己监听，因此就不需要在添加user了，去掉
            return result;
        } catch (Exception e) {
            log.error("上传文件失败");
        }
        return null;
    }
}