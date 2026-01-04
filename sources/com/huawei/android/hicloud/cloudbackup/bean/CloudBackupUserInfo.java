package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CloudBackupUserInfo {
    private String bakSourceStrategy;
    private CloudRecoveryItem currentLatestBackupRecord;
    private CloudRecoveryItem latestBackupRecord;
    private String uploadTargetStrategy;
    private long useSpace;
    private List<CloudRecoveryItem> userRecordItems = new ArrayList();
    private Map<String, CloudBackupDeviceInfo> deviceInfoMap = new HashMap();

    public String getBakSourceStrategy() {
        return this.bakSourceStrategy;
    }

    public CloudRecoveryItem getCurrentLatestBackupRecord() {
        return this.currentLatestBackupRecord;
    }

    public Map<String, CloudBackupDeviceInfo> getDeviceInfoMap() {
        return this.deviceInfoMap;
    }

    public CloudRecoveryItem getLatestBackupRecord() {
        return this.latestBackupRecord;
    }

    public String getUploadTargetStrategy() {
        return this.uploadTargetStrategy;
    }

    public long getUseSpace() {
        return this.useSpace;
    }

    public List<CloudRecoveryItem> getUserRecordItems() {
        return this.userRecordItems;
    }

    public void setBakSourceStrategy(String str) {
        this.bakSourceStrategy = str;
    }

    public void setCurrentLatestBackupRecord(CloudRecoveryItem cloudRecoveryItem) {
        this.currentLatestBackupRecord = cloudRecoveryItem;
    }

    public void setDeviceInfoMap(Map<String, CloudBackupDeviceInfo> map) {
        this.deviceInfoMap = map;
    }

    public void setLatestBackupRecord(CloudRecoveryItem cloudRecoveryItem) {
        this.latestBackupRecord = cloudRecoveryItem;
    }

    public void setUploadTargetStrategy(String str) {
        this.uploadTargetStrategy = str;
    }

    public void setUseSpace(long j10) {
        this.useSpace = j10;
    }

    public void setUserRecordItems(List<CloudRecoveryItem> list) {
        this.userRecordItems = list;
    }
}
