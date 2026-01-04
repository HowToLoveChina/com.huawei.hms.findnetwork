package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class StartCursor extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String startCursor;

    public String getCategory() {
        return this.category;
    }

    public String getStartCursor() {
        return this.startCursor;
    }

    public StartCursor setCategory(String str) {
        this.category = str;
        return this;
    }

    public StartCursor setStartCursor(String str) {
        this.startCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public StartCursor set(String str, Object obj) {
        return (StartCursor) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public StartCursor clone() {
        return (StartCursor) super.clone();
    }
}
