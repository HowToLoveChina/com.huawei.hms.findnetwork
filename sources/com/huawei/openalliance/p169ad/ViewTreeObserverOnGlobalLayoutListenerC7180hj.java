package com.huawei.openalliance.p169ad;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.p169ad.views.linkscroll.LinkScrollView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.hj */
/* loaded from: classes8.dex */
public class ViewTreeObserverOnGlobalLayoutListenerC7180hj implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final WeakReference<LinkScrollView> f33083a;

    /* renamed from: b */
    private final WeakReference<View> f33084b;

    /* renamed from: c */
    private int f33085c = 0;

    public ViewTreeObserverOnGlobalLayoutListenerC7180hj(LinkScrollView linkScrollView, View view) {
        this.f33083a = new WeakReference<>(linkScrollView);
        this.f33084b = new WeakReference<>(view);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        try {
            View view = this.f33084b.get();
            LinkScrollView linkScrollView = this.f33083a.get();
            if (view != null && linkScrollView != null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int height = view.getHeight();
                int i10 = height - rect.bottom;
                AbstractC7185ho.m43818a("InputOnGlobalLayoutList", "keyboard height is %s, view height is %s.", Integer.valueOf(i10), Integer.valueOf(height));
                if (i10 > height * 0.25f) {
                    linkScrollView.m50345a(i10 - this.f33085c, true);
                    return;
                }
                linkScrollView.m50345a(i10, false);
                if (i10 != 0) {
                    this.f33085c = i10;
                    return;
                }
                return;
            }
            AbstractC7185ho.m43823c("InputOnGlobalLayoutList", "view is null.");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("InputOnGlobalLayoutList", "listen input err: %s", th2.getClass().getSimpleName());
        }
    }
}
