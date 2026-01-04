package com.huawei.hms.network.base.common;

import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.common.trans.ByteString;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.charset.Charset;

/* loaded from: classes8.dex */
public class ResponseBodyProviders {

    /* renamed from: a */
    private static final String f26214a = "ResponseBodyProviders";

    /* renamed from: b */
    private static final Charset f26215b = Charset.forName(Constants.UTF_8);

    public static ResponseBody create(final MediaType mediaType, final long j10, final InputStream inputStream) {
        if (inputStream != null) {
            return new ResponseBody() { // from class: com.huawei.hms.network.base.common.ResponseBodyProviders.1
                @Override // com.huawei.hms.network.httpclient.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    InputStream inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            IoUtils.closeSecure(inputStream2);
                        } catch (IllegalBlockingModeException unused) {
                            Logger.m32145w(ResponseBodyProviders.f26214a, "closeSecure IllegalBlockingModeException");
                        }
                    }
                    Reader reader = this.reader;
                    if (reader != null) {
                        try {
                            IoUtils.closeSecure(reader);
                        } catch (IllegalBlockingModeException unused2) {
                            Logger.m32145w(ResponseBodyProviders.f26214a, "closeSecure IllegalBlockingModeException");
                        }
                    }
                }

                @Override // com.huawei.hms.network.httpclient.ResponseBody
                public long getContentLength() {
                    return j10;
                }

                @Override // com.huawei.hms.network.httpclient.ResponseBody
                public String getContentType() {
                    MediaType mediaType2 = mediaType;
                    if (mediaType2 == null) {
                        return null;
                    }
                    return mediaType2.toString();
                }

                @Override // com.huawei.hms.network.httpclient.ResponseBody
                public InputStream getInputStream() {
                    return inputStream;
                }
            };
        }
        throw new NullPointerException("inputStream == null");
    }

    public static ResponseBody create(MediaType mediaType, ByteString byteString) {
        if (byteString != null) {
            return create(mediaType, byteString.toByteArray());
        }
        throw new NullPointerException("content == null");
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        if (str == null) {
            throw new NullPointerException("content == null");
        }
        Charset charset = f26215b;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        return create(mediaType, bArr.length, new ByteArrayInputStream(bArr));
    }
}
