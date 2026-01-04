package p687uq;

import android.content.Context;
import com.huawei.secure.android.common.util.SafeString;

/* renamed from: uq.a */
/* loaded from: classes8.dex */
public class C13236a {

    /* renamed from: a */
    public static final String f59907a = "a";

    /* renamed from: uq.a$b */
    public static class b {

        /* renamed from: a */
        public static C13236a f59908a = new C13236a();
    }

    /* renamed from: b */
    public static C13236a m79608b() {
        return b.f59908a;
    }

    /* renamed from: a */
    public String m79609a(Context context) {
        String strM79610c = m79610c(context);
        return (strM79610c == null || strM79610c.length() < 3) ? "" : SafeString.substring(strM79610c, 0, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m79610c(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r8 = ""
            r0 = 1
            java.lang.String r1 = "phone"
            java.lang.Object r9 = r9.getSystemService(r1)     // Catch: java.lang.Throwable -> L71
            android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9     // Catch: java.lang.Throwable -> L71
            uq.c r1 = p687uq.C13238c.m79615a()     // Catch: java.lang.Throwable -> L71
            boolean r1 = r1.m79617c()     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r3 = 5
            if (r1 == 0) goto L73
            java.lang.String r9 = p687uq.C13236a.f59907a     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = "getDevicePLMN multi sim enable"
            p640sq.C12836o.m77097b(r9, r1, r0)     // Catch: java.lang.Throwable -> L71
            uq.c r1 = p687uq.C13238c.m79615a()     // Catch: java.lang.Throwable -> L71
            uq.b r1 = r1.m79618d()     // Catch: java.lang.Throwable -> L71
            int r4 = r1.mo79611a()     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r5.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r6 = "getDevicePLMN subId:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L71
            r5.append(r4)     // Catch: java.lang.Throwable -> L71
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L71
            p640sq.C12836o.m77096a(r9, r5, r0)     // Catch: java.lang.Throwable -> L71
            int r5 = r1.mo79613b(r4)     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r6.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r7 = "getDevicePLMN simState:"
            r6.append(r7)     // Catch: java.lang.Throwable -> L71
            r6.append(r5)     // Catch: java.lang.Throwable -> L71
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L71
            p640sq.C12836o.m77096a(r9, r6, r0)     // Catch: java.lang.Throwable -> L71
            if (r3 != r5) goto L9b
            java.lang.String r9 = r1.mo79614c(r4)     // Catch: java.lang.Throwable -> L71
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L71
            if (r5 == 0) goto L9c
            java.lang.String r9 = r1.mo79612a(r4)     // Catch: java.lang.Throwable -> L71
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L71
            if (r1 != 0) goto L9c
            java.lang.String r9 = com.huawei.secure.android.common.util.SafeString.substring(r9, r2, r3)     // Catch: java.lang.Throwable -> L71
            goto L9c
        L71:
            r9 = move-exception
            goto La7
        L73:
            java.lang.String r1 = p687uq.C13236a.f59907a     // Catch: java.lang.Throwable -> L71
            java.lang.String r4 = "getDevicePLMN multi sim disable"
            p640sq.C12836o.m77097b(r1, r4, r0)     // Catch: java.lang.Throwable -> L71
            int r1 = r9.getSimState()     // Catch: java.lang.Throwable -> L71
            if (r3 != r1) goto L9b
            java.lang.String r1 = r9.getSimOperator()     // Catch: java.lang.Throwable -> L71
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L71
            if (r4 == 0) goto L99
            java.lang.String r9 = r9.getSubscriberId()     // Catch: java.lang.Throwable -> L71
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L71
            if (r1 != 0) goto L9c
            java.lang.String r9 = com.huawei.secure.android.common.util.SafeString.substring(r9, r2, r3)     // Catch: java.lang.Throwable -> L71
            goto L9c
        L99:
            r9 = r1
            goto L9c
        L9b:
            r9 = r8
        L9c:
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L71
            if (r1 == 0) goto La5
            java.lang.String r8 = "00000"
            goto Lc5
        La5:
            r8 = r9
            goto Lc5
        La7:
            java.lang.String r1 = p687uq.C13236a.f59907a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Throwable:"
            r2.append(r3)
            java.lang.Class r9 = r9.getClass()
            java.lang.String r9 = r9.getSimpleName()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            p640sq.C12836o.m77099d(r1, r9, r0)
        Lc5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p687uq.C13236a.m79610c(android.content.Context):java.lang.String");
    }

    public C13236a() {
    }
}
