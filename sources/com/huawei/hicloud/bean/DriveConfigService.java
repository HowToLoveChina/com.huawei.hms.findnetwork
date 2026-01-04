package com.huawei.hicloud.bean;

import android.graphics.drawable.Drawable;
import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class DriveConfigService implements Serializable {
    private static final long serialVersionUID = 7504741045141725272L;

    @SerializedName("appId")
    private String[] appId;

    @SerializedName("resource")
    private DriveConfigServiceResource driveConfigServiceResource;

    @SerializedName("icon")
    private String icon;
    private Drawable iconDrawable;
    private String iconPath;

    /* renamed from: id */
    @SerializedName("id")
    private String f22229id;

    @SerializedName("minSyncVersion")
    private int minSyncVersion;

    @SerializedName("name")
    private String name;

    @SerializedName("pkgNames")
    private String[] pkgNames;
    private DriveConfigQuotaCountData quotaCounts;

    @SerializedName("record")
    private boolean record;

    @SerializedName("recordIndex")
    private int recordIndex;
    private boolean showDivider;

    @SerializedName("signHash")
    private String[] signHash;

    @SerializedName(TemplateStyleRecord.STYLE)
    private String style;
    private String subPageIconPath;

    @SerializedName("sub_user")
    private boolean subUser;
    private boolean switchStatus;
    private String titleText;

    @SerializedName("version")
    private String version;

    public String[] getAppId() {
        return this.appId;
    }

    public DriveConfigServiceResource getDriveConfigServiceResource() {
        return this.driveConfigServiceResource;
    }

    public String getIcon() {
        return this.icon;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getId() {
        return this.f22229id;
    }

    public int getMinSyncVersion() {
        return this.minSyncVersion;
    }

    public String getName() {
        return this.name;
    }

    public String[] getPkgNames() {
        return this.pkgNames;
    }

    public DriveConfigQuotaCountData getQuotaCounts() {
        return this.quotaCounts;
    }

    public int getRecordIndex() {
        return this.recordIndex;
    }

    public String[] getSignHash() {
        return this.signHash;
    }

    public String getStyle() {
        return this.style;
    }

    public String getSubPageIconPath() {
        return this.subPageIconPath;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public String getVersion() {
        return this.version;
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

    public boolean isSwitchStatus() {
        return this.switchStatus;
    }

    public void setAppId(String[] strArr) {
        this.appId = strArr;
    }

    public void setDriveConfigServiceResource(DriveConfigServiceResource driveConfigServiceResource) {
        this.driveConfigServiceResource = driveConfigServiceResource;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public void setIconPath(String str) {
        this.iconPath = str;
    }

    public void setId(String str) {
        this.f22229id = str;
    }

    public void setMinSyncVersion(int i10) {
        this.minSyncVersion = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPkgNames(String[] strArr) {
        this.pkgNames = strArr;
    }

    public void setQuotaCounts(DriveConfigQuotaCountData driveConfigQuotaCountData) {
        this.quotaCounts = driveConfigQuotaCountData;
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

    public void setSignHash(String[] strArr) {
        this.signHash = strArr;
    }

    public void setStyle(String str) {
        this.style = str;
    }

    public void setSubPageIconPath(String str) {
        this.subPageIconPath = str;
    }

    public void setSubUser(boolean z10) {
        this.subUser = z10;
    }

    public void setSwitchStatus(boolean z10) {
        this.switchStatus = z10;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
