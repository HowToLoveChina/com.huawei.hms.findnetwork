package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.beans.inner.AdEventReport;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.C7753b;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.bb */
/* loaded from: classes8.dex */
public class C6951bb extends AbstractC6950ba {
    public C6951bb() {
        super("pps.event.click");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String str2;
        int i10;
        AbstractC7185ho.m43817a("JsbReportClickEvent", "start");
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b == null) {
            AbstractC7185ho.m43820b("JsbReportClickEvent", "ad not exist");
            str2 = this.f34112a;
            i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
        } else if (m45223a(context, contentRecordM45224b)) {
            InterfaceC7615qq interfaceC7615qqM39244d = m39244d(context, str);
            AdEventReport adEventReport = (AdEventReport) AbstractC7758be.m47722a(str, AdEventReport.class, new Class[0]);
            if (interfaceC7615qqM39244d != null) {
                int iM39317i = adEventReport.m39317i();
                int iM39318j = adEventReport.m39318j();
                String strM39319k = !TextUtils.isEmpty(adEventReport.m39319k()) ? adEventReport.m39319k() : ClickDestination.JS_SDK_INTERFACE;
                int iIntValue = adEventReport.m39311d() != null ? adEventReport.m39311d().intValue() : 13;
                String strM39321m = adEventReport.m39321m();
                C7587b.a aVar = new C7587b.a();
                JSONObject jSONObject = new JSONObject(str);
                MaterialClickInfo materialClickInfoM45229f = m45229f(str);
                Integer numM45227d = m45227d(str);
                boolean z10 = materialClickInfoM45229f.m44517h() == null && materialClickInfoM45229f.m44518i() == null;
                if (numM45227d != null && 13 == numM45227d.intValue() && z10) {
                    materialClickInfoM45229f.m44515f(1);
                }
                aVar.m46912a(iM39317i).m46919b(iM39318j).m46920b(strM39319k).m46915a(Integer.valueOf(iIntValue)).m46922c(strM39321m).m46914a(materialClickInfoM45229f).m46916a(jSONObject.optString("versionCode")).m46917a(m45231h(jSONObject.optString("versionCode"))).m46923d(C7753b.m47699a(context));
                interfaceC7615qqM39244d.mo46594a(aVar.m46918a());
            }
            str2 = this.f34112a;
            i10 = 1000;
        } else {
            AbstractC7185ho.m43820b("JsbReportClickEvent", "ad is not in whitelist");
            str2 = this.f34112a;
            i10 = SNSCode.Status.GET_GROUP_MEM_LIST_FAIL;
        }
        AbstractC7326j.m45216a(remoteCallResultCallback, str2, i10, null, true);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return "JsbReportClickEvent";
    }
}
