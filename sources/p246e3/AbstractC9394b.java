package p246e3;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p276f3.C9649c;
import p760x2.C13689a;

/* renamed from: e3.b */
/* loaded from: classes.dex */
public abstract class AbstractC9394b {

    /* renamed from: a */
    public int f46918a;

    /* renamed from: b */
    public int f46919b;

    /* renamed from: c */
    public int[] f46920c = new int[0];

    /* renamed from: d */
    public int f46921d;

    /* renamed from: e */
    public int f46922e;

    /* renamed from: f */
    public int f46923f;

    public AbstractC9394b(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f46918a = C9649c.m60268d(context, typedArrayM10770h, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f46919b = Math.min(C9649c.m60268d(context, typedArrayM10770h, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f46918a / 2);
        this.f46922e = typedArrayM10770h.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f46923f = typedArrayM10770h.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        m58858c(context, typedArrayM10770h);
        m58859d(context, typedArrayM10770h);
        typedArrayM10770h.recycle();
    }

    /* renamed from: a */
    public boolean m58856a() {
        return this.f46923f != 0;
    }

    /* renamed from: b */
    public boolean m58857b() {
        return this.f46922e != 0;
    }

    /* renamed from: c */
    public final void m58858c(Context context, TypedArray typedArray) throws Resources.NotFoundException {
        int i10 = R$styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i10)) {
            this.f46920c = new int[]{C13689a.m82288b(context, R$attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i10).type != 1) {
            this.f46920c = new int[]{typedArray.getColor(i10, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
        this.f46920c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    /* renamed from: d */
    public final void m58859d(Context context, TypedArray typedArray) {
        int i10 = R$styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i10)) {
            this.f46921d = typedArray.getColor(i10, -1);
            return;
        }
        this.f46921d = this.f46920c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f10 = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f46921d = C13689a.m82287a(this.f46921d, (int) (f10 * 255.0f));
    }

    /* renamed from: e */
    public abstract void mo10893e();
}
