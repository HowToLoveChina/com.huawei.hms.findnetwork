package com.huawei.cloud.base.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.cloud.base.util.l */
/* loaded from: classes.dex */
public final class C4644l implements Serializable {

    /* renamed from: d */
    public static final TimeZone f21315d = TimeZone.getTimeZone("GMT");

    /* renamed from: e */
    public static final Pattern f21316e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final long f21317a;

    /* renamed from: b */
    public final boolean f21318b;

    /* renamed from: c */
    public final int f21319c;

    public C4644l(Date date, TimeZone timeZone) {
        this(false, date.getTime(), timeZone == null ? null : Integer.valueOf(timeZone.getOffset(date.getTime()) / 60000));
    }

    /* renamed from: b */
    public static void m28456b(StringBuilder sb2, int i10, int i11) {
        if (i10 < 0) {
            sb2.append('-');
            i10 = -i10;
        }
        int i12 = i10;
        while (i12 > 0) {
            i12 /= 10;
            i11--;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            sb2.append('0');
        }
        if (i10 != 0) {
            sb2.append(i10);
        }
    }

    /* renamed from: d */
    public static C4644l m28457d(String str) throws NumberFormatException {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        Integer numValueOf;
        int i14;
        Matcher matcher = f21316e.matcher(str);
        if (!matcher.matches()) {
            throw new NumberFormatException("Invalid date/time format: " + str);
        }
        int i15 = Integer.parseInt(matcher.group(1));
        int i16 = Integer.parseInt(matcher.group(2)) - 1;
        int i17 = Integer.parseInt(matcher.group(3));
        boolean z11 = matcher.group(4) != null;
        String strGroup = matcher.group(9);
        boolean z12 = strGroup != null;
        if (z12 && !z11) {
            throw new NumberFormatException("Invalid date/time format, cannot specify time zone shift without specifying time: " + str);
        }
        if (z11) {
            int i18 = Integer.parseInt(matcher.group(5));
            int i19 = Integer.parseInt(matcher.group(6));
            int i20 = Integer.parseInt(matcher.group(7));
            if (matcher.group(8) != null) {
                z10 = z11;
                i10 = (int) (Integer.parseInt(matcher.group(8).substring(1)) / Math.pow(10.0d, matcher.group(8).substring(1).length() - 3));
                i12 = i19;
                i13 = i20;
            } else {
                z10 = z11;
                i12 = i19;
                i13 = i20;
                i10 = 0;
            }
            i11 = i18;
        } else {
            z10 = z11;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f21315d);
        gregorianCalendar.set(i15, i16, i17, i11, i12, i13);
        gregorianCalendar.set(14, i10);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (z10 && z12) {
            if (Character.toUpperCase(strGroup.charAt(0)) == 'Z') {
                i14 = 0;
            } else {
                int i21 = (Integer.parseInt(matcher.group(11)) * 60) + Integer.parseInt(matcher.group(12));
                if (matcher.group(10).charAt(0) == '-') {
                    i21 = -i21;
                }
                i14 = i21;
                timeInMillis -= i14 * 60000;
            }
            numValueOf = Integer.valueOf(i14);
        } else {
            numValueOf = null;
        }
        return new C4644l(true ^ z10, timeInMillis, numValueOf);
    }

    /* renamed from: c */
    public long m28458c() {
        return this.f21317a;
    }

    /* renamed from: e */
    public String m28459e() {
        StringBuilder sb2 = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f21315d);
        gregorianCalendar.setTimeInMillis(this.f21317a + (this.f21319c * 60000));
        m28456b(sb2, gregorianCalendar.get(1), 4);
        sb2.append('-');
        m28456b(sb2, gregorianCalendar.get(2) + 1, 2);
        sb2.append('-');
        m28456b(sb2, gregorianCalendar.get(5), 2);
        if (!this.f21318b) {
            sb2.append('T');
            m28456b(sb2, gregorianCalendar.get(11), 2);
            sb2.append(':');
            m28456b(sb2, gregorianCalendar.get(12), 2);
            sb2.append(':');
            m28456b(sb2, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb2.append('.');
                m28456b(sb2, gregorianCalendar.get(14), 3);
            }
            int i10 = this.f21319c;
            if (i10 == 0) {
                sb2.append('Z');
            } else {
                if (i10 > 0) {
                    sb2.append('+');
                } else {
                    sb2.append('-');
                    i10 = -i10;
                }
                m28456b(sb2, i10 / 60, 2);
                sb2.append(':');
                m28456b(sb2, i10 % 60, 2);
            }
        }
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4644l)) {
            return false;
        }
        C4644l c4644l = (C4644l) obj;
        return this.f21318b == c4644l.f21318b && this.f21317a == c4644l.f21317a && this.f21319c == c4644l.f21319c;
    }

    public int hashCode() {
        long[] jArr = new long[3];
        jArr[0] = this.f21317a;
        jArr[1] = this.f21318b ? 1L : 0L;
        jArr[2] = this.f21319c;
        return Arrays.hashCode(jArr);
    }

    public String toString() {
        return m28459e();
    }

    public C4644l(long j10) {
        this(false, j10, null);
    }

    public C4644l(Date date) {
        this(date.getTime());
    }

    public C4644l(boolean z10, long j10, Integer num) {
        int offset;
        this.f21318b = z10;
        this.f21317a = j10;
        if (z10) {
            offset = 0;
        } else {
            offset = num == null ? TimeZone.getDefault().getOffset(j10) / 60000 : num.intValue();
        }
        this.f21319c = offset;
    }

    public C4644l(String str) throws NumberFormatException {
        C4644l c4644lM28457d = m28457d(str);
        this.f21318b = c4644lM28457d.f21318b;
        this.f21317a = c4644lM28457d.f21317a;
        this.f21319c = c4644lM28457d.f21319c;
    }
}
