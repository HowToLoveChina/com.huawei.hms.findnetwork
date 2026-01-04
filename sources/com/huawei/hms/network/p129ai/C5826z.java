package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.CreateFileUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.inner.api.RequestContext;
import com.huawei.hms.network.p129ai.InterfaceC5811m0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.network.ai.z */
/* loaded from: classes8.dex */
public class C5826z implements InterfaceC5802i {

    /* renamed from: A */
    public static final int f26134A = 8;

    /* renamed from: B */
    public static final int f26135B = 30000;

    /* renamed from: C */
    public static final int f26136C = 960000;

    /* renamed from: D */
    public static final String f26137D = "ai_websocketpingmodel_download";

    /* renamed from: E */
    public static final String f26138E = "lastDownloadTime";

    /* renamed from: F */
    public static final long f26139F = 604800000;

    /* renamed from: g */
    public static final String f26140g = "WebSocketPingModel";

    /* renamed from: h */
    public static final String f26141h = "Wise_ping.model";

    /* renamed from: i */
    public static final int f26142i = -1;

    /* renamed from: j */
    public static final int f26143j = 30000;

    /* renamed from: k */
    public static final int f26144k = 6000;

    /* renamed from: l */
    public static final float f26145l = 5.0f;

    /* renamed from: m */
    public static final int f26146m = 3;

    /* renamed from: n */
    public static final int f26147n = 5;

    /* renamed from: o */
    public static final int f26148o = -127;

    /* renamed from: p */
    public static final int f26149p = Integer.MAX_VALUE;

    /* renamed from: q */
    public static final int f26150q = -95;

    /* renamed from: r */
    public static final int f26151r = -90;

    /* renamed from: s */
    public static final int f26152s = -80;

    /* renamed from: t */
    public static final int f26153t = 150;

    /* renamed from: u */
    public static final int f26154u = 300;

    /* renamed from: v */
    public static final int f26155v = 400;

    /* renamed from: w */
    public static final int f26156w = 500;

    /* renamed from: x */
    public static final int f26157x = 5;

    /* renamed from: y */
    public static final int f26158y = 6;

    /* renamed from: z */
    public static final int f26159z = 7;

    /* renamed from: a */
    public C5787a0 f26160a;

    /* renamed from: b */
    public C5813n0 f26161b = null;

    /* renamed from: c */
    public int f26162c = 0;

    /* renamed from: d */
    public int f26163d = 0;

    /* renamed from: e */
    public int f26164e = 0;

    /* renamed from: f */
    public PLSharedPreferences f26165f = new PLSharedPreferences(ContextHolder.getResourceContext(), f26137D);

    /* renamed from: com.huawei.hms.network.ai.z$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5826z.this.f26160a.mo33245b();
            C5826z.this.f26162c = StringUtils.stringToInteger(String.valueOf(ConfigAPI.getValue("ai_ping_minthreshold")), 0);
            C5826z.this.f26163d = StringUtils.stringToInteger(String.valueOf(ConfigAPI.getValue("ai_ping_nat")), C5826z.f26136C);
            C5826z.this.f26164e = r3.f26163d - 30000;
        }
    }

    public C5826z(C5787a0 c5787a0) {
        this.f26160a = c5787a0;
    }

    /* renamed from: b */
    private int m33608b(int i10) {
        int i11 = this.f26162c;
        return i11 != 0 ? i11 : i10 / 2;
    }

    /* renamed from: d */
    private Map<String, Integer> m33613d(C5824x c5824x) {
        if (!c5824x.m33597q()) {
            return null;
        }
        HashMap map = new HashMap();
        if (c5824x.m33577e() >= 3) {
            return this.f26160a.m33238a(c5824x.m33564a(), c5824x.m33583h(), c5824x.m33589k(), c5824x.m33579f());
        }
        map.put("ping", Integer.valueOf(c5824x.m33591l()));
        map.put("pingStatus", Integer.valueOf(c5824x.m33594n()));
        map.put("delayPing", Integer.valueOf(c5824x.m33575d()));
        map.put("delayTimes", Integer.valueOf(c5824x.m33577e() + 1));
        return map;
    }

    /* renamed from: e */
    private int m33614e(C5824x c5824x) {
        int iM33236a = this.f26160a.m33236a(c5824x.m33583h(), c5824x.m33589k(), c5824x.m33579f());
        return iM33236a != 0 ? iM33236a : c5824x.m33564a();
    }

    /* renamed from: f */
    private int m33616f(C5824x c5824x) {
        int iM33608b = m33608b(c5824x.m33564a());
        if (Float.compare(5.0f, this.f26160a.m33244b(c5824x)) != -1 && c5824x.m33587j() != 1 && c5824x.m33589k() != -1 && c5824x.m33589k() != 0 && c5824x.m33589k() != 2 && c5824x.m33589k() != 3) {
            if (c5824x.m33589k() != 1) {
                return (c5824x.m33585i() < -90 || c5824x.m33585i() == Integer.MAX_VALUE || m33611b(c5824x.m33593m()) > 300) ? iM33608b : c5824x.m33564a();
            }
            if (c5824x.m33595o() < -95 || c5824x.m33595o() == -127) {
                return iM33608b;
            }
            if (c5824x.m33595o() < -80) {
                return 6000;
            }
            if (m33611b(c5824x.m33593m()) > 500) {
                return iM33608b;
            }
            if (m33611b(c5824x.m33593m()) > 150) {
                return 6000;
            }
            return c5824x.m33564a();
        }
        return iM33608b;
    }

    /* renamed from: g */
    private Map<String, Integer> m33617g(C5824x c5824x) {
        int iM33594n;
        HashMap map = new HashMap();
        if (c5824x.m33597q()) {
            return m33619i(c5824x);
        }
        if (c5824x.m33568b() != 0) {
            map.put("ping", Integer.valueOf(c5824x.m33596p() ? m33624a(c5824x.m33591l(), c5824x.m33564a()) : c5824x.m33591l()));
            iM33594n = c5824x.m33594n();
        } else {
            map.put("ping", Integer.valueOf(m33624a(c5824x.m33591l(), c5824x.m33564a())));
            iM33594n = 0;
        }
        map.put("pingStatus", Integer.valueOf(iM33594n));
        this.f26160a.m33243a(c5824x.m33583h(), c5824x.m33581g(), c5824x.m33579f(), ((Integer) map.get("ping")).intValue(), ((Integer) map.get("pingStatus")).intValue());
        return map;
    }

    /* renamed from: h */
    private Map<String, Integer> m33618h(C5824x c5824x) {
        HashMap map = new HashMap();
        if (c5824x.m33597q()) {
            return m33619i(c5824x);
        }
        map.put("ping", Integer.valueOf(c5824x.m33564a()));
        map.put("pingStatus", 1);
        if (c5824x.m33587j() != 1 && c5824x.m33589k() != -1 && c5824x.m33589k() != 0) {
            this.f26160a.m33243a(c5824x.m33583h(), c5824x.m33581g(), c5824x.m33579f(), ((Integer) map.get("ping")).intValue(), ((Integer) map.get("pingStatus")).intValue());
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.Integer> m33619i(com.huawei.hms.network.p129ai.C5824x r14) {
        /*
            r13 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = r14.m33568b()
            java.lang.String r2 = "continueTimes"
            java.lang.String r3 = "continuePing"
            r4 = 1
            java.lang.String r5 = "ping"
            java.lang.String r6 = "pingStatus"
            if (r1 == 0) goto L6c
            int r1 = r14.m33572c()
            r7 = 5
            if (r1 >= r7) goto L4a
            int r13 = r14.m33591l()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r0.put(r5, r13)
            int r13 = r14.m33594n()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r0.put(r6, r13)
            int r13 = r14.m33568b()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r0.put(r3, r13)
            int r13 = r14.m33572c()
            int r13 = r13 + r4
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        L45:
            r0.put(r2, r13)
            goto Ldf
        L4a:
            r1 = 2
            int r1 = r13.m33602a(r1, r14)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r0.put(r5, r2)
            int r2 = r14.m33594n()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r6, r2)
            int r2 = r14.m33594n()
            if (r2 != r4) goto Ldf
            int r2 = r13.f26164e
            if (r1 != r2) goto Lba
            goto Lb2
        L6c:
            int r1 = r13.m33620j(r14)
            r7 = 6000(0x1770, float:8.408E-42)
            if (r1 != r7) goto L96
            int r13 = r14.m33591l()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r0.put(r5, r13)
            int r13 = r14.m33594n()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r0.put(r6, r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r0.put(r3, r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)
            goto L45
        L96:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r0.put(r5, r2)
            int r2 = r14.m33594n()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r6, r2)
            int r2 = r14.m33594n()
            if (r2 != r4) goto Ldf
            int r2 = r13.f26164e
            if (r1 != r2) goto Lba
        Lb2:
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.put(r6, r1)
        Lba:
            com.huawei.hms.network.ai.a0 r7 = r13.f26160a
            java.lang.String r8 = r14.m33583h()
            int r9 = r14.m33581g()
            java.lang.String r10 = r14.m33579f()
            java.lang.Object r13 = r0.get(r5)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r11 = r13.intValue()
            java.lang.Object r13 = r0.get(r6)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r12 = r13.intValue()
            r7.m33243a(r8, r9, r10, r11, r12)
        Ldf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.p129ai.C5826z.m33619i(com.huawei.hms.network.ai.x):java.util.Map");
    }

    /* renamed from: j */
    private int m33620j(C5824x c5824x) {
        return c5824x.m33594n() == 0 ? m33622l(c5824x) : m33621k(c5824x);
    }

    /* renamed from: k */
    private int m33621k(C5824x c5824x) {
        if (Float.compare(5.0f, this.f26160a.m33244b(c5824x)) == -1 || c5824x.m33587j() == 1 || c5824x.m33589k() == -1 || c5824x.m33589k() == 0) {
            return 6000;
        }
        if (c5824x.m33589k() == 1) {
            if (c5824x.m33595o() < -95 || c5824x.m33595o() == -127 || m33611b(c5824x.m33593m()) > 150) {
                return 6000;
            }
        } else {
            if (c5824x.m33585i() < -90 || c5824x.m33585i() == Integer.MAX_VALUE) {
                return c5824x.m33591l();
            }
            if (m33611b(c5824x.m33593m()) > 400) {
                return c5824x.m33591l();
            }
        }
        return m33623a(c5824x.m33591l());
    }

    /* renamed from: l */
    private int m33622l(C5824x c5824x) {
        if (Float.compare(5.0f, this.f26160a.m33244b(c5824x)) == -1 || c5824x.m33587j() == 1 || c5824x.m33589k() == -1 || c5824x.m33589k() == 0) {
            return c5824x.m33564a();
        }
        if (c5824x.m33589k() != 1) {
            return (c5824x.m33585i() < -90 || c5824x.m33585i() == Integer.MAX_VALUE) ? c5824x.m33564a() : m33611b(c5824x.m33593m()) > 400 ? c5824x.m33564a() : m33614e(c5824x);
        }
        if (c5824x.m33595o() < -95 || c5824x.m33595o() == -127) {
            return c5824x.m33564a();
        }
        if (c5824x.m33595o() < -80) {
            return 6000;
        }
        if (m33611b(c5824x.m33593m()) > 500) {
            return c5824x.m33564a();
        }
        if (m33611b(c5824x.m33593m()) > 150) {
            return 6000;
        }
        return m33614e(c5824x);
    }

    /* renamed from: a */
    public int m33623a(int i10) {
        int i11 = i10 + 30000;
        int i12 = this.f26164e;
        return i11 >= i12 ? i12 : i11;
    }

    /* renamed from: c */
    public int m33628c(C5824x c5824x) {
        float[] fArr = new float[9];
        String[] strArrM33607a = m33607a(c5824x.m33593m());
        double dAbs = 0.0d;
        float f10 = 0.0f;
        double d10 = 0.0d;
        for (int i10 = 0; i10 < 5; i10++) {
            fArr[i10] = Float.parseFloat(strArrM33607a[i10]);
            d10 += Float.parseFloat(strArrM33607a[i10]);
            float f11 = fArr[i10];
            if (f11 > f10) {
                f10 = f11;
            }
        }
        double length = d10 / strArrM33607a.length;
        fArr[5] = (float) length;
        double dPow = 0.0d;
        for (int i11 = 0; i11 < strArrM33607a.length; i11++) {
            dPow += Math.pow(Double.parseDouble(strArrM33607a[i11]) - length, 2.0d);
            dAbs += Math.abs(Double.parseDouble(strArrM33607a[i11]) - length);
        }
        fArr[6] = (float) (dPow / (strArrM33607a.length - 1));
        fArr[7] = f10;
        fArr[8] = (float) (dAbs / strArrM33607a.length);
        Logger.m32136d("WebSocketPingModel", "featureArray:" + Arrays.toString(fArr));
        float[] fArrM33465a = this.f26161b.m33465a(InterfaceC5811m0.a.m33434a(fArr, false));
        if (Float.compare(fArrM33465a[0], 0.4f) == -1) {
            return 3;
        }
        return Float.compare(fArrM33465a[0], 0.8f) == -1 ? 2 : 1;
    }

    /* renamed from: e */
    private boolean m33615e() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f26165f.getLong(f26138E, 0L);
        if (jCurrentTimeMillis <= 604800000 && jCurrentTimeMillis >= 0) {
            Logger.m32143v("WebSocketPingModel", "ping model initPredictor < 7 days");
            return false;
        }
        Logger.m32143v("WebSocketPingModel", "ping model initPredictor > 7 days,try to update Model " + jCurrentTimeMillis);
        return true;
    }

    /* renamed from: a */
    public int m33624a(int i10, int i11) {
        int i12 = i10 - 30000;
        return i12 <= i11 ? i11 : i12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.Object, java.lang.String] */
    /* renamed from: d */
    public boolean m33629d() throws IOException {
        String string;
        C5807k0 c5807k0;
        C5807k0 c5807k02;
        String str = "modelVersion";
        Logger.m32141i("WebSocketPingModel", "ping model initPredictor");
        boolean z10 = false;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ContextHolder.getAppContext().getFilesDir().getCanonicalPath());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("networkkit");
            sb2.append(str2);
            String string2 = sb2.toString();
            Logger.m32143v("WebSocketPingModel", "get model initPredictor path: " + string2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string2);
            sb3.append(f26141h);
            File fileNewSafeFile = CreateFileUtil.newSafeFile(sb3.toString());
            FileInputStream fileInputStreamNewSafeFileInputStream = null;
            if (!fileNewSafeFile.exists()) {
                fileNewSafeFile.getParentFile().mkdirs();
                Logger.m32141i("WebSocketPingModel", "initPredictor fail because model file not exists");
                if (this.f26165f.getLong("modelDisable", 0L) != 0) {
                    Logger.m32141i("WebSocketPingModel", "initPredictor model disable");
                    if (m33615e()) {
                        c5807k02 = new C5807k0();
                    }
                    return false;
                }
                c5807k02 = new C5807k0();
                c5807k02.m33418a(string2, f26141h, null);
                return false;
            }
            try {
                try {
                    try {
                        try {
                            fileInputStreamNewSafeFileInputStream = CreateFileUtil.newSafeFileInputStream(string2 + f26141h);
                            this.f26161b = new C5813n0(fileInputStreamNewSafeFileInputStream);
                            z10 = true;
                        } catch (IOException e10) {
                            Logger.m32147w("WebSocketPingModel", "ping model initPredictor meet io exception, e:%s", e10.getMessage());
                            m33606a(fileInputStreamNewSafeFileInputStream);
                            string = this.f26165f.getString("modelVersion");
                            if (m33615e()) {
                                c5807k0 = new C5807k0();
                                c5807k0.m33418a(string2, f26141h, string);
                            }
                        } catch (NoClassDefFoundError e11) {
                            Logger.m32147w("WebSocketPingModel", "ping model initPredictor meet no class error, e:%s", e11.getMessage());
                            m33606a(fileInputStreamNewSafeFileInputStream);
                            string = this.f26165f.getString("modelVersion");
                            if (m33615e()) {
                                c5807k0 = new C5807k0();
                                c5807k0.m33418a(string2, f26141h, string);
                            }
                        }
                    } catch (FileNotFoundException e12) {
                        Logger.m32147w("WebSocketPingModel", "ping model initPredictor meet model not find, e:%s", e12.getMessage());
                        m33606a(fileInputStreamNewSafeFileInputStream);
                        string = this.f26165f.getString("modelVersion");
                        if (m33615e()) {
                            c5807k0 = new C5807k0();
                            c5807k0.m33418a(string2, f26141h, string);
                        }
                    } catch (VerifyError e13) {
                        Logger.m32147w("WebSocketPingModel", "ping model initPredictor meet verify error, e:%s", e13.getMessage());
                        m33606a(fileInputStreamNewSafeFileInputStream);
                        string = this.f26165f.getString("modelVersion");
                        if (m33615e()) {
                            c5807k0 = new C5807k0();
                            c5807k0.m33418a(string2, f26141h, string);
                        }
                    }
                } catch (RuntimeException e14) {
                    Logger.m32147w("WebSocketPingModel", "ping model initPredictor meet runtime exception, e:%s", e14.getMessage());
                    m33606a(fileInputStreamNewSafeFileInputStream);
                    string = this.f26165f.getString("modelVersion");
                    if (m33615e()) {
                        c5807k0 = new C5807k0();
                        c5807k0.m33418a(string2, f26141h, string);
                    }
                }
                StringBuilder sb4 = new StringBuilder();
                str = "ping model initPredictor is success: ";
                sb4.append("ping model initPredictor is success: ");
                sb4.append(z10);
                this = sb4.toString();
                Logger.m32141i("WebSocketPingModel", this);
                return z10;
            } finally {
                this.m33606a(fileInputStreamNewSafeFileInputStream);
                String string3 = this.f26165f.getString(str);
                if (this.m33615e()) {
                    new C5807k0().m33418a(string2, f26141h, string3);
                }
            }
        } catch (IOException unused) {
            Logger.m32145w("WebSocketPingModel", "get mobile local path meet error");
            return false;
        }
    }

    /* renamed from: a */
    private int m33602a(int i10, C5824x c5824x) {
        int iM33628c = m33628c(c5824x);
        if (i10 != 1) {
            return c5824x.m33594n() == 0 ? iM33628c == 3 ? m33614e(c5824x) : iM33628c == 2 ? (c5824x.m33564a() + m33614e(c5824x)) / 2 : c5824x.m33564a() : (iM33628c == 3 || iM33628c == 2) ? m33623a(c5824x.m33591l()) : c5824x.m33591l();
        }
        if (iM33628c == 3) {
            return c5824x.m33564a();
        }
        int iM33608b = m33608b(c5824x.m33564a());
        return iM33628c == 2 ? (iM33608b + c5824x.m33564a()) / 2 : iM33608b;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: c */
    public void mo33284c() {
    }

    /* renamed from: b */
    private int m33611b(String str) {
        return Integer.parseInt(m33607a(str)[r0.length - 1]);
    }

    /* renamed from: b */
    public Map<String, Integer> m33627b(C5824x c5824x) {
        if (c5824x.m33564a() <= this.f26164e) {
            return c5824x.m33575d() != 0 ? m33613d(c5824x) : c5824x.m33594n() == 0 ? m33618h(c5824x) : m33617g(c5824x);
        }
        HashMap map = new HashMap();
        map.put("ping", Integer.valueOf(this.f26164e));
        map.put("pingStatus", Integer.valueOf(c5824x.m33594n()));
        return map;
    }

    /* renamed from: a */
    private C5824x m33605a(Map<String, String> map) {
        C5824x c5824x = new C5824x();
        c5824x.m33570b(map.get("mnc"));
        c5824x.m33566a(map.get("domain"));
        c5824x.m33565a(Integer.parseInt(map.get("businessPing")));
        c5824x.m33588j(Integer.parseInt(map.get("ping")));
        c5824x.m33590k(Integer.parseInt(map.get("pingStatus")));
        c5824x.m33592l(Integer.parseInt(map.get("wifi_signal_strength")));
        c5824x.m33582g(Integer.parseInt(map.get("mobile_signal_strength")));
        c5824x.m33584h(Integer.parseInt(map.get("networkChange")));
        c5824x.m33574c(map.get("pingIntervalList"));
        c5824x.m33586i(Integer.parseInt(map.get("networkType")));
        c5824x.m33571b(Boolean.parseBoolean(map.get("isSuccess")));
        c5824x.m33567a(Boolean.parseBoolean(map.get("isActive")));
        if (map.get("continuePing") != null) {
            c5824x.m33569b(Integer.parseInt(map.get("continuePing")));
            c5824x.m33573c(Integer.parseInt(map.get(C5788b.f25728R)));
        }
        if (map.get("delayPing") != null) {
            c5824x.m33576d(Integer.parseInt(map.get("delayPing")));
            c5824x.m33578e(Integer.parseInt(map.get("delayTimes")));
        }
        if (map.get("firstNetworkType") == null) {
            c5824x.m33580f(Integer.parseInt(map.get("firstNetworkType")));
        }
        this.f26160a.m33241a(c5824x);
        return c5824x;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: b */
    public void mo33283b() {
    }

    /* renamed from: a */
    public Map<String, Integer> m33625a(int i10, Map<String, String> map) {
        if (this.f26161b == null) {
            Logger.m32138e("WebSocketPingModel", "predictor is null, check local file is exists");
            return null;
        }
        if (map == null) {
            return null;
        }
        C5824x c5824xM33605a = m33605a(map);
        if (i10 == 1) {
            return m33626a(c5824xM33605a);
        }
        if (i10 == 2) {
            return m33627b(c5824xM33605a);
        }
        return null;
    }

    /* renamed from: a */
    public Map<String, Integer> m33626a(C5824x c5824x) {
        int iM33616f;
        int iValueOf;
        if (!c5824x.m33597q()) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("pingStatus", Integer.valueOf(c5824x.m33594n()));
        if (c5824x.m33564a() <= this.f26162c) {
            map.put("ping", Integer.valueOf(c5824x.m33564a()));
            return map;
        }
        if (c5824x.m33568b() == 0) {
            iM33616f = m33616f(c5824x);
            if (iM33616f == 6000) {
                map.put("ping", Integer.valueOf(c5824x.m33591l()));
                map.put("continuePing", Integer.valueOf(iM33616f));
                iValueOf = 1;
                map.put(C5788b.f25728R, iValueOf);
            }
            map.put("ping", Integer.valueOf(iM33616f));
        } else if (c5824x.m33572c() < 5) {
            map.put("ping", Integer.valueOf(c5824x.m33591l()));
            map.put("continuePing", Integer.valueOf(c5824x.m33568b()));
            iValueOf = Integer.valueOf(c5824x.m33572c() + 1);
            map.put(C5788b.f25728R, iValueOf);
        } else {
            iM33616f = m33602a(1, c5824x);
            map.put("ping", Integer.valueOf(iM33616f));
        }
        return map;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33279a() {
        C5794e.m33310a().m33312b(new a());
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33281a(C5808l c5808l) {
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33282a(RequestContext requestContext) {
    }

    /* renamed from: a */
    private void m33606a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                Logger.m32140e("WebSocketPingModel", "ping model inputStream close error, e:%s", e10.getMessage());
            }
        }
    }

    /* renamed from: a */
    private String[] m33607a(String str) {
        return str.replace(" ", "").replace("[", "").replace("]", "").split(",");
    }
}
