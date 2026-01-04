package com.huawei.dynamicanimation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.dynamicanimation.AbstractC4672b;
import com.huawei.dynamicanimation.C4671a;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.math.BigDecimal;
import java.util.ArrayList;

/* renamed from: com.huawei.dynamicanimation.b */
/* loaded from: classes5.dex */
public abstract class AbstractC4672b<T extends AbstractC4672b<T>> implements C4671a.b {

    /* renamed from: d */
    public Object f21527d;

    /* renamed from: e */
    public AbstractC4674d f21528e;

    /* renamed from: l */
    public float f21535l;

    /* renamed from: p */
    public static final s f21513p = new f("translationX");

    /* renamed from: q */
    public static final s f21514q = new g("translationY");

    /* renamed from: r */
    public static final s f21515r = new h("translationZ");

    /* renamed from: s */
    public static final s f21516s = new i(TopAnimatorConfig.AnimatorType.SCALE_X);

    /* renamed from: t */
    public static final s f21517t = new j(TopAnimatorConfig.AnimatorType.SCALE_Y);

    /* renamed from: u */
    public static final s f21518u = new k("rotation");

    /* renamed from: v */
    public static final s f21519v = new l("rotationX");

    /* renamed from: w */
    public static final s f21520w = new m("rotationY");

    /* renamed from: x */
    public static final s f21521x = new n(Constants.MULTIPLE_SIGN);

    /* renamed from: y */
    public static final s f21522y = new a("y");

    /* renamed from: z */
    public static final s f21523z = new b("z");

    /* renamed from: A */
    public static final s f21507A = new c(TopAnimatorConfig.AnimatorType.ALPHA);

    /* renamed from: B */
    public static final s f21508B = new d("scrollX");

    /* renamed from: C */
    public static final s f21509C = new e("scrollY");

    /* renamed from: D */
    public static final float f21510D = new BigDecimal(1.0d).divide(new BigDecimal("10")).floatValue();

    /* renamed from: E */
    public static final float f21511E = new BigDecimal(1.0d).divide(new BigDecimal("256")).floatValue();

    /* renamed from: F */
    public static final float f21512F = new BigDecimal(1.0d).divide(new BigDecimal("500")).floatValue();

    /* renamed from: a */
    public float f21524a = 0.0f;

    /* renamed from: b */
    public float f21525b = Float.MAX_VALUE;

    /* renamed from: c */
    public boolean f21526c = false;

    /* renamed from: f */
    public float f21529f = Float.MAX_VALUE;

    /* renamed from: g */
    public float f21530g = -Float.MAX_VALUE;

    /* renamed from: h */
    public boolean f21531h = false;

    /* renamed from: i */
    public boolean f21532i = false;

    /* renamed from: j */
    public long f21533j = 0;

    /* renamed from: k */
    public long f21534k = 16;

    /* renamed from: m */
    public final ArrayList<q> f21536m = new ArrayList<>();

    /* renamed from: n */
    public final ArrayList<p> f21537n = new ArrayList<>();

    /* renamed from: o */
    public final ArrayList<r> f21538o = new ArrayList<>();

    /* renamed from: com.huawei.dynamicanimation.b$a */
    public class a extends s {
        public a(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getY();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setY(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$b */
    public class b extends s {
        public b(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view != null) {
                return view.getZ();
            }
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view != null) {
                view.setZ(f10);
            }
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$c */
    public class c extends s {
        public c(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getAlpha();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setAlpha(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$d */
    public class d extends s {
        public d(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScrollX();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScrollX((int) f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$e */
    public class e extends s {
        public e(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScrollY();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScrollY((int) f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$f */
    public class f extends s {
        public f(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getTranslationX();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setTranslationX(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$g */
    public class g extends s {
        public g(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getTranslationY();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setTranslationY(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$h */
    public class h extends s {
        public h(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view != null) {
                return view.getTranslationZ();
            }
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view != null) {
                view.setTranslationZ(f10);
            }
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$i */
    public class i extends s {
        public i(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScaleX();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScaleX(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$j */
    public class j extends s {
        public j(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScaleY();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScaleY(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$k */
    public class k extends s {
        public k(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotation();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setRotation(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$l */
    public class l extends s {
        public l(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotationX();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setRotationX(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$m */
    public class m extends s {
        public m(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotationY();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setRotationY(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$n */
    public class n extends s {
        public n(String str) {
            super(str, null);
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo28644a(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getX();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo28645b(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setX(f10);
        }
    }

    /* renamed from: com.huawei.dynamicanimation.b$o */
    public static class o {

        /* renamed from: a */
        public float f21539a;

        /* renamed from: b */
        public float f21540b;
    }

    /* renamed from: com.huawei.dynamicanimation.b$p */
    public interface p {
        /* renamed from: a */
        void mo28674a(AbstractC4672b abstractC4672b, boolean z10, float f10, float f11);
    }

    /* renamed from: com.huawei.dynamicanimation.b$q */
    public interface q {
        /* renamed from: a */
        void m28675a(AbstractC4672b abstractC4672b, float f10, float f11);
    }

    /* renamed from: com.huawei.dynamicanimation.b$r */
    public interface r {
        /* renamed from: a */
        void mo28676a(AbstractC4672b abstractC4672b, float f10, float f11);
    }

    /* renamed from: com.huawei.dynamicanimation.b$s */
    public static abstract class s extends AbstractC4674d<View> {
        public /* synthetic */ s(String str, f fVar) {
            this(str);
        }

        public s(String str) {
            super(str);
        }
    }

    public <K> AbstractC4672b(K k10, AbstractC4674d<K> abstractC4674d) {
        m28633h(k10, abstractC4674d);
    }

    /* renamed from: k */
    public static <T> void m28625k(ArrayList<T> arrayList, T t10) {
        int iIndexOf = arrayList.indexOf(t10);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    /* renamed from: l */
    public static void m28626l(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // com.huawei.dynamicanimation.C4671a.b
    /* renamed from: a */
    public boolean mo28623a(long j10) {
        long j11 = this.f21533j;
        if (j11 == 0) {
            this.f21533j = j10;
            if (!this.f21531h) {
                m28638o(this.f21525b);
                return false;
            }
            j11 = j10 - this.f21534k;
        }
        this.f21533j = j10;
        float fMin = Math.min(this.f21525b, this.f21529f);
        this.f21525b = fMin;
        this.f21525b = Math.max(fMin, this.f21530g);
        boolean zMo28643t = mo28643t(j10 - j11);
        m28638o(this.f21525b);
        if (zMo28643t) {
            m28631f(false);
        }
        return zMo28643t;
    }

    /* renamed from: b */
    public T m28627b(p pVar) {
        if (!this.f21537n.contains(pVar)) {
            this.f21537n.add(pVar);
        }
        return this;
    }

    /* renamed from: c */
    public T m28628c(r rVar) {
        if (m28634i()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f21538o.contains(rVar)) {
            this.f21538o.add(rVar);
        }
        return this;
    }

    /* renamed from: d */
    public void m28629d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f21532i) {
            m28631f(true);
        }
    }

    /* renamed from: e */
    public T m28630e() {
        this.f21536m.clear();
        this.f21538o.clear();
        this.f21537n.clear();
        return this;
    }

    /* renamed from: f */
    public final void m28631f(boolean z10) {
        this.f21532i = false;
        C4671a.m28615i().m28621l(this);
        this.f21533j = 0L;
        this.f21526c = false;
        for (int i10 = 0; i10 < this.f21537n.size(); i10++) {
            if (this.f21537n.get(i10) != null) {
                this.f21537n.get(i10).mo28674a(this, z10, this.f21525b, this.f21524a);
            }
        }
        m28626l(this.f21537n);
    }

    /* renamed from: g */
    public float m28632g() {
        return this.f21535l * 0.75f;
    }

    /* renamed from: h */
    public final <K> void m28633h(K k10, AbstractC4674d<K> abstractC4674d) {
        this.f21527d = k10;
        this.f21528e = abstractC4674d;
        if (abstractC4674d == f21518u || abstractC4674d == f21519v || abstractC4674d == f21520w) {
            this.f21535l = f21510D;
            return;
        }
        if (abstractC4674d == f21507A) {
            this.f21535l = f21511E;
        } else if (abstractC4674d == f21516s || abstractC4674d == f21517t) {
            this.f21535l = f21511E;
        } else {
            this.f21535l = 1.0f;
        }
    }

    /* renamed from: i */
    public boolean m28634i() {
        return this.f21532i;
    }

    /* renamed from: j */
    public void m28635j(p pVar) {
        m28625k(this.f21537n, pVar);
    }

    /* renamed from: m */
    public void m28636m(r rVar) {
        m28625k(this.f21538o, rVar);
    }

    /* renamed from: n */
    public <K> T m28637n(K k10, AbstractC4674d<K> abstractC4674d) {
        m28633h(k10, abstractC4674d);
        return this;
    }

    /* renamed from: o */
    public void m28638o(float f10) {
        this.f21528e.mo28645b(this.f21527d, f10);
        for (int i10 = 0; i10 < this.f21538o.size(); i10++) {
            if (this.f21538o.get(i10) != null) {
                this.f21538o.get(i10).mo28676a(this, f10, this.f21524a);
            }
        }
        m28626l(this.f21538o);
    }

    /* renamed from: p */
    public T m28639p(float f10) {
        this.f21524a = f10;
        return this;
    }

    /* renamed from: q */
    public final void m28640q() {
        AbstractC4674d abstractC4674d;
        if (this.f21532i) {
            return;
        }
        this.f21532i = true;
        if (!this.f21526c && (abstractC4674d = this.f21528e) != null) {
            this.f21525b = abstractC4674d.mo28644a(this.f21527d);
        }
        float f10 = this.f21525b;
        if (f10 > this.f21529f || f10 < this.f21530g) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        C4671a.m28615i().m28616f(this, 0L);
        for (int i10 = 0; i10 < this.f21536m.size(); i10++) {
            if (this.f21536m.get(i10) != null) {
                this.f21536m.get(i10).m28675a(this, this.f21525b, this.f21524a);
            }
        }
        m28626l(this.f21536m);
    }

    /* renamed from: r */
    public void m28641r() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f21532i) {
            return;
        }
        this.f21531h = true;
        m28640q();
    }

    /* renamed from: s */
    public void m28642s(long j10) {
        if (j10 > 0 && j10 <= 100) {
            this.f21534k = j10;
        }
        m28641r();
    }

    /* renamed from: t */
    public abstract boolean mo28643t(long j10);
}
