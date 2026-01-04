package com.huawei.android.hicloud.commonlib.hms.p080ui;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.p107bi.HiAnalyticsBaselActivity;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import p514o9.C11839m;
import p681uj.C13192i;
import sk.C12808e;

/* loaded from: classes3.dex */
public class HmsUpdateActivity extends HiAnalyticsBaselActivity {

    /* renamed from: b */
    public int f12035b;

    /* renamed from: c */
    public final void m15901c() {
        if (this.f12035b == 0) {
            finish();
        } else {
            setResult(1);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70686d("HmsUpdateActivity", "onActivityResult  requestCode=" + i10 + ",resultCode=" + i11);
        if (i11 != -1) {
            C11839m.m70688i("HmsUpdateActivity", "resolve error");
            m15901c();
        } else {
            if (intent == null) {
                m15901c();
                return;
            }
            int intExtra = new SafeIntent(intent).getIntExtra(BridgeActivity.EXTRA_RESULT, 8);
            C11839m.m70688i("HmsUpdateActivity", "hms update result = " + intExtra);
            if (intExtra == 0) {
                setResult(-1);
                finish();
            } else {
                m15901c();
            }
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.huawei.hicloud.report.p107bi.HiAnalyticsBaselActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        Intent intent = getIntent();
        if (intent == null) {
            C11839m.m70687e("HmsUpdateActivity", "intent is null.");
            finish();
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        int intExtra = hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, -1);
        int intExtra2 = hiCloudSafeIntent.getIntExtra("enterType", -1);
        this.f12035b = intExtra2;
        if (intExtra2 == -1) {
            m15901c();
        }
        HuaweiApiAvailability huaweiApiAvailability = HuaweiApiAvailability.getInstance();
        if (!huaweiApiAvailability.isUserResolvableError(intExtra)) {
            m15901c();
            return;
        }
        C11839m.m70688i("HmsUpdateActivity", "begin resolveError mEnterType =" + this.f12035b + ",errorCode = " + intExtra);
        huaweiApiAvailability.resolveError(this, intExtra, 1000);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f12035b == 0) {
            C13192i.m79258g().m79266l(false);
        }
    }
}
