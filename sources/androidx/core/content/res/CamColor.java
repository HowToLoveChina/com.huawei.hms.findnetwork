package androidx.core.content.res;

import p723w.C13503b;

/* loaded from: classes.dex */
class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;

    /* renamed from: mJ */
    private final float f3420mJ;
    private final float mJstar;

    /* renamed from: mM */
    private final float f3421mM;

    /* renamed from: mQ */
    private final float f3422mQ;

    /* renamed from: mS */
    private final float f3423mS;

    public CamColor(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.mHue = f10;
        this.mChroma = f11;
        this.f3420mJ = f12;
        this.f3422mQ = f13;
        this.f3421mM = f14;
        this.f3423mS = f15;
        this.mJstar = f16;
        this.mAstar = f17;
        this.mBstar = f18;
    }

    private static CamColor findCamByJ(float f10, float f11, float f12) {
        float f13 = 100.0f;
        float f14 = 1000.0f;
        float f15 = 0.0f;
        CamColor camColor = null;
        float f16 = 1000.0f;
        while (Math.abs(f15 - f13) > 0.01f) {
            float f17 = ((f13 - f15) / 2.0f) + f15;
            int iViewedInSrgb = fromJch(f17, f11, f10).viewedInSrgb();
            float fLStarFromInt = CamUtils.lStarFromInt(iViewedInSrgb);
            float fAbs = Math.abs(f12 - fLStarFromInt);
            if (fAbs < 0.2f) {
                CamColor camColorFromColor = fromColor(iViewedInSrgb);
                float fDistance = camColorFromColor.distance(fromJch(camColorFromColor.getJ(), camColorFromColor.getChroma(), f10));
                if (fDistance <= 1.0f) {
                    camColor = camColorFromColor;
                    f14 = fAbs;
                    f16 = fDistance;
                }
            }
            if (f14 == 0.0f && f16 == 0.0f) {
                break;
            }
            if (fLStarFromInt < f12) {
                f15 = f17;
            } else {
                f13 = f17;
            }
        }
        return camColor;
    }

    public static CamColor fromColor(int i10) {
        return fromColorInViewingConditions(i10, ViewingConditions.DEFAULT);
    }

    public static CamColor fromColorInViewingConditions(int i10, ViewingConditions viewingConditions) {
        float[] fArrXyzFromInt = CamUtils.xyzFromInt(i10);
        float[][] fArr = CamUtils.XYZ_TO_CAM16RGB;
        float f10 = fArrXyzFromInt[0];
        float[] fArr2 = fArr[0];
        float f11 = fArr2[0] * f10;
        float f12 = fArrXyzFromInt[1];
        float f13 = f11 + (fArr2[1] * f12);
        float f14 = fArrXyzFromInt[2];
        float f15 = f13 + (fArr2[2] * f14);
        float[] fArr3 = fArr[1];
        float f16 = (fArr3[0] * f10) + (fArr3[1] * f12) + (fArr3[2] * f14);
        float[] fArr4 = fArr[2];
        float f17 = (f10 * fArr4[0]) + (f12 * fArr4[1]) + (f14 * fArr4[2]);
        float f18 = viewingConditions.getRgbD()[0] * f15;
        float f19 = viewingConditions.getRgbD()[1] * f16;
        float f20 = viewingConditions.getRgbD()[2] * f17;
        float fPow = (float) Math.pow((viewingConditions.getFl() * Math.abs(f18)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f19)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f20)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f18) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f19) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f20) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f21 = ((float) (((fSignum * 11.0d) + (fSignum2 * (-12.0d))) + d10)) / 11.0f;
        float f22 = ((float) ((fSignum + fSignum2) - (d10 * 2.0d))) / 9.0f;
        float f23 = fSignum2 * 20.0f;
        float f24 = (((fSignum * 20.0f) + f23) + (21.0f * fSignum3)) / 20.0f;
        float f25 = (((fSignum * 40.0f) + f23) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f22, f21)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f26 = fAtan2;
        float f27 = (3.1415927f * f26) / 180.0f;
        float fPow4 = ((float) Math.pow((f25 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float flRoot = viewingConditions.getFlRoot() * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (viewingConditions.getAw() + 4.0f);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f26) < 20.14d ? 360.0f + f26 : f26) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f21 * f21) + (f22 * f22)))) / (f24 + 0.305f), 0.9d)) * ((float) Math.sqrt(fPow4 / 100.0d));
        float flRoot2 = fPow5 * viewingConditions.getFlRoot();
        float fSqrt = ((float) Math.sqrt((r3 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f28 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * flRoot2) + 1.0f)) * 43.85965f;
        double d11 = f27;
        return new CamColor(f26, fPow5, fPow4, flRoot, flRoot2, fSqrt, f28, fLog * ((float) Math.cos(d11)), fLog * ((float) Math.sin(d11)));
    }

    private static CamColor fromJch(float f10, float f11, float f12) {
        return fromJchInFrame(f10, f11, f12, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f10, float f11, float f12, ViewingConditions viewingConditions) {
        float c10 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(f10 / 100.0d)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = f11 * viewingConditions.getFlRoot();
        float fSqrt = ((float) Math.sqrt(((f11 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f13 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float fLog = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f12) / 180.0f;
        return new CamColor(f12, f11, f10, c10, flRoot, fSqrt, f13, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    public static int toColor(float f10, float f11, float f12) {
        return toColor(f10, f11, f12, ViewingConditions.DEFAULT);
    }

    public float distance(CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    public float getAStar() {
        return this.mAstar;
    }

    public float getBStar() {
        return this.mBstar;
    }

    public float getChroma() {
        return this.mChroma;
    }

    public float getHue() {
        return this.mHue;
    }

    public float getJ() {
        return this.f3420mJ;
    }

    public float getJStar() {
        return this.mJstar;
    }

    public float getM() {
        return this.f3421mM;
    }

    public float getQ() {
        return this.f3422mQ;
    }

    public float getS() {
        return this.f3423mS;
    }

    public int viewed(ViewingConditions viewingConditions) {
        float fPow = (float) Math.pow(((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(getJ() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw2 = viewingConditions.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()));
        float nc2 = fCos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw2 / viewingConditions.getNbb();
        float fSin = (float) Math.sin(hue);
        float fCos2 = (float) Math.cos(hue);
        float f10 = (((0.305f + nbb) * 23.0f) * fPow) / (((nc2 * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f11 = fCos2 * f10;
        float f12 = f10 * fSin;
        float f13 = nbb * 460.0f;
        float f14 = (((451.0f * f11) + f13) + (288.0f * f12)) / 1403.0f;
        float f15 = ((f13 - (891.0f * f11)) - (261.0f * f12)) / 1403.0f;
        float fSignum = Math.signum(f14) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f14) * 27.13d) / (400.0d - Math.abs(f14))), 2.380952380952381d));
        float fSignum2 = Math.signum(f15) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f13 - (f11 * 220.0f)) - (f12 * 6300.0f)) / 1403.0f) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r8) * 27.13d) / (400.0d - Math.abs(r8))), 2.380952380952381d));
        float f16 = fSignum / viewingConditions.getRgbD()[0];
        float f17 = fSignum2 / viewingConditions.getRgbD()[1];
        float f18 = fSignum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f19 = (fArr2[0] * f16) + (fArr2[1] * f17) + (fArr2[2] * f18);
        float[] fArr3 = fArr[1];
        float f20 = (fArr3[0] * f16) + (fArr3[1] * f17) + (fArr3[2] * f18);
        float[] fArr4 = fArr[2];
        return C13503b.m81218b(f19, f20, (f16 * fArr4[0]) + (f17 * fArr4[1]) + (f18 * fArr4[2]));
    }

    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public static int toColor(float f10, float f11, float f12, ViewingConditions viewingConditions) {
        if (f11 < 1.0d || Math.round(f12) <= 0.0d || Math.round(f12) >= 100.0d) {
            return CamUtils.intFromLStar(f12);
        }
        float fMin = f10 < 0.0f ? 0.0f : Math.min(360.0f, f10);
        CamColor camColor = null;
        boolean z10 = true;
        float f13 = 0.0f;
        float f14 = f11;
        while (Math.abs(f13 - f11) >= 0.4f) {
            CamColor camColorFindCamByJ = findCamByJ(fMin, f14, f12);
            if (!z10) {
                if (camColorFindCamByJ == null) {
                    f11 = f14;
                } else {
                    f13 = f14;
                    camColor = camColorFindCamByJ;
                }
                f14 = ((f11 - f13) / 2.0f) + f13;
            } else {
                if (camColorFindCamByJ != null) {
                    return camColorFindCamByJ.viewed(viewingConditions);
                }
                f14 = ((f11 - f13) / 2.0f) + f13;
                z10 = false;
            }
        }
        return camColor == null ? CamUtils.intFromLStar(f12) : camColor.viewed(viewingConditions);
    }
}
