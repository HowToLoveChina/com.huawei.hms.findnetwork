package com.huawei.phoneservice.faq.p174ui;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.phoneservice.faq.FaqCommonWebActivity;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;

/* loaded from: classes4.dex */
public class IpccDetailActivity extends FaqCommonWebActivity {
    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: V */
    public void mo51668V() throws Throwable {
        Bundle extras;
        setTitle(R$string.faq_sdk_common_loading);
        super.mo51668V();
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            this.f38508B = extras.getString("ipcc_url_extra");
        } catch (ClassCastException e10) {
            FaqLogger.m51840e("IpccDetailActivity", e10.getMessage());
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: z0 */
    public boolean mo51675z0(String str) throws Throwable {
        if (FaqWebActivityUtil.isInWhiteList(str, this)) {
            return false;
        }
        FaqWebActivityUtil.goToBrowserWebUrl(this, str, false);
        return true;
    }
}
