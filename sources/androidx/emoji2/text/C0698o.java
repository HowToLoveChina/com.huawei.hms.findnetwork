package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* renamed from: androidx.emoji2.text.o */
/* loaded from: classes.dex */
public final class C0698o extends AbstractC0692i {

    /* renamed from: f */
    public static Paint f3676f;

    public C0698o(C0690g c0690g) {
        super(c0690g);
    }

    /* renamed from: c */
    public static Paint m4319c() {
        if (f3676f == null) {
            TextPaint textPaint = new TextPaint();
            f3676f = textPaint;
            textPaint.setColor(C0688e.m4221b().m4226c());
            f3676f.setStyle(Paint.Style.FILL);
        }
        return f3676f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        if (C0688e.m4221b().m4228i()) {
            canvas.drawRect(f10, i12, f10 + m4278b(), i14, m4319c());
        }
        m4277a().m4248a(canvas, f10, i13, paint);
    }
}
