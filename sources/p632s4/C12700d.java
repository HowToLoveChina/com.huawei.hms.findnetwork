package p632s4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import p699v4.C13334c;
import p699v4.C13339h;

/* renamed from: s4.d */
/* loaded from: classes.dex */
public class C12700d {

    /* renamed from: a */
    public static final String f58239a = System.getProperty("line.separator");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
    /* renamed from: a */
    public static int m76423a(Context context, String str, String[] strArr) throws Throwable {
        Closeable closeable;
        Throwable th2;
        OutputStreamWriter outputStreamWriter;
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        File dir = context.getDir("medaicache", 0);
        if (!dir.exists() && !dir.mkdir()) {
            C2111d.m12648d("MediaCacheHelper", "writeMediaFileSet mkdir ERROR!");
            return -1;
        }
        String str2 = C13334c.m79991x(dir) + File.separator + str;
        File file = new File(str2);
        ?? Exists = file.exists();
        if (Exists != 0 && !file.delete()) {
            C2111d.m12648d("MediaCacheHelper", "writeMediaFileSet delete ERROR!");
        }
        if (strArr != null && strArr.length > 0) {
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                try {
                    Exists = new FileOutputStream(new File(str2));
                    try {
                        try {
                            outputStreamWriter = new OutputStreamWriter((OutputStream) Exists, Constants.UTF_8);
                            try {
                                for (String str3 : strArr) {
                                    outputStreamWriter.write(str3);
                                    outputStreamWriter.write(f58239a);
                                }
                                outputStreamWriter.flush();
                                outputStreamWriter.close();
                                Exists = Exists;
                            } catch (IOException unused) {
                                outputStreamWriter2 = outputStreamWriter;
                                C2111d.m12648d("MediaCacheHelper", "writeMediaFileSet  ERROR!");
                                if (outputStreamWriter2 != null) {
                                    outputStreamWriter2.close();
                                    Exists = Exists;
                                }
                                C13339h.m80014a(Exists);
                                return 0;
                            } catch (Throwable th3) {
                                th2 = th3;
                                closeable = Exists;
                                if (outputStreamWriter != null) {
                                    try {
                                        outputStreamWriter.close();
                                    } catch (IOException unused2) {
                                        C2111d.m12648d("MediaCacheHelper", "writeMediaFileSet close file ERROR!");
                                    }
                                }
                                C13339h.m80014a(closeable);
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            OutputStreamWriter outputStreamWriter3 = outputStreamWriter2;
                            th2 = th4;
                            outputStreamWriter = outputStreamWriter3;
                            closeable = Exists;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                    Exists = 0;
                } catch (Throwable th5) {
                    closeable = null;
                    th2 = th5;
                    outputStreamWriter = null;
                }
            } catch (IOException unused5) {
                C2111d.m12648d("MediaCacheHelper", "writeMediaFileSet close file ERROR!");
            }
            C13339h.m80014a(Exists);
        }
        return 0;
    }
}
