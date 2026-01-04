package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC1896a;
import com.google.crypto.tink.shaded.protobuf.AbstractC1896a.a;
import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0;
import java.io.IOException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.a */
/* loaded from: classes.dex */
public abstract class AbstractC1896a<MessageType extends AbstractC1896a<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements InterfaceC1951s0 {
    protected int memoizedHashCode = 0;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.a$a */
    public static abstract class a<MessageType extends AbstractC1896a<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements InterfaceC1951s0.a {
        /* renamed from: n */
        public static C1937n1 m11463n(InterfaceC1951s0 interfaceC1951s0) {
            return new C1937n1(interfaceC1951s0);
        }

        /* renamed from: a */
        public abstract BuilderType mo11464a(MessageType messagetype);

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BuilderType mo11466h(InterfaceC1951s0 interfaceC1951s0) {
            if (mo12208c().getClass().isInstance(interfaceC1951s0)) {
                return (BuilderType) mo11464a((AbstractC1896a) interfaceC1951s0);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    /* renamed from: a */
    public int mo11456a() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public int m11457b(InterfaceC1919h1 interfaceC1919h1) {
        int iMo11456a = mo11456a();
        if (iMo11456a != -1) {
            return iMo11456a;
        }
        int iMo11674h = interfaceC1919h1.mo11674h(this);
        mo11462o(iMo11674h);
        return iMo11674h;
    }

    /* renamed from: e */
    public final String m11458e(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0
    /* renamed from: g */
    public AbstractC1920i mo11459g() {
        try {
            AbstractC1920i.h hVarM11685n = AbstractC1920i.m11685n(mo12140i());
            mo12139f(hVarM11685n.m11708b());
            return hVarM11685n.m11707a();
        } catch (IOException e10) {
            throw new RuntimeException(this.m11458e("ByteString"), e10);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0
    /* renamed from: j */
    public byte[] mo11460j() {
        try {
            byte[] bArr = new byte[mo12140i()];
            AbstractC1929l abstractC1929lM11902d0 = AbstractC1929l.m11902d0(bArr);
            mo12139f(abstractC1929lM11902d0);
            abstractC1929lM11902d0.m11944c();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(m11458e("byte array"), e10);
        }
    }

    /* renamed from: n */
    public C1937n1 m11461n() {
        return new C1937n1(this);
    }

    /* renamed from: o */
    public void mo11462o(int i10) {
        throw new UnsupportedOperationException();
    }
}
