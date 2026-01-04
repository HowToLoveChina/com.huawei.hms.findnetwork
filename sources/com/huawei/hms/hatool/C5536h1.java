package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.h1 */
/* loaded from: classes8.dex */
public class C5536h1 implements InterfaceC5557o1 {

    /* renamed from: a */
    private List<C5518b1> f25204a;

    /* renamed from: b */
    private AbstractC5544k0 f25205b;

    /* renamed from: c */
    private AbstractC5568t0 f25206c;

    /* renamed from: d */
    private InterfaceC5557o1 f25207d;

    /* renamed from: e */
    private String f25208e = "";

    /* renamed from: f */
    private String f25209f;

    public C5536h1(String str) {
        this.f25209f = str;
    }

    @Override // com.huawei.hms.hatool.InterfaceC5557o1
    /* renamed from: a */
    public JSONObject mo32451a() throws JSONException {
        String str;
        List<C5518b1> list = this.f25204a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f25205b == null || this.f25206c == null || this.f25207d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f25205b.mo32451a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectMo32451a = this.f25207d.mo32451a();
            jSONObjectMo32451a.put(Event.EventConstants.PROPERTIES, this.f25206c.mo32451a());
            try {
                jSONObjectMo32451a.put("events_global_properties", new JSONObject(this.f25208e));
            } catch (JSONException unused) {
                jSONObjectMo32451a.put("events_global_properties", this.f25208e);
            }
            jSONObject2.put("events_common", jSONObjectMo32451a);
            JSONArray jSONArray = new JSONArray();
            Iterator<C5518b1> it = this.f25204a.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectMo32451a2 = it.next().mo32451a();
                if (jSONObjectMo32451a2 != null) {
                    jSONArray.put(jSONObjectMo32451a2);
                } else {
                    C5571v.m32796e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(Event.EventConstants.EVENTS, jSONArray);
            try {
                String strM32653a = C5552n.m32653a(C5545k1.m32613a(jSONObject2.toString().getBytes(Constants.UTF_8)), this.f25209f);
                if (TextUtils.isEmpty(strM32653a)) {
                    C5571v.m32796e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", strM32653a);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        C5571v.m32796e("hmsSdk", str);
        return null;
    }

    /* renamed from: a */
    public void m32564a(AbstractC5544k0 abstractC5544k0) {
        this.f25205b = abstractC5544k0;
    }

    /* renamed from: a */
    public void m32565a(C5546l c5546l) {
        this.f25207d = c5546l;
    }

    /* renamed from: a */
    public void m32566a(AbstractC5568t0 abstractC5568t0) {
        this.f25206c = abstractC5568t0;
    }

    /* renamed from: a */
    public void m32567a(String str) {
        if (str != null) {
            this.f25208e = str;
        }
    }

    /* renamed from: a */
    public void m32568a(List<C5518b1> list) {
        this.f25204a = list;
    }
}
