package com.huawei.android.remotecontrol.p093ui;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.remotecontrol.p093ui.widget.SmartSuggestionPhoneFinderCallback;
import com.huawei.android.remotecontrol.p093ui.widget.SmartSuggestionPhoneFinderDialog;
import com.huawei.android.remotecontrol.sdk.R$anim;
import com.huawei.hms.push.constant.RemoteMessageConst;
import p020ap.C1007b;
import p521og.C11875h;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class SmartSuggestionPhoneFinderActivity extends UIActivity implements SmartSuggestionPhoneFinderCallback {

    /* renamed from: p */
    public SmartSuggestionPhoneFinderDialog f20524p;

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: D1 */
    public void mo20612D1() {
    }

    @Override // com.huawei.android.remotecontrol.p093ui.widget.SmartSuggestionPhoneFinderCallback
    public void onClickEnable() {
        C13981a.m83989i("SmartSuggestionPhoneFinderActivity", "onClickEnable");
        this.f20524p.dismiss();
        C1007b.m5980s().m6007a(this, SmartSuggestionPhoneFinderDialog.FEATURE_ID);
        Intent intent = new Intent(this, (Class<?>) PhoneFinderActivity.class);
        intent.putExtra(RemoteMessageConst.FROM, "from_smart_suggest");
        startActivity(intent);
        finish();
    }

    @Override // com.huawei.android.remotecontrol.p093ui.widget.SmartSuggestionPhoneFinderCallback
    public void onClickKnow() {
        C13981a.m83989i("SmartSuggestionPhoneFinderActivity", "onClickKnow");
        this.f20524p.dismiss();
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C13981a.m83989i("SmartSuggestionPhoneFinderActivity", "onCreate");
        if (!C11875h.m71190a(this)) {
            finish();
            return;
        }
        try {
            m22367G1(1);
            SmartSuggestionPhoneFinderDialog smartSuggestionPhoneFinderDialog = new SmartSuggestionPhoneFinderDialog(this, this);
            this.f20524p = smartSuggestionPhoneFinderDialog;
            smartSuggestionPhoneFinderDialog.setCanceledOnTouchOutside(false);
            this.f20524p.show();
        } catch (Exception e10) {
            C13981a.m83988e("SmartSuggestionPhoneFinderActivity", "get type error:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        overridePendingTransition(R$anim.activity_close, 0);
        SmartSuggestionPhoneFinderDialog smartSuggestionPhoneFinderDialog = this.f20524p;
        if (smartSuggestionPhoneFinderDialog != null && smartSuggestionPhoneFinderDialog.isShowing()) {
            this.f20524p.dismiss();
        }
        C1007b.m5980s().m6004X(this);
        super.onDestroy();
    }
}
