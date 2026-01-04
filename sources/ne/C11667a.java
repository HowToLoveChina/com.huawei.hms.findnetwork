package ne;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C5863b6;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import p015ak.C0213f;
import p514o9.C11839m;
import p514o9.C11842p;
import p783xp.C13843a;

/* renamed from: ne.a */
/* loaded from: classes3.dex */
public class C11667a {
    /* renamed from: a */
    public static String m69659a(long j10) {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j10));
        C11839m.m70688i("TimeFormatUtil", "convertTimestampToDateStr,timeStamp is:" + j10 + ",time is:" + str);
        return str;
    }

    /* renamed from: b */
    public static long m69660b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new SimpleDateFormat(str2).parse(str).getTime();
            } catch (ParseException unused) {
                C11839m.m70687e("TimeFormatUtil", "convertToMillis exception");
            }
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m69661c(android.content.Context r10, long r11, int r13) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        /*
            java.lang.String r0 = "NotePadDateUtils"
            boolean r1 = p015ak.C0209d.m1277l1()     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            if (r1 == 0) goto Lf
            java.lang.String r1 = "com.hihonor.android.text.format.DateUtilsEx"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            goto L15
        Lf:
            java.lang.String r1 = "com.huawei.android.text.format.DateUtilsEx"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
        L15:
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.String r3 = "formatChinaDateTime"
            r4 = 3
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r8 = 1
            r5[r8] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r9 = 2
            r5[r9] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r7] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r8] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r9] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            goto L70
        L4c:
            java.lang.String r1 = "formatDateTime , InvocationTargetException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L52:
            java.lang.String r1 = "formatDateTime , IllegalArgumentException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L58:
            java.lang.String r1 = "formatDateTime , IllegalAccessException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L5e:
            java.lang.String r1 = "formatDateTime , NoSuchMethodException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L64:
            java.lang.String r1 = "formatDateTime , InstantiationException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L6a:
            java.lang.String r1 = "formatDateTime , ClassNotFoundException"
            p514o9.C11839m.m70687e(r0, r1)
        L6f:
            r1 = 0
        L70:
            if (r1 != 0) goto L76
            java.lang.String r1 = android.text.format.DateUtils.formatDateTime(r10, r11, r13)
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ne.C11667a.m69661c(android.content.Context, long, int):java.lang.String");
    }

    /* renamed from: d */
    public static String m69662d(Context context, long j10) throws Resources.NotFoundException {
        Date date = new Date(j10);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM69665g = j10 - m69665g();
        long jM69663e = j10 - (m69663e() - 86400000);
        long jM69663e2 = j10 - m69663e();
        long j11 = jCurrentTimeMillis - j10;
        if (jM69665g <= 0 || jM69665g >= m69670l()) {
            return context.getString(R$string.time_updated_on, m69666h(date));
        }
        if (jM69663e <= 0 || jM69663e >= 172800000) {
            return context.getString(R$string.time_updated_on, m69666h(date));
        }
        if (jM69663e2 <= 0 || jM69663e2 >= 86400000) {
            return context.getString(R$string.time_updated, context.getString(R$string.main_yesterday));
        }
        if (j11 <= 0 || j11 >= C5863b6.g.f26453g) {
            return context.getString(R$string.time_updated, C13843a.m83065Q(context, date));
        }
        if (j11 < 60000) {
            return context.getString(R$string.just_updated);
        }
        int i10 = (int) (j11 / 60000);
        return context.getString(R$string.time_updated, context.getResources().getQuantityString(R$plurals.minutes_ago1, i10, Integer.valueOf(i10)));
    }

    /* renamed from: e */
    public static long m69663e() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    /* renamed from: f */
    public static String m69664f(Context context, long j10) {
        long jM69665g = j10 - m69665g();
        return (jM69665g <= 0 || jM69665g >= m69670l()) ? m69661c(context, j10, 65556) : m69661c(context, j10, ARImageMetadata.CONTROL_SCENE_MODE);
    }

    /* renamed from: g */
    public static long m69665g() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    /* renamed from: h */
    public static String m69666h(Date date) {
        if (!C13843a.m83067S()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return m69661c(C0213f.m1377a(), calendar.getTimeInMillis(), C11842p.m70828k());
        }
        return ((String) DateFormat.format("yyyy/M/d", date)) + " ";
    }

    /* renamed from: i */
    public static int m69667i(long j10, long j11) {
        if (j10 >= j11) {
            return 0;
        }
        long j12 = j11 - j10;
        if (j12 < 86400000) {
            return 0;
        }
        double d10 = (j12 * 1.0d) / 8.64E7d;
        return j12 % 86400000 != 0 ? (int) Math.floor(d10) : (int) d10;
    }

    /* renamed from: j */
    public static String m69668j(Long l10, Context context) {
        return m69661c(context, l10 != null ? l10.longValue() : 0L, 65556);
    }

    /* renamed from: k */
    public static String m69669k(Context context, Date date, String str) {
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (DateFormat.is24HourFormat(context)) {
            return m69673o(timeZone, "HH:mm", date) + " ";
        }
        if (!C13843a.m83067S()) {
            return m69673o(timeZone, "h:mm a", date);
        }
        return m69673o(timeZone, "a h:mm", date) + " ";
    }

    /* renamed from: l */
    public static long m69670l() {
        Calendar.getInstance().setTime(new Date());
        return r0.getActualMaximum(6) * 86400000;
    }

    /* renamed from: m */
    public static boolean m69671m(Date date, String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3);
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(str));
            calendar2.setTime(simpleDateFormat.parse(str2));
            calendar3.setTime(simpleDateFormat.parse(simpleDateFormat.format(date)));
            if (calendar3.equals(calendar) || calendar3.after(calendar)) {
                if (calendar3.before(calendar2)) {
                    C11839m.m70688i("TimeFormatUtil", "local time is in time scope:[" + str + "," + str2 + ")");
                    return true;
                }
            }
        } catch (ParseException e10) {
            C11839m.m70687e("TimeFormatUtil", "parseTimeException:" + e10.getMessage());
        }
        C11839m.m70688i("TimeFormatUtil", "local time is not in time scope:[" + str + "," + str2 + ")");
        return false;
    }

    /* renamed from: n */
    public static boolean m69672n(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3);
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            Calendar calendar3 = Calendar.getInstance();
            Calendar calendar4 = Calendar.getInstance();
            calendar3.setTime(simpleDateFormat.parse("00:00"));
            calendar4.setTime(simpleDateFormat.parse("24:00"));
            calendar.setTime(simpleDateFormat.parse(str));
            calendar2.setTime(simpleDateFormat.parse(str2));
            if (calendar.after(calendar2) || calendar.before(calendar3)) {
                return true;
            }
            return calendar2.after(calendar4);
        } catch (Exception e10) {
            C11839m.m70687e("TimeFormatUtil", "parse data error:" + e10.getMessage());
            return true;
        }
    }

    /* renamed from: o */
    public static String m69673o(TimeZone timeZone, String str, Date date) {
        if (timeZone == null || TextUtils.isEmpty(str)) {
            C11839m.m70688i("TimeFormatUtil", "timezone is null or pattern is null");
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }
}
