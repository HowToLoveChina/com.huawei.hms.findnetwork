package com.huawei.hicloud.bean;

import com.google.gson.Gson;
import java.util.Map;

/* loaded from: classes6.dex */
public class Client {
    private App app;
    private Device device;
    private Map<String, String> userProperties;

    public App getApp() {
        return this.app;
    }

    public Device getDevice() {
        return this.device;
    }

    public Map<String, String> getUserProperties() {
        return this.userProperties;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setUserProperties(Map<String, String> map) {
        this.userProperties = map;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
