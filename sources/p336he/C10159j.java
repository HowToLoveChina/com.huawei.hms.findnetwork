package p336he;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.huawei.hicloud.sync.R$plurals;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.network.embedded.C5863b6;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import p015ak.C0213f;
import p015ak.C0234s;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12312h0;

/* renamed from: he.j */
/* loaded from: classes3.dex */
public class C10159j {
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m63325a(android.content.Context r10, long r11, int r13) {
        /*
            java.lang.String r0 = "NotePadDateUtils"
            boolean r1 = p015ak.C0209d.m1277l1()     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            if (r1 == 0) goto Lf
            java.lang.String r1 = "com.hihonor.android.text.format.DateUtilsEx"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            goto L15
        Lf:
            java.lang.String r1 = "com.huawei.android.text.format.DateUtilsEx"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
        L15:
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.String r3 = "formatChinaDateTime"
            r4 = 3
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            r8 = 1
            r5[r8] = r6     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            r9 = 2
            r5[r9] = r6     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r7] = r10     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r8] = r4     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r9] = r4     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.IllegalArgumentException -> L4c java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L58 java.lang.InstantiationException -> L5e java.lang.NoSuchMethodException -> L64 java.lang.ClassNotFoundException -> L6a
            goto L70
        L4c:
            java.lang.String r1 = "formatDateTime , IllegalArgumentException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L52:
            java.lang.String r1 = "formatDateTime , InvocationTargetException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L58:
            java.lang.String r1 = "formatDateTime , IllegalAccessException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L5e:
            java.lang.String r1 = "formatDateTime , InstantiationException"
            p514o9.C11839m.m70687e(r0, r1)
            goto L6f
        L64:
            java.lang.String r1 = "formatDateTime , NoSuchMethodException"
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
        throw new UnsupportedOperationException("Method not decompiled: p336he.C10159j.m63325a(android.content.Context, long, int):java.lang.String");
    }

    /* renamed from: b */
    public static String m63326b(String str, Context context) {
        if (!"0".equals(str)) {
            try {
                return DateUtils.formatDateTime(context, Long.parseLong(str), C11842p.m70824j());
            } catch (Exception unused) {
                C11839m.m70689w("TimeFormatUtil", "formatMoreDateTime stringTime format error,have old data: ");
            }
        }
        return "";
    }

    /* renamed from: c */
    public static String m63327c(Context context, long j10) throws Resources.NotFoundException {
        Date date = new Date(j10);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM63333i = j10 - m63333i();
        long jM63332h = j10 - (m63332h() - 86400000);
        long jM63332h2 = j10 - m63332h();
        long j11 = jCurrentTimeMillis - j10;
        if (jM63333i <= 0 || jM63333i >= m63338n()) {
            return context.getString(R$string.time_updated_on, m63334j(date));
        }
        if (jM63332h <= 0 || jM63332h >= 172800000) {
            return context.getString(R$string.time_updated_on, m63334j(date));
        }
        if (jM63332h2 <= 0 || jM63332h2 >= 86400000) {
            return context.getString(R$string.time_updated, context.getString(R$string.main_yesterday));
        }
        if (j11 <= 0 || j11 >= C5863b6.g.f26453g) {
            return context.getString(R$string.time_updated, m63337m(context, date));
        }
        if (j11 < 60000) {
            return context.getString(R$string.just_updated);
        }
        int i10 = (int) (j11 / 60000);
        return context.getString(R$string.time_updated, context.getResources().getQuantityString(R$plurals.minutes_ago1, i10, Integer.valueOf(i10)));
    }

    /* renamed from: d */
    public static String m63328d(long j10) {
        Date date = new Date(j10);
        if (m63339o()) {
            return (String) DateFormat.format("yyyy/M/d kk:mm", date);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return m63325a(C0213f.m1377a(), calendar.getTimeInMillis(), C11842p.m70832l());
    }

    /* renamed from: e */
    public static String m63329e(long j10) {
        try {
            Instant instantOfEpochSecond = Instant.ofEpochSecond(j10);
            ZoneOffset zoneOffset = ZoneOffset.UTC;
            return instantOfEpochSecond.atZone(zoneOffset).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(zoneOffset));
        } catch (Exception e10) {
            C11839m.m70687e("TimeFormatUtil", "formatTimes exception: " + e10.getMessage());
            return String.valueOf(j10);
        }
    }

    /* renamed from: f */
    public static String m63330f(Context context, long j10, boolean z10) {
        Date date = new Date(j10);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM63333i = j10 - m63333i();
        long jM63332h = j10 - (m63332h() - 86400000);
        long jM63332h2 = j10 - m63332h();
        long j11 = jCurrentTimeMillis - j10;
        if (jM63333i <= 0 || jM63333i >= m63338n()) {
            return m63334j(date);
        }
        if (jM63332h <= 0 || jM63332h >= 172800000) {
            return m63334j(date);
        }
        if (jM63332h2 <= 0 || jM63332h2 >= 86400000) {
            return context.getString(R$string.main_yesterday);
        }
        if (j11 <= 0 || j11 >= C5863b6.g.f26453g) {
            return m63337m(context, date);
        }
        if (j11 < 60000) {
            return z10 ? context.getString(R$string.just_updated) : context.getString(R$string.just_now);
        }
        int i10 = (int) (j11 / 60000);
        return context.getResources().getQuantityString(R$plurals.minutes_ago1, i10, Integer.valueOf(i10));
    }

    /* renamed from: g */
    public static String m63331g(long j10, String str) {
        if (j10 < 0) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            String str2 = new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j10));
            if (str.indexOf(84) < 0) {
                return str2;
            }
            return str2.substring(0, str2.length() - 2) + ':' + str2.substring(str2.length() - 2);
        } catch (Exception e10) {
            C11839m.m70687e("TimeFormatUtil", "getDateTime exception: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: h */
    public static long m63332h() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    /* renamed from: i */
    public static long m63333i() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    /* renamed from: j */
    public static String m63334j(Date date) {
        if (!m63339o()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return m63325a(C0213f.m1377a(), calendar.getTimeInMillis(), C11842p.m70828k());
        }
        return ((String) DateFormat.format("yyyy/M/d", date)) + " ";
    }

    /* renamed from: k */
    public static long m63335k(long j10) {
        try {
            String strM63331g = m63331g(j10, "yyyy-MM-dd HH:mm:ss");
            String strM63331g2 = m63331g(C12312h0.m74027b().m74028c(), "yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(strM63331g, dateTimeFormatterOfPattern);
            LocalDateTime localDateTime2 = LocalDateTime.parse(strM63331g2, dateTimeFormatterOfPattern);
            C11839m.m70688i("TimeFormatUtil", "getRemainDays delDate: " + localDateTime + ", currentDate: " + localDateTime2);
            if (localDateTime.isBefore(localDateTime2)) {
                return -1L;
            }
            return ChronoUnit.DAYS.between(localDateTime2.toLocalDate(), localDateTime.toLocalDate());
        } catch (Exception e10) {
            C11839m.m70687e("TimeFormatUtil", "getRemainDays exception: " + e10.getMessage());
            return -1L;
        }
    }

    /* renamed from: l */
    public static String m63336l(String str, String str2, String str3) throws ParseException {
        try {
            Date date = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.getDefault());
            if (date != null) {
                return simpleDateFormat.format(date);
            }
        } catch (Exception e10) {
            C11839m.m70687e("TimeFormatUtil", e10.getMessage());
        }
        return str;
    }

    /* renamed from: m */
    public static String m63337m(Context context, Date date) {
        if (DateFormat.is24HourFormat(context)) {
            return ((String) DateFormat.format("kk:mm", date)) + " ";
        }
        if (!m63339o()) {
            return (String) DateFormat.format("h:mm a", date);
        }
        return ((String) DateFormat.format("a h:mm", date)) + " ";
    }

    /* renamed from: n */
    public static long m63338n() {
        Calendar.getInstance().setTime(new Date());
        return r0.getActualMaximum(6) * 86400000;
    }

    /* renamed from: o */
    public static boolean m63339o() {
        return C0234s.m1636n().equalsIgnoreCase("zh");
    }
}
