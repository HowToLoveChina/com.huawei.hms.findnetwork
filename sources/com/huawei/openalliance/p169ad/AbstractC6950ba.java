package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;

/* renamed from: com.huawei.openalliance.ad.ba */
/* loaded from: classes8.dex */
public abstract class AbstractC6950ba extends AbstractC7326j {
    public AbstractC6950ba(String str) {
        super(str);
    }

    /* renamed from: b */
    public C6922c m39242b(Context context) {
        return new C6922c(context);
    }

    /* renamed from: b */
    public abstract String mo39243b();

    /* renamed from: d */
    public InterfaceC7615qq m39244d(Context context, String str) {
        H5Ad h5Ad = (H5Ad) AbstractC7758be.m47722a(str, H5Ad.class, new Class[0]);
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b == null) {
            AbstractC7185ho.m43824c("JsbBaseReportEvent", "%s: content is null", mo39243b());
            return null;
        }
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, h5Ad.m30368a()));
        c7560ou.mo46590a(contentRecordM45224b);
        return c7560ou;
    }
}
