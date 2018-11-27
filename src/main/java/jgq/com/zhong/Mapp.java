package jgq.com.zhong;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class Mapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this).build();

        ImageLoader instance = ImageLoader.getInstance();

        instance.init(imageLoaderConfiguration);
    }
}
