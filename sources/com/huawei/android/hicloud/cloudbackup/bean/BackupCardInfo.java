package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.android.hicloud.cloudbackup.constant.BackupCardTaskOperation;
import com.huawei.android.hicloud.cloudbackup.util.BackupCardInfoTransferUtil;
import java.util.EnumSet;

/* loaded from: classes2.dex */
public class BackupCardInfo {
    private static final String TAG = "BackupCardInfo";
    private String baseFirstAppId;
    private int baseModuleCount;
    private String baseSecondAppId;
    private int errorCode;
    private String fullFirstAppId;
    private int fullModuleCount;
    private String fullSecondAppId;
    private boolean isBackupOpen;
    private boolean isBaseOpen;
    private boolean isBasicData;
    private boolean isHasSuccessDevice;
    private boolean isLoadingModule;
    private boolean isNewBmType;
    private long lastSuccessTime;
    private long nextBackupTime;
    private EnumSet<BackupCardTaskOperation> operations;
    private int state;
    private long waitBackupSize;

    public BackupCardViewData dataTransfer() {
        return BackupCardInfoTransferUtil.cardInfoToViewData(this);
    }

    public String getBaseFirstAppId() {
        return this.baseFirstAppId;
    }

    public int getBaseModuleCount() {
        return this.baseModuleCount;
    }

    public String getBaseSecondAppId() {
        return this.baseSecondAppId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFullFirstAppId() {
        return this.fullFirstAppId;
    }

    public int getFullModuleCount() {
        return this.fullModuleCount;
    }

    public String getFullSecondAppId() {
        return this.fullSecondAppId;
    }

    public Boolean getHasSuccessDevice() {
        return Boolean.valueOf(this.isHasSuccessDevice);
    }

    public long getLastSuccessTime() {
        return this.lastSuccessTime;
    }

    public long getNextBackupTime() {
        return this.nextBackupTime;
    }

    public EnumSet<BackupCardTaskOperation> getOperations() {
        return this.operations;
    }

    public int getState() {
        return this.state;
    }

    public long getWaitBackupSize() {
        return this.waitBackupSize;
    }

    public boolean hasSuccessDevice() {
        return Boolean.valueOf(this.isHasSuccessDevice).equals(Boolean.TRUE);
    }

    public boolean isBackupOpen() {
        return this.isBackupOpen;
    }

    public boolean isBaseOpen() {
        return this.isBaseOpen;
    }

    public boolean isBasicData() {
        return this.isBasicData;
    }

    public boolean isLoadingModule() {
        return this.isLoadingModule;
    }

    public boolean isNewBmType() {
        return this.isNewBmType;
    }

    public void setBackupOpen(boolean z10) {
        this.isBackupOpen = z10;
    }

    public void setBaseFirstAppId(String str) {
        this.baseFirstAppId = str;
    }

    public void setBaseModuleCount(int i10) {
        this.baseModuleCount = i10;
    }

    public void setBaseOpen(boolean z10) {
        this.isBaseOpen = z10;
    }

    public void setBaseSecondAppId(String str) {
        this.baseSecondAppId = str;
    }

    public void setBasicData(boolean z10) {
        this.isBasicData = z10;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setFullFirstAppId(String str) {
        this.fullFirstAppId = str;
    }

    public void setFullModuleCount(int i10) {
        this.fullModuleCount = i10;
    }

    public void setFullSecondAppId(String str) {
        this.fullSecondAppId = str;
    }

    public void setHasSuccessDevice(Boolean bool) {
        this.isHasSuccessDevice = bool.booleanValue();
    }

    public void setLastSuccessTime(long j10) {
        this.lastSuccessTime = j10;
    }

    public void setLoadingModule(boolean z10) {
        this.isLoadingModule = z10;
    }

    public void setNewBmType(boolean z10) {
        this.isNewBmType = z10;
    }

    public void setNextBackupTime(long j10) {
        this.nextBackupTime = j10;
    }

    public void setOperations(EnumSet<BackupCardTaskOperation> enumSet) {
        this.operations = enumSet;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setWaitBackupSize(long j10) {
        this.waitBackupSize = j10;
    }
}
