package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7607qi;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;

/* renamed from: com.huawei.openalliance.ad.sr */
/* loaded from: classes8.dex */
public class C7669sr implements C7607qi.a {

    /* renamed from: a */
    private EventRecord f35682a;

    public C7669sr(EventRecord eventRecord) {
        this.f35682a = eventRecord;
    }

    @Override // com.huawei.openalliance.p169ad.C7607qi.a
    /* renamed from: a */
    public String mo47035a(String str) {
        if (TextUtils.isEmpty(str) || this.f35682a == null) {
            AbstractC7185ho.m43817a("VideoEventStrategy", "invalid para");
            return str;
        }
        if (EventType.VIDEOTIME.value().equals(this.f35682a.m41752j())) {
            return (this.f35682a.m41713aj() == 0 || !str.contains("__HW_VIDEO_TIME__")) ? str : str.replace("__HW_VIDEO_TIME__", String.valueOf((int) Math.ceil(this.f35682a.m41713aj() / 1000.0d)));
        }
        AbstractC7185ho.m43818a("VideoEventStrategy", "event type not match playTime, is %s", this.f35682a.m41752j());
        return str;
    }
}
