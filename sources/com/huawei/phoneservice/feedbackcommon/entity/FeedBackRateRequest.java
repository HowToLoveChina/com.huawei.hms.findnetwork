package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class FeedBackRateRequest {

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("problemId")
    private String problemId;

    @SerializedName("score")
    private String score;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getProblemId() {
        return this.problemId;
    }

    public String getScore() {
        return this.score;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setProblemId(String str) {
        this.problemId = str;
    }

    public void setScore(String str) {
        this.score = str;
    }
}
