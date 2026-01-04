package com.tencent.p204mm.opensdk.channel.p205a;

import com.tencent.p204mm.opensdk.utils.C8929b;

/* renamed from: com.tencent.mm.opensdk.channel.a.b */
/* loaded from: classes9.dex */
public final class C8918b {
    /* renamed from: a */
    public static byte[] m56625a(String str, int i10, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i10);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C8929b.m56645c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
