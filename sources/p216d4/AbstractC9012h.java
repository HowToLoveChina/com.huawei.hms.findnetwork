package p216d4;

/* renamed from: d4.h */
/* loaded from: classes.dex */
public abstract class AbstractC9012h {
    /* renamed from: a */
    public static String m56889a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
