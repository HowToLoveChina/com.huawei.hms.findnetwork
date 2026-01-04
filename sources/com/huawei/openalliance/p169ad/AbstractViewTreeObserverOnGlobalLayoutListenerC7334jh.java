package com.huawei.openalliance.p169ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.jh */
/* loaded from: classes8.dex */
public abstract class AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: d */
    protected static final Map<View, AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh> f34169d = new ConcurrentHashMap();

    /* renamed from: b */
    private View f34171b;

    /* renamed from: c */
    private boolean f34172c;

    /* renamed from: e */
    private long f34173e;

    /* renamed from: f */
    private int f34174f;

    /* renamed from: k */
    private BroadcastReceiver f34179k;

    /* renamed from: a */
    private String f34170a = "ViewMonitor";

    /* renamed from: g */
    private Rect f34175g = new Rect();

    /* renamed from: h */
    private boolean f34176h = true;

    /* renamed from: i */
    private boolean f34177i = true;

    /* renamed from: j */
    private BroadcastReceiver f34178j = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.jh.1
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            AbstractC7185ho.m43821b(AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh.this.f34170a, "receive screen state: %s", action);
            if (TextUtils.equals("android.intent.action.SCREEN_ON", action) || TextUtils.equals("android.intent.action.SCREEN_OFF", action) || TextUtils.equals("android.intent.action.USER_PRESENT", action)) {
                AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh.this.m45298d();
                AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh.this.m45300f();
            }
        }
    };

    /* renamed from: com.huawei.openalliance.ad.jh$1 */
    public class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            AbstractC7185ho.m43821b(AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh.this.f34170a, "receive screen state: %s", action);
            if (TextUtils.equals("android.intent.action.SCREEN_ON", action) || TextUtils.equals("android.intent.action.SCREEN_OFF", action) || TextUtils.equals("android.intent.action.USER_PRESENT", action)) {
                AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh.this.m45298d();
                AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh.this.m45300f();
            }
        }
    }

    public AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(View view) {
        this.f34171b = view;
        m45294b();
    }

    /* renamed from: b */
    private void m45294b() {
        if (this.f34171b != null) {
            this.f34170a = this.f34171b.getClass().getSimpleName() + "ViewMonitor";
        }
    }

    /* renamed from: c */
    private void m45296c() {
        AbstractC7185ho.m43820b(this.f34170a, "registerObservers");
        View view = this.f34171b;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Map<View, AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh> map = f34169d;
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = map.get(this.f34171b);
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(abstractViewTreeObserverOnGlobalLayoutListenerC7334jh);
            viewTreeObserver.removeOnGlobalLayoutListener(abstractViewTreeObserverOnGlobalLayoutListenerC7334jh);
        }
        map.put(this.f34171b, this);
        if (this.f34177i && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f34179k = this.f34178j;
        HiAd.m44014a(this.f34171b.getContext()).mo44043a(this.f34179k, intentFilter);
        this.f34176h = true;
    }

    /* renamed from: d */
    public void m45298d() {
        Context context = this.f34171b.getContext();
        this.f34176h = AbstractC7811dd.m48301a(context) && !AbstractC7811dd.m48310b(context);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(this.f34170a, "checkScreenState screen available: %s ", Boolean.valueOf(this.f34176h));
        }
    }

    /* renamed from: e */
    private void m45299e() {
        AbstractC7185ho.m43820b(this.f34170a, "unregisterObservers");
        View view = this.f34171b;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.f34177i && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.removeOnScrollChangedListener(this);
        }
        this.f34171b.setOnSystemUiVisibilityChangeListener(null);
        if (this.f34179k != null) {
            HiAd.m44014a(this.f34171b.getContext()).mo44042a(this.f34179k);
            this.f34179k = null;
        }
        f34169d.remove(this.f34171b);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0046  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m45300f() {
        /*
            r4 = this;
            boolean r0 = r4.f34176h
            if (r0 == 0) goto L18
            android.view.View r0 = r4.f34171b
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L18
            android.view.View r0 = r4.f34171b
            android.graphics.Rect r1 = r4.f34175g
            boolean r0 = r0.getLocalVisibleRect(r1)
            if (r0 == 0) goto L18
            r0 = 1
            goto L19
        L18:
            r0 = 0
        L19:
            android.view.View r1 = r4.f34171b
            int r1 = r1.getWidth()
            android.view.View r2 = r4.f34171b
            int r2 = r2.getHeight()
            int r1 = r1 * r2
            if (r0 == 0) goto L46
            if (r1 <= 0) goto L46
            android.graphics.Rect r2 = r4.f34175g
            int r2 = r2.width()
            android.graphics.Rect r3 = r4.f34175g
            int r3 = r3.height()
            int r2 = r2 * r3
            int r2 = r2 * 100
            int r2 = r2 / r1
            int r1 = r4.f34174f
            if (r2 <= r1) goto L40
            r4.f34174f = r2
        L40:
            r4.mo45253a(r2)
            if (r2 > 0) goto L46
            goto L4c
        L46:
            if (r0 == 0) goto L4c
            r4.m45305l()
            goto L4f
        L4c:
            r4.m45306m()
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45300f():void");
    }

    /* renamed from: h */
    public void m45301h() {
        AbstractC7185ho.m43820b(this.f34170a, "onViewAttachedToWindow");
        m45296c();
        m45300f();
    }

    /* renamed from: i */
    public void m45302i() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(this.f34170a, "onViewDetachedFromWindow");
        }
        m45299e();
        m45306m();
    }

    /* renamed from: j */
    public void m45303j() {
        AbstractC7185ho.m43820b(this.f34170a, "onViewVisibilityChanged");
        m45300f();
    }

    /* renamed from: k */
    public int m45304k() {
        boolean z10 = this.f34176h && this.f34171b.isShown() && this.f34171b.getLocalVisibleRect(this.f34175g);
        int width = this.f34171b.getWidth() * this.f34171b.getHeight();
        if (!z10 || width <= 0) {
            return 0;
        }
        return ((this.f34175g.width() * this.f34175g.height()) * 100) / width;
    }

    /* renamed from: l */
    public void m45305l() {
        if (this.f34172c) {
            return;
        }
        AbstractC7185ho.m43820b(this.f34170a, "onViewShown");
        this.f34172c = true;
        this.f34173e = System.currentTimeMillis();
        mo45252a();
    }

    /* renamed from: m */
    public void m45306m() {
        if (this.f34172c) {
            AbstractC7185ho.m43820b(this.f34170a, "onViewHidden");
            this.f34172c = false;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f34173e;
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a(this.f34170a, "max physical visible area percentage: %d duration: %d", Integer.valueOf(this.f34174f), Long.valueOf(jCurrentTimeMillis));
            }
            mo45254a(jCurrentTimeMillis, this.f34174f);
            this.f34174f = 0;
        }
    }

    /* renamed from: n */
    public boolean m45307n() {
        return this.f34172c && this.f34171b.isShown();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(this.f34170a, "onGlobalLayout");
        }
        m45300f();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(this.f34170a, "onScrollChanged");
        }
        m45300f();
    }

    /* renamed from: a */
    public void mo45252a() {
    }

    /* renamed from: a */
    public void mo45253a(int i10) {
    }

    /* renamed from: a */
    public void mo45254a(long j10, int i10) {
    }
}
