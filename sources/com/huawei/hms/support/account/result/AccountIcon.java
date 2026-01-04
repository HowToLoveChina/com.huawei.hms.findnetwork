package com.huawei.hms.support.account.result;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class AccountIcon implements Parcelable {
    public static final Parcelable.Creator<AccountIcon> CREATOR = new Parcelable.Creator<AccountIcon>() { // from class: com.huawei.hms.support.account.result.AccountIcon.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountIcon createFromParcel(Parcel parcel) {
            return new AccountIcon(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountIcon[] newArray(int i10) {
            return new AccountIcon[i10];
        }
    };

    /* renamed from: a */
    private String f29752a;

    /* renamed from: b */
    private Bitmap f29753b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.f29752a;
    }

    public Bitmap getIcon() {
        return this.f29753b;
    }

    public void setDescription(String str) {
        this.f29752a = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.f29753b = bitmap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29752a);
        parcel.writeParcelable(this.f29753b, i10);
    }

    public AccountIcon() {
    }

    private AccountIcon(Parcel parcel) {
        this.f29752a = parcel.readString();
        this.f29753b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    public AccountIcon(String str, Bitmap bitmap) {
        this.f29752a = str;
        this.f29753b = bitmap;
    }
}
