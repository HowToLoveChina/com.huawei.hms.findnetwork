package com.huawei.phoneservice.faq.p174ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;
import com.huawei.phoneservice.faq.response.C8343c;
import com.huawei.phoneservice.faq.response.FaqFastServicesResponse;
import com.huawei.phoneservice.faq.response.FaqIpccBean;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;

/* renamed from: com.huawei.phoneservice.faq.ui.a */
/* loaded from: classes4.dex */
public class C8406a {

    /* renamed from: com.huawei.phoneservice.faq.ui.a$a */
    public class a extends FaqCallback<C8343c> {

        /* renamed from: d */
        public final /* synthetic */ String f39192d;

        /* renamed from: e */
        public final /* synthetic */ FaqCallback f39193e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Activity activity, String str, FaqCallback faqCallback) {
            super(cls, activity);
            this.f39192d = str;
            this.f39193e = faqCallback;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8343c c8343c) {
            if (th2 == null && c8343c != null) {
                String strM51998a = c8343c.m51998a();
                if (!TextUtils.isEmpty(strM51998a)) {
                    FaqTrack.setCountryAndLanguage(this.f39192d, strM51998a);
                }
            }
            FaqCallback faqCallback = this.f39193e;
            if (faqCallback != null) {
                faqCallback.onResult(th2, c8343c);
            }
        }
    }

    /* renamed from: a */
    public static void m52325a(Activity activity, FaqCallback faqCallback) throws Throwable {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE);
        String sdk2 = FaqSdk.getSdk().getSdk("country");
        if (!TextUtils.isEmpty(sdk) && !TextUtils.isEmpty(sdk2)) {
            m52327c(activity, sdk, sdk2, faqCallback);
        } else {
            FaqLogger.m51840e("ActivityUtils", "FaqDispatchPresenter dispatch getISOLanguage, intent is null");
            activity.finish();
        }
    }

    /* renamed from: b */
    public static void m52326b(Activity activity, String str) throws Throwable {
        StringBuilder sb2;
        String str2;
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || TextUtils.isEmpty(str) || !str.contains("://")) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            intent.setPackage(activity.getPackageName());
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "goCallBackActivity failed because of ActivityNotFoundException ";
            sb2.append(str2);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("ActivityUtils", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "goCallBackActivity failed because of ";
            sb2.append(str2);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("ActivityUtils", sb2.toString());
        }
    }

    /* renamed from: c */
    public static void m52327c(Activity activity, String str, String str2, FaqCallback faqCallback) throws Throwable {
        String string;
        StringBuilder sb2;
        String str3;
        if (str.contains("-")) {
            sb2 = new StringBuilder();
            str3 = str.split("-")[0];
        } else {
            if (!str.contains("_")) {
                string = null;
                SdkFaqCommonManager.INSTANCE.getLanguageCode(activity, string, new a(C8343c.class, null, str2, faqCallback));
                FaqLogger.m51836d("ActivityUtils", "FaqDispatchPresenter dispatch goToFaqActivity, get ios code");
            }
            sb2 = new StringBuilder();
            str3 = str.split("_")[0];
        }
        sb2.append(str3);
        sb2.append('-');
        sb2.append(str2);
        string = sb2.toString();
        SdkFaqCommonManager.INSTANCE.getLanguageCode(activity, string, new a(C8343c.class, null, str2, faqCallback));
        FaqLogger.m51836d("ActivityUtils", "FaqDispatchPresenter dispatch goToFaqActivity, get ios code");
    }

    /* renamed from: d */
    public static void m52328d(Context context, FaqFastServicesResponse.ModuleListBean moduleListBean, FaqIpccBean faqIpccBean, String str) {
        Intent intent = new Intent(context, (Class<?>) FaqOnlineActivity.class);
        if (moduleListBean != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(FaqConstants.ON_IPCC_PARMS, faqIpccBean);
            bundle.putString(FaqConstants.FAQ_CALLFUNCTION, str);
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    /* renamed from: e */
    public static void m52329e(Activity activity, FaqCallback faqCallback) throws Throwable {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        m52327c(activity, FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE), FaqSdk.getSdk().getSdk("country"), faqCallback);
    }

    /* renamed from: f */
    public static void m52330f(Context context, FaqFastServicesResponse.ModuleListBean moduleListBean, FaqIpccBean faqIpccBean, String str) {
        if (moduleListBean.m51927c() == 21) {
            if (FaqConstants.OPEN_TYPE_IN.equals(moduleListBean.m51931g())) {
                faqIpccBean.m51938K(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_SHASN));
                m52328d(context, moduleListBean, faqIpccBean, str);
            } else {
                String strM51930f = moduleListBean.m51930f();
                if (FaqWebActivityUtil.isUrl(strM51930f)) {
                    FaqWebActivityUtil.startSystemWeb(context, strM51930f);
                }
            }
        }
    }
}
