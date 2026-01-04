package com.huawei.hms.framework.network.restclient.hwhttp;

import com.huawei.hms.framework.network.restclient.Headers;
import java.io.Closeable;
import java.io.IOException;
import java.net.URL;

@Deprecated
/* loaded from: classes8.dex */
public class Response implements Closeable {
    private static final String TAG = "Response";
    private ResponseBody body;
    private int code;
    private Headers headers;
    private String message;
    private URL url;

    @Deprecated
    public static final class Builder {
        private ResponseBody body;
        private int code;
        private Headers headers;
        private String message;
        private URL url;

        public /* synthetic */ Builder(Response response, C55001 c55001) {
            this(response);
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            return new Response(this);
        }

        public Builder code(int i10) {
            this.code = i10;
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder url(URL url) {
            this.url = url;
            return this;
        }

        public Builder() {
        }

        private Builder(Response response) {
            this.body = response.body;
            this.headers = response.headers;
            this.code = response.code;
            this.message = response.message;
            this.url = response.url;
        }
    }

    public /* synthetic */ Response(Builder builder, C55001 c55001) {
        this(builder);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            this.body = null;
        }
    }

    public ResponseBody getBody() {
        return this.body;
    }

    public int getCode() {
        return this.code;
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public String getMessage() {
        return this.message;
    }

    public URL getUrl() {
        return this.url;
    }

    public boolean isOK() {
        return this.code == 200;
    }

    public boolean isSuccessful() {
        int i10 = this.code;
        return i10 >= 200 && i10 < 300;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    private Response(Builder builder) {
        this.body = builder.body;
        this.headers = builder.headers;
        this.code = builder.code;
        this.message = builder.message;
        this.url = builder.url;
    }
}
