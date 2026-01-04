package com.huawei.hicloud.cloudbackup.store.database.tags;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.model.AppBaseInfo;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class BackupOptionItem extends AppBaseInfo implements Comparable<BackupOptionItem> {
    private static final String TAG = "BackupOptionItem";
    private int appType;
    private boolean backupData;
    private boolean backupSwitch;
    private long codeBytes;
    private long dataBytes;
    private long increase1;
    private long increase2;
    private boolean isLoadDataSucceed;
    private int itemTotal;
    private long operateTime;
    private int operateType;
    private boolean preBackupSwitch;
    private int showType;
    private int switchCount;
    private int uid;
    private String appId = "";
    private String appName = "";
    private String parent = "";
    private boolean isDisable = false;
    private int isDataEnable = 0;
    private String oriBackupAppName = "";
    private String splitApkType = "";

    @Deprecated
    private String data1 = "";
    private String data2 = "";
    private String data3 = "";
    private String data4 = "";
    private String data5 = "";
    private String data6 = "";
    private final List<BackupOptionItem> twinAppsList = new ArrayList();
    private boolean isNotEnoughDialogShow = false;
    private boolean isAlmostFullDialogShow = false;

    public BackupOptionItem() {
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getAppId() {
        return TextUtils.isEmpty(this.appId) ? "" : this.appId;
    }

    public String getAppName() {
        return TextUtils.isEmpty(this.appName) ? "" : this.appName;
    }

    public int getAppType() {
        return this.appType;
    }

    public boolean getBackupSwitch() {
        return this.backupSwitch;
    }

    public long getCodeBytes() {
        return this.codeBytes;
    }

    public long getCurrentIncrease() {
        return this.increase2;
    }

    public String getData1() {
        return TextUtils.isEmpty(this.data1) ? "" : this.data1;
    }

    public String getData2() {
        return TextUtils.isEmpty(this.data2) ? "" : this.data2;
    }

    public String getData3() {
        return TextUtils.isEmpty(this.data3) ? "" : this.data3;
    }

    public String getData4() {
        return TextUtils.isEmpty(this.data4) ? "" : this.data4;
    }

    public String getData5() {
        return TextUtils.isEmpty(this.data5) ? "" : this.data5;
    }

    public String getData6() {
        return TextUtils.isEmpty(this.data6) ? "" : this.data6;
    }

    public long getDataBytes() {
        return this.dataBytes;
    }

    public int getIsDataEnable() {
        return this.isDataEnable;
    }

    public boolean getIsDisable() {
        return this.isDisable;
    }

    public int getItemTotal() {
        return this.itemTotal;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public String getOriBackupAppName() {
        if (!is3rdAppTwin()) {
            return getAppId();
        }
        String str = this.oriBackupAppName;
        return str == null ? "" : str;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.AppBaseInfo
    public String getPackageName() {
        return TextUtils.isEmpty(this.appId) ? "" : this.appId;
    }

    public String getParent() {
        return TextUtils.isEmpty(this.parent) ? "" : this.parent;
    }

    public boolean getPreBackupSwitch() {
        return this.preBackupSwitch;
    }

    public int getShowType() {
        return this.showType;
    }

    public String getSplitApkType() {
        String str = this.splitApkType;
        return str == null ? "" : str;
    }

    public int getSwitchCount() {
        return this.switchCount;
    }

    public long getTotalIncrease() {
        return this.increase1;
    }

    public List<BackupOptionItem> getTwinAppsList() {
        return this.twinAppsList;
    }

    public int getUid() {
        return this.uid;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean is3rdAppTwin() {
        return SplitAppUtil.isSplitApp(getSplitApkType());
    }

    public boolean isAlmostFullDialogShow() {
        return this.isAlmostFullDialogShow;
    }

    public boolean isBackupData() {
        return this.backupData;
    }

    public int isDataEnable() {
        return this.isDataEnable;
    }

    public boolean isDisable() {
        return this.isDisable;
    }

    public boolean isLoadDataSucceed() {
        return this.isLoadDataSucceed;
    }

    public boolean isModuleSplitExist() {
        try {
            SplitAppUtil.checkAppTwinStatus(getOriBackupAppName(), getUid());
            return true;
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "isModuleSplitExist: " + getAppId() + " e: " + e10);
            return false;
        }
    }

    public boolean isNotEnoughDialogShow() {
        return this.isNotEnoughDialogShow;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.AppBaseInfo
    public boolean isOmConfigAble() {
        return this.backupData;
    }

    public void setAlmostFullDialogShow(boolean z10) {
        this.isAlmostFullDialogShow = z10;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppType(int i10) {
        this.appType = i10;
    }

    public void setBackupData(boolean z10) {
        this.backupData = z10;
    }

    public void setBackupSwitch(boolean z10) {
        this.backupSwitch = z10;
    }

    public void setCodeBytes(long j10) {
        this.codeBytes = j10;
    }

    public void setCurrentIncrease(long j10) {
        this.increase2 = j10;
    }

    public void setData1(String str) {
        this.data1 = str;
    }

    public void setData2(String str) {
        this.data2 = str;
    }

    public void setData3(String str) {
        this.data3 = str;
    }

    public void setData4(String str) {
        this.data4 = str;
    }

    public void setData5(String str) {
        this.data5 = str;
    }

    public void setData6(String str) {
        this.data6 = str;
    }

    public void setDataBytes(long j10) {
        this.dataBytes = j10;
    }

    public void setDataEnable(int i10) {
        this.isDataEnable = i10;
    }

    public void setDisable(boolean z10) {
        this.isDisable = z10;
    }

    public void setIsDataEnable(int i10) {
        this.isDataEnable = i10;
    }

    public void setIsDisable(boolean z10) {
        this.isDisable = z10;
    }

    public void setItemTotal(int i10) {
        this.itemTotal = i10;
    }

    public void setLoadDataSucceed(boolean z10) {
        this.isLoadDataSucceed = z10;
    }

    public void setNotEnoughDialogShow(boolean z10) {
        this.isNotEnoughDialogShow = z10;
    }

    public void setOperateTime(long j10) {
        this.operateTime = j10;
    }

    public void setOperateType(int i10) {
        this.operateType = i10;
    }

    public void setOriBackupAppName(String str) {
        this.oriBackupAppName = str;
    }

    public void setParent(String str) {
        this.parent = str;
    }

    public void setPreBackupSwitch(boolean z10) {
        this.preBackupSwitch = z10;
    }

    public void setShowType(int i10) {
        this.showType = i10;
    }

    public void setSplitApkType(String str) {
        this.splitApkType = str;
    }

    public void setSwitchCount(int i10) {
        this.switchCount = i10;
    }

    public void setTotalIncrease(long j10) {
        this.increase1 = j10;
    }

    public void setTwinAppsList(List<BackupOptionItem> list) {
        this.twinAppsList.clear();
        this.twinAppsList.addAll(list);
    }

    public void setUid(int i10) {
        this.uid = i10;
    }

    public String toString() {
        return "BackupOptionItem{uid=" + this.uid + ", appId='" + this.appId + "', appName='" + this.appName + "', appType=" + this.appType + ", itemTotal=" + this.itemTotal + ", isLoadDataSucceed=" + this.isLoadDataSucceed + ", dataBytes=" + this.dataBytes + ", codeBytes=" + this.codeBytes + ", backupSwitch=" + this.backupSwitch + ", backupData=" + this.backupData + ", operateType=" + this.operateType + ", operateTime=" + this.operateTime + ", parent='" + this.parent + "', increase1=" + this.increase1 + ", increase2=" + this.increase2 + ", isDisable=" + this.isDisable + ", isDataEnable=" + this.isDataEnable + ", oriBackupAppName='" + this.oriBackupAppName + "', splitApkType='" + this.splitApkType + "', switchCount=" + this.switchCount + ", showType=" + this.showType + ", data1='" + this.data1 + "', data2='" + this.data2 + "', data3='" + this.data3 + "', data4='" + this.data4 + "', data5='" + this.data5 + "', data6='" + this.data6 + "'}";
    }

    @Override // java.lang.Comparable
    public int compareTo(BackupOptionItem backupOptionItem) {
        long dataBytes = this.dataBytes - backupOptionItem.getDataBytes();
        if (dataBytes < 0) {
            return 1;
        }
        return dataBytes > 0 ? -1 : 0;
    }

    public BackupOptionItem(String str) {
        setAppId(str);
    }

    public BackupOptionItem(String str, String str2) {
        setAppId(str);
        setParent(str2);
    }
}
