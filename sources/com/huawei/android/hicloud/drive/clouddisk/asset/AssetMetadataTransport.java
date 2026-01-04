package com.huawei.android.hicloud.drive.clouddisk.asset;

import com.huawei.android.hicloud.drive.clouddisk.model.Asset;
import com.huawei.android.hicloud.drive.clouddisk.model.Resource;
import fk.C9721b;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface AssetMetadataTransport<T> {
    Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset, boolean z10) throws C9721b, IOException;
}
