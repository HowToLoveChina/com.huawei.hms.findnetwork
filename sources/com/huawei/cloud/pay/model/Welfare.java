package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class Welfare implements Serializable {
    private static final long serialVersionUID = -3127079682009182630L;
    private String content;
    private String desc;
    private long expireTime;

    /* renamed from: id */
    private String f21419id;
    private String name;
    private long pickTime;
    private int state;
    private int type;
    private long useTime;
    private String useUrl;

    public String getContent() {
        return this.content;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getId() {
        return this.f21419id;
    }

    public String getName() {
        return this.name;
    }

    public long getPickTime() {
        return this.pickTime;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public long getUseTime() {
        return this.useTime;
    }

    public String getUseUrl() {
        return this.useUrl;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExpireTime(long j10) {
        this.expireTime = j10;
    }

    public void setId(String str) {
        this.f21419id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPickTime(long j10) {
        this.pickTime = j10;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setUseTime(long j10) {
        this.useTime = j10;
    }

    public void setUseUrl(String str) {
        this.useUrl = str;
    }
}
