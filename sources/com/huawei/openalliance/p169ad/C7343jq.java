package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.baidu.location.p065a.C1529a;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.views.VideoView;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.jq */
/* loaded from: classes8.dex */
public class C7343jq implements InterfaceC7342jp {

    /* renamed from: a */
    private WeakReference<View> f34225a;

    /* renamed from: b */
    private final List<String> f34226b;

    /* renamed from: c */
    private final List<String> f34227c;

    /* renamed from: e */
    private final C7560ou f34229e;

    /* renamed from: f */
    private final ContentRecord f34230f;

    /* renamed from: h */
    private int f34232h;

    /* renamed from: i */
    private long f34233i;

    /* renamed from: j */
    private long f34234j;

    /* renamed from: k */
    private long f34235k;

    /* renamed from: l */
    private int f34236l;

    /* renamed from: o */
    private AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh f34239o;

    /* renamed from: d */
    private final EnumC7338jl f34228d = EnumC7338jl.m45325a();

    /* renamed from: g */
    private final boolean[] f34231g = new boolean[5];

    /* renamed from: m */
    private final String f34237m = Constants.IMP_EVENT_MONITOR_ID + hashCode();

    /* renamed from: n */
    private boolean f34238n = false;

    public C7343jq(List<String> list, List<String> list2, C7560ou c7560ou, ContentRecord contentRecord) {
        this.f34226b = list;
        this.f34227c = list2;
        this.f34229e = c7560ou;
        this.f34230f = contentRecord;
        m45366c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String m45367d() {
        return AbstractC7741ao.m47561b(C1529a.f6579e) + "-" + this.f34230f.m41588n() + "-" + this.f34230f.m41591o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m45369e() {
        if (this.f34238n) {
            return;
        }
        this.f34238n = true;
        this.f34234j = AbstractC7741ao.m47566c();
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.jq.4
            @Override // java.lang.Runnable
            public void run() {
                C7343jq.this.m45359a(AbstractC7741ao.m47566c() - C7343jq.this.f34234j, C7343jq.this.f34236l, -1);
            }
        }, this.f34237m, this.f34233i);
    }

    /* renamed from: k */
    private String m45381k() {
        if (m45383l() instanceof InterfaceC7337jk) {
            return AbstractC7811dd.m48288a((InterfaceC7337jk) m45383l());
        }
        AbstractC7185ho.m43823c(m45386m(), "getSlotPosition failed, view is not IView");
        return "";
    }

    /* renamed from: l */
    private View m45383l() {
        WeakReference<View> weakReference = this.f34225a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: b */
    public void mo45354b() {
        this.f34228d.m45334a(this.f34226b);
        this.f34228d.m45334a(this.f34227c);
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f34239o;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45302i();
            this.f34239o = null;
        }
    }

    /* renamed from: c */
    private void m45366c() {
        ContentRecord contentRecord = this.f34230f;
        if (contentRecord == null) {
            this.f34232h = 50;
            this.f34233i = 1000L;
            return;
        }
        this.f34232h = contentRecord.m41539d();
        this.f34233i = this.f34230f.m41531c();
        AbstractC7185ho.m43821b(m45386m(), "showRatio %s, showTime %s.", Integer.valueOf(this.f34232h), Long.valueOf(this.f34233i));
        if (this.f34232h == 0) {
            this.f34232h = 50;
        }
        if (this.f34233i == 0) {
            this.f34233i = 1000L;
        }
        if (this.f34232h > 100) {
            this.f34232h = 100;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m45372f() {
        int i10;
        if (this.f34238n) {
            this.f34238n = false;
            AbstractC7817dj.m48366a(this.f34237m);
            long jM47566c = AbstractC7741ao.m47566c() - this.f34234j;
            if (jM47566c <= this.f34233i || (i10 = this.f34236l) < this.f34232h) {
                return;
            }
            m45359a(jM47566c, i10, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m45374g() {
        boolean[] zArr = this.f34231g;
        if (zArr[3]) {
            return;
        }
        zArr[3] = true;
        AbstractC7185ho.m43820b(m45386m(), "callMzOnImp");
        this.f34228d.m45335a(this.f34226b, m45383l(), this.f34230f);
    }

    /* renamed from: h */
    private void m45376h() {
        boolean[] zArr = this.f34231g;
        if (zArr[4]) {
            return;
        }
        zArr[4] = true;
        AbstractC7185ho.m43820b(m45386m(), "callMzClick");
        this.f34228d.m45336a(this.f34227c, this.f34230f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m45378i() {
        if (this.f34231g[0]) {
            return;
        }
        this.f34230f.m41560g(this.f34235k);
        this.f34230f.m41536c(String.valueOf(this.f34235k));
        this.f34229e.mo46590a(this.f34230f);
        AbstractC7185ho.m43820b(m45386m(), "callHwShowStart");
        C7560ou c7560ou = this.f34229e;
        if (c7560ou != null) {
            c7560ou.mo46606b();
            this.f34231g[0] = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m45380j() {
        ContentRecord contentRecord = this.f34230f;
        return C7780c.m47866a(contentRecord == null ? null : contentRecord.m41514ba());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public String m45386m() {
        return "ImageMzMonitor_" + hashCode();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: a */
    public void mo45351a() {
        m45374g();
        m45376h();
        m45359a(AbstractC7741ao.m47566c() - this.f34235k, this.f34236l, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45358a(long j10, int i10) {
        if (this.f34231g[2]) {
            return;
        }
        AbstractC7185ho.m43821b(m45386m(), "callHwPhyShow, %s, %s", Long.valueOf(j10), Integer.valueOf(i10));
        C7560ou c7560ou = this.f34229e;
        if (c7560ou != null) {
            c7560ou.mo46581a(j10, i10);
            this.f34231g[2] = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45359a(long j10, int i10, int i11) {
        if (this.f34231g[1]) {
            return;
        }
        AbstractC7185ho.m43821b(m45386m(), "callHwShow, %s, %s", Long.valueOf(j10), Integer.valueOf(i10));
        C7586a.a aVarM46875a = new C7586a.a().m46873a(Integer.valueOf(i10)).m46874a(Long.valueOf(j10)).m46885e(C8190vl.m50727b(m45383l())).m46884d(m45381k()).m46875a(C7753b.m47700a(m45383l()));
        if (i11 != -1) {
            aVarM46875a.m46878b(Integer.valueOf(i11));
        }
        C7560ou c7560ou = this.f34229e;
        if (c7560ou != null) {
            c7560ou.mo46593a(aVarM46875a.m46877a());
            this.f34231g[1] = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45360a(final Context context, final String str) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.jq.3
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).mo39119b(str, "task support mz but has impSmartCtrl", C7343jq.this.f34230f);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: a */
    public void mo45352a(final View view) {
        AbstractC7185ho.m43821b(m45386m(), "setContainerView, view is %s", view.getClass().getSimpleName());
        this.f34225a = new WeakReference<>(view);
        this.f34239o = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this.f34225a.get()) { // from class: com.huawei.openalliance.ad.jq.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                super.mo45252a();
                AbstractC7185ho.m43820b(C7343jq.this.m45386m(), "onViewShowStart");
                if (C7343jq.this.m45380j()) {
                    C7343jq.this.m45360a(view.getContext(), C7343jq.this.m45367d());
                }
                C7343jq.this.f34235k = AbstractC7741ao.m47566c();
                C7343jq.this.m45374g();
                C7343jq.this.m45378i();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45253a(int i10) {
                super.mo45253a(i10);
                AbstractC7185ho.m43818a(C7343jq.this.m45386m(), "onUpdateViewShowArea, %s", Integer.valueOf(i10));
                if (i10 > C7343jq.this.f34236l) {
                    C7343jq.this.f34236l = i10;
                }
                int i11 = C7343jq.this.f34232h;
                C7343jq c7343jq = C7343jq.this;
                if (i10 >= i11) {
                    c7343jq.m45369e();
                } else {
                    c7343jq.m45372f();
                }
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                super.mo45254a(j10, i10);
                AbstractC7185ho.m43821b(C7343jq.this.m45386m(), "onViewShowEnd, %s, %s", Long.valueOf(j10), Integer.valueOf(i10));
                AbstractC7817dj.m48366a(C7343jq.this.f34237m);
                C7343jq.this.m45358a(j10, i10);
                if (j10 <= C7343jq.this.f34233i || i10 < C7343jq.this.f34232h) {
                    return;
                }
                C7343jq.this.m45359a(j10, i10, -1);
            }
        };
        this.f34225a.get().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.huawei.openalliance.ad.jq.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                String strM45386m = C7343jq.this.m45386m();
                Object[] objArr = new Object[1];
                objArr[0] = C7343jq.this.f34239o == null ? "not null" : "null";
                AbstractC7185ho.m43821b(strM45386m, "onViewAttachedToWindow, viewMonitor is %s", objArr);
                if (C7343jq.this.f34239o != null) {
                    C7343jq.this.f34239o.m45301h();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                String strM45386m = C7343jq.this.m45386m();
                Object[] objArr = new Object[1];
                objArr[0] = C7343jq.this.f34239o == null ? "not null" : "null";
                AbstractC7185ho.m43821b(strM45386m, "onViewDetachedFromWindow, viewMonitor is %s", objArr);
                if (C7343jq.this.f34239o != null) {
                    AbstractC7185ho.m43817a(C7343jq.this.m45386m(), "viewMonitor is not null, call onViewDetachedFromWindow");
                    C7343jq.this.f34239o.m45302i();
                }
            }
        });
        if (this.f34239o != null) {
            AbstractC7185ho.m43817a(m45386m(), "viewMonitor is not null, call onViewAttachedToWindow");
            this.f34239o.m45301h();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7342jp
    /* renamed from: a */
    public void mo45353a(VideoView videoView) {
    }
}
