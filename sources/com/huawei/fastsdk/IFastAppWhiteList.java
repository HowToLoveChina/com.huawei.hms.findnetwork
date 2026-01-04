package com.huawei.fastsdk;

import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IFastAppWhiteList {
    List<String> getAdBlockedH5QuickappList();

    List<String> getAgdAllowedRpks();

    Map<String, List<String>> getAppAllowList();

    String getCustomKeyString(String str);

    List<String> getCustomMenuList();

    List<String> getDeepLinkList();

    List<String> getFoldscreenQuickAppList();

    List<String> getHwQuickappList();
}
