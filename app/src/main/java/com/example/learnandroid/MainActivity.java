package com.example.learnandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.learnandroid.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnXacNhan;
    EditText editUserName,editPassword,editEmail;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnXacNhan=findViewById(R.id.buttonXacNhan);
        editUserName=findViewById(R.id.editTextUserName);
        editPassword=findViewById(R.id.editTextPassword);
        editEmail=findViewById(R.id.editTextEmail);
        cbRemember=findViewById(R.id.checkBoxRemember);
        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
        editUserName.setText(sharedPreferences.getString("taikhoan",""));
        editPassword.setText(sharedPreferences.getString("matkhau",""));
        editEmail.setText(sharedPreferences.getString("email",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked",false));
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=editUserName.getText().toString().trim();
                String password=editPassword.getText().toString().trim();
                String email=editEmail.getText().toString().trim();
                if(username.equals("VanHuy")&&password.equals("123123az")&&email.equals("Phamvahuy2004@gmail.com")){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("taikhoan",username);
                        editor.putString("matkhau",password);
                        editor.putString("email",email);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Lỗi đăng nhập",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.remove("taikhoan");
                    editor.remove("matkhau");
                    editor.remove("email");
                    editor.remove("checked");
                    editor.commit();
                }
            }
        });
        EdgeToEdge.enable(this);
    }
}