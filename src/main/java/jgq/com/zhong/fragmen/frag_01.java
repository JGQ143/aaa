package jgq.com.zhong.fragmen;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import jgq.com.zhong.Goods;
import jgq.com.zhong.MySqlite.Dao;
import jgq.com.zhong.R;

public class frag_01 extends Fragment {

    String baseUrl = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";

    ArrayList<Goods.DataBean> list = new ArrayList<>();

    private PullToRefreshListView pull;
    private Myadapter myadapter;
    int page=0;
    private Dao dao;
    private String murl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_01,container,false);
        //创建dao

        dao = new Dao(getActivity());

        //获取控件
        pull = view.findViewById(R.id.pull);

        myadapter = new Myadapter();

        pull.setAdapter(myadapter);

        //上下啦

        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                list.clear();
                initdata(0);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page++;
                initdata(page);
                page=0;
            }
        });

        //刷新

        pull.setMode(PullToRefreshListView.Mode.BOTH);

        initdata(page);

        return view;
    }

    private void initdata(int page) {
        murl = baseUrl + page;

        if (NewUtils.isCoon(getActivity())){
            new MAysnc().execute(murl);
        }else {
            Toast.makeText(getActivity(),"没网啦",Toast.LENGTH_LONG).show();

            String s = dao.querydata(murl);

            if (!s.isEmpty()){
                Gson gson = new Gson();

                Goods goods = gson.fromJson(s, Goods.class);

                List<Goods.DataBean> query = goods.getData();

                ArrayList<String> queryList = new ArrayList<String>();

                for (int i=0;i<query.size();i++){
                    queryList.add(query.get(i).getNews_title());
                }

                list.addAll(query);

                myadapter.notifyDataSetChanged();

                pull.onRefreshComplete();
            }


        }


    }

    //创建异步

    private class MAysnc extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {

            return NewUtils.getjson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            dao.insertdata(murl,s);

            Gson gson = new Gson();

            Goods goods = gson.fromJson(s, Goods.class);

            List<Goods.DataBean> data = goods.getData();

            ArrayList<String> stringList = new ArrayList<String>();

            for (int i=0;i<data.size();i++){
                stringList.add(data.get(i).getNews_title());
            }

            list.addAll(data);

            myadapter.notifyDataSetChanged();

            pull.onRefreshComplete();


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
            ViewHolder vh =null;
            if (convertView == null){
                convertView =View.inflate(getActivity(),R.layout.item_01,null);
                vh = new ViewHolder();

                vh.t1 = convertView.findViewById(R.id.textview1);

                convertView.setTag(vh);
            }else{
                 vh = (ViewHolder)convertView.getTag();
            }
            vh.t1.setText(list.get(position).getNews_title());
            return convertView;
        }
    }
    class ViewHolder{
        public TextView t1;
    }

}
