package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.exception.C7112d;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.net.http.g */
/* loaded from: classes2.dex */
class C7504g extends AbstractC7499b {
    public C7504g(Context context) {
        super(context);
    }

    /* renamed from: a */
    private HttpURLConnection m46075a(String str, C7498a c7498a, boolean z10, C7502e c7502e) throws ProtocolException, C7112d {
        AbstractC7185ho.m43821b("HttpUrlConnectionCaller", "createConnection: %s", AbstractC7806cz.m48174f(str));
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        HttpsConfig.m45964a(httpURLConnection, c7502e.f34835g, c7502e.f34837i);
        httpURLConnection.setRequestMethod(c7498a.f34797e);
        httpURLConnection.setConnectTimeout(c7502e.f34830b);
        httpURLConnection.setReadTimeout(c7502e.f34831c);
        httpURLConnection.setDoOutput(z10);
        m46077a(httpURLConnection, c7498a);
        return httpURLConnection;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // com.huawei.openalliance.p169ad.net.http.InterfaceC7505h
    /* renamed from: b */
    public com.huawei.openalliance.p169ad.net.http.Response mo45976b(com.huawei.openalliance.p169ad.net.http.C7502e r29, com.huawei.openalliance.p169ad.net.http.C7498a r30) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.net.http.C7504g.mo45976b(com.huawei.openalliance.ad.net.http.e, com.huawei.openalliance.ad.net.http.a):com.huawei.openalliance.ad.net.http.Response");
    }

    /* renamed from: a */
    private void m46076a(C7498a c7498a, HttpURLConnection httpURLConnection) {
        if (c7498a.f34803k) {
            httpURLConnection.setRequestProperty("Content-Encoding", Constants.GZIP);
        }
        byte[] bArr = c7498a.f34802j;
        if (bArr != null) {
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        }
    }

    /* renamed from: b */
    private void m46079b(C7498a c7498a, HttpURLConnection httpURLConnection) {
        String str;
        if (m46045a(c7498a)) {
            str = FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM;
        } else {
            str = c7498a.f34799g;
            if (str == null) {
                return;
            }
        }
        httpURLConnection.setRequestProperty("Content-Type", str);
    }

    /* renamed from: a */
    private void m46077a(HttpURLConnection httpURLConnection, C7498a c7498a) {
        httpURLConnection.setRequestProperty(C5966j2.f27080v, Constants.GZIP);
        if (m46045a(c7498a)) {
            httpURLConnection.setRequestProperty("hw-request-type", m46046b(c7498a));
        }
        if (c7498a.f34800h == 1) {
            String strM48247k = AbstractC7807d.m48247k(this.f34826a);
            if (!TextUtils.isEmpty(strM48247k)) {
                httpURLConnection.setRequestProperty("User-Agent", strM48247k);
            }
        }
        C7500c c7500c = c7498a.f34798f;
        if (c7500c != null) {
            for (Map.Entry<String, String> entry : c7500c.m46049a().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    private boolean m46078a(URLConnection uRLConnection) {
        String headerField = uRLConnection.getHeaderField("Content-Encoding");
        return headerField != null && Constants.GZIP.equalsIgnoreCase(headerField);
    }
}
