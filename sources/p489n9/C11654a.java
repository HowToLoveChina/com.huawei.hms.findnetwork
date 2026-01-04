package p489n9;

import com.huawei.android.hicloud.commonlib.router.ISyncAccountModuleClient;
import com.huawei.android.hicloud.commonlib.router.ISyncAccountModuleService;
import java.util.ArrayList;
import java.util.List;

/* renamed from: n9.a */
/* loaded from: classes3.dex */
public class C11654a {

    /* renamed from: a */
    public static ISyncAccountModuleService f54065a;

    /* renamed from: b */
    public static List<ISyncAccountModuleClient> f54066b = new ArrayList();

    /* renamed from: a */
    public static void m69600a(ISyncAccountModuleClient iSyncAccountModuleClient) {
        if (iSyncAccountModuleClient != null) {
            f54066b.add(iSyncAccountModuleClient);
        }
    }

    /* renamed from: b */
    public static ISyncAccountModuleService m69601b() {
        return f54065a;
    }
}
