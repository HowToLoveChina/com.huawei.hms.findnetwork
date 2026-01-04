package p003a2;

/* renamed from: a2.f */
/* loaded from: classes.dex */
public final class C0011f implements InterfaceC0006a<byte[]> {
    @Override // p003a2.InterfaceC0006a
    /* renamed from: a */
    public String mo5a() {
        return "ByteArrayPool";
    }

    @Override // p003a2.InterfaceC0006a
    /* renamed from: b */
    public int mo6b() {
        return 1;
    }

    @Override // p003a2.InterfaceC0006a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int mo7c(byte[] bArr) {
        return bArr.length;
    }

    @Override // p003a2.InterfaceC0006a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i10) {
        return new byte[i10];
    }
}
