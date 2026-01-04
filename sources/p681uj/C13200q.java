package p681uj;

import android.content.Context;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import p015ak.C0213f;
import p683um.C13221b;

/* renamed from: uj.q */
/* loaded from: classes5.dex */
public class C13200q {
    /* renamed from: a */
    public static HuaweiIdAuthService m79391a() {
        HuaweiIdAuthParams huaweiIdAuthParamsCreateParams = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setScopeList(C13221b.m79457d()).setAuthorizationCode().setAccessToken().setUid().setProfile().createParams();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return HuaweiIdAuthManager.getService(contextM1377a, huaweiIdAuthParamsCreateParams);
        }
        BaseLogger.m28731e("HuaweiIdAuthServiceBuilder", "context is null");
        return null;
    }
}
