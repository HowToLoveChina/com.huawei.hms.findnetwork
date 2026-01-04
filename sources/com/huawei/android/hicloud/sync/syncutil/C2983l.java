package com.huawei.android.hicloud.sync.syncutil;

import android.text.TextUtils;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.l */
/* loaded from: classes3.dex */
public final class C2983l {
    /* renamed from: a */
    public static String m17904a(String str) {
        return m17905b(str, 2);
    }

    /* renamed from: b */
    public static String m17905b(String str, int i10) {
        int i11;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        if (i10 == 1) {
            i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                char cCharAt = str.charAt(i12);
                if (cCharAt != ' ') {
                    cArr[i11] = cCharAt;
                    i11++;
                }
            }
        } else if (i10 == 2) {
            i11 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                char cCharAt2 = str.charAt(i13);
                if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                    cArr[i11] = cCharAt2;
                    i11++;
                }
            }
        } else {
            i11 = 0;
        }
        return i11 == length ? str : new String(cArr, 0, i11);
    }

    /* renamed from: c */
    public static String m17906c(String str) {
        return m17905b(str, 1);
    }

    /* renamed from: d */
    public static String[] m17907d(String[] strArr, int i10) {
        if (strArr == null) {
            return new String[i10];
        }
        if (strArr.length >= i10) {
            return strArr;
        }
        C11839m.m70688i("StringUtil", "origArray.length is less than destLength: origArray.length = " + strArr.length + ", destLength = " + i10);
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.StringBuilder] */
    /* renamed from: e */
    public static String m17908e(String str) throws Throwable {
        String str2;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(str.length() / 2);
                for (int i10 = 0; i10 < str.length(); i10 += 2) {
                    try {
                        byteArrayOutputStream3.write(("0123456789ABCDEF".indexOf(str.charAt(i10)) << 4) | "0123456789ABCDEF".indexOf(str.charAt(i10 + 1)));
                    } catch (Exception e10) {
                        e = e10;
                        byteArrayOutputStream2 = byteArrayOutputStream3;
                        C11839m.m70687e("StringUtil", "[hexDecode] catch Exception ,  exception content:" + e.toString());
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e11) {
                                C11839m.m70688i("StringUtil", "[hexDecode] catch Exception ,  exception content:" + e11.toString());
                            }
                        }
                        str2 = "";
                        byteArrayOutputStream = byteArrayOutputStream2;
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream3;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e12) {
                                C11839m.m70688i("StringUtil", "[hexDecode] catch Exception ,  exception content:" + e12.toString());
                            }
                        }
                        throw th;
                    }
                }
                byte[] byteArray = byteArrayOutputStream3.toByteArray();
                ?? r32 = Constants.UTF_8;
                str2 = new String(byteArray, Constants.UTF_8);
                try {
                    byteArrayOutputStream3.close();
                    byteArrayOutputStream = r32;
                } catch (IOException e13) {
                    ?? sb2 = new StringBuilder();
                    sb2.append("[hexDecode] catch Exception ,  exception content:");
                    sb2.append(e13.toString());
                    C11839m.m70688i("StringUtil", sb2.toString());
                    byteArrayOutputStream = sb2;
                }
            } catch (Exception e14) {
                e = e14;
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: f */
    public static String m17909f(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("utf-8");
            StringBuilder sb2 = new StringBuilder(bytes.length * 2);
            for (byte b10 : bytes) {
                sb2.append("0123456789ABCDEF".charAt((b10 & 240) >> 4));
                sb2.append("0123456789ABCDEF".charAt(b10 & BaseType.Obj));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException unused) {
            C11839m.m70687e("StringUtil", "UnsupportedEncodingException occur");
            return null;
        }
    }

    /* renamed from: g */
    public static boolean m17910g(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i10 = 0; i10 < length; i10++) {
                if (str.charAt(i10) != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: h */
    public static String[] m17911h(String str, char c10) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList(5);
        int length = charArray.length;
        int i10 = 0;
        int i11 = 0;
        boolean z10 = true;
        for (int i12 = 0; i12 < length; i12++) {
            char c11 = charArray[i12];
            if (i10 != 0) {
                i10--;
            } else if (c11 == '\\') {
                i10++;
            } else if (c11 == c10) {
                if (z10) {
                    arrayList.add(str.substring(i11, i12));
                } else {
                    arrayList.add(str.substring(i11 + 1, i12));
                }
                if (i11 == 0) {
                    z10 = false;
                }
                i11 = i12;
            }
        }
        if (z10) {
            arrayList.add(str.substring(i11));
        } else {
            arrayList.add(str.substring(i11 + 1));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: i */
    public static String m17912i(String str) {
        return str.replace("\\", "\\\\").replace(";", "\\;");
    }
}
