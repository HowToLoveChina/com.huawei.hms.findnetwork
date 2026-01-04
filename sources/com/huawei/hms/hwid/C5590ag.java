package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hms.identity.AddressConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hwid.ag */
/* loaded from: classes8.dex */
public class C5590ag {

    /* renamed from: a */
    private Integer f25342a;

    /* renamed from: b */
    private String f25343b;

    /* renamed from: a */
    public Integer m32868a() {
        return this.f25342a;
    }

    /* renamed from: b */
    public String m32871b() {
        return this.f25343b;
    }

    /* renamed from: b */
    public static C5590ag m32867b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new C5590ag();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Integer numValueOf = jSONObject.has(AddressConstants.Extras.EXTRA_NAME_ERR_CODE) ? Integer.valueOf(jSONObject.getInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE)) : null;
            String string = jSONObject.has(C2126b.ERROR_MESSAGE_INFO) ? jSONObject.getString(C2126b.ERROR_MESSAGE_INFO) : null;
            C5590ag c5590ag = new C5590ag();
            c5590ag.m32869a(numValueOf);
            c5590ag.m32870a(string);
            return c5590ag;
        } catch (JSONException unused) {
            C5602as.m32912d("ReadSmsOutputBean", "ReadSmsOutputBean json parse falied", true);
            return new C5590ag();
        }
    }

    /* renamed from: a */
    public void m32869a(Integer num) {
        this.f25342a = num;
    }

    /* renamed from: a */
    public void m32870a(String str) {
        this.f25343b = str;
    }
}
