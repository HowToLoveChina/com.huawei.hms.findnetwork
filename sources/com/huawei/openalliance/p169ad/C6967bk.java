package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.beans.inner.AdEventReport;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.bk */
/* loaded from: classes8.dex */
public class C6967bk extends AbstractC6950ba {
    public C6967bk() {
        super("pps.event.show");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String str2;
        int i10;
        AbstractC7185ho.m43817a("JsbReportShowEvent", "start");
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b != null) {
            AdEventReport adEventReport = (AdEventReport) AbstractC7758be.m47722a(str, AdEventReport.class, new Class[0]);
            InterfaceC7615qq interfaceC7615qqM39244d = m39244d(context, str);
            if (interfaceC7615qqM39244d != null && adEventReport != null) {
                if (adEventReport.m39304a()) {
                    interfaceC7615qqM39244d.mo46581a(adEventReport.m39305b() == null ? 0L : adEventReport.m39305b().longValue(), adEventReport.m39308c() != null ? adEventReport.m39308c().intValue() : 0);
                } else if (m45223a(context, contentRecordM45224b)) {
                    C7586a.a aVar = new C7586a.a();
                    aVar.m46874a(adEventReport.m39305b()).m46873a(adEventReport.m39308c()).m46878b(adEventReport.m39311d()).m46876a(m45231h(new JSONObject(str).optString("versionCode"))).m46885e(m45228e(str)).m46875a(adEventReport.m39322n());
                    interfaceC7615qqM39244d.mo46593a(aVar.m46877a());
                } else {
                    AbstractC7185ho.m43817a("JsbReportShowEvent", "ad is not in whitelist");
                    str2 = this.f34112a;
                    i10 = SNSCode.Status.GET_GROUP_MEM_LIST_FAIL;
                }
                AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, 200, null, true);
                return;
            }
            str2 = this.f34112a;
            i10 = SNSCode.Status.HWID_UNLOGIN;
        } else {
            str2 = this.f34112a;
            i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
        }
        AbstractC7326j.m45216a(remoteCallResultCallback, str2, i10, null, true);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return null;
    }
}
