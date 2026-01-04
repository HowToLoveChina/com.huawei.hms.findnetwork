package com.huawei.phoneservice.faq.dispatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.SdkListenerPoxy;
import com.huawei.phoneservice.faq.p174ui.C8406a;
import com.huawei.phoneservice.faq.p174ui.FaqQuestionDetailActivity;
import com.huawei.phoneservice.faq.p174ui.FaqThirdListActivity;
import com.huawei.phoneservice.faq.response.C8343c;

/* renamed from: com.huawei.phoneservice.faq.dispatch.a */
/* loaded from: classes4.dex */
public class C8331a implements InterfaceC8334d {

    /* renamed from: com.huawei.phoneservice.faq.dispatch.a$a */
    public class a extends FaqCallback<C8343c> {

        /* renamed from: d */
        public final /* synthetic */ Activity f38740d;

        /* renamed from: e */
        public final /* synthetic */ String f38741e;

        /* renamed from: f */
        public final /* synthetic */ String f38742f;

        /* renamed from: g */
        public final /* synthetic */ String f38743g;

        /* renamed from: h */
        public final /* synthetic */ String f38744h;

        /* renamed from: i */
        public final /* synthetic */ String f38745i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Activity activity, Activity activity2, String str, String str2, String str3, String str4, String str5) {
            super(cls, activity);
            this.f38740d = activity2;
            this.f38741e = str;
            this.f38742f = str2;
            this.f38743g = str3;
            this.f38744h = str4;
            this.f38745i = str5;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8343c c8343c) {
            if (this.f38740d.isFinishing() || this.f38740d.isDestroyed()) {
                return;
            }
            C8331a.this.m51912f((th2 != null || c8343c == null) ? FaqConstants.DEFAULT_ISO_LANGUAGE : c8343c.m51998a(), this.f38741e, this.f38740d, this.f38742f, this.f38743g, this.f38744h, this.f38745i);
        }
    }

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: a */
    public boolean mo51908a(Activity activity, Intent intent) throws Throwable {
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(FaqConstants.GOTOFAQ);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        m51913g(activity, stringExtra, extras);
        return true;
    }

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: b */
    public boolean mo51909b() {
        return false;
    }

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: c */
    public boolean mo51910c(Intent intent) {
        return true;
    }

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: d */
    public void mo51911d(SdkListenerPoxy sdkListenerPoxy) {
    }

    /* renamed from: f */
    public final void m51912f(String str, String str2, Activity activity, String str3, String str4, String str5, String str6) {
        if (FaqThirdListActivity.class.getSimpleName().equals(str2)) {
            FaqThirdListActivity.m52270E0(activity, str, FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE), str3, FaqSdk.getSdk().getSdk("countryCode"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LANGUAGE), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL), str4, FaqSdk.getSdk().getSdk("country"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LEVEL), FaqSdk.getSdk().getSdk("accessToken"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_REFRESH), FaqSdk.getSdk().getSdk("appVersion"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CALLFUNCTION), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_WECHATID), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_WEIBOID), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_PICID));
        } else if (FaqQuestionDetailActivity.class.getSimpleName().equals(str2)) {
            FaqQuestionDetailActivity.m52169z0(activity, str, FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE), str3, str5, FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL), str6, FaqSdk.getSdk().getSdk("country"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LEVEL), FaqSdk.getSdk().getSdk("accessToken"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_REFRESH), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL), FaqSdk.getSdk().getSdk("appVersion"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION), FaqSdk.getSdk().getSdk("countryCode"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CALLFUNCTION), true, FaqSdk.getSdk().getSdk(FaqConstants.FAQ_WECHATID), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_WEIBOID), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_PICID), null);
        }
        activity.finish();
    }

    /* renamed from: g */
    public final void m51913g(Activity activity, String str, Bundle bundle) throws Throwable {
        C8406a.m52325a(activity, new a(C8343c.class, null, activity, str, bundle.getString("title"), bundle.getString("productCategoryCode"), bundle.getString("url"), bundle.getString("knowledgeId")));
    }
}
