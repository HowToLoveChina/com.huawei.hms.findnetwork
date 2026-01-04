package com.huawei.hicloud.cloudbackup.server.model;

import com.huawei.hicloud.cloudbackup.server.slice.Resource;

/* loaded from: classes6.dex */
public class ResourceResp extends BaseResponse {
    private Resource resource;

    public Resource getResource() {
        return this.resource;
    }

    public ResourceResp setResource(Resource resource) {
        this.resource = resource;
        return this;
    }
}
