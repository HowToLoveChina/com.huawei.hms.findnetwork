package com.huawei.hms.videokit.player.bean;

/* loaded from: classes8.dex */
public class Proxy {

    /* renamed from: a */
    private Type f30315a = Type.UNKNOWN;

    /* renamed from: b */
    private String f30316b;

    /* renamed from: c */
    private String f30317c;

    /* renamed from: d */
    private String f30318d;

    /* renamed from: e */
    private String f30319e;

    public enum Type {
        UNKNOWN,
        HTTP,
        SOCKS
    }

    public String getHost() {
        return this.f30316b;
    }

    public String getPasswd() {
        return this.f30319e;
    }

    public String getPort() {
        return this.f30317c;
    }

    public Type getType() {
        return this.f30315a;
    }

    public String getUser() {
        return this.f30318d;
    }

    public void setHost(String str) {
        this.f30316b = str;
    }

    public void setPasswd(String str) {
        this.f30319e = str;
    }

    public void setPort(String str) {
        this.f30317c = str;
    }

    public void setType(Type type) {
        this.f30315a = type;
    }

    public void setUser(String str) {
        this.f30318d = str;
    }

    public String toString() {
        return "ProxyInfo{type=" + this.f30315a + ", host=" + this.f30316b + ", port=" + this.f30317c + ", user=" + this.f30318d + "}";
    }
}
