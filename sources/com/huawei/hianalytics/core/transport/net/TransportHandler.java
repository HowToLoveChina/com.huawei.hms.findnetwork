package com.huawei.hianalytics.core.transport.net;

import android.text.TextUtils;
import com.huawei.hianalytics.core.transport.Utils;
import com.huawei.hianalytics.core.transport.net.Response;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class TransportHandler {

    /* renamed from: a */
    public String f21695a;

    /* renamed from: b */
    public Map<String, String> f21696b;

    /* renamed from: c */
    public byte[] f21697c;

    public interface Methods {
        public static final String METHOD_GET = "GET";
        public static final String METHOD_POST = "POST";
    }

    public TransportHandler(String str, Map<String, String> map, byte[] bArr) {
        this.f21695a = str;
        this.f21696b = map;
        this.f21697c = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    /* renamed from: a */
    public abstract Response mo28797a();

    /* renamed from: b */
    public abstract Response mo28802b();

    public Response execute() {
        return execute("POST");
    }

    public Response execute(String str) {
        if (TextUtils.isEmpty(this.f21695a)) {
            return new Response(Response.Code.HOST_ERROR, "collectUrls is empty");
        }
        try {
            return "GET".equals(str) ? mo28797a() : mo28802b();
        } catch (Exception e10) {
            return Utils.handlerException(e10);
        }
    }
}
