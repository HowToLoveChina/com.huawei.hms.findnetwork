package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class BakRefreshRequestNoLock extends C11707b {

    @InterfaceC4648p
    Integer occupySpaceType;

    @InterfaceC4648p
    private Map<String, String> properties;

    public Integer getOccupySpaceType() {
        return this.occupySpaceType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setOccupySpaceType(Integer num) {
        this.occupySpaceType = num;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }
}
