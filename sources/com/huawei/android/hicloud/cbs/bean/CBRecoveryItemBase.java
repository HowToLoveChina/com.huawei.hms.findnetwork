package com.huawei.android.hicloud.cbs.bean;

/* loaded from: classes2.dex */
public interface CBRecoveryItemBase {
    long getBackupEndTime();

    String getBackupId();

    String getDevDisplayName();

    String getDeviceIdd();

    String getDeviceName();

    int getDeviceType();

    long getSize();

    String getTerminalType();

    boolean isCurrent();

    void setBackupEndTime(long j10);

    void setBackupId(String str);

    void setCurrent(boolean z10);

    void setDevDisplayName(String str);

    void setDeviceIdd(String str);

    void setDeviceName(String str);

    void setDeviceType(int i10);

    void setSize(long j10);

    void setTerminalType(String str);
}
