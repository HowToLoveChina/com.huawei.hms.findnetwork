package com.huawei.android.hicloud.common.account;

import android.content.ComponentName;
import android.content.Context;
import android.database.SQLException;
import ca.C1399b;
import ca.C1400c;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.exiter.IExitProcessor;
import com.huawei.android.hicloud.p081cs.p082db.DBManager;
import com.huawei.android.hicloud.p088ui.activity.BackupMainforSettingActivity;
import com.huawei.feedback.FeedbackSdkProcessor;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.HiCloudBrandBannerManager;
import com.huawei.hicloud.notification.manager.HiCloudSceneBannerManager;
import com.huawei.hicloud.notification.manager.HiCloudSceneSpaceMgrManager;
import com.huawei.hicloud.notification.manager.HiCloudSpaceBrandMarketsManager;
import com.huawei.hicloud.notification.manager.HiCloudSpacePositionMgrManager;
import com.huawei.hicloud.notification.manager.HiCloudSpaceSceneNoticesManager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import gl.C9961b;
import gp.C10028c;
import p014aj.C0202a;
import p015ak.C0209d;
import p015ak.C0213f;
import p252e9.C9426c;
import p252e9.C9432i;
import p258ei.C9492a;
import p292fn.C9731d;
import p336he.C10155f;
import p362i9.C10455b;
import p454lj.C11296s;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p651t8.C12998f;
import p674ub.C13148e;
import p703v8.C13368e;
import p703v8.C13379p;
import p837z9.C14163d;
import p847zk.C14311d;
import p847zk.C14315h;

/* renamed from: com.huawei.android.hicloud.common.account.a */
/* loaded from: classes3.dex */
public class C2744a implements IExitProcessor {

    /* renamed from: com.huawei.android.hicloud.common.account.a$a */
    public static class a extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("CloudBackupExitProcessor", "clearDataInBackground");
            DBManager.m16248a();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.EXIT;
        }
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: a */
    public void mo15561a(boolean z10) throws SQLException {
        Context contextM1377a = C0213f.m1377a();
        C14315h.m85262p().m85279o(contextM1377a);
        m15564d();
        ICBBroadcastManager.unRegisterBroadcastReceiver(contextM1377a);
        m15565e(contextM1377a);
        C10155f.m63262O(contextM1377a, false);
        C9432i.m59149j().m59151e();
        C11296s.m67804a0(contextM1377a);
        C1400c.m8055a();
        C1399b.m8034o().m8040f();
        C9492a.m59357h().m59360c(contextM1377a);
        C0202a.m1119c().m1120a();
        C13368e.m80184F().m80226P().clear();
        C13368e.m80184F().m80267z();
        SdkProblemManager.getSdk().release();
        FeedbackSdkProcessor.notifyLoginChanged();
        HicloudH5ConfigManager.getInstance().clear();
        C9426c.m59108d().m59109a();
        C9961b.m61788i().m61799l();
        HiCloudSpaceBrandMarketsManager.getInstance().clearConfigFileAndDb();
        HiCloudSpaceSceneNoticesManager.getInstance().clearConfigFileAndDb();
        HiCloudBrandBannerManager.getInstance().clearConfigFileAndDb();
        HiCloudSceneBannerManager.getInstance().clearConfigFileAndDb();
        HiCloudSpacePositionMgrManager.getInstance().clearConfigFileAndDb();
        RecommendCardManager.getInstance().clear();
        C13379p.m80310f().m80312b();
        AdSwitchManager.getInstance().clear();
        C12998f.m78034R().m78138z();
        HiCloudSceneSpaceMgrManager.getInstance().clearConfigFileAndDb();
        C0209d.m1259h();
        C13148e.m79054c();
        C9731d.m60699d().m60701b();
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: b */
    public void mo15562b() {
        C14311d.m85230g().m85240m(C0213f.m1377a());
        DBManager.m16248a();
        C13368e.m80184F().m80226P().clear();
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: c */
    public void mo15563c(boolean z10) throws SQLException {
        C11839m.m70688i("CloudBackupExitProcessor", "CloudBackupExitProcessor exit start");
        if (C10028c.m62182c0().m62388s("backup_key") && C14163d.m84990g().m85007m()) {
            C12515a.m75110o().m75172d(new C10455b());
        }
        mo15561a(z10);
        C11839m.m70688i("CloudBackupExitProcessor", "CloudBackupExitProcessor exit end");
    }

    /* renamed from: d */
    public final void m15564d() {
        C12515a.m75110o().m75172d(new a());
    }

    /* renamed from: e */
    public final void m15565e(Context context) {
        if (ModuleConfigUtil.getInstance().isLocalVersion()) {
            return;
        }
        ComponentName componentName = new ComponentName(context, (Class<?>) BackupMainforSettingActivity.class);
        if (C2783d.m16107S() && C0209d.m1166E1()) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } else {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        }
    }
}
