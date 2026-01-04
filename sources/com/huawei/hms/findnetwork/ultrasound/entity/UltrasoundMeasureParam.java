package com.huawei.hms.findnetwork.ultrasound.entity;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class UltrasoundMeasureParam {
    private long mBeginRecordTime;
    private byte[] mRecordByteArray;
    private long mUltrasoundTxTime = -1;
    private final AtomicBoolean mIsStopMeasuring = new AtomicBoolean(false);

    public long getBeginRecordTime() {
        return this.mBeginRecordTime;
    }

    public AtomicBoolean getIsStopMeasuring() {
        return this.mIsStopMeasuring;
    }

    public byte[] getRecordByteArray() {
        byte[] bArr = this.mRecordByteArray;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public long getUltrasoundTxTime() {
        return this.mUltrasoundTxTime;
    }

    public void setBeginRecordTime(long j10) {
        this.mBeginRecordTime = j10;
    }

    public void setRecordByteArray(byte[] bArr) {
        if (bArr != null) {
            this.mRecordByteArray = (byte[]) bArr.clone();
        }
    }

    public void setUltrasoundTxTime(long j10) {
        this.mUltrasoundTxTime = j10;
    }

    public String toString() {
        return "UltrasoundMeasureParam{mRecordByteArray=" + Arrays.toString(this.mRecordByteArray) + ", mBeginRecordTime=" + this.mBeginRecordTime + ", mIsStopMeasuring=" + this.mIsStopMeasuring + '}';
    }
}
