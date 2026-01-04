package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class SyncType implements Parcelable {
    public static final int AUTO_SYNC_CALLLOG = 131;
    public static final int AUTO_SYNC_CONTACT = 96;
    public static final int AUTO_SYNC_CONTACT_NETCON = 112;
    public static final int AUTO_SYNC_PHONE_MANAGER = 136;
    public static final int AUTO_SYNC_RECORD = 132;
    public static final int AUTO_SYNC_SMS = 130;
    public static final int AUTO_SYNC_WLAN = 128;
    public static final int CONTACT_CHANGE = 16;
    public static final int DELAY_START_SYNC = 137;
    public static final int GROUP_CHANGE = 9;
    public static final int I_CONTACT_GROUP_ALL = 8;
    public static final int OPEN_SWITCH_FROM_GUIDE = 134;
    public static final int OPEN_SWITCH_MANUALLY = 133;
    public static final int RECEIVE_WLAN_CHANGE = 17;
    public static final int RISK_MANAGEMENT_MANUALLY = 135;
    public static final int WLAN_CHANGE = 129;
    private int biReportType;
    private int syncType;
    private final int type;
    public static final SyncType CONTACT = new SyncType(16);
    public static final SyncType INTELLIGENCE_SYNC_MANUAL = new SyncType(16, 4, 1);
    public static final SyncType INTELLIGENCE_SYNC_FROM_GUIDE = new SyncType(16, 4, 2);
    public static final SyncType MAMUNAL_OPENAUTO_SYNC = new SyncType(16, 3, 4);
    public static final SyncType RETRY_SYNC = new SyncType(16, 3, 3);
    public static final SyncType PUSH_SYNC = new SyncType(16, 3, 5);
    public static final SyncType OBSERVE_CONTACT_CHANGE_SYNC = new SyncType(16, 3, 6);
    public static final SyncType NETWORK_CHANGE_SYNC = new SyncType(16, 3, 9);
    public static final SyncType LAST_FAIL_NETWORK_CHANGE_SYNC = new SyncType(16, 3, 10);
    public static final SyncType RISK_SYNC = new SyncType(16, 3, 13);
    public static final SyncType COMMON_SYNC = new SyncType(16, 3, 15);
    public static final SyncType HIDISK_RETRY_SYNC = new SyncType(16, 3, 16);
    public static final Parcelable.Creator<SyncType> CREATOR = new Parcelable.Creator<SyncType>() { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncType createFromParcel(Parcel parcel) {
            return new SyncType(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncType[] newArray(int i10) {
            return new SyncType[i10];
        }
    };

    public static class WlanSyncType {
        public static final SyncType MAMUNAL_OPENAUTO_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 4);
        public static final SyncType INTELLIGENCE_SYNC_MANUAL = new SyncType(SyncType.WLAN_CHANGE, 4, 1);
        public static final SyncType INTELLIGENCE_SYNC_FROM_GUIDE = new SyncType(SyncType.WLAN_CHANGE, 4, 2);
        public static final SyncType CONFIGURED_NETWORKS_CHANGE_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 14);
        public static final SyncType LAST_FAIL_NETWORK_CHANGE_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 10);
        public static final SyncType RETRY_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 3);
        public static final SyncType PUSH_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 5);
        public static final SyncType RISK_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 13);
        public static final SyncType COMMON_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 15);
        public static final SyncType HIDISK_RETRY_SYNC = new SyncType(SyncType.WLAN_CHANGE, 3, 16);
    }

    public SyncType(Parcel parcel) {
        this.syncType = 3;
        this.biReportType = 12;
        this.type = parcel.readInt();
        this.syncType = parcel.readInt();
        this.biReportType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBiReportType() {
        return this.biReportType;
    }

    public int getSyncType() {
        return this.syncType;
    }

    public int getType() {
        return this.type;
    }

    public void setBiReportType(int i10) {
        this.biReportType = i10;
    }

    public String toString() {
        return this.type == 16 ? "Contact" : "Unknown";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.syncType);
        parcel.writeInt(this.biReportType);
    }

    public SyncType(int i10, int i11, int i12) {
        this.type = i10;
        this.syncType = i11;
        this.biReportType = i12;
    }

    public SyncType(int i10) {
        this.syncType = 3;
        this.biReportType = 12;
        this.type = i10;
    }

    public SyncType(int i10, int i11) {
        this.biReportType = 12;
        this.type = i10;
        this.syncType = i11;
    }
}
