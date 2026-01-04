package com.huawei.openalliance.p169ad.magazine.inter;

import android.content.Context;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.magazine.inter.listener.MagLockListener;
import com.huawei.openalliance.p169ad.processor.eventbeans.MagLockEventInfo;
import java.util.Set;

@OuterVisible
/* loaded from: classes2.dex */
public interface HiAdMagLock {

    @OuterVisible
    public static final class Builder {
        @OuterVisible
        public final HiAdMagLock build(Context context) {
            return new C7419a(context);
        }
    }

    void loadAds(String[] strArr, Set<String> set, boolean z10, MagLockListener magLockListener);

    void onNetworkConnected(Context context);

    void preloadAds(String[] strArr, Set<String> set, boolean z10, MagLockListener magLockListener);

    void reportEvent(Context context, String str, EventType eventType, MagLockEventInfo magLockEventInfo);
}
