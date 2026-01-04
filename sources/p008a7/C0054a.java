package p008a7;

import android.annotation.TargetApi;
import android.view.View;

/* renamed from: a7.a */
/* loaded from: classes2.dex */
public class C0054a {
    /* renamed from: a */
    public static void m383a(View view, Runnable runnable) {
        m384b(view, runnable);
    }

    @TargetApi(16)
    /* renamed from: b */
    public static void m384b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
