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
import com.huawei.fastengine.fastview.NavigationUtils;
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
public class MessageDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public Handler f15523N0 = new HandlerC3401a();

    /* renamed from: O0 */
    public Messenger f15524O0 = new Messenger(this.f15523N0);

    /* renamed from: com.huawei.android.hicloud.ui.activity.MessageDetailActivity$a */
    public class HandlerC3401a extends Handler {
        public HandlerC3401a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            int i10 = message.what;
            if (i10 == 1040) {
                C11839m.m70688i("MessageDetailActivity", "MSG_DELETE_SMS_RECORD_FINISH");
                MessageDetailActivity.this.m22432d2();
                Intent intent = new Intent();
                intent.setAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
                intent.putExtra("moduleName", NavigationUtils.SMS_SCHEMA_PREF);
                C13108a.m78878b(MessageDetailActivity.this).m78881d(intent);
                MessageDetailActivity.this.f16177C = false;
                CommonReportUtil.reportCloudStorageDeleteResult(NavigationUtils.SMS_SCHEMA_PREF, "success");
                MessageDetailActivity.this.finish();
                return;
            }
            if (i10 == 1041) {
                C11839m.m70688i("MessageDetailActivity", "MSG_DELETE_SMS_RECORD_PROCESSING");
                return;
            }
            if (i10 == 1042) {
                C11839m.m70688i("MessageDetailActivity", "MSG_DELETE_SMS_RECORD_FAILED");
                MessageDetailActivity.this.m22432d2();
                MessageDetailActivity.this.f16177C = false;
                CommonReportUtil.reportCloudStorageDeleteResult(NavigationUtils.SMS_SCHEMA_PREF, NotifyConstants.CommonReportConstants.FAILED);
                return;
            }
            if (i10 == 1038) {
                C11839m.m70688i("MessageDetailActivity", "MSG_QUERY_SMS_COUNT_FINISH");
                SmsStorageQueryResult smsStorageQueryResult = (SmsStorageQueryResult) message.obj;
                MessageDetailActivity.this.f16177C = false;
                if (message.arg1 == 0 && smsStorageQueryResult != null) {
                    C13368e.m80184F().m80209C(MessageDetailActivity.this.f15524O0);
                } else {
                    C11839m.m70688i("MessageDetailActivity", "MSG_DELETE_SMS_RECORD_FAILED");
                    MessageDetailActivity.this.m22432d2();
                }
            }
        }
    }

    /* renamed from: T2 */
    private void m21576T2() throws Resources.NotFoundException {
        int i10 = R$string.cloudbackup_back_item_sms;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        this.f16236t0.setText(R$string.cloudbackup_btn_delete_all);
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_cloud_message_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_cloud_message));
        }
        String strM83049A = C13843a.m83049A();
        String strM1681c = C0240y.m1681c(this, strM83049A);
        C11839m.m70688i("MessageDetailActivity", "message package name: " + strM83049A);
        m22420G2(this, strM1681c);
        Resources resources = getResources();
        int i11 = R$plurals.cloudbackup_some_records;
        int i12 = this.f16173A;
        String quantityString = resources.getQuantityString(i11, i12, Integer.valueOf(i12));
        this.f16200O.setText(R$string.recovery_appid_sms);
        this.f16201P.setText(C2783d.m16095M(quantityString, Integer.valueOf(this.f16173A)));
    }

    /* renamed from: U2 */
    private void m21577U2() {
        this.f16199N.setVisibility(8);
        this.f16236t0.setVisibility(0);
        this.f16236t0.setOnClickListener(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: n2 */
    public void mo19224n2() throws JSONException {
        super.mo19224n2();
        C13227f.m79492i1().m79585f0("mecloud_message_mng_click_delete", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_message_mng_click_delete", "1", "12");
        C13368e.m80184F().m80209C(this.f15524O0);
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
        C11839m.m70688i("MessageDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(false);
        m21577U2();
        m21576T2();
    }
}
