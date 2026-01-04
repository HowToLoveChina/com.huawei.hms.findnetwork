package na;

import android.text.TextUtils;
import com.huawei.cloud.base.util.C4634e;
import com.huawei.hiar.ARImageMetadata;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import p015ak.C0241z;
import p399jk.AbstractC10896a;

/* renamed from: na.a */
/* loaded from: classes3.dex */
public final class C11655a {

    /* renamed from: a */
    public String f54067a;

    /* renamed from: b */
    public InputStream f54068b;

    /* renamed from: c */
    public boolean f54069c = true;

    /* renamed from: d */
    public RandomAccessFile f54070d;

    public C11655a(InputStream inputStream, String str, RandomAccessFile randomAccessFile) throws IOException {
        this.f54067a = str;
        this.f54070d = randomAccessFile;
        this.f54068b = inputStream;
        m69604a(m69606c());
    }

    /* renamed from: e */
    public static InputStream m69602e(byte[] bArr) {
        int length = bArr.length;
        if (length > 0 && bArr[length - 1] == 10) {
            length--;
        }
        if (length > 0 && bArr[length - 1] == 13) {
            length--;
        }
        return new ByteArrayInputStream(bArr, 0, length);
    }

    /* renamed from: f */
    public static String m69603f(String str) {
        if (str == null) {
            return null;
        }
        return str.endsWith("\r\n") ? str.substring(0, str.length() - 2) : str.endsWith("\n") ? str.substring(0, str.length() - 1) : str;
    }

    /* renamed from: a */
    public final void m69604a(String str) throws IOException {
        if (str.equals(this.f54067a + "--")) {
            this.f54069c = false;
            this.f54068b.close();
        }
    }

    /* renamed from: b */
    public void m69605b() throws IOException {
        String strM69607d;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strM69606c = m69606c();
        boolean z10 = (strM69606c == null || strM69606c.equals("")) ? false : true;
        long jM1688f = -1;
        long jM1688f2 = -1;
        while (z10) {
            String[] strArrSplit = strM69606c.split(": ", 2);
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            arrayList.add(str);
            arrayList2.add(str2);
            if ("Content-Length".equalsIgnoreCase(str.trim())) {
                jM1688f = C0241z.m1688f(str2);
            }
            if ("Content-range".equalsIgnoreCase(str.trim())) {
                jM1688f2 = C0241z.m1688f(str2.substring(str2.indexOf("bytes") + 6, str2.indexOf(45)));
            }
            strM69606c = m69606c();
            z10 = (strM69606c == null || strM69606c.equals("")) ? false : true;
        }
        InputStream inputStreamM28407b = null;
        try {
            if (jM1688f == -1) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    strM69607d = m69607d();
                    if (strM69607d == null || strM69607d.startsWith(this.f54067a)) {
                        break;
                    } else {
                        byteArrayOutputStream.write(strM69607d.getBytes("ISO-8859-1"));
                    }
                }
                inputStreamM28407b = m69602e(byteArrayOutputStream.toByteArray());
                strM69606c = m69603f(strM69607d);
            } else {
                inputStreamM28407b = C4634e.m28407b(this.f54068b, jM1688f);
            }
            byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
            this.f54070d.seek(jM1688f2);
            while (true) {
                int i10 = inputStreamM28407b.read(bArr);
                if (i10 == -1) {
                    break;
                } else {
                    this.f54070d.write(bArr, 0, i10);
                }
            }
            while (true) {
                if (inputStreamM28407b.skip(jM1688f) <= 0 && inputStreamM28407b.read() == -1) {
                    try {
                        break;
                    } catch (IOException unused) {
                        AbstractC10896a.m65886e("MutipartUnparsedResponse", "inputStream close exception.");
                    }
                }
            }
            inputStreamM28407b.close();
            if (jM1688f != -1) {
                strM69606c = m69606c();
            }
            while (strM69606c != null && strM69606c.length() == 0) {
                strM69606c = m69606c();
            }
            if (TextUtils.isEmpty(strM69606c)) {
                return;
            }
            m69604a(strM69606c);
        } catch (Throwable th2) {
            if (inputStreamM28407b != null) {
                try {
                    inputStreamM28407b.close();
                } catch (IOException unused2) {
                    AbstractC10896a.m65886e("MutipartUnparsedResponse", "inputStream close exception.");
                }
            }
            throw th2;
        }
    }

    /* renamed from: c */
    public final String m69606c() throws IOException {
        return m69603f(m69607d());
    }

    /* renamed from: d */
    public final String m69607d() throws IOException {
        int i10 = this.f54068b.read();
        if (i10 == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 != -1) {
            sb2.append((char) i10);
            if (i10 == 10) {
                break;
            }
            i10 = this.f54068b.read();
        }
        return sb2.toString();
    }
}
