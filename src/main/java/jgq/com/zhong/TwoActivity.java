package jgq.com.zhong;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit1;
    private EditText edit2;
    private CheckBox box1;
    private CheckBox box2;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        box1 = findViewById(R.id.checkBox);
        box2 = findViewById(R.id.checkBox2);

        findViewById(R.id.button).setOnClickListener(this);

        sp = getSharedPreferences("login", Context.MODE_PRIVATE);

        String name = sp.getString("edit1", "");
        String pwd = sp.getString("edit2", "");

        boolean jz = sp.getBoolean("jz", false);

        if (jz){
            edit1.setText(name);
            edit2.setText(pwd);
        }

        boolean dl = sp.getBoolean("dl", false);

        if (dl){

            startActivity(new Intent(TwoActivity.this,ThreeActivity.class));

            finish();
            return;
        }

        edit1.setText(sp.getString("edit1",""));
        edit2.setText(sp.getString("edit2",""));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String name = edit1.getText().toString().trim();
                String pwd = edit2.getText().toString().trim();
                if (name.equals("")||pwd.equals("")){
                    Toast.makeText(TwoActivity.this,"请您先输入!",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    Toast.makeText(TwoActivity.this,"登陆成功!",Toast.LENGTH_LONG).show();
                }
                if (box2.isChecked()){
                    SharedPreferences.Editor edit = sp.edit();

                    edit.putString("edit1",name);
                    edit.putString("edit2",pwd);

                    edit.putBoolean("jz",true);

                    edit.commit();
                }

                if (box1.isChecked()){
                    SharedPreferences.Editor edit = sp.edit();

                    edit.putBoolean("dl",true);
                    edit.commit();

                }
                startActivity(new Intent(TwoActivity.this,ThreeActivity.class));
                finish();
                break;
        }
    }
}
