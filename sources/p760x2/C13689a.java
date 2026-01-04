package p760x2;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p276f3.C9648b;
import p723w.C13503b;

/* renamed from: x2.a */
/* loaded from: classes.dex */
public class C13689a {
    /* renamed from: a */
    public static int m82287a(int i10, int i11) {
        return C13503b.m81226j(i10, (Color.alpha(i10) * i11) / HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: b */
    public static int m82288b(Context context, int i10, int i11) {
        TypedValue typedValueM60260a = C9648b.m60260a(context, i10);
        return typedValueM60260a != null ? typedValueM60260a.data : i11;
    }

    /* renamed from: c */
    public static int m82289c(Context context, int i10, String str) {
        return C9648b.m60263d(context, i10, str);
    }

    /* renamed from: d */
    public static int m82290d(View view, int i10) {
        return C9648b.m60264e(view, i10);
    }

    /* renamed from: e */
    public static int m82291e(View view, int i10, int i11) {
        return m82288b(view.getContext(), i10, i11);
    }

    /* renamed from: f */
    public static boolean m82292f(int i10) {
        return i10 != 0 && C13503b.m81219c(i10) > 0.5d;
    }

    /* renamed from: g */
    public static int m82293g(int i10, int i11) {
        return C13503b.m81222f(i11, i10);
    }

    /* renamed from: h */
    public static int m82294h(int i10, int i11, float f10) {
        return m82293g(i10, C13503b.m81226j(i11, Math.round(Color.alpha(i11) * f10)));
    }

    /* renamed from: i */
    public static int m82295i(View view, int i10, int i11, float f10) {
        return m82294h(m82290d(view, i10), m82290d(view, i11), f10);
    }
}
