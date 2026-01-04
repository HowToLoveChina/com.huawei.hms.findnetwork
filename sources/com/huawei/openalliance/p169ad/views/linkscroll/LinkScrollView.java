package com.huawei.openalliance.p169ad.views.linkscroll;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.ViewTreeObserverOnGlobalLayoutListenerC7180hj;
import com.huawei.openalliance.p169ad.activity.PPSActivity;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.linkscroll.C8142e;

/* loaded from: classes2.dex */
public class LinkScrollView extends LinearLayout implements InterfaceC8139b {

    /* renamed from: a */
    private View f37933a;

    /* renamed from: b */
    private View f37934b;

    /* renamed from: c */
    private int f37935c;

    /* renamed from: d */
    private OverScroller f37936d;

    /* renamed from: e */
    private int f37937e;

    /* renamed from: f */
    private int f37938f;

    /* renamed from: g */
    private Scroller f37939g;

    /* renamed from: h */
    private View f37940h;

    /* renamed from: i */
    private int f37941i;

    /* renamed from: j */
    private final boolean f37942j;

    /* renamed from: k */
    private int f37943k;

    /* renamed from: l */
    private int f37944l;

    /* renamed from: m */
    private boolean f37945m;

    /* renamed from: n */
    private ViewTreeObserverOnGlobalLayoutListenerC7180hj f37946n;

    /* renamed from: o */
    private View f37947o;

    /* renamed from: p */
    private C8142e.a f37948p;

    public LinkScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37941i = 0;
        this.f37948p = new C8142e.a() { // from class: com.huawei.openalliance.ad.views.linkscroll.LinkScrollView.1
            @Override // com.huawei.openalliance.p169ad.views.linkscroll.C8142e.a
            /* renamed from: a */
            public void mo50352a(View view) {
                if (view != null && LinkScrollView.this.m50340b()) {
                    if (LinkScrollView.this.f37941i != -1) {
                        AbstractC7185ho.m43817a("LinkScrollView", "fling orientation invalid, parent can not fling.");
                        return;
                    }
                    if (LinkScrollView.this.f37935c == LinkScrollView.this.getScrollY() && LinkScrollView.this.f37939g.computeScrollOffset()) {
                        float currVelocity = LinkScrollView.this.f37939g.getCurrVelocity();
                        if (currVelocity >= 0.0f) {
                            currVelocity = -currVelocity;
                        }
                        LinkScrollView.this.f37939g.abortAnimation();
                        LinkScrollView.this.m50332a(currVelocity);
                    }
                }
            }
        };
        setOrientation(1);
        this.f37936d = new OverScroller(context);
        this.f37939g = new Scroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f37937e = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f37938f = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f37942j = C6982bz.m41152b(context);
        m50333a(context);
    }

    /* renamed from: a */
    public void m50344a() {
        try {
            View view = this.f37947o;
            if (view == null || this.f37946n == null) {
                return;
            }
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f37946n);
            this.f37946n = null;
            this.f37947o = null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LinkScrollView", "remove listen err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f37936d.computeScrollOffset()) {
            int currY = this.f37936d.getCurrY();
            if (currY < 0) {
                currY = 0;
            }
            int i10 = this.f37935c;
            if (currY > i10) {
                currY = i10;
            }
            scrollTo(0, currY);
            int scrollY = getScrollY();
            if (m50340b() && scrollY == this.f37935c) {
                int currVelocity = (int) this.f37936d.getCurrVelocity();
                AbstractC7185ho.m43820b("LinkScrollView", "webView fling");
                this.f37936d.abortAnimation();
                View view = this.f37940h;
                if (view instanceof C8142e) {
                    ((C8142e) view).m50377a(currVelocity);
                }
                m50339b(currVelocity);
            }
            invalidate();
        }
    }

    public int getLinkScrollAxes() {
        return 0;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f37933a = findViewById(C6849R.id.linked_native_view);
        this.f37934b = findViewById(C6849R.id.linked_pps_web_view);
        this.f37933a.setOverScrollMode(2);
        this.f37934b.setOverScrollMode(2);
        setOverScrollMode(2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f37933a.measure(i10, View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams layoutParams = this.f37934b.getLayoutParams();
        int measuredHeight = getMeasuredHeight();
        layoutParams.height = measuredHeight;
        if (!this.f37942j) {
            int i12 = measuredHeight - this.f37943k;
            layoutParams.height = i12;
            if (this.f37945m) {
                layoutParams.height = i12 - this.f37944l;
            }
        }
        this.f37934b.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f37935c = this.f37933a.getMeasuredHeight();
    }

    public void setBarHeight(int i10) {
        this.f37943k = i10;
    }

    public void setWebView(View view) {
        this.f37940h = view;
        if (view instanceof C8142e) {
            ((C8142e) view).setScrollListener(this.f37948p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50332a(float f10) {
        if (Math.abs(f10) > this.f37938f) {
            this.f37941i = f10 > 0.0f ? 1 : -1;
            this.f37936d.fling(0, getScrollY(), 1, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            invalidate();
        }
    }

    /* renamed from: b */
    private void m50339b(float f10) {
        this.f37939g.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        invalidate();
    }

    /* renamed from: c */
    private void m50342c() {
        this.f37941i = 0;
        this.f37939g.abortAnimation();
        this.f37936d.abortAnimation();
    }

    /* renamed from: a */
    public void m50345a(int i10, boolean z10) {
        this.f37944l = i10;
        this.f37945m = z10;
        measure(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // com.huawei.openalliance.p169ad.views.linkscroll.InterfaceC8139b
    /* renamed from: b */
    public void mo50351b(View view, View view2, int i10) {
        m50342c();
    }

    /* renamed from: a */
    private void m50333a(Context context) {
        try {
            if (this.f37942j) {
                AbstractC7185ho.m43820b("LinkScrollView", "inner device, no need to listen input.");
                return;
            }
            Activity activityM48350z = AbstractC7811dd.m48350z(context);
            if (!(activityM48350z instanceof PPSActivity)) {
                AbstractC7185ho.m43823c("LinkScrollView", "activity is invalid.");
                return;
            }
            View decorView = activityM48350z.getWindow().getDecorView();
            this.f37947o = decorView;
            this.f37946n = new ViewTreeObserverOnGlobalLayoutListenerC7180hj(this, decorView);
            this.f37947o.getViewTreeObserver().addOnGlobalLayoutListener(this.f37946n);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LinkScrollView", "listen input err: %s", th2.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m50340b() {
        int measuredHeight = this.f37933a.getMeasuredHeight();
        this.f37935c = measuredHeight;
        return measuredHeight > 0;
    }

    @Override // com.huawei.openalliance.p169ad.views.linkscroll.InterfaceC8139b
    /* renamed from: a */
    public void mo50346a(View view) {
    }

    @Override // com.huawei.openalliance.p169ad.views.linkscroll.InterfaceC8139b
    /* renamed from: a */
    public void mo50347a(View view, int i10, int i11, int i12, int i13) {
    }

    @Override // com.huawei.openalliance.p169ad.views.linkscroll.InterfaceC8139b
    /* renamed from: a */
    public void mo50348a(View view, int i10, int i11, int[] iArr) {
        if (m50340b()) {
            if (m50335a(i11) || m50336a(view, i11)) {
                if (i11 < 0) {
                    int scrollY = getScrollY();
                    if (i11 + scrollY < 0) {
                        i11 = -scrollY;
                    }
                }
                scrollBy(0, i11);
                iArr[1] = i11;
            }
        }
    }

    /* renamed from: a */
    private boolean m50335a(int i10) {
        int measuredHeight = this.f37933a.getMeasuredHeight();
        this.f37935c = measuredHeight;
        return measuredHeight > 0 && i10 > 0 && getScrollY() < this.f37935c;
    }

    @Override // com.huawei.openalliance.p169ad.views.linkscroll.InterfaceC8139b
    /* renamed from: a */
    public boolean mo50349a(View view, float f10, float f11) {
        int scrollY = getScrollY();
        this.f37941i = f11 > 0.0f ? 1 : -1;
        if (scrollY == this.f37935c) {
            m50339b(f11);
            return false;
        }
        m50332a(f11);
        return true;
    }

    /* renamed from: a */
    private boolean m50336a(View view, int i10) {
        if (i10 >= 0 || getScrollY() < 0) {
            return false;
        }
        return !view.canScrollVertically(-1);
    }

    @Override // com.huawei.openalliance.p169ad.views.linkscroll.InterfaceC8139b
    /* renamed from: a */
    public boolean mo50350a(View view, View view2, int i10) {
        return true;
    }
}
