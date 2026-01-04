package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import p214d2.C8988b;
import p630s2.C12668c;
import p630s2.C12672g;
import p759x1.C13680e;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.data.j */
/* loaded from: classes.dex */
public class C1569j implements InterfaceC1563d<InputStream> {

    /* renamed from: g */
    public static final b f6954g = new a();

    /* renamed from: a */
    public final C8988b f6955a;

    /* renamed from: b */
    public final int f6956b;

    /* renamed from: c */
    public final b f6957c;

    /* renamed from: d */
    public HttpURLConnection f6958d;

    /* renamed from: e */
    public InputStream f6959e;

    /* renamed from: f */
    public volatile boolean f6960f;

    /* renamed from: com.bumptech.glide.load.data.j$a */
    public static class a implements b {
        @Override // com.bumptech.glide.load.data.C1569j.b
        /* renamed from: a */
        public HttpURLConnection mo9044a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* renamed from: com.bumptech.glide.load.data.j$b */
    public interface b {
        /* renamed from: a */
        HttpURLConnection mo9044a(URL url) throws IOException;
    }

    public C1569j(C8988b c8988b, int i10) {
        this(c8988b, i10, f6954g);
    }

    /* renamed from: f */
    public static int m9038f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e10) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e10);
            return -1;
        }
    }

    /* renamed from: h */
    public static boolean m9039h(int i10) {
        return i10 / 100 == 2;
    }

    /* renamed from: i */
    public static boolean m9040i(int i10) {
        return i10 / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: a */
    public Class<InputStream> mo9017a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: b */
    public void mo9022b() throws IOException {
        InputStream inputStream = this.f6959e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f6958d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f6958d = null;
    }

    /* renamed from: c */
    public final HttpURLConnection m9041c(URL url, Map<String, String> map) throws C13680e {
        try {
            HttpURLConnection httpURLConnectionMo9044a = this.f6957c.mo9044a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionMo9044a.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionMo9044a.setConnectTimeout(this.f6956b);
            httpURLConnectionMo9044a.setReadTimeout(this.f6956b);
            httpURLConnectionMo9044a.setUseCaches(false);
            httpURLConnectionMo9044a.setDoInput(true);
            httpURLConnectionMo9044a.setInstanceFollowRedirects(false);
            return httpURLConnectionMo9044a;
        } catch (IOException e10) {
            throw new C13680e("URL.openConnection threw", 0, e10);
        }
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    public void cancel() {
        this.f6960f = true;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: d */
    public EnumC13676a mo9024d() {
        return EnumC13676a.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: e */
    public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super InputStream> aVar) {
        StringBuilder sb2;
        long jM76263b = C12672g.m76263b();
        try {
            try {
                aVar.mo9031f(m9043j(this.f6955a.m56823h(), 0, null, this.f6955a.m56820e()));
            } catch (IOException e10) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
                }
                aVar.mo9030c(e10);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb2 = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(C12672g.m76262a(jM76263b));
                Log.v("HttpUrlFetcher", sb2.toString());
            }
        } catch (Throwable th2) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + C12672g.m76262a(jM76263b));
            }
            throw th2;
        }
    }

    /* renamed from: g */
    public final InputStream m9042g(HttpURLConnection httpURLConnection) throws C13680e {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f6959e = C12668c.m76253e(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f6959e = httpURLConnection.getInputStream();
            }
            return this.f6959e;
        } catch (IOException e10) {
            throw new C13680e("Failed to obtain InputStream", m9038f(httpURLConnection), e10);
        }
    }

    /* renamed from: j */
    public final InputStream m9043j(URL url, int i10, URL url2, Map<String, String> map) throws IOException {
        if (i10 >= 5) {
            throw new C13680e("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new C13680e("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionM9041c = m9041c(url, map);
        this.f6958d = httpURLConnectionM9041c;
        try {
            httpURLConnectionM9041c.connect();
            this.f6959e = this.f6958d.getInputStream();
            if (this.f6960f) {
                return null;
            }
            int iM9038f = m9038f(this.f6958d);
            if (m9039h(iM9038f)) {
                return m9042g(this.f6958d);
            }
            if (!m9040i(iM9038f)) {
                if (iM9038f == -1) {
                    throw new C13680e(iM9038f);
                }
                try {
                    throw new C13680e(this.f6958d.getResponseMessage(), iM9038f);
                } catch (IOException e10) {
                    throw new C13680e("Failed to get a response message", iM9038f, e10);
                }
            }
            String headerField = this.f6958d.getHeaderField(ActivityRecognitionConstants.LOCATION_MODULE);
            if (TextUtils.isEmpty(headerField)) {
                throw new C13680e("Received empty or null redirect url", iM9038f);
            }
            try {
                URL url3 = new URL(url, headerField);
                mo9022b();
                return m9043j(url3, i10 + 1, url, map);
            } catch (MalformedURLException e11) {
                throw new C13680e("Bad redirect url: " + headerField, iM9038f, e11);
            }
        } catch (IOException e12) {
            throw new C13680e("Failed to connect or obtain data", m9038f(this.f6958d), e12);
        }
    }

    public C1569j(C8988b c8988b, int i10, b bVar) {
        this.f6955a = c8988b;
        this.f6956b = i10;
        this.f6957c = bVar;
    }
}
