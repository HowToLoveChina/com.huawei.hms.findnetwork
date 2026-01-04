package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.RewardKeys;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.bd */
/* loaded from: classes8.dex */
public class C6953bd extends AbstractC6950ba {
    public C6953bd() {
        super("pps.common.report");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String str2;
        int i10;
        AbstractC7185ho.m43817a("JsbReportCommonEvent", "start");
        ContentRecord contentRecordM45224b = m45224b(context, str);
        JSONObject jSONObject = new JSONObject(str);
        boolean zOptBoolean = jSONObject.optBoolean(JsbMapKeyNames.CHECK_CONTENT, true);
        boolean zOptBoolean2 = jSONObject.optBoolean(JsbMapKeyNames.REPORT_NOW, false);
        boolean zOptBoolean3 = jSONObject.optBoolean(JsbMapKeyNames.CHECK_DISCARD, false);
        if (zOptBoolean) {
            if (contentRecordM45224b == null) {
                AbstractC7185ho.m43820b("JsbReportCommonEvent", "ad not exist");
                str2 = this.f34112a;
                i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
            } else if (!m45223a(context, contentRecordM45224b)) {
                AbstractC7185ho.m43820b("JsbReportCommonEvent", "ad is not in whitelist");
                str2 = this.f34112a;
                i10 = SNSCode.Status.GET_GROUP_MEM_LIST_FAIL;
            }
            AbstractC7326j.m45216a(remoteCallResultCallback, str2, i10, null, true);
        }
        AbstractC7185ho.m43820b("JsbReportCommonEvent", "no check ContentRecord");
        EventRecord eventRecord = (EventRecord) AbstractC7758be.m47739b(jSONObject.getString(RewardKeys.EVENT_RECORD), EventRecord.class, new Class[0]);
        if (eventRecord == null) {
            AbstractC7185ho.m43823c("JsbReportCommonEvent", "reportEvent, eventRecord is null.");
            str2 = this.f34112a;
            i10 = SNSCode.Status.HWID_UNLOGIN;
        } else {
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, eventRecord.m41761m()));
            c7560ou.mo46590a(contentRecordM45224b);
            C6972bp c6972bp = new C6972bp(context);
            AbstractC7185ho.m43820b("JsbReportCommonEvent", "start report event");
            c6972bp.m41059a(eventRecord, contentRecordM45224b, zOptBoolean2, zOptBoolean3, c7560ou);
            str2 = this.f34112a;
            i10 = 1000;
        }
        AbstractC7326j.m45216a(remoteCallResultCallback, str2, i10, null, true);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return "JsbReportCommonEvent";
    }
}
