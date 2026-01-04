package com.huawei.uikit.hwrecyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.AbstractC0875n;
import androidx.recyclerview.widget.InterfaceC0870i;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes4.dex */
public class HwLinearLayoutManagerEx extends RecyclerView.AbstractC0846p implements InterfaceC0870i, RecyclerView.AbstractC0855y.b {

    /* renamed from: A */
    static final int f43625A = 4;

    /* renamed from: B */
    static final int f43626B = 0;

    /* renamed from: C */
    static final int f43627C = 1;

    /* renamed from: D */
    static final int f43628D = 2;

    /* renamed from: E */
    static final int f43629E = 4;

    /* renamed from: F */
    static final int f43630F = 4;

    /* renamed from: G */
    static final int f43631G = 16;

    /* renamed from: H */
    static final int f43632H = 32;
    public static final int HORIZONTAL = 0;

    /* renamed from: I */
    static final int f43633I = 64;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;

    /* renamed from: J */
    static final int f43634J = 8;

    /* renamed from: K */
    static final int f43635K = 256;

    /* renamed from: L */
    static final int f43636L = 512;

    /* renamed from: M */
    static final int f43637M = 1024;

    /* renamed from: N */
    static final int f43638N = 12;

    /* renamed from: O */
    static final int f43639O = 4096;

    /* renamed from: P */
    static final int f43640P = 8192;

    /* renamed from: Q */
    static final int f43641Q = 16384;

    /* renamed from: R */
    static final int f43642R = 7;

    /* renamed from: S */
    private static final String f43643S = "LinearLayoutManager";

    /* renamed from: T */
    private static final float f43644T = 0.33333334f;
    public static final int VERTICAL = 1;

    /* renamed from: w */
    static final boolean f43645w = false;

    /* renamed from: x */
    static final boolean f43646x = false;

    /* renamed from: y */
    static final int f43647y = 1;

    /* renamed from: z */
    static final int f43648z = 2;

    /* renamed from: a */
    int f43649a;

    /* renamed from: b */
    boolean f43650b;

    /* renamed from: c */
    int f43651c;

    /* renamed from: d */
    int f43652d;

    /* renamed from: e */
    AbstractC0875n f43653e;

    /* renamed from: f */
    SavedState f43654f;

    /* renamed from: g */
    final bzrwd f43655g;

    /* renamed from: h */
    private bqmxo f43656h;

    /* renamed from: i */
    private OnReferenceItemListener f43657i;

    /* renamed from: j */
    private boolean f43658j;

    /* renamed from: k */
    private boolean f43659k;

    /* renamed from: l */
    private boolean f43660l;

    /* renamed from: m */
    private boolean f43661m;

    /* renamed from: n */
    private boolean f43662n;

    /* renamed from: o */
    private final LayoutChunkResult f43663o;

    /* renamed from: p */
    private int f43664p;

    /* renamed from: q */
    private int[] f43665q;

    /* renamed from: r */
    private Method f43666r;

    /* renamed from: s */
    private Object f43667s;

    /* renamed from: t */
    private Object f43668t;

    /* renamed from: u */
    private int f43669u;

    /* renamed from: v */
    private int f43670v;

    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        /* renamed from: a */
        public void m55136a() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    public interface OnReferenceItemListener {
        boolean isNeedRefreshReferenceLayout(View view);
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new bzrwd();

        /* renamed from: a */
        int f43671a;

        /* renamed from: b */
        int f43672b;

        /* renamed from: c */
        boolean f43673c;

        public class bzrwd implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState() {
        }

        /* renamed from: a */
        public boolean m55137a() {
            return this.f43671a >= 0;
        }

        /* renamed from: b */
        public void m55138b() {
            this.f43671a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f43671a);
            parcel.writeInt(this.f43672b);
            parcel.writeInt(this.f43673c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f43671a = parcel.readInt();
            this.f43672b = parcel.readInt();
            this.f43673c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f43671a = savedState.f43671a;
            this.f43672b = savedState.f43672b;
            this.f43673c = savedState.f43673c;
        }
    }

    public static class aauaf {

        /* renamed from: a */
        View f43674a;

        /* renamed from: b */
        View f43675b;

        /* renamed from: c */
        boolean f43676c;
    }

    public static class bqmxo {

        /* renamed from: n */
        static final String f43677n = "LLM#LayoutState";

        /* renamed from: o */
        static final int f43678o = -1;

        /* renamed from: p */
        static final int f43679p = 1;

        /* renamed from: q */
        static final int f43680q = Integer.MIN_VALUE;

        /* renamed from: r */
        static final int f43681r = -1;

        /* renamed from: s */
        static final int f43682s = 1;

        /* renamed from: t */
        static final int f43683t = Integer.MIN_VALUE;

        /* renamed from: b */
        int f43685b;

        /* renamed from: c */
        int f43686c;

        /* renamed from: d */
        int f43687d;

        /* renamed from: e */
        int f43688e;

        /* renamed from: f */
        int f43689f;

        /* renamed from: g */
        int f43690g;

        /* renamed from: k */
        int f43694k;

        /* renamed from: m */
        boolean f43696m;

        /* renamed from: a */
        boolean f43684a = true;

        /* renamed from: h */
        int f43691h = 0;

        /* renamed from: i */
        int f43692i = 0;

        /* renamed from: j */
        boolean f43693j = false;

        /* renamed from: l */
        List<RecyclerView.AbstractC0833c0> f43695l = null;

        /* renamed from: c */
        private View m55141c() {
            int size = this.f43695l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f43695l.get(i10).f4327a;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    if (!layoutParams2.m5127d() && this.f43687d == layoutParams2.m5125a()) {
                        m55144a(view);
                        return view;
                    }
                }
            }
            return null;
        }

        /* renamed from: a */
        public boolean m55145a(RecyclerView.C0856z c0856z) {
            int i10 = this.f43687d;
            return i10 >= 0 && i10 < c0856z.m5305b();
        }

        /* renamed from: b */
        public View m55146b(View view) {
            int iM5125a;
            int size = this.f43695l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f43695l.get(i11).f4327a;
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    if (view3 != view && !layoutParams2.m5127d() && (iM5125a = (layoutParams2.m5125a() - this.f43687d) * this.f43688e) >= 0 && iM5125a < i10) {
                        view2 = view3;
                        if (iM5125a == 0) {
                            break;
                        }
                        i10 = iM5125a;
                    }
                }
            }
            return view2;
        }

        /* renamed from: a */
        public View m55142a(RecyclerView.C0852v c0852v) {
            if (this.f43695l != null) {
                return m55141c();
            }
            View viewM5285o = c0852v.m5285o(this.f43687d);
            this.f43687d += this.f43688e;
            return viewM5285o;
        }

        /* renamed from: a */
        public void m55143a() {
            m55144a((View) null);
        }

        /* renamed from: a */
        public void m55144a(View view) {
            View viewM55146b = m55146b(view);
            if (viewM55146b == null) {
                this.f43687d = -1;
                return;
            }
            ViewGroup.LayoutParams layoutParams = viewM55146b.getLayoutParams();
            if (layoutParams instanceof RecyclerView.LayoutParams) {
                this.f43687d = ((RecyclerView.LayoutParams) layoutParams).m5125a();
            }
        }

        /* renamed from: b */
        public void m55147b() {
            Log.d(f43677n, "avail:" + this.f43686c + ", ind:" + this.f43687d + ", dir:" + this.f43688e + ", offset:" + this.f43685b + ", layoutDir:" + this.f43689f);
        }
    }

    public static class bzrwd {

        /* renamed from: a */
        AbstractC0875n f43697a;

        /* renamed from: b */
        int f43698b;

        /* renamed from: c */
        int f43699c;

        /* renamed from: d */
        boolean f43700d;

        /* renamed from: e */
        boolean f43701e;

        public bzrwd() {
            m55148c();
        }

        /* renamed from: c */
        private void m55148c() {
            this.f43698b = -1;
            this.f43699c = Integer.MIN_VALUE;
            this.f43700d = false;
            this.f43701e = false;
        }

        /* renamed from: a */
        public void m55149a() {
            this.f43699c = this.f43700d ? this.f43697a.mo5556i() : this.f43697a.mo5561n();
        }

        /* renamed from: b */
        public void m55152b() {
            m55148c();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f43698b + ", mCoordinate=" + this.f43699c + ", mLayoutFromEnd=" + this.f43700d + ", mValid=" + this.f43701e + '}';
        }

        /* renamed from: b */
        public void m55153b(View view, int i10) {
            int iM5563p = this.f43697a.m5563p();
            if (iM5563p >= 0) {
                m55150a(view, i10);
                return;
            }
            this.f43698b = i10;
            if (this.f43700d) {
                int iMo5556i = (this.f43697a.mo5556i() - iM5563p) - this.f43697a.mo5551d(view);
                this.f43699c = this.f43697a.mo5556i() - iMo5556i;
                if (iMo5556i > 0) {
                    int iMo5552e = this.f43699c - this.f43697a.mo5552e(view);
                    int iMo5561n = this.f43697a.mo5561n();
                    int iMin = iMo5552e - (iMo5561n + Math.min(this.f43697a.mo5554g(view) - iMo5561n, 0));
                    if (iMin < 0) {
                        this.f43699c += Math.min(iMo5556i, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMo5554g = this.f43697a.mo5554g(view);
            int iMo5561n2 = iMo5554g - this.f43697a.mo5561n();
            this.f43699c = iMo5554g;
            if (iMo5561n2 > 0) {
                int iMo5556i2 = (this.f43697a.mo5556i() - Math.min(0, (this.f43697a.mo5556i() - iM5563p) - this.f43697a.mo5551d(view))) - (iMo5554g + this.f43697a.mo5552e(view));
                if (iMo5556i2 < 0) {
                    this.f43699c -= Math.min(iMo5561n2, -iMo5556i2);
                }
            }
        }

        /* renamed from: a */
        public boolean m55151a(View view, RecyclerView.C0856z c0856z) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.m5127d() && layoutParams.m5125a() >= 0 && layoutParams.m5125a() < c0856z.m5305b();
        }

        /* renamed from: a */
        public void m55150a(View view, int i10) {
            if (this.f43700d) {
                this.f43699c = this.f43697a.mo5551d(view) + this.f43697a.m5563p();
            } else {
                this.f43699c = this.f43697a.mo5554g(view);
            }
            this.f43698b = i10;
        }
    }

    public HwLinearLayoutManagerEx(Context context) {
        this(context, 1, false);
    }

    /* renamed from: b */
    private void m55107b(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.f43660l == z10) {
            return;
        }
        this.f43660l = z10;
        requestLayout();
    }

    /* renamed from: c */
    private void m55111c(int i10, int i11) {
        this.f43656h.f43686c = i11 - this.f43653e.mo5561n();
        bqmxo bqmxoVar = this.f43656h;
        bqmxoVar.f43687d = i10;
        bqmxoVar.f43688e = this.f43650b ? 1 : -1;
        bqmxoVar.f43689f = -1;
        bqmxoVar.f43685b = i11;
        bqmxoVar.f43690g = Integer.MIN_VALUE;
    }

    /* renamed from: d */
    private View m55114d(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        return this.f43650b ? m55101b(c0852v, c0856z) : m55087a(c0852v, c0856z);
    }

    /* renamed from: e */
    private View m55115e() {
        return this.f43650b ? m55109c() : m55113d();
    }

    /* renamed from: f */
    private View m55116f() {
        return this.f43650b ? m55113d() : m55109c();
    }

    /* renamed from: g */
    private View m55117g() {
        return getChildAt(this.f43650b ? 0 : getChildCount() - 1);
    }

    /* renamed from: h */
    private View m55118h() {
        return getChildAt(this.f43650b ? getChildCount() - 1 : 0);
    }

    /* renamed from: i */
    private void m55119i() {
        Log.d(f43643S, "internal representation of views on the screen");
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            Log.d(f43643S, "item " + getPosition(childAt) + ", coord:" + this.f43653e.mo5554g(childAt));
        }
        Log.d(f43643S, "==============");
    }

    /* renamed from: k */
    private void m55120k() {
        if (this.f43649a == 1 || !isLayoutRTL()) {
            this.f43650b = this.f43659k;
        } else {
            this.f43650b = !this.f43659k;
        }
    }

    /* renamed from: a */
    public void m55130a(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, bzrwd bzrwdVar, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f43654f == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.C0856z c0856z, int[] iArr) {
        int i10;
        int extraLayoutSpace = getExtraLayoutSpace(c0856z);
        if (this.f43656h.f43689f == -1) {
            i10 = 0;
        } else {
            i10 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollHorizontally() {
        return this.f43649a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollVertically() {
        return this.f43649a == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.C0856z c0856z, RecyclerView.AbstractC0846p.c cVar) {
        if (this.f43649a != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        m55133b();
        m55088a(i10 > 0 ? 1 : -1, Math.abs(i10), true, c0856z);
        m55131a(c0856z, this.f43656h, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void collectInitialPrefetchPositions(int i10, RecyclerView.AbstractC0846p.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.f43654f;
        if (savedState == null || !savedState.m55137a()) {
            m55120k();
            z10 = this.f43650b;
            i11 = this.f43651c;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.f43654f;
            z10 = savedState2.f43673c;
            i11 = savedState2.f43671a;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.f43664p && i11 >= 0 && i11 < i10; i13++) {
            cVar.mo5245a(i11, 0);
            i11 += i12;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollExtent(RecyclerView.C0856z c0856z) {
        return m55085a(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollOffset(RecyclerView.C0856z c0856z) {
        return m55099b(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollRange(RecyclerView.C0856z c0856z) {
        return m55108c(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0855y.b
    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        int i11 = (i10 < getPosition(getChildAt(0))) != this.f43650b ? -1 : 1;
        return this.f43649a == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollExtent(RecyclerView.C0856z c0856z) {
        return m55085a(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollOffset(RecyclerView.C0856z c0856z) {
        return m55099b(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollRange(RecyclerView.C0856z c0856z) {
        return m55108c(c0856z);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewM55125a = m55125a(0, getChildCount(), true, false);
        if (viewM55125a == null) {
            return -1;
        }
        return getPosition(viewM55125a);
    }

    public int findFirstVisibleItemPosition() {
        View viewM55125a = m55125a(0, getChildCount(), false, true);
        if (viewM55125a == null) {
            return -1;
        }
        return getPosition(viewM55125a);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewM55125a = m55125a(getChildCount() - 1, -1, true, false);
        if (viewM55125a == null) {
            return -1;
        }
        return getPosition(viewM55125a);
    }

    public int findLastVisibleItemPosition() {
        View viewM55125a = m55125a(getChildCount() - 1, -1, false, true);
        if (viewM55125a == null) {
            return -1;
        }
        return getPosition(viewM55125a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public View findViewByPosition(int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i10 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i10) {
                return childAt;
            }
        }
        return super.findViewByPosition(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.C0856z c0856z) {
        if (c0856z.m5307d()) {
            return this.f43653e.mo5562o();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.f43664p;
    }

    public OnReferenceItemListener getOnReferenceItemListener() {
        return this.f43657i;
    }

    public int getOrientation() {
        return this.f43649a;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.f43662n;
    }

    public boolean getReverseLayout() {
        return this.f43659k;
    }

    public boolean getStackFromEnd() {
        return this.f43660l;
    }

    public boolean hasFlexibleChildInBothOrientations() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i10).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isRemoved(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (abstractC0833c0.f4327a.getLayoutParams() instanceof RecyclerView.LayoutParams) {
            return ((RecyclerView.LayoutParams) abstractC0833c0.f4327a.getLayoutParams()).m5127d();
        }
        return true;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.f43661m;
    }

    /* renamed from: j */
    public boolean m55134j() {
        return this.f43653e.mo5559l() == 0 && this.f43653e.mo5555h() == 0;
    }

    /* renamed from: l */
    public void m55135l() {
        Log.d(f43643S, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iMo5554g = this.f43653e.mo5554g(getChildAt(0));
        if (this.f43650b) {
            for (int i10 = 1; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                int position2 = getPosition(childAt);
                int iMo5554g2 = this.f43653e.mo5554g(childAt);
                if (position2 < position) {
                    m55119i();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    sb2.append(iMo5554g2 < iMo5554g);
                    Log.e(f43643S, sb2.toString());
                    return;
                }
                if (iMo5554g2 > iMo5554g) {
                    m55119i();
                    Log.e(f43643S, "detected invalid location");
                    return;
                }
            }
            return;
        }
        for (int i11 = 1; i11 < getChildCount(); i11++) {
            View childAt2 = getChildAt(i11);
            int position3 = getPosition(childAt2);
            int iMo5554g3 = this.f43653e.mo5554g(childAt2);
            if (position3 < position) {
                m55119i();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("detected invalid position. loc invalid? ");
                sb3.append(iMo5554g3 < iMo5554g);
                Log.e(f43643S, sb3.toString());
                return;
            }
            if (iMo5554g3 < iMo5554g) {
                m55119i();
                Log.e(f43643S, "detected invalid location");
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0852v c0852v) {
        super.onDetachedFromWindow(recyclerView, c0852v);
        if (this.f43662n) {
            removeAndRecycleAllViews(c0852v);
            c0852v.m5273c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public View onFocusSearchFailed(View view, int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        int iM55121a;
        m55120k();
        if (getChildCount() == 0 || (iM55121a = m55121a(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        m55133b();
        m55088a(iM55121a, (int) (this.f43653e.mo5562o() * f43644T), false, c0856z);
        bqmxo bqmxoVar = this.f43656h;
        bqmxoVar.f43690g = Integer.MIN_VALUE;
        bqmxoVar.f43684a = false;
        m55123a(c0852v, bqmxoVar, c0856z, true);
        View viewM55116f = iM55121a == -1 ? m55116f() : m55115e();
        View viewM55118h = iM55121a == -1 ? m55118h() : m55117g();
        if (!viewM55118h.hasFocusable()) {
            return viewM55116f;
        }
        if (viewM55116f == null) {
            return null;
        }
        return viewM55118h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        int i10;
        int i11;
        int i12;
        int i13;
        int iM55084a;
        int i14;
        View viewFindViewByPosition;
        int iMo5554g;
        int iMo5556i;
        int i15 = -1;
        if (!(this.f43654f == null && this.f43651c == -1) && c0856z.m5305b() == 0) {
            removeAndRecycleAllViews(c0852v);
            return;
        }
        SavedState savedState = this.f43654f;
        if (savedState != null && savedState.m55137a()) {
            this.f43651c = this.f43654f.f43671a;
        }
        m55133b();
        this.f43656h.f43684a = false;
        m55120k();
        View focusedChild = getFocusedChild();
        bzrwd bzrwdVar = this.f43655g;
        if (!bzrwdVar.f43701e || this.f43651c != -1 || this.f43654f != null) {
            bzrwdVar.m55152b();
            bzrwd bzrwdVar2 = this.f43655g;
            bzrwdVar2.f43700d = this.f43650b ^ this.f43660l;
            m55105b(c0852v, c0856z, bzrwdVar2);
            this.f43655g.f43701e = true;
        } else if (focusedChild != null && (this.f43653e.mo5554g(focusedChild) >= this.f43653e.mo5556i() || this.f43653e.mo5551d(focusedChild) <= this.f43653e.mo5561n())) {
            this.f43655g.m55153b(focusedChild, getPosition(focusedChild));
        }
        bqmxo bqmxoVar = this.f43656h;
        bqmxoVar.f43689f = bqmxoVar.f43694k >= 0 ? 1 : -1;
        int[] iArr = this.f43665q;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0856z, iArr);
        int iMax = Math.max(0, this.f43665q[0]) + this.f43653e.mo5561n();
        int iMax2 = Math.max(0, this.f43665q[1]) + this.f43653e.mo5557j();
        if (c0856z.m5308e() && (i14 = this.f43651c) != -1 && this.f43652d != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i14)) != null) {
            if (this.f43650b) {
                iMo5556i = this.f43653e.mo5556i() - this.f43653e.mo5551d(viewFindViewByPosition);
                iMo5554g = this.f43652d;
            } else {
                iMo5554g = this.f43653e.mo5554g(viewFindViewByPosition) - this.f43653e.mo5561n();
                iMo5556i = this.f43652d;
            }
            int i16 = iMo5556i - iMo5554g;
            if (i16 > 0) {
                iMax += i16;
            } else {
                iMax2 -= i16;
            }
        }
        bzrwd bzrwdVar3 = this.f43655g;
        if (!bzrwdVar3.f43700d ? !this.f43650b : this.f43650b) {
            i15 = 1;
        }
        m55130a(c0852v, c0856z, bzrwdVar3, i15);
        detachAndScrapAttachedViews(c0852v);
        this.f43656h.f43696m = m55134j();
        this.f43656h.f43693j = c0856z.m5308e();
        this.f43656h.f43692i = 0;
        bzrwd bzrwdVar4 = this.f43655g;
        if (bzrwdVar4.f43700d) {
            m55106b(bzrwdVar4);
            bqmxo bqmxoVar2 = this.f43656h;
            bqmxoVar2.f43691h = iMax;
            m55123a(c0852v, bqmxoVar2, c0856z, false);
            bqmxo bqmxoVar3 = this.f43656h;
            i11 = bqmxoVar3.f43685b;
            int i17 = bqmxoVar3.f43687d;
            int i18 = bqmxoVar3.f43686c;
            if (i18 > 0) {
                iMax2 += i18;
            }
            m55093a(this.f43655g);
            bqmxo bqmxoVar4 = this.f43656h;
            bqmxoVar4.f43691h = iMax2;
            bqmxoVar4.f43687d += bqmxoVar4.f43688e;
            m55123a(c0852v, bqmxoVar4, c0856z, false);
            bqmxo bqmxoVar5 = this.f43656h;
            i10 = bqmxoVar5.f43685b;
            int i19 = bqmxoVar5.f43686c;
            if (i19 > 0) {
                m55111c(i17, i11);
                bqmxo bqmxoVar6 = this.f43656h;
                bqmxoVar6.f43691h = i19;
                m55123a(c0852v, bqmxoVar6, c0856z, false);
                i11 = this.f43656h.f43685b;
            }
        } else {
            m55093a(bzrwdVar4);
            bqmxo bqmxoVar7 = this.f43656h;
            bqmxoVar7.f43691h = iMax2;
            m55123a(c0852v, bqmxoVar7, c0856z, false);
            bqmxo bqmxoVar8 = this.f43656h;
            i10 = bqmxoVar8.f43685b;
            int i20 = bqmxoVar8.f43687d;
            int i21 = bqmxoVar8.f43686c;
            if (i21 > 0) {
                iMax += i21;
            }
            m55106b(this.f43655g);
            bqmxo bqmxoVar9 = this.f43656h;
            bqmxoVar9.f43691h = iMax;
            bqmxoVar9.f43687d += bqmxoVar9.f43688e;
            m55123a(c0852v, bqmxoVar9, c0856z, false);
            bqmxo bqmxoVar10 = this.f43656h;
            i11 = bqmxoVar10.f43685b;
            int i22 = bqmxoVar10.f43686c;
            if (i22 > 0) {
                m55103b(i20, i10);
                bqmxo bqmxoVar11 = this.f43656h;
                bqmxoVar11.f43691h = i22;
                m55123a(c0852v, bqmxoVar11, c0856z, false);
                i10 = this.f43656h.f43685b;
            }
        }
        if (getChildCount() > 0) {
            if (this.f43650b ^ this.f43660l) {
                int iM55084a2 = m55084a(i10, c0852v, c0856z, true);
                i12 = i11 + iM55084a2;
                i13 = i10 + iM55084a2;
                iM55084a = m55098b(i12, c0852v, c0856z, false);
            } else {
                int iM55098b = m55098b(i11, c0852v, c0856z, true);
                i12 = i11 + iM55098b;
                i13 = i10 + iM55098b;
                iM55084a = m55084a(i13, c0852v, c0856z, false);
            }
            i11 = i12 + iM55084a;
            i10 = i13 + iM55084a;
        }
        m55090a(c0852v, c0856z, i11, i10);
        if (c0856z.m5308e()) {
            this.f43655g.m55152b();
        } else {
            this.f43653e.m5567t();
        }
        this.f43658j = this.f43660l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutCompleted(RecyclerView.C0856z c0856z) {
        super.onLayoutCompleted(c0856z);
        this.f43654f = null;
        this.f43651c = -1;
        this.f43652d = Integer.MIN_VALUE;
        this.f43655g.m55152b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f43654f = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public Parcelable onSaveInstanceState() {
        if (this.f43654f != null) {
            return new SavedState(this.f43654f);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            m55133b();
            boolean z10 = this.f43658j ^ this.f43650b;
            savedState.f43673c = z10;
            if (z10) {
                View viewM55117g = m55117g();
                savedState.f43672b = this.f43653e.mo5556i() - this.f43653e.mo5551d(viewM55117g);
                savedState.f43671a = getPosition(viewM55117g);
            } else {
                View viewM55118h = m55118h();
                savedState.f43671a = getPosition(viewM55118h);
                savedState.f43672b = this.f43653e.mo5554g(viewM55118h) - this.f43653e.mo5561n();
            }
        } else {
            savedState.m55138b();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.InterfaceC0870i
    public void prepareForDrop(View view, View view2, int i10, int i11) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        m55133b();
        m55120k();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c10 = position < position2 ? (char) 1 : (char) 65535;
        if (this.f43650b) {
            if (c10 == 1) {
                scrollToPositionWithOffset(position2, this.f43653e.mo5556i() - (this.f43653e.mo5554g(view2) + this.f43653e.mo5552e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.f43653e.mo5556i() - this.f43653e.mo5551d(view2));
                return;
            }
        }
        if (c10 == 65535) {
            scrollToPositionWithOffset(position2, this.f43653e.mo5554g(view2) - this.f43653e.mo5561n());
        } else {
            scrollToPositionWithOffset(position2, (this.f43653e.mo5551d(view2) - this.f43653e.mo5552e(view)) - this.f43653e.mo5561n());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollHorizontallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (this.f43649a == 1) {
            return 0;
        }
        return m55122a(i10, c0852v, c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void scrollToPosition(int i10) {
        this.f43651c = i10;
        this.f43652d = Integer.MIN_VALUE;
        SavedState savedState = this.f43654f;
        if (savedState != null) {
            savedState.m55138b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        this.f43651c = i10;
        this.f43652d = i11;
        SavedState savedState = this.f43654f;
        if (savedState != null) {
            savedState.m55138b();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollVerticallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (this.f43649a == 0) {
            return 0;
        }
        return m55122a(i10, c0852v, c0856z);
    }

    public void setExtraLayoutSpace(int i10, int i11) {
        this.f43669u = i10;
        this.f43670v = i11;
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.f43664p = i10;
    }

    public void setOnReferenceItemListener(OnReferenceItemListener onReferenceItemListener) {
        this.f43657i = onReferenceItemListener;
    }

    public void setOrientation(int i10) {
        m55102b(i10);
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.f43662n = z10;
    }

    public void setReverseLayout(boolean z10) {
        m55094a(z10);
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.f43661m = z10;
    }

    public void setStackFromEnd(boolean z10) {
        m55107b(z10);
    }

    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0856z c0856z, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean supportsPredictiveItemAnimations() {
        return this.f43654f == null && this.f43658j == this.f43660l;
    }

    public HwLinearLayoutManagerEx(Context context, int i10, boolean z10) {
        this.f43649a = 1;
        this.f43650b = false;
        this.f43651c = -1;
        this.f43652d = Integer.MIN_VALUE;
        this.f43654f = null;
        this.f43655g = new bzrwd();
        this.f43659k = false;
        this.f43660l = false;
        this.f43661m = true;
        this.f43663o = new LayoutChunkResult();
        this.f43664p = 2;
        this.f43665q = new int[2];
        this.f43666r = null;
        this.f43667s = null;
        this.f43668t = null;
        this.f43669u = 0;
        this.f43670v = 0;
        m55102b(i10);
        m55094a(z10);
    }

    /* renamed from: a */
    private void m55094a(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.f43659k) {
            return;
        }
        this.f43659k = z10;
        requestLayout();
    }

    /* renamed from: d */
    private View m55113d() {
        return m55124a(getChildCount() - 1, -1);
    }

    public int[] getExtraLayoutSpace() {
        return new int[]{this.f43669u, this.f43670v};
    }

    /* renamed from: b */
    private void m55102b(int i10) {
        if (i10 != 0 && i10 != 1) {
            Log.e(f43643S, "invalid orientation:" + i10);
            return;
        }
        assertNotInLayoutOrScroll(null);
        if (i10 != this.f43649a || this.f43653e == null) {
            AbstractC0875n abstractC0875nM5549b = AbstractC0875n.m5549b(this, i10);
            this.f43653e = abstractC0875nM5549b;
            this.f43655g.f43697a = abstractC0875nM5549b;
            this.f43649a = i10;
            requestLayout();
        }
    }

    /* renamed from: a */
    private void m55090a(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10, int i11) {
        if (!c0856z.m5310g() || getChildCount() == 0 || c0856z.m5308e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.AbstractC0833c0> listM5281k = c0852v.m5281k();
        int size = listM5281k.size();
        int position = getPosition(getChildAt(0));
        int iMo5552e = 0;
        int iMo5552e2 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.AbstractC0833c0 abstractC0833c0 = listM5281k.get(i12);
            if (!isRemoved(abstractC0833c0)) {
                if ((abstractC0833c0.m5168o() < position) != this.f43650b) {
                    iMo5552e += this.f43653e.mo5552e(abstractC0833c0.f4327a);
                } else {
                    iMo5552e2 += this.f43653e.mo5552e(abstractC0833c0.f4327a);
                }
            }
        }
        this.f43656h.f43695l = listM5281k;
        if (iMo5552e > 0) {
            m55111c(getPosition(m55118h()), i10);
            bqmxo bqmxoVar = this.f43656h;
            bqmxoVar.f43691h = iMo5552e;
            bqmxoVar.f43686c = 0;
            bqmxoVar.m55143a();
            m55123a(c0852v, this.f43656h, c0856z, false);
        }
        if (iMo5552e2 > 0) {
            m55103b(getPosition(m55117g()), i11);
            bqmxo bqmxoVar2 = this.f43656h;
            bqmxoVar2.f43691h = iMo5552e2;
            bqmxoVar2.f43686c = 0;
            bqmxoVar2.m55143a();
            m55123a(c0852v, this.f43656h, c0856z, false);
        }
        this.f43656h.f43695l = null;
    }

    /* renamed from: c */
    private int m55108c(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        m55133b();
        aauaf aauafVar = new aauaf();
        aauafVar.f43674a = m55132b(!this.f43661m, true);
        aauafVar.f43675b = m55127a(!this.f43661m, true);
        aauafVar.f43676c = this.f43661m;
        return akxao.m55349b(c0856z, this.f43653e, aauafVar, this);
    }

    /* renamed from: b */
    private void m55105b(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, bzrwd bzrwdVar) {
        if (m55096a(c0856z, bzrwdVar) || m55095a(c0852v, c0856z, bzrwdVar)) {
            return;
        }
        bzrwdVar.m55149a();
        bzrwdVar.f43698b = this.f43660l ? c0856z.m5305b() - 1 : 0;
    }

    /* renamed from: c */
    private void m55112c(RecyclerView.C0852v c0852v, int i10, int i11) {
        if (i10 < 0) {
            return;
        }
        int i12 = i10 - i11;
        int childCount = getChildCount();
        if (!this.f43650b) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (this.f43653e.mo5551d(childAt) > i12 || this.f43653e.mo5564q(childAt) > i12) {
                    m55089a(c0852v, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = childCount - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View childAt2 = getChildAt(i15);
            if (this.f43653e.mo5551d(childAt2) > i12 || this.f43653e.mo5564q(childAt2) > i12) {
                m55089a(c0852v, i14, i15);
                return;
            }
        }
    }

    /* renamed from: b */
    private int m55098b(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iMo5561n;
        int iMo5561n2 = i10 - this.f43653e.mo5561n();
        if (iMo5561n2 <= 0) {
            return 0;
        }
        int i11 = -m55122a(iMo5561n2, c0852v, c0856z);
        int i12 = i10 + i11;
        if (!z10 || (iMo5561n = i12 - this.f43653e.mo5561n()) <= 0) {
            return i11;
        }
        this.f43653e.mo5566s(-iMo5561n);
        return i11 - iMo5561n;
    }

    /* renamed from: b */
    private void m55103b(int i10, int i11) {
        this.f43656h.f43686c = this.f43653e.mo5556i() - i11;
        bqmxo bqmxoVar = this.f43656h;
        bqmxoVar.f43688e = this.f43650b ? -1 : 1;
        bqmxoVar.f43687d = i10;
        bqmxoVar.f43689f = 1;
        bqmxoVar.f43685b = i11;
        bqmxoVar.f43690g = Integer.MIN_VALUE;
    }

    public HwLinearLayoutManagerEx(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f43649a = 1;
        this.f43650b = false;
        this.f43651c = -1;
        this.f43652d = Integer.MIN_VALUE;
        this.f43654f = null;
        this.f43655g = new bzrwd();
        this.f43659k = false;
        this.f43660l = false;
        this.f43661m = true;
        this.f43663o = new LayoutChunkResult();
        this.f43664p = 2;
        this.f43665q = new int[2];
        this.f43666r = null;
        this.f43667s = null;
        this.f43668t = null;
        this.f43669u = 0;
        this.f43670v = 0;
        RecyclerView.AbstractC0846p.d properties = RecyclerView.AbstractC0846p.getProperties(context, attributeSet, i10, i11);
        m55102b(properties.f4364a);
        m55094a(properties.f4366c);
        m55107b(properties.f4367d);
    }

    /* renamed from: c */
    private View m55110c(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        return this.f43650b ? m55087a(c0852v, c0856z) : m55101b(c0852v, c0856z);
    }

    /* renamed from: b */
    private void m55106b(bzrwd bzrwdVar) {
        m55111c(bzrwdVar.f43698b, bzrwdVar.f43699c);
    }

    /* renamed from: c */
    private View m55109c() {
        return m55124a(0, getChildCount());
    }

    /* renamed from: b */
    public void m55133b() {
        if (this.f43656h == null) {
            this.f43656h = m55128a();
        }
    }

    /* renamed from: b */
    private int m55099b(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        m55133b();
        aauaf aauafVar = new aauaf();
        aauafVar.f43674a = m55132b(!this.f43661m, true);
        aauafVar.f43675b = m55127a(!this.f43661m, true);
        aauafVar.f43676c = this.f43661m;
        return akxao.m55348a(c0856z, this.f43653e, aauafVar, this, this.f43650b);
    }

    /* renamed from: a */
    private boolean m55095a(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, bzrwd bzrwdVar) {
        View viewM55114d;
        int iMo5561n;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (this.f43657i == null && focusedChild != null && bzrwdVar.m55151a(focusedChild, c0856z)) {
            bzrwdVar.m55153b(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.f43658j != this.f43660l) {
            return false;
        }
        if (bzrwdVar.f43700d) {
            viewM55114d = m55110c(c0852v, c0856z);
        } else {
            viewM55114d = m55114d(c0852v, c0856z);
        }
        if (viewM55114d == null) {
            return false;
        }
        bzrwdVar.m55150a(viewM55114d, getPosition(viewM55114d));
        if (!c0856z.m5308e() && supportsPredictiveItemAnimations() && (this.f43653e.mo5554g(viewM55114d) >= this.f43653e.mo5556i() || this.f43653e.mo5551d(viewM55114d) < this.f43653e.mo5561n())) {
            if (bzrwdVar.f43700d) {
                iMo5561n = this.f43653e.mo5556i();
            } else {
                iMo5561n = this.f43653e.mo5561n();
            }
            bzrwdVar.f43699c = iMo5561n;
        }
        return true;
    }

    /* renamed from: b */
    private void m55104b(RecyclerView.C0852v c0852v, int i10, int i11) {
        int childCount = getChildCount();
        if (i10 < 0) {
            return;
        }
        int iMo5555h = (this.f43653e.mo5555h() - i10) + i11;
        if (this.f43650b) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (this.f43653e.mo5554g(childAt) < iMo5555h || this.f43653e.mo5565r(childAt) < iMo5555h) {
                    m55089a(c0852v, 0, i12);
                    return;
                }
            }
            return;
        }
        int i13 = childCount - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            View childAt2 = getChildAt(i14);
            if (this.f43653e.mo5554g(childAt2) < iMo5555h || this.f43653e.mo5565r(childAt2) < iMo5555h) {
                m55089a(c0852v, i13, i14);
                return;
            }
        }
    }

    /* renamed from: b */
    public View m55132b(boolean z10, boolean z11) {
        if (this.f43650b) {
            return m55125a(getChildCount() - 1, -1, z10, z11);
        }
        return m55125a(0, getChildCount(), z10, z11);
    }

    /* renamed from: a */
    private boolean m55096a(RecyclerView.C0856z c0856z, bzrwd bzrwdVar) {
        int i10;
        if (!c0856z.m5308e() && (i10 = this.f43651c) != -1) {
            if (i10 >= 0 && i10 < c0856z.m5305b()) {
                bzrwdVar.f43698b = this.f43651c;
                SavedState savedState = this.f43654f;
                if (savedState != null && savedState.m55137a()) {
                    boolean z10 = this.f43654f.f43673c;
                    bzrwdVar.f43700d = z10;
                    if (z10) {
                        bzrwdVar.f43699c = this.f43653e.mo5556i() - this.f43654f.f43672b;
                    } else {
                        bzrwdVar.f43699c = this.f43653e.mo5561n() + this.f43654f.f43672b;
                    }
                    return true;
                }
                if (this.f43652d == Integer.MIN_VALUE) {
                    return m55097a(bzrwdVar, findViewByPosition(this.f43651c));
                }
                boolean z11 = this.f43650b;
                bzrwdVar.f43700d = z11;
                if (z11) {
                    bzrwdVar.f43699c = this.f43653e.mo5556i() - this.f43652d;
                } else {
                    bzrwdVar.f43699c = this.f43653e.mo5561n() + this.f43652d;
                }
                return true;
            }
            this.f43651c = -1;
            this.f43652d = Integer.MIN_VALUE;
        }
        return false;
    }

    /* renamed from: b */
    private View m55101b(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        return m55126a(c0852v, c0856z, getChildCount() - 1, -1, c0856z.m5305b());
    }

    /* renamed from: b */
    private View m55100b(int i10, int i11, int i12, int i13) throws NoSuchFieldException, SecurityException {
        try {
            if (this.f43668t == null) {
                Field declaredField = RecyclerView.AbstractC0846p.class.getDeclaredField("mVerticalBoundCheck");
                declaredField.setAccessible(true);
                this.f43668t = declaredField.get(this);
            }
            if (this.f43666r == null) {
                Class cls = Integer.TYPE;
                this.f43666r = HwReflectUtil.getMethod("findOneViewWithinBoundFlags", new Class[]{cls, cls, cls, cls}, "androidx.recyclerview.widget.ViewBoundsCheck");
            }
            Object objInvokeMethod = HwReflectUtil.invokeMethod(this.f43668t, this.f43666r, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
            if (objInvokeMethod instanceof View) {
                return (View) objInvokeMethod;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            Log.e(f43643S, "Reflect findVerticalOneViewWithinBoundFlags failed!");
            return null;
        }
    }

    /* renamed from: a */
    private boolean m55097a(bzrwd bzrwdVar, View view) {
        int iMo5554g;
        if (bzrwdVar == null) {
            return false;
        }
        if (view != null) {
            if (this.f43653e.mo5552e(view) > this.f43653e.mo5562o()) {
                bzrwdVar.m55149a();
                return true;
            }
            if (this.f43653e.mo5554g(view) - this.f43653e.mo5561n() < 0) {
                bzrwdVar.f43699c = this.f43653e.mo5561n();
                bzrwdVar.f43700d = false;
                return true;
            }
            if (this.f43653e.mo5556i() - this.f43653e.mo5551d(view) < 0) {
                bzrwdVar.f43699c = this.f43653e.mo5556i();
                bzrwdVar.f43700d = true;
                return true;
            }
            if (bzrwdVar.f43700d) {
                iMo5554g = this.f43653e.mo5551d(view) + this.f43653e.m5563p();
            } else {
                iMo5554g = this.f43653e.mo5554g(view);
            }
            bzrwdVar.f43699c = iMo5554g;
        } else {
            if (getChildCount() > 0) {
                bzrwdVar.f43700d = (this.f43651c < getPosition(getChildAt(0))) == this.f43650b;
            }
            bzrwdVar.m55149a();
        }
        return true;
    }

    /* renamed from: a */
    private int m55084a(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iMo5556i;
        int iMo5556i2 = this.f43653e.mo5556i() - i10;
        if (iMo5556i2 <= 0) {
            return 0;
        }
        int i11 = -m55122a(-iMo5556i2, c0852v, c0856z);
        int i12 = i10 + i11;
        if (!z10 || (iMo5556i = this.f43653e.mo5556i() - i12) <= 0) {
            return i11;
        }
        this.f43653e.mo5566s(iMo5556i);
        return iMo5556i + i11;
    }

    /* renamed from: a */
    private void m55093a(bzrwd bzrwdVar) {
        m55103b(bzrwdVar.f43698b, bzrwdVar.f43699c);
    }

    /* renamed from: a */
    public bqmxo m55128a() {
        return new bqmxo();
    }

    /* renamed from: a */
    private int m55085a(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        m55133b();
        aauaf aauafVar = new aauaf();
        aauafVar.f43674a = m55132b(!this.f43661m, true);
        aauafVar.f43675b = m55127a(!this.f43661m, true);
        aauafVar.f43676c = this.f43661m;
        return akxao.m55347a(c0856z, this.f43653e, aauafVar, this);
    }

    /* renamed from: a */
    private void m55088a(int i10, int i11, boolean z10, RecyclerView.C0856z c0856z) {
        int iMo5561n;
        this.f43656h.f43696m = m55134j();
        this.f43656h.f43689f = i10;
        int[] iArr = this.f43665q;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0856z, iArr);
        int iMax = Math.max(0, this.f43665q[0]);
        int iMax2 = Math.max(0, this.f43665q[1]);
        boolean z11 = i10 == 1;
        bqmxo bqmxoVar = this.f43656h;
        int i12 = z11 ? iMax2 : iMax;
        bqmxoVar.f43691h = i12;
        if (!z11) {
            iMax = iMax2;
        }
        bqmxoVar.f43692i = iMax;
        if (z11) {
            bqmxoVar.f43691h = i12 + this.f43653e.mo5557j();
            View viewM55117g = m55117g();
            bqmxo bqmxoVar2 = this.f43656h;
            bqmxoVar2.f43688e = this.f43650b ? -1 : 1;
            int position = getPosition(viewM55117g);
            bqmxo bqmxoVar3 = this.f43656h;
            bqmxoVar2.f43687d = position + bqmxoVar3.f43688e;
            bqmxoVar3.f43685b = this.f43653e.mo5551d(viewM55117g);
            iMo5561n = this.f43653e.mo5551d(viewM55117g) - this.f43653e.mo5556i();
        } else {
            View viewM55118h = m55118h();
            this.f43656h.f43691h += this.f43653e.mo5561n();
            bqmxo bqmxoVar4 = this.f43656h;
            bqmxoVar4.f43688e = this.f43650b ? 1 : -1;
            int position2 = getPosition(viewM55118h);
            bqmxo bqmxoVar5 = this.f43656h;
            bqmxoVar4.f43687d = position2 + bqmxoVar5.f43688e;
            bqmxoVar5.f43685b = this.f43653e.mo5554g(viewM55118h);
            iMo5561n = (-this.f43653e.mo5554g(viewM55118h)) + this.f43653e.mo5561n();
        }
        bqmxo bqmxoVar6 = this.f43656h;
        bqmxoVar6.f43686c = i11;
        if (z10) {
            bqmxoVar6.f43686c = i11 - iMo5561n;
        }
        bqmxoVar6.f43690g = iMo5561n;
    }

    /* renamed from: a */
    public void m55131a(RecyclerView.C0856z c0856z, bqmxo bqmxoVar, RecyclerView.AbstractC0846p.c cVar) {
        int i10 = bqmxoVar.f43687d;
        if (i10 < 0 || i10 >= c0856z.m5305b()) {
            return;
        }
        cVar.mo5245a(i10, Math.max(0, bqmxoVar.f43690g));
    }

    /* renamed from: a */
    public int m55122a(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        m55133b();
        this.f43656h.f43684a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int iAbs = Math.abs(i10);
        m55088a(i11, iAbs, true, c0856z);
        bqmxo bqmxoVar = this.f43656h;
        int iM55123a = bqmxoVar.f43690g + m55123a(c0852v, bqmxoVar, c0856z, false);
        if (iM55123a < 0) {
            return 0;
        }
        if (iAbs > iM55123a) {
            i10 = i11 * iM55123a;
        }
        this.f43653e.mo5566s(-i10);
        this.f43656h.f43694k = i10;
        return i10;
    }

    /* renamed from: a */
    private void m55089a(RecyclerView.C0852v c0852v, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                removeAndRecycleViewAt(i10, c0852v);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                removeAndRecycleViewAt(i12, c0852v);
            }
        }
    }

    /* renamed from: a */
    private void m55091a(RecyclerView.C0852v c0852v, bqmxo bqmxoVar) {
        if (!bqmxoVar.f43684a || bqmxoVar.f43696m) {
            return;
        }
        int i10 = bqmxoVar.f43690g;
        int i11 = bqmxoVar.f43692i;
        if (bqmxoVar.f43689f == -1) {
            m55104b(c0852v, i10, i11);
        } else {
            m55112c(c0852v, i10, i11);
        }
    }

    /* renamed from: a */
    public int m55123a(RecyclerView.C0852v c0852v, bqmxo bqmxoVar, RecyclerView.C0856z c0856z, boolean z10) {
        int i10 = bqmxoVar.f43686c;
        int i11 = bqmxoVar.f43690g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                bqmxoVar.f43690g = i11 + i10;
            }
            m55091a(c0852v, bqmxoVar);
        }
        int i12 = bqmxoVar.f43686c + bqmxoVar.f43691h;
        LayoutChunkResult layoutChunkResult = this.f43663o;
        while (true) {
            if ((!bqmxoVar.f43696m && i12 <= 0) || !bqmxoVar.m55145a(c0856z)) {
                break;
            }
            layoutChunkResult.m55136a();
            m55129a(c0852v, c0856z, bqmxoVar, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                bqmxoVar.f43685b += layoutChunkResult.mConsumed * bqmxoVar.f43689f;
                if (!layoutChunkResult.mIgnoreConsumed || bqmxoVar.f43695l != null || !c0856z.m5308e()) {
                    int i13 = bqmxoVar.f43686c;
                    int i14 = layoutChunkResult.mConsumed;
                    bqmxoVar.f43686c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = bqmxoVar.f43690g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + layoutChunkResult.mConsumed;
                    bqmxoVar.f43690g = i16;
                    int i17 = bqmxoVar.f43686c;
                    if (i17 < 0) {
                        bqmxoVar.f43690g = i16 + i17;
                    }
                    m55091a(c0852v, bqmxoVar);
                }
                if (z10 && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - bqmxoVar.f43686c;
    }

    /* renamed from: a */
    public void m55129a(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, bqmxo bqmxoVar, LayoutChunkResult layoutChunkResult) {
        View viewM55142a = bqmxoVar.m55142a(c0852v);
        if (viewM55142a == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        if (bqmxoVar.f43695l == null) {
            if (this.f43650b == (bqmxoVar.f43689f == -1)) {
                addView(viewM55142a);
            } else {
                addView(viewM55142a, 0);
            }
        } else {
            if (this.f43650b == (bqmxoVar.f43689f == -1)) {
                addDisappearingView(viewM55142a);
            } else {
                addDisappearingView(viewM55142a, 0);
            }
        }
        measureChildWithMargins(viewM55142a, 0, 0);
        layoutChunkResult.mConsumed = this.f43653e.mo5552e(viewM55142a);
        m55092a(bqmxoVar, layoutChunkResult, viewM55142a);
        layoutChunkResult.mFocusable = viewM55142a.hasFocusable();
    }

    /* renamed from: a */
    private void m55092a(bqmxo bqmxoVar, LayoutChunkResult layoutChunkResult, View view) {
        int i10;
        int i11;
        int i12;
        int i13;
        int paddingLeft;
        int iMo5553f;
        int i14;
        int i15;
        if (bqmxoVar == null || layoutChunkResult == null || view == null) {
            return;
        }
        if (this.f43649a == 1) {
            if (isLayoutRTL()) {
                iMo5553f = getWidth() - getPaddingRight();
                paddingLeft = iMo5553f - this.f43653e.mo5553f(view);
            } else {
                paddingLeft = getPaddingLeft();
                iMo5553f = this.f43653e.mo5553f(view) + paddingLeft;
            }
            if (bqmxoVar.f43689f == -1) {
                i15 = bqmxoVar.f43685b;
                i14 = i15 - layoutChunkResult.mConsumed;
            } else {
                i14 = bqmxoVar.f43685b;
                i15 = layoutChunkResult.mConsumed + i14;
            }
            i13 = i15;
            i12 = iMo5553f;
            i11 = i14;
            i10 = paddingLeft;
        } else {
            int paddingTop = getPaddingTop();
            int iMo5553f2 = this.f43653e.mo5553f(view) + paddingTop;
            if (bqmxoVar.f43689f == -1) {
                int i16 = bqmxoVar.f43685b;
                i12 = i16;
                i11 = paddingTop;
                i10 = i16 - layoutChunkResult.mConsumed;
            } else {
                int i17 = bqmxoVar.f43685b;
                i10 = i17;
                i11 = paddingTop;
                i12 = layoutChunkResult.mConsumed + i17;
            }
            i13 = iMo5553f2;
        }
        layoutDecoratedWithMargins(view, i10, i11, i12, i13);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            if (layoutParams2.m5127d() || layoutParams2.m5126c()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
        }
    }

    /* renamed from: a */
    public int m55121a(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f43649a == 1) ? 1 : Integer.MIN_VALUE : this.f43649a == 0 ? 1 : Integer.MIN_VALUE : this.f43649a == 1 ? -1 : Integer.MIN_VALUE : this.f43649a == 0 ? -1 : Integer.MIN_VALUE : (this.f43649a != 1 && isLayoutRTL()) ? -1 : 1 : (this.f43649a != 1 && isLayoutRTL()) ? 1 : -1;
    }

    /* renamed from: a */
    public View m55127a(boolean z10, boolean z11) {
        if (this.f43650b) {
            return m55125a(0, getChildCount(), z10, z11);
        }
        return m55125a(getChildCount() - 1, -1, z10, z11);
    }

    /* renamed from: a */
    private View m55087a(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        return m55126a(c0852v, c0856z, 0, getChildCount(), c0856z.m5305b());
    }

    /* renamed from: a */
    public View m55126a(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10, int i11, int i12) {
        OnReferenceItemListener onReferenceItemListener;
        m55133b();
        int iMo5561n = this.f43653e.mo5561n();
        int iMo5556i = this.f43653e.mo5556i();
        View view = null;
        int i13 = i11 > i10 ? 1 : -1;
        View view2 = null;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            int position = getPosition(childAt);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof RecyclerView.LayoutParams) && position >= 0 && position < i12) {
                if (((RecyclerView.LayoutParams) layoutParams).m5127d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.f43653e.mo5554g(childAt) < iMo5556i && this.f43653e.mo5551d(childAt) >= iMo5561n) {
                    OnReferenceItemListener onReferenceItemListener2 = this.f43657i;
                    if (onReferenceItemListener2 == null || onReferenceItemListener2.isNeedRefreshReferenceLayout(childAt)) {
                        return childAt;
                    }
                } else if (view == null && ((onReferenceItemListener = this.f43657i) == null || onReferenceItemListener.isNeedRefreshReferenceLayout(childAt))) {
                    view = childAt;
                }
            }
            i10 += i13;
        }
        return view != null ? view : view2;
    }

    /* renamed from: a */
    public View m55125a(int i10, int i11, boolean z10, boolean z11) {
        m55133b();
        int i12 = z10 ? 24579 : 320;
        int i13 = z11 ? 320 : 0;
        if (this.f43649a == 0) {
            return m55086a(i10, i11, i12, i13);
        }
        return m55100b(i10, i11, i12, i13);
    }

    /* renamed from: a */
    public View m55124a(int i10, int i11) {
        int i12;
        int i13;
        m55133b();
        if (i11 > i10 || i11 < i10) {
            if (this.f43653e.mo5554g(getChildAt(i10)) < this.f43653e.mo5561n()) {
                i12 = 16644;
                i13 = 16388;
            } else {
                i12 = 4161;
                i13 = 4097;
            }
            if (this.f43649a == 0) {
                return m55086a(i10, i11, i12, i13);
            }
            return m55100b(i10, i11, i12, i13);
        }
        return getChildAt(i10);
    }

    /* renamed from: a */
    private View m55086a(int i10, int i11, int i12, int i13) throws NoSuchFieldException, SecurityException {
        try {
            if (this.f43667s == null) {
                Field declaredField = RecyclerView.AbstractC0846p.class.getDeclaredField("mHorizontalBoundCheck");
                declaredField.setAccessible(true);
                this.f43667s = declaredField.get(this);
            }
            if (this.f43666r == null) {
                Class cls = Integer.TYPE;
                this.f43666r = HwReflectUtil.getMethod("findOneViewWithinBoundFlags", new Class[]{cls, cls, cls, cls}, "androidx.recyclerview.widget.ViewBoundsCheck");
            }
            Object objInvokeMethod = HwReflectUtil.invokeMethod(this.f43667s, this.f43666r, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
            if (objInvokeMethod instanceof View) {
                return (View) objInvokeMethod;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            Log.e(f43643S, "Reflect findHorizontalOneViewWithinBoundFlags failed!");
            return null;
        }
    }
}
