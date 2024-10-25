package com.example.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);
        final EditText receiveValueEdit = (EditText) findViewById(R.id.value_receive);
        final Button callReceiverButton = (Button) findViewById(R.id.call_button);

        // Lay ve Bundle duoc gui kem Intent roi lay ra giatri
        Bundle receiveBundle = this.getIntent().getExtras();
        final long receiveValue = receiveBundle.getLong("value");
        receiveValueEdit.setText(String.valueOf(receiveValue));
        callReceiverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this, Receiver.class);
                i.putExtra("new value", receiveValue - 10);
                sendBroadcast(i);
            }
        });
        EdgeToEdge.enable(this);
    }
}