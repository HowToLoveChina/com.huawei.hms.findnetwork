package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.sync.R$string;
import java.util.Map;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class ServiceStatusTipsBaseView extends LinearLayout implements ServiceStateController {
    public ServiceStatusTipsBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24015c(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStateController
    /* renamed from: a */
    public void mo24013a() {
        C12809f.m76841n(getTipTextView(), getTipsText());
    }

    /* renamed from: b */
    public final String m24014b(String str) {
        int i10;
        Map<String, SyncItemInfo> mapM24070i = C3948f.m24064g().m24070i();
        if (mapM24070i != null && mapM24070i.containsKey(str)) {
            return mapM24070i.get(str).getTitle();
        }
        str.hashCode();
        if (str.equals("cloudBack1")) {
            i10 = R$string.cloudbackup_back_item_sms;
        } else if (str.equals("cloudBack2")) {
            i10 = R$string.cloud_restore_applist;
        } else {
            AbstractC10896a.m65888w("ServiceStatusTipsView", "getServiceName moduleName is:" + str);
            i10 = 0;
        }
        return i10 == 0 ? "" : getContext().getString(i10);
    }

    /* renamed from: c */
    public final void m24015c(Context context) {
        setTipTextView(LayoutInflater.from(context).inflate(getServiceStatusTipLayout(), this));
        C3948f.m24064g().m24073m(getClass().getCanonicalName(), this);
        mo24013a();
    }

    public String getServiceNameText() {
        C3948f c3948fM24064g = C3948f.m24064g();
        if (C0213f.m1377a() == null) {
            AbstractC10896a.m65886e("ServiceStatusTipsView", "getServiceNameText context is null");
            return "";
        }
        if (TextUtils.isEmpty(c3948fM24064g.m24068f())) {
            AbstractC10896a.m65886e("ServiceStatusTipsView", "firstOpenServiceKey is empty");
            return "";
        }
        int iM24067e = c3948fM24064g.m24067e();
        if (iM24067e == 1) {
            return m24014b(c3948fM24064g.m24068f());
        }
        String strM24014b = m24014b(c3948fM24064g.m24068f());
        String strM24014b2 = m24014b(c3948fM24064g.m24069h());
        if (!TextUtils.isEmpty(strM24014b) && !TextUtils.isEmpty(strM24014b2)) {
            return getContext().getString(iM24067e == 2 ? R$string.sync_data_merge_confirm_tips_double : R$string.service_names, strM24014b, strM24014b2);
        }
        AbstractC10896a.m65888w("ServiceStatusTipsView", "service name is empty");
        return "";
    }

    public abstract int getServiceStatusTipLayout();

    public abstract TextView getTipTextView();

    public abstract CharSequence getTipsText();

    public abstract void setTipTextView(View view);

    public ServiceStatusTipsBaseView(Context context) {
        super(context);
        m24015c(context);
    }
}
