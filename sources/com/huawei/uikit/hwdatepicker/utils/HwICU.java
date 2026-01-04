package com.huawei.uikit.hwdatepicker.utils;

import android.util.Log;
import com.huawei.openalliance.p169ad.constant.VastAttribute;

/* loaded from: classes7.dex */
public class HwICU {

    /* renamed from: a */
    private static final String f42149a = "ICU";

    /* renamed from: b */
    private static final int f42150b = 3;

    /* renamed from: c */
    private static final int f42151c = -1;

    public static class aauaf {

        /* renamed from: a */
        int f42152a = 0;

        /* renamed from: b */
        boolean f42153b = false;

        /* renamed from: c */
        boolean f42154c = false;

        /* renamed from: d */
        boolean f42155d = false;
    }

    public static class bzrwd {

        /* renamed from: a */
        boolean f42156a;

        /* renamed from: b */
        boolean f42157b;

        /* renamed from: c */
        boolean f42158c;
    }

    private HwICU() {
    }

    /* renamed from: a */
    private static void m54223a(char c10, char[] cArr, bzrwd bzrwdVar, aauaf aauafVar) {
        int i10 = aauafVar.f42152a;
        if (i10 >= 3 || i10 < 0) {
            return;
        }
        if (c10 == 'd' && !aauafVar.f42153b) {
            aauafVar.f42152a = i10 + 1;
            cArr[i10] = 'd';
            aauafVar.f42153b = true;
        } else if (bzrwdVar.f42157b && !aauafVar.f42154c) {
            aauafVar.f42152a = i10 + 1;
            cArr[i10] = 'M';
            aauafVar.f42154c = true;
        } else {
            if (c10 != 'y' || aauafVar.f42155d) {
                Log.e(f42149a, VastAttribute.ERROR);
                return;
            }
            aauafVar.f42152a = i10 + 1;
            cArr[i10] = 'y';
            aauafVar.f42155d = true;
        }
    }

    public static char[] getDateFormatOrder(String str) {
        char[] cArr = new char[3];
        if (str == null) {
            Log.w(f42149a, "getDateFormatOrder method: parms pattern is null");
            return cArr;
        }
        aauaf aauafVar = new aauaf();
        int length = str.length();
        int iIndexOf = 0;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            bzrwd bzrwdVarM54222a = m54222a(cCharAt);
            if (bzrwdVarM54222a.f42156a) {
                m54223a(cCharAt, cArr, bzrwdVarM54222a, aauafVar);
            } else if (cCharAt == 'G') {
                Log.w("TAG", "ignore");
            } else {
                if (bzrwdVarM54222a.f42158c) {
                    Log.w(f42149a, "Bad pattern character '" + cCharAt + "' in " + str);
                    return cArr;
                }
                if (cCharAt == '\'') {
                    if (iIndexOf >= str.length() - 1 || str.charAt(iIndexOf + 1) != '\'') {
                        iIndexOf = str.indexOf(39, iIndexOf + 1);
                    }
                    if (iIndexOf == -1) {
                        Log.w(f42149a, "Bad quoting in " + str);
                        return cArr;
                    }
                    iIndexOf++;
                } else {
                    Log.w("TAG", "ignore");
                }
            }
            iIndexOf++;
        }
        return cArr;
    }

    /* renamed from: a */
    private static bzrwd m54222a(char c10) {
        boolean z10 = true;
        boolean z11 = c10 == 'd' || c10 == 'L' || c10 == 'M' || c10 == 'y';
        boolean z12 = c10 == 'L' || c10 == 'M';
        if ((c10 < 'a' || c10 > 'z') && (c10 < 'A' || c10 > 'Z')) {
            z10 = false;
        }
        bzrwd bzrwdVar = new bzrwd();
        bzrwdVar.f42156a = z11;
        bzrwdVar.f42157b = z12;
        bzrwdVar.f42158c = z10;
        return bzrwdVar;
    }
}
