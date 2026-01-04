package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.C10082f;
import p354i1.AbstractC10388b;
import p354i1.InterfaceC10408t;
import p481n1.C11595g;
import p481n1.C11603o;

/* renamed from: j1.w */
/* loaded from: classes.dex */
public class C10691w extends AbstractC10388b implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10691w f51326a = new C10691w();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 2;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        char[] charArray;
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65222a0();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == Date.class && !c10650d1.m65237w(EnumC10653e1.WriteDateUseDateFormat)) {
            if ((((Date) obj).getTime() + c10664i0.f51266s.getOffset(r7)) % 86400000 == 0 && !EnumC10653e1.m65241e(c10650d1.f51197c, i10, EnumC10653e1.WriteClassName)) {
                c10650d1.m65228g0(obj.toString());
                return;
            }
        }
        if (cls == Time.class) {
            long time = ((Time) obj).getTime();
            if ("unixtime".equals(c10664i0.m65274v())) {
                c10650d1.m65221Z(time / 1000);
                return;
            } else if ("millis".equals(c10664i0.m65274v())) {
                c10650d1.m65221Z(time);
                return;
            } else if (time < 86400000) {
                c10650d1.m65228g0(obj.toString());
                return;
            }
        }
        int nanos = cls == Timestamp.class ? ((Timestamp) obj).getNanos() : 0;
        java.util.Date dateM69310o = obj instanceof java.util.Date ? (java.util.Date) obj : C11603o.m69310o(obj);
        if ("unixtime".equals(c10664i0.m65274v())) {
            c10650d1.m65221Z(dateM69310o.getTime() / 1000);
            return;
        }
        if ("millis".equals(c10664i0.m65274v())) {
            c10650d1.m65221Z(dateM69310o.getTime());
            return;
        }
        if (c10650d1.m65237w(EnumC10653e1.WriteDateUseDateFormat)) {
            DateFormat dateFormatM65273u = c10664i0.m65273u();
            if (dateFormatM65273u == null) {
                String strM65275w = c10664i0.m65275w();
                if (strM65275w == null) {
                    strM65275w = AbstractC9377a.f46782e;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strM65275w, c10664i0.f51267t);
                simpleDateFormat.setTimeZone(c10664i0.f51266s);
                dateFormatM65273u = simpleDateFormat;
            }
            c10650d1.m65228g0(dateFormatM65273u.format(dateM69310o));
            return;
        }
        if (c10650d1.m65237w(EnumC10653e1.WriteClassName) && cls != type) {
            if (cls == java.util.Date.class) {
                c10650d1.write("new Date(");
                c10650d1.m65221Z(((java.util.Date) obj).getTime());
                c10650d1.write(41);
                return;
            } else {
                c10650d1.write(123);
                c10650d1.m65209B(AbstractC9377a.f46780c);
                c10664i0.m65263H(cls.getName());
                c10650d1.m65213F(',', "val", ((java.util.Date) obj).getTime());
                c10650d1.write(125);
                return;
            }
        }
        long time2 = dateM69310o.getTime();
        if (!c10650d1.m65237w(EnumC10653e1.UseISO8601DateFormat)) {
            c10650d1.m65221Z(time2);
            return;
        }
        int i11 = c10650d1.m65237w(EnumC10653e1.UseSingleQuotes) ? 39 : 34;
        c10650d1.write(i11);
        Calendar calendar = Calendar.getInstance(c10664i0.f51266s, c10664i0.f51267t);
        calendar.setTimeInMillis(time2);
        int i12 = calendar.get(1);
        int i13 = calendar.get(2) + 1;
        int i14 = calendar.get(5);
        int i15 = calendar.get(11);
        int i16 = calendar.get(12);
        int i17 = calendar.get(13);
        int i18 = calendar.get(14);
        if (nanos > 0) {
            charArray = "0000-00-00 00:00:00.000000000".toCharArray();
            C11595g.m69211f(nanos, 29, charArray);
            C11595g.m69211f(i17, 19, charArray);
            C11595g.m69211f(i16, 16, charArray);
            C11595g.m69211f(i15, 13, charArray);
            C11595g.m69211f(i14, 10, charArray);
            C11595g.m69211f(i13, 7, charArray);
            C11595g.m69211f(i12, 4, charArray);
        } else if (i18 != 0) {
            char[] charArray2 = "0000-00-00T00:00:00.000".toCharArray();
            C11595g.m69211f(i18, 23, charArray2);
            C11595g.m69211f(i17, 19, charArray2);
            C11595g.m69211f(i16, 16, charArray2);
            C11595g.m69211f(i15, 13, charArray2);
            C11595g.m69211f(i14, 10, charArray2);
            C11595g.m69211f(i13, 7, charArray2);
            C11595g.m69211f(i12, 4, charArray2);
            charArray = charArray2;
        } else if (i17 == 0 && i16 == 0 && i15 == 0) {
            char[] charArray3 = "0000-00-00".toCharArray();
            C11595g.m69211f(i14, 10, charArray3);
            C11595g.m69211f(i13, 7, charArray3);
            C11595g.m69211f(i12, 4, charArray3);
            charArray = charArray3;
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            C11595g.m69211f(i17, 19, charArray);
            C11595g.m69211f(i16, 16, charArray);
            C11595g.m69211f(i15, 13, charArray);
            C11595g.m69211f(i14, 10, charArray);
            C11595g.m69211f(i13, 7, charArray);
            C11595g.m69211f(i12, 4, charArray);
        }
        if (nanos > 0) {
            int i19 = 0;
            while (i19 < 9 && charArray[(charArray.length - i19) - 1] == '0') {
                i19++;
            }
            c10650d1.write(charArray, 0, charArray.length - i19);
            c10650d1.write(i11);
            return;
        }
        c10650d1.write(charArray);
        float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
        int i20 = (int) offset;
        if (i20 == 0.0d) {
            c10650d1.write(90);
        } else {
            if (i20 > 9) {
                c10650d1.write(43);
                c10650d1.m65219X(i20);
            } else if (i20 > 0) {
                c10650d1.write(43);
                c10650d1.write(48);
                c10650d1.m65219X(i20);
            } else if (i20 < -9) {
                c10650d1.write(45);
                c10650d1.m65219X(-i20);
            } else if (i20 < 0) {
                c10650d1.write(45);
                c10650d1.write(48);
                c10650d1.m65219X(-i20);
            }
            c10650d1.write(58);
            c10650d1.append(String.format("%02d", Integer.valueOf((int) (Math.abs(offset - i20) * 60.0f))));
        }
        c10650d1.write(i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r4v15, types: [T, java.util.Calendar] */
    @Override // p354i1.AbstractC10388b
    /* renamed from: g */
    public <T> T mo63894g(C10077a c10077a, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof java.util.Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new java.util.Date(C11603o.m69248D0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new java.util.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new C9380d("parse error");
        }
        String strSubstring = (String) obj2;
        if (strSubstring.length() == 0) {
            return null;
        }
        if (strSubstring.length() == 23 && strSubstring.endsWith(" 000")) {
            strSubstring = strSubstring.substring(0, 19);
        }
        C10082f c10082f = new C10082f(strSubstring);
        try {
            if (c10082f.m62838u1(false)) {
                ?? r42 = (T) c10082f.m62795G0();
                return type == Calendar.class ? r42 : (T) r42.getTime();
            }
            c10082f.close();
            String strM62741u = c10077a.m62741u();
            if (strSubstring.length() == strM62741u.length() || ((strSubstring.length() == 22 && strM62741u.equals("yyyyMMddHHmmssSSSZ")) || (strSubstring.indexOf(84) != -1 && strM62741u.contains("'T'") && strSubstring.length() + 2 == strM62741u.length()))) {
                try {
                    return (T) c10077a.m62743v().parse(strSubstring);
                } catch (ParseException unused) {
                }
            }
            if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
            }
            if ("0000-00-00".equals(strSubstring) || "0000-00-00T00:00:00".equalsIgnoreCase(strSubstring) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(strSubstring)) {
                return null;
            }
            int iLastIndexOf = strSubstring.lastIndexOf(124);
            if (iLastIndexOf > 20) {
                TimeZone timeZone = TimeZone.getTimeZone(strSubstring.substring(iLastIndexOf + 1));
                if (!"GMT".equals(timeZone.getID())) {
                    C10082f c10082f2 = new C10082f(strSubstring.substring(0, iLastIndexOf));
                    try {
                        if (c10082f2.m62838u1(false)) {
                            ?? r43 = (T) c10082f2.m62795G0();
                            r43.setTimeZone(timeZone);
                            return type == Calendar.class ? r43 : (T) r43.getTime();
                        }
                    } finally {
                    }
                }
            }
            return (T) new java.util.Date(Long.parseLong(strSubstring));
        } finally {
        }
    }
}
