package com.pingan.tst.tstapp.Utils;

import android.util.Log;

import java.io.File;

public class FileUtil {
    public static void print(String s){
        System.out.println(s);//
        Log.i("aa",s);
    }

    public static File[] listAllFiles(File file){
        if(file==null || !file.exists() || file.getAbsolutePath().contains("pingan")){

            return null;
        }
        if(file.isFile()){
            File[] fileArray = new File[1];
             fileArray[0] = file;
            return fileArray;
        }
        if(file.isDirectory()){
            return file.listFiles();
        }
        return null;
    }
    public static boolean isPingAnFile(){
        return  false;
    }
}
