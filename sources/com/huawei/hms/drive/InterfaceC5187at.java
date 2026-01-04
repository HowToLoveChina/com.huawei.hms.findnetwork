package com.huawei.hms.drive;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.huawei.hms.drive.at */
/* loaded from: classes8.dex */
public interface InterfaceC5187at {

    /* renamed from: a */
    public static final InterfaceC5187at f23774a = new InterfaceC5187at() { // from class: com.huawei.hms.drive.c0
        @Override // com.huawei.hms.drive.InterfaceC5187at
        public final List lookup(String str) {
            return InterfaceC5187at.m30886a(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    static /* synthetic */ List m30886a(String str) throws UnknownHostException {
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
