package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import p507o2.C11788a;
import p507o2.C11794g;
import p507o2.C11795h;
import p507o2.InterfaceC11790c;
import p507o2.InterfaceC11791d;
import p507o2.InterfaceC11792e;
import p542p2.InterfaceC12082i;
import p630s2.C12670e;
import p630s2.C12676k;
import p630s2.C12677l;
import p829z1.AbstractC14071j;

/* renamed from: com.bumptech.glide.j */
/* loaded from: classes.dex */
public class C1554j<TranscodeType> extends BaseRequestOptions<C1554j<TranscodeType>> implements Cloneable {

    /* renamed from: o */
    public static final RequestOptions f6890o = new RequestOptions().diskCacheStrategy(AbstractC14071j.f62956c).priority(EnumC1551g.LOW).skipMemoryCache(true);

    /* renamed from: a */
    public final Context f6891a;

    /* renamed from: b */
    public final ComponentCallbacks2C1555k f6892b;

    /* renamed from: c */
    public final Class<TranscodeType> f6893c;

    /* renamed from: d */
    public final ComponentCallbacks2C1546b f6894d;

    /* renamed from: e */
    public final C1548d f6895e;

    /* renamed from: f */
    public AbstractC1556l<?, ? super TranscodeType> f6896f;

    /* renamed from: g */
    public Object f6897g;

    /* renamed from: h */
    public List<InterfaceC11792e<TranscodeType>> f6898h;

    /* renamed from: i */
    public C1554j<TranscodeType> f6899i;

    /* renamed from: j */
    public C1554j<TranscodeType> f6900j;

    /* renamed from: k */
    public Float f6901k;

    /* renamed from: l */
    public boolean f6902l = true;

    /* renamed from: m */
    public boolean f6903m;

    /* renamed from: n */
    public boolean f6904n;

    /* renamed from: com.bumptech.glide.j$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6905a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f6906b;

        static {
            int[] iArr = new int[EnumC1551g.values().length];
            f6906b = iArr;
            try {
                iArr[EnumC1551g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6906b[EnumC1551g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6906b[EnumC1551g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6906b[EnumC1551g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f6905a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6905a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6905a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6905a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6905a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6905a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6905a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6905a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public C1554j(ComponentCallbacks2C1546b componentCallbacks2C1546b, ComponentCallbacks2C1555k componentCallbacks2C1555k, Class<TranscodeType> cls, Context context) {
        this.f6894d = componentCallbacks2C1546b;
        this.f6892b = componentCallbacks2C1555k;
        this.f6893c = cls;
        this.f6891a = context;
        this.f6896f = componentCallbacks2C1555k.m8982p(cls);
        this.f6895e = componentCallbacks2C1546b.m8910i();
        m8961j(componentCallbacks2C1555k.m8980n());
        apply(componentCallbacks2C1555k.m8981o());
    }

    /* renamed from: a */
    public C1554j<TranscodeType> m8954a(InterfaceC11792e<TranscodeType> interfaceC11792e) {
        if (isAutoCloneEnabled()) {
            return clone().m8954a(interfaceC11792e);
        }
        if (interfaceC11792e != null) {
            if (this.f6898h == null) {
                this.f6898h = new ArrayList();
            }
            this.f6898h.add(interfaceC11792e);
        }
        return selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public C1554j<TranscodeType> apply(BaseRequestOptions<?> baseRequestOptions) {
        C12676k.m76276d(baseRequestOptions);
        return (C1554j) super.apply(baseRequestOptions);
    }

    /* renamed from: c */
    public final InterfaceC11790c m8956c(InterfaceC12082i<TranscodeType> interfaceC12082i, InterfaceC11792e<TranscodeType> interfaceC11792e, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return m8957d(new Object(), interfaceC12082i, interfaceC11792e, null, this.f6896f, baseRequestOptions.getPriority(), baseRequestOptions.getOverrideWidth(), baseRequestOptions.getOverrideHeight(), baseRequestOptions, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final InterfaceC11790c m8957d(Object obj, InterfaceC12082i<TranscodeType> interfaceC12082i, InterfaceC11792e<TranscodeType> interfaceC11792e, InterfaceC11791d interfaceC11791d, AbstractC1556l<?, ? super TranscodeType> abstractC1556l, EnumC1551g enumC1551g, int i10, int i11, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        C11788a c11788a;
        InterfaceC11791d c11788a2;
        if (this.f6900j != null) {
            c11788a2 = new C11788a(obj, interfaceC11791d);
            c11788a = c11788a2;
        } else {
            c11788a = 0;
            c11788a2 = interfaceC11791d;
        }
        InterfaceC11790c interfaceC11790cM8958f = m8958f(obj, interfaceC12082i, interfaceC11792e, c11788a2, abstractC1556l, enumC1551g, i10, i11, baseRequestOptions, executor);
        if (c11788a == 0) {
            return interfaceC11790cM8958f;
        }
        int overrideWidth = this.f6900j.getOverrideWidth();
        int overrideHeight = this.f6900j.getOverrideHeight();
        if (C12677l.m76296s(i10, i11) && !this.f6900j.isValidOverride()) {
            overrideWidth = baseRequestOptions.getOverrideWidth();
            overrideHeight = baseRequestOptions.getOverrideHeight();
        }
        C1554j<TranscodeType> c1554j = this.f6900j;
        c11788a.m70279p(interfaceC11790cM8958f, c1554j.m8957d(obj, interfaceC12082i, interfaceC11792e, c11788a, c1554j.f6896f, c1554j.getPriority(), overrideWidth, overrideHeight, this.f6900j, executor));
        return c11788a;
    }

    /* renamed from: f */
    public final InterfaceC11790c m8958f(Object obj, InterfaceC12082i<TranscodeType> interfaceC12082i, InterfaceC11792e<TranscodeType> interfaceC11792e, InterfaceC11791d interfaceC11791d, AbstractC1556l<?, ? super TranscodeType> abstractC1556l, EnumC1551g enumC1551g, int i10, int i11, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        C1554j<TranscodeType> c1554j = this.f6899i;
        if (c1554j == null) {
            if (this.f6901k == null) {
                return m8973v(obj, interfaceC12082i, interfaceC11792e, baseRequestOptions, interfaceC11791d, abstractC1556l, enumC1551g, i10, i11, executor);
            }
            C11795h c11795h = new C11795h(obj, interfaceC11791d);
            c11795h.m70308o(m8973v(obj, interfaceC12082i, interfaceC11792e, baseRequestOptions, c11795h, abstractC1556l, enumC1551g, i10, i11, executor), m8973v(obj, interfaceC12082i, interfaceC11792e, baseRequestOptions.mo85641clone().sizeMultiplier(this.f6901k.floatValue()), c11795h, abstractC1556l, m8960i(enumC1551g), i10, i11, executor));
            return c11795h;
        }
        if (this.f6904n) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        AbstractC1556l<?, ? super TranscodeType> abstractC1556l2 = c1554j.f6902l ? abstractC1556l : c1554j.f6896f;
        EnumC1551g priority = c1554j.isPrioritySet() ? this.f6899i.getPriority() : m8960i(enumC1551g);
        int overrideWidth = this.f6899i.getOverrideWidth();
        int overrideHeight = this.f6899i.getOverrideHeight();
        if (C12677l.m76296s(i10, i11) && !this.f6899i.isValidOverride()) {
            overrideWidth = baseRequestOptions.getOverrideWidth();
            overrideHeight = baseRequestOptions.getOverrideHeight();
        }
        C11795h c11795h2 = new C11795h(obj, interfaceC11791d);
        InterfaceC11790c interfaceC11790cM8973v = m8973v(obj, interfaceC12082i, interfaceC11792e, baseRequestOptions, c11795h2, abstractC1556l, enumC1551g, i10, i11, executor);
        this.f6904n = true;
        C1554j<TranscodeType> c1554j2 = this.f6899i;
        InterfaceC11790c interfaceC11790cM8957d = c1554j2.m8957d(obj, interfaceC12082i, interfaceC11792e, c11795h2, abstractC1556l2, priority, overrideWidth, overrideHeight, c1554j2, executor);
        this.f6904n = false;
        c11795h2.m70308o(interfaceC11790cM8973v, interfaceC11790cM8957d);
        return c11795h2;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C1554j<TranscodeType> mo85641clone() {
        C1554j<TranscodeType> c1554j = (C1554j) super.mo85641clone();
        c1554j.f6896f = c1554j.f6896f.clone();
        if (c1554j.f6898h != null) {
            c1554j.f6898h = new ArrayList(c1554j.f6898h);
        }
        C1554j<TranscodeType> c1554j2 = c1554j.f6899i;
        if (c1554j2 != null) {
            c1554j.f6899i = c1554j2.clone();
        }
        C1554j<TranscodeType> c1554j3 = c1554j.f6900j;
        if (c1554j3 != null) {
            c1554j.f6900j = c1554j3.clone();
        }
        return c1554j;
    }

    /* renamed from: i */
    public final EnumC1551g m8960i(EnumC1551g enumC1551g) {
        int i10 = a.f6906b[enumC1551g.ordinal()];
        if (i10 == 1) {
            return EnumC1551g.NORMAL;
        }
        if (i10 == 2) {
            return EnumC1551g.HIGH;
        }
        if (i10 == 3 || i10 == 4) {
            return EnumC1551g.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: j */
    public final void m8961j(List<InterfaceC11792e<Object>> list) {
        Iterator<InterfaceC11792e<Object>> it = list.iterator();
        while (it.hasNext()) {
            m8954a((InterfaceC11792e) it.next());
        }
    }

    /* renamed from: k */
    public <Y extends InterfaceC12082i<TranscodeType>> Y m8962k(Y y10) {
        return (Y) m8964m(y10, null, C12670e.m76260b());
    }

    /* renamed from: l */
    public final <Y extends InterfaceC12082i<TranscodeType>> Y m8963l(Y y10, InterfaceC11792e<TranscodeType> interfaceC11792e, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        C12676k.m76276d(y10);
        if (!this.f6903m) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        InterfaceC11790c interfaceC11790cM8956c = m8956c(y10, interfaceC11792e, baseRequestOptions, executor);
        InterfaceC11790c interfaceC11790cMo72224a = y10.mo72224a();
        if (interfaceC11790cM8956c.mo70271h(interfaceC11790cMo72224a) && !m8966o(baseRequestOptions, interfaceC11790cMo72224a)) {
            if (!((InterfaceC11790c) C12676k.m76276d(interfaceC11790cMo72224a)).isRunning()) {
                interfaceC11790cMo72224a.mo70272i();
            }
            return y10;
        }
        this.f6892b.m8979m(y10);
        y10.mo72225e(interfaceC11790cM8956c);
        this.f6892b.m8991y(y10, interfaceC11790cM8956c);
        return y10;
    }

    /* renamed from: m */
    public <Y extends InterfaceC12082i<TranscodeType>> Y m8964m(Y y10, InterfaceC11792e<TranscodeType> interfaceC11792e, Executor executor) {
        return (Y) m8963l(y10, interfaceC11792e, this, executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x004c  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p542p2.AbstractC12083j<android.widget.ImageView, TranscodeType> m8965n(android.widget.ImageView r4) {
        /*
            r3 = this;
            p630s2.C12677l.m76278a()
            p630s2.C12676k.m76276d(r4)
            boolean r0 = r3.isTransformationSet()
            if (r0 != 0) goto L4c
            boolean r0 = r3.isTransformationAllowed()
            if (r0 == 0) goto L4c
            android.widget.ImageView$ScaleType r0 = r4.getScaleType()
            if (r0 == 0) goto L4c
            int[] r0 = com.bumptech.glide.C1554j.a.f6905a
            android.widget.ImageView$ScaleType r1 = r4.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L43;
                case 2: goto L3a;
                case 3: goto L31;
                case 4: goto L31;
                case 5: goto L31;
                case 6: goto L28;
                default: goto L27;
            }
        L27:
            goto L4c
        L28:
            com.bumptech.glide.request.BaseRequestOptions r0 = r3.mo85641clone()
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.optionalCenterInside()
            goto L4d
        L31:
            com.bumptech.glide.request.BaseRequestOptions r0 = r3.mo85641clone()
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.optionalFitCenter()
            goto L4d
        L3a:
            com.bumptech.glide.request.BaseRequestOptions r0 = r3.mo85641clone()
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.optionalCenterInside()
            goto L4d
        L43:
            com.bumptech.glide.request.BaseRequestOptions r0 = r3.mo85641clone()
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.optionalCenterCrop()
            goto L4d
        L4c:
            r0 = r3
        L4d:
            com.bumptech.glide.d r1 = r3.f6895e
            java.lang.Class<TranscodeType> r2 = r3.f6893c
            p2.j r4 = r1.m8919a(r4, r2)
            r1 = 0
            java.util.concurrent.Executor r2 = p630s2.C12670e.m76260b()
            p2.i r3 = r3.m8963l(r4, r1, r0, r2)
            p2.j r3 = (p542p2.AbstractC12083j) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.C1554j.m8965n(android.widget.ImageView):p2.j");
    }

    /* renamed from: o */
    public final boolean m8966o(BaseRequestOptions<?> baseRequestOptions, InterfaceC11790c interfaceC11790c) {
        return !baseRequestOptions.isMemoryCacheable() && interfaceC11790c.mo70274k();
    }

    /* renamed from: p */
    public C1554j<TranscodeType> m8967p(InterfaceC11792e<TranscodeType> interfaceC11792e) {
        if (isAutoCloneEnabled()) {
            return clone().m8967p(interfaceC11792e);
        }
        this.f6898h = null;
        return m8954a(interfaceC11792e);
    }

    /* renamed from: q */
    public C1554j<TranscodeType> m8968q(Uri uri) {
        return m8972u(uri);
    }

    /* renamed from: r */
    public C1554j<TranscodeType> m8969r(File file) {
        return m8972u(file);
    }

    /* renamed from: s */
    public C1554j<TranscodeType> m8970s(Object obj) {
        return m8972u(obj);
    }

    /* renamed from: t */
    public C1554j<TranscodeType> m8971t(String str) {
        return m8972u(str);
    }

    /* renamed from: u */
    public final C1554j<TranscodeType> m8972u(Object obj) {
        if (isAutoCloneEnabled()) {
            return clone().m8972u(obj);
        }
        this.f6897g = obj;
        this.f6903m = true;
        return selfOrThrowIfLocked();
    }

    /* renamed from: v */
    public final InterfaceC11790c m8973v(Object obj, InterfaceC12082i<TranscodeType> interfaceC12082i, InterfaceC11792e<TranscodeType> interfaceC11792e, BaseRequestOptions<?> baseRequestOptions, InterfaceC11791d interfaceC11791d, AbstractC1556l<?, ? super TranscodeType> abstractC1556l, EnumC1551g enumC1551g, int i10, int i11, Executor executor) {
        Context context = this.f6891a;
        C1548d c1548d = this.f6895e;
        return C11794g.m70286y(context, c1548d, obj, this.f6897g, this.f6893c, baseRequestOptions, i10, i11, enumC1551g, interfaceC12082i, interfaceC11792e, this.f6898h, interfaceC11791d, c1548d.m8924f(), abstractC1556l.m8995d(), executor);
    }
}
