package p038bq;

import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;
import np.C11741a;
import p038bq.C1272b;

/* renamed from: bq.a */
/* loaded from: classes8.dex */
public class C1271a {

    /* renamed from: b */
    public static final Collator f5706b = Collator.getInstance(Locale.CHINA);

    /* renamed from: c */
    public static C1271a f5707c;

    /* renamed from: a */
    public final boolean f5708a;

    public C1271a(boolean z10) {
        this.f5708a = z10;
    }

    /* renamed from: c */
    public static C1271a m7538c() {
        int i10;
        synchronized (C1271a.class) {
            try {
                C1271a c1271a = f5707c;
                if (c1271a != null) {
                    return c1271a;
                }
                Locale[] availableLocales = Collator.getAvailableLocales();
                Locale locale = new Locale("zh");
                for (0; i10 < availableLocales.length; i10 + 1) {
                    i10 = (availableLocales[i10].equals(Locale.CHINA) || availableLocales[i10].equals(locale)) ? 0 : i10 + 1;
                    C1271a c1271a2 = new C1271a(true);
                    f5707c = c1271a2;
                    return c1271a2;
                }
                C1271a c1271a3 = new C1271a(false);
                f5707c = c1271a3;
                return c1271a3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public final void m7539a(StringBuilder sb2, ArrayList<C1272b.c> arrayList, int i10) {
        if (sb2.length() <= 0) {
            return;
        }
        String string = sb2.toString();
        arrayList.add(new C1272b.c(i10, string, string));
        sb2.setLength(0);
    }

    /* renamed from: b */
    public ArrayList<C1272b.c> m7540b(String str) {
        ArrayList<C1272b.c> arrayList = new ArrayList<>();
        if (this.f5708a && !TextUtils.isEmpty(str)) {
            int length = str.length();
            StringBuilder sb2 = new StringBuilder();
            int i10 = 1;
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = str.charAt(i11);
                if (cCharAt == ' ') {
                    m7539a(sb2, arrayList, i10);
                } else if (cCharAt < 256) {
                    if (i10 != 1) {
                        m7539a(sb2, arrayList, i10);
                    }
                    sb2.append(cCharAt);
                    i10 = 1;
                } else {
                    C1272b.c cVarM7541d = m7541d(cCharAt);
                    int i12 = cVarM7541d.f5711a;
                    if (i12 == 2) {
                        m7539a(sb2, arrayList, i10);
                        arrayList.add(cVarM7541d);
                        i10 = 2;
                    } else {
                        if (i10 != i12) {
                            m7539a(sb2, arrayList, i10);
                        }
                        i10 = cVarM7541d.f5711a;
                        sb2.append(cCharAt);
                    }
                }
            }
            m7539a(sb2, arrayList, i10);
        }
        return arrayList;
    }

    /* renamed from: d */
    public final C1272b.c m7541d(char c10) {
        int length;
        C1272b.c cVar = new C1272b.c();
        String string = Character.toString(c10);
        cVar.f5712b = string;
        byte[] bArr = C11741a.m70047a().get(Character.valueOf(c10));
        if (bArr != null) {
            cVar.f5711a = 2;
            m7542e(cVar, bArr);
            return cVar;
        }
        if (c10 < 256) {
            cVar.f5711a = 1;
            cVar.f5713c = string;
            return cVar;
        }
        Collator collator = f5706b;
        int iCompare = collator.compare(string, "阿");
        if (iCompare < 0) {
            cVar.f5711a = 4;
            cVar.f5713c = string;
            return cVar;
        }
        int i10 = 0;
        if (iCompare == 0) {
            cVar.f5711a = 2;
            length = 0;
        } else {
            iCompare = collator.compare(string, "鿿");
            if (iCompare > 0) {
                cVar.f5711a = 4;
                cVar.f5713c = string;
                return cVar;
            }
            if (iCompare == 0) {
                cVar.f5711a = 2;
                length = C11741a.f54299b.length - 1;
            } else {
                length = -1;
            }
        }
        cVar.f5711a = 2;
        if (length < 0) {
            int length2 = C11741a.f54299b.length - 1;
            while (i10 <= length2) {
                length = (i10 + length2) >>> 1;
                iCompare = f5706b.compare(string, Character.toString(C11741a.f54299b[length]));
                if (iCompare == 0) {
                    break;
                }
                if (iCompare > 0) {
                    i10 = length + 1;
                } else {
                    length2 = length - 1;
                }
            }
        }
        if (iCompare < 0) {
            length--;
        }
        byte[][] bArr2 = C11741a.f54300c;
        m7542e(cVar, bArr2[(bArr2.length - 1) - length]);
        return cVar;
    }

    /* renamed from: e */
    public final void m7542e(C1272b.c cVar, byte[] bArr) {
        byte b10;
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArr.length && (b10 = bArr[i10]) != 0; i10++) {
            sb2.append((char) b10);
        }
        String string = sb2.toString();
        cVar.f5713c = string;
        if (TextUtils.isEmpty(string)) {
            cVar.f5711a = 4;
            cVar.f5713c = cVar.f5712b;
        }
    }
}
