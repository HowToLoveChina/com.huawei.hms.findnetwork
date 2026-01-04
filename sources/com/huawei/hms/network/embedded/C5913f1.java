package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/* renamed from: com.huawei.hms.network.embedded.f1 */
/* loaded from: classes8.dex */
public class C5913f1 extends ResponseBody {

    /* renamed from: d */
    public static final String f26724d = "ResponseBodyImpl";

    /* renamed from: a */
    public String f26725a;

    /* renamed from: b */
    public long f26726b;

    /* renamed from: c */
    public InputStream f26727c;

    /* renamed from: com.huawei.hms.network.embedded.f1$b */
    public static final class b {

        /* renamed from: a */
        public String f26728a;

        /* renamed from: b */
        public InputStream f26729b;

        /* renamed from: c */
        public long f26730c;

        /* renamed from: d */
        public Charset f26731d;

        public b() {
        }

        public b(C5913f1 c5913f1) {
            this.f26728a = c5913f1.f26725a;
            this.f26730c = c5913f1.f26726b;
            this.f26731d = c5913f1.charSet;
            this.f26729b = c5913f1.f26727c;
        }

        public C5913f1 build() {
            return new C5913f1(this);
        }

        public b charSet(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f26731d = Charset.forName(str);
                } catch (IllegalCharsetNameException | UnsupportedCharsetException e10) {
                    Logger.m32146w("ResponseBody", "charSet error", e10);
                }
            }
            return this;
        }

        public b contentLength(long j10) {
            this.f26730c = j10;
            return this;
        }

        public b contentType(String str) {
            this.f26728a = str;
            return this;
        }

        public b inputStream(InputStream inputStream) {
            if (inputStream == null) {
                throw new NullPointerException("inputStream not null in ResponseBody");
            }
            this.f26729b = inputStream;
            return this;
        }

        public b charSet(Charset charset) {
            this.f26731d = charset;
            return this;
        }
    }

    public C5913f1(b bVar) {
        this.f26725a = bVar.f26728a;
        this.f26726b = bVar.f26730c;
        this.f26727c = bVar.f26729b;
        this.charSet = bVar.f26731d;
    }

    @Override // com.huawei.hms.network.httpclient.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f26727c;
        if (inputStream != null) {
            try {
                IoUtils.closeSecure(inputStream);
            } catch (IllegalBlockingModeException e10) {
                Logger.m32146w(f26724d, "closeSecure IllegalBlockingModeException", e10);
            }
        }
        Reader reader = this.reader;
        if (reader != null) {
            try {
                IoUtils.closeSecure(reader);
            } catch (IllegalBlockingModeException e11) {
                Logger.m32146w(f26724d, "closeSecure IllegalBlockingModeException", e11);
            }
        }
    }

    @Override // com.huawei.hms.network.httpclient.ResponseBody
    public long getContentLength() {
        return this.f26726b;
    }

    @Override // com.huawei.hms.network.httpclient.ResponseBody
    public String getContentType() {
        return this.f26725a;
    }

    @Override // com.huawei.hms.network.httpclient.ResponseBody
    public final InputStream getInputStream() {
        return this.f26727c;
    }

    public b newBuilder() {
        return new b(this);
    }
}
