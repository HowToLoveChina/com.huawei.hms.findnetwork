package com.huawei.location.base.activity.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* loaded from: classes8.dex */
public class ClientInfo implements Parcelable {
    public static final Parcelable.Creator<ClientInfo> CREATOR = new C6740a();
    private int clientPid;
    private int clientUid;
    private Bundle mExtras;
    private String packageName;
    private String transactionID;

    /* renamed from: com.huawei.location.base.activity.entity.ClientInfo$a */
    public class C6740a implements Parcelable.Creator<ClientInfo> {
        @Override // android.os.Parcelable.Creator
        public final ClientInfo createFromParcel(Parcel parcel) {
            return new ClientInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ClientInfo[] newArray(int i10) {
            return new ClientInfo[i10];
        }
    }

    public ClientInfo() {
        this.mExtras = null;
        this.transactionID = UUID.randomUUID().toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getClientPid() {
        return this.clientPid;
    }

    public int getClientUid() {
        return this.clientUid;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public Bundle getmExtras() {
        return this.mExtras;
    }

    public void setClientPid(int i10) {
        this.clientPid = i10;
    }

    public void setClientUid(int i10) {
        this.clientUid = i10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setTransactionID(String str) {
        this.transactionID = str;
    }

    public void setmExtras(Bundle bundle) {
        this.mExtras = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.packageName);
        parcel.writeInt(this.clientUid);
        parcel.writeInt(this.clientPid);
        parcel.writeString(this.transactionID);
        parcel.writeBundle(this.mExtras);
    }

    public ClientInfo(Parcel parcel) {
        this.mExtras = null;
        this.packageName = parcel.readString();
        this.clientUid = parcel.readInt();
        this.clientPid = parcel.readInt();
        this.transactionID = parcel.readString();
        this.mExtras = parcel.readBundle(Bundle.class.getClassLoader());
    }

    public ClientInfo(String str, int i10, int i11) {
        this.mExtras = null;
        this.packageName = str;
        this.clientUid = i10;
        this.clientPid = i11;
        this.transactionID = UUID.randomUUID().toString();
        this.mExtras = new Bundle();
    }

    public ClientInfo(String str, int i10, int i11, String str2) {
        this.mExtras = null;
        this.packageName = str;
        this.clientUid = i10;
        this.clientPid = i11;
        this.transactionID = str2;
        this.mExtras = new Bundle();
    }

    public ClientInfo(String str, int i10, int i11, String str2, Bundle bundle) {
        this.packageName = str;
        this.clientUid = i10;
        this.clientPid = i11;
        this.transactionID = str2;
        this.mExtras = bundle;
    }
}
