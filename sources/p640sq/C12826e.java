package p640sq;

import android.text.TextUtils;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* renamed from: sq.e */
/* loaded from: classes8.dex */
public class C12826e {
    /* renamed from: a */
    public static String m77026a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        char[] cArr2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            cArr[i11] = cArr2[(b10 & 240) >> 4];
            cArr[i11 + 1] = cArr2[b10 & BaseType.Obj];
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static byte[] m77027b(String str) {
        if (TextUtils.isEmpty(str)) {
            C12836o.m77099d("CommonUtils", "getUTF8Bytes, str is empty", true);
            return new byte[0];
        }
        try {
            return str.getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C12836o.m77099d("CommonUtils", "getBytes error" + e10.getClass().getSimpleName(), true);
            return new byte[0];
        }
    }

    /* renamed from: c */
    public static boolean m77028c(String str) {
        C12836o.m77097b("CommonUtils", "the loginUrl is:" + str, false);
        try {
            String host = new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            ArrayList<String> arrayListM76994P = C12824c.m76994P();
            if (arrayListM76994P == null || arrayListM76994P.size() == 0 || TextUtils.isEmpty(host) || !arrayListM76994P.contains(host)) {
                C12836o.m77097b("CommonUtils", "host  is not in whitelist", true);
                return false;
            }
            C12836o.m77097b("CommonUtils", "host is in whitelist", true);
            return true;
        } catch (MalformedURLException unused) {
            C12836o.m77097b("CommonUtils", "MalformedURLException", true);
            return false;
        }
    }
}
