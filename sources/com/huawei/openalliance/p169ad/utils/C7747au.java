package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.utils.au */
/* loaded from: classes2.dex */
public class C7747au {

    /* renamed from: a */
    private C7560ou f35846a;

    /* renamed from: b */
    private ContentRecord f35847b;

    public C7747au(Context context, ContentRecord contentRecord) {
        this.f35847b = contentRecord;
        this.f35846a = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()), contentRecord);
    }

    /* renamed from: a */
    private void m47609a(String str, String str2, boolean z10) {
        AbstractC7185ho.m43820b("ILandingJs", "call event report from js");
        if (!m47610a(this.f35847b)) {
            AbstractC7185ho.m43823c("ILandingJs", "has no permission to report event");
        } else if (TextUtils.isEmpty(str2)) {
            AbstractC7185ho.m43823c("ILandingJs", "additionalinfo is null");
        } else {
            this.f35846a.m46602a(str, str2, z10);
        }
    }

    @JavascriptInterface
    public void eventReport(String str, String str2) {
        m47609a(str, str2, false);
    }

    /* renamed from: a */
    private boolean m47610a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return false;
        }
        return "2".equals(contentRecord.m41483ae()) || "1".equals(contentRecord.m41483ae());
    }

    @JavascriptInterface
    public void eventReport(String str, String str2, boolean z10) {
        m47609a(str, str2, z10);
    }
}
