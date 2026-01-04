package com.huawei.hms.network.embedded;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.check.ProviderCheckUtil;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.embedded.C5976k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.network.embedded.r5 */
/* loaded from: classes8.dex */
public class C6073r5 {

    /* renamed from: h */
    public static final String f28046h = "QoeManager";

    /* renamed from: i */
    public static final String f28047i = "content://com.huawei.hms.contentprovider";

    /* renamed from: j */
    public static final String f28048j = "/com.huawei.hms.wireless/qoe";

    /* renamed from: k */
    public static final int f28049k = 3;

    /* renamed from: l */
    public static final long f28050l = 500;

    /* renamed from: a */
    public long f28051a;

    /* renamed from: b */
    public long f28052b;

    /* renamed from: c */
    public AtomicInteger f28053c;

    /* renamed from: d */
    public long f28054d;

    /* renamed from: e */
    public long f28055e;

    /* renamed from: f */
    public long f28056f;

    /* renamed from: g */
    public boolean f28057g;

    /* renamed from: com.huawei.hms.network.embedded.r5$b */
    public static class b {

        /* renamed from: a */
        public static final C6073r5 f28058a = new C6073r5();
    }

    public C6073r5() {
        this.f28051a = 120000L;
        this.f28052b = 1000L;
        this.f28053c = new AtomicInteger(0);
        this.f28054d = 0L;
        this.f28055e = 0L;
        this.f28056f = 0L;
        this.f28057g = false;
        m35197b();
    }

    /* renamed from: a */
    private Bundle m35194a(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Uri uri = Uri.parse(f28047i);
        if (!ProviderCheckUtil.isValid(uri)) {
            this.f28057g = true;
            return null;
        }
        bundle.putString(C6110u3.f28491p, C6110u3.f28492q);
        try {
            Bundle bundleCall = context.getContentResolver().call(uri, str, str2, bundle);
            if (bundleCall == null) {
                Logger.m32136d(f28046h, "call provider success : but res is null");
            }
            return bundleCall;
        } catch (Throwable th2) {
            this.f28057g = true;
            Logger.m32143v(f28046h, "call QoeProvider fail, error is " + th2.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private void m35197b() {
        Object value = ConfigAPI.getValue(C5976k.i.f27228b);
        Object value2 = ConfigAPI.getValue(C5976k.i.f27229c);
        if (value != null && value2 != null) {
            long jStringToLong = StringUtils.stringToLong(String.valueOf(value), 120000L);
            if (jStringToLong <= 60000) {
                jStringToLong = 60000;
            }
            this.f28051a = jStringToLong;
            long jStringToLong2 = StringUtils.stringToLong(String.valueOf(value2), 1000L);
            this.f28052b = jStringToLong2 > 1000 ? jStringToLong2 : 1000L;
        }
        Logger.m32136d(f28046h, "qoeReportSuppressTime is " + this.f28051a + " and apiCallSuppressTime is " + this.f28052b);
    }

    /* renamed from: a */
    public static C6073r5 m35195a() {
        return b.f28058a;
    }

    /* renamed from: a */
    public C6099t5 m35198a(boolean z10) {
        StringBuilder sb2;
        long j10;
        Map<String, Integer> map = new HashMap<>();
        map.put("status", 0);
        if (System.currentTimeMillis() - this.f28054d < 500) {
            Logger.m32136d(f28046h, "call in retry suppress time, the suppress time is 500");
            return new C6099t5(map);
        }
        if (this.f28057g || this.f28053c.get() >= 3) {
            Logger.m32136d(f28046h, "call wireless kit failed, this process is suppressing");
            return new C6099t5(map);
        }
        if (!z10 && System.currentTimeMillis() - this.f28055e < this.f28052b) {
            Logger.m32136d(f28046h, "api call suppress, the suppress time is " + this.f28052b);
            return new C6099t5(map);
        }
        if (z10 && System.currentTimeMillis() - this.f28056f < this.f28051a) {
            Logger.m32136d(f28046h, "Ha report suppress, the suppress time is " + this.f28051a);
            return new C6099t5(map);
        }
        Bundle bundleM35194a = m35194a(ContextHolder.getAppContext(), "Qoe", ContextHolder.getAppContext().getPackageName(), null);
        if (bundleM35194a == null || bundleM35194a.getInt(C6086s5.f28170d) == 0) {
            this.f28053c.addAndGet(1);
            this.f28054d = System.currentTimeMillis();
            Logger.m32136d(f28046h, "update last RetryTime " + this.f28054d);
        } else {
            Logger.m32136d(f28046h, "qoe info not null");
            map = m35196a(map, bundleM35194a);
            map.put("status", 1);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z10) {
                this.f28056f = jCurrentTimeMillis;
                sb2 = new StringBuilder();
                sb2.append("update last ReportTime ");
                j10 = this.f28056f;
            } else {
                this.f28055e = jCurrentTimeMillis;
                sb2 = new StringBuilder();
                sb2.append("update last CallTime ");
                j10 = this.f28055e;
            }
            sb2.append(j10);
            Logger.m32136d(f28046h, sb2.toString());
            if (this.f28053c.get() != 0) {
                this.f28053c.set(0);
            }
        }
        return new C6099t5(map);
    }

    /* renamed from: a */
    private Map<String, Integer> m35196a(Map<String, Integer> map, Bundle bundle) {
        for (String str : bundle.keySet()) {
            map.put(str, Integer.valueOf(bundle.getInt(str)));
            Logger.m32136d(f28046h, "key : " + str + " value : " + bundle.getInt(str));
        }
        return map;
    }
}
