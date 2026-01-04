package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.p169ad.constant.NotifyMessageNames;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: com.huawei.openalliance.ad.hg */
/* loaded from: classes8.dex */
public class ViewTreeObserverOnGlobalLayoutListenerC7177hg implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final WeakReference<Context> f33077a;

    /* renamed from: b */
    private final WeakReference<View> f33078b;

    /* renamed from: c */
    private final int[] f33079c;

    public ViewTreeObserverOnGlobalLayoutListenerC7177hg(View view, Context context, int[] iArr) {
        this.f33077a = new WeakReference<>(context);
        this.f33078b = new WeakReference<>(view);
        this.f33079c = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
    }

    /* renamed from: a */
    private boolean m43799a(int[] iArr, int[] iArr2) {
        int iMax = Math.max(AbstractC7741ao.m47583h(this.f33077a.get()), AbstractC7811dd.m48329g(this.f33077a.get()));
        return Math.abs(iArr[0] - iArr2[0]) <= iMax && Math.abs(iArr[1] - iArr2[1]) <= iMax;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        try {
            View view = this.f33078b.get();
            Context context = this.f33077a.get();
            if (view != null && context != null && this.f33079c != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i10 = iArr[0];
                if (i10 == 0 && iArr[1] == 0) {
                    AbstractC7185ho.m43820b("CustomOnGlobalLayoutListener", "anchorView onGlobalLayout newLoc[x,y] =0,0");
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    return;
                }
                int[] iArr2 = this.f33079c;
                if ((iArr2[0] == i10 && iArr2[1] == iArr[1]) || m43799a(iArr2, iArr)) {
                    return;
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AbstractC7185ho.m43820b("CustomOnGlobalLayoutListener", "anchorView location change newLoc[x,y] = " + iArr[0] + "," + iArr[1] + "--oldLoc[x,y] = " + this.f33079c[0] + "," + this.f33079c[1]);
                C7335ji.m45308a().m45309a(NotifyMessageNames.FEEDBACK_RECEIVE, new Intent("com.huawei.ads.feedback.action.ANCHOR_LOCATION_CHANGE"));
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("CustomOnGlobalLayoutListener", "onGlobalLayout error:" + th2.getClass().getSimpleName());
        }
    }
}
