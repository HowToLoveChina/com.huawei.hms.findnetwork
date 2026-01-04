package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.C5092a;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.AdContentRequestFactory;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.q */
/* loaded from: classes8.dex */
public class C7598q extends AbstractC7326j {

    /* renamed from: d */
    private Context f35446d;

    public C7598q() {
        super("pps.api.req.getbody");
    }

    /* renamed from: a */
    private String m46968a(String[] strArr, int i10, int i11, RequestOptions requestOptions, C5092a c5092a) {
        String strM43953a;
        if (AbstractC7760bg.m47769a(strArr) || -1 == i10) {
            AbstractC7185ho.m43820b("JsbGetApiReqBody", "get body without slotId and type.");
            strM43953a = AdContentRequestFactory.m43953a(this.f35446d, i11, requestOptions, c5092a);
        } else {
            AbstractC7185ho.m43820b("JsbGetApiReqBody", "get req body.");
            strM43953a = AdContentRequestFactory.m43954a(this.f35446d, strArr, i10, i11, requestOptions, c5092a, null);
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("JsbGetApiReqBody", "reqBody: %s", strM43953a);
        }
        return strM43953a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) throws JSONException {
        this.f35446d = context.getApplicationContext();
        AbstractC7185ho.m43820b("JsbGetApiReqBody", "get js api req body.");
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("JsbGetApiReqBody", str);
        }
        JSONObject jSONObject = new JSONObject(str);
        String[] strArrM48161a = AbstractC7806cz.m48161a(jSONObject.optJSONArray(JsbMapKeyNames.H5_SLOT_IDS));
        int iOptInt = jSONObject.optInt("adType", -1);
        int iOptInt2 = jSONObject.optInt(JsbMapKeyNames.H5_DEVICE_TYPE, 4);
        RequestOptions requestOptionsM45226c = m45226c(context, str);
        C5092a.a aVar = new C5092a.a();
        m46969a(jSONObject, str, aVar);
        String strM46968a = m46968a(strArrM48161a, iOptInt, iOptInt2, requestOptionsM45226c, aVar.m30385a());
        if (TextUtils.isEmpty(strM46968a)) {
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, 4001, null, true);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", strM46968a);
        jSONObject2.put("complete", true);
        jSONObject2.put("callBackName", (Object) null);
        AbstractC7185ho.m43820b("JsbGetApiReqBody", "notifyResultCallback by callBackJson.");
        AbstractC7326j.m45217a(remoteCallResultCallback, this.f34112a, 1000, jSONObject2);
    }

    /* renamed from: a */
    private void m46969a(JSONObject jSONObject, String str, C5092a.a aVar) {
        Integer numValueOf;
        String strOptString = jSONObject.optString(JsbMapKeyNames.CREATIVE_TYPES);
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.MEDIA_DIRECTION, -111111);
        int iOptInt2 = jSONObject.optInt(JsbMapKeyNames.MEDIA_ASPECT, -111111);
        int iOptInt3 = jSONObject.optInt(JsbMapKeyNames.AD_WIDTH, -111111);
        int iOptInt4 = jSONObject.optInt(JsbMapKeyNames.AD_HEIGHT, -111111);
        String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_MEDIA_CONTENT);
        if (!TextUtils.isEmpty(strOptString)) {
            List<Integer> listM48163b = AbstractC7806cz.m48163b(strOptString, ";");
            if (!AbstractC7760bg.m47767a(listM48163b)) {
                aVar.m30384a(listM48163b);
            }
        }
        if (iOptInt != -111111) {
            numValueOf = Integer.valueOf((iOptInt != 0 ? iOptInt != 1 ? iOptInt != 2 ? EnumC6969bm.UNKNOWN : EnumC6969bm.LAND : EnumC6969bm.PORTRAIT : EnumC6969bm.ANY).m41048a());
        } else {
            numValueOf = null;
        }
        if (iOptInt2 != -111111 && EnumC6969bm.ANY.m41049a(iOptInt2)) {
            numValueOf = Integer.valueOf(iOptInt2);
        }
        if (numValueOf != null) {
            aVar.m30382a(numValueOf.intValue() == EnumC6969bm.CUSTOM.m41048a() ? 0 : Integer.valueOf(numValueOf.intValue() + 2));
        }
        if (iOptInt4 != -111111 && iOptInt3 != -111111) {
            aVar.m30386b(Integer.valueOf(iOptInt3));
            aVar.m30387c(Integer.valueOf(iOptInt4));
        }
        try {
            aVar.m30381a(m45230g(str));
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("JsbGetApiReqBody", "get loc error.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            return;
        }
        aVar.m30383a(strOptString2);
    }
}
