package com.huawei.fastsdk;

/* loaded from: classes5.dex */
public interface IFastAppPreferences {
    boolean getBooleanByProvider(String str, boolean z10);

    Long getLongByProvider(String str, Long l10);

    String getStringByProvider(String str, String str2);

    void putBooleanByProvider(String str, boolean z10);

    void putLongByProvider(String str, Long l10);

    void putStringByProvider(String str, String str2);
}
