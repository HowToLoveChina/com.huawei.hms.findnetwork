package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class LongPubHashKey {

    /* renamed from: pj */
    private int f24738pj;
    private String pubKeyHash;

    public LongPubHashKey(String str, int i10) {
        this.pubKeyHash = str;
        this.f24738pj = i10;
    }

    public int getPj() {
        return this.f24738pj;
    }

    public String getPubKeyHash() {
        return this.pubKeyHash;
    }

    public void setPj(int i10) {
        this.f24738pj = i10;
    }

    public void setPubKeyHash(String str) {
        this.pubKeyHash = str;
    }
}
