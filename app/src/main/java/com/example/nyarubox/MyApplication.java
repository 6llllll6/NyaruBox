package com.example.nyarubox;

import android.app.Application;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.nyarubox.comm.TransformationScale;
import com.example.nyarubox.view.IImageLoader;
import com.example.nyarubox.view.XRichText;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        initCrashReport();
        // 在任意地方，调用以下方法即可，崩溃发生后，会在下一次App启动的时候使用Service异步打包日志，
        // 然后上传日志，发送成功与否，Service都会自动退出释放内存
        //LogReport.getInstance().upload(this);
        // 使用以下方法，打印Log的同时，把Log信息保存到本地（保存的时候会附带线程名称，线程id，打印时间），
        // 并且随同崩溃日志一起，发送到特定的邮箱或者服务器上。帮助开发者还原用户的操作路径，更好的分析崩溃产生的原因
        //LogWriter.writeLog("wenming", "打Log测试！！！！");

        XRichText.getInstance().setImageLoader(new IImageLoader() {
            @Override
            public void loadImage(final String imagePath, final ImageView imageView, final int imageHeight) {
                Log.e("---", "imageHeight: "+imageHeight);
                //如果是网络图片
//                if (imagePath.startsWith("http://") || imagePath.startsWith("https://")){
//                    Glide.with(getApplicationContext()).asBitmap().load(imagePath).dontAnimate()
//                            .into(new SimpleTarget<Bitmap>() {
//                                @Override
//                                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
//                                    if (imageHeight > 0) {//固定高度
//                                        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
//                                                FrameLayout.LayoutParams.MATCH_PARENT, imageHeight);//固定图片高度，记得设置裁剪剧中
//                                        lp.bottomMargin = 10;//图片的底边距
//                                        imageView.setLayoutParams(lp);
//                                        Glide.with(getApplicationContext()).asBitmap().load(imagePath).centerCrop()
//                                                .placeholder(R.mipmap.img_load_fail).error(R.mipmap.img_load_fail).into(imageView);
//                                    } else {//自适应高度
//                                        Glide.with(getApplicationContext()).asBitmap().load(imagePath)
//                                                .placeholder(R.mipmap.img_load_fail).error(R.mipmap.img_load_fail).into(new TransformationScale(imageView));
//                                    }
//                                }
//                            });
//                } else { //如果是本地图片
                    if (imageHeight > 0) {//固定高度
                        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                                FrameLayout.LayoutParams.MATCH_PARENT, imageHeight);//固定图片高度，记得设置裁剪剧中
                        lp.bottomMargin = 10;//图片的底边距
                        imageView.setLayoutParams(lp);

                        Glide.with(getApplicationContext()).asBitmap().load(imagePath).centerCrop()
                                .into(imageView);
                    } else {//自适应高度
                        Glide.with(getApplicationContext()).asBitmap().load(imagePath)
                                .into(new TransformationScale(imageView));
                    }
//                }
            }
        });
    }

}
