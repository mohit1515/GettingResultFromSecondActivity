package com.example.mohit.gettingresultfromsecondactivity11;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tdata;
    Button btnsend;
    EditText edata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tdata = findViewById(R.id.txtData);
        edata = findViewById(R.id.edtdata);
        btnsend = findViewById(R.id.btnsub);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edata.getText().toString().trim();
                Intent intent= new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data_key", str);
                startActivityForResult(intent, 15);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(RESULT_OK, 15, data);
        String mydata = data.getExtras().getString("data_return");//important to get data in the form of string
        tdata.setText(mydata);



    }
}
