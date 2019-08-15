package com.example.mvp.model;

import com.example.mvp.dto.videoDto.response.VideoRecommendResponse;
import com.example.mvp.service.VideoRecommendService;
import com.example.mvp.utlis.RetrofitUtils;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class VideoRecommendModel {
    public Single<VideoRecommendResponse> getVideoRecommend() {
        return RetrofitUtils.getInstance().create(VideoRecommendService.class).getVideoRecommend()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
