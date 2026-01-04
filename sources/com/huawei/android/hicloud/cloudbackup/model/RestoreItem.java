package com.huawei.android.hicloud.cloudbackup.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.fastengine.fastview.NavigationUtils;
import java.util.ArrayList;
import java.util.List;
import p848zl.C14333b;

/* loaded from: classes2.dex */
public class RestoreItem extends RestoreStatus {
    public static final Parcelable.Creator<RestoreItem> CREATOR = new Parcelable.Creator<RestoreItem>() { // from class: com.huawei.android.hicloud.cloudbackup.model.RestoreItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreItem createFromParcel(Parcel parcel) {
            RestoreItem restoreItem = new RestoreItem();
            restoreItem.setAppId(parcel.readString());
            restoreItem.setAppName(parcel.readString());
            restoreItem.setAppType(parcel.readInt());
            restoreItem.setAction(parcel.readInt());
            restoreItem.setStatus(parcel.readInt());
            restoreItem.setType(parcel.readInt());
            restoreItem.setCurrent(parcel.readInt());
            restoreItem.setCount(parcel.readInt());
            restoreItem.setSize(parcel.readLong());
            restoreItem.setAsize(parcel.readLong());
            restoreItem.childList = new ArrayList();
            parcel.readList(restoreItem.childList, getClass().getClassLoader());
            return restoreItem;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreItem[] newArray(int i10) {
            return new RestoreItem[i10];
        }
    };
    private List<RestoreItem> childList;

    public static class ModuleCount {
        int cancel;
        int download;
        int fail;
        int foregroundUnSupport;
        int pause;
        int restore;
        int success;
        int unsupported;
        int wait;

        private ModuleCount() {
            this.unsupported = 0;
            this.wait = 0;
            this.pause = 0;
            this.cancel = 0;
            this.restore = 0;
            this.success = 0;
            this.fail = 0;
            this.download = 0;
            this.foregroundUnSupport = 0;
        }
    }

    private int getSystemModuleCount(RestoreItem restoreItem) {
        if (restoreItem == null) {
            return 0;
        }
        if (isSystemShowModule() && restoreItem.isUnSupport()) {
            return 0;
        }
        return restoreItem.getCount();
    }

    private boolean is3rdAPP(RestoreItem restoreItem) {
        return "thirdApp".equals(restoreItem.getAppId());
    }

    private boolean isSms(String str) {
        return NavigationUtils.SMS_SCHEMA_PREF.equals(str) || "chatSms".equals(str);
    }

    private boolean isSmsOrSounds(RestoreItem restoreItem) {
        String appId = restoreItem.getAppId();
        return NavigationUtils.SMS_SCHEMA_PREF.equals(appId) || "soundrecorder".equals(appId);
    }

    private boolean isSounds(RestoreItem restoreItem) {
        String appId = restoreItem.getAppId();
        return "soundrecorder".equals(appId) || "callRecorder".equals(appId);
    }

    private void refreshModuleCount(RestoreItem restoreItem, RestoreItem restoreItem2, ModuleCount moduleCount) {
        int status = restoreItem2.getStatus();
        int type = restoreItem2.getType();
        switch (status) {
            case -8:
            case 8:
                if (type != 1) {
                    moduleCount.fail++;
                    break;
                } else {
                    moduleCount.success++;
                    break;
                }
            case -6:
            case -5:
            case -4:
            case -3:
            case -1:
                moduleCount.unsupported++;
                break;
            case -2:
                moduleCount.foregroundUnSupport++;
                break;
            case 0:
            case 3:
                moduleCount.wait++;
                break;
            case 1:
                moduleCount.cancel++;
                break;
            case 2:
                moduleCount.pause++;
                break;
            case 4:
            case 5:
            case 6:
                if (!isSounds(restoreItem2) && !isSms(restoreItem2.getAppId())) {
                    moduleCount.restore++;
                    break;
                } else {
                    moduleCount.download++;
                    break;
                }
                break;
            case 7:
                if (!is3rdAPP(restoreItem)) {
                    moduleCount.restore++;
                    break;
                } else {
                    moduleCount.success++;
                    break;
                }
        }
    }

    private void refreshModuleStatus(RestoreItem restoreItem, ModuleCount moduleCount, int i10) {
        int i11 = moduleCount.unsupported;
        if (i11 == i10) {
            restoreItem.setStatus(-1);
            return;
        }
        int i12 = i10 - i11;
        if (moduleCount.wait == i12) {
            restoreItem.setStatus(0);
            return;
        }
        if (moduleCount.pause == i12) {
            restoreItem.setStatus(2);
            return;
        }
        if (moduleCount.cancel > 0) {
            restoreItem.setStatus(1);
            return;
        }
        if (moduleCount.download > 0) {
            restoreItem.setStatus(4);
        } else if (moduleCount.restore > 0) {
            restoreItem.setStatus(7);
        } else {
            refreshModuleStatusOther(restoreItem, moduleCount, i10);
        }
    }

    private void refreshModuleStatusOther(RestoreItem restoreItem, ModuleCount moduleCount, int i10) {
        int i11;
        int i12;
        if (moduleCount.wait > 0) {
            restoreItem.setStatus(0);
            return;
        }
        if (moduleCount.pause > 0) {
            restoreItem.setStatus(2);
            return;
        }
        restoreItem.setStatus(8);
        if (restoreItem.isShowChildList()) {
            i11 = moduleCount.fail + moduleCount.cancel + moduleCount.unsupported;
            i12 = moduleCount.foregroundUnSupport;
        } else {
            i11 = moduleCount.fail;
            i12 = moduleCount.cancel;
        }
        restoreItem.setType(i11 + i12 > 0 ? 2 : 1);
        if (!isSmsOrSounds(restoreItem) || moduleCount.unsupported <= 0 || i10 <= 1) {
            return;
        }
        restoreItem.setStatus(8);
        restoreItem.setType(2);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public List<RestoreItem> getChildList() {
        return this.childList;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public boolean isSystemShowModule() {
        return C14333b.m85476k().contains(getAppId()) && !C14333b.m85482q().contains(getAppId());
    }

    public RestoreItem setChildList(List<RestoreItem> list) {
        this.childList = list;
        return this;
    }

    public void updateCount() {
        updateCount(this);
    }

    public void updateStatus() {
        updateStatus(this);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeList(this.childList);
    }

    private void updateCount(RestoreItem restoreItem) {
        long asize;
        List<RestoreItem> childList = restoreItem.getChildList();
        if (childList == null || childList.isEmpty()) {
            return;
        }
        int systemModuleCount = 0;
        long j10 = 0;
        long size = 0;
        for (RestoreItem restoreItem2 : childList) {
            updateCount(restoreItem2);
            int action = restoreItem2.getAction();
            if (action == 0) {
                systemModuleCount = restoreItem2.isSystemShowModule() ? systemModuleCount + getSystemModuleCount(restoreItem2) : systemModuleCount + 1;
                size += restoreItem2.getSize();
                asize = restoreItem2.getAsize();
            } else if (action == 1) {
                systemModuleCount = restoreItem2.isSystemShowModule() ? systemModuleCount + getSystemModuleCount(restoreItem2) : systemModuleCount + 1;
                size += restoreItem2.is3rdAppType() ? 0L : restoreItem2.getSize();
                asize = restoreItem2.getAsize();
            } else if (restoreItem2.isSystemShowModule()) {
                systemModuleCount += getSystemModuleCount(restoreItem2);
                size += restoreItem2.getSize();
                asize = restoreItem2.getAsize();
            }
            j10 += asize;
        }
        restoreItem.setCount(systemModuleCount);
        if (!"thirdAppData".equals(restoreItem.getAppId())) {
            restoreItem.setAsize(j10);
        }
        if ("thirdApp".equals(restoreItem.getAppId())) {
            return;
        }
        restoreItem.setSize(size);
    }

    private void updateStatus(RestoreItem restoreItem) {
        List<RestoreItem> childList = restoreItem.getChildList();
        if (childList == null || childList.isEmpty()) {
            return;
        }
        ModuleCount moduleCount = new ModuleCount();
        for (RestoreItem restoreItem2 : childList) {
            if (restoreItem2 != null) {
                updateStatus(restoreItem2);
                refreshModuleCount(restoreItem, restoreItem2, moduleCount);
            }
        }
        refreshModuleStatus(restoreItem, moduleCount, childList.size());
        if (restoreItem.isShowChildList()) {
            restoreItem.setCurrent(moduleCount.success);
            return;
        }
        int count = 0;
        int count2 = 0;
        for (RestoreItem restoreItem3 : childList) {
            if (restoreItem3 != null) {
                count += (restoreItem3.getType() == 1 && restoreItem3.getStatus() == 8) ? restoreItem3.getCount() : restoreItem3.getCurrent();
                count2 += restoreItem3.getCount();
            }
        }
        if (count > restoreItem.getCurrent()) {
            if (count >= count2) {
                count = count2;
            }
            restoreItem.setCurrent(count);
        }
        restoreItem.setCount(count2);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setAction(int i10) {
        return (RestoreItem) super.setAction(i10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setAppId(String str) {
        return (RestoreItem) super.setAppId(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setAppName(String str) {
        return (RestoreItem) super.setAppName(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setAppType(int i10) {
        return (RestoreItem) super.setAppType(i10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setAsize(long j10) {
        return (RestoreItem) super.setAsize(j10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setCount(int i10) {
        return (RestoreItem) super.setCount(i10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setCurrent(int i10) {
        return (RestoreItem) super.setCurrent(i10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setSize(long j10) {
        return (RestoreItem) super.setSize(j10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setStatus(int i10) {
        return (RestoreItem) super.setStatus(i10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.RestoreStatus
    public RestoreItem setType(int i10) {
        return (RestoreItem) super.setType(i10);
    }
}
