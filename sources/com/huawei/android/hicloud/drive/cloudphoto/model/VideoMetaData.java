package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class VideoMetaData extends C11707b {

    @InterfaceC4648p
    private Integer durationTime;

    @InterfaceC4648p
    private Integer height;

    @InterfaceC4648p
    private String position;

    @InterfaceC4648p
    private Integer rotation;

    @InterfaceC4648p
    private Integer width;

    public Integer getDurationTime() {
        Integer num = this.durationTime;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public Integer getHeight() {
        return this.height;
    }

    public String getPosition() {
        return this.position;
    }

    public Integer getRotation() {
        return this.rotation;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setDurationTime(Integer num) {
        this.durationTime = num;
    }

    public void setHeight(Integer num) {
        this.height = num;
    }

    public VideoMetaData setPosition(String str) {
        this.position = str;
        return this;
    }

    public VideoMetaData setRotation(Integer num) {
        this.rotation = num;
        return this;
    }

    public void setWidth(Integer num) {
        this.width = num;
    }
}
