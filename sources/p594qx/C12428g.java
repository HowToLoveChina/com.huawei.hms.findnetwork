package p594qx;

import mx.C11557q;
import p409jx.EnumC10957f;
import p409jx.EnumC10958g;
import p502nx.EnumC11764d;
import p502nx.EnumC11765e;

/* renamed from: qx.g */
/* loaded from: classes9.dex */
public class C12428g {
    /* renamed from: a */
    public static int m74618a(C11557q c11557q, C12426e c12426e) {
        byte[] bArr = {EnumC10957f.SPECIFICATION_VERSION.m66128b(), EnumC10957f.UNIX.m66128b()};
        if (C12424c.m74592t() && !c11557q.m69009t()) {
            bArr[1] = EnumC10957f.WINDOWS.m66128b();
        }
        return c12426e.m74603h(bArr, 0);
    }

    /* renamed from: b */
    public static EnumC10958g m74619b(C11557q c11557q) {
        EnumC10958g enumC10958g = EnumC10958g.DEFAULT;
        if (c11557q.m68993d() == EnumC11764d.DEFLATE) {
            enumC10958g = EnumC10958g.DEFLATE_COMPRESSED;
        }
        if (c11557q.m68997h() > 4294967295L) {
            enumC10958g = EnumC10958g.ZIP_64_FORMAT;
        }
        return (c11557q.m69004o() && c11557q.m68995f().equals(EnumC11765e.AES)) ? EnumC10958g.AES_ENCRYPTED : enumC10958g;
    }
}
