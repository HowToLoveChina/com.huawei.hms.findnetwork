package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.content.Context;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.entity.C8613b;
import com.huawei.phoneservice.feedbackcommon.entity.C8617d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.b */
/* loaded from: classes5.dex */
public final class C8660b {

    /* renamed from: a */
    public WeakReference<OnDeleteHistoryListener> f40335a;

    /* renamed from: b */
    public final Context f40336b;

    /* renamed from: c */
    public final String f40337c;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.b$a */
    public class a extends FaqCallback<C8617d> {

        /* renamed from: d */
        public final /* synthetic */ C8613b f40338d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Activity activity, C8613b c8613b) {
            super(cls, activity);
            this.f40338d = c8613b;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8617d c8617d) {
            if (th2 == null) {
                C8660b.this.m53392k();
            } else {
                C8660b.this.m53389g(th2, this.f40338d);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.b$b */
    public class b extends FaqCallback<C8617d> {
        public b(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8617d c8617d) {
            C8660b c8660b = C8660b.this;
            if (th2 == null) {
                c8660b.m53392k();
            } else {
                c8660b.m53390h();
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.b$c */
    public class c extends BaseSdkUpdateRequest<C8613b> {
        public c(C8613b c8613b) {
            super(c8613b);
        }

        @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onCallback(String str, String str2, String str3, C8613b c8613b) {
            if (!"accessToken".equals(str) || c8613b == null) {
                return;
            }
            FaqSdk.getISdk().unregisterUpdateListener(this);
            c8613b.m53193a(str3);
            C8660b.this.m53391i(c8613b);
        }
    }

    public C8660b(Context context, String str) {
        this.f40336b = context;
        this.f40337c = str;
    }

    /* renamed from: a */
    public final OnDeleteHistoryListener m53386a() {
        WeakReference<OnDeleteHistoryListener> weakReference = this.f40335a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: b */
    public final void m53387b(C8613b c8613b) {
        Context context = this.f40336b;
        if (context == null || c8613b == null) {
            return;
        }
        FeedbackCommonManager.INSTANCE.deleteHistory(context, c8613b, new a(C8617d.class, (Activity) context, c8613b));
    }

    /* renamed from: c */
    public void m53388c(OnDeleteHistoryListener onDeleteHistoryListener) {
        if (onDeleteHistoryListener != null) {
            this.f40335a = new WeakReference<>(onDeleteHistoryListener);
        }
        C8613b c8613b = new C8613b();
        c8613b.m53195c(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        c8613b.m53193a(FaqSdk.getSdk().getSdk("accessToken"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f40337c);
        c8613b.m53194b(arrayList);
        m53387b(c8613b);
    }

    /* renamed from: g */
    public final void m53389g(Throwable th2, C8613b c8613b) {
        if ((th2 instanceof FaqWebServiceException) && ((FaqWebServiceException) th2).errorCode == 401 && FaqSdk.getISdk().haveSdkErr("accessToken")) {
            m53393l(c8613b);
        } else {
            m53390h();
        }
    }

    /* renamed from: h */
    public final void m53390h() {
        if (m53386a() != null) {
            m53386a().showErrorToast();
        }
    }

    /* renamed from: i */
    public final void m53391i(C8613b c8613b) {
        Context context = this.f40336b;
        if (context == null || c8613b == null) {
            return;
        }
        FeedbackCommonManager.INSTANCE.deleteHistory(context, c8613b, new b(C8617d.class, (Activity) context));
    }

    /* renamed from: k */
    public final void m53392k() {
        if (m53386a() != null) {
            m53386a().deleteLocalData();
        }
    }

    /* renamed from: l */
    public final void m53393l(C8613b c8613b) {
        if (c8613b == null) {
            return;
        }
        FaqSdk.getISdk().registerUpdateListener(new c(c8613b));
        FaqSdk.getISdk().onSdkErr("accessToken", FaqSdk.getSdk().getSdk("accessToken"));
    }
}
