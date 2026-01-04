package com.huawei.phoneservice.faq.utils;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import java.util.List;

/* loaded from: classes4.dex */
public interface IFaqManager {
    void faqErr();

    void getIsoLanguage(Activity activity, FaqCallback faqCallback);

    List<String> getWhiteList();

    void goToFaq(Activity activity);

    void goToFaqCateActivity(Activity activity);

    void gotoFaqDispatch(Activity activity, Class cls, Bundle bundle);

    void setWhiteList(List<String> list);
}
