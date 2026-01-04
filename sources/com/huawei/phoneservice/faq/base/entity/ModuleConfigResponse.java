package com.huawei.phoneservice.faq.base.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class ModuleConfigResponse implements Serializable, Parcelable {
    public static final Parcelable.Creator<ModuleConfigResponse> CREATOR = new C8296a();
    private static final long serialVersionUID = 5523493960862839428L;

    /* renamed from: a */
    @SerializedName("moduleList")
    private List<ModuleListBean> f38633a;

    public static class ModuleListBean implements Serializable, Parcelable {
        public static final Parcelable.Creator<ModuleListBean> CREATOR = new C8294a();
        private static final long serialVersionUID = -6366144895402746183L;

        /* renamed from: a */
        @SerializedName("moduleCode")
        private String f38634a;

        /* renamed from: b */
        @SerializedName("moduleName")
        private String f38635b;

        /* renamed from: c */
        @SerializedName("moduleLinkAddress")
        private String f38636c;

        /* renamed from: d */
        @SerializedName("openLinkType")
        private String f38637d;

        /* renamed from: e */
        @SerializedName("isLink")
        private String f38638e;

        /* renamed from: f */
        @SerializedName("subModuleList")
        private List<SubModuleListBean> f38639f;

        /* renamed from: g */
        @SerializedName("appName")
        private String f38640g;

        /* renamed from: com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse$ModuleListBean$a */
        public class C8294a implements Parcelable.Creator<ModuleListBean> {
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
            this.f38634a = parcel.readString();
            this.f38635b = parcel.readString();
            this.f38636c = parcel.readString();
            this.f38637d = parcel.readString();
            this.f38638e = parcel.readString();
            this.f38639f = parcel.createTypedArrayList(SubModuleListBean.CREATOR);
            this.f38640g = parcel.readString();
            parcel.readParcelable(getClass().getClassLoader());
        }

        /* renamed from: c */
        public String m51762c() {
            return this.f38640g;
        }

        /* renamed from: d */
        public List<SubModuleListBean> m51763d() {
            return this.f38639f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj != null && getClass() == obj.getClass()) {
                return this.f38634a.equals(((ModuleListBean) obj).getModuleCode());
            }
            return false;
        }

        @Keep
        public String getLinkAddress() {
            return this.f38636c;
        }

        @Keep
        public String getModuleCode() {
            return this.f38634a;
        }

        @Keep
        public String getOpenType() {
            return this.f38637d;
        }

        public int hashCode() {
            return super.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f38634a);
            parcel.writeString(this.f38635b);
            parcel.writeString(this.f38636c);
            parcel.writeString(this.f38637d);
            parcel.writeString(this.f38638e);
            parcel.writeTypedList(this.f38639f);
            parcel.writeString(this.f38640g);
        }
    }

    public static class SubModuleListBean implements Serializable, Parcelable {
        public static final Parcelable.Creator<SubModuleListBean> CREATOR = new C8295a();
        private static final long serialVersionUID = 773325441128424814L;

        /* renamed from: a */
        @SerializedName("subModuleCode")
        private String f38641a;

        /* renamed from: b */
        @SerializedName("subModuleName")
        private String f38642b;

        /* renamed from: c */
        @SerializedName("subModuleLinkAddress")
        private String f38643c;

        /* renamed from: d */
        @SerializedName("openLinkType")
        private String f38644d;

        /* renamed from: e */
        @SerializedName("isLink")
        private String f38645e;

        /* renamed from: com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse$SubModuleListBean$a */
        public class C8295a implements Parcelable.Creator<SubModuleListBean> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SubModuleListBean createFromParcel(Parcel parcel) {
                return new SubModuleListBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SubModuleListBean[] newArray(int i10) {
                return new SubModuleListBean[i10];
            }
        }

        public SubModuleListBean(Parcel parcel) {
            this.f38641a = parcel.readString();
            this.f38642b = parcel.readString();
            this.f38643c = parcel.readString();
            this.f38644d = parcel.readString();
            this.f38645e = parcel.readString();
        }

        /* renamed from: c */
        public String m51766c() {
            return this.f38641a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f38641a);
            parcel.writeString(this.f38642b);
            parcel.writeString(this.f38643c);
            parcel.writeString(this.f38644d);
            parcel.writeString(this.f38645e);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse$a */
    public class C8296a implements Parcelable.Creator<ModuleConfigResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModuleConfigResponse createFromParcel(Parcel parcel) {
            return new ModuleConfigResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ModuleConfigResponse[] newArray(int i10) {
            return new ModuleConfigResponse[i10];
        }
    }

    public ModuleConfigResponse() {
    }

    public ModuleConfigResponse(Parcel parcel) {
        this.f38633a = parcel.createTypedArrayList(ModuleListBean.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Keep
    public List<ModuleListBean> getModuleList() {
        return this.f38633a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f38633a);
    }
}
