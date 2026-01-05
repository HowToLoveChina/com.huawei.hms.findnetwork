package com.huawei.wisesecurity.ucs.credential.entity;

import p239dw.C9320b;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12042i;
import p857zv.Exception_C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class EcKeyPair {
    public byte[] privateKey;
    public byte[] publicKey;

    public static final class Builder {

        @InterfaceC12042i
        private byte[] privateKey;

        @InterfaceC12042i
        private byte[] publicKey;

        private Builder() {
        }

        public EcKeyPair build() throws Exception_C14389c {
            try {
                C11756a.m70079b(this);
                return new EcKeyPair(this);
            } catch (C10626e e10) {
                StringBuilder errmsg = C9320b.m58651a("EcKeyPair build check param error : ");
                errmsg.append(e10.getMessage());
                throw new C14391e(errmsg.toString());
            }
        }

        public Builder privateKey(byte[] bArr) {
            this.privateKey = bArr;
            return this;
        }

        public Builder publicKey(byte[] bArr) {
            this.publicKey = bArr;
            return this;
        }
    }

    private EcKeyPair(Builder builder) {
        this.publicKey = builder.publicKey;
        this.privateKey = builder.privateKey;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public byte[] getPrivateKey() {
        return this.privateKey;
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }
}
