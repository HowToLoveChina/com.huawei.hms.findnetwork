package com.huawei.hicloud.request.cbs.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class CBSInitParam {
    private String backupTimes;
    private int cycle;
    private String gradeCode;
    private int reminderCycle;
    private int times;
    private int nextBackupTime = 0;
    private int delayedStartTime = 10;
    private int breakedTime = 5;
    private List<CBSDataBackup> apkDataBackupList = new ArrayList();
    private List<CBSDataBackup> dataBackupList = new ArrayList();
    private List<CBSDataBackup> mediaLibBackup = new ArrayList();
    private List<CBSDataBackup> galleryLibBackup = new ArrayList();
    private Map<String, List<String>> appsWhiteList = new HashMap();
    private List<String> appsBlackList = new ArrayList();
    private List<CBSFilterModule> moduleBlackList = new ArrayList();

    public void addApkDataBackupList(CBSDataBackup cBSDataBackup) {
        this.apkDataBackupList.add(cBSDataBackup);
    }

    public void addAppsBlackList(String str) {
        this.appsBlackList.add(str);
    }

    public void addAppsWhiteList(String str, List<String> list) {
        this.appsWhiteList.put(str, list);
    }

    public void addDataBackupList(CBSDataBackup cBSDataBackup) {
        this.dataBackupList.add(cBSDataBackup);
    }

    public void addGalleryLibBackup(CBSDataBackup cBSDataBackup) {
        this.galleryLibBackup.add(cBSDataBackup);
    }

    public void addMediaLibBackup(CBSDataBackup cBSDataBackup) {
        this.mediaLibBackup.add(cBSDataBackup);
    }

    public void addModuleBlackList(CBSFilterModule cBSFilterModule) {
        this.moduleBlackList.add(cBSFilterModule);
    }

    public List<CBSDataBackup> getApkDataBackupList() {
        return this.apkDataBackupList;
    }

    public List<String> getAppsBlackList() {
        return this.appsBlackList;
    }

    public Map<String, List<String>> getAppsWhiteList() {
        return this.appsWhiteList;
    }

    public String getBackupTimes() {
        return this.backupTimes;
    }

    public int getBreakedTime() {
        return this.breakedTime;
    }

    public int getCycle() {
        return this.cycle;
    }

    public List<CBSDataBackup> getDataBackupList() {
        return this.dataBackupList;
    }

    public int getDelayedStartTime() {
        return this.delayedStartTime;
    }

    public List<CBSDataBackup> getGalleryLibBackup() {
        return this.galleryLibBackup;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public List<CBSDataBackup> getMediaLibBackup() {
        return this.mediaLibBackup;
    }

    public List<CBSFilterModule> getModuleBlackList() {
        return this.moduleBlackList;
    }

    public int getNextBackupTime() {
        return this.nextBackupTime;
    }

    public int getReminderCycle() {
        return this.reminderCycle;
    }

    public int getTimes() {
        return this.times;
    }

    public void setApkDataBackupList(List<CBSDataBackup> list) {
        this.apkDataBackupList = list;
    }

    public void setAppsBlackList(List<String> list) {
        this.appsBlackList = list;
    }

    public void setAppsWhiteList(Map<String, List<String>> map) {
        this.appsWhiteList = map;
    }

    public void setBackupTimes(String str) {
        this.backupTimes = str;
    }

    public void setBreakedTime(int i10) {
        this.breakedTime = i10;
    }

    public void setCycle(int i10) {
        this.cycle = i10;
    }

    public void setDataBackupList(List<CBSDataBackup> list) {
        this.dataBackupList = list;
    }

    public void setDelayedStartTime(int i10) {
        this.delayedStartTime = i10;
    }

    public void setGalleryLibBackup(List<CBSDataBackup> list) {
        this.galleryLibBackup = list;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setMediaLibBackup(List<CBSDataBackup> list) {
        this.mediaLibBackup = list;
    }

    public void setModuleBlackList(List<CBSFilterModule> list) {
        this.moduleBlackList = list;
    }

    public void setNextBackupTime(int i10) {
        this.nextBackupTime = i10;
    }

    public void setReminderCycle(int i10) {
        this.reminderCycle = i10;
    }

    public void setTimes(int i10) {
        this.times = i10;
    }
}
