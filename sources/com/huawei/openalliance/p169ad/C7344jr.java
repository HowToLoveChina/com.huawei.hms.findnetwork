package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.views.VideoView;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.jr */
/* loaded from: classes8.dex */
public class C7344jr implements InterfaceC7342jp {

    /* renamed from: o */
    private static int f34247o;

    /* renamed from: p */
    private static int f34248p;

    /* renamed from: a */
    private WeakReference<View> f34249a;

    /* renamed from: b */
    private MediaStateListener f34250b;

    /* renamed from: c */
    private final List<String> f34251c;

    /* renamed from: d */
    private final List<String> f34252d;

    /* renamed from: f */
    private final C7560ou f34254f;

    /* renamed from: g */
    private final ContentRecord f34255g;

    /* renamed from: k */
    private int f34259k;

    /* renamed from: l */
    private long f34260l;

    /* renamed from: m */
    private int f34261m;

    /* renamed from: n */
    private int f34262n;

    /* renamed from: q */
    private long f34263q;

    /* renamed from: r */
    private AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh f34264r;

    /* renamed from: s */
    private VideoView f34265s;

    /* renamed from: t */
    private final boolean f34266t;

    /* renamed from: e */
    private final EnumC7338jl f34253e = EnumC7338jl.m45325a();

    /* renamed from: h */
    private int f34256h = 0;

    /* renamed from: i */
    private final boolean[] f34257i = new boolean[5];

    /* renamed from: j */
    private boolean f34258j = false;

    public C7344jr(List<String> list, List<String> list2, C7560ou c7560ou, ContentRecord contentRecord) {
        this.f34251c = list;
        this.f34252d = list2;
        this.f34254f = c7560ou;
        this.f34255g = contentRecord;
        m45401d();
        this.f34266t = m45395a(contentRecord);
    }

    /* renamed from: e */
    private String m45402e() {
        return AbstractC7741ao.m47561b(C1529a.f6579e) + "-" + this.f34255g.m41588n() + "-" + this.f34255g.m41591o();
    }

    /* renamed from: f */
    private boolean m45403f() {
        ContentRecord contentRecord = this.f34255g;
        return C7780c.m47866a(contentRecord == null ? null : contentRecord.m41514ba());
    }

    /* renamed from: g */
    private void m45404g() {
        if (this.f34257i[3]) {
            return;
        }
        AbstractC7185ho.m43820b(m45409l(), "callMzOnImp");
        this.f34253e.m45332a(1, this.f34251c, m45408k(), this.f34255g);
        this.f34257i[3] = true;
    }

    /* renamed from: h */
    private void m45405h() {
        boolean[] zArr = this.f34257i;
        if (zArr[4]) {
            return;
        }
        zArr[4] = true;
        AbstractC7185ho.m43820b(m45409l(), "callMzClick");
        this.f34253e.m45336a(this.f34252d, this.f34255g);
    }

    /* renamed from: i */
    private void m45406i() {
        if (this.f34257i[0]) {
            AbstractC7185ho.m43817a(m45409l(), "hasReport showStart");
            return;
        }
        this.f34255g.m41560g(this.f34263q);
        this.f34255g.m41536c(String.valueOf(this.f34263q));
        this.f34254f.mo46590a(this.f34255g);
        AbstractC7185ho.m43820b(m45409l(), "callHwShowStart");
        C7560ou c7560ou = this.f34254f;
        if (c7560ou != null) {
            c7560ou.mo46606b();
            this.f34257i[0] = true;
        }
    }

    /* renamed from: j */
    private String m45407j() {
        if (m45408k() instanceof InterfaceC7337jk) {
            return AbstractC7811dd.m48288a((InterfaceC7337jk) m45408k());
        }
        AbstractC7185ho.m43823c(m45409l(), "getSlotPosition failed, view is not IView");
        return "";
    }

    /* renamed from: k */
    private View m45408k() {
        WeakReference<View> weakReference = this.f34249a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public String m45409l() {
        return "VideoMzMonitor_" + hashCode();
    }

    /* renamed from: d */
    private void m45401d() {
        ContentRecord contentRecord = this.f34255g;
        if (contentRecord == null) {
            this.f34259k = 50;
            this.f34260l = RippleView.SINGLE_RIPPLE_TIME;
            this.f34262n = 50;
            return;
        }
        this.f34256h = contentRecord.m41581l();
        this.f34259k = this.f34255g.m41539d();
        this.f34260l = this.f34255g.m41531c();
        this.f34262n = this.f34255g.m41546e();
        AbstractC7185ho.m43821b(m45409l(), "exposeType %s, showRatio %s, showTime %s, percentage %s.", Integer.valueOf(this.f34256h), Integer.valueOf(this.f34259k), Long.valueOf(this.f34260l), Integer.valueOf(this.f34262n));
        if (this.f34259k == 0) {
            this.f34259k = 50;
        }
        if (this.f34260l == 0) {
            this.f34260l = RippleView.SINGLE_RIPPLE_TIME;
        }
        if (this.f34262n == 0) {
            this.f34262n = 50;
        }
        if (this.f34259k > 100) {
            this.f34259k = 100;
        }
    }

    /* renamed from: c */
    public void m45411c() {
        AbstractC7185ho.m43821b(m45409l(), "hasShowStart %s", Boolean.valueOf(this.f34258j));
        this.f34263q = AbstractC7741ao.m47566c();
        if (m45403f()) {
            m45393a(this.f34249a.get().getContext(), m45402e());
        }
        if (this.f34258j) {
            m45406i();
            if (this.f34266t) {
                return;
            }
            m45404g();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: b */
    public void mo45354b() {
        this.f34253e.m45334a(this.f34251c);
        this.f34253e.m45334a(this.f34252d);
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f34264r;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45302i();
            this.f34264r = null;
        }
        VideoView videoView = this.f34265s;
        if (videoView != null) {
            videoView.removeMediaStateListener(this.f34250b);
            this.f34265s = null;
            this.f34250b = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: a */
    public void mo45351a() {
        m45404g();
        m45405h();
        m45392a(f34247o, this.f34261m, 1);
    }

    /* renamed from: a */
    public void m45410a(int i10, int i11) {
        AbstractC7185ho.m43818a(m45409l(), "doOnProgress, maxShowArea %s, percentage %s, playTime is %s", Integer.valueOf(this.f34261m), Integer.valueOf(i10), Integer.valueOf(i11));
        f34247o = i11;
        f34248p = i10;
        if (this.f34261m >= this.f34259k) {
            int i12 = this.f34256h;
            if ((i12 == 2 || i11 <= this.f34260l) && (i12 != 2 || i10 < this.f34262n)) {
                return;
            }
            m45404g();
            m45392a(i11, this.f34261m, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45391a(long j10, int i10) {
        if (this.f34257i[2]) {
            AbstractC7185ho.m43817a(m45409l(), "hasReport phyShow");
            return;
        }
        AbstractC7185ho.m43821b(m45409l(), "callHwPhyShow, %s, %s", Long.valueOf(j10), Integer.valueOf(i10));
        if (this.f34254f != null) {
            C7559ot c7559ot = new C7559ot();
            c7559ot.m46489a(Integer.valueOf(f34248p));
            c7559ot.m46491b(Integer.valueOf(f34247o));
            this.f34254f.mo46582a(j10, i10, c7559ot);
            this.f34257i[2] = true;
        }
    }

    /* renamed from: a */
    private void m45392a(long j10, int i10, int i11) {
        if (this.f34257i[1]) {
            AbstractC7185ho.m43817a(m45409l(), "hasReport Imp");
            return;
        }
        AbstractC7185ho.m43821b(m45409l(), "callHwShow, %s, %s", Long.valueOf(j10), Integer.valueOf(i10));
        C7586a.a aVarM46885e = new C7586a.a().m46873a(Integer.valueOf(i10)).m46874a(Long.valueOf(j10)).m46875a(C7753b.m47700a(m45408k())).m46884d(m45407j()).m46885e(C8190vl.m50727b(m45408k()));
        if (i11 != -1) {
            aVarM46885e.m46878b(Integer.valueOf(i11));
        }
        C7560ou c7560ou = this.f34254f;
        if (c7560ou != null) {
            c7560ou.mo46593a(aVarM46885e.m46877a());
            this.f34257i[1] = true;
        }
    }

    /* renamed from: a */
    private void m45393a(final Context context, final String str) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.jr.2
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).mo39119b(str, "task support mz but has impSmartCtrl", C7344jr.this.f34255g);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: a */
    public void mo45352a(View view) {
        AbstractC7185ho.m43821b(m45409l(), "setContainerView, view is %s", view.getClass().getSimpleName());
        this.f34249a = new WeakReference<>(view);
        if (view instanceof VideoView) {
            mo45353a((VideoView) view);
        }
        this.f34264r = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this.f34249a.get()) { // from class: com.huawei.openalliance.ad.jr.3
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                super.mo45252a();
                AbstractC7185ho.m43820b(C7344jr.this.m45409l(), "onViewShowStart.");
                C7344jr.this.f34258j = true;
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45253a(int i10) {
                super.mo45253a(i10);
                AbstractC7185ho.m43818a(C7344jr.this.m45409l(), "onUpdateViewShowArea, per %s", Integer.valueOf(i10));
                if (i10 > C7344jr.this.f34261m) {
                    C7344jr.this.f34261m = i10;
                }
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                super.mo45254a(j10, i10);
                AbstractC7185ho.m43821b(C7344jr.this.m45409l(), "onViewShowEnd, %s, %s", Long.valueOf(j10), Integer.valueOf(i10));
                if (i10 > C7344jr.this.f34261m) {
                    C7344jr.this.f34261m = i10;
                }
                C7344jr c7344jr = C7344jr.this;
                c7344jr.m45391a(j10, c7344jr.f34261m);
            }
        };
        this.f34249a.get().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.huawei.openalliance.ad.jr.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                String strM45409l = C7344jr.this.m45409l();
                Object[] objArr = new Object[1];
                objArr[0] = C7344jr.this.f34264r == null ? "null" : "not null";
                AbstractC7185ho.m43821b(strM45409l, "onViewAttachedToWindow, viewMonitor is %s", objArr);
                if (C7344jr.this.f34264r != null) {
                    C7344jr.this.f34264r.m45301h();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                String strM45409l = C7344jr.this.m45409l();
                Object[] objArr = new Object[1];
                objArr[0] = C7344jr.this.f34264r == null ? "null" : "not null";
                AbstractC7185ho.m43821b(strM45409l, "onViewDetachedFromWindow, viewMonitor is %s", objArr);
                if (C7344jr.this.f34264r != null) {
                    C7344jr.this.f34264r.m45302i();
                }
            }
        });
        String strM45409l = m45409l();
        Object[] objArr = new Object[1];
        objArr[0] = this.f34264r == null ? "null" : "not null";
        AbstractC7185ho.m43818a(strM45409l, "viewMonitor is %s", objArr);
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f34264r;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45301h();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: a */
    public void mo45353a(VideoView videoView) {
        if (videoView == null) {
            AbstractC7185ho.m43823c(m45409l(), "video view is null.");
            return;
        }
        AbstractC7185ho.m43820b(m45409l(), "set video view");
        this.f34265s = videoView;
        MediaStateListener mediaStateListener = new MediaStateListener() { // from class: com.huawei.openalliance.ad.jr.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                int unused = C7344jr.f34248p = 100;
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C7344jr.this.m45411c();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                C7344jr.this.m45410a(i10, i11);
                int unused = C7344jr.f34247o = i11;
                int unused2 = C7344jr.f34248p = i10;
            }
        };
        this.f34250b = mediaStateListener;
        this.f34265s.addMediaStateListener(mediaStateListener);
    }

    /* renamed from: a */
    private boolean m45395a(ContentRecord contentRecord) {
        return contentRecord != null && contentRecord.m41552f() == 60;
    }
}
