package com.huawei.cloud.pay.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes5.dex */
public class GetAvailablePackagesSortData implements Comparable<GetAvailablePackagesSortData> {
    private long capacity;
    private boolean isDefaultSort;
    private String label;
    private HashSet<Integer> showSeqSet = new HashSet<>();
    private ArrayList<CloudPackage> dataList = new ArrayList<>();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.capacity == ((GetAvailablePackagesSortData) obj).capacity;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public ArrayList<CloudPackage> getDataList() {
        return this.dataList;
    }

    public String getLabel() {
        return this.label;
    }

    public ArrayList<CloudPackage> getMonthPayList() {
        ArrayList<CloudPackage> arrayList = new ArrayList<>();
        if (this.dataList.isEmpty()) {
            return arrayList;
        }
        Iterator<CloudPackage> it = this.dataList.iterator();
        while (it.hasNext()) {
            CloudPackage next = it.next();
            int productType = next.getProductType();
            if (productType == 6 || productType == 8) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public HashSet<Integer> getShowSeqSet() {
        return this.showSeqSet;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.capacity));
    }

    public boolean isDefaultSort() {
        return this.isDefaultSort;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setDataList(ArrayList<CloudPackage> arrayList) {
        this.dataList = arrayList;
    }

    public void setDefaultSort(boolean z10) {
        this.isDefaultSort = z10;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setShowSeqSet(HashSet<Integer> hashSet) {
        this.showSeqSet = hashSet;
    }

    @Override // java.lang.Comparable
    public int compareTo(GetAvailablePackagesSortData getAvailablePackagesSortData) {
        long j10 = this.capacity - getAvailablePackagesSortData.capacity;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }
}
