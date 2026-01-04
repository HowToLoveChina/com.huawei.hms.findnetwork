package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.views.c */
/* loaded from: classes2.dex */
public class C8079c extends ImageSpan {

    /* renamed from: a */
    int f37580a;

    /* renamed from: b */
    int f37581b;

    /* renamed from: c */
    private WeakReference<Drawable> f37582c;

    public C8079c(Context context, Bitmap bitmap, int i10, int i11, int i12) {
        super(context, bitmap, i10);
        m50086a(i11, i12);
    }

    /* renamed from: a */
    private Drawable m50085a() {
        WeakReference<Drawable> weakReference = this.f37582c;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        this.f37582c = new WeakReference<>(drawable2);
        return drawable2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        Drawable drawableM50085a = m50085a();
        canvas.save();
        canvas.translate(this.f37580a + f10, (i12 + ((i14 - i12) / 2)) - (drawableM50085a.getBounds().height() / 2));
        drawableM50085a.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        return this.f37580a + super.getSize(paint, charSequence, i10, i11, fontMetricsInt) + this.f37581b;
    }

    public C8079c(Drawable drawable, int i10, int i11, int i12) {
        super(drawable, i10);
        m50086a(i11, i12);
    }

    /* renamed from: a */
    private void m50086a(int i10, int i11) {
        if (AbstractC7811dd.m48315c()) {
            this.f37580a = i11;
            this.f37581b = i10;
        } else {
            this.f37580a = i10;
            this.f37581b = i11;
        }
    }
}
