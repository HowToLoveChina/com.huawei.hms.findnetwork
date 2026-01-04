package com.huawei.hms.network.base.common;

import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.base.common.trans.ByteString;
import com.huawei.hms.network.base.common.trans.CounterOutputStream;
import com.huawei.hms.network.httpclient.RequestBody;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes8.dex */
public class MultipartBody extends RequestBody {

    /* renamed from: f */
    private static final String f26189f = "MultipartBody";

    /* renamed from: a */
    private final MediaType f26193a;

    /* renamed from: b */
    private final ByteString f26194b;

    /* renamed from: c */
    private final List<Part> f26195c;

    /* renamed from: d */
    private final MediaType f26196d;

    /* renamed from: e */
    private long f26197e = -1;
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    public static final MediaType FORM = MediaType.get(com.huawei.hms.framework.network.restclient.hwhttp.RequestBody.HEAD_VALUE_CONTENT_TYPE_FORM_DATA);

    /* renamed from: g */
    private static final byte[] f26190g = {58, 32};

    /* renamed from: h */
    private static final byte[] f26191h = {13, 10};

    /* renamed from: i */
    private static final byte[] f26192i = {45, 45};

    public static final class Builder {

        /* renamed from: a */
        private final ByteString f26198a;

        /* renamed from: b */
        private final List<Part> f26199b;

        /* renamed from: c */
        private MediaType f26200c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public MultipartBody build() {
            if (this.f26199b.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            if (mediaType.type().equals("multipart")) {
                this.f26200c = mediaType;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + this.f26200c);
        }

        public Builder(String str) {
            this.f26199b = new ArrayList();
            this.f26200c = MultipartBody.MIXED;
            this.f26198a = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Part part) {
            if (part == null) {
                throw new NullPointerException("part == null");
            }
            this.f26199b.add(part);
            return this;
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }
    }

    public static final class Part {

        /* renamed from: a */
        final Headers f26201a;

        /* renamed from: b */
        final RequestBody f26202b;

        private Part(Headers headers, RequestBody requestBody) {
            this.f26201a = headers;
            this.f26202b = requestBody;
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            }
            if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers == null || headers.get("Content-Length") == null) {
                return new Part(headers, requestBody);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBodyProviders.create((MediaType) null, str2));
        }

        public RequestBody body() {
            return this.f26202b;
        }

        public Headers headers() {
            return this.f26201a;
        }

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb2 = new StringBuilder("form-data; name=");
            MultipartBody.m33640a(sb2, str);
            if (str2 != null) {
                sb2.append("; filename=");
                MultipartBody.m33640a(sb2, str2);
            }
            return create(Headers.m33637of("Content-Disposition", sb2.toString()), requestBody);
        }
    }

    public MultipartBody(Builder builder) {
        this.f26195c = builder.f26199b;
        ByteString byteString = builder.f26198a;
        this.f26194b = byteString;
        MediaType mediaType = builder.f26200c;
        this.f26193a = mediaType;
        this.f26196d = MediaType.get(mediaType + "; boundary=" + byteString.utf8());
    }

    /* renamed from: a */
    private long m33639a(OutputStream outputStream, boolean z10) throws IOException {
        CounterOutputStream counterOutputStream = new CounterOutputStream();
        if (z10) {
            outputStream = counterOutputStream;
        }
        int size = this.f26195c.size();
        long lenth = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Part part = this.f26195c.get(i10);
            Headers headers = part.f26201a;
            RequestBody requestBody = part.f26202b;
            outputStream.write(f26192i);
            outputStream.write(StringUtils.getBytes(boundary()));
            outputStream.write(f26191h);
            if (headers != null) {
                int size2 = headers.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    outputStream.write(StringUtils.getBytes(headers.name(i11)));
                    outputStream.write(f26190g);
                    outputStream.write(StringUtils.getBytes(headers.value(i11)));
                    outputStream.write(f26191h);
                }
            }
            String strContentType = requestBody.contentType();
            if (strContentType != null) {
                outputStream.write(StringUtils.getBytes("Content-Type: "));
                outputStream.write(StringUtils.getBytes(strContentType));
                outputStream.write(f26191h);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                outputStream.write(StringUtils.getBytes("Content-Length: "));
                outputStream.write(StringUtils.getBytes(jContentLength));
                outputStream.write(f26191h);
            } else if (z10) {
                return -1L;
            }
            byte[] bArr = f26191h;
            outputStream.write(bArr);
            if (z10) {
                lenth += jContentLength;
            } else {
                requestBody.writeTo(outputStream);
            }
            outputStream.write(bArr);
        }
        byte[] bArr2 = f26192i;
        outputStream.write(bArr2);
        outputStream.write(StringUtils.getBytes(boundary()));
        outputStream.write(bArr2);
        outputStream.write(f26191h);
        if (z10) {
            lenth += counterOutputStream.getLenth();
            IoUtils.closeSecure((OutputStream) counterOutputStream);
        }
        Logger.m32144v(f26189f, "the length of the requestBody is %s", Long.valueOf(lenth));
        return lenth;
    }

    public String boundary() {
        return this.f26194b.utf8();
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public long contentLength() {
        long j10 = this.f26197e;
        if (j10 != -1) {
            return j10;
        }
        this.f26197e = m33639a((OutputStream) null, true);
        Logger.m32141i(f26189f, "get the contentLength,and the contentLength =" + this.f26197e);
        return this.f26197e;
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public String contentType() {
        MediaType mediaType = this.f26196d;
        if (mediaType == null) {
            return null;
        }
        return mediaType.toString();
    }

    public Part part(int i10) {
        return this.f26195c.get(i10);
    }

    public List<Part> parts() {
        return this.f26195c;
    }

    public int size() {
        return this.f26195c.size();
    }

    public MediaType type() {
        return this.f26193a;
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        m33639a(outputStream, false);
    }

    /* renamed from: a */
    public static StringBuilder m33640a(StringBuilder sb2, String str) {
        String str2;
        sb2.append('\"');
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\n') {
                str2 = "%0A";
            } else if (cCharAt == '\r') {
                str2 = "%0D";
            } else if (cCharAt != '\"') {
                sb2.append(cCharAt);
            } else {
                str2 = "%22";
            }
            sb2.append(str2);
        }
        sb2.append('\"');
        return sb2;
    }
}
