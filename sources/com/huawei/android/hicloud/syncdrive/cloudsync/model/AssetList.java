package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class AssetList extends C11707b {

    @InterfaceC4648p
    private List<Asset> assets;

    public List<Asset> getAssets() {
        return this.assets;
    }

    public AssetList setAssets(List<Asset> list) {
        this.assets = list;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public AssetList set(String str, Object obj) {
        return (AssetList) super.set(str, obj);
    }
}
