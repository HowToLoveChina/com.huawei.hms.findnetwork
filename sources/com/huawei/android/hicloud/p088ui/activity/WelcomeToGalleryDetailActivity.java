package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.android.hicloud.complexutil.C2783d;
import java.lang.reflect.InvocationTargetException;
import mc.C11436a;
import p015ak.C0209d;
import p514o9.C11839m;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class WelcomeToGalleryDetailActivity extends WelcomeBaseActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: W1 */
    public boolean mo22626W1() {
        C11839m.m70688i("WelcomeToGalleryDetailActivity", "hasQueryV3ConfigTime");
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: X1 */
    public boolean mo22628X1() {
        C11839m.m70688i("WelcomeToGalleryDetailActivity", "hasSetConfigTag");
        return C2783d.m16097N();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 == 1) {
            setResult(-1);
            finish();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70686d("WelcomeToGalleryDetailActivity", "onCreate");
        if (C13452e.m80781L().m80912f1()) {
            C11839m.m70687e("WelcomeToGalleryDetailActivity", "site not match");
            C11436a.m68492d().m68499h(this);
            finish();
            return;
        }
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i("WelcomeToGalleryDetailActivity", "isPrivacyUser, now exit Cloud!");
            finish();
            return;
        }
        if (!C13612b.m81829B().m81853R()) {
            C11839m.m70687e("WelcomeToGalleryDetailActivity", "not login");
            finish();
        } else if (!m22667s2()) {
            C11839m.m70687e("WelcomeToGalleryDetailActivity", "not allow to jump to next");
            finish();
        } else {
            Intent intent = new Intent(this, (Class<?>) GalleryDetailActivity.class);
            intent.putExtras(new Bundle());
            C13230i.m79525e1(intent, "1", "3");
            startActivityForResult(intent, 1);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
