package com.huawei.hms.network.p129ai;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.network.ai.o0 */
/* loaded from: classes8.dex */
public class C5815o0 {

    /* renamed from: a */
    public static final int f26010a = 0;

    /* renamed from: b */
    public static final int f26011b = -127;

    /* renamed from: c */
    public static final int f26012c = -3;

    /* renamed from: d */
    public static final int f26013d = -20;

    /* renamed from: e */
    public static final int f26014e = 300;

    /* renamed from: f */
    public static final int f26015f = -200;

    /* renamed from: g */
    public static final int f26016g = 44;

    /* renamed from: h */
    public static final int f26017h = -51;

    /* renamed from: i */
    public static final int f26018i = 0;

    /* renamed from: j */
    public static final int f26019j = 15;

    /* renamed from: k */
    public static final int f26020k = -43;

    /* renamed from: l */
    public static final int f26021l = -140;

    /* renamed from: m */
    public static final int f26022m = -127;

    /* renamed from: n */
    public static final int f26023n = 0;

    /* renamed from: o */
    public static final Double f26024o = Double.valueOf(1.0d);

    /* renamed from: p */
    public static final Double f26025p = Double.valueOf(0.001d);

    /* renamed from: a */
    public static float m33470a(double d10, double d11, double d12, double d13) {
        double dLog = Math.log(d11 / d13) / d12;
        return (float) Math.exp((-dLog) * (d10 + ((-Math.log(d11)) / dLog)));
    }

    /* renamed from: b */
    public static float m33476b(int i10) {
        if (i10 == 0 || i10 == Integer.MAX_VALUE) {
            return 0.0f;
        }
        return m33471a(i10, -140.0f, -43.0f);
    }

    /* renamed from: c */
    public static float m33478c(int i10) {
        if (i10 == 0 || i10 == Integer.MAX_VALUE) {
            return 0.0f;
        }
        return m33471a(i10, -20.0f, -3.0f);
    }

    /* renamed from: d */
    public static float m33480d(int i10) {
        if (i10 == 0 || i10 == Integer.MAX_VALUE) {
            return 0.0f;
        }
        return m33471a(i10, -51.0f, 44.0f);
    }

    /* renamed from: e */
    public static float m33481e(int i10) {
        if (i10 == 0 || i10 == Integer.MAX_VALUE) {
            return 0.0f;
        }
        return m33471a(i10, -200.0f, 300.0f);
    }

    /* renamed from: f */
    public static float m33482f(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return 0.0f;
        }
        return m33471a(i10, -127.0f, 0.0f);
    }

    /* renamed from: g */
    public static int m33483g(int i10) {
        return i10 == 0 ? 0 : 1;
    }

    /* renamed from: h */
    public static float m33484h(int i10) {
        if (i10 == -127) {
            return 0.0f;
        }
        return m33471a(i10, -127.0f, 0.0f);
    }

    /* renamed from: a */
    public static float m33471a(float f10, float f11, float f12) {
        return (f10 - f11) / (f12 - f11);
    }

    /* renamed from: b */
    public static int m33477b(int i10, int i11) {
        if (i10 == 0 || i10 == Integer.MAX_VALUE || i11 == 0 || i11 == Integer.MAX_VALUE) {
            return 0;
        }
        return i10 - i11;
    }

    /* renamed from: c */
    public static int m33479c(int i10, int i11) {
        if (i10 == 0 || i10 == -127 || i11 == 0 || i11 == -127) {
            return 0;
        }
        return i10 - i11;
    }

    /* renamed from: a */
    public static float m33472a(int i10) {
        if (i10 == 0 || i10 == Integer.MAX_VALUE) {
            return 0.0f;
        }
        return m33471a(i10, 15.0f, 0.0f);
    }

    /* renamed from: a */
    public static float m33473a(LinkedHashMap<Long, C5818r> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            return 0.0f;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, C5818r>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            C5818r value = it.next().getValue();
            arrayList.add(new Pair(Long.valueOf(value.m33493b()), Long.valueOf(value.m33491a())));
        }
        if (arrayList.size() <= 2) {
            return arrayList.size() == 2 ? (((Long) ((Pair) arrayList.get(0)).second).longValue() + ((Long) ((Pair) arrayList.get(1)).second).longValue()) / 2.0f : ((Long) ((Pair) arrayList.get(0)).second).longValue();
        }
        long jLongValue = ((Long) ((Pair) arrayList.get(0)).first).longValue();
        int iLongValue = (int) (((Long) ((Pair) arrayList.get(arrayList.size() - 1)).first).longValue() - jLongValue);
        float f10 = 0.0f;
        float fLongValue = 0.0f;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            float fM33470a = m33470a((int) (r6 - ((Long) ((Pair) arrayList.get(i10)).first).longValue()), f26024o.doubleValue(), iLongValue, f26025p.doubleValue());
            fLongValue += ((Long) ((Pair) arrayList.get(i10)).second).longValue() * fM33470a;
            f10 += fM33470a;
        }
        if (f10 == 0.0f) {
            return 0.0f;
        }
        return fLongValue / f10;
    }

    /* renamed from: a */
    public static int m33474a(int i10, int i11) {
        if (i10 == 0 || i10 == Integer.MAX_VALUE || i11 == 0 || i11 == Integer.MAX_VALUE) {
            return 0;
        }
        return i10 - i11;
    }

    /* renamed from: a */
    public static long m33475a(Map<Long, C5818r> map) {
        long jM33491a = 2147483647L;
        for (C5818r c5818r : map.values()) {
            if (c5818r.m33491a() < jM33491a) {
                jM33491a = c5818r.m33491a();
            }
        }
        return jM33491a;
    }
}
