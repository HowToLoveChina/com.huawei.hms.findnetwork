package com.huawei.hwcloudjs.service.auth.bean;

import com.huawei.hwcloudjs.support.enables.NoProguard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoProguard
/* loaded from: classes8.dex */
public class AuthBean implements Serializable {
    private static final long serialVersionUID = 6321099514219022763L;
    private String appId;
    private long timestamp;
    private List<String> urlList = new ArrayList();
    private List<String> permissionList = new ArrayList();

    public String getAppId() {
        return this.appId;
    }

    public List<String> getPermissionList() {
        return this.permissionList;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setPermissionList(List<String> list) {
        this.permissionList = list;
    }

    public void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public void setUrlList(List<String> list) {
        this.urlList = list;
    }
}
