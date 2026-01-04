package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.AbstractC0846p implements RecyclerView.AbstractC0855y.b {

    /* renamed from: W */
    public C0861c[] f4408W;

    /* renamed from: X */
    public AbstractC0875n f4409X;

    /* renamed from: Y */
    public AbstractC0875n f4410Y;

    /* renamed from: Z */
    public int f4411Z;

    /* renamed from: a0 */
    public int f4412a0;

    /* renamed from: b0 */
    public final C0872k f4413b0;

    /* renamed from: e0 */
    public BitSet f4416e0;

    /* renamed from: j0 */
    public boolean f4421j0;

    /* renamed from: k0 */
    public boolean f4422k0;

    /* renamed from: l0 */
    public SavedState f4423l0;

    /* renamed from: m0 */
    public int f4424m0;

    /* renamed from: r0 */
    public int[] f4429r0;

    /* renamed from: V */
    public int f4407V = -1;

    /* renamed from: c0 */
    public boolean f4414c0 = false;

    /* renamed from: d0 */
    public boolean f4415d0 = false;

    /* renamed from: f0 */
    public int f4417f0 = -1;

    /* renamed from: g0 */
    public int f4418g0 = Integer.MIN_VALUE;

    /* renamed from: h0 */
    public LazySpanLookup f4419h0 = new LazySpanLookup();

    /* renamed from: i0 */
    public int f4420i0 = 2;

    /* renamed from: n0 */
    public final Rect f4425n0 = new Rect();

    /* renamed from: o0 */
    public final C0860b f4426o0 = new C0860b();

    /* renamed from: p0 */
    public boolean f4427p0 = false;

    /* renamed from: q0 */
    public boolean f4428q0 = true;

    /* renamed from: s0 */
    public final Runnable f4430s0 = new RunnableC0859a();

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e */
        public C0861c f4431e;

        /* renamed from: f */
        public boolean f4432f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: f */
        public boolean m5358f() {
            return this.f4432f;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0858a();

        /* renamed from: a */
        public int f4439a;

        /* renamed from: b */
        public int f4440b;

        /* renamed from: c */
        public int f4441c;

        /* renamed from: d */
        public int[] f4442d;

        /* renamed from: e */
        public int f4443e;

        /* renamed from: f */
        public int[] f4444f;

        /* renamed from: g */
        public List<LazySpanLookup.FullSpanItem> f4445g;

        /* renamed from: h */
        public boolean f4446h;

        /* renamed from: i */
        public boolean f4447i;

        /* renamed from: j */
        public boolean f4448j;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$a */
        public class C0858a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        /* renamed from: a */
        public void m5377a() {
            this.f4442d = null;
            this.f4441c = 0;
            this.f4439a = -1;
            this.f4440b = -1;
        }

        /* renamed from: c */
        public void m5378c() {
            this.f4442d = null;
            this.f4441c = 0;
            this.f4443e = 0;
            this.f4444f = null;
            this.f4445g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f4439a);
            parcel.writeInt(this.f4440b);
            parcel.writeInt(this.f4441c);
            if (this.f4441c > 0) {
                parcel.writeIntArray(this.f4442d);
            }
            parcel.writeInt(this.f4443e);
            if (this.f4443e > 0) {
                parcel.writeIntArray(this.f4444f);
            }
            parcel.writeInt(this.f4446h ? 1 : 0);
            parcel.writeInt(this.f4447i ? 1 : 0);
            parcel.writeInt(this.f4448j ? 1 : 0);
            parcel.writeList(this.f4445g);
        }

        public SavedState(Parcel parcel) {
            this.f4439a = parcel.readInt();
            this.f4440b = parcel.readInt();
            int i10 = parcel.readInt();
            this.f4441c = i10;
            if (i10 > 0) {
                int[] iArr = new int[i10];
                this.f4442d = iArr;
                parcel.readIntArray(iArr);
            }
            int i11 = parcel.readInt();
            this.f4443e = i11;
            if (i11 > 0) {
                int[] iArr2 = new int[i11];
                this.f4444f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f4446h = parcel.readInt() == 1;
            this.f4447i = parcel.readInt() == 1;
            this.f4448j = parcel.readInt() == 1;
            this.f4445g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f4441c = savedState.f4441c;
            this.f4439a = savedState.f4439a;
            this.f4440b = savedState.f4440b;
            this.f4442d = savedState.f4442d;
            this.f4443e = savedState.f4443e;
            this.f4444f = savedState.f4444f;
            this.f4446h = savedState.f4446h;
            this.f4447i = savedState.f4447i;
            this.f4448j = savedState.f4448j;
            this.f4445g = savedState.f4445g;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$a */
    public class RunnableC0859a implements Runnable {
        public RunnableC0859a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m5351t();
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$b */
    public class C0860b {

        /* renamed from: a */
        public int f4450a;

        /* renamed from: b */
        public int f4451b;

        /* renamed from: c */
        public boolean f4452c;

        /* renamed from: d */
        public boolean f4453d;

        /* renamed from: e */
        public boolean f4454e;

        /* renamed from: f */
        public int[] f4455f;

        public C0860b() {
            m5383c();
        }

        /* renamed from: a */
        public void m5381a() {
            this.f4451b = this.f4452c ? StaggeredGridLayoutManager.this.f4409X.mo5556i() : StaggeredGridLayoutManager.this.f4409X.mo5561n();
        }

        /* renamed from: b */
        public void m5382b(int i10) {
            if (this.f4452c) {
                this.f4451b = StaggeredGridLayoutManager.this.f4409X.mo5556i() - i10;
            } else {
                this.f4451b = StaggeredGridLayoutManager.this.f4409X.mo5561n() + i10;
            }
        }

        /* renamed from: c */
        public void m5383c() {
            this.f4450a = -1;
            this.f4451b = Integer.MIN_VALUE;
            this.f4452c = false;
            this.f4453d = false;
            this.f4454e = false;
            int[] iArr = this.f4455f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* renamed from: d */
        public void m5384d(C0861c[] c0861cArr) {
            int length = c0861cArr.length;
            int[] iArr = this.f4455f;
            if (iArr == null || iArr.length < length) {
                this.f4455f = new int[StaggeredGridLayoutManager.this.f4408W.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f4455f[i10] = c0861cArr[i10].m5400p(Integer.MIN_VALUE);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c */
    public class C0861c {

        /* renamed from: a */
        public ArrayList<View> f4457a = new ArrayList<>();

        /* renamed from: b */
        public int f4458b = Integer.MIN_VALUE;

        /* renamed from: c */
        public int f4459c = Integer.MIN_VALUE;

        /* renamed from: d */
        public int f4460d = 0;

        /* renamed from: e */
        public final int f4461e;

        public C0861c(int i10) {
            this.f4461e = i10;
        }

        /* renamed from: a */
        public void m5385a(View view) {
            LayoutParams layoutParamsM5398n = m5398n(view);
            layoutParamsM5398n.f4431e = this;
            this.f4457a.add(view);
            this.f4459c = Integer.MIN_VALUE;
            if (this.f4457a.size() == 1) {
                this.f4458b = Integer.MIN_VALUE;
            }
            if (layoutParamsM5398n.m5127d() || layoutParamsM5398n.m5126c()) {
                this.f4460d += StaggeredGridLayoutManager.this.f4409X.mo5552e(view);
            }
        }

        /* renamed from: b */
        public void m5386b(boolean z10, int i10) {
            int iM5396l = z10 ? m5396l(Integer.MIN_VALUE) : m5400p(Integer.MIN_VALUE);
            m5389e();
            if (iM5396l == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || iM5396l >= StaggeredGridLayoutManager.this.f4409X.mo5556i()) {
                if (z10 || iM5396l <= StaggeredGridLayoutManager.this.f4409X.mo5561n()) {
                    if (i10 != Integer.MIN_VALUE) {
                        iM5396l += i10;
                    }
                    this.f4459c = iM5396l;
                    this.f4458b = iM5396l;
                }
            }
        }

        /* renamed from: c */
        public void m5387c() {
            LazySpanLookup.FullSpanItem fullSpanItemM5364f;
            ArrayList<View> arrayList = this.f4457a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParamsM5398n = m5398n(view);
            this.f4459c = StaggeredGridLayoutManager.this.f4409X.mo5551d(view);
            if (layoutParamsM5398n.f4432f && (fullSpanItemM5364f = StaggeredGridLayoutManager.this.f4419h0.m5364f(layoutParamsM5398n.m5125a())) != null && fullSpanItemM5364f.f4436b == 1) {
                this.f4459c += fullSpanItemM5364f.m5374a(this.f4461e);
            }
        }

        /* renamed from: d */
        public void m5388d() {
            LazySpanLookup.FullSpanItem fullSpanItemM5364f;
            View view = this.f4457a.get(0);
            LayoutParams layoutParamsM5398n = m5398n(view);
            this.f4458b = StaggeredGridLayoutManager.this.f4409X.mo5554g(view);
            if (layoutParamsM5398n.f4432f && (fullSpanItemM5364f = StaggeredGridLayoutManager.this.f4419h0.m5364f(layoutParamsM5398n.m5125a())) != null && fullSpanItemM5364f.f4436b == -1) {
                this.f4458b -= fullSpanItemM5364f.m5374a(this.f4461e);
            }
        }

        /* renamed from: e */
        public void m5389e() {
            this.f4457a.clear();
            m5401q();
            this.f4460d = 0;
        }

        /* renamed from: f */
        public int m5390f() {
            return StaggeredGridLayoutManager.this.f4414c0 ? m5393i(this.f4457a.size() - 1, -1, true) : m5393i(0, this.f4457a.size(), true);
        }

        /* renamed from: g */
        public int m5391g() {
            return StaggeredGridLayoutManager.this.f4414c0 ? m5393i(0, this.f4457a.size(), true) : m5393i(this.f4457a.size() - 1, -1, true);
        }

        /* renamed from: h */
        public int m5392h(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int iMo5561n = StaggeredGridLayoutManager.this.f4409X.mo5561n();
            int iMo5556i = StaggeredGridLayoutManager.this.f4409X.mo5556i();
            int i12 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = this.f4457a.get(i10);
                int iMo5554g = StaggeredGridLayoutManager.this.f4409X.mo5554g(view);
                int iMo5551d = StaggeredGridLayoutManager.this.f4409X.mo5551d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? iMo5554g >= iMo5556i : iMo5554g > iMo5556i;
                if (!z12 ? iMo5551d > iMo5561n : iMo5551d >= iMo5561n) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (z10 && z11) {
                        if (iMo5554g >= iMo5561n && iMo5551d <= iMo5556i) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (iMo5554g < iMo5561n || iMo5551d > iMo5556i) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i10 += i12;
            }
            return -1;
        }

        /* renamed from: i */
        public int m5393i(int i10, int i11, boolean z10) {
            return m5392h(i10, i11, false, false, z10);
        }

        /* renamed from: j */
        public int m5394j() {
            return this.f4460d;
        }

        /* renamed from: k */
        public int m5395k() {
            int i10 = this.f4459c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            m5387c();
            return this.f4459c;
        }

        /* renamed from: l */
        public int m5396l(int i10) {
            int i11 = this.f4459c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f4457a.size() == 0) {
                return i10;
            }
            m5387c();
            return this.f4459c;
        }

        /* renamed from: m */
        public View m5397m(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f4457a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f4457a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f4414c0 && staggeredGridLayoutManager.getPosition(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f4414c0 && staggeredGridLayoutManager2.getPosition(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f4457a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = this.f4457a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f4414c0 && staggeredGridLayoutManager3.getPosition(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f4414c0 && staggeredGridLayoutManager4.getPosition(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        /* renamed from: n */
        public LayoutParams m5398n(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* renamed from: o */
        public int m5399o() {
            int i10 = this.f4458b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            m5388d();
            return this.f4458b;
        }

        /* renamed from: p */
        public int m5400p(int i10) {
            int i11 = this.f4458b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f4457a.size() == 0) {
                return i10;
            }
            m5388d();
            return this.f4458b;
        }

        /* renamed from: q */
        public void m5401q() {
            this.f4458b = Integer.MIN_VALUE;
            this.f4459c = Integer.MIN_VALUE;
        }

        /* renamed from: r */
        public void m5402r(int i10) {
            int i11 = this.f4458b;
            if (i11 != Integer.MIN_VALUE) {
                this.f4458b = i11 + i10;
            }
            int i12 = this.f4459c;
            if (i12 != Integer.MIN_VALUE) {
                this.f4459c = i12 + i10;
            }
        }

        /* renamed from: s */
        public void m5403s() {
            int size = this.f4457a.size();
            View viewRemove = this.f4457a.remove(size - 1);
            LayoutParams layoutParamsM5398n = m5398n(viewRemove);
            layoutParamsM5398n.f4431e = null;
            if (layoutParamsM5398n.m5127d() || layoutParamsM5398n.m5126c()) {
                this.f4460d -= StaggeredGridLayoutManager.this.f4409X.mo5552e(viewRemove);
            }
            if (size == 1) {
                this.f4458b = Integer.MIN_VALUE;
            }
            this.f4459c = Integer.MIN_VALUE;
        }

        /* renamed from: t */
        public void m5404t() {
            View viewRemove = this.f4457a.remove(0);
            LayoutParams layoutParamsM5398n = m5398n(viewRemove);
            layoutParamsM5398n.f4431e = null;
            if (this.f4457a.size() == 0) {
                this.f4459c = Integer.MIN_VALUE;
            }
            if (layoutParamsM5398n.m5127d() || layoutParamsM5398n.m5126c()) {
                this.f4460d -= StaggeredGridLayoutManager.this.f4409X.mo5552e(viewRemove);
            }
            this.f4458b = Integer.MIN_VALUE;
        }

        /* renamed from: u */
        public void m5405u(View view) {
            LayoutParams layoutParamsM5398n = m5398n(view);
            layoutParamsM5398n.f4431e = this;
            this.f4457a.add(0, view);
            this.f4458b = Integer.MIN_VALUE;
            if (this.f4457a.size() == 1) {
                this.f4459c = Integer.MIN_VALUE;
            }
            if (layoutParamsM5398n.m5127d() || layoutParamsM5398n.m5126c()) {
                this.f4460d += StaggeredGridLayoutManager.this.f4409X.mo5552e(view);
            }
        }

        /* renamed from: v */
        public void m5406v(int i10) {
            this.f4458b = i10;
            this.f4459c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.AbstractC0846p.d properties = RecyclerView.AbstractC0846p.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f4364a);
        setSpanCount(properties.f4365b);
        setReverseLayout(properties.f4366c);
        this.f4413b0 = new C0872k();
        m5355x();
    }

    private int computeScrollExtent(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0878q.m5579a(c0856z, this.f4409X, m5312B(!this.f4428q0), m5311A(!this.f4428q0), this, this.f4428q0);
    }

    private int computeScrollOffset(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0878q.m5580b(c0856z, this.f4409X, m5312B(!this.f4428q0), m5311A(!this.f4428q0), this, this.f4428q0, this.f4415d0);
    }

    private int computeScrollRange(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0878q.m5581c(c0856z, this.f4409X, m5312B(!this.f4428q0), m5311A(!this.f4428q0), this, this.f4428q0);
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f4411Z == 1) ? 1 : Integer.MIN_VALUE : this.f4411Z == 0 ? 1 : Integer.MIN_VALUE : this.f4411Z == 1 ? -1 : Integer.MIN_VALUE : this.f4411Z == 0 ? -1 : Integer.MIN_VALUE : (this.f4411Z != 1 && isLayoutRTL()) ? -1 : 1 : (this.f4411Z != 1 && isLayoutRTL()) ? 1 : -1;
    }

    /* renamed from: A */
    public View m5311A(boolean z10) {
        int iMo5561n = this.f4409X.mo5561n();
        int iMo5556i = this.f4409X.mo5556i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iMo5554g = this.f4409X.mo5554g(childAt);
            int iMo5551d = this.f4409X.mo5551d(childAt);
            if (iMo5551d > iMo5561n && iMo5554g < iMo5556i) {
                if (iMo5551d <= iMo5556i || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: B */
    public View m5312B(boolean z10) {
        int iMo5561n = this.f4409X.mo5561n();
        int iMo5556i = this.f4409X.mo5556i();
        int childCount = getChildCount();
        View view = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int iMo5554g = this.f4409X.mo5554g(childAt);
            if (this.f4409X.mo5551d(childAt) > iMo5561n && iMo5554g < iMo5556i) {
                if (iMo5554g >= iMo5561n || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: C */
    public int m5313C() {
        View viewM5311A = this.f4415d0 ? m5311A(true) : m5312B(true);
        if (viewM5311A == null) {
            return -1;
        }
        return getPosition(viewM5311A);
    }

    /* renamed from: D */
    public final int m5314D(int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: E */
    public final void m5315E(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iMo5556i;
        int iM5319I = m5319I(Integer.MIN_VALUE);
        if (iM5319I != Integer.MIN_VALUE && (iMo5556i = this.f4409X.mo5556i() - iM5319I) > 0) {
            int i10 = iMo5556i - (-scrollBy(-iMo5556i, c0852v, c0856z));
            if (!z10 || i10 <= 0) {
                return;
            }
            this.f4409X.mo5566s(i10);
        }
    }

    /* renamed from: F */
    public final void m5316F(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iMo5561n;
        int iM5322L = m5322L(Integer.MAX_VALUE);
        if (iM5322L != Integer.MAX_VALUE && (iMo5561n = iM5322L - this.f4409X.mo5561n()) > 0) {
            int iScrollBy = iMo5561n - scrollBy(iMo5561n, c0852v, c0856z);
            if (!z10 || iScrollBy <= 0) {
                return;
            }
            this.f4409X.mo5566s(-iScrollBy);
        }
    }

    /* renamed from: G */
    public int m5317G() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* renamed from: H */
    public int m5318H() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* renamed from: I */
    public final int m5319I(int i10) {
        int iM5396l = this.f4408W[0].m5396l(i10);
        for (int i11 = 1; i11 < this.f4407V; i11++) {
            int iM5396l2 = this.f4408W[i11].m5396l(i10);
            if (iM5396l2 > iM5396l) {
                iM5396l = iM5396l2;
            }
        }
        return iM5396l;
    }

    /* renamed from: J */
    public final int m5320J(int i10) {
        int iM5400p = this.f4408W[0].m5400p(i10);
        for (int i11 = 1; i11 < this.f4407V; i11++) {
            int iM5400p2 = this.f4408W[i11].m5400p(i10);
            if (iM5400p2 > iM5400p) {
                iM5400p = iM5400p2;
            }
        }
        return iM5400p;
    }

    /* renamed from: K */
    public final int m5321K(int i10) {
        int iM5396l = this.f4408W[0].m5396l(i10);
        for (int i11 = 1; i11 < this.f4407V; i11++) {
            int iM5396l2 = this.f4408W[i11].m5396l(i10);
            if (iM5396l2 < iM5396l) {
                iM5396l = iM5396l2;
            }
        }
        return iM5396l;
    }

    /* renamed from: L */
    public final int m5322L(int i10) {
        int iM5400p = this.f4408W[0].m5400p(i10);
        for (int i11 = 1; i11 < this.f4407V; i11++) {
            int iM5400p2 = this.f4408W[i11].m5400p(i10);
            if (iM5400p2 < iM5400p) {
                iM5400p = iM5400p2;
            }
        }
        return iM5400p;
    }

    /* renamed from: M */
    public final C0861c m5323M(C0872k c0872k) {
        int i10;
        int i11;
        int i12;
        if (m5329S(c0872k.f4617e)) {
            i11 = this.f4407V - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = this.f4407V;
            i11 = 0;
            i12 = 1;
        }
        C0861c c0861c = null;
        if (c0872k.f4617e == 1) {
            int iMo5561n = this.f4409X.mo5561n();
            int i13 = Integer.MAX_VALUE;
            while (i11 != i10) {
                C0861c c0861c2 = this.f4408W[i11];
                int iM5396l = c0861c2.m5396l(iMo5561n);
                if (iM5396l < i13) {
                    c0861c = c0861c2;
                    i13 = iM5396l;
                }
                i11 += i12;
            }
            return c0861c;
        }
        int iMo5556i = this.f4409X.mo5556i();
        int i14 = Integer.MIN_VALUE;
        while (i11 != i10) {
            C0861c c0861c3 = this.f4408W[i11];
            int iM5400p = c0861c3.m5400p(iMo5556i);
            if (iM5400p > i14) {
                c0861c = c0861c3;
                i14 = iM5400p;
            }
            i11 += i12;
        }
        return c0861c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5324N(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4415d0
            if (r0 == 0) goto L9
            int r0 = r6.m5318H()
            goto Ld
        L9:
            int r0 = r6.m5317G()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f4419h0
            r4.m5366h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4419h0
            r9.m5369k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f4419h0
            r7.m5368j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4419h0
            r9.m5369k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4419h0
            r9.m5368j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.f4415d0
            if (r7 == 0) goto L4e
            int r7 = r6.m5317G()
            goto L52
        L4e:
            int r7 = r6.m5318H()
        L52:
            if (r3 > r7) goto L57
            r6.requestLayout()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m5324N(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View m5325O() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f4407V
            r2.<init>(r3)
            int r3 = r12.f4407V
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f4411Z
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.f4415d0
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f4431e
            int r9 = r9.f4461e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f4431e
            boolean r9 = r12.m5352u(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f4431e
            int r9 = r9.f4461e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f4432f
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f4415d0
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.n r10 = r12.f4409X
            int r10 = r10.mo5551d(r7)
            androidx.recyclerview.widget.n r11 = r12.f4409X
            int r11 = r11.mo5551d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.n r10 = r12.f4409X
            int r10 = r10.mo5554g(r7)
            androidx.recyclerview.widget.n r11 = r12.f4409X
            int r11 = r11.mo5554g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f4431e
            int r8 = r8.f4461e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f4431e
            int r9 = r9.f4461e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m5325O():android.view.View");
    }

    /* renamed from: P */
    public void m5326P() {
        this.f4419h0.m5360b();
        requestLayout();
    }

    /* renamed from: Q */
    public final void m5327Q(View view, LayoutParams layoutParams, boolean z10) {
        if (layoutParams.f4432f) {
            if (this.f4411Z == 1) {
                measureChildWithDecorationsAndMargin(view, this.f4424m0, RecyclerView.AbstractC0846p.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z10);
                return;
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.AbstractC0846p.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.f4424m0, z10);
                return;
            }
        }
        if (this.f4411Z == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.AbstractC0846p.getChildMeasureSpec(this.f4412a0, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.AbstractC0846p.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z10);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.AbstractC0846p.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.AbstractC0846p.getChildMeasureSpec(this.f4412a0, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5328R(androidx.recyclerview.widget.RecyclerView.C0852v r9, androidx.recyclerview.widget.RecyclerView.C0856z r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m5328R(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean):void");
    }

    /* renamed from: S */
    public final boolean m5329S(int i10) {
        if (this.f4411Z == 0) {
            return (i10 == -1) != this.f4415d0;
        }
        return ((i10 == -1) == this.f4415d0) == isLayoutRTL();
    }

    /* renamed from: T */
    public void m5330T(int i10, RecyclerView.C0856z c0856z) {
        int iM5317G;
        int i11;
        if (i10 > 0) {
            iM5317G = m5318H();
            i11 = 1;
        } else {
            iM5317G = m5317G();
            i11 = -1;
        }
        this.f4413b0.f4613a = true;
        m5341e0(iM5317G, c0856z);
        m5336Z(i11);
        C0872k c0872k = this.f4413b0;
        c0872k.f4615c = iM5317G + c0872k.f4616d;
        c0872k.f4614b = Math.abs(i10);
    }

    /* renamed from: U */
    public final void m5331U(View view) {
        for (int i10 = this.f4407V - 1; i10 >= 0; i10--) {
            this.f4408W[i10].m5405u(view);
        }
    }

    /* renamed from: V */
    public final void m5332V(RecyclerView.C0852v c0852v, C0872k c0872k) {
        if (!c0872k.f4613a || c0872k.f4621i) {
            return;
        }
        if (c0872k.f4614b == 0) {
            if (c0872k.f4617e == -1) {
                m5333W(c0852v, c0872k.f4619g);
                return;
            } else {
                m5334X(c0852v, c0872k.f4618f);
                return;
            }
        }
        if (c0872k.f4617e != -1) {
            int iM5321K = m5321K(c0872k.f4619g) - c0872k.f4619g;
            m5334X(c0852v, iM5321K < 0 ? c0872k.f4618f : Math.min(iM5321K, c0872k.f4614b) + c0872k.f4618f);
        } else {
            int i10 = c0872k.f4618f;
            int iM5320J = i10 - m5320J(i10);
            m5333W(c0852v, iM5320J < 0 ? c0872k.f4619g : c0872k.f4619g - Math.min(iM5320J, c0872k.f4614b));
        }
    }

    /* renamed from: W */
    public final void m5333W(RecyclerView.C0852v c0852v, int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f4409X.mo5554g(childAt) < i10 || this.f4409X.mo5565r(childAt) < i10) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f4432f) {
                for (int i11 = 0; i11 < this.f4407V; i11++) {
                    if (this.f4408W[i11].f4457a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f4407V; i12++) {
                    this.f4408W[i12].m5403s();
                }
            } else if (layoutParams.f4431e.f4457a.size() == 1) {
                return;
            } else {
                layoutParams.f4431e.m5403s();
            }
            removeAndRecycleView(childAt, c0852v);
        }
    }

    /* renamed from: X */
    public final void m5334X(RecyclerView.C0852v c0852v, int i10) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f4409X.mo5551d(childAt) > i10 || this.f4409X.mo5564q(childAt) > i10) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f4432f) {
                for (int i11 = 0; i11 < this.f4407V; i11++) {
                    if (this.f4408W[i11].f4457a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f4407V; i12++) {
                    this.f4408W[i12].m5404t();
                }
            } else if (layoutParams.f4431e.f4457a.size() == 1) {
                return;
            } else {
                layoutParams.f4431e.m5404t();
            }
            removeAndRecycleView(childAt, c0852v);
        }
    }

    /* renamed from: Y */
    public final void m5335Y() {
        if (this.f4410Y.mo5559l() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            float fMo5552e = this.f4410Y.mo5552e(childAt);
            if (fMo5552e >= fMax) {
                if (((LayoutParams) childAt.getLayoutParams()).m5358f()) {
                    fMo5552e = (fMo5552e * 1.0f) / this.f4407V;
                }
                fMax = Math.max(fMax, fMo5552e);
            }
        }
        int i11 = this.f4412a0;
        int iRound = Math.round(fMax * this.f4407V);
        if (this.f4410Y.mo5559l() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f4410Y.mo5562o());
        }
        m5342f0(iRound);
        if (this.f4412a0 == i11) {
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.f4432f) {
                if (isLayoutRTL() && this.f4411Z == 1) {
                    int i13 = this.f4407V;
                    int i14 = layoutParams.f4431e.f4461e;
                    childAt2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.f4412a0) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = layoutParams.f4431e.f4461e;
                    int i16 = this.f4412a0 * i15;
                    int i17 = i15 * i11;
                    if (this.f4411Z == 1) {
                        childAt2.offsetLeftAndRight(i16 - i17);
                    } else {
                        childAt2.offsetTopAndBottom(i16 - i17);
                    }
                }
            }
        }
    }

    /* renamed from: Z */
    public final void m5336Z(int i10) {
        C0872k c0872k = this.f4413b0;
        c0872k.f4617e = i10;
        c0872k.f4616d = this.f4415d0 != (i10 == -1) ? -1 : 1;
    }

    /* renamed from: a0 */
    public final void m5337a0(int i10, int i11) {
        for (int i12 = 0; i12 < this.f4407V; i12++) {
            if (!this.f4408W[i12].f4457a.isEmpty()) {
                m5343g0(this.f4408W[i12], i10, i11);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f4423l0 == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* renamed from: b0 */
    public final boolean m5338b0(RecyclerView.C0856z c0856z, C0860b c0860b) {
        c0860b.f4450a = this.f4421j0 ? m5314D(c0856z.m5305b()) : m5357z(c0856z.m5305b());
        c0860b.f4451b = Integer.MIN_VALUE;
        return true;
    }

    /* renamed from: c0 */
    public boolean m5339c0(RecyclerView.C0856z c0856z, C0860b c0860b) {
        int i10;
        if (!c0856z.m5308e() && (i10 = this.f4417f0) != -1) {
            if (i10 >= 0 && i10 < c0856z.m5305b()) {
                SavedState savedState = this.f4423l0;
                if (savedState == null || savedState.f4439a == -1 || savedState.f4441c < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.f4417f0);
                    if (viewFindViewByPosition != null) {
                        c0860b.f4450a = this.f4415d0 ? m5318H() : m5317G();
                        if (this.f4418g0 != Integer.MIN_VALUE) {
                            if (c0860b.f4452c) {
                                c0860b.f4451b = (this.f4409X.mo5556i() - this.f4418g0) - this.f4409X.mo5551d(viewFindViewByPosition);
                            } else {
                                c0860b.f4451b = (this.f4409X.mo5561n() + this.f4418g0) - this.f4409X.mo5554g(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.f4409X.mo5552e(viewFindViewByPosition) > this.f4409X.mo5562o()) {
                            c0860b.f4451b = c0860b.f4452c ? this.f4409X.mo5556i() : this.f4409X.mo5561n();
                            return true;
                        }
                        int iMo5554g = this.f4409X.mo5554g(viewFindViewByPosition) - this.f4409X.mo5561n();
                        if (iMo5554g < 0) {
                            c0860b.f4451b = -iMo5554g;
                            return true;
                        }
                        int iMo5556i = this.f4409X.mo5556i() - this.f4409X.mo5551d(viewFindViewByPosition);
                        if (iMo5556i < 0) {
                            c0860b.f4451b = iMo5556i;
                            return true;
                        }
                        c0860b.f4451b = Integer.MIN_VALUE;
                    } else {
                        int i11 = this.f4417f0;
                        c0860b.f4450a = i11;
                        int i12 = this.f4418g0;
                        if (i12 == Integer.MIN_VALUE) {
                            c0860b.f4452c = m5350s(i11) == 1;
                            c0860b.m5381a();
                        } else {
                            c0860b.m5382b(i12);
                        }
                        c0860b.f4453d = true;
                    }
                } else {
                    c0860b.f4451b = Integer.MIN_VALUE;
                    c0860b.f4450a = this.f4417f0;
                }
                return true;
            }
            this.f4417f0 = -1;
            this.f4418g0 = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollHorizontally() {
        return this.f4411Z == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollVertically() {
        return this.f4411Z == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.C0856z c0856z, RecyclerView.AbstractC0846p.c cVar) {
        int iM5396l;
        int iM5400p;
        if (this.f4411Z != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        m5330T(i10, c0856z);
        int[] iArr = this.f4429r0;
        if (iArr == null || iArr.length < this.f4407V) {
            this.f4429r0 = new int[this.f4407V];
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f4407V; i13++) {
            C0872k c0872k = this.f4413b0;
            if (c0872k.f4616d == -1) {
                iM5396l = c0872k.f4618f;
                iM5400p = this.f4408W[i13].m5400p(iM5396l);
            } else {
                iM5396l = this.f4408W[i13].m5396l(c0872k.f4619g);
                iM5400p = this.f4413b0.f4619g;
            }
            int i14 = iM5396l - iM5400p;
            if (i14 >= 0) {
                this.f4429r0[i12] = i14;
                i12++;
            }
        }
        Arrays.sort(this.f4429r0, 0, i12);
        for (int i15 = 0; i15 < i12 && this.f4413b0.m5540a(c0856z); i15++) {
            cVar.mo5245a(this.f4413b0.f4615c, this.f4429r0[i15]);
            C0872k c0872k2 = this.f4413b0;
            c0872k2.f4615c += c0872k2.f4616d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollExtent(RecyclerView.C0856z c0856z) {
        return computeScrollExtent(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollOffset(RecyclerView.C0856z c0856z) {
        return computeScrollOffset(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollRange(RecyclerView.C0856z c0856z) {
        return computeScrollRange(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0855y.b
    public PointF computeScrollVectorForPosition(int i10) {
        int iM5350s = m5350s(i10);
        PointF pointF = new PointF();
        if (iM5350s == 0) {
            return null;
        }
        if (this.f4411Z == 0) {
            pointF.x = iM5350s;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM5350s;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollExtent(RecyclerView.C0856z c0856z) {
        return computeScrollExtent(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollOffset(RecyclerView.C0856z c0856z) {
        return computeScrollOffset(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollRange(RecyclerView.C0856z c0856z) {
        return computeScrollRange(c0856z);
    }

    /* renamed from: d0 */
    public void m5340d0(RecyclerView.C0856z c0856z, C0860b c0860b) {
        if (m5339c0(c0856z, c0860b) || m5338b0(c0856z, c0860b)) {
            return;
        }
        c0860b.m5381a();
        c0860b.f4450a = 0;
    }

    /* renamed from: e0 */
    public final void m5341e0(int i10, RecyclerView.C0856z c0856z) {
        int iMo5562o;
        int iMo5562o2;
        int iM5306c;
        C0872k c0872k = this.f4413b0;
        boolean z10 = false;
        c0872k.f4614b = 0;
        c0872k.f4615c = i10;
        if (!isSmoothScrolling() || (iM5306c = c0856z.m5306c()) == -1) {
            iMo5562o = 0;
            iMo5562o2 = 0;
        } else {
            if (this.f4415d0 == (iM5306c < i10)) {
                iMo5562o = this.f4409X.mo5562o();
                iMo5562o2 = 0;
            } else {
                iMo5562o2 = this.f4409X.mo5562o();
                iMo5562o = 0;
            }
        }
        if (getClipToPadding()) {
            this.f4413b0.f4618f = this.f4409X.mo5561n() - iMo5562o2;
            this.f4413b0.f4619g = this.f4409X.mo5556i() + iMo5562o;
        } else {
            this.f4413b0.f4619g = this.f4409X.mo5555h() + iMo5562o;
            this.f4413b0.f4618f = -iMo5562o2;
        }
        C0872k c0872k2 = this.f4413b0;
        c0872k2.f4620h = false;
        c0872k2.f4613a = true;
        if (this.f4409X.mo5559l() == 0 && this.f4409X.mo5555h() == 0) {
            z10 = true;
        }
        c0872k2.f4621i = z10;
    }

    /* renamed from: f0 */
    public void m5342f0(int i10) {
        this.f4412a0 = i10 / this.f4407V;
        this.f4424m0 = View.MeasureSpec.makeMeasureSpec(i10, this.f4410Y.mo5559l());
    }

    /* renamed from: g0 */
    public final void m5343g0(C0861c c0861c, int i10, int i11) {
        int iM5394j = c0861c.m5394j();
        if (i10 == -1) {
            if (c0861c.m5399o() + iM5394j <= i11) {
                this.f4416e0.set(c0861c.f4461e, false);
            }
        } else if (c0861c.m5395k() - iM5394j >= i11) {
            this.f4416e0.set(c0861c.f4461e, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.f4411Z == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getOrientation() {
        return this.f4411Z;
    }

    /* renamed from: h0 */
    public final int m5344h0(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    /* renamed from: i */
    public final void m5345i(View view) {
        for (int i10 = this.f4407V - 1; i10 >= 0; i10--) {
            this.f4408W[i10].m5385a(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean isAutoMeasureEnabled() {
        return this.f4420i0 != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: j */
    public final void m5346j(C0860b c0860b) {
        SavedState savedState = this.f4423l0;
        int i10 = savedState.f4441c;
        if (i10 > 0) {
            if (i10 == this.f4407V) {
                for (int i11 = 0; i11 < this.f4407V; i11++) {
                    this.f4408W[i11].m5389e();
                    SavedState savedState2 = this.f4423l0;
                    int iMo5556i = savedState2.f4442d[i11];
                    if (iMo5556i != Integer.MIN_VALUE) {
                        iMo5556i += savedState2.f4447i ? this.f4409X.mo5556i() : this.f4409X.mo5561n();
                    }
                    this.f4408W[i11].m5406v(iMo5556i);
                }
            } else {
                savedState.m5378c();
                SavedState savedState3 = this.f4423l0;
                savedState3.f4439a = savedState3.f4440b;
            }
        }
        SavedState savedState4 = this.f4423l0;
        this.f4422k0 = savedState4.f4448j;
        setReverseLayout(savedState4.f4446h);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.f4423l0;
        int i12 = savedState5.f4439a;
        if (i12 != -1) {
            this.f4417f0 = i12;
            c0860b.f4452c = savedState5.f4447i;
        } else {
            c0860b.f4452c = this.f4415d0;
        }
        if (savedState5.f4443e > 1) {
            LazySpanLookup lazySpanLookup = this.f4419h0;
            lazySpanLookup.f4433a = savedState5.f4444f;
            lazySpanLookup.f4434b = savedState5.f4445g;
        }
    }

    public final void measureChildWithDecorationsAndMargin(View view, int i10, int i11, boolean z10) {
        calculateItemDecorationsForChild(view, this.f4425n0);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.f4425n0;
        int iM5344h0 = m5344h0(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.f4425n0;
        int iM5344h02 = m5344h0(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z10 ? shouldReMeasureChild(view, iM5344h0, iM5344h02, layoutParams) : shouldMeasureChild(view, iM5344h0, iM5344h02, layoutParams)) {
            view.measure(iM5344h0, iM5344h02);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void offsetChildrenHorizontal(int i10) {
        super.offsetChildrenHorizontal(i10);
        for (int i11 = 0; i11 < this.f4407V; i11++) {
            this.f4408W[i11].m5402r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void offsetChildrenVertical(int i10) {
        super.offsetChildrenVertical(i10);
        for (int i11 = 0; i11 < this.f4407V; i11++) {
            this.f4408W[i11].m5402r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onAdapterChanged(RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0838h abstractC0838h2) {
        this.f4419h0.m5360b();
        for (int i10 = 0; i10 < this.f4407V; i10++) {
            this.f4408W[i10].m5389e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0852v c0852v) {
        super.onDetachedFromWindow(recyclerView, c0852v);
        removeCallbacks(this.f4430s0);
        for (int i10 = 0; i10 < this.f4407V; i10++) {
            this.f4408W[i10].m5389e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public View onFocusSearchFailed(View view, int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        View viewFindContainingItemView;
        View viewM5397m;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
        boolean z10 = layoutParams.f4432f;
        C0861c c0861c = layoutParams.f4431e;
        int iM5318H = iConvertFocusDirectionToLayoutDirection == 1 ? m5318H() : m5317G();
        m5341e0(iM5318H, c0856z);
        m5336Z(iConvertFocusDirectionToLayoutDirection);
        C0872k c0872k = this.f4413b0;
        c0872k.f4615c = c0872k.f4616d + iM5318H;
        c0872k.f4614b = (int) (this.f4409X.mo5562o() * 0.33333334f);
        C0872k c0872k2 = this.f4413b0;
        c0872k2.f4620h = true;
        c0872k2.f4613a = false;
        m5356y(c0852v, c0872k2, c0856z);
        this.f4421j0 = this.f4415d0;
        if (!z10 && (viewM5397m = c0861c.m5397m(iM5318H, iConvertFocusDirectionToLayoutDirection)) != null && viewM5397m != viewFindContainingItemView) {
            return viewM5397m;
        }
        if (m5329S(iConvertFocusDirectionToLayoutDirection)) {
            for (int i11 = this.f4407V - 1; i11 >= 0; i11--) {
                View viewM5397m2 = this.f4408W[i11].m5397m(iM5318H, iConvertFocusDirectionToLayoutDirection);
                if (viewM5397m2 != null && viewM5397m2 != viewFindContainingItemView) {
                    return viewM5397m2;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f4407V; i12++) {
                View viewM5397m3 = this.f4408W[i12].m5397m(iM5318H, iConvertFocusDirectionToLayoutDirection);
                if (viewM5397m3 != null && viewM5397m3 != viewFindContainingItemView) {
                    return viewM5397m3;
                }
            }
        }
        boolean z11 = (this.f4414c0 ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z10) {
            View viewFindViewByPosition = findViewByPosition(z11 ? c0861c.m5390f() : c0861c.m5391g());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (m5329S(iConvertFocusDirectionToLayoutDirection)) {
            for (int i13 = this.f4407V - 1; i13 >= 0; i13--) {
                if (i13 != c0861c.f4461e) {
                    View viewFindViewByPosition2 = findViewByPosition(z11 ? this.f4408W[i13].m5390f() : this.f4408W[i13].m5391g());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f4407V; i14++) {
                View viewFindViewByPosition3 = findViewByPosition(z11 ? this.f4408W[i14].m5390f() : this.f4408W[i14].m5391g());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewM5312B = m5312B(false);
            View viewM5311A = m5311A(false);
            if (viewM5312B == null || viewM5311A == null) {
                return;
            }
            int position = getPosition(viewM5312B);
            int position2 = getPosition(viewM5311A);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        m5324N(i10, i11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f4419h0.m5360b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        m5324N(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        m5324N(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        m5324N(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        m5328R(c0852v, c0856z, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutCompleted(RecyclerView.C0856z c0856z) {
        super.onLayoutCompleted(c0856z);
        this.f4417f0 = -1;
        this.f4418g0 = Integer.MIN_VALUE;
        this.f4423l0 = null;
        this.f4426o0.m5383c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f4423l0 = savedState;
            if (this.f4417f0 != -1) {
                savedState.m5377a();
                this.f4423l0.m5378c();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public Parcelable onSaveInstanceState() {
        int iM5400p;
        int iMo5561n;
        int[] iArr;
        if (this.f4423l0 != null) {
            return new SavedState(this.f4423l0);
        }
        SavedState savedState = new SavedState();
        savedState.f4446h = this.f4414c0;
        savedState.f4447i = this.f4421j0;
        savedState.f4448j = this.f4422k0;
        LazySpanLookup lazySpanLookup = this.f4419h0;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f4433a) == null) {
            savedState.f4443e = 0;
        } else {
            savedState.f4444f = iArr;
            savedState.f4443e = iArr.length;
            savedState.f4445g = lazySpanLookup.f4434b;
        }
        if (getChildCount() > 0) {
            savedState.f4439a = this.f4421j0 ? m5318H() : m5317G();
            savedState.f4440b = m5313C();
            int i10 = this.f4407V;
            savedState.f4441c = i10;
            savedState.f4442d = new int[i10];
            for (int i11 = 0; i11 < this.f4407V; i11++) {
                if (this.f4421j0) {
                    iM5400p = this.f4408W[i11].m5396l(Integer.MIN_VALUE);
                    if (iM5400p != Integer.MIN_VALUE) {
                        iMo5561n = this.f4409X.mo5556i();
                        iM5400p -= iMo5561n;
                    }
                } else {
                    iM5400p = this.f4408W[i11].m5400p(Integer.MIN_VALUE);
                    if (iM5400p != Integer.MIN_VALUE) {
                        iMo5561n = this.f4409X.mo5561n();
                        iM5400p -= iMo5561n;
                    }
                }
                savedState.f4442d[i11] = iM5400p;
            }
        } else {
            savedState.f4439a = -1;
            savedState.f4440b = -1;
            savedState.f4441c = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onScrollStateChanged(int i10) {
        if (i10 == 0) {
            m5351t();
        }
    }

    /* renamed from: p */
    public boolean m5347p() {
        int iM5396l = this.f4408W[0].m5396l(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f4407V; i10++) {
            if (this.f4408W[i10].m5396l(Integer.MIN_VALUE) != iM5396l) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: q */
    public boolean m5348q() {
        int iM5400p = this.f4408W[0].m5400p(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f4407V; i10++) {
            if (this.f4408W[i10].m5400p(Integer.MIN_VALUE) != iM5400p) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r */
    public final void m5349r(View view, LayoutParams layoutParams, C0872k c0872k) {
        if (c0872k.f4617e == 1) {
            if (layoutParams.f4432f) {
                m5345i(view);
                return;
            } else {
                layoutParams.f4431e.m5385a(view);
                return;
            }
        }
        if (layoutParams.f4432f) {
            m5331U(view);
        } else {
            layoutParams.f4431e.m5405u(view);
        }
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f4411Z == 1 || !isLayoutRTL()) {
            this.f4415d0 = this.f4414c0;
        } else {
            this.f4415d0 = !this.f4414c0;
        }
    }

    /* renamed from: s */
    public final int m5350s(int i10) {
        if (getChildCount() == 0) {
            return this.f4415d0 ? 1 : -1;
        }
        return (i10 < m5317G()) != this.f4415d0 ? -1 : 1;
    }

    public int scrollBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        m5330T(i10, c0856z);
        int iM5356y = m5356y(c0852v, this.f4413b0, c0856z);
        if (this.f4413b0.f4614b >= iM5356y) {
            i10 = i10 < 0 ? -iM5356y : iM5356y;
        }
        this.f4409X.mo5566s(-i10);
        this.f4421j0 = this.f4415d0;
        C0872k c0872k = this.f4413b0;
        c0872k.f4614b = 0;
        m5332V(c0852v, c0872k);
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollHorizontallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        return scrollBy(i10, c0852v, c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void scrollToPosition(int i10) {
        SavedState savedState = this.f4423l0;
        if (savedState != null && savedState.f4439a != i10) {
            savedState.m5377a();
        }
        this.f4417f0 = i10;
        this.f4418g0 = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollVerticallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        return scrollBy(i10, c0852v, c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f4411Z == 1) {
            iChooseSize2 = RecyclerView.AbstractC0846p.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = RecyclerView.AbstractC0846p.chooseSize(i10, (this.f4412a0 * this.f4407V) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.AbstractC0846p.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = RecyclerView.AbstractC0846p.chooseSize(i11, (this.f4412a0 * this.f4407V) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i10 == this.f4411Z) {
            return;
        }
        this.f4411Z = i10;
        AbstractC0875n abstractC0875n = this.f4409X;
        this.f4409X = this.f4410Y;
        this.f4410Y = abstractC0875n;
        requestLayout();
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f4423l0;
        if (savedState != null && savedState.f4446h != z10) {
            savedState.f4446h = z10;
        }
        this.f4414c0 = z10;
        requestLayout();
    }

    public void setSpanCount(int i10) {
        assertNotInLayoutOrScroll(null);
        if (i10 != this.f4407V) {
            m5326P();
            this.f4407V = i10;
            this.f4416e0 = new BitSet(this.f4407V);
            this.f4408W = new C0861c[this.f4407V];
            for (int i11 = 0; i11 < this.f4407V; i11++) {
                this.f4408W[i11] = new C0861c(i11);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0856z c0856z, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean supportsPredictiveItemAnimations() {
        return this.f4423l0 == null;
    }

    /* renamed from: t */
    public boolean m5351t() {
        int iM5317G;
        int iM5318H;
        if (getChildCount() == 0 || this.f4420i0 == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f4415d0) {
            iM5317G = m5318H();
            iM5318H = m5317G();
        } else {
            iM5317G = m5317G();
            iM5318H = m5318H();
        }
        if (iM5317G == 0 && m5325O() != null) {
            this.f4419h0.m5360b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.f4427p0) {
            return false;
        }
        int i10 = this.f4415d0 ? -1 : 1;
        int i11 = iM5318H + 1;
        LazySpanLookup.FullSpanItem fullSpanItemM5363e = this.f4419h0.m5363e(iM5317G, i11, i10, true);
        if (fullSpanItemM5363e == null) {
            this.f4427p0 = false;
            this.f4419h0.m5362d(i11);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemM5363e2 = this.f4419h0.m5363e(iM5317G, fullSpanItemM5363e.f4435a, i10 * (-1), true);
        if (fullSpanItemM5363e2 == null) {
            this.f4419h0.m5362d(fullSpanItemM5363e.f4435a);
        } else {
            this.f4419h0.m5362d(fullSpanItemM5363e2.f4435a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    /* renamed from: u */
    public final boolean m5352u(C0861c c0861c) {
        if (this.f4415d0) {
            if (c0861c.m5395k() < this.f4409X.mo5556i()) {
                ArrayList<View> arrayList = c0861c.f4457a;
                return !c0861c.m5398n(arrayList.get(arrayList.size() - 1)).f4432f;
            }
        } else if (c0861c.m5399o() > this.f4409X.mo5561n()) {
            return !c0861c.m5398n(c0861c.f4457a.get(0)).f4432f;
        }
        return false;
    }

    /* renamed from: v */
    public final LazySpanLookup.FullSpanItem m5353v(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4437c = new int[this.f4407V];
        for (int i11 = 0; i11 < this.f4407V; i11++) {
            fullSpanItem.f4437c[i11] = i10 - this.f4408W[i11].m5396l(i10);
        }
        return fullSpanItem;
    }

    /* renamed from: w */
    public final LazySpanLookup.FullSpanItem m5354w(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4437c = new int[this.f4407V];
        for (int i11 = 0; i11 < this.f4407V; i11++) {
            fullSpanItem.f4437c[i11] = this.f4408W[i11].m5400p(i10) - i10;
        }
        return fullSpanItem;
    }

    /* renamed from: x */
    public final void m5355x() {
        this.f4409X = AbstractC0875n.m5549b(this, this.f4411Z);
        this.f4410Y = AbstractC0875n.m5549b(this, 1 - this.f4411Z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* renamed from: y */
    public final int m5356y(RecyclerView.C0852v c0852v, C0872k c0872k, RecyclerView.C0856z c0856z) {
        C0861c c0861cM5323M;
        int iMo5552e;
        int i10;
        int iMo5552e2;
        int iMo5552e3;
        boolean z10;
        ?? r92 = 0;
        this.f4416e0.set(0, this.f4407V, true);
        int i11 = this.f4413b0.f4621i ? c0872k.f4617e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : c0872k.f4617e == 1 ? c0872k.f4619g + c0872k.f4614b : c0872k.f4618f - c0872k.f4614b;
        m5337a0(c0872k.f4617e, i11);
        int iMo5556i = this.f4415d0 ? this.f4409X.mo5556i() : this.f4409X.mo5561n();
        boolean z11 = false;
        while (c0872k.m5540a(c0856z) && (this.f4413b0.f4621i || !this.f4416e0.isEmpty())) {
            View viewM5541b = c0872k.m5541b(c0852v);
            LayoutParams layoutParams = (LayoutParams) viewM5541b.getLayoutParams();
            int iM5125a = layoutParams.m5125a();
            int iM5365g = this.f4419h0.m5365g(iM5125a);
            boolean z12 = iM5365g == -1 ? true : r92;
            if (z12) {
                c0861cM5323M = layoutParams.f4432f ? this.f4408W[r92] : m5323M(c0872k);
                this.f4419h0.m5372n(iM5125a, c0861cM5323M);
            } else {
                c0861cM5323M = this.f4408W[iM5365g];
            }
            C0861c c0861c = c0861cM5323M;
            layoutParams.f4431e = c0861c;
            if (c0872k.f4617e == 1) {
                addView(viewM5541b);
            } else {
                addView(viewM5541b, r92);
            }
            m5327Q(viewM5541b, layoutParams, r92);
            if (c0872k.f4617e == 1) {
                int iM5319I = layoutParams.f4432f ? m5319I(iMo5556i) : c0861c.m5396l(iMo5556i);
                int iMo5552e4 = this.f4409X.mo5552e(viewM5541b) + iM5319I;
                if (z12 && layoutParams.f4432f) {
                    LazySpanLookup.FullSpanItem fullSpanItemM5353v = m5353v(iM5319I);
                    fullSpanItemM5353v.f4436b = -1;
                    fullSpanItemM5353v.f4435a = iM5125a;
                    this.f4419h0.m5359a(fullSpanItemM5353v);
                }
                i10 = iMo5552e4;
                iMo5552e = iM5319I;
            } else {
                int iM5322L = layoutParams.f4432f ? m5322L(iMo5556i) : c0861c.m5400p(iMo5556i);
                iMo5552e = iM5322L - this.f4409X.mo5552e(viewM5541b);
                if (z12 && layoutParams.f4432f) {
                    LazySpanLookup.FullSpanItem fullSpanItemM5354w = m5354w(iM5322L);
                    fullSpanItemM5354w.f4436b = 1;
                    fullSpanItemM5354w.f4435a = iM5125a;
                    this.f4419h0.m5359a(fullSpanItemM5354w);
                }
                i10 = iM5322L;
            }
            if (layoutParams.f4432f && c0872k.f4616d == -1) {
                if (z12) {
                    this.f4427p0 = true;
                } else {
                    if (!(c0872k.f4617e == 1 ? m5347p() : m5348q())) {
                        LazySpanLookup.FullSpanItem fullSpanItemM5364f = this.f4419h0.m5364f(iM5125a);
                        if (fullSpanItemM5364f != null) {
                            fullSpanItemM5364f.f4438d = true;
                        }
                        this.f4427p0 = true;
                    }
                }
            }
            m5349r(viewM5541b, layoutParams, c0872k);
            if (isLayoutRTL() && this.f4411Z == 1) {
                int iMo5556i2 = layoutParams.f4432f ? this.f4410Y.mo5556i() : this.f4410Y.mo5556i() - (((this.f4407V - 1) - c0861c.f4461e) * this.f4412a0);
                iMo5552e3 = iMo5556i2;
                iMo5552e2 = iMo5556i2 - this.f4410Y.mo5552e(viewM5541b);
            } else {
                int iMo5561n = layoutParams.f4432f ? this.f4410Y.mo5561n() : (c0861c.f4461e * this.f4412a0) + this.f4410Y.mo5561n();
                iMo5552e2 = iMo5561n;
                iMo5552e3 = this.f4410Y.mo5552e(viewM5541b) + iMo5561n;
            }
            if (this.f4411Z == 1) {
                layoutDecoratedWithMargins(viewM5541b, iMo5552e2, iMo5552e, iMo5552e3, i10);
            } else {
                layoutDecoratedWithMargins(viewM5541b, iMo5552e, iMo5552e2, i10, iMo5552e3);
            }
            if (layoutParams.f4432f) {
                m5337a0(this.f4413b0.f4617e, i11);
            } else {
                m5343g0(c0861c, this.f4413b0.f4617e, i11);
            }
            m5332V(c0852v, this.f4413b0);
            if (!this.f4413b0.f4620h || !viewM5541b.hasFocusable()) {
                z10 = false;
            } else if (layoutParams.f4432f) {
                this.f4416e0.clear();
                z10 = false;
            } else {
                z10 = false;
                this.f4416e0.set(c0861c.f4461e, false);
            }
            r92 = z10;
            z11 = true;
        }
        int i12 = r92;
        if (!z11) {
            m5332V(c0852v, this.f4413b0);
        }
        int iMo5561n2 = this.f4413b0.f4617e == -1 ? this.f4409X.mo5561n() - m5322L(this.f4409X.mo5561n()) : m5319I(this.f4409X.mo5556i()) - this.f4409X.mo5556i();
        return iMo5561n2 > 0 ? Math.min(c0872k.f4614b, iMo5561n2) : i12;
    }

    /* renamed from: z */
    public final int m5357z(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            int position = getPosition(getChildAt(i11));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LazySpanLookup {

        /* renamed from: a */
        public int[] f4433a;

        /* renamed from: b */
        public List<FullSpanItem> f4434b;

        /* renamed from: a */
        public void m5359a(FullSpanItem fullSpanItem) {
            if (this.f4434b == null) {
                this.f4434b = new ArrayList();
            }
            int size = this.f4434b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = this.f4434b.get(i10);
                if (fullSpanItem2.f4435a == fullSpanItem.f4435a) {
                    this.f4434b.remove(i10);
                }
                if (fullSpanItem2.f4435a >= fullSpanItem.f4435a) {
                    this.f4434b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f4434b.add(fullSpanItem);
        }

        /* renamed from: b */
        public void m5360b() {
            int[] iArr = this.f4433a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4434b = null;
        }

        /* renamed from: c */
        public void m5361c(int i10) {
            int[] iArr = this.f4433a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f4433a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[m5373o(i10)];
                this.f4433a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f4433a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* renamed from: d */
        public int m5362d(int i10) {
            List<FullSpanItem> list = this.f4434b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f4434b.get(size).f4435a >= i10) {
                        this.f4434b.remove(size);
                    }
                }
            }
            return m5366h(i10);
        }

        /* renamed from: e */
        public FullSpanItem m5363e(int i10, int i11, int i12, boolean z10) {
            List<FullSpanItem> list = this.f4434b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = this.f4434b.get(i13);
                int i14 = fullSpanItem.f4435a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f4436b == i12 || (z10 && fullSpanItem.f4438d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* renamed from: f */
        public FullSpanItem m5364f(int i10) {
            List<FullSpanItem> list = this.f4434b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4434b.get(size);
                if (fullSpanItem.f4435a == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* renamed from: g */
        public int m5365g(int i10) {
            int[] iArr = this.f4433a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        /* renamed from: h */
        public int m5366h(int i10) {
            int[] iArr = this.f4433a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int iM5367i = m5367i(i10);
            if (iM5367i == -1) {
                int[] iArr2 = this.f4433a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f4433a.length;
            }
            int iMin = Math.min(iM5367i + 1, this.f4433a.length);
            Arrays.fill(this.f4433a, i10, iMin, -1);
            return iMin;
        }

        /* renamed from: i */
        public final int m5367i(int i10) {
            if (this.f4434b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemM5364f = m5364f(i10);
            if (fullSpanItemM5364f != null) {
                this.f4434b.remove(fullSpanItemM5364f);
            }
            int size = this.f4434b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (this.f4434b.get(i11).f4435a >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f4434b.get(i11);
            this.f4434b.remove(i11);
            return fullSpanItem.f4435a;
        }

        /* renamed from: j */
        public void m5368j(int i10, int i11) {
            int[] iArr = this.f4433a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            m5361c(i12);
            int[] iArr2 = this.f4433a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f4433a, i10, i12, -1);
            m5370l(i10, i11);
        }

        /* renamed from: k */
        public void m5369k(int i10, int i11) {
            int[] iArr = this.f4433a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            m5361c(i12);
            int[] iArr2 = this.f4433a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f4433a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            m5371m(i10, i11);
        }

        /* renamed from: l */
        public final void m5370l(int i10, int i11) {
            List<FullSpanItem> list = this.f4434b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4434b.get(size);
                int i12 = fullSpanItem.f4435a;
                if (i12 >= i10) {
                    fullSpanItem.f4435a = i12 + i11;
                }
            }
        }

        /* renamed from: m */
        public final void m5371m(int i10, int i11) {
            List<FullSpanItem> list = this.f4434b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4434b.get(size);
                int i13 = fullSpanItem.f4435a;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f4434b.remove(size);
                    } else {
                        fullSpanItem.f4435a = i13 - i11;
                    }
                }
            }
        }

        /* renamed from: n */
        public void m5372n(int i10, C0861c c0861c) {
            m5361c(i10);
            this.f4433a[i10] = c0861c.f4461e;
        }

        /* renamed from: o */
        public int m5373o(int i10) {
            int length = this.f4433a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new C0857a();

            /* renamed from: a */
            public int f4435a;

            /* renamed from: b */
            public int f4436b;

            /* renamed from: c */
            public int[] f4437c;

            /* renamed from: d */
            public boolean f4438d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$a */
            public class C0857a implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f4435a = parcel.readInt();
                this.f4436b = parcel.readInt();
                this.f4438d = parcel.readInt() == 1;
                int i10 = parcel.readInt();
                if (i10 > 0) {
                    int[] iArr = new int[i10];
                    this.f4437c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* renamed from: a */
            public int m5374a(int i10) {
                int[] iArr = this.f4437c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4435a + ", mGapDir=" + this.f4436b + ", mHasUnwantedGapAfter=" + this.f4438d + ", mGapPerSpan=" + Arrays.toString(this.f4437c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f4435a);
                parcel.writeInt(this.f4436b);
                parcel.writeInt(this.f4438d ? 1 : 0);
                int[] iArr = this.f4437c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f4437c);
                }
            }

            public FullSpanItem() {
            }
        }
    }
}
