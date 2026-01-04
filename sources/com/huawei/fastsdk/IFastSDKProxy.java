package com.huawei.fastsdk;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IFastSDKProxy {
    void clearFrescoMemoryCache();

    IFastSDKInstance createFastSDKInstance(Context context);

    void destroy(boolean z10);

    ICardRepository getCardRepository();

    void init(Application application, ApplicationInfo applicationInfo, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z10, boolean z11);

    void init(Application application, String str, ArrayList<String> arrayList, ArrayList<String> arrayList2);

    void init(Application application, String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z10);

    void registerActions(Map<String, Class<? extends AbsQuickCardAction>> map);

    void setMaxFrescoMemoryCacheSize(int i10);

    void setRunMode(int i10);

    void setViewWidth(int i10);
}
