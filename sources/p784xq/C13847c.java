package p784xq;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* renamed from: xq.c */
/* loaded from: classes8.dex */
public final class C13847c {
    /* renamed from: a */
    public static ArrayList<float[]> m83116a(ArrayList<float[]> arrayList, ArrayList<float[]> arrayList2, int i10) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList.size(), arrayList.get(0).length);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            System.arraycopy(arrayList.get(i11), 0, fArr[i11], 0, arrayList.get(i11).length);
        }
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList2.size(), arrayList2.get(0).length);
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            System.arraycopy(arrayList2.get(i12), 0, fArr2[i12], 0, arrayList2.get(i12).length);
        }
        float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i10, i10);
        for (int i13 = 0; i13 < i10; i13++) {
            for (int i14 = 0; i14 < i10; i14++) {
                fArr3[i13][i14] = 0.0f;
                for (int i15 = 0; i15 < i10; i15++) {
                    float[] fArr4 = fArr3[i13];
                    fArr4[i14] = (fArr[i13][i15] * fArr2[i15][i14]) + fArr4[i14];
                }
            }
        }
        ArrayList<float[]> arrayList3 = new ArrayList<>(i10);
        for (float[] fArr5 : fArr3) {
            arrayList3.add(fArr5);
        }
        return arrayList3;
    }
}
