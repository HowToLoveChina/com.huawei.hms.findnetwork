package com.huawei.hicloud.request.notify.callback;

import android.text.TextUtils;
import com.huawei.hicloud.okhttp.request.AbstractC4977a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import p015ak.C0209d;
import p015ak.C0213f;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class NotifyCallback extends AbstractC4977a {
    protected String accessToken;
    private String body;

    public NotifyCallback(String str, String str2, String str3, String str4) {
        super(str2, str4, "POST");
        this.accessToken = str;
        this.body = str3;
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4976b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.body.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.okhttp.request.AbstractC4977a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(C11918e0.a aVar) throws C9721b, NoSuchMethodException, IOException, SecurityException {
        super.prepare(aVar);
        aVar.m71574a("x-hw-userid", C13452e.m80781L().m80971t0());
        aVar.m71574a("x-hw-app-id", "10055832");
        aVar.m71574a("x-hw-callfrom", "com.huawei.hidisk");
        String strM1324x0 = C0209d.m1324x0();
        if (TextUtils.isEmpty(strM1324x0)) {
            strM1324x0 = "";
        }
        aVar.m71574a("x-hw-deviceUDID", strM1324x0);
        aVar.m71574a("x-hw-network", C0209d.m1228Z(C0209d.m1225Y(C0213f.m1377a())));
        C0209d.m1231a(aVar);
        aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.accessToken);
    }
}
