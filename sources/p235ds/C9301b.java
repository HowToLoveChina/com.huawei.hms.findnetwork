package p235ds;

import android.text.TextUtils;
import as.C1016d;
import az.C1081e;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import lu.C11343b;
import p302fz.C9811c;
import p756wy.C13667b;
import uy.C13294h;

/* renamed from: ds.b */
/* loaded from: classes8.dex */
public final class C9301b implements InterfaceC9303d {
    @Override // p235ds.InterfaceC9303d
    /* renamed from: a */
    public final String mo38472a(String str, String str2) {
        return str;
    }

    @Override // p235ds.InterfaceC9303d
    /* renamed from: b */
    public final String mo38473b(String str, String str2) throws CharacterCodingException, IllegalArgumentException, UnsupportedEncodingException {
        ByteBuffer byteBufferEncode;
        byte[] bArr;
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            try {
                byteBufferEncode = Charset.forName(Constants.UTF_8).newEncoder().encode(CharBuffer.wrap(str));
            } catch (CharacterCodingException unused) {
                C1016d.m6183c("SM4Security", "CharacterCodingException ");
                byteBufferEncode = null;
            }
            if (byteBufferEncode != null) {
                bArr = new byte[byteBufferEncode.limit()];
                byteBufferEncode.get(bArr);
            } else {
                bArr = new byte[0];
            }
            if (bArr.length > 0) {
                byte[] bArrM68147b = C11343b.m68147b(str2);
                C13667b c13667b = new C13667b();
                c13667b.mo79739d(true, new C1081e(bArrM68147b));
                if (bArr.length == 0) {
                    C1016d.m6183c("SM4Security", "handlePKCS5Padding error");
                } else {
                    int length = bArr.length;
                    int i10 = 16 - (length % 16);
                    int i11 = length + i10;
                    byte[] bArr2 = new byte[i11];
                    byte[] bArr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, BaseType.Float, BaseType.Double, 13, BaseType.Vector, BaseType.Obj, BaseType.Union};
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (i12 < length) {
                            bArr2[i12] = bArr[i12];
                        } else {
                            bArr2[i12] = bArr3[i10];
                        }
                    }
                    bArr = bArr2;
                }
                int length2 = bArr.length;
                byte[] bArr4 = new byte[length2];
                int i13 = length2 / 16;
                for (int i14 = 0; i14 < i13; i14++) {
                    int i15 = i14 * 16;
                    try {
                        c13667b.mo79737b(bArr, i15, bArr4, i15);
                    } catch (IllegalStateException unused2) {
                        str3 = "encryptBySm4OutByte IllegalStateException";
                        C1016d.m6183c("SM4Security", str3);
                        return C9811c.m60986c(bArr4);
                    } catch (C13294h unused3) {
                        str3 = "encryptBySm4OutByte DataLengthException";
                        C1016d.m6183c("SM4Security", str3);
                        return C9811c.m60986c(bArr4);
                    }
                }
                return C9811c.m60986c(bArr4);
            }
        }
        return str;
    }
}
