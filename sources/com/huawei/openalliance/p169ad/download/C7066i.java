package com.huawei.openalliance.p169ad.download;

import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import com.huawei.openalliance.p169ad.exception.C7112d;
import com.huawei.openalliance.p169ad.net.http.HttpsConfig;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.huawei.openalliance.ad.download.i */
/* loaded from: classes2.dex */
public class C7066i extends AbstractC7060c {

    /* renamed from: a */
    private HttpURLConnection f32542a;

    public C7066i(String str, long j10) throws IOException, C7112d {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f32542a = httpURLConnection;
        HttpsConfig.m45964a(httpURLConnection, true, false);
        this.f32542a.setConnectTimeout(10000);
        this.f32542a.setReadTimeout(10000);
        this.f32542a.setUseCaches(false);
        if (j10 > 0) {
            this.f32542a.setRequestProperty("Range", "bytes=" + j10 + "-");
        }
        this.f32542a.setRequestProperty(C5966j2.f27080v, "identity");
        this.f32542a.connect();
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: a */
    public InputStream mo42576a() {
        return this.f32542a.getInputStream();
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: b */
    public int mo42578b() {
        return this.f32542a.getResponseCode();
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: c */
    public int mo42579c() {
        return this.f32542a.getContentLength();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC7805cy.m48143a(this.f32542a);
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: d */
    public HttpConnection mo42580d() {
        return new HttpConnection();
    }

    @Override // com.huawei.openalliance.p169ad.download.AbstractC7060c
    /* renamed from: a */
    public String mo42577a(String str) {
        return this.f32542a.getHeaderField(str);
    }
}
