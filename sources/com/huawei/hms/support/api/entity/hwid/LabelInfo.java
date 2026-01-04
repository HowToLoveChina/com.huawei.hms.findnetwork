package com.huawei.hms.support.api.entity.hwid;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class LabelInfo implements Parcelable {
    public static final Parcelable.Creator<LabelInfo> CREATOR = new Parcelable.Creator<LabelInfo>() { // from class: com.huawei.hms.support.api.entity.hwid.LabelInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LabelInfo createFromParcel(Parcel parcel) {
            return new LabelInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LabelInfo[] newArray(int i10) {
            return new LabelInfo[i10];
        }
    };

    /* renamed from: a */
    private int f29792a;

    /* renamed from: b */
    private String f29793b;

    public LabelInfo() {
        this.f29792a = -1;
        this.f29793b = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLabelName() {
        return this.f29793b;
    }

    public int getLabelType() {
        return this.f29792a;
    }

    public boolean isEquals(LabelInfo labelInfo) {
        return labelInfo != null && getLabelType() == labelInfo.getLabelType() && getLabelName().equals(labelInfo.getLabelName());
    }

    public void setLabelName(String str) {
        this.f29793b = str;
    }

    public void setLabelType(int i10) {
        this.f29792a = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f29792a);
        parcel.writeString(this.f29793b);
    }

    public LabelInfo(Parcel parcel) {
        this.f29792a = parcel.readInt();
        this.f29793b = parcel.readString();
    }
}
