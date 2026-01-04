package com.huawei.hms.framework.network.grs.p120e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.C5429a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p122g.C5445d;
import com.huawei.hms.framework.network.grs.p122g.C5448g;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5453c;
import com.huawei.hms.framework.network.grs.p125h.C5459e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.e.a */
/* loaded from: classes8.dex */
public class C5434a {

    /* renamed from: e */
    private static final String f24914e = "a";

    /* renamed from: f */
    private static final Map<String, Map<String, Map<String, String>>> f24915f = new ConcurrentHashMap(16);

    /* renamed from: a */
    private final Map<String, Long> f24916a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private final C5436c f24917b;

    /* renamed from: c */
    private final C5436c f24918c;

    /* renamed from: d */
    private final C5448g f24919d;

    public C5434a(C5436c c5436c, C5436c c5436c2, C5448g c5448g) {
        this.f24918c = c5436c2;
        this.f24917b = c5436c;
        this.f24919d = c5448g;
        c5448g.m32298a(this);
    }

    /* renamed from: a */
    public C5436c m32190a() {
        return this.f24917b;
    }

    /* renamed from: b */
    public C5448g m32194b() {
        return this.f24919d;
    }

    /* renamed from: c */
    public C5436c m32196c() {
        return this.f24918c;
    }

    /* renamed from: a */
    public Map<String, String> m32191a(GrsBaseInfo grsBaseInfo, String str, C5435b c5435b, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f24915f;
        Map<String, Map<String, String>> map2 = map.get(grsParasKey);
        if (map2 != null && !map2.isEmpty()) {
            m32188a(grsBaseInfo, c5435b, context, str);
            return map2.get(str);
        }
        Logger.m32136d(f24914e, "Cache size is: " + map.size());
        return new HashMap();
    }

    /* renamed from: b */
    public void m32195b(GrsBaseInfo grsBaseInfo, Context context) throws NumberFormatException {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String strM32200a = this.f24917b.m32200a(grsParasKey, "");
        String strM32200a2 = this.f24917b.m32200a(grsParasKey + "time", "0");
        long j10 = 0;
        if (!TextUtils.isEmpty(strM32200a2) && strM32200a2.matches("\\d+")) {
            try {
                j10 = Long.parseLong(strM32200a2);
            } catch (NumberFormatException e10) {
                Logger.m32146w(f24914e, "convert urlParamKey from String to Long catch NumberFormatException.", e10);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f24915f;
        map.put(grsParasKey, C5429a.m32150a(strM32200a));
        Logger.m32136d(f24914e, "Cache size is: " + map.size());
        this.f24916a.put(grsParasKey, Long.valueOf(j10));
        m32189a(grsBaseInfo, grsParasKey, context);
    }

    /* renamed from: a */
    public void m32192a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f24917b.m32204b(grsParasKey + "time", "0");
        this.f24916a.remove(grsParasKey + "time");
        Map<String, Map<String, Map<String, String>>> map = f24915f;
        map.remove(grsParasKey);
        Logger.m32136d(f24914e, "Cache size is: " + map.size());
        this.f24919d.m32300a(grsParasKey);
    }

    /* renamed from: a */
    private void m32188a(GrsBaseInfo grsBaseInfo, C5435b c5435b, Context context, String str) {
        Long l10 = this.f24916a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (C5459e.m32331a(l10)) {
            c5435b.m32197a(2);
            return;
        }
        if (C5459e.m32332a(l10, 300000L)) {
            this.f24919d.m32299a(new C5453c(grsBaseInfo, context), null, str, this.f24918c, -1);
        }
        c5435b.m32197a(1);
    }

    /* renamed from: a */
    public void m32193a(GrsBaseInfo grsBaseInfo, C5445d c5445d, Context context, C5453c c5453c) {
        if (c5445d.m32280f() == 2) {
            Logger.m32145w(f24914e, "update cache from server failed");
            return;
        }
        if (c5453c.m32312d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (c5445d.m32287m()) {
                f24915f.put(grsParasKey, C5429a.m32150a(this.f24917b.m32200a(grsParasKey, "")));
            } else {
                this.f24917b.m32204b(grsParasKey, c5445d.m32284j());
                f24915f.put(grsParasKey, C5429a.m32150a(c5445d.m32284j()));
            }
            if (!TextUtils.isEmpty(c5445d.m32279e())) {
                this.f24917b.m32204b(grsParasKey + "ETag", c5445d.m32279e());
            }
            this.f24917b.m32204b(grsParasKey + "time", c5445d.m32270a());
            this.f24916a.put(grsParasKey, Long.valueOf(Long.parseLong(c5445d.m32270a())));
        } else {
            this.f24917b.m32204b("geoipCountryCode", c5445d.m32284j());
            this.f24917b.m32204b("geoipCountryCodetime", c5445d.m32270a());
        }
        Logger.m32136d(f24914e, "Cache size is: " + f24915f.size());
    }

    /* renamed from: a */
    private void m32189a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (C5459e.m32332a(this.f24916a.get(str), 300000L)) {
            this.f24919d.m32299a(new C5453c(grsBaseInfo, context), null, null, this.f24918c, -1);
        }
    }
}
