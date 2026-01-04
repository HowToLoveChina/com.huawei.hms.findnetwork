package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.entity.C8612a0;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemEntity;
import com.huawei.phoneservice.feedbackcommon.p176db.FeedbackProblemData;
import java.lang.ref.WeakReference;
import java.net.ConnectException;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.j */
/* loaded from: classes5.dex */
public final class C8670j {

    /* renamed from: a */
    public WeakReference<OnReadListener> f40385a;

    /* renamed from: b */
    public WeakReference<OnReadListener> f40386b;

    /* renamed from: c */
    public String f40387c;

    /* renamed from: d */
    public WeakReference<Context> f40388d;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.j$a */
    public class a extends FaqCallback<C8612a0> {
        public a(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8612a0 c8612a0) throws Throwable {
            C8670j c8670j;
            boolean z10 = false;
            boolean z11 = th2 == null;
            if ((th2 instanceof FaqWebServiceException) && ((FaqWebServiceException) th2).errorCode == 400) {
                z10 = true;
            }
            if (z11 || z10) {
                FeedbackProblemData.getInstance((Context) C8670j.this.f40388d.get()).deleteFailProblem(C8670j.this.f40387c);
                c8670j = C8670j.this;
                th2 = null;
            } else {
                FeedbackProblemData.getInstance((Context) C8670j.this.f40388d.get()).saveFailProblem(new ProblemEntity(C8670j.this.f40387c));
                c8670j = C8670j.this;
            }
            c8670j.m53465e(th2);
        }
    }

    public C8670j(Context context, String str, OnReadListener onReadListener) {
        this.f40387c = str;
        this.f40388d = new WeakReference<>(context);
        if (onReadListener != null) {
            this.f40385a = new WeakReference<>(onReadListener);
        }
    }

    /* renamed from: a */
    public final OnReadListener m53463a() {
        WeakReference<OnReadListener> weakReference = this.f40386b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: c */
    public void m53464c(OnReadListener onReadListener) {
        if (onReadListener != null) {
            this.f40386b = new WeakReference<>(onReadListener);
        }
        if (TextUtils.isEmpty(this.f40387c)) {
            m53465e(new Throwable("problemId is Empty"));
        } else if (FaqSdk.getISdk().hadAddress()) {
            m53467h();
        } else {
            m53465e(new ConnectException("Unable to connect to server"));
            FeedbackProblemData.getInstance(this.f40388d.get()).saveFailProblem(new ProblemEntity(this.f40387c));
        }
    }

    /* renamed from: e */
    public final void m53465e(Throwable th2) {
        OnReadListener onReadListenerM53463a = m53463a();
        if (onReadListenerM53463a == null && (onReadListenerM53463a = m53466f()) == null) {
            return;
        }
        onReadListenerM53463a.read(th2, this.f40387c);
    }

    /* renamed from: f */
    public final OnReadListener m53466f() {
        WeakReference<OnReadListener> weakReference = this.f40385a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: h */
    public final void m53467h() {
        FeedbackCommonManager.INSTANCE.setRead(this.f40388d.get(), FaqSdk.getSdk().getSdk("accessToken"), this.f40387c, new a(C8612a0.class, null));
    }
}
