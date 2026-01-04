package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class Next2hmosMappingItem {
    private List<ApkBean> apk;
    private List<BundleBean> bundle;

    public List<ApkBean> getApk() {
        return this.apk;
    }

    public List<BundleBean> getBundle() {
        return this.bundle;
    }

    public void setApk(List<ApkBean> list) {
        this.apk = list;
    }

    public void setBundle(List<BundleBean> list) {
        this.bundle = list;
    }

    public String toString() {
        return "Next2hmosMappingItem{bundle=" + this.bundle + ", apk=" + this.apk + '}';
    }
}
