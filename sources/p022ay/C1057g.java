package p022ay;

import ax.C1045o;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import cy.C8963b;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kw.C11175g;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: ay.g */
/* loaded from: classes9.dex */
public class C1057g implements Serializable, Comparable<C1057g> {

    /* renamed from: d */
    public static final a f5135d = new a(null);

    /* renamed from: e */
    public static final C1057g f5136e = new C1057g(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final byte[] f5137a;

    /* renamed from: b */
    public transient int f5138b;

    /* renamed from: c */
    public transient String f5139c;

    /* renamed from: ay.g$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final C1057g m6389a(String str) {
            C13267j.m79677e(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) ((C8963b.m56723e(str.charAt(i11)) << 4) + C8963b.m56723e(str.charAt(i11 + 1)));
            }
            return new C1057g(bArr);
        }

        /* renamed from: b */
        public final C1057g m6390b(String str) {
            C13267j.m79677e(str, "<this>");
            C1057g c1057g = new C1057g(C1052b0.m6300a(str));
            c1057g.m6367B(str);
            return c1057g;
        }

        /* renamed from: c */
        public final C1057g m6391c(byte... bArr) {
            C13267j.m79677e(bArr, "data");
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            C13267j.m79676d(bArrCopyOf, "copyOf(this, size)");
            return new C1057g(bArrCopyOf);
        }

        /* renamed from: d */
        public final C1057g m6392d(InputStream inputStream, int i10) throws IOException {
            C13267j.m79677e(inputStream, "<this>");
            if (i10 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
            }
            byte[] bArr = new byte[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = inputStream.read(bArr, i11, i10 - i11);
                if (i12 == -1) {
                    throw new EOFException();
                }
                i11 += i12;
            }
            return new C1057g(bArr);
        }

        public a() {
        }
    }

    public C1057g(byte[] bArr) {
        C13267j.m79677e(bArr, "data");
        this.f5137a = bArr;
    }

    /* renamed from: f */
    public static final C1057g m6363f(String str) {
        return f5135d.m6389a(str);
    }

    /* renamed from: k */
    public static final C1057g m6364k(String str) {
        return f5135d.m6390b(str);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        C1057g c1057gM6392d = f5135d.m6392d(objectInputStream, objectInputStream.readInt());
        Field declaredField = C1057g.class.getDeclaredField(VideoPlayFlag.PLAY_IN_ALL);
        declaredField.setAccessible(true);
        declaredField.set(this, c1057gM6392d.f5137a);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f5137a.length);
        objectOutputStream.write(this.f5137a);
    }

    /* renamed from: x */
    public static final C1057g m6365x(byte... bArr) {
        return f5135d.m6391c(bArr);
    }

    /* renamed from: A */
    public final void m6366A(int i10) {
        this.f5138b = i10;
    }

    /* renamed from: B */
    public final void m6367B(String str) {
        this.f5139c = str;
    }

    /* renamed from: C */
    public final C1057g m6368C() {
        return mo6378h("SHA-1");
    }

    /* renamed from: D */
    public final C1057g m6369D() {
        return mo6378h("SHA-256");
    }

    /* renamed from: E */
    public final int m6370E() {
        return mo6382s();
    }

    /* renamed from: F */
    public final boolean m6371F(C1057g c1057g) {
        C13267j.m79677e(c1057g, "prefix");
        return mo6387y(0, c1057g, 0, c1057g.m6370E());
    }

    /* renamed from: G */
    public C1057g mo6372G() {
        for (int i10 = 0; i10 < m6380q().length; i10++) {
            byte b10 = m6380q()[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrM6380q = m6380q();
                byte[] bArrCopyOf = Arrays.copyOf(bArrM6380q, bArrM6380q.length);
                C13267j.m79676d(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b11 = bArrCopyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new C1057g(bArrCopyOf);
            }
        }
        return this;
    }

    /* renamed from: H */
    public byte[] mo6373H() {
        byte[] bArrM6380q = m6380q();
        byte[] bArrCopyOf = Arrays.copyOf(bArrM6380q, bArrM6380q.length);
        C13267j.m79676d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    /* renamed from: I */
    public String m6374I() {
        String strM6383t = m6383t();
        if (strM6383t != null) {
            return strM6383t;
        }
        String strM6301b = C1052b0.m6301b(mo6385v());
        m6367B(strM6301b);
        return strM6301b;
    }

    /* renamed from: J */
    public void mo6375J(C1054d c1054d, int i10, int i11) {
        C13267j.m79677e(c1054d, "buffer");
        C8963b.m56722d(this, c1054d, i10, i11);
    }

    /* renamed from: b */
    public String mo6376b() {
        return C1049a.m6291b(m6380q(), null, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0028, code lost:
    
        if (r7 < r8) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0031, code lost:
    
        if (r0 < r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return 1;
     */
    @Override // java.lang.Comparable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(p022ay.C1057g r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            p692uw.C13267j.m79677e(r10, r0)
            int r0 = r9.m6370E()
            int r1 = r10.m6370E()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.m6379p(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.m6379p(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p022ay.C1057g.compareTo(ay.g):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1057g) {
            C1057g c1057g = (C1057g) obj;
            if (c1057g.m6370E() == m6380q().length && c1057g.mo6388z(0, m6380q(), 0, m6380q().length)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public C1057g mo6378h(String str) throws NoSuchAlgorithmException {
        C13267j.m79677e(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f5137a, 0, m6370E());
        byte[] bArrDigest = messageDigest.digest();
        C13267j.m79676d(bArrDigest, "digestBytes");
        return new C1057g(bArrDigest);
    }

    public int hashCode() {
        int iM6381r = m6381r();
        if (iM6381r != 0) {
            return iM6381r;
        }
        int iHashCode = Arrays.hashCode(m6380q());
        m6366A(iHashCode);
        return iHashCode;
    }

    /* renamed from: p */
    public final byte m6379p(int i10) {
        return mo6386w(i10);
    }

    /* renamed from: q */
    public final byte[] m6380q() {
        return this.f5137a;
    }

    /* renamed from: r */
    public final int m6381r() {
        return this.f5138b;
    }

    /* renamed from: s */
    public int mo6382s() {
        return m6380q().length;
    }

    /* renamed from: t */
    public final String m6383t() {
        return this.f5139c;
    }

    public String toString() {
        if (m6380q().length == 0) {
            return "[size=0]";
        }
        int iM56721c = C8963b.m56721c(m6380q(), 64);
        if (iM56721c != -1) {
            String strM6374I = m6374I();
            String strSubstring = strM6374I.substring(0, iM56721c);
            C13267j.m79676d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strM6263h = C1045o.m6263h(C1045o.m6263h(C1045o.m6263h(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iM56721c >= strM6374I.length()) {
                return "[text=" + strM6263h + ']';
            }
            return "[size=" + m6380q().length + " text=" + strM6263h + "…]";
        }
        if (m6380q().length <= 64) {
            return "[hex=" + mo6384u() + ']';
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[size=");
        sb2.append(m6380q().length);
        sb2.append(" hex=");
        C1057g c1057g = this;
        int iM6295c = C1051b.m6295c(c1057g, 64);
        if (iM6295c > m6380q().length) {
            throw new IllegalArgumentException(("endIndex > length(" + m6380q().length + C5929g4.f26850l).toString());
        }
        if (iM6295c < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (iM6295c != m6380q().length) {
            c1057g = new C1057g(C11175g.m67147g(m6380q(), 0, iM6295c));
        }
        sb2.append(c1057g.mo6384u());
        sb2.append("…]");
        return sb2.toString();
    }

    /* renamed from: u */
    public String mo6384u() {
        char[] cArr = new char[m6380q().length * 2];
        int i10 = 0;
        for (byte b10 : m6380q()) {
            int i11 = i10 + 1;
            cArr[i10] = C8963b.m56724f()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = C8963b.m56724f()[b10 & BaseType.Obj];
        }
        return C1045o.m6259d(cArr);
    }

    /* renamed from: v */
    public byte[] mo6385v() {
        return m6380q();
    }

    /* renamed from: w */
    public byte mo6386w(int i10) {
        return m6380q()[i10];
    }

    /* renamed from: y */
    public boolean mo6387y(int i10, C1057g c1057g, int i11, int i12) {
        C13267j.m79677e(c1057g, "other");
        return c1057g.mo6388z(i11, m6380q(), i10, i12);
    }

    /* renamed from: z */
    public boolean mo6388z(int i10, byte[] bArr, int i11, int i12) {
        C13267j.m79677e(bArr, "other");
        return i10 >= 0 && i10 <= m6380q().length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && C1051b.m6293a(m6380q(), i10, bArr, i11, i12);
    }
}
