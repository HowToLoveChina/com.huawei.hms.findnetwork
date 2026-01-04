package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;

@DataKeep
/* loaded from: classes2.dex */
public class EventMonitorRecord extends C7013a {
    public static final String ADD_TIME = "addTime";
    public static final String AD_TYPE = "adType";
    public static final String EVENT_ID = "eventId";

    @InterfaceC6933e
    private String _id;
    private int adType = -1;
    private long addTime;
    private String eventId;

    /* renamed from: a */
    public String m41660a() {
        return this.eventId;
    }

    /* renamed from: a */
    public void m41661a(int i10) {
        this.adType = i10;
    }

    /* renamed from: a */
    public void m41662a(long j10) {
        this.addTime = j10;
    }

    /* renamed from: a */
    public void m41663a(String str) {
        this.eventId = str;
    }
}
