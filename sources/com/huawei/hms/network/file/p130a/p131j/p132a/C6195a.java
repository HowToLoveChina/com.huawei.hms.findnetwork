package com.huawei.hms.network.file.p130a.p131j.p132a;

import com.huawei.hms.network.file.core.util.FLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.huawei.hms.network.file.a.j.a.a */
/* loaded from: classes8.dex */
public class C6195a {

    /* renamed from: a */
    private a f29302a = null;

    /* renamed from: b */
    public ArrayList<Double> f29303b;

    /* renamed from: com.huawei.hms.network.file.a.j.a.a$a */
    public static class a {

        /* renamed from: a */
        String f29304a;

        /* renamed from: b */
        public boolean f29305b;

        /* renamed from: c */
        public a f29306c;

        /* renamed from: d */
        public a f29307d;

        /* renamed from: e */
        public int f29308e;

        /* renamed from: f */
        public double f29309f;

        /* renamed from: g */
        public double f29310g;
    }

    /* renamed from: a */
    private double m36059a(double[] dArr) {
        a aVar = this.f29302a;
        a aVar2 = aVar;
        while (aVar2 != null) {
            if (aVar2.f29305b) {
                return aVar2.f29309f;
            }
            a aVar3 = aVar2.f29306c;
            aVar2 = (aVar3 == null || dArr[aVar2.f29308e] >= aVar2.f29310g) ? aVar2.f29307d : aVar3;
        }
        FLogger.m36351e("DecisionTree", "predict error, parent:" + aVar.f29304a);
        return -1.0d;
    }

    /* renamed from: a */
    public ArrayList<Double> m36060a(ArrayList<double[]> arrayList) {
        ArrayList<Double> arrayList2 = new ArrayList<>();
        Iterator<double[]> it = arrayList.iterator();
        while (it.hasNext()) {
            double[] next = it.next();
            double dM36059a = m36059a(next);
            if (dM36059a == -1.0d || dM36059a == -100.0d) {
                FLogger.m36351e("DecisionTree", "predict error,  error for:" + Arrays.toString(next) + ",name:" + this.f29302a.f29304a);
            }
            arrayList2.add(Double.valueOf(dM36059a));
        }
        this.f29303b = arrayList2;
        return arrayList2;
    }
}
