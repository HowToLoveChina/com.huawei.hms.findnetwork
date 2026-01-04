package com.huawei.hms.hatool;

import com.huawei.hwcloudjs.p165g.C6664a;
import gu.C10048b;
import gu.C10049c;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import p237du.AbstractC9309b;

/* renamed from: com.huawei.hms.hatool.x */
/* loaded from: classes8.dex */
public class C5575x {

    /* renamed from: a */
    private String f25322a = AbstractC5562q0.m32718i().getFilesDir().getPath();

    /* renamed from: b */
    private String m32813b(String str) throws Throwable {
        File file = new File(m32809a(str), "hianalytics_" + str);
        if (m32811a(file)) {
            return C5545k1.m32607a(file);
        }
        String strM62473e = C10048b.m62473e(128);
        C5545k1.m32610a(file, strM62473e);
        return strM62473e;
    }

    /* renamed from: c */
    public static boolean m32816c() {
        return m32815b(new File(AbstractC5562q0.m32718i().getFilesDir().getPath() + "/" + C6664a.f30905c));
    }

    /* renamed from: d */
    private String m32817d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    /* renamed from: a */
    public String m32818a() throws Throwable {
        String strM32813b;
        String strM32813b2;
        String strM32813b3;
        String strM32813b4;
        String strM32817d = m32817d();
        if (m32814b()) {
            C5571v.m32792c("hmsSdk", "refresh components");
            strM32813b = C10048b.m62473e(128);
            m32810a("aprpap", strM32813b);
            strM32813b2 = C10048b.m62473e(128);
            m32810a("febdoc", strM32813b2);
            strM32813b3 = C10048b.m62473e(128);
            m32810a("marfil", strM32813b3);
            strM32813b4 = C10048b.m62473e(128);
            m32810a("maywnj", strM32813b4);
            C5522d.m32480b(AbstractC5562q0.m32718i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            strM32813b = m32813b("aprpap");
            strM32813b2 = m32813b("febdoc");
            strM32813b3 = m32813b("marfil");
            strM32813b4 = m32813b("maywnj");
        }
        return C10049c.m62476a(AbstractC9309b.m58615b(m32812a(strM32813b, strM32813b2, strM32813b3, strM32817d), C10049c.m62477b(strM32813b4), 10000, 16));
    }

    /* renamed from: a */
    private String m32809a(String str) {
        return this.f25322a + "/hms/component/".replace("component", str);
    }

    /* renamed from: b */
    private boolean m32814b() {
        long jM32475a = C5522d.m32475a(AbstractC5562q0.m32718i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != jM32475a) {
            return System.currentTimeMillis() - jM32475a > 31536000000L;
        }
        C5571v.m32792c("hmsSdk", "First init components");
        return true;
    }

    /* renamed from: a */
    private void m32810a(String str, String str2) throws Throwable {
        File file = new File(m32809a(str));
        File file2 = new File(m32809a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            C5571v.m32792c("hmsSdk", "file directory is mkdirs");
        }
        if (m32811a(file2)) {
            C5545k1.m32610a(file2, str2);
        } else {
            C5571v.m32797f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    /* renamed from: b */
    private static boolean m32815b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    C5571v.m32792c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                m32815b(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    private boolean m32811a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            C5571v.m32797f("hmsSdk", "create new file error!");
            return false;
        }
    }

    /* renamed from: a */
    private char[] m32812a(String str, String str2, String str3, String str4) throws UnsupportedEncodingException {
        byte[] bArrM62477b = C10049c.m62477b(str);
        byte[] bArrM62477b2 = C10049c.m62477b(str2);
        byte[] bArrM62477b3 = C10049c.m62477b(str3);
        byte[] bArrM62477b4 = C10049c.m62477b(str4);
        int length = bArrM62477b.length;
        if (length > bArrM62477b2.length) {
            length = bArrM62477b2.length;
        }
        if (length > bArrM62477b3.length) {
            length = bArrM62477b3.length;
        }
        if (length > bArrM62477b4.length) {
            length = bArrM62477b4.length;
        }
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = (char) (((bArrM62477b[i10] ^ bArrM62477b2[i10]) ^ bArrM62477b3[i10]) ^ bArrM62477b4[i10]);
        }
        return cArr;
    }
}
