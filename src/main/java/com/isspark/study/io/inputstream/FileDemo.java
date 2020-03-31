package com.isspark.study.io.inputstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    private static Logger logger = LoggerFactory.getLogger(FileDemo.class);

    public static void main(String[] args) {
        String pathname = "C:\\Users\\HX0011001\\Desktop\\azxx\\temp\\test.txt";
        createFile(pathname);
    }

    public static void createFile(String pathname){
        File file = new File(pathname);

        try {
            logger.info("文件是否存在：{}",file.exists());
            logger.info("是否是目录:{}",file.isDirectory());
            logger.info("是否是文件：{}",file.isFile());
            logger.info("是否是隐藏文件：{}",file.isHidden());
            logger.info("是否可读:{}",file.canRead());
            logger.info("是否可写：{}",file.canWrite());
            logger.error("删除文件：{}",file.delete());
            file.mkdir();
            //创建文件
            file.createNewFile();
            file.getAbsoluteFile();
            file.getAbsolutePath();
            file.getName();
            file.getPath();
            file.getParent();
            file.getParentFile().getName();
            file.renameTo(new File("otherName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
