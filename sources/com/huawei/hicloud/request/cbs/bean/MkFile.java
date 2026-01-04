package com.huawei.hicloud.request.cbs.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MkFile implements Parcelable {
    public static final Parcelable.Creator<MkFile> CREATOR = new Parcelable.Creator<MkFile>() { // from class: com.huawei.hicloud.request.cbs.bean.MkFile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MkFile createFromParcel(Parcel parcel) {
            MkFile mkFile = new MkFile();
            mkFile.setName(parcel.readString());
            mkFile.setSig(parcel.readString());
            mkFile.setSize(parcel.readString());
            mkFile.setTs(parcel.readString());
            mkFile.setUrl(parcel.readString());
            mkFile.setExtParams(parcel.readHashMap(HashMap.class.getClassLoader()));
            mkFile.setNeedRun(parcel.readByte() != 0);
            return mkFile;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MkFile[] newArray(int i10) {
            return new MkFile[i10];
        }
    };
    private Map<String, String> extParams;
    private String name;
    private boolean needRun = true;
    private String sig;
    private String size;

    /* renamed from: ts */
    private String f22812ts;
    private String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getExtParams() {
        return this.extParams;
    }

    public String getName() {
        return this.name;
    }

    public String getSig() {
        return this.sig;
    }

    public String getSize() {
        return this.size;
    }

    public String getTs() {
        return this.f22812ts;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isNeedRun() {
        return this.needRun;
    }

    public void setExtParams(Map<String, String> map) {
        this.extParams = map;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedRun(boolean z10) {
        this.needRun = z10;
    }

    public void setSig(String str) {
        this.sig = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setTs(String str) {
        this.f22812ts = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.name);
        parcel.writeString(this.sig);
        parcel.writeString(this.size);
        parcel.writeString(this.f22812ts);
        parcel.writeString(this.url);
        parcel.writeMap(this.extParams);
        parcel.writeByte(this.needRun ? (byte) 1 : (byte) 0);
    }
}
