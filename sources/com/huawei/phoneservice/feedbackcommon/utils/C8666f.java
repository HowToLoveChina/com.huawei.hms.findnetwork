package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.feedbackcommon.entity.C8612a0;
import com.huawei.phoneservice.feedbackcommon.entity.C8630p;
import com.huawei.phoneservice.feedbackcommon.entity.C8631q;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemEntity;
import com.huawei.phoneservice.feedbackcommon.p176db.FeedbackProblemData;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.f */
/* loaded from: classes5.dex */
public final class C8666f {

    /* renamed from: a */
    public WeakReference<OnReadListener> f40362a;

    /* renamed from: b */
    public String f40363b;

    /* renamed from: c */
    public boolean f40364c;

    /* renamed from: d */
    public WeakReference<Context> f40365d;

    /* renamed from: e */
    public WeakReference<OnReadListener> f40366e;

    /* renamed from: f */
    public LinkedList<ProblemEntity> f40367f;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.f$a */
    public class a extends FaqCallback<C8631q> {
        public a(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8631q c8631q) {
            int i10;
            if (c8631q == null || c8631q.m53251a() == null) {
                i10 = 0;
            } else {
                i10 = 0;
                for (C8631q.a aVar : c8631q.m53251a()) {
                    if (aVar != null && !aVar.m53252a() && C8666f.this.f40364c == aVar.m53253b()) {
                        i10++;
                    }
                }
            }
            C8666f.this.m53430f(th2, i10 > 0 ? 1 : 0);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.f$b */
    public class b extends FaqCallback<C8612a0> {

        /* renamed from: d */
        public final /* synthetic */ String f40369d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Activity activity, String str) {
            super(cls, activity);
            this.f40369d = str;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8612a0 c8612a0) throws Throwable {
            boolean z10 = th2 == null;
            boolean z11 = (th2 instanceof FaqWebServiceException) && ((FaqWebServiceException) th2).errorCode == 400;
            if (!z10 && !z11) {
                C8666f.this.m53430f(th2, 0);
                return;
            }
            try {
                FeedbackProblemData.getInstance((Context) C8666f.this.f40365d.get()).deleteFailProblem(this.f40369d);
            } catch (Exception e10) {
                FaqLogger.m51840e("GetUnreadTask", e10.getMessage());
            }
            C8666f.this.m53429e(this.f40369d);
            C8666f.this.f40367f.removeLast();
            boolean zIsEmpty = C8666f.this.f40367f.isEmpty();
            C8666f c8666f = C8666f.this;
            if (zIsEmpty) {
                c8666f.m53432k();
            } else {
                c8666f.m53433l();
            }
        }
    }

    public C8666f(Context context, String str, boolean z10, OnReadListener onReadListener) {
        this.f40363b = str;
        this.f40364c = z10;
        this.f40365d = new WeakReference<>(context);
        if (onReadListener != null) {
            this.f40362a = new WeakReference<>(onReadListener);
        }
    }

    /* renamed from: a */
    public final OnReadListener m53427a() {
        WeakReference<OnReadListener> weakReference = this.f40366e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: b */
    public void m53428b(OnReadListener onReadListener) {
        if (onReadListener != null) {
            this.f40366e = new WeakReference<>(onReadListener);
        }
        List<ProblemEntity> allFailProblem = null;
        if (!FaqSdk.getISdk().hadAddress() || !ModuleConfigUtils.isNativeFeedback() || TextUtils.isEmpty(FaqSdk.getSdk().getSdk("accessToken"))) {
            FaqLogger.m51840e("GetUnreadTask", " ERROR");
            m53430f(null, 0);
            return;
        }
        if (TextUtils.isEmpty(this.f40363b)) {
            try {
                allFailProblem = FeedbackProblemData.getInstance(this.f40365d.get()).getAllFailProblem();
            } catch (Exception e10) {
                FaqLogger.m51840e("GetUnreadTask", e10.getMessage());
            }
            if (allFailProblem != null && !allFailProblem.isEmpty()) {
                this.f40367f = new LinkedList<>(allFailProblem);
                m53433l();
                return;
            }
        }
        m53432k();
    }

    /* renamed from: e */
    public final void m53429e(String str) {
        OnReadListener onReadListenerM53431h = m53431h();
        if (onReadListenerM53431h != null) {
            onReadListenerM53431h.read(null, str);
        }
    }

    /* renamed from: f */
    public final void m53430f(Throwable th2, int i10) {
        OnReadListener onReadListenerM53427a = m53427a();
        if (onReadListenerM53427a == null && (onReadListenerM53427a = m53431h()) == null) {
            return;
        }
        onReadListenerM53427a.unread(th2, this.f40363b, i10);
    }

    /* renamed from: h */
    public final OnReadListener m53431h() {
        WeakReference<OnReadListener> weakReference = this.f40362a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: k */
    public final void m53432k() {
        C8630p c8630p = new C8630p(FaqSdk.getSdk().getSdk("accessToken"), FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL), this.f40363b);
        c8630p.m53249a(this.f40364c ? 2 : 1);
        c8630p.m53250b(50);
        FeedbackCommonManager.INSTANCE.getUnread(this.f40365d.get(), c8630p, new a(C8631q.class, null));
    }

    /* renamed from: l */
    public final void m53433l() {
        String strM53180a = this.f40367f.getLast().m53180a();
        FeedbackCommonManager.INSTANCE.setRead(this.f40365d.get(), FaqSdk.getSdk().getSdk("accessToken"), strM53180a, new b(C8612a0.class, null, strM53180a));
    }
}
