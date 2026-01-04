package com.huawei.hms.core.aidl;

/* loaded from: classes8.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int i10) {
        return i10 == 2 ? new MessageCodecV2() : new MessageCodec();
    }
}
