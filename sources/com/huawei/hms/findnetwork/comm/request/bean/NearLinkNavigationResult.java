package com.huawei.hms.findnetwork.comm.request.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class NearLinkNavigationResult implements Parcelable {
    public static final Parcelable.Creator<NearLinkNavigationResult> CREATOR = new C5338a();
    private float angle;
    private float angleAccuracy;
    private String deviceId;
    private float direction;
    private float distance;
    private float duration;
    private float stage;
    private float trackQuality;

    /* renamed from: com.huawei.hms.findnetwork.comm.request.bean.NearLinkNavigationResult$a */
    public class C5338a implements Parcelable.Creator<NearLinkNavigationResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NearLinkNavigationResult createFromParcel(Parcel parcel) {
            return new NearLinkNavigationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NearLinkNavigationResult[] newArray(int i10) {
            return new NearLinkNavigationResult[i10];
        }
    }

    public NearLinkNavigationResult() {
        this.stage = -1.0f;
        this.distance = -1.0f;
        this.direction = -1.0f;
        this.angle = -1.0f;
        this.angleAccuracy = -1.0f;
        this.duration = -1.0f;
        this.trackQuality = -1.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAngle() {
        return this.angle;
    }

    public float getAngleAccuracy() {
        return this.angleAccuracy;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public float getDirection() {
        return this.direction;
    }

    public float getDistance() {
        return this.distance;
    }

    public float getDuration() {
        return this.duration;
    }

    public float getStage() {
        return this.stage;
    }

    public float getTrackQuality() {
        return this.trackQuality;
    }

    public void reset() {
        this.stage = -1.0f;
        this.distance = -1.0f;
        this.direction = -1.0f;
        this.angle = -1.0f;
        this.angleAccuracy = -1.0f;
        this.duration = -1.0f;
        this.trackQuality = -1.0f;
    }

    public void setAngle(float f10) {
        this.angle = f10;
    }

    public void setAngleAccuracy(float f10) {
        this.angleAccuracy = f10;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDirection(float f10) {
        this.direction = f10;
    }

    public void setDistance(float f10) {
        this.distance = f10;
    }

    public void setDuration(float f10) {
        this.duration = f10;
    }

    public void setStage(float f10) {
        this.stage = f10;
    }

    public void setTrackQuality(float f10) {
        this.trackQuality = f10;
    }

    public String toString() {
        return "NearLinkNavigationResult{stage=" + this.stage + ", distance=" + this.distance + ", direction=" + this.direction + ", angle=" + this.angle + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.deviceId);
        parcel.writeFloat(this.stage);
        parcel.writeFloat(this.distance);
        parcel.writeFloat(this.direction);
        parcel.writeFloat(this.angle);
        parcel.writeFloat(this.angleAccuracy);
        parcel.writeFloat(this.duration);
        parcel.writeFloat(this.trackQuality);
    }

    public NearLinkNavigationResult(Parcel parcel) {
        this.stage = -1.0f;
        this.distance = -1.0f;
        this.direction = -1.0f;
        this.angle = -1.0f;
        this.angleAccuracy = -1.0f;
        this.duration = -1.0f;
        this.trackQuality = -1.0f;
        this.deviceId = parcel.readString();
        this.stage = parcel.readFloat();
        this.distance = parcel.readFloat();
        this.direction = parcel.readFloat();
        this.angle = parcel.readFloat();
        this.angleAccuracy = parcel.readFloat();
        this.duration = parcel.readFloat();
        this.trackQuality = parcel.readFloat();
    }
}
