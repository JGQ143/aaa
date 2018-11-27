package jgq.com.zhong;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import jgq.com.zhong.Fragment.Frag_Four;
import jgq.com.zhong.Fragment.Frag_One;
import jgq.com.zhong.Fragment.Frag_Three;
import jgq.com.zhong.Fragment.Frag_Two;

public class ThreeActivity extends AppCompatActivity {

    String urlBitmap = "http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg";

    private FragmentManager manager;
    private RadioGroup radio;
    private DrawerLayout dr;
    private ListView listview;
    private Frag_One frag_one;
    private Frag_Two frag_two;
    private Frag_Three frag_three;
    private Frag_Four frag_four;
    private LinearLayout ll;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        //获取图片
        image = findViewById(R.id.imageview2);

        DisplayImageOptions options = Imagecircle.Imageoptions();

        ImageLoader instance = ImageLoader.getInstance();

        instance.displayImage(urlBitmap,image,options);

        //获取侧拉控件

        dr = findViewById(R.id.dr);

        listview = findViewById(R.id.listview);

        ll = findViewById(R.id.ll);


        ArrayList<String> list = new ArrayList<>();

        for (int i=0;i<1;i++){
            list.add("首页");
            list.add("资料卡");
            list.add("钱包");
            list.add("我的");

        }

        ArrayAdapter<String> myadapter = new ArrayAdapter<>(ThreeActivity.this,android.R.layout.simple_list_item_1,list);

        listview.setAdapter(myadapter);


        //点击条目跳转

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();

                transaction2.hide(frag_one);
                transaction2.hide(frag_two);
                transaction2.hide(frag_three);
                transaction2.hide(frag_four);

                switch (position){
                    case 0:
                        transaction2.show(frag_one);
                        break;
                    case 1:
                        transaction2.show(frag_two);
                        break;
                    case 2:
                        transaction2.show(frag_three);
                        break;
                    case 3:
                        transaction2.show(frag_four);
                        break;
                }
                transaction2.commit();

                dr.closeDrawer(ll);

            }
        });



        manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();


        frag_one = new Frag_One();

        frag_two = new Frag_Two();
        frag_three = new Frag_Three();
        frag_four = new Frag_Four();

        transaction.add(R.id.frag, frag_one,"frag_one").show(frag_one);
        transaction.add(R.id.frag, frag_two);
        transaction.add(R.id.frag, frag_three);
        transaction.add(R.id.frag, frag_four);


        transaction.hide(frag_two);
        transaction.hide(frag_three);
        transaction.hide(frag_four);


        transaction.commit();

        radio = findViewById(R.id.radiogroup);

        radio.check(1);

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();

                transaction1.hide(frag_one);
                transaction1.hide(frag_two);
                transaction1.hide(frag_three);
                transaction1.hide(frag_four);
                switch (checkedId){
                    case 1:
                        transaction1.show(frag_one);
                        break;
                    case 2:
                        transaction1.show(frag_two);
                        break;
                    case 3:
                        transaction1.show(frag_three);
                        break;
                    case 4:
                        transaction1.show(frag_four);
                        break;
                }
                transaction1.commit();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Fragment frag_one = manager.findFragmentByTag("frag_one");

        frag_one.onActivityResult(requestCode,resultCode,data);
    }
}
