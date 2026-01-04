package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.RewardKeys;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;

/* renamed from: com.huawei.openalliance.ad.bp */
/* loaded from: classes8.dex */
public class C6972bp {

    /* renamed from: a */
    private Context f32030a;

    public C6972bp(Context context) {
        this.f32030a = context;
    }

    /* renamed from: a */
    private void m41057a(Context context, EventRecord eventRecord, ContentRecord contentRecord) {
        if (contentRecord == null || eventRecord == null) {
            return;
        }
        String strM41752j = eventRecord.m41752j();
        eventRecord.m41729d(contentRecord.m41552f());
        eventRecord.m41700a(contentRecord.m41395G());
        eventRecord.m41730d(AbstractC7741ao.m47566c());
        eventRecord.m41731d(contentRecord.m41577k());
        eventRecord.m41857a(contentRecord.m41859br());
        eventRecord.m41749i(contentRecord.m41492an());
        eventRecord.m41788y(contentRecord.m41486ah());
        eventRecord.m41786x(contentRecord.m41588n());
        eventRecord.m41738f(contentRecord.m41460aL());
        eventRecord.m41765n(contentRecord.m41472aX());
        eventRecord.m41745h(contentRecord.m41581l());
        String strM41520bg = contentRecord.m41520bg();
        if (TextUtils.isEmpty(strM41520bg)) {
            strM41520bg = context.getPackageName();
        }
        eventRecord.m41674F(strM41520bg);
        if (EventType.SHOW.value().equals(strM41752j) || EventType.SUPPLEMENTIMP.value().equals(strM41752j)) {
            eventRecord.m41784w(contentRecord.m41494ap());
            eventRecord.m41772q(contentRecord.m41504az());
        }
        if (EventType.VIDEOTIME.value().equals(strM41752j)) {
            eventRecord.m41742g(contentRecord.m41519bf());
        }
    }

    /* renamed from: a */
    public void m41058a(Bundle bundle, ContentRecord contentRecord, InterfaceC7615qq interfaceC7615qq) {
        if (bundle == null || contentRecord == null || interfaceC7615qq == null) {
            AbstractC7185ho.m43820b("EventRecordUitl", "param or ad is null");
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        String strM43588d = c7154gk.m43588d("eventType");
        if (TextUtils.isEmpty(strM43588d)) {
            AbstractC7185ho.m43820b("EventRecordUitl", "eventType is null");
            return;
        }
        String strM43588d2 = c7154gk.m43588d(RewardKeys.EVENT_RECORD);
        boolean zM43581a = c7154gk.m43581a("is_report_now", false);
        boolean zM43581a2 = c7154gk.m43581a("is_check_discard", false);
        EventRecord eventRecord = (EventRecord) AbstractC7758be.m47739b(strM43588d2, EventRecord.class, new Class[0]);
        if (eventRecord == null) {
            AbstractC7185ho.m43820b("EventRecordUitl", "eventRecord is null");
        } else {
            eventRecord.m41727c(strM43588d);
            m41059a(eventRecord, contentRecord, zM43581a, zM43581a2, interfaceC7615qq);
        }
    }

    /* renamed from: a */
    public void m41059a(EventRecord eventRecord, ContentRecord contentRecord, boolean z10, boolean z11, InterfaceC7615qq interfaceC7615qq) {
        if (eventRecord == null || contentRecord == null || interfaceC7615qq == null) {
            AbstractC7185ho.m43820b("EventRecordUitl", "params is null");
            return;
        }
        m41057a(this.f32030a, eventRecord, contentRecord);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EventRecordUitl", "reportEvent, eventRecord: %s", AbstractC7758be.m47742b(eventRecord));
        }
        AbstractC7185ho.m43821b("EventRecordUitl", "start report event, eventType: %s", eventRecord.m41752j());
        interfaceC7615qq.mo46591a(eventRecord, z10, z11);
    }
}
