package com.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IOUtil {

    private static Scanner scanner = new Scanner(System.in);


    public static String readString(){
        return scanner.next();
    }
}
