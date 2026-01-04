package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.C1632c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class FlexboxLayout extends ViewGroup implements InterfaceC1630a {

    /* renamed from: a */
    public int f7202a;

    /* renamed from: b */
    public int f7203b;

    /* renamed from: c */
    public int f7204c;

    /* renamed from: d */
    public int f7205d;

    /* renamed from: e */
    public int f7206e;

    /* renamed from: f */
    public int f7207f;

    /* renamed from: g */
    public Drawable f7208g;

    /* renamed from: h */
    public Drawable f7209h;

    /* renamed from: i */
    public int f7210i;

    /* renamed from: j */
    public int f7211j;

    /* renamed from: k */
    public int f7212k;

    /* renamed from: l */
    public int f7213l;

    /* renamed from: m */
    public int[] f7214m;

    /* renamed from: n */
    public SparseIntArray f7215n;

    /* renamed from: o */
    public C1632c f7216o;

    /* renamed from: p */
    public List<C1631b> f7217p;

    /* renamed from: q */
    public C1632c.b f7218q;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    public final void m9272A() {
        if (this.f7208g == null && this.f7209h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: a */
    public void mo9273a(View view, int i10, int i11, C1631b c1631b) {
        if (m9291s(i10, i11)) {
            if (mo9286n()) {
                int i12 = c1631b.f7289e;
                int i13 = this.f7213l;
                c1631b.f7289e = i12 + i13;
                c1631b.f7290f += i13;
                return;
            }
            int i14 = c1631b.f7289e;
            int i15 = this.f7212k;
            c1631b.f7289e = i14 + i15;
            c1631b.f7290f += i15;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f7215n == null) {
            this.f7215n = new SparseIntArray(getChildCount());
        }
        this.f7214m = this.f7216o.m9453n(view, i10, layoutParams, this.f7215n);
        super.addView(view, i10, layoutParams);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: b */
    public void mo9274b(C1631b c1631b) {
        if (mo9286n()) {
            if ((this.f7211j & 4) > 0) {
                int i10 = c1631b.f7289e;
                int i11 = this.f7213l;
                c1631b.f7289e = i10 + i11;
                c1631b.f7290f += i11;
                return;
            }
            return;
        }
        if ((this.f7210i & 4) > 0) {
            int i12 = c1631b.f7289e;
            int i13 = this.f7212k;
            c1631b.f7289e = i12 + i13;
            c1631b.f7290f += i13;
        }
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: c */
    public View mo9275c(int i10) {
        return m9290r(i10);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: d */
    public int mo9276d(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: e */
    public void mo9277e(int i10, View view) {
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: f */
    public View mo9278f(int i10) {
        return getChildAt(i10);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: g */
    public int mo9279g(View view, int i10, int i11) {
        int i12;
        int i13;
        if (mo9286n()) {
            i12 = m9291s(i10, i11) ? this.f7213l : 0;
            if ((this.f7211j & 4) <= 0) {
                return i12;
            }
            i13 = this.f7213l;
        } else {
            i12 = m9291s(i10, i11) ? this.f7212k : 0;
            if ((this.f7210i & 4) <= 0) {
                return i12;
            }
            i13 = this.f7212k;
        }
        return i12 + i13;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getAlignContent() {
        return this.f7206e;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getAlignItems() {
        return this.f7205d;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f7208g;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f7209h;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getFlexDirection() {
        return this.f7202a;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<C1631b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f7217p.size());
        for (C1631b c1631b : this.f7217p) {
            if (c1631b.m9412c() != 0) {
                arrayList.add(c1631b);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public List<C1631b> getFlexLinesInternal() {
        return this.f7217p;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getFlexWrap() {
        return this.f7203b;
    }

    public int getJustifyContent() {
        return this.f7204c;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getLargestMainSize() {
        Iterator<C1631b> it = this.f7217p.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f7289e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getMaxLine() {
        return this.f7207f;
    }

    public int getShowDividerHorizontal() {
        return this.f7210i;
    }

    public int getShowDividerVertical() {
        return this.f7211j;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getSumOfCrossSize() {
        int size = this.f7217p.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            C1631b c1631b = this.f7217p.get(i11);
            if (m9292t(i11)) {
                i10 += mo9286n() ? this.f7212k : this.f7213l;
            }
            if (m9293u(i11)) {
                i10 += mo9286n() ? this.f7212k : this.f7213l;
            }
            i10 += c1631b.f7291g;
        }
        return i10;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: h */
    public int mo9280h(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    /* renamed from: i */
    public final boolean m9281i(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f7217p.get(i11).m9412c() > 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: j */
    public final boolean m9282j(int i10, int i11) {
        for (int i12 = 1; i12 <= i11; i12++) {
            View viewM9290r = m9290r(i10 - i12);
            if (viewM9290r != null && viewM9290r.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public final void m9283k(Canvas canvas, boolean z10, boolean z11) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f7217p.size();
        for (int i10 = 0; i10 < size; i10++) {
            C1631b c1631b = this.f7217p.get(i10);
            for (int i11 = 0; i11 < c1631b.f7292h; i11++) {
                int i12 = c1631b.f7299o + i11;
                View viewM9290r = m9290r(i12);
                if (viewM9290r != null && viewM9290r.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewM9290r.getLayoutParams();
                    if (m9291s(i12, i11)) {
                        m9288p(canvas, z10 ? viewM9290r.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (viewM9290r.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f7213l, c1631b.f7286b, c1631b.f7291g);
                    }
                    if (i11 == c1631b.f7292h - 1 && (this.f7211j & 4) > 0) {
                        m9288p(canvas, z10 ? (viewM9290r.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f7213l : viewM9290r.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, c1631b.f7286b, c1631b.f7291g);
                    }
                }
            }
            if (m9292t(i10)) {
                m9285m(canvas, paddingLeft, z11 ? c1631b.f7288d : c1631b.f7286b - this.f7212k, iMax);
            }
            if (m9293u(i10) && (this.f7210i & 4) > 0) {
                m9285m(canvas, paddingLeft, z11 ? c1631b.f7286b - this.f7212k : c1631b.f7288d, iMax);
            }
        }
    }

    /* renamed from: l */
    public final void m9284l(Canvas canvas, boolean z10, boolean z11) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f7217p.size();
        for (int i10 = 0; i10 < size; i10++) {
            C1631b c1631b = this.f7217p.get(i10);
            for (int i11 = 0; i11 < c1631b.f7292h; i11++) {
                int i12 = c1631b.f7299o + i11;
                View viewM9290r = m9290r(i12);
                if (viewM9290r != null && viewM9290r.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewM9290r.getLayoutParams();
                    if (m9291s(i12, i11)) {
                        m9285m(canvas, c1631b.f7285a, z11 ? viewM9290r.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (viewM9290r.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f7212k, c1631b.f7291g);
                    }
                    if (i11 == c1631b.f7292h - 1 && (this.f7210i & 4) > 0) {
                        m9285m(canvas, c1631b.f7285a, z11 ? (viewM9290r.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f7212k : viewM9290r.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, c1631b.f7291g);
                    }
                }
            }
            if (m9292t(i10)) {
                m9288p(canvas, z10 ? c1631b.f7287c : c1631b.f7285a - this.f7213l, paddingTop, iMax);
            }
            if (m9293u(i10) && (this.f7211j & 4) > 0) {
                m9288p(canvas, z10 ? c1631b.f7285a - this.f7213l : c1631b.f7287c, paddingTop, iMax);
            }
        }
    }

    /* renamed from: m */
    public final void m9285m(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f7208g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i10, i11, i12 + i10, this.f7212k + i11);
        this.f7208g.draw(canvas);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: n */
    public boolean mo9286n() {
        int i10 = this.f7202a;
        return i10 == 0 || i10 == 1;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: o */
    public int mo9287o(View view) {
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f7209h == null && this.f7208g == null) {
            return;
        }
        if (this.f7210i == 0 && this.f7211j == 0) {
            return;
        }
        int iM59832A = C9603h0.m59832A(this);
        int i10 = this.f7202a;
        if (i10 == 0) {
            m9283k(canvas, iM59832A == 1, this.f7203b == 2);
            return;
        }
        if (i10 == 1) {
            m9283k(canvas, iM59832A != 1, this.f7203b == 2);
            return;
        }
        if (i10 == 2) {
            boolean z10 = iM59832A == 1;
            if (this.f7203b == 2) {
                z10 = !z10;
            }
            m9284l(canvas, z10, false);
            return;
        }
        if (i10 != 3) {
            return;
        }
        boolean z11 = iM59832A == 1;
        if (this.f7203b == 2) {
            z11 = !z11;
        }
        m9284l(canvas, z11, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        int iM59832A = C9603h0.m59832A(this);
        int i14 = this.f7202a;
        if (i14 == 0) {
            m9294v(iM59832A == 1, i10, i11, i12, i13);
            return;
        }
        if (i14 == 1) {
            m9294v(iM59832A != 1, i10, i11, i12, i13);
            return;
        }
        if (i14 == 2) {
            z11 = iM59832A == 1;
            m9295w(this.f7203b == 2 ? !z11 : z11, false, i10, i11, i12, i13);
        } else if (i14 == 3) {
            z11 = iM59832A == 1;
            m9295w(this.f7203b == 2 ? !z11 : z11, true, i10, i11, i12, i13);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f7202a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f7215n == null) {
            this.f7215n = new SparseIntArray(getChildCount());
        }
        if (this.f7216o.m9428O(this.f7215n)) {
            this.f7214m = this.f7216o.m9452m(this.f7215n);
        }
        int i12 = this.f7202a;
        if (i12 == 0 || i12 == 1) {
            m9296x(i10, i11);
            return;
        }
        if (i12 == 2 || i12 == 3) {
            m9297y(i10, i11);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f7202a);
    }

    /* renamed from: p */
    public final void m9288p(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f7209h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i10, i11, this.f7213l + i10, i12 + i11);
        this.f7209h.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: r */
    public View m9290r(int i10) {
        if (i10 < 0) {
            return null;
        }
        int[] iArr = this.f7214m;
        if (i10 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i10]);
    }

    /* renamed from: s */
    public final boolean m9291s(int i10, int i11) {
        return m9282j(i10, i11) ? mo9286n() ? (this.f7211j & 1) != 0 : (this.f7210i & 1) != 0 : mo9286n() ? (this.f7211j & 2) != 0 : (this.f7210i & 2) != 0;
    }

    public void setAlignContent(int i10) {
        if (this.f7206e != i10) {
            this.f7206e = i10;
            requestLayout();
        }
    }

    public void setAlignItems(int i10) {
        if (this.f7205d != i10) {
            this.f7205d = i10;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.f7208g) {
            return;
        }
        this.f7208g = drawable;
        if (drawable != null) {
            this.f7212k = drawable.getIntrinsicHeight();
        } else {
            this.f7212k = 0;
        }
        m9272A();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.f7209h) {
            return;
        }
        this.f7209h = drawable;
        if (drawable != null) {
            this.f7213l = drawable.getIntrinsicWidth();
        } else {
            this.f7213l = 0;
        }
        m9272A();
        requestLayout();
    }

    public void setFlexDirection(int i10) {
        if (this.f7202a != i10) {
            this.f7202a = i10;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public void setFlexLines(List<C1631b> list) {
        this.f7217p = list;
    }

    public void setFlexWrap(int i10) {
        if (this.f7203b != i10) {
            this.f7203b = i10;
            requestLayout();
        }
    }

    public void setJustifyContent(int i10) {
        if (this.f7204c != i10) {
            this.f7204c = i10;
            requestLayout();
        }
    }

    public void setMaxLine(int i10) {
        if (this.f7207f != i10) {
            this.f7207f = i10;
            requestLayout();
        }
    }

    public void setShowDivider(int i10) {
        setShowDividerVertical(i10);
        setShowDividerHorizontal(i10);
    }

    public void setShowDividerHorizontal(int i10) {
        if (i10 != this.f7210i) {
            this.f7210i = i10;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i10) {
        if (i10 != this.f7211j) {
            this.f7211j = i10;
            requestLayout();
        }
    }

    /* renamed from: t */
    public final boolean m9292t(int i10) {
        if (i10 < 0 || i10 >= this.f7217p.size()) {
            return false;
        }
        return m9281i(i10) ? mo9286n() ? (this.f7210i & 1) != 0 : (this.f7211j & 1) != 0 : mo9286n() ? (this.f7210i & 2) != 0 : (this.f7211j & 2) != 0;
    }

    /* renamed from: u */
    public final boolean m9293u(int i10) {
        if (i10 < 0 || i10 >= this.f7217p.size()) {
            return false;
        }
        for (int i11 = i10 + 1; i11 < this.f7217p.size(); i11++) {
            if (this.f7217p.get(i11).m9412c() > 0) {
                return false;
            }
        }
        return mo9286n() ? (this.f7210i & 4) != 0 : (this.f7211j & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0200  */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m9294v(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.m9294v(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f6  */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m9295w(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.m9295w(boolean, boolean, int, int, int, int):void");
    }

    /* renamed from: x */
    public final void m9296x(int i10, int i11) {
        this.f7217p.clear();
        this.f7218q.m9466a();
        this.f7216o.m9442c(this.f7218q, i10, i11);
        this.f7217p = this.f7218q.f7308a;
        this.f7216o.m9455p(i10, i11);
        if (this.f7205d == 3) {
            for (C1631b c1631b : this.f7217p) {
                int iMax = Integer.MIN_VALUE;
                for (int i12 = 0; i12 < c1631b.f7292h; i12++) {
                    View viewM9290r = m9290r(c1631b.f7299o + i12);
                    if (viewM9290r != null && viewM9290r.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) viewM9290r.getLayoutParams();
                        iMax = this.f7203b != 2 ? Math.max(iMax, viewM9290r.getMeasuredHeight() + Math.max(c1631b.f7296l - viewM9290r.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, viewM9290r.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((c1631b.f7296l - viewM9290r.getMeasuredHeight()) + viewM9290r.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                c1631b.f7291g = iMax;
            }
        }
        this.f7216o.m9454o(i10, i11, getPaddingTop() + getPaddingBottom());
        this.f7216o.m9437X();
        m9298z(this.f7202a, i10, i11, this.f7218q.f7309b);
    }

    /* renamed from: y */
    public final void m9297y(int i10, int i11) {
        this.f7217p.clear();
        this.f7218q.m9466a();
        this.f7216o.m9445f(this.f7218q, i10, i11);
        this.f7217p = this.f7218q.f7308a;
        this.f7216o.m9455p(i10, i11);
        this.f7216o.m9454o(i10, i11, getPaddingLeft() + getPaddingRight());
        this.f7216o.m9437X();
        m9298z(this.f7202a, i10, i11, this.f7218q.f7309b);
    }

    /* renamed from: z */
    public final void m9298z(int i10, int i11, int i12, int i13) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (i10 == 0 || i10 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i10 != 2 && i10 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i10);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i13 = View.combineMeasuredStates(i13, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i11, i13);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i11, i13);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i13 = View.combineMeasuredStates(i13, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i11, i13);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i13 = View.combineMeasuredStates(i13, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i12, i13);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i12, i13);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i13 = View.combineMeasuredStates(i13, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i12, i13);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7207f = -1;
        this.f7216o = new C1632c(this);
        this.f7217p = new ArrayList();
        this.f7218q = new C1632c.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout, i10, 0);
        this.f7202a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexDirection, 0);
        this.f7203b = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexWrap, 0);
        this.f7204c = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_justifyContent, 0);
        this.f7205d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignItems, 0);
        this.f7206e = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignContent, 0);
        this.f7207f = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDivider, 0);
        if (i11 != 0) {
            this.f7211j = i11;
            this.f7210i = i11;
        }
        int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerVertical, 0);
        if (i12 != 0) {
            this.f7211j = i12;
        }
        int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i13 != 0) {
            this.f7210i = i13;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new C1624a();

        /* renamed from: a */
        public int f7219a;

        /* renamed from: b */
        public float f7220b;

        /* renamed from: c */
        public float f7221c;

        /* renamed from: d */
        public int f7222d;

        /* renamed from: e */
        public float f7223e;

        /* renamed from: f */
        public int f7224f;

        /* renamed from: g */
        public int f7225g;

        /* renamed from: h */
        public int f7226h;

        /* renamed from: i */
        public int f7227i;

        /* renamed from: j */
        public boolean f7228j;

        /* renamed from: com.google.android.flexbox.FlexboxLayout$LayoutParams$a */
        public class C1624a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i10) {
                return new LayoutParams[i10];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7219a = 1;
            this.f7220b = 0.0f;
            this.f7221c = 1.0f;
            this.f7222d = -1;
            this.f7223e = -1.0f;
            this.f7224f = -1;
            this.f7225g = -1;
            this.f7226h = 16777215;
            this.f7227i = 16777215;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
            this.f7219a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f7220b = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f7221c = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f7222d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f7223e = typedArrayObtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f7224f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.f7225g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.f7226h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.f7227i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.f7228j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: B */
        public int mo9250B() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: D */
        public int mo9251D() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: E */
        public void mo9252E(int i10) {
            this.f7225g = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: F */
        public float mo9253F() {
            return this.f7220b;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: H */
        public float mo9254H() {
            return this.f7223e;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: Z */
        public int mo9255Z() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f7219a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: j0 */
        public int mo9256j0() {
            return this.f7225g;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: m0 */
        public boolean mo9257m0() {
            return this.f7228j;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: n0 */
        public int mo9258n0() {
            return this.f7227i;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: r0 */
        public int mo9259r0() {
            return this.f7226h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i10) {
            this.f7224f = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: w */
        public int mo9260w() {
            return this.f7222d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f7219a);
            parcel.writeFloat(this.f7220b);
            parcel.writeFloat(this.f7221c);
            parcel.writeInt(this.f7222d);
            parcel.writeFloat(this.f7223e);
            parcel.writeInt(this.f7224f);
            parcel.writeInt(this.f7225g);
            parcel.writeInt(this.f7226h);
            parcel.writeInt(this.f7227i);
            parcel.writeByte(this.f7228j ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: x */
        public float mo9261x() {
            return this.f7221c;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: y */
        public int mo9262y() {
            return this.f7224f;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: z */
        public int mo9263z() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f7219a = 1;
            this.f7220b = 0.0f;
            this.f7221c = 1.0f;
            this.f7222d = -1;
            this.f7223e = -1.0f;
            this.f7224f = -1;
            this.f7225g = -1;
            this.f7226h = 16777215;
            this.f7227i = 16777215;
            this.f7219a = layoutParams.f7219a;
            this.f7220b = layoutParams.f7220b;
            this.f7221c = layoutParams.f7221c;
            this.f7222d = layoutParams.f7222d;
            this.f7223e = layoutParams.f7223e;
            this.f7224f = layoutParams.f7224f;
            this.f7225g = layoutParams.f7225g;
            this.f7226h = layoutParams.f7226h;
            this.f7227i = layoutParams.f7227i;
            this.f7228j = layoutParams.f7228j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7219a = 1;
            this.f7220b = 0.0f;
            this.f7221c = 1.0f;
            this.f7222d = -1;
            this.f7223e = -1.0f;
            this.f7224f = -1;
            this.f7225g = -1;
            this.f7226h = 16777215;
            this.f7227i = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7219a = 1;
            this.f7220b = 0.0f;
            this.f7221c = 1.0f;
            this.f7222d = -1;
            this.f7223e = -1.0f;
            this.f7224f = -1;
            this.f7225g = -1;
            this.f7226h = 16777215;
            this.f7227i = 16777215;
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f7219a = 1;
            this.f7220b = 0.0f;
            this.f7221c = 1.0f;
            this.f7222d = -1;
            this.f7223e = -1.0f;
            this.f7224f = -1;
            this.f7225g = -1;
            this.f7226h = 16777215;
            this.f7227i = 16777215;
            this.f7219a = parcel.readInt();
            this.f7220b = parcel.readFloat();
            this.f7221c = parcel.readFloat();
            this.f7222d = parcel.readInt();
            this.f7223e = parcel.readFloat();
            this.f7224f = parcel.readInt();
            this.f7225g = parcel.readInt();
            this.f7226h = parcel.readInt();
            this.f7227i = parcel.readInt();
            this.f7228j = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
