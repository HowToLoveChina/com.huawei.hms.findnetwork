package com.huawei.android.hicloud.p088ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
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
public class MemorandumDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public boolean f15502N0 = false;

    /* renamed from: O0 */
    public Handler.Callback f15503O0 = new C3397a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.MemorandumDetailActivity$a */
    public class C3397a implements Handler.Callback {
        public C3397a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            if (32309 == message.what) {
                MemorandumDetailActivity memorandumDetailActivity = MemorandumDetailActivity.this;
                memorandumDetailActivity.f16177C = false;
                memorandumDetailActivity.m22432d2();
                if (message.arg1 == 0) {
                    Intent intent = new Intent();
                    intent.setAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
                    intent.putExtra("moduleName", "notepad");
                    C13108a.m78878b(MemorandumDetailActivity.this).m78881d(intent);
                    CommonReportUtil.reportCloudStorageDeleteResult("notepad", "success");
                    MemorandumDetailActivity.this.finish();
                } else {
                    CommonReportUtil.reportCloudStorageDeleteResult("notepad", NotifyConstants.CommonReportConstants.FAILED);
                    C11839m.m70688i("MemorandumDetailActivity", "MSG_DELETE_NOTEPAD_RECORD_FAILED");
                }
            }
            return false;
        }
    }

    @SuppressLint({"StringFormatMatches"})
    /* renamed from: S2 */
    private void m21560S2() throws Resources.NotFoundException {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            this.f15502N0 = safeIntent.getBooleanExtra("has_sync_data", false);
            safeIntent.getIntExtra("recycle_notepad_num", 0);
        } catch (Exception e10) {
            C11839m.m70687e("MemorandumDetailActivity", "get intent param error:" + e10.toString());
        }
        int i10 = R$string.notepad_app_name;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        this.f16236t0.setText(R$string.cloudbackup_btn_delete_all);
        m21563V2();
        String strM83050B = C13843a.m83050B(this);
        C11839m.m70688i("MemorandumDetailActivity", "notepad package name: " + strM83050B);
        m22420G2(this, C0240y.m1681c(this, strM83050B));
        m21561T2();
        m21562U2();
        if (C0209d.m1184K0(this, strM83050B) && C0209d.m1215U1(this)) {
            if (this.f16207V != null) {
                if (this.f16203R.getVisibility() == 8 && this.f16199N.getVisibility() == 8 && this.f16208W.getVisibility() == 8) {
                    this.f16207V.setVisibility(8);
                } else {
                    this.f16207V.setVisibility(0);
                }
            }
            this.f16195L.setVisibility(0);
        } else {
            View view = this.f16207V;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (C0209d.m1293p1()) {
            this.f16212a0.setVisibility(8);
            this.f16230q0.setVisibility(8);
        } else {
            this.f16212a0.setVisibility(0);
            this.f16230q0.setVisibility(4);
        }
        int i11 = R$id.enter_hyperlink;
        int i12 = R$string.cloudbackup_back_item_notepad;
        m22418E2(i11, strM83050B, "", getString(i12), 4);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, getString(i12)).trim());
    }

    /* renamed from: T2 */
    public final void m21561T2() {
        if (TextUtils.isEmpty(this.f16247z)) {
            this.f16199N.setVisibility(8);
            this.f16202Q.setVisibility(8);
        } else {
            this.f16199N.setVisibility(0);
            this.f16202Q.setVisibility(0);
            this.f16200O.setText(R$string.disk_app_detail_title);
            this.f16201P.setText(this.f16247z);
        }
    }

    /* renamed from: U2 */
    public final void m21562U2() {
        this.f16203R.setVisibility(8);
        this.f16202Q.setVisibility(8);
    }

    /* renamed from: V2 */
    public final void m21563V2() {
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_memorandum_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_memorandum));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C10028c.m62182c0().m62388s("notepad");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: n2 */
    public void mo19224n2() throws JSONException {
        super.mo19224n2();
        C13227f.m79492i1().m79585f0("mecloud_notepad_mng_click_deleteall", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_notepad_mng_click_deleteall", "1", "10");
        CloudBackupService.getInstance().deleteRecord("notepad", this.f15502N0);
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
        C11839m.m70688i("MemorandumDetailActivity", "onCreate");
        super.onCreate(bundle);
        CloudBackupService.getInstance().register(this.f15503O0);
        m22433f2(true);
        m21560S2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CloudBackupService.getInstance().unregister(this.f15503O0);
    }
}
