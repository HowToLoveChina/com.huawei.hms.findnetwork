package com.huawei.openalliance.p169ad;

import android.view.View;
import android.view.ViewParent;
import com.huawei.openalliance.p169ad.views.C8074ai;
import com.huawei.openalliance.p169ad.views.PPSInterstitialView;
import com.huawei.openalliance.p169ad.views.PPSRewardView;
import com.huawei.openalliance.p169ad.views.PPSSplashView;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.to */
/* loaded from: classes8.dex */
public abstract class AbstractC7693to {

    /* renamed from: a */
    private static Set<Class<?>> f35716a;

    static {
        HashSet hashSet = new HashSet();
        f35716a = hashSet;
        hashSet.add(PPSInterstitialView.class);
        f35716a.add(PPSRewardView.class);
        f35716a.add(C8074ai.class);
        f35716a.add(PPSSplashView.class);
    }

    /* renamed from: a */
    public static boolean m47280a(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        for (int i10 = 0; i10 < 5 && parent != null; i10++) {
            if (m47281a(parent)) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m47281a(ViewParent viewParent) {
        for (Class<?> cls : f35716a) {
            if (cls != null && cls.isInstance(viewParent)) {
                AbstractC7185ho.m43818a("BaseTrackerUtil", "parent instanceof %s", cls.getSimpleName());
                return true;
            }
        }
        return false;
    }
}
