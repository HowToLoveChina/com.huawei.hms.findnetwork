package com.huawei.openalliance.p169ad.views.feedback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.activity.AdComplainActivity;
import com.huawei.openalliance.p169ad.beans.feedback.AdditionalContext;
import com.huawei.openalliance.p169ad.beans.feedback.ComplainAddInfo;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.views.feedback.d */
/* loaded from: classes2.dex */
public class C8094d {

    /* renamed from: a */
    private WeakReference<InterfaceC8097g> f37654a;

    /* renamed from: b */
    private ContentRecord f37655b;

    /* renamed from: c */
    private List<FeedbackInfo> f37656c;

    /* renamed from: d */
    private List<FeedbackInfo> f37657d;

    /* renamed from: e */
    private FeedbackInfo f37658e;

    /* renamed from: f */
    private Context f37659f;

    /* renamed from: g */
    private InterfaceC8096f f37660g;

    public C8094d(InterfaceC8097g interfaceC8097g) {
        this.f37654a = new WeakReference<>(interfaceC8097g);
    }

    /* renamed from: g */
    private void m50151g() {
        AdditionalContext additionalContextM39268a;
        ComplainAddInfo complainAddInfoMo50141a = this.f37660g.mo50141a();
        if (complainAddInfoMo50141a == null || (additionalContextM39268a = complainAddInfoMo50141a.m39268a()) == null) {
            return;
        }
        AbstractC7185ho.m43821b("FeedbackPresenter", "add info: %s", additionalContextM39268a.toString());
    }

    /* renamed from: a */
    public List<FeedbackInfo> m50152a() {
        return this.f37656c;
    }

    /* renamed from: b */
    public List<FeedbackInfo> m50155b() {
        return this.f37657d;
    }

    /* renamed from: c */
    public FeedbackInfo m50156c() {
        return this.f37658e;
    }

    /* renamed from: d */
    public boolean m50157d() {
        ContentRecord contentRecord = this.f37655b;
        if (contentRecord != null) {
            return contentRecord.m41517bd();
        }
        return false;
    }

    /* renamed from: e */
    public String m50158e() {
        ContentRecord contentRecord = this.f37655b;
        return contentRecord != null ? contentRecord.m41516bc() : "";
    }

    /* renamed from: f */
    public boolean m50159f() {
        AbstractC7185ho.m43820b("FeedbackPresenter", "click complain");
        if (this.f37658e == null) {
            return false;
        }
        try {
            Intent intent = new Intent(this.f37659f, (Class<?>) AdComplainActivity.class);
            intent.putExtra(MapKeyNames.COMPLAIN_H5_TITLE, this.f37658e.getLabel());
            AdComplainActivity.m38585a(this.f37660g);
            if (!(this.f37659f instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            AbstractC7811dd.m48294a(this.f37659f, intent);
            m50151g();
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FeedbackPresenter", "start ac failed: %s", th2.getClass().getSimpleName());
            return true;
        }
    }

    /* renamed from: a */
    public void m50153a(Context context, ContentRecord contentRecord, InterfaceC8098h interfaceC8098h) {
        List<FeedbackInfo> list;
        this.f37659f = context.getApplicationContext();
        if (contentRecord == null || AbstractC7760bg.m47767a(contentRecord.m41461aM())) {
            return;
        }
        this.f37655b = contentRecord;
        this.f37660g = new C8091a(context, contentRecord, interfaceC8098h);
        List<FeedbackInfo> listM41461aM = this.f37655b.m41461aM();
        this.f37657d = new ArrayList();
        this.f37656c = new ArrayList();
        for (FeedbackInfo feedbackInfo : listM41461aM) {
            if (feedbackInfo != null) {
                int type = feedbackInfo.getType();
                if (type == 1) {
                    list = this.f37657d;
                } else if (type == 2) {
                    list = this.f37656c;
                } else if (type != 3) {
                    AbstractC7185ho.m43817a("FeedbackPresenter", "invalid feedback type");
                } else {
                    this.f37658e = feedbackInfo;
                }
                list.add(feedbackInfo);
            }
        }
        InterfaceC8097g interfaceC8097g = this.f37654a.get();
        if (interfaceC8097g != null) {
            interfaceC8097g.m50164c();
        }
    }

    /* renamed from: a */
    public boolean m50154a(Context context) {
        ContentRecord contentRecord = this.f37655b;
        if (contentRecord == null) {
            return false;
        }
        return AbstractC7741ao.m47548a(context, contentRecord);
    }
}
