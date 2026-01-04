package com.huawei.hms.network.file.p130a.p131j.p132a;

import android.os.Build;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.core.util.FLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.network.file.a.j.a.b */
/* loaded from: classes8.dex */
public class C6196b {

    /* renamed from: g */
    private static final int[] f29311g = {2, 3, 4, 5, 6, 7, 8};

    /* renamed from: a */
    ArrayList<C6195a> f29312a;

    /* renamed from: b */
    private final Object f29313b;

    /* renamed from: c */
    private volatile boolean f29314c;

    /* renamed from: d */
    volatile long f29315d;

    /* renamed from: e */
    int[] f29316e;

    /* renamed from: f */
    boolean f29317f;

    /* renamed from: com.huawei.hms.network.file.a.j.a.b$b */
    public static class b {

        /* renamed from: a */
        static final C6196b f29318a = new C6196b();
    }

    private C6196b() {
        this.f29312a = new ArrayList<>();
        this.f29313b = new Object();
        this.f29314c = false;
        this.f29315d = 0L;
        this.f29316e = null;
        this.f29317f = true;
    }

    /* renamed from: b */
    public static C6196b m36073b() {
        return b.f29318a;
    }

    /* renamed from: a */
    public static double m36061a(ArrayList<Double> arrayList) {
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            dDoubleValue += arrayList.get(i10).doubleValue();
        }
        return dDoubleValue / arrayList.size();
    }

    /* renamed from: b */
    public static boolean m36074b(int i10) {
        return 1 == i10;
    }

    /* renamed from: a */
    public static double m36062a(ArrayList<Double> arrayList, ArrayList<Double> arrayList2) {
        int size = arrayList.size();
        double dM36061a = m36061a(arrayList);
        double dPow = 0.0d;
        double dPow2 = 0.0d;
        for (int i10 = 0; i10 < size; i10++) {
            dPow += Math.pow(arrayList.get(i10).doubleValue() - arrayList2.get(i10).doubleValue(), 2.0d);
            dPow2 += Math.pow(arrayList.get(i10).doubleValue() - dM36061a, 2.0d);
        }
        return 1.0d - (dPow / dPow2);
    }

    /* renamed from: a */
    private int m36063a(double d10, double d11, double d12, long j10, final int i10, final long j11) {
        String str;
        int i11 = 0;
        final double[] dArrM36071a = m36071a(new double[]{d10, d11, d12, j10, i10, 0.0d}, true);
        if (dArrM36071a.length <= 0) {
            return 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            int iIntValue = ((Integer) ExecutorsUtils.newSingleThreadExecutor("DecisionTreeManager").submit(new Callable() { // from class: com.huawei.hms.network.file.a.j.a.c
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f29319a.m36067a(dArrM36071a, i10, j11);
                }
            }).get(j11, TimeUnit.MILLISECONDS)).intValue();
            try {
                FLogger.m36350d("DecisionTreeManager", "predictSliceNum timeued:" + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                return iIntValue;
            } catch (InterruptedException e10) {
                e = e10;
                i11 = iIntValue;
                str = "predictException for InterruptedException";
                FLogger.m36352e("DecisionTreeManager", str, e);
                return i11;
            } catch (ExecutionException e11) {
                e = e11;
                i11 = iIntValue;
                str = "predictException for ExecutionException";
                FLogger.m36352e("DecisionTreeManager", str, e);
                return i11;
            } catch (TimeoutException e12) {
                e = e12;
                i11 = iIntValue;
                str = "predictException for TimeoutException";
                FLogger.m36352e("DecisionTreeManager", str, e);
                return i11;
            }
        } catch (InterruptedException e13) {
            e = e13;
        } catch (ExecutionException e14) {
            e = e14;
        } catch (TimeoutException e15) {
            e = e15;
        }
    }

    /* renamed from: a */
    public static int m36064a(int i10) {
        if (i10 > 0) {
            return 0;
        }
        if (i10 > -60) {
            return 5;
        }
        if (i10 > -75) {
            return 4;
        }
        if (i10 > -90) {
            return 3;
        }
        if (i10 > -100) {
            return 2;
        }
        return i10 > -110 ? 1 : 0;
    }

    /* renamed from: a */
    public int m36075a(long j10, long j11) {
        if (!this.f29314c || !this.f29317f) {
            return 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int[] iArrM36072a = m36072a();
        FLogger.m36353i("DecisionTreeManager", "getCachedNetworkInfos timeused:" + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        if (iArrM36072a == null) {
            FLogger.m36351e("DecisionTreeManager", "predictSliceNum failed, networkInfo is null");
            return 0;
        }
        int i10 = iArrM36072a[0];
        int i11 = iArrM36072a[1];
        int i12 = iArrM36072a[2];
        FLogger.m36350d("DecisionTreeManager", "predictSliceNum networkType:" + i10 + ",wifiNum:" + i11 + ",mobileNum:" + i12, new Object[0]);
        return m36063a(i10, i11, i12, j10, m36065a(Build.MODEL), j11);
    }

    /* renamed from: a */
    public static int m36065a(String str) {
        String upperCase = str.toUpperCase(Locale.getDefault());
        int length = upperCase.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = upperCase.charAt(i11);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                i10 = (i10 * 26) + (cCharAt - '@');
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Integer m36067a(double[] dArr, int i10, long j10) {
        int[] iArr;
        int i11;
        try {
            ArrayList<double[]> arrayList = new ArrayList<>(f29311g.length);
            int i12 = 0;
            while (true) {
                iArr = f29311g;
                if (i12 >= iArr.length) {
                    break;
                }
                arrayList.add(new double[]{dArr[0], dArr[1], dArr[2], dArr[3], iArr[i12]});
                i12++;
            }
            FLogger.m36350d("DecisionTreeManager", "predictSliceNum params:" + Arrays.toString(arrayList.get(0)) + ",model:" + i10 + ", timeout:" + j10, new Object[0]);
            ArrayList<Double> arrayListM36068a = m36068a(arrayList, false);
            Double d10 = arrayListM36068a.get(0);
            int i13 = iArr[0];
            for (i11 = 1; i11 < arrayListM36068a.size(); i11++) {
                if (arrayListM36068a.get(i11).doubleValue() > d10.doubleValue()) {
                    d10 = arrayListM36068a.get(i11);
                    i13 = f29311g[i11];
                }
            }
            FLogger.m36350d("DecisionTreeManager", "predictResult:" + arrayListM36068a + ";bestSliceNum = " + i13, new Object[0]);
            return Integer.valueOf(i13);
        } catch (Throwable th2) {
            FLogger.m36352e("DecisionTreeManager", "predictException", th2);
            return null;
        }
    }

    /* renamed from: a */
    private ArrayList<Double> m36068a(ArrayList<double[]> arrayList, boolean z10) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Double> arrayList3 = new ArrayList<>();
        if (z10) {
            Iterator<double[]> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Double.valueOf(it.next()[r3.length - 1]));
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator<C6195a> it2 = this.f29312a.iterator();
        while (it2.hasNext()) {
            C6195a next = it2.next();
            next.m36060a(arrayList);
            arrayList4.add(next.f29303b);
        }
        int size = arrayList.size();
        int size2 = this.f29312a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList arrayList5 = new ArrayList();
            for (int i12 = 0; i12 < size2; i12++) {
                arrayList5.add((Double) ((ArrayList) arrayList4.get(i12)).get(i11));
            }
            double dM36061a = m36061a((ArrayList<Double>) arrayList5);
            arrayList3.add(Double.valueOf(dM36061a));
            if (z10 && m36069a(dM36061a, ((Double) arrayList2.get(i11)).doubleValue())) {
                i10++;
            }
        }
        if (z10) {
            FLogger.m36353i("DecisionTreeManager", "Accuracy of Forest is : " + ((i10 * 100) / size) + ",score:" + m36062a((ArrayList<Double>) arrayList2, arrayList3), new Object[0]);
        }
        return arrayList3;
    }

    /* renamed from: a */
    public static boolean m36069a(double d10, double d11) {
        return Math.abs(d10 - d11) <= Math.abs(d11) * 0.20000000298023224d;
    }

    /* renamed from: a */
    public static boolean m36070a(int i10, int i11, int i12) {
        String str;
        if (i10 == 0) {
            str = "invalid network info: unknown  netType";
        } else if (m36074b(i10) && -127 == i11) {
            str = "invalid network info: unknown  wifi";
        } else {
            if (m36074b(i10) || -127 != i12) {
                return true;
            }
            str = "invalid network info: unknown  mobile";
        }
        FLogger.m36351e("DecisionTreeManager", str);
        return false;
    }

    /* renamed from: a */
    public static double[] m36071a(double[] dArr, boolean z10) {
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        if (z10) {
            if (!m36070a((int) dArrCopyOf[0], (int) dArrCopyOf[1], (int) dArrCopyOf[2])) {
                FLogger.m36351e("DecisionTreeManager", "preProposeData invalidData:" + Arrays.toString(dArr));
                return new double[0];
            }
            if (m36074b((int) dArrCopyOf[0])) {
                dArrCopyOf[2] = -127.0d;
            } else {
                dArrCopyOf[1] = -127.0d;
            }
            dArrCopyOf[1] = m36064a((int) dArrCopyOf[1]);
            dArrCopyOf[2] = m36064a((int) dArrCopyOf[2]);
        }
        return dArrCopyOf;
    }

    /* renamed from: a */
    private int[] m36072a() {
        synchronized (this.f29313b) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.f29315d == 0 || jCurrentTimeMillis - this.f29315d > 30000) {
                    if (this.f29316e == null) {
                        this.f29316e = new int[3];
                    }
                    this.f29316e[0] = NetworkUtil.netWork(RequestManager.getAppContext());
                    this.f29316e[1] = NetworkUtil.getWifiRssi(RequestManager.getAppContext());
                    this.f29316e[2] = NetworkUtil.getMobileRsrp(RequestManager.getAppContext());
                    this.f29315d = System.currentTimeMillis();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f29316e;
    }
}
