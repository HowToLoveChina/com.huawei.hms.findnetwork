package com.huawei.android.remotecontrol.p093ui;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes4.dex */
public class RequestPermissionsActivity extends RequestPermissionsActivityBase {

    /* renamed from: c */
    public static final String[] f20518c = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: j */
    public static boolean m27222j(Context context) {
        return RequestPermissionsActivityBase.m27227c(context, f20518c);
    }

    /* renamed from: k */
    public static boolean m27223k(Activity activity) {
        return RequestPermissionsActivityBase.m27228h(activity, f20518c, RequestPermissionsActivity.class);
    }

    /* renamed from: l */
    public static boolean m27224l(Activity activity) {
        return RequestPermissionsActivityBase.m27229i(activity, f20518c, RequestPermissionsActivity.class);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.RequestPermissionsActivityBase
    /* renamed from: a */
    public String[] mo27225a() {
        return f20518c;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.RequestPermissionsActivityBase
    /* renamed from: b */
    public String[] mo27226b() {
        return f20518c;
    }
}
