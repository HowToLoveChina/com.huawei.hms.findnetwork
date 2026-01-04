package com.huawei.android.hicloud.drive.asset;

import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import fk.C9721b;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface AssetMetadataTransport {

    /* renamed from: com.huawei.android.hicloud.drive.asset.AssetMetadataTransport$a */
    public static class C2796a {
    }

    Asset onCreateUploadUrl(String str, String str2, String str3, Asset asset, C2796a c2796a) throws C9721b, IOException;

    Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset) throws IOException;

    void onUploadCompleted(String str, String str2, String str3, Asset asset, boolean z10) throws C9721b, IOException;
}
