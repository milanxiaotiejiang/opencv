package com.example.opencv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2})
    void onClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, FaceActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, OpencvFaceActivity.class));
                break;
        }
    }
}
