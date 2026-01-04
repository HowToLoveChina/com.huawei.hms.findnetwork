package com.huawei.uikit.hwlunar.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.huawei.hms.iap.entity.OrderStatusCode;
import com.huawei.uikit.hwlunar.C8717R;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class HwLunarCalendar {

    /* renamed from: A */
    private static final int f42861A = 1;

    /* renamed from: B */
    private static final int f42862B = 2;

    /* renamed from: C */
    private static final int f42863C = 1;

    /* renamed from: D */
    private static final int f42864D = 31;

    /* renamed from: E */
    private static final int f42865E = 1;

    /* renamed from: F */
    private static final int f42866F = 28;

    /* renamed from: G */
    private static final int f42867G = 33;

    /* renamed from: H */
    private static final int f42868H = 10;

    /* renamed from: I */
    private static final int f42869I = 12;

    /* renamed from: J */
    private static final int f42870J = 12;

    /* renamed from: K */
    private static final int f42871K = 15;

    /* renamed from: L */
    private static final int f42872L = 86400000;

    /* renamed from: M */
    private static final int f42873M = 10;

    /* renamed from: N */
    private static final int f42874N = 20;

    /* renamed from: O */
    private static final int f42875O = 30;

    /* renamed from: P */
    private static final int f42876P = 29;

    /* renamed from: Q */
    private static final int f42877Q = 12;

    /* renamed from: R */
    private static final int f42878R = 2;

    /* renamed from: S */
    private static final int f42879S = 28;

    /* renamed from: T */
    private static final int f42880T = 29;

    /* renamed from: U */
    private static final int f42881U = 31;

    /* renamed from: V */
    private static final int f42882V = 30;

    /* renamed from: W */
    private static final int f42883W = 13;

    /* renamed from: X */
    private static final int f42884X = 348;

    /* renamed from: Y */
    private static final int f42885Y = 8;

    /* renamed from: Z */
    private static final int f42886Z = 32768;

    /* renamed from: a0 */
    private static final int f42887a0 = 65536;

    /* renamed from: b0 */
    private static final int f42888b0 = 4;

    /* renamed from: c0 */
    private static final int f42889c0 = 11;

    /* renamed from: d0 */
    private static final int f42890d0 = 12;

    /* renamed from: e0 */
    private static final int f42891e0 = 2;

    /* renamed from: f0 */
    private static final int f42892f0 = 3;

    /* renamed from: g0 */
    private static final String f42893g0 = "UTC";

    /* renamed from: k */
    private static final String f42894k = "HwLunarCalendar";

    /* renamed from: l */
    private static final int[] f42895l = {27296, 47779, 43856, 19416, 19168, 42352, 21717, 53856, 55632, 21844, 22191, 39632, 21970, 19168, 42422, 42192, 53840, 53909, 46415, 54944, 44450, 38320, 18807, 18815, 42160, 46261, 27216, 27968, 43860, 11119, 38256, 21234, 18800, 25958, 54432, 59984, 27285, 23263, 11104, 34531, 37615, 51415, 51551, 54432, 55462, 46431, 22176, 42420, 9695, 37584, 53938, 43344, 46423, 27808, 46416, 21333, 19887, 42416, 17779, 21183, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 38310, 38335, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 20854, 21183, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, OrderStatusCode.ORDER_STATE_NET_ERROR, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 53430, 53855, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 45653, 27951, 44448, 19299, 37759, 18936, 18800, 25776, 26790, 59999, 27424, 42692, 43759, 37600, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 19285, 19311, 42352, 21732, 53856, 59752, 54560, 55968, 27302, 22239, 19168, 43476, 42192, 53584, 62034, 54560, 56645, 46496, 22224};

    /* renamed from: m */
    private static final int[] f42896m = {C8717R.string.gan_jia, C8717R.string.gan_yi, C8717R.string.gan_bing, C8717R.string.gan_ding, C8717R.string.gan_wu, C8717R.string.gan_ji, C8717R.string.gan_gen, C8717R.string.gan_xin, C8717R.string.gan_ren, C8717R.string.gan_gui};

    /* renamed from: n */
    private static final int[] f42897n = {C8717R.string.jian_zhi_zi, C8717R.string.jian_zhi_chu, C8717R.string.jian_zhi_yin, C8717R.string.jian_zhi_mao, C8717R.string.jian_zhi_chen, C8717R.string.jian_zhi_si, C8717R.string.jian_zhi_wu, C8717R.string.jian_zhi_wei, C8717R.string.jian_zhi_shen, C8717R.string.jian_zhi_you, C8717R.string.jian_zhi_xu, C8717R.string.jian_zhi_hai};

    /* renamed from: o */
    private static final int[] f42898o = {C8717R.string.jian_mouse, C8717R.string.jian_cattle, C8717R.string.jian_tiger, C8717R.string.jian_rabbit, C8717R.string.jian_dragon, C8717R.string.jian_snake, C8717R.string.jian_horse, C8717R.string.jian_sheep, C8717R.string.jian_monkey, C8717R.string.jian_chicken, C8717R.string.jian_dog, C8717R.string.jian_pig};

    /* renamed from: p */
    private static final int[] f42899p = {C8717R.string.mouse, C8717R.string.cattle, C8717R.string.tiger, C8717R.string.rabbit, C8717R.string.dragon, C8717R.string.snake, C8717R.string.horse, C8717R.string.sheep, C8717R.string.monkey, C8717R.string.chicken, C8717R.string.dog, C8717R.string.pig};

    /* renamed from: q */
    private static final int[] f42900q = {C8717R.string.zero, C8717R.string.one, C8717R.string.two, C8717R.string.three, C8717R.string.four, C8717R.string.five, C8717R.string.six, C8717R.string.seven, C8717R.string.eight, C8717R.string.nine, C8717R.string.ten};

    /* renamed from: r */
    private static final int[] f42901r = {C8717R.string.jian_one, C8717R.string.jian_two, C8717R.string.jian_three, C8717R.string.jian_four, C8717R.string.jian_five, C8717R.string.jian_six, C8717R.string.jian_seven, C8717R.string.jian_eight, C8717R.string.jian_nine, C8717R.string.jian_ten};

    /* renamed from: s */
    private static final int[] f42902s = {1, 3, 5, 7, 8, 10, 12};

    /* renamed from: t */
    private static final int[] f42903t = {4, 6, 9, 11};

    /* renamed from: u */
    private static final int f42904u = 1900;

    /* renamed from: v */
    private static final int f42905v = 2100;

    /* renamed from: w */
    private static final int f42906w = 1897;

    /* renamed from: x */
    private static final int f42907x = 2102;

    /* renamed from: y */
    private static final int f42908y = 1897;

    /* renamed from: z */
    private static final int f42909z = 2102;

    /* renamed from: a */
    private boolean f42910a;

    /* renamed from: b */
    private boolean f42911b;

    /* renamed from: c */
    private Context f42912c;

    /* renamed from: d */
    private Calendar f42913d;

    /* renamed from: e */
    private GregorianCalendar f42914e;

    /* renamed from: f */
    private int f42915f;

    /* renamed from: g */
    private int f42916g;

    /* renamed from: h */
    private int f42917h;

    /* renamed from: i */
    private boolean f42918i;

    /* renamed from: j */
    private final Object f42919j;

    private HwLunarCalendar() {
        this.f42919j = new Object();
    }

    /* renamed from: a */
    private boolean m54710a(int i10, int i11, int i12) {
        return i10 >= i11 && i10 <= i12;
    }

    /* renamed from: b */
    private void m54713b(int i10, int i11, int i12) {
        this.f42911b = true;
        boolean z10 = this.f42910a;
        int i13 = z10 ? 1897 : 1900;
        int i14 = z10 ? 2102 : 2100;
        if (i10 == i13 && i11 < 1 && i12 < 31) {
            this.f42911b = false;
            return;
        }
        if (i10 == i14 + 1 && i11 < 1 && i12 <= 28) {
            this.f42911b = true;
            return;
        }
        if (i10 < i13 || i10 > i14) {
            this.f42911b = false;
            return;
        }
        if (i11 < 0 || i11 > 12) {
            this.f42911b = false;
            return;
        }
        int i15 = i11 + 1;
        if (i15 == 2) {
            if (new GregorianCalendar().isLeapYear(i10)) {
                this.f42911b = m54710a(i12, 1, 29);
                return;
            } else {
                this.f42911b = m54710a(i12, 1, 28);
                return;
            }
        }
        if (m54711a(i15, f42902s)) {
            this.f42911b = m54710a(i12, 1, 31);
        } else if (m54711a(i15, f42903t)) {
            this.f42911b = m54710a(i12, 1, 30);
        } else {
            Log.e(f42894k, "wrong month index");
        }
    }

    /* renamed from: c */
    private int m54714c(int i10) {
        int iM54699a = m54699a(i10) + f42884X;
        if (i10 < 1897 || i10 > 2102) {
            Log.e(f42894k, "getLunarYearDays: lunarYear index out of boundry, lunarYear = " + i10);
            return 0;
        }
        for (int i11 = 32768; i11 > 8; i11 >>= 1) {
            iM54699a += (f42895l[i10 + (-1897)] & i11) != 0 ? 1 : 0;
        }
        return iM54699a;
    }

    public String getChineseDay() {
        String str = "";
        if (!this.f42911b) {
            return "";
        }
        if (this.f42917h <= 10) {
            str = "" + this.f42912c.getString(C8717R.string.chinese_chu);
        }
        return str + m54704a(this.f42917h, false);
    }

    public String getChineseMonthJian() {
        return m54707a(false, true);
    }

    public String getChineseYearJian() {
        if (!this.f42911b) {
            return "";
        }
        return m54703a() + m54705a(true) + this.f42912c.getString(C8717R.string.chinese_year1) + this.f42915f;
    }

    public int getLunarDayNum() {
        return this.f42917h;
    }

    public int getLunarMonthNum() {
        return this.f42916g;
    }

    public int getLunarYearNum() {
        return this.f42915f;
    }

    public void setLunarDate(int i10, int i11, int i12) {
        synchronized (this.f42919j) {
            try {
                Calendar calendar = Calendar.getInstance();
                int i13 = i11 - 1;
                calendar.set(i10, i13, i12);
                m54708a(i10 == 0 ? System.currentTimeMillis() : calendar.getTimeInMillis());
                m54713b(i10, i13, i12);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private boolean m54711a(int i10, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i10 == i11) {
                return true;
            }
        }
        return false;
    }

    public HwLunarCalendar(Context context) {
        this.f42919j = new Object();
        this.f42912c = context;
        this.f42911b = true;
        this.f42914e = new GregorianCalendar(TimeZone.getTimeZone(f42893g0));
        this.f42913d = Calendar.getInstance();
        this.f42910a = true;
    }

    /* renamed from: a */
    private void m54708a(long j10) {
        this.f42913d.setTimeInMillis(j10);
        this.f42915f = 1897;
        HwCustTime hwCustTime = new HwCustTime(Calendar.getInstance().getTimeZone());
        hwCustTime.set(j10);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(hwCustTime.getYear(), hwCustTime.getMonth(), hwCustTime.getMonthDay());
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone(f42893g0));
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(1897, 1, 2);
        gregorianCalendar2.setTimeZone(TimeZone.getTimeZone(f42893g0));
        m54709a(gregorianCalendar, gregorianCalendar2);
    }

    /* renamed from: a */
    private void m54709a(Calendar calendar, Calendar calendar2) {
        boolean z10;
        long jM54702a = m54702a((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 86400000, m54714c(this.f42915f));
        int iM54712b = m54712b(this.f42915f);
        boolean z11 = false;
        int i10 = 1;
        boolean z12 = false;
        loop0: while (true) {
            z10 = z12;
            while (i10 < 13 && jM54702a > 0) {
                long jM54701a = m54701a(i10, z12, z10);
                if (jM54702a < jM54701a) {
                    break loop0;
                }
                jM54702a -= jM54701a;
                if (z10) {
                    i10++;
                    z12 = false;
                } else if (iM54712b == i10) {
                    break;
                } else {
                    i10++;
                }
            }
            z12 = true;
        }
        this.f42916g = i10;
        if (i10 == iM54712b && z10) {
            z11 = true;
        }
        this.f42918i = z11;
        this.f42917h = ((int) jM54702a) + 1;
    }

    /* renamed from: b */
    private int m54712b(int i10) {
        if (i10 >= 1897 && i10 <= 2102) {
            int i11 = f42895l[i10 - 1897] & 15;
            if (i11 == 15) {
                return 0;
            }
            return i11;
        }
        Log.e(f42894k, "getLunarLeapMonth: lunarYear index out of boundry, lunarYear = " + i10);
        return 0;
    }

    /* renamed from: a */
    private int m54701a(int i10, boolean z10, boolean z11) {
        if (z11 && z10) {
            return m54699a(this.f42915f);
        }
        return m54700a(this.f42915f, i10);
    }

    /* renamed from: a */
    private long m54702a(long j10, int i10) {
        while (true) {
            int i11 = this.f42915f;
            if (i11 >= 2102) {
                break;
            }
            long j11 = i10;
            if (j10 < j11) {
                break;
            }
            j10 -= j11;
            int i12 = i11 + 1;
            this.f42915f = i12;
            i10 = m54714c(i12);
        }
        return j10;
    }

    /* renamed from: a */
    private int m54699a(int i10) {
        if (i10 >= 1896 && i10 < 2103) {
            int i11 = f42895l[i10 - 1896] & 15;
            if (m54712b(i10) > 0) {
                return i11 == 15 ? 30 : 29;
            }
            return 0;
        }
        Log.e(f42894k, "getLunarLeapDays: lunarYear index out of boundry, lunarYear = " + i10);
        return 0;
    }

    /* renamed from: a */
    private int m54700a(int i10, int i11) {
        if (i10 >= 1897 && i10 <= 2102) {
            return (f42895l[i10 - 1897] & (65536 >> i11)) != 0 ? 30 : 29;
        }
        Log.e(f42894k, "getLunarMonthDays: lunarYear index out of boundry, lunarYear = " + i10);
        return 0;
    }

    /* renamed from: a */
    private String m54705a(boolean z10) {
        if (z10) {
            return this.f42912c.getString(f42898o[(this.f42915f - 4) % 12]);
        }
        return this.f42912c.getString(f42899p[(this.f42915f - 4) % 12]);
    }

    /* renamed from: a */
    private String m54703a() {
        if (!this.f42911b) {
            return "";
        }
        int i10 = this.f42915f - 1864;
        try {
            return this.f42912c.getString(f42896m[i10 % 10]) + this.f42912c.getString(f42897n[i10 % 12]);
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private String m54707a(boolean z10, boolean z11) {
        String str;
        String str2 = "";
        if (!this.f42911b) {
            return "";
        }
        if (this.f42918i) {
            if (z11) {
                str2 = "" + this.f42912c.getString(C8717R.string.run1);
            } else {
                str2 = "" + this.f42912c.getString(C8717R.string.run);
            }
        }
        if (z11) {
            str = m54704a(this.f42916g, z11) + this.f42912c.getString(C8717R.string.chinese_month1);
        } else {
            str = m54704a(this.f42916g, z11) + this.f42912c.getString(C8717R.string.chinese_month);
        }
        int i10 = this.f42916g;
        if (i10 == 1) {
            return str2 + m54706a(z10, this.f42912c.getString(C8717R.string.zhengyue), str);
        }
        if (i10 == 11) {
            if (z11) {
                return str2 + m54706a(z10, this.f42912c.getString(C8717R.string.dongyue1), str);
            }
            return str2 + m54706a(z10, this.f42912c.getString(C8717R.string.dongyue), str);
        }
        if (i10 != 12) {
            return str2 + str;
        }
        if (z11) {
            return str2 + m54706a(z10, this.f42912c.getString(C8717R.string.layue1), str);
        }
        return str2 + m54706a(z10, this.f42912c.getString(C8717R.string.layue), str);
    }

    /* renamed from: a */
    private String m54704a(int i10, boolean z10) {
        String string = "";
        if (i10 < 0) {
            return "";
        }
        int i11 = i10 / 10;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    if (z10) {
                        string = this.f42912c.getString(C8717R.string.chinese_thirty1);
                    } else {
                        string = this.f42912c.getString(C8717R.string.chinese_thirty);
                    }
                }
            } else if (z10) {
                string = this.f42912c.getString(C8717R.string.chinese_twenty1);
            } else {
                string = this.f42912c.getString(C8717R.string.chinese_twenty);
            }
        } else if (z10) {
            string = this.f42912c.getString(f42901r[9]);
        } else {
            string = this.f42912c.getString(C8717R.string.ten);
        }
        int i12 = i10 % 10;
        if (i12 != 0) {
            string = string + this.f42912c.getString(f42900q[i12]);
        }
        return i10 == 20 ? HwLunarUtils.LUNAR_DAY[i10 - 1] : string;
    }

    /* renamed from: a */
    private String m54706a(boolean z10, String str, String str2) {
        if (!z10) {
            return str;
        }
        return str2 + String.format(Locale.ROOT, this.f42912c.getString(C8717R.string.lunar_month), str);
    }
}
