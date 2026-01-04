package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes5.dex */
public class HistoryVersionList extends C11707b {

    @InterfaceC4648p
    public String category;

    @InterfaceC4648p
    public List<HistoryVersion> historyVersions;

    @InterfaceC4648p
    public String nextCursor;

    public String getCategory() {
        return this.category;
    }

    public List<HistoryVersion> getHistoryVersions() {
        return this.historyVersions;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public HistoryVersionList setCategory(String str) {
        this.category = str;
        return this;
    }

    public HistoryVersionList setHistoryVersions(List<HistoryVersion> list) {
        this.historyVersions = list;
        return this;
    }

    public HistoryVersionList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public HistoryVersionList set(String str, Object obj) {
        return (HistoryVersionList) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public HistoryVersionList clone() {
        return (HistoryVersionList) super.clone();
    }
}
