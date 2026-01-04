package tk;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import java.util.Locale;
import p212d0.C8974f;

/* renamed from: tk.b */
/* loaded from: classes6.dex */
public class C13021b extends ImageSpan {

    /* renamed from: a */
    public String f59284a;

    /* renamed from: b */
    public int f59285b;

    /* renamed from: c */
    public a f59286c;

    /* renamed from: tk.b$a */
    public interface a {
        /* renamed from: a */
        void mo23908a(int i10);
    }

    public C13021b(Drawable drawable, int i10, String str) {
        super(drawable);
        this.f59285b = i10;
        this.f59284a = str;
    }

    /* renamed from: a */
    public void m78358a(a aVar) {
        this.f59286c = aVar;
    }

    /* renamed from: b */
    public final void m78359b(Paint paint) {
        if (TextUtils.isEmpty(this.f59284a)) {
            return;
        }
        this.f59285b = (int) (this.f59285b - paint.measureText(this.f59284a));
        this.f59284a = null;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f11 = i13;
        int i15 = (int) (((((fontMetrics.ascent + f11) + f11) + fontMetrics.descent) / 2.0f) - ((drawable.getBounds().bottom + drawable.getBounds().top) / 2));
        canvas.save();
        m78359b(paint);
        if (this.f59285b != 0) {
            f10 = C8974f.m56783a(Locale.getDefault()) == 1 ? f10 - this.f59285b : f10 + this.f59285b;
        }
        canvas.translate(f10, i15);
        drawable.draw(canvas);
        canvas.restore();
        a aVar = this.f59286c;
        if (aVar != null) {
            aVar.mo23908a(i15);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        m78359b(paint);
        return this.f59285b + super.getSize(paint, charSequence, i10, i11, fontMetricsInt);
    }
}
