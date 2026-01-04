package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import dj.C9159b;
import java.lang.reflect.InvocationTargetException;
import p514o9.C11839m;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class HisyncExternalActivityForFileManager extends HisyncExternalActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity
    /* renamed from: k4 */
    public void mo20695k4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d("HisyncExternalActivityForFileManager", "setOpenAnimation");
        new HwAnimationReflection(this).m15927c(1);
        this.f16376U0 = true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity, com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C9159b.m57574m(getIntent());
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity, com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        C9159b.m57574m(intent);
        super.onNewIntent(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: r3 */
    public void mo20698r3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f16376U0) {
            C11839m.m70686d("HisyncExternalActivityForFileManager", "setCloseAnimation");
            this.f16376U0 = false;
            new HwAnimationReflection(this).m15927c(2);
        }
    }
}
