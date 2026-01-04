package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.db */
/* loaded from: classes8.dex */
public class C7012db {

    /* renamed from: a */
    private static final byte[] f32156a = new byte[0];

    /* renamed from: b */
    private static C7012db f32157b;

    /* renamed from: c */
    private volatile Map<String, ContentRecord> f32158c = new ConcurrentHashMap();

    private C7012db() {
    }

    /* renamed from: b */
    private void m41244b() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.db.1
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : new ConcurrentHashMap(C7012db.this.f32158c).entrySet()) {
                    AbstractC7185ho.m43818a("AdRecordManager", "entry key: %s time: %s", entry.getKey(), Long.valueOf(((ContentRecord) entry.getValue()).m41518be()));
                    if (System.currentTimeMillis() - ((ContentRecord) entry.getValue()).m41518be() > 86400000) {
                        C7012db.this.f32158c.remove(entry.getKey());
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public ContentRecord m41245a(String str) {
        return this.f32158c.get(str);
    }

    /* renamed from: a */
    public static C7012db m41242a() {
        C7012db c7012db;
        synchronized (f32156a) {
            try {
                if (f32157b == null) {
                    f32157b = new C7012db();
                }
                c7012db = f32157b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7012db;
    }

    /* renamed from: b */
    public void m41247b(String str) {
        if (this.f32158c.containsKey(str)) {
            this.f32158c.remove(str);
        }
    }

    /* renamed from: a */
    public void m41246a(String str, ContentRecord contentRecord) {
        AbstractC7185ho.m43818a("AdRecordManager", "task size before: %s", Integer.valueOf(this.f32158c.size()));
        contentRecord.m41565h(System.currentTimeMillis());
        this.f32158c.put(str, contentRecord);
        m41244b();
    }
}
