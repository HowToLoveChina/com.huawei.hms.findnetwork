package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.analysis.C6921b;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.n */
/* loaded from: classes8.dex */
public class C7492n extends AbstractC7326j {
    public C7492n() {
        super("pps.common.analysis");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        AbstractC7185ho.m43817a("JsbCommonAnalysis", "start");
        ContentRecord contentRecordM45224b = m45224b(context, str);
        JSONObject jSONObject = new JSONObject(str);
        boolean zOptBoolean = jSONObject.optBoolean(JsbMapKeyNames.CHECK_CONTENT, true);
        int iOptInt = jSONObject.optInt("adType", -1);
        String strOptString = jSONObject.optString("slotid", "");
        boolean zOptBoolean2 = jSONObject.optBoolean(JsbMapKeyNames.REPORT_NOW, false);
        boolean zOptBoolean3 = jSONObject.optBoolean(JsbMapKeyNames.CHECK_DISCARD, false);
        if (!zOptBoolean) {
            AbstractC7185ho.m43820b("JsbCommonAnalysis", "no check ContentRecord");
        } else if (contentRecordM45224b == null) {
            AbstractC7185ho.m43820b("JsbCommonAnalysis", "ad not exist");
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
            return;
        } else if (!m45223a(context, contentRecordM45224b)) {
            AbstractC7185ho.m43820b("JsbCommonAnalysis", "ad is not in whitelist");
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_GROUP_MEM_LIST_FAIL, null, true);
            return;
        }
        BaseAnalysisInfo baseAnalysisInfo = (BaseAnalysisInfo) AbstractC7758be.m47739b(jSONObject.getString("analysis_info"), BaseAnalysisInfo.class, new Class[0]);
        C6971bo c6971bo = new C6971bo(context);
        C6921b c6921bM41053a = contentRecordM45224b != null ? c6971bo.m41053a(contentRecordM45224b, baseAnalysisInfo) : c6971bo.m41052a(baseAnalysisInfo);
        if (c6921bM41053a == null) {
            AbstractC7185ho.m43823c("JsbCommonAnalysis", "onAnalysis, info is null.");
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.HWID_UNLOGIN, null, true);
            return;
        }
        AbstractC7185ho.m43821b("JsbCommonAnalysis", "onAnalysis, type: %s", c6921bM41053a.m38812aL());
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("JsbCommonAnalysis", "onAnalysis, info: %s", AbstractC7758be.m47742b(c6921bM41053a));
        }
        if (contentRecordM45224b == null) {
            c6921bM41053a.m38936a(iOptInt);
            c6921bM41053a.m39031o(strOptString);
        }
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, iOptInt));
        c7560ou.mo46590a(contentRecordM45224b);
        c7560ou.mo46609b(c6921bM41053a, zOptBoolean2, zOptBoolean3);
        m45225b(remoteCallResultCallback, true);
    }
}
