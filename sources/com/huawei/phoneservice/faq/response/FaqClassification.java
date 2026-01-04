package com.huawei.phoneservice.faq.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class FaqClassification {

    /* renamed from: a */
    @SerializedName("rList")
    private ArrayList<Classification> f38751a;

    public static class Classification implements Parcelable {
        public static final Parcelable.Creator<Classification> CREATOR = new C8335a();

        /* renamed from: a */
        @SerializedName("productCategoryCode")
        private String f38752a;

        /* renamed from: b */
        @SerializedName("productCategoryName")
        private String f38753b;

        /* renamed from: c */
        @SerializedName("subClass")
        private String f38754c;

        /* renamed from: d */
        @SerializedName("icon")
        private String f38755d;

        /* renamed from: e */
        public boolean f38756e = false;

        /* renamed from: com.huawei.phoneservice.faq.response.FaqClassification$Classification$a */
        public class C8335a implements Parcelable.Creator<Classification> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Classification createFromParcel(Parcel parcel) {
                return new Classification(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Classification[] newArray(int i10) {
                return new Classification[i10];
            }
        }

        public Classification(Parcel parcel) {
            this.f38752a = parcel.readString();
            this.f38753b = parcel.readString();
            this.f38754c = parcel.readString();
            this.f38755d = parcel.readString();
        }

        /* renamed from: a */
        public String m51919a() {
            return this.f38754c;
        }

        /* renamed from: c */
        public void m51920c(boolean z10) {
            this.f38756e = z10;
        }

        /* renamed from: d */
        public String m51921d() {
            return this.f38752a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        public String m51922e() {
            return this.f38753b;
        }

        /* renamed from: f */
        public String m51923f() {
            return this.f38755d;
        }

        /* renamed from: g */
        public boolean m51924g() {
            return this.f38756e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f38752a);
            parcel.writeString(this.f38753b);
            parcel.writeString(this.f38754c);
            parcel.writeString(this.f38755d);
        }
    }

    /* renamed from: a */
    public ArrayList<Classification> m51918a() {
        return this.f38751a;
    }
}
