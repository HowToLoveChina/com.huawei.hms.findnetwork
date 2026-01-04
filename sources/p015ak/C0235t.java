package p015ak;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.huawei.openalliance.p169ad.constant.VastAttribute;

/* renamed from: ak.t */
/* loaded from: classes6.dex */
public class C0235t extends C0205b {

    /* renamed from: a */
    public static C0235t f861a = new C0235t();

    /* renamed from: e */
    public static C0235t m1645e() {
        return f861a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.core.app.NotificationCompat.Builder m1646d(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, java.lang.String r14) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r8 = this;
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            if (r9 != 0) goto Lc
            android.content.Context r9 = p015ak.C0213f.m1377a()
            android.content.Context r9 = r9.getApplicationContext()
        Lc:
            r0 = 0
            java.lang.String r1 = "android.app.NotificationChannel"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L73
            r2 = 3
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L73
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Exception -> L73
            java.lang.Class<java.lang.CharSequence> r5 = java.lang.CharSequence.class
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Exception -> L73
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L73
            r7 = 2
            r3[r7] = r5     // Catch: java.lang.Exception -> L73
            java.lang.reflect.Constructor r3 = r1.getDeclaredConstructor(r3)     // Catch: java.lang.Exception -> L73
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L73
            r2[r4] = r11     // Catch: java.lang.Exception -> L73
            r2[r6] = r12     // Catch: java.lang.Exception -> L73
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L73
            r2[r7] = r12     // Catch: java.lang.Exception -> L73
            java.lang.Object r12 = r3.newInstance(r2)     // Catch: java.lang.Exception -> L73
            java.lang.String r2 = "setDescription"
            java.lang.Class[] r3 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L73
            r3[r4] = r8     // Catch: java.lang.Exception -> L73
            java.lang.reflect.Method r8 = r1.getDeclaredMethod(r2, r3)     // Catch: java.lang.Exception -> L73
            java.lang.Object[] r10 = new java.lang.Object[]{r10}     // Catch: java.lang.Exception -> L73
            r8.invoke(r12, r10)     // Catch: java.lang.Exception -> L73
            p015ak.C0205b.m1128c(r1, r12, r13)     // Catch: java.lang.Exception -> L73
            java.lang.String r8 = "android.app.NotificationManager"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch: java.lang.Exception -> L73
            java.lang.String r10 = "createNotificationChannel"
            java.lang.Class[] r13 = new java.lang.Class[]{r1}     // Catch: java.lang.Exception -> L73
            java.lang.reflect.Method r10 = r8.getDeclaredMethod(r10, r13)     // Catch: java.lang.Exception -> L73
            java.lang.Object r8 = r9.getSystemService(r8)     // Catch: java.lang.Exception -> L73
            java.lang.Object[] r12 = new java.lang.Object[]{r12}     // Catch: java.lang.Exception -> L73
            r10.invoke(r8, r12)     // Catch: java.lang.Exception -> L73
            androidx.core.app.NotificationCompat$Builder r8 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.Exception -> L73
            r8.<init>(r9, r11)     // Catch: java.lang.Exception -> L73
            r8.m3820u(r6)     // Catch: java.lang.Exception -> L72
            p015ak.C0205b.m1126a(r8, r14)     // Catch: java.lang.Exception -> L72
            goto L7b
        L72:
            r0 = r8
        L73:
            java.lang.String r8 = "LowLevelNotificationManagerHelper"
            java.lang.String r10 = "getNotificationCompatBuilder Exception"
            p399jk.AbstractC10896a.m65888w(r8, r10)
            r8 = r0
        L7b:
            if (r8 != 0) goto L82
            androidx.core.app.NotificationCompat$Builder r8 = new androidx.core.app.NotificationCompat$Builder
            r8.<init>(r9)
        L82:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0235t.m1646d(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String):androidx.core.app.NotificationCompat$Builder");
    }

    /* renamed from: f */
    public NotificationCompat.Builder m1647f(Context context, String str, String str2, String str3) {
        return m1646d(context, str, str2, str3, 3, "reminder");
    }

    /* renamed from: g */
    public NotificationCompat.Builder m1648g(Context context, String str, String str2, String str3) {
        return m1646d(context, str, str2, str3, 3, VastAttribute.PROGRESS);
    }

    /* renamed from: h */
    public NotificationCompat.Builder m1649h(Context context, String str, String str2, String str3, int i10, String str4) {
        return m1646d(context, str, str2, str3, i10, str4);
    }
}
