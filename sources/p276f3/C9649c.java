package p276f3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.C0523e0;
import com.google.android.material.R$styleable;
import p211d.C8968a;

/* renamed from: f3.c */
/* loaded from: classes.dex */
public class C9649c {
    /* renamed from: a */
    public static ColorStateList m60265a(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList colorStateListM56742a;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (colorStateListM56742a = C8968a.m56742a(context, resourceId)) == null) ? typedArray.getColorStateList(i10) : colorStateListM56742a;
    }

    /* renamed from: b */
    public static ColorStateList m60266b(Context context, C0523e0 c0523e0, int i10) {
        int iM2960n;
        ColorStateList colorStateListM56742a;
        return (!c0523e0.m2965s(i10) || (iM2960n = c0523e0.m2960n(i10, 0)) == 0 || (colorStateListM56742a = C8968a.m56742a(context, iM2960n)) == null) ? c0523e0.m2949c(i10) : colorStateListM56742a;
    }

    /* renamed from: c */
    public static int m60267c(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    /* renamed from: d */
    public static int m60268d(Context context, TypedArray typedArray, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i10, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i10, i11);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i11);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    /* renamed from: e */
    public static Drawable m60269e(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable drawableM56743b;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (drawableM56743b = C8968a.m56743b(context, resourceId)) == null) ? typedArray.getDrawable(i10) : drawableM56743b;
    }

    /* renamed from: f */
    public static int m60270f(TypedArray typedArray, int i10, int i11) {
        return typedArray.hasValue(i10) ? i10 : i11;
    }

    /* renamed from: g */
    public static C9650d m60271g(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return new C9650d(context, resourceId);
    }

    /* renamed from: h */
    public static int m60272h(Context context, int i10, int i11) throws Resources.NotFoundException {
        if (i10 == 0) {
            return i11;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R$styleable.TextAppearance);
        TypedValue typedValue = new TypedValue();
        boolean value = typedArrayObtainStyledAttributes.getValue(R$styleable.TextAppearance_android_textSize, typedValue);
        typedArrayObtainStyledAttributes.recycle();
        return !value ? i11 : m60267c(typedValue) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    /* renamed from: i */
    public static boolean m60273i(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    /* renamed from: j */
    public static boolean m60274j(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
