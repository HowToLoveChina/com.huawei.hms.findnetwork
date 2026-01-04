package as;

import android.os.Bundle;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.openalliance.p169ad.constant.Constants;
import es.C9537b;
import es.C9542g;
import es.C9552q;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import p209cs.C8947c;
import p209cs.C8948d;

/* renamed from: as.c */
/* loaded from: classes8.dex */
public final class C1015c {

    /* renamed from: a */
    public static final byte[] f5049a = new byte[0];

    /* renamed from: b */
    public static byte[] f5050b = new byte[2048];

    /* renamed from: c */
    public static int f5051c;

    /* renamed from: a */
    public static String m6176a(List<String> list) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        if (C9537b.m59560a(list)) {
            stringBuffer.append("|\r\n");
        } else {
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (i10 != list.size() - 1) {
                    stringBuffer.append("|");
                    str = list.get(i10);
                } else {
                    str = "\r\n";
                }
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static void m6177b() {
        synchronized (f5049a) {
            f5050b = new byte[2048];
            f5051c = 0;
        }
    }

    /* renamed from: c */
    public static void m6178c(byte[] bArr, String str) {
        if (bArr.length + f5051c + 1 > 2048) {
            ReportBuilder reportBuilder = new ReportBuilder();
            reportBuilder.setTag(str);
            String str2 = "";
            int i10 = f5051c;
            if (i10 > 0) {
                try {
                    byte[] bArr2 = f5050b;
                    int i11 = i10 + 1;
                    if (i11 > 2048) {
                        i11 = 2048;
                    }
                    str2 = new String(bArr2, 0, i11, Constants.UTF_8);
                } catch (UnsupportedEncodingException unused) {
                    C1016d.m6190j("LogCache", "toString() UnsupportedEncodingException");
                }
            }
            reportBuilder.setErrorMessage(str2);
            if (C9552q.m59643a() == 200) {
                C8948d c8948d = new C8948d();
                c8948d.m56671a(C9542g.m59588a().toJson(reportBuilder));
                Bundle bundle = new Bundle();
                bundle.putString("report_type", "event");
                c8948d.m56672b(bundle);
                C8947c.m56668a().m56669b(102, "report", c8948d, null);
            } else {
                C6791a.m38458h().m38466k(1, "Location_errorLogReport", reportBuilder.build());
            }
            m6177b();
        }
        synchronized (f5049a) {
            try {
                for (byte b10 : bArr) {
                    int i12 = f5051c;
                    if (i12 >= 0 && i12 < 2048) {
                        f5050b[i12] = b10;
                        f5051c = i12 + 1;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public static byte[] m6179d(String str, String str2) {
        byte[] bArr = new byte[0];
        try {
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "|" + str + "|" + str2 + "\r\n").getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            C1016d.m6190j("LogCache", "putStr() UnsupportedEncodingException");
            return bArr;
        }
    }

    /* renamed from: e */
    public static byte[] m6180e(String str, List<String> list) throws UnsupportedEncodingException {
        String string;
        String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        byte[] bytes = new byte[0];
        try {
            if (C9537b.m59560a(list)) {
                string = str2 + "|" + str + "\r\n";
            } else {
                StringBuffer stringBuffer = new StringBuffer(str2);
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (i10 != list.size() - 1) {
                        stringBuffer.append("|");
                        stringBuffer.append(list.get(i10));
                    } else {
                        stringBuffer.append('\r');
                        stringBuffer.append('\n');
                    }
                }
                string = stringBuffer.toString();
            }
            bytes = string.getBytes(Constants.UTF_8);
            return bytes;
        } catch (UnsupportedEncodingException unused) {
            C1016d.m6190j("LogCache", "putStr() UnsupportedEncodingException");
            return bytes;
        }
    }
}
