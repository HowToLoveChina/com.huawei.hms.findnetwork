package com.huawei.hicloud.request.opengw.bean;

import com.huawei.hicloud.base.slice.SliceItem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class AddressParams {
    private int count;
    private String fek;

    /* renamed from: iv */
    private String f22815iv;
    private long length;
    private String name;
    private String server;
    private int type;
    private LinkedList<SliceItem<String>> sliceItems = new LinkedList<>();
    private List<Map<String, Object>> params = new ArrayList();

    public void addParams(Map<String, Object> map) {
        this.params.add(map);
    }

    public void addSlices(SliceItem<String> sliceItem) {
        this.sliceItems.add(sliceItem);
    }

    public int getCount() {
        return this.count;
    }

    public String getFek() {
        return this.fek;
    }

    public String getIv() {
        return this.f22815iv;
    }

    public long getLength() {
        return this.length;
    }

    public String getName() {
        return this.name;
    }

    public List<Map<String, Object>> getParams() {
        return this.params;
    }

    public String getServer() {
        return this.server;
    }

    public LinkedList<SliceItem<String>> getSliceItems() {
        return this.sliceItems;
    }

    public int getType() {
        return this.type;
    }

    public void increase(long j10) {
        this.length += j10;
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    public void setFek(String str) {
        this.fek = str;
    }

    public void setIv(String str) {
        this.f22815iv = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
