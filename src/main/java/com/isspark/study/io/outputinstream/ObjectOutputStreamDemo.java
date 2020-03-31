package com.isspark.study.io.outputinstream;

import com.isspark.study.pojo.User;
import com.isspark.study.properties.PropUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class ObjectOutputStreamDemo {

    private static Logger logger = LoggerFactory.getLogger(ObjectOutputStreamDemo.class);

    public static void main(String[] args) {
        String pathname = PropUtils.get("pathname");
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(getOutputStream(pathname));
//            out.writeInt(123);
            User user = new User("xuzheng",28);
            out.writeObject(user);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(out);
        }
    }

    public static void close(OutputStream outputStream){
        if(outputStream==null){
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OutputStream getOutputStream(String pathname){
        try {
            FileOutputStream out = new FileOutputStream(pathname);
            return out;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }


}
