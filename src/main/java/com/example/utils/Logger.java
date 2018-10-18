package com.example.utils;

import java.time.LocalDateTime;

public class Logger {
    private final static String INFO_TEMPLATE = "[INFO] %s : %s";
    private final static String ERR_TEMPLATE = "[ERROR] %s : %s";


    public static void info(String message){
        System.out.println(String.format(INFO_TEMPLATE, LocalDateTime.now().toString(),message));
    }

    public static void error(String message) {
        System.out.println(String.format(INFO_TEMPLATE, LocalDateTime.now().toString(),message));
    }
}
