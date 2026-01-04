package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.dh */
/* loaded from: classes8.dex */
public class C7019dh {

    /* renamed from: a */
    private static Map<String, C7022dk> f32207a = new HashMap();

    /* renamed from: a */
    public static synchronized C7022dk m41937a(Context context, String str) {
        C7022dk c7022dk;
        try {
            if (AbstractC7806cz.m48165b(str)) {
                str = Constants.NORMAL_CACHE;
            }
            c7022dk = f32207a.get(str);
            if (c7022dk == null) {
                c7022dk = new C7022dk(context, str);
            }
            f32207a.put(str, c7022dk);
        } catch (Throwable th2) {
            throw th2;
        }
        return c7022dk;
    }

    /* renamed from: b */
    public static synchronized void m41939b() {
        Iterator<String> it = f32207a.keySet().iterator();
        while (it.hasNext()) {
            C7022dk c7022dk = f32207a.get(it.next());
            if (c7022dk != null) {
                c7022dk.m41969d();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m41938a() {
        try {
            Iterator<String> it = f32207a.keySet().iterator();
            while (it.hasNext()) {
                C7022dk c7022dk = f32207a.get(it.next());
                if (c7022dk != null) {
                    c7022dk.m41957a();
                }
            }
            f32207a.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
