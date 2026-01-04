package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.widget.C0662c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p273f0.C9620q;

/* renamed from: com.google.android.flexbox.c */
/* loaded from: classes.dex */
public class C1632c {

    /* renamed from: a */
    public final InterfaceC1630a f7303a;

    /* renamed from: b */
    public boolean[] f7304b;

    /* renamed from: c */
    public int[] f7305c;

    /* renamed from: d */
    public long[] f7306d;

    /* renamed from: e */
    public long[] f7307e;

    /* renamed from: com.google.android.flexbox.c$b */
    public static class b {

        /* renamed from: a */
        public List<C1631b> f7308a;

        /* renamed from: b */
        public int f7309b;

        /* renamed from: a */
        public void m9466a() {
            this.f7308a = null;
            this.f7309b = 0;
        }
    }

    /* renamed from: com.google.android.flexbox.c$c */
    public static class c implements Comparable<c> {

        /* renamed from: a */
        public int f7310a;

        /* renamed from: b */
        public int f7311b;

        public c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i10 = this.f7311b;
            int i11 = cVar.f7311b;
            return i10 != i11 ? i10 - i11 : this.f7310a - cVar.f7310a;
        }

        public String toString() {
            return "Order{order=" + this.f7311b + ", index=" + this.f7310a + '}';
        }
    }

    public C1632c(InterfaceC1630a interfaceC1630a) {
        this.f7303a = interfaceC1630a;
    }

    /* renamed from: A */
    public final int m9414A(int i10, FlexItem flexItem, int i11) {
        InterfaceC1630a interfaceC1630a = this.f7303a;
        int iMo9276d = interfaceC1630a.mo9276d(i10, interfaceC1630a.getPaddingLeft() + this.f7303a.getPaddingRight() + flexItem.mo9250B() + flexItem.mo9255Z() + i11, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iMo9276d);
        return size > flexItem.mo9259r0() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo9259r0(), View.MeasureSpec.getMode(iMo9276d)) : size < flexItem.mo9262y() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo9262y(), View.MeasureSpec.getMode(iMo9276d)) : iMo9276d;
    }

    /* renamed from: B */
    public final int m9415B(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.mo9263z() : flexItem.mo9255Z();
    }

    /* renamed from: C */
    public final int m9416C(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.mo9255Z() : flexItem.mo9263z();
    }

    /* renamed from: D */
    public final int m9417D(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.mo9251D() : flexItem.mo9250B();
    }

    /* renamed from: E */
    public final int m9418E(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.mo9250B() : flexItem.mo9251D();
    }

    /* renamed from: F */
    public final int m9419F(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getHeight() : flexItem.getWidth();
    }

    /* renamed from: G */
    public final int m9420G(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getWidth() : flexItem.getHeight();
    }

    /* renamed from: H */
    public final int m9421H(boolean z10) {
        return z10 ? this.f7303a.getPaddingBottom() : this.f7303a.getPaddingEnd();
    }

    /* renamed from: I */
    public final int m9422I(boolean z10) {
        return z10 ? this.f7303a.getPaddingEnd() : this.f7303a.getPaddingBottom();
    }

    /* renamed from: J */
    public final int m9423J(boolean z10) {
        return z10 ? this.f7303a.getPaddingTop() : this.f7303a.getPaddingStart();
    }

    /* renamed from: K */
    public final int m9424K(boolean z10) {
        return z10 ? this.f7303a.getPaddingStart() : this.f7303a.getPaddingTop();
    }

    /* renamed from: L */
    public final int m9425L(View view, boolean z10) {
        return z10 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    /* renamed from: M */
    public final int m9426M(View view, boolean z10) {
        return z10 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    /* renamed from: N */
    public final boolean m9427N(int i10, int i11, C1631b c1631b) {
        return i10 == i11 - 1 && c1631b.m9412c() != 0;
    }

    /* renamed from: O */
    public boolean m9428O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f7303a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i10 = 0; i10 < flexItemCount; i10++) {
            View viewMo9278f = this.f7303a.mo9278f(i10);
            if (viewMo9278f != null && ((FlexItem) viewMo9278f.getLayoutParams()).getOrder() != sparseIntArray.get(i10)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: P */
    public final boolean m9429P(View view, int i10, int i11, int i12, int i13, FlexItem flexItem, int i14, int i15, int i16) {
        if (this.f7303a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.mo9257m0()) {
            return true;
        }
        if (i10 == 0) {
            return false;
        }
        int maxLine = this.f7303a.getMaxLine();
        if (maxLine != -1 && maxLine <= i16 + 1) {
            return false;
        }
        int iMo9279g = this.f7303a.mo9279g(view, i14, i15);
        if (iMo9279g > 0) {
            i13 += iMo9279g;
        }
        return i11 < i12 + i13;
    }

    /* renamed from: Q */
    public void m9430Q(View view, C1631b c1631b, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f7303a.getAlignItems();
        if (flexItem.mo9260w() != -1) {
            alignItems = flexItem.mo9260w();
        }
        int i14 = c1631b.f7291g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f7303a.getFlexWrap() == 2) {
                    view.layout(i10, (i11 - i14) + view.getMeasuredHeight() + flexItem.mo9251D(), i12, (i13 - i14) + view.getMeasuredHeight() + flexItem.mo9251D());
                    return;
                } else {
                    int i15 = i11 + i14;
                    view.layout(i10, (i15 - view.getMeasuredHeight()) - flexItem.mo9263z(), i12, i15 - flexItem.mo9263z());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i14 - view.getMeasuredHeight()) + flexItem.mo9251D()) - flexItem.mo9263z()) / 2;
                if (this.f7303a.getFlexWrap() != 2) {
                    int i16 = i11 + measuredHeight;
                    view.layout(i10, i16, i12, view.getMeasuredHeight() + i16);
                    return;
                } else {
                    int i17 = i11 - measuredHeight;
                    view.layout(i10, i17, i12, view.getMeasuredHeight() + i17);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f7303a.getFlexWrap() != 2) {
                    int iMax = Math.max(c1631b.f7296l - view.getBaseline(), flexItem.mo9251D());
                    view.layout(i10, i11 + iMax, i12, i13 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((c1631b.f7296l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.mo9263z());
                    view.layout(i10, i11 - iMax2, i12, i13 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f7303a.getFlexWrap() != 2) {
            view.layout(i10, i11 + flexItem.mo9251D(), i12, i13 + flexItem.mo9251D());
        } else {
            view.layout(i10, i11 - flexItem.mo9263z(), i12, i13 - flexItem.mo9263z());
        }
    }

    /* renamed from: R */
    public void m9431R(View view, C1631b c1631b, boolean z10, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f7303a.getAlignItems();
        if (flexItem.mo9260w() != -1) {
            alignItems = flexItem.mo9260w();
        }
        int i14 = c1631b.f7291g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z10) {
                    view.layout((i10 - i14) + view.getMeasuredWidth() + flexItem.mo9250B(), i11, (i12 - i14) + view.getMeasuredWidth() + flexItem.mo9250B(), i13);
                    return;
                } else {
                    view.layout(((i10 + i14) - view.getMeasuredWidth()) - flexItem.mo9255Z(), i11, ((i12 + i14) - view.getMeasuredWidth()) - flexItem.mo9255Z(), i13);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i14 - view.getMeasuredWidth()) + C9620q.m60124b(marginLayoutParams)) - C9620q.m60123a(marginLayoutParams)) / 2;
                if (z10) {
                    view.layout(i10 - measuredWidth, i11, i12 - measuredWidth, i13);
                    return;
                } else {
                    view.layout(i10 + measuredWidth, i11, i12 + measuredWidth, i13);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z10) {
            view.layout(i10 - flexItem.mo9255Z(), i11, i12 - flexItem.mo9255Z(), i13);
        } else {
            view.layout(i10 + flexItem.mo9250B(), i11, i12 + flexItem.mo9250B(), i13);
        }
    }

    /* renamed from: S */
    public long m9432S(int i10, int i11) {
        return (i10 & 4294967295L) | (i11 << 32);
    }

    /* renamed from: T */
    public final void m9433T(int i10, int i11, C1631b c1631b, int i12, int i13, boolean z10) {
        int iMax;
        int i14 = c1631b.f7289e;
        float f10 = c1631b.f7295k;
        float f11 = 0.0f;
        if (f10 <= 0.0f || i12 > i14) {
            return;
        }
        float f12 = (i14 - i12) / f10;
        c1631b.f7289e = i13 + c1631b.f7290f;
        if (!z10) {
            c1631b.f7291g = Integer.MIN_VALUE;
        }
        int i15 = 0;
        boolean z11 = false;
        int i16 = 0;
        float f13 = 0.0f;
        while (i15 < c1631b.f7292h) {
            int i17 = c1631b.f7299o + i15;
            View viewMo9275c = this.f7303a.mo9275c(i17);
            if (viewMo9275c != null && viewMo9275c.getVisibility() != 8) {
                FlexItem flexItem = (FlexItem) viewMo9275c.getLayoutParams();
                int flexDirection = this.f7303a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = viewMo9275c.getMeasuredWidth();
                    long[] jArr = this.f7307e;
                    if (jArr != null) {
                        measuredWidth = m9464y(jArr[i17]);
                    }
                    int measuredHeight = viewMo9275c.getMeasuredHeight();
                    long[] jArr2 = this.f7307e;
                    if (jArr2 != null) {
                        measuredHeight = m9463x(jArr2[i17]);
                    }
                    if (!this.f7304b[i17] && flexItem.mo9261x() > 0.0f) {
                        float fMo9261x = measuredWidth - (flexItem.mo9261x() * f12);
                        if (i15 == c1631b.f7292h - 1) {
                            fMo9261x += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fMo9261x);
                        if (iRound < flexItem.mo9262y()) {
                            iRound = flexItem.mo9262y();
                            this.f7304b[i17] = true;
                            c1631b.f7295k -= flexItem.mo9261x();
                            z11 = true;
                        } else {
                            f13 += fMo9261x - iRound;
                            double d10 = f13;
                            if (d10 > 1.0d) {
                                iRound++;
                                f13 -= 1.0f;
                            } else if (d10 < -1.0d) {
                                iRound--;
                                f13 += 1.0f;
                            }
                        }
                        int iM9465z = m9465z(i11, flexItem, c1631b.f7297m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewMo9275c.measure(iMakeMeasureSpec, iM9465z);
                        int measuredWidth2 = viewMo9275c.getMeasuredWidth();
                        int measuredHeight2 = viewMo9275c.getMeasuredHeight();
                        m9439Z(i17, iMakeMeasureSpec, iM9465z, viewMo9275c);
                        this.f7303a.mo9277e(i17, viewMo9275c);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i16, measuredHeight + flexItem.mo9251D() + flexItem.mo9263z() + this.f7303a.mo9287o(viewMo9275c));
                    c1631b.f7289e += measuredWidth + flexItem.mo9250B() + flexItem.mo9255Z();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewMo9275c.getMeasuredHeight();
                    long[] jArr3 = this.f7307e;
                    if (jArr3 != null) {
                        measuredHeight3 = m9463x(jArr3[i17]);
                    }
                    int measuredWidth3 = viewMo9275c.getMeasuredWidth();
                    long[] jArr4 = this.f7307e;
                    if (jArr4 != null) {
                        measuredWidth3 = m9464y(jArr4[i17]);
                    }
                    if (!this.f7304b[i17] && flexItem.mo9261x() > f11) {
                        float fMo9261x2 = measuredHeight3 - (flexItem.mo9261x() * f12);
                        if (i15 == c1631b.f7292h - 1) {
                            fMo9261x2 += f13;
                            f13 = f11;
                        }
                        int iRound2 = Math.round(fMo9261x2);
                        if (iRound2 < flexItem.mo9256j0()) {
                            iRound2 = flexItem.mo9256j0();
                            this.f7304b[i17] = true;
                            c1631b.f7295k -= flexItem.mo9261x();
                            z11 = true;
                        } else {
                            f13 += fMo9261x2 - iRound2;
                            double d11 = f13;
                            if (d11 > 1.0d) {
                                iRound2++;
                                f13 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                iRound2--;
                                f13 += 1.0f;
                            }
                        }
                        int iM9414A = m9414A(i10, flexItem, c1631b.f7297m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewMo9275c.measure(iM9414A, iMakeMeasureSpec2);
                        measuredWidth3 = viewMo9275c.getMeasuredWidth();
                        int measuredHeight4 = viewMo9275c.getMeasuredHeight();
                        m9439Z(i17, iM9414A, iMakeMeasureSpec2, viewMo9275c);
                        this.f7303a.mo9277e(i17, viewMo9275c);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i16, measuredWidth3 + flexItem.mo9250B() + flexItem.mo9255Z() + this.f7303a.mo9287o(viewMo9275c));
                    c1631b.f7289e += measuredHeight3 + flexItem.mo9251D() + flexItem.mo9263z();
                }
                c1631b.f7291g = Math.max(c1631b.f7291g, iMax);
                i16 = iMax;
            }
            i15++;
            f11 = 0.0f;
        }
        if (!z11 || i14 == c1631b.f7289e) {
            return;
        }
        m9433T(i10, i11, c1631b, i12, i13, true);
    }

    /* renamed from: U */
    public final int[] m9434U(int i10, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i10];
        int i11 = 0;
        for (c cVar : list) {
            int i12 = cVar.f7310a;
            iArr[i11] = i12;
            sparseIntArray.append(i12, cVar.f7311b);
            i11++;
        }
        return iArr;
    }

    /* renamed from: V */
    public final void m9435V(View view, int i10, int i11) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.mo9250B()) - flexItem.mo9255Z()) - this.f7303a.mo9287o(view), flexItem.mo9262y()), flexItem.mo9259r0());
        long[] jArr = this.f7307e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? m9463x(jArr[i11]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        m9439Z(i11, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f7303a.mo9277e(i11, view);
    }

    /* renamed from: W */
    public final void m9436W(View view, int i10, int i11) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.mo9251D()) - flexItem.mo9263z()) - this.f7303a.mo9287o(view), flexItem.mo9256j0()), flexItem.mo9258n0());
        long[] jArr = this.f7307e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? m9464y(jArr[i11]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        m9439Z(i11, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f7303a.mo9277e(i11, view);
    }

    /* renamed from: X */
    public void m9437X() {
        m9438Y(0);
    }

    /* renamed from: Y */
    public void m9438Y(int i10) {
        View viewMo9275c;
        if (i10 >= this.f7303a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f7303a.getFlexDirection();
        if (this.f7303a.getAlignItems() != 4) {
            for (C1631b c1631b : this.f7303a.getFlexLinesInternal()) {
                for (Integer num : c1631b.f7298n) {
                    View viewMo9275c2 = this.f7303a.mo9275c(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        m9436W(viewMo9275c2, c1631b.f7291g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        m9435V(viewMo9275c2, c1631b.f7291g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f7305c;
        List<C1631b> flexLinesInternal = this.f7303a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i11 = iArr != null ? iArr[i10] : 0; i11 < size; i11++) {
            C1631b c1631b2 = flexLinesInternal.get(i11);
            int i12 = c1631b2.f7292h;
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = c1631b2.f7299o + i13;
                if (i13 < this.f7303a.getFlexItemCount() && (viewMo9275c = this.f7303a.mo9275c(i14)) != null && viewMo9275c.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewMo9275c.getLayoutParams();
                    if (flexItem.mo9260w() == -1 || flexItem.mo9260w() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            m9436W(viewMo9275c, c1631b2.f7291g, i14);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            m9435V(viewMo9275c, c1631b2.f7291g, i14);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: Z */
    public final void m9439Z(int i10, int i11, int i12, View view) {
        long[] jArr = this.f7306d;
        if (jArr != null) {
            jArr[i10] = m9432S(i11, i12);
        }
        long[] jArr2 = this.f7307e;
        if (jArr2 != null) {
            jArr2[i10] = m9432S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* renamed from: a */
    public final void m9440a(List<C1631b> list, C1631b c1631b, int i10, int i11) {
        c1631b.f7297m = i11;
        this.f7303a.mo9274b(c1631b);
        c1631b.f7300p = i10;
        list.add(c1631b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public void m9441b(b bVar, int i10, int i11, int i12, int i13, int i14, List<C1631b> list) {
        int i15;
        b bVar2;
        int i16;
        int i17;
        int i18;
        List<C1631b> list2;
        int i19;
        View view;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28 = i10;
        int i29 = i11;
        int i30 = i14;
        boolean zMo9286n = this.f7303a.mo9286n();
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        List<C1631b> arrayList = list == null ? new ArrayList() : list;
        bVar.f7308a = arrayList;
        int i31 = i30 == -1 ? 1 : 0;
        int iM9424K = m9424K(zMo9286n);
        int iM9422I = m9422I(zMo9286n);
        int iM9423J = m9423J(zMo9286n);
        int iM9421H = m9421H(zMo9286n);
        C1631b c1631b = new C1631b();
        int i32 = i13;
        c1631b.f7299o = i32;
        int i33 = iM9422I + iM9424K;
        c1631b.f7289e = i33;
        int flexItemCount = this.f7303a.getFlexItemCount();
        int i34 = i31;
        int i35 = Integer.MIN_VALUE;
        int i36 = 0;
        int iCombineMeasuredStates = 0;
        int i37 = 0;
        while (true) {
            if (i32 >= flexItemCount) {
                i15 = iCombineMeasuredStates;
                bVar2 = bVar;
                break;
            }
            View viewMo9275c = this.f7303a.mo9275c(i32);
            if (viewMo9275c != null) {
                if (viewMo9275c.getVisibility() != 8) {
                    if (viewMo9275c instanceof CompoundButton) {
                        m9461v((CompoundButton) viewMo9275c);
                    }
                    FlexItem flexItem = (FlexItem) viewMo9275c.getLayoutParams();
                    int i38 = flexItemCount;
                    if (flexItem.mo9260w() == 4) {
                        c1631b.f7298n.add(Integer.valueOf(i32));
                    }
                    int iM9420G = m9420G(flexItem, zMo9286n);
                    if (flexItem.mo9254H() != -1.0f && mode == 1073741824) {
                        iM9420G = Math.round(size * flexItem.mo9254H());
                    }
                    if (zMo9286n) {
                        int iMo9276d = this.f7303a.mo9276d(i28, i33 + m9418E(flexItem, true) + m9416C(flexItem, true), iM9420G);
                        i16 = size;
                        i17 = mode;
                        int iMo9280h = this.f7303a.mo9280h(i29, iM9423J + iM9421H + m9417D(flexItem, true) + m9415B(flexItem, true) + i36, m9419F(flexItem, true));
                        viewMo9275c.measure(iMo9276d, iMo9280h);
                        m9439Z(i32, iMo9276d, iMo9280h, viewMo9275c);
                        i18 = iMo9276d;
                    } else {
                        i16 = size;
                        i17 = mode;
                        int iMo9276d2 = this.f7303a.mo9276d(i29, iM9423J + iM9421H + m9417D(flexItem, false) + m9415B(flexItem, false) + i36, m9419F(flexItem, false));
                        int iMo9280h2 = this.f7303a.mo9280h(i28, m9418E(flexItem, false) + i33 + m9416C(flexItem, false), iM9420G);
                        viewMo9275c.measure(iMo9276d2, iMo9280h2);
                        m9439Z(i32, iMo9276d2, iMo9280h2, viewMo9275c);
                        i18 = iMo9280h2;
                    }
                    this.f7303a.mo9277e(i32, viewMo9275c);
                    m9448i(viewMo9275c, i32);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewMo9275c.getMeasuredState());
                    int i39 = i36;
                    int i40 = i33;
                    C1631b c1631b2 = c1631b;
                    int i41 = i32;
                    list2 = arrayList;
                    int i42 = i18;
                    if (m9429P(viewMo9275c, i17, i16, c1631b.f7289e, m9416C(flexItem, zMo9286n) + m9426M(viewMo9275c, zMo9286n) + m9418E(flexItem, zMo9286n), flexItem, i41, i37, arrayList.size())) {
                        i32 = i41;
                        if (c1631b2.m9412c() > 0) {
                            m9440a(list2, c1631b2, i32 > 0 ? i32 - 1 : 0, i39);
                            i36 = c1631b2.f7291g + i39;
                        } else {
                            i36 = i39;
                        }
                        if (!zMo9286n) {
                            i19 = i11;
                            view = viewMo9275c;
                            i20 = -1;
                            if (flexItem.getWidth() == -1) {
                                InterfaceC1630a interfaceC1630a = this.f7303a;
                                view.measure(interfaceC1630a.mo9276d(i19, interfaceC1630a.getPaddingLeft() + this.f7303a.getPaddingRight() + flexItem.mo9250B() + flexItem.mo9255Z() + i36, flexItem.getWidth()), i42);
                                m9448i(view, i32);
                            }
                        } else if (flexItem.getHeight() == -1) {
                            InterfaceC1630a interfaceC1630a2 = this.f7303a;
                            i19 = i11;
                            i20 = -1;
                            view = viewMo9275c;
                            view.measure(i42, interfaceC1630a2.mo9280h(i19, interfaceC1630a2.getPaddingTop() + this.f7303a.getPaddingBottom() + flexItem.mo9251D() + flexItem.mo9263z() + i36, flexItem.getHeight()));
                            m9448i(view, i32);
                        } else {
                            i19 = i11;
                            view = viewMo9275c;
                            i20 = -1;
                        }
                        c1631b = new C1631b();
                        i22 = 1;
                        c1631b.f7292h = 1;
                        i21 = i40;
                        c1631b.f7289e = i21;
                        c1631b.f7299o = i32;
                        i24 = Integer.MIN_VALUE;
                        i23 = 0;
                    } else {
                        i19 = i11;
                        i32 = i41;
                        view = viewMo9275c;
                        i20 = -1;
                        c1631b = c1631b2;
                        i21 = i40;
                        i22 = 1;
                        c1631b.f7292h++;
                        i23 = i37 + 1;
                        i36 = i39;
                        i24 = i35;
                    }
                    c1631b.f7301q = (c1631b.f7301q ? 1 : 0) | (flexItem.mo9253F() != 0.0f ? i22 : 0);
                    c1631b.f7302r = (c1631b.f7302r ? 1 : 0) | (flexItem.mo9261x() != 0.0f ? i22 : 0);
                    int[] iArr = this.f7305c;
                    if (iArr != null) {
                        iArr[i32] = list2.size();
                    }
                    c1631b.f7289e += m9426M(view, zMo9286n) + m9418E(flexItem, zMo9286n) + m9416C(flexItem, zMo9286n);
                    c1631b.f7294j += flexItem.mo9253F();
                    c1631b.f7295k += flexItem.mo9261x();
                    this.f7303a.mo9273a(view, i32, i23, c1631b);
                    int iMax = Math.max(i24, m9425L(view, zMo9286n) + m9417D(flexItem, zMo9286n) + m9415B(flexItem, zMo9286n) + this.f7303a.mo9287o(view));
                    c1631b.f7291g = Math.max(c1631b.f7291g, iMax);
                    if (zMo9286n) {
                        if (this.f7303a.getFlexWrap() != 2) {
                            c1631b.f7296l = Math.max(c1631b.f7296l, view.getBaseline() + flexItem.mo9251D());
                        } else {
                            c1631b.f7296l = Math.max(c1631b.f7296l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.mo9263z());
                        }
                    }
                    i25 = i38;
                    if (m9427N(i32, i25, c1631b)) {
                        m9440a(list2, c1631b, i32, i36);
                        i36 += c1631b.f7291g;
                    }
                    i26 = i14;
                    if (i26 == i20 || list2.size() <= 0 || list2.get(list2.size() - i22).f7300p < i26 || i32 < i26 || i34 != 0) {
                        i27 = i12;
                    } else {
                        i36 = -c1631b.m9410a();
                        i27 = i12;
                        i34 = i22;
                    }
                    if (i36 > i27 && i34 != 0) {
                        bVar2 = bVar;
                        i15 = iCombineMeasuredStates;
                        break;
                    }
                    i37 = i23;
                    i35 = iMax;
                    i32++;
                    i28 = i10;
                    flexItemCount = i25;
                    i29 = i19;
                    i33 = i21;
                    arrayList = list2;
                    size = i16;
                    mode = i17;
                    i30 = i26;
                } else {
                    c1631b.f7293i++;
                    c1631b.f7292h++;
                    if (m9427N(i32, flexItemCount, c1631b)) {
                        m9440a(arrayList, c1631b, i32, i36);
                    }
                }
            } else if (m9427N(i32, flexItemCount, c1631b)) {
                m9440a(arrayList, c1631b, i32, i36);
            }
            i16 = size;
            i17 = mode;
            i19 = i29;
            i26 = i30;
            i21 = i33;
            list2 = arrayList;
            i25 = flexItemCount;
            i32++;
            i28 = i10;
            flexItemCount = i25;
            i29 = i19;
            i33 = i21;
            arrayList = list2;
            size = i16;
            mode = i17;
            i30 = i26;
        }
        bVar2.f7309b = i15;
    }

    /* renamed from: c */
    public void m9442c(b bVar, int i10, int i11) {
        m9441b(bVar, i10, i11, Integer.MAX_VALUE, 0, -1, null);
    }

    /* renamed from: d */
    public void m9443d(b bVar, int i10, int i11, int i12, int i13, List<C1631b> list) {
        m9441b(bVar, i10, i11, i12, i13, -1, list);
    }

    /* renamed from: e */
    public void m9444e(b bVar, int i10, int i11, int i12, int i13, List<C1631b> list) {
        m9441b(bVar, i10, i11, i12, 0, i13, list);
    }

    /* renamed from: f */
    public void m9445f(b bVar, int i10, int i11) {
        m9441b(bVar, i11, i10, Integer.MAX_VALUE, 0, -1, null);
    }

    /* renamed from: g */
    public void m9446g(b bVar, int i10, int i11, int i12, int i13, List<C1631b> list) {
        m9441b(bVar, i11, i10, i12, i13, -1, list);
    }

    /* renamed from: h */
    public void m9447h(b bVar, int i10, int i11, int i12, int i13, List<C1631b> list) {
        m9441b(bVar, i11, i10, i12, 0, i13, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m9448i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.mo9262y()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.mo9262y()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.mo9259r0()
            if (r1 <= r3) goto L26
            int r1 = r0.mo9259r0()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.mo9256j0()
            if (r2 >= r5) goto L32
            int r2 = r0.mo9256j0()
            goto L3e
        L32:
            int r5 = r0.mo9258n0()
            if (r2 <= r5) goto L3d
            int r2 = r0.mo9258n0()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.m9439Z(r8, r1, r0, r7)
            com.google.android.flexbox.a r6 = r6.f7303a
            r6.mo9277e(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.C1632c.m9448i(android.view.View, int):void");
    }

    /* renamed from: j */
    public void m9449j(List<C1631b> list, int i10) {
        int i11 = this.f7305c[i10];
        if (i11 == -1) {
            i11 = 0;
        }
        if (list.size() > i11) {
            list.subList(i11, list.size()).clear();
        }
        int[] iArr = this.f7305c;
        int length = iArr.length - 1;
        if (i10 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i10, length, -1);
        }
        long[] jArr = this.f7306d;
        int length2 = jArr.length - 1;
        if (i10 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i10, length2, 0L);
        }
    }

    /* renamed from: k */
    public final List<C1631b> m9450k(List<C1631b> list, int i10, int i11) {
        int i12 = (i10 - i11) / 2;
        ArrayList arrayList = new ArrayList();
        C1631b c1631b = new C1631b();
        c1631b.f7291g = i12;
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            if (i13 == 0) {
                arrayList.add(c1631b);
            }
            arrayList.add(list.get(i13));
            if (i13 == list.size() - 1) {
                arrayList.add(c1631b);
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public final List<c> m9451l(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            FlexItem flexItem = (FlexItem) this.f7303a.mo9278f(i11).getLayoutParams();
            c cVar = new c();
            cVar.f7311b = flexItem.getOrder();
            cVar.f7310a = i11;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* renamed from: m */
    public int[] m9452m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f7303a.getFlexItemCount();
        return m9434U(flexItemCount, m9451l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: n */
    public int[] m9453n(View view, int i10, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f7303a.getFlexItemCount();
        List<c> listM9451l = m9451l(flexItemCount);
        c cVar = new c();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            cVar.f7311b = 1;
        } else {
            cVar.f7311b = ((FlexItem) layoutParams).getOrder();
        }
        if (i10 == -1 || i10 == flexItemCount || i10 >= this.f7303a.getFlexItemCount()) {
            cVar.f7310a = flexItemCount;
        } else {
            cVar.f7310a = i10;
            while (i10 < flexItemCount) {
                listM9451l.get(i10).f7310a++;
                i10++;
            }
        }
        listM9451l.add(cVar);
        return m9434U(flexItemCount + 1, listM9451l, sparseIntArray);
    }

    /* renamed from: o */
    public void m9454o(int i10, int i11, int i12) {
        int mode;
        int size;
        int flexDirection = this.f7303a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i11);
            int size2 = View.MeasureSpec.getSize(i11);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(i10);
            size = View.MeasureSpec.getSize(i10);
        }
        List<C1631b> flexLinesInternal = this.f7303a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f7303a.getSumOfCrossSize() + i12;
            int i13 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f7291g = size - i12;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f7303a.getAlignContent();
                if (alignContent == 1) {
                    C1631b c1631b = new C1631b();
                    c1631b.f7291g = size - sumOfCrossSize;
                    flexLinesInternal.add(0, c1631b);
                    return;
                }
                if (alignContent == 2) {
                    this.f7303a.setFlexLines(m9450k(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f10 = 0.0f;
                    while (i13 < size4) {
                        arrayList.add(flexLinesInternal.get(i13));
                        if (i13 != flexLinesInternal.size() - 1) {
                            C1631b c1631b2 = new C1631b();
                            if (i13 == flexLinesInternal.size() - 2) {
                                c1631b2.f7291g = Math.round(f10 + size3);
                                f10 = 0.0f;
                            } else {
                                c1631b2.f7291g = Math.round(size3);
                            }
                            int i14 = c1631b2.f7291g;
                            f10 += size3 - i14;
                            if (f10 > 1.0f) {
                                c1631b2.f7291g = i14 + 1;
                                f10 -= 1.0f;
                            } else if (f10 < -1.0f) {
                                c1631b2.f7291g = i14 - 1;
                                f10 += 1.0f;
                            }
                            arrayList.add(c1631b2);
                        }
                        i13++;
                    }
                    this.f7303a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f7303a.setFlexLines(m9450k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    C1631b c1631b3 = new C1631b();
                    c1631b3.f7291g = size5;
                    for (C1631b c1631b4 : flexLinesInternal) {
                        arrayList2.add(c1631b3);
                        arrayList2.add(c1631b4);
                        arrayList2.add(c1631b3);
                    }
                    this.f7303a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f11 = 0.0f;
                    while (i13 < size7) {
                        C1631b c1631b5 = flexLinesInternal.get(i13);
                        float f12 = c1631b5.f7291g + size6;
                        if (i13 == flexLinesInternal.size() - 1) {
                            f12 += f11;
                            f11 = 0.0f;
                        }
                        int iRound = Math.round(f12);
                        f11 += f12 - iRound;
                        if (f11 > 1.0f) {
                            iRound++;
                            f11 -= 1.0f;
                        } else if (f11 < -1.0f) {
                            iRound--;
                            f11 += 1.0f;
                        }
                        c1631b5.f7291g = iRound;
                        i13++;
                    }
                }
            }
        }
    }

    /* renamed from: p */
    public void m9455p(int i10, int i11) {
        m9456q(i10, i11, 0);
    }

    /* renamed from: q */
    public void m9456q(int i10, int i11, int i12) {
        int size;
        int paddingLeft;
        int paddingRight;
        m9457r(this.f7303a.getFlexItemCount());
        if (i12 >= this.f7303a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f7303a.getFlexDirection();
        int flexDirection2 = this.f7303a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i10);
            size = View.MeasureSpec.getSize(i10);
            int largestMainSize = this.f7303a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f7303a.getPaddingLeft();
            paddingRight = this.f7303a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            if (mode2 != 1073741824) {
                size = this.f7303a.getLargestMainSize();
            }
            paddingLeft = this.f7303a.getPaddingTop();
            paddingRight = this.f7303a.getPaddingBottom();
        }
        int i13 = paddingLeft + paddingRight;
        int[] iArr = this.f7305c;
        List<C1631b> flexLinesInternal = this.f7303a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i14 = iArr != null ? iArr[i12] : 0; i14 < size2; i14++) {
            C1631b c1631b = flexLinesInternal.get(i14);
            int i15 = c1631b.f7289e;
            if (i15 < size && c1631b.f7301q) {
                m9462w(i10, i11, c1631b, size, i13, false);
            } else if (i15 > size && c1631b.f7302r) {
                m9433T(i10, i11, c1631b, size, i13, false);
            }
        }
    }

    /* renamed from: r */
    public final void m9457r(int i10) {
        boolean[] zArr = this.f7304b;
        if (zArr == null) {
            this.f7304b = new boolean[Math.max(i10, 10)];
        } else if (zArr.length < i10) {
            this.f7304b = new boolean[Math.max(zArr.length * 2, i10)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    /* renamed from: s */
    public void m9458s(int i10) {
        int[] iArr = this.f7305c;
        if (iArr == null) {
            this.f7305c = new int[Math.max(i10, 10)];
        } else if (iArr.length < i10) {
            this.f7305c = Arrays.copyOf(this.f7305c, Math.max(iArr.length * 2, i10));
        }
    }

    /* renamed from: t */
    public void m9459t(int i10) {
        long[] jArr = this.f7306d;
        if (jArr == null) {
            this.f7306d = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f7306d = Arrays.copyOf(this.f7306d, Math.max(jArr.length * 2, i10));
        }
    }

    /* renamed from: u */
    public void m9460u(int i10) {
        long[] jArr = this.f7307e;
        if (jArr == null) {
            this.f7307e = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f7307e = Arrays.copyOf(this.f7307e, Math.max(jArr.length * 2, i10));
        }
    }

    /* renamed from: v */
    public final void m9461v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int iMo9262y = flexItem.mo9262y();
        int iMo9256j0 = flexItem.mo9256j0();
        Drawable drawableM4039a = C0662c.m4039a(compoundButton);
        int minimumWidth = drawableM4039a == null ? 0 : drawableM4039a.getMinimumWidth();
        int minimumHeight = drawableM4039a != null ? drawableM4039a.getMinimumHeight() : 0;
        if (iMo9262y == -1) {
            iMo9262y = minimumWidth;
        }
        flexItem.setMinWidth(iMo9262y);
        if (iMo9256j0 == -1) {
            iMo9256j0 = minimumHeight;
        }
        flexItem.mo9252E(iMo9256j0);
    }

    /* renamed from: w */
    public final void m9462w(int i10, int i11, C1631b c1631b, int i12, int i13, boolean z10) {
        int i14;
        int i15;
        int iMax;
        double d10;
        double d11;
        float f10 = c1631b.f7294j;
        float f11 = 0.0f;
        if (f10 <= 0.0f || i12 < (i14 = c1631b.f7289e)) {
            return;
        }
        float f12 = (i12 - i14) / f10;
        c1631b.f7289e = i13 + c1631b.f7290f;
        if (!z10) {
            c1631b.f7291g = Integer.MIN_VALUE;
        }
        int i16 = 0;
        boolean z11 = false;
        int i17 = 0;
        float f13 = 0.0f;
        while (i16 < c1631b.f7292h) {
            int i18 = c1631b.f7299o + i16;
            View viewMo9275c = this.f7303a.mo9275c(i18);
            if (viewMo9275c == null || viewMo9275c.getVisibility() == 8) {
                i15 = i14;
            } else {
                FlexItem flexItem = (FlexItem) viewMo9275c.getLayoutParams();
                int flexDirection = this.f7303a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i15 = i14;
                    int measuredWidth = viewMo9275c.getMeasuredWidth();
                    long[] jArr = this.f7307e;
                    if (jArr != null) {
                        measuredWidth = m9464y(jArr[i18]);
                    }
                    int measuredHeight = viewMo9275c.getMeasuredHeight();
                    long[] jArr2 = this.f7307e;
                    if (jArr2 != null) {
                        measuredHeight = m9463x(jArr2[i18]);
                    }
                    if (!this.f7304b[i18] && flexItem.mo9253F() > 0.0f) {
                        float fMo9253F = measuredWidth + (flexItem.mo9253F() * f12);
                        if (i16 == c1631b.f7292h - 1) {
                            fMo9253F += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fMo9253F);
                        if (iRound > flexItem.mo9259r0()) {
                            iRound = flexItem.mo9259r0();
                            this.f7304b[i18] = true;
                            c1631b.f7294j -= flexItem.mo9253F();
                            z11 = true;
                        } else {
                            f13 += fMo9253F - iRound;
                            double d12 = f13;
                            if (d12 > 1.0d) {
                                iRound++;
                                d10 = d12 - 1.0d;
                            } else if (d12 < -1.0d) {
                                iRound--;
                                d10 = d12 + 1.0d;
                            }
                            f13 = (float) d10;
                        }
                        int iM9465z = m9465z(i11, flexItem, c1631b.f7297m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewMo9275c.measure(iMakeMeasureSpec, iM9465z);
                        int measuredWidth2 = viewMo9275c.getMeasuredWidth();
                        int measuredHeight2 = viewMo9275c.getMeasuredHeight();
                        m9439Z(i18, iMakeMeasureSpec, iM9465z, viewMo9275c);
                        this.f7303a.mo9277e(i18, viewMo9275c);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i17, measuredHeight + flexItem.mo9251D() + flexItem.mo9263z() + this.f7303a.mo9287o(viewMo9275c));
                    c1631b.f7289e += measuredWidth + flexItem.mo9250B() + flexItem.mo9255Z();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewMo9275c.getMeasuredHeight();
                    long[] jArr3 = this.f7307e;
                    if (jArr3 != null) {
                        measuredHeight3 = m9463x(jArr3[i18]);
                    }
                    int measuredWidth3 = viewMo9275c.getMeasuredWidth();
                    long[] jArr4 = this.f7307e;
                    if (jArr4 != null) {
                        measuredWidth3 = m9464y(jArr4[i18]);
                    }
                    if (this.f7304b[i18] || flexItem.mo9253F() <= f11) {
                        i15 = i14;
                    } else {
                        float fMo9253F2 = measuredHeight3 + (flexItem.mo9253F() * f12);
                        if (i16 == c1631b.f7292h - 1) {
                            fMo9253F2 += f13;
                            f13 = f11;
                        }
                        int iRound2 = Math.round(fMo9253F2);
                        if (iRound2 > flexItem.mo9258n0()) {
                            iRound2 = flexItem.mo9258n0();
                            this.f7304b[i18] = true;
                            c1631b.f7294j -= flexItem.mo9253F();
                            i15 = i14;
                            z11 = true;
                        } else {
                            f13 += fMo9253F2 - iRound2;
                            i15 = i14;
                            double d13 = f13;
                            if (d13 > 1.0d) {
                                iRound2++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                iRound2--;
                                d11 = d13 + 1.0d;
                            }
                            f13 = (float) d11;
                        }
                        int iM9414A = m9414A(i10, flexItem, c1631b.f7297m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewMo9275c.measure(iM9414A, iMakeMeasureSpec2);
                        measuredWidth3 = viewMo9275c.getMeasuredWidth();
                        int measuredHeight4 = viewMo9275c.getMeasuredHeight();
                        m9439Z(i18, iM9414A, iMakeMeasureSpec2, viewMo9275c);
                        this.f7303a.mo9277e(i18, viewMo9275c);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i17, measuredWidth3 + flexItem.mo9250B() + flexItem.mo9255Z() + this.f7303a.mo9287o(viewMo9275c));
                    c1631b.f7289e += measuredHeight3 + flexItem.mo9251D() + flexItem.mo9263z();
                }
                c1631b.f7291g = Math.max(c1631b.f7291g, iMax);
                i17 = iMax;
            }
            i16++;
            i14 = i15;
            f11 = 0.0f;
        }
        int i19 = i14;
        if (!z11 || i19 == c1631b.f7289e) {
            return;
        }
        m9462w(i10, i11, c1631b, i12, i13, true);
    }

    /* renamed from: x */
    public int m9463x(long j10) {
        return (int) (j10 >> 32);
    }

    /* renamed from: y */
    public int m9464y(long j10) {
        return (int) j10;
    }

    /* renamed from: z */
    public final int m9465z(int i10, FlexItem flexItem, int i11) {
        InterfaceC1630a interfaceC1630a = this.f7303a;
        int iMo9280h = interfaceC1630a.mo9280h(i10, interfaceC1630a.getPaddingTop() + this.f7303a.getPaddingBottom() + flexItem.mo9251D() + flexItem.mo9263z() + i11, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iMo9280h);
        return size > flexItem.mo9258n0() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo9258n0(), View.MeasureSpec.getMode(iMo9280h)) : size < flexItem.mo9256j0() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo9256j0(), View.MeasureSpec.getMode(iMo9280h)) : iMo9280h;
    }
}
