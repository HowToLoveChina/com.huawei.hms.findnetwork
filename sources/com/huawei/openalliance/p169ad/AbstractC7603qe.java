package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.EventType;

/* renamed from: com.huawei.openalliance.ad.qe */
/* loaded from: classes8.dex */
public abstract class AbstractC7603qe {
    /* renamed from: a */
    private static int m47017a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        for (EventType eventType : EventType.values()) {
            if (TextUtils.equals(eventType.value(), str)) {
                return eventType.getCategory();
            }
        }
        return 3;
    }

    /* renamed from: a */
    public static InterfaceC7604qf m47018a(Context context, InterfaceC7671st interfaceC7671st, int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? new C7606qh(context, interfaceC7671st) : new C7600qb(context, interfaceC7671st) : new C7602qd(context, interfaceC7671st) : new C7605qg(context, interfaceC7671st);
    }

    /* renamed from: a */
    public static InterfaceC7604qf m47019a(Context context, InterfaceC7671st interfaceC7671st, EventType eventType) {
        return m47018a(context, interfaceC7671st, eventType.getCategory());
    }

    /* renamed from: a */
    public static InterfaceC7604qf m47020a(Context context, InterfaceC7671st interfaceC7671st, String str) {
        return m47018a(context, interfaceC7671st, m47017a(str));
    }
}
