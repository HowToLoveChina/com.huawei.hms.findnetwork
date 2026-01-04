package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7705u;
import com.huawei.openalliance.p169ad.C7854v;
import com.huawei.openalliance.p169ad.C8232x;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.AdContentResponseParser;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.s */
/* loaded from: classes8.dex */
public class C7651s extends AbstractC7326j {
    public C7651s() {
        super("pps.api.parse.ad");
    }

    /* renamed from: a */
    private AdContentResponseParser m47161a(Context context, RemoteCallResultCallback<String> remoteCallResultCallback, Integer[] numArr, String str, int i10) {
        AdContentResponseParser.Builder builder = new AdContentResponseParser.Builder(context);
        builder.enableDirectReturnVideoAd(true);
        if (m47162a(numArr, 3)) {
            builder.setNativeAdListener(new C7854v.a(context, remoteCallResultCallback, this.f34112a, 3, i10));
        } else if (m47162a(numArr, 9)) {
            builder.setIconAdListener(new C7854v.a(context, remoteCallResultCallback, this.f34112a, 9, i10));
        } else if (m47162a(numArr, 13)) {
            builder.setSearchAdListener(new C7854v.a(context, remoteCallResultCallback, this.f34112a, 13, i10));
        } else if (m47162a(numArr, 7)) {
            builder.setRewardAdListener(new C8232x.a(context, remoteCallResultCallback, this.f34112a));
        } else if (m47162a(numArr, 12)) {
            builder.m43994a(new C7705u.a(context, remoteCallResultCallback, this.f34112a));
        }
        return builder.build();
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String str2;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("JsbParseApiAd", "param content: %s", str);
        }
        JSONObject jSONObject = new JSONObject(str);
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.JSSDK_VER, 2);
        Integer[] numArrM48166b = AbstractC7806cz.m48166b(jSONObject.optJSONArray(JsbMapKeyNames.H5_AD_TYPES));
        String strOptString = jSONObject.optString(JsbMapKeyNames.H5_API_RSP);
        if (AbstractC7760bg.m47769a(numArrM48166b)) {
            str2 = "adType is empty";
        } else {
            if (!TextUtils.isEmpty(strOptString)) {
                AbstractC7185ho.m43820b("JsbParseApiAd", "parse api response.");
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("JsbParseApiAd", "rsp: %s", strOptString);
                }
                AdContentResponseParser adContentResponseParserM47161a = m47161a(context, remoteCallResultCallback, numArrM48166b, strOptString, iOptInt);
                if (m47162a(numArrM48166b, 13)) {
                    adContentResponseParserM47161a.processAdResponse(strOptString, true);
                    return;
                } else {
                    adContentResponseParserM47161a.processAdResponse(strOptString);
                    return;
                }
            }
            str2 = "rsp is empty";
        }
        AbstractC7185ho.m43823c("JsbParseApiAd", str2);
        m45222a(remoteCallResultCallback, true);
    }

    /* renamed from: a */
    private boolean m47162a(Integer[] numArr, int i10) {
        if (AbstractC7760bg.m47769a(numArr)) {
            return false;
        }
        for (Integer num : numArr) {
            if (num.intValue() == i10) {
                return true;
            }
        }
        return false;
    }
}
