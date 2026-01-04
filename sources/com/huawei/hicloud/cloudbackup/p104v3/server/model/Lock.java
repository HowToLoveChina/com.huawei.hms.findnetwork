package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Lock extends C11707b {

    @InterfaceC4648p
    private List<String> cloudControlAction;

    @InterfaceC4648p
    private String lockAction;

    @InterfaceC4648p
    private String lockId;

    @InterfaceC4648p
    private Integer lockInterval;

    public List<String> getCloudControlAction() {
        return this.cloudControlAction;
    }

    public String getLockAction() {
        return this.lockAction;
    }

    public String getLockId() {
        return this.lockId;
    }

    public Integer getLockInterval() {
        return this.lockInterval;
    }

    public Lock setCloudControlAction(List<String> list) {
        this.cloudControlAction = list;
        return this;
    }

    public Lock setLockAction(String str) {
        this.lockAction = str;
        return this;
    }

    public Lock setLockId(String str) {
        this.lockId = str;
        return this;
    }

    public Lock setLockInterval(Integer num) {
        this.lockInterval = num;
        return this;
    }

    @Override // ni.C11707b, java.util.AbstractMap
    public String toString() {
        return "Lock{lockId='" + this.lockId + "', lockAction='" + this.lockAction + "', lockInterval=" + this.lockInterval + '}';
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Lock set(String str, Object obj) {
        return (Lock) super.set(str, obj);
    }
}
