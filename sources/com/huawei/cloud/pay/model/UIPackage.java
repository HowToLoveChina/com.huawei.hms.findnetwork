package com.huawei.cloud.pay.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class UIPackage implements Comparable<UIPackage> {
    private long capacity;
    private List<CloudPackage> packages = new ArrayList();
    private String spaceTag;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.capacity == ((UIPackage) obj).capacity;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public List<CloudPackage> getPackages() {
        return this.packages;
    }

    public String getSpaceTag() {
        return this.spaceTag;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.capacity));
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setPackages(List<CloudPackage> list) {
        this.packages = list;
    }

    public void setSpaceTag(String str) {
        this.spaceTag = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(UIPackage uIPackage) {
        long j10 = this.capacity - uIPackage.capacity;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }
}
