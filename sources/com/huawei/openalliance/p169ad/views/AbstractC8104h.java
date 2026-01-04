package com.huawei.openalliance.p169ad.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterfaceC7181hk;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.feedback.InterfaceC8092b;
import java.util.Arrays;

/* renamed from: com.huawei.openalliance.ad.views.h */
/* loaded from: classes2.dex */
public abstract class AbstractC8104h extends LinearLayout {

    /* renamed from: a */
    protected View f37754a;

    /* renamed from: b */
    protected View f37755b;

    /* renamed from: c */
    protected View f37756c;

    /* renamed from: d */
    protected float f37757d;

    /* renamed from: e */
    protected int f37758e;

    /* renamed from: f */
    protected int f37759f;

    /* renamed from: g */
    protected int f37760g;

    /* renamed from: h */
    protected int f37761h;

    /* renamed from: i */
    protected Boolean f37762i;

    /* renamed from: j */
    protected ViewTreeObserver.OnGlobalLayoutListener f37763j;

    /* renamed from: k */
    private int[] f37764k;

    /* renamed from: l */
    private int[] f37765l;

    /* renamed from: com.huawei.openalliance.ad.views.h$1 */
    public class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                View view = AbstractC8104h.this.f37755b;
                if (view == null) {
                    return;
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measuredHeight = AbstractC8104h.this.f37755b.getMeasuredHeight();
                AbstractC8104h abstractC8104h = AbstractC8104h.this;
                abstractC8104h.m50252a(abstractC8104h.f37755b, Math.min(measuredHeight, abstractC8104h.f37758e));
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("PPSBaseDialogContentView", "onGlobalLayout error: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.h$a */
    public interface a {
        /* renamed from: l */
        void mo38623l();
    }

    public AbstractC8104h(Context context) {
        super(context);
        this.f37758e = (int) (AbstractC7807d.m48202a(getContext()) * 0.8f);
        this.f37763j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.h.1
            public AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = AbstractC8104h.this.f37755b;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = AbstractC8104h.this.f37755b.getMeasuredHeight();
                    AbstractC8104h abstractC8104h = AbstractC8104h.this;
                    abstractC8104h.m50252a(abstractC8104h.f37755b, Math.min(measuredHeight, abstractC8104h.f37758e));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSBaseDialogContentView", "onGlobalLayout error: %s", th2.getClass().getSimpleName());
                }
            }
        };
        m50254e(context);
    }

    /* renamed from: a */
    public void m50255a(int i10) {
        int i11 = this.f37760g;
        if (i11 > i10) {
            this.f37760g = i11 - i10;
        }
        int i12 = this.f37761h;
        if (i12 > i10) {
            this.f37761h = i12 - i10;
        }
        mo50094c();
    }

    /* renamed from: a */
    public abstract void mo50092a(Context context);

    /* renamed from: b */
    public abstract void mo50093b(Context context);

    /* renamed from: c */
    public abstract void mo50094c();

    /* renamed from: c */
    public void mo50108c(Context context) {
        if (C7845x.m48587n(context) || (C7845x.m48595q(context) && C7845x.m48599r(context))) {
            this.f37757d = 0.6f;
        } else {
            this.f37757d = 0.86f;
        }
    }

    /* renamed from: d */
    public void mo50109d(Context context) {
        int iWidth;
        int iHeight;
        if (this.f37756c != null) {
            int iM48215b = AbstractC7807d.m48215b(context);
            int iM48202a = AbstractC7807d.m48202a(context);
            if (context instanceof Activity) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Activity activity = (Activity) context;
                    iWidth = activity.getWindowManager().getCurrentWindowMetrics().getBounds().width();
                    iHeight = activity.getWindowManager().getCurrentWindowMetrics().getBounds().height();
                } else {
                    Point point = new Point();
                    ((Activity) context).getWindowManager().getDefaultDisplay().getSize(point);
                    iWidth = point.x;
                    iHeight = point.y;
                }
                int i10 = iWidth;
                iM48202a = iHeight;
                iM48215b = i10;
            }
            ViewGroup.LayoutParams layoutParams = this.f37756c.getLayoutParams();
            this.f37759f = (int) ((AbstractC7811dd.m48335k(context) == 1 ? iM48215b : Math.min(iM48215b, iM48202a)) * this.f37757d);
            layoutParams.width = this.f37759f;
            this.f37756c.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: e */
    public void mo50132e() {
    }

    public float getViewWidthPercent() {
        return this.f37757d;
    }

    public int getViewWith() {
        return this.f37759f;
    }

    public void setAdContent(ContentRecord contentRecord) {
    }

    public void setFeedbackListener(InterfaceC8092b interfaceC8092b) {
    }

    public void setPaddingStart(int i10) {
        if (AbstractC7811dd.m48315c()) {
            this.f37760g = 0;
            this.f37761h = i10;
        } else {
            this.f37760g = i10;
            this.f37761h = 0;
        }
        mo50094c();
    }

    public void setScreenLockCallBack(a aVar) {
    }

    public void setShowWhyThisAd(boolean z10) {
        this.f37762i = Boolean.valueOf(z10);
    }

    public void setViewClickListener(InterfaceC7181hk interfaceC7181hk) {
    }

    public AbstractC8104h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37758e = (int) (AbstractC7807d.m48202a(getContext()) * 0.8f);
        this.f37763j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.h.1
            public AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = AbstractC8104h.this.f37755b;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = AbstractC8104h.this.f37755b.getMeasuredHeight();
                    AbstractC8104h abstractC8104h = AbstractC8104h.this;
                    abstractC8104h.m50252a(abstractC8104h.f37755b, Math.min(measuredHeight, abstractC8104h.f37758e));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSBaseDialogContentView", "onGlobalLayout error: %s", th2.getClass().getSimpleName());
                }
            }
        };
        m50254e(context);
    }

    /* renamed from: a */
    public void m50252a(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: e */
    private void m50254e(Context context) {
        try {
            mo50092a(context);
            mo50108c(context);
            mo50109d(context);
            mo50093b(context);
            mo50094c();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSBaseDialogContentView", "init ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    public boolean m50257d() {
        return (this.f37765l == null || this.f37764k == null) ? false : true;
    }

    public AbstractC8104h(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37758e = (int) (AbstractC7807d.m48202a(getContext()) * 0.8f);
        this.f37763j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.h.1
            public AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = AbstractC8104h.this.f37755b;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = AbstractC8104h.this.f37755b.getMeasuredHeight();
                    AbstractC8104h abstractC8104h = AbstractC8104h.this;
                    abstractC8104h.m50252a(abstractC8104h.f37755b, Math.min(measuredHeight, abstractC8104h.f37758e));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSBaseDialogContentView", "onGlobalLayout error: %s", th2.getClass().getSimpleName());
                }
            }
        };
        m50254e(context);
    }

    @SuppressLint({"NewApi"})
    public AbstractC8104h(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f37758e = (int) (AbstractC7807d.m48202a(getContext()) * 0.8f);
        this.f37763j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.h.1
            public AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = AbstractC8104h.this.f37755b;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = AbstractC8104h.this.f37755b.getMeasuredHeight();
                    AbstractC8104h abstractC8104h = AbstractC8104h.this;
                    abstractC8104h.m50252a(abstractC8104h.f37755b, Math.min(measuredHeight, abstractC8104h.f37758e));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSBaseDialogContentView", "onGlobalLayout error: %s", th2.getClass().getSimpleName());
                }
            }
        };
        m50254e(context);
    }

    /* renamed from: a */
    public void m50256a(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null) {
            return;
        }
        this.f37764k = Arrays.copyOf(iArr, iArr.length);
        this.f37765l = Arrays.copyOf(iArr2, iArr2.length);
    }
}
