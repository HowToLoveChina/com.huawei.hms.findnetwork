package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public final class ChangeList extends C11707b {

    @InterfaceC4648p
    private List<Change> changes;

    @InterfaceC4648p
    private String newStartCursor;

    @InterfaceC4648p
    private String nextCursor;

    public List<Change> getChanges() {
        return this.changes;
    }

    public String getNewStartCursor() {
        return this.newStartCursor;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public ChangeList setChanges(List<Change> list) {
        this.changes = list;
        return this;
    }

    public ChangeList setNewStartCursor(String str) {
        this.newStartCursor = str;
        return this;
    }

    public ChangeList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ChangeList set(String str, Object obj) {
        return (ChangeList) super.set(str, obj);
    }
}
