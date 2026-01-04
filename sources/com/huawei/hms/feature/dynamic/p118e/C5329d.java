package com.huawei.hms.feature.dynamic.p118e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;

/* renamed from: com.huawei.hms.feature.dynamic.e.d */
/* loaded from: classes8.dex */
public class C5329d implements DynamicModule.VersionPolicy {

    /* renamed from: a */
    public static final String f24711a = "d";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = f24711a;
        Logger.m30740i(str2, "The version of remote module " + str + ":" + remoteModuleInfo.getInt(InterfaceC5323b.f24684k));
        Logger.m30740i(str2, "The version of local module " + str + ":" + localModuleInfo.getInt(InterfaceC5323b.f24685l));
        if (remoteModuleInfo.getInt(InterfaceC5323b.f24684k) >= localModuleInfo.getInt(InterfaceC5323b.f24685l)) {
            Logger.m30740i(str2, "Choose remote module info.");
            return remoteModuleInfo;
        }
        Logger.m30740i(str2, "Choose local module info.");
        return localModuleInfo;
    }
}
