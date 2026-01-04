package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackZipBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.d */
/* loaded from: classes5.dex */
public abstract class AbstractC8662d {

    /* renamed from: a */
    public WeakReference<Submit> f40342a;

    /* renamed from: b */
    public WeakReference<com.huawei.hms.network.httpclient.Submit<ResponseBody>> f40343b;

    /* renamed from: c */
    public WeakReference<BaseSdkUpdateRequest> f40344c;

    /* renamed from: e */
    public Context f40346e;

    /* renamed from: d */
    public boolean f40345d = false;

    /* renamed from: f */
    public List<FeedbackZipBean> f40347f = new ArrayList(20);

    /* renamed from: g */
    public CancelInterface f40348g = new a();

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.d$a */
    public class a implements CancelInterface {
        public a() {
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.CancelInterface
        public void isCancel(boolean z10) {
            if (z10) {
                WeakReference<Submit> weakReference = AbstractC8662d.this.f40342a;
                if (weakReference != null && weakReference.get() != null) {
                    AbstractC8662d.this.f40342a.get().cancel();
                    AbstractC8662d.this.f40342a.clear();
                    AbstractC8662d.this.f40342a = null;
                }
                WeakReference<com.huawei.hms.network.httpclient.Submit<ResponseBody>> weakReference2 = AbstractC8662d.this.f40343b;
                if (weakReference2 != null && weakReference2.get() != null) {
                    AbstractC8662d.this.f40343b.get().cancel();
                    AbstractC8662d.this.f40343b.clear();
                    AbstractC8662d.this.f40343b = null;
                }
                WeakReference<BaseSdkUpdateRequest> weakReference3 = AbstractC8662d.this.f40344c;
                if (weakReference3 == null || weakReference3.get() == null) {
                    return;
                }
                FaqSdk.getISdk().unregisterUpdateListener(AbstractC8662d.this.f40344c.get());
                AbstractC8662d.this.f40344c.clear();
                AbstractC8662d.this.f40344c = null;
            }
        }
    }

    /* renamed from: a */
    public CancelInterface m53399a() {
        return this.f40348g;
    }
}
