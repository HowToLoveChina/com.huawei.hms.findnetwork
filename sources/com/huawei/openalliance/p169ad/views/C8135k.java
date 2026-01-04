package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.views.k */
/* loaded from: classes2.dex */
public class C8135k extends C8134j {

    /* renamed from: f */
    protected ImageView f37928f;

    /* renamed from: g */
    protected ScanningView f37929g;

    public C8135k(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m50327a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0 || drawingCache == null) {
            AbstractC7185ho.m43820b(getViewTag(), "captureWidget NULL");
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, 0, 0, measuredWidth, measuredHeight);
        view.destroyDrawingCache();
        return bitmapCreateBitmap;
    }

    /* renamed from: b */
    public void m50329b() {
        ScanningView scanningView = this.f37929g;
        if (scanningView != null) {
            scanningView.m49924b();
        }
    }

    public String getViewTag() {
        return "PPSSplashSwipeClickView";
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        AbstractC7185ho.m43821b(getViewTag(), "w=%s, h=%s, oldw=%s, oldh=%s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        this.f37928f.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.k.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43821b(C8135k.this.getViewTag(), "POST %s %s", Integer.valueOf(C8135k.this.f37928f.getHeight()), Integer.valueOf(C8135k.this.f37928f.getWidth()));
                if (C8135k.this.f37929g.getSrcBitmap() == null) {
                    C8135k c8135k = C8135k.this;
                    c8135k.f37929g.setSrcBitmap(c8135k.m50327a(c8135k.f37928f));
                }
                ScanningView scanningView = C8135k.this.f37929g;
                if (scanningView != null) {
                    scanningView.m49923a();
                }
            }
        });
    }

    public C8135k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C8135k(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
