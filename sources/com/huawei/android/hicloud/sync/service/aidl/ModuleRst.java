package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ModuleRst implements Parcelable {
    public static final Parcelable.Creator<ModuleRst> CREATOR = new Parcelable.Creator<ModuleRst>() { // from class: com.huawei.android.hicloud.sync.service.aidl.ModuleRst.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModuleRst createFromParcel(Parcel parcel) {
            return new ModuleRst(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModuleRst[] newArray(int i10) {
            return new ModuleRst[i10];
        }
    };
    private int cAddNum;
    private int cDeleteNum;
    private int cModifyNum;
    private String errorSource;
    private int failNum;
    private String failReason;
    private int lAddNum;
    private int lDeleteNum;
    private int lModifyNum;
    private String moduleName;
    private int nochangeNum;
    private int progress;
    private int retCode;
    private int returnCode;
    private int successNum;

    private int getlAddNum() {
        return this.lAddNum;
    }

    private int getlDeleteNum() {
        return this.lDeleteNum;
    }

    private int getlModifyNum() {
        return this.lModifyNum;
    }

    private void readFromParcel(Parcel parcel) {
        this.retCode = parcel.readInt();
        this.successNum = parcel.readInt();
        this.failNum = parcel.readInt();
        this.nochangeNum = parcel.readInt();
        this.moduleName = parcel.readString();
        this.lAddNum = parcel.readInt();
        this.lModifyNum = parcel.readInt();
        this.lDeleteNum = parcel.readInt();
        this.cAddNum = parcel.readInt();
        this.cModifyNum = parcel.readInt();
        this.cDeleteNum = parcel.readInt();
        this.returnCode = parcel.readInt();
        this.errorSource = parcel.readString();
        this.failReason = parcel.readString();
    }

    private void setcAddNum(int i10) {
        this.cAddNum = i10;
    }

    private void setcDeleteNum(int i10) {
        this.cDeleteNum = i10;
    }

    private void setcModifyNum(int i10) {
        this.cModifyNum = i10;
    }

    private void setlAddNum(int i10) {
        this.lAddNum = i10;
    }

    private void setlDeleteNum(int i10) {
        this.lDeleteNum = i10;
    }

    private void setlModifyNum(int i10) {
        this.lModifyNum = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAllNum() {
        return getlAddNum() + getlModifyNum() + getlDeleteNum();
    }

    public String getErrorSource() {
        return this.errorSource;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public void setErrorSource(String str) {
        this.errorSource = str;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setNumbers(int i10, int i11, int i12, int i13, int i14, int i15) {
        setcAddNum(i10);
        setcModifyNum(i12);
        setcDeleteNum(i11);
        setlAddNum(i13);
        setlModifyNum(i15);
        setlDeleteNum(i14);
    }

    public void setProgress(int i10) {
        this.progress = i10;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public String toString() {
        return "ModuleRst [successNum=" + this.successNum + ", failNum=" + this.failNum + ", nochangeNum=" + this.nochangeNum + ", retCode=" + this.retCode + " + lAddNum=" + this.lAddNum + ", lModifyNum=" + this.lModifyNum + ", lDeleteNum=" + this.lDeleteNum + " + cAddNum=" + this.cAddNum + ", cModifyNum=" + this.cModifyNum + ", cDeleteNum=" + this.cDeleteNum + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.retCode);
        parcel.writeInt(this.successNum);
        parcel.writeInt(this.failNum);
        parcel.writeInt(this.nochangeNum);
        parcel.writeString(this.moduleName);
        parcel.writeInt(this.lAddNum);
        parcel.writeInt(this.lModifyNum);
        parcel.writeInt(this.lDeleteNum);
        parcel.writeInt(this.cAddNum);
        parcel.writeInt(this.cModifyNum);
        parcel.writeInt(this.cDeleteNum);
        parcel.writeInt(this.returnCode);
        parcel.writeString(this.errorSource);
        parcel.writeString(this.failReason);
    }

    public ModuleRst() {
        this.successNum = 0;
        this.failNum = 0;
        this.nochangeNum = 0;
        this.lAddNum = 0;
        this.lModifyNum = 0;
        this.lDeleteNum = 0;
        this.cAddNum = 0;
        this.cModifyNum = 0;
        this.cDeleteNum = 0;
        this.retCode = -1;
        this.progress = 0;
        this.moduleName = "";
        this.failReason = "";
    }

    private ModuleRst(Parcel parcel) {
        this.successNum = 0;
        this.failNum = 0;
        this.nochangeNum = 0;
        this.lAddNum = 0;
        this.lModifyNum = 0;
        this.lDeleteNum = 0;
        this.cAddNum = 0;
        this.cModifyNum = 0;
        this.cDeleteNum = 0;
        this.retCode = -1;
        this.progress = 0;
        this.moduleName = "";
        this.failReason = "";
        readFromParcel(parcel);
    }
}
