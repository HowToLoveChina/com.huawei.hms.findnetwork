package com.huawei.android.hicloud.p088ui.activity;

import ae.C0118e0;
import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0219i;
import p429kk.C11058a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p664u0.C13108a;
import p684un.C13225d;
import p684un.C13230i;
import p711vl.C13467g;
import p814yl.C13998b0;
import pm.C12176c;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupRecordsSettingActivity extends UIActivity {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f13844p;

    /* renamed from: q */
    public C0118e0 f13845q;

    /* renamed from: r */
    public HandlerC3164b f13846r = new HandlerC3164b(this, null);

    /* renamed from: s */
    public int f13847s = -1;

    /* renamed from: t */
    public ListView f13848t;

    /* renamed from: u */
    public NotchFitRelativeLayout f13849u;

    /* renamed from: v */
    public TextView f13850v;

    /* renamed from: w */
    public NotchFitRelativeLayout f13851w;

    /* renamed from: x */
    public LocalReceiver f13852x;

    /* renamed from: y */
    public boolean f13853y;

    public class LocalReceiver extends BroadcastReceiver {
        public LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70688i("BackupRecordsSettingActivity", "LocalReceiver intent null");
                return;
            }
            String action = new HiCloudSafeIntent(intent).getAction();
            C11839m.m70686d("BackupRecordsSettingActivity", "LocalReceiver onReceive: " + action);
            if ("com.huawei.cloud.pay.action.updatespace".equals(action)) {
                BackupRecordsSettingActivity.this.f13853y = true;
                BackupRecordsSettingActivity.this.f13849u.setVisibility(0);
                BackupRecordsSettingActivity.this.m19175X1();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupRecordsSettingActivity$a */
    public class C3163a extends AbstractC12367d {
        public C3163a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("BackupRecordsSettingActivity", "request times");
            try {
                C12176c.m73260b(new C13998b0().m84137z("times", C11058a.m66627b("02307")), true);
                if (BackupRecordsSettingActivity.this.f13846r != null) {
                    C11839m.m70688i("BackupRecordsSettingActivity", "times fail.");
                    Message message = new Message();
                    message.what = 1;
                    BackupRecordsSettingActivity.this.f13846r.sendMessage(message);
                }
            } catch (C9721b unused) {
                if (BackupRecordsSettingActivity.this.f13846r != null) {
                    C11839m.m70688i("BackupRecordsSettingActivity", "times fail.");
                    Message message2 = new Message();
                    message2.what = 2;
                    BackupRecordsSettingActivity.this.f13846r.sendMessage(message2);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupRecordsSettingActivity$b */
    public class HandlerC3164b extends Handler {
        public HandlerC3164b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                BackupRecordsSettingActivity.this.m19176Z1();
                C11839m.m70688i("BackupRecordsSettingActivity", "handleMessage fail  gradeCode  ");
                return;
            }
            BackupRecordsSettingActivity.this.f13847s = C12590s0.m75892q0();
            if (BackupRecordsSettingActivity.this.f13853y && BackupRecordsSettingActivity.this.f13845q.m772e() == CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue()) {
                C13467g.m81086c().m81094i("user_number_of_backup_record", BackupRecordsSettingActivity.this.f13847s);
            }
            if (BackupRecordsSettingActivity.this.f13845q != null) {
                BackupRecordsSettingActivity.this.f13845q.m779l(BackupRecordsSettingActivity.this.f13847s);
            }
            BackupRecordsSettingActivity.this.m19176Z1();
        }

        public /* synthetic */ HandlerC3164b(BackupRecordsSettingActivity backupRecordsSettingActivity, C3163a c3163a) {
            this();
        }
    }

    /* renamed from: V1 */
    private void m19171V1() {
        this.f13847s = C12590s0.m75892q0();
        this.f13845q = new C0118e0(this, this.f13847s);
        ArrayList arrayList = new ArrayList();
        arrayList.add(CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS);
        arrayList.add(CloudBackupConstant.UserPackageInfo.VIP_BACKUP_RECORDS);
        this.f13845q.m778k(arrayList);
        this.f13848t.setAdapter((ListAdapter) this.f13845q);
    }

    /* renamed from: W1 */
    private void m19172W1() throws Resources.NotFoundException {
        this.f13844p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13851w = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.settings_parent);
        this.f13848t = (ListView) C12809f.m76829b(this, R$id.back_records_list);
        this.f13849u = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backups_loading);
        this.f13850v = (TextView) C12809f.m76829b(this, R$id.backup_page_tip);
        Resources resources = getResources();
        int i10 = R$plurals.backup_record_number_records;
        Integer num = CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS;
        String quantityString = resources.getQuantityString(i10, num.intValue(), num);
        Resources resources2 = getResources();
        Integer num2 = CloudBackupConstant.UserPackageInfo.VIP_BACKUP_RECORDS;
        this.f13850v.setText(getResources().getString(R$string.backup_record_page_tip_new, quantityString, resources2.getQuantityString(i10, num2.intValue(), num2)));
    }

    /* renamed from: Y1 */
    private void m19173Y1() {
        this.f13852x = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.cloud.pay.action.updatespace");
        C13108a.m78878b(this).m78880c(this.f13852x, intentFilter);
    }

    /* renamed from: U1 */
    public final void m19174U1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m22365E1(R$string.backup_record_page_title);
        if (C0219i.m1463a() < 14 || C0219i.m1463a() >= 17) {
            ActionBar actionBar = getActionBar();
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getColor(i10));
            }
        }
    }

    /* renamed from: X1 */
    public final void m19175X1() {
        C12515a.m75110o().m75172d(new C3163a());
    }

    /* renamed from: Z1 */
    public final void m19176Z1() {
        this.f13853y = false;
        NotchFitRelativeLayout notchFitRelativeLayout = this.f13849u;
        if (notchFitRelativeLayout != null) {
            notchFitRelativeLayout.setVisibility(8);
        }
    }

    /* renamed from: a2 */
    public final void m19177a2() {
        if (this.f13852x != null) {
            try {
                C13108a.m78878b(this).m78883f(this.f13852x);
                this.f13852x = null;
            } catch (Exception unused) {
                C11839m.m70687e("BackupRecordsSettingActivity", "unregisterBroadcastReceiver mLocalReceiver");
            }
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
        arrayList.add(this.f13844p);
        arrayList.add(this.f13851w);
        arrayList.add(this.f13849u);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_backup_records_setting);
        m19172W1();
        m19171V1();
        m19174U1();
        mo19005p1();
        m19173Y1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m19177a2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C0118e0 c0118e0 = this.f13845q;
        if (c0118e0 != null) {
            c0118e0.notifyDataSetChanged();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: p1 */
    public void mo19005p1() {
        List<View> listMo13289d1 = mo13289d1();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo13289d1);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listMo13289d1);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m22387z1(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }
}
