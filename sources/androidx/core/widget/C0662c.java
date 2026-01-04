package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* renamed from: androidx.core.widget.c */
/* loaded from: classes.dex */
public final class C0662c {

    /* renamed from: androidx.core.widget.c$a */
    public static class a {
        /* renamed from: a */
        public static ColorStateList m4043a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        /* renamed from: b */
        public static PorterDuff.Mode m4044b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        /* renamed from: c */
        public static void m4045c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        /* renamed from: d */
        public static void m4046d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* renamed from: androidx.core.widget.c$b */
    public static class b {
        /* renamed from: a */
        public static Drawable m4047a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    /* renamed from: a */
    public static Drawable m4039a(CompoundButton compoundButton) {
        return b.m4047a(compoundButton);
    }

    /* renamed from: b */
    public static ColorStateList m4040b(CompoundButton compoundButton) {
        return a.m4043a(compoundButton);
    }

    /* renamed from: c */
    public static void m4041c(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.m4045c(compoundButton, colorStateList);
    }

    /* renamed from: d */
    public static void m4042d(CompoundButton compoundButton, PorterDuff.Mode mode) {
        a.m4046d(compoundButton, mode);
    }
}
