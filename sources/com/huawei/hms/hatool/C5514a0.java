package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hiar.ARImageMetadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.a0 */
/* loaded from: classes8.dex */
public class C5514a0 implements InterfaceRunnableC5531g {

    /* renamed from: a */
    private Context f25136a = AbstractC5562q0.m32718i();

    /* renamed from: b */
    private String f25137b;

    /* renamed from: c */
    private JSONObject f25138c;

    /* renamed from: d */
    private String f25139d;

    /* renamed from: e */
    private String f25140e;

    /* renamed from: f */
    private String f25141f;

    /* renamed from: g */
    private String f25142g;

    /* renamed from: h */
    private Boolean f25143h;

    public C5514a0(String str, JSONObject jSONObject, String str2, String str3, long j10) {
        this.f25137b = str;
        this.f25138c = jSONObject;
        this.f25139d = str2;
        this.f25140e = str3;
        this.f25141f = String.valueOf(j10);
        if (AbstractC5579z.m32836i(str2, "oper")) {
            C5559p0 c5559p0M32824a = C5577y.m32822a().m32824a(str2, j10);
            this.f25142g = c5559p0M32824a.m32687a();
            this.f25143h = Boolean.valueOf(c5559p0M32824a.m32689b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        C5571v.m32786a("hmsSdk", "Begin to run EventRecordTask...");
        int iM32716h = AbstractC5562q0.m32716h();
        int iM32436k = AbstractC5515a1.m32436k(this.f25139d, this.f25140e);
        if (C5520c0.m32466a(this.f25136a, "stat_v2_1", iM32716h * ARImageMetadata.SHADING_MODE)) {
            C5571v.m32792c("hmsSdk", "stat sp file reach max limited size, delete it");
            C5522d.m32478a(this.f25136a, "stat_v2_1", new String[0]);
            return;
        }
        C5518b1 c5518b1 = new C5518b1();
        c5518b1.m32455b(this.f25137b);
        c5518b1.m32452a(this.f25138c.toString());
        c5518b1.m32459d(this.f25140e);
        c5518b1.m32457c(this.f25141f);
        c5518b1.m32461f(this.f25142g);
        Boolean bool = this.f25143h;
        c5518b1.m32460e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject jSONObjectM32458d = c5518b1.m32458d();
            String strM32660a = AbstractC5554n1.m32660a(this.f25139d, this.f25140e);
            String strM32476a = C5522d.m32476a(this.f25136a, "stat_v2_1", strM32660a, "");
            try {
                jSONArray = !TextUtils.isEmpty(strM32476a) ? new JSONArray(strM32476a) : new JSONArray();
            } catch (JSONException unused) {
                C5571v.m32794d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(jSONObjectM32458d);
            C5522d.m32481b(this.f25136a, "stat_v2_1", strM32660a, jSONArray.toString());
            if (jSONArray.toString().length() > iM32436k * 1024) {
                C5525e.m32484a().m32491a(this.f25139d, this.f25140e);
            }
        } catch (JSONException unused2) {
            C5571v.m32796e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
