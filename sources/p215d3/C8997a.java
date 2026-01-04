package p215d3;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import p276f3.C9648b;
import p322h0.C10076a;
import p723w.C13506e;

/* renamed from: d3.a */
/* loaded from: classes.dex */
public class C8997a {
    /* renamed from: a */
    public static float m56852a(String[] strArr, int i10) throws NumberFormatException {
        float f10 = Float.parseFloat(strArr[i10]);
        if (f10 >= 0.0f && f10 <= 1.0f) {
            return f10;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f10);
    }

    /* renamed from: b */
    public static String m56853b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    /* renamed from: c */
    public static boolean m56854c(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("(");
        return str.startsWith(sb2.toString()) && str.endsWith(")");
    }

    /* renamed from: d */
    public static int m56855d(Context context, int i10, int i11) {
        return C9648b.m60262c(context, i10, i11);
    }

    /* renamed from: e */
    public static TimeInterpolator m56856e(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!m56854c(strValueOf, "cubic-bezier")) {
            if (m56854c(strValueOf, "path")) {
                return C10076a.m62702b(C13506e.m81238d(m56853b(strValueOf, "path")));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + strValueOf);
        }
        String[] strArrSplit = m56853b(strValueOf, "cubic-bezier").split(",");
        if (strArrSplit.length == 4) {
            return C10076a.m62701a(m56852a(strArrSplit, 0), m56852a(strArrSplit, 1), m56852a(strArrSplit, 2), m56852a(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }
}
