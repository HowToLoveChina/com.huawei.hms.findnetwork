package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ac */
/* loaded from: classes8.dex */
public class C6853ac extends C8251z {

    /* renamed from: com.huawei.openalliance.ad.ac$a */
    public static class a implements IRewardAdStatusListener {

        /* renamed from: a */
        RewardItem f31621a;

        /* renamed from: b */
        private String f31622b;

        /* renamed from: c */
        private RemoteCallResultCallback<String> f31623c;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, RewardItem rewardItem) {
            this.f31621a = rewardItem;
            this.f31623c = remoteCallResultCallback;
            this.f31622b = str;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdClicked() {
            AbstractC7326j.m45215a(this.f31623c, this.f31622b, 1000, new JsbCallBackData(null, false, "reward.cb.click"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdClosed() {
            AbstractC7326j.m45215a(this.f31623c, this.f31622b, 1000, new JsbCallBackData(null, true, "reward.cb.close"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdCompleted() {
            AbstractC7326j.m45215a(this.f31623c, this.f31622b, 1000, new JsbCallBackData(null, false, "reward.cb.completed"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdError(int i10, int i11) {
            AbstractC7326j.m45215a(this.f31623c, this.f31622b, 1000, new JsbCallBackData(null, false, "reward.cb.error"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdShown() {
            AbstractC7326j.m45215a(this.f31623c, this.f31622b, 1000, new JsbCallBackData(null, false, "reward.cb.show"));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onRewarded() {
            AbstractC7326j.m45215a(this.f31623c, this.f31622b, 1000, new JsbCallBackData(this.f31621a, false, "reward.cb.reward"));
        }
    }

    public C6853ac() {
        super("pps.activity.reward");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("JsbStartRewardAdActivity", "paramContent: %s", str);
        }
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b == null) {
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
            return;
        }
        AbstractC7185ho.m43821b("JsbStartRewardAdActivity", "show reward ad: %s, apiVer: %s", contentRecordM45224b.m41588n(), Integer.valueOf(contentRecordM45224b.m41464aP()));
        C7305h c7305hM46794a = C7580pn.m46794a(context, contentRecordM45224b);
        if (c7305hM46794a == null) {
            AbstractC7185ho.m43817a("JsbStartRewardAdActivity", "reward is null, start activity failed");
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(JsbMapKeyNames.H5_CUSTOM_DATA);
            String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_USER_ID);
            boolean zOptBoolean = jSONObject.optBoolean("muted", true);
            boolean zOptBoolean2 = jSONObject.optBoolean(JsbMapKeyNames.H5_REWARD_DATA_ALERTS, true);
            int iOptInt = jSONObject.optInt("audioFocusType", 1);
            if (!TextUtils.isEmpty(strOptString)) {
                c7305hM46794a.setCustomData(strOptString);
            }
            if (!TextUtils.isEmpty(strOptString2)) {
                c7305hM46794a.setUserId(strOptString2);
            }
            if (iOptInt == 1 || iOptInt == 2 || iOptInt == 0) {
                c7305hM46794a.setAudioFocusType(iOptInt);
            }
            c7305hM46794a.setMute(zOptBoolean);
            c7305hM46794a.setMobileDataAlertSwitch(zOptBoolean2);
        } catch (Throwable unused) {
            AbstractC7185ho.m43817a("JsbStartRewardAdActivity", "content parse error");
        }
        c7305hM46794a.m44945a(new a(remoteCallResultCallback, this.f34112a, c7305hM46794a.getRewardItem()));
        C6980bx.m41143a(m45221a(context), c7305hM46794a);
        m45225b(remoteCallResultCallback, false);
    }
}
