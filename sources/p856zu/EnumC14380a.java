package p856zu;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: zu.a */
/* loaded from: classes9.dex */
public enum enumEncryptAlgorithm {
    UNKNOWN((byte) -1, "unknown", 0),
    AES_CBC((byte) 0, "AES/CBC/PKCS5Padding", 16),
    KEY_STORE_AES_CBC((byte) 0, "AES/CBC/PKCS7Padding", 16),
    AES_GCM((byte) 1, "AES/GCM/NoPadding", 12),
    RSA_OAEP(BaseType.Union, "RSA/ECB/OAEPWithSHA-256AndMGF1Padding", 0),
    ECIES((byte) 32, "ECIESwithAES/NONE/PKCS7Padding", 0),
    ECIES_CBC(PublicSuffixDatabase.f29565i, "ECIESwithAES-CBC/NONE/PKCS7Padding", 0);


    /* renamed from: k */
    public static final Map<Byte, enumEncryptAlgorithm> f63746k = new HashMap();

    /* renamed from: l */
    public static final Map<String, enumEncryptAlgorithm> f63747l = new HashMap();

    /* renamed from: a */
    public final byte m_key;

    /* renamed from: b */
    public final String m_name;

    /* renamed from: c */
    public final int m_seed;

    static {
        Iterator it = EnumSet.allOf(enumEncryptAlgorithm.class).iterator();
        while (it.hasNext()) {
            enumEncryptAlgorithm enumEncryptAlgorithm = (enumEncryptAlgorithm) it.next();
            f63746k.put(Byte.valueOf(enumEncryptAlgorithm.m_key), enumEncryptAlgorithm);
        }
        Map<String, enumEncryptAlgorithm> map = f63747l;
        map.put("EC", ECIES);
        map.put("RSA", RSA_OAEP);
        map.put("AES", AES_GCM);
    }

    enumEncryptAlgorithm(byte b10, String str, int i10) {
        this.m_key = b10;
        this.m_name = str;
        this.m_seed = i10;
    }

    /* renamed from: e */
    public static enumEncryptAlgorithm getAlgorithm(String str) {
        return f63747l.get(str);
    }

    /* renamed from: b */
    public int getAlgorithmSeed() {
        return this.m_seed;
    }

    /* renamed from: f */
    public String getAlgorithmName() {
        return this.m_name;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f63750b;
    }
}
