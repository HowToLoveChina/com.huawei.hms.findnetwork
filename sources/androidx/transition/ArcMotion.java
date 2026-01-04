package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* renamed from: g */
    public static final float f4652g = (float) Math.tan(Math.toRadians(35.0d));

    /* renamed from: a */
    public float f4653a;

    /* renamed from: b */
    public float f4654b;

    /* renamed from: c */
    public float f4655c;

    /* renamed from: d */
    public float f4656d;

    /* renamed from: e */
    public float f4657e;

    /* renamed from: f */
    public float f4658f;

    public ArcMotion() {
        this.f4653a = 0.0f;
        this.f4654b = 0.0f;
        this.f4655c = 70.0f;
        this.f4656d = 0.0f;
        this.f4657e = 0.0f;
        this.f4658f = f4652g;
    }

    /* renamed from: e */
    public static float m5611e(float f10) {
        if (f10 < 0.0f || f10 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f10 / 2.0f));
    }

    @Override // androidx.transition.PathMotion
    /* renamed from: a */
    public Path mo5612a(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        Path path = new Path();
        path.moveTo(f10, f11);
        float f17 = f12 - f10;
        float f18 = f13 - f11;
        float f19 = (f17 * f17) + (f18 * f18);
        float f20 = (f10 + f12) / 2.0f;
        float f21 = (f11 + f13) / 2.0f;
        float f22 = 0.25f * f19;
        boolean z10 = f11 > f13;
        if (Math.abs(f17) < Math.abs(f18)) {
            float fAbs = Math.abs(f19 / (f18 * 2.0f));
            if (z10) {
                f15 = fAbs + f13;
                f14 = f12;
            } else {
                f15 = fAbs + f11;
                f14 = f10;
            }
            f16 = this.f4657e;
        } else {
            float f23 = f19 / (f17 * 2.0f);
            if (z10) {
                f15 = f11;
                f14 = f23 + f10;
            } else {
                f14 = f12 - f23;
                f15 = f13;
            }
            f16 = this.f4656d;
        }
        float f24 = f22 * f16 * f16;
        float f25 = f20 - f14;
        float f26 = f21 - f15;
        float f27 = (f25 * f25) + (f26 * f26);
        float f28 = this.f4658f;
        float f29 = f22 * f28 * f28;
        if (f27 >= f24) {
            f24 = f27 > f29 ? f29 : 0.0f;
        }
        if (f24 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f24 / f27);
            f14 = ((f14 - f20) * fSqrt) + f20;
            f15 = f21 + (fSqrt * (f15 - f21));
        }
        path.cubicTo((f10 + f14) / 2.0f, (f11 + f15) / 2.0f, (f14 + f12) / 2.0f, (f15 + f13) / 2.0f, f12, f13);
        return path;
    }

    /* renamed from: b */
    public void m5613b(float f10) {
        this.f4655c = f10;
        this.f4658f = m5611e(f10);
    }

    /* renamed from: c */
    public void m5614c(float f10) {
        this.f4653a = f10;
        this.f4656d = m5611e(f10);
    }

    /* renamed from: d */
    public void m5615d(float f10) {
        this.f4654b = f10;
        this.f4657e = m5611e(f10);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4653a = 0.0f;
        this.f4654b = 0.0f;
        this.f4655c = 70.0f;
        this.f4656d = 0.0f;
        this.f4657e = 0.0f;
        this.f4658f = f4652g;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4873j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        m5615d(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        m5614c(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        m5613b(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        typedArrayObtainStyledAttributes.recycle();
    }
}
