package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class AudioInfo {
    private int duration;
    private int fileSize;
    private String mime;
    private String sha256;
    private String url;

    /* renamed from: a */
    public String m39861a() {
        return this.url;
    }

    /* renamed from: b */
    public int m39864b() {
        return this.duration;
    }

    /* renamed from: c */
    public int m39867c() {
        return this.fileSize;
    }

    /* renamed from: d */
    public String m39869d() {
        return this.sha256;
    }

    /* renamed from: e */
    public String m39870e() {
        return this.mime;
    }

    /* renamed from: a */
    public void m39862a(int i10) {
        this.duration = i10;
    }

    /* renamed from: b */
    public void m39865b(int i10) {
        this.fileSize = i10;
    }

    /* renamed from: c */
    public void m39868c(String str) {
        this.mime = str;
    }

    /* renamed from: a */
    public void m39863a(String str) {
        this.url = str;
    }

    /* renamed from: b */
    public void m39866b(String str) {
        this.sha256 = str;
    }
}
