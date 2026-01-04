package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface ExtensionActionListener {
    void onClick(String str);

    void onDismiss(String str);

    void onFail(String str, int i10);

    void onPrepare(String str);

    void onShow(String str);
}
