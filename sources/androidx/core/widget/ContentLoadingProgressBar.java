package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a */
    public long f3447a;

    /* renamed from: b */
    public boolean f3448b;

    /* renamed from: c */
    public boolean f3449c;

    /* renamed from: d */
    public boolean f3450d;

    /* renamed from: e */
    public final Runnable f3451e;

    /* renamed from: f */
    public final Runnable f3452f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    public final /* synthetic */ void m3941c() {
        this.f3448b = false;
        this.f3447a = -1L;
        setVisibility(8);
    }

    /* renamed from: d */
    public final /* synthetic */ void m3942d() {
        this.f3449c = false;
        if (this.f3450d) {
            return;
        }
        this.f3447a = System.currentTimeMillis();
        setVisibility(0);
    }

    /* renamed from: e */
    public final void m3943e() {
        removeCallbacks(this.f3451e);
        removeCallbacks(this.f3452f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m3943e();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3943e();
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3447a = -1L;
        this.f3448b = false;
        this.f3449c = false;
        this.f3450d = false;
        this.f3451e = new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f3515a.m3941c();
            }
        };
        this.f3452f = new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f3516a.m3942d();
            }
        };
    }
}
