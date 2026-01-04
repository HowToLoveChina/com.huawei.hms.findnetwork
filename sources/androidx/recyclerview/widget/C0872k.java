package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.k */
/* loaded from: classes.dex */
public class C0872k {

    /* renamed from: b */
    public int f4614b;

    /* renamed from: c */
    public int f4615c;

    /* renamed from: d */
    public int f4616d;

    /* renamed from: e */
    public int f4617e;

    /* renamed from: h */
    public boolean f4620h;

    /* renamed from: i */
    public boolean f4621i;

    /* renamed from: a */
    public boolean f4613a = true;

    /* renamed from: f */
    public int f4618f = 0;

    /* renamed from: g */
    public int f4619g = 0;

    /* renamed from: a */
    public boolean m5540a(RecyclerView.C0856z c0856z) {
        int i10 = this.f4615c;
        return i10 >= 0 && i10 < c0856z.m5305b();
    }

    /* renamed from: b */
    public View m5541b(RecyclerView.C0852v c0852v) {
        View viewM5285o = c0852v.m5285o(this.f4615c);
        this.f4615c += this.f4616d;
        return viewM5285o;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4614b + ", mCurrentPosition=" + this.f4615c + ", mItemDirection=" + this.f4616d + ", mLayoutDirection=" + this.f4617e + ", mStartLine=" + this.f4618f + ", mEndLine=" + this.f4619g + '}';
    }
}
