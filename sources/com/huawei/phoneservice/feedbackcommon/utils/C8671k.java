package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.entity.C8614b0;
import com.huawei.phoneservice.feedbackcommon.entity.C8622h;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackZipBean;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.k */
/* loaded from: classes5.dex */
public class C8671k extends AbstractC8662d {

    /* renamed from: h */
    public List<String> f40390h;

    /* renamed from: i */
    public WeakReference<SubmitListener> f40391i;

    /* renamed from: j */
    public FeedbackInfo f40392j;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.k$a */
    public class a extends FaqCallback<C8622h> {

        /* renamed from: d */
        public final /* synthetic */ C8614b0 f40393d;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.k$a$a, reason: collision with other inner class name */
        public class C14496a extends BaseSdkUpdateRequest<C8614b0> {
            public C14496a(C8614b0 c8614b0) {
                super(c8614b0);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onCallback(String str, String str2, String str3, C8614b0 c8614b0) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    WeakReference<BaseSdkUpdateRequest> weakReference = C8671k.this.f40344c;
                    if (weakReference != null) {
                        weakReference.clear();
                        C8671k.this.f40344c = null;
                    }
                    c8614b0.m53197b(str3);
                    C8671k.this.m53482o(c8614b0);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Activity activity, C8614b0 c8614b0) {
            super(cls, activity);
            this.f40393d = c8614b0;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8622h c8622h) {
            if (th2 == null && c8622h != null) {
                C8671k.this.m53473b(6, -1, c8622h.f40134a);
                return;
            }
            boolean z10 = th2 instanceof FaqWebServiceException;
            if (!z10 || ((FaqWebServiceException) th2).errorCode != 401 || !FaqSdk.getISdk().haveSdkErr("accessToken")) {
                if ((th2 instanceof SocketTimeoutException) || (th2 instanceof ConnectException)) {
                    C8671k.this.m53473b(7, 1, null);
                    return;
                } else {
                    if (z10) {
                        C8671k.this.m53475d((FaqWebServiceException) th2);
                        return;
                    }
                    return;
                }
            }
            C14496a c14496a = new C14496a(this.f40393d);
            WeakReference<BaseSdkUpdateRequest> weakReference = C8671k.this.f40344c;
            if (weakReference != null) {
                weakReference.clear();
            }
            C8671k.this.f40344c = new WeakReference<>(c14496a);
            FaqSdk.getISdk().registerUpdateListener(c14496a);
            FaqSdk.getISdk().onSdkErr("accessToken", FaqSdk.getSdk().getSdk("accessToken"));
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.k$b */
    public class b extends FaqCallback<C8622h> {

        /* renamed from: d */
        public final /* synthetic */ C8614b0 f40396d;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.k$b$a */
        public class a extends BaseSdkUpdateRequest<C8614b0> {
            public a(C8614b0 c8614b0) {
                super(c8614b0);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onCallback(String str, String str2, String str3, C8614b0 c8614b0) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    WeakReference<BaseSdkUpdateRequest> weakReference = C8671k.this.f40344c;
                    if (weakReference != null) {
                        weakReference.clear();
                        C8671k.this.f40344c = null;
                    }
                    c8614b0.m53197b(str3);
                    C8671k.this.m53476e(c8614b0);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Activity activity, C8614b0 c8614b0) {
            super(cls, activity);
            this.f40396d = c8614b0;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8622h c8622h) {
            if (th2 == null && c8622h != null) {
                ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(C8671k.this.f40346e)));
                C8671k.this.m53473b(6, -1, c8622h.f40134a);
                return;
            }
            boolean z10 = th2 instanceof FaqWebServiceException;
            if (z10 && ((FaqWebServiceException) th2).errorCode == 401 && FaqSdk.getISdk().haveSdkErr("accessToken")) {
                a aVar = new a(this.f40396d);
                WeakReference<BaseSdkUpdateRequest> weakReference = C8671k.this.f40344c;
                if (weakReference != null) {
                    weakReference.clear();
                }
                C8671k.this.f40344c = new WeakReference<>(aVar);
                FaqSdk.getISdk().registerUpdateListener(aVar);
                FaqSdk.getISdk().onSdkErr("accessToken", FaqSdk.getSdk().getSdk("accessToken"));
                return;
            }
            if ((th2 instanceof SocketTimeoutException) || (th2 instanceof ConnectException)) {
                C8671k.this.m53473b(7, 1, null);
                return;
            }
            C8671k c8671k = C8671k.this;
            if (z10) {
                c8671k.m53475d((FaqWebServiceException) th2);
            } else {
                c8671k.m53475d(null);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.k$c */
    public class c extends FaqCallback<C8622h> {
        public c(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8622h c8622h) {
            if (th2 == null && c8622h != null) {
                C8671k.this.m53473b(6, -1, c8622h.f40134a);
                return;
            }
            if ((th2 instanceof SocketTimeoutException) || (th2 instanceof ConnectException)) {
                C8671k.this.m53473b(7, 1, null);
            } else if (th2 instanceof FaqWebServiceException) {
                C8671k.this.m53475d((FaqWebServiceException) th2);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.k$d */
    public class d extends FaqCallback<C8622h> {
        public d(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8622h c8622h) {
            if (th2 == null && c8622h != null) {
                ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(C8671k.this.f40346e)));
                C8671k.this.m53473b(6, -1, c8622h.f40134a);
            } else if ((th2 instanceof SocketTimeoutException) || (th2 instanceof ConnectException)) {
                C8671k.this.m53473b(7, 1, null);
            } else if (th2 instanceof FaqWebServiceException) {
                C8671k.this.m53475d((FaqWebServiceException) th2);
            }
        }
    }

    public C8671k(Context context, boolean z10, List<String> list, List<FeedbackZipBean> list2, FeedbackInfo feedbackInfo) {
        this.f40346e = context;
        this.f40390h = list;
        this.f40392j = feedbackInfo;
        this.f40345d = z10;
        this.f40347f = list2;
    }

    /* renamed from: b */
    public final void m53473b(int i10, int i11, String str) {
        SubmitListener submitListenerM53478j = m53478j();
        if (submitListenerM53478j != null) {
            submitListenerM53478j.submitNotify(i10, i11, str);
        }
    }

    /* renamed from: c */
    public final void m53474c(Submit submit) {
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(submit);
    }

    /* renamed from: d */
    public final void m53475d(FaqWebServiceException faqWebServiceException) {
        int i10;
        int i11 = 3;
        if (faqWebServiceException != null && "Y".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_IS_DEEPLICK)) && ((i10 = faqWebServiceException.errorCode) == 401 || i10 == 405)) {
            i11 = i10;
        }
        m53473b(7, i11, null);
    }

    /* renamed from: e */
    public final void m53476e(C8614b0 c8614b0) {
        Submit submitCallFeedBackService = FeedbackCommonManager.INSTANCE.callFeedBackService(this.f40346e, c8614b0, new c(C8622h.class, null));
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(submitCallFeedBackService);
    }

    /* renamed from: f */
    public void m53477f(SubmitListener submitListener) {
        if (submitListener != null) {
            this.f40391i = new WeakReference<>(submitListener);
        }
        m53480m();
    }

    /* renamed from: j */
    public final SubmitListener m53478j() {
        WeakReference<SubmitListener> weakReference = this.f40391i;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: k */
    public final void m53479k(C8614b0 c8614b0) {
        Submit submitCallFeedBackService = FeedbackCommonManager.INSTANCE.callFeedBackService(this.f40346e, c8614b0, new b(C8622h.class, null, c8614b0));
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(submitCallFeedBackService);
    }

    /* renamed from: m */
    public void m53480m() {
        if (this.f40392j == null) {
            return;
        }
        C8614b0 c8614b0 = new C8614b0();
        c8614b0.m53208m(this.f40392j.getProblemId());
        c8614b0.m53211p(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        c8614b0.m53202g(FaqSdk.getSdk().getSdk("country"));
        c8614b0.m53205j(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LANGUAGE));
        c8614b0.m53203h(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE));
        c8614b0.m53210o(this.f40392j.getProblemDesc());
        c8614b0.m53201f(this.f40392j.getContact());
        List<String> list = this.f40390h;
        if (list != null) {
            c8614b0.m53198c(list);
        }
        c8614b0.m53212q(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN));
        c8614b0.m53204i(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION));
        c8614b0.m53199d(FaqSdk.getSdk().getSdk("appVersion"));
        c8614b0.m53207l(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL));
        c8614b0.m53197b(FaqSdk.getSdk().getSdk("accessToken"));
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SOFT_VERSION);
        if (!TextUtils.isEmpty(sdk)) {
            c8614b0.m53213r(sdk);
        }
        if (!TextUtils.isEmpty(this.f40392j.getSrCode())) {
            c8614b0.m53214s(this.f40392j.getSrCode());
        }
        c8614b0.m53209n(this.f40392j.getProblemType());
        if (!TextUtils.isEmpty(String.valueOf(this.f40392j.getAssociatedId()))) {
            c8614b0.m53196a(Long.valueOf(this.f40392j.getAssociatedId()));
            c8614b0.m53215t(this.f40392j.getUniqueCode());
        }
        if (this.f40345d) {
            c8614b0.m53206k(this.f40392j.getZipFileName() + FeedbackWebConstants.SUFFIX);
            c8614b0.m53200e(this.f40347f);
        }
        if ("Y".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_IS_DEEPLICK))) {
            m53481n(c8614b0);
        } else {
            m53479k(c8614b0);
        }
    }

    /* renamed from: n */
    public final void m53481n(C8614b0 c8614b0) {
        Submit submitUpdateFeedBackInfo = FeedbackCommonManager.INSTANCE.updateFeedBackInfo(this.f40346e, c8614b0, new a(C8622h.class, null, c8614b0));
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(submitUpdateFeedBackInfo);
    }

    /* renamed from: o */
    public final void m53482o(C8614b0 c8614b0) {
        m53474c(FeedbackCommonManager.INSTANCE.callFeedBackService(this.f40346e, c8614b0, new d(C8622h.class, null)));
    }
}
