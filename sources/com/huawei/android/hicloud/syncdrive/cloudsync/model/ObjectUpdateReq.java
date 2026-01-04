package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class ObjectUpdateReq extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private String objectId;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private SpeedInfo speed;

    @InterfaceC4648p
    private UploadStatus uploadStatus;

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public SpeedInfo getSpeed() {
        return this.speed;
    }

    public UploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public ObjectUpdateReq setAttributes(Map<String, Object> map) {
        this.attributes = map;
        return this;
    }

    public ObjectUpdateReq setObjectId(String str) {
        this.objectId = str;
        return this;
    }

    public ObjectUpdateReq setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public ObjectUpdateReq setSpeed(SpeedInfo speedInfo) {
        this.speed = speedInfo;
        return this;
    }

    public ObjectUpdateReq setUploadStatus(UploadStatus uploadStatus) {
        this.uploadStatus = uploadStatus;
        return this;
    }
}
