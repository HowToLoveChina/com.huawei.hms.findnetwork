package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ab */
/* loaded from: classes8.dex */
public class C6852ab extends C8251z {

    /* renamed from: com.huawei.openalliance.ad.ab$a */
    public static class a implements InterfaceC7311a {

        /* renamed from: a */
        private String f31619a;

        /* renamed from: b */
        private RemoteCallResultCallback<String> f31620b;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.f31620b = remoteCallResultCallback;
            this.f31619a = str;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: a */
        public void mo38577a() {
            AbstractC7326j.m45215a(this.f31620b, this.f31619a, 1000, new JsbCallBackData(null, false, "interstitial.cb.show"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: b */
        public void mo38579b() {
            AbstractC7326j.m45215a(this.f31620b, this.f31619a, 1000, new JsbCallBackData(null, false, "interstitial.cb.click"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: c */
        public void mo38580c() {
            AbstractC7326j.m45215a(this.f31620b, this.f31619a, 1000, new JsbCallBackData(null, false, "interstitial.cb.completed"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: d */
        public void mo38581d() {
            AbstractC7326j.m45215a(this.f31620b, this.f31619a, 1000, new JsbCallBackData(null, true, "interstitial.cb.close"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: e */
        public void mo38582e() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: f */
        public void mo38583f() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: a */
        public void mo38578a(int i10, int i11) {
            AbstractC7326j.m45215a(this.f31620b, this.f31619a, 200, new JsbCallBackData(Integer.valueOf(i10), false, "interstitial.cb.error"));
        }
    }

    public C6852ab() {
        super("pps.activity.interstitial");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b == null) {
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
            return;
        }
        C7301d c7301dM46654a = C7563ox.m46654a(context, contentRecordM45224b);
        if (c7301dM46654a == null) {
            AbstractC7185ho.m43820b("JsbStartInterstitialAdActivity", "ad is null, start activity failed");
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(JsbMapKeyNames.H5_CUSTOM_DATA);
            String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_USER_ID);
            boolean zOptBoolean = jSONObject.optBoolean("muted", true);
            boolean zOptBoolean2 = jSONObject.optBoolean(JsbMapKeyNames.H5_INTERSTITIAL_DATA_ALERTS, true);
            if (!TextUtils.isEmpty(strOptString)) {
                c7301dM46654a.setCustomData(strOptString);
            }
            if (!TextUtils.isEmpty(strOptString2)) {
                c7301dM46654a.setUserId(strOptString2);
            }
            c7301dM46654a.m44737f(zOptBoolean);
            c7301dM46654a.m44743h(zOptBoolean2);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("JsbStartInterstitialAdActivity", "content parse error");
        }
        c7301dM46654a.m44724a(new a(remoteCallResultCallback, this.f34112a));
        C6980bx.m41142a(m45221a(context), c7301dM46654a);
        m45225b(remoteCallResultCallback, false);
    }
}
