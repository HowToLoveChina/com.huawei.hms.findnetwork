package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class BakList extends C11707b {

    @InterfaceC4648p
    private List<Bak> baks;

    @InterfaceC4648p
    private String nextCursor;

    public List<Bak> getBaks() {
        return this.baks;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public BakList setBaks(List<Bak> list) {
        this.baks = list;
        return this;
    }

    public BakList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public BakList set(String str, Object obj) {
        return (BakList) super.set(str, obj);
    }
}
