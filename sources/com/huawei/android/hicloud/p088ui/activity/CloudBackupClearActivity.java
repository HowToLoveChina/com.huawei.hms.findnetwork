package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.backup.CleanupEntryView;
import com.huawei.android.hicloud.task.simple.C3012a2;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupClearActivity extends UIActivity {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f13896p;

    /* renamed from: q */
    public NotchFitRelativeLayout f13897q;

    /* renamed from: r */
    public CleanupEntryView f13898r;

    /* renamed from: s */
    public long f13899s = 0;

    /* renamed from: t */
    public C13149f f13900t = new C13149f();

    /* renamed from: u */
    public final Handler f13901u = new HandlerC3169a(Looper.myLooper());

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupClearActivity$a */
    public class HandlerC3169a extends Handler {
        public HandlerC3169a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            C11839m.m70688i("CloudBackupClearActivity", "msg what: " + message.what);
            if (message.what == 9000) {
                Object obj = message.obj;
                if (obj instanceof C3012a2.a) {
                    C3012a2.a aVar = (C3012a2.a) obj;
                    C11839m.m70688i("CloudBackupClearActivity", "msg dataCallback: " + aVar.toString());
                    CloudBackupClearActivity.this.m19248T1(aVar);
                    CloudBackupClearActivity.this.m19249U1(aVar);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupClearActivity$b */
    public class C3170b extends AbstractC12367d {
        public C3170b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                CloudSpace cloudSpace = CloudSpaceNotifyUtil.getInstance().getSpaceProxy().getCloudSpace();
                if (cloudSpace != null) {
                    CloudBackupClearActivity.this.f13899s = cloudSpace.getTotal();
                }
                CloudBackupClearActivity.this.f13898r.setTotalSize(CloudBackupClearActivity.this.f13899s);
                C11839m.m70688i("getQuotaSpaceInfo", "getQuotaSpaceInfo total:" + CloudBackupClearActivity.this.f13899s);
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupClearActivity", "QuerySpaceCheckVipTask querySpace error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: Q1 */
    private void m19245Q1() {
        this.f13896p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f13897q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.normal_view);
        CleanupEntryView cleanupEntryView = (CleanupEntryView) C12809f.m76829b(this, R$id.cleanup_entry_view);
        this.f13898r = cleanupEntryView;
        cleanupEntryView.setEntry(CleanupEntryView.BACKUP_CLEAR);
        this.f13898r.setActivity(this);
    }

    /* renamed from: S1 */
    private void m19246S1() {
        View viewM76829b = C12809f.m76829b(this, R$id.set_network_not_connect);
        View viewM76829b2 = C12809f.m76829b(this, R$id.rl_fit_loading);
        C11842p.m70760Q1(this, viewM76829b);
        C11842p.m70760Q1(this, viewM76829b2);
    }

    /* renamed from: R1 */
    public final void m19247R1() {
        C12515a.m75110o().m75175e(new C3170b(), false);
        C12515a.m75110o().m75175e(new C3012a2(this.f13901u), false);
    }

    /* renamed from: T1 */
    public final void m19248T1(C3012a2.a aVar) throws Resources.NotFoundException {
        if (aVar.m18189b() == 0) {
            this.f13898r.setOldDeviceTip(aVar.m18188a());
        } else {
            this.f13898r.setDeviceErrorSubTip();
        }
    }

    /* renamed from: U1 */
    public final void m19249U1(C3012a2.a aVar) throws Resources.NotFoundException {
        if (aVar.m18189b() == 0) {
            this.f13898r.setOldRecordsTip(aVar.m18190c());
        } else {
            this.f13898r.setRecordErrorSubTip();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13896p);
        arrayList.add(this.f13897q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws Resources.NotFoundException {
        C11839m.m70688i("CloudBackupClearActivity", "onActivityResult requestCode: " + i10 + ", resultCode: " + i11);
        if (intent == null) {
            C11839m.m70689w("CloudBackupClearActivity", "onActivityResult data is null");
            m19247R1();
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if (10000 == i10) {
            int intExtra = safeIntent.getIntExtra(CleanupEntryView.OLD_DEVICE_SIZE, -1);
            C11839m.m70688i("CloudBackupClearActivity", "onActivityResult oldDeviceSize: " + intExtra);
            if (-1 == intExtra) {
                m19247R1();
                return;
            } else {
                this.f13898r.setOldDeviceTip(intExtra);
                return;
            }
        }
        if (10001 != i10) {
            m19247R1();
            return;
        }
        int cleanRecordsNum = BackupCleanRecordsManager.getInstance().getCleanRecordsNum();
        C11839m.m70688i("CloudBackupClearActivity", "onActivityResult oldBackupRecords: " + cleanRecordsNum);
        this.f13898r.setOldRecordsTip(cleanRecordsNum);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m19246S1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.cloud_backup_clear_activity);
        m22365E1(R$string.cloud_backup_clear_item_title);
        mo19982C1();
        m19245Q1();
        mo19005p1();
        this.f13898r.initSubTip();
        m19247R1();
        this.f13900t.m79065c(this, getIntent(), C13222a.m79465g(this));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
