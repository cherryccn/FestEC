package com.hjy.festec.example;

import android.app.Application;

import com.hjy.latte.app.Latte;
import com.hjy.latte.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")//本地的地址
                .configure();
    }
}
