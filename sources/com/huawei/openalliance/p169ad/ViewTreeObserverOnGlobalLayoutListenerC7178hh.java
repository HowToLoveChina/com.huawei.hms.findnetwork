package com.huawei.openalliance.p169ad;

import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.p169ad.activity.ActivityC6901a;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.hh */
/* loaded from: classes8.dex */
public class ViewTreeObserverOnGlobalLayoutListenerC7178hh implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private WeakReference<ActivityC6901a> f33080a;

    /* renamed from: b */
    private WeakReference<View> f33081b;

    /* renamed from: c */
    private int[] f33082c;

    public ViewTreeObserverOnGlobalLayoutListenerC7178hh(ActivityC6901a activityC6901a, View view, int[] iArr) {
        this.f33080a = new WeakReference<>(activityC6901a);
        this.f33081b = new WeakReference<>(view);
        this.f33082c = iArr;
    }

    /* renamed from: a */
    private boolean m43800a(int[] iArr, int[] iArr2) {
        int iMax = Math.max(AbstractC7741ao.m47583h(this.f33080a.get()), AbstractC7811dd.m48329g(this.f33080a.get()));
        return Math.abs(iArr[0] - iArr2[0]) <= iMax && Math.abs(iArr[1] - iArr2[1]) <= iMax;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        try {
            View view = this.f33081b.get();
            ActivityC6901a activityC6901a = this.f33080a.get();
            if (view != null && activityC6901a != null && this.f33082c != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i10 = iArr[0];
                if (i10 == 0 && iArr[1] == 0) {
                    AbstractC7185ho.m43820b("DialogOnGlobalLayoutListener", "anchorView onGlobalLayout newLoc[x,y] =0,0");
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    return;
                }
                int[] iArr2 = this.f33082c;
                if (iArr2[0] == i10 && iArr2[1] == iArr[1]) {
                    return;
                }
                if (m43800a(iArr2, iArr)) {
                    AbstractC7185ho.m43820b("DialogOnGlobalLayoutListener", "the anchorView's sliding distance is acceptable");
                    return;
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AbstractC7185ho.m43820b("DialogOnGlobalLayoutListener", "anchorView location change newLoc[x,y] = " + iArr[0] + "," + iArr[1] + "--oldLoc[x,y] = " + this.f33082c[0] + "," + this.f33082c[1]);
                activityC6901a.finish();
                return;
            }
            AbstractC7185ho.m43820b("DialogOnGlobalLayoutListener", "anchorView or activity or location is null.");
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("DialogOnGlobalLayoutListener", "onGlobalLayout error:" + th2.getClass().getSimpleName());
        }
    }
}
