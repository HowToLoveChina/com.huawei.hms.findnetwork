package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class GetPackageResp extends Response {
    private List<CloudPackage> spacePackages;

    public List<CloudPackage> getSpacePackages() {
        return this.spacePackages;
    }

    public void setSpacePackages(List<CloudPackage> list) {
        this.spacePackages = list;
    }
}
