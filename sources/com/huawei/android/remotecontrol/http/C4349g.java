package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.remotecontrol.registration.QueryActiveInfo;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p520of.C11860j;
import p521og.C11881n;
import p577qg.C12354d;
import p611rf.C12505m;
import p664u0.C13108a;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.http.g */
/* loaded from: classes4.dex */
public class C4349g implements Handler.Callback {

    /* renamed from: a */
    public final int f19845a;

    /* renamed from: b */
    public final Context f19846b;

    /* renamed from: c */
    public final Consumer<QueryActiveInfo> f19847c;

    public C4349g(Context context, int i10, Consumer<QueryActiveInfo> consumer) {
        this.f19845a = i10;
        this.f19846b = context;
        this.f19847c = consumer;
    }

    /* renamed from: a */
    public void m26249a(Message message) throws IllegalAccessException, JSONException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83987d("QueryActiveHttpCallBack", "processQueryActiveResponse");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (200 != iM1685c) {
            C13981a.m83989i("QueryActiveHttpCallBack", "processQueryActiveResponse ConnectFail:" + iM1685c);
            Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_ERROR");
            intent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, iM1685c);
            C13108a.m78878b(this.f19846b).m78881d(intent);
            return;
        }
        String string = message.getData().getString("response_info");
        C13981a.m83987d("QueryActiveHttpCallBack", "processQueryActiveResponse:" + string);
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("QueryActiveHttpCallBack", "report code = " + iM26233d);
        if (iM26233d == 0 || 3001 == iM26233d) {
            m26250b(string);
            return;
        }
        if (401 == iM26233d) {
            C13981a.m83989i("QueryActiveHttpCallBack", "updateDeviceTicket: queryActive");
            new C12505m().m75087f();
        } else if (14 == iM26233d) {
            Bundle bundle = new Bundle();
            bundle.putString(HwPayConstant.KEY_SITE_ID, C11881n.m71367q(string));
            C11860j.m71063j0(bundle);
        }
        Intent intent2 = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_ERROR");
        intent2.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, iM26233d);
        C13108a.m78878b(this.f19846b).m78881d(intent2);
    }

    /* renamed from: b */
    public final void m26250b(String str) throws IllegalAccessException, JSONException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        QueryActiveInfo queryActiveInfo = new QueryActiveInfo();
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("params")) {
                    C13981a.m83987d("QueryActiveHttpCallBack", "json has no params");
                    return;
                }
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("params");
                C13981a.m83987d("QueryActiveHttpCallBack", "jsonParams=" + jSONObject2);
                if (jSONObject2.getInt("active") == 0) {
                    C13981a.m83987d("QueryActiveHttpCallBack", "query result: device is not active");
                    C11860j.m71088v0(7);
                    C12354d.m74327C(jSONObject2, "proactive");
                    return;
                }
                QueryActiveInfo queryActiveInfo2 = (QueryActiveInfo) new Gson().fromJson(jSONObject2.toString(), QueryActiveInfo.class);
                try {
                    if (jSONObject2.has("accountInfo")) {
                        JSONObject jSONObject3 = (JSONObject) jSONObject2.get("accountInfo");
                        String string = jSONObject3.has("mobile") ? jSONObject3.getString("mobile") : "";
                        if (TextUtils.isEmpty(string) && jSONObject3.has("email")) {
                            string = jSONObject3.getString("email");
                        }
                        if (TextUtils.isEmpty(string) && jSONObject3.has("petalMail")) {
                            string = jSONObject3.getString("petalMail");
                        }
                        queryActiveInfo2.setAccountName(string);
                    }
                    Consumer<QueryActiveInfo> consumer = this.f19847c;
                    if (consumer != null) {
                        consumer.accept(queryActiveInfo2);
                    }
                } catch (JSONException unused) {
                    queryActiveInfo = queryActiveInfo2;
                    C13981a.m83988e("QueryActiveHttpCallBack", "handle MSG_QUERY_DEVICE_ACTIVE JSONException");
                    Consumer<QueryActiveInfo> consumer2 = this.f19847c;
                    if (consumer2 != null) {
                        consumer2.accept(queryActiveInfo);
                    }
                }
            } catch (JsonSyntaxException e10) {
                C13981a.m83988e("QueryActiveHttpCallBack", "processQueryActiveSuccess exception:" + e10.getMessage());
            }
        } catch (JSONException unused2) {
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws IllegalAccessException, JSONException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("QueryActiveHttpCallBack", "HttpCallback->handleMessage");
        if (this.f19845a != 3108) {
            return true;
        }
        m26249a(message);
        return true;
    }
}
