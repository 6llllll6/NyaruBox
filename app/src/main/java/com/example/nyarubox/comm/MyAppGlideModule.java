package com.example.nyarubox.comm;


import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

//import okhttp3.OkHttpClient;

@GlideModule
public final class MyAppGlideModule extends AppGlideModule {
//    @Override
//    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
//        OkHttpClient client = UnsafeOkHttpClient.getUnsafeOkHttpClient();
//        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(client));
//    }
}
