package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* renamed from: androidx.core.widget.f */
/* loaded from: classes.dex */
public class C0665f {

    /* renamed from: androidx.core.widget.f$a */
    public static class a {
        /* renamed from: a */
        public static ColorStateList m4052a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        /* renamed from: b */
        public static PorterDuff.Mode m4053b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        /* renamed from: c */
        public static void m4054c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        /* renamed from: d */
        public static void m4055d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    /* renamed from: a */
    public static ColorStateList m4048a(ImageView imageView) {
        return a.m4052a(imageView);
    }

    /* renamed from: b */
    public static PorterDuff.Mode m4049b(ImageView imageView) {
        return a.m4053b(imageView);
    }

    /* renamed from: c */
    public static void m4050c(ImageView imageView, ColorStateList colorStateList) {
        a.m4054c(imageView, colorStateList);
    }

    /* renamed from: d */
    public static void m4051d(ImageView imageView, PorterDuff.Mode mode) {
        a.m4055d(imageView, mode);
    }
}
