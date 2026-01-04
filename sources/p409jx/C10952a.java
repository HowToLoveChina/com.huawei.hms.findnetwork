package p409jx;

import java.nio.charset.Charset;
import mx.C11541a;
import mx.C11549i;
import mx.C11550j;
import mx.C11557q;
import p376ix.C10631a;
import p502nx.EnumC11761a;
import p502nx.EnumC11763c;
import p502nx.EnumC11764d;
import p502nx.EnumC11765e;
import p594qx.C12422a;
import p594qx.C12424c;
import p594qx.C12425d;
import p594qx.C12426e;
import p594qx.C12427f;
import p594qx.C12428g;

/* renamed from: jx.a */
/* loaded from: classes9.dex */
public class C10952a {
    /* renamed from: a */
    public final int m66076a(String str, Charset charset) {
        return C10955d.m66104b(str, charset).length;
    }

    /* renamed from: b */
    public final byte[] m66077b(boolean z10, C11557q c11557q, Charset charset) {
        byte[] bArr = new byte[2];
        bArr[0] = m66080e(z10, c11557q);
        if (charset == null || C12425d.f57265b.equals(charset)) {
            bArr[1] = C12422a.m74570b(bArr[1], 3);
        }
        return bArr;
    }

    /* renamed from: c */
    public final C11541a m66078c(C11557q c11557q) throws C10631a {
        C11541a c11541a = new C11541a();
        if (c11557q.m68991b() != null) {
            c11541a.m68849i(c11557q.m68991b());
        }
        EnumC11761a enumC11761aM68990a = c11557q.m68990a();
        EnumC11761a enumC11761a = EnumC11761a.KEY_STRENGTH_128;
        if (enumC11761aM68990a == enumC11761a) {
            c11541a.m68848h(enumC11761a);
        } else {
            EnumC11761a enumC11761aM68990a2 = c11557q.m68990a();
            EnumC11761a enumC11761a2 = EnumC11761a.KEY_STRENGTH_192;
            if (enumC11761aM68990a2 == enumC11761a2) {
                c11541a.m68848h(enumC11761a2);
            } else {
                EnumC11761a enumC11761aM68990a3 = c11557q.m68990a();
                EnumC11761a enumC11761a3 = EnumC11761a.KEY_STRENGTH_256;
                if (enumC11761aM68990a3 != enumC11761a3) {
                    throw new C10631a("invalid AES key strength");
                }
                c11541a.m68848h(enumC11761a3);
            }
        }
        c11541a.m68850j(c11557q.m68993d());
        return c11541a;
    }

    /* renamed from: d */
    public C11549i m66079d(C11557q c11557q, boolean z10, int i10, Charset charset, C12426e c12426e) throws C10631a {
        C11549i c11549i = new C11549i();
        c11549i.m68966b(EnumC10954c.CENTRAL_DIRECTORY);
        c11549i.m68926X(C12428g.m74618a(c11557q, c12426e));
        c11549i.m68862J(C12428g.m74619b(c11557q).m66129b());
        if (c11557q.m69004o() && c11557q.m68995f() == EnumC11765e.AES) {
            c11549i.m68883v(EnumC11764d.AES_INTERNAL_ONLY);
            c11549i.m68881t(m66078c(c11557q));
            c11549i.m68855C(c11549i.m68870i() + 11);
        } else {
            c11549i.m68883v(c11557q.m68993d());
        }
        if (c11557q.m69004o()) {
            if (c11557q.m68995f() == null || c11557q.m68995f() == EnumC11765e.NONE) {
                throw new C10631a("Encryption method has to be set when encryptFiles flag is set in zip parameters");
            }
            c11549i.m68887z(true);
            c11549i.m68853A(c11557q.m68995f());
        }
        String strM66082g = m66082g(c11557q.m69000k());
        c11549i.m68856D(strM66082g);
        c11549i.m68857E(m66076a(strM66082g, charset));
        if (!z10) {
            i10 = 0;
        }
        c11549i.m68920R(i10);
        c11549i.m68860H(C12427f.m74615e(c11557q.m69001l()));
        boolean zM74593u = C12424c.m74593u(strM66082g);
        c11549i.m68886y(zM74593u);
        c11549i.m68921S(C12424c.m74578f(zM74593u));
        if (c11557q.m69010u() && c11557q.m68997h() == -1) {
            c11549i.m68861I(0L);
        } else {
            c11549i.m68861I(c11557q.m68997h());
        }
        if (c11557q.m69004o() && c11557q.m68995f() == EnumC11765e.ZIP_STANDARD) {
            c11549i.m68884w(c11557q.m68996g());
        }
        c11549i.m68859G(m66077b(c11549i.m68879r(), c11557q, charset));
        c11549i.m68885x(c11557q.m69010u());
        c11549i.m68922T(c11557q.m68999j());
        return c11549i;
    }

    /* renamed from: e */
    public final byte m66080e(boolean z10, C11557q c11557q) {
        byte bM74570b = z10 ? C12422a.m74570b((byte) 0, 0) : (byte) 0;
        if (EnumC11764d.DEFLATE.equals(c11557q.m68993d())) {
            if (EnumC11763c.NORMAL.equals(c11557q.m68992c())) {
                bM74570b = C12422a.m74571c(C12422a.m74571c(bM74570b, 1), 2);
            } else if (EnumC11763c.MAXIMUM.equals(c11557q.m68992c())) {
                bM74570b = C12422a.m74571c(C12422a.m74570b(bM74570b, 1), 2);
            } else if (EnumC11763c.FAST.equals(c11557q.m68992c())) {
                bM74570b = C12422a.m74570b(C12422a.m74571c(bM74570b, 1), 2);
            } else if (EnumC11763c.FASTEST.equals(c11557q.m68992c()) || EnumC11763c.ULTRA.equals(c11557q.m68992c())) {
                bM74570b = C12422a.m74570b(C12422a.m74570b(bM74570b, 1), 2);
            }
        }
        return c11557q.m69010u() ? C12422a.m74570b(bM74570b, 3) : bM74570b;
    }

    /* renamed from: f */
    public C11550j m66081f(C11549i c11549i) {
        C11550j c11550j = new C11550j();
        c11550j.m68966b(EnumC10954c.LOCAL_FILE_HEADER);
        c11550j.m68862J(c11549i.m68876o());
        c11550j.m68883v(c11549i.m68866e());
        c11550j.m68860H(c11549i.m68874m());
        c11550j.m68861I(c11549i.m68875n());
        c11550j.m68857E(c11549i.m68872k());
        c11550j.m68856D(c11549i.m68871j());
        c11550j.m68887z(c11549i.m68879r());
        c11550j.m68853A(c11549i.m68868g());
        c11550j.m68881t(c11549i.m68864c());
        c11550j.m68884w(c11549i.m68867f());
        c11550j.m68882u(c11549i.m68865d());
        c11550j.m68859G((byte[]) c11549i.m68873l().clone());
        c11550j.m68885x(c11549i.m68878q());
        c11550j.m68855C(c11549i.m68870i());
        return c11550j;
    }

    /* renamed from: g */
    public final String m66082g(String str) throws C10631a {
        if (C12427f.m74616f(str)) {
            return str;
        }
        throw new C10631a("fileNameInZip is null or empty");
    }
}
