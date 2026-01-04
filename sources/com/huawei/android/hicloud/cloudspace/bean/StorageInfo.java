package com.huawei.android.hicloud.cloudspace.bean;

import java.util.ArrayList;
import java.util.List;
import p703v8.C13379p;

/* loaded from: classes2.dex */
public class StorageInfo {
    private long appSize;
    private BackupCacheInfo backupCacheInfo;
    private long cloudDriveSize;
    private CBSpaceDetail currentDeviceBackupDetails;
    private long diskUsedSize;
    private int disuseState;
    private long galleryDeleteSize;
    private long galleryUsedSize;
    private int leftDays;
    private long recycleSize;
    private TotalStorageInfo totalInfo;
    private long backupUsedSize = -1;
    private long usedSize = -1;
    private List<HDSpaceDetail> diskDetails = new ArrayList();
    private List<CBSpaceDetail> backupDetails = new ArrayList();
    private List<CBSpaceDetail> otherDeviceDetails = new ArrayList();
    private boolean enterSpaceDetailUseCache = false;

    public void clear() {
        this.galleryUsedSize = 0L;
        this.diskUsedSize = 0L;
        this.backupUsedSize = 0L;
        this.usedSize = 0L;
        this.cloudDriveSize = 0L;
        this.galleryDeleteSize = 0L;
        this.recycleSize = 0L;
        this.appSize = 0L;
        this.diskDetails.clear();
        this.backupDetails.clear();
        this.otherDeviceDetails.clear();
        this.currentDeviceBackupDetails = null;
        this.totalInfo = null;
        this.disuseState = 0;
        this.leftDays = 0;
    }

    public long getAppSize() {
        return this.appSize;
    }

    public BackupCacheInfo getBackupCacheInfo() {
        if (this.backupCacheInfo == null) {
            this.backupCacheInfo = C13379p.m80310f().m80314d();
        }
        return this.backupCacheInfo;
    }

    public List<CBSpaceDetail> getBackupDetails() {
        return this.backupDetails;
    }

    public long getBackupUsedSize() {
        return this.backupUsedSize;
    }

    public long getCloudDriveSize() {
        return this.cloudDriveSize;
    }

    public CBSpaceDetail getCurrentDeviceBackupDetails() {
        return this.currentDeviceBackupDetails;
    }

    public List<HDSpaceDetail> getDiskDetails() {
        return this.diskDetails;
    }

    public long getDiskUsedSize() {
        return this.diskUsedSize;
    }

    public int getDisuseState() {
        return this.disuseState;
    }

    public long getGalleryDeleteSize() {
        return this.galleryDeleteSize;
    }

    public long getGalleryUsedSize() {
        return this.galleryUsedSize;
    }

    public int getLeftDays() {
        return this.leftDays;
    }

    public List<CBSpaceDetail> getOtherDeviceDetails() {
        return this.otherDeviceDetails;
    }

    public long getRecycleSize() {
        return this.recycleSize;
    }

    public TotalStorageInfo getTotalInfo() {
        return this.totalInfo;
    }

    public long getUsedSize() {
        return this.usedSize;
    }

    public boolean isEnterSpaceDetailUseCache() {
        return this.enterSpaceDetailUseCache;
    }

    public void setAppSize(long j10) {
        this.appSize = j10;
    }

    public void setBackupCacheInfo(BackupCacheInfo backupCacheInfo) {
        this.backupCacheInfo = backupCacheInfo;
    }

    public void setBackupDetails(List<CBSpaceDetail> list) {
        this.backupDetails = list;
    }

    public void setBackupUsedSize(long j10) {
        this.backupUsedSize = j10;
    }

    public void setCloudDriveSize(long j10) {
        this.cloudDriveSize = j10;
    }

    public void setCurrentDeviceBackupDetails(CBSpaceDetail cBSpaceDetail) {
        this.currentDeviceBackupDetails = cBSpaceDetail;
    }

    public void setDiskDetails(List<HDSpaceDetail> list) {
        this.diskDetails = list;
    }

    public void setDiskUsedSize(long j10) {
        this.diskUsedSize = j10;
    }

    public void setDisuseState(int i10) {
        this.disuseState = i10;
    }

    public void setEnterSpaceDetailUseCache(boolean z10) {
        this.enterSpaceDetailUseCache = z10;
    }

    public void setGalleryDeleteSize(long j10) {
        this.galleryDeleteSize = j10;
    }

    public void setGalleryUsedSize(long j10) {
        this.galleryUsedSize = j10;
    }

    public void setLeftDays(int i10) {
        this.leftDays = i10;
    }

    public void setOtherDeviceDetails(List<CBSpaceDetail> list) {
        this.otherDeviceDetails = list;
    }

    public void setRecycleSize(long j10) {
        this.recycleSize = j10;
    }

    public void setTotalInfo(TotalStorageInfo totalStorageInfo) {
        this.totalInfo = totalStorageInfo;
    }

    public void setUsedSize(long j10) {
        this.usedSize = j10;
    }
}
