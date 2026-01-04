package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.linked.view.LinkedAppDetailView;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.hc */
/* loaded from: classes8.dex */
public class C7173hc {

    /* renamed from: a */
    private LinkedAppDetailView f33019a;

    /* renamed from: b */
    private C7162gs f33020b;

    /* renamed from: a */
    public void m43683a() {
        if (this.f33019a == null || this.f33020b == null || !m43686b()) {
            return;
        }
        this.f33019a.setAdLandingPageData(this.f33020b.m43621c());
        this.f33019a.setContentRecord(this.f33020b.m43619a());
        this.f33019a.setVisibility(0);
    }

    /* renamed from: b */
    public boolean m43686b() {
        ContentRecord contentRecordM43619a;
        C7162gs c7162gs = this.f33020b;
        return (c7162gs == null || (contentRecordM43619a = c7162gs.m43619a()) == null || contentRecordM43619a.m41484af() == null) ? false : true;
    }

    /* renamed from: c */
    public void m43687c() {
        LinkedAppDetailView linkedAppDetailView = this.f33019a;
        if (linkedAppDetailView != null) {
            linkedAppDetailView.setVisibility(8);
        }
    }

    /* renamed from: d */
    public boolean m43688d() {
        LinkedAppDetailView linkedAppDetailView = this.f33019a;
        return linkedAppDetailView != null && linkedAppDetailView.getVisibility() == 0;
    }

    /* renamed from: a */
    public void m43684a(C7162gs c7162gs) {
        this.f33020b = c7162gs;
    }

    /* renamed from: a */
    public void m43685a(LinkedAppDetailView linkedAppDetailView) {
        this.f33019a = linkedAppDetailView;
    }
}
