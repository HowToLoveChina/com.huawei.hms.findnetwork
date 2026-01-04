package com.huawei.phoneservice.faq.base.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqSdkServiceUrlResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<FaqSdkServiceUrlResponse> CREATOR = new C8293a();
    private static final long serialVersionUID = 1726106361091289151L;

    /* renamed from: a */
    @SerializedName("itemList")
    private List<ServiceUrl> f38626a;

    public static class ServiceUrl implements Parcelable, Serializable {
        public static final Parcelable.Creator<ServiceUrl> CREATOR = new C8292a();
        private static final long serialVersionUID = -117340691941684418L;

        /* renamed from: a */
        @SerializedName(FaqConstants.SDK_URL_HA)
        private String f38627a;

        /* renamed from: b */
        @SerializedName(FaqConstants.SDK_URL_MD)
        private String f38628b;

        /* renamed from: c */
        @SerializedName("sdkGwRouteAddressV2")
        private String f38629c;

        /* renamed from: d */
        @SerializedName(FaqConstants.SDK_URL_YUN)
        private String f38630d;

        /* renamed from: e */
        @SerializedName("countryCode")
        private String f38631e;

        /* renamed from: com.huawei.phoneservice.faq.base.entity.FaqSdkServiceUrlResponse$ServiceUrl$a */
        public class C8292a implements Parcelable.Creator<ServiceUrl> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ServiceUrl createFromParcel(Parcel parcel) {
                return new ServiceUrl(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ServiceUrl[] newArray(int i10) {
                return new ServiceUrl[i10];
            }
        }

        public ServiceUrl(Parcel parcel) {
            this.f38627a = parcel.readString();
            this.f38628b = parcel.readString();
            this.f38629c = parcel.readString();
            this.f38630d = parcel.readString();
            this.f38631e = parcel.readString();
        }

        /* renamed from: c */
        public String m51753c() {
            return this.f38631e;
        }

        /* renamed from: d */
        public String m51754d() {
            return this.f38627a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        public String m51755e() {
            return this.f38628b;
        }

        /* renamed from: f */
        public String m51756f() {
            return this.f38629c;
        }

        /* renamed from: g */
        public String m51757g() {
            return this.f38630d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f38627a);
            parcel.writeString(this.f38628b);
            parcel.writeString(this.f38629c);
            parcel.writeString(this.f38630d);
            parcel.writeString(this.f38631e);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.entity.FaqSdkServiceUrlResponse$a */
    public class C8293a implements Parcelable.Creator<FaqSdkServiceUrlResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaqSdkServiceUrlResponse createFromParcel(Parcel parcel) {
            return new FaqSdkServiceUrlResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FaqSdkServiceUrlResponse[] newArray(int i10) {
            return new FaqSdkServiceUrlResponse[i10];
        }
    }

    public FaqSdkServiceUrlResponse(Parcel parcel) {
        this.f38626a = parcel.createTypedArrayList(ServiceUrl.CREATOR);
    }

    /* renamed from: c */
    public List<ServiceUrl> m51752c() {
        return this.f38626a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f38626a);
    }
}
