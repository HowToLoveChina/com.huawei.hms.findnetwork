package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import gp.C10028c;
import java.util.HashMap;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes3.dex */
public class HMSTermsProcessBaseActivity extends UIActivity {
    /* renamed from: L1 */
    private void m20608L1(int i10, Intent intent) {
        ErrorStatus errorStatus;
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07009"), "termProcessHMSResult", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("hms_agreement_result_code", String.valueOf(i10));
        map.put("hms_current_activity", getClass().getName());
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (i10 == 0) {
            C11839m.m70687e("HMSTermsProcessBaseActivity", "agreement update result cancel");
            if (intent != null) {
                try {
                    errorStatus = (ErrorStatus) intent.getParcelableExtra("parce");
                } catch (Exception e10) {
                    C11839m.m70687e("HMSTermsProcessBaseActivity", "class ErrorStatus pkg path hms apk sdk not match  " + e10.getMessage());
                    errorStatus = null;
                }
                if (errorStatus != null) {
                    int errorCode = errorStatus.getErrorCode();
                    C11839m.m70687e("HMSTermsProcessBaseActivity", "error code = " + errorCode + ", error reason = " + errorStatus.getErrorReason());
                    map.put("hms_agreement_result_error_code", String.valueOf(errorCode));
                    if (errorCode == 10002) {
                        c10028cM62183d0.m62377p3("hms_agr_force_query", false);
                    }
                }
            }
        } else {
            C11839m.m70688i("HMSTermsProcessBaseActivity", "agreement update success");
            c10028cM62183d0.m62377p3("hms_agr_force_query", false);
            c10028cM62183d0.m62377p3("is_hicloud_terms_confirm", true);
            C11829c.m70604p();
        }
        C13622a.m81969o(this, c11060cM66626a, map);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        super.onActivityResult(i10, i11, hiCloudSafeIntent);
        if (i10 == 10028) {
            m20608L1(i11, hiCloudSafeIntent);
        }
    }
}
