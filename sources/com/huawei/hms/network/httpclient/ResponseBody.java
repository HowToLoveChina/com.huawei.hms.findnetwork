package com.huawei.hms.network.httpclient;

import com.huawei.hms.framework.common.IoUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* loaded from: classes8.dex */
public abstract class ResponseBody implements Closeable {
    public Charset charSet;
    public Reader reader;

    public final byte[] bytes() throws IOException {
        long contentLength = getContentLength();
        try {
            if (contentLength > 2147483647L) {
                throw new IOException("Cannot buffer entire body for content length: " + contentLength);
            }
            InputStream inputStream = getInputStream();
            if (inputStream == null) {
                return new byte[0];
            }
            byte[] byteArray = IoUtils.toByteArray(inputStream);
            if (contentLength != -1 && contentLength != byteArray.length) {
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + byteArray.length + ") disagree");
            }
            return byteArray;
        } finally {
            close();
        }
    }

    public final Reader charStream() {
        InputStream inputStream = getInputStream();
        if (inputStream == null) {
            return null;
        }
        if (this.reader == null) {
            Charset charsetForName = this.charSet;
            if (charsetForName == null) {
                charsetForName = Charset.forName(Constants.UTF_8);
            }
            this.reader = new InputStreamReader(inputStream, charsetForName);
        }
        return this.reader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract long getContentLength();

    public abstract String getContentType();

    public abstract InputStream getInputStream();
}
