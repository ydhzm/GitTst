package com.pingan.tst.tstapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pingan.tst.tstapp.data.Student;
import com.pingan.tst.tstapp.data.StudentInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        TextView view = ((TextView)findViewById(R.id.txt));
        view.setOnClickListener(this);
        StringBuilder sb = new StringBuilder();

        Log.i("aa","ff"+Color.RED);
        Log.i("mytest","I want to test git command:git reset HEAD");
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




        String s1 = "ydh";
        String s2 = s1.intern();
        sb = new StringBuilder();
        if(s1 == s2){
            sb.append("s1=s2");
        }

        String a1 = new String("yyj");
        String a2 = a1.intern();
        String a3 = a1.intern();
        if(a1 == a2){
            sb.append("\n");
            sb.append("a1 = a2");
        }

        if( a2 == a3){
            sb.append("\n"+"a2 = a3");
        }

//        sb.reverse();
        sb = new StringBuilder();
        sb.append("Math.round(-11.4) = "+Math.round(-11.4f)+"\n");
        sb.append("Math.round(-11.5) = "+Math.round(-11.5f)+"\n");
        sb.append("Math.round(-11.6) = "+Math.round(-11.6f)+"\n");

        int value = 0xf;
        sb.append("\n"+String.valueOf(value)+" -- "+Integer.toBinaryString(value));
        sb.append("\n>>\n");
        value = value >> 1;
        sb.append(String.valueOf(value)+" --  " +Integer.toBinaryString(value));


        int value2 = 0xf;
        sb.append("\n"+String.valueOf(value2)+" -- "+Integer.toBinaryString(value2));
        sb.append("\n<<\n");
        value2 = value2 << 1;
        sb.append(String.valueOf(value2)+" --  " +Integer.toBinaryString(value2));
//        println(sb.toString());
        println(Integer.toBinaryString(-15)+"<<2 = "+Integer.toBinaryString(-15<<2));
        println(Integer.toBinaryString(-15)+">>2 = "+Integer.toBinaryString(-15>>2));
        println(Integer.toBinaryString(-15)+">>>2 = "+Integer.toBinaryString(-15>>>2));
        println("-1 = "+Integer.toBinaryString(-1));

        println("-15>>2 = "+(-15>>2));
        println("-15>>>2 = "+(-15>>>2));
        println("~-15 = "+Integer.toBinaryString(~-15));
        println(Integer.toBinaryString(15));
        println("~15 = "+Integer.toBinaryString(~15));
        println("~15 = "+~15);
        println(Integer.toBinaryString(15)+"^");
        println(Integer.toBinaryString(22));
        println(Integer.toBinaryString(15^22));
        println("-15  = "+Integer.toBinaryString(-15));
        println("-15L = "+Long.toBinaryString(-15L));
        println("-15>>>1= "+Integer.toBinaryString(-15>>>1));
        println("-15>>>31= "+Integer.toBinaryString(-15>>>31));
        println("-15>>>-1= "+Integer.toBinaryString(-15>>>-1));

        println("0 = "+Integer.toBinaryString(0));

        int testValue = 0;
        println(Integer.toBinaryString(testValue)+" has "+calcOneCount(testValue)+"\"1\"");
        testValue = -1;
        println(Integer.toBinaryString(testValue)+" has "+calcOneCount(testValue)+"\"1\"");
        testValue = -10;
        println(Integer.toBinaryString(testValue)+" has "+calcOneCount(testValue)+"\"1\"");
        testValue = 1993838;
        println(Integer.toBinaryString(testValue)+" has "+calcOneCount(testValue)+"\"1\"");
        testValue = 555;
        println(Integer.toBinaryString(testValue)+" has "+calcOneCount(testValue)+"\"1\"");

        testCloneWithSerializable();

    }

    @Override
    public void onClick(View v) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/sdcard/188/1.txt")));
            Object object = ois.readObject();
            Student zhangwei = (Student)object;
            println("反序列化serializab 后:"+zhangwei);
        } catch (IOException e) {
            Log.i("abc",e.toString());
        }catch (ClassNotFoundException e) {
            Log.i("abc",e.toString());
        }
    }

    private void testCloneWithSerializable(){
        ObjectOutputStream oos = null;
        try {
            String sdPath = Environment.getExternalStorageDirectory().getPath();
            File file = new File("/sdcard"+"/188/1.txt");
            File parentFile = file.getParentFile();
            if(!parentFile.exists()){
                boolean result = parentFile.mkdirs();
                if(parentFile.exists()){
                    println("create Dir 888");
                }

            }
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            oos = new ObjectOutputStream(new FileOutputStream(file));
            Student zhangwei = new Student("张伟", 25, new StudentInfo(95));
            println("serializab 前:"+zhangwei);
            oos.writeObject(zhangwei);
            oos.flush();
        }catch (IOException e) {
            println(e.toString());
        } finally {
            try{
                if(oos!=null){
                    oos.close();
                }
            } catch (Exception e){

            }
        }
    }
    private void print(String s){
        TextView view = ((TextView)findViewById(R.id.txt));
        view.setText(view.getText()+s);
    }
    private void println(String s){
        TextView view = ((TextView)findViewById(R.id.txt));
        view.setText(view.getText()+"\n"+s);
    }

    private int calcOneCount(int num){
        if(num==0){
            return 0;
        }
        if(num==-1){
            return 32;
        }
        int count =0;
        for(int i=0;i<32;i++){
            int result = (num>>>i)&0x01;
            if(result == 1){
                count++;
            }
        }
        return count;
    }

}
