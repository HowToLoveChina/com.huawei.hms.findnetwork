package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;
import p273f0.C9603h0;
import p353i0.C10382a;

/* renamed from: androidx.appcompat.widget.o */
/* loaded from: classes.dex */
public class C0540o {

    /* renamed from: a */
    public final TextView f2377a;

    /* renamed from: b */
    public C0519c0 f2378b;

    /* renamed from: c */
    public C0519c0 f2379c;

    /* renamed from: d */
    public C0519c0 f2380d;

    /* renamed from: e */
    public C0519c0 f2381e;

    /* renamed from: f */
    public C0519c0 f2382f;

    /* renamed from: g */
    public C0519c0 f2383g;

    /* renamed from: h */
    public C0519c0 f2384h;

    /* renamed from: i */
    public final C0541p f2385i;

    /* renamed from: j */
    public int f2386j = 0;

    /* renamed from: k */
    public int f2387k = -1;

    /* renamed from: l */
    public Typeface f2388l;

    /* renamed from: m */
    public boolean f2389m;

    /* renamed from: androidx.appcompat.widget.o$a */
    public class a extends ResourcesCompat.FontCallback {

        /* renamed from: a */
        public final /* synthetic */ int f2390a;

        /* renamed from: b */
        public final /* synthetic */ int f2391b;

        /* renamed from: c */
        public final /* synthetic */ WeakReference f2392c;

        public a(int i10, int i11, WeakReference weakReference) {
            this.f2390a = i10;
            this.f2391b = i11;
            this.f2392c = weakReference;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        /* renamed from: onFontRetrievalFailed */
        public void lambda$callbackFailAsync$1(int i10) {
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        /* renamed from: onFontRetrieved */
        public void lambda$callbackSuccessAsync$0(Typeface typeface) {
            int i10 = this.f2390a;
            if (i10 != -1) {
                typeface = f.m3107a(typeface, i10, (this.f2391b & 2) != 0);
            }
            C0540o.this.m3085n(this.f2392c, typeface);
        }
    }

    /* renamed from: androidx.appcompat.widget.o$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ TextView f2394a;

        /* renamed from: b */
        public final /* synthetic */ Typeface f2395b;

        /* renamed from: c */
        public final /* synthetic */ int f2396c;

        public b(TextView textView, Typeface typeface, int i10) {
            this.f2394a = textView;
            this.f2395b = typeface;
            this.f2396c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2394a.setTypeface(this.f2395b, this.f2396c);
        }
    }

    /* renamed from: androidx.appcompat.widget.o$c */
    public static class c {
        /* renamed from: a */
        public static Drawable[] m3098a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        /* renamed from: b */
        public static void m3099b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: c */
        public static void m3100c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* renamed from: androidx.appcompat.widget.o$d */
    public static class d {
        /* renamed from: a */
        public static LocaleList m3101a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        /* renamed from: b */
        public static void m3102b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* renamed from: androidx.appcompat.widget.o$e */
    public static class e {
        /* renamed from: a */
        public static int m3103a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        /* renamed from: b */
        public static void m3104b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        /* renamed from: c */
        public static void m3105c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        /* renamed from: d */
        public static boolean m3106d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* renamed from: androidx.appcompat.widget.o$f */
    public static class f {
        /* renamed from: a */
        public static Typeface m3107a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    public C0540o(TextView textView) {
        this.f2377a = textView;
        this.f2385i = new C0541p(textView);
    }

    /* renamed from: d */
    public static C0519c0 m3069d(Context context, C0524f c0524f, int i10) {
        ColorStateList colorStateListM2974f = c0524f.m2974f(context, i10);
        if (colorStateListM2974f == null) {
            return null;
        }
        C0519c0 c0519c0 = new C0519c0();
        c0519c0.f2304d = true;
        c0519c0.f2301a = colorStateListM2974f;
        return c0519c0;
    }

    /* renamed from: A */
    public void m3070A(int i10, float f10) {
        if (C0535k0.f2369b || m3083l()) {
            return;
        }
        m3071B(i10, f10);
    }

    /* renamed from: B */
    public final void m3071B(int i10, float f10) {
        this.f2385i.m3127t(i10, f10);
    }

    /* renamed from: C */
    public final void m3072C(Context context, C0523e0 c0523e0) {
        String strM2961o;
        this.f2386j = c0523e0.m2957k(R$styleable.TextAppearance_android_textStyle, this.f2386j);
        int iM2957k = c0523e0.m2957k(R$styleable.TextAppearance_android_textFontWeight, -1);
        this.f2387k = iM2957k;
        if (iM2957k != -1) {
            this.f2386j &= 2;
        }
        int i10 = R$styleable.TextAppearance_android_fontFamily;
        if (!c0523e0.m2965s(i10) && !c0523e0.m2965s(R$styleable.TextAppearance_fontFamily)) {
            int i11 = R$styleable.TextAppearance_android_typeface;
            if (c0523e0.m2965s(i11)) {
                this.f2389m = false;
                int iM2957k2 = c0523e0.m2957k(i11, 1);
                if (iM2957k2 == 1) {
                    this.f2388l = Typeface.SANS_SERIF;
                    return;
                } else if (iM2957k2 == 2) {
                    this.f2388l = Typeface.SERIF;
                    return;
                } else {
                    if (iM2957k2 != 3) {
                        return;
                    }
                    this.f2388l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f2388l = null;
        int i12 = R$styleable.TextAppearance_fontFamily;
        if (c0523e0.m2965s(i12)) {
            i10 = i12;
        }
        int i13 = this.f2387k;
        int i14 = this.f2386j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM2956j = c0523e0.m2956j(i10, this.f2386j, new a(i13, i14, new WeakReference(this.f2377a)));
                if (typefaceM2956j != null) {
                    if (this.f2387k != -1) {
                        this.f2388l = f.m3107a(Typeface.create(typefaceM2956j, 0), this.f2387k, (this.f2386j & 2) != 0);
                    } else {
                        this.f2388l = typefaceM2956j;
                    }
                }
                this.f2389m = this.f2388l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f2388l != null || (strM2961o = c0523e0.m2961o(i10)) == null) {
            return;
        }
        if (this.f2387k != -1) {
            this.f2388l = f.m3107a(Typeface.create(strM2961o, 0), this.f2387k, (this.f2386j & 2) != 0);
        } else {
            this.f2388l = Typeface.create(strM2961o, this.f2386j);
        }
    }

    /* renamed from: a */
    public final void m3073a(Drawable drawable, C0519c0 c0519c0) {
        if (drawable == null || c0519c0 == null) {
            return;
        }
        C0524f.m2971i(drawable, c0519c0, this.f2377a.getDrawableState());
    }

    /* renamed from: b */
    public void m3074b() {
        if (this.f2378b != null || this.f2379c != null || this.f2380d != null || this.f2381e != null) {
            Drawable[] compoundDrawables = this.f2377a.getCompoundDrawables();
            m3073a(compoundDrawables[0], this.f2378b);
            m3073a(compoundDrawables[1], this.f2379c);
            m3073a(compoundDrawables[2], this.f2380d);
            m3073a(compoundDrawables[3], this.f2381e);
        }
        if (this.f2382f == null && this.f2383g == null) {
            return;
        }
        Drawable[] drawableArrM3098a = c.m3098a(this.f2377a);
        m3073a(drawableArrM3098a[0], this.f2382f);
        m3073a(drawableArrM3098a[2], this.f2383g);
    }

    /* renamed from: c */
    public void m3075c() {
        this.f2385i.m3110a();
    }

    /* renamed from: e */
    public int m3076e() {
        return this.f2385i.m3115f();
    }

    /* renamed from: f */
    public int m3077f() {
        return this.f2385i.m3116g();
    }

    /* renamed from: g */
    public int m3078g() {
        return this.f2385i.m3117h();
    }

    /* renamed from: h */
    public int[] m3079h() {
        return this.f2385i.m3118i();
    }

    /* renamed from: i */
    public int m3080i() {
        return this.f2385i.m3119j();
    }

    /* renamed from: j */
    public ColorStateList m3081j() {
        C0519c0 c0519c0 = this.f2384h;
        if (c0519c0 != null) {
            return c0519c0.f2301a;
        }
        return null;
    }

    /* renamed from: k */
    public PorterDuff.Mode m3082k() {
        C0519c0 c0519c0 = this.f2384h;
        if (c0519c0 != null) {
            return c0519c0.f2302b;
        }
        return null;
    }

    /* renamed from: l */
    public boolean m3083l() {
        return this.f2385i.m3121n();
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00ff  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3084m(android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0540o.m3084m(android.util.AttributeSet, int):void");
    }

    /* renamed from: n */
    public void m3085n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f2389m) {
            this.f2388l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (C9603h0.m59863S(textView)) {
                    textView.post(new b(textView, typeface, this.f2386j));
                } else {
                    textView.setTypeface(typeface, this.f2386j);
                }
            }
        }
    }

    /* renamed from: o */
    public void m3086o(boolean z10, int i10, int i11, int i12, int i13) {
        if (C0535k0.f2369b) {
            return;
        }
        m3075c();
    }

    /* renamed from: p */
    public void m3087p() {
        m3074b();
    }

    /* renamed from: q */
    public void m3088q(Context context, int i10) {
        String strM2961o;
        C0523e0 c0523e0M2944t = C0523e0.m2944t(context, i10, R$styleable.TextAppearance);
        int i11 = R$styleable.TextAppearance_textAllCaps;
        if (c0523e0M2944t.m2965s(i11)) {
            m3090s(c0523e0M2944t.m2947a(i11, false));
        }
        int i12 = R$styleable.TextAppearance_android_textSize;
        if (c0523e0M2944t.m2965s(i12) && c0523e0M2944t.m2952f(i12, -1) == 0) {
            this.f2377a.setTextSize(0, 0.0f);
        }
        m3072C(context, c0523e0M2944t);
        int i13 = R$styleable.TextAppearance_fontVariationSettings;
        if (c0523e0M2944t.m2965s(i13) && (strM2961o = c0523e0M2944t.m2961o(i13)) != null) {
            e.m3106d(this.f2377a, strM2961o);
        }
        c0523e0M2944t.m2966w();
        Typeface typeface = this.f2388l;
        if (typeface != null) {
            this.f2377a.setTypeface(typeface, this.f2386j);
        }
    }

    /* renamed from: r */
    public void m3089r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        C10382a.m63834e(editorInfo, textView.getText());
    }

    /* renamed from: s */
    public void m3090s(boolean z10) {
        this.f2377a.setAllCaps(z10);
    }

    /* renamed from: t */
    public void m3091t(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        this.f2385i.m3123p(i10, i11, i12, i13);
    }

    /* renamed from: u */
    public void m3092u(int[] iArr, int i10) throws IllegalArgumentException {
        this.f2385i.m3124q(iArr, i10);
    }

    /* renamed from: v */
    public void m3093v(int i10) {
        this.f2385i.m3125r(i10);
    }

    /* renamed from: w */
    public void m3094w(ColorStateList colorStateList) {
        if (this.f2384h == null) {
            this.f2384h = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2384h;
        c0519c0.f2301a = colorStateList;
        c0519c0.f2304d = colorStateList != null;
        m3097z();
    }

    /* renamed from: x */
    public void m3095x(PorterDuff.Mode mode) {
        if (this.f2384h == null) {
            this.f2384h = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2384h;
        c0519c0.f2302b = mode;
        c0519c0.f2303c = mode != null;
        m3097z();
    }

    /* renamed from: y */
    public final void m3096y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrM3098a = c.m3098a(this.f2377a);
            TextView textView = this.f2377a;
            if (drawable5 == null) {
                drawable5 = drawableArrM3098a[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrM3098a[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrM3098a[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrM3098a[3];
            }
            c.m3099b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrM3098a2 = c.m3098a(this.f2377a);
        Drawable drawable7 = drawableArrM3098a2[0];
        if (drawable7 != null || drawableArrM3098a2[2] != null) {
            TextView textView2 = this.f2377a;
            if (drawable2 == null) {
                drawable2 = drawableArrM3098a2[1];
            }
            Drawable drawable8 = drawableArrM3098a2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrM3098a2[3];
            }
            c.m3099b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f2377a.getCompoundDrawables();
        TextView textView3 = this.f2377a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    /* renamed from: z */
    public final void m3097z() {
        C0519c0 c0519c0 = this.f2384h;
        this.f2378b = c0519c0;
        this.f2379c = c0519c0;
        this.f2380d = c0519c0;
        this.f2381e = c0519c0;
        this.f2382f = c0519c0;
        this.f2383g = c0519c0;
    }
}
