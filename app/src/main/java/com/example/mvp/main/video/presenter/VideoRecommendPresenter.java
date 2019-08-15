package com.example.mvp.main.video.presenter;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.dto.videoDto.response.VideoRecommendResponse;
import com.example.mvp.model.VideoRecommendModel;

public class VideoRecommendPresenter extends BasePresenter {
    private VideoRecommendModel videoRecommendModel;
    private VideoRecommendCallback videoRecommendCallback;

    public VideoRecommendPresenter(VideoRecommendCallback callback) {
        videoRecommendModel = new VideoRecommendModel();
        this.videoRecommendCallback = callback;
    }

    public interface VideoRecommendCallback {
        void onVideoRecommendSuccess(VideoRecommendResponse dto);

        void onVideoRecommendFail(String errorMsg);
    }

    public void getVideoRecommend() {
        disposable.add(videoRecommendModel.getVideoRecommend().subscribe(
                videoRecommendCallback::onVideoRecommendSuccess
                , throwable -> videoRecommendCallback.onVideoRecommendFail(throwable.getMessage())));
    }
}
