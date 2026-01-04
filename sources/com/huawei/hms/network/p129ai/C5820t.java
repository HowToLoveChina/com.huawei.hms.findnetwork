package com.huawei.hms.network.p129ai;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.inner.api.NetworkService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.hms.network.ai.t */
/* loaded from: classes8.dex */
public class C5820t implements InterfaceC5798g {

    /* renamed from: A */
    public static final String f26050A = "protocol";

    /* renamed from: B */
    public static final String f26051B = "networkType";

    /* renamed from: C */
    public static final String f26052C = "table_timezone";

    /* renamed from: D */
    public static final String f26053D = "timezoneArray";

    /* renamed from: E */
    public static final String f26054E = "timezoneCountArray";

    /* renamed from: F */
    public static final int f26055F = 24;

    /* renamed from: G */
    public static final long f26056G = 30000;

    /* renamed from: H */
    public static final String f26057H = ",";

    /* renamed from: I */
    public static final String f26058I = ":";

    /* renamed from: J */
    public static final String f26059J;

    /* renamed from: K */
    public static final String f26060K;

    /* renamed from: L */
    public static final String f26061L;

    /* renamed from: M */
    public static final String f26062M = "connect_time_2s.model";

    /* renamed from: N */
    public static final String f26063N = "connect_time_4s.model";

    /* renamed from: O */
    public static final String f26064O = "connect_time_fail.model";

    /* renamed from: m */
    public static final String f26065m = "ConnectTimeoutModelData";

    /* renamed from: n */
    public static final String f26066n = "table_connecttimeout";

    /* renamed from: o */
    public static final String f26067o = "starttime";

    /* renamed from: p */
    public static final String f26068p = "connecttime";

    /* renamed from: q */
    public static final String f26069q = "ttfb";

    /* renamed from: r */
    public static final String f26070r = "table_laststatus";

    /* renamed from: s */
    public static final String f26071s = "wifiSignalStrength";

    /* renamed from: t */
    public static final String f26072t = "mobileSignalStrength";

    /* renamed from: u */
    public static final String f26073u = "networkChange";

    /* renamed from: v */
    public static final String f26074v = "callStartNetworkType";

    /* renamed from: w */
    public static final String f26075w = "rcReqStartTime";

    /* renamed from: x */
    public static final String f26076x = "csRsrq";

    /* renamed from: y */
    public static final String f26077y = "csRssnr";

    /* renamed from: z */
    public static final String f26078z = "csRssi";

    /* renamed from: a */
    public float f26079a = 0.94f;

    /* renamed from: b */
    public float f26080b = 0.95f;

    /* renamed from: c */
    public float f26081c = 0.8f;

    /* renamed from: d */
    public LinkedHashMap<Long, C5818r> f26082d = new LinkedHashMap<>();

    /* renamed from: e */
    public C5822v f26083e = null;

    /* renamed from: f */
    public int[] f26084f = new int[24];

    /* renamed from: g */
    public int[] f26085g = new int[24];

    /* renamed from: h */
    public C5813n0 f26086h = null;

    /* renamed from: i */
    public C5813n0 f26087i = null;

    /* renamed from: j */
    public C5813n0 f26088j = null;

    /* renamed from: k */
    public int f26089k = 0;

    /* renamed from: l */
    public final Object f26090l = new Object();

    /* renamed from: com.huawei.hms.network.ai.t$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f26091a;

        public a(List list) {
            this.f26091a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5820t.this.m33509a((List<Long>) this.f26091a);
        }
    }

    static {
        Locale locale = Locale.ENGLISH;
        f26059J = String.format(locale, "create table if not exists %s(%s long, %s long, %s long)", f26066n, f26067o, f26068p, "ttfb");
        f26060K = String.format(locale, "create table if not exists %s(%s integer, %s integer, %s integer, %s integer, %s long, %s long, %s long, %s integer, %s integer, %s integer, %s varchar(128), %s integer)", f26070r, f26071s, f26072t, "networkChange", f26074v, f26075w, f26068p, "ttfb", f26076x, f26077y, f26078z, "protocol", "networkType");
        f26061L = String.format(locale, "create table if not exists %s(%s varchar(168), %s varchar(264))", f26052C, f26053D, f26054E);
    }

    /* renamed from: i */
    private void m33515i() {
        Cursor cursor = null;
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f26066n);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex(f26067o);
                    int columnIndex2 = cursorM33262a.getColumnIndex(f26068p);
                    int columnIndex3 = cursorM33262a.getColumnIndex("ttfb");
                    while (cursorM33262a.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(f26067o, Long.valueOf(cursorM33262a.getLong(columnIndex)));
                        contentValues.put(f26068p, Long.valueOf(cursorM33262a.getLong(columnIndex2)));
                        contentValues.put("ttfb", Long.valueOf(cursorM33262a.getLong(columnIndex3)));
                        C5790c.m33256f().m33261a(f26066n, contentValues);
                    }
                    if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), f26066n, (String) null, (String[]) null) == 1) {
                        Logger.m32141i(f26065m, "InitModel checkTableConnecttimeoutData success");
                    }
                } catch (Throwable unused) {
                    cursor = cursorM33262a;
                    try {
                        Logger.m32138e(f26065m, "meet exception when checkTableConnecttimeoutData");
                        return;
                    } finally {
                        IoUtils.close(cursor);
                    }
                }
            }
            IoUtils.close(cursorM33262a);
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: j */
    private void m33516j() {
        String str;
        Cursor cursor;
        String str2 = "networkType";
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f26070r);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex(f26071s);
                    try {
                        int columnIndex2 = cursorM33262a.getColumnIndex(f26072t);
                        String str3 = f26070r;
                        int columnIndex3 = cursorM33262a.getColumnIndex("networkChange");
                        String str4 = "networkChange";
                        int columnIndex4 = cursorM33262a.getColumnIndex(f26074v);
                        String str5 = f26074v;
                        int columnIndex5 = cursorM33262a.getColumnIndex(f26075w);
                        String str6 = f26075w;
                        int columnIndex6 = cursorM33262a.getColumnIndex(f26068p);
                        String str7 = f26068p;
                        int columnIndex7 = cursorM33262a.getColumnIndex("ttfb");
                        String str8 = "ttfb";
                        int columnIndex8 = cursorM33262a.getColumnIndex(f26076x);
                        String str9 = f26076x;
                        int columnIndex9 = cursorM33262a.getColumnIndex(f26077y);
                        String str10 = f26077y;
                        int columnIndex10 = cursorM33262a.getColumnIndex(f26078z);
                        String str11 = f26078z;
                        int columnIndex11 = cursorM33262a.getColumnIndex("protocol");
                        String str12 = "protocol";
                        int columnIndex12 = cursorM33262a.getColumnIndex("networkType");
                        while (cursorM33262a.moveToNext()) {
                            String str13 = str2;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(f26071s, Integer.valueOf(cursorM33262a.getInt(columnIndex)));
                            contentValues.put(f26072t, Integer.valueOf(cursorM33262a.getInt(columnIndex2)));
                            int i10 = columnIndex2;
                            String str14 = str4;
                            contentValues.put(str14, Integer.valueOf(cursorM33262a.getInt(columnIndex3)));
                            str4 = str14;
                            String str15 = str5;
                            contentValues.put(str15, Integer.valueOf(cursorM33262a.getInt(columnIndex4)));
                            str5 = str15;
                            String str16 = str6;
                            contentValues.put(str16, Long.valueOf(cursorM33262a.getLong(columnIndex5)));
                            str6 = str16;
                            String str17 = str7;
                            contentValues.put(str17, Long.valueOf(cursorM33262a.getLong(columnIndex6)));
                            str7 = str17;
                            String str18 = str8;
                            contentValues.put(str18, Long.valueOf(cursorM33262a.getLong(columnIndex7)));
                            str8 = str18;
                            String str19 = str9;
                            contentValues.put(str19, Integer.valueOf(cursorM33262a.getInt(columnIndex8)));
                            str9 = str19;
                            String str20 = str10;
                            contentValues.put(str20, Integer.valueOf(cursorM33262a.getInt(columnIndex9)));
                            str10 = str20;
                            String str21 = str11;
                            contentValues.put(str21, Integer.valueOf(cursorM33262a.getInt(columnIndex10)));
                            str11 = str21;
                            String str22 = str12;
                            contentValues.put(str22, cursorM33262a.getString(columnIndex11));
                            str12 = str22;
                            contentValues.put(str13, Integer.valueOf(cursorM33262a.getInt(columnIndex12)));
                            String str23 = str3;
                            C5790c.m33256f().m33261a(str23, contentValues);
                            str3 = str23;
                            str2 = str13;
                            columnIndex2 = i10;
                            columnIndex = columnIndex;
                        }
                        if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), str3, (String) null, (String[]) null) == 1) {
                            str = f26065m;
                            try {
                                Logger.m32141i(str, "InitModel checkTableLaststatusData success");
                            } catch (Throwable unused) {
                                cursor = cursorM33262a;
                                try {
                                    Logger.m32138e(str, "meet exception when checkTableLaststatusData");
                                    return;
                                } finally {
                                    IoUtils.close(cursor);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        str = f26065m;
                    }
                } catch (Throwable unused3) {
                    str = f26065m;
                }
            }
            IoUtils.close(cursorM33262a);
        } catch (Throwable unused4) {
            str = f26065m;
            cursor = null;
        }
    }

    /* renamed from: k */
    private void m33517k() {
        Cursor cursor = null;
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f26052C);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex(f26053D);
                    int columnIndex2 = cursorM33262a.getColumnIndex(f26054E);
                    while (cursorM33262a.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(f26053D, cursorM33262a.getString(columnIndex));
                        contentValues.put(f26054E, cursorM33262a.getString(columnIndex2));
                        C5790c.m33256f().m33261a(f26052C, contentValues);
                    }
                    if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), f26052C, (String) null, (String[]) null) == 1) {
                        Logger.m32141i(f26065m, "InitModel checkTableTimezoneData success");
                    }
                } catch (Throwable unused) {
                    cursor = cursorM33262a;
                    try {
                        Logger.m32138e(f26065m, "meet exception when checkTableTimezoneData");
                        return;
                    } finally {
                        IoUtils.close(cursor);
                    }
                }
            }
            IoUtils.close(cursorM33262a);
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: l */
    private int m33518l() {
        return Integer.parseInt(new SimpleDateFormat("HH", Locale.ENGLISH).format(new Date()));
    }

    /* renamed from: m */
    private void m33519m() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, C5818r>> it = this.f26082d.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, C5818r> next = it.next();
            if (System.currentTimeMillis() - next.getKey().longValue() <= 600000) {
                break;
            }
            arrayList.add(next.getKey());
            it.remove();
        }
        if (arrayList.size() != 0) {
            C5794e.m33310a().m33311a(new a(arrayList));
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public Object mo33237a() {
        C5822v c5822v;
        Cursor cursorM33265a;
        synchronized (this.f26090l) {
            try {
                cursorM33265a = C5790c.m33256f().m33265a(f26070r, null, null, null, null, null, null);
            } catch (Throwable unused) {
                c5822v = null;
                cursorM33265a = null;
            }
            try {
                int columnIndex = cursorM33265a.getColumnIndex(f26071s);
                int columnIndex2 = cursorM33265a.getColumnIndex(f26072t);
                int columnIndex3 = cursorM33265a.getColumnIndex("networkChange");
                int columnIndex4 = cursorM33265a.getColumnIndex(f26074v);
                int columnIndex5 = cursorM33265a.getColumnIndex(f26075w);
                int columnIndex6 = cursorM33265a.getColumnIndex(f26068p);
                int columnIndex7 = cursorM33265a.getColumnIndex("ttfb");
                int columnIndex8 = cursorM33265a.getColumnIndex(f26076x);
                int columnIndex9 = cursorM33265a.getColumnIndex(f26077y);
                int columnIndex10 = cursorM33265a.getColumnIndex(f26078z);
                int columnIndex11 = cursorM33265a.getColumnIndex("protocol");
                int columnIndex12 = cursorM33265a.getColumnIndex("networkType");
                StringBuilder sb2 = new StringBuilder();
                int i10 = columnIndex11;
                sb2.append("size ");
                sb2.append(cursorM33265a.getCount());
                Logger.m32141i(f26065m, sb2.toString());
                while (cursorM33265a.moveToNext()) {
                    C5822v c5822v2 = new C5822v();
                    this.f26083e = c5822v2;
                    c5822v2.m33547h(cursorM33265a.getInt(columnIndex));
                    this.f26083e.m33541e(cursorM33265a.getInt(columnIndex2));
                    this.f26083e.m33543f(cursorM33265a.getInt(columnIndex3));
                    this.f26083e.m33529a(cursorM33265a.getInt(columnIndex4));
                    this.f26083e.m33534b(cursorM33265a.getLong(columnIndex5));
                    this.f26083e.m33530a(cursorM33265a.getLong(columnIndex6));
                    this.f26083e.m33537c(cursorM33265a.getLong(columnIndex7));
                    this.f26083e.m33533b(cursorM33265a.getInt(columnIndex8));
                    this.f26083e.m33539d(cursorM33265a.getInt(columnIndex9));
                    this.f26083e.m33536c(cursorM33265a.getInt(columnIndex10));
                    int i11 = i10;
                    this.f26083e.m33531a(cursorM33265a.getString(i11));
                    int i12 = columnIndex12;
                    int i13 = columnIndex;
                    this.f26083e.m33545g(cursorM33265a.getInt(i12));
                    i10 = i11;
                    columnIndex = i13;
                    columnIndex12 = i12;
                }
            } catch (Throwable unused2) {
                c5822v = null;
                try {
                    this.f26083e = c5822v;
                    Logger.m32138e(f26065m, "meet exception when getting connecttimeout status data");
                    return this.f26083e;
                } finally {
                    IoUtils.close(cursorM33265a);
                }
            }
        }
        return this.f26083e;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: b */
    public Object mo33245b() {
        Cursor cursorM33265a;
        synchronized (this.f26090l) {
            this.f26082d.clear();
            try {
                cursorM33265a = C5790c.m33256f().m33265a(f26066n, null, null, null, null, null, null);
                try {
                    int columnIndex = cursorM33265a.getColumnIndex(f26067o);
                    int columnIndex2 = cursorM33265a.getColumnIndex(f26068p);
                    int columnIndex3 = cursorM33265a.getColumnIndex("ttfb");
                    Logger.m32141i(f26065m, "size " + cursorM33265a.getCount());
                    while (cursorM33265a.moveToNext()) {
                        long j10 = cursorM33265a.getLong(columnIndex);
                        this.f26082d.put(Long.valueOf(j10), new C5818r(j10, cursorM33265a.getLong(columnIndex2), cursorM33265a.getLong(columnIndex3)));
                    }
                } catch (Throwable unused) {
                    try {
                        Logger.m32138e(f26065m, "meet exception when getting connecttimeout model data");
                        return this.f26082d;
                    } finally {
                        IoUtils.close(cursorM33265a);
                    }
                }
            } catch (Throwable unused2) {
                cursorM33265a = null;
            }
        }
        return this.f26082d;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: c */
    public void mo33246c() {
        m33516j();
        m33515i();
        m33517k();
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: d */
    public void mo33247d() {
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x01d1 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:147:0x001c, B:149:0x002d, B:152:0x0034, B:183:0x012e, B:195:0x01bc, B:203:0x01e6, B:215:0x0208, B:217:0x02e0, B:219:0x0309, B:220:0x0310, B:223:0x0314, B:225:0x0320, B:226:0x0325, B:229:0x0329, B:238:0x0342, B:240:0x0393, B:242:0x03ba, B:243:0x03bf, B:246:0x03c3, B:247:0x03c8, B:199:0x01d1, B:167:0x00e1, B:177:0x010b, B:249:0x03ca, B:251:0x03d9, B:256:0x03e4, B:260:0x03ea, B:262:0x03ec, B:264:0x03ee), top: B:271:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0309 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:147:0x001c, B:149:0x002d, B:152:0x0034, B:183:0x012e, B:195:0x01bc, B:203:0x01e6, B:215:0x0208, B:217:0x02e0, B:219:0x0309, B:220:0x0310, B:223:0x0314, B:225:0x0320, B:226:0x0325, B:229:0x0329, B:238:0x0342, B:240:0x0393, B:242:0x03ba, B:243:0x03bf, B:246:0x03c3, B:247:0x03c8, B:199:0x01d1, B:167:0x00e1, B:177:0x010b, B:249:0x03ca, B:251:0x03d9, B:256:0x03e4, B:260:0x03ea, B:262:0x03ec, B:264:0x03ee), top: B:271:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0314 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:147:0x001c, B:149:0x002d, B:152:0x0034, B:183:0x012e, B:195:0x01bc, B:203:0x01e6, B:215:0x0208, B:217:0x02e0, B:219:0x0309, B:220:0x0310, B:223:0x0314, B:225:0x0320, B:226:0x0325, B:229:0x0329, B:238:0x0342, B:240:0x0393, B:242:0x03ba, B:243:0x03bf, B:246:0x03c3, B:247:0x03c8, B:199:0x01d1, B:167:0x00e1, B:177:0x010b, B:249:0x03ca, B:251:0x03d9, B:256:0x03e4, B:260:0x03ea, B:262:0x03ec, B:264:0x03ee), top: B:271:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03ba A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:147:0x001c, B:149:0x002d, B:152:0x0034, B:183:0x012e, B:195:0x01bc, B:203:0x01e6, B:215:0x0208, B:217:0x02e0, B:219:0x0309, B:220:0x0310, B:223:0x0314, B:225:0x0320, B:226:0x0325, B:229:0x0329, B:238:0x0342, B:240:0x0393, B:242:0x03ba, B:243:0x03bf, B:246:0x03c3, B:247:0x03c8, B:199:0x01d1, B:167:0x00e1, B:177:0x010b, B:249:0x03ca, B:251:0x03d9, B:256:0x03e4, B:260:0x03ea, B:262:0x03ec, B:264:0x03ee), top: B:271:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03c3 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:147:0x001c, B:149:0x002d, B:152:0x0034, B:183:0x012e, B:195:0x01bc, B:203:0x01e6, B:215:0x0208, B:217:0x02e0, B:219:0x0309, B:220:0x0310, B:223:0x0314, B:225:0x0320, B:226:0x0325, B:229:0x0329, B:238:0x0342, B:240:0x0393, B:242:0x03ba, B:243:0x03bf, B:246:0x03c3, B:247:0x03c8, B:199:0x01d1, B:167:0x00e1, B:177:0x010b, B:249:0x03ca, B:251:0x03d9, B:256:0x03e4, B:260:0x03ea, B:262:0x03ec, B:264:0x03ee), top: B:271:0x001c }] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m33521e() {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.p129ai.C5820t.m33521e():int");
    }

    /* renamed from: f */
    public void m33522f() {
        Cursor cursorM33265a;
        synchronized (this.f26090l) {
            try {
                cursorM33265a = C5790c.m33256f().m33265a(f26052C, null, null, null, null, null, null);
                try {
                    int columnIndex = cursorM33265a.getColumnIndex(f26053D);
                    int columnIndex2 = cursorM33265a.getColumnIndex(f26054E);
                    Logger.m32141i(f26065m, "time zone size " + cursorM33265a.getCount());
                    while (cursorM33265a.moveToNext()) {
                        String[] strArrSplit = cursorM33265a.getString(columnIndex).split(",");
                        if (strArrSplit.length == 24) {
                            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                                this.f26084f[i10] = Integer.parseInt(strArrSplit[i10]);
                            }
                        }
                        String[] strArrSplit2 = cursorM33265a.getString(columnIndex2).split(",");
                        if (strArrSplit2.length == 24) {
                            for (int i11 = 0; i11 < strArrSplit2.length; i11++) {
                                this.f26085g[i11] = Integer.parseInt(strArrSplit2[i11]);
                            }
                        }
                    }
                } catch (Throwable unused) {
                    try {
                        Logger.m32138e(f26065m, "meet exception when getting timezone data");
                    } finally {
                        IoUtils.close(cursorM33265a);
                    }
                }
            } catch (Throwable unused2) {
                cursorM33265a = null;
            }
        }
    }

    /* renamed from: g */
    public boolean m33523g() {
        Logger.m32141i(f26065m, "initPredictor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ContextHolder.getAppContext().getFilesDir().getPath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("networkkit");
        sb2.append(str);
        String string = sb2.toString();
        String str2 = string + f26062M;
        String str3 = string + f26063N;
        String str4 = string + f26064O;
        File file = new File(str2);
        File file2 = new File(str3);
        File file3 = new File(str4);
        if (!file.exists() || !file2.exists() || !file3.exists()) {
            Logger.m32138e(f26065m, "initPredictor fail because model file not exists");
            return false;
        }
        synchronized (this.f26090l) {
            try {
                try {
                    this.f26086h = new C5813n0(new FileInputStream(file));
                    this.f26087i = new C5813n0(new FileInputStream(file2));
                    this.f26088j = new C5813n0(new FileInputStream(file3));
                } catch (NoClassDefFoundError unused) {
                    Logger.m32138e(f26065m, "initPredictor meet no class error");
                    return false;
                } catch (RuntimeException unused2) {
                    Logger.m32138e(f26065m, "initPredictor meet runtime exception");
                } catch (VerifyError unused3) {
                    Logger.m32138e(f26065m, "initPredictor meet verify error");
                    return false;
                }
            } catch (FileNotFoundException unused4) {
                Logger.m32138e(f26065m, "initPredictor meet model not find");
                return false;
            } catch (IOException unused5) {
                Logger.m32138e(f26065m, "initPredictor meet io exception");
                return false;
            }
        }
        this.f26089k = EmuiUtil.getEMUIVersionCode();
        Logger.m32141i(f26065m, "initPredictor success");
        return true;
    }

    /* renamed from: h */
    public void m33524h() {
        String strReplaceAll = String.valueOf(ConfigAPI.getValue(NetworkService.Constants.AI_CONNECTTIMEOUT_THRESHOLD)).replaceAll(" ", "");
        if (TextUtils.isEmpty(strReplaceAll)) {
            Logger.m32141i(f26065m, "remote thresholds is null, use default value");
            return;
        }
        String[] strArrSplit = strReplaceAll.split(",");
        HashMap map = new HashMap();
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split(":");
            map.put(strArrSplit2[0], Float.valueOf(Float.parseFloat(strArrSplit2[1])));
        }
        if (map.containsKey(C5788b.f25748r)) {
            this.f26079a = ((Float) map.get(C5788b.f25748r)).floatValue();
        }
        if (map.containsKey(C5788b.f25749s)) {
            this.f26080b = ((Float) map.get(C5788b.f25749s)).floatValue();
        }
        if (map.containsKey(C5788b.f25750t)) {
            this.f26081c = ((Float) map.get(C5788b.f25750t)).floatValue();
        }
    }

    /* renamed from: a */
    private String m33505a(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (i10 != iArr.length - 1) {
                stringBuffer.append(iArr[i10] + ",");
            } else {
                stringBuffer.append(iArr[i10]);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private void m33512b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        Logger.m32141i(f26065m, "connectTimeout modle create status table");
        try {
            sQLiteDatabase.execSQL(f26060K);
        } catch (SQLException unused) {
            Logger.m32138e(f26065m, "execSQL fail on create status table");
        }
    }

    /* renamed from: c */
    private void m33513c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        Logger.m32141i(f26065m, "connectTimeout modle create time table");
        try {
            sQLiteDatabase.execSQL(f26059J);
        } catch (SQLException unused) {
            Logger.m32138e(f26065m, "execSQL fail on create time table");
        }
    }

    /* renamed from: d */
    private void m33514d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        Logger.m32141i(f26065m, "connectTimeout timezone create time table");
        try {
            sQLiteDatabase.execSQL(f26061L);
        } catch (SQLException unused) {
            Logger.m32138e(f26065m, "execSQL fail on create timezone table");
        }
    }

    /* renamed from: a */
    private void m33506a(long j10) {
        if (j10 <= 30000) {
            int iM33518l = m33518l();
            int[] iArr = this.f26084f;
            long j11 = iArr[iM33518l];
            int[] iArr2 = this.f26085g;
            int i10 = iArr2[iM33518l];
            if (j11 == 0) {
                iArr[iM33518l] = (int) j10;
            } else {
                iArr[iM33518l] = (int) (((j11 * i10) + j10) / (i10 + 1));
            }
            iArr2[iM33518l] = i10 + 1;
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33239a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m33513c(sQLiteDatabase);
        m33512b(sQLiteDatabase);
        m33514d(sQLiteDatabase);
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33240a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    /* renamed from: a */
    public void m33520a(C5822v c5822v) {
        Logger.m32141i(f26065m, "addNetworkStatusCache");
        synchronized (this.f26090l) {
            try {
                SQLiteDatabase sQLiteDatabaseM33270d = C5790c.m33256f().m33270d();
                if (sQLiteDatabaseM33270d == null) {
                    return;
                }
                this.f26083e = c5822v;
                this.f26082d.put(Long.valueOf(c5822v.m33549j()), new C5818r(c5822v.m33549j(), c5822v.m33532b(), c5822v.m33550k()));
                m33506a(c5822v.m33532b());
                try {
                    try {
                        sQLiteDatabaseM33270d.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(f26067o, Long.valueOf(c5822v.m33549j()));
                        contentValues.put(f26068p, Long.valueOf(c5822v.m33532b()));
                        contentValues.put("ttfb", Long.valueOf(c5822v.m33550k()));
                        C5790c.m33256f().m33261a(f26066n, contentValues);
                        C5790c.m33256f().m33260a(f26070r, null, null);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put(f26071s, Integer.valueOf(c5822v.m33551l()));
                        contentValues2.put(f26072t, Integer.valueOf(c5822v.m33542f()));
                        contentValues2.put("networkChange", Integer.valueOf(c5822v.m33544g()));
                        contentValues2.put(f26074v, Integer.valueOf(c5822v.m33528a()));
                        contentValues2.put(f26075w, Long.valueOf(c5822v.m33549j()));
                        contentValues2.put(f26068p, Long.valueOf(c5822v.m33532b()));
                        contentValues2.put("ttfb", Long.valueOf(c5822v.m33550k()));
                        contentValues2.put(f26076x, Integer.valueOf(c5822v.m33535c()));
                        contentValues2.put(f26077y, Integer.valueOf(c5822v.m33540e()));
                        contentValues2.put(f26078z, Integer.valueOf(c5822v.m33538d()));
                        contentValues2.put("protocol", c5822v.m33548i());
                        contentValues2.put("networkType", Integer.valueOf(c5822v.m33546h()));
                        C5790c.m33256f().m33261a(f26070r, contentValues2);
                        if (c5822v.m33532b() <= 30000) {
                            C5790c.m33256f().m33260a(f26052C, null, null);
                            ContentValues contentValues3 = new ContentValues();
                            contentValues3.put(f26053D, m33505a(this.f26084f));
                            contentValues3.put(f26054E, m33505a(this.f26085g));
                            C5790c.m33256f().m33261a(f26052C, contentValues3);
                        }
                        sQLiteDatabaseM33270d.setTransactionSuccessful();
                    } catch (Throwable unused) {
                        Logger.m32145w(f26065m, "Transaction will roll back in addNetworkStatusCache");
                    }
                } finally {
                    sQLiteDatabaseM33270d.endTransaction();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33242a(Object obj) {
    }

    /* renamed from: a */
    private void m33508a(String str, long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
        HashMap map = new HashMap();
        map.put(C5804j.f25911h, C5788b.f25735e);
        map.put(C5804j.f25918o, str);
        map.put(C5804j.f25919p, String.valueOf(jElapsedRealtime));
        C5804j.m33379a(map);
    }

    /* renamed from: a */
    public void m33509a(List<Long> list) {
        Logger.m32138e(f26065m, " deleteDb");
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10] = String.valueOf(list.get(i10));
        }
        SQLiteDatabase sQLiteDatabaseM33270d = C5790c.m33256f().m33270d();
        if (sQLiteDatabaseM33270d != null) {
            try {
                try {
                    sQLiteDatabaseM33270d.beginTransaction();
                    for (int i11 = 0; i11 < size; i11++) {
                        C5790c.m33256f().m33260a(f26066n, "starttime = ?", new String[]{strArr[i11]});
                    }
                    sQLiteDatabaseM33270d.setTransactionSuccessful();
                } catch (Throwable unused) {
                    Logger.m32145w(f26065m, "Transaction will roll back in deleteDb");
                }
            } finally {
                sQLiteDatabaseM33270d.endTransaction();
            }
        }
    }

    /* renamed from: a */
    private boolean m33510a(int i10) {
        return (i10 == -1 || i10 == 1 || i10 == 5) ? false : true;
    }

    /* renamed from: a */
    private boolean m33511a(C5813n0 c5813n0, InterfaceC5811m0 interfaceC5811m0, float f10) {
        float[] fArrM33465a = c5813n0.m33465a(interfaceC5811m0);
        return fArrM33465a.length > 0 && fArrM33465a[0] > f10;
    }
}
