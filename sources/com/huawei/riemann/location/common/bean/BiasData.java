package com.huawei.riemann.location.common.bean;

/* loaded from: classes5.dex */
public class BiasData {
    private static final double DOUBLE_ZERO = 1.0E-12d;
    private double biasX = 0.0d;
    private double biasY = 0.0d;
    private double biasZ = 0.0d;
    private double gNorm = 9.8d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof BiasData)) {
            return false;
        }
        BiasData biasData = (BiasData) obj;
        return Math.abs(this.biasX - biasData.biasX) <= DOUBLE_ZERO && Math.abs(this.biasY - biasData.biasY) <= DOUBLE_ZERO && Math.abs(this.biasZ - biasData.biasZ) <= DOUBLE_ZERO && Math.abs(this.gNorm - biasData.gNorm) <= DOUBLE_ZERO;
    }

    public double getBiasX() {
        return this.biasX;
    }

    public double getBiasY() {
        return this.biasY;
    }

    public double getBiasZ() {
        return this.biasZ;
    }

    public double getGNorm() {
        return this.gNorm;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setBiasX(double d10) {
        this.biasX = d10;
    }

    public void setBiasY(double d10) {
        this.biasY = d10;
    }

    public void setBiasZ(double d10) {
        this.biasZ = d10;
    }

    public void setgNorm(double d10) {
        this.gNorm = d10;
    }

    public String toString() {
        return "BiasData{biasX=" + this.biasX + ", biasY=" + this.biasY + ", biasZ=" + this.biasZ + ", gNorm=" + this.gNorm + '}';
    }
}
