package com.example.utils;

import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class IOUtil {

    private static Scanner scanner = new Scanner(System.in);


    public static String readString(){
        return scanner.next();
    }

    public static String prompt(String msg){
        System.out.print(msg+": ");
        return readString();
    }

    public static boolean writeObjectToFile(String filename, Object serObj) {
        try (
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)
        ){
            objectOut.writeObject(serObj);
            return true;
        } catch (Throwable e) {
            return false;
        }
    }

    public static Object loadObjectFromFile(String filename){
        try(
                FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)
        ){
            return objectIn.readObject();
        }catch (Throwable e){
            throw new RuntimeException(e);
        }
    }

}
