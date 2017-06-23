package com.xys.butterknifetest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {


    @BindView(R.id.tv_show)
    TextView mTvShow;
    @BindView(R.id.img_show)
    ImageView mImgShow;
    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @OnClick(R.id.btn1)
    public void onMBtn1Clicked() {
        mTvShow.setText("事件1触发");
        Toast.makeText(this, "事件1触发", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn2)
    public void onMBtn2Clicked() {
        mTvShow.setText("事件2触发");
        Toast.makeText(this, "事件2触发", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn3)
    public void onMBtn3Clicked() {
        mTvShow.setText("事件3触发");
        Toast.makeText(this, "事件3触发", Toast.LENGTH_SHORT).show();
    }
}
