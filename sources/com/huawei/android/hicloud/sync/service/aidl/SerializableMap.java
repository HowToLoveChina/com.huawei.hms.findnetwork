package com.huawei.android.hicloud.sync.service.aidl;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class SerializableMap<T, K> implements Serializable {
    private static final long serialVersionUID = 1;
    private Map<T, K> map;

    public Map<T, K> getMap() {
        return this.map;
    }

    public void setMap(Map<T, K> map) {
        this.map = map;
    }
}
