package com.huawei.fastsdk;

import android.content.res.Configuration;
import android.os.Bundle;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IFastSDKInstance {
    int bindData(String str);

    int bindData(Map<String, Object> map);

    void clearResource();

    void destroy();

    void evaluateExpression(String str);

    boolean onActivityBack();

    void onActivityConfigurationChanged(Configuration configuration);

    void onActivityCreate();

    void onActivityDestroy();

    void onActivityPause();

    void onActivityResume();

    void onActivityStart();

    void onActivityStop();

    void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);

    void onRoute(Object... objArr);

    void registerFastCardMessageToCard(IFastCardMessage iFastCardMessage);

    void registerFastCardMessageToHost(IFastCardMessage iFastCardMessage);

    void registerFastRenderListener(IFastRenderListener iFastRenderListener);

    void registerQuickCardListener(IQuickCardListener iQuickCardListener);

    void registerUiConfiguration(IUiConfiguration iUiConfiguration);

    void render(String str, String str2, Map<String, Object> map, String str3);

    int renderQuickCard(String str, Map<String, Object> map);

    void sendMessageToCard(String str);

    void setAccessType(String str);

    void setActivityDestroySync(boolean z10);

    void setBundleUrl(String str);

    void setPackageInfo(Bundle bundle);

    void setTrackComponent(boolean z10);
}
