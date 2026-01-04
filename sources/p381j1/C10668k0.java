package p381j1;

import com.baidu.location.p065a.C1529a;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import p244e1.AbstractC9377a;
import p244e1.C9381e;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.k0 */
/* loaded from: classes.dex */
public class C10668k0 implements InterfaceC10686t0, InterfaceC10687u, InterfaceC10408t {

    /* renamed from: a */
    public static final C10668k0 f51279a = new C10668k0();

    /* renamed from: b */
    public static final DateTimeFormatter f51280b = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c */
    public static final DateTimeFormatter f51281c = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: d */
    public static final DateTimeFormatter f51282d = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");

    /* renamed from: e */
    public static final DateTimeFormatter f51283e = DateTimeFormat.forPattern("yyyy年M月d日 HH:mm:ss");

    /* renamed from: f */
    public static final DateTimeFormatter f51284f = DateTimeFormat.forPattern("yyyy年M月d日 H时m分s秒");

    /* renamed from: g */
    public static final DateTimeFormatter f51285g = DateTimeFormat.forPattern("yyyy년M월d일 HH:mm:ss");

    /* renamed from: h */
    public static final DateTimeFormatter f51286h = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

    /* renamed from: i */
    public static final DateTimeFormatter f51287i = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    /* renamed from: j */
    public static final DateTimeFormatter f51288j = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");

    /* renamed from: k */
    public static final DateTimeFormatter f51289k = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");

    /* renamed from: l */
    public static final DateTimeFormatter f51290l = DateTimeFormat.forPattern(C1529a.f6579e);

    /* renamed from: m */
    public static final DateTimeFormatter f51291m = DateTimeFormat.forPattern("yyyy/MM/dd");

    /* renamed from: n */
    public static final DateTimeFormatter f51292n = DateTimeFormat.forPattern("yyyy年M月d日");

    /* renamed from: o */
    public static final DateTimeFormatter f51293o = DateTimeFormat.forPattern("yyyy년M월d일");

    /* renamed from: p */
    public static final DateTimeFormatter f51294p = DateTimeFormat.forPattern(HwConstants.DATE_FORMAT);

    /* renamed from: q */
    public static final DateTimeFormatter f51295q = DateTimeFormat.forPattern("dd/MM/yyyy");

    /* renamed from: r */
    public static final DateTimeFormatter f51296r = DateTimeFormat.forPattern("dd.MM.yyyy");

    /* renamed from: s */
    public static final DateTimeFormatter f51297s = DateTimeFormat.forPattern("dd-MM-yyyy");

    /* renamed from: t */
    public static final DateTimeFormatter f51298t = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.getDefault());

    /* renamed from: u */
    public static final DateTimeFormatter f51299u = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        return (T) m65300f(c10077a, type, obj, null, 0);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 4;
    }

    @Override // p381j1.InterfaceC10687u
    /* renamed from: d */
    public void mo63932d(C10664i0 c10664i0, Object obj, C10665j c10665j) throws IOException {
        m65304j(c10664i0.f51258k, (ReadablePartial) obj, c10665j.m65280b());
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65222a0();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != LocalDateTime.class) {
            c10650d1.m65228g0(obj.toString());
            return;
        }
        EnumC10653e1 enumC10653e1 = EnumC10653e1.UseISO8601DateFormat;
        int iM65244b = enumC10653e1.m65244b();
        LocalDateTime localDateTime = (LocalDateTime) obj;
        String strM65274v = c10664i0.m65274v();
        if (strM65274v == null) {
            strM65274v = ((i10 & iM65244b) != 0 || c10664i0.m65256A(enumC10653e1)) ? "yyyy-MM-dd'T'HH:mm:ss" : c10664i0.m65256A(EnumC10653e1.WriteDateUseDateFormat) ? AbstractC9377a.f46782e : localDateTime.getMillisOfSecond() == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
        }
        if (strM65274v != null) {
            m65304j(c10650d1, localDateTime, strM65274v);
        } else {
            c10650d1.m65221Z(localDateTime.toDateTime(DateTimeZone.forTimeZone(AbstractC9377a.f46778a)).toInstant().getMillis());
        }
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, org.joda.time.LocalDateTime] */
    /* renamed from: f */
    public <T> T m65300f(C10077a c10077a, Type type, Object obj, String str, int i10) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 8) {
            interfaceC10079c.mo62790z();
            return null;
        }
        if (interfaceC10079c.mo62768a0() == 4) {
            String strMo62763J = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62790z();
            DateTimeFormatter dateTimeFormatterForPattern = str != null ? "yyyy-MM-dd HH:mm:ss".equals(str) ? f51280b : DateTimeFormat.forPattern(str) : null;
            if ("".equals(strMo62763J)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                return (strMo62763J.length() == 10 || strMo62763J.length() == 8) ? (T) m65302h(strMo62763J, str, dateTimeFormatterForPattern).toLocalDateTime(LocalTime.MIDNIGHT) : (T) m65301g(strMo62763J, dateTimeFormatterForPattern);
            }
            if (type == LocalDate.class) {
                return strMo62763J.length() == 23 ? (T) LocalDateTime.parse(strMo62763J).toLocalDate() : (T) m65302h(strMo62763J, str, dateTimeFormatterForPattern);
            }
            if (type == LocalTime.class) {
                return strMo62763J.length() == 23 ? (T) LocalDateTime.parse(strMo62763J).toLocalTime() : (T) LocalTime.parse(strMo62763J);
            }
            if (type == DateTime.class) {
                if (dateTimeFormatterForPattern == f51280b) {
                    dateTimeFormatterForPattern = f51298t;
                }
                return (T) m65303i(strMo62763J, dateTimeFormatterForPattern);
            }
            if (type == DateTimeZone.class) {
                return (T) DateTimeZone.forID(strMo62763J);
            }
            if (type == Period.class) {
                return (T) Period.parse(strMo62763J);
            }
            if (type == Duration.class) {
                return (T) Duration.parse(strMo62763J);
            }
            if (type == Instant.class) {
                int i11 = 0;
                while (true) {
                    if (i11 < strMo62763J.length()) {
                        char cCharAt = strMo62763J.charAt(i11);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i11++;
                    } else if (strMo62763J.length() > 8 && strMo62763J.length() < 19) {
                        return (T) new Instant(Long.parseLong(strMo62763J));
                    }
                }
                return (T) Instant.parse(strMo62763J);
            }
            if (type == DateTimeFormatter.class) {
                return (T) DateTimeFormat.forPattern(strMo62763J);
            }
        } else {
            if (interfaceC10079c.mo62768a0() == 2) {
                long jMo62783u = interfaceC10079c.mo62783u();
                interfaceC10079c.mo62790z();
                TimeZone timeZone = AbstractC9377a.f46778a;
                if (timeZone == null) {
                    timeZone = TimeZone.getDefault();
                }
                if (type == DateTime.class) {
                    return (T) new DateTime(jMo62783u, DateTimeZone.forTimeZone(timeZone));
                }
                ?? r72 = (T) new LocalDateTime(jMo62783u, DateTimeZone.forTimeZone(timeZone));
                if (type == LocalDateTime.class) {
                    return r72;
                }
                if (type == LocalDate.class) {
                    return (T) r72.toLocalDate();
                }
                if (type == LocalTime.class) {
                    return (T) r72.toLocalTime();
                }
                if (type == Instant.class) {
                    return (T) new Instant(jMo62783u);
                }
                throw new UnsupportedOperationException();
            }
            if (interfaceC10079c.mo62768a0() != 12) {
                throw new UnsupportedOperationException();
            }
            C9381e c9381eM62720a0 = c10077a.m62720a0();
            if (type == Instant.class) {
                Object obj2 = c9381eM62720a0.get("epochSecond");
                if (obj2 instanceof Number) {
                    return (T) Instant.ofEpochSecond(C11603o.m69246C0((Number) obj2));
                }
                Object obj3 = c9381eM62720a0.get("millis");
                if (obj3 instanceof Number) {
                    return (T) Instant.ofEpochMilli(C11603o.m69246C0((Number) obj3));
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0128 A[SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.joda.time.LocalDateTime m65301g(java.lang.String r17, org.joda.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10668k0.m65301g(java.lang.String, org.joda.time.format.DateTimeFormatter):org.joda.time.LocalDateTime");
    }

    /* renamed from: h */
    public LocalDate m65302h(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f51290l;
            }
            int i10 = 0;
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f51291m;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i11 = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = f51295q;
                    } else if (i11 > 12) {
                        dateTimeFormatter3 = f51294p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f51294p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f51295q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = f51296r;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = f51297s;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = f51292n;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = f51293o;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i10 < str.length()) {
                    char cCharAt9 = str.charAt(i10);
                    if (cCharAt9 < '0' || cCharAt9 > '9') {
                        break;
                    }
                    i10++;
                } else if (str.length() > 8 && str.length() < 19) {
                    return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(AbstractC9377a.f46778a)).toLocalDate();
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    /* renamed from: i */
    public DateTime m65303i(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 == ':' && cCharAt5 == ':') {
                    if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = f51299u;
                        } else if (cCharAt3 == ' ') {
                            dateTimeFormatter = f51280b;
                        }
                    } else if (cCharAt == '/' && cCharAt2 == '/') {
                        dateTimeFormatter = f51282d;
                    } else {
                        char cCharAt6 = str.charAt(0);
                        char cCharAt7 = str.charAt(1);
                        char cCharAt8 = str.charAt(2);
                        char cCharAt9 = str.charAt(3);
                        char cCharAt10 = str.charAt(5);
                        if (cCharAt8 == '/' && cCharAt10 == '/') {
                            int i10 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                            if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                                dateTimeFormatter = f51287i;
                            } else if (i10 > 12) {
                                dateTimeFormatter = f51286h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f51286h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f51287i;
                                }
                            }
                        } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                            dateTimeFormatter = f51288j;
                        } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                            dateTimeFormatter = f51289k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? f51284f : f51283e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter = f51285g;
                }
            }
        }
        return dateTimeFormatter == null ? DateTime.parse(str) : DateTime.parse(str, dateTimeFormatter);
    }

    /* renamed from: j */
    public final void m65304j(C10650d1 c10650d1, ReadablePartial readablePartial, String str) {
        c10650d1.m65228g0((str.equals("yyyy-MM-dd'T'HH:mm:ss") ? f51299u : DateTimeFormat.forPattern(str)).print(readablePartial));
    }
}
