package p542p2;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R$id;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507o2.InterfaceC11790c;
import p630s2.C12676k;

@Deprecated
/* renamed from: p2.j */
/* loaded from: classes.dex */
public abstract class AbstractC12083j<T extends View, Z> extends AbstractC12074a<Z> {

    /* renamed from: g */
    public static boolean f55899g;

    /* renamed from: h */
    public static int f55900h = R$id.glide_custom_view_target_tag;

    /* renamed from: b */
    public final T f55901b;

    /* renamed from: c */
    public final a f55902c;

    /* renamed from: d */
    public View.OnAttachStateChangeListener f55903d;

    /* renamed from: e */
    public boolean f55904e;

    /* renamed from: f */
    public boolean f55905f;

    /* renamed from: p2.j$a */
    public static final class a {

        /* renamed from: e */
        public static Integer f55906e;

        /* renamed from: a */
        public final View f55907a;

        /* renamed from: b */
        public final List<InterfaceC12081h> f55908b = new ArrayList();

        /* renamed from: c */
        public boolean f55909c;

        /* renamed from: d */
        public ViewTreeObserverOnPreDrawListenerC14511a f55910d;

        /* renamed from: p2.j$a$a, reason: collision with other inner class name */
        public static final class ViewTreeObserverOnPreDrawListenerC14511a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            public final WeakReference<a> f55911a;

            public ViewTreeObserverOnPreDrawListenerC14511a(a aVar) {
                this.f55911a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f55911a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.m72242a();
                return true;
            }
        }

        public a(View view) {
            this.f55907a = view;
        }

        /* renamed from: c */
        public static int m72241c(Context context) {
            if (f55906e == null) {
                Display defaultDisplay = ((WindowManager) C12676k.m76276d((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f55906e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f55906e.intValue();
        }

        /* renamed from: a */
        public void m72242a() {
            if (this.f55908b.isEmpty()) {
                return;
            }
            int iM72247g = m72247g();
            int iM72246f = m72246f();
            if (m72249i(iM72247g, iM72246f)) {
                m72250j(iM72247g, iM72246f);
                m72243b();
            }
        }

        /* renamed from: b */
        public void m72243b() {
            ViewTreeObserver viewTreeObserver = this.f55907a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f55910d);
            }
            this.f55910d = null;
            this.f55908b.clear();
        }

        /* renamed from: d */
        public void m72244d(InterfaceC12081h interfaceC12081h) {
            int iM72247g = m72247g();
            int iM72246f = m72246f();
            if (m72249i(iM72247g, iM72246f)) {
                interfaceC12081h.mo70289d(iM72247g, iM72246f);
                return;
            }
            if (!this.f55908b.contains(interfaceC12081h)) {
                this.f55908b.add(interfaceC12081h);
            }
            if (this.f55910d == null) {
                ViewTreeObserver viewTreeObserver = this.f55907a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC14511a viewTreeObserverOnPreDrawListenerC14511a = new ViewTreeObserverOnPreDrawListenerC14511a(this);
                this.f55910d = viewTreeObserverOnPreDrawListenerC14511a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC14511a);
            }
        }

        /* renamed from: e */
        public final int m72245e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f55909c && this.f55907a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f55907a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m72241c(this.f55907a.getContext());
        }

        /* renamed from: f */
        public final int m72246f() {
            int paddingTop = this.f55907a.getPaddingTop() + this.f55907a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f55907a.getLayoutParams();
            return m72245e(this.f55907a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: g */
        public final int m72247g() {
            int paddingLeft = this.f55907a.getPaddingLeft() + this.f55907a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f55907a.getLayoutParams();
            return m72245e(this.f55907a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: h */
        public final boolean m72248h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        /* renamed from: i */
        public final boolean m72249i(int i10, int i11) {
            return m72248h(i10) && m72248h(i11);
        }

        /* renamed from: j */
        public final void m72250j(int i10, int i11) {
            Iterator it = new ArrayList(this.f55908b).iterator();
            while (it.hasNext()) {
                ((InterfaceC12081h) it.next()).mo70289d(i10, i11);
            }
        }

        /* renamed from: k */
        public void m72251k(InterfaceC12081h interfaceC12081h) {
            this.f55908b.remove(interfaceC12081h);
        }
    }

    public AbstractC12083j(T t10) {
        this.f55901b = (T) C12676k.m76276d(t10);
        this.f55902c = new a(t10);
    }

    @Override // p542p2.AbstractC12074a, p542p2.InterfaceC12082i
    /* renamed from: a */
    public InterfaceC11790c mo72224a() {
        Object objM72237i = m72237i();
        if (objM72237i == null) {
            return null;
        }
        if (objM72237i instanceof InterfaceC11790c) {
            return (InterfaceC11790c) objM72237i;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: b */
    public void mo72230b(InterfaceC12081h interfaceC12081h) {
        this.f55902c.m72244d(interfaceC12081h);
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: d */
    public void mo72231d(InterfaceC12081h interfaceC12081h) {
        this.f55902c.m72251k(interfaceC12081h);
    }

    @Override // p542p2.AbstractC12074a, p542p2.InterfaceC12082i
    /* renamed from: e */
    public void mo72225e(InterfaceC11790c interfaceC11790c) {
        m72240l(interfaceC11790c);
    }

    @Override // p542p2.AbstractC12074a, p542p2.InterfaceC12082i
    /* renamed from: g */
    public void mo72227g(Drawable drawable) {
        super.mo72227g(drawable);
        m72238j();
    }

    @Override // p542p2.AbstractC12074a, p542p2.InterfaceC12082i
    /* renamed from: h */
    public void mo66338h(Drawable drawable) {
        super.mo66338h(drawable);
        this.f55902c.m72243b();
        if (this.f55904e) {
            return;
        }
        m72239k();
    }

    /* renamed from: i */
    public final Object m72237i() {
        return this.f55901b.getTag(f55900h);
    }

    /* renamed from: j */
    public final void m72238j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f55903d;
        if (onAttachStateChangeListener == null || this.f55905f) {
            return;
        }
        this.f55901b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f55905f = true;
    }

    /* renamed from: k */
    public final void m72239k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f55903d;
        if (onAttachStateChangeListener == null || !this.f55905f) {
            return;
        }
        this.f55901b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f55905f = false;
    }

    /* renamed from: l */
    public final void m72240l(Object obj) {
        f55899g = true;
        this.f55901b.setTag(f55900h, obj);
    }

    public String toString() {
        return "Target for: " + this.f55901b;
    }
}
