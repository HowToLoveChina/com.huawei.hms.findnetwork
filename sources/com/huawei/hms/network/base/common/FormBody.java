package com.huawei.hms.network.base.common;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class FormBody extends RequestBody {

    /* renamed from: c */
    private static final String f26173c = "FormBody";

    /* renamed from: d */
    private static final String f26174d = "application/x-www-form-urlencoded; charset=UTF-8";

    /* renamed from: a */
    private final List<String> f26175a;

    /* renamed from: b */
    private final byte[] f26176b;

    public static final class Builder {

        /* renamed from: a */
        private final List<String> f26177a = new ArrayList();

        public Builder add(String str, String str2) {
            if (str != null && str2 != null) {
                this.f26177a.add(str);
                this.f26177a.add(str2);
            }
            return this;
        }

        public FormBody build() {
            return new FormBody(this);
        }
    }

    private FormBody(Builder builder) {
        this.f26175a = builder.f26177a;
        this.f26176b = m33633a();
    }

    /* renamed from: a */
    private byte[] m33633a() {
        StringBuilder sb2 = new StringBuilder();
        int size = this.f26175a.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            if (i10 > 0) {
                sb2.append('&');
            }
            sb2.append(this.f26175a.get(i10));
            sb2.append('=');
            sb2.append(this.f26175a.get(i10 + 1));
        }
        try {
            return sb2.toString().getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            byte[] bArr = new byte[0];
            Logger.m32146w(f26173c, "UnsupportedEncodingException", e10);
            return bArr;
        }
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public long contentLength() {
        if (this.f26176b.length == 0) {
            return -1L;
        }
        return r2.length;
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public String contentType() {
        return f26174d;
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.f26176b);
    }
}
