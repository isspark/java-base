package com.isspark.study.io.inputstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/**
 * Created by Smile on 2018/11/7.
 */
public class FileInputstreamDemon {

    private static Logger logger = LoggerFactory.getLogger(FileInputstreamDemon.class);

    public static void main(String[] args) {
        read("D:\\test.txt");
    }

    public static void read(String pathname) {

        File file = new File(pathname);
        if (!file.exists()) {
            return;
        }
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[5];
            int length = 0;
            while ((length = in.read(bytes)) != -1) {
                logger.info("读取到信息长度：{}", length);
                logger.info(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeInputStream(in);
        }
    }

    public static void closeInputStream(InputStream in){
        if(in !=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
