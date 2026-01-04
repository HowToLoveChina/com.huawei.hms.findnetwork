package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.LimitQueue;
import com.huawei.hms.framework.common.Logger;

/* renamed from: com.huawei.hms.network.embedded.s4 */
/* loaded from: classes8.dex */
public class C6085s4 extends AbstractC6072r4<AbstractC6137w4, AbstractC6137w4> {

    /* renamed from: b */
    public static final String f28164b = "DetectInfoCache";

    /* renamed from: c */
    public static C6085s4 f28165c = new C6085s4();

    /* renamed from: a */
    public LimitQueue<AbstractC6137w4> f28166a = new LimitQueue<>(5, false);

    public static C6085s4 getInstance() {
        return f28165c;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    /* renamed from: a */
    public void updateCacheInfo(AbstractC6137w4 abstractC6137w4) {
        Logger.m32143v(f28164b, "DetectCache update :" + abstractC6137w4.toString());
        this.f28166a.remove(abstractC6137w4);
        this.f28166a.add(abstractC6137w4);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public AbstractC6137w4 getPeekLastInfo() {
        AbstractC6137w4 abstractC6137w4PeekLast = this.f28166a.peekLast();
        if (abstractC6137w4PeekLast == null) {
            return new C6124v4();
        }
        return Math.abs(System.currentTimeMillis() - abstractC6137w4PeekLast.mo35556b()) < 300000 ? abstractC6137w4PeekLast : new C6124v4();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public int obtainNetworkQuality(long j10, long j11) {
        AbstractC6137w4 peekLastInfo = getPeekLastInfo();
        if (peekLastInfo.mo35557b(1).mo35778c() == 204) {
            return 4;
        }
        return peekLastInfo.mo35557b(0).mo35778c() == 204 ? 5 : 0;
    }
}
