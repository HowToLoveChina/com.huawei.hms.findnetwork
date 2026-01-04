package cv;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import mv.C11529b;
import p374iv.C10622a;

/* renamed from: cv.a */
/* loaded from: classes9.dex */
public interface InterfaceC8954a {

    /* renamed from: a */
    public static final InterfaceC8954a f45454a = new a();

    /* renamed from: b */
    public static final InterfaceC8954a f45455b = new b();

    /* renamed from: c */
    public static final InterfaceC8954a f45456c = new c();

    /* renamed from: d */
    public static final InterfaceC8954a f45457d = new d();

    /* renamed from: cv.a$a */
    public static class a implements InterfaceC8954a {
        @Override // cv.InterfaceC8954a
        /* renamed from: b */
        public byte[] mo56697b(String str) throws C10622a {
            try {
                return Base64.decode(str, 0);
            } catch (Exception e10) {
                throw new C10622a("Base64 decode fail : " + e10.getMessage());
            }
        }
    }

    /* renamed from: cv.a$b */
    public static class b implements InterfaceC8954a {
        @Override // cv.InterfaceC8954a
        /* renamed from: b */
        public byte[] mo56697b(String str) throws C10622a {
            try {
                return Base64.decode(str, 8);
            } catch (Exception e10) {
                throw new C10622a("Base64 decode fail : " + e10.getMessage());
            }
        }
    }

    /* renamed from: cv.a$c */
    public static class c implements InterfaceC8954a {
        @Override // cv.InterfaceC8954a
        /* renamed from: b */
        public byte[] mo56697b(String str) throws C10622a {
            return C11529b.m68814b(str);
        }
    }

    /* renamed from: cv.a$d */
    public static class d implements InterfaceC8954a {
        @Override // cv.InterfaceC8954a
        /* renamed from: b */
        public byte[] mo56697b(String str) throws C10622a {
            return str.getBytes(StandardCharsets.UTF_8);
        }
    }

    /* renamed from: b */
    byte[] mo56697b(String str) throws C10622a;
}
