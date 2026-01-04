package com.huawei.hicloud.notification.p106db.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class RecommendNeedData implements Serializable {
    private static final long serialVersionUID = -2517438730301381670L;
    private int activityType;
    private String appId;
    private long backupNeedSpace;
    private int channelId;
    private String chooseOtherCaseText;
    private long currentPackageSpace;
    private List<NoticeDetailGoto> detailGotoBeanList;
    private int enterType;
    private long galleryNum;

    /* renamed from: id */
    private int f22658id;
    private boolean isActivityWithTaskCenter;
    private boolean isFormWithActivity;
    private boolean isV5BackupNotEnoughDialog;
    private boolean isWorryFreeExpire;
    private String mainText;
    private long notUsedSpace;
    private String recommendType;
    private String secondMainText;
    private String subTitle;
    private String title;
    private long totalNeedSpace;

    public int getActivityType() {
        return this.activityType;
    }

    public String getAppId() {
        return this.appId;
    }

    public long getBackupNeedSpace() {
        return this.backupNeedSpace;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public String getChooseOtherCaseText() {
        return this.chooseOtherCaseText;
    }

    public long getCurrentPackageSpace() {
        return this.currentPackageSpace;
    }

    public List<NoticeDetailGoto> getDetailGotoBeanList() {
        return this.detailGotoBeanList;
    }

    public int getEnterType() {
        return this.enterType;
    }

    public long getGalleryNum() {
        return this.galleryNum;
    }

    public int getId() {
        return this.f22658id;
    }

    public String getMainText() {
        return this.mainText;
    }

    public long getNotUsedSpace() {
        return this.notUsedSpace;
    }

    public String getRecommendType() {
        return this.recommendType;
    }

    public String getSecondMainText() {
        return this.secondMainText;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTotalNeedSpace() {
        return this.totalNeedSpace;
    }

    public boolean isActivityWithTaskCenter() {
        return this.isActivityWithTaskCenter;
    }

    public boolean isFormWithActivity() {
        return this.isFormWithActivity;
    }

    public boolean isV5BackupNotEnoughDialog() {
        return this.isV5BackupNotEnoughDialog;
    }

    public boolean isWorryFreeExpire() {
        return this.isWorryFreeExpire;
    }

    public void setActivityType(int i10) {
        this.activityType = i10;
    }

    public void setActivityWithTaskCenter(boolean z10) {
        this.isActivityWithTaskCenter = z10;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBackupNeedSpace(long j10) {
        this.backupNeedSpace = j10;
    }

    public void setChannelId(int i10) {
        this.channelId = i10;
    }

    public void setChooseOtherCaseText(String str) {
        this.chooseOtherCaseText = str;
    }

    public void setCurrentPackageSpace(long j10) {
        this.currentPackageSpace = j10;
    }

    public void setDetailGotoBeanList(List<NoticeDetailGoto> list) {
        this.detailGotoBeanList = list;
    }

    public void setEnterType(int i10) {
        this.enterType = i10;
    }

    public void setGalleryNum(long j10) {
        this.galleryNum = j10;
    }

    public void setId(int i10) {
        this.f22658id = i10;
    }

    public void setIsFormWithActivity(boolean z10) {
        this.isFormWithActivity = z10;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setNotUsedSpace(long j10) {
        this.notUsedSpace = j10;
    }

    public void setRecommendType(String str) {
        this.recommendType = str;
    }

    public void setSecondMainText(String str) {
        this.secondMainText = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalNeedSpace(long j10) {
        this.totalNeedSpace = j10;
    }

    public void setV5BackupNotEnoughDialog(boolean z10) {
        this.isV5BackupNotEnoughDialog = z10;
    }

    public void setWorryFreeExpire(boolean z10) {
        this.isWorryFreeExpire = z10;
    }

    public String toString() {
        return "RecommendNeedData{id=" + this.f22658id + ", title='" + this.title + "', subTitle='" + this.subTitle + "', mainText='" + this.mainText + "', secondMainText='" + this.secondMainText + "', chooseOtherCaseText='" + this.chooseOtherCaseText + "', backupNeedSpace=" + this.backupNeedSpace + ", notUsedSpace=" + this.notUsedSpace + ", totalNeedSpace=" + this.totalNeedSpace + ", currentPackageSpace=" + this.currentPackageSpace + ", recommendType='" + this.recommendType + "', galleryNum=" + this.galleryNum + ", isFormWithActivity=" + this.isFormWithActivity + ", enterType=" + this.enterType + ", activityType=" + this.activityType + ", isWorryFreeExpire=" + this.isWorryFreeExpire + ", isActivityWithTaskCenter=" + this.isActivityWithTaskCenter + ", isV5BackupNotEnoughDialog=" + this.isV5BackupNotEnoughDialog + ", channelId=" + this.channelId + ", appId='" + this.appId + "'}";
    }
}
