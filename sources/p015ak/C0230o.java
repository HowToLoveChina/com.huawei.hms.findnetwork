package p015ak;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.huawei.hicloud.base.R$string;

/* renamed from: ak.o */
/* loaded from: classes6.dex */
public class C0230o extends C0205b {

    /* renamed from: a */
    public static String f854a = C0213f.m1377a().getString(R$string.feedback_sdk_question);

    /* renamed from: b */
    public static C0230o f855b = new C0230o();

    /* renamed from: e */
    public static C0230o m1610e() {
        return f855b;
    }

    /* renamed from: g */
    public static void m1611g(String str) {
        f854a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.core.app.NotificationCompat.Builder m1612d(android.content.Context r10, java.lang.String r11, int r12, java.lang.String r13) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            java.lang.String r9 = "3"
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r10 != 0) goto Le
            android.content.Context r10 = p015ak.C0213f.m1377a()
            android.content.Context r10 = r10.getApplicationContext()
        Le:
            r1 = 0
            int r2 = com.huawei.hicloud.base.R$string.oobe_notify_name     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> L81
            m1611g(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "android.app.NotificationChannel"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L81
            r3 = 3
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L81
            r5 = 0
            r4[r5] = r0     // Catch: java.lang.Throwable -> L81
            java.lang.Class<java.lang.CharSequence> r6 = java.lang.CharSequence.class
            r7 = 1
            r4[r7] = r6     // Catch: java.lang.Throwable -> L81
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L81
            r8 = 2
            r4[r8] = r6     // Catch: java.lang.Throwable -> L81
            java.lang.reflect.Constructor r4 = r2.getDeclaredConstructor(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L81
            r3[r5] = r9     // Catch: java.lang.Throwable -> L81
            java.lang.String r6 = p015ak.C0230o.f854a     // Catch: java.lang.Throwable -> L81
            r3[r7] = r6     // Catch: java.lang.Throwable -> L81
            r6 = 5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L81
            r3[r8] = r6     // Catch: java.lang.Throwable -> L81
            java.lang.Object r3 = r4.newInstance(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "setDescription"
            java.lang.Class[] r6 = new java.lang.Class[r7]     // Catch: java.lang.Throwable -> L81
            r6[r5] = r0     // Catch: java.lang.Throwable -> L81
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r4, r6)     // Catch: java.lang.Throwable -> L81
            java.lang.Object[] r11 = new java.lang.Object[]{r11}     // Catch: java.lang.Throwable -> L81
            r0.invoke(r3, r11)     // Catch: java.lang.Throwable -> L81
            p015ak.C0205b.m1128c(r2, r3, r12)     // Catch: java.lang.Throwable -> L81
            java.lang.String r11 = "android.app.NotificationManager"
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L81
            java.lang.String r12 = "createNotificationChannel"
            java.lang.Class[] r0 = new java.lang.Class[]{r2}     // Catch: java.lang.Throwable -> L81
            java.lang.reflect.Method r12 = r11.getDeclaredMethod(r12, r0)     // Catch: java.lang.Throwable -> L81
            java.lang.Object r11 = r10.getSystemService(r11)     // Catch: java.lang.Throwable -> L81
            java.lang.Object[] r0 = new java.lang.Object[]{r3}     // Catch: java.lang.Throwable -> L81
            r12.invoke(r11, r0)     // Catch: java.lang.Throwable -> L81
            androidx.core.app.NotificationCompat$Builder r11 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.Throwable -> L81
            r11.<init>(r10, r9)     // Catch: java.lang.Throwable -> L81
            r11.m3820u(r7)     // Catch: java.lang.Throwable -> L80
            p015ak.C0205b.m1126a(r11, r13)     // Catch: java.lang.Throwable -> L80
            goto L89
        L80:
            r1 = r11
        L81:
            java.lang.String r9 = "HighLevelNotificationManagerHelper"
            java.lang.String r11 = "getNotificationCompatBuider catch Exception"
            p399jk.AbstractC10896a.m65888w(r9, r11)
            r11 = r1
        L89:
            if (r11 != 0) goto L90
            androidx.core.app.NotificationCompat$Builder r11 = new androidx.core.app.NotificationCompat$Builder
            r11.<init>(r10)
        L90:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0230o.m1612d(android.content.Context, java.lang.String, int, java.lang.String):androidx.core.app.NotificationCompat$Builder");
    }

    /* renamed from: f */
    public NotificationCompat.Builder m1613f(Context context, String str) {
        return m1612d(context, str, 3, "reminder");
    }
}
