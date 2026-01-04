package p276f3;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* renamed from: f3.b */
/* loaded from: classes.dex */
public class C9648b {
    /* renamed from: a */
    public static TypedValue m60260a(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m60261b(Context context, int i10, boolean z10) {
        TypedValue typedValueM60260a = m60260a(context, i10);
        return (typedValueM60260a == null || typedValueM60260a.type != 18) ? z10 : typedValueM60260a.data != 0;
    }

    /* renamed from: c */
    public static int m60262c(Context context, int i10, int i11) {
        TypedValue typedValueM60260a = m60260a(context, i10);
        return (typedValueM60260a == null || typedValueM60260a.type != 16) ? i11 : typedValueM60260a.data;
    }

    /* renamed from: d */
    public static int m60263d(Context context, int i10, String str) {
        TypedValue typedValueM60260a = m60260a(context, i10);
        if (typedValueM60260a != null) {
            return typedValueM60260a.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i10)));
    }

    /* renamed from: e */
    public static int m60264e(View view, int i10) {
        return m60263d(view.getContext(), i10, view.getClass().getCanonicalName());
    }
}
