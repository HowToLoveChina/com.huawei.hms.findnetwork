package com.huawei.cloud.pay.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class DegradePackageSortData implements Comparable<DegradePackageSortData> {
    private long capacity;
    private String label;
    private List<CloudPackage> monthPackages = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.capacity == ((DegradePackageSortData) obj).capacity;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public String getLabel() {
        return this.label;
    }

    public List<CloudPackage> getMonthPackages() {
        return this.monthPackages;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.capacity));
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setMonthPackages(List<CloudPackage> list) {
        this.monthPackages = list;
    }

    @Override // java.lang.Comparable
    public int compareTo(DegradePackageSortData degradePackageSortData) {
        long j10 = this.capacity - degradePackageSortData.capacity;
        if (j10 > 0) {
            return -1;
        }
        return j10 < 0 ? 1 : 0;
    }
}
