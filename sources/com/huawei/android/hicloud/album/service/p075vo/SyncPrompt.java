package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SyncPrompt implements Parcelable {
    public static final Parcelable.Creator<SyncPrompt> CREATOR = new Parcelable.Creator<SyncPrompt>() { // from class: com.huawei.android.hicloud.album.service.vo.SyncPrompt.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncPrompt createFromParcel(Parcel parcel) {
            return new SyncPrompt(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncPrompt[] newArray(int i10) {
            return new SyncPrompt[i10];
        }
    };
    public static final int SYNC_STATE_BATTERY_TOO_LOW = 911;
    public static final int SYNC_STATE_DEFAULT = 910;
    public static final int SYNC_STATE_DEFAULT_BLANK = 912;
    public static final int SYNC_STATE_FAIL = 909;
    public static final int SYNC_STATE_NO_NEED_SYNC = 907;
    public static final int SYNC_STATE_PAUSE_FOR_BATTERY = 904;
    public static final int SYNC_STATE_PAUSE_FOR_SPACE_TOO_LOW = 905;
    public static final int SYNC_STATE_PAUSE_FOR_WIFI = 901;
    public static final int SYNC_STATE_START_SYNC = 906;
    public static final int SYNC_STATE_SYNC = 902;
    public static final int SYNC_STATE_SYNC_FAIL = 908;
    public static final int SYNC_STATE_UPLOAD = 903;
    public static final int SYNC_STOPPED_WAIT = 0;
    public static final int SYNC_STOPPED_WAIT_DOWNLOADING = 1;
    public static final int SYNC_STOPPED_WAIT_UPLOADING = 2;
    public static final int TYPE_GENERAL_SYNC = 0;
    public static final int TYPE_SHARE_SYNC = 1;
    private long latestSyncTime;
    private int state;
    private int stoppedState;
    private int type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getLatestSyncTime() {
        return this.latestSyncTime;
    }

    public int getState() {
        return this.state;
    }

    public int getStoppedState() {
        return this.stoppedState;
    }

    public int getType() {
        return this.type;
    }

    public void readFromParcel(Parcel parcel) {
        this.state = parcel.readInt();
        this.latestSyncTime = parcel.readLong();
        this.stoppedState = parcel.readInt();
        this.type = parcel.readInt();
    }

    public void setLatestSyncTime(long j10) {
        this.latestSyncTime = j10;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setStoppedState(int i10) {
        this.stoppedState = i10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        return "SyncPrompt{state=" + this.state + ", latestSyncTime=" + this.latestSyncTime + ", stoppedState=" + this.stoppedState + ", type=" + this.type + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.state);
        parcel.writeLong(this.latestSyncTime);
        parcel.writeInt(this.stoppedState);
        parcel.writeInt(this.type);
    }

    public SyncPrompt() {
        this.state = SYNC_STATE_DEFAULT;
        this.stoppedState = 0;
        this.type = 0;
    }

    private SyncPrompt(Parcel parcel) {
        this.state = SYNC_STATE_DEFAULT;
        this.stoppedState = 0;
        this.type = 0;
        readFromParcel(parcel);
    }
}
