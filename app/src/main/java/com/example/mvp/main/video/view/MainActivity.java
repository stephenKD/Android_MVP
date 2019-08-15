package com.example.mvp.main.video.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_mvp_retrofit2_rxjava.R;
import com.example.mvp.dto.videoDto.response.VideoRecommendResponse;
import com.example.mvp.main.video.presenter.VideoRecommendPresenter;

public class MainActivity extends AppCompatActivity {

    private VideoRecommendPresenter presenter;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPresenter();
    }

    private void initView() {
        tv = findViewById(R.id.textView);
        findViewById(R.id.videoBtn).setOnClickListener(v -> presenter.getVideoRecommend());
    }

    private void initPresenter() {
        presenter = new VideoRecommendPresenter(new VideoRecommendPresenter.VideoRecommendCallback() {
            @Override
            public void onVideoRecommendSuccess(VideoRecommendResponse dto) {
                tv.setText(dto.getMessage());
            }

            @Override
            public void onVideoRecommendFail(String errorMsg) {
                Toast.makeText(MainActivity.this,errorMsg,Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
