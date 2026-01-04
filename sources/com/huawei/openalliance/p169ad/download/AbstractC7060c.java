package com.huawei.openalliance.p169ad.download;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import java.io.Closeable;
import java.io.InputStream;

/* renamed from: com.huawei.openalliance.ad.download.c */
/* loaded from: classes2.dex */
public abstract class AbstractC7060c implements Closeable {
    /* renamed from: a */
    public static AbstractC7060c m42575a(Context context, String str, long j10) {
        try {
            AbstractC7185ho.m43820b("DownloadNetworkConnection", "create OkHttpNetworkConnection");
            return new C7067j(context, str, j10);
        } catch (Throwable unused) {
            AbstractC7185ho.m43820b("DownloadNetworkConnection", "create HttpUrlNetworkConnection");
            return new C7066i(str, j10);
        }
    }

    /* renamed from: a */
    public abstract InputStream mo42576a();

    /* renamed from: a */
    public abstract String mo42577a(String str);

    /* renamed from: b */
    public abstract int mo42578b();

    /* renamed from: c */
    public abstract int mo42579c();

    /* renamed from: d */
    public abstract HttpConnection mo42580d();
}
