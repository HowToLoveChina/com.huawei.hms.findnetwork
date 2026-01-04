package com.huawei.location.crowdsourcing.upload;

import as.C1016d;
import com.huawei.location.activity.C6738e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.huawei.location.crowdsourcing.upload.b */
/* loaded from: classes8.dex */
public final class C6754b {
    /* renamed from: a */
    public static boolean m38357a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!m38357a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: b */
    public static boolean m38358b(String str, LinkedList linkedList) throws IOException {
        File file = new File(str);
        String name = file.getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getParent());
        String str2 = File.separator;
        File file2 = new File(C6738e.m38291a(sb2, str2, "split"));
        m38357a(file2);
        boolean zM38359c = false;
        if (!file2.mkdir()) {
            C1016d.m6183c("UploadFile", "make split dir failed");
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                zM38359c = m38359c(linkedList, file2.getCanonicalPath() + str2 + name, fileInputStream);
                fileInputStream.close();
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6186f("UploadFile", "IOException:....fileinputstream.");
        }
        m38357a(file2);
        return zM38359c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:66|7|8|(12:68|10|11|(6:14|64|15|(2:17|82)(1:81)|20|12)|80|21|(2:23|(2:25|26))(1:26)|51|(2:54|52)|79|55|(1:57)(2:78|83))(4:29|70|30|(1:32))|35|74|36|51|(1:52)|79|55|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
    
        r0 = "IOException";
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
    
        as.C1016d.m6183c("UploadFile", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b6, code lost:
    
        r0 = "FileNotFoundException";
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d4 A[LOOP:1: B:52:0x00ce->B:54:0x00d4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f2 A[LOOP:0: B:3:0x0006->B:57:0x00f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8 A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m38359c(java.util.LinkedList r19, java.lang.String r20, java.io.FileInputStream r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.C6754b.m38359c(java.util.LinkedList, java.lang.String, java.io.FileInputStream):boolean");
    }
}
