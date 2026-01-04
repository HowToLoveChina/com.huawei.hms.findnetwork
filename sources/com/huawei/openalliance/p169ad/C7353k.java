package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.k */
/* loaded from: classes8.dex */
public class C7353k extends AbstractC7326j {
    public C7353k() {
        super("pps.click.complianceele");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String str2;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("JsbClickComplianceEle", "start");
        }
        String strOptString = new JSONObject(str).optString(JsbMapKeyNames.H5_COMPLIANCE_TYPE, "");
        AbstractC7185ho.m43820b("JsbClickComplianceEle", "type:" + strOptString);
        ContentRecord contentRecordM45224b = m45224b(context, str);
        int i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
        if (contentRecordM45224b != null) {
            AppInfo appInfoM41484af = contentRecordM45224b.m41484af();
            if (appInfoM41484af != null) {
                strOptString.hashCode();
                switch (strOptString) {
                    case "privacyUrl":
                        appInfoM41484af.showPrivacyPolicy(m45221a(context));
                        break;
                    case "permissionInWeb":
                        appInfoM41484af.showPermissionPageInWeb(m45221a(context));
                        break;
                    case "permissionUrl":
                        appInfoM41484af.showPermissionPage(m45221a(context));
                        break;
                    case "privacyInWeb":
                        appInfoM41484af.showPrivacyPolicyInWeb(m45221a(context));
                        break;
                    case "appDetailUrl":
                        C7302e c7302eM46699a = C7570pd.m46699a(context, contentRecordM45224b, true);
                        MaterialClickInfo materialClickInfo = (MaterialClickInfo) AbstractC7758be.m47739b(str, MaterialClickInfo.class, new Class[0]);
                        if (materialClickInfo != null && AbstractC7806cz.m48187p(materialClickInfo.m44508c()) && materialClickInfo.m44501a() != null) {
                            c7302eM46699a.m44605a(m45221a(context), materialClickInfo);
                            break;
                        } else {
                            c7302eM46699a.showAppDetailPage(m45221a(context));
                            break;
                        }
                        break;
                }
                i10 = 1000;
                AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, i10, null, true);
            }
            str2 = "appInfo not exist";
        } else {
            str2 = "ad not exist";
        }
        AbstractC7185ho.m43817a("JsbClickComplianceEle", str2);
        AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, i10, null, true);
    }
}
