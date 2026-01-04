package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R$string;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import gu.C10047a;
import gu.C10048b;
import gu.C10050d;
import gu.C10051e;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import lu.C11344c;

/* renamed from: com.huawei.hms.opendevice.l */
/* loaded from: classes8.dex */
public abstract class AbstractC6274l {

    /* renamed from: a */
    private static final String f29592a = "l";

    /* renamed from: b */
    private static Map<String, String> f29593b = new HashMap();

    /* renamed from: c */
    private static final Object f29594c = new Object();

    /* renamed from: a */
    private static byte[] m36452a(String str, String str2, String str3, String str4) {
        return C10047a.m62465g(str, str2, str3, str4, 32, true);
    }

    /* renamed from: b */
    private static byte[] m36456b() {
        return m36452a(m36459d(), m36461e(), m36457c(), m36464g());
    }

    /* renamed from: c */
    public static void m36458c(Context context) {
        synchronized (f29594c) {
            try {
                m36460d(context.getApplicationContext());
                if (m36466i()) {
                    HMSLog.m36988i(f29592a, "The local secret is already in separate file mode.");
                    return;
                }
                File file = new File(AbstractC6267e.m36422c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
                if (file.exists()) {
                    C11344c.m68148a(file);
                    HMSLog.m36988i(f29592a, "destroy C, delete file LocalAvengers.xml.");
                }
                byte[] bArrM62472d = C10048b.m62472d(32);
                byte[] bArrM62472d2 = C10048b.m62472d(32);
                byte[] bArrM62472d3 = C10048b.m62472d(32);
                byte[] bArrM62472d4 = C10048b.m62472d(32);
                String strM36416a = AbstractC6266d.m36416a(bArrM62472d);
                String strM36416a2 = AbstractC6266d.m36416a(bArrM62472d2);
                String strM36416a3 = AbstractC6266d.m36416a(bArrM62472d3);
                String strM36416a4 = AbstractC6266d.m36416a(bArrM62472d4);
                m36450a(strM36416a, strM36416a2, strM36416a3, strM36416a4, C10051e.m62486d(AbstractC6266d.m36416a(C10048b.m62472d(32)), m36452a(strM36416a, strM36416a2, strM36416a3, strM36416a4)), context);
                HMSLog.m36988i(f29592a, "generate D.");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    private static void m36460d(Context context) throws Throwable {
        if (m36466i()) {
            HMSLog.m36988i(f29592a, "secretKeyCache not empty.");
            return;
        }
        f29593b.clear();
        String strM36422c = AbstractC6267e.m36422c(context);
        if (TextUtils.isEmpty(strM36422c)) {
            return;
        }
        String strM36467a = AbstractC6275m.m36467a(strM36422c + "/files/math/m");
        String strM36467a2 = AbstractC6275m.m36467a(strM36422c + "/files/panda/p");
        String strM36467a3 = AbstractC6275m.m36467a(strM36422c + "/files/panda/d");
        String strM36467a4 = AbstractC6275m.m36467a(strM36422c + "/files/math/t");
        String strM36467a5 = AbstractC6275m.m36467a(strM36422c + "/files/s");
        if (C6276n.m36469a(strM36467a, strM36467a2, strM36467a3, strM36467a4, strM36467a5)) {
            f29593b.put("m", strM36467a);
            f29593b.put("p", strM36467a2);
            f29593b.put("d", strM36467a3);
            f29593b.put("t", strM36467a4);
            f29593b.put("s", strM36467a5);
        }
    }

    /* renamed from: e */
    private static synchronized String m36462e(Context context) {
        String strM62484b = C10051e.m62484b(m36463f(), m36456b());
        if (C6276n.m36469a(strM62484b)) {
            HMSLog.m36988i(f29592a, "keyS has been upgraded, no require operate again.");
            return strM62484b;
        }
        String strM62483a = C10051e.m62483a(m36463f(), m36465h());
        if (C6276n.m36469a(strM62483a)) {
            HMSLog.m36988i(f29592a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
            m36448a(C10051e.m62486d(strM62483a, m36456b()), context);
            return strM62483a;
        }
        String strM62484b2 = C10051e.m62484b(m36463f(), C10047a.m62465g(m36459d(), m36461e(), m36457c(), m36464g(), 32, false));
        if (!C6276n.m36469a(strM62484b2)) {
            HMSLog.m36986e(f29592a, "all mode unable to decrypt root key.");
            return "";
        }
        HMSLog.m36988i(f29592a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
        m36448a(C10051e.m62486d(strM62484b2, m36456b()), context);
        return strM62484b2;
    }

    /* renamed from: f */
    private static String m36463f() {
        return m36447a("s");
    }

    /* renamed from: g */
    private static String m36464g() {
        return m36447a("t");
    }

    /* renamed from: h */
    private static C10050d m36465h() {
        return C10050d.m62478e(m36459d(), m36461e(), m36457c(), m36464g());
    }

    /* renamed from: i */
    private static boolean m36466i() {
        return !TextUtils.isEmpty(m36463f());
    }

    /* renamed from: a */
    public static byte[] m36451a(Context context) {
        byte[] bArrM36417a = AbstractC6266d.m36417a(context.getString(R$string.push_cat_head));
        byte[] bArrM36417a2 = AbstractC6266d.m36417a(context.getString(R$string.push_cat_body));
        return m36453a(m36454a(m36454a(bArrM36417a, bArrM36417a2), AbstractC6266d.m36417a(m36446a())));
    }

    /* renamed from: b */
    public static String m36455b(Context context) {
        if (!m36466i()) {
            HMSLog.m36988i(f29592a, "work key is empty, execute init.");
            m36458c(context);
        }
        String strM62484b = C10051e.m62484b(m36463f(), m36456b());
        return C6276n.m36469a(strM62484b) ? strM62484b : m36462e(context);
    }

    /* renamed from: a */
    private static String m36446a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    /* renamed from: a */
    private static byte[] m36454a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && bArr.length != 0 && bArr2.length != 0) {
            int length = bArr.length;
            if (length != bArr2.length) {
                return new byte[0];
            }
            byte[] bArr3 = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
            }
            return bArr3;
        }
        return new byte[0];
    }

    /* renamed from: a */
    private static byte[] m36453a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr[i10] = (byte) (bArr[i10] >> 2);
            }
            return bArr;
        }
        return new byte[0];
    }

    /* renamed from: d */
    private static String m36459d() {
        return m36447a("m");
    }

    /* renamed from: e */
    private static String m36461e() {
        return m36447a("p");
    }

    /* renamed from: a */
    private static void m36450a(String str, String str2, String str3, String str4, String str5, Context context) throws Throwable {
        String strM36422c = AbstractC6267e.m36422c(context.getApplicationContext());
        if (TextUtils.isEmpty(strM36422c)) {
            return;
        }
        try {
            m36449a("m", str, strM36422c + "/files/math/m");
            m36449a("p", str2, strM36422c + "/files/panda/p");
            m36449a("d", str3, strM36422c + "/files/panda/d");
            m36449a("t", str4, strM36422c + "/files/math/t");
            m36449a("s", str5, strM36422c + "/files/s");
        } catch (IOException unused) {
            HMSLog.m36986e(f29592a, "save key IOException.");
        }
    }

    /* renamed from: c */
    private static String m36457c() {
        return m36447a("d");
    }

    /* renamed from: a */
    private static void m36448a(String str, Context context) throws Throwable {
        String strM36422c = AbstractC6267e.m36422c(context.getApplicationContext());
        if (TextUtils.isEmpty(strM36422c)) {
            return;
        }
        try {
            m36449a("s", str, strM36422c + "/files/s");
        } catch (IOException unused) {
            HMSLog.m36986e(f29592a, "save keyS IOException.");
        }
    }

    /* renamed from: a */
    private static void m36449a(String str, String str2, String str3) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        HMSLog.m36988i(f29592a, "save local secret key.");
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str3);
            AbstractC6275m.m36468a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), Constants.UTF_8);
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
        }
        try {
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            f29593b.put(str, str2);
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter2 = bufferedWriter;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter2);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m36447a(String str) {
        String str2 = f29593b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
