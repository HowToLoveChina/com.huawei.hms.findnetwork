package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import org.json.JSONException;
import p015ak.C0240y;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p684un.C13227f;
import p709vj.C13452e;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class HarassmentInterceptDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public Handler.Callback f14909N0 = new C3313a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.HarassmentInterceptDetailActivity$a */
    public class C3313a implements Handler.Callback {
        public C3313a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            if (32309 == message.what) {
                HarassmentInterceptDetailActivity harassmentInterceptDetailActivity = HarassmentInterceptDetailActivity.this;
                harassmentInterceptDetailActivity.f16177C = false;
                harassmentInterceptDetailActivity.m22432d2();
                if (message.arg1 == 0) {
                    Intent intent = new Intent();
                    intent.setAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
                    intent.putExtra("moduleName", "phonemanager");
                    C13108a.m78878b(HarassmentInterceptDetailActivity.this).m78881d(intent);
                    CommonReportUtil.reportCloudStorageDeleteResult("phonemanager", "success");
                    HarassmentInterceptDetailActivity.this.finish();
                } else {
                    CommonReportUtil.reportCloudStorageDeleteResult("phonemanager", NotifyConstants.CommonReportConstants.FAILED);
                    C11839m.m70688i("HarassmentInterceptDetailActivity", "MSG_DELETE_SMS_RECORD_FAILED");
                }
            }
            return false;
        }
    }

    /* renamed from: S2 */
    private void m20609S2() throws Resources.NotFoundException {
        int i10 = R$string.cloudbackup_back_item_phonemanager;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        this.f16236t0.setText(R$string.cloudbackup_btn_delete_all);
        this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.icon_section_ba_detail));
        m22420G2(this, C0240y.m1681c(this, C13843a.m83064P()));
        this.f16200O.setText(R$string.disk_app_detail_title);
        this.f16201P.setText(this.f16247z);
    }

    /* renamed from: T2 */
    private void m20610T2() {
        this.f16199N.setVisibility(0);
        this.f16236t0.setVisibility(0);
        this.f16236t0.setOnClickListener(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: n2 */
    public void mo19224n2() throws JSONException {
        super.mo19224n2();
        C13227f.m79492i1().m79585f0("mecloud_phonemanager_mng_click_delete", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_phonemanager_mng_click_delete", "1", "6");
        CloudBackupService.getInstance().deleteRecord("phonemanager", false);
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
        C11839m.m70688i("HarassmentInterceptDetailActivity", "onCreate");
        super.onCreate(bundle);
        CloudBackupService.getInstance().register(this.f14909N0);
        m22433f2(false);
        m20610T2();
        m20609S2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CloudBackupService.getInstance().unregister(this.f14909N0);
    }
}
