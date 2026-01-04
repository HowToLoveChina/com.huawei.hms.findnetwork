package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;

/* renamed from: com.huawei.openalliance.ad.rt */
/* loaded from: classes8.dex */
public abstract class AbstractC7644rt {

    /* renamed from: e */
    private static final String[] f35593e = {"com.huawei.openalliance.ad.views.reward", "com.huawei.openalliance.ad.activity", "com.huawei.openalliance.ad.utils", "com.huawei.openalliance.ad.views", "com.huawei.openalliance.ad.views.dsa", "java.lang.reflect", "com.android.internal.os", "android.app", "android.os", "android.view", "com.android.internal.policy", "dalvik.system", "java.lang", "com.huawei.hms.ads.uiengine.views.template", "com.huawei.hms.ads", "com.android.tools.profiler.support.event", "huawei.android.widget", "android.widget", "androidx.recyclerview.widget", "android.app.servertransaction", "com.huawei.hms.ads.uiengine.remote"};

    /* renamed from: a */
    protected Context f35594a;

    /* renamed from: b */
    protected ContentRecord f35595b;

    /* renamed from: c */
    protected C6971bo f35596c;

    /* renamed from: d */
    protected AbstractC7644rt f35597d;

    public AbstractC7644rt() {
    }

    public AbstractC7644rt(Context context, ContentRecord contentRecord) {
        this.f35594a = context;
        this.f35595b = contentRecord;
        this.f35596c = new C6971bo(context);
    }

    /* renamed from: a */
    public void m47116a(AbstractC7644rt abstractC7644rt) {
        this.f35597d = abstractC7644rt;
    }

    /* renamed from: a */
    public abstract boolean mo47112a();

    /* renamed from: a */
    public static boolean m47114a(View view) {
        if (view != null) {
            return !(view.getContext() instanceof Activity) || AbstractC7811dd.m48316c((Activity) view.getContext());
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m47115a(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null || TextUtils.isEmpty(stackTraceElement.toString()) || TextUtils.isEmpty(stackTraceElement.getClassName())) {
            return true;
        }
        String strM48179h = AbstractC7806cz.m48179h(stackTraceElement.getFileName(), stackTraceElement.getClassName());
        if (TextUtils.isEmpty(strM48179h)) {
            return false;
        }
        int i10 = 0;
        while (true) {
            String[] strArr = f35593e;
            if (i10 >= strArr.length) {
                return false;
            }
            if (strM48179h.equals(strArr[i10])) {
                return true;
            }
            i10++;
        }
    }
}
