package com.huawei.android.hicloud.sync.protocol;

import android.text.TextUtils;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p514o9.C11829c;

/* renamed from: com.huawei.android.hicloud.sync.protocol.b */
/* loaded from: classes3.dex */
public abstract class AbstractC2923b extends AbstractC4994a {
    protected static final String APP_ID = "com.huawei.hidisk";
    protected static final String DEVICE_TYPE_UDID = "9";
    protected static final String NET_TYPE = "0";
    protected String accessToken;
    private int encryptVersion;
    private String request;

    public AbstractC2923b(String str, String str2, String str3, String str4, int i10) {
        super(str2, str4, "POST");
        this.accessToken = str;
        this.request = str3;
        this.encryptVersion = i10;
    }

    public abstract String addAuthHeader();

    public abstract String addLockTokenToHeader();

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/json; charset=utf-8"), this.request.getBytes(StandardCharsets.UTF_8));
    }

    public abstract void onReceiveLockToken(String str);

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader("Connection", "close");
        C11829c.m70559a(aVar);
        String strAddAuthHeader = addAuthHeader();
        if (!TextUtils.isEmpty(strAddAuthHeader)) {
            aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, strAddAuthHeader);
        }
        int i10 = this.encryptVersion;
        if (i10 != 0) {
            aVar.addHeader("encversion", String.valueOf(i10));
        }
        String strAddLockTokenToHeader = addLockTokenToHeader();
        if (TextUtils.isEmpty(strAddLockTokenToHeader)) {
            return;
        }
        aVar.addHeader("Lock-Token", strAddLockTokenToHeader);
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(HttpResponseBuilder HttpResponseBuilder) throws C9721b, IOException {
        onReceiveLockToken(HttpResponseBuilder.m71599w("Lock-Token"));
        return super.onResponse(HttpResponseBuilder);
    }
}
