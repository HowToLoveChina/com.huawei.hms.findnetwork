package com.huawei.openalliance.p169ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7645ru;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;

/* renamed from: com.huawei.openalliance.ad.views.u */
/* loaded from: classes2.dex */
public abstract class AbstractC8151u extends RelativeLayout {

    /* renamed from: a */
    private ContentRecord f38146a;

    /* renamed from: b */
    private long f38147b;

    public AbstractC8151u(Context context) {
        super(context);
        this.f38147b = 0L;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(getTAG(), "check touch ex: %s", th2.getClass().getSimpleName());
        }
        if (System.currentTimeMillis() - this.f38147b < 10000) {
            return super.dispatchTouchEvent(motionEvent);
        }
        this.f38147b = System.currentTimeMillis();
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.views.u.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43818a(AbstractC8151u.this.getTAG(), "dispatchTouch, cheating: %s", Boolean.valueOf(C7645ru.m47117a(AbstractC8151u.this.getContext(), AbstractC8151u.this.f38146a, stackTrace, AbstractC8151u.this, C7645ru.f35598a).mo47112a()));
            }
        });
        return super.dispatchTouchEvent(motionEvent);
    }

    public abstract String getTAG();

    /* renamed from: i */
    public void m50516i() {
        try {
            if (AbstractC7741ao.m47551a(this.f38146a) && (this instanceof AppDownloadButton)) {
                return;
            }
            post(new Runnable() { // from class: com.huawei.openalliance.ad.views.u.3
                @Override // java.lang.Runnable
                public void run() {
                    final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.views.u.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractC7185ho.m43821b(AbstractC8151u.this.getTAG(), "checkValidDisplay, cheating: %s", Boolean.valueOf(C7645ru.m47117a(AbstractC8151u.this.getContext(), AbstractC8151u.this.f38146a, stackTrace, AbstractC8151u.this, C7645ru.f35600c).mo47112a()));
                        }
                    });
                }
            });
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(getTAG(), "checkValidDisplay ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        try {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.views.u.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43818a(AbstractC8151u.this.getTAG(), "performClick, cheating: %s", Boolean.valueOf(C7645ru.m47117a(AbstractC8151u.this.getContext(), AbstractC8151u.this.f38146a, stackTrace, AbstractC8151u.this, C7645ru.f35599b).mo47112a()));
                }
            });
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(getTAG(), "check click ex: %s", th2.getClass().getSimpleName());
        }
        return super.performClick();
    }

    public void setAdData(ContentRecord contentRecord) {
        this.f38146a = contentRecord;
    }

    public AbstractC8151u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38147b = 0L;
    }

    public AbstractC8151u(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f38147b = 0L;
    }

    @SuppressLint({"NewApi"})
    public AbstractC8151u(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f38147b = 0L;
    }
}
