package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class AdIECFeedbackRecord extends AbstractC10440e {
    private String contentId;
    private int dislike = 0;
    private long updateTime = System.currentTimeMillis();

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
    public void m12480t(int i10) {
        this.dislike = i10;
    }

    /* renamed from: u */
    public void m12481u(long j10) {
        this.updateTime = j10;
    }

    /* renamed from: v */
    public void m12482v(String str) {
        this.contentId = str;
    }
}
