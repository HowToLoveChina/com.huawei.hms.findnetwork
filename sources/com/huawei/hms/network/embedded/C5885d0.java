package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C6003m0;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.d0 */
/* loaded from: classes8.dex */
public class C5885d0<T extends C6003m0> {

    /* renamed from: b */
    public static final String f26604b = "MemoryCache";

    /* renamed from: c */
    public static final int f26605c = 128;

    /* renamed from: a */
    public final LruCache<String, T> f26606a = new LruCache<>(128);

    /* renamed from: a */
    public void m34092a() {
        this.f26606a.evictAll();
    }

    /* renamed from: b */
    public T m34095b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f26606a.get(str);
    }

    /* renamed from: a */
    public boolean m34093a(String str) {
        Logger.m32144v(f26604b, "[DNS Memory Cache]remove one record，host: %s", str);
        this.f26606a.remove(str);
        return true;
    }

    /* renamed from: b */
    public Map<String, T> m34096b() {
        return this.f26606a.snapshot();
    }

    /* renamed from: a */
    public boolean m34094a(String str, T t10) {
        if (C6158y.m35829b(t10) || TextUtils.isEmpty(str)) {
            return false;
        }
        this.f26606a.put(str, t10);
        return true;
    }
}
