package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import java.lang.reflect.InvocationTargetException;
import p037bp.C1270a;
import p232dp.InterfaceC9287f;
import p514o9.C11839m;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class HisyncExternalActivityForSlave extends HisyncExternalActivity {
    /* renamed from: n4 */
    private boolean m20699n4() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            C11839m.m70687e("HisyncExternalActivityForSlave", "calling pkg name empty");
            return false;
        }
        if (!"com.huawei.android.findmyphone".equals(callingPackage) && !getPackageName().equals(callingPackage)) {
            C11839m.m70687e("HisyncExternalActivityForSlave", "calling pkg not from slave");
            return false;
        }
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f == null) {
            C11839m.m70688i("HisyncExternalActivityForSlave", "phoneFinderRouter is null, return");
            return false;
        }
        boolean zMo58566i = interfaceC9287f.mo58566i(this, callingPackage);
        C11839m.m70687e("HisyncExternalActivityForSlave", "is slave sign match:" + zMo58566i);
        return zMo58566i;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity, com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: I2 */
    public boolean mo20681I2() {
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity
    /* renamed from: k4 */
    public void mo20695k4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d("HisyncExternalActivityForSlave", "setOpenAnimation");
        new HwAnimationReflection(this).m15927c(1);
        this.f16376U0 = true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity, com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("HisyncExternalActivityForSlave", "onCreate");
        super.onCreate(bundle);
        if (m20699n4()) {
            return;
        }
        C11839m.m70688i("HisyncExternalActivityForSlave", "check permission false, finish");
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: r3 */
    public void mo20698r3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f16376U0) {
            C11839m.m70686d("HisyncExternalActivityForSlave", "setCloseAnimation");
            this.f16376U0 = false;
            new HwAnimationReflection(this).m15927c(2);
        }
    }
}
