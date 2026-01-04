package com.huawei.hms.network.embedded;

import android.os.SystemClock;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PowerUtils;

/* renamed from: com.huawei.hms.network.embedded.u4 */
/* loaded from: classes8.dex */
public class C6111u4 extends AbstractC6072r4<InterfaceC5930g5, Boolean> {

    /* renamed from: a */
    public static final String f28504a = "SystemControlCache";

    /* renamed from: b */
    public static C6111u4 f28505b = new C6111u4();

    public static C6111u4 getInstance() {
        return f28505b;
    }

    /* renamed from: a */
    public C5917f5 m35503a(long j10) {
        C5917f5 c5917f5 = new C5917f5();
        c5917f5.m34223c(PowerUtils.isDozeIdleMode(ContextHolder.getResourceContext()));
        c5917f5.m34221b(PowerUtils.isAppIdleMode(ContextHolder.getResourceContext()));
        c5917f5.m34218a(PowerUtils.isWhilteList(ContextHolder.getResourceContext()));
        c5917f5.m34220b(PowerUtils.readPowerSaverMode(ContextHolder.getResourceContext()));
        c5917f5.m34216a(PowerUtils.readDataSaverMode(ContextHolder.getResourceContext()));
        c5917f5.m34217a(j10);
        return c5917f5;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public InterfaceC5930g5 getPeekLastInfo() {
        return m35503a(SystemClock.elapsedRealtime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public int obtainNetworkQuality(long j10, long j11) {
        Logger.m32143v(f28504a, "the data will not be update,and always default");
        return 0;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void updateCacheInfo(Boolean bool) {
        m35503a(SystemClock.elapsedRealtime());
    }
}
