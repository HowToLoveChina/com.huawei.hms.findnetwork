package com.huawei.location.nlp.network.request;

import com.huawei.location.C6769i;
import java.util.List;

/* loaded from: classes8.dex */
public class RequestExtraInfo {
    int arStatus;
    List<CacheLocationOnline> cacheLocationList;
    List<IndoorLocation> indoorGlobalLocation;
    List<IndoorLocation> indoorLocalLocation;
    int isFilter;
    NLPLocationOnLine nlpLastLocation;

    public int getArStatus() {
        return this.arStatus;
    }

    public List<CacheLocationOnline> getCacheLocationList() {
        return this.cacheLocationList;
    }

    public List<IndoorLocation> getIndoorGlobalLocation() {
        return this.indoorGlobalLocation;
    }

    public List<IndoorLocation> getIndoorLocalLocation() {
        return this.indoorLocalLocation;
    }

    public int getIsFilter() {
        return this.isFilter;
    }

    public NLPLocationOnLine getNlpLastLocation() {
        return this.nlpLastLocation;
    }

    public void setArStatus(int i10) {
        this.arStatus = i10;
    }

    public void setCacheLocationList(List<CacheLocationOnline> list) {
        this.cacheLocationList = list;
    }

    public void setIndoorGlobalLocation(List<IndoorLocation> list) {
        this.indoorGlobalLocation = list;
    }

    public void setIndoorLocalLocation(List<IndoorLocation> list) {
        this.indoorLocalLocation = list;
    }

    public void setIsFilter(int i10) {
        this.isFilter = i10;
    }

    public void setNlpLastLocation(NLPLocationOnLine nLPLocationOnLine) {
        this.nlpLastLocation = nLPLocationOnLine;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("RequestExtraInfo{nlpLastLocation=");
        sb2.append(this.nlpLastLocation);
        sb2.append(", cacheLocationList=");
        sb2.append(this.cacheLocationList);
        sb2.append(", indoorGlobalLocation=");
        sb2.append(this.indoorGlobalLocation);
        sb2.append(", indoorLocalLocation=");
        sb2.append(this.indoorLocalLocation);
        sb2.append(", arStatus=");
        sb2.append(this.arStatus);
        sb2.append(", isFilter=");
        return C6769i.m38373a(sb2, this.isFilter, '}');
    }
}
