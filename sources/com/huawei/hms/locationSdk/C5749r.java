package com.huawei.hms.locationSdk;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.locationSdk.r */
/* loaded from: classes8.dex */
public class C5749r {

    /* renamed from: a */
    private final int f25567a;

    /* renamed from: b */
    private final long f25568b;

    /* renamed from: c */
    private final List<C5755t> f25569c;

    public C5749r(int i10, long j10, List<C5755t> list) {
        this.f25567a = i10;
        this.f25568b = j10;
        this.f25569c = list;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("svCnt");
        sb2.append(":");
        sb2.append(this.f25567a);
        sb2.append(",");
        sb2.append("receiverTime");
        sb2.append(":");
        sb2.append(this.f25568b);
        sb2.append(",");
        sb2.append("gnssStatus");
        sb2.append(":[");
        List<C5755t> list = this.f25569c;
        if (list != null && list.size() != 0) {
            Iterator<C5755t> it = this.f25569c.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().toString());
                sb2.append(",");
            }
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append("]");
        return sb2.toString();
    }
}
