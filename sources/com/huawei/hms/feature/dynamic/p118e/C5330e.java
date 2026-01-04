package com.huawei.hms.feature.dynamic.p118e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;

/* renamed from: com.huawei.hms.feature.dynamic.e.e */
/* loaded from: classes8.dex */
public class C5330e implements DynamicModule.VersionPolicy {

    /* renamed from: a */
    public static final String f24712a = "e";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt(InterfaceC5323b.f24684k) > 0) {
            Logger.m30740i(f24712a, "Prefer remote: The version of remote module " + str + ":" + remoteModuleInfo.getInt(InterfaceC5323b.f24684k));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt(InterfaceC5323b.f24685l) <= 0) {
            Logger.m30740i(f24712a, "Cannot get module info in remote or local.");
            return new Bundle();
        }
        Logger.m30740i(f24712a, "Choose local: The version of local module " + str + ":" + localModuleInfo.getInt(InterfaceC5323b.f24685l));
        return localModuleInfo;
    }
}
