package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0;

/* renamed from: com.google.crypto.tink.shaded.protobuf.b */
/* loaded from: classes.dex */
public abstract class AbstractC1899b<MessageType extends InterfaceC1951s0> implements InterfaceC1898a1<MessageType> {

    /* renamed from: a */
    public static final C1944q f9084a = C1944q.m12103b();

    /* renamed from: c */
    public final MessageType m11482c(MessageType messagetype) throws C1903c0 {
        if (messagetype == null || messagetype.mo12209m()) {
            return messagetype;
        }
        throw m11483d(messagetype).m12057b().m11511k(messagetype);
    }

    /* renamed from: d */
    public final C1937n1 m11483d(MessageType messagetype) {
        return messagetype instanceof AbstractC1896a ? ((AbstractC1896a) messagetype).m11461n() : new C1937n1(messagetype);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessageType mo11480a(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (MessageType) m11482c(m11485f(abstractC1920i, c1944q));
    }

    /* renamed from: f */
    public MessageType m11485f(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        AbstractC1923j abstractC1923jMo11694o = abstractC1920i.mo11694o();
        MessageType messagetypeMo11481b = mo11481b(abstractC1923jMo11694o, c1944q);
        try {
            abstractC1923jMo11694o.mo11727a(0);
            return messagetypeMo11481b;
        } catch (C1903c0 e10) {
            throw e10.m11511k(messagetypeMo11481b);
        }
    }
}
