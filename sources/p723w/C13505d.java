package p723w;

import android.graphics.Paint;
import android.graphics.Rect;
import p243e0.C9369d;

/* renamed from: w.d */
/* loaded from: classes.dex */
public final class C13505d {

    /* renamed from: a */
    public static final ThreadLocal<C9369d<Rect, Rect>> f60774a = new ThreadLocal<>();

    /* renamed from: w.d$a */
    public static class a {
        /* renamed from: a */
        public static boolean m81234a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    /* renamed from: a */
    public static boolean m81233a(Paint paint, String str) {
        return a.m81234a(paint, str);
    }
}
