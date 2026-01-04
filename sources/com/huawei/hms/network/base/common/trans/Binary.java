package com.huawei.hms.network.base.common.trans;

import java.io.OutputStream;

/* loaded from: classes8.dex */
public interface Binary {
    long getLength();

    void onWriteBinary(OutputStream outputStream);
}
