package sg;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import bf.C1175a;
import ck.C1443a;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0228m0;
import p237du.C9310c;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p581qk.AbstractC12367d;
import p611rf.C12498f;
import p616rk.C12515a;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import tm.C13040c;

/* renamed from: sg.a */
/* loaded from: classes4.dex */
public class C12796a {

    /* renamed from: sg.a$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f58478a;

        /* renamed from: b */
        public final /* synthetic */ LinkedHashMap f58479b;

        public a(Context context, LinkedHashMap linkedHashMap) {
            this.f58478a = context;
            this.f58479b = linkedHashMap;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                String strM71275j = C11877j.m71275j(this.f58478a);
                String strM78622N = C13040c.m78609F().m78622N();
                if (TextUtils.isEmpty(strM71275j)) {
                    strM71275j = strM78622N;
                }
                String strM83101w = C13843a.m83101w(strM71275j);
                this.f58479b.put("domain", strM83101w);
                this.f58479b.put("server_ip", C11881n.m71370t(strM83101w));
            } catch (Exception e10) {
                C13981a.m83990w("ActiveLockHiAnalytics", "getPhoneFinderUrl domain error:" + e10.getMessage());
            }
            C12796a.this.m76770c(this.f58479b);
        }
    }

    /* renamed from: b */
    public final void m76769b(boolean z10, Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, LinkedHashMap<String, String> linkedHashMap) {
        if (C10028c.m62182c0().m62221H1()) {
            C13981a.m83989i("ActiveLockHiAnalytics", "use cloud report");
            new C12797b().m76785k(context, str, str2, str3, str4, str5, str6, str7, true, linkedHashMap);
            return;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("returnCode", str2);
        linkedHashMap2.put("errorReason", str3);
        linkedHashMap2.put("clientErrorCode", str4);
        linkedHashMap2.put("operationType", str5);
        linkedHashMap2.put("business_id", str7);
        linkedHashMap2.put("traceID", C12797b.m76776f(str6, str5));
        linkedHashMap2.put("business_type", Build.MODEL);
        linkedHashMap2.put(HwPayConstant.KEY_USER_ID, AbstractC12139d.m72766e(context).getUserID());
        linkedHashMap2.put("gradeCode", C13452e.m80781L().m80790C());
        linkedHashMap2.put("androidVersion", Build.VERSION.RELEASE);
        linkedHashMap2.put("resourcePath", "resourcePath");
        linkedHashMap2.put("pn", "com.huawei.hidisk\u0001_phonefinder");
        LinkedHashMap<String, String> linkedHashMap3 = linkedHashMap == null ? new LinkedHashMap<>() : linkedHashMap;
        linkedHashMap3.put("readTaData", C1175a.m7392n());
        linkedHashMap2.put("extraData", linkedHashMap3.toString());
        linkedHashMap2.put("deviceUUID", C0228m0.m1597b().m1599c());
        linkedHashMap2.put(FaqConstants.FAQ_ROMVERSION, C0209d.m1319w());
        linkedHashMap2.put(FaqConstants.FAQ_EMUIVERSION, C0209d.m1186L());
        linkedHashMap2.put("appVersion", "16.0.0.300");
        if (z10) {
            linkedHashMap2.put("deviceId", C9310c.m58618b(C12498f.m75015b(context)));
        }
        C12515a.m75110o().m75175e(new a(context, linkedHashMap2), false);
    }

    /* renamed from: c */
    public final void m76770c(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>(linkedHashMap);
            try {
                if (C13230i.m79504I().mo79488G() == null) {
                    C13230i.m79504I().m79562M(C12347f.m74285n().m74301m(), true);
                }
            } catch (C9721b unused) {
                C13981a.m83988e("ActiveLockHiAnalytics", "report getHiAnalyticsInstance exception");
                C13230i.m79504I().m79562M(C12347f.m74285n().m74301m(), true);
            }
            C13230i.m79504I().mo79488G().onEvent(1, "HUAWEICLOUD", linkedHashMap2);
            C13230i.m79504I().mo79488G().onReport(1);
            if (C1443a.f6214b.booleanValue()) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap2);
                C13230i.m79516a1(linkedHashMap3);
                C13981a.m83987d("ActiveLockHiAnalytics", "BI DATA = " + linkedHashMap3.toString());
            }
        } catch (Exception e10) {
            C13981a.m83988e("ActiveLockHiAnalytics", "report exception: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public void m76771d(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, LinkedHashMap<String, String> linkedHashMap) {
        m76769b(false, context, str, str2, str3, str4, str5, str6, str7, linkedHashMap);
    }

    /* renamed from: e */
    public void m76772e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, LinkedHashMap<String, String> linkedHashMap) {
        m76769b(true, context, str, str2, str3, str4, str5, str6, str7, linkedHashMap);
    }

    /* renamed from: f */
    public void m76773f(Context context, String str, String str2, String str3, String str4, String str5, String str6, LinkedHashMap<String, String> linkedHashMap) {
        m76772e(context, "ActiveLockHiAnalytics", str, str2, str3, str4, str5, str6, linkedHashMap);
    }
}
