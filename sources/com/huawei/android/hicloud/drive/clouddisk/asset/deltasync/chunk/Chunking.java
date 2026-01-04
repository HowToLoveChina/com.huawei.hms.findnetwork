package com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk;

import com.huawei.android.hicloud.drive.clouddisk.model.Digest;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public interface Chunking {
    /* renamed from: a */
    int mo16343a();

    /* renamed from: b */
    Digest mo16344b(Digest digest, File file) throws NoSuchAlgorithmException, IOException;
}
