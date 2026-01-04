package p273f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* renamed from: f0.f0 */
/* loaded from: classes.dex */
public final class C9598f0 {

    /* renamed from: a */
    public final PointerIcon f47704a;

    /* renamed from: f0.f0$a */
    public static class a {
        /* renamed from: a */
        public static PointerIcon m59826a(Bitmap bitmap, float f10, float f11) {
            return PointerIcon.create(bitmap, f10, f11);
        }

        /* renamed from: b */
        public static PointerIcon m59827b(Context context, int i10) {
            return PointerIcon.getSystemIcon(context, i10);
        }

        /* renamed from: c */
        public static PointerIcon m59828c(Resources resources, int i10) {
            return PointerIcon.load(resources, i10);
        }
    }

    public C9598f0(PointerIcon pointerIcon) {
        this.f47704a = pointerIcon;
    }

    /* renamed from: b */
    public static C9598f0 m59824b(Context context, int i10) {
        return new C9598f0(a.m59827b(context, i10));
    }

    /* renamed from: a */
    public Object m59825a() {
        return this.f47704a;
    }
}
