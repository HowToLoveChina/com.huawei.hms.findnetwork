package p257eh;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ConnectConfig;

/* renamed from: eh.d */
/* loaded from: classes4.dex */
public class C9482d {
    /* renamed from: a */
    public static Intent m59331a(String str, ConnectConfig connectConfig) {
        Intent intent = new Intent(m59332b(connectConfig));
        intent.setPackage(str);
        return intent;
    }

    /* renamed from: b */
    public static String m59332b(ConnectConfig connectConfig) {
        return (connectConfig == null || TextUtils.isEmpty(connectConfig.getConnectServiceAction())) ? "com.huawei.appmarket.service.intent.ACTION_CORE_SERVICE" : connectConfig.getConnectServiceAction();
    }
}
