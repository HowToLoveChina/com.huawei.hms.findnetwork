package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import com.huawei.android.hicloud.cloudspace.bean.SmsStorageQueryResult;
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
import p703v8.C13368e;
import p709vj.C13452e;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class CallLogDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public Handler f13871N0 = new HandlerC3168a();

    /* renamed from: O0 */
    public Messenger f13872O0 = new Messenger(this.f13871N0);

    /* renamed from: com.huawei.android.hicloud.ui.activity.CallLogDetailActivity$a */
    public class HandlerC3168a extends Handler {
        public HandlerC3168a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            int i10 = message.what;
            if (i10 == 1043) {
                C11839m.m70688i("CallLogDetailActivity", "MSG_DELETE_CALLLOG_RECORD_FINISH");
                CallLogDetailActivity.this.m22432d2();
                Intent intent = new Intent();
                intent.setAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
                intent.putExtra("moduleName", "calllog");
                C13108a.m78878b(CallLogDetailActivity.this).m78881d(intent);
                CallLogDetailActivity.this.f16177C = false;
                CommonReportUtil.reportCloudStorageDeleteResult("calllog", "success");
                CallLogDetailActivity.this.finish();
                return;
            }
            if (i10 == 1044) {
                C11839m.m70688i("CallLogDetailActivity", "MSG_DELETE_SMS_RECORD_FAILED");
                CallLogDetailActivity.this.m22432d2();
                CallLogDetailActivity.this.f16177C = false;
                CommonReportUtil.reportCloudStorageDeleteResult("calllog", NotifyConstants.CommonReportConstants.FAILED);
                return;
            }
            if (i10 == 1039) {
                C11839m.m70688i("CallLogDetailActivity", "MSG_QUERY_CALLLOG_COUNT_FINISH");
                SmsStorageQueryResult smsStorageQueryResult = (SmsStorageQueryResult) message.obj;
                CallLogDetailActivity.this.f16177C = false;
                if (message.arg1 == 0 && smsStorageQueryResult != null) {
                    C13368e.m80184F().m80207B(CallLogDetailActivity.this.f13872O0);
                } else {
                    C11839m.m70688i("CallLogDetailActivity", "MSG_DELETE_CALLLOG_RECORD_FAILED");
                    CallLogDetailActivity.this.m22432d2();
                }
            }
        }
    }

    /* renamed from: T2 */
    private void m19222T2() throws Resources.NotFoundException {
        m22365E1(R$string.cloudbackup_Calllog);
        mo19982C1();
        this.f16187H.setText(R$string.dial);
        this.f16236t0.setText(R$string.cloudbackup_btn_delete_all);
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_cloud_phone_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_cloud_phone));
        }
        String strM83094p = C13843a.m83094p(this);
        C11839m.m70688i("CallLogDetailActivity", "call log package name: " + strM83094p);
        m22420G2(this, C0240y.m1681c(this, strM83094p));
        Resources resources = getResources();
        int i10 = R$plurals.cloudbackup_some_records;
        int i11 = this.f16173A;
        String quantityString = resources.getQuantityString(i10, i11, Integer.valueOf(i11));
        this.f16200O.setText(R$string.recovery_appid_calllog);
        this.f16201P.setText(C2783d.m16095M(quantityString, Integer.valueOf(this.f16173A)));
    }

    /* renamed from: U2 */
    private void m19223U2() {
        this.f16199N.setVisibility(8);
        this.f16236t0.setVisibility(0);
        this.f16236t0.setOnClickListener(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: n2 */
    public void mo19224n2() throws JSONException {
        super.mo19224n2();
        C13227f.m79492i1().m79585f0("mecloud_calllog_mng_click_delete", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_calllog_mng_click_delete", "1", "25");
        C13368e.m80184F().m80207B(this.f13872O0);
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
        C11839m.m70688i("CallLogDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(false);
        m19223U2();
        m19222T2();
    }
}
