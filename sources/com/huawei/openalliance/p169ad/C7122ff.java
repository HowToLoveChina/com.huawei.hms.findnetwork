package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ff */
/* loaded from: classes8.dex */
public class C7122ff extends AbstractC7100ep {

    /* renamed from: c */
    private static C7122ff f32838c;

    /* renamed from: d */
    private static final byte[] f32839d = new byte[0];

    /* renamed from: e */
    private static final byte[] f32840e = new byte[0];

    private C7122ff(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static C7122ff m43303a(Context context) {
        C7122ff c7122ff;
        synchronized (f32839d) {
            try {
                if (f32838c == null) {
                    f32838c = new C7122ff(context);
                }
                c7122ff = f32838c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7122ff;
    }

    /* renamed from: b */
    private SdkCfgSha256Record m43304b(String str) {
        List listM42984a = m42984a(SdkCfgSha256Record.class, null, EnumC7125fi.SDKCFG_SHA256_BY_PKG, new String[]{str}, null, null);
        if (!AbstractC7760bg.m47767a(listM42984a)) {
            return (SdkCfgSha256Record) listM42984a.get(0);
        }
        AbstractC7185ho.m43817a("SdkCfgSha256RecordDao", "no match sha256");
        return null;
    }

    /* renamed from: a */
    public Class<? extends SdkCfgSha256Record> m43305a() {
        return SdkCfgSha256Record.class;
    }

    /* renamed from: a */
    public String m43306a(String str) {
        SdkCfgSha256Record sdkCfgSha256RecordM43304b = m43304b(str);
        if (sdkCfgSha256RecordM43304b != null) {
            return sdkCfgSha256RecordM43304b.m41818b();
        }
        return null;
    }

    /* renamed from: a */
    public void m43307a(SdkCfgSha256Record sdkCfgSha256Record) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (sdkCfgSha256Record == null || this.f32709a == null) {
            return;
        }
        synchronized (f32840e) {
            ArrayList arrayList = new ArrayList();
            String simpleName = m43305a().getSimpleName();
            String strM41816a = sdkCfgSha256Record.m41816a();
            EnumC7125fi enumC7125fi = EnumC7125fi.SDKCFG_SHA256_BY_PKG;
            arrayList.add(new C7016de(simpleName, enumC7125fi.m43493a(), new String[]{strM41816a}, enumC7125fi.m43493a(), new String[]{strM41816a}, sdkCfgSha256Record.m41863d(this.f32709a)));
            m42989c(arrayList);
        }
        AbstractC7185ho.m43818a("SdkCfgSha256RecordDao", "insertOrUpdateContents duration: %s ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
