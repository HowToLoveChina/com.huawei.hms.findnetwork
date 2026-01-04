package p681uj;

import android.content.Context;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import java.util.ArrayList;
import p015ak.C0213f;
import p683um.C13221b;

/* renamed from: uj.r */
/* loaded from: classes5.dex */
public class C13201r {
    /* renamed from: a */
    public static HuaweiIdAuthService m79392a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope(C13221b.m79456c("WEB_SCOPE")));
        arrayList.add(new Scope(C13221b.m79456c("TOOL_WEB_SCOPE")));
        HuaweiIdAuthParams huaweiIdAuthParamsCreateParams = new HuaweiIdAuthParamsHelper().setScopeList(arrayList).setAuthorizationCode().setAccessToken().createParams();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return HuaweiIdAuthManager.getService(contextM1377a, huaweiIdAuthParamsCreateParams);
        }
        BaseLogger.m28731e("HuaweiIdAuthServiceBuilderByWebView", "context is null");
        return null;
    }
}
