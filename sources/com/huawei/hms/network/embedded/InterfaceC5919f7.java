package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.InterfaceC5919f7;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.f7 */
/* loaded from: classes8.dex */
public interface InterfaceC5919f7 {

    /* renamed from: a */
    public static final InterfaceC5919f7 f26768a = new InterfaceC5919f7() { // from class: gq.c
        @Override // com.huawei.hms.network.embedded.InterfaceC5919f7
        public final List lookup(String str) {
            return InterfaceC5919f7.m34227a(str);
        }
    };

    /* renamed from: a */
    static /* synthetic */ List m34227a(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        try {
            return Arrays.asList(InetAddress.getAllByName(str));
        } catch (NullPointerException e10) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
            unknownHostException.initCause(e10);
            throw unknownHostException;
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
