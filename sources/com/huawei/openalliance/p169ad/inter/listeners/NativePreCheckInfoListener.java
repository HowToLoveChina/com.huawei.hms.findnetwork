package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public interface NativePreCheckInfoListener {
    void onPreCheck(List<IPreCheckInfo> list);
}
