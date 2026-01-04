package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public class AudioInfo implements Serializable {

    /* renamed from: a */
    private String f33607a;

    /* renamed from: b */
    private int f33608b;

    /* renamed from: c */
    private int f33609c;

    /* renamed from: d */
    private String f33610d;

    /* renamed from: e */
    private String f33611e;

    @OuterVisible
    public AudioInfo() {
    }

    public AudioInfo(com.huawei.openalliance.p169ad.beans.metadata.AudioInfo audioInfo) {
        if (audioInfo != null) {
            this.f33607a = audioInfo.m39861a();
            this.f33608b = audioInfo.m39864b();
            this.f33609c = audioInfo.m39867c();
            this.f33610d = audioInfo.m39869d();
            this.f33611e = audioInfo.m39870e();
        }
    }

    /* renamed from: a */
    public void m44442a(int i10) {
        this.f33608b = i10;
    }

    /* renamed from: b */
    public void m44444b(int i10) {
        this.f33609c = i10;
    }

    /* renamed from: c */
    public void m44446c(String str) {
        this.f33611e = str;
    }

    @OuterVisible
    public int getDuration() {
        return this.f33608b;
    }

    @OuterVisible
    public int getFileSize() {
        return this.f33609c;
    }

    @OuterVisible
    public String getMime() {
        return this.f33611e;
    }

    @OuterVisible
    public String getSha256() {
        return this.f33610d;
    }

    @OuterVisible
    public String getUrl() {
        return this.f33607a;
    }

    /* renamed from: a */
    public void m44443a(String str) {
        this.f33607a = str;
    }

    /* renamed from: b */
    public void m44445b(String str) {
        this.f33610d = str;
    }
}
