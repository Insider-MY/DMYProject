package com.lyd.newsstory.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lyd.newsstory.R;
import com.lyd.newsstory.activity.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private Button login,register;
    private TextView forget_password;
    private EditText ed_account,ed_password;
    private CheckBox cb_box;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String user,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        ed_account = findViewById(R.id.ed_account);
        ed_password =findViewById(R.id.ed_password);
        forget_password =findViewById(R.id.login_forget);
        login =findViewById(R.id.btn_login);
        register =findViewById(R.id.btn_register);
        cb_box =findViewById(R.id.cb_box);
        sp = getSharedPreferences("info", Context.MODE_PRIVATE);
        //判断是否保存密码
        if (sp.getBoolean("checkbox",false)){
            ed_account.setText(sp.getString("user",null));
            ed_password.setText(sp.getString("pass",null));
            cb_box.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag =false;    //判断是否登录成功
                user =ed_account.getText().toString();
                password =ed_password.getText().toString();
                DBHelper dbHelper =new DBHelper(LoginActivity.this,"User.db",null,1);
                Cursor cursor =dbHelper.select();
                cursor.moveToNext();
                while (cursor.moveToNext()){
                    if (cursor.getString(cursor.getColumnIndex("username"))
                            .equals(user)
                            &&(cursor.getString(cursor.getColumnIndex("password"))
                            .equals(password))){
                            if (cb_box.isChecked()){
                                editor =sp.edit();
                                editor.putString("user",user);
                                editor.putString("pass",password);
                                editor.putBoolean("checkbox",true);
                                editor.commit();
                            }else {
                                editor =sp.edit();
                                editor.putString("user",null);
                                editor.putString("pass",null);
                                editor.putBoolean("checkbox",false);
                                editor.commit();
                            }
                            flag =true;
                            Intent intent =new Intent();
                            Bundle bundle =new Bundle();
                            intent.setClass(LoginActivity.this, MainActivity.class);
                            bundle.putString("userName",user);
                            bundle.putString("PassWord",password);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                    }
                }
                if (flag ==false){
                    ed_account.setText(null);
                    ed_password.setText(null);
                    Toast.makeText(LoginActivity.this, "登录失败,账号:"
                            +user
                            +"密码:"
                            +password, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
