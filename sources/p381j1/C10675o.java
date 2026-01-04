package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import p323h1.C10077a;
import p354i1.InterfaceC10408t;

/* renamed from: j1.o */
/* loaded from: classes.dex */
public class C10675o implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10675o f51308a = new C10675o();

    /* renamed from: j1.o$a */
    public static class a {

        /* renamed from: a */
        public byte[] f51309a;

        /* renamed from: b */
        public int f51310b;

        /* renamed from: c */
        public int f51311c;

        /* renamed from: a */
        public ByteBuffer m65308a() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f51309a);
            byteBufferWrap.limit(this.f51310b);
            byteBufferWrap.position(this.f51311c);
            return byteBufferWrap;
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        return (T) ((a) c10077a.m62721b0(a.class)).m65308a();
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 14;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byte[] bArrArray = byteBuffer.array();
        C10650d1 c10650d1 = c10664i0.f51258k;
        c10650d1.write(123);
        c10650d1.m65209B("array");
        c10650d1.m65239y(bArrArray);
        c10650d1.m65212E(',', "limit", byteBuffer.limit());
        c10650d1.m65212E(',', "position", byteBuffer.position());
        c10650d1.write(125);
    }
}
