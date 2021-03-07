package com.example.insta;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("sAWqVOey9aPR6MN0dIk6UPim9t964DYB7LZnvT1w")
                .clientKey("fSExbgigpOrf7Vu929Xj977lKnzdZkjpArAUHJkm")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
