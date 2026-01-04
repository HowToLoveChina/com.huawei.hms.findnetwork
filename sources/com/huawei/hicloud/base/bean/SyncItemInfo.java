package com.huawei.hicloud.base.bean;

import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class SyncItemInfo {
    private boolean checkedProgrammatically;
    private Drawable drawable;
    private boolean hasNotePadHistoryData;
    private boolean hideLoading;
    private boolean hideTip;
    private String iconPath;

    /* renamed from: id */
    private String f22142id;
    private boolean isChecked;
    private boolean isDiskItem;
    private boolean isDriveConfig;
    private boolean isShowSwitch;
    private boolean isSyncConfig;
    private String itemStatus;
    private String linkClickText;
    private boolean noSubTitle;
    private boolean onClick;
    private boolean showDivider;
    private boolean showLoading;
    private boolean showStatusLayout;
    private boolean showSubTitle;
    private boolean showSwitchLayout;
    private String statusText;
    private String subStringText;
    private String subTitleLoadingText;
    private String subTitleSpanClickText;
    private String subTitleText;
    private boolean subUser;
    private boolean switchStatus;
    private int syncItemSubtitleStatus;
    private String title;
    private int visible = 0;
    private boolean isSubUserDisable = false;

    public SyncItemInfo() {
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getId() {
        return this.f22142id;
    }

    public Drawable getImage() {
        return this.drawable;
    }

    public String getItemStatus() {
        return this.itemStatus;
    }

    public String getLinkClickText() {
        return this.linkClickText;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public String getSubStringText() {
        return this.subStringText;
    }

    public String getSubTitleLoadingText() {
        return this.subTitleLoadingText;
    }

    public String getSubTitleSpanClickText() {
        return this.subTitleSpanClickText;
    }

    public String getSubTitleText() {
        return this.subTitleText;
    }

    public int getSyncItemSubtitleStatus() {
        return this.syncItemSubtitleStatus;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVisible() {
        int i10 = this.visible;
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 8) {
            return 8;
        }
        return i10 == 4 ? 4 : 0;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isCheckedProgrammatically() {
        return this.checkedProgrammatically;
    }

    public boolean isDiskItem() {
        return this.isDiskItem;
    }

    public boolean isDriveConfig() {
        return this.isDriveConfig;
    }

    public boolean isHasNotePadHistoryData() {
        return this.hasNotePadHistoryData;
    }

    public boolean isHideLoading() {
        return this.hideLoading;
    }

    public boolean isHideTip() {
        return this.hideTip;
    }

    public boolean isNoSubTitle() {
        return this.noSubTitle;
    }

    public boolean isOnClick() {
        return this.onClick;
    }

    public boolean isShowDivider() {
        return this.showDivider;
    }

    public boolean isShowLoading() {
        return this.showLoading;
    }

    public boolean isShowStatusLayout() {
        return this.showStatusLayout;
    }

    public boolean isShowSubTitle() {
        return this.showSubTitle;
    }

    public boolean isShowSwitch() {
        return this.isShowSwitch;
    }

    public boolean isShowSwitchLayout() {
        return this.showSwitchLayout;
    }

    public boolean isSubUser() {
        return this.subUser;
    }

    public boolean isSubUserDisable() {
        return this.isSubUserDisable;
    }

    public boolean isSwitchStatus() {
        return this.switchStatus;
    }

    public boolean isSyncConfig() {
        return this.isSyncConfig;
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setCheckedProgrammatically(boolean z10) {
        this.checkedProgrammatically = z10;
    }

    public void setDiskItem(boolean z10) {
        this.isDiskItem = z10;
    }

    public void setDriveConfig(boolean z10) {
        this.isDriveConfig = z10;
    }

    public void setHasNotePadHistoryData(boolean z10) {
        this.hasNotePadHistoryData = z10;
    }

    public void setHideLoading(boolean z10) {
        this.hideLoading = z10;
        this.showLoading = !z10;
    }

    public void setHideTip(boolean z10) {
        this.hideTip = z10;
    }

    public void setIconPath(String str) {
        this.iconPath = str;
    }

    public void setId(String str) {
        this.f22142id = str;
    }

    public void setImage(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setItemStatus(String str) {
        this.itemStatus = str;
    }

    public void setLinkClickText(String str) {
        this.linkClickText = str;
    }

    public void setNoSubTitle(boolean z10) {
        this.noSubTitle = z10;
        this.showSubTitle = !z10;
    }

    public void setOnClick(boolean z10) {
        this.onClick = z10;
    }

    public void setShowDivider(boolean z10) {
        this.showDivider = z10;
    }

    public void setShowLoading(boolean z10) {
        this.showLoading = z10;
        this.hideLoading = !z10;
    }

    public void setShowStatusLayout(boolean z10) {
        this.showStatusLayout = z10;
        this.showSwitchLayout = !z10;
    }

    public void setShowSubTitle(boolean z10) {
        this.showSubTitle = z10;
        this.noSubTitle = !z10;
    }

    public void setShowSwitch(boolean z10) {
        this.isShowSwitch = z10;
        this.showSwitchLayout = z10;
    }

    public void setShowSwitchLayout(boolean z10) {
        this.showSwitchLayout = z10;
        this.showStatusLayout = !z10;
    }

    public void setStatusText(String str) {
        this.statusText = str;
    }

    public void setSubStringText(String str) {
        this.subStringText = str;
    }

    public void setSubTitleLoadingText(String str) {
        this.subTitleLoadingText = str;
        this.subTitleText = "";
        this.subTitleSpanClickText = "";
    }

    public void setSubTitleSpanClickText(String str) {
        this.subTitleSpanClickText = str;
        this.subTitleLoadingText = "";
        this.subTitleText = "";
    }

    public void setSubTitleText(String str) {
        this.subTitleText = str;
        this.subTitleLoadingText = "";
        this.subTitleSpanClickText = "";
    }

    public void setSubUser(boolean z10) {
        this.subUser = z10;
    }

    public void setSubUserDisable(boolean z10) {
        this.isSubUserDisable = z10;
    }

    public void setSwitchStatus(boolean z10) {
        this.switchStatus = z10;
    }

    public void setSyncConfig(boolean z10) {
        this.isSyncConfig = z10;
    }

    public void setSyncItemSubtitleStatus(int i10) {
        this.syncItemSubtitleStatus = i10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVisible(int i10) {
        this.visible = i10;
    }

    public SyncItemInfo(String str) {
        this.title = str;
    }
}
