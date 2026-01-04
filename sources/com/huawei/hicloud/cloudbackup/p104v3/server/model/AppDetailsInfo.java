package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import android.text.TextUtils;
import com.huawei.fastengine.fastview.NavigationUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import p514o9.C11839m;
import p848zl.C14333b;

/* loaded from: classes6.dex */
public class AppDetailsInfo extends AppSizeInfo implements Serializable {
    public static final int DEFAULT_UI_STYLE = 0;
    public static final int DELETE_LOADING_UI_STYLE = 2;
    public static final int MULTIPLE_CHOICES_UI_STYLE = 1;
    public static final int REQUEST_DATA_DONE_STATUS = 1;
    public static final int REQUEST_DATA_FAIL_STATUS = -1;
    public static final int REQUEST_DATA_LOADING_STATUS = 0;
    private static final String TAG = "AppDetailsInfo";
    private static final long serialVersionUID = 1;
    private CopyOnWriteArrayList<AppDetailsInfo> childList;
    private int errorCode;
    private boolean isBasicItem;
    private boolean isCheck;
    private boolean isTemp;
    private boolean isVirtualApp;
    private String parentId;
    private int requestStatus = 0;
    private final List<AppDetailsInfo> twinAppsList = new ArrayList();
    private int uiStyle;

    private long computingSystemTotalSize() {
        if (!getBackupAppName().equals("baseData")) {
            return getTotalSize();
        }
        CopyOnWriteArrayList<AppDetailsInfo> childList = getChildList();
        if (childList == null || childList.isEmpty()) {
            return getTotalSize();
        }
        long j10 = 0;
        long j11 = 0;
        for (AppDetailsInfo appDetailsInfo : childList) {
            boolean zIsSystemData = appDetailsInfo.isSystemData(C14333b.m85482q());
            String backupAppName = appDetailsInfo.getBackupAppName();
            long appSize = appDetailsInfo.getAppSize();
            long totalSize = appDetailsInfo.getTotalSize();
            j10 += appSize;
            C11839m.m70688i(TAG, "computingSystemTotleSize appId = " + backupAppName + " appSize = " + appSize + " totalSize = " + totalSize + " contains = " + zIsSystemData);
            if (zIsSystemData) {
                j11 += totalSize;
            }
        }
        return j10 + j11;
    }

    private void updateOther(List<AppDetailsInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int i10 = 0;
        long totalSize = 0;
        int errorCode = 0;
        boolean z10 = false;
        for (AppDetailsInfo appDetailsInfo : list) {
            if (appDetailsInfo.isRequestDone()) {
                i10++;
            }
            if (appDetailsInfo.isRequestFail()) {
                errorCode = appDetailsInfo.getErrorCode();
                z10 = true;
            }
            totalSize += appDetailsInfo.getTotalSize();
        }
        C11839m.m70688i(TAG, "appNAME = " + getBackupAppName() + " updateOther ,countSize = " + size + " , updateSize = " + i10);
        if (size == i10 || isTemp()) {
            if (z10) {
                setErrorCode(errorCode);
                setRequestStatus(-1);
            } else {
                setRequestStatus(1);
            }
            if (getBackupAppName().equals("baseData")) {
                setTotalSize(computingSystemTotalSize());
            } else {
                setTotalSize(totalSize);
            }
        }
    }

    private void updateSmsOrSound() {
        CopyOnWriteArrayList<AppDetailsInfo> childList = getChildList();
        if (childList == null || childList.isEmpty()) {
            return;
        }
        if (childList.size() == 1) {
            childList.forEach(new Consumer() { // from class: com.huawei.hicloud.cloudbackup.v3.server.model.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f22598a.lambda$updateSmsOrSound$0((AppDetailsInfo) obj);
                }
            });
            return;
        }
        AppDetailsInfo appDetailsInfo = childList.get(0);
        AppDetailsInfo appDetailsInfo2 = childList.get(1);
        if (appDetailsInfo.isRequestDone() && appDetailsInfo2.isRequestDone()) {
            if (appDetailsInfo.isRequestFail()) {
                setErrorCode(appDetailsInfo.getErrorCode());
                setRequestStatus(-1);
            } else if (appDetailsInfo2.isRequestFail()) {
                setErrorCode(appDetailsInfo2.getErrorCode());
                setRequestStatus(-1);
            } else {
                setRequestStatus(1);
            }
            setTotalSize(appDetailsInfo.getTotalSize() + appDetailsInfo2.getTotalSize());
        }
    }

    public void copy(AppDetailsInfo appDetailsInfo) {
        if (appDetailsInfo == null) {
            return;
        }
        setBackupAppName(appDetailsInfo.getBackupAppName());
        setRequestStatus(appDetailsInfo.getRequestStatus());
        setUiStyle(appDetailsInfo.getUiStyle());
        setCheck(appDetailsInfo.isCheck());
        setAppSize(Long.valueOf(appDetailsInfo.getAppSize()));
        setTotalSize(appDetailsInfo.getTotalSize());
        setParentId(appDetailsInfo.getParentId());
        setVirtualApp(appDetailsInfo.isVirtualApp());
        setErrorCode(appDetailsInfo.getErrorCode());
        setProperties(appDetailsInfo.getProperties());
        setSplitApkType(appDetailsInfo.getSplitApkType());
        setOriBackupAppName(appDetailsInfo.getOriBackupAppName());
        setTwinAppsList(appDetailsInfo.getTwinAppsList());
        setBasicItem(appDetailsInfo.isBasicItem());
    }

    /* renamed from: copyForMerge, reason: merged with bridge method [inline-methods] */
    public void lambda$updateSmsOrSound$0(AppDetailsInfo appDetailsInfo) {
        if (appDetailsInfo == null) {
            return;
        }
        setRequestStatus(appDetailsInfo.getRequestStatus());
        setUiStyle(appDetailsInfo.getUiStyle());
        setCheck(appDetailsInfo.isCheck());
        setAppSize(Long.valueOf(appDetailsInfo.getAppSize()));
        setTotalSize(appDetailsInfo.getTotalSize());
        setParentId(appDetailsInfo.getParentId());
        setVirtualApp(appDetailsInfo.isVirtualApp());
        setErrorCode(appDetailsInfo.getErrorCode());
        setBasicItem(appDetailsInfo.isBasicItem());
    }

    public CopyOnWriteArrayList<AppDetailsInfo> getChildList() {
        return this.childList;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getPropertiesValue(String str) {
        Map<String, String> properties = getProperties();
        String str2 = properties != null ? properties.get(str) : "";
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public int getRequestStatus() {
        return this.requestStatus;
    }

    public List<AppDetailsInfo> getTwinAppsList() {
        return this.twinAppsList;
    }

    public int getUiStyle() {
        return this.uiStyle;
    }

    public boolean has3rdData() {
        Map<String, String> properties = getProperties();
        if (properties == null) {
            return false;
        }
        return String.valueOf(1).equals(properties.get("appwithdata"));
    }

    public boolean isBasicItem() {
        return this.isBasicItem;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public boolean isRequestDone() {
        int i10 = this.requestStatus;
        return i10 == -1 || i10 == 1;
    }

    public boolean isRequestFail() {
        return this.requestStatus == -1;
    }

    public boolean isRequestLoading() {
        return this.requestStatus == 0;
    }

    public boolean isSame(AppDetailsInfo appDetailsInfo) {
        if (appDetailsInfo != null && Objects.equals(getBackupAppName(), appDetailsInfo.getBackupAppName()) && Integer.valueOf(getRequestStatus()).equals(Integer.valueOf(appDetailsInfo.getRequestStatus())) && Integer.valueOf(getUiStyle()).equals(Integer.valueOf(appDetailsInfo.getUiStyle())) && Boolean.valueOf(isCheck()).equals(Boolean.valueOf(appDetailsInfo.isCheck())) && Long.valueOf(getAppSize()).equals(Long.valueOf(appDetailsInfo.getAppSize())) && Long.valueOf(getTotalSize()).equals(Long.valueOf(appDetailsInfo.getTotalSize())) && Objects.equals(getParentId(), appDetailsInfo.getParentId()) && Boolean.valueOf(isVirtualApp()).equals(Boolean.valueOf(appDetailsInfo.isVirtualApp())) && Boolean.valueOf(isBasicItem()).equals(Boolean.valueOf(appDetailsInfo.isBasicItem()))) {
            return Integer.valueOf(getErrorCode()).equals(Integer.valueOf(appDetailsInfo.getErrorCode()));
        }
        return false;
    }

    public boolean isTemp() {
        return this.isTemp;
    }

    public boolean isVirtualApp() {
        return this.isVirtualApp;
    }

    public void setBasicItem(boolean z10) {
        this.isBasicItem = z10;
    }

    public void setCheck(boolean z10) {
        this.isCheck = z10;
    }

    public void setChildList(CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList) {
        this.childList = copyOnWriteArrayList;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setRequestStatus(int i10) {
        this.requestStatus = i10;
    }

    public void setTemp(boolean z10) {
        this.isTemp = z10;
    }

    public void setTwinAppsList(List<AppDetailsInfo> list) {
        this.twinAppsList.clear();
        this.twinAppsList.addAll(list);
    }

    public void setUiStyle(int i10) {
        this.uiStyle = i10;
    }

    public void setVirtualApp(boolean z10) {
        this.isVirtualApp = z10;
    }

    @Override // ni.C11707b, java.util.AbstractMap
    public String toString() {
        return "AppDetailsInfo{getBackupAppName =" + getBackupAppName() + ", requestStatus=" + this.requestStatus + ", childList=" + this.childList + '}';
    }

    public void update(AppSizeInfo appSizeInfo) {
        if (appSizeInfo != null && TextUtils.equals(getBackupAppName(), appSizeInfo.getBackupAppName())) {
            setAppSize(Long.valueOf(appSizeInfo.getAppSize()));
            setTotalSize(appSizeInfo.getTotalSize());
            setRequestStatus(1);
        }
    }

    public void updateRequestFail(int i10) {
        setRequestStatus(-1);
        setErrorCode(i10);
    }

    public void update() {
        String backupAppName = getBackupAppName();
        if (!NavigationUtils.SMS_SCHEMA_PREF.equals(backupAppName) && !"soundrecorder".equals(backupAppName)) {
            updateOther(getChildList());
        } else {
            updateSmsOrSound();
        }
    }
}
