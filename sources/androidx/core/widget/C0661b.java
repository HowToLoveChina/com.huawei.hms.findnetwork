package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* renamed from: androidx.core.widget.b */
/* loaded from: classes.dex */
public final class C0661b {

    /* renamed from: androidx.core.widget.b$a */
    public static class a {
        /* renamed from: a */
        public static Drawable m4036a(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* renamed from: androidx.core.widget.b$b */
    public static class b {
        /* renamed from: a */
        public static void m4037a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        /* renamed from: b */
        public static void m4038b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    /* renamed from: a */
    public static Drawable m4033a(CheckedTextView checkedTextView) {
        return a.m4036a(checkedTextView);
    }

    /* renamed from: b */
    public static void m4034b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        b.m4037a(checkedTextView, colorStateList);
    }

    /* renamed from: c */
    public static void m4035c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        b.m4038b(checkedTextView, mode);
    }
}
