package com.huawei.hicloud.request.upload;

import android.os.Build;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import p336he.C10160k;
import p514o9.C11829c;

/* loaded from: classes6.dex */
public class PreUploadCallback extends AbstractC4994a {
    private String body;

    public PreUploadCallback(String str, String str2, String str3) {
        super(str, str3, "POST");
        this.body = str2;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(MimeClass.m71445d("application/x-www-form-urlencoded; charset=utf-8"), this.body.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        super.prepare(aVar);
        aVar.addHeader("User-Agent", "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)");
        aVar.m71578e("x-hw-unique-trace-id", C10160k.m63341b("04015"));
    }
}
