package com.huawei.wisesecurity.ucs.credential.outer;

import java.io.IOException;
import p857zv.C14389c;

/* loaded from: classes9.dex */
public interface NetworkCapability {
    NetworkResponse get(NetworkRequest networkRequest) throws IOException;

    void initConfig(int i10, int i11) throws C14389c;

    NetworkResponse post(NetworkRequest networkRequest) throws IOException;
}
