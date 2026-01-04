package p311g7;

import android.content.Context;
import android.database.SQLException;
import com.huawei.android.hicloud.exiter.IExitProcessor;
import com.huawei.cloud.banner.manager.FrontAppDownloadManager;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import lc.C11268b;
import p015ak.C0213f;
import p258ei.C9494c;
import p572qb.C12314i0;
import p572qb.C12332x;
import p766x8.C13731j;

/* renamed from: g7.b */
/* loaded from: classes2.dex */
public class C9889b implements IExitProcessor {
    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: a */
    public void mo15561a(boolean z10) throws SQLException {
        Context contextM1377a = C0213f.m1377a();
        C11268b.m67619i().m67621f();
        C12314i0.m74036h().m74040e();
        C13731j.m82515e(contextM1377a);
        C9494c.m59390r().m59419e0();
        FrontAppDownloadManager.m28137j().m28151s();
        C12332x.m74156a().m74158c();
        HiCloudForceUpgradeConfigManager.getInstance().clearForceUpgradeConfig();
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: c */
    public void mo15563c(boolean z10) throws SQLException {
        mo15561a(z10);
    }
}
