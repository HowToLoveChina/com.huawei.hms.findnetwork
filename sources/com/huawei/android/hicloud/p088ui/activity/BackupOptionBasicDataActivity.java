package com.huawei.android.hicloud.p088ui.activity;

import ae.C0153o0;
import android.app.ActionBar;
import android.content.res.Resources;
import android.os.Message;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.task.GetBackupCardInfoTask;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p815ym.AbstractC14026a;
import pm.C12176c;

/* loaded from: classes3.dex */
public class BackupOptionBasicDataActivity extends BasicDataActivity {

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionBasicDataActivity$a */
    public class C3140a extends AbstractC12367d {
        public C3140a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void m18871e() {
            BackupOptionBasicDataActivity.this.mo19229P1(R$string.backup_option_no_data, R$drawable.pay_sync_nodata);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            BackupOptionBasicDataActivity.this.mo19229P1(R$string.backup_option_no_data, R$drawable.pay_sync_nodata);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            List<String> listM73271n = C12176c.m73271n(null);
            List<BackupOptionItem> backupOptionItems = GetBackupCardInfoTask.getBackupOptionItems(null);
            if (AbstractC14026a.m84159a(backupOptionItems)) {
                BackupOptionBasicDataActivity.this.runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17582a.lambda$call$0();
                    }
                });
                return;
            }
            List<BackupOptionItem> baseDataList = GetBackupCardInfoTask.getBaseDataList(backupOptionItems, listM73271n);
            if (AbstractC14026a.m84159a(baseDataList)) {
                BackupOptionBasicDataActivity.this.runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17592a.m18871e();
                    }
                });
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (BackupOptionItem backupOptionItem : baseDataList) {
                AppDetailsInfo appDetailsInfo = new AppDetailsInfo();
                appDetailsInfo.setBackupAppName(backupOptionItem.getAppId());
                appDetailsInfo.setName(C12590s0.m75770M(BackupOptionBasicDataActivity.this, backupOptionItem.getAppId()));
                arrayList.add(appDetailsInfo);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 330000;
            messageObtain.obj = arrayList;
            BackupOptionBasicDataActivity.this.f13867K.sendMessage(messageObtain);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BasicDataActivity
    /* renamed from: a2 */
    public void mo18866a2() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R$string.all_basic_data));
        }
        C12515a.m75110o().m75172d(new C3140a());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BasicDataActivity
    /* renamed from: b2 */
    public void mo18867b2() {
        super.mo18867b2();
        TextView textView = this.f13865I;
        if (textView != null) {
            textView.setText(R$string.backup_basic_data_des_new);
        }
        m19238R1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BasicDataActivity
    /* renamed from: n2 */
    public void mo18868n2(List<AppDetailsInfo> list) throws Resources.NotFoundException {
        this.f13862F = list;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("BackupOptionBasicDataActivity", "showDetailList: recordItem data is null");
            return;
        }
        C0153o0 c0153o0 = new C0153o0(this, this.f13867K, this.f13862F);
        this.f13864H = c0153o0;
        this.f13863G.setAdapter((ListAdapter) c0153o0);
        this.f13860D.setText(getResources().getQuantityString(R$plurals.backup_basic_data_count_tips_new, this.f13862F.size(), Integer.valueOf(this.f13862F.size())));
    }
}
