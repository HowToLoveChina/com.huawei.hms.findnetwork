package com.huawei.android.hicloud.cloudbackup.bean;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public class BackupCardViewData {
    private String content;
    private boolean isLoadingModule;
    private boolean isMainItemEnableClick;
    private boolean isShowArrow;
    private boolean isShowBackupDevice;
    private boolean isShowBasicBusinessTip;
    private boolean isShowContent;
    private boolean isShowSubTitle;
    private boolean isShowSubtitleTip;
    private boolean isShowSwitch;
    private boolean isSubtitleCarousel;
    private BiConsumer<Context, Boolean> mainItemClick;
    private String subTitle;
    private String subTitle2;
    private int subTitle2Color;
    private int subTitleColor;
    private boolean switchStatus;
    private String title;

    public String getContent() {
        return this.content;
    }

    public BiConsumer<Context, Boolean> getMainItemClick() {
        return this.mainItemClick;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getSubTitle2() {
        return this.subTitle2;
    }

    public int getSubTitle2Color() {
        return this.subTitle2Color;
    }

    public int getSubTitleColor() {
        return this.subTitleColor;
    }

    public Map<String, Integer> getSubTitleProperties() {
        HashMap map = new HashMap();
        map.put(getSubTitle(), Integer.valueOf(getSubTitleColor()));
        map.put(getSubTitle2(), Integer.valueOf(getSubTitle2Color()));
        return map;
    }

    public boolean getSwitchStatus() {
        return this.switchStatus;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isLoadingModule() {
        return this.isLoadingModule;
    }

    public boolean isMainItemEnableClick() {
        return this.isMainItemEnableClick;
    }

    public boolean isShowArrow() {
        return this.isShowArrow;
    }

    public boolean isShowBackupDevice() {
        return this.isShowBackupDevice;
    }

    public boolean isShowBasicBusinessTip() {
        return this.isShowBasicBusinessTip;
    }

    public boolean isShowContent() {
        return this.isShowContent;
    }

    public boolean isShowSubTitle() {
        return this.isShowSubTitle;
    }

    public boolean isShowSubtitleTip() {
        return this.isShowSubtitleTip;
    }

    public boolean isShowSwitch() {
        return this.isShowSwitch;
    }

    public boolean isSubtitleCarousel() {
        return this.isSubtitleCarousel;
    }

    public boolean isSwitchStatus() {
        return this.switchStatus;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLoadingModule(boolean z10) {
        this.isLoadingModule = z10;
    }

    public void setMainItemClick(BiConsumer<Context, Boolean> biConsumer) {
        this.mainItemClick = biConsumer;
    }

    public void setMainItemEnableClick(boolean z10) {
        this.isMainItemEnableClick = z10;
    }

    public void setShowArrow(boolean z10) {
        this.isShowArrow = z10;
    }

    public void setShowBackupDevice(boolean z10) {
        this.isShowBackupDevice = z10;
    }

    public void setShowBasicBusinessTip(boolean z10) {
        this.isShowBasicBusinessTip = z10;
    }

    public void setShowContent(boolean z10) {
        this.isShowContent = z10;
    }

    public void setShowSubTitle(boolean z10) {
        this.isShowSubTitle = z10;
    }

    public void setShowSubtitleTip(boolean z10) {
        this.isShowSubtitleTip = z10;
    }

    public void setShowSwitch(boolean z10) {
        this.isShowSwitch = z10;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setSubTitle2(String str) {
        this.subTitle2 = str;
    }

    public void setSubTitle2Color(int i10) {
        this.subTitle2Color = i10;
    }

    public void setSubTitleColor(int i10) {
        this.subTitleColor = i10;
    }

    public void setSubtitleCarousel(boolean z10) {
        this.isSubtitleCarousel = z10;
    }

    public void setSwitchStatus(boolean z10) {
        this.switchStatus = z10;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
