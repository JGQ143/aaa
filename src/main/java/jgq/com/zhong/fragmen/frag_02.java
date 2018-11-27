package jgq.com.zhong.fragmen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import jgq.com.zhong.R;

public class frag_02 extends Fragment {

    private Banner banner;

    ArrayList<String> list_path = new ArrayList<>();
    ArrayList<String> list_title = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_02,container,false);

        banner = view.findViewById(R.id.banner);

        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();

                instance.displayImage((String) path,imageView);
            }
        });

        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");


        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);

        list_title.add("杨老二1");
        list_title.add("杨老二2");
        list_title.add("杨老二3");
        list_title.add("杨老二4");

        banner.setImages(list_path);
        banner.setBannerTitles(list_title);
        banner.start();

        return view;
    }
}
