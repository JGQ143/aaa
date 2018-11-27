package jgq.com.zhong.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import jgq.com.zhong.R;
import jgq.com.zhong.fragmen.BlankFragment;
import jgq.com.zhong.fragmen.frag_01;
import jgq.com.zhong.fragmen.frag_02;
import jgq.com.zhong.fragmen.frag_03;


public class Frag_One extends Fragment {

    private TabLayout tb;
    private ViewPager vp;

    ArrayList<Fragment> fragmentList = new ArrayList<>();

    ArrayList<ChannelBean> channelBeanList = new ArrayList<>();
    private MyPagerAdapter myPagerAdapter;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.frag_one,container,false);
        //获取控件

        tb = view.findViewById(R.id.tb);

        vp = view.findViewById(R.id.vp);

        btn = view.findViewById(R.id.btn);

        //点击
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChannelActivity.startChannelActivity((AppCompatActivity) getActivity(),channelBeanList);
            }
        });

        initdata();
        return view;
    }

    private void initdata() {
        channelBeanList.add(new ChannelBean("数据",true));
        channelBeanList.add(new ChannelBean("轮播图",true));
        channelBeanList.add(new ChannelBean("视频",true));
        channelBeanList.add(new ChannelBean("旅游",false));
        channelBeanList.add(new ChannelBean("游戏",false));
        channelBeanList.add(new ChannelBean("更多",false));

        for (int i=0;i<channelBeanList.size();i++){
            if (channelBeanList.get(i).isSelect()){
                String name = channelBeanList.get(i).getName();
                tb.addTab(tb.newTab().setText(name));
                if (i == 0){
                    fragmentList.add(new frag_01());
                }else if (i ==1){
                    fragmentList.add(new frag_02());
                }else if (i == 2){
                    fragmentList.add(new frag_03());
                }else{
                    fragmentList.add(new BlankFragment());
                }
            }
        }

        myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());

        vp.setAdapter(myPagerAdapter);

        tb.setupWithViewPager(vp);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String json = data.getStringExtra(ChannelActivity.RESULT_JSON_KEY);

        Type type = new TypeToken<ArrayList<ChannelBean>>() {}.getType();

        Gson gson = new Gson();

        channelBeanList =gson.fromJson(json,type);

        tb.removeAllTabs();

        fragmentList.clear();

        for (int i=0;i<channelBeanList.size();i++){
            ChannelBean channelBean = channelBeanList.get(i);
            if (channelBean.isSelect()){
                String tname = channelBeanList.get(i).getName();
                tb.addTab(tb.newTab().setText(tname));
                if ("数据".equals(channelBean.getName())){
                    fragmentList.add(new frag_01());
                }else if ("轮播图".equals(channelBean.getName())){
                    fragmentList.add(new frag_02());
                }else if ("视频".equals(channelBean.getName())){
                    fragmentList.add(new frag_03());
                }else {
                    fragmentList.add(new BlankFragment());
                }
            }
        }

        myPagerAdapter.notifyDataSetChanged();

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return channelBeanList.get(position).getName();
        }
    }
}
