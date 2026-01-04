package p324h2;

import com.bumptech.glide.load.data.InterfaceC1564e;
import java.nio.ByteBuffer;

/* renamed from: h2.a */
/* loaded from: classes.dex */
public class C10087a implements InterfaceC1564e<ByteBuffer> {

    /* renamed from: a */
    public final ByteBuffer f49262a;

    /* renamed from: h2.a$a */
    public static class a implements InterfaceC1564e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: a */
        public Class<ByteBuffer> mo9014a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC1564e<ByteBuffer> mo9015b(ByteBuffer byteBuffer) {
            return new C10087a(byteBuffer);
        }
    }

    public C10087a(ByteBuffer byteBuffer) {
        this.f49262a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1564e
    /* renamed from: b */
    public void mo9012b() {
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1564e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer mo9011a() {
        this.f49262a.position(0);
        return this.f49262a;
    }
}
