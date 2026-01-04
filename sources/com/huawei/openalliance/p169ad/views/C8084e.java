package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: com.huawei.openalliance.ad.views.e */
/* loaded from: classes2.dex */
public class C8084e extends ImageView {

    /* renamed from: a */
    a f37608a;

    /* renamed from: com.huawei.openalliance.ad.views.e$a */
    public static class a extends Drawable {

        /* renamed from: a */
        private static final int f37609a = Color.parseColor("#007DFF");

        /* renamed from: b */
        private final Paint f37610b;

        /* renamed from: c */
        private final Paint f37611c;

        /* renamed from: d */
        private int f37612d;

        public a(Context context) {
            Paint paint = new Paint();
            this.f37610b = paint;
            paint.setColor(-16777216);
            paint.setAlpha(26);
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f37611c = paint2;
            paint2.setColor(f37609a);
            paint2.setAlpha(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            paint2.setStyle(style);
            paint2.setAntiAlias(true);
        }

        /* renamed from: a */
        public void m50111a() {
            this.f37612d = 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawRect(getBounds(), this.f37610b);
            float f10 = this.f37612d / 100.0f;
            if (getLayoutDirection() == 1) {
                canvas.rotate(180.0f, (getBounds().right / 2) - (getBounds().left / 2), (getBounds().bottom / 2) - (getBounds().top / 2));
            }
            canvas.drawRect(getBounds().left, getBounds().top, getBounds().right * f10, getBounds().bottom, this.f37611c);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        /* renamed from: a */
        public void m50112a(int i10) {
            if (i10 > 100) {
                i10 = 100;
            }
            if (i10 >= this.f37612d) {
                this.f37612d = i10;
            }
            invalidateSelf();
        }
    }

    public C8084e(Context context) {
        super(context);
        a aVar = new a(context);
        this.f37608a = aVar;
        setImageDrawable(aVar);
    }

    /* renamed from: a */
    public void m50110a() {
        a aVar = this.f37608a;
        if (aVar != null) {
            aVar.m50111a();
        }
    }

    public void setProgress(int i10) {
        a aVar = this.f37608a;
        if (aVar != null) {
            aVar.m50112a(i10);
        }
    }
}
