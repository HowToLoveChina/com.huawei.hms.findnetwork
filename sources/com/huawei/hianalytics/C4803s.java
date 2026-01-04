package com.huawei.hianalytics;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.location.p065a.C1529a;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.s */
/* loaded from: classes5.dex */
public class C4803s {

    /* renamed from: a */
    public static volatile C4803s f21912a;

    /* renamed from: d */
    public static final List<String> f21913d = Arrays.asList("com.tencent.mm.plugin.appbrand.ui.AppBrandUI%5Cd*", "com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity%5C%24Lite%5Cd*", "com.alipay.mobile.nebulax.xriver.activity.XRiverActivity%5C%24XRiverLite%5Cd*", "com.huawei.fastapp.app.processManager.RpkLoaderActivityEntry%5Cd*", "com.huawei.fastapp.app.processManager.PageLoaderActivityEntryPort%5Cd*", "com.tt.miniapphost.placeholder.MiniAppChildProcessMultiInsActivity%5Cd*", "com.minigame.miniapphost.placeholder.MiniGameActivity%5Cd*", "com.baidu.swan.apps.SwanAppActivity%5Cd*");

    /* renamed from: a */
    public boolean f21918a = true;

    /* renamed from: b */
    public boolean f21922b = true;

    /* renamed from: c */
    public boolean f21926c = true;

    /* renamed from: d */
    public boolean f21928d = true;

    /* renamed from: e */
    public boolean f21929e = true;

    /* renamed from: a */
    public String f21916a = "all";

    /* renamed from: a */
    public long f21915a = 10800000;

    /* renamed from: b */
    public long f21920b = 43200000;

    /* renamed from: c */
    public long f21924c = 10800000;

    /* renamed from: a */
    public int f21914a = 50;

    /* renamed from: d */
    public long f21927d = 600000;

    /* renamed from: b */
    public int f21919b = 15;

    /* renamed from: c */
    public int f21923c = 1000;

    /* renamed from: a */
    public final List<Pattern> f21917a = new ArrayList();

    /* renamed from: b */
    public final List<String> f21921b = new ArrayList();

    /* renamed from: c */
    public final List<String> f21925c = new ArrayList();

    public C4803s() {
        m29022a();
    }

    /* renamed from: a */
    public long m29020a() {
        return new Random().nextInt(this.f21919b) * 60000;
    }

    /* renamed from: b */
    public long m29024b() {
        return this.f21915a;
    }

    /* renamed from: a */
    public static C4803s m29018a() {
        if (f21912a == null) {
            synchronized (C4803s.class) {
                try {
                    if (f21912a == null) {
                        f21912a = new C4803s();
                    }
                } finally {
                }
            }
        }
        return f21912a;
    }

    /* renamed from: b */
    public final void m29025b() {
        this.f21918a = true;
        this.f21922b = true;
        this.f21926c = true;
        this.f21928d = true;
        this.f21929e = true;
        this.f21915a = 10800000L;
        this.f21920b = 43200000L;
        this.f21924c = 10800000L;
        this.f21914a = 50;
        this.f21927d = 600000L;
        this.f21919b = 15;
        this.f21916a = "all";
        this.f21923c = 1000;
        try {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (true) {
                List<String> list = f21913d;
                if (i10 >= list.size()) {
                    m29023a(arrayList);
                    this.f21921b.clear();
                    this.f21921b.addAll(m29019a("eJyVUltuGzEMvBHvkGwa1EANL5oa6V/Blbhr1nqBkuws0MOHWifpK47hH0EacYbkkCZ6qIFjSDhDTe3scb4xhQ9c5l9GvwsFQ6GA95BcnThANhgCCVSGW8z0oM/t6kxsHEfHgVrsIzpHZXMCusihr5Lpf+Yo6OkYZQ+YEmxXPU50Lzh5/b9Q2XFJ8YODpaeWciOW5DMG60jOlvgv6VTnrSjtLGfQviGXOsDjdzXsUyhyyTVtZmiaLcVNSov+EvrTguMBDOYdq6sKJc1PcGA6QndCuxfwrxzouA1MdSSyBZ9T0260DOucuhgKqtXyEalZ3N5rDvwFq9m9H+7jwI6WyQNm8KoLaz06TKXKu2W9UGLIXGgBSCaCzev7mla2gb+Szuej2g4kPM5s1XUNUNRWRRPmrLtklyZVUofVH+0do4vT1WIjh4kkCetg73/fux2Z/YXp/7kwXc0l+gf12tNVm8PJvK3ON8z7XuLTvF09Az04dh4="));
                    this.f21925c.clear();
                    this.f21925c.addAll(m29019a("eJxLzs/VS8zJLEis1MvNT8rMSdXLS00qzUlMLCgoKMqvqNTLLEjW8zANKMpPTi0uDilKzCt2TC7JLMssqQQAqosXBQ=="));
                    return;
                }
                String str = list.get(i10);
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(URLDecoder.decode(str, Constants.UTF_8));
                }
                i10++;
            }
        } catch (Throwable th2) {
            HiLog.m28809i(C1529a.f6575a, "reset fail " + th2.getMessage());
        }
    }

    /* renamed from: a */
    public final synchronized void m29022a() {
        String strM28908a;
        try {
            strM28908a = C4785j.m28908a("global_v2", "DcCfg", "");
        } catch (Throwable th2) {
            HiLog.m28807d(C1529a.f6575a, "init fail " + th2.getMessage());
            m29025b();
        }
        if (TextUtils.isEmpty(strM28908a)) {
            m29025b();
            return;
        }
        JSONObject jSONObject = new JSONObject(strM28908a);
        this.f21918a = jSONObject.optBoolean("collectEnable", false);
        this.f21922b = jSONObject.optBoolean("appOpen", false);
        this.f21926c = jSONObject.optBoolean("liteApp", false);
        this.f21928d = jSONObject.optBoolean("appUsage", false);
        jSONObject.optBoolean("locate", false);
        this.f21929e = jSONObject.optBoolean("pageOpenV2", false);
        this.f21915a = jSONObject.optLong("reportInterval", 10800000L);
        this.f21920b = jSONObject.optLong("reloadInterval", 43200000L);
        this.f21924c = jSONObject.optLong("hmsReportInterval", 10800000L);
        this.f21914a = jSONObject.optInt("flushSize", 50);
        this.f21927d = jSONObject.optLong("flushInterval", 600000L);
        this.f21919b = jSONObject.optInt("randomBound", 15);
        this.f21916a = jSONObject.optString("collectTag", "all");
        this.f21923c = jSONObject.optInt("labelWaitTime", 1000);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("liteAppPages");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                String strOptString = jSONArrayOptJSONArray.optString(i10);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(URLDecoder.decode(strOptString, Constants.UTF_8));
                }
            }
            m29023a(arrayList);
        }
        String strOptString2 = jSONObject.optString("pageSwitchListV2", "");
        if (!TextUtils.isEmpty(strOptString2)) {
            this.f21921b.clear();
            this.f21921b.addAll(m29019a(strOptString2));
        }
        String strOptString3 = jSONObject.optString("pageSwitchBlack", "");
        if (!TextUtils.isEmpty(strOptString3)) {
            this.f21925c.clear();
            this.f21925c.addAll(m29019a(strOptString3));
        }
    }

    /* renamed from: a */
    public final void m29023a(List<String> list) {
        this.f21917a.clear();
        for (int i10 = 0; i10 < list.size(); i10++) {
            try {
                this.f21917a.add(Pattern.compile(list.get(i10)));
            } catch (Throwable th2) {
                HiLog.m28809i(C1529a.f6575a, "initLiteAppPagePattern fail: " + th2.getMessage());
            }
        }
    }

    /* renamed from: a */
    public Pair<Long, Long> m29021a() {
        try {
            long jM28896a = C4785j.m28896a("global_v2", "lastCollectTime", 0L);
            if (jM28896a == 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                return Pair.create(Long.valueOf(jCurrentTimeMillis - this.f21915a), Long.valueOf(jCurrentTimeMillis));
            }
            return Pair.create(Long.valueOf(jM28896a), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            return Pair.create(Long.valueOf(jCurrentTimeMillis2 - this.f21915a), Long.valueOf(jCurrentTimeMillis2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> m29019a(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "DcUtil"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto Le
            return r1
        Le:
            r2 = 0
            byte[] r7 = com.huawei.secure.android.common.util.SafeBase64.decode(r7, r2)
            java.lang.String r3 = ""
            if (r7 == 0) goto L92
            int r4 = r7.length
            r5 = 1
            if (r4 < r5) goto L92
            r4 = 0
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r5.<init>()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.util.zip.InflaterOutputStream r6 = new java.util.zip.InflaterOutputStream     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r6.write(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.lang.String r3 = r5.toString(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            r6.close()     // Catch: java.io.IOException -> L37
            goto L68
        L37:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.huawei.hianalytics.core.log.HiLog.m28808e(r0, r7)
            goto L68
        L40:
            r7 = move-exception
            r4 = r6
            goto L75
        L43:
            r7 = move-exception
            r4 = r6
            goto L51
        L46:
            r7 = move-exception
            goto L75
        L48:
            r7 = move-exception
            goto L51
        L4a:
            r7 = move-exception
            goto L4e
        L4c:
            r7 = move-exception
            goto L50
        L4e:
            r5 = r4
            goto L75
        L50:
            r5 = r4
        L51:
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L46
            com.huawei.hianalytics.core.log.HiLog.m28808e(r0, r7)     // Catch: java.lang.Throwable -> L46
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L66
        L5e:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.huawei.hianalytics.core.log.HiLog.m28808e(r0, r7)
        L66:
            if (r5 == 0) goto L92
        L68:
            r5.close()     // Catch: java.io.IOException -> L6c
            goto L92
        L6c:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.huawei.hianalytics.core.log.HiLog.m28808e(r0, r7)
            goto L92
        L75:
            if (r4 == 0) goto L83
            r4.close()     // Catch: java.io.IOException -> L7b
            goto L83
        L7b:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.hianalytics.core.log.HiLog.m28808e(r0, r1)
        L83:
            if (r5 == 0) goto L91
            r5.close()     // Catch: java.io.IOException -> L89
            goto L91
        L89:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.hianalytics.core.log.HiLog.m28808e(r0, r1)
        L91:
            throw r7
        L92:
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 == 0) goto L99
            return r1
        L99:
            java.lang.String r7 = "\\|"
            java.lang.String[] r7 = r3.split(r7)
            int r0 = r7.length
        La0:
            if (r2 >= r0) goto Lb0
            r3 = r7[r2]
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto Lad
            r1.add(r3)
        Lad:
            int r2 = r2 + 1
            goto La0
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4803s.m29019a(java.lang.String):java.util.List");
    }
}
