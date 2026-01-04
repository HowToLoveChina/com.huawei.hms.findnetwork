package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0241z;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12540b1;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p848zl.C14339h;
import sk.C12809f;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes3.dex */
public class CloudGuideBackupActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public TextView f14300p;

    /* renamed from: q */
    public TextView f14301q;

    /* renamed from: r */
    public TextView f14302r;

    /* renamed from: s */
    public AutoSizeButton f14303s;

    /* renamed from: t */
    public RelativeLayout f14304t;

    /* renamed from: u */
    public LinearLayout f14305u;

    /* renamed from: v */
    public LinearLayout f14306v;

    /* renamed from: x */
    public boolean f14308x;

    /* renamed from: y */
    public CloudBackupState f14309y;

    /* renamed from: z */
    public float f14310z;

    /* renamed from: w */
    public int f14307w = 0;

    /* renamed from: A */
    public Handler.Callback f14299A = new C3222a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudGuideBackupActivity$a */
    public class C3222a implements Handler.Callback {
        public C3222a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws Resources.NotFoundException {
            int i10 = message.arg1;
            switch (message.what) {
                case 3211:
                    int i11 = R$plurals.cloudbackup_prepare_all_data_time_end;
                    CloudGuideBackupActivity.this.f14300p.setText(CloudGuideBackupActivity.this.getResources().getQuantityString(R$plurals.backup_not_complete_guide_tip_sum_time_last_one_week, 7, 7, CloudGuideBackupActivity.this.m19767Z1(i10, R$plurals.remain_time_hour, i11, null)));
                    CloudGuideBackupActivity.this.m19761Q1();
                    break;
                case 3212:
                    int i12 = R$plurals.cloudbackup_prepare_all_data_time_end_away;
                    String strM19767Z1 = CloudGuideBackupActivity.this.m19767Z1(i10, R$plurals.remain_time_hour_away, i12, Integer.valueOf(R$plurals.remain_time_day_away));
                    CloudGuideBackupActivity.this.f14302r.setText(CloudGuideBackupActivity.this.getResources().getString(C0209d.m1167E2(R$string.backup_not_complete_predict_suggestion, R$string.backup_not_complete_predict_suggestion2), strM19767Z1));
                    CloudGuideBackupActivity.this.m19761Q1();
                    break;
                case 3213:
                    if (i10 > 180) {
                        CloudGuideBackupActivity.this.f14301q.setText(CloudGuideBackupActivity.this.getResources().getString(R$string.backup_not_complete_guide_tip_predict_beyond_time, 3));
                    } else {
                        int i13 = R$plurals.backup_not_complete_minute;
                        CloudGuideBackupActivity.this.f14301q.setText(CloudGuideBackupActivity.this.getResources().getString(R$string.backup_not_complete_guide_tip_predict_time, CloudGuideBackupActivity.this.m19767Z1(i10, R$plurals.remain_time_hour, i13, null)));
                    }
                    CloudGuideBackupActivity.this.m19761Q1();
                    break;
            }
            return false;
        }
    }

    /* renamed from: U1 */
    private void m19758U1() throws Resources.NotFoundException {
        String strM19767Z1 = m19767Z1(0, R$plurals.remain_time_hour, R$plurals.cloudbackup_prepare_all_data_time_end, null);
        this.f14300p.setText(getResources().getQuantityString(R$plurals.backup_not_complete_guide_tip_sum_time_last_one_week, 7, 7, strM19767Z1));
        String stringExtra = new HiCloudSafeIntent(getIntent()).getStringExtra("backup_no_success_backup_state");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f14309y = (CloudBackupState) C12540b1.m75483a(stringExtra, CloudBackupState.class);
        }
        String strM19763S1 = m19763S1(this.f14309y, m19765W1());
        if (TextUtils.isEmpty(strM19763S1)) {
            this.f14301q.setText(R$string.backup_loading);
        } else {
            this.f14308x = true;
            this.f14301q.setText(strM19763S1);
        }
        this.f14302r.setText(getResources().getString(C0209d.m1167E2(R$string.backup_not_complete_guide_suggestion, R$string.backup_not_complete_guide_suggestion2), strM19767Z1));
        CloudBackupService.getInstance().refreshGuideBackupInfo(!this.f14308x);
    }

    /* renamed from: V1 */
    private void m19759V1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f14305u = (LinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14306v = (LinearLayout) C12809f.m76829b(this, R$id.ll_top);
        this.f14300p = (TextView) C12809f.m76829b(this, R$id.tv_backup_guide_tip_sum_time);
        this.f14301q = (TextView) C12809f.m76829b(this, R$id.tv_backup_guide_tip_predict_time);
        this.f14302r = (TextView) C12809f.m76829b(this, R$id.tv_backup_guide_suggestion);
        this.f14303s = (AutoSizeButton) C12809f.m76829b(this, R$id.backup_now_title);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.backup_guide_loading);
        this.f14304t = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f14303s.setOnClickListener(this);
        C11842p.m70874v1(this, this.f14303s);
        mo13327n1();
    }

    /* renamed from: Y1 */
    private void m19760Y1() {
        if (this.f14310z >= 1.75f) {
            setContentView(R$layout.activity_guide_backup_font_scale);
        } else {
            setContentView(R$layout.activity_guide_backup);
        }
    }

    /* renamed from: Q1 */
    public final void m19761Q1() {
        int i10 = this.f14307w + 1;
        this.f14307w = i10;
        if (i10 >= m19764T1()) {
            this.f14304t.setVisibility(8);
        }
    }

    /* renamed from: R1 */
    public String m19762R1(int i10) {
        String strM25632b;
        String spaceMultLanguage;
        if (C14339h.m85509h().contains(Integer.valueOf(i10))) {
            return getString(R$string.cloud_backup_failed_module_dataabnormal);
        }
        if (C14339h.m85510i().contains(Integer.valueOf(i10))) {
            return getString(R$string.cloud_backup_failed_module_file_changed);
        }
        strM25632b = "";
        if (C14339h.m85511j().contains(Integer.valueOf(i10))) {
            C13029h c13029hM19765W1 = m19765W1();
            if (c13029hM19765W1 != null) {
                String strM78463e = c13029hM19765W1.m78463e();
                if (strM78463e.contains("_")) {
                    String[] strArrSplit = strM78463e.split("_");
                    strM78463e = strArrSplit.length > 0 ? strArrSplit[0] : "";
                }
                strM25632b = NewHiSyncUtil.m25632b(strM78463e);
            }
            return TextUtils.isEmpty(strM25632b) ? getString(R$string.cloud_backup_failed_foreground_app_exist_2) : getString(R$string.cloud_backup_failed_foreground_app, strM25632b);
        }
        if (C14339h.m85506e().contains(Integer.valueOf(i10))) {
            return getString(R$string.cloud_restore_failed_battery, 5);
        }
        if (C14339h.m85505d().contains(Integer.valueOf(i10))) {
            return getString(R$string.cloud_backup_failed_battery2, C2783d.m16144h(10));
        }
        if (C14339h.m85504c().contains(Integer.valueOf(i10))) {
            return getString(R$string.cloud_backup_failed_service_occupied);
        }
        if (C14339h.m85502a().contains(Integer.valueOf(i10))) {
            return getString(R$string.auto_backup_failed_power);
        }
        if (C14339h.m85503b().contains(Integer.valueOf(i10))) {
            return getString(R$string.auto_backup_failed_screen);
        }
        if (C14339h.m85507f().contains(Integer.valueOf(i10))) {
            return getString(R$string.cloud_backup_failed_server_busy);
        }
        if (3911 == i10) {
            String string = getString(R$string.backup_failed_tip_20181025);
            spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("v3_backup_server_error_tip");
            if (TextUtils.isEmpty(spaceMultLanguage)) {
                return string;
            }
        } else {
            if (3941 != i10) {
                return C14339h.m85515n().contains(Integer.valueOf(i10)) ? getString(R$string.cloud_backup_failed_abnormal_server, Integer.valueOf(i10)) : C14339h.m85508g().contains(Integer.valueOf(i10)) ? getString(R$string.cloud_backup_failed_abnormal_client_new, getString(R$string.contact_customer_service)) : C14339h.m85516o().contains(Integer.valueOf(i10)) ? getString(R$string.cloud_backup_failed_network_anomaly, Integer.valueOf(i10)) : C14339h.m85513l().contains(Integer.valueOf(i10)) ? getString(R$string.toast_tip_in_delete_backup) : (i10 == 0 || i10 == 1001) ? "" : 3942 == i10 ? getString(R$string.cloud_backup_source_forbidden) : getString(R$string.backup_failed_tip_20181025);
            }
            String string2 = getString(R$string.backup_failed_tip_20181025);
            spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("backup_server_lock_conflict_tip");
            if (TextUtils.isEmpty(spaceMultLanguage)) {
                return string2;
            }
        }
        return spaceMultLanguage;
    }

    /* renamed from: S1 */
    public String m19763S1(CloudBackupState cloudBackupState, C13029h c13029h) {
        if (cloudBackupState == null) {
            C11839m.m70687e("CloudGuideBackupActivity", "getErrCodeDes cloudBackupState is null");
            return "";
        }
        int returnCode = cloudBackupState.getReturnCode();
        if (C14339h.m85517p().contains(Integer.valueOf(returnCode))) {
            return getString(R$string.backup_no_space_tip_2, C0209d.m1157C0(C0223k.m1524g(this, c13029h != null ? C0241z.m1689g(c13029h.m78482u(), c13029h.m78439E()) : 0L)));
        }
        if (C14339h.m85512k().contains(Integer.valueOf(returnCode))) {
            return cloudBackupState.isLocalSpaceNotEnoughChange() ? getString(R$string.backup_no_space_local_tip_3) : getString(R$string.backup_no_space_local_tip_2, C0223k.m1524g(this, c13029h != null ? c13029h.m78438D() : 0L));
        }
        return C14339h.m85514m().contains(Integer.valueOf(returnCode)) ? (c13029h == null || c13029h.m78442H() != 2) ? getString(R$string.backup_failed_network_tip) : getString(R$string.auto_backup_failed_network_tip) : returnCode == 1030 ? getString(R$string.backup_battery_temperature_high) : m19762R1(returnCode);
    }

    /* renamed from: T1 */
    public final int m19764T1() {
        return this.f14308x ? 2 : 3;
    }

    /* renamed from: W1 */
    public C13029h m19765W1() {
        C13029h c13029hM78495f;
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(2);
            if (c13029hM78495f != null) {
                return c13029hM78495f;
            }
            try {
                return c13030i.m78495f(1);
            } catch (C9721b unused) {
                C11839m.m70689w("CloudGuideBackupActivity", "");
                return c13029hM78495f;
            }
        } catch (C9721b unused2) {
            c13029hM78495f = null;
        }
    }

    /* renamed from: X1 */
    public final void m19766X1() {
        C13225d.m79490f1().m79585f0("action_code_view_from_backup_guide", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_view_from_backup_guide", "1", "63");
    }

    /* renamed from: Z1 */
    public final String m19767Z1(int i10, int i11, int i12, Integer num) {
        if (i10 <= 0) {
            i10 = 0;
        } else {
            int i13 = i10 / 60;
            int i14 = i13 / 24;
            if (i14 > 0 && num != null) {
                i11 = num.intValue();
                i10 = i14;
            } else if (i13 > 0) {
                i10 = i13;
            } else {
                i11 = i12;
            }
        }
        return getResources().getQuantityString(i11, i10, Integer.valueOf(i10));
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
        arrayList.add(this.f14305u);
        arrayList.add(this.f14306v);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.backup_now_title) {
            C13225d.m79490f1().m79585f0("action_code_backup_guide_backup_now", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_guide_backup_now", "1", "64");
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent(this, (Class<?>) BackupMainActivity.class));
            hiCloudSafeIntent.putExtra("from_guide_backup_activity", true);
            startActivity(hiCloudSafeIntent);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14303s);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f14310z = C0209d.m1195O(this);
        m19760Y1();
        m19766X1();
        m19759V1();
        CBCallBack.getInstance().registerCallback(this.f14299A);
        mo19005p1();
        m22365E1(R$string.cloud_backup_item_title);
        m19758U1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CBCallBack.getInstance().unregisterCallback(this.f14299A);
    }
}
