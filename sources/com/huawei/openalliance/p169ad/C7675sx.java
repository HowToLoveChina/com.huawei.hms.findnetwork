package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.fastengine.fastview.FastSDKEngine;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7831j;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.sx */
/* loaded from: classes8.dex */
public class C7675sx extends AbstractC7687ti {

    /* renamed from: c */
    private InterfaceC7615qq f35686c;

    public C7675sx(Context context, ContentRecord contentRecord) {
        super(context, contentRecord);
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
        this.f35686c = c7560ou;
        c7560ou.mo46590a(contentRecord);
    }

    /* renamed from: d */
    private boolean m47235d() throws JSONException {
        ContentRecord contentRecord;
        if (!AbstractC7791ck.m48066a("com.huawei.fastengine.fastview.FastSDKEngine")) {
            AbstractC7185ho.m43823c("FastAppSdkOpenAction", "fast sdk not available.");
            return false;
        }
        if (this.f35700a == null || (contentRecord = this.f35701b) == null) {
            AbstractC7185ho.m43823c("FastAppSdkOpenAction", "open fast app param error");
            return false;
        }
        String strM48168c = AbstractC7806cz.m48168c(contentRecord.m41397H());
        if (TextUtils.isEmpty(strM48168c)) {
            AbstractC7185ho.m43823c("FastAppSdkOpenAction", "intentUri empty");
            return false;
        }
        FastSDKEngine.LaunchOption launchOption = new FastSDKEngine.LaunchOption();
        launchOption.setShortCutStrategy(0);
        int iLaunchFastAppByDeeplink = FastSDKEngine.launchFastAppByDeeplink(this.f35700a, strM48168c, launchOption);
        AbstractC7185ho.m43821b("FastAppSdkOpenAction", "launch ret: %s", Integer.valueOf(iLaunchFastAppByDeeplink));
        C7692tn.a aVar = new C7692tn.a();
        aVar.m47274a(this.f35701b).m47279c(Constants.FAST_APP_PKG);
        if (iLaunchFastAppByDeeplink == 0) {
            C7691tm.m47256a(this.f35700a, aVar.m47277a());
            this.f35686c.mo46588a(EventType.INTENTSUCCESS, (Integer) 2, (Integer) null);
            return true;
        }
        AbstractC7185ho.m43823c("FastAppSdkOpenAction", "launchFastAppByDeeplink error");
        new C6922c(this.f35700a).mo39085a(aVar.m47277a(), String.valueOf(iLaunchFastAppByDeeplink));
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        AbstractC7185ho.m43820b("FastAppSdkOpenAction", "handle fast app sdk action.");
        if (!m47235d()) {
            return m47249b();
        }
        AppInfo appInfoM41484af = this.f35701b.m41484af();
        m47248b(C7831j.m48455a(appInfoM41484af == null ? null : appInfoM41484af.getPackageName(), appInfoM41484af));
        return true;
    }
}
