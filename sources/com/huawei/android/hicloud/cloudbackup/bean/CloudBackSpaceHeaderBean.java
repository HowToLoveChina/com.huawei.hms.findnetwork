package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudBackSpaceHeaderBean {
    public List<AppDetailsInfo> basicItemList;
    public boolean canBeReserveForever;
    public BackupDetailItem detailItem;
    public boolean isBackupSwitchOpen;
    public boolean isOnlyHarmonyNext;
    public boolean isOnlyRefurbish;
    public Integer occupySpaceType;
    public String terminalType;
    public String tips;
    public boolean isCurrentDeviceHasData = true;
    public boolean isTempBackup = false;
    public boolean isFromNotifyTemp = false;
    public boolean isDelete = false;
    public int expiratoryInDays = 7;
}
