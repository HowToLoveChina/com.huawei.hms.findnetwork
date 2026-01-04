package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import p211d.C8968a;

/* renamed from: androidx.appcompat.widget.e0 */
/* loaded from: classes.dex */
public class C0523e0 {

    /* renamed from: a */
    public final Context f2318a;

    /* renamed from: b */
    public final TypedArray f2319b;

    /* renamed from: c */
    public TypedValue f2320c;

    public C0523e0(Context context, TypedArray typedArray) {
        this.f2318a = context;
        this.f2319b = typedArray;
    }

    /* renamed from: t */
    public static C0523e0 m2944t(Context context, int i10, int[] iArr) {
        return new C0523e0(context, context.obtainStyledAttributes(i10, iArr));
    }

    /* renamed from: u */
    public static C0523e0 m2945u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0523e0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: v */
    public static C0523e0 m2946v(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new C0523e0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    /* renamed from: a */
    public boolean m2947a(int i10, boolean z10) {
        return this.f2319b.getBoolean(i10, z10);
    }

    /* renamed from: b */
    public int m2948b(int i10, int i11) {
        return this.f2319b.getColor(i10, i11);
    }

    /* renamed from: c */
    public ColorStateList m2949c(int i10) {
        int resourceId;
        ColorStateList colorStateListM56742a;
        return (!this.f2319b.hasValue(i10) || (resourceId = this.f2319b.getResourceId(i10, 0)) == 0 || (colorStateListM56742a = C8968a.m56742a(this.f2318a, resourceId)) == null) ? this.f2319b.getColorStateList(i10) : colorStateListM56742a;
    }

    /* renamed from: d */
    public float m2950d(int i10, float f10) {
        return this.f2319b.getDimension(i10, f10);
    }

    /* renamed from: e */
    public int m2951e(int i10, int i11) {
        return this.f2319b.getDimensionPixelOffset(i10, i11);
    }

    /* renamed from: f */
    public int m2952f(int i10, int i11) {
        return this.f2319b.getDimensionPixelSize(i10, i11);
    }

    /* renamed from: g */
    public Drawable m2953g(int i10) {
        int resourceId;
        return (!this.f2319b.hasValue(i10) || (resourceId = this.f2319b.getResourceId(i10, 0)) == 0) ? this.f2319b.getDrawable(i10) : C8968a.m56743b(this.f2318a, resourceId);
    }

    /* renamed from: h */
    public Drawable m2954h(int i10) {
        int resourceId;
        if (!this.f2319b.hasValue(i10) || (resourceId = this.f2319b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return C0524f.m2968b().m2973d(this.f2318a, resourceId, true);
    }

    /* renamed from: i */
    public float m2955i(int i10, float f10) {
        return this.f2319b.getFloat(i10, f10);
    }

    /* renamed from: j */
    public Typeface m2956j(int i10, int i11, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f2319b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2320c == null) {
            this.f2320c = new TypedValue();
        }
        return ResourcesCompat.getFont(this.f2318a, resourceId, this.f2320c, i11, fontCallback);
    }

    /* renamed from: k */
    public int m2957k(int i10, int i11) {
        return this.f2319b.getInt(i10, i11);
    }

    /* renamed from: l */
    public int m2958l(int i10, int i11) {
        return this.f2319b.getInteger(i10, i11);
    }

    /* renamed from: m */
    public int m2959m(int i10, int i11) {
        return this.f2319b.getLayoutDimension(i10, i11);
    }

    /* renamed from: n */
    public int m2960n(int i10, int i11) {
        return this.f2319b.getResourceId(i10, i11);
    }

    /* renamed from: o */
    public String m2961o(int i10) {
        return this.f2319b.getString(i10);
    }

    /* renamed from: p */
    public CharSequence m2962p(int i10) {
        return this.f2319b.getText(i10);
    }

    /* renamed from: q */
    public CharSequence[] m2963q(int i10) {
        return this.f2319b.getTextArray(i10);
    }

    /* renamed from: r */
    public TypedArray m2964r() {
        return this.f2319b;
    }

    /* renamed from: s */
    public boolean m2965s(int i10) {
        return this.f2319b.hasValue(i10);
    }

    /* renamed from: w */
    public void m2966w() {
        this.f2319b.recycle();
    }
}
