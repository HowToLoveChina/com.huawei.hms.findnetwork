package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.huawei.hms.network.embedded.u1 */
/* loaded from: classes8.dex */
public class C6108u1 {

    /* renamed from: a */
    public static final String f28462a = "HttpHeadersUtils";
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");

    /* renamed from: b */
    public static final ThreadLocal<DateFormat> f28463b = new a();

    /* renamed from: c */
    public static final ThreadLocal<DateFormat> f28464c = new b();

    /* renamed from: com.huawei.hms.network.embedded.u1$a */
    public class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C6108u1.UTC);
            return simpleDateFormat;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.u1$b */
    public class b extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    }

    public static Date parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        DateFormat dateFormat = f28463b.get();
        if (dateFormat == null) {
            Logger.m32145w(f28462a, "dateFormat == null");
            return null;
        }
        Date date = dateFormat.parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        return null;
    }

    public static String parseCurrentUTCTime() {
        return f28464c.get().format(new Date());
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000b A[PHI: r0
  0x000b: PHI (r0v2 long) = (r0v0 long), (r0v1 long) binds: [B:4:0x0009, B:7:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int parseSeconds(java.lang.String r3, int r4) throws java.lang.NumberFormatException {
        /*
            long r3 = java.lang.Long.parseLong(r3)     // Catch: java.lang.NumberFormatException -> L16
            r0 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 <= 0) goto Ld
        Lb:
            r3 = r0
            goto L14
        Ld:
            r0 = 0
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 >= 0) goto L14
            goto Lb
        L14:
            int r3 = (int) r3
            return r3
        L16:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6108u1.parseSeconds(java.lang.String, int):int");
    }

    public static int skipUntil(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    public static int skipWhitespace(String str, int i10) {
        for (int i11 = i10; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i11;
            }
        }
        return i10;
    }

    public static int stringToInteger(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            Logger.m32146w(f28462a, "String to Integer catch NumberFormatException.", e10);
            return i10;
        }
    }

    public static long stringToLong(String str, long j10) {
        if (str == null) {
            return j10;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e10) {
            Logger.m32146w(f28462a, "String to Long catch NumberFormatException.", e10);
            return j10;
        }
    }
}
