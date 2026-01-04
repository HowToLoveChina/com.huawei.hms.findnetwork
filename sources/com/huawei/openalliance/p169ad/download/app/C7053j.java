package com.huawei.openalliance.p169ad.download.app;

import android.content.Context;
import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7575pi;
import com.huawei.openalliance.p169ad.C7686th;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.download.app.j */
/* loaded from: classes2.dex */
public class C7053j {

    /* renamed from: a */
    private static long f32456a;

    /* renamed from: a */
    private Map<String, String> m42485a(ContentRecord contentRecord) {
        HashMap map = new HashMap();
        if (contentRecord != null && contentRecord.m41568i() != null) {
            MetaData metaDataM41568i = contentRecord.m41568i();
            String strM40330n = metaDataM41568i.m40330n();
            String strM40328m = metaDataM41568i.m40328m();
            if (strM40330n != null && strM40328m != null) {
                map.put("appId", strM40330n);
                map.put("thirdId", strM40328m);
            }
        }
        return map;
    }

    /* renamed from: a */
    private void m42486a(final Context context, final IAd iAd) {
        long jM47566c = AbstractC7741ao.m47566c();
        AbstractC7185ho.m43821b("DownloadChecker", "trigger action list lastTime:%s curTime:%s", Long.valueOf(f32456a), Long.valueOf(jM47566c));
        if (jM47566c - f32456a < 500) {
            AbstractC7185ho.m43820b("DownloadChecker", "trigger action list too frequently");
        } else {
            f32456a = jM47566c;
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.j.1
                @Override // java.lang.Runnable
                public void run() {
                    C7053j.this.m42488a(iAd, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42488a(IAd iAd, Context context) {
        if (iAd == null || context == null) {
            return;
        }
        if (iAd instanceof C7302e) {
            AbstractC7185ho.m43821b("DownloadChecker", "native trigger action list result:%s", Boolean.valueOf(((C7302e) iAd).m44801a(context, (Bundle) null)));
        } else if (!(iAd instanceof C7304g)) {
            AbstractC7185ho.m43820b("DownloadChecker", "Unsupported ad form");
        } else {
            ContentRecord contentRecordM46766a = C7575pi.m46766a((C7304g) iAd);
            AbstractC7185ho.m43821b("DownloadChecker", "trigger action list result:%s", Boolean.valueOf(C7686th.m47245a(context, contentRecordM46766a, m42485a(contentRecordM46766a)).mo47233a()));
        }
    }

    /* renamed from: a */
    public boolean m42489a(Context context, IAd iAd, boolean z10) {
        if (context == null || iAd == null) {
            return false;
        }
        if (iAd instanceof C7306i) {
            return true;
        }
        int interfaceDownloadConfig = iAd.getInterfaceDownloadConfig();
        AbstractC7185ho.m43818a("DownloadChecker", "api control flag:%s", Integer.valueOf(interfaceDownloadConfig));
        if (interfaceDownloadConfig == 0) {
            return true;
        }
        if (interfaceDownloadConfig != 1) {
            if (interfaceDownloadConfig != 2) {
                AbstractC7185ho.m43823c("DownloadChecker", "invalid apiDownloadFlag value!");
            }
            return false;
        }
        if (z10) {
            m42486a(context, iAd);
        }
        return false;
    }
}
