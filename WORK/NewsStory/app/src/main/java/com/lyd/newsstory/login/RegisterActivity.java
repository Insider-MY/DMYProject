package com.lyd.newsstory.login;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lyd.newsstory.R;

public class RegisterActivity extends AppCompatActivity {
    private final static String TAG ="RegisterActivity";
    private EditText user_ed,password_ed,confirm_ed;
    private Button register_btn;
    private SharedPreferences.Editor editor;
    private DBHelper dbHelper ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        user_ed = findViewById(R.id.ed_register_account);
        password_ed =findViewById(R.id.ed_register_password);
        confirm_ed =findViewById(R.id.ed_confirm_password);
        register_btn =findViewById(R.id.btn_register_user);
        dbHelper =new DBHelper(this,"User.db",null,1);
        //对用户注册的筛选
        user_ed.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        for (int i =start ; i<end;i++){
                            if (!Character.isLetterOrDigit(source.charAt(i))&&
                                    !Character.toString(source.charAt(i)).equals("_")){
                                Toast.makeText(RegisterActivity.this, "只能使用字母,数字,汉字注册!", Toast.LENGTH_SHORT).show();
                                return "";
                            }
                        }
                        return null;
                    }
                }
        });
        user_ed.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    user_ed.clearFocus(); //清除焦点
                    // 清除焦点时,隐藏键盘
                    InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(user_ed.getWindowToken(),0);
                }
                return false;
            }
        });
        password_ed.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId ==EditorInfo.IME_ACTION_DONE){
                    String s =v.getText().toString();
                    if (s.length() >= 6){
                        password_ed.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(password_ed.getWindowToken(),0);
                    }else {
                        Toast.makeText(RegisterActivity.this, "密码最少为六位数", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
        confirm_ed.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId ==EditorInfo.IME_ACTION_DONE){
                    confirm_ed.clearFocus();
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(confirm_ed.getWindowToken(),0);
                }
                return false;
            }
        });
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckIsDataAlreadyInDBorNot(user_ed.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "该用户已被注册,注册失败", Toast.LENGTH_SHORT).show();
                }else {
                    if (password_ed.getText().toString().trim().equals(confirm_ed.getText().toString())){
                        registerUserInfo(user_ed.getText().toString(),password_ed.getText().toString());
                        Toast.makeText(RegisterActivity.this, "注册成功!", Toast.LENGTH_SHORT).show();
                        saveUserInfo();
                        Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(RegisterActivity.this, "两次输入密码不同,请重新输入!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void saveUserInfo(){
        SharedPreferences sp =getSharedPreferences("UserInfo",MODE_PRIVATE);
        editor =sp.edit();
        editor.putString("username",user_ed.getText().toString());
        //判断注册时两次密码是否相同
        if(password_ed.getText().toString().equals(confirm_ed.getText().toString())){
            editor.putString("password",password_ed.getText().toString());
        }
        editor.commit();
    }

    //利用sql创建嵌入式数据库进行注册访问
    private void registerUserInfo(String username,String password){
        SQLiteDatabase database =dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("username",username);
        values.put("password",password);
        database.insert("usertable",null,values);
        database.close();
    }

    public boolean CheckIsDataAlreadyInDBorNot(String value){
        SQLiteDatabase database =dbHelper.getWritableDatabase();
        String Query ="select * from usertable where username =?";
        Cursor cursor =database.rawQuery(Query,new String[]{value});
        if (cursor.getCount()>0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

}
