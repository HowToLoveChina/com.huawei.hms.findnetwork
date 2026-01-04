package p757x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: x.a */
/* loaded from: classes.dex */
public final class C13669a {

    /* renamed from: x.a$a */
    public static class a {
        /* renamed from: a */
        public static int m82232a(Drawable drawable) {
            return drawable.getAlpha();
        }

        /* renamed from: b */
        public static Drawable m82233b(DrawableContainer.DrawableContainerState drawableContainerState, int i10) {
            return drawableContainerState.getChild(i10);
        }

        /* renamed from: c */
        public static Drawable m82234c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        /* renamed from: d */
        public static boolean m82235d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        /* renamed from: e */
        public static void m82236e(Drawable drawable, boolean z10) {
            drawable.setAutoMirrored(z10);
        }
    }

    /* renamed from: x.a$b */
    public static class b {
        /* renamed from: a */
        public static void m82237a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        /* renamed from: b */
        public static boolean m82238b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        /* renamed from: c */
        public static ColorFilter m82239c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        /* renamed from: d */
        public static void m82240d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        /* renamed from: e */
        public static void m82241e(Drawable drawable, float f10, float f11) {
            drawable.setHotspot(f10, f11);
        }

        /* renamed from: f */
        public static void m82242f(Drawable drawable, int i10, int i11, int i12, int i13) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }

        /* renamed from: g */
        public static void m82243g(Drawable drawable, int i10) {
            drawable.setTint(i10);
        }

        /* renamed from: h */
        public static void m82244h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        /* renamed from: i */
        public static void m82245i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* renamed from: x.a$c */
    public static class c {
        /* renamed from: a */
        public static int m82246a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        /* renamed from: b */
        public static boolean m82247b(Drawable drawable, int i10) {
            return drawable.setLayoutDirection(i10);
        }
    }

    /* renamed from: a */
    public static void m82220a(Drawable drawable) {
        drawable.clearColorFilter();
    }

    /* renamed from: b */
    public static int m82221b(Drawable drawable) {
        return c.m82246a(drawable);
    }

    /* renamed from: c */
    public static boolean m82222c(Drawable drawable) {
        return a.m82235d(drawable);
    }

    /* renamed from: d */
    public static void m82223d(Drawable drawable, boolean z10) {
        a.m82236e(drawable, z10);
    }

    /* renamed from: e */
    public static void m82224e(Drawable drawable, float f10, float f11) {
        b.m82241e(drawable, f10, f11);
    }

    /* renamed from: f */
    public static void m82225f(Drawable drawable, int i10, int i11, int i12, int i13) {
        b.m82242f(drawable, i10, i11, i12, i13);
    }

    /* renamed from: g */
    public static boolean m82226g(Drawable drawable, int i10) {
        return c.m82247b(drawable, i10);
    }

    /* renamed from: h */
    public static void m82227h(Drawable drawable, int i10) {
        b.m82243g(drawable, i10);
    }

    /* renamed from: i */
    public static void m82228i(Drawable drawable, ColorStateList colorStateList) {
        b.m82244h(drawable, colorStateList);
    }

    /* renamed from: j */
    public static void m82229j(Drawable drawable, PorterDuff.Mode mode) {
        b.m82245i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: k */
    public static <T extends Drawable> T m82230k(Drawable drawable) {
        return drawable instanceof InterfaceC13673e ? (T) ((InterfaceC13673e) drawable).m82257b() : drawable;
    }

    /* renamed from: l */
    public static Drawable m82231l(Drawable drawable) {
        return drawable;
    }
}
