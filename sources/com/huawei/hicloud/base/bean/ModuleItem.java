package com.huawei.hicloud.base.bean;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class ModuleItem {
    private String deviceId;
    private String deviceIdMD5;
    private int deviceType;
    private String displayName;
    private ArrayList<DownloadItem> downloadItems;
    private String moduleName;
    private String name;
    private int progress;
    private int num = 0;
    private long space = 0;
    private State state = State.NORMAL;
    private boolean isCurrent = false;
    private boolean isInTask = false;

    public enum State {
        NORMAL,
        WAITING,
        LOADING,
        CANCLE,
        DELETING,
        FAILED,
        DONE
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceIdMD5() {
        return this.deviceIdMD5;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ArrayList<DownloadItem> getDownloadItems() {
        return this.downloadItems;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String getName() {
        return this.name;
    }

    public int getNum() {
        return this.num;
    }

    public int getProgress() {
        return this.progress;
    }

    public long getSpace() {
        return this.space;
    }

    public State getState() {
        return this.state;
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public boolean isInTask() {
        return this.isInTask;
    }

    public void setCurrent(boolean z10) {
        this.isCurrent = z10;
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceIdMD5(String str) {
        this.deviceIdMD5 = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setDownloadItems(ArrayList<DownloadItem> arrayList) {
        this.downloadItems = arrayList;
    }

    public void setInTask(boolean z10) {
        this.isInTask = z10;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNum(int i10) {
        this.num = i10;
    }

    public void setProgress(int i10) {
        this.progress = i10;
    }

    public void setSpace(long j10) {
        this.space = j10;
    }

    public void setState(State state) {
        this.state = state;
    }
}
