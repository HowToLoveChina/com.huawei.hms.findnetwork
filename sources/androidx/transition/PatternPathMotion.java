package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import p723w.C13506e;

/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* renamed from: a */
    public Path f4750a;

    /* renamed from: b */
    public final Path f4751b;

    /* renamed from: c */
    public final Matrix f4752c;

    public PatternPathMotion() {
        Path path = new Path();
        this.f4751b = path;
        this.f4752c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f4750a = path;
    }

    /* renamed from: b */
    public static float m5694b(float f10, float f11) {
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    @Override // androidx.transition.PathMotion
    /* renamed from: a */
    public Path mo5612a(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float fM5694b = m5694b(f14, f15);
        double dAtan2 = Math.atan2(f15, f14);
        this.f4752c.setScale(fM5694b, fM5694b);
        this.f4752c.postRotate((float) Math.toDegrees(dAtan2));
        this.f4752c.postTranslate(f10, f11);
        Path path = new Path();
        this.f4751b.transform(this.f4752c, path);
        return path;
    }

    /* renamed from: c */
    public void m5695c(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f10 = fArr[0];
        float f11 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f12 = fArr[0];
        float f13 = fArr[1];
        if (f12 == f10 && f13 == f11) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f4752c.setTranslate(-f12, -f13);
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        float fM5694b = 1.0f / m5694b(f14, f15);
        this.f4752c.postScale(fM5694b, fM5694b);
        this.f4752c.postRotate((float) Math.toDegrees(-Math.atan2(f15, f14)));
        path.transform(this.f4752c, this.f4751b);
        this.f4750a = path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f4751b = new Path();
        this.f4752c = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4874k);
        try {
            String namedString = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (namedString != null) {
                m5695c(C13506e.m81238d(namedString));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
