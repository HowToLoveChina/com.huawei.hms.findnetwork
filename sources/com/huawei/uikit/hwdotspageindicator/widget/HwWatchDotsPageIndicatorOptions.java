package com.huawei.uikit.hwdotspageindicator.widget;

import android.graphics.PointF;
import java.lang.reflect.Array;
import java.math.BigDecimal;

/* loaded from: classes7.dex */
public class HwWatchDotsPageIndicatorOptions {

    /* renamed from: A */
    private static final int f42511A = 0;

    /* renamed from: B */
    private static final int f42512B = 1;

    /* renamed from: C */
    private static final int f42513C = 1;

    /* renamed from: D */
    private static final int f42514D = 2;

    /* renamed from: E */
    private static final int f42515E = 2;

    /* renamed from: F */
    private static final int f42516F = 0;

    /* renamed from: G */
    private static final int f42517G = 1;

    /* renamed from: H */
    private static final int f42518H = 2;

    /* renamed from: I */
    private static final int f42519I = 3;

    /* renamed from: J */
    private static final int f42520J = 3;

    /* renamed from: K */
    private static final int f42521K = 0;

    /* renamed from: L */
    private static final int f42522L = 1;

    /* renamed from: M */
    private static final int f42523M = -1;

    /* renamed from: N */
    private static final int f42524N = 4;

    /* renamed from: O */
    private static final float f42525O = 0.0f;

    /* renamed from: P */
    private static final float f42526P = 180.0f;

    /* renamed from: Q */
    private static final float f42527Q = 4.0f;

    /* renamed from: R */
    private static final float f42528R = 2.0f;

    /* renamed from: S */
    private static final float f42529S = 5.0f;

    /* renamed from: T */
    private static final float f42530T = 8.0f;

    /* renamed from: U */
    private static final float f42531U = 4.0f;

    /* renamed from: V */
    private static final float f42532V = 10.0f;

    /* renamed from: a */
    private float[][] f42533a;

    /* renamed from: b */
    private float[][] f42534b;

    /* renamed from: c */
    private float[][] f42535c;

    /* renamed from: d */
    private float[][] f42536d;

    /* renamed from: e */
    private int f42537e;

    /* renamed from: f */
    private int f42538f;

    /* renamed from: g */
    private int f42539g;

    /* renamed from: h */
    private int f42540h = -1;

    /* renamed from: i */
    private int f42541i;

    /* renamed from: j */
    private int f42542j;

    /* renamed from: k */
    private int f42543k;

    /* renamed from: l */
    private float f42544l;

    /* renamed from: m */
    private float f42545m;

    /* renamed from: n */
    private float f42546n;

    /* renamed from: o */
    private float[] f42547o;

    /* renamed from: p */
    private float f42548p;

    /* renamed from: q */
    private float f42549q;

    /* renamed from: r */
    private float f42550r;

    /* renamed from: s */
    private float f42551s;

    /* renamed from: t */
    private float f42552t;

    /* renamed from: u */
    private float f42553u;

    /* renamed from: v */
    private float f42554v;

    /* renamed from: w */
    private float f42555w;

    /* renamed from: x */
    private float f42556x;

    /* renamed from: y */
    private float f42557y;

    /* renamed from: z */
    private boolean f42558z;

    /* renamed from: a */
    private boolean m54497a(float[][] fArr, int i10) {
        return fArr == null || i10 < 0 || i10 >= fArr.length;
    }

    /* renamed from: b */
    private int m54498b(int i10) {
        return this.f42558z ? (this.f42537e - 1) - i10 : i10;
    }

    /* renamed from: c */
    private float m54499c(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42536d, iM54498b)) {
            return 0.0f;
        }
        return this.f42536d[iM54498b][2];
    }

    public HwWatchDotsPageIndicatorOptions deepCopy() {
        HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions = new HwWatchDotsPageIndicatorOptions();
        hwWatchDotsPageIndicatorOptions.setIndex(getIndex());
        hwWatchDotsPageIndicatorOptions.setFocusedDotsAngles(getFocusedDotsAngles());
        hwWatchDotsPageIndicatorOptions.setDotRadius(getDotRadius());
        hwWatchDotsPageIndicatorOptions.setScaleDotRadius(getScaleDotRadius());
        hwWatchDotsPageIndicatorOptions.setScaledIndex(getScaledIndex());
        hwWatchDotsPageIndicatorOptions.setIsRtl(isIsRtl());
        hwWatchDotsPageIndicatorOptions.setPageCount(getPageCount());
        hwWatchDotsPageIndicatorOptions.setFocusedDotWidth(getFocusedDotWidth());
        hwWatchDotsPageIndicatorOptions.setHotZoneColor(getHotZoneColor());
        hwWatchDotsPageIndicatorOptions.setDotAngles(getDotAngles());
        hwWatchDotsPageIndicatorOptions.setWatchDotSpacingAngle(getWatchDotSpacingAngle());
        hwWatchDotsPageIndicatorOptions.setNormalHotZoneStartAngle(getNormalHotZoneStartAngle());
        hwWatchDotsPageIndicatorOptions.setNormalHotZoneSweepAngle(getNormalHotZoneSweepAngle());
        hwWatchDotsPageIndicatorOptions.setFocusDotStartAngle(getFocusDotStartAngle());
        hwWatchDotsPageIndicatorOptions.setFocusDotSweepAngle(getFocusDotSweepAngle());
        hwWatchDotsPageIndicatorOptions.setFocusDotEndAngle(getFocusDotEndAngle());
        hwWatchDotsPageIndicatorOptions.setMarginScreen(getMarginScreen());
        hwWatchDotsPageIndicatorOptions.setWatchScaleDotSpacingAngle(getWatchScaleDotSpacingAngle());
        hwWatchDotsPageIndicatorOptions.setFocusedDotZoomInWidth(getFocusedDotZoomInWidth());
        hwWatchDotsPageIndicatorOptions.setScaleHotZoneStartAngle(getScaleHotZoneStartAngle());
        hwWatchDotsPageIndicatorOptions.setScaleHotZoneSweepAngle(getScaleHotZoneSweepAngle());
        hwWatchDotsPageIndicatorOptions.setDotNormalAngles(getDotNormalAngles());
        hwWatchDotsPageIndicatorOptions.setDotZoomInAngles(getDotZoomInAngles());
        hwWatchDotsPageIndicatorOptions.setFocusedDotsAngles(getFocusedDotsAngles());
        hwWatchDotsPageIndicatorOptions.setFocusZoomInAngles(getFocusZoomInAngles());
        hwWatchDotsPageIndicatorOptions.setZoomInHotZoneStartAngle(getZoomInHotZoneStartAngle());
        hwWatchDotsPageIndicatorOptions.setZoomInHotZoneSweepAngle(getZoomInHotZoneSweepAngle());
        return hwWatchDotsPageIndicatorOptions;
    }

    public float[] getCurrentDotAngle(int i10, boolean z10) {
        return z10 ? getNormalStatusDotsAngeles(i10) : getScaledStatusDotAngles(i10);
    }

    public float getCurrentNormalDotAngle(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42533a, iM54498b)) {
            return 0.0f;
        }
        return this.f42533a[iM54498b][this.f42558z ? (char) 1 : (char) 2];
    }

    public float getDotAngle(int i10, int i11) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42533a, iM54498b)) {
            return 0.0f;
        }
        if (i10 > i11) {
            return this.f42533a[iM54498b][this.f42558z ? (char) 1 : (char) 2];
        }
        if (i10 < i11) {
            return this.f42533a[iM54498b][this.f42558z ? (char) 2 : (char) 1];
        }
        return this.f42533a[iM54498b][0];
    }

    public float[] getDotAngles() {
        return this.f42547o;
    }

    public float[][] getDotNormalAngles() {
        return this.f42533a;
    }

    public float getDotRadius() {
        return this.f42544l;
    }

    public float getDotScaleCenter(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42535c, iM54498b)) {
            return 0.0f;
        }
        return this.f42535c[iM54498b][0];
    }

    public float getDotScaleEnd(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42535c, iM54498b)) {
            return 0.0f;
        }
        return this.f42535c[iM54498b][this.f42558z ? (char) 1 : (char) 2];
    }

    public float getDotScaleStart(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42535c, iM54498b)) {
            return 0.0f;
        }
        return this.f42535c[iM54498b][this.f42558z ? (char) 2 : (char) 1];
    }

    public float[][] getDotZoomInAngles() {
        return this.f42535c;
    }

    public float getDotZoomedAngles(int i10, int i11) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42535c, iM54498b)) {
            return 0.0f;
        }
        if (i10 > i11) {
            return this.f42535c[iM54498b][this.f42558z ? (char) 1 : (char) 2];
        }
        if (i10 < i11) {
            return this.f42535c[iM54498b][this.f42558z ? (char) 2 : (char) 1];
        }
        return this.f42535c[iM54498b][0];
    }

    public float getFocusCenterProper(boolean z10, int i10) {
        return z10 ? m54496a(i10) : m54499c(i10);
    }

    public float getFocusDotAngleAtFocusRight(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42533a, iM54498b)) {
            return 0.0f;
        }
        return this.f42533a[iM54498b][this.f42558z ? (char) 1 : (char) 2];
    }

    public float getFocusDotEndAngle() {
        return this.f42549q;
    }

    public float getFocusDotStartAngle() {
        return this.f42548p;
    }

    public float getFocusDotSweepAngle() {
        return this.f42550r;
    }

    public float getFocusEnd(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42534b, iM54498b)) {
            return 0.0f;
        }
        return this.f42534b[iM54498b][!this.f42558z ? 1 : 0];
    }

    public float getFocusEndProper(boolean z10, int i10) {
        return z10 ? getFocusEnd(i10) : getZoomInFocusEnd(i10);
    }

    public float getFocusStart(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42534b, iM54498b)) {
            return 0.0f;
        }
        return this.f42534b[iM54498b][this.f42558z ? 1 : 0];
    }

    public float getFocusStartProper(boolean z10, int i10) {
        return z10 ? getFocusStart(i10) : getZoomInFocusStart(i10);
    }

    public float[][] getFocusZoomInAngles() {
        return this.f42536d;
    }

    public int getFocusedDotWidth() {
        return this.f42541i;
    }

    public float getFocusedDotZoomInWidth() {
        return this.f42557y;
    }

    public float[][] getFocusedDotsAngles() {
        return this.f42534b;
    }

    public int getHotZoneColor() {
        return this.f42539g;
    }

    public int getIndex() {
        return this.f42538f;
    }

    public float getMarginScreen() {
        return this.f42546n;
    }

    public float getNormalHotZoneStartAngle() {
        return this.f42555w;
    }

    public float getNormalHotZoneSweepAngle() {
        return this.f42556x;
    }

    public float[] getNormalStatusDotsAngeles(int i10) {
        float[] fArr = new float[this.f42537e];
        for (int i11 = 0; i11 < this.f42537e; i11++) {
            fArr[i11] = getDotAngle(i11, i10);
        }
        return fArr;
    }

    public int getPageCount() {
        return this.f42537e;
    }

    public PointF getPointByAngleInArc(float f10, float f11, PointF pointF) {
        PointF pointF2 = new PointF();
        double d10 = f10 * 3.141592653589793d;
        double d11 = f11;
        pointF2.x = pointF.x + new BigDecimal(Math.cos(new BigDecimal(d10).divide(new BigDecimal(180.0d), 4, 4).floatValue())).multiply(new BigDecimal(d11)).floatValue();
        pointF2.y = pointF.y + new BigDecimal(Math.sin(new BigDecimal(d10).divide(new BigDecimal(180.0d), 4, 4).floatValue())).multiply(new BigDecimal(d11)).floatValue();
        return pointF2;
    }

    public float getScaleDotRadius() {
        return this.f42545m;
    }

    public float getScaleHotZoneStartAngle() {
        return this.f42551s;
    }

    public float getScaleHotZoneSweepAngle() {
        return this.f42552t;
    }

    public int getScaledIndex() {
        return this.f42540h;
    }

    public float[] getScaledStatusDotAngles(int i10) {
        float[] fArr = new float[this.f42537e];
        for (int i11 = 0; i11 < this.f42537e; i11++) {
            fArr[i11] = getDotZoomedAngles(i11, i10);
        }
        return fArr;
    }

    public int getWatchDotSpacingAngle() {
        return this.f42542j;
    }

    public int getWatchScaleDotSpacingAngle() {
        return this.f42543k;
    }

    public float getZoomInFocusDotAngleAtRight(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42535c, iM54498b)) {
            return 0.0f;
        }
        return this.f42535c[iM54498b][this.f42558z ? (char) 1 : (char) 2];
    }

    public float getZoomInFocusEnd(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42536d, iM54498b)) {
            return 0.0f;
        }
        return this.f42536d[iM54498b][!this.f42558z ? 1 : 0];
    }

    public float getZoomInFocusStart(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42536d, iM54498b)) {
            return 0.0f;
        }
        return this.f42536d[iM54498b][this.f42558z ? 1 : 0];
    }

    public float getZoomInHotZoneStartAngle() {
        return this.f42553u;
    }

    public float getZoomInHotZoneSweepAngle() {
        return this.f42554v;
    }

    public void initCommonPositionForWatch(float f10) {
        int i10 = this.f42537e;
        if (i10 == 0) {
            return;
        }
        Class cls = Float.TYPE;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) cls, i10, 3);
        this.f42533a = fArr;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) cls, i10, 3);
        this.f42534b = fArr2;
        float[] fArr3 = fArr2[0];
        fArr3[0] = f10;
        fArr3[1] = f10 - 4.0f;
        float f11 = f10 - 2.0f;
        fArr3[2] = f11;
        float[] fArr4 = fArr[0];
        fArr4[1] = f10;
        fArr4[0] = f11;
        fArr4[2] = f11;
        if (i10 < 2) {
            return;
        }
        int i11 = 1;
        while (true) {
            int i12 = this.f42537e;
            if (i11 >= i12) {
                return;
            }
            float[] fArr5 = this.f42534b[i11];
            float f12 = i11 * 5.0f;
            float f13 = f10 - f12;
            fArr5[0] = f13;
            fArr5[1] = f13 - 4.0f;
            float f14 = f13 - 2.0f;
            fArr5[2] = f14;
            float[] fArr6 = this.f42533a[i11];
            fArr6[1] = f13;
            fArr6[0] = f14;
            fArr6[2] = f10 - (f12 + 4.0f);
            if (i11 == i12 - 1) {
                fArr6[1] = f14;
            }
            i11++;
        }
    }

    public void initScalePositionForWatch(int i10) {
        int i11 = this.f42537e;
        if (i11 == 0) {
            return;
        }
        Class cls = Float.TYPE;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) cls, i11, 3);
        this.f42535c = fArr;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) cls, i11, 3);
        this.f42536d = fArr2;
        float[] fArr3 = fArr2[0];
        float f10 = i10;
        fArr3[0] = f10;
        fArr3[1] = f10 - 8.0f;
        float f11 = f10 - 4.0f;
        fArr3[2] = f11;
        float[] fArr4 = fArr[0];
        fArr4[1] = f10;
        fArr4[0] = f11;
        fArr4[2] = f11;
        if (i11 < 2) {
            return;
        }
        int i12 = 1;
        while (true) {
            int i13 = this.f42537e;
            if (i12 >= i13) {
                return;
            }
            float[] fArr5 = this.f42536d[i12];
            float f12 = i12 * 10.0f;
            float f13 = f10 - f12;
            fArr5[0] = f13;
            fArr5[1] = f13 - 8.0f;
            float f14 = f13 - 4.0f;
            fArr5[2] = f14;
            float[] fArr6 = this.f42535c[i12];
            fArr6[1] = f13;
            fArr6[0] = f14;
            fArr6[2] = f10 - (f12 + 8.0f);
            if (i12 == i13 - 1) {
                fArr6[1] = f14;
            }
            i12++;
        }
    }

    public boolean isIsRtl() {
        return this.f42558z;
    }

    public void setDotAngles(float[] fArr) {
        this.f42547o = fArr;
    }

    public void setDotCenterAngles(int i10, float f10) {
        float[] fArr = this.f42547o;
        if (fArr == null || i10 < 0 || i10 >= fArr.length) {
            return;
        }
        fArr[i10] = f10;
    }

    public void setDotNormalAngles(float[][] fArr) {
        this.f42533a = fArr;
    }

    public void setDotRadius(float f10) {
        this.f42544l = f10;
    }

    public void setDotZoomInAngles(float[][] fArr) {
        this.f42535c = fArr;
    }

    public void setFocusDotEndAngle(float f10) {
        this.f42549q = f10;
    }

    public void setFocusDotStartAngle(float f10) {
        this.f42548p = f10;
    }

    public void setFocusDotSweepAngle(float f10) {
        this.f42550r = f10;
    }

    public void setFocusZoomInAngles(float[][] fArr) {
        this.f42536d = fArr;
    }

    public void setFocusedDotWidth(int i10) {
        this.f42541i = i10;
    }

    public void setFocusedDotZoomInWidth(float f10) {
        this.f42557y = f10;
    }

    public void setFocusedDotsAngles(float[][] fArr) {
        this.f42534b = fArr;
    }

    public void setHotZoneColor(int i10) {
        this.f42539g = i10;
    }

    public void setIndex(int i10) {
        this.f42538f = i10;
    }

    public void setIsRtl(boolean z10) {
        this.f42558z = z10;
    }

    public void setMarginScreen(float f10) {
        this.f42546n = f10;
    }

    public void setNormalHotZoneStartAngle(float f10) {
        this.f42555w = f10;
    }

    public void setNormalHotZoneSweepAngle(float f10) {
        this.f42556x = f10;
    }

    public void setPageCount(int i10) {
        if (i10 > 0) {
            this.f42537e = i10;
        }
    }

    public void setScaleDotRadius(float f10) {
        this.f42545m = f10;
    }

    public void setScaleHotZoneStartAngle(float f10) {
        this.f42551s = f10;
    }

    public void setScaleHotZoneSweepAngle(float f10) {
        this.f42552t = f10;
    }

    public void setScaledIndex(int i10) {
        this.f42540h = i10;
    }

    public void setWatchDotSpacingAngle(int i10) {
        this.f42542j = i10;
    }

    public void setWatchScaleDotSpacingAngle(int i10) {
        this.f42543k = i10;
    }

    public void setZoomInHotZoneStartAngle(float f10) {
        this.f42553u = f10;
    }

    public void setZoomInHotZoneSweepAngle(float f10) {
        this.f42554v = f10;
    }

    /* renamed from: a */
    private float m54496a(int i10) {
        int iM54498b = m54498b(i10);
        if (m54497a(this.f42534b, iM54498b)) {
            return 0.0f;
        }
        return this.f42534b[iM54498b][2];
    }

    public void setDotNormalAngles(int i10, float f10) {
        float[] fArr = this.f42547o;
        if (fArr == null || i10 < 0 || i10 >= fArr.length) {
            return;
        }
        fArr[i10] = f10;
    }
}
