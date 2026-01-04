package com.huawei.hms.feature.dynamic.p118e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;

/* renamed from: com.huawei.hms.feature.dynamic.e.c */
/* loaded from: classes8.dex */
public class C5328c implements DynamicModule.VersionPolicy {

    /* renamed from: a */
    public static final String f24710a = "c";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        DynamicModule.LoadingException loadingException;
        Bundle bundle;
        try {
            bundle = DynamicModule.getRemoteModuleInfo(context, str);
            loadingException = null;
        } catch (DynamicModule.LoadingException e10) {
            loadingException = e10.getBundle() != null ? new DynamicModule.LoadingException(e10.getMessage(), e10.getBundle()) : new DynamicModule.LoadingException(e10.getMessage());
            Logger.m30744w(f24710a, "Get remote module info failed: " + e10.getMessage() + ". try to query local.");
            bundle = new Bundle();
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = f24710a;
        Logger.m30740i(str2, "The version of remote module " + str + ":" + bundle.getInt(InterfaceC5323b.f24684k));
        Logger.m30740i(str2, "The version of local module " + str + ":" + localModuleInfo.getInt(InterfaceC5323b.f24685l));
        if (localModuleInfo.getInt(InterfaceC5323b.f24685l) > 0 && localModuleInfo.getInt(InterfaceC5323b.f24685l) >= bundle.getInt(InterfaceC5323b.f24684k)) {
            Logger.m30740i(str2, "Choose local module info.");
            return localModuleInfo;
        }
        if (loadingException != null && bundle.getInt(InterfaceC5323b.f24684k) == 0) {
            throw loadingException;
        }
        Logger.m30740i(str2, "Choose remote module info.");
        return bundle;
    }
}
