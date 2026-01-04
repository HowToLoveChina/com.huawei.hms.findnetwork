package p415k2;

import android.graphics.Bitmap;
import p003a2.InterfaceC0007b;
import p003a2.InterfaceC0009d;
import p725w1.InterfaceC13516a;

/* renamed from: k2.a */
/* loaded from: classes.dex */
public final class C10972a implements InterfaceC13516a.a {

    /* renamed from: a */
    public final InterfaceC0009d f51996a;

    /* renamed from: b */
    public final InterfaceC0007b f51997b;

    public C10972a(InterfaceC0009d interfaceC0009d, InterfaceC0007b interfaceC0007b) {
        this.f51996a = interfaceC0009d;
        this.f51997b = interfaceC0007b;
    }

    @Override // p725w1.InterfaceC13516a.a
    /* renamed from: a */
    public Bitmap mo66297a(int i10, int i11, Bitmap.Config config) {
        return this.f51996a.mo17d(i10, i11, config);
    }

    @Override // p725w1.InterfaceC13516a.a
    /* renamed from: b */
    public int[] mo66298b(int i10) {
        InterfaceC0007b interfaceC0007b = this.f51997b;
        return interfaceC0007b == null ? new int[i10] : (int[]) interfaceC0007b.mo10c(i10, int[].class);
    }

    @Override // p725w1.InterfaceC13516a.a
    /* renamed from: c */
    public void mo66299c(Bitmap bitmap) {
        this.f51996a.mo15b(bitmap);
    }

    @Override // p725w1.InterfaceC13516a.a
    /* renamed from: d */
    public void mo66300d(byte[] bArr) {
        InterfaceC0007b interfaceC0007b = this.f51997b;
        if (interfaceC0007b == null) {
            return;
        }
        interfaceC0007b.put(bArr);
    }

    @Override // p725w1.InterfaceC13516a.a
    /* renamed from: e */
    public byte[] mo66301e(int i10) {
        InterfaceC0007b interfaceC0007b = this.f51997b;
        return interfaceC0007b == null ? new byte[i10] : (byte[]) interfaceC0007b.mo10c(i10, byte[].class);
    }

    @Override // p725w1.InterfaceC13516a.a
    /* renamed from: f */
    public void mo66302f(int[] iArr) {
        InterfaceC0007b interfaceC0007b = this.f51997b;
        if (interfaceC0007b == null) {
            return;
        }
        interfaceC0007b.put(iArr);
    }
}
