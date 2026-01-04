package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSSmsCalllogReq extends CBSBaseReq {
    private List<String> keys;
    private long time;

    public CBSSmsCalllogReq(int i10, String str, List<String> list, long j10) {
        super(i10, str);
        this.keys = list;
        this.time = j10;
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public long getTime() {
        return this.time;
    }

    public void setKeys(List<String> list) {
        this.keys = list;
    }

    public void setTime(long j10) {
        this.time = j10;
    }
}
