package com.huawei.hicloud.request.opengw.bean;

import com.huawei.hicloud.base.slice.SliceItem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class DownloadAddress {
    private long aLength;
    private String fek;

    /* renamed from: iv */
    private String f22816iv;
    private int type;
    private List<Address> addresses = new ArrayList();
    private LinkedList<SliceItem<String>> sliceItems = new LinkedList<>();

    public void addAddresses(Address address) {
        this.addresses.add(address);
    }

    public void addSlices(SliceItem<String> sliceItem) {
        this.sliceItems.add(sliceItem);
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public String getFek() {
        return this.fek;
    }

    public String getIv() {
        return this.f22816iv;
    }

    public LinkedList<SliceItem<String>> getSliceItems() {
        return this.sliceItems;
    }

    public int getType() {
        return this.type;
    }

    public long getaLength() {
        return this.aLength;
    }

    public void setAddresses(List<Address> list) {
        this.addresses = list;
    }

    public void setFek(String str) {
        this.fek = str;
    }

    public void setIv(String str) {
        this.f22816iv = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setaLength(long j10) {
        this.aLength = j10;
    }
}
