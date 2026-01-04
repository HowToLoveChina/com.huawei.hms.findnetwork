package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7089ee;
import com.huawei.openalliance.p169ad.C7090ef;
import com.huawei.openalliance.p169ad.C7091eg;
import com.huawei.openalliance.p169ad.C7092eh;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.BaseVideoView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u;

/* renamed from: com.huawei.openalliance.ad.views.b */
/* loaded from: classes2.dex */
public abstract class AbstractC8078b extends BaseVideoView implements InterfaceC8128u {

    /* renamed from: A */
    private volatile boolean f37557A;

    /* renamed from: a */
    protected final C7091eg f37558a;

    /* renamed from: b */
    protected C7089ee f37559b;

    /* renamed from: c */
    protected C7092eh f37560c;

    /* renamed from: d */
    protected int f37561d;

    /* renamed from: e */
    protected int f37562e;

    /* renamed from: f */
    protected C8099g f37563f;

    /* renamed from: g */
    protected Integer f37564g;

    /* renamed from: h */
    protected Integer f37565h;

    /* renamed from: i */
    protected volatile Float f37566i;

    /* renamed from: j */
    protected volatile boolean f37567j;

    /* renamed from: y */
    private final C7090ef f37568y;

    /* renamed from: z */
    private float[] f37569z;

    public AbstractC8078b(Context context) {
        super(context);
        C7090ef c7090ef = new C7090ef();
        this.f37568y = c7090ef;
        this.f37558a = new C7091eg(c7090ef);
        this.f37567j = false;
        this.f37569z = new float[16];
        this.f37557A = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m50077j() {
        if (this.f37560c == null || this.f37559b == null) {
            AbstractC7185ho.m43824c(getLogTag(), "render failed, textureProgram:%s, windowSurface:%s", AbstractC7806cz.m48162b(this.f37560c), AbstractC7806cz.m48162b(this.f37559b));
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        if (this.f37557A) {
            this.f37558a.m42902a(this.f37560c, this.f37569z);
            this.f37559b.m42889d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m50078k() {
        AbstractC7185ho.m43820b(getLogTag(), "onSurfaceDestroyed");
        this.f36362m = false;
        m50079a();
    }

    /* renamed from: a */
    public void m50079a() {
        m50082a(new Runnable() { // from class: com.huawei.openalliance.ad.views.b.1
            @Override // java.lang.Runnable
            public void run() {
                C7089ee c7089ee = AbstractC8078b.this.f37559b;
                if (c7089ee != null) {
                    c7089ee.m42890e();
                    AbstractC8078b.this.f37559b = null;
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u
    /* renamed from: b */
    public void mo48803b() {
        this.f37557A = true;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u
    /* renamed from: c */
    public void mo48804c() {
        if (this.f37567j) {
            AbstractC7185ho.m43823c(getLogTag(), "renderVideo, destroyed");
        } else {
            m50082a(new Runnable() { // from class: com.huawei.openalliance.ad.views.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AbstractC8078b.this.f37567j) {
                            AbstractC7185ho.m43823c(AbstractC8078b.this.getLogTag(), "renderVideo, destroyed");
                            return;
                        }
                        SurfaceTexture surfaceTexture = AbstractC8078b.this.f36366q;
                        if (surfaceTexture != null) {
                            surfaceTexture.updateTexImage();
                        }
                        AbstractC8078b abstractC8078b = AbstractC8078b.this;
                        if (abstractC8078b.f37559b != null) {
                            GLES20.glViewport(0, 0, abstractC8078b.f37561d, abstractC8078b.f37562e);
                            AbstractC8078b.this.f37559b.m42888c();
                            AbstractC8078b.this.m50077j();
                        }
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43813a(3, AbstractC8078b.this.getLogTag(), "render exception", th2);
                    }
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView
    /* renamed from: d */
    public void mo48790d() {
        m50082a(new Runnable() { // from class: com.huawei.openalliance.ad.views.b.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        super.destroyView();
        this.f37567j = true;
        this.f37557A = false;
        m50079a();
    }

    /* renamed from: e */
    public void m50084e() {
        m50082a(new Runnable() { // from class: com.huawei.openalliance.ad.views.b.4
            @Override // java.lang.Runnable
            public void run() {
                AbstractC8078b.this.m50078k();
            }
        });
    }

    public abstract String getLogTag();

    public void setVideoRatio(Float f10) {
        AbstractC7185ho.m43818a(getLogTag(), "setVideoRatio %s", f10);
        this.f37566i = f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m50075d(int i10, int i11) {
        AbstractC7185ho.m43820b(getLogTag(), "onSurfaceChanged");
        m50076e(i10, i11);
    }

    /* renamed from: e */
    private void m50076e(int i10, int i11) {
        this.f37561d = i10;
        this.f37562e = i11;
        m50080a(i10, i11);
        if (this.f37566i != null) {
            float fFloatValue = this.f37566i.floatValue();
            int i12 = this.f37561d;
            int i13 = this.f37562e;
            mo48785a(fFloatValue, i12 / i13, i12, i13);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView
    /* renamed from: a */
    public void mo48785a(float f10, float f11, int i10, int i11) {
        int i12 = this.f36368s;
        if (i12 == 1) {
            m50080a(this.f37561d, this.f37562e);
            return;
        }
        if (i12 != 2) {
            return;
        }
        if (f11 < f10) {
            this.f37565h = Integer.valueOf(i11);
            this.f37564g = Integer.valueOf((int) (i11 * f10));
        } else {
            this.f37564g = Integer.valueOf(i10);
            this.f37565h = Integer.valueOf((int) (i10 / f10));
        }
        this.f37558a.m42900a(this.f37564g.intValue(), this.f37565h.intValue());
    }

    /* renamed from: b */
    public void m50083b(final int i10, final int i11) {
        m50082a(new Runnable() { // from class: com.huawei.openalliance.ad.views.b.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractC8078b.this.m50075d(i10, i11);
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.b.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC8078b abstractC8078b = AbstractC8078b.this;
                        abstractC8078b.f36373x.m48795a(abstractC8078b.f36371v, abstractC8078b.f36372w);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m50073b(Surface surface) {
        AbstractC7185ho.m43820b(getLogTag(), "onSurfaceAvailable");
        this.f36362m = true;
        if (this.f37563f != null && surface != null && surface.isValid()) {
            try {
                this.f37563f.m50170b();
                C7089ee c7089ee = new C7089ee(this.f37563f.m50176g(), surface);
                this.f37559b = c7089ee;
                c7089ee.m42888c();
                this.f37563f.m50167a();
                this.f36365p = this.f37563f.m50172c();
                this.f37560c = this.f37563f.m50175f();
                this.f37558a.m42901a(this.f37563f.m50173d());
                this.f36366q = this.f37563f.m50174e();
                this.f36363n.setSurface(this.f36365p);
                m50076e(this.f37559b.m42886a(), this.f37559b.m42887b());
                if (this.f36370u == null) {
                    BaseVideoView.C7898h c7898h = new BaseVideoView.C7898h(this.f36373x);
                    this.f36370u = c7898h;
                    this.f36363n.setVideoSizeChangeListener(c7898h);
                }
                if (this.f36361l) {
                    play(this.f36367r);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c(getLogTag(), "exception: %s", th2.getClass().getSimpleName());
            }
        }
        mo48804c();
    }

    /* renamed from: a */
    public void m50080a(int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
        float f10 = i10;
        float f11 = i11;
        Matrix.orthoM(this.f37569z, 0, 0.0f, f10, 0.0f, f11, -1.0f, 1.0f);
        float f12 = f10 / 2.0f;
        float f13 = f11 / 2.0f;
        Integer num = this.f37564g;
        if (num != null) {
            i10 = num.intValue();
        }
        Integer num2 = this.f37565h;
        if (num2 != null) {
            i11 = num2.intValue();
        }
        this.f37558a.m42900a(i10, i11);
        this.f37558a.m42903b(f12, f13);
    }

    /* renamed from: a */
    public void m50081a(final Surface surface) {
        m50082a(new Runnable() { // from class: com.huawei.openalliance.ad.views.b.6
            @Override // java.lang.Runnable
            public void run() {
                AbstractC8078b.this.m50073b(surface);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u
    /* renamed from: a */
    public void mo48802a(C8099g c8099g) {
        this.f37563f = c8099g;
        setMediaPlayerAgent(c8099g.m50177h());
    }

    /* renamed from: a */
    public void m50082a(Runnable runnable) {
        C8099g c8099g = this.f37563f;
        if (c8099g != null) {
            c8099g.m50169a(runnable);
        }
    }
}
