package com.isspark.study.regex;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Smile on 2018/10/30.
 */
public class VerifyDate {

    private static Logger logger = Logger.getLogger(VerifyDate.class.getName());

    public static void main(String[] args) {

        logger.info(isDate("2018-08-09")+"");
        logger.info(isDate("2018/08/09")+"");
        logger.info(isDate("2018-08-09 00:00:00")+"");
        logger.info(isDate("2018/08/09 00:00:00")+"");

        logger.info(isDateTime("2018-08-09")+"");
        logger.info(isDateTime("2018/08/09")+"");
        logger.info(isDateTime("2018-08-09 00:00:00")+"");
        logger.info(isDateTime("2018/08/09 00:00:00")+"");
    }

    /**
     * 校验日期格式 yyyy-MM-dd 和 yyyy/MM/dd
     * @param date
     * @return
     */
    public static boolean isDate(String date){
        //校验日期格式 yyyy-MM-dd
        String regex = "^\\d{4}-\\d{1,2}-\\d{1,2}";
        //校验日期格式 yyyy/MM/dd
        String regex2 = "^\\d{4}/\\d{1,2}/\\d{1,2}";
        String regex3 = "^\\d{4}[/|-]\\d{1,2}[/|-]\\d{1,2}";
//        return isRightFormat(regex,date)|isRightFormat(regex2,date);
        return isRightFormat(regex3,date);
    }

    /**
     * 校验日期格式 yyyy-MM-dd HH:mm:ss 和 yyyy/MM/dd HH:mm:ss
     * @param dateTime
     * @return
     */
    public static boolean isDateTime(String dateTime){
        //校验日期格式 yyyy-MM-dd
        String regex = "^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}";
        //校验日期格式 yyyy/MM/dd
        String regex2 = "^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}";
        String regex3 = "^\\d{4}[/|-]\\d{1,2}[/|-]\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}";
//        return isRightFormat(regex,dateTime)|isRightFormat(regex2,dateTime);
        return isRightFormat(regex3,dateTime);
    }

    public static boolean isRightFormat(String regex,String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
