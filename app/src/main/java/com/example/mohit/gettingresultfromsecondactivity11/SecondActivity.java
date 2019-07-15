package com.example.mohit.gettingresultfromsecondactivity11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView ttdata;
    EditText eedata;
    Button bttnresp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ttdata = findViewById(R.id.txtdata);
        eedata = findViewById(R.id.edtdata);
        bttnresp = findViewById(R.id.btnnsub);

        Bundle bundle =getIntent().getExtras();
        String data=bundle.getString("data_key");
        ttdata.setText(data);

        bttnresp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= eedata.getText().toString().trim();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("data_return", message);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
