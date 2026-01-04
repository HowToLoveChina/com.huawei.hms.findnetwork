package com.huawei.openalliance.p169ad.beans.metadata;

import android.util.Pair;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;

@DataKeep
/* loaded from: classes8.dex */
public class CellInfo {

    @InterfaceC6929a
    private String mcc;

    @InterfaceC6929a
    private String mnc;

    @InterfaceC6929a
    private int networkType;

    /* renamed from: a */
    public String m39876a() {
        return this.mcc;
    }

    /* renamed from: b */
    public String m39878b() {
        return this.mnc;
    }

    /* renamed from: c */
    public int m39879c() {
        return this.networkType;
    }

    /* renamed from: a */
    public void m39877a(Pair<Integer, Pair<String, String>> pair) {
        if (pair == null) {
            return;
        }
        Object obj = pair.first;
        if (obj != null) {
            this.networkType = ((Integer) obj).intValue();
        }
        Pair pair2 = (Pair) pair.second;
        if (pair2 != null) {
            this.mcc = (String) pair2.first;
            this.mnc = (String) pair2.second;
        }
    }
}
