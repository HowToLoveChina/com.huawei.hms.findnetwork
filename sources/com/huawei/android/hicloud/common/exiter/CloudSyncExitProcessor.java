package com.huawei.android.hicloud.common.exiter;

import android.content.Context;
import android.content.Intent;
import bd.C1164a;
import com.huawei.android.hicloud.complexutil.C2785f;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.exiter.IExitProcessor;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverService;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.hicloud.sync.service.aidl.ToolSyncService;
import com.huawei.hicloud.base.bean.ExiterSyncData;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.manager.DriveModuleConfigManager;
import com.huawei.hicloud.notification.manager.SyncModuleConfigManager;
import java.util.Iterator;
import md.C11440c;
import nc.C11662a;
import p015ak.C0212e0;
import p015ak.C0213f;
import p223db.C9062b;
import p363ia.C10463a;
import p488n8.C11653a;
import p514o9.C11829c;
import p514o9.C11839m;
import p572qb.C12308f0;
import p572qb.C12316j0;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13226e;
import pa.C12123a;
import sc.C12768a;
import tc.C13007b;

/* loaded from: classes3.dex */
public class CloudSyncExitProcessor implements IExitProcessor {

    public static class ClearDataTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f11923a;

        public ClearDataTask(Context context) {
            this.f11923a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("CloudSyncExitProcessor", "clearAllInfo begin");
            C12768a.m76624a(this.f11923a);
            C10463a.m64279e().m64286i();
            C12123a c12123a = new C12123a();
            c12123a.m72690f();
            c12123a.m72691g();
            C11839m.m70688i("CloudSyncExitProcessor", "clearAllInfo end");
        }
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: a */
    public void mo15561a(boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        m15573e(contextM1377a);
        C11653a.m69582l().m69586b(2010);
        CloudSyncUtil.m16036p(contextM1377a);
        if (!C11829c.m70611r0()) {
            C12338d.m74195s().m74233k0();
        }
        SyncModuleConfigManager.getInstance().clearDB();
        DriveModuleConfigManager.getInstance().clearDB();
        C0212e0.m1351a(contextM1377a, "driveConfig");
        C2785f.m16206b();
        C2786g.m16213b();
        C12316j0.m74076d().m74078b();
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: b */
    public void mo15562b() {
        Context contextM1377a = C0213f.m1377a();
        C11440c.m68541t(SyncObserverServiceInvoker.getInstance().getAllSyncType(), FamilyShareConstants.MessageCode.GET_USERPACKAGE_FOR_INVITE_FAMILY_MEMBER);
        SyncObserverServiceInvoker.getInstance().startSync(contextM1377a, 10, "");
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: c */
    public void mo15563c(boolean z10) {
        String str;
        C1164a.m7265f().m7273j();
        C12308f0.m74000d().m74006g();
        C2785f.m16206b();
        C2786g.m16213b();
        Iterator<ExiterSyncData> it = C9062b.m57146k().m57157j().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "retain";
                break;
            } else if (!it.next().isRetainState()) {
                str = "delete";
                break;
            }
        }
        C13226e.m79491f1().m79551D0("0", str);
        mo15561a(z10);
    }

    /* renamed from: d */
    public final void m15572d(Context context) {
        C12515a.m75110o().m75175e(new ClearDataTask(context), true);
    }

    /* renamed from: e */
    public final void m15573e(Context context) {
        C11839m.m70688i("CloudSyncExitProcessor", "onAccountLogOut");
        m15572d(context);
        try {
            C13007b.m78205Y(context).m78248a();
            C11662a.m69650c(context).m69651a();
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncExitProcessor", "clear sync setting error." + e10.toString());
        }
        context.stopService(new Intent(context, (Class<?>) SyncObserverService.class));
        context.stopService(new Intent(context, (Class<?>) SyncLogicService.class));
        context.stopService(new Intent(context, (Class<?>) GenSyncLogicService.class));
        context.stopService(new Intent(context, (Class<?>) ToolSyncService.class));
    }
}
