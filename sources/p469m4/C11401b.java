package p469m4;

import android.util.Log;
import com.huawei.hianalytics.core.transport.Utils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import p417k4.C10983b;

/* renamed from: m4.b */
/* loaded from: classes.dex */
public final class C11401b {
    /* renamed from: a */
    public static void m68318a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e(Utils.TAG, "Exception when closing the 'Closeable'.");
            }
        }
    }

    /* renamed from: b */
    public static void m68319b(Reader reader, Writer writer) throws IOException {
        m68320c(reader, writer, new char[4096]);
    }

    /* renamed from: c */
    public static void m68320c(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int i10 = reader.read(cArr);
            if (-1 == i10) {
                return;
            } else {
                writer.write(cArr, 0, i10);
            }
        }
    }

    /* renamed from: d */
    public static Map<String, String> m68321d(Map<String, String> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map2.put(m68322e(entry.getKey()), entry.getValue());
        }
        return map2;
    }

    /* renamed from: e */
    public static String m68322e(String str) {
        int i10 = 0;
        if (str.length() > 0) {
            while (str.charAt(i10) == '/') {
                i10++;
            }
        }
        return "/" + str.substring(i10);
    }

    /* renamed from: f */
    public static C10983b m68323f(String str, String str2) {
        if (str == null) {
            if (str2 != null) {
                if (str2.contains("connect-drcn")) {
                    return C10983b.f52044c;
                }
                if (str2.contains("connect-dre")) {
                    return C10983b.f52045d;
                }
                if (str2.contains("connect-drru")) {
                    return C10983b.f52046e;
                }
                if (str2.contains("connect-dra")) {
                    return C10983b.f52047f;
                }
            }
            return C10983b.f52043b;
        }
        switch (str) {
            case "CN":
                return C10983b.f52044c;
            case "DE":
                return C10983b.f52045d;
            case "RU":
                return C10983b.f52046e;
            case "SG":
                return C10983b.f52047f;
            default:
                return C10983b.f52043b;
        }
    }

    /* renamed from: g */
    public static String m68324g(InputStream inputStream, String str) throws IOException {
        StringWriter stringWriter = new StringWriter();
        m68319b(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }
}
