package com.huawei.openalliance.p169ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.b */
/* loaded from: classes2.dex */
public class C7753b {
    /* renamed from: a */
    public static String m47699a(Context context) {
        Activity activityM47701b = m47701b(context);
        if (activityM47701b != null) {
            AbstractC7185ho.m43818a("ActivityUtils", "ana_tag  getActivityLocalClassName LocalClassName = %s", activityM47701b.getLocalClassName());
            return activityM47701b.getLocalClassName();
        }
        AbstractC7185ho.m43826d("ActivityUtils", "ana_tag  getActivityLocalClassName LocalClassName is null");
        return "";
    }

    /* renamed from: b */
    private static Activity m47701b(Context context) {
        if (context == null) {
            AbstractC7185ho.m43826d("ActivityUtils", "ana_tag getActivity context is null, return");
            return null;
        }
        int i10 = 0;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            i10++;
            if (i10 > 5) {
                AbstractC7185ho.m43826d("ActivityUtils", "ana_tag getActivity loop too much times, return");
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    /* renamed from: a */
    public static String m47700a(Object obj) {
        String str;
        if (obj == null) {
            str = "ana_tag getActivityName obj is null, return";
        } else {
            if (obj instanceof View) {
                return m47699a(((View) obj).getContext());
            }
            str = "ana_tag  getActivityName activityname is not view";
        }
        AbstractC7185ho.m43826d("ActivityUtils", str);
        return null;
    }
}
