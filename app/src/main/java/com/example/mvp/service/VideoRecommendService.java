package com.example.mvp.service;

import com.example.mvp.dto.videoDto.response.VideoRecommendResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface VideoRecommendService {

    @GET("musicBroadcasting")
    Single<VideoRecommendResponse> getVideoRecommend();

}
