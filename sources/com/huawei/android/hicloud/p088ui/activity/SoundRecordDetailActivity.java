package com.huawei.android.hicloud.p088ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0240y;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p684un.C13227f;
import p709vj.C13452e;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class SoundRecordDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public Handler.Callback f16038N0 = new C3479a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.SoundRecordDetailActivity$a */
    public class C3479a implements Handler.Callback {
        public C3479a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            if (32309 == message.what) {
                SoundRecordDetailActivity soundRecordDetailActivity = SoundRecordDetailActivity.this;
                soundRecordDetailActivity.f16177C = false;
                soundRecordDetailActivity.m22432d2();
                if (message.arg1 == 0) {
                    Intent intent = new Intent();
                    intent.setAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
                    intent.putExtra("moduleName", "record");
                    C13108a.m78878b(SoundRecordDetailActivity.this).m78881d(intent);
                    CommonReportUtil.reportCloudStorageDeleteResult("record", "success");
                    SoundRecordDetailActivity.this.finish();
                } else {
                    CommonReportUtil.reportCloudStorageDeleteResult("record", NotifyConstants.CommonReportConstants.FAILED);
                    C11839m.m70688i("SoundRecordDetailActivity", "MSG_DELETE_RECORDING_RECORD_FAILED");
                }
            }
            return false;
        }
    }

    @SuppressLint({"StringFormatMatches"})
    /* renamed from: S2 */
    private void m22193S2() throws Resources.NotFoundException {
        int i10 = R$string.recorder_app_name;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        this.f16236t0.setText(R$string.cloudbackup_btn_delete_all);
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.icon_record_detail_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.icon_record_detail));
        }
        String strM83058J = C13843a.m83058J(this);
        C11839m.m70688i("SoundRecordDetailActivity", "sound recorder package name: " + strM83058J);
        m22420G2(this, C0240y.m1681c(this, strM83058J));
        Resources resources = getResources();
        int i11 = R$plurals.backup_detail_gallery_num1;
        int i12 = this.f16173A;
        String quantityString = resources.getQuantityString(i11, i12, Integer.valueOf(i12));
        this.f16200O.setText(R$string.disk_app_detail_title);
        this.f16201P.setText(this.f16247z);
        this.f16204S.setText(R$string.recording_file);
        this.f16205T.setText(C2783d.m16095M(quantityString, Integer.valueOf(this.f16173A)));
    }

    /* renamed from: T2 */
    private void m22194T2() {
        this.f16199N.setVisibility(0);
        this.f16203R.setVisibility(8);
        this.f16202Q.setVisibility(0);
        this.f16236t0.setVisibility(0);
        this.f16236t0.setOnClickListener(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: n2 */
    public void mo19224n2() throws JSONException {
        super.mo19224n2();
        C13227f.m79492i1().m79585f0("mecloud_recording_mng_click_delete", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_recording_mng_click_delete", "1", "26");
        CloudBackupService.getInstance().deleteRecord("record", false);
        m22423J2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f16236t0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C11839m.m70688i("SoundRecordDetailActivity", "onCreate");
        super.onCreate(bundle);
        CloudBackupService.getInstance().register(this.f16038N0);
        m22433f2(false);
        m22194T2();
        m22193S2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CloudBackupService.getInstance().unregister(this.f16038N0);
    }
}
