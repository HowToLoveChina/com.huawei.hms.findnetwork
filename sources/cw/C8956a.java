package cw;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: cw.a */
/* loaded from: classes9.dex */
public class C8956a {
    /* renamed from: a */
    public static long m56699a(Reader reader, Writer writer) throws IOException {
        return m56700b(reader, writer, new char[4096]);
    }

    /* renamed from: b */
    public static long m56700b(Reader reader, Writer writer, char[] cArr) throws IOException {
        int i10 = reader.read(cArr);
        long j10 = 0;
        while (-1 != i10) {
            writer.write(cArr, 0, i10);
            j10 += i10;
            i10 = reader.read(cArr);
        }
        return j10;
    }

    /* renamed from: c */
    public static String m56701c(InputStream inputStream, String str) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                m56699a(inputStreamReader, stringWriter);
                String string = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return string;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                inputStreamReader.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
