package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class MotionData implements Serializable {
    private static final long serialVersionUID = 5993334213402798519L;
    private long dataId;
    private int duration;
    private String filePath;
    private String format;
    private int height;
    private String sha256;
    private int size;
    private String url;
    private int width;

    /* renamed from: a */
    public long m40524a() {
        return this.dataId;
    }

    /* renamed from: b */
    public int m40528b() {
        return this.width;
    }

    /* renamed from: c */
    public int m40531c() {
        return this.height;
    }

    /* renamed from: d */
    public String m40534d() {
        return this.format;
    }

    /* renamed from: e */
    public int m40537e() {
        return this.size;
    }

    /* renamed from: f */
    public int m40538f() {
        return this.duration;
    }

    /* renamed from: g */
    public String m40539g() {
        return this.url;
    }

    /* renamed from: h */
    public String m40540h() {
        return this.sha256;
    }

    /* renamed from: i */
    public String m40541i() {
        return this.filePath;
    }

    /* renamed from: a */
    public void m40525a(int i10) {
        this.width = i10;
    }

    /* renamed from: b */
    public void m40529b(int i10) {
        this.height = i10;
    }

    /* renamed from: c */
    public void m40532c(int i10) {
        this.size = i10;
    }

    /* renamed from: d */
    public void m40535d(int i10) {
        this.duration = i10;
    }

    /* renamed from: a */
    public void m40526a(long j10) {
        this.dataId = j10;
    }

    /* renamed from: b */
    public void m40530b(String str) {
        this.url = str;
    }

    /* renamed from: c */
    public void m40533c(String str) {
        this.sha256 = str;
    }

    /* renamed from: d */
    public void m40536d(String str) {
        this.filePath = str;
    }

    /* renamed from: a */
    public void m40527a(String str) {
        this.format = str;
    }
}
