package com.huawei.hms.framework.network.restclient.hwhttp.trans;

import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.hwhttp.MediaType;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Deprecated
/* loaded from: classes8.dex */
public class MultipartBody extends RequestBody {
    private static final String TAG = "MultipartBody";
    private final ByteString boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    public static final MediaType FORM = MediaType.get(RequestBody.HEAD_VALUE_CONTENT_TYPE_FORM_DATA);
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    @Deprecated
    public static final class Builder {
        private final ByteString boundaryString;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + mediaType);
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundaryString = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }
    }

    @Deprecated
    public static final class Part {
        final RequestBody body;
        final Headers headers;

        private Part(Headers headers, RequestBody requestBody) {
            this.body = requestBody;
            this.headers = headers;
        }

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create((MediaType) null, str2));
        }

        public RequestBody body() {
            return this.body;
        }

        public Headers headers() {
            return this.headers;
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

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb2 = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(sb2, str);
            if (str2 != null) {
                sb2.append("; filename=");
                MultipartBody.appendQuotedString(sb2, str2);
            }
            return create(Headers.m32364of("Content-Disposition", sb2.toString()), requestBody);
        }
    }

    public MultipartBody(Builder builder) {
        ByteString byteString = builder.boundaryString;
        this.boundary = byteString;
        MediaType mediaType = builder.type;
        this.originalType = mediaType;
        this.parts = builder.parts;
        this.contentType = MediaType.get(mediaType + "; boundary=" + byteString.utf8());
    }

    public static StringBuilder appendQuotedString(StringBuilder sb2, String str) {
        sb2.append('\"');
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\n') {
                sb2.append("%0A");
            } else if (cCharAt == '\r') {
                sb2.append("%0D");
            } else if (cCharAt != '\"') {
                sb2.append(cCharAt);
            } else {
                sb2.append("%22");
            }
        }
        sb2.append('\"');
        return sb2;
    }

    private long writeOrCountBytes(OutputStream outputStream, boolean z10) throws IOException {
        CounterOutputStream counterOutputStream = new CounterOutputStream();
        if (z10) {
            outputStream = counterOutputStream;
        }
        int size = this.parts.size();
        long lenth = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Part part = this.parts.get(i10);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            outputStream.write(DASHDASH);
            outputStream.write(StringUtils.getBytes(boundary()));
            outputStream.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    outputStream.write(StringUtils.getBytes(headers.name(i11)));
                    outputStream.write(COLONSPACE);
                    outputStream.write(StringUtils.getBytes(headers.value(i11)));
                    outputStream.write(CRLF);
                }
            }
            String strContentType = requestBody.contentType();
            if (strContentType != null) {
                outputStream.write(StringUtils.getBytes("Content-Type: "));
                outputStream.write(StringUtils.getBytes(strContentType));
                outputStream.write(CRLF);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                outputStream.write(StringUtils.getBytes("Content-Length: "));
                outputStream.write(StringUtils.getBytes(jContentLength));
                outputStream.write(CRLF);
            } else if (z10) {
                return -1L;
            }
            byte[] bArr = CRLF;
            outputStream.write(bArr);
            if (z10) {
                lenth += jContentLength;
            } else {
                requestBody.writeTo(outputStream);
            }
            outputStream.write(bArr);
        }
        byte[] bArr2 = DASHDASH;
        outputStream.write(bArr2);
        outputStream.write(StringUtils.getBytes(boundary()));
        outputStream.write(bArr2);
        outputStream.write(CRLF);
        if (z10) {
            lenth += counterOutputStream.getLenth();
            IoUtils.closeSecure((OutputStream) counterOutputStream);
        }
        Logger.m32144v(TAG, "the length of the requestBody is %s", Long.valueOf(lenth));
        return lenth;
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
    @Deprecated
    public byte[] body() {
        return new byte[0];
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
    public long contentLength() throws IOException {
        long j10 = this.contentLength;
        if (j10 != -1) {
            return j10;
        }
        this.contentLength = writeOrCountBytes(null, true);
        Logger.m32141i(TAG, "get the contentLength,and the contentLength =" + this.contentLength);
        return this.contentLength;
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
    public String contentType() {
        MediaType mediaType = this.contentType;
        if (mediaType == null) {
            return null;
        }
        return mediaType.toString();
    }

    public Part part(int i10) {
        return this.parts.get(i10);
    }

    public List<Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public MediaType type() {
        return this.originalType;
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        writeOrCountBytes(outputStream, false);
    }
}
