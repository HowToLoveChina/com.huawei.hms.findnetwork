package com.huawei.phoneservice.faq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.phoneservice.faq.R$style;
import com.huawei.phoneservice.faq.R$styleable;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import p243e0.C9372g;

/* loaded from: classes4.dex */
public class FaqAutoNextLineLinearLayout extends ViewGroup {

    /* renamed from: a */
    public C8420a f39254a;

    /* renamed from: b */
    public LinkedHashSet<C8421b> f39255b;

    /* renamed from: c */
    public C9372g<C8421b> f39256c;

    /* renamed from: d */
    public List<View> f39257d;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqAutoNextLineLinearLayout$a */
    public static final class C8420a {

        /* renamed from: a */
        public int f39258a;

        /* renamed from: b */
        public float f39259b;

        /* renamed from: c */
        public float f39260c;

        /* renamed from: d */
        public boolean f39261d;

        /* renamed from: e */
        public int f39262e;

        /* renamed from: f */
        public boolean f39263f;

        /* renamed from: g */
        public int f39264g;

        /* renamed from: h */
        public int f39265h;

        /* renamed from: i */
        public int f39266i;

        public C8420a(Context context, AttributeSet attributeSet) {
            this.f39262e = 0;
            this.f39264g = Integer.MAX_VALUE;
            this.f39265h = Integer.MAX_VALUE;
            if (attributeSet == null) {
                return;
            }
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.WarpLinearLayout);
            this.f39258a = typedArrayObtainStyledAttributes.getInt(R$styleable.WarpLinearLayout_faqGravity, 3);
            boolean z10 = 1 == context.getResources().getConfiguration().getLayoutDirection();
            this.f39263f = z10;
            int i10 = this.f39258a;
            if (i10 > 2) {
                this.f39258a = z10 ? 4 - i10 : i10 - 3;
            }
            this.f39259b = typedArrayObtainStyledAttributes.getDimension(R$styleable.WarpLinearLayout_faqHorizontal_Space, 0.0f);
            this.f39260c = typedArrayObtainStyledAttributes.getDimension(R$styleable.WarpLinearLayout_faqVertical_Space, 0.0f);
            this.f39261d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WarpLinearLayout_faqIsFull, false);
            this.f39264g = typedArrayObtainStyledAttributes.getInt(R$styleable.WarpLinearLayout_faqMaxLines, Integer.MAX_VALUE);
            this.f39265h = typedArrayObtainStyledAttributes.getInt(R$styleable.WarpLinearLayout_faqMaxColumns, Integer.MAX_VALUE);
            this.f39262e = typedArrayObtainStyledAttributes.getInt(R$styleable.WarpLinearLayout_faqEqualPolicy, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqAutoNextLineLinearLayout$b */
    public final class C8421b {

        /* renamed from: b */
        public int f39268b;

        /* renamed from: a */
        public List<View> f39267a = new ArrayList();

        /* renamed from: c */
        public int f39269c = 0;

        /* renamed from: d */
        public int f39270d = 0;

        public C8421b() {
            this.f39268b = FaqAutoNextLineLinearLayout.this.getPaddingLeft() + FaqAutoNextLineLinearLayout.this.getPaddingRight();
            m52434a();
        }

        /* renamed from: a */
        public final void m52434a() {
            List<View> list = this.f39267a;
            if (list != null) {
                list.clear();
            }
            if (FaqAutoNextLineLinearLayout.this.f39254a.f39262e == 2) {
                this.f39269c = FaqAutoNextLineLinearLayout.this.f39254a.f39266i;
            }
            this.f39268b = FaqAutoNextLineLinearLayout.this.getPaddingLeft() + FaqAutoNextLineLinearLayout.this.getPaddingRight();
            this.f39270d = 0;
        }

        /* renamed from: b */
        public final void m52435b(View view) {
            int paddingLeft;
            int measuredWidth;
            int size = this.f39267a.size();
            this.f39269c = Math.max(this.f39269c, view.getMeasuredWidth());
            this.f39270d = Math.max(this.f39270d, view.getMeasuredHeight());
            if (FaqAutoNextLineLinearLayout.this.f39254a.f39262e != 0) {
                paddingLeft = ((int) ((this.f39269c * (size + 1)) + (FaqAutoNextLineLinearLayout.this.f39254a.f39259b * size))) + FaqAutoNextLineLinearLayout.this.getPaddingLeft();
                measuredWidth = FaqAutoNextLineLinearLayout.this.getPaddingRight();
            } else {
                if (!FaqCommonUtils.isEmpty(this.f39267a)) {
                    this.f39268b = (int) (this.f39268b + FaqAutoNextLineLinearLayout.this.f39254a.f39259b);
                }
                paddingLeft = this.f39268b;
                measuredWidth = view.getMeasuredWidth();
            }
            this.f39268b = paddingLeft + measuredWidth;
            this.f39267a.add(view);
        }

        /* renamed from: e */
        public final boolean m52436e(View view, int i10) {
            if (FaqAutoNextLineLinearLayout.this.f39254a.f39262e == 0) {
                return true;
            }
            int measuredWidth = view.getMeasuredWidth();
            int i11 = this.f39269c;
            if (measuredWidth <= i11) {
                return ((float) (this.f39268b + i11)) + FaqAutoNextLineLinearLayout.this.f39254a.f39259b <= ((float) i10);
            }
            int measuredWidth2 = view.getMeasuredWidth();
            int size = this.f39267a.size();
            return ((int) (((float) ((size + 1) * measuredWidth2)) + (FaqAutoNextLineLinearLayout.this.f39254a.f39259b * ((float) size)))) <= i10;
        }

        public boolean equals(Object obj) {
            boolean z10 = this == obj;
            if (z10 || !(obj instanceof C8421b)) {
                return z10;
            }
            C8421b c8421b = (C8421b) obj;
            return this.f39270d == c8421b.f39270d && this.f39268b == c8421b.f39268b && this.f39267a == c8421b.f39267a;
        }

        public int hashCode() {
            int i10 = (((this.f39270d + 527) * 31) + this.f39268b) * 31;
            List<View> list = this.f39267a;
            return i10 + (list == null ? 0 : list.hashCode());
        }
    }

    public FaqAutoNextLineLinearLayout(Context context) {
        this(context, null);
    }

    private C8421b getWarpLine() {
        C8421b c8421bMo58738b = this.f39256c.mo58738b();
        if (c8421bMo58738b == null) {
            c8421bMo58738b = new C8421b();
        }
        c8421bMo58738b.m52434a();
        return c8421bMo58738b;
    }

    /* renamed from: a */
    public final int m52410a(int i10, int i11, int i12, int i13) {
        int i14 = 0;
        if (i10 == Integer.MIN_VALUE) {
            while (i14 < i13) {
                if (i14 != 0) {
                    i11 = (int) (i11 + this.f39254a.f39259b);
                }
                i11 += getChildAt(i14).getMeasuredWidth();
                i14++;
            }
            return Math.min(i11 + getPaddingLeft() + getPaddingRight(), i12);
        }
        if (i10 != 0) {
            return i12;
        }
        while (i14 < i13) {
            if (i14 != 0) {
                i11 = (int) (i11 + this.f39254a.f39259b);
            }
            i11 += getChildAt(i14).getMeasuredWidth();
            i14++;
        }
        return i11 + getPaddingLeft() + getPaddingRight();
    }

    /* renamed from: c */
    public final C8421b m52411c(int i10, int i11) {
        C8421b warpLine = getWarpLine();
        for (int i12 = 0; this.f39255b.size() < this.f39254a.f39264g && i12 < i11; i12++) {
            if (warpLine.f39267a.size() < this.f39254a.f39265h && warpLine.f39268b + getChildAt(i12).getMeasuredWidth() + this.f39254a.f39259b <= i10 && warpLine.m52436e(getChildAt(i12), i10)) {
                warpLine.m52435b(getChildAt(i12));
            } else if (FaqCommonUtils.isEmpty(warpLine.f39267a)) {
                warpLine.m52435b(getChildAt(i12));
                m52413e(warpLine);
                warpLine = getWarpLine();
            } else {
                m52413e(warpLine);
                warpLine = getWarpLine();
                warpLine.m52435b(getChildAt(i12));
            }
        }
        return warpLine;
    }

    /* renamed from: d */
    public final List<View> m52412d(List<View> list) {
        this.f39257d.clear();
        if (list != null) {
            this.f39257d.addAll(list);
        }
        return this.f39257d;
    }

    /* renamed from: e */
    public final void m52413e(C8421b c8421b) {
        if (this.f39255b.size() < this.f39254a.f39264g) {
            this.f39255b.add(c8421b);
        }
    }

    @SuppressLint({"LongLogTag"})
    /* renamed from: f */
    public final void m52414f(LinkedHashSet<C8421b> linkedHashSet) throws Throwable {
        String str;
        if (linkedHashSet != null) {
            Iterator<C8421b> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                C8421b next = it.next();
                if (next != null) {
                    try {
                        this.f39256c.mo58737a(next);
                    } catch (IllegalStateException unused) {
                        str = "removeAllWarpLine IllegalStateException";
                        FaqLogger.print("FaqAutoNextLineLinearLayout", str);
                    } catch (Exception unused2) {
                        str = "removeAllWarpLine Exception";
                        FaqLogger.print("FaqAutoNextLineLinearLayout", str);
                    }
                }
            }
            linkedHashSet.clear();
        }
    }

    /* renamed from: g */
    public boolean m52415g() {
        return this.f39254a.f39261d;
    }

    @Override // android.view.ViewGroup
    public void measureChildren(int i10, int i11) {
        super.measureChildren(i10, i11);
        if (this.f39254a.f39262e == 2) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                C8420a c8420a = this.f39254a;
                c8420a.f39266i = Math.max(c8420a.f39266i, getChildAt(i12).getMeasuredWidth());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float size;
        int paddingTop = getPaddingTop();
        Iterator<C8421b> it = this.f39255b.iterator();
        while (it.hasNext()) {
            C8421b next = it.next();
            int paddingLeft = getPaddingLeft();
            int measuredWidth = getMeasuredWidth() - next.f39268b;
            List<View> listM52412d = m52412d(next.f39267a);
            if (this.f39254a.f39263f) {
                Collections.reverse(listM52412d);
            }
            for (View view : listM52412d) {
                int measuredWidth2 = this.f39254a.f39262e != 0 ? next.f39269c : view.getMeasuredWidth();
                if (m52415g()) {
                    view.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth2 + (measuredWidth / listM52412d.size()), view.getMeasuredHeight() + paddingTop);
                    f10 = paddingLeft;
                    f11 = measuredWidth2 + this.f39254a.f39259b;
                    size = measuredWidth / listM52412d.size();
                } else {
                    int i14 = this.f39254a.f39258a;
                    if (i14 == 1) {
                        int i15 = paddingLeft + measuredWidth;
                        view.layout(i15, paddingTop, i15 + measuredWidth2, view.getMeasuredHeight() + paddingTop);
                    } else if (i14 != 2) {
                        view.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth2, view.getMeasuredHeight() + paddingTop);
                    } else {
                        int i16 = (measuredWidth / 2) + paddingLeft;
                        view.layout(i16, paddingTop, i16 + measuredWidth2, view.getMeasuredHeight() + paddingTop);
                        paddingLeft = (int) (paddingLeft + measuredWidth2 + this.f39254a.f39259b);
                    }
                    f10 = paddingLeft;
                    f11 = measuredWidth2;
                    size = this.f39254a.f39259b;
                }
                paddingLeft = (int) (f10 + f11 + size);
            }
            paddingTop = (int) (paddingTop + next.f39270d + this.f39254a.f39260c);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) throws Throwable {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int childCount = getChildCount();
        measureChildren(i10, i11);
        int i12 = 0;
        int iM52410a = m52410a(mode, 0, size, childCount);
        m52414f(this.f39255b);
        if (this.f39254a.f39264g > 0) {
            C8421b c8421bM52411c = m52411c(iM52410a, childCount);
            if (!FaqCommonUtils.isEmpty(c8421bM52411c.f39267a) && !this.f39255b.contains(c8421bM52411c)) {
                m52413e(c8421bM52411c);
            }
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        Iterator<C8421b> it = this.f39255b.iterator();
        while (it.hasNext()) {
            C8421b next = it.next();
            int i13 = i12 + 1;
            if (i12 != 0) {
                paddingTop = (int) (paddingTop + this.f39254a.f39260c);
            }
            paddingTop += next.f39270d;
            i12 = i13;
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingTop, size2);
        } else if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(iM52410a, size2);
    }

    public void setIsFull(boolean z10) {
        this.f39254a.f39261d = z10;
    }

    public FaqAutoNextLineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$style.WarpLinearLayoutDefault);
    }

    public FaqAutoNextLineLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f39255b = new LinkedHashSet<>();
        this.f39256c = new C9372g<>(10);
        this.f39257d = new ArrayList();
        this.f39254a = new C8420a(context, attributeSet);
    }
}
