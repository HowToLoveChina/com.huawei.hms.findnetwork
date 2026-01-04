package p354i1;

import com.baidu.location.p065a.C1529a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import p244e1.AbstractC9377a;
import p381j1.C10650d1;
import p381j1.C10664i0;
import p381j1.C10665j;
import p381j1.EnumC10653e1;
import p381j1.InterfaceC10686t0;
import p381j1.InterfaceC10687u;

/* renamed from: i1.q */
/* loaded from: classes.dex */
public class C10405q extends AbstractC10393e implements InterfaceC10686t0, InterfaceC10687u, InterfaceC10408t {

    /* renamed from: a */
    public static final C10405q f50212a = new C10405q();

    /* renamed from: b */
    public static final DateTimeFormatter f50213b = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c */
    public static final DateTimeFormatter f50214c = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: d */
    public static final DateTimeFormatter f50215d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /* renamed from: e */
    public static final DateTimeFormatter f50216e = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");

    /* renamed from: f */
    public static final DateTimeFormatter f50217f = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");

    /* renamed from: g */
    public static final DateTimeFormatter f50218g = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");

    /* renamed from: h */
    public static final DateTimeFormatter f50219h = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /* renamed from: i */
    public static final DateTimeFormatter f50220i = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /* renamed from: j */
    public static final DateTimeFormatter f50221j = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    /* renamed from: k */
    public static final DateTimeFormatter f50222k = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /* renamed from: l */
    public static final DateTimeFormatter f50223l = DateTimeFormatter.ofPattern(C1529a.f6579e);

    /* renamed from: m */
    public static final DateTimeFormatter f50224m = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /* renamed from: n */
    public static final DateTimeFormatter f50225n = DateTimeFormatter.ofPattern("yyyy年M月d日");

    /* renamed from: o */
    public static final DateTimeFormatter f50226o = DateTimeFormatter.ofPattern("yyyy년M월d일");

    /* renamed from: p */
    public static final DateTimeFormatter f50227p = DateTimeFormatter.ofPattern(HwConstants.DATE_FORMAT);

    /* renamed from: q */
    public static final DateTimeFormatter f50228q = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* renamed from: r */
    public static final DateTimeFormatter f50229r = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /* renamed from: s */
    public static final DateTimeFormatter f50230s = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /* renamed from: t */
    public static final DateTimeFormatter f50231t = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    /* renamed from: u */
    public static final DateTimeFormatter f50232u = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    /* renamed from: g */
    public static Object m63931g(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return LocalDateTime.parse(obj.toString(), DateTimeFormatter.ofPattern(str));
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 4;
    }

    @Override // p381j1.InterfaceC10687u
    /* renamed from: d */
    public void mo63932d(C10664i0 c10664i0, Object obj, C10665j c10665j) throws IOException {
        m63937k(c10664i0.f51258k, (TemporalAccessor) obj, c10665j.m65280b());
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
            strM65274v = "yyyy-MM-dd'T'HH:mm:ss";
            if ((i10 & iM65244b) == 0 && !c10664i0.m65256A(enumC10653e1)) {
                if (c10664i0.m65256A(EnumC10653e1.WriteDateUseDateFormat)) {
                    strM65274v = (c10664i0.m65275w() == null || c10664i0.m65275w().length() <= 0) ? AbstractC9377a.f46782e : c10664i0.m65275w();
                } else {
                    int nano = localDateTime.getNano();
                    if (nano != 0) {
                        strM65274v = nano % Constants.MILLON == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
                    }
                }
            }
        }
        if (strM65274v != null) {
            m63937k(c10650d1, localDateTime, strM65274v);
        } else {
            c10650d1.m65221Z(localDateTime.atZone(AbstractC9377a.f46778a.toZoneId()).toInstant().toEpochMilli());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:276:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x01fb  */
    @Override // p354i1.AbstractC10393e
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T mo63893f(p323h1.C10077a r18, java.lang.reflect.Type r19, java.lang.Object r20, java.lang.String r21, int r22) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10405q.mo63893f(h1.a, java.lang.reflect.Type, java.lang.Object, java.lang.String, int):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00f2  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.time.LocalDateTime m63934h(java.lang.String r17, java.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10405q.m63934h(java.lang.String, java.time.format.DateTimeFormatter):java.time.LocalDateTime");
    }

    /* renamed from: i */
    public LocalDate m63935i(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f50223l;
            }
            int i10 = 0;
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f50224m;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i11 = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = f50228q;
                    } else if (i11 > 12) {
                        dateTimeFormatter3 = f50227p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f50227p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f50228q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = f50229r;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = f50230s;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = f50225n;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = f50226o;
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
                    return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), AbstractC9377a.f46778a.toZoneId()).toLocalDate();
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    /* renamed from: j */
    public ZonedDateTime m63936j(String str, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            int i10 = 0;
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 == ':' && cCharAt5 == ':') {
                    if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (cCharAt3 == ' ') {
                            dateTimeFormatter = f50213b;
                        }
                    } else if (cCharAt == '/' && cCharAt2 == '/') {
                        dateTimeFormatter = f50215d;
                    } else {
                        char cCharAt6 = str.charAt(0);
                        char cCharAt7 = str.charAt(1);
                        char cCharAt8 = str.charAt(2);
                        char cCharAt9 = str.charAt(3);
                        char cCharAt10 = str.charAt(5);
                        if (cCharAt8 == '/' && cCharAt10 == '/') {
                            int i11 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                            if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                                dateTimeFormatter = f50220i;
                            } else if (i11 > 12) {
                                dateTimeFormatter = f50219h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f50219h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f50220i;
                                }
                            }
                        } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                            dateTimeFormatter = f50221j;
                        } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                            dateTimeFormatter = f50222k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter2 = str.charAt(str.length() - 1) == 31186 ? f50217f : f50216e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter2 = f50218g;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i10 < str.length()) {
                    char cCharAt12 = str.charAt(i10);
                    if (cCharAt12 < '0' || cCharAt12 > '9') {
                        break;
                    }
                    i10++;
                } else if (str.length() > 8 && str.length() < 19) {
                    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), AbstractC9377a.f46778a.toZoneId());
                }
            }
        }
        return dateTimeFormatter == null ? ZonedDateTime.parse(str) : ZonedDateTime.parse(str, dateTimeFormatter);
    }

    /* renamed from: k */
    public final void m63937k(C10650d1 c10650d1, TemporalAccessor temporalAccessor, String str) {
        if ("unixtime".equals(str)) {
            if (temporalAccessor instanceof ChronoZonedDateTime) {
                c10650d1.m65219X((int) ((ChronoZonedDateTime) temporalAccessor).toEpochSecond());
                return;
            } else if (temporalAccessor instanceof LocalDateTime) {
                c10650d1.m65219X((int) ((LocalDateTime) temporalAccessor).atZone(AbstractC9377a.f46778a.toZoneId()).toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            Instant instant = temporalAccessor instanceof ChronoZonedDateTime ? ((ChronoZonedDateTime) temporalAccessor).toInstant() : temporalAccessor instanceof LocalDateTime ? ((LocalDateTime) temporalAccessor).atZone(AbstractC9377a.f46778a.toZoneId()).toInstant() : null;
            if (instant != null) {
                c10650d1.m65221Z(instant.toEpochMilli());
                return;
            }
        }
        c10650d1.m65228g0((str == "yyyy-MM-dd'T'HH:mm:ss" ? f50232u : DateTimeFormatter.ofPattern(str)).format(temporalAccessor));
    }
}
