package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ReceiveActivityGiftResq extends Response {
    private boolean isEffect;
    private SpacePackage spacePackage;

    public class SpacePackage {
        private long capacity;
        private int durationMonth;
        private String durationName;
        private int durationUnit;
        private long effectEndTime;

        /* renamed from: id */
        private String f21415id;
        private String productName;
        private int productType;

        public SpacePackage() {
        }

        public long getCapacity() {
            return this.capacity;
        }

        public int getDurationMonth() {
            return this.durationMonth;
        }

        public String getDurationName() {
            return this.durationName;
        }

        public int getDurationUnit() {
            return this.durationUnit;
        }

        public long getEffectEndTime() {
            return this.effectEndTime;
        }

        public String getId() {
            return this.f21415id;
        }

        public String getProductName() {
            return this.productName;
        }

        public int getProductType() {
            return this.productType;
        }

        public void setCapacity(int i10) {
            this.capacity = i10;
        }

        public void setDurationMonth(int i10) {
            this.durationMonth = i10;
        }

        public void setDurationName(String str) {
            this.durationName = str;
        }

        public void setDurationUnit(int i10) {
            this.durationUnit = i10;
        }

        public void setEffectEndTime(long j10) {
            this.effectEndTime = j10;
        }

        public void setId(String str) {
            this.f21415id = str;
        }

        public void setProductName(String str) {
            this.productName = str;
        }

        public void setProductType(int i10) {
            this.productType = i10;
        }
    }

    public SpacePackage getSpacePackage() {
        return this.spacePackage;
    }

    public boolean isEffect() {
        return this.isEffect;
    }

    public void setEffect(boolean z10) {
        this.isEffect = z10;
    }

    public void setSpacePackage(SpacePackage spacePackage) {
        this.spacePackage = spacePackage;
    }
}
