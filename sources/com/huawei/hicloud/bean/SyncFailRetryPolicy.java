package com.huawei.hicloud.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class SyncFailRetryPolicy {
    private List<RetryPolicy> retryPolicyList;

    public List<RetryPolicy> getRetryPolicyList() {
        return this.retryPolicyList;
    }

    public void setRetryPolicyList(List<RetryPolicy> list) {
        this.retryPolicyList = list;
    }
}
