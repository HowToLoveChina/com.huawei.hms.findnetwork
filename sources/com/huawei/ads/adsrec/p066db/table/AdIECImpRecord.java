package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class AdIECImpRecord extends AbstractC10440e {
    private String contentId;
    private long lastRecallTime;
    private long lastShowTime;
    private String pkgName;
    private int showCount;
    private long updateTime = System.currentTimeMillis();

    /* renamed from: A */
    public int m12483A() {
        return this.showCount;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 1296000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "updateTime<?";
    }

    /* renamed from: t */
    public String m12484t() {
        return this.contentId;
    }

    /* renamed from: u */
    public void m12485u(int i10) {
        this.showCount = i10;
    }

    /* renamed from: v */
    public void m12486v(long j10) {
        this.lastShowTime = j10;
    }

    /* renamed from: w */
    public void m12487w(String str) {
        this.contentId = str;
    }

    /* renamed from: x */
    public long m12488x() {
        return this.lastRecallTime;
    }

    /* renamed from: y */
    public void m12489y(long j10) {
        this.updateTime = j10;
    }

    /* renamed from: z */
    public void m12490z(String str) {
        this.pkgName = str;
    }
}
