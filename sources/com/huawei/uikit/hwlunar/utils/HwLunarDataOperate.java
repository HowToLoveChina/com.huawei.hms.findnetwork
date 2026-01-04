package com.huawei.uikit.hwlunar.utils;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import com.huawei.uikit.hwlunar.C8717R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class HwLunarDataOperate {

    /* renamed from: A */
    private static final String f42920A = "UTF-8";

    /* renamed from: A0 */
    private static final int f42921A0 = 8;

    /* renamed from: B */
    private static final String f42922B = "";

    /* renamed from: B0 */
    private static final int f42923B0 = 12;

    /* renamed from: C */
    private static final String f42924C = "0";

    /* renamed from: C0 */
    private static final int f42925C0 = 16;
    public static final int CHANGE_TYPE_MONTH = 1;
    public static final int CHANGE_TYPE_YEAR = 0;

    /* renamed from: D */
    private static final int f42926D = 8;

    /* renamed from: D0 */
    private static final int f42927D0 = 17;

    /* renamed from: E */
    private static final int f42928E = 0;

    /* renamed from: E0 */
    private static final int f42929E0 = 21;

    /* renamed from: F */
    private static final int f42930F = 4;

    /* renamed from: F0 */
    private static final int f42931F0 = 28;

    /* renamed from: G */
    private static final int f42932G = 4;

    /* renamed from: G0 */
    private static final int f42933G0 = 1890;

    /* renamed from: H */
    private static final int f42934H = 6;

    /* renamed from: H0 */
    private static final int f42935H0 = 4;

    /* renamed from: I */
    private static final int f42936I = 6;

    /* renamed from: I0 */
    private static final int f42937I0 = 0;

    /* renamed from: J */
    private static final int f42938J = 8;

    /* renamed from: J0 */
    private static final int f42939J0 = 1;

    /* renamed from: K */
    private static final int f42940K = 0;

    /* renamed from: K0 */
    private static final int f42941K0 = 2;

    /* renamed from: L */
    private static final int f42942L = 31;

    /* renamed from: L0 */
    private static final int f42943L0 = 3;

    /* renamed from: M */
    private static final int f42944M = 1900;

    /* renamed from: M0 */
    private static final int f42945M0 = 8;

    /* renamed from: N */
    private static final int f42946N = 2100;

    /* renamed from: N0 */
    private static final int f42947N0 = 8;

    /* renamed from: O */
    private static final int f42948O = 1898;

    /* renamed from: O0 */
    private static final int f42949O0 = 2;

    /* renamed from: P */
    private static final int f42950P = 2102;

    /* renamed from: P0 */
    private static final int f42951P0 = 3;

    /* renamed from: Q */
    private static final int f42952Q = 4;

    /* renamed from: Q0 */
    private static final int f42953Q0 = -1;

    /* renamed from: R */
    private static final int f42954R = 0;

    /* renamed from: R0 */
    private static final int f42955R0 = 3;

    /* renamed from: S */
    private static final int f42956S = 1;

    /* renamed from: S0 */
    private static final int f42957S0 = 2;

    /* renamed from: T */
    private static final int f42958T = 2;

    /* renamed from: T0 */
    private static final int f42959T0 = 2;

    /* renamed from: U */
    private static final int f42960U = 3;

    /* renamed from: U0 */
    private static final int f42961U0 = 27;

    /* renamed from: V */
    private static final int f42962V = 10;

    /* renamed from: V0 */
    private static final int f42963V0 = 6;

    /* renamed from: W */
    private static final int f42964W = 16;

    /* renamed from: W0 */
    private static final int f42965W0 = 7;

    /* renamed from: X */
    private static final int f42966X = 255;

    /* renamed from: X0 */
    private static final int f42967X0 = 10000;

    /* renamed from: Y */
    private static final int f42968Y = 31;

    /* renamed from: Y0 */
    private static final int f42969Y0 = 1000;

    /* renamed from: Z */
    private static final int f42970Z = 15;

    /* renamed from: Z0 */
    private static HwLunarDataOperate f42971Z0 = null;

    /* renamed from: a0 */
    private static final int f42972a0 = 1;

    /* renamed from: b0 */
    private static final int f42973b0 = 8;

    /* renamed from: c0 */
    private static final int f42974c0 = 6;

    /* renamed from: d0 */
    private static final int f42975d0 = 0;

    /* renamed from: e0 */
    private static final int f42976e0 = 1;

    /* renamed from: f0 */
    private static final int f42977f0 = 2;

    /* renamed from: g0 */
    private static final int f42978g0 = 3;

    /* renamed from: h0 */
    private static final int f42979h0 = 4;

    /* renamed from: i0 */
    private static final int f42980i0 = 5;

    /* renamed from: j0 */
    private static final int f42981j0 = 6;

    /* renamed from: k0 */
    private static final int f42982k0 = 7;

    /* renamed from: l0 */
    private static final int f42983l0 = 4;

    /* renamed from: m0 */
    private static final int f42984m0 = 9;

    /* renamed from: n0 */
    private static final int f42985n0 = 13;

    /* renamed from: o0 */
    private static final int f42986o0 = 17;

    /* renamed from: p0 */
    private static final int f42987p0 = 18;

    /* renamed from: q0 */
    private static final int f42988q0 = 19;

    /* renamed from: r0 */
    private static final int f42989r0 = 23;

    /* renamed from: s0 */
    private static final int f42990s0 = 4;

    /* renamed from: t0 */
    private static final int f42991t0 = 8;

    /* renamed from: u0 */
    private static final int f42992u0 = 0;

    /* renamed from: v0 */
    private static final int f42993v0 = 1;

    /* renamed from: w0 */
    private static final int f42994w0 = 2;

    /* renamed from: x0 */
    private static final int f42995x0 = 3;

    /* renamed from: y */
    private static final String f42996y = "HwLunarDataOperate";

    /* renamed from: y0 */
    private static final int f42997y0 = 4;

    /* renamed from: z */
    private static final String f42998z = "_";

    /* renamed from: z0 */
    private static final int f42999z0 = 5;

    /* renamed from: q */
    private Context f43016q;

    /* renamed from: r */
    private HwLunarCalendar f43017r;

    /* renamed from: a */
    private String[] f43000a = new String[Constant.ERROR_ACC_GRAVITY_INVALID];

    /* renamed from: b */
    private String[] f43001b = new String[Constant.ERROR_ACC_GRAVITY_INVALID];

    /* renamed from: c */
    private SparseArray<Integer> f43002c = new SparseArray<>();

    /* renamed from: d */
    private SparseArray<String> f43003d = new SparseArray<>();

    /* renamed from: e */
    private SparseArray<String> f43004e = new SparseArray<>();

    /* renamed from: f */
    private Map<String, Integer> f43005f = new HashMap(10);

    /* renamed from: g */
    private Map<String, Integer> f43006g = new HashMap(10);

    /* renamed from: h */
    private Map<Integer, List<String>> f43007h = new HashMap(10);

    /* renamed from: i */
    private Map<Integer, String> f43008i = new HashMap(10);

    /* renamed from: j */
    private Map<String, Integer> f43009j = new HashMap(10);

    /* renamed from: k */
    private Map<String, String> f43010k = new HashMap(10);

    /* renamed from: l */
    private Map<String, List<String>> f43011l = new HashMap(10);

    /* renamed from: m */
    private List<Object> f43012m = new ArrayList(10);

    /* renamed from: n */
    private List<Object> f43013n = new ArrayList(10);

    /* renamed from: o */
    private List<Object> f43014o = new ArrayList(10);

    /* renamed from: p */
    private Map<String, List<String>> f43015p = new HashMap(10);

    /* renamed from: s */
    private String f43018s = null;

    /* renamed from: t */
    private String f43019t = null;

    /* renamed from: u */
    private String f43020u = null;

    /* renamed from: v */
    private final Object f43021v = new Object();

    /* renamed from: w */
    private List<String> f43022w = new ArrayList(10);

    /* renamed from: x */
    private Map<String, Integer> f43023x = new HashMap(10);

    public HwLunarDataOperate(Context context) throws Throwable {
        this.f43016q = context.getApplicationContext();
        this.f43017r = new HwLunarCalendar(this.f43016q);
        m54730b();
    }

    /* renamed from: a */
    private static HwLunarDataOperate m54716a() {
        return f42971Z0;
    }

    /* renamed from: b */
    private void m54730b() throws Throwable {
        Log.w(f42996y, "init ");
        int i10 = 0;
        for (int i11 = 1898; i11 < 2103; i11++) {
            this.f43017r.setLunarDate(i11, 8, 8);
            String chineseYearJian = this.f43017r.getChineseYearJian();
            this.f43000a[i10] = chineseYearJian;
            this.f43001b[i10] = String.valueOf(i11);
            this.f43002c.put(i11, Integer.valueOf(i10));
            this.f43003d.put(i11, chineseYearJian);
            this.f43004e.put(i10, chineseYearJian);
            this.f43005f.put(chineseYearJian, Integer.valueOf(i11));
            this.f43006g.put(chineseYearJian, Integer.valueOf(i10));
            i10++;
        }
        m54734c();
        Map<String, Integer> map = this.f43023x;
        StringBuilder sb2 = new StringBuilder();
        Context context = this.f43016q;
        int i12 = C8717R.string.chinese_twenty;
        sb2.append(context.getString(i12));
        sb2.append(this.f43016q.getString(C8717R.string.eight));
        map.put(sb2.toString(), 1);
        this.f43023x.put(this.f43016q.getString(i12) + this.f43016q.getString(C8717R.string.nine), 2);
        Map<String, Integer> map2 = this.f43023x;
        Context context2 = this.f43016q;
        int i13 = C8717R.string.chinese_thirty;
        map2.put(context2.getString(i13), 3);
        this.f43023x.put(this.f43016q.getString(i13) + this.f43016q.getString(C8717R.string.one), 3);
    }

    /* renamed from: c */
    private void m54734c() throws Throwable {
        BufferedReader bufferedReader;
        InputStream inputStreamOpenRawResource;
        BufferedReader bufferedReader2;
        InputStream inputStream = null;
        String str = null;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader3 = null;
        try {
            inputStreamOpenRawResource = this.f43016q.getResources().openRawResource(C8717R.raw.all_month);
            try {
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, "UTF-8"));
                    try {
                        ArrayList arrayList = new ArrayList(10);
                        int i10 = 0;
                        String str2 = null;
                        while (true) {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                                HwLunarUtils.closeBufferedReader(bufferedReader2);
                                return;
                            }
                            if (m54725a(line, i10)) {
                                HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                                HwLunarUtils.closeBufferedReader(bufferedReader2);
                                return;
                            }
                            String[] strArrM54727a = m54727a(m54726a(m54715a(line)));
                            m54721a(i10, strArrM54727a);
                            if (str == null) {
                                str = strArrM54727a[0];
                                str2 = strArrM54727a[1];
                                arrayList.add(strArrM54727a[2]);
                            } else if (str.equals(strArrM54727a[0])) {
                                arrayList.add(strArrM54727a[2]);
                            } else {
                                m54723a(str, arrayList);
                                this.f43011l.put(str2, arrayList);
                                ArrayList arrayList2 = new ArrayList(10);
                                String str3 = strArrM54727a[0];
                                String str4 = strArrM54727a[1];
                                arrayList2.add(strArrM54727a[2]);
                                arrayList = arrayList2;
                                str = str3;
                                str2 = str4;
                            }
                            i10++;
                        }
                    } catch (IOException unused) {
                        bufferedReader3 = bufferedReader2;
                        Log.e(f42996y, "loadAllMonth has an Exception.");
                        HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                        HwLunarUtils.closeBufferedReader(bufferedReader3);
                    } catch (Throwable th2) {
                        th = th2;
                        HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                        HwLunarUtils.closeBufferedReader(bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    InputStream inputStream2 = inputStreamOpenRawResource;
                    bufferedReader = bufferedReader3;
                    inputStream = inputStream2;
                    bufferedReader2 = bufferedReader;
                    inputStreamOpenRawResource = inputStream;
                    HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                    HwLunarUtils.closeBufferedReader(bufferedReader2);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (IOException unused3) {
            inputStreamOpenRawResource = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader2 = bufferedReader;
            inputStreamOpenRawResource = inputStream;
            HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
            HwLunarUtils.closeBufferedReader(bufferedReader2);
            throw th;
        }
    }

    public static synchronized HwLunarDataOperate getInstance(Context context) {
        try {
            if (f42971Z0 == null) {
                m54722a(new HwLunarDataOperate(context));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return m54716a();
    }

    public static GregorianCalendar getMaxWesternDate() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(2101, 0, 27);
        return gregorianCalendar;
    }

    public static GregorianCalendar getMinWesternDate() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1900, 0, 31);
        return gregorianCalendar;
    }

    public SparseArray<String> getAllIndexLunarYear() {
        return this.f43004e;
    }

    public Map<Integer, String> getAllIndexLunarYearMonth() {
        return this.f43008i;
    }

    public String[] getAllLunarNumberYearStrings() {
        return this.f43001b;
    }

    public Map<String, Integer> getAllLunarYearIndex() {
        return this.f43006g;
    }

    public Map<String, Integer> getAllLunarYearMonthIndex() {
        return this.f43009j;
    }

    public Map<String, List<String>> getAllLunarYearToMonths() {
        return this.f43011l;
    }

    public Map<String, Integer> getAllLunarYearWesternYear() {
        return this.f43005f;
    }

    public SparseArray<String> getAllWesternYearlunarYear() {
        return this.f43003d;
    }

    public String[] getAllYearStrings() {
        return this.f43000a;
    }

    public Map<String, List<String>> getLunarYearMonthToDays() {
        return this.f43015p;
    }

    public void loadData(int i10) {
        synchronized (this.f43021v) {
            try {
                this.f43018s = null;
                this.f43019t = null;
                this.f43020u = null;
                if (!this.f43015p.isEmpty()) {
                    this.f43015p = new HashMap(10);
                }
                int i11 = C8717R.raw.year_1899 + (i10 - 1899);
                this.f43013n = m54733c(i11 - 1);
                this.f43012m = m54733c(i11);
                this.f43014o = m54733c(i11 + 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public GregorianCalendar lunarChangeWestern(String str, String str2, String str3, boolean z10) {
        GregorianCalendar gregorianCalendarM54718a;
        synchronized (this.f43021v) {
            try {
                int iIntValue = this.f43005f.get(str).intValue();
                String str4 = str + str2 + str3;
                gregorianCalendarM54718a = !this.f43012m.isEmpty() ? m54718a(this.f43012m, str4) : null;
                if (gregorianCalendarM54718a == null && !this.f43014o.isEmpty()) {
                    gregorianCalendarM54718a = m54718a(this.f43014o, str4);
                }
                if (gregorianCalendarM54718a == null && !this.f43013n.isEmpty()) {
                    gregorianCalendarM54718a = m54718a(this.f43013n, str4);
                }
                if (gregorianCalendarM54718a == null) {
                    loadData(iIntValue);
                    if (!this.f43012m.isEmpty()) {
                        gregorianCalendarM54718a = m54718a(this.f43012m, str4);
                    }
                    if (gregorianCalendarM54718a == null && !this.f43014o.isEmpty()) {
                        gregorianCalendarM54718a = m54718a(this.f43014o, str4);
                    }
                    gregorianCalendarM54718a = m54719a(z10, gregorianCalendarM54718a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gregorianCalendarM54718a;
    }

    /* renamed from: a */
    private static void m54722a(HwLunarDataOperate hwLunarDataOperate) {
        f42971Z0 = hwLunarDataOperate;
    }

    /* renamed from: a */
    private void m54723a(String str, List<String> list) {
        try {
            this.f43007h.put(Integer.valueOf(str), list);
        } catch (NumberFormatException unused) {
            Log.e(f42996y, "parse string to int error, westernYear = " + str);
        }
    }

    /* renamed from: a */
    private boolean m54725a(String str, int i10) {
        if (i10 > 10000) {
            Log.e(f42996y, "loadAllMonth: too many lines in all month config file!");
            return true;
        }
        if (str.length() <= 6) {
            return false;
        }
        Log.e(f42996y, "hex month string length is illegal");
        return true;
    }

    /* renamed from: a */
    private void m54721a(int i10, String[] strArr) {
        if (strArr != null && strArr.length == 4) {
            this.f43008i.put(Integer.valueOf(i10), strArr[1] + "_" + strArr[2]);
            this.f43009j.put(strArr[1] + "_" + strArr[2], Integer.valueOf(i10));
            this.f43010k.put(strArr[1] + strArr[2], strArr[3]);
            return;
        }
        Log.e(f42996y, "decode month table error");
    }

    /* renamed from: a */
    private int m54715a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str, 16);
        } catch (NumberFormatException | IllegalFormatException unused) {
            Log.e(f42996y, "parse string to hex error, hexStr = " + str);
            return 0;
        }
    }

    /* renamed from: a */
    private int[] m54726a(int i10) {
        return new int[]{(i10 & 255) + f42933G0, (i10 >> 8) & 15, (i10 >> 12) & 15, (i10 >> 16) & 1, (i10 >> 17) & 15, (i10 >> 21) & 1};
    }

    /* renamed from: a */
    private String[] m54727a(int[] iArr) {
        if (iArr.length != 6) {
            Log.e(f42996y, "decode year month table error");
            return new String[0];
        }
        String[] strArr = new String[4];
        strArr[0] = iArr[0] + "";
        StringBuilder sb2 = new StringBuilder();
        String[] strArr2 = HwLunarUtils.TIAN_GAN;
        sb2.append(strArr2[iArr[1] % strArr2.length]);
        String[] strArr3 = HwLunarUtils.DI_ZHI;
        sb2.append(strArr3[iArr[2] % strArr3.length]);
        String[] strArr4 = HwLunarUtils.ZIADOC;
        sb2.append(strArr4[iArr[2] % strArr4.length]);
        sb2.append("年");
        sb2.append(iArr[0]);
        strArr[1] = sb2.toString();
        if (iArr[3] == 0) {
            String[] strArr5 = HwLunarUtils.LUNAR_MONTH;
            strArr[2] = strArr5[iArr[4] % strArr5.length];
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(HwConstants.LUNAR_RUN);
            String[] strArr6 = HwLunarUtils.LUNAR_MONTH;
            sb3.append(strArr6[iArr[4] % strArr6.length]);
            strArr[2] = sb3.toString();
        }
        String[] strArr7 = HwLunarUtils.LUNAR_DAY;
        strArr[3] = strArr7[(iArr[5] + 28) % strArr7.length];
        return strArr;
    }

    public GregorianCalendar lunarChangeWestern(String str, String str2, String str3, int i10, boolean z10) {
        GregorianCalendar gregorianCalendarM54718a;
        synchronized (this.f43021v) {
            try {
                int iIntValue = this.f43005f.get(str).intValue();
                String str4 = str + str2 + str3;
                gregorianCalendarM54718a = !this.f43012m.isEmpty() ? m54718a(this.f43012m, str4) : null;
                if (gregorianCalendarM54718a == null && !this.f43014o.isEmpty()) {
                    gregorianCalendarM54718a = m54718a(this.f43014o, str4);
                }
                if (gregorianCalendarM54718a == null && !this.f43013n.isEmpty()) {
                    gregorianCalendarM54718a = m54718a(this.f43013n, str4);
                }
                if (gregorianCalendarM54718a == null) {
                    loadData(iIntValue);
                    if (!this.f43012m.isEmpty()) {
                        gregorianCalendarM54718a = m54718a(this.f43012m, str4);
                    }
                    if (gregorianCalendarM54718a == null && !this.f43014o.isEmpty()) {
                        gregorianCalendarM54718a = m54718a(this.f43014o, str4);
                    }
                    if (gregorianCalendarM54718a == null) {
                        m54717a(str, str2, str3, i10, z10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gregorianCalendarM54718a;
    }

    /* renamed from: b */
    private GregorianCalendar m54729b(String str) throws NumberFormatException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (str.length() == 8) {
            String strSubstring = str.substring(0, 4);
            String strSubstring2 = str.substring(4, 6);
            String strSubstring3 = str.substring(6, 8);
            if (strSubstring2.indexOf("0") != -1 && strSubstring2.indexOf("0") != 1) {
                strSubstring2 = strSubstring2.substring(1, 2);
            }
            try {
                gregorianCalendar.set(Integer.parseInt(strSubstring), Integer.parseInt(strSubstring2) - 1, Integer.parseInt(strSubstring3));
            } catch (NumberFormatException unused) {
                Log.e(f42996y, "parse string to int error.");
            }
        }
        return gregorianCalendar;
    }

    /* renamed from: a */
    private GregorianCalendar m54719a(boolean z10, GregorianCalendar gregorianCalendar) {
        return (gregorianCalendar == null && z10) ? new GregorianCalendar() : gregorianCalendar;
    }

    /* renamed from: a */
    private GregorianCalendar m54717a(String str, String str2, String str3, int i10, boolean z10) {
        if (i10 == 1) {
            String str4 = this.f43010k.get(str + str2);
            if (str4 != null) {
                if (this.f43023x.get(str3).intValue() > this.f43023x.get(str4).intValue()) {
                    return lunarChangeWestern(str, str2, str4, false);
                }
                return null;
            }
            return m54719a(z10, (GregorianCalendar) null);
        }
        if (i10 == 0) {
            Context context = this.f43016q;
            int i11 = C8717R.string.run;
            if (str2.indexOf(context.getString(i11)) != -1) {
                GregorianCalendar gregorianCalendarLunarChangeWestern = lunarChangeWestern(str, str2, str3, 1, false);
                if (gregorianCalendarLunarChangeWestern != null) {
                    return gregorianCalendarLunarChangeWestern;
                }
                String strReplace = str2.replace(this.f43016q.getString(i11), "");
                GregorianCalendar gregorianCalendarLunarChangeWestern2 = lunarChangeWestern(str, strReplace, str3, false);
                return gregorianCalendarLunarChangeWestern2 != null ? gregorianCalendarLunarChangeWestern2 : m54719a(z10, lunarChangeWestern(str, strReplace, str3, 1, false));
            }
            GregorianCalendar gregorianCalendarLunarChangeWestern3 = lunarChangeWestern(str, str2, str3, 1, false);
            return (gregorianCalendarLunarChangeWestern3 == null && z10) ? new GregorianCalendar() : gregorianCalendarLunarChangeWestern3;
        }
        return m54719a(z10, (GregorianCalendar) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.huawei.uikit.hwlunar.utils.HwLunarDataOperate] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* renamed from: c */
    private List<Object> m54733c(int i10) throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpenRawResource;
        ?? r82;
        ?? r83;
        ?? bufferedReader;
        String line;
        ArrayList arrayList = new ArrayList(10);
        InputStream inputStream2 = null;
        try {
            inputStreamOpenRawResource = this.f43016q.getResources().openRawResource(i10);
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, "UTF-8"));
                    try {
                        line = bufferedReader.readLine();
                    } catch (IOException unused) {
                        inputStream2 = bufferedReader;
                        Log.e(f42996y, "readOneYearData has an Exception.");
                        r83 = inputStream2;
                        HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                        HwLunarUtils.closeBufferedReader(r83);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        r82 = bufferedReader;
                        HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                        HwLunarUtils.closeBufferedReader(r82);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    InputStream inputStream3 = inputStream2;
                    inputStream2 = inputStreamOpenRawResource;
                    inputStream = inputStream3;
                    r82 = inputStream;
                    inputStreamOpenRawResource = inputStream2;
                    HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                    HwLunarUtils.closeBufferedReader(r82);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (IOException unused3) {
            inputStreamOpenRawResource = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            r82 = inputStream;
            inputStreamOpenRawResource = inputStream2;
            HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
            HwLunarUtils.closeBufferedReader(r82);
            throw th;
        }
        if (line != null && line.length() <= 7) {
            try {
                int i11 = Integer.parseInt(line, 16);
                HashMap map = new HashMap(10);
                List<Object> listM54720a = m54720a(bufferedReader, arrayList, i11, map, 1);
                if (listM54720a != null) {
                    HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                    HwLunarUtils.closeBufferedReader(bufferedReader);
                    return listM54720a;
                }
                arrayList.add(map);
                r83 = bufferedReader;
                HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                HwLunarUtils.closeBufferedReader(r83);
                return arrayList;
            } catch (NumberFormatException unused4) {
                Log.e(f42996y, "readOneYearData: parse string to hex error, line = " + line);
                HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
                HwLunarUtils.closeBufferedReader(bufferedReader);
                return arrayList;
            }
        }
        Log.e(f42996y, "readOneYearData: year index length is illegal, line = " + line);
        HwLunarUtils.closeInputStream(inputStreamOpenRawResource);
        HwLunarUtils.closeBufferedReader(bufferedReader);
        return arrayList;
    }

    /* renamed from: b */
    private int[] m54732b(int i10) {
        return new int[]{i10 & 15, (i10 >> 4) & 31, (i10 >> 9) & 15, (i10 >> 13) & 15, (i10 >> 17) & 1, (i10 >> 18) & 1, (i10 >> 19) & 15, (i10 >> 23) & 31};
    }

    /* renamed from: b */
    private void m54731b(String[] strArr) {
        if (strArr == null || strArr.length != 4) {
            return;
        }
        this.f43015p.put(this.f43018s + this.f43019t, this.f43022w);
        ArrayList arrayList = new ArrayList(10);
        this.f43022w = arrayList;
        this.f43019t = strArr[2];
        this.f43018s = strArr[1];
        String str = strArr[3];
        this.f43020u = str;
        arrayList.add(str);
    }

    /* renamed from: a */
    private GregorianCalendar m54718a(List<Object> list, String str) {
        int i10;
        Map map = (Map) list.get(0);
        if (map.get(str) == null) {
            return null;
        }
        int iM54715a = m54715a((String) map.get(str));
        int[] iArr = {iM54715a & 15, (iM54715a >> 4) & 31, (iM54715a >> 17) & 1};
        String strSubstring = str.substring(4, 8);
        try {
            i10 = Integer.parseInt(strSubstring) + iArr[2];
        } catch (NumberFormatException unused) {
            Log.e(f42996y, "parse string to int error, lunarYear = " + strSubstring);
            i10 = 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10);
        String[] strArr = HwLunarUtils.WESTERN_MONTH;
        sb2.append(strArr[iArr[0] % strArr.length]);
        String[] strArr2 = HwLunarUtils.WESTERN_DAY;
        sb2.append(strArr2[iArr[1] % strArr2.length]);
        return m54729b(sb2.toString());
    }

    /* renamed from: a */
    private List<Object> m54720a(BufferedReader bufferedReader, List<Object> list, int i10, Map<String, String> map, int i11) throws IOException {
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            int i12 = i11 + 1;
            if (i11 > 1000) {
                Log.e(f42996y, "readOneYearData: Too many lines in one year data file");
                return list;
            }
            if (line.length() > 7) {
                Log.e(f42996y, "readOneYearData: yearData length is illegal, line = " + line);
                return list;
            }
            String[] strArrM54728a = m54728a(m54732b(m54715a(line)), i10);
            if (strArrM54728a == null || strArrM54728a.length != 4) {
                break;
            }
            map.put(strArrM54728a[1] + strArrM54728a[2] + strArrM54728a[3], line);
            m54724a(strArrM54728a);
            i11 = i12;
        }
        Log.e(f42996y, "readOneYearData: decode error");
        return list;
    }

    /* renamed from: a */
    private void m54724a(String[] strArr) {
        String str = this.f43016q.getString(C8717R.string.chinese_chu) + this.f43016q.getString(C8717R.string.one);
        if (this.f43019t == null && str.equals(strArr[3])) {
            this.f43019t = strArr[2];
            this.f43018s = strArr[1];
            String str2 = strArr[3];
            this.f43020u = str2;
            this.f43022w.add(str2);
            return;
        }
        String str3 = this.f43019t;
        if (str3 != null && strArr[2].equals(str3)) {
            String str4 = strArr[3];
            this.f43020u = str4;
            this.f43022w.add(str4);
        } else if (this.f43019t != null) {
            m54731b(strArr);
        } else {
            Log.e(f42996y, "readOneYearData: load data error");
        }
    }

    /* renamed from: a */
    private String[] m54728a(int[] iArr, int i10) {
        if (iArr != null && iArr.length == 8) {
            String[] strArr = new String[4];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            String[] strArr2 = HwLunarUtils.WESTERN_MONTH;
            sb2.append(strArr2[iArr[0] % strArr2.length]);
            String[] strArr3 = HwLunarUtils.WESTERN_DAY;
            sb2.append(strArr3[iArr[1] % strArr3.length]);
            strArr[0] = sb2.toString();
            int i11 = i10 - iArr[4];
            StringBuilder sb3 = new StringBuilder();
            String[] strArr4 = HwLunarUtils.TIAN_GAN;
            sb3.append(strArr4[iArr[2] % strArr4.length]);
            String[] strArr5 = HwLunarUtils.DI_ZHI;
            sb3.append(strArr5[iArr[3] % strArr5.length]);
            String[] strArr6 = HwLunarUtils.ZIADOC;
            sb3.append(strArr6[iArr[3] % strArr6.length]);
            sb3.append("年");
            sb3.append(i11);
            strArr[1] = sb3.toString();
            if (iArr[5] == 0) {
                String[] strArr7 = HwLunarUtils.LUNAR_MONTH;
                strArr[2] = strArr7[iArr[6] % strArr7.length];
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(HwConstants.LUNAR_RUN);
                String[] strArr8 = HwLunarUtils.LUNAR_MONTH;
                sb4.append(strArr8[iArr[6] % strArr8.length]);
                strArr[2] = sb4.toString();
            }
            String[] strArr9 = HwLunarUtils.LUNAR_DAY;
            strArr[3] = strArr9[iArr[7] % strArr9.length];
            return strArr;
        }
        Log.e(f42996y, "decode year index error");
        return new String[0];
    }
}
