package com.huawei.hms.findnetwork.comm.request.result;

import com.huawei.hms.findnetwork.comm.util.MaskUtil;

/* loaded from: classes8.dex */
public class FindNetworkScanResult {
    private String mMac;
    private float mPreciseDistance;
    private String mRelativeDistance;
    private String mRssi;
    private String mSN;
    private String mStandbyDevice;
    private int mStatus;

    public String getStandbyDevice() {
        return this.mStandbyDevice;
    }

    public String getmMac() {
        return this.mMac;
    }

    public float getmPreciseDistance() {
        return this.mPreciseDistance;
    }

    public String getmRelativeDistance() {
        return this.mRelativeDistance;
    }

    public String getmRssi() {
        return this.mRssi;
    }

    public String getmSN() {
        return this.mSN;
    }

    public int getmStatus() {
        return this.mStatus;
    }

    public void setStandbyDevice(String str) {
        this.mStandbyDevice = str;
    }

    public void setmMac(String str) {
        this.mMac = str;
    }

    public void setmPreciseDistance(float f10) {
        this.mPreciseDistance = f10;
    }

    public void setmRelativeDistance(String str) {
        this.mRelativeDistance = str;
    }

    public void setmRssi(String str) {
        this.mRssi = str;
    }

    public void setmSN(String str) {
        this.mSN = str;
    }

    public void setmStatus(int i10) {
        this.mStatus = i10;
    }

    public String toString() {
        return "FindNetworkScanResult{fid=" + MaskUtil.maskSn(this.mSN) + ", mStatus=" + this.mStatus + ", mRssi=" + this.mRssi + ", mMac=" + MaskUtil.maskMac(this.mMac) + ", mStandbyDevice=" + MaskUtil.maskCommon(this.mStandbyDevice) + '}';
    }
}
