package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.z0 */
/* loaded from: classes8.dex */
public class C5580z0 {

    /* renamed from: a */
    private String f25328a;

    /* renamed from: b */
    public C5548l1 f25329b;

    public C5580z0(String str) {
        this.f25328a = str;
        this.f25329b = new C5548l1(str);
        C5565s.m32733c().m32737a(this.f25328a, this.f25329b);
    }

    /* renamed from: b */
    private C5566s0 m32839b(int i10) {
        if (i10 == 0) {
            return this.f25329b.m32631c();
        }
        if (i10 == 1) {
            return this.f25329b.m32629b();
        }
        if (i10 == 2) {
            return this.f25329b.m32632d();
        }
        if (i10 != 3) {
            return null;
        }
        return this.f25329b.m32626a();
    }

    /* renamed from: c */
    private boolean m32840c(int i10) {
        String str;
        if (i10 != 2) {
            C5566s0 c5566s0M32839b = m32839b(i10);
            if (c5566s0M32839b != null && !TextUtils.isEmpty(c5566s0M32839b.m32762h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i10;
        } else {
            if ("_default_config_tag".equals(this.f25328a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        C5571v.m32796e("hmsSdk", str);
        return false;
    }

    /* renamed from: a */
    public void m32841a(int i10) {
        C5571v.m32794d("hmsSdk", "onReport. TAG: " + this.f25328a + ", TYPE: " + i10);
        C5532g0.m32514a().m32518a(this.f25328a, i10);
    }

    /* renamed from: a */
    public void m32842a(int i10, String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        C5571v.m32794d("hmsSdk", "onEvent. TAG: " + this.f25328a + ", TYPE: " + i10 + ", eventId : " + str);
        if (C5527e1.m32504a(str) || !m32840c(i10)) {
            C5571v.m32796e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f25328a + ", TYPE: " + i10);
            return;
        }
        if (!C5527e1.m32507a(linkedHashMap)) {
            C5571v.m32796e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f25328a + ", TYPE: " + i10);
            linkedHashMap = null;
        }
        C5532g0.m32514a().m32519a(this.f25328a, i10, str, linkedHashMap);
    }

    /* renamed from: b */
    public void m32845b(int i10, String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        C5571v.m32794d("hmsSdk", "onStreamEvent. TAG: " + this.f25328a + ", TYPE: " + i10 + ", eventId : " + str);
        if (C5527e1.m32504a(str) || !m32840c(i10)) {
            C5571v.m32796e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f25328a + ", TYPE: " + i10);
            return;
        }
        if (!C5527e1.m32507a(linkedHashMap)) {
            C5571v.m32796e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f25328a + ", TYPE: " + i10);
            linkedHashMap = null;
        }
        C5532g0.m32514a().m32521b(this.f25328a, i10, str, linkedHashMap);
    }

    /* renamed from: a */
    public void m32843a(Context context, String str, String str2) throws JSONException {
        C5571v.m32794d("hmsSdk", "onEvent(context). TAG: " + this.f25328a + ", eventId : " + str);
        if (context == null) {
            C5571v.m32796e("hmsSdk", "context is null in onevent ");
            return;
        }
        if (C5527e1.m32504a(str) || !m32840c(0)) {
            C5571v.m32796e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f25328a);
            return;
        }
        if (!C5527e1.m32505a("value", str2, 65536)) {
            C5571v.m32796e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f25328a);
            str2 = "";
        }
        C5532g0.m32514a().m32520a(this.f25328a, context, str, str2);
    }

    /* renamed from: b */
    public void m32846b(C5566s0 c5566s0) {
        C5571v.m32786a("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f25328a);
        C5548l1 c5548l1 = this.f25329b;
        if (c5566s0 != null) {
            c5548l1.m32630b(c5566s0);
        } else {
            c5548l1.m32630b(null);
            C5571v.m32796e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }

    /* renamed from: a */
    public void m32844a(C5566s0 c5566s0) {
        C5548l1 c5548l1;
        C5571v.m32786a("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f25328a);
        if (c5566s0 == null) {
            C5571v.m32796e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            c5548l1 = this.f25329b;
            c5566s0 = null;
        } else {
            c5548l1 = this.f25329b;
        }
        c5548l1.m32628a(c5566s0);
    }
}
