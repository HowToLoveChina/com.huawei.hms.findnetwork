package com.huawei.fastengine.fastview.download.download;

import java.io.File;

/* loaded from: classes5.dex */
public interface DownloadListener {
    void failure(int i10);

    void progress(int i10, int i11);

    void success(File file);
}
