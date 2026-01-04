package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.io.File;

/* renamed from: com.huawei.openalliance.ad.df */
/* loaded from: classes8.dex */
public class C7017df {

    /* renamed from: a */
    private Context f32201a;

    /* renamed from: b */
    private InterfaceC7144ga f32202b;

    public C7017df(Context context) {
        this.f32201a = context;
        this.f32202b = C7121fe.m43293a(context);
    }

    /* renamed from: a */
    public void m41931a() {
        try {
            long jMo43297a = this.f32202b.mo43297a("143");
            AbstractC7185ho.m43818a("DbSizeMonitor", "lastRptTime:%s", Long.valueOf(jMo43297a));
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jMo43297a < 86400000) {
                AbstractC7185ho.m43817a("DbSizeMonitor", "rpt once time a day");
                return;
            }
            this.f32202b.mo43299a("143", jCurrentTimeMillis);
            File databasePath = C7845x.m48571i(this.f32201a).getDatabasePath("hiad_recd.db");
            if (databasePath.exists()) {
                new C6922c(this.f32201a).m39095a("hiad_recd", databasePath.length());
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DbSizeMonitor", "check db size ex:%s", th2.getClass().getSimpleName());
        }
    }
}
