package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class AdTraceRecord extends AbstractC10440e {
    private String adCreativeMaterialUrl;
    private String click;
    private String contentId;
    private String exposure;
    private String reserveStr;
    private Boolean sendToMedia;
    private String tradeMode;
    private String uniqueId;
    private long uptime;

    /* renamed from: A */
    public String m12498A() {
        return this.exposure;
    }

    /* renamed from: B */
    public void m12499B(String str) {
        this.exposure = str;
    }

    /* renamed from: C */
    public void m12500C(String str) {
        this.tradeMode = str;
    }

    /* renamed from: D */
    public String m12501D() {
        return this.uniqueId;
    }

    /* renamed from: E */
    public void m12502E(String str) {
        this.uniqueId = str;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 2592000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "uptime<?";
    }

    /* renamed from: t */
    public void m12503t(long j10) {
        this.uptime = j10;
    }

    /* renamed from: u */
    public void m12504u(String str) {
        this.adCreativeMaterialUrl = str;
    }

    /* renamed from: v */
    public void m12505v(boolean z10) {
        this.sendToMedia = Boolean.valueOf(z10);
    }

    /* renamed from: w */
    public String m12506w() {
        return this.click;
    }

    /* renamed from: x */
    public void m12507x(String str) {
        this.click = str;
    }

    /* renamed from: y */
    public String m12508y() {
        return this.contentId;
    }

    /* renamed from: z */
    public void m12509z(String str) {
        this.contentId = str;
    }
}
