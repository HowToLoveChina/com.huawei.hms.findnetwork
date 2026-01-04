package com.huawei.hms.support.api.entity.location.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes8.dex */
public class Address implements Parcelable {
    public static final Parcelable.Creator<Address> CREATOR = new C6328yn();
    private String mCity;
    private String mCountryCode;
    private String mCountryName;
    private String mCounty;
    private Map<String, Object> mExtraInfo;
    private String mFeatureName;
    private String mPhone;
    private String mPostalCode;
    private String mState;
    private String mStreet;
    private String mUrl;

    /* renamed from: com.huawei.hms.support.api.entity.location.geocoder.Address$yn */
    public class C6328yn implements Parcelable.Creator<Address> {
        @Override // android.os.Parcelable.Creator
        public final Address createFromParcel(Parcel parcel) {
            return new Address(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Address[] newArray(int i10) {
            return new Address[i10];
        }
    }

    public Address() {
    }

    private Address(Parcel parcel) {
        this.mCountryCode = parcel.readString();
        this.mCountryName = parcel.readString();
        this.mState = parcel.readString();
        this.mCity = parcel.readString();
        this.mCounty = parcel.readString();
        this.mStreet = parcel.readString();
        this.mFeatureName = parcel.readString();
        this.mPostalCode = parcel.readString();
        this.mPhone = parcel.readString();
        this.mUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public String getCountryName() {
        return this.mCountryName;
    }

    public String getCounty() {
        return this.mCounty;
    }

    public Map<String, Object> getExtraInfo() {
        return this.mExtraInfo;
    }

    public String getFeatureName() {
        return this.mFeatureName;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public String getPostalCode() {
        return this.mPostalCode;
    }

    public String getState() {
        return this.mState;
    }

    public String getStreet() {
        return this.mStreet;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public void setCountryCode(String str) {
        this.mCountryCode = str;
    }

    public void setCountryName(String str) {
        this.mCountryName = str;
    }

    public void setCounty(String str) {
        this.mCounty = str;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.mExtraInfo = map;
    }

    public void setFeatureName(String str) {
        this.mFeatureName = str;
    }

    public void setPhone(String str) {
        this.mPhone = str;
    }

    public void setPostalCode(String str) {
        this.mPostalCode = str;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public void setStreet(String str) {
        this.mStreet = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mCountryCode);
        parcel.writeString(this.mCountryName);
        parcel.writeString(this.mState);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mCounty);
        parcel.writeString(this.mStreet);
        parcel.writeString(this.mFeatureName);
        parcel.writeString(this.mPostalCode);
        parcel.writeString(this.mPhone);
        parcel.writeString(this.mUrl);
    }

    public /* synthetic */ Address(Parcel parcel, C6328yn c6328yn) {
        this(parcel);
    }
}
