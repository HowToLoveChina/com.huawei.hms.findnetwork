package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.fd */
/* loaded from: classes8.dex */
public class C7120fd implements InterfaceC7142fz {

    /* renamed from: a */
    private static final byte[] f32829a = new byte[0];

    /* renamed from: e */
    private static InterfaceC7142fz f32830e;

    /* renamed from: b */
    private final byte[] f32831b = new byte[0];

    /* renamed from: c */
    private Context f32832c;

    /* renamed from: d */
    private final SharedPreferences f32833d;

    private C7120fd(Context context) {
        Context contextM48571i = C7845x.m48571i(context.getApplicationContext());
        this.f32832c = contextM48571i;
        this.f32833d = contextM48571i.getSharedPreferences("HiAd_preload_sp", 0);
    }

    /* renamed from: b */
    private static InterfaceC7142fz m43289b(Context context) {
        InterfaceC7142fz interfaceC7142fz;
        synchronized (f32829a) {
            try {
                if (f32830e == null) {
                    f32830e = new C7120fd(context);
                }
                interfaceC7142fz = f32830e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7142fz;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7142fz
    /* renamed from: a */
    public int mo43290a(String str) {
        synchronized (this.f32831b) {
            try {
                Map map = (Map) AbstractC7758be.m47739b(this.f32833d.getString("splashPreloadMode", ""), Map.class, new Class[0]);
                if (C7765bl.m47802a(map)) {
                    return 1;
                }
                Integer numM48178h = AbstractC7806cz.m48178h((String) map.get(str));
                if (numM48178h != null && numM48178h.intValue() >= 0) {
                    return numM48178h.intValue();
                }
                return 1;
            } finally {
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC7142fz m43288a(Context context) {
        return m43289b(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7142fz
    /* renamed from: a */
    public String mo43291a() {
        String string;
        synchronized (this.f32831b) {
            string = this.f32833d.getString("splashPreloadMode", "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7142fz
    /* renamed from: a */
    public void mo43292a(Map<String, String> map) {
        synchronized (this.f32831b) {
            try {
                if (C7765bl.m47802a(map)) {
                    return;
                }
                Map map2 = (Map) AbstractC7758be.m47739b(this.f32833d.getString("splashPreloadMode", ""), Map.class, new Class[0]);
                if (C7765bl.m47802a(map2)) {
                    map2 = new HashMap();
                }
                map2.putAll(map);
                this.f32833d.edit().putString("splashPreloadMode", AbstractC7758be.m47742b(map2)).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
