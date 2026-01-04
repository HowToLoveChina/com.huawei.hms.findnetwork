package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class AdEventRecord extends AbstractC10440e {
    private String clientRequestId;
    private String contentId;
    private long eventTime = System.currentTimeMillis();
    private String eventType;
    private int maxShowRatio;
    private String pkgName;
    private long showDuration;
    private String showId;
    private String slotId;

    /* renamed from: A */
    public long m12463A() {
        return this.eventTime;
    }

    /* renamed from: B */
    public void m12464B(String str) {
        this.eventType = str;
    }

    /* renamed from: C */
    public String m12465C() {
        return this.eventType;
    }

    /* renamed from: D */
    public void m12466D(String str) {
        this.pkgName = str;
    }

    /* renamed from: E */
    public String m12467E() {
        return this.pkgName;
    }

    /* renamed from: F */
    public void m12468F(String str) {
        this.showId = str;
    }

    /* renamed from: G */
    public long m12469G() {
        return this.showDuration;
    }

    /* renamed from: H */
    public void m12470H(String str) {
        this.slotId = str;
    }

    /* renamed from: J */
    public String m12471J() {
        return this.showId;
    }

    /* renamed from: K */
    public String m12472K() {
        return this.slotId;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 7776000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "eventTime<?";
    }

    /* renamed from: t */
    public String m12473t() {
        return this.clientRequestId;
    }

    public String toString() {
        return "AdEventRecord{pkgName='" + this.pkgName + "', slotId='" + this.slotId + "', contentId='" + this.contentId + "', showId='" + this.showId + "', showDuration=" + this.showDuration + ", maxShowRatio=" + this.maxShowRatio + ", eventType='" + this.eventType + "', eventTime=" + this.eventTime + ", clientRequestId=" + this.clientRequestId + '}';
    }

    /* renamed from: u */
    public void m12474u(int i10) {
        this.maxShowRatio = i10;
    }

    /* renamed from: v */
    public void m12475v(long j10) {
        this.eventTime = j10;
    }

    /* renamed from: w */
    public void m12476w(String str) {
        this.clientRequestId = str;
    }

    /* renamed from: x */
    public String m12477x() {
        return this.contentId;
    }

    /* renamed from: y */
    public void m12478y(long j10) {
        this.showDuration = j10;
    }

    /* renamed from: z */
    public void m12479z(String str) {
        this.contentId = str;
    }
}
