package com.huawei.android.hicloud.p088ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudspace.bean.BackupCacheInfo;
import com.huawei.android.hicloud.commonlib.space.FullQuotaInfo;
import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import com.huawei.android.hicloud.commonlib.space.UsedSpaceInfo;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import hu.C10342a;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import je.C10802p;
import p015ak.C0226l0;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;
import p431ko.C11075a;
import p514o9.C11839m;
import p703v8.C13379p;

/* loaded from: classes3.dex */
public class BackupRouterActivity extends CloudBackupBaseUiActivity {

    /* renamed from: C */
    public final C11075a f13857C = new C11075a(new C3165a());

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupRouterActivity$a */
    public class C3165a implements C11075a.a<UsedSpaceInfo> {
        public C3165a() {
        }

        @Override // p431ko.C11075a.a
        /* renamed from: b */
        public void mo19190b() {
            NotifyLogger.m29915i("BackupRouterActivity", "on error");
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.t1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17735a.m19192f();
                }
            });
        }

        @Override // p431ko.C11075a.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public UsedSpaceInfo mo19189a() throws C9721b {
            return BackupRouterActivity.this.m19183X1();
        }

        /* renamed from: f */
        public final /* synthetic */ void m19192f() {
            BackupRouterActivity.this.m19184Y1();
        }

        /* renamed from: g */
        public final /* synthetic */ void m19193g(UsedSpaceInfo usedSpaceInfo) {
            BackupRouterActivity.this.m19186a2(usedSpaceInfo.getUsed() > 0);
        }

        @Override // p431ko.C11075a.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(final UsedSpaceInfo usedSpaceInfo) {
            NotifyLogger.m29915i("BackupRouterActivity", "on result");
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.s1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17722a.m19193g(usedSpaceInfo);
                }
            });
        }
    }

    /* renamed from: b2 */
    public static /* synthetic */ boolean m19182b2(UsedSpaceInfo usedSpaceInfo) {
        return TextUtils.equals(usedSpaceInfo.getKey(), CloudBackupConstant.Command.PMS_CMD_BACKUP);
    }

    /* renamed from: X1 */
    public final UsedSpaceInfo m19183X1() throws C9721b {
        QuotaInfoRsp quotaInfoRspMo17182o = ((InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class)).mo17182o();
        if (quotaInfoRspMo17182o == null) {
            throw new C9721b(4003, "quota request fail");
        }
        FullQuotaInfo retBody = quotaInfoRspMo17182o.getRetBody();
        if (retBody == null) {
            throw new C9721b(4003, "info is null");
        }
        if (!TextUtils.equals(retBody.getRetType(), "val")) {
            throw new C9721b(4003, "return type is not val");
        }
        List<UsedSpaceInfo> usedInfos = retBody.getUsedInfos();
        if (usedInfos == null || usedInfos.isEmpty()) {
            throw new C9721b(4003, "usedInfos is null");
        }
        return usedInfos.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.r1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BackupRouterActivity.m19182b2((UsedSpaceInfo) obj);
            }
        }).findFirst().orElse(null);
    }

    /* renamed from: Y1 */
    public final void m19184Y1() {
        C11839m.m70688i("BackupRouterActivity", "getDataError");
        m19186a2(true);
    }

    /* renamed from: Z1 */
    public void m19185Z1() {
        mo19005p1();
        m19238R1();
    }

    /* renamed from: a2 */
    public final void m19186a2(boolean z10) {
        NotifyLogger.m29915i("BackupRouterActivity", "jump hasBackupData:" + z10);
        String str = z10 ? NotifyConstants.HICLOUD_BACKUP_MANAGER : NotifyConstants.HICLOUD_BACKUP_OPTION;
        SafeIntent safeIntent = new SafeIntent(C10802p.m65746a(this, "application", str));
        safeIntent.addFlags(33554432);
        if (str.equals(NotifyConstants.HICLOUD_BACKUP_MANAGER)) {
            safeIntent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        }
        C10342a.m63676b(this, safeIntent);
        overridePendingTransition(0, 0);
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13885p);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m19185Z1();
        BackupCacheInfo backupCacheInfoM80314d = C13379p.m80310f().m80314d();
        if (backupCacheInfoM80314d == null || backupCacheInfoM80314d.getBackupUsedSize() <= 0) {
            this.f13857C.execute();
        } else {
            NotifyLogger.m29915i("BackupRouterActivity", "jump with cache");
            m19186a2(true);
        }
    }
}
