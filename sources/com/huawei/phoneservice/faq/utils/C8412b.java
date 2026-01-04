package com.huawei.phoneservice.faq.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.p174ui.C8406a;
import com.huawei.phoneservice.faq.p174ui.FaqCategoryActivity;
import com.huawei.phoneservice.faq.p174ui.FaqCategoryWebActivity;
import com.huawei.phoneservice.faq.response.FaqFastServicesResponse;
import com.huawei.phoneservice.faq.response.FaqIpccBean;
import com.huawei.phoneservice.faq.widget.BadgeHelper;

/* renamed from: com.huawei.phoneservice.faq.utils.b */
/* loaded from: classes4.dex */
public class C8412b {
    /* renamed from: a */
    public static void m52367a(Activity activity) throws Throwable {
        FaqFastServicesResponse.ModuleListBean moduleListBean = new FaqFastServicesResponse.ModuleListBean();
        moduleListBean.m51928d(21);
        moduleListBean.m51929e(FaqConstants.OPEN_TYPE_IN);
        FaqIpccBean faqIpccBean = new FaqIpccBean();
        faqIpccBean.m51945c(SdkFaqManager.getSdk().getSdk("accessToken"));
        faqIpccBean.m51957p(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ISOLANGUAGE));
        faqIpccBean.m51949g(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        faqIpccBean.m51951i(SdkFaqManager.getSdk().getSdk("country"));
        faqIpccBean.m51955n(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LEVEL));
        faqIpccBean.m51947e(SdkFaqManager.getSdk().getSdk("appVersion"));
        faqIpccBean.m51939L(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_SHASN));
        faqIpccBean.m51937I(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION));
        faqIpccBean.m51961t(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_MODEL));
        faqIpccBean.m51956o(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION));
        faqIpccBean.m51962v(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_OSVERSION));
        faqIpccBean.m51953l(SdkFaqManager.getSdk().getSdk("countryCode"));
        faqIpccBean.m51941N(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE));
        faqIpccBean.m51942O(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WECHATID));
        faqIpccBean.m51943P(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WEIBOID));
        faqIpccBean.m51936A(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_PICID));
        faqIpccBean.m51958q(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID));
        faqIpccBean.m51960s(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY));
        faqIpccBean.m51959r(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH));
        C8406a.m52330f(activity, moduleListBean, faqIpccBean, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CALLFUNCTION));
        FaqTrack.event(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL) + "+SDK", "Click on Contact us", "contact us");
    }

    /* renamed from: b */
    public static void m52368b(Activity activity, BadgeHelper badgeHelper) {
        C8416f.m52391c(activity, badgeHelper, ModuleConfigUtils.getFeedbackOpenTypeConfig()[0], true);
    }

    /* renamed from: c */
    public static void m52369c(Activity activity, boolean z10, String str) {
        Intent intent;
        if (ModuleConfigUtils.isHasFaq()) {
            String[] faqOpenTypeConfig = ModuleConfigUtils.getFaqOpenTypeConfig();
            intent = (faqOpenTypeConfig.length <= 1 || TextUtils.isEmpty(faqOpenTypeConfig[1])) ? new Intent(activity, (Class<?>) FaqCategoryActivity.class) : new Intent(activity, (Class<?>) FaqCategoryWebActivity.class);
        } else {
            intent = new Intent(activity, (Class<?>) FaqCategoryActivity.class);
        }
        intent.putExtra("isResult", z10);
        intent.putExtra("err", str);
        activity.startActivity(intent);
        activity.finish();
    }

    /* renamed from: d */
    public static boolean m52370d(String str) {
        if (C8416f.m52392d()) {
            if ("6".equals(str)) {
                if (ModuleConfigUtils.productSuggestEnabled()) {
                    return true;
                }
            } else if ("7".equals(str) && ModuleConfigUtils.productUploadLogEnabled()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static void m52371e(Activity activity, BadgeHelper badgeHelper) {
        C8416f.m52391c(activity, badgeHelper, ModuleConfigUtils.getFeedbackOpenTypeConfig()[0], false);
    }
}
