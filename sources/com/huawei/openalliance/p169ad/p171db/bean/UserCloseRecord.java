package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes2.dex */
public class UserCloseRecord extends C7013a {
    public static final String TIME_STAMP = "timeStamp";
    private String time;
    private long timeStamp;

    /* renamed from: a */
    public void m41847a(long j10) {
        this.timeStamp = j10;
    }

    /* renamed from: a */
    public void m41848a(String str) {
        this.time = str;
    }
}
