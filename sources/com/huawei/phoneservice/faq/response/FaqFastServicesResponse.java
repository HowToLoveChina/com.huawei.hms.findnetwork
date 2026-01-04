package com.huawei.phoneservice.faq.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqFastServicesResponse implements Serializable, Parcelable {
    public static final Parcelable.Creator<FaqFastServicesResponse> CREATOR = new C8337a();
    private static final long serialVersionUID = 3336773395104625934L;

    /* renamed from: a */
    @SerializedName("moduleList")
    private List<ModuleListBean> f38757a;

    public static class ModuleListBean implements Serializable, Parcelable {
        public static final Parcelable.Creator<ModuleListBean> CREATOR = new C8336a();
        private static final long serialVersionUID = 5243896567447681158L;

        /* renamed from: a */
        @SerializedName("moduleCode")
        private int f38758a;

        /* renamed from: b */
        @SerializedName("moduleName")
        private String f38759b;

        /* renamed from: c */
        @SerializedName("moduleUrl")
        private String f38760c;

        /* renamed from: d */
        @SerializedName("openType")
        private String f38761d;

        /* renamed from: e */
        public Object f38762e;

        /* renamed from: com.huawei.phoneservice.faq.response.FaqFastServicesResponse$ModuleListBean$a */
        public class C8336a implements Parcelable.Creator<ModuleListBean> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ModuleListBean createFromParcel(Parcel parcel) {
                return new ModuleListBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ModuleListBean[] newArray(int i10) {
                return new ModuleListBean[i10];
            }
        }

        public ModuleListBean() {
        }

        public ModuleListBean(Parcel parcel) {
            this.f38758a = parcel.readInt();
            this.f38759b = parcel.readString();
            this.f38760c = parcel.readString();
            this.f38761d = parcel.readString();
            parcel.readParcelable(getClass().getClassLoader());
        }

        /* renamed from: c */
        public int m51927c() {
            return this.f38758a;
        }

        /* renamed from: d */
        public void m51928d(int i10) {
            this.f38758a = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        public void m51929e(String str) {
            this.f38761d = str;
        }

        public boolean equals(Object obj) {
            return obj != null && getClass() == obj.getClass() && this.f38758a == ((ModuleListBean) obj).m51927c();
        }

        /* renamed from: f */
        public String m51930f() {
            return this.f38760c;
        }

        /* renamed from: g */
        public String m51931g() {
            return this.f38761d;
        }

        public int hashCode() {
            return super.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f38758a);
            parcel.writeString(this.f38759b);
            parcel.writeString(this.f38760c);
            parcel.writeString(this.f38761d);
            parcel.writeParcelable((Parcelable) this.f38762e, i10);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.response.FaqFastServicesResponse$a */
    public class C8337a implements Parcelable.Creator<FaqFastServicesResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaqFastServicesResponse createFromParcel(Parcel parcel) {
            return new FaqFastServicesResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FaqFastServicesResponse[] newArray(int i10) {
            return new FaqFastServicesResponse[i10];
        }
    }

    public FaqFastServicesResponse(Parcel parcel) {
        this.f38757a = parcel.createTypedArrayList(ModuleListBean.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f38757a);
    }
}
