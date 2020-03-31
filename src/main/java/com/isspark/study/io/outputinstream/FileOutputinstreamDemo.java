package com.isspark.study.io.outputinstream;

import java.io.*;

public class FileOutputinstreamDemo {

    public static void main(String[] args) {
        write("this is new line");
    }

    public static void write(String content){
        File file = new File("D:\\test.txt");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeOutputStream(out);
        }
    }

    public static void closeOutputStream(OutputStream in){
        if(in !=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
