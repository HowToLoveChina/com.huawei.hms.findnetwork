package lu;

import android.app.Activity;

/* renamed from: lu.f */
/* loaded from: classes5.dex */
public class C11347f {
    /* renamed from: a */
    public static void m68157a(Activity activity, int i10) {
        if (activity == null || activity.isFinishing()) {
            C11345d.m68152d("", "activity is null");
        } else {
            activity.getWindow().addFlags(i10);
        }
    }

    /* renamed from: b */
    public static void m68158b(Activity activity) {
        m68157a(activity, 8192);
    }
}
