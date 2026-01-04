package p356i3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;

/* renamed from: i3.m */
/* loaded from: classes.dex */
public class C10432m {

    /* renamed from: m */
    public static final InterfaceC10422c f50312m = new C10430k(0.5f);

    /* renamed from: a */
    public C10423d f50313a;

    /* renamed from: b */
    public C10423d f50314b;

    /* renamed from: c */
    public C10423d f50315c;

    /* renamed from: d */
    public C10423d f50316d;

    /* renamed from: e */
    public InterfaceC10422c f50317e;

    /* renamed from: f */
    public InterfaceC10422c f50318f;

    /* renamed from: g */
    public InterfaceC10422c f50319g;

    /* renamed from: h */
    public InterfaceC10422c f50320h;

    /* renamed from: i */
    public C10425f f50321i;

    /* renamed from: j */
    public C10425f f50322j;

    /* renamed from: k */
    public C10425f f50323k;

    /* renamed from: l */
    public C10425f f50324l;

    /* renamed from: i3.m$c */
    public interface c {
        /* renamed from: a */
        InterfaceC10422c mo64038a(InterfaceC10422c interfaceC10422c);
    }

    /* renamed from: a */
    public static b m64045a() {
        return new b();
    }

    /* renamed from: b */
    public static b m64046b(Context context, int i10, int i11) {
        return m64047c(context, i10, i11, 0);
    }

    /* renamed from: c */
    public static b m64047c(Context context, int i10, int i11, int i12) {
        return m64048d(context, i10, i11, new C10420a(i12));
    }

    /* renamed from: d */
    public static b m64048d(Context context, int i10, int i11, InterfaceC10422c interfaceC10422c) throws Resources.NotFoundException {
        if (i11 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
            i10 = i11;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R$styleable.ShapeAppearance);
        try {
            int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i12);
            int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i12);
            int i15 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i12);
            int i16 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i12);
            InterfaceC10422c interfaceC10422cM64052m = m64052m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, interfaceC10422c);
            InterfaceC10422c interfaceC10422cM64052m2 = m64052m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, interfaceC10422cM64052m);
            InterfaceC10422c interfaceC10422cM64052m3 = m64052m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, interfaceC10422cM64052m);
            InterfaceC10422c interfaceC10422cM64052m4 = m64052m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, interfaceC10422cM64052m);
            return new b().m64085C(i13, interfaceC10422cM64052m2).m64089G(i14, interfaceC10422cM64052m3).m64103x(i15, interfaceC10422cM64052m4).m64099t(i16, m64052m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, interfaceC10422cM64052m));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: e */
    public static b m64049e(Context context, AttributeSet attributeSet, int i10, int i11) {
        return m64050f(context, attributeSet, i10, i11, 0);
    }

    /* renamed from: f */
    public static b m64050f(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return m64051g(context, attributeSet, i10, i11, new C10420a(i12));
    }

    /* renamed from: g */
    public static b m64051g(Context context, AttributeSet attributeSet, int i10, int i11, InterfaceC10422c interfaceC10422c) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return m64048d(context, resourceId, resourceId2, interfaceC10422c);
    }

    /* renamed from: m */
    public static InterfaceC10422c m64052m(TypedArray typedArray, int i10, InterfaceC10422c interfaceC10422c) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        if (typedValuePeekValue == null) {
            return interfaceC10422c;
        }
        int i11 = typedValuePeekValue.type;
        return i11 == 5 ? new C10420a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i11 == 6 ? new C10430k(typedValuePeekValue.getFraction(1.0f, 1.0f)) : interfaceC10422c;
    }

    /* renamed from: h */
    public C10425f m64053h() {
        return this.f50323k;
    }

    /* renamed from: i */
    public C10423d m64054i() {
        return this.f50316d;
    }

    /* renamed from: j */
    public InterfaceC10422c m64055j() {
        return this.f50320h;
    }

    /* renamed from: k */
    public C10423d m64056k() {
        return this.f50315c;
    }

    /* renamed from: l */
    public InterfaceC10422c m64057l() {
        return this.f50319g;
    }

    /* renamed from: n */
    public C10425f m64058n() {
        return this.f50324l;
    }

    /* renamed from: o */
    public C10425f m64059o() {
        return this.f50322j;
    }

    /* renamed from: p */
    public C10425f m64060p() {
        return this.f50321i;
    }

    /* renamed from: q */
    public C10423d m64061q() {
        return this.f50313a;
    }

    /* renamed from: r */
    public InterfaceC10422c m64062r() {
        return this.f50317e;
    }

    /* renamed from: s */
    public C10423d m64063s() {
        return this.f50314b;
    }

    /* renamed from: t */
    public InterfaceC10422c m64064t() {
        return this.f50318f;
    }

    /* renamed from: u */
    public boolean m64065u(RectF rectF) {
        boolean z10 = this.f50324l.getClass().equals(C10425f.class) && this.f50322j.getClass().equals(C10425f.class) && this.f50321i.getClass().equals(C10425f.class) && this.f50323k.getClass().equals(C10425f.class);
        float fMo63966a = this.f50317e.mo63966a(rectF);
        return z10 && ((this.f50318f.mo63966a(rectF) > fMo63966a ? 1 : (this.f50318f.mo63966a(rectF) == fMo63966a ? 0 : -1)) == 0 && (this.f50320h.mo63966a(rectF) > fMo63966a ? 1 : (this.f50320h.mo63966a(rectF) == fMo63966a ? 0 : -1)) == 0 && (this.f50319g.mo63966a(rectF) > fMo63966a ? 1 : (this.f50319g.mo63966a(rectF) == fMo63966a ? 0 : -1)) == 0) && ((this.f50314b instanceof C10431l) && (this.f50313a instanceof C10431l) && (this.f50315c instanceof C10431l) && (this.f50316d instanceof C10431l));
    }

    /* renamed from: v */
    public b m64066v() {
        return new b(this);
    }

    /* renamed from: w */
    public C10432m m64067w(float f10) {
        return m64066v().m64094o(f10).m64093m();
    }

    /* renamed from: x */
    public C10432m m64068x(InterfaceC10422c interfaceC10422c) {
        return m64066v().m64095p(interfaceC10422c).m64093m();
    }

    /* renamed from: y */
    public C10432m m64069y(c cVar) {
        return m64066v().m64088F(cVar.mo64038a(m64062r())).m64092J(cVar.mo64038a(m64064t())).m64102w(cVar.mo64038a(m64055j())).m64083A(cVar.mo64038a(m64057l())).m64093m();
    }

    public C10432m(b bVar) {
        this.f50313a = bVar.f50325a;
        this.f50314b = bVar.f50326b;
        this.f50315c = bVar.f50327c;
        this.f50316d = bVar.f50328d;
        this.f50317e = bVar.f50329e;
        this.f50318f = bVar.f50330f;
        this.f50319g = bVar.f50331g;
        this.f50320h = bVar.f50332h;
        this.f50321i = bVar.f50333i;
        this.f50322j = bVar.f50334j;
        this.f50323k = bVar.f50335k;
        this.f50324l = bVar.f50336l;
    }

    /* renamed from: i3.m$b */
    public static final class b {

        /* renamed from: a */
        public C10423d f50325a;

        /* renamed from: b */
        public C10423d f50326b;

        /* renamed from: c */
        public C10423d f50327c;

        /* renamed from: d */
        public C10423d f50328d;

        /* renamed from: e */
        public InterfaceC10422c f50329e;

        /* renamed from: f */
        public InterfaceC10422c f50330f;

        /* renamed from: g */
        public InterfaceC10422c f50331g;

        /* renamed from: h */
        public InterfaceC10422c f50332h;

        /* renamed from: i */
        public C10425f f50333i;

        /* renamed from: j */
        public C10425f f50334j;

        /* renamed from: k */
        public C10425f f50335k;

        /* renamed from: l */
        public C10425f f50336l;

        public b() {
            this.f50325a = C10428i.m64040b();
            this.f50326b = C10428i.m64040b();
            this.f50327c = C10428i.m64040b();
            this.f50328d = C10428i.m64040b();
            this.f50329e = new C10420a(0.0f);
            this.f50330f = new C10420a(0.0f);
            this.f50331g = new C10420a(0.0f);
            this.f50332h = new C10420a(0.0f);
            this.f50333i = C10428i.m64041c();
            this.f50334j = C10428i.m64041c();
            this.f50335k = C10428i.m64041c();
            this.f50336l = C10428i.m64041c();
        }

        /* renamed from: n */
        public static float m64082n(C10423d c10423d) {
            if (c10423d instanceof C10431l) {
                return ((C10431l) c10423d).f50311a;
            }
            if (c10423d instanceof C10424e) {
                return ((C10424e) c10423d).f50256a;
            }
            return -1.0f;
        }

        /* renamed from: A */
        public b m64083A(InterfaceC10422c interfaceC10422c) {
            this.f50331g = interfaceC10422c;
            return this;
        }

        /* renamed from: B */
        public b m64084B(C10425f c10425f) {
            this.f50333i = c10425f;
            return this;
        }

        /* renamed from: C */
        public b m64085C(int i10, InterfaceC10422c interfaceC10422c) {
            return m64086D(C10428i.m64039a(i10)).m64088F(interfaceC10422c);
        }

        /* renamed from: D */
        public b m64086D(C10423d c10423d) {
            this.f50325a = c10423d;
            float fM64082n = m64082n(c10423d);
            if (fM64082n != -1.0f) {
                m64087E(fM64082n);
            }
            return this;
        }

        /* renamed from: E */
        public b m64087E(float f10) {
            this.f50329e = new C10420a(f10);
            return this;
        }

        /* renamed from: F */
        public b m64088F(InterfaceC10422c interfaceC10422c) {
            this.f50329e = interfaceC10422c;
            return this;
        }

        /* renamed from: G */
        public b m64089G(int i10, InterfaceC10422c interfaceC10422c) {
            return m64090H(C10428i.m64039a(i10)).m64092J(interfaceC10422c);
        }

        /* renamed from: H */
        public b m64090H(C10423d c10423d) {
            this.f50326b = c10423d;
            float fM64082n = m64082n(c10423d);
            if (fM64082n != -1.0f) {
                m64091I(fM64082n);
            }
            return this;
        }

        /* renamed from: I */
        public b m64091I(float f10) {
            this.f50330f = new C10420a(f10);
            return this;
        }

        /* renamed from: J */
        public b m64092J(InterfaceC10422c interfaceC10422c) {
            this.f50330f = interfaceC10422c;
            return this;
        }

        /* renamed from: m */
        public C10432m m64093m() {
            return new C10432m(this);
        }

        /* renamed from: o */
        public b m64094o(float f10) {
            return m64087E(f10).m64091I(f10).m64105z(f10).m64101v(f10);
        }

        /* renamed from: p */
        public b m64095p(InterfaceC10422c interfaceC10422c) {
            return m64088F(interfaceC10422c).m64092J(interfaceC10422c).m64083A(interfaceC10422c).m64102w(interfaceC10422c);
        }

        /* renamed from: q */
        public b m64096q(int i10, float f10) {
            return m64097r(C10428i.m64039a(i10)).m64094o(f10);
        }

        /* renamed from: r */
        public b m64097r(C10423d c10423d) {
            return m64086D(c10423d).m64090H(c10423d).m64104y(c10423d).m64100u(c10423d);
        }

        /* renamed from: s */
        public b m64098s(C10425f c10425f) {
            this.f50335k = c10425f;
            return this;
        }

        /* renamed from: t */
        public b m64099t(int i10, InterfaceC10422c interfaceC10422c) {
            return m64100u(C10428i.m64039a(i10)).m64102w(interfaceC10422c);
        }

        /* renamed from: u */
        public b m64100u(C10423d c10423d) {
            this.f50328d = c10423d;
            float fM64082n = m64082n(c10423d);
            if (fM64082n != -1.0f) {
                m64101v(fM64082n);
            }
            return this;
        }

        /* renamed from: v */
        public b m64101v(float f10) {
            this.f50332h = new C10420a(f10);
            return this;
        }

        /* renamed from: w */
        public b m64102w(InterfaceC10422c interfaceC10422c) {
            this.f50332h = interfaceC10422c;
            return this;
        }

        /* renamed from: x */
        public b m64103x(int i10, InterfaceC10422c interfaceC10422c) {
            return m64104y(C10428i.m64039a(i10)).m64083A(interfaceC10422c);
        }

        /* renamed from: y */
        public b m64104y(C10423d c10423d) {
            this.f50327c = c10423d;
            float fM64082n = m64082n(c10423d);
            if (fM64082n != -1.0f) {
                m64105z(fM64082n);
            }
            return this;
        }

        /* renamed from: z */
        public b m64105z(float f10) {
            this.f50331g = new C10420a(f10);
            return this;
        }

        public b(C10432m c10432m) {
            this.f50325a = C10428i.m64040b();
            this.f50326b = C10428i.m64040b();
            this.f50327c = C10428i.m64040b();
            this.f50328d = C10428i.m64040b();
            this.f50329e = new C10420a(0.0f);
            this.f50330f = new C10420a(0.0f);
            this.f50331g = new C10420a(0.0f);
            this.f50332h = new C10420a(0.0f);
            this.f50333i = C10428i.m64041c();
            this.f50334j = C10428i.m64041c();
            this.f50335k = C10428i.m64041c();
            this.f50336l = C10428i.m64041c();
            this.f50325a = c10432m.f50313a;
            this.f50326b = c10432m.f50314b;
            this.f50327c = c10432m.f50315c;
            this.f50328d = c10432m.f50316d;
            this.f50329e = c10432m.f50317e;
            this.f50330f = c10432m.f50318f;
            this.f50331g = c10432m.f50319g;
            this.f50332h = c10432m.f50320h;
            this.f50333i = c10432m.f50321i;
            this.f50334j = c10432m.f50322j;
            this.f50335k = c10432m.f50323k;
            this.f50336l = c10432m.f50324l;
        }
    }

    public C10432m() {
        this.f50313a = C10428i.m64040b();
        this.f50314b = C10428i.m64040b();
        this.f50315c = C10428i.m64040b();
        this.f50316d = C10428i.m64040b();
        this.f50317e = new C10420a(0.0f);
        this.f50318f = new C10420a(0.0f);
        this.f50319g = new C10420a(0.0f);
        this.f50320h = new C10420a(0.0f);
        this.f50321i = C10428i.m64041c();
        this.f50322j = C10428i.m64041c();
        this.f50323k = C10428i.m64041c();
        this.f50324l = C10428i.m64041c();
    }
}
