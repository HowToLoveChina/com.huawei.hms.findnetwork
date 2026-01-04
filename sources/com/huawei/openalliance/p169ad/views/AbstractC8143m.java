package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7639ro;
import com.huawei.openalliance.p169ad.C7640rp;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.EnumC7480mo;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.InterfaceC7534ob;
import com.huawei.openalliance.p169ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n;

/* renamed from: com.huawei.openalliance.ad.views.m */
/* loaded from: classes2.dex */
public abstract class AbstractC8143m<P extends InterfaceC7534ob> extends RelativeLayout implements InterfaceC8121n {

    /* renamed from: A */
    private Integer f37971A;

    /* renamed from: B */
    private Integer f37972B;

    /* renamed from: C */
    private Integer f37973C;

    /* renamed from: D */
    private int f37974D;

    /* renamed from: E */
    private MaterialClickInfo f37975E;

    /* renamed from: F */
    private View.OnTouchListener f37976F;

    /* renamed from: G */
    private View.OnTouchListener f37977G;

    /* renamed from: H */
    private View.OnTouchListener f37978H;

    /* renamed from: I */
    private AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh f37979I;

    /* renamed from: a */
    protected P f37980a;

    /* renamed from: b */
    protected InterfaceC7416lz f37981b;

    /* renamed from: c */
    protected ContentRecord f37982c;

    /* renamed from: d */
    protected int f37983d;

    /* renamed from: e */
    protected InterfaceC7328jb f37984e;

    /* renamed from: f */
    private boolean f37985f;

    /* renamed from: g */
    private Long f37986g;

    /* renamed from: h */
    private View f37987h;

    /* renamed from: i */
    private C7640rp f37988i;

    /* renamed from: j */
    private C7639ro f37989j;

    /* renamed from: k */
    private double f37990k;

    /* renamed from: l */
    private double f37991l;

    /* renamed from: m */
    private double f37992m;

    /* renamed from: n */
    private double f37993n;

    /* renamed from: o */
    private double f37994o;

    /* renamed from: p */
    private double f37995p;

    /* renamed from: q */
    private double f37996q;

    /* renamed from: r */
    private double f37997r;

    /* renamed from: s */
    private double f37998s;

    /* renamed from: t */
    private double f37999t;

    /* renamed from: u */
    private boolean f38000u;

    /* renamed from: v */
    private int f38001v;

    /* renamed from: w */
    private int f38002w;

    /* renamed from: x */
    private int f38003x;

    /* renamed from: y */
    private int f38004y;

    /* renamed from: z */
    private float f38005z;

    /* renamed from: com.huawei.openalliance.ad.views.m$a */
    public class a implements C7639ro.a {
        private a() {
        }

        @Override // com.huawei.openalliance.p169ad.C7639ro.a
        /* renamed from: a */
        public void mo47106a(float f10, float f11, float f12) {
            AbstractC8143m.this.f38005z = (float) Math.sqrt((f10 * f10) + (f11 * f11) + (f12 * f12));
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSBaseView", "accLimitNew: %s, xAcc: %s yAcc: %s zAcc: %s, sqrtAcc: %s", Integer.valueOf(AbstractC8143m.this.f38003x), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(AbstractC8143m.this.f38005z));
            }
            if (AbstractC8143m.this.f37986g == null || !AbstractC8143m.this.m50419o()) {
                return;
            }
            AbstractC7185ho.m43821b("PPSBaseView", "meet, accLimitNew: %s, sqrtAcc: %s", Integer.valueOf(AbstractC8143m.this.f38003x), Float.valueOf(AbstractC8143m.this.f38005z));
            AbstractC8143m.this.m50413l();
            MaterialClickInfo materialClickInfoM44535a = new MaterialClickInfo.C7296a().m44539c((Integer) 2).m44538b(Integer.valueOf(AbstractC8143m.this.getWidth()) + "*" + Integer.valueOf(AbstractC8143m.this.getHeight())).m44531a(Float.valueOf(AbstractC7807d.m48245j(AbstractC8143m.this.getContext()))).m44535a();
            AbstractC8143m abstractC8143m = AbstractC8143m.this;
            abstractC8143m.f37980a.mo46111a(0, 0, abstractC8143m.f37982c, abstractC8143m.f37986g, materialClickInfoM44535a, 19);
            AbstractC8143m.this.f37981b.mo45610a(EnumC7480mo.CLICK);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.m$b */
    public class b implements C7640rp.a {
        private b() {
        }

        @Override // com.huawei.openalliance.p169ad.C7640rp.a
        /* renamed from: a */
        public void mo47110a(double d10, double d11, double d12) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSBaseView", "X:%s Y:%s Z:%s", Double.valueOf(d10), Double.valueOf(d11), Double.valueOf(d12));
            }
            AbstractC8143m.this.f38000u = true;
            if (AbstractC8143m.this.f37971A == null) {
                AbstractC8143m.this.f37971A = Integer.valueOf((int) d10);
            }
            if (AbstractC8143m.this.f37972B == null) {
                AbstractC8143m.this.f37972B = Integer.valueOf((int) d11);
            }
            if (AbstractC8143m.this.f37973C == null) {
                AbstractC8143m.this.f37973C = Integer.valueOf((int) d12);
            }
            AbstractC8143m.this.m50389a(d10, d11, d12);
            AbstractC8143m abstractC8143m = AbstractC8143m.this;
            abstractC8143m.f37991l = abstractC8143m.m50395b(abstractC8143m.f37992m, AbstractC8143m.this.f37993n);
            AbstractC8143m abstractC8143m2 = AbstractC8143m.this;
            abstractC8143m2.f37994o = abstractC8143m2.m50395b(abstractC8143m2.f37995p, AbstractC8143m.this.f37996q);
            AbstractC8143m abstractC8143m3 = AbstractC8143m.this;
            abstractC8143m3.f37997r = abstractC8143m3.m50395b(abstractC8143m3.f37998s, AbstractC8143m.this.f37999t);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSBaseView", "diffDegreeX: %s diffDegreeY: %s diffDegreeZ: %s", Double.valueOf(AbstractC8143m.this.f37991l), Double.valueOf(AbstractC8143m.this.f37994o), Double.valueOf(AbstractC8143m.this.f37997r));
                AbstractC7185ho.m43818a("PPSBaseView", "diffLeftDegreeX: %s diffRightDegreeX: %s ", Double.valueOf(AbstractC8143m.this.f37992m), Double.valueOf(AbstractC8143m.this.f37993n));
                AbstractC7185ho.m43818a("PPSBaseView", "diffLeftDegreeY: %s diffRightDegreeY: %s ", Double.valueOf(AbstractC8143m.this.f37995p), Double.valueOf(AbstractC8143m.this.f37996q));
                AbstractC7185ho.m43818a("PPSBaseView", "diffLeftDegreeZ: %s diffRightDegreeZ: %s ", Double.valueOf(AbstractC8143m.this.f37998s), Double.valueOf(AbstractC8143m.this.f37999t));
            }
            if (AbstractC8143m.this.f37986g == null || !AbstractC8143m.this.m50419o()) {
                return;
            }
            AbstractC7185ho.m43821b("PPSBaseView", "meet, diffX: %s, diffY: %s, diffZ: %s, limit: %s", Double.valueOf(AbstractC8143m.this.f37991l), Double.valueOf(AbstractC8143m.this.f37994o), Double.valueOf(AbstractC8143m.this.f37997r), Integer.valueOf(AbstractC8143m.this.f38002w));
            AbstractC8143m.this.m50413l();
            MaterialClickInfo materialClickInfoM44535a = new MaterialClickInfo.C7296a().m44539c((Integer) 2).m44538b(AbstractC8143m.this.getWidth() + "*" + AbstractC8143m.this.getHeight()).m44531a(Float.valueOf(AbstractC7807d.m48245j(AbstractC8143m.this.getContext()))).m44535a();
            AbstractC8143m abstractC8143m4 = AbstractC8143m.this;
            abstractC8143m4.f37980a.mo46111a(0, 0, abstractC8143m4.f37982c, abstractC8143m4.f37986g, materialClickInfoM44535a, 19);
            AbstractC8143m.this.f37981b.mo45610a(EnumC7480mo.CLICK);
        }
    }

    public AbstractC8143m(Context context) {
        super(context);
        this.f37981b = new C7405lo();
        this.f37985f = false;
        this.f37986g = null;
        this.f38000u = false;
        this.f37976F = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.m.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return AbstractC8143m.this.m50392a(view, motionEvent);
            }
        };
        this.f37977G = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.m.2

            /* renamed from: b */
            private float f38008b;

            /* renamed from: c */
            private float f38009c;

            /* renamed from: a */
            private boolean m50431a(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.f38008b = motionEvent.getX();
                    this.f38009c = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseView", "startX = %s, startY = %s", Float.valueOf(this.f38008b), Float.valueOf(this.f38009c));
                    }
                    AbstractC8143m abstractC8143m = AbstractC8143m.this;
                    abstractC8143m.f37975E = C7694tp.m47286b(abstractC8143m, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    AbstractC8143m.this.f38000u = true;
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseView", " endX= %s, endY = %s, startX - endX= %s, startY - endY= %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.f38008b - x10), Float.valueOf(this.f38009c - y10));
                    }
                    if (C7822do.m48382a(AbstractC8143m.this.f37974D, AbstractC8143m.this.f38001v, this.f38008b - x10, this.f38009c - y10)) {
                        C7694tp.m47287b(AbstractC8143m.this, motionEvent, 1, AbstractC8143m.this.f37975E);
                        AbstractC8143m.this.setOnTouchListener(null);
                        AbstractC8143m abstractC8143m2 = AbstractC8143m.this;
                        abstractC8143m2.f37980a.mo46111a(0, 0, abstractC8143m2.f37982c, abstractC8143m2.f37986g, AbstractC8143m.this.f37975E, 18);
                        AbstractC8143m.this.f37975E = null;
                        AbstractC8143m.this.f37981b.mo45610a(EnumC7480mo.CLICK);
                    }
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return m50431a(motionEvent);
            }
        };
        this.f37978H = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.m.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AbstractC8143m.this.f38000u = true;
                }
                return true;
            }
        };
        this.f37979I = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.m.4
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                InterfaceC7328jb interfaceC7328jb = AbstractC8143m.this.f37984e;
                if (interfaceC7328jb != null) {
                    interfaceC7328jb.mo45182i();
                }
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                AbstractC8143m.this.mo50430f();
                if (AbstractC8143m.this.f37986g == null) {
                    AbstractC7185ho.m43823c("PPSBaseView", "onViewShowEnd - no adShowStartTime");
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - AbstractC8143m.this.f37986g.longValue();
                AbstractC8143m abstractC8143m = AbstractC8143m.this;
                P p10 = abstractC8143m.f37980a;
                if (p10 != null) {
                    p10.mo46114a(abstractC8143m.f37982c, jCurrentTimeMillis, 100);
                    AbstractC8143m.this.f37980a.mo46120c();
                }
                AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.m.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC8143m.this.f37981b.mo45613b();
                    }
                }, 150L);
                AbstractC8143m.this.f37986g = null;
            }
        };
        setOnTouchListener(this.f37976F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public double m50395b(double d10, double d11) {
        if (Math.abs(d10) < this.f38002w || Math.abs(d11) < this.f38002w) {
            return 0.0d;
        }
        return Math.abs(d10) + Math.abs(d11);
    }

    /* renamed from: q */
    private boolean m50422q() {
        AbstractC7185ho.m43818a("PPSBaseView", "acceptableAngle: diffDegreeX: %s, diffDegreeY: %s, diffDegreeZ: %s, limitDegree: %s", Double.valueOf(this.f37991l), Double.valueOf(this.f37994o), Double.valueOf(this.f37997r), Integer.valueOf(this.f38002w));
        double d10 = this.f37991l;
        double d11 = this.f37990k;
        return d10 >= d11 || this.f37994o >= d11 || this.f37997r >= d11;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        AbstractC7185ho.m43817a("PPSBaseView", RewardMethods.DESTROY_VIEW);
        m50413l();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    public InterfaceC7328jb getAdMediator() {
        return this.f37984e;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f37979I;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45301h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b("PPSBaseView", "detached from window");
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f37979I;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45302i();
        }
        this.f37981b.mo45613b();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f37979I;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45303j();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    public void setAdContent(ContentRecord contentRecord) {
        int iIntValue;
        this.f37982c = contentRecord;
        if (contentRecord.m41459aK() != null) {
            InteractCfg interactCfgM41459aK = contentRecord.m41459aK();
            this.f38001v = (interactCfgM41459aK.m40201b() == null || interactCfgM41459aK.m40201b().intValue() <= 0) ? C7124fh.m43316b(getContext()).mo43032J() : interactCfgM41459aK.m40201b().intValue();
            this.f38003x = interactCfgM41459aK.m40204c() != null ? interactCfgM41459aK.m40204c().intValue() : C7124fh.m43316b(getContext()).mo43035M();
            this.f38002w = interactCfgM41459aK.m40207d() != null ? interactCfgM41459aK.m40207d().intValue() : C7124fh.m43316b(getContext()).mo43034L();
            this.f37974D = interactCfgM41459aK.m40215g().intValue();
            iIntValue = interactCfgM41459aK.m40210e().intValue();
        } else {
            this.f38001v = C7124fh.m43316b(getContext()).mo43032J();
            this.f38003x = C7124fh.m43316b(getContext()).mo43035M();
            this.f38002w = C7124fh.m43316b(getContext()).mo43034L();
            iIntValue = 0;
        }
        this.f38004y = iIntValue;
        this.f37990k = this.f38002w * 2;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    public void setAdMediator(InterfaceC7328jb interfaceC7328jb) {
        this.f37984e = interfaceC7328jb;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    public void setAudioFocusType(int i10) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    public void setDisplayDuration(int i10) {
        this.f37983d = i10;
    }

    /* renamed from: j */
    private void m50409j() {
        AbstractC7185ho.m43820b("PPSBaseView", "setAccListener");
        if (this.f37989j == null) {
            AbstractC7185ho.m43820b("PPSBaseView", "new setAccListener");
            C7639ro c7639ro = new C7639ro(getContext());
            this.f37989j = c7639ro;
            c7639ro.m47104a(new a());
            this.f37989j.m47103a();
        }
    }

    /* renamed from: k */
    private void m50411k() {
        AbstractC7185ho.m43820b("PPSBaseView", "setRotationListener");
        if (this.f37988i == null) {
            AbstractC7185ho.m43820b("PPSBaseView", " new setRotationListener");
            C7640rp c7640rp = new C7640rp(getContext());
            this.f37988i = c7640rp;
            c7640rp.m47108a(new b());
            this.f37988i.m47107a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m50413l() {
        AbstractC7185ho.m43820b("PPSBaseView", "stopListener");
        m50415m();
        m50417n();
    }

    /* renamed from: m */
    private void m50415m() {
        AbstractC7185ho.m43820b("PPSBaseView", "resetDegree");
        this.f37971A = null;
        this.f37972B = null;
        this.f37973C = null;
        this.f37991l = 0.0d;
        this.f37992m = 0.0d;
        this.f37993n = 0.0d;
        this.f37994o = 0.0d;
        this.f37995p = 0.0d;
        this.f37996q = 0.0d;
        this.f37997r = 0.0d;
        this.f37998s = 0.0d;
        this.f37999t = 0.0d;
        this.f38005z = 0.0f;
    }

    /* renamed from: n */
    private void m50417n() {
        AbstractC7185ho.m43817a("PPSBaseView", "releaseSensor");
        C7639ro c7639ro = this.f37989j;
        if (c7639ro != null) {
            c7639ro.m47105b();
        }
        C7640rp c7640rp = this.f37988i;
        if (c7640rp != null) {
            c7640rp.m47109b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public boolean m50419o() {
        AbstractC7185ho.m43818a("PPSBaseView", "interactiveLogic is %s", Integer.valueOf(this.f38004y));
        return this.f38004y == 1 ? m50421p() && m50422q() : m50421p() || m50422q();
    }

    /* renamed from: p */
    private boolean m50421p() {
        AbstractC7185ho.m43818a("PPSBaseView", "acceptableAcceleration: sqrtAcc: %s, limitAcc: %s", Float.valueOf(this.f38005z), Integer.valueOf(this.f38003x));
        return this.f38005z >= ((float) this.f38003x);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: d */
    public void mo50316d() {
        this.f37984e.mo45192s();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: e */
    public boolean mo50317e() {
        return false;
    }

    /* renamed from: f */
    public void mo50430f() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: g */
    public void mo50318g() {
        P p10 = this.f37980a;
        if (p10 != null) {
            p10.mo46115a(this.f37986g);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: h */
    public void mo50319h() {
        P p10 = this.f37980a;
        if (p10 != null) {
            p10.mo46118b(this.f37986g);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: i */
    public boolean mo50320i() {
        int iM46487z = AbstractC7558os.m46487z(this.f37982c.m41427W());
        if (1 == iM46487z) {
            return this.f37980a.mo46121h();
        }
        if (2 == iM46487z) {
            return this.f37980a.mo46121h() && this.f38000u;
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: c */
    public void mo50314c() {
        AbstractC7185ho.m43820b("PPSBaseView", "notifyAdLoaded");
        this.f37985f = true;
        this.f37986g = Long.valueOf(System.currentTimeMillis());
        this.f37984e.mo45152a(this.f37982c);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: b */
    public void mo50313b() {
        AbstractC7185ho.m43820b("PPSBaseView", "show ad");
        this.f37980a.mo46113a(this.f37982c);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: c */
    public void mo50315c(int i10) {
        this.f37984e.mo45177f(i10);
    }

    /* renamed from: b */
    public void m50429b(int i10) {
        this.f37984e.mo45168c(i10);
    }

    /* renamed from: a */
    public void m50428a() {
        this.f37984e.mo45209B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50389a(double d10, double d11, double d12) {
        if (d10 - this.f37971A.intValue() < 0.0d && m50391a(this.f37992m, d10 - this.f37971A.intValue())) {
            this.f37992m = Math.min(this.f37992m, d10 - this.f37971A.intValue());
        } else if (m50391a(this.f37993n, d10 - this.f37971A.intValue())) {
            this.f37993n = Math.max(this.f37993n, d10 - this.f37971A.intValue());
        }
        if (d11 - this.f37972B.intValue() < 0.0d && m50391a(this.f37995p, d11 - this.f37972B.intValue())) {
            this.f37995p = Math.min(this.f37995p, d11 - this.f37972B.intValue());
        } else if (m50391a(this.f37996q, d11 - this.f37972B.intValue())) {
            this.f37996q = Math.max(this.f37996q, d11 - this.f37972B.intValue());
        }
        if (d12 - this.f37973C.intValue() < 0.0d && m50391a(this.f37998s, d12 - this.f37973C.intValue())) {
            this.f37998s = Math.min(this.f37998s, d12 - this.f37973C.intValue());
        } else if (m50391a(this.f37999t, d12 - this.f37973C.intValue())) {
            this.f37999t = Math.max(this.f37999t, d12 - this.f37973C.intValue());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: a */
    public void mo50309a(int i10) {
        this.f37984e.mo45164b(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: a */
    public void mo50310a(int i10, int i11) {
        AbstractC7185ho.m43820b("PPSBaseView", "user click skip button");
        this.f37980a.mo46112a(i10, i11, this.f37986g);
        this.f37981b.mo45623j();
        this.f37981b.mo45613b();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: a */
    public void mo50311a(View view, Integer num) {
        this.f37987h = view;
        if (view != null) {
            view.setOnTouchListener(this.f37976F);
        }
        ContentRecord contentRecord = this.f37982c;
        String strM41427W = contentRecord == null ? null : contentRecord.m41427W();
        int iM46475n = AbstractC7558os.m46475n(strM41427W);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSBaseView", "ctrlswitch:%s", strM41427W);
            AbstractC7185ho.m43818a("PPSBaseView", "splashpro mode:%d, splashInteractCfg: %s", Integer.valueOf(iM46475n), num);
        }
        if (iM46475n == 2) {
            setOnTouchListener(this.f37978H);
            if (num == null) {
                return;
            }
            if (1 == num.intValue() || 4 == num.intValue()) {
                setOnTouchListener(this.f37977G);
                if (this.f37987h == null || 1 != num.intValue()) {
                    return;
                }
                this.f37987h.setOnTouchListener(null);
                return;
            }
            if (2 == num.intValue() || 3 == num.intValue()) {
                setOnTouchListener(this.f37978H);
                m50409j();
                m50411k();
                if (this.f37987h == null || 2 != num.intValue()) {
                    return;
                }
                this.f37987h.setOnTouchListener(null);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: a */
    public void mo50312a(InterfaceC7416lz interfaceC7416lz) {
        if (interfaceC7416lz != null) {
            this.f37981b = interfaceC7416lz;
        }
    }

    /* renamed from: a */
    private boolean m50391a(double d10, double d11) {
        return ((double) this.f38002w) > Math.abs(d11) || Math.abs(d10) > Math.abs(d11) / 2.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m50392a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return true;
        }
        setOnTouchListener(null);
        view.setEnabled(false);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSBaseView", "touch down image x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
        }
        MaterialClickInfo materialClickInfoM47286b = C7694tp.m47286b(view, motionEvent);
        if (materialClickInfoM47286b != null) {
            materialClickInfoM47286b.m44509c(0);
            materialClickInfoM47286b.m44502a(Float.valueOf(AbstractC7807d.m48245j(getContext())));
        }
        P p10 = this.f37980a;
        int i10 = (int) rawX;
        int i11 = (int) rawY;
        ContentRecord contentRecord = this.f37982c;
        p10.mo46111a(i10, i11, contentRecord, this.f37986g, materialClickInfoM47286b, 2 == AbstractC7558os.m46475n(contentRecord.m41427W()) ? 17 : 7);
        this.f37981b.mo45610a(EnumC7480mo.CLICK);
        return true;
    }
}
