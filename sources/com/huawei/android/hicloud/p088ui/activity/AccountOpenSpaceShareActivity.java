package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import java.lang.reflect.InvocationTargetException;
import p514o9.C11829c;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class AccountOpenSpaceShareActivity extends HisyncExternalActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity
    /* renamed from: e4 */
    public void mo18552e4() {
        if (!C11829c.m70626w0()) {
            C11839m.m70688i("AccountOpenSpaceShareActivity", "spaceshare enable false");
            m20691g4(5, FamilyShareConstants.OpenCloudShareResultInfo.DESC_MODULE_NOT_SUPPORT);
            return;
        }
        C11839m.m70688i("AccountOpenSpaceShareActivity", "spaceshare enable true");
        int i10 = this.f16340C0;
        if (i10 == 2) {
            C2783d.m16169p0(this, this.f16434z, i10);
        } else {
            C2783d.m16166o0(this, this.f16434z, i10);
        }
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity, com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f16370R0 = true;
    }
}
