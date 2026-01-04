package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public final class Change extends C11707b {

    @InterfaceC4648p
    private String changeType;

    @InterfaceC4648p
    private Boolean deleted;

    @InterfaceC4648p
    private String device;

    /* renamed from: id */
    @InterfaceC4648p
    private String f13033id;

    @InterfaceC4648p
    private String ownerId;

    @InterfaceC4648p
    private Record record;

    @InterfaceC4648p
    private C4644l time;

    public String getChangeType() {
        return this.changeType;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getDevice() {
        return this.device;
    }

    public String getId() {
        return this.f13033id;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public Record getRecord() {
        return this.record;
    }

    public C4644l getTime() {
        return this.time;
    }

    public Change setChangeType(String str) {
        this.changeType = str;
        return this;
    }

    public Change setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Change setDevice(String str) {
        this.device = str;
        return this;
    }

    public Change setId(String str) {
        this.f13033id = str;
        return this;
    }

    public Change setOwnerId(String str) {
        this.ownerId = str;
        return this;
    }

    public Change setRecord(Record record) {
        this.record = record;
        return this;
    }

    public Change setTime(C4644l c4644l) {
        this.time = c4644l;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }
}
