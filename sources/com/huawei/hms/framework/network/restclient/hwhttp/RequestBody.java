package com.huawei.hms.framework.network.restclient.hwhttp;

import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.trans.ByteString;
import com.huawei.hms.framework.network.restclient.hwhttp.trans.FileBinary;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@Deprecated
/* loaded from: classes8.dex */
public abstract class RequestBody {
    public static final String DEFAULT_CONTENT_TYPE = "text/plain; charset=UTF-8";
    public static final String HEAD_VALUE_CONTENT_TYPE_FORM_DATA = "multipart/form-data";
    public static final String HEAD_VALUE_CONTENT_TYPE_URLENCODED = "application/x-www-form-urlencoded";
    private static final String TAG = "RequestBody";
    private static final Charset UTF_8 = Charset.forName(Constants.UTF_8);

    public static RequestBody create(final String str, final byte[] bArr) {
        if (bArr != null) {
            return new RequestBody() { // from class: com.huawei.hms.framework.network.restclient.hwhttp.RequestBody.1
                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public byte[] body() {
                    return bArr;
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public String contentType() {
                    String str2 = str;
                    return str2 == null ? "text/plain; charset=UTF-8" : str2;
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public void writeTo(OutputStream outputStream) throws IOException {
                    try {
                        outputStream.write(bArr);
                    } catch (IOException unused) {
                        Logger.m32145w(RequestBody.TAG, "the requestBody with writeTo has other error");
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public abstract byte[] body();

    public long contentLength() throws IOException {
        if (body() != null) {
            return r2.length;
        }
        return 0L;
    }

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static RequestBody create(final String str) {
        if (str != null) {
            return new RequestBody() { // from class: com.huawei.hms.framework.network.restclient.hwhttp.RequestBody.2
                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public byte[] body() {
                    return StringUtils.str2Byte(str);
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public String contentType() {
                    return "text/plain; charset=UTF-8";
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public void writeTo(OutputStream outputStream) throws IOException {
                    try {
                        outputStream.write(StringUtils.str2Byte(str));
                    } catch (IOException unused) {
                        Logger.m32145w(RequestBody.TAG, "the requestBody with writeTo has other error");
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(MediaType mediaType, String str) {
        if (str != null) {
            Charset charset = UTF_8;
            if (mediaType != null) {
                Charset charset2 = mediaType.charset();
                if (charset2 == null) {
                    mediaType = MediaType.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset2;
                }
            }
            byte[] bytes = str.getBytes(charset);
            return create(mediaType, bytes, 0, bytes.length);
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i10, final int i11) {
        if (bArr != null) {
            CheckParamUtils.checkOffsetAndCount(bArr.length, i10, i11);
            return new RequestBody() { // from class: com.huawei.hms.framework.network.restclient.hwhttp.RequestBody.3
                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public byte[] body() {
                    return new byte[0];
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public long contentLength() {
                    return i11;
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public String contentType() {
                    MediaType mediaType2 = mediaType;
                    if (mediaType2 == null) {
                        return null;
                    }
                    return mediaType2.toString();
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public void writeTo(OutputStream outputStream) throws IOException {
                    outputStream.write(bArr, i10, i11);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: com.huawei.hms.framework.network.restclient.hwhttp.RequestBody.4
            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public byte[] body() {
                return new byte[0];
            }

            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public String contentType() {
                MediaType mediaType2 = mediaType;
                if (mediaType2 == null) {
                    return null;
                }
                return mediaType2.toString();
            }

            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(StringUtils.getBytes(byteString.utf8()));
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() { // from class: com.huawei.hms.framework.network.restclient.hwhttp.RequestBody.5
                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public byte[] body() {
                    return new byte[0];
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public String contentType() {
                    MediaType mediaType2 = mediaType;
                    if (mediaType2 == null) {
                        return null;
                    }
                    return mediaType2.toString();
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
                public void writeTo(OutputStream outputStream) throws IOException {
                    new FileBinary(file).onWriteBinary(outputStream);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
