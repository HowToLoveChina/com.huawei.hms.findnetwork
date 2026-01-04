package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p684un.C13225d;
import p684un.C13230i;

/* loaded from: classes3.dex */
public class BeforeBackupTransitionsActivity extends BaseActivity {
    /* renamed from: M1 */
    public final void m19214M1() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent(this, (Class<?>) NoticeBeforeBackupActivity.class));
        hiCloudSafeIntent.putExtras(new HiCloudSafeIntent(getIntent()).getExtras());
        startActivity(hiCloudSafeIntent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m19214M1();
        finish();
    }
}
