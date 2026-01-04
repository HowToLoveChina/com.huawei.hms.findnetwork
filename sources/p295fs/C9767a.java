package p295fs;

import as.C1016d;

/* renamed from: fs.a */
/* loaded from: classes8.dex */
public class C9767a {
    /* renamed from: a */
    public static C9769c m60794a(double d10, double d11, int i10) {
        if (i10 == 1) {
            return m60795b(d10, d11);
        }
        C1016d.m6183c("CoordinateTransform", "coordType is not 84");
        return null;
    }

    /* renamed from: b */
    public static C9769c m60795b(double d10, double d11) {
        return m60796c(d10, d11, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p295fs.C9769c m60796c(double r5, double r7, int r9) {
        /*
            fs.c r0 = new fs.c
            r0.<init>()
            r1 = 0
            double[] r2 = new double[r1]
            java.lang.String r3 = "CoordinateTransform"
            r4 = 1
            if (r9 != r4) goto L13
            double[] r5 = com.huawei.location.lite.common.util.coordinateconverter.Transform.wgs84to02Native(r5, r7)     // Catch: java.lang.Error -> L18 java.lang.Exception -> L1e
        L11:
            r2 = r5
            goto L21
        L13:
            double[] r5 = com.huawei.location.lite.common.util.coordinateconverter.Transform.gcj02to84Native(r5, r7)     // Catch: java.lang.Error -> L18 java.lang.Exception -> L1e
            goto L11
        L18:
            java.lang.String r5 = "transform Native method error"
        L1a:
            as.C1016d.m6183c(r3, r5)
            goto L21
        L1e:
            java.lang.String r5 = "transform Native method exception"
            goto L1a
        L21:
            int r5 = r2.length
            r6 = 2
            if (r5 >= r6) goto L2c
            java.lang.String r5 = "transform doubles length exception"
            as.C1016d.m6183c(r3, r5)
            r5 = 0
            return r5
        L2c:
            r5 = r2[r1]
            r0.m60803c(r5)
            r5 = r2[r4]
            r0.m60804d(r5)
            java.lang.String r5 = "transform ok"
            as.C1016d.m6181a(r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p295fs.C9767a.m60796c(double, double, int):fs.c");
    }
}
