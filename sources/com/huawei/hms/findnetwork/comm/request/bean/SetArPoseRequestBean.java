package com.huawei.hms.findnetwork.comm.request.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class SetArPoseRequestBean extends BaseRequestBean implements Parcelable {
    public static final Parcelable.Creator<SetArPoseRequestBean> CREATOR = new C5339a();
    private String deviceId;
    private float outQw;
    private float outQx;
    private float outQy;
    private float outQz;
    private float outTx;
    private float outTy;
    private float outTz;

    /* renamed from: com.huawei.hms.findnetwork.comm.request.bean.SetArPoseRequestBean$a */
    public class C5339a implements Parcelable.Creator<SetArPoseRequestBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetArPoseRequestBean createFromParcel(Parcel parcel) {
            return new SetArPoseRequestBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetArPoseRequestBean[] newArray(int i10) {
            return new SetArPoseRequestBean[i10];
        }
    }

    public SetArPoseRequestBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public float getOutQw() {
        return this.outQw;
    }

    public float getOutQx() {
        return this.outQx;
    }

    public float getOutQy() {
        return this.outQy;
    }

    public float getOutQz() {
        return this.outQz;
    }

    public float getOutTx() {
        return this.outTx;
    }

    public float getOutTy() {
        return this.outTy;
    }

    public float getOutTz() {
        return this.outTz;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setOutQw(float f10) {
        this.outQw = f10;
    }

    public void setOutQx(float f10) {
        this.outQx = f10;
    }

    public void setOutQy(float f10) {
        this.outQy = f10;
    }

    public void setOutQz(float f10) {
        this.outQz = f10;
    }

    public void setOutTx(float f10) {
        this.outTx = f10;
    }

    public void setOutTy(float f10) {
        this.outTy = f10;
    }

    public void setOutTz(float f10) {
        this.outTz = f10;
    }

    public String toString() {
        return "ArPose{outTx=" + this.outTx + ", outTy=" + this.outTy + ", outTz=" + this.outTz + ", outQx=" + this.outQx + ", outQy=" + this.outQy + ", outQz=" + this.outQz + ", outQw=" + this.outQw + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.deviceId);
        parcel.writeFloat(this.outTx);
        parcel.writeFloat(this.outTy);
        parcel.writeFloat(this.outTz);
        parcel.writeFloat(this.outQx);
        parcel.writeFloat(this.outQy);
        parcel.writeFloat(this.outQz);
        parcel.writeFloat(this.outQw);
    }

    public SetArPoseRequestBean(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.outTx = parcel.readFloat();
        this.outTy = parcel.readFloat();
        this.outTz = parcel.readFloat();
        this.outQx = parcel.readFloat();
        this.outQy = parcel.readFloat();
        this.outQz = parcel.readFloat();
        this.outQw = parcel.readFloat();
    }
}
