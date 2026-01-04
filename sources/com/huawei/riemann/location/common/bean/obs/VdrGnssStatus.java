package com.huawei.riemann.location.common.bean.obs;

/* loaded from: classes5.dex */
public class VdrGnssStatus {
    long utc = 0;
    double bootTime = 0.0d;
    double azimuth = 0.0d;
    double basebandCn0DbHz = 0.0d;
    double carrierFrequencyHz = 0.0d;
    double cn0DbHz = 0.0d;
    int constellationType = 0;
    double elevationDegrees = 0.0d;
    int svid = 0;
    boolean usedInFix = false;

    public double getAzimuth() {
        return this.azimuth;
    }

    public double getBasebandCn0DbHz() {
        return this.basebandCn0DbHz;
    }

    public double getBootTime() {
        return this.bootTime;
    }

    public double getCarrierFrequencyHz() {
        return this.carrierFrequencyHz;
    }

    public double getCn0DbHz() {
        return this.cn0DbHz;
    }

    public int getConstellationType() {
        return this.constellationType;
    }

    public double getElevationDegrees() {
        return this.elevationDegrees;
    }

    public int getSvid() {
        return this.svid;
    }

    public double getUtc() {
        return this.utc;
    }

    public boolean isUsedInFix() {
        return this.usedInFix;
    }

    public void setAzimuth(double d10) {
        this.azimuth = d10;
    }

    public void setBasebandCn0DbHz(double d10) {
        this.basebandCn0DbHz = d10;
    }

    public void setBootTime(double d10) {
        this.bootTime = d10;
    }

    public void setCarrierFrequencyHz(double d10) {
        this.carrierFrequencyHz = d10;
    }

    public void setCn0DbHz(double d10) {
        this.cn0DbHz = d10;
    }

    public void setConstellationType(int i10) {
        this.constellationType = i10;
    }

    public void setElevationDegrees(double d10) {
        this.elevationDegrees = d10;
    }

    public void setSvid(int i10) {
        this.svid = i10;
    }

    public void setUsedInFix(boolean z10) {
        this.usedInFix = z10;
    }

    public void setUtc(long j10) {
        this.utc = j10;
    }

    public String toString() {
        return "VdrGnssStatus{utc=" + String.valueOf(this.utc) + ", bootTime=" + this.bootTime + ", azimuth=" + this.azimuth + ", basebandCn0DbHz=" + this.basebandCn0DbHz + ", carrierFrequencyHz=" + this.carrierFrequencyHz + ", cn0DbHz=" + this.cn0DbHz + ", constellationType=" + this.constellationType + ", elevationDegrees=" + this.elevationDegrees + ", svid=" + this.svid + ", usedInFix=" + this.usedInFix + '}';
    }
}
