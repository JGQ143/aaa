package jgq.com.zhong;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class Imagecircle {

    public static DisplayImageOptions Imageoptions() {

        DisplayImageOptions build = new DisplayImageOptions.Builder()
                .displayer(new RoundedBitmapDisplayer(100))
                .build();

        return build;
    }
}
