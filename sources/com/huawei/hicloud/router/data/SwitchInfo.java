package com.huawei.hicloud.router.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class SwitchInfo implements Parcelable {
    public static final Parcelable.Creator<SwitchInfo> CREATOR = new Parcelable.Creator<SwitchInfo>() { // from class: com.huawei.hicloud.router.data.SwitchInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SwitchInfo createFromParcel(Parcel parcel) {
            return new SwitchInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SwitchInfo[] newArray(int i10) {
            return new SwitchInfo[i10];
        }
    };
    private Bundle customAlbumSwitches;
    private boolean generalAlbumSwitch;
    private boolean shareAlbumSwitch;
    private boolean smartAlbumSwitch;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getCustomAlbumSwitches() {
        return this.customAlbumSwitches;
    }

    public boolean isCustomAlbumOn(String str) {
        return this.customAlbumSwitches.getBoolean(str, false);
    }

    public boolean isCustomSwitchOn(String str) {
        return this.customAlbumSwitches.getBoolean(str, false);
    }

    public boolean isGeneralAlbumOn() {
        return this.generalAlbumSwitch;
    }

    public boolean isShareAlbumOn() {
        return this.shareAlbumSwitch;
    }

    public boolean isSmartAlbumOn() {
        return this.smartAlbumSwitch;
    }

    public void readFromParcel(Parcel parcel) {
        this.generalAlbumSwitch = parcel.readByte() != 0;
        this.shareAlbumSwitch = parcel.readByte() != 0;
        this.smartAlbumSwitch = parcel.readByte() != 0;
        this.customAlbumSwitches = parcel.readBundle();
    }

    public void setCustomAlbumSwitchOn(String str, boolean z10) {
        this.customAlbumSwitches.putBoolean(str, z10);
    }

    public void setGeneralAlbumOn(boolean z10) {
        this.generalAlbumSwitch = z10;
    }

    public void setShareAlbumOn(boolean z10) {
        this.shareAlbumSwitch = z10;
    }

    public void setSmartAlbumOn(boolean z10) {
        this.smartAlbumSwitch = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.generalAlbumSwitch ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.shareAlbumSwitch ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.smartAlbumSwitch ? (byte) 1 : (byte) 0);
        parcel.writeBundle(this.customAlbumSwitches);
    }

    public SwitchInfo() {
        this.customAlbumSwitches = new Bundle();
    }

    private SwitchInfo(Parcel parcel) {
        this.customAlbumSwitches = new Bundle();
        readFromParcel(parcel);
    }
}
