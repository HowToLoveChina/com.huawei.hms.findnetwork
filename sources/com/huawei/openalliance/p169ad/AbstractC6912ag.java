package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.jsb.C5091a;
import com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.ag */
/* loaded from: classes8.dex */
public abstract class AbstractC6912ag extends AbstractC7326j {
    public AbstractC6912ag(String str) {
        super(str);
    }

    /* renamed from: a */
    public C7306i m38794a(ContentRecord contentRecord) {
        if (contentRecord != null) {
            return new C7306i(contentRecord);
        }
        AbstractC7185ho.m43817a("JsbBaseDownload", "content is null");
        return null;
    }

    /* renamed from: d */
    public C7306i m38795d(Context context, String str) {
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b != null) {
            return new C7306i(contentRecordM45224b);
        }
        AbstractC7185ho.m43817a("JsbBaseDownload", "content is null");
        return null;
    }

    /* renamed from: e */
    public InterfaceC7052b m38796e(Context context, String str) {
        InterfaceC7052b interfaceC7052bM30361a = C5091a.m30359a(context).m30361a();
        interfaceC7052bM30361a.mo42479a(m45227d(str));
        return interfaceC7052bM30361a;
    }
}
