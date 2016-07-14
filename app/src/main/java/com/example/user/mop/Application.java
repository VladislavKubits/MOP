package com.example.user.mop;


import com.vk.sdk.VKSdk;

/**
 * Created by Kirill on 14.07.2016.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VKSdk.initialize(this);
    }
}
