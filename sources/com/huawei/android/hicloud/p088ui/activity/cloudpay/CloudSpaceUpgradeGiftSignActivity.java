package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import com.huawei.android.p073ds.R$id;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.iap.Iap;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import p015ak.C0224k0;
import p054cj.C1442a;
import p664u0.C13108a;

/* loaded from: classes3.dex */
public class CloudSpaceUpgradeGiftSignActivity extends CloudSpaceUpgradeActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        C1442a.m8290i("CloudSpaceUpgradeGiftSignActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 10002) {
            m22759E4();
            C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
            C0224k0.m1542L(this, new Intent(this, (Class<?>) CloudSpaceUpgradeActivity.class));
            finish();
            return;
        }
        if (i10 == 10001 || i10 == 10007) {
            if (new HiCloudSafeIntent(intent).getIntExtra("returnCode", -1) != 30000) {
                super.onActivityResult(i10, i11, intent);
                return;
            } else {
                C1442a.m8290i("CloudSpaceUpgradeGiftSignActivity", "onActivityResult iap 2.0 cancel ");
                finish();
                return;
            }
        }
        if (i10 != 10013) {
            super.onActivityResult(i10, i11, intent);
            return;
        }
        if (Iap.getIapClient((Activity) this).parsePurchaseResultInfoFromIntent(new HiCloudSafeIntent(intent)).getReturnCode() != 60000) {
            super.onActivityResult(i10, i11, intent);
        } else {
            C1442a.m8290i("CloudSpaceUpgradeGiftSignActivity", "onActivityResult iap 4.0 cancel ");
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (view.getId() == R$id.back) {
            onBackPressed();
        } else {
            super.onClick(view);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: r1 */
    public boolean mo19553r1(int i10, KeyEvent keyEvent) {
        onBackPressed();
        return true;
    }
}
