package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.bz */
/* loaded from: classes8.dex */
public class C6982bz {

    /* renamed from: a */
    private static volatile InterfaceC6998co f32093a = null;

    /* renamed from: b */
    private static final byte[] f32094b = new byte[0];

    /* renamed from: c */
    private static String f32095c = null;

    /* renamed from: d */
    private static int f32096d = 3;

    /* renamed from: com.huawei.openalliance.ad.bz$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f32097a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6982bz.m41162l(context);
        }
    }

    /* renamed from: a */
    public static InterfaceC6998co m41148a(Context context) {
        if (f32093a == null) {
            synchronized (f32094b) {
                try {
                    if (f32093a == null) {
                        f32093a = m41154d(context) ? C6993cj.m41222b(context) : m41155e(context) ? C6990cg.m41213b(context) : m41149a() ? C6989cf.m41211b(context) : C6997cn.m41226b(context);
                    }
                } catch (Throwable th2) {
                    f32093a = C6993cj.m41222b(context);
                    AbstractC7185ho.m43823c("DeviceManager", "init device manager error, " + th2.getClass().getSimpleName());
                } finally {
                }
            }
        }
        return f32093a;
    }

    /* renamed from: b */
    public static boolean m41151b() {
        String str = Build.MANUFACTURER;
        return str.equalsIgnoreCase("Minrray") || str.equalsIgnoreCase("Hivendor") || str.equalsIgnoreCase("Huanglong");
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m41153c(android.content.Context r8) {
        /*
            java.lang.String r0 = "DeviceManager"
            java.lang.String r1 = "HONOR"
            java.lang.String r2 = "HUAWEI"
            android.content.Context r3 = r8.getApplicationContext()
            com.huawei.openalliance.ad.utils.cg r3 = com.huawei.openalliance.p169ad.utils.C7787cg.m47900a(r3)
            java.lang.String r4 = r3.m47973c()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            r6 = 1
            if (r5 != 0) goto L23
            java.lang.String r8 = java.lang.String.valueOf(r6)
            boolean r8 = android.text.TextUtils.equals(r8, r4)
            goto L9e
        L23:
            r4 = 0
            java.lang.String r5 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            boolean r7 = r5.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r7 != 0) goto L47
            java.lang.String r7 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            boolean r2 = r7.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r2 != 0) goto L47
            boolean r2 = r5.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r2 != 0) goto L47
            boolean r1 = r7.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r1 == 0) goto L41
            goto L47
        L41:
            r1 = r4
            goto L48
        L43:
            r8 = move-exception
            goto L75
        L45:
            r8 = move-exception
            goto L93
        L47:
            r1 = r6
        L48:
            if (r1 != 0) goto L73
            com.huawei.openalliance.ad.cq r8 = com.huawei.openalliance.p169ad.C6985cb.m41166a(r8)     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L70
            java.lang.String r8 = r8.mo41208e()     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L70
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L70
            java.lang.String r2 = "EMUI_SDK_INT"
            java.lang.reflect.Field r8 = r8.getDeclaredField(r2)     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L70
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L70
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L70
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L70
            if (r8 <= 0) goto L6a
            goto L6b
        L6a:
            r6 = r4
        L6b:
            r1 = r6
            goto L73
        L6d:
            r8 = move-exception
            r4 = r1
            goto L75
        L70:
            r8 = move-exception
            r4 = r1
            goto L93
        L73:
            r8 = r1
            goto L9b
        L75:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isHuaweiPhone Error:"
        L7c:
            r1.append(r2)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r0, r8)
            r8 = r4
            goto L9b
        L93:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isHuaweiPhone RuntimeException:"
            goto L7c
        L9b:
            r3.m47957a(r8)
        L9e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C6982bz.m41153c(android.content.Context):boolean");
    }

    /* renamed from: d */
    public static boolean m41154d(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47944W = c7787cgM47900a.m47944W();
        if (!TextUtils.isEmpty(strM47944W)) {
            return TextUtils.equals(String.valueOf(true), strM47944W);
        }
        boolean z10 = m41153c(context) && !m41155e(context);
        c7787cgM47900a.m47980d(z10);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0032  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m41155e(android.content.Context r4) {
        /*
            com.huawei.openalliance.ad.utils.cg r4 = com.huawei.openalliance.p169ad.utils.C7787cg.m47900a(r4)
            java.lang.String r0 = r4.m47945X()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r1 != 0) goto L18
            java.lang.String r4 = java.lang.String.valueOf(r2)
            boolean r4 = android.text.TextUtils.equals(r4, r0)
            goto L57
        L18:
            r0 = 0
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "HONOR"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L30
            r3 = 31
            if (r1 < r3) goto L32
            int r1 = com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT     // Catch: java.lang.Throwable -> L30
            r3 = 33
            if (r1 < r3) goto L32
            goto L33
        L30:
            r1 = move-exception
            goto L35
        L32:
            r2 = r0
        L33:
            r0 = r2
            goto L53
        L35:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isHonor6UpPhone Error:"
            r2.append(r3)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "DeviceManager"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r2, r1)
        L53:
            r4.m47984e(r0)
            r4 = r0
        L57:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C6982bz.m41155e(android.content.Context):boolean");
    }

    /* renamed from: f */
    public static boolean m41156f(Context context) {
        Integer numMo44057j = HiAd.m44014a(context).mo44057j();
        InterfaceC6998co interfaceC6998coM41148a = m41148a(context);
        return (numMo44057j != null && 2 == numMo44057j.intValue()) || ("HONOR".equalsIgnoreCase(interfaceC6998coM41148a.mo41181j()) && "HONOR".equalsIgnoreCase(interfaceC6998coM41148a.mo41182k()));
    }

    /* renamed from: g */
    public static boolean m41157g(Context context) {
        return "HUAWEI".equalsIgnoreCase(m41148a(context).mo41181j()) && "HUAWEI".equalsIgnoreCase(m41148a(context).mo41182k());
    }

    /* renamed from: h */
    public static boolean m41158h(Context context) {
        if (m41153c(context)) {
            return true;
        }
        m41160j(context);
        if (!m41150a(f32096d, f32095c)) {
            List listAsList = Arrays.asList(f32095c.split(","));
            Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).length() != f32096d) {
                    AbstractC7185ho.m43821b("DeviceManager", "The partnerList format is incorrect, %s", listAsList);
                }
            }
            String strM48289a = AbstractC7811dd.m48289a(Constants.PROPERTY_CHANNEL);
            boolean z10 = !TextUtils.isEmpty(strM48289a) && listAsList.contains(strM48289a.substring(0, Math.min(f32096d, strM48289a.length())));
            m41161k(context);
            return z10;
        }
        AbstractC7185ho.m43820b("DeviceManager", "partnerRule out of range");
        m41161k(context);
        return m41149a();
    }

    /* renamed from: j */
    private static void m41160j(Context context) {
        if (f32095c == null) {
            m41162l(context);
        }
    }

    /* renamed from: k */
    private static void m41161k(Context context) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.bz.1

            /* renamed from: a */
            final /* synthetic */ Context f32097a;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C6982bz.m41162l(context);
            }
        });
    }

    /* renamed from: l */
    public static void m41162l(Context context) {
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        f32096d = interfaceC7146gcM43316b.mo43067ao();
        f32095c = interfaceC7146gcM43316b.mo43068ap();
        AbstractC7185ho.m43818a("DeviceManager", "get partner config, partnerRule: %s, partnerList: %s", Integer.valueOf(f32096d), f32095c);
    }

    /* renamed from: a */
    public static boolean m41149a() {
        String strM48289a = AbstractC7811dd.m48289a(Constants.PROPERTY_CHANNEL);
        return !TextUtils.isEmpty(strM48289a) && strM48289a.startsWith("02");
    }

    /* renamed from: b */
    public static boolean m41152b(Context context) {
        return m41153c(context) || m41149a() || m41151b();
    }

    /* renamed from: a */
    private static boolean m41150a(int i10, String str) {
        return i10 < 2 || i10 > 11 || TextUtils.isEmpty(str) || !str.matches(Constants.PARTNER_REGEX);
    }
}
