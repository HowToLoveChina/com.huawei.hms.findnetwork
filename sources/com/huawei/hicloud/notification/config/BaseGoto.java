package com.huawei.hicloud.notification.config;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class BaseGoto implements Serializable {
    private static final long serialVersionUID = -3100202662920575739L;
    private String type;
    private String uri;

    public String getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
