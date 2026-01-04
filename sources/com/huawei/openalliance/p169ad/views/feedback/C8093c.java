package com.huawei.openalliance.p169ad.views.feedback;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.AdFeedbackListener;

/* renamed from: com.huawei.openalliance.ad.views.feedback.c */
/* loaded from: classes2.dex */
public class C8093c {

    /* renamed from: a */
    private View f37650a;

    /* renamed from: b */
    private AdFeedbackListener f37651b;

    /* renamed from: c */
    private AdFeedbackListener f37652c;

    /* renamed from: d */
    private Context f37653d = null;

    /* renamed from: a */
    public View m50143a() {
        return this.f37650a;
    }

    /* renamed from: b */
    public AdFeedbackListener m50147b() {
        return this.f37651b;
    }

    /* renamed from: c */
    public AdFeedbackListener m50149c() {
        return this.f37652c;
    }

    /* renamed from: d */
    public Context m50150d() {
        return this.f37653d;
    }

    /* renamed from: a */
    public void m50144a(Context context) {
        this.f37653d = context;
    }

    /* renamed from: b */
    public void m50148b(AdFeedbackListener adFeedbackListener) {
        this.f37652c = adFeedbackListener;
    }

    /* renamed from: a */
    public void m50145a(View view) {
        this.f37650a = view;
    }

    /* renamed from: a */
    public void m50146a(AdFeedbackListener adFeedbackListener) {
        this.f37651b = adFeedbackListener;
    }
}
