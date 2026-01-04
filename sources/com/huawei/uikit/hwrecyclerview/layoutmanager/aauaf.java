package com.huawei.uikit.hwrecyclerview.layoutmanager;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.animations.drawable.HwFloatingBubbleRadialDrawable;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
class aauaf {

    /* renamed from: a */
    private static final String f43319a = "HwFloatingBubblesCalculationUtils";

    /* renamed from: b */
    private static final float f43320b = 2.0f;

    /* renamed from: c */
    private static final float f43321c = 0.5f;

    /* renamed from: d */
    private static final float f43322d = 0.2f;

    /* renamed from: e */
    private static final int f43323e = 20;

    /* renamed from: f */
    private static final int f43324f = 1;

    /* renamed from: g */
    private static final int f43325g = -1;

    /* renamed from: h */
    private static final int f43326h = 1;

    /* renamed from: i */
    private static final float f43327i = 0.7f;

    /* renamed from: j */
    private static final float f43328j = 0.5f;

    /* renamed from: k */
    private static final int f43329k = 2;

    /* renamed from: l */
    private static final int f43330l = 50;

    /* renamed from: m */
    private static final float f43331m = 1.286f;

    /* renamed from: n */
    private static final float f43332n = -0.286f;

    /* renamed from: o */
    private static final int f43333o = 0;

    /* renamed from: p */
    private static final int f43334p = 1;

    private aauaf() {
    }

    /* renamed from: a */
    public static List<bzrwd> m54839a(int i10, int i11, int i12, int i13, int i14) {
        if (i14 + i13 >= i11) {
            if (i13 > i11) {
                Log.w(f43319a, "calculateViewLocations: the diameter is invalid");
                i13 = i11;
                i14 = 0;
            } else {
                i14 = i11 - i13;
                Log.w(f43319a, "calculateViewLocations: the margin is invalid");
            }
        }
        List<bzrwd> listM54838a = m54838a(i10, i11, i13, i14);
        int iM54851c = listM54838a.size() > 0 ? listM54838a.get(0).m54851c() - listM54838a.get(0).m54848a() : 0;
        int i15 = Integer.MIN_VALUE;
        for (int i16 = 0; i16 < listM54838a.size(); i16++) {
            bzrwd bzrwdVar = listM54838a.get(i16);
            int iM54851c2 = bzrwdVar.m54851c() - iM54851c;
            i15 = (i15 == Integer.MIN_VALUE || iM54851c2 - i15 >= 50) ? iM54851c2 : i15 + 50;
            bzrwdVar.m54849a(i15);
        }
        return listM54838a;
    }

    /* renamed from: a */
    private static List<bzrwd> m54838a(int i10, int i11, int i12, int i13) {
        int i14;
        int iRandom;
        ArrayList arrayList = new ArrayList();
        int i15 = i12 / 2;
        arrayList.add(new bzrwd((int) ((Math.random() * (i11 - (i15 * 2))) + i15), i15, i15));
        int i16 = (int) ((i12 + i13) * 0.8f);
        ArrayList arrayList2 = new ArrayList();
        int i17 = 1;
        while (true) {
            while (i17 <= i10) {
                int i18 = i17 - 1;
                int iM54851c = ((bzrwd) arrayList.get(i18)).m54851c();
                iRandom = ((int) (Math.random() * (i15 + i13))) + iM54851c + i14;
                arrayList2.clear();
                arrayList2.add(new int[]{i15, i11 - i15});
                int iM54851c2 = iRandom - iM54851c;
                while (i18 >= 0 && iM54851c2 < i16) {
                    bzrwd bzrwdVar = (bzrwd) arrayList.get(i18);
                    int iSqrt = (int) Math.sqrt(Math.pow(i16, 2.0d) - Math.pow(iM54851c2, 2.0d));
                    m54844a(arrayList2, bzrwdVar.m54850b() + iSqrt, bzrwdVar.m54850b() - iSqrt);
                    i18--;
                    if (i18 >= 0) {
                        iM54851c2 = iRandom - ((bzrwd) arrayList.get(i18)).m54851c();
                    }
                }
                i14 = arrayList2.size() == 0 ? i14 + i13 : 0;
            }
            return arrayList;
            arrayList.add(i17, new bzrwd(m54837a(arrayList2), iRandom, i15));
            i17++;
        }
    }

    /* renamed from: a */
    private static int m54837a(List<int[]> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int[] iArr = list.get(i11);
            i10 += iArr[1] - iArr[0];
        }
        int iNextInt = new SecureRandom().nextInt(1) * i10;
        for (int i12 = 0; i12 < list.size(); i12++) {
            int[] iArr2 = list.get(i12);
            int i13 = iArr2[1];
            int i14 = iArr2[0];
            int i15 = i13 - i14;
            if (iNextInt <= i15) {
                return i14 + iNextInt;
            }
            iNextInt -= i15;
        }
        return iNextInt;
    }

    /* renamed from: a */
    private static void m54844a(List<int[]> list, int i10, int i11) {
        int i12;
        int i13 = 0;
        boolean z10 = true;
        while (i13 < list.size()) {
            int[] iArr = list.get(i13);
            if (z10) {
                int i14 = iArr[0];
                if (i11 >= i14) {
                    if (i11 <= i14 || i11 >= iArr[1]) {
                        i13++;
                    } else {
                        list.set(i13, new int[]{i14, i11});
                        i13++;
                        list.add(i13, new int[]{i11, iArr[1]});
                    }
                }
                z10 = false;
            } else {
                int i15 = iArr[0];
                if (i10 < i15) {
                    i13++;
                } else {
                    if (i10 > i15 && i10 < (i12 = iArr[1])) {
                        list.set(i13, new int[]{i10, i12});
                        return;
                    }
                    list.remove(i13);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m54842a(RecyclerView.AbstractC0846p abstractC0846p, View view, float f10, HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams) {
        float translationY = view.getTranslationY() + (view.getHeight() * 0.5f) + view.getTop();
        if (Float.compare(translationY, abstractC0846p.getHeight()) < 0 && Float.compare(translationY, 0.0f) > 0) {
            float fM54835a = m54835a(hwFloatingBubblesAnimatorParams, view, Math.abs(translationY - f10) / f10);
            view.setScaleY(fM54835a);
            view.setScaleX(fM54835a);
        } else {
            view.setScaleY(0.0f);
            view.setScaleX(0.0f);
        }
        m54841a(view, abstractC0846p.getWidth());
    }

    /* renamed from: a */
    public static void m54841a(View view, int i10) {
        float bgAlphaScale;
        Drawable background = view.getBackground();
        if (background instanceof HwFloatingBubbleRadialDrawable) {
            HwFloatingBubbleRadialDrawable hwFloatingBubbleRadialDrawable = (HwFloatingBubbleRadialDrawable) background;
            bgAlphaScale = hwFloatingBubbleRadialDrawable.getBgAlphaScale();
            hwFloatingBubbleRadialDrawable.setParams(i10, view.getLeft(), view.getTop(), view.getScaleX());
        } else {
            bgAlphaScale = 1.0f;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt != null) {
                    float f10 = (f43331m * bgAlphaScale) + f43332n;
                    if (f10 < 0.0f) {
                        f10 = 0.0f;
                    }
                    childAt.setAlpha(f10);
                }
            }
        }
    }

    /* renamed from: a */
    private static float m54834a(float f10, float f11, float f12) {
        if (Float.compare(f11, 0.0f) == 0 || Float.compare(f12, 0.0f) == 0) {
            return f10;
        }
        if (Float.compare(f11, 1.0f) == 1) {
            return 0.3f;
        }
        return ((0.3f - f10) * f11) + f10;
    }

    /* renamed from: a */
    public static float m54833a(float f10) {
        if (Float.compare(f10, 0.5f) == -1) {
            return 1.0f;
        }
        if (Float.compare(f10, 1.0f) == 1) {
            return 0.7f;
        }
        return (f10 * (-0.6f)) + 1.3f;
    }

    /* renamed from: a */
    public static int[][] m54847a(boolean z10, int i10, RecyclerView.AbstractC0846p abstractC0846p, HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams) {
        int childCount = abstractC0846p.getChildCount();
        double[] dArr = new double[childCount];
        double[] dArr2 = new double[childCount];
        for (int i11 = 0; i11 < childCount; i11++) {
            dArr[i11] = 0.0d;
            dArr2[i11] = i10;
        }
        m54845a(z10, abstractC0846p, hwFloatingBubblesAnimatorParams, dArr, dArr2);
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, childCount);
        for (int i12 = 0; i12 < childCount; i12++) {
            iArr[0][i12] = (int) dArr[i12];
            iArr[1][i12] = (int) dArr2[i12];
        }
        return iArr;
    }

    /* renamed from: a */
    private static void m54845a(boolean z10, RecyclerView.AbstractC0846p abstractC0846p, HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams, double[] dArr, double[] dArr2) {
        int childCount = abstractC0846p.getChildCount();
        int height = abstractC0846p.getHeight();
        if (height == 0) {
            return;
        }
        float f10 = height / 2.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = abstractC0846p.getChildAt(i10);
            if (childAt != null) {
                double d10 = f10;
                m54840a(i10, childAt, m54835a(hwFloatingBubblesAnimatorParams, childAt, (float) (Math.abs((((childAt.getTop() + (childAt.getHeight() / 2.0f)) + (z10 ? 0.0f : childAt.getTranslationY())) + dArr2[i10]) - d10) / d10)), abstractC0846p, dArr);
                m54843a(abstractC0846p, hwFloatingBubblesAnimatorParams, dArr, dArr2, i10);
            }
        }
    }

    /* renamed from: a */
    private static void m54843a(RecyclerView.AbstractC0846p abstractC0846p, HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams, double[] dArr, double[] dArr2, int i10) {
        float f10;
        float f11;
        char c10;
        View view;
        int i11;
        float f12;
        float f13;
        int i12;
        RecyclerView.AbstractC0846p abstractC0846p2 = abstractC0846p;
        HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams2 = hwFloatingBubblesAnimatorParams;
        int i13 = i10;
        int childCount = abstractC0846p.getChildCount();
        View childAt = abstractC0846p2.getChildAt(i13);
        char c11 = 0;
        float height = childAt.getHeight() / 2.0f;
        float height2 = abstractC0846p.getHeight() / 2.0f;
        float left = childAt.getLeft() + height + childAt.getTranslationX();
        float translationY = childAt.getTranslationY() + childAt.getTop() + height;
        int i14 = i13 + 1;
        while (i14 < childCount) {
            View childAt2 = abstractC0846p2.getChildAt(i14);
            if (childAt2 == null) {
                f11 = translationY;
                i12 = i14;
                i11 = childCount;
                view = childAt;
                c10 = c11;
                f10 = height;
                f12 = height2;
                f13 = left;
            } else {
                double d10 = translationY + dArr2[i13];
                f10 = height;
                double d11 = height2;
                f11 = translationY;
                float fM54835a = m54835a(hwFloatingBubblesAnimatorParams2, childAt, (float) (Math.abs(d10 - d11) / d11));
                c10 = 0;
                int i15 = childCount;
                view = childAt;
                double translationY2 = childAt2.getTranslationY() + childAt2.getTop() + r4 + dArr2[i14];
                i11 = i15;
                double translationX = childAt2.getTranslationX() + childAt2.getLeft() + r4 + dArr[i14];
                float fM54835a2 = m54835a(hwFloatingBubblesAnimatorParams2, childAt2, (float) (Math.abs(translationY2 - d11) / d11));
                double d12 = left + dArr[i13];
                f12 = height2;
                f13 = left;
                double d13 = d12 - translationX;
                i12 = i14;
                double d14 = d10 - translationY2;
                double dPow = Math.pow(d13, 2.0d) + Math.pow(d14, 2.0d);
                double d15 = fM54835a * f10;
                double height3 = fM54835a2 * (childAt2.getHeight() / 2.0f);
                double d16 = d15 + height3;
                float fM54836a = m54836a(hwFloatingBubblesAnimatorParams2, view, childAt2);
                if (Double.compare(dPow, Math.pow((1.0f - fM54836a) * d16, 2.0d)) == -1) {
                    double dSqrt = Math.sqrt(dPow);
                    if (Double.compare(dSqrt, 0.0d) == 0 || Double.compare(d16, 0.0d) == 0) {
                        return;
                    }
                    double d17 = d16 - dSqrt;
                    double d18 = fM54836a;
                    double d19 = ((d17 * height3) - ((height3 * d18) * d16)) / d16;
                    double d20 = (d19 * d13) / dSqrt;
                    double d21 = (d19 * d14) / dSqrt;
                    double dM54832a = m54832a(abstractC0846p, d12, d15, d20);
                    double dAbs = Double.compare(d21, 0.0d) == 1 ? d21 + Math.abs(dM54832a) : d21 - Math.abs(dM54832a);
                    double d22 = -(((d17 * d15) - ((d15 * d18) * d16)) / d16);
                    double d23 = (d13 * d22) / dSqrt;
                    double d24 = (d22 * d14) / dSqrt;
                    double dM54832a2 = m54832a(abstractC0846p, translationX, height3, d23);
                    double dAbs2 = Double.compare(d24, 0.0d) == 1 ? d24 + Math.abs(dM54832a2) : d24 - Math.abs(dM54832a2);
                    double dM54831a = m54831a(view, childAt2, dAbs, dAbs2);
                    dArr[i10] = dArr[i10] + d20 + dM54832a;
                    dArr2[i10] = dArr2[i10] + dAbs + dM54831a;
                    dArr[i12] = dArr[i12] + d23 + dM54832a2;
                    dArr2[i12] = dArr2[i12] + dAbs2 + dM54831a;
                } else {
                    continue;
                }
            }
            i14 = i12 + 1;
            abstractC0846p2 = abstractC0846p;
            hwFloatingBubblesAnimatorParams2 = hwFloatingBubblesAnimatorParams;
            i13 = i10;
            c11 = c10;
            height = f10;
            childAt = view;
            childCount = i11;
            translationY = f11;
            height2 = f12;
            left = f13;
        }
    }

    /* renamed from: a */
    private static double m54831a(View view, View view2, double d10, double d11) {
        double d12 = view.isSelected() ? 0.0d + (-d10) : 0.0d;
        return view2.isSelected() ? d12 + (-d11) : d12;
    }

    /* renamed from: a */
    private static float m54836a(HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams, View view, View view2) {
        float maxCoverFactor = hwFloatingBubblesAnimatorParams.getMaxCoverFactor();
        if (view.isSelected() || view2.isSelected()) {
            return 0.0f;
        }
        return maxCoverFactor;
    }

    /* renamed from: a */
    private static double m54832a(RecyclerView.AbstractC0846p abstractC0846p, double d10, double d11, double d12) {
        double d13 = d10 - d11;
        if (m54846a(abstractC0846p.getPaddingLeft(), d13 + d12)) {
            return (abstractC0846p.getPaddingLeft() - d13) - d12;
        }
        double d14 = d10 + d11;
        if (m54846a(d14 + d12, abstractC0846p.getWidth() - abstractC0846p.getPaddingRight())) {
            return ((abstractC0846p.getWidth() - abstractC0846p.getPaddingRight()) - d14) - d12;
        }
        return 0.0d;
    }

    /* renamed from: a */
    private static void m54840a(int i10, View view, float f10, RecyclerView.AbstractC0846p abstractC0846p, double[] dArr) {
        int width = view.getWidth() >> 1;
        int left = view.getLeft() + width;
        int i11 = (int) (width * f10);
        double d10 = left - i11;
        if (m54846a(abstractC0846p.getPaddingLeft(), d10)) {
            dArr[i10] = (dArr[i10] + abstractC0846p.getPaddingLeft()) - d10;
            return;
        }
        double d11 = left + i11;
        if (m54846a(d11, abstractC0846p.getWidth() - abstractC0846p.getPaddingRight())) {
            dArr[i10] = ((dArr[i10] + abstractC0846p.getWidth()) - abstractC0846p.getPaddingRight()) - d11;
        }
    }

    /* renamed from: a */
    private static boolean m54846a(double d10, double d11) {
        return Double.compare(d10, d11) == 1;
    }

    /* renamed from: a */
    public static float m54835a(HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams, View view, float f10) {
        float fM54834a = m54834a(hwFloatingBubblesAnimatorParams.getMaxScale(), f10, hwFloatingBubblesAnimatorParams.getVisibleCriticalOffsetY() * (view instanceof HwFloatingBubbleLayout ? ((HwFloatingBubbleLayout) view).getRandomFactor() : 1.0f));
        return view.isSelected() ? fM54834a * hwFloatingBubblesAnimatorParams.getSelectedScaleRelativeOther() : fM54834a;
    }
}
