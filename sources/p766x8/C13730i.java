package p766x8;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.QueryOmBackupManager;
import com.huawei.android.hicloud.sync.syncutil.C2987p;
import com.huawei.android.hicloud.task.simple.C3032f2;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import lb.C11266a;
import p284fb.C9681b;
import p314gc.C9904a;
import p459lp.InterfaceC11332j;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p674ub.C13152i;
import p805yb.C13933c;

/* renamed from: x8.i */
/* loaded from: classes2.dex */
public class C13730i implements InterfaceC11332j {
    @Override // p459lp.InterfaceC11332j
    /* renamed from: a */
    public void mo68078a() {
        QueryOmBackupManager.getInstance().processBackupOmConfig();
    }

    @Override // p459lp.InterfaceC11332j
    /* renamed from: b */
    public void mo68079b() {
        C9904a.m61488b().m61494g("get_version");
    }

    @Override // p459lp.InterfaceC11332j
    /* renamed from: c */
    public void mo68080c() {
        C13152i.m79070o().m79098h();
    }

    @Override // p459lp.InterfaceC11332j
    /* renamed from: d */
    public void mo68081d() {
        C11266a.m67614b().m67616c("get_version");
    }

    @Override // p459lp.InterfaceC11332j
    /* renamed from: e */
    public void mo68082e() {
        if (!C11829c.m70530L0() && !C11829c.m70538P0()) {
            C11839m.m70689w("ConfigProxyImp", "not support pps ads");
        } else {
            C12515a.m75110o().m75172d(new C3032f2());
        }
    }

    @Override // p459lp.InterfaceC11332j
    /* renamed from: f */
    public void mo68083f() throws Throwable {
        NotificationConfig configFromFile;
        HNCloudConfig hNCloudConfig = new HNCloudConfig();
        NoticeContent noticeContentM17952b = C2987p.m17952b(4);
        if ((noticeContentM17952b != null && !TextUtils.isEmpty(noticeContentM17952b.getLanguage())) || (configFromFile = hNCloudConfig.getConfigFromFile()) == null || configFromFile.getHiCloudRiskRule() == null) {
            return;
        }
        NotifyLogger.m29915i("ConfigProxyImp", "risk config downloaded.");
        hNCloudConfig.clearSpaceNotifyDb();
        hNCloudConfig.extractConfig();
        NotificationReportUtil.reportSpaceNotifyClear(NotifyConstants.ClearSpaceFrequencyDBFrom.FROM_PROCESS_RISK_CONFIG);
    }

    @Override // p459lp.InterfaceC11332j
    /* renamed from: g */
    public void mo68084g() {
        C9681b.m60470l().m60472B();
    }

    @Override // p459lp.InterfaceC11332j
    /* renamed from: h */
    public void mo68085h() {
        C13933c.m83668n().m83689w("get_version");
    }
}
