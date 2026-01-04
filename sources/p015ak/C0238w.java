package p015ak;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.huawei.hicloud.base.R$string;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ak.w */
/* loaded from: classes6.dex */
public class C0238w extends C0205b {

    /* renamed from: a */
    public static String f862a = "other notification";

    /* renamed from: b */
    public static C0238w f863b = new C0238w();

    /* JADX WARN: Removed duplicated region for block: B:12:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.core.app.NotificationCompat.Builder m1662e(android.content.Context r11, java.lang.String r12, int r13, java.lang.String r14) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r10 = this;
            java.lang.String r10 = "0"
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r11 != 0) goto Le
            android.content.Context r11 = p015ak.C0213f.m1377a()
            android.content.Context r11 = r11.getApplicationContext()
        Le:
            r1 = 0
            int r2 = com.huawei.hicloud.base.R$string.other_notify_name     // Catch: java.lang.Exception -> L80
            java.lang.String r2 = r11.getString(r2)     // Catch: java.lang.Exception -> L80
            m1664l(r2)     // Catch: java.lang.Exception -> L80
            java.lang.String r2 = "android.app.NotificationChannel"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Exception -> L80
            r3 = 3
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L80
            r5 = 0
            r4[r5] = r0     // Catch: java.lang.Exception -> L80
            java.lang.Class<java.lang.CharSequence> r6 = java.lang.CharSequence.class
            r7 = 1
            r4[r7] = r6     // Catch: java.lang.Exception -> L80
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L80
            r8 = 2
            r4[r8] = r6     // Catch: java.lang.Exception -> L80
            java.lang.reflect.Constructor r4 = r2.getDeclaredConstructor(r4)     // Catch: java.lang.Exception -> L80
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L80
            r6[r5] = r10     // Catch: java.lang.Exception -> L80
            java.lang.String r9 = p015ak.C0238w.f862a     // Catch: java.lang.Exception -> L80
            r6[r7] = r9     // Catch: java.lang.Exception -> L80
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L80
            r6[r8] = r3     // Catch: java.lang.Exception -> L80
            java.lang.Object r3 = r4.newInstance(r6)     // Catch: java.lang.Exception -> L80
            java.lang.String r4 = "setDescription"
            java.lang.Class[] r6 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L80
            r6[r5] = r0     // Catch: java.lang.Exception -> L80
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r4, r6)     // Catch: java.lang.Exception -> L80
            java.lang.Object[] r12 = new java.lang.Object[]{r12}     // Catch: java.lang.Exception -> L80
            r0.invoke(r3, r12)     // Catch: java.lang.Exception -> L80
            p015ak.C0205b.m1128c(r2, r3, r13)     // Catch: java.lang.Exception -> L80
            java.lang.String r12 = "android.app.NotificationManager"
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch: java.lang.Exception -> L80
            java.lang.String r13 = "createNotificationChannel"
            java.lang.Class[] r0 = new java.lang.Class[]{r2}     // Catch: java.lang.Exception -> L80
            java.lang.reflect.Method r13 = r12.getDeclaredMethod(r13, r0)     // Catch: java.lang.Exception -> L80
            java.lang.Object r12 = r11.getSystemService(r12)     // Catch: java.lang.Exception -> L80
            java.lang.Object[] r0 = new java.lang.Object[]{r3}     // Catch: java.lang.Exception -> L80
            r13.invoke(r12, r0)     // Catch: java.lang.Exception -> L80
            androidx.core.app.NotificationCompat$Builder r12 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.Exception -> L80
            r12.<init>(r11, r10)     // Catch: java.lang.Exception -> L80
            r12.m3820u(r7)     // Catch: java.lang.Exception -> L7f
            p015ak.C0205b.m1126a(r12, r14)     // Catch: java.lang.Exception -> L7f
            goto L88
        L7f:
            r1 = r12
        L80:
            java.lang.String r10 = "NotificationManagerHelper"
            java.lang.String r12 = "getNotificationCompatBuider catch Exception"
            p399jk.AbstractC10896a.m65888w(r10, r12)
            r12 = r1
        L88:
            if (r12 != 0) goto L8f
            androidx.core.app.NotificationCompat$Builder r12 = new androidx.core.app.NotificationCompat$Builder
            r12.<init>(r11)
        L8f:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0238w.m1662e(android.content.Context, java.lang.String, int, java.lang.String):androidx.core.app.NotificationCompat$Builder");
    }

    /* renamed from: f */
    public static C0238w m1663f() {
        return f863b;
    }

    /* renamed from: l */
    private static void m1664l(String str) {
        f862a = str;
    }

    /* renamed from: d */
    public final NotificationCompat.Builder m1665d(Context context, String str, int i10, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (context == null) {
            context = C0213f.m1377a().getApplicationContext();
        }
        m1664l(context.getString(R$string.other_notify_name));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.getNotificationChannel("0");
        NotificationChannel notificationChannel = new NotificationChannel("0", f862a, 3);
        notificationChannel.setDescription(str);
        C0205b.m1127b(notificationChannel, i10);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "0");
        C0205b.m1126a(builder, str2);
        return builder;
    }

    /* renamed from: g */
    public NotificationCompat.Builder m1666g(Context context, String str) {
        return m1665d(context, str, 3, "reminder");
    }

    /* renamed from: h */
    public NotificationCompat.Builder m1667h(Context context, String str, int i10, String str2) {
        return m1665d(context, str, i10, str2);
    }

    /* renamed from: i */
    public NotificationCompat.Builder m1668i(Context context, String str) {
        return m1662e(context, str, 3, "reminder");
    }

    /* renamed from: j */
    public NotificationCompat.Builder m1669j(Context context, String str) {
        return m1662e(context, str, 3, VastAttribute.PROGRESS);
    }

    /* renamed from: k */
    public NotificationCompat.Builder m1670k(Context context, String str, int i10, String str2) {
        return m1662e(context, str, i10, str2);
    }
}
