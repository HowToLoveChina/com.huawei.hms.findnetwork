package androidx.viewpager2.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.C0876o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.InterfaceC0985a;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import p273f0.C9603h0;
import p304g0.C9832l;
import p304g0.InterfaceC9835o;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: u */
    public static boolean f4965u = true;

    /* renamed from: a */
    public final Rect f4966a;

    /* renamed from: b */
    public final Rect f4967b;

    /* renamed from: c */
    public C1001b f4968c;

    /* renamed from: d */
    public int f4969d;

    /* renamed from: e */
    public boolean f4970e;

    /* renamed from: f */
    public RecyclerView.AbstractC0840j f4971f;

    /* renamed from: g */
    public LinearLayoutManager f4972g;

    /* renamed from: h */
    public int f4973h;

    /* renamed from: i */
    public Parcelable f4974i;

    /* renamed from: j */
    public RecyclerView f4975j;

    /* renamed from: k */
    public C0876o f4976k;

    /* renamed from: l */
    public C1004e f4977l;

    /* renamed from: m */
    public C1001b f4978m;

    /* renamed from: n */
    public C1002c f4979n;

    /* renamed from: o */
    public C1003d f4980o;

    /* renamed from: p */
    public RecyclerView.AbstractC0843m f4981p;

    /* renamed from: q */
    public boolean f4982q;

    /* renamed from: r */
    public boolean f4983r;

    /* renamed from: s */
    public int f4984s;

    /* renamed from: t */
    public AbstractC0991e f4985t;

    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f4985t.mo5884d() ? ViewPager2.this.f4985t.mo5894n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f4969d);
            accessibilityEvent.setToIndex(ViewPager2.this.f4969d);
            ViewPager2.this.f4985t.mo5895o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.m5866e() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.m5866e() && super.onTouchEvent(motionEvent);
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$a */
    public class C0987a extends AbstractC0993g {
        public C0987a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0993g, androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f4970e = true;
            viewPager2.f4977l.m5924q();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$b */
    public class C0988b extends AbstractC0995i {
        public C0988b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0995i
        /* renamed from: a */
        public void mo5879a(int i10) {
            if (i10 == 0) {
                ViewPager2.this.m5874m();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0995i
        /* renamed from: c */
        public void mo5880c(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f4969d != i10) {
                viewPager2.f4969d = i10;
                viewPager2.f4985t.mo5897q();
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$c */
    public class C0989c extends AbstractC0995i {
        public C0989c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0995i
        /* renamed from: c */
        public void mo5880c(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f4975j.requestFocus(2);
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$d */
    public class C0990d implements RecyclerView.InterfaceC0847q {
        public C0990d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0847q
        public void onChildViewAttachedToWindow(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0847q
        public void onChildViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$e */
    public abstract class AbstractC0991e {
        public AbstractC0991e() {
        }

        /* renamed from: a */
        public boolean mo5881a() {
            return false;
        }

        /* renamed from: b */
        public boolean mo5882b(int i10) {
            return false;
        }

        /* renamed from: c */
        public boolean mo5883c(int i10, Bundle bundle) {
            return false;
        }

        /* renamed from: d */
        public boolean mo5884d() {
            return false;
        }

        /* renamed from: e */
        public void mo5885e(RecyclerView.AbstractC0838h<?> abstractC0838h) {
        }

        /* renamed from: f */
        public void mo5886f(RecyclerView.AbstractC0838h<?> abstractC0838h) {
        }

        /* renamed from: g */
        public String mo5887g() {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: h */
        public void mo5888h(C1001b c1001b, RecyclerView recyclerView) {
        }

        /* renamed from: i */
        public void mo5889i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* renamed from: j */
        public void mo5890j(C9832l c9832l) {
        }

        /* renamed from: k */
        public boolean mo5891k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: l */
        public boolean mo5892l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: m */
        public void mo5893m() {
        }

        /* renamed from: n */
        public CharSequence mo5894n() {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: o */
        public void mo5895o(AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: p */
        public void mo5896p() {
        }

        /* renamed from: q */
        public void mo5897q() {
        }

        /* renamed from: r */
        public void mo5898r() {
        }

        /* renamed from: s */
        public void mo5899s() {
        }

        public /* synthetic */ AbstractC0991e(ViewPager2 viewPager2, C0987a c0987a) {
            this();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$f */
    public class C0992f extends AbstractC0991e {
        public C0992f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: b */
        public boolean mo5882b(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.m5866e();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: d */
        public boolean mo5884d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: j */
        public void mo5890j(C9832l c9832l) {
            if (ViewPager2.this.m5866e()) {
                return;
            }
            c9832l.m61058N(C9832l.a.f48308r);
            c9832l.m61058N(C9832l.a.f48307q);
            c9832l.m61102q0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: k */
        public boolean mo5891k(int i10) {
            if (mo5882b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: n */
        public CharSequence mo5894n() {
            if (mo5884d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$g */
    public static abstract class AbstractC0993g extends RecyclerView.AbstractC0840j {
        public AbstractC0993g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public /* synthetic */ AbstractC0993g(C0987a c0987a) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$h */
    public class C0994h extends LinearLayoutManager {
        public C0994h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.C0856z c0856z, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(c0856z, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
        public void onInitializeAccessibilityNodeInfo(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(c0852v, c0856z, c9832l);
            ViewPager2.this.f4985t.mo5890j(c9832l);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
        public boolean performAccessibilityAction(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10, Bundle bundle) {
            return ViewPager2.this.f4985t.mo5882b(i10) ? ViewPager2.this.f4985t.mo5891k(i10) : super.performAccessibilityAction(c0852v, c0856z, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$i */
    public static abstract class AbstractC0995i {
        /* renamed from: a */
        public void mo5879a(int i10) {
        }

        /* renamed from: b */
        public void mo5900b(int i10, float f10, int i11) {
        }

        /* renamed from: c */
        public void mo5880c(int i10) {
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$j */
    public class C0996j extends AbstractC0991e {

        /* renamed from: b */
        public final InterfaceC9835o f4997b;

        /* renamed from: c */
        public final InterfaceC9835o f4998c;

        /* renamed from: d */
        public RecyclerView.AbstractC0840j f4999d;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$j$a */
        public class a implements InterfaceC9835o {
            public a() {
            }

            @Override // p304g0.InterfaceC9835o
            /* renamed from: a */
            public boolean mo4167a(View view, InterfaceC9835o.a aVar) {
                C0996j.this.m5903v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$j$b */
        public class b implements InterfaceC9835o {
            public b() {
            }

            @Override // p304g0.InterfaceC9835o
            /* renamed from: a */
            public boolean mo4167a(View view, InterfaceC9835o.a aVar) {
                C0996j.this.m5903v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$j$c */
        public class c extends AbstractC0993g {
            public c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0993g, androidx.recyclerview.widget.RecyclerView.AbstractC0840j
            public void onChanged() {
                C0996j.this.m5904w();
            }
        }

        public C0996j() {
            super(ViewPager2.this, null);
            this.f4997b = new a();
            this.f4998c = new b();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: a */
        public boolean mo5881a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: c */
        public boolean mo5883c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: e */
        public void mo5885e(RecyclerView.AbstractC0838h<?> abstractC0838h) {
            m5904w();
            if (abstractC0838h != null) {
                abstractC0838h.m5204A(this.f4999d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: f */
        public void mo5886f(RecyclerView.AbstractC0838h<?> abstractC0838h) {
            if (abstractC0838h != null) {
                abstractC0838h.m5206C(this.f4999d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: g */
        public String mo5887g() {
            if (mo5881a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: h */
        public void mo5888h(C1001b c1001b, RecyclerView recyclerView) {
            C9603h0.m59833A0(recyclerView, 2);
            this.f4999d = new c();
            if (C9603h0.m59919y(ViewPager2.this) == 0) {
                C9603h0.m59833A0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: i */
        public void mo5889i(AccessibilityNodeInfo accessibilityNodeInfo) {
            m5901t(accessibilityNodeInfo);
            m5902u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: l */
        public boolean mo5892l(int i10, Bundle bundle) {
            if (!mo5883c(i10, bundle)) {
                throw new IllegalStateException();
            }
            m5903v(i10 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: m */
        public void mo5893m() {
            m5904w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: o */
        public void mo5895o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(mo5887g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: p */
        public void mo5896p() {
            m5904w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: q */
        public void mo5897q() {
            m5904w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: r */
        public void mo5898r() {
            m5904w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0991e
        /* renamed from: s */
        public void mo5899s() {
            m5904w();
        }

        /* renamed from: t */
        public final void m5901t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iMo721e;
            int iMo721e2;
            if (ViewPager2.this.getAdapter() == null) {
                iMo721e = 0;
                iMo721e2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                iMo721e = ViewPager2.this.getAdapter().mo721e();
                iMo721e2 = 0;
            } else {
                iMo721e2 = ViewPager2.this.getAdapter().mo721e();
                iMo721e = 0;
            }
            C9832l.m61042A0(accessibilityNodeInfo).m61067W(C9832l.b.m61126b(iMo721e, iMo721e2, false, 0));
        }

        /* renamed from: u */
        public final void m5902u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iMo721e;
            RecyclerView.AbstractC0838h adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (iMo721e = adapter.mo721e()) == 0 || !ViewPager2.this.m5866e()) {
                return;
            }
            if (ViewPager2.this.f4969d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f4969d < iMo721e - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        /* renamed from: v */
        public void m5903v(int i10) {
            if (ViewPager2.this.m5866e()) {
                ViewPager2.this.m5871j(i10, true);
            }
        }

        /* renamed from: w */
        public void m5904w() {
            int iMo721e;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i10 = R.id.accessibilityActionPageLeft;
            C9603h0.m59890j0(viewPager2, R.id.accessibilityActionPageLeft);
            C9603h0.m59890j0(viewPager2, R.id.accessibilityActionPageRight);
            C9603h0.m59890j0(viewPager2, R.id.accessibilityActionPageUp);
            C9603h0.m59890j0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (iMo721e = ViewPager2.this.getAdapter().mo721e()) == 0 || !ViewPager2.this.m5866e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f4969d < iMo721e - 1) {
                    C9603h0.m59894l0(viewPager2, new C9832l.a(R.id.accessibilityActionPageDown, null), null, this.f4997b);
                }
                if (ViewPager2.this.f4969d > 0) {
                    C9603h0.m59894l0(viewPager2, new C9832l.a(R.id.accessibilityActionPageUp, null), null, this.f4998c);
                    return;
                }
                return;
            }
            boolean zM5865d = ViewPager2.this.m5865d();
            int i11 = zM5865d ? 16908360 : 16908361;
            if (zM5865d) {
                i10 = 16908361;
            }
            if (ViewPager2.this.f4969d < iMo721e - 1) {
                C9603h0.m59894l0(viewPager2, new C9832l.a(i11, null), null, this.f4997b);
            }
            if (ViewPager2.this.f4969d > 0) {
                C9603h0.m59894l0(viewPager2, new C9832l.a(i10, null), null, this.f4998c);
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$k */
    public interface InterfaceC0997k {
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$l */
    public class C0998l extends C0876o {
        public C0998l() {
        }

        @Override // androidx.recyclerview.widget.C0876o, androidx.recyclerview.widget.AbstractC0880s
        public View findSnapView(RecyclerView.AbstractC0846p abstractC0846p) {
            if (ViewPager2.this.m5864c()) {
                return null;
            }
            return super.findSnapView(abstractC0846p);
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$m */
    public static class RunnableC0999m implements Runnable {

        /* renamed from: a */
        public final int f5005a;

        /* renamed from: b */
        public final RecyclerView f5006b;

        public RunnableC0999m(int i10, RecyclerView recyclerView) {
            this.f5005a = i10;
            this.f5006b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5006b.smoothScrollToPosition(this.f5005a);
        }
    }

    public ViewPager2(Context context) throws IllegalStateException {
        super(context);
        this.f4966a = new Rect();
        this.f4967b = new Rect();
        this.f4968c = new C1001b(3);
        this.f4970e = false;
        this.f4971f = new C0987a();
        this.f4973h = -1;
        this.f4981p = null;
        this.f4982q = false;
        this.f4983r = true;
        this.f4984s = -1;
        m5863b(context, null);
    }

    /* renamed from: a */
    public final RecyclerView.InterfaceC0847q m5862a() {
        return new C0990d();
    }

    /* renamed from: b */
    public final void m5863b(Context context, AttributeSet attributeSet) throws IllegalStateException {
        this.f4985t = f4965u ? new C0996j() : new C0992f();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f4975j = recyclerViewImpl;
        recyclerViewImpl.setId(C9603h0.m59891k());
        this.f4975j.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        C0994h c0994h = new C0994h(context);
        this.f4972g = c0994h;
        this.f4975j.setLayoutManager(c0994h);
        this.f4975j.setScrollingTouchSlop(1);
        m5872k(context, attributeSet);
        this.f4975j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f4975j.addOnChildAttachStateChangeListener(m5862a());
        C1004e c1004e = new C1004e(this);
        this.f4977l = c1004e;
        this.f4979n = new C1002c(this, c1004e, this.f4975j);
        C0998l c0998l = new C0998l();
        this.f4976k = c0998l;
        c0998l.attachToRecyclerView(this.f4975j);
        this.f4975j.addOnScrollListener(this.f4977l);
        C1001b c1001b = new C1001b(3);
        this.f4978m = c1001b;
        this.f4977l.m5927t(c1001b);
        C0988b c0988b = new C0988b();
        C0989c c0989c = new C0989c();
        this.f4978m.m5910d(c0988b);
        this.f4978m.m5910d(c0989c);
        this.f4985t.mo5888h(this.f4978m, this.f4975j);
        this.f4978m.m5910d(this.f4968c);
        C1003d c1003d = new C1003d(this.f4972g);
        this.f4980o = c1003d;
        this.f4978m.m5910d(c1003d);
        RecyclerView recyclerView = this.f4975j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    /* renamed from: c */
    public boolean m5864c() {
        return this.f4979n.m5912a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f4975j.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f4975j.canScrollVertically(i10);
    }

    /* renamed from: d */
    public boolean m5865d() {
        return this.f4972g.getLayoutDirection() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f4987a;
            sparseArray.put(this.f4975j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        m5869h();
    }

    /* renamed from: e */
    public boolean m5866e() {
        return this.f4983r;
    }

    /* renamed from: f */
    public final void m5867f(RecyclerView.AbstractC0838h<?> abstractC0838h) {
        if (abstractC0838h != null) {
            abstractC0838h.m5204A(this.f4971f);
        }
    }

    /* renamed from: g */
    public void m5868g() {
        this.f4980o.m5913d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.f4985t.mo5881a() ? this.f4985t.mo5887g() : super.getAccessibilityClassName();
    }

    public RecyclerView.AbstractC0838h getAdapter() {
        return this.f4975j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f4969d;
    }

    public int getItemDecorationCount() {
        return this.f4975j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f4984s;
    }

    public int getOrientation() {
        return this.f4972g.getOrientation();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f4975j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f4977l.m5920m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public final void m5869h() {
        RecyclerView.AbstractC0838h adapter;
        if (this.f4973h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f4974i;
        if (parcelable != null) {
            if (adapter instanceof InterfaceC0985a) {
                ((InterfaceC0985a) adapter).m5861b(parcelable);
            }
            this.f4974i = null;
        }
        int iMax = Math.max(0, Math.min(this.f4973h, adapter.mo721e() - 1));
        this.f4969d = iMax;
        this.f4973h = -1;
        this.f4975j.scrollToPosition(iMax);
        this.f4985t.mo5893m();
    }

    /* renamed from: i */
    public void m5870i(int i10, boolean z10) {
        if (m5864c()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        m5871j(i10, z10);
    }

    /* renamed from: j */
    public void m5871j(int i10, boolean z10) {
        RecyclerView.AbstractC0838h adapter = getAdapter();
        if (adapter == null) {
            if (this.f4973h != -1) {
                this.f4973h = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.mo721e() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i10, 0), adapter.mo721e() - 1);
        if (iMin == this.f4969d && this.f4977l.m5922o()) {
            return;
        }
        int i11 = this.f4969d;
        if (iMin == i11 && z10) {
            return;
        }
        double dM5919l = i11;
        this.f4969d = iMin;
        this.f4985t.mo5897q();
        if (!this.f4977l.m5922o()) {
            dM5919l = this.f4977l.m5919l();
        }
        this.f4977l.m5925r(iMin, z10);
        if (!z10) {
            this.f4975j.scrollToPosition(iMin);
            return;
        }
        double d10 = iMin;
        if (Math.abs(d10 - dM5919l) <= 3.0d) {
            this.f4975j.smoothScrollToPosition(iMin);
            return;
        }
        this.f4975j.scrollToPosition(d10 > dM5919l ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f4975j;
        recyclerView.post(new RunnableC0999m(iMin, recyclerView));
    }

    /* renamed from: k */
    public final void m5872k(Context context, AttributeSet attributeSet) {
        int[] iArr = R$styleable.ViewPager2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: l */
    public final void m5873l(RecyclerView.AbstractC0838h<?> abstractC0838h) {
        if (abstractC0838h != null) {
            abstractC0838h.m5206C(this.f4971f);
        }
    }

    /* renamed from: m */
    public void m5874m() {
        C0876o c0876o = this.f4976k;
        if (c0876o == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewFindSnapView = c0876o.findSnapView(this.f4972g);
        if (viewFindSnapView == null) {
            return;
        }
        int position = this.f4972g.getPosition(viewFindSnapView);
        if (position != this.f4969d && getScrollState() == 0) {
            this.f4978m.mo5880c(position);
        }
        this.f4970e = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f4985t.mo5889i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f4975j.getMeasuredWidth();
        int measuredHeight = this.f4975j.getMeasuredHeight();
        this.f4966a.left = getPaddingLeft();
        this.f4966a.right = (i12 - i10) - getPaddingRight();
        this.f4966a.top = getPaddingTop();
        this.f4966a.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f4966a, this.f4967b);
        RecyclerView recyclerView = this.f4975j;
        Rect rect = this.f4967b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f4970e) {
            m5874m();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f4975j, i10, i11);
        int measuredWidth = this.f4975j.getMeasuredWidth();
        int measuredHeight = this.f4975j.getMeasuredHeight();
        int measuredState = this.f4975j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4973h = savedState.f4988b;
        this.f4974i = savedState.f4989c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4987a = this.f4975j.getId();
        int i10 = this.f4973h;
        if (i10 == -1) {
            i10 = this.f4969d;
        }
        savedState.f4988b = i10;
        Parcelable parcelable = this.f4974i;
        if (parcelable != null) {
            savedState.f4989c = parcelable;
        } else {
            Object adapter = this.f4975j.getAdapter();
            if (adapter instanceof InterfaceC0985a) {
                savedState.f4989c = ((InterfaceC0985a) adapter).m5860a();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return this.f4985t.mo5883c(i10, bundle) ? this.f4985t.mo5892l(i10, bundle) : super.performAccessibilityAction(i10, bundle);
    }

    public void setAdapter(RecyclerView.AbstractC0838h abstractC0838h) {
        RecyclerView.AbstractC0838h adapter = this.f4975j.getAdapter();
        this.f4985t.mo5886f(adapter);
        m5873l(adapter);
        this.f4975j.setAdapter(abstractC0838h);
        this.f4969d = 0;
        m5869h();
        this.f4985t.mo5885e(abstractC0838h);
        m5867f(abstractC0838h);
    }

    public void setCurrentItem(int i10) {
        m5870i(i10, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f4985t.mo5896p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f4984s = i10;
        this.f4975j.requestLayout();
    }

    public void setOrientation(int i10) {
        this.f4972g.setOrientation(i10);
        this.f4985t.mo5898r();
    }

    public void setPageTransformer(InterfaceC0997k interfaceC0997k) {
        if (interfaceC0997k != null) {
            if (!this.f4982q) {
                this.f4981p = this.f4975j.getItemAnimator();
                this.f4982q = true;
            }
            this.f4975j.setItemAnimator(null);
        } else if (this.f4982q) {
            this.f4975j.setItemAnimator(this.f4981p);
            this.f4981p = null;
            this.f4982q = false;
        }
        this.f4980o.m5913d();
        if (interfaceC0997k == null) {
            return;
        }
        this.f4980o.m5914e(interfaceC0997k);
        m5868g();
    }

    public void setUserInputEnabled(boolean z10) {
        this.f4983r = z10;
        this.f4985t.mo5899s();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0986a();

        /* renamed from: a */
        public int f4987a;

        /* renamed from: b */
        public int f4988b;

        /* renamed from: c */
        public Parcelable f4989c;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$SavedState$a */
        public static class C0986a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m5875a(parcel, classLoader);
        }

        /* renamed from: a */
        public final void m5875a(Parcel parcel, ClassLoader classLoader) {
            this.f4987a = parcel.readInt();
            this.f4988b = parcel.readInt();
            this.f4989c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4987a);
            parcel.writeInt(this.f4988b);
            parcel.writeParcelable(this.f4989c, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) throws IllegalStateException {
        super(context, attributeSet);
        this.f4966a = new Rect();
        this.f4967b = new Rect();
        this.f4968c = new C1001b(3);
        this.f4970e = false;
        this.f4971f = new C0987a();
        this.f4973h = -1;
        this.f4981p = null;
        this.f4982q = false;
        this.f4983r = true;
        this.f4984s = -1;
        m5863b(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i10) throws IllegalStateException {
        super(context, attributeSet, i10);
        this.f4966a = new Rect();
        this.f4967b = new Rect();
        this.f4968c = new C1001b(3);
        this.f4970e = false;
        this.f4971f = new C0987a();
        this.f4973h = -1;
        this.f4981p = null;
        this.f4982q = false;
        this.f4983r = true;
        this.f4984s = -1;
        m5863b(context, attributeSet);
    }
}
