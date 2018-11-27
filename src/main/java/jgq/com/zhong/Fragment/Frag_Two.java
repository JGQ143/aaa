package jgq.com.zhong.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xlistviewlibrary.view.XListView;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import jgq.com.zhong.Bean;
import jgq.com.zhong.Imagecircle;
import jgq.com.zhong.R;


public class Frag_Two extends Fragment {

    String urlString ="http://api.tianapi.com/meinv/?key=c0bf81fbc2864ca3425a61ec7bcba15e&num=10";

    ArrayList<Bean.NewslistBean> list = new ArrayList<>();

    private XListView xlistview;
    private Myadapter myadapter;

    int page=0;
    private String murl;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.frag_two,container,false);



        //获取控件
        xlistview = view.findViewById(R.id.xlistview);

        myadapter = new Myadapter();

        xlistview.setAdapter(myadapter);

        //上下

        xlistview.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                list.clear();
                initdata(0);
            }

            @Override
            public void onLoadMore() {
                page++;
                initdata(page);
                page=0;
            }
        });

        //刷新
        xlistview.setPullLoadEnable(true);

        initdata(page);

        //条目监听

//        xlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(),WebActivity.class);
//
//                intent.putExtra("ff",list.get(position).getUrl());
//
//                startActivity(intent);
//            }
//        });
        return view;
    }

    private void initdata(int page) {
        murl = urlString + page;

        new MAysnc().execute(murl);

    }

    private class MAysnc extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {

            return Newuti.getJson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();

            Bean bean = gson.fromJson(s, Bean.class);

            List<Bean.NewslistBean> newslist = bean.getNewslist();

            list.addAll(newslist);

            myadapter.notifyDataSetChanged();

            uiComplete();

        }


    }

    private class Myadapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder1 vh1 = null;
            if (convertView ==null){
                convertView=View.inflate(getActivity(),R.layout.item_02,null);

                vh1 = new ViewHolder1();

                vh1.image1 = convertView.findViewById(R.id.imageview6);
                vh1.t1 = convertView.findViewById(R.id.textview6);

                convertView.setTag(vh1);
            }else{
                 vh1 = (ViewHolder1)convertView.getTag();
            }

            vh1.t1.setText(list.get(position).getTitle());

            DisplayImageOptions options = Imagecircle.Imageoptions();

            ImageLoader instance = ImageLoader.getInstance();

            instance.displayImage(list.get(position).getPicUrl(),vh1.image1,options);

            return convertView;
        }
    }


    private void uiComplete() {
        xlistview.setRefreshTime("刚刚");
        xlistview.stopRefresh();
        xlistview.stopLoadMore();
    }
    class ViewHolder1{
        public ImageView image1;
        public TextView t1;
    }


}
