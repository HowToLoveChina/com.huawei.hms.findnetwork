package p015ak;

import android.app.NotificationChannel;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.InvocationTargetException;
import p399jk.AbstractC10896a;

/* renamed from: ak.b */
/* loaded from: classes6.dex */
public class C0205b {
    /* renamed from: a */
    public static void m1126a(NotificationCompat.Builder builder, String str) {
        if (C0209d.m1253f1() && builder != null) {
            try {
                builder.m3808i(str);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("BaseNotificationHelper", "setNotificationCategory catch Exception " + e10.getMessage());
            }
        }
    }

    /* renamed from: b */
    public static void m1127b(Object obj, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1253f1()) {
            try {
                NotificationChannel.class.getMethod("setChannelType", Integer.TYPE).invoke(obj, Integer.valueOf(i10));
            } catch (Exception e10) {
                AbstractC10896a.m65886e("BaseNotificationHelper", "setNotificationChannelType catch Exception " + e10.getMessage());
            }
        }
    }

    /* renamed from: c */
    public static void m1128c(Class cls, Object obj, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1253f1()) {
            try {
                cls.getMethod("setChannelType", Integer.TYPE).invoke(obj, Integer.valueOf(i10));
            } catch (Exception e10) {
                AbstractC10896a.m65886e("BaseNotificationHelper", "setNotificationClassChannelType catch Exception " + e10.getMessage());
            }
        }
    }
}
