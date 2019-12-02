package com.lyd.newsstory.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lyd.newsstory.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

public class PictureUtil {
    /**
     * 图片下载
     */
    public static void saveImage(ImageView shot, Context context){
        //外部存储目录
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        //创建文件夹
        File directory =new File(externalStorageDirectory,"lydpicture");
        //如果文件夹不存在,则创建
        if (!directory.exists()){
            directory.mkdir();
        }
        Bitmap drawingCache =shot.getDrawingCache();//缓存
        try {
            File file =new File(directory,new Date().getTime()+ ".jpg");
            FileOutputStream fos =new FileOutputStream(file);
            drawingCache.compress(Bitmap.CompressFormat.JPEG,100,fos);  //压缩
            Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri= Uri.fromFile(file);
            intent.setData(uri);
            context.sendBroadcast(intent);
            Toast.makeText(context,
                    "保存成功", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context,
                    "啊!竟然出错了 0.0", Toast.LENGTH_LONG).show();
        }
    }
    /*
    图片显示
     */
    public static void showImage(ImageView showImView, Context context, String ImageUrl){
        Glide.with(context)
                .load(ImageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(showImView);
    }
}
