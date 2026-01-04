package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.utils.AbstractC7740an;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;

/* renamed from: com.huawei.openalliance.ad.pc */
/* loaded from: classes8.dex */
public class C7569pc {

    /* renamed from: a */
    private static final byte[] f35281a = new byte[0];

    /* renamed from: b */
    private static C7569pc f35282b;

    /* renamed from: c */
    private InterfaceC7146gc f35283c;

    /* renamed from: d */
    private String f35284d = m46687a();

    /* renamed from: com.huawei.openalliance.ad.pc$a */
    public static class a {

        /* renamed from: a */
        private String f35285a;

        /* renamed from: b */
        private String f35286b;

        /* renamed from: a */
        public String m46696a() {
            return this.f35285a;
        }

        /* renamed from: b */
        public String m46697b() {
            return this.f35286b;
        }
    }

    private C7569pc(Context context) {
        this.f35283c = C7124fh.m43316b(context);
    }

    /* renamed from: a */
    public a m46691a(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("MonitorUrlFomatter", " url is empty");
            return null;
        }
        a aVar = new a();
        aVar.f35285a = str;
        if (str.indexOf("__HWPPSREQUESTID__") > 0) {
            String strM46688a = m46688a(1);
            aVar.f35286b = strM46688a;
            aVar.f35285a = str.replace("__HWPPSREQUESTID__", strM46688a);
        }
        String str2 = aVar.f35285a;
        if (str2.indexOf("__TS__") > 0 && m46690a(j10)) {
            aVar.f35285a = str2.replace("__TS__", String.valueOf(j10));
        }
        return aVar;
    }

    /* renamed from: a */
    public a m46692a(String str, String str2, long j10) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("MonitorUrlFomatter", " url is empty");
            return null;
        }
        a aVar = new a();
        aVar.f35285a = str;
        if (str.indexOf("__HWPPSREQUESTID__") > 0) {
            String strM46688a = TextUtils.isEmpty(str2) ? m46688a(1) : m46689a(str2);
            aVar.f35286b = strM46688a;
            aVar.f35285a = str.replace("__HWPPSREQUESTID__", strM46688a);
        }
        String str3 = aVar.f35285a;
        if (str3.indexOf("__TS__") > 0 && m46690a(j10)) {
            aVar.f35285a = str3.replace("__TS__", String.valueOf(j10));
        }
        return aVar;
    }

    /* renamed from: a */
    public static C7569pc m46686a(Context context) {
        C7569pc c7569pc;
        synchronized (f35281a) {
            try {
                if (f35282b == null) {
                    f35282b = new C7569pc(context);
                }
                c7569pc = f35282b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7569pc;
    }

    /* renamed from: a */
    private String m46687a() {
        String strMo43412bm = this.f35283c.mo43412bm();
        if (!TextUtils.isEmpty(strMo43412bm)) {
            return strMo43412bm;
        }
        String strReplaceAll = AbstractC7741ao.m47539a().replaceAll("-", "");
        this.f35283c.mo43476m(strReplaceAll);
        return strReplaceAll;
    }

    /* renamed from: a */
    private String m46688a(int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f35284d);
        stringBuffer.append("_");
        stringBuffer.append(AbstractC7740an.m47531a(AbstractC7796cp.m48081a(7)));
        stringBuffer.append("_");
        stringBuffer.append(i10);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m46689a(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return m46688a(1);
        }
        try {
            int iLastIndexOf = str.lastIndexOf("_");
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length() - 1) {
                str3 = "requestId format is illegal.";
            } else {
                int i10 = iLastIndexOf + 1;
                String strSubstring = str.substring(i10);
                if (!TextUtils.isEmpty(strSubstring)) {
                    int i11 = Integer.parseInt(strSubstring) + 1;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append((CharSequence) str, 0, i10);
                    stringBuffer.append(i11);
                    return stringBuffer.toString();
                }
                str3 = "requestId format is illegal. seq is empty";
            }
            AbstractC7185ho.m43820b("MonitorUrlFomatter", str3);
        } catch (NumberFormatException unused) {
            str2 = "seq has format exception:";
            AbstractC7185ho.m43823c("MonitorUrlFomatter", str2);
            return m46688a(1);
        } catch (Exception unused2) {
            str2 = "increaseRequestIdSeqNum has exception";
            AbstractC7185ho.m43823c("MonitorUrlFomatter", str2);
            return m46688a(1);
        }
        return m46688a(1);
    }

    /* renamed from: a */
    private boolean m46690a(long j10) {
        return j10 != -111111 && j10 > 0;
    }
}
