package p276f3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R$styleable;

/* renamed from: f3.d */
/* loaded from: classes.dex */
public class C9650d {

    /* renamed from: a */
    public final ColorStateList f47783a;

    /* renamed from: b */
    public final ColorStateList f47784b;

    /* renamed from: c */
    public final ColorStateList f47785c;

    /* renamed from: d */
    public final String f47786d;

    /* renamed from: e */
    public final int f47787e;

    /* renamed from: f */
    public final int f47788f;

    /* renamed from: g */
    public final boolean f47789g;

    /* renamed from: h */
    public final float f47790h;

    /* renamed from: i */
    public final float f47791i;

    /* renamed from: j */
    public final float f47792j;

    /* renamed from: k */
    public final boolean f47793k;

    /* renamed from: l */
    public final float f47794l;

    /* renamed from: m */
    public ColorStateList f47795m;

    /* renamed from: n */
    public float f47796n;

    /* renamed from: o */
    public final int f47797o;

    /* renamed from: p */
    public boolean f47798p = false;

    /* renamed from: q */
    public Typeface f47799q;

    /* renamed from: f3.d$a */
    public class a extends ResourcesCompat.FontCallback {

        /* renamed from: a */
        public final /* synthetic */ AbstractC9652f f47800a;

        public a(AbstractC9652f abstractC9652f) {
            this.f47800a = abstractC9652f;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        /* renamed from: onFontRetrievalFailed */
        public void lambda$callbackFailAsync$1(int i10) {
            C9650d.this.f47798p = true;
            this.f47800a.mo10020a(i10);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        /* renamed from: onFontRetrieved */
        public void lambda$callbackSuccessAsync$0(Typeface typeface) {
            C9650d c9650d = C9650d.this;
            c9650d.f47799q = Typeface.create(typeface, c9650d.f47787e);
            C9650d.this.f47798p = true;
            this.f47800a.mo10021b(C9650d.this.f47799q, false);
        }
    }

    /* renamed from: f3.d$b */
    public class b extends AbstractC9652f {

        /* renamed from: a */
        public final /* synthetic */ Context f47802a;

        /* renamed from: b */
        public final /* synthetic */ TextPaint f47803b;

        /* renamed from: c */
        public final /* synthetic */ AbstractC9652f f47804c;

        public b(Context context, TextPaint textPaint, AbstractC9652f abstractC9652f) {
            this.f47802a = context;
            this.f47803b = textPaint;
            this.f47804c = abstractC9652f;
        }

        @Override // p276f3.AbstractC9652f
        /* renamed from: a */
        public void mo10020a(int i10) {
            this.f47804c.mo10020a(i10);
        }

        @Override // p276f3.AbstractC9652f
        /* renamed from: b */
        public void mo10021b(Typeface typeface, boolean z10) {
            C9650d.this.m60290p(this.f47802a, this.f47803b, typeface);
            this.f47804c.mo10021b(typeface, z10);
        }
    }

    public C9650d(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R$styleable.TextAppearance);
        m60286l(typedArrayObtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f));
        m60285k(C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColor));
        this.f47783a = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.f47784b = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f47787e = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f47788f = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int iM60270f = C9649c.m60270f(typedArrayObtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.f47797o = typedArrayObtainStyledAttributes.getResourceId(iM60270f, 0);
        this.f47786d = typedArrayObtainStyledAttributes.getString(iM60270f);
        this.f47789g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f47785c = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f47790h = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f47791i = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f47792j = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i10, R$styleable.MaterialTextAppearance);
        int i11 = R$styleable.MaterialTextAppearance_android_letterSpacing;
        this.f47793k = typedArrayObtainStyledAttributes2.hasValue(i11);
        this.f47794l = typedArrayObtainStyledAttributes2.getFloat(i11, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    /* renamed from: d */
    public final void m60278d() {
        String str;
        if (this.f47799q == null && (str = this.f47786d) != null) {
            this.f47799q = Typeface.create(str, this.f47787e);
        }
        if (this.f47799q == null) {
            int i10 = this.f47788f;
            if (i10 == 1) {
                this.f47799q = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f47799q = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f47799q = Typeface.DEFAULT;
            } else {
                this.f47799q = Typeface.MONOSPACE;
            }
            this.f47799q = Typeface.create(this.f47799q, this.f47787e);
        }
    }

    /* renamed from: e */
    public Typeface m60279e() {
        m60278d();
        return this.f47799q;
    }

    /* renamed from: f */
    public Typeface m60280f(Context context) {
        if (this.f47798p) {
            return this.f47799q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.f47797o);
                this.f47799q = font;
                if (font != null) {
                    this.f47799q = Typeface.create(font, this.f47787e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f47786d, e10);
            }
        }
        m60278d();
        this.f47798p = true;
        return this.f47799q;
    }

    /* renamed from: g */
    public void m60281g(Context context, TextPaint textPaint, AbstractC9652f abstractC9652f) {
        m60290p(context, textPaint, m60279e());
        m60282h(context, new b(context, textPaint, abstractC9652f));
    }

    /* renamed from: h */
    public void m60282h(Context context, AbstractC9652f abstractC9652f) {
        if (m60287m(context)) {
            m60280f(context);
        } else {
            m60278d();
        }
        int i10 = this.f47797o;
        if (i10 == 0) {
            this.f47798p = true;
        }
        if (this.f47798p) {
            abstractC9652f.mo10021b(this.f47799q, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i10, new a(abstractC9652f), null);
        } catch (Resources.NotFoundException unused) {
            this.f47798p = true;
            abstractC9652f.mo10020a(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f47786d, e10);
            this.f47798p = true;
            abstractC9652f.mo10020a(-3);
        }
    }

    /* renamed from: i */
    public ColorStateList m60283i() {
        return this.f47795m;
    }

    /* renamed from: j */
    public float m60284j() {
        return this.f47796n;
    }

    /* renamed from: k */
    public void m60285k(ColorStateList colorStateList) {
        this.f47795m = colorStateList;
    }

    /* renamed from: l */
    public void m60286l(float f10) {
        this.f47796n = f10;
    }

    /* renamed from: m */
    public final boolean m60287m(Context context) {
        if (C9651e.m60291a()) {
            return true;
        }
        int i10 = this.f47797o;
        return (i10 != 0 ? ResourcesCompat.getCachedFont(context, i10) : null) != null;
    }

    /* renamed from: n */
    public void m60288n(Context context, TextPaint textPaint, AbstractC9652f abstractC9652f) {
        m60289o(context, textPaint, abstractC9652f);
        ColorStateList colorStateList = this.f47795m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f10 = this.f47792j;
        float f11 = this.f47790h;
        float f12 = this.f47791i;
        ColorStateList colorStateList2 = this.f47785c;
        textPaint.setShadowLayer(f10, f11, f12, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    /* renamed from: o */
    public void m60289o(Context context, TextPaint textPaint, AbstractC9652f abstractC9652f) {
        if (m60287m(context)) {
            m60290p(context, textPaint, m60280f(context));
        } else {
            m60281g(context, textPaint, abstractC9652f);
        }
    }

    /* renamed from: p */
    public void m60290p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceM60293a = C9654h.m60293a(context, typeface);
        if (typefaceM60293a != null) {
            typeface = typefaceM60293a;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f47787e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f47796n);
        if (this.f47793k) {
            textPaint.setLetterSpacing(this.f47794l);
        }
    }
}
