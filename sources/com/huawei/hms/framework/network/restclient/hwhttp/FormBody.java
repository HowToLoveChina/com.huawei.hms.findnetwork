package com.huawei.hms.framework.network.restclient.hwhttp;

import com.huawei.hms.framework.common.Logger;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes8.dex */
public class FormBody extends RequestBody {
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
    private static final String TAG = "FormBody";
    private byte[] formbody;
    private final List<String> nameAndValues;

    @Deprecated
    public static final class Builder {
        private final List<String> nameAndValues = new ArrayList();

        public Builder add(String str, String str2) {
            if (str != null && str2 != null) {
                this.nameAndValues.add(str);
                this.nameAndValues.add(str2);
            }
            return this;
        }

        public FormBody build() {
            return new FormBody(this);
        }
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
    public byte[] body() {
        if (this.formbody == null) {
            StringBuilder sb2 = new StringBuilder();
            int size = this.nameAndValues.size();
            for (int i10 = 0; i10 < size; i10 += 2) {
                if (i10 > 0) {
                    sb2.append('&');
                }
                sb2.append(this.nameAndValues.get(i10));
                sb2.append('=');
                sb2.append(this.nameAndValues.get(i10 + 1));
            }
            try {
                this.formbody = sb2.toString().getBytes(Constants.UTF_8);
            } catch (UnsupportedEncodingException e10) {
                this.formbody = new byte[0];
                Logger.m32146w(TAG, "UnsupportedEncodingException", e10);
            }
        }
        return (byte[]) this.formbody.clone();
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
    public String contentType() {
        return CONTENT_TYPE;
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
    }

    private FormBody(Builder builder) {
        this.nameAndValues = builder.nameAndValues;
    }
}
