package com.huawei.hicloud.bean;

import android.graphics.drawable.Drawable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class SyncConfigService implements Serializable {
    private static final long serialVersionUID = -9057160474165488243L;

    @SerializedName("applicationIds")
    private String[] applications;

    @SerializedName("dataTypes")
    private SyncConfigServiceDataType[] dataTypes;
    private String databaseId;

    @SerializedName("fingerprints")
    private String[] fingerPrints;
    private boolean forceDelete;

    @SerializedName("icon")
    private String icon;
    private Drawable iconDrawable;

    @SerializedName("iconHash")
    private String iconHash;
    private String iconPath;

    /* renamed from: id */
    @SerializedName("id")
    private String f22234id;
    private String keyType;

    @SerializedName("minSyncVersion")
    private int minSyncVersion;

    @SerializedName("minSyncVersion_obs")
    private int minSyncVersionObs;

    @SerializedName("name")
    private String name;
    private String notifyType;

    @SerializedName("record")
    private boolean record;

    @SerializedName("recordIndex")
    private int recordIndex;
    private boolean showDivider;
    private String subStringText;

    @SerializedName("sub_user")
    private boolean subUser;

    @SerializedName("supportServer")
    private int supportServer;
    private boolean switchEnable = true;
    private boolean switchStatus;
    private int syncItemSubtitleStatus;
    private String titleText;

    @SerializedName("unstructedPath")
    private String unstructedPath;

    @SerializedName("unstructedPath_obs")
    private String unstructedPathObs;

    public String[] getApplications() {
        String[] strArr = this.applications;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public SyncConfigServiceDataType[] getDataTypes() {
        SyncConfigServiceDataType[] syncConfigServiceDataTypeArr = this.dataTypes;
        return syncConfigServiceDataTypeArr != null ? (SyncConfigServiceDataType[]) syncConfigServiceDataTypeArr.clone() : new SyncConfigServiceDataType[0];
    }

    public String getDatabaseId() {
        return this.databaseId;
    }

    public String[] getFingerPrints() {
        String[] strArr = this.fingerPrints;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public String getIcon() {
        return this.icon;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public String getIconHash() {
        return this.iconHash;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getId() {
        return this.f22234id;
    }

    public String getKeyType() {
        return this.keyType;
    }

    public int getMinSyncVersion() {
        return this.minSyncVersion;
    }

    public int getMinSyncVersionObs() {
        return this.minSyncVersionObs;
    }

    public String getName() {
        return this.name;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public int getRecordIndex() {
        return this.recordIndex;
    }

    public String getSubStringText() {
        return this.subStringText;
    }

    public int getSupportServer() {
        return this.supportServer;
    }

    public boolean getSwitchStatus() {
        return this.switchStatus;
    }

    public int getSyncItemSubtitleStatus() {
        return this.syncItemSubtitleStatus;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public String getUnstructedPath() {
        return this.unstructedPath;
    }

    public String getUnstructedPathObs() {
        return this.unstructedPathObs;
    }

    public boolean isForceDelete() {
        return this.forceDelete;
    }

    public boolean isRecord() {
        return this.record;
    }

    public boolean isShowDivider() {
        return this.showDivider;
    }

    public boolean isSubUser() {
        return this.subUser;
    }

    public boolean isSwitchEnable() {
        return this.switchEnable;
    }

    public void setApplications(String[] strArr) {
        if (strArr != null) {
            this.applications = (String[]) strArr.clone();
        } else {
            this.applications = null;
        }
    }

    public void setDataTypes(SyncConfigServiceDataType[] syncConfigServiceDataTypeArr) {
        if (syncConfigServiceDataTypeArr != null) {
            this.dataTypes = (SyncConfigServiceDataType[]) syncConfigServiceDataTypeArr.clone();
        } else {
            this.dataTypes = null;
        }
    }

    public void setDatabaseId(String str) {
        this.databaseId = str;
    }

    public void setFingerPrints(String[] strArr) {
        if (strArr != null) {
            this.fingerPrints = (String[]) strArr.clone();
        } else {
            this.fingerPrints = null;
        }
    }

    public void setForceDelete(boolean z10) {
        this.forceDelete = z10;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public void setIconHash(String str) {
        this.iconHash = str;
    }

    public void setIconPath(String str) {
        this.iconPath = str;
    }

    public void setId(String str) {
        this.f22234id = str;
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }

    public void setMinSyncVersion(int i10) {
        this.minSyncVersion = i10;
    }

    public void setMinSyncVersionObs(int i10) {
        this.minSyncVersionObs = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setRecord(boolean z10) {
        this.record = z10;
    }

    public void setRecordIndex(int i10) {
        this.recordIndex = i10;
    }

    public void setShowDivider(boolean z10) {
        this.showDivider = z10;
    }

    public void setSubStringText(String str) {
        this.subStringText = str;
    }

    public void setSubUser(boolean z10) {
        this.subUser = z10;
    }

    public void setSupportServer(int i10) {
        this.supportServer = i10;
    }

    public void setSwitchEnable(boolean z10) {
        this.switchEnable = z10;
    }

    public void setSwitchStatus(Boolean bool) {
        this.switchStatus = bool.booleanValue();
    }

    public void setSyncItemSubtitleStatus(int i10) {
        this.syncItemSubtitleStatus = i10;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void setUnstructedPath(String str) {
        this.unstructedPath = str;
    }

    public void setUnstructedPathObs(String str) {
        this.unstructedPathObs = str;
    }
}
