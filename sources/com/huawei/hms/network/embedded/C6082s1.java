package com.huawei.hms.network.embedded;

import com.huawei.hms.network.base.common.trans.ByteString;

/* renamed from: com.huawei.hms.network.embedded.s1 */
/* loaded from: classes8.dex */
public class C6082s1 {
    public static final int BUFFER_SIZE = 8192;
    public static final int MAX_SIZE = 16777216;

    public static String key(String str) {
        if (str == null) {
            return null;
        }
        return ByteString.encodeUtf8(str).sha256().hex();
    }
}
