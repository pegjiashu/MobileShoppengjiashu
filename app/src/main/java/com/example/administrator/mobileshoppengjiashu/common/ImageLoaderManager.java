package com.example.administrator.mobileshoppengjiashu.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mobileshoppengjiashu.R;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import retrofit2.http.PUT;

public class ImageLoaderManager {

    private static ImageLoaderManager mInstance;
    public static ImageLoaderManager getInstance(){
        if (mInstance == null){
            synchronized (ImageLoaderManager.class){
                if (mInstance == null){
                    mInstance = new ImageLoaderManager();
                }
            }
        }
        return mInstance;
    }
    public ImageLoaderManager() {
        if (mInstance == null) {
            ImageLoader.getInstance().init(customImageLoaderConfig(MyApplication.getContext()));
            ImageLoader.getInstance().init(defaultImageLoaderConfig());
        }

    }
        private ImageLoaderConfiguration defaultImageLoaderConfig () {
            return ImageLoaderConfiguration.createDefault(MyApplication.getContext());
        }
        public static DisplayImageOptions product_options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.image_loading)
                .showImageForEmptyUri(R.drawable.image_empty)
                .showImageOnFail(R.drawable.image_error)
                .resetViewBeforeLoading(false)
                .delayBeforeLoading(1000)
                .cacheInMemory(false)
                .cacheOnDisk(false)
                .considerExifParams(false)
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new SimpleBitmapDisplayer())
                .handler(new Handler())
                .build();


    public static DisplayImageOptions user_options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading)
            .showImageForEmptyUri(R.drawable.face_default)
            .showImageOnFail(R.drawable.face_default)
            .resetViewBeforeLoading(false)
            .delayBeforeLoading(1000)
            .cacheInMemory(false)
            .cacheOnDisk(false)
            .considerExifParams(false)
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
            .bitmapConfig(Bitmap.Config.ARGB_8888)
            .displayer(new SimpleBitmapDisplayer())
            .handler(new Handler())
            .build();


    private ImageLoaderConfiguration customImageLoaderConfig (Context context){
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                    .memoryCacheExtraOptions(480, 480)
                    .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                    .diskCacheSize(50 * 1024 * 1024)
                    .diskCacheFileCount(100)
                    .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                    .diskCacheExtraOptions(480, 800, null)
                    .threadPoolSize(3)
                    .threadPriority(Thread.NORM_PRIORITY - 2)
                    .denyCacheImageMultipleSizesInMemory()
                    .imageDownloader(new BaseImageDownloader(context))
                    .defaultDisplayImageOptions(DisplayImageOptions.createSimple()).writeDebugLogs()
                    .build();
            return config;
        }

}
