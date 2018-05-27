package com.pingan.tst.tstapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        StringBuilder sb = new StringBuilder();

        Log.i("aa","ff"+Color.RED);
        Color color1 = Color.RED;
        Color color2 = Color.BLACK;
        if(color1.equals(color2)){

        }


        String str = System.getProperty("sun.boot.class.path");
        str += System.getProperty("java.library.path");
        Class cls = MainActivity.this.getClass();
        ClassLoader clsLd = MainActivity.class.getClassLoader();

        while (clsLd != null){
            sb.append(clsLd);
            sb.append("\n");
            clsLd = clsLd.getParent();
        }

        sb.reverse();
        ((TextView)findViewById(R.id.txt)).setText(sb.toString());
    }

}
