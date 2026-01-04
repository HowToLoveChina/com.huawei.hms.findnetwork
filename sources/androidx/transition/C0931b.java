package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;

/* renamed from: androidx.transition.b */
/* loaded from: classes.dex */
public class C0931b {
    @SuppressLint({"SoonBlockedPrivateApi"})
    /* renamed from: a */
    public static void m5783a(Canvas canvas, boolean z10) {
        if (z10) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
