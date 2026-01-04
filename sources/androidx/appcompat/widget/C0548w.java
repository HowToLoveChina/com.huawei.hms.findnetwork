package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p002a1.C0005d;
import p438l.C11210d;
import p438l.C11211e;
import p438l.C11213g;
import p438l.C11214h;
import p757x.C13669a;

/* renamed from: androidx.appcompat.widget.w */
/* loaded from: classes.dex */
public final class C0548w {

    /* renamed from: i */
    public static C0548w f2427i;

    /* renamed from: a */
    public WeakHashMap<Context, C11214h<ColorStateList>> f2429a;

    /* renamed from: b */
    public C11213g<String, b> f2430b;

    /* renamed from: c */
    public C11214h<String> f2431c;

    /* renamed from: d */
    public final WeakHashMap<Context, C11210d<WeakReference<Drawable.ConstantState>>> f2432d = new WeakHashMap<>(0);

    /* renamed from: e */
    public TypedValue f2433e;

    /* renamed from: f */
    public boolean f2434f;

    /* renamed from: g */
    public c f2435g;

    /* renamed from: h */
    public static final PorterDuff.Mode f2426h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j */
    public static final a f2428j = new a(6);

    /* renamed from: androidx.appcompat.widget.w$a */
    public static class a extends C11211e<Integer, PorterDuffColorFilter> {
        public a(int i10) {
            super(i10);
        }

        /* renamed from: h */
        public static int m3177h(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        /* renamed from: i */
        public PorterDuffColorFilter m3178i(int i10, PorterDuff.Mode mode) {
            return m67307c(Integer.valueOf(m3177h(i10, mode)));
        }

        /* renamed from: j */
        public PorterDuffColorFilter m3179j(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return m67308d(Integer.valueOf(m3177h(i10, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$b */
    public interface b {
        /* renamed from: a */
        Drawable m3180a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* renamed from: androidx.appcompat.widget.w$c */
    public interface c {
        /* renamed from: a */
        boolean mo2976a(Context context, int i10, Drawable drawable);

        /* renamed from: b */
        PorterDuff.Mode mo2977b(int i10);

        /* renamed from: c */
        Drawable mo2978c(C0548w c0548w, Context context, int i10);

        /* renamed from: d */
        ColorStateList mo2979d(Context context, int i10);

        /* renamed from: e */
        boolean mo2980e(Context context, int i10, Drawable drawable);
    }

    /* renamed from: d */
    public static long m3154d(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    /* renamed from: f */
    public static PorterDuffColorFilter m3155f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m3157k(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: g */
    public static synchronized C0548w m3156g() {
        try {
            if (f2427i == null) {
                C0548w c0548w = new C0548w();
                f2427i = c0548w;
                m3158o(c0548w);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f2427i;
    }

    /* renamed from: k */
    public static synchronized PorterDuffColorFilter m3157k(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterM3178i;
        a aVar = f2428j;
        porterDuffColorFilterM3178i = aVar.m3178i(i10, mode);
        if (porterDuffColorFilterM3178i == null) {
            porterDuffColorFilterM3178i = new PorterDuffColorFilter(i10, mode);
            aVar.m3179j(i10, mode, porterDuffColorFilterM3178i);
        }
        return porterDuffColorFilterM3178i;
    }

    /* renamed from: o */
    public static void m3158o(C0548w c0548w) {
    }

    /* renamed from: p */
    public static boolean m3159p(Drawable drawable) {
        return (drawable instanceof C0005d) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* renamed from: v */
    public static void m3160v(Drawable drawable, C0519c0 c0519c0, int[] iArr) {
        int[] state = drawable.getState();
        if (C0544s.m3140a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = c0519c0.f2304d;
        if (z10 || c0519c0.f2303c) {
            drawable.setColorFilter(m3155f(z10 ? c0519c0.f2301a : null, c0519c0.f2303c ? c0519c0.f2302b : f2426h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    /* renamed from: a */
    public final synchronized boolean m3161a(Context context, long j10, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            C11210d<WeakReference<Drawable.ConstantState>> c11210d = this.f2432d.get(context);
            if (c11210d == null) {
                c11210d = new C11210d<>();
                this.f2432d.put(context, c11210d);
            }
            c11210d.m67300l(j10, new WeakReference<>(constantState));
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public final void m3162b(Context context, int i10, ColorStateList colorStateList) {
        if (this.f2429a == null) {
            this.f2429a = new WeakHashMap<>();
        }
        C11214h<ColorStateList> c11214h = this.f2429a.get(context);
        if (c11214h == null) {
            c11214h = new C11214h<>();
            this.f2429a.put(context, c11214h);
        }
        c11214h.m67336a(i10, colorStateList);
    }

    /* renamed from: c */
    public final void m3163c(Context context) {
        if (this.f2434f) {
            return;
        }
        this.f2434f = true;
        Drawable drawableM3166i = m3166i(context, R$drawable.abc_vector_test);
        if (drawableM3166i == null || !m3159p(drawableM3166i)) {
            this.f2434f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    /* renamed from: e */
    public final Drawable m3164e(Context context, int i10) throws Resources.NotFoundException {
        if (this.f2433e == null) {
            this.f2433e = new TypedValue();
        }
        TypedValue typedValue = this.f2433e;
        context.getResources().getValue(i10, typedValue, true);
        long jM3154d = m3154d(typedValue);
        Drawable drawableM3165h = m3165h(context, jM3154d);
        if (drawableM3165h != null) {
            return drawableM3165h;
        }
        c cVar = this.f2435g;
        Drawable drawableMo2978c = cVar == null ? null : cVar.mo2978c(this, context, i10);
        if (drawableMo2978c != null) {
            drawableMo2978c.setChangingConfigurations(typedValue.changingConfigurations);
            m3161a(context, jM3154d, drawableMo2978c);
        }
        return drawableMo2978c;
    }

    /* renamed from: h */
    public final synchronized Drawable m3165h(Context context, long j10) {
        C11210d<WeakReference<Drawable.ConstantState>> c11210d = this.f2432d.get(context);
        if (c11210d == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceM67296g = c11210d.m67296g(j10);
        if (weakReferenceM67296g != null) {
            Drawable.ConstantState constantState = weakReferenceM67296g.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c11210d.m67301m(j10);
        }
        return null;
    }

    /* renamed from: i */
    public synchronized Drawable m3166i(Context context, int i10) {
        return m3167j(context, i10, false);
    }

    /* renamed from: j */
    public synchronized Drawable m3167j(Context context, int i10, boolean z10) {
        Drawable drawableM3171q;
        try {
            m3163c(context);
            drawableM3171q = m3171q(context, i10);
            if (drawableM3171q == null) {
                drawableM3171q = m3164e(context, i10);
            }
            if (drawableM3171q == null) {
                drawableM3171q = ContextCompat.getDrawable(context, i10);
            }
            if (drawableM3171q != null) {
                drawableM3171q = m3175u(context, i10, z10, drawableM3171q);
            }
            if (drawableM3171q != null) {
                C0544s.m3141b(drawableM3171q);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return drawableM3171q;
    }

    /* renamed from: l */
    public synchronized ColorStateList m3168l(Context context, int i10) {
        ColorStateList colorStateListM3169m;
        colorStateListM3169m = m3169m(context, i10);
        if (colorStateListM3169m == null) {
            c cVar = this.f2435g;
            colorStateListM3169m = cVar == null ? null : cVar.mo2979d(context, i10);
            if (colorStateListM3169m != null) {
                m3162b(context, i10, colorStateListM3169m);
            }
        }
        return colorStateListM3169m;
    }

    /* renamed from: m */
    public final ColorStateList m3169m(Context context, int i10) {
        C11214h<ColorStateList> c11214h;
        WeakHashMap<Context, C11214h<ColorStateList>> weakHashMap = this.f2429a;
        if (weakHashMap == null || (c11214h = weakHashMap.get(context)) == null) {
            return null;
        }
        return c11214h.m67340g(i10);
    }

    /* renamed from: n */
    public PorterDuff.Mode m3170n(int i10) {
        c cVar = this.f2435g;
        if (cVar == null) {
            return null;
        }
        return cVar.mo2977b(i10);
    }

    /* renamed from: q */
    public final Drawable m3171q(Context context, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        C11213g<String, b> c11213g = this.f2430b;
        if (c11213g == null || c11213g.isEmpty()) {
            return null;
        }
        C11214h<String> c11214h = this.f2431c;
        if (c11214h != null) {
            String strM67340g = c11214h.m67340g(i10);
            if ("appcompat_skip_skip".equals(strM67340g) || (strM67340g != null && this.f2430b.get(strM67340g) == null)) {
                return null;
            }
        } else {
            this.f2431c = new C11214h<>();
        }
        if (this.f2433e == null) {
            this.f2433e = new TypedValue();
        }
        TypedValue typedValue = this.f2433e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long jM3154d = m3154d(typedValue);
        Drawable drawableM3165h = m3165h(context, jM3154d);
        if (drawableM3165h != null) {
            return drawableM3165h;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2431c.m67336a(i10, name);
                b bVar = this.f2430b.get(name);
                if (bVar != null) {
                    drawableM3165h = bVar.m3180a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM3165h != null) {
                    drawableM3165h.setChangingConfigurations(typedValue.changingConfigurations);
                    m3161a(context, jM3154d, drawableM3165h);
                }
            } catch (Exception e10) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e10);
            }
        }
        if (drawableM3165h == null) {
            this.f2431c.m67336a(i10, "appcompat_skip_skip");
        }
        return drawableM3165h;
    }

    /* renamed from: r */
    public synchronized void m3172r(Context context) {
        C11210d<WeakReference<Drawable.ConstantState>> c11210d = this.f2432d.get(context);
        if (c11210d != null) {
            c11210d.m67293c();
        }
    }

    /* renamed from: s */
    public synchronized Drawable m3173s(Context context, C0533j0 c0533j0, int i10) {
        try {
            Drawable drawableM3171q = m3171q(context, i10);
            if (drawableM3171q == null) {
                drawableM3171q = c0533j0.m3181a(i10);
            }
            if (drawableM3171q == null) {
                return null;
            }
            return m3175u(context, i10, false, drawableM3171q);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: t */
    public synchronized void m3174t(c cVar) {
        this.f2435g = cVar;
    }

    /* renamed from: u */
    public final Drawable m3175u(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList colorStateListM3168l = m3168l(context, i10);
        if (colorStateListM3168l == null) {
            c cVar = this.f2435g;
            if ((cVar == null || !cVar.mo2980e(context, i10, drawable)) && !m3176w(context, i10, drawable) && z10) {
                return null;
            }
            return drawable;
        }
        if (C0544s.m3140a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableM82231l = C13669a.m82231l(drawable);
        C13669a.m82228i(drawableM82231l, colorStateListM3168l);
        PorterDuff.Mode modeM3170n = m3170n(i10);
        if (modeM3170n == null) {
            return drawableM82231l;
        }
        C13669a.m82229j(drawableM82231l, modeM3170n);
        return drawableM82231l;
    }

    /* renamed from: w */
    public boolean m3176w(Context context, int i10, Drawable drawable) {
        c cVar = this.f2435g;
        return cVar != null && cVar.mo2976a(context, i10, drawable);
    }
}
