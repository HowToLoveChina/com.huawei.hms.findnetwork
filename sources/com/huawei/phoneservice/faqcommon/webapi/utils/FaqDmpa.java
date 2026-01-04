package com.huawei.phoneservice.faqcommon.webapi.utils;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import java.lang.ref.WeakReference;
import java.util.Calendar;

/* loaded from: classes4.dex */
public class FaqDmpa implements FaqIDmpa {

    /* renamed from: a */
    public String f39423a;

    /* renamed from: b */
    public WeakReference<Context> f39424b;

    /* renamed from: com.huawei.phoneservice.faqcommon.webapi.utils.FaqDmpa$a */
    public static class C8445a implements Callback {
        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) throws Throwable {
            FaqLogger.m51840e("FaqNewDmpa", "send data to dmpa failed with other exception " + th2.getMessage());
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            String strByte2Str = StringUtils.byte2Str(response.getBody().bytes());
            if (response.isSuccessful()) {
                FaqLogger.m51836d("FaqNewDmpa", "send data to dmpa success. " + strByte2Str);
                return;
            }
            FaqLogger.m51840e("FaqNewDmpa", "send data to dmpa failed. responseCode is " + response.getCode() + "responseMsg is " + response.getMessage() + "errorResult is " + strByte2Str);
        }
    }

    @Keep
    public FaqDmpa(Context context, String str) {
        this.f39424b = new WeakReference<>(context);
        this.f39423a = str;
    }

    @Override // com.huawei.phoneservice.faqcommon.webapi.utils.FaqIDmpa
    public void dmpa(String str, String str2) throws Throwable {
        Headers headersBuild = new Headers.Builder().add("Content-Type", RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED).add("User-Agent", System.getProperty("http.agent")).build();
        try {
            C8446a c8446a = new C8446a();
            c8446a.m52528b(str2);
            c8446a.m52527a(str);
            c8446a.m52529c(this.f39423a);
            c8446a.m52530d("495556");
            c8446a.m52531e(String.valueOf(System.currentTimeMillis()));
            c8446a.m52532f(String.valueOf(Calendar.getInstance().getTimeZone()));
            FaqRestClient.initRestClientAnno(this.f39424b.get()).asyncRequestWitHead(this.f39424b.get(), FaqUtil.getDmpaUrl(), headersBuild, new Gson().toJson(c8446a), new C8445a());
        } catch (Throwable th2) {
            FaqLogger.m51840e("FaqNewDmpa", "send data to dmpa failed due to " + th2.getMessage());
        }
    }
}
