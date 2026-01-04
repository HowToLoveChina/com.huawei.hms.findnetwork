package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7607qi;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;

/* renamed from: com.huawei.openalliance.ad.sf */
/* loaded from: classes8.dex */
public class C7657sf implements C7607qi.a {

    /* renamed from: a */
    private EventRecord f35672a;

    public C7657sf(EventRecord eventRecord) {
        this.f35672a = eventRecord;
    }

    /* renamed from: b */
    private boolean m47221b(String str) {
        return "app".equals(str) || ClickDestination.HARMONY_APP.equals(str) || "download".equals(str);
    }

    @Override // com.huawei.openalliance.p169ad.C7607qi.a
    /* renamed from: a */
    public String mo47035a(String str) {
        if (TextUtils.isEmpty(str) || this.f35672a == null) {
            AbstractC7185ho.m43817a("appsFlyer", "invalid para");
            return str;
        }
        if (!EventType.CLICK.value().equals(this.f35672a.m41752j())) {
            AbstractC7185ho.m43818a("appsFlyer", "event type not match %s", this.f35672a.m41752j());
            return str;
        }
        String strM41724c = this.f35672a.m41724c();
        if (!m47221b(strM41724c)) {
            AbstractC7185ho.m43818a("appsFlyer", "click destination not match app or harmonyApp or download, is %s", strM41724c);
            return str;
        }
        if (str.indexOf("af_engagement_type") == -1) {
            AbstractC7185ho.m43817a("appsFlyer", "af key not exist");
            return str;
        }
        if (str.indexOf("click_to_store") != -1) {
            return str.replace("click_to_store", "click_to_download");
        }
        AbstractC7185ho.m43817a("appsFlyer", "af value replacement not exist");
        return str;
    }
}
