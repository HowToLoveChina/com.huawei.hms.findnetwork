package p762x4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p699v4.C13345n;
import p798y4.C13909a;

/* renamed from: x4.i */
/* loaded from: classes.dex */
public class C13702i {

    /* renamed from: a */
    public String f61688a;

    /* renamed from: b */
    public String f61689b;

    /* renamed from: c */
    public ArrayList<C13909a> f61690c;

    /* renamed from: d */
    public Context f61691d;

    public C13702i(Context context, String str) {
        this.f61688a = str;
        this.f61691d = context;
        m82439c();
    }

    /* renamed from: a */
    public boolean m82437a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            C2111d.m12648d("ReaderAppData", "createFile mkdirs fail");
            return false;
        }
        try {
            if (!file.createNewFile()) {
                C2111d.m12648d("ReaderAppData", "createFile fail:" + str);
            }
            return true;
        } catch (IOException unused) {
            C2111d.m12648d("ReaderAppData", "createFile createNewFile fail");
            return false;
        }
    }

    /* renamed from: b */
    public File m82438b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(str);
        }
        C2111d.m12657m("ReaderAppData", "appFilepath is empty");
        return null;
    }

    /* renamed from: c */
    public final void m82439c() {
        Context context = this.f61691d;
        if (context == null) {
            C2111d.m12648d("ReaderAppData", "initFilePath error: mContext is null");
            return;
        }
        this.f61689b = C13345n.m80070i(context) + this.f61688a + ".txt";
    }

    /* renamed from: d */
    public final C13909a m82440d(String str) {
        if (TextUtils.isEmpty(str)) {
            C2111d.m12648d("ReaderAppData", "parseFileAttr fail param is null");
            return null;
        }
        String[] strArrSplit = str.split(";");
        if (strArrSplit.length != 5) {
            C2111d.m12648d("ReaderAppData", "parseFileAttr length error");
            return null;
        }
        C13909a c13909a = new C13909a();
        c13909a.m83340l(strArrSplit);
        return c13909a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0070 A[EXC_TOP_SPLITTER, PHI: r4 r5
  0x0070: PHI (r4v9 ??) = (r4v6 ??), (r4v7 ??), (r4v8 ??), (r4v14 ??), (r4v14 ??) binds: [B:47:0x0093, B:61:0x00b5, B:54:0x00a4, B:31:0x006d, B:29:0x0069] A[DONT_GENERATE, DONT_INLINE]
  0x0070: PHI (r5v9 java.io.InputStreamReader) = 
  (r5v6 java.io.InputStreamReader)
  (r5v7 java.io.InputStreamReader)
  (r5v8 java.io.InputStreamReader)
  (r5v10 java.io.InputStreamReader)
  (r5v10 java.io.InputStreamReader)
 binds: [B:47:0x0093, B:61:0x00b5, B:54:0x00a4, B:31:0x006d, B:29:0x0069] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [x4.i] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<p798y4.C13909a> m82441e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p762x4.C13702i.m82441e():java.util.ArrayList");
    }

    /* renamed from: f */
    public boolean m82442f(List<C13909a> list) throws Throwable {
        if (list == null || list.isEmpty()) {
            C2111d.m12648d("ReaderAppData", "writeAttrFileInfo appDataFileAttrs  error:appDataFileAttrs is null");
            return false;
        }
        if (!m82437a(this.f61689b)) {
            C2111d.m12648d("ReaderAppData", "createFile fail currAttrFilePath=" + this.f61689b);
            return false;
        }
        PrintWriter printWriter = null;
        try {
            try {
                PrintWriter printWriter2 = new PrintWriter(new File(this.f61689b), Constants.UTF_8);
                try {
                    Iterator<C13909a> it = list.iterator();
                    while (it.hasNext()) {
                        printWriter2.println(it.next().m83330b());
                    }
                    printWriter2.close();
                    return true;
                } catch (IOException unused) {
                    printWriter = printWriter2;
                    C2111d.m12648d("ReaderAppData", "writeAttrFileInfo error");
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
