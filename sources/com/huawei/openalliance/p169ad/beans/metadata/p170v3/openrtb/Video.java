package com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class Video implements Serializable {
    private static final long serialVersionUID = -6156262595056906295L;
    private int checkSHA256Flag;
    private long duration;
    private String format;

    @InterfaceC6932d(m39225a = "H")
    private int height;
    private String localPath;
    private String sha256;
    private long size;
    private int type;
    private String url;

    @InterfaceC6932d(m39225a = "W")
    private int width;

    /* renamed from: a */
    public String m40595a() {
        return this.url;
    }

    /* renamed from: b */
    public int m40599b() {
        return this.width;
    }

    /* renamed from: c */
    public int m40603c() {
        return this.height;
    }

    /* renamed from: d */
    public long m40606d() {
        return this.duration;
    }

    /* renamed from: e */
    public long m40609e() {
        return this.size;
    }

    /* renamed from: f */
    public String m40610f() {
        return this.sha256;
    }

    /* renamed from: g */
    public String m40611g() {
        return this.format;
    }

    /* renamed from: h */
    public int m40612h() {
        return this.checkSHA256Flag;
    }

    /* renamed from: i */
    public String m40613i() {
        return this.localPath;
    }

    /* renamed from: j */
    public int m40614j() {
        return this.type;
    }

    /* renamed from: a */
    public void m40596a(int i10) {
        this.width = i10;
    }

    /* renamed from: b */
    public void m40600b(int i10) {
        this.height = i10;
    }

    /* renamed from: c */
    public void m40604c(int i10) {
        this.checkSHA256Flag = i10;
    }

    /* renamed from: d */
    public void m40607d(int i10) {
        this.type = i10;
    }

    /* renamed from: a */
    public void m40597a(long j10) {
        this.duration = j10;
    }

    /* renamed from: b */
    public void m40601b(long j10) {
        this.size = j10;
    }

    /* renamed from: c */
    public void m40605c(String str) {
        this.format = str;
    }

    /* renamed from: d */
    public void m40608d(String str) {
        this.localPath = str;
    }

    /* renamed from: a */
    public void m40598a(String str) {
        this.url = str;
    }

    /* renamed from: b */
    public void m40602b(String str) {
        this.sha256 = str;
    }
}
