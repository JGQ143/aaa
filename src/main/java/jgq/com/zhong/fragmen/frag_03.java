package jgq.com.zhong.fragmen;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

import jgq.com.zhong.R;


public class frag_03 extends Fragment {

    private VideoView videoView;
    private File file;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.frag_03,container,false);

        videoView = view.findViewById(R.id.videoView);

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            file = new File(Environment.getExternalStorageDirectory(),"A.mp4");
        }

        videoView.setVideoPath(file.getAbsolutePath());

        videoView.setMediaController(new MediaController(getActivity()));
        return view;
    }
}
