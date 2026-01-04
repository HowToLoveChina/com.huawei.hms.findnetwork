package com.huawei.phoneservice.faq.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.FaqDisabledActivity;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.Sdk;
import com.huawei.phoneservice.faq.dispatch.FaqDispatchActivity;
import com.huawei.phoneservice.faq.p174ui.C8406a;
import com.huawei.phoneservice.faq.p174ui.FaqCategoryActivity;
import com.huawei.phoneservice.faq.p174ui.FaqCategoryWebActivity;
import java.util.List;

/* loaded from: classes4.dex */
public final class SdkFaqManager implements IFaqManager {
    private List<String> whiteList;

    /* renamed from: com.huawei.phoneservice.faq.utils.SdkFaqManager$b */
    public static class C8410b {

        /* renamed from: a */
        public static final SdkFaqManager f39226a = new SdkFaqManager();
    }

    private SdkFaqManager() {
    }

    public /* synthetic */ SdkFaqManager(C8409a c8409a) {
        this();
    }

    public static IFaqManager getManager() {
        return C8410b.f39226a;
    }

    public static Sdk getSdk() {
        return FaqSdk.getSdk();
    }

    @Override // com.huawei.phoneservice.faq.utils.IFaqManager
    public void faqErr() {
    }

    @Override // com.huawei.phoneservice.faq.utils.IFaqManager
    public void getIsoLanguage(Activity activity, FaqCallback faqCallback) throws Throwable {
        C8406a.m52329e(activity, faqCallback);
    }

    @Override // com.huawei.phoneservice.faq.utils.IFaqManager
    public List<String> getWhiteList() {
        return this.whiteList;
    }

    @Override // com.huawei.phoneservice.faq.utils.IFaqManager
    public void goToFaq(Activity activity) {
        Intent intent;
        if (FaqSdk.getISdk().getSdkInitCode() != 0) {
            intent = new Intent(activity, (Class<?>) FaqDisabledActivity.class);
        } else if (ModuleConfigUtils.isHasFaq()) {
            String[] faqOpenTypeConfig = ModuleConfigUtils.getFaqOpenTypeConfig();
            intent = (faqOpenTypeConfig.length <= 1 || TextUtils.isEmpty(faqOpenTypeConfig[1])) ? new Intent(activity, (Class<?>) FaqCategoryActivity.class) : new Intent(activity, (Class<?>) FaqCategoryWebActivity.class);
        } else {
            intent = new Intent(activity, (Class<?>) FaqCategoryActivity.class);
        }
        activity.startActivity(intent);
    }

    @Override // com.huawei.phoneservice.faq.utils.IFaqManager
    public void goToFaqCateActivity(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) FaqDispatchActivity.class);
        intent.putExtra(FaqConstants.GO_TO_FAQ, true);
        activity.startActivity(intent);
    }

    @Override // com.huawei.phoneservice.faq.utils.IFaqManager
    public void gotoFaqDispatch(Activity activity, Class cls, Bundle bundle) {
        Intent intent = new Intent(activity, (Class<?>) FaqDispatchActivity.class);
        intent.putExtra(FaqConstants.GOTOFAQ, cls.getSimpleName());
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.huawei.phoneservice.faq.utils.IFaqManager
    public void setWhiteList(List<String> list) {
        this.whiteList = list;
    }
}
