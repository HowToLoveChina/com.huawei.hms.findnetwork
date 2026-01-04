package p695v0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: v0.j */
/* loaded from: classes.dex */
public class C13322j {

    /* renamed from: a */
    public static final byte[] f60090a = {112, 114, 111, 0};

    /* renamed from: b */
    public static final byte[] f60091b = {112, 114, 109, 0};

    /* renamed from: A */
    public static void m79833A(byte[] bArr, int i10, int i11, C13314b c13314b) {
        int iM79862m = m79862m(i10, i11, c13314b.f60073g);
        int i12 = iM79862m / 8;
        bArr[i12] = (byte) ((1 << (iM79862m % 8)) | bArr[i12]);
    }

    /* renamed from: B */
    public static void m79834B(InputStream inputStream) throws IOException {
        C13315c.m79820h(inputStream);
        int iM79822j = C13315c.m79822j(inputStream);
        if (iM79822j == 6 || iM79822j == 7) {
            return;
        }
        while (iM79822j > 0) {
            C13315c.m79822j(inputStream);
            for (int iM79822j2 = C13315c.m79822j(inputStream); iM79822j2 > 0; iM79822j2--) {
                C13315c.m79820h(inputStream);
            }
            iM79822j--;
        }
    }

    /* renamed from: C */
    public static boolean m79835C(OutputStream outputStream, byte[] bArr, C13314b[] c13314bArr) throws IOException {
        if (Arrays.equals(bArr, C13323k.f60092a)) {
            m79848P(outputStream, c13314bArr);
            return true;
        }
        if (Arrays.equals(bArr, C13323k.f60093b)) {
            m79847O(outputStream, c13314bArr);
            return true;
        }
        if (Arrays.equals(bArr, C13323k.f60095d)) {
            m79845M(outputStream, c13314bArr);
            return true;
        }
        if (Arrays.equals(bArr, C13323k.f60094c)) {
            m79846N(outputStream, c13314bArr);
            return true;
        }
        if (!Arrays.equals(bArr, C13323k.f60096e)) {
            return false;
        }
        m79844L(outputStream, c13314bArr);
        return true;
    }

    /* renamed from: D */
    public static void m79836D(OutputStream outputStream, C13314b c13314b) throws IOException {
        int[] iArr = c13314b.f60074h;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            C13315c.m79828p(outputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
    }

    /* renamed from: E */
    public static C13324l m79837E(C13314b[] c13314bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            C13315c.m79828p(byteArrayOutputStream, c13314bArr.length);
            int i10 = 2;
            for (C13314b c13314b : c13314bArr) {
                C13315c.m79829q(byteArrayOutputStream, c13314b.f60069c);
                C13315c.m79829q(byteArrayOutputStream, c13314b.f60070d);
                C13315c.m79829q(byteArrayOutputStream, c13314b.f60073g);
                String strM79859j = m79859j(c13314b.f60067a, c13314b.f60068b, C13323k.f60092a);
                int iM79823k = C13315c.m79823k(strM79859j);
                C13315c.m79828p(byteArrayOutputStream, iM79823k);
                i10 = i10 + 14 + iM79823k;
                C13315c.m79826n(byteArrayOutputStream, strM79859j);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                C13324l c13324l = new C13324l(EnumC13316d.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return c13324l;
            }
            throw C13315c.m79815c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: F */
    public static void m79838F(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f60090a);
        outputStream.write(bArr);
    }

    /* renamed from: G */
    public static void m79839G(OutputStream outputStream, C13314b c13314b) throws IOException {
        m79843K(outputStream, c13314b);
        m79836D(outputStream, c13314b);
        m79841I(outputStream, c13314b);
    }

    /* renamed from: H */
    public static void m79840H(OutputStream outputStream, C13314b c13314b, String str) throws IOException {
        C13315c.m79828p(outputStream, C13315c.m79823k(str));
        C13315c.m79828p(outputStream, c13314b.f60071e);
        C13315c.m79829q(outputStream, c13314b.f60072f);
        C13315c.m79829q(outputStream, c13314b.f60069c);
        C13315c.m79829q(outputStream, c13314b.f60073g);
        C13315c.m79826n(outputStream, str);
    }

    /* renamed from: I */
    public static void m79841I(OutputStream outputStream, C13314b c13314b) throws IOException {
        byte[] bArr = new byte[m79860k(c13314b.f60073g)];
        for (Map.Entry<Integer, Integer> entry : c13314b.f60075i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                m79833A(bArr, 2, iIntValue, c13314b);
            }
            if ((iIntValue2 & 4) != 0) {
                m79833A(bArr, 4, iIntValue, c13314b);
            }
        }
        outputStream.write(bArr);
    }

    /* renamed from: J */
    public static void m79842J(OutputStream outputStream, int i10, C13314b c13314b) throws IOException {
        byte[] bArr = new byte[m79861l(i10, c13314b.f60073g)];
        for (Map.Entry<Integer, Integer> entry : c13314b.f60075i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int i11 = 0;
            for (int i12 = 1; i12 <= 4; i12 <<= 1) {
                if (i12 != 1 && (i12 & i10) != 0) {
                    if ((i12 & iIntValue2) == i12) {
                        int i13 = (c13314b.f60073g * i11) + iIntValue;
                        int i14 = i13 / 8;
                        bArr[i14] = (byte) ((1 << (i13 % 8)) | bArr[i14]);
                    }
                    i11++;
                }
            }
        }
        outputStream.write(bArr);
    }

    /* renamed from: K */
    public static void m79843K(OutputStream outputStream, C13314b c13314b) throws IOException {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : c13314b.f60075i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                C13315c.m79828p(outputStream, iIntValue - i10);
                C13315c.m79828p(outputStream, 0);
                i10 = iIntValue;
            }
        }
    }

    /* renamed from: L */
    public static void m79844L(OutputStream outputStream, C13314b[] c13314bArr) throws IOException {
        C13315c.m79828p(outputStream, c13314bArr.length);
        for (C13314b c13314b : c13314bArr) {
            String strM79859j = m79859j(c13314b.f60067a, c13314b.f60068b, C13323k.f60096e);
            C13315c.m79828p(outputStream, C13315c.m79823k(strM79859j));
            C13315c.m79828p(outputStream, c13314b.f60075i.size());
            C13315c.m79828p(outputStream, c13314b.f60074h.length);
            C13315c.m79829q(outputStream, c13314b.f60069c);
            C13315c.m79826n(outputStream, strM79859j);
            Iterator<Integer> it = c13314b.f60075i.keySet().iterator();
            while (it.hasNext()) {
                C13315c.m79828p(outputStream, it.next().intValue());
            }
            for (int i10 : c13314b.f60074h) {
                C13315c.m79828p(outputStream, i10);
            }
        }
    }

    /* renamed from: M */
    public static void m79845M(OutputStream outputStream, C13314b[] c13314bArr) throws IOException {
        C13315c.m79830r(outputStream, c13314bArr.length);
        for (C13314b c13314b : c13314bArr) {
            int size = c13314b.f60075i.size() * 4;
            String strM79859j = m79859j(c13314b.f60067a, c13314b.f60068b, C13323k.f60095d);
            C13315c.m79828p(outputStream, C13315c.m79823k(strM79859j));
            C13315c.m79828p(outputStream, c13314b.f60074h.length);
            C13315c.m79829q(outputStream, size);
            C13315c.m79829q(outputStream, c13314b.f60069c);
            C13315c.m79826n(outputStream, strM79859j);
            Iterator<Integer> it = c13314b.f60075i.keySet().iterator();
            while (it.hasNext()) {
                C13315c.m79828p(outputStream, it.next().intValue());
                C13315c.m79828p(outputStream, 0);
            }
            for (int i10 : c13314b.f60074h) {
                C13315c.m79828p(outputStream, i10);
            }
        }
    }

    /* renamed from: N */
    public static void m79846N(OutputStream outputStream, C13314b[] c13314bArr) throws IOException {
        byte[] bArrM79851b = m79851b(c13314bArr, C13323k.f60094c);
        C13315c.m79830r(outputStream, c13314bArr.length);
        C13315c.m79825m(outputStream, bArrM79851b);
    }

    /* renamed from: O */
    public static void m79847O(OutputStream outputStream, C13314b[] c13314bArr) throws IOException {
        byte[] bArrM79851b = m79851b(c13314bArr, C13323k.f60093b);
        C13315c.m79830r(outputStream, c13314bArr.length);
        C13315c.m79825m(outputStream, bArrM79851b);
    }

    /* renamed from: P */
    public static void m79848P(OutputStream outputStream, C13314b[] c13314bArr) throws IOException {
        m79849Q(outputStream, c13314bArr);
    }

    /* renamed from: Q */
    public static void m79849Q(OutputStream outputStream, C13314b[] c13314bArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(m79837E(c13314bArr));
        arrayList.add(m79852c(c13314bArr));
        arrayList.add(m79853d(c13314bArr));
        long length2 = C13323k.f60092a.length + f60090a.length + 4 + (arrayList.size() * 16);
        C13315c.m79829q(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            C13324l c13324l = (C13324l) arrayList.get(i10);
            C13315c.m79829q(outputStream, c13324l.f60099a.m79832e());
            C13315c.m79829q(outputStream, length2);
            if (c13324l.f60102d) {
                byte[] bArr = c13324l.f60101c;
                long length3 = bArr.length;
                byte[] bArrM79814b = C13315c.m79814b(bArr);
                arrayList2.add(bArrM79814b);
                C13315c.m79829q(outputStream, bArrM79814b.length);
                C13315c.m79829q(outputStream, length3);
                length = bArrM79814b.length;
            } else {
                arrayList2.add(c13324l.f60101c);
                C13315c.m79829q(outputStream, c13324l.f60101c.length);
                C13315c.m79829q(outputStream, 0L);
                length = c13324l.f60101c.length;
            }
            length2 += length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    /* renamed from: a */
    public static int m79850a(C13314b c13314b) {
        Iterator<Map.Entry<Integer, Integer>> it = c13314b.f60075i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= it.next().getValue().intValue();
        }
        return iIntValue;
    }

    /* renamed from: b */
    public static byte[] m79851b(C13314b[] c13314bArr, byte[] bArr) throws IOException {
        int i10 = 0;
        int iM79823k = 0;
        for (C13314b c13314b : c13314bArr) {
            iM79823k += C13315c.m79823k(m79859j(c13314b.f60067a, c13314b.f60068b, bArr)) + 16 + (c13314b.f60071e * 2) + c13314b.f60072f + m79860k(c13314b.f60073g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iM79823k);
        if (Arrays.equals(bArr, C13323k.f60094c)) {
            int length = c13314bArr.length;
            while (i10 < length) {
                C13314b c13314b2 = c13314bArr[i10];
                m79840H(byteArrayOutputStream, c13314b2, m79859j(c13314b2.f60067a, c13314b2.f60068b, bArr));
                m79839G(byteArrayOutputStream, c13314b2);
                i10++;
            }
        } else {
            for (C13314b c13314b3 : c13314bArr) {
                m79840H(byteArrayOutputStream, c13314b3, m79859j(c13314b3.f60067a, c13314b3.f60068b, bArr));
            }
            int length2 = c13314bArr.length;
            while (i10 < length2) {
                m79839G(byteArrayOutputStream, c13314bArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == iM79823k) {
            return byteArrayOutputStream.toByteArray();
        }
        throw C13315c.m79815c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iM79823k);
    }

    /* renamed from: c */
    public static C13324l m79852c(C13314b[] c13314bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < c13314bArr.length; i11++) {
            try {
                C13314b c13314b = c13314bArr[i11];
                C13315c.m79828p(byteArrayOutputStream, i11);
                C13315c.m79828p(byteArrayOutputStream, c13314b.f60071e);
                i10 = i10 + 4 + (c13314b.f60071e * 2);
                m79836D(byteArrayOutputStream, c13314b);
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            C13324l c13324l = new C13324l(EnumC13316d.CLASSES, i10, byteArray, true);
            byteArrayOutputStream.close();
            return c13324l;
        }
        throw C13315c.m79815c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    /* renamed from: d */
    public static C13324l m79853d(C13314b[] c13314bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < c13314bArr.length; i11++) {
            try {
                C13314b c13314b = c13314bArr[i11];
                int iM79850a = m79850a(c13314b);
                byte[] bArrM79854e = m79854e(iM79850a, c13314b);
                byte[] bArrM79855f = m79855f(c13314b);
                C13315c.m79828p(byteArrayOutputStream, i11);
                int length = bArrM79854e.length + 2 + bArrM79855f.length;
                C13315c.m79829q(byteArrayOutputStream, length);
                C13315c.m79828p(byteArrayOutputStream, iM79850a);
                byteArrayOutputStream.write(bArrM79854e);
                byteArrayOutputStream.write(bArrM79855f);
                i10 = i10 + 6 + length;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            C13324l c13324l = new C13324l(EnumC13316d.METHODS, i10, byteArray, true);
            byteArrayOutputStream.close();
            return c13324l;
        }
        throw C13315c.m79815c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    /* renamed from: e */
    public static byte[] m79854e(int i10, C13314b c13314b) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m79842J(byteArrayOutputStream, i10, c13314b);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: f */
    public static byte[] m79855f(C13314b c13314b) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m79843K(byteArrayOutputStream, c13314b);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: g */
    public static String m79856g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    /* renamed from: h */
    public static String m79857h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    /* renamed from: i */
    public static C13314b m79858i(C13314b[] c13314bArr, String str) {
        if (c13314bArr.length <= 0) {
            return null;
        }
        String strM79857h = m79857h(str);
        for (int i10 = 0; i10 < c13314bArr.length; i10++) {
            if (c13314bArr[i10].f60068b.equals(strM79857h)) {
                return c13314bArr[i10];
            }
        }
        return null;
    }

    /* renamed from: j */
    public static String m79859j(String str, String str2, byte[] bArr) {
        String strM79876a = C13323k.m79876a(bArr);
        if (str.length() <= 0) {
            return m79856g(str2, strM79876a);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return m79856g(str2, strM79876a);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + C13323k.m79876a(bArr) + str2;
    }

    /* renamed from: k */
    public static int m79860k(int i10) {
        return m79875z(i10 * 2) / 8;
    }

    /* renamed from: l */
    public static int m79861l(int i10, int i11) {
        return m79875z(Integer.bitCount(i10 & (-2)) * i11) / 8;
    }

    /* renamed from: m */
    public static int m79862m(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw C13315c.m79815c("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw C13315c.m79815c("Unexpected flag: " + i10);
    }

    /* renamed from: n */
    public static int[] m79863n(InputStream inputStream, int i10) throws IOException {
        int[] iArr = new int[i10];
        int iM79820h = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iM79820h += C13315c.m79820h(inputStream);
            iArr[i11] = iM79820h;
        }
        return iArr;
    }

    /* renamed from: o */
    public static int m79864o(BitSet bitSet, int i10, int i11) {
        int i12 = bitSet.get(m79862m(2, i10, i11)) ? 2 : 0;
        return bitSet.get(m79862m(4, i10, i11)) ? i12 | 4 : i12;
    }

    /* renamed from: p */
    public static byte[] m79865p(InputStream inputStream, byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, C13315c.m79816d(inputStream, bArr.length))) {
            return C13315c.m79816d(inputStream, C13323k.f60093b.length);
        }
        throw C13315c.m79815c("Invalid magic");
    }

    /* renamed from: q */
    public static void m79866q(InputStream inputStream, C13314b c13314b) throws IOException {
        int iAvailable = inputStream.available() - c13314b.f60072f;
        int iM79820h = 0;
        while (inputStream.available() > iAvailable) {
            iM79820h += C13315c.m79820h(inputStream);
            c13314b.f60075i.put(Integer.valueOf(iM79820h), 1);
            for (int iM79820h2 = C13315c.m79820h(inputStream); iM79820h2 > 0; iM79820h2--) {
                m79834B(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw C13315c.m79815c("Read too much data during profile line parse");
        }
    }

    /* renamed from: r */
    public static C13314b[] m79867r(InputStream inputStream, byte[] bArr, byte[] bArr2, C13314b[] c13314bArr) throws IOException {
        if (Arrays.equals(bArr, C13323k.f60097f)) {
            if (Arrays.equals(C13323k.f60092a, bArr2)) {
                throw C13315c.m79815c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return m79868s(inputStream, bArr, c13314bArr);
        }
        if (Arrays.equals(bArr, C13323k.f60098g)) {
            return m79870u(inputStream, bArr2, c13314bArr);
        }
        throw C13315c.m79815c("Unsupported meta version");
    }

    /* renamed from: s */
    public static C13314b[] m79868s(InputStream inputStream, byte[] bArr, C13314b[] c13314bArr) throws IOException {
        if (!Arrays.equals(bArr, C13323k.f60097f)) {
            throw C13315c.m79815c("Unsupported meta version");
        }
        int iM79822j = C13315c.m79822j(inputStream);
        byte[] bArrM79817e = C13315c.m79817e(inputStream, (int) C13315c.m79821i(inputStream), (int) C13315c.m79821i(inputStream));
        if (inputStream.read() > 0) {
            throw C13315c.m79815c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM79817e);
        try {
            C13314b[] c13314bArrM79869t = m79869t(byteArrayInputStream, iM79822j, c13314bArr);
            byteArrayInputStream.close();
            return c13314bArrM79869t;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: t */
    public static C13314b[] m79869t(InputStream inputStream, int i10, C13314b[] c13314bArr) throws IOException {
        if (inputStream.available() == 0) {
            return new C13314b[0];
        }
        if (i10 != c13314bArr.length) {
            throw C13315c.m79815c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iM79820h = C13315c.m79820h(inputStream);
            iArr[i11] = C13315c.m79820h(inputStream);
            strArr[i11] = C13315c.m79818f(inputStream, iM79820h);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            C13314b c13314b = c13314bArr[i12];
            if (!c13314b.f60068b.equals(strArr[i12])) {
                throw C13315c.m79815c("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            c13314b.f60071e = i13;
            c13314b.f60074h = m79863n(inputStream, i13);
        }
        return c13314bArr;
    }

    /* renamed from: u */
    public static C13314b[] m79870u(InputStream inputStream, byte[] bArr, C13314b[] c13314bArr) throws IOException {
        int iM79820h = C13315c.m79820h(inputStream);
        byte[] bArrM79817e = C13315c.m79817e(inputStream, (int) C13315c.m79821i(inputStream), (int) C13315c.m79821i(inputStream));
        if (inputStream.read() > 0) {
            throw C13315c.m79815c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM79817e);
        try {
            C13314b[] c13314bArrM79871v = m79871v(byteArrayInputStream, bArr, iM79820h, c13314bArr);
            byteArrayInputStream.close();
            return c13314bArrM79871v;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: v */
    public static C13314b[] m79871v(InputStream inputStream, byte[] bArr, int i10, C13314b[] c13314bArr) throws IOException {
        if (inputStream.available() == 0) {
            return new C13314b[0];
        }
        if (i10 != c13314bArr.length) {
            throw C13315c.m79815c("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            C13315c.m79820h(inputStream);
            String strM79818f = C13315c.m79818f(inputStream, C13315c.m79820h(inputStream));
            long jM79821i = C13315c.m79821i(inputStream);
            int iM79820h = C13315c.m79820h(inputStream);
            C13314b c13314bM79858i = m79858i(c13314bArr, strM79818f);
            if (c13314bM79858i == null) {
                throw C13315c.m79815c("Missing profile key: " + strM79818f);
            }
            c13314bM79858i.f60070d = jM79821i;
            int[] iArrM79863n = m79863n(inputStream, iM79820h);
            if (Arrays.equals(bArr, C13323k.f60096e)) {
                c13314bM79858i.f60071e = iM79820h;
                c13314bM79858i.f60074h = iArrM79863n;
            }
        }
        return c13314bArr;
    }

    /* renamed from: w */
    public static void m79872w(InputStream inputStream, C13314b c13314b) throws IOException {
        BitSet bitSetValueOf = BitSet.valueOf(C13315c.m79816d(inputStream, C13315c.m79813a(c13314b.f60073g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = c13314b.f60073g;
            if (i10 >= i11) {
                return;
            }
            int iM79864o = m79864o(bitSetValueOf, i10, i11);
            if (iM79864o != 0) {
                Integer num = c13314b.f60075i.get(Integer.valueOf(i10));
                if (num == null) {
                    num = 0;
                }
                c13314b.f60075i.put(Integer.valueOf(i10), Integer.valueOf(iM79864o | num.intValue()));
            }
            i10++;
        }
    }

    /* renamed from: x */
    public static C13314b[] m79873x(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, C13323k.f60093b)) {
            throw C13315c.m79815c("Unsupported version");
        }
        int iM79822j = C13315c.m79822j(inputStream);
        byte[] bArrM79817e = C13315c.m79817e(inputStream, (int) C13315c.m79821i(inputStream), (int) C13315c.m79821i(inputStream));
        if (inputStream.read() > 0) {
            throw C13315c.m79815c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM79817e);
        try {
            C13314b[] c13314bArrM79874y = m79874y(byteArrayInputStream, str, iM79822j);
            byteArrayInputStream.close();
            return c13314bArrM79874y;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: y */
    public static C13314b[] m79874y(InputStream inputStream, String str, int i10) throws IOException {
        if (inputStream.available() == 0) {
            return new C13314b[0];
        }
        C13314b[] c13314bArr = new C13314b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iM79820h = C13315c.m79820h(inputStream);
            int iM79820h2 = C13315c.m79820h(inputStream);
            c13314bArr[i11] = new C13314b(str, C13315c.m79818f(inputStream, iM79820h), C13315c.m79821i(inputStream), 0L, iM79820h2, (int) C13315c.m79821i(inputStream), (int) C13315c.m79821i(inputStream), new int[iM79820h2], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            C13314b c13314b = c13314bArr[i12];
            m79866q(inputStream, c13314b);
            c13314b.f60074h = m79863n(inputStream, c13314b.f60071e);
            m79872w(inputStream, c13314b);
        }
        return c13314bArr;
    }

    /* renamed from: z */
    public static int m79875z(int i10) {
        return (i10 + 7) & (-8);
    }
}
