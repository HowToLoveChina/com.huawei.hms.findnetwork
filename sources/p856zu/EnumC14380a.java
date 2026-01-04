package p856zu;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: zu.a */
/* loaded from: classes9.dex */
public enum EnumC14380a {
    UNKNOWN((byte) -1, "unknown", 0),
    AES_CBC((byte) 0, "AES/CBC/PKCS5Padding", 16),
    KEY_STORE_AES_CBC((byte) 0, "AES/CBC/PKCS7Padding", 16),
    AES_GCM((byte) 1, "AES/GCM/NoPadding", 12),
    RSA_OAEP(BaseType.Union, "RSA/ECB/OAEPWithSHA-256AndMGF1Padding", 0),
    ECIES((byte) 32, "ECIESwithAES/NONE/PKCS7Padding", 0),
    ECIES_CBC(PublicSuffixDatabase.f29565i, "ECIESwithAES-CBC/NONE/PKCS7Padding", 0);


    /* renamed from: k */
    public static final Map<Byte, EnumC14380a> f63746k = new HashMap();

    /* renamed from: l */
    public static final Map<String, EnumC14380a> f63747l = new HashMap();

    /* renamed from: a */
    public final byte f63749a;

    /* renamed from: b */
    public final String f63750b;

    /* renamed from: c */
    public final int f63751c;

    static {
        Iterator it = EnumSet.allOf(EnumC14380a.class).iterator();
        while (it.hasNext()) {
            EnumC14380a enumC14380a = (EnumC14380a) it.next();
            f63746k.put(Byte.valueOf(enumC14380a.f63749a), enumC14380a);
        }
        Map<String, EnumC14380a> map = f63747l;
        map.put("EC", ECIES);
        map.put("RSA", RSA_OAEP);
        map.put("AES", AES_GCM);
    }

    EnumC14380a(byte b10, String str, int i10) {
        this.f63749a = b10;
        this.f63750b = str;
        this.f63751c = i10;
    }

    /* renamed from: e */
    public static EnumC14380a m85605e(String str) {
        return f63747l.get(str);
    }

    /* renamed from: b */
    public int m85606b() {
        return this.f63751c;
    }

    /* renamed from: f */
    public String m85607f() {
        return this.f63750b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f63750b;
    }
}
