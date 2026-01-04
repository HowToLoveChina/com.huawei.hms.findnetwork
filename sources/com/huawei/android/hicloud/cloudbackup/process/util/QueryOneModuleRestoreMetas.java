package com.huawei.android.hicloud.cloudbackup.process.util;

import fk.C9721b;
import java.util.List;
import pl.C12168j;
import pl.C12169k;

/* loaded from: classes2.dex */
public class QueryOneModuleRestoreMetas {
    private static final int PAGE = 1000;
    private String appId;
    private int count;
    private int current;
    private int fileType;
    private C12169k metaOperator;
    private int total;

    public QueryOneModuleRestoreMetas(String str) throws C9721b {
        C12169k c12169k = new C12169k();
        this.metaOperator = c12169k;
        this.appId = str;
        this.total = c12169k.m73204g(str);
    }

    public int getCount() {
        return this.count;
    }

    public int getSize() {
        return this.total;
    }

    public boolean hasNext() {
        return this.current < this.count;
    }

    public void init(int i10) throws C9721b {
        this.current = 0;
        this.fileType = i10;
        if (i10 == 7) {
            this.count = this.metaOperator.m73206i(this.appId, i10);
        } else {
            this.count = this.metaOperator.m73205h(this.appId, i10);
        }
    }

    public List<C12168j> next() throws C9721b {
        int i10 = this.current;
        int i11 = this.count - i10;
        if (i11 >= 1000) {
            i11 = 1000;
        }
        this.current = i10 + i11;
        int i12 = this.fileType;
        return i12 == 7 ? this.metaOperator.m73210m(this.appId, i12, i11, i10) : this.metaOperator.m73209l(this.appId, i12, i11, i10);
    }
}
