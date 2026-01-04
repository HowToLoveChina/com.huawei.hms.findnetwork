package com.huawei.hms.network.embedded;

import android.content.Context;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Interceptor;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.p4 */
/* loaded from: classes8.dex */
public abstract class AbstractC6046p4 {

    /* renamed from: a */
    public static volatile AbstractC6046p4 f27696a = null;

    /* renamed from: b */
    public static final String f27697b = "https://";

    /* renamed from: c */
    public static final String f27698c = "GET";

    /* renamed from: d */
    public static volatile HttpClient f27699d;

    /* renamed from: e */
    public static synchronized HttpClient m34962e() {
        try {
            if (f27699d == null) {
                f27699d = new HttpClient.Builder().retryTimeOnConnectionFailure(0).build();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f27699d;
    }

    /* renamed from: f */
    public static AbstractC6046p4 m34963f() {
        if (f27696a == null) {
            synchronized (AbstractC6046p4.class) {
                try {
                    if (f27696a == null) {
                        f27696a = new C6059q4();
                    }
                } finally {
                }
            }
        }
        return f27696a;
    }

    /* renamed from: a */
    public abstract LinkedHashMapPack mo34964a(String str);

    /* renamed from: a */
    public abstract C6021n5 mo34965a(String str, List<InetAddress> list);

    /* renamed from: a */
    public abstract C6099t5 mo34966a(boolean z10);

    /* renamed from: a */
    public abstract AbstractC6176z4 mo34967a(long j10, long j11);

    /* renamed from: a */
    public abstract void mo34968a(Context context);

    /* renamed from: a */
    public abstract void mo34969a(Interceptor.Chain chain);

    /* renamed from: a */
    public abstract boolean mo34970a();

    /* renamed from: b */
    public abstract String mo34971b();

    /* renamed from: b */
    public abstract void mo34972b(boolean z10);

    /* renamed from: b */
    public abstract boolean mo34973b(long j10, long j11);

    /* renamed from: c */
    public abstract Map<String, Integer> mo34974c();

    /* renamed from: c */
    public abstract void mo34975c(boolean z10);

    /* renamed from: d */
    public abstract void mo34976d();
}
