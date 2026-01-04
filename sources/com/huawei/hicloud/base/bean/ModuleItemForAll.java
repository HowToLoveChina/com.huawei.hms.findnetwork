package com.huawei.hicloud.base.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class ModuleItemForAll {
    List<ModuleItem> mCallLogItems;
    List<ModuleItem> mPhonemanagerItems;
    List<ModuleItem> mRecordingItems;
    List<ModuleItem> mSmsItems;

    public List<ModuleItem> getCallLogItems() {
        return this.mCallLogItems;
    }

    public List<ModuleItem> getPhonemanagerItems() {
        return this.mPhonemanagerItems;
    }

    public List<ModuleItem> getRecordingItems() {
        return this.mRecordingItems;
    }

    public List<ModuleItem> getSmsItems() {
        return this.mSmsItems;
    }

    public boolean hasCallLogData() {
        List<ModuleItem> list = this.mCallLogItems;
        return list != null && list.size() > 0;
    }

    public boolean hasPhoneManagerData() {
        List<ModuleItem> list = this.mPhonemanagerItems;
        return list != null && list.size() > 0;
    }

    public boolean hasRecordingData() {
        List<ModuleItem> list = this.mRecordingItems;
        return list != null && list.size() > 0;
    }

    public boolean hasSmsData() {
        List<ModuleItem> list = this.mSmsItems;
        return list != null && list.size() > 0;
    }

    public void setCallLogItems(List<ModuleItem> list) {
        this.mCallLogItems = list;
    }

    public void setPhonemanagerItems(List<ModuleItem> list) {
        this.mPhonemanagerItems = list;
    }

    public void setRecordingItems(List<ModuleItem> list) {
        this.mRecordingItems = list;
    }

    public void setSmsItems(List<ModuleItem> list) {
        this.mSmsItems = list;
    }
}
