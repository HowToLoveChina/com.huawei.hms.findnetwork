package p784xq;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

/* renamed from: xq.b */
/* loaded from: classes8.dex */
public final class C13846b {
    /* renamed from: a */
    public static ArrayList m83115a(ArrayList arrayList) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList.size(), ((float[]) arrayList.get(0)).length);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            System.arraycopy(arrayList.get(i10), 0, fArr[i10], 0, ((float[]) arrayList.get(i10)).length);
        }
        if (fArr.length == 0) {
            return arrayList;
        }
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 256, fArr[0].length);
        double dDoubleValue = new BigDecimal(fArr.length / 256).setScale(2, 4).doubleValue();
        int i11 = 0;
        for (int i12 = 0; i11 < fArr[i12].length; i12 = 0) {
            int iRound = i12;
            int i13 = iRound;
            while (true) {
                if (iRound >= fArr.length) {
                    break;
                }
                if (i13 == 255) {
                    fArr2[i13][i11] = fArr[fArr.length - 1][i11];
                    break;
                }
                if (iRound == 0) {
                    fArr2[i13][i11] = fArr[iRound][i11];
                    i13++;
                    iRound += (int) Math.round(dDoubleValue);
                } else {
                    double dRound = (((int) Math.round(dDoubleValue)) * dDoubleValue) / 2.0d;
                    if (Math.abs(dRound) >= 1.0E-6d) {
                        fArr2[i13][i11] = (float) (((fArr[iRound][i11] - fArr[iRound - ((int) Math.round(dDoubleValue))][i11]) / dRound) + fArr[iRound - ((int) Math.round(dDoubleValue))][i11]);
                    } else {
                        fArr2[i13][i11] = 0.0f;
                    }
                    i13++;
                    iRound += (int) Math.round(dDoubleValue);
                }
            }
            i11++;
        }
        ArrayList arrayList2 = new ArrayList(256);
        for (float[] fArr3 : fArr2) {
            arrayList2.add(fArr3);
        }
        return arrayList2;
    }
}
