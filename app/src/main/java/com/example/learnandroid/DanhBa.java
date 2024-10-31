package com.example.learnandroid;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.learnandroid.model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        EdgeToEdge.enable(this);
        addControls();
        showAllContact();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_ASK_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAllContact();
            } else {
                Toast.makeText(this, "Permission denied to read contacts", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showAllContact() {
        dsDanhBa.clear(); // Xóa danh sách trước khi thêm mới

        // Thêm dữ liệu giả vào danh sách
        dsDanhBa.add(new Contact("Nguyễn Văn A", "0123456789"));
        dsDanhBa.add(new Contact("Trần Thị B", "0987654321"));
        dsDanhBa.add(new Contact("Lê Thị C", "0912345678")); // Thêm thêm một số liên hệ giả khác

        adapterDanhBa.notifyDataSetChanged(); // Cập nhật adapter để hiển thị danh sách mới
    }

    private void addControls() {
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(
                DanhBa.this, android.R.layout.simple_list_item_1, dsDanhBa
        );
        lvDanhBa.setAdapter(adapterDanhBa);
    }
}
