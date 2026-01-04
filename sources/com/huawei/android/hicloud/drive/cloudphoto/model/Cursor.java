package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;
import p765x7.C13719a;

/* loaded from: classes3.dex */
public final class Cursor extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String fullUploadCursor;

    @InterfaceC4648p
    private String startCursor;

    public String getBigStartCursor() {
        return C13719a.m82475c(this.startCursor);
    }

    public String getCategory() {
        return this.category;
    }

    public String getFullUploadCursor() {
        return this.fullUploadCursor;
    }

    public String getStartCursor() {
        return this.startCursor;
    }

    public Cursor setCategory(String str) {
        this.category = str;
        return this;
    }

    public Cursor setFullUploadCursor(String str) {
        this.fullUploadCursor = str;
        return this;
    }

    public Cursor setStartCursor(String str) {
        this.startCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Cursor set(String str, Object obj) {
        return (Cursor) super.set(str, obj);
    }
}
