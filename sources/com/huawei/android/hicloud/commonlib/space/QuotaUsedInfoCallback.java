package com.huawei.android.hicloud.commonlib.space;

import android.os.Build;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import java.net.URLEncoder;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class QuotaUsedInfoCallback extends AbstractC4994a {
    private static final String TAG = "AgreementServiceCallback";
    private String accessToken;
    private String request;

    public QuotaUsedInfoCallback(String str, String str2, String str3, String str4) {
        super(str2, str4, "GET");
        this.accessToken = str;
        this.request = str3;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        MimeClass MimeClassM71445d = MimeClass.m71445d(RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nsp_svc=");
        sb2.append(URLEncoder.encode(this.svc, Constants.UTF_8));
        sb2.append("&access_token=");
        sb2.append(URLEncoder.encode(this.accessToken, Constants.UTF_8));
        sb2.append("&request=");
        sb2.append(URLEncoder.encode(this.request, Constants.UTF_8));
        C11839m.m70686d(TAG, "doOutput:" + sb2.toString());
        return AbstractC11920f0.create(MimeClassM71445d, sb2.toString().getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.accessToken);
        StringBuilder sb2 = new StringBuilder("com.huawei.hidisk/");
        sb2.append("16.0.0.300");
        sb2.append(" (Linux; HarmonyOS ");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append("; ");
        String str = Build.MODEL;
        sb2.append(str);
        sb2.append("; ");
        sb2.append("HUAWEI");
        sb2.append(str);
        sb2.append(") ");
        sb2.append("HMS/");
        sb2.append("2.6.3.306");
        sb2.append(" (");
        sb2.append("10055832)");
        aVar.addHeader("User-Agent", sb2.toString());
    }
}
