package com.huawei.hms.videokit.player;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.videokit.player.p */
/* loaded from: classes8.dex */
public class C6592p {

    /* renamed from: a */
    private LinkedHashMap<String, String> f30660a = new LinkedHashMap<>();

    /* renamed from: a */
    public C6592p m37590a(String str, long j10) {
        if (str == null) {
            C6550c1.m37256a("HiAnalyticsData", "key is null");
        } else {
            this.f30660a.put(str, "" + j10);
        }
        return this;
    }

    public String toString() {
        String str = null;
        for (Map.Entry<String, String> entry : m37592a().entrySet()) {
            str = str != null ? str + '\n' + entry.getKey() + ":" + entry.getValue() : entry.getKey() + ":" + entry.getValue();
        }
        return str;
    }

    /* renamed from: a */
    public C6592p m37591a(String str, String str2) {
        if (str == null || str2 == null) {
            C6550c1.m37256a("HiAnalyticsData", "key or value is null");
        } else {
            this.f30660a.put(str, str2);
        }
        return this;
    }

    /* renamed from: a */
    public LinkedHashMap<String, String> m37592a() {
        return this.f30660a;
    }
}
