package com.huawei.hianalytics;

import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import gu.C10048b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* renamed from: com.huawei.hianalytics.o0 */
/* loaded from: classes5.dex */
public class C4797o0 {

    /* renamed from: a */
    public String f21885a;

    public C4797o0() {
        try {
            this.f21885a = EnvUtils.getAppContext().getFilesDir().getCanonicalPath() + File.separator;
        } catch (IOException unused) {
            HiLog.m28808e("ComponentManager", "get fileRootDirectory error");
        }
    }

    /* renamed from: b */
    public static boolean m28974b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    HiLog.m28809i("ComponentManager", "delete file failed: " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                m28974b(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    public final String m28975a(String str) {
        return this.f21885a + "/hianalytics_/component/".replace("component", str);
    }

    /* renamed from: a */
    public final void m28976a(String str, String str2) throws Throwable {
        File file = new File(m28975a(str));
        File file2 = new File(m28975a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            HiLog.m28809i("ComponentManager", "file directory is mkdirs");
        }
        if (m28977a(file2)) {
            C4778g1.m28888a(file2, str2);
        } else {
            HiLog.m28812w("ComponentManager", "file is not found, file is create failed");
        }
    }

    /* renamed from: b */
    public final String m28978b(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th2;
        byte[] bArr;
        File file = new File(m28975a(str), "hianalytics_" + str);
        if (!m28977a(file)) {
            String strM62473e = C10048b.m62473e(128);
            C4778g1.m28888a(file, strM62473e);
            return strM62473e;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
        } catch (Throwable th3) {
            th = th3;
            C4778g1.m28887a(fileInputStream2);
            throw th;
        }
        try {
            byte[] bArr2 = new byte[1024];
            byte[] bArr3 = new byte[1024];
            int i10 = 0;
            while (true) {
                int i11 = fileInputStream.read(bArr3);
                if (i11 == -1) {
                    break;
                }
                if (i11 > 0) {
                    if (bArr2.length - i10 >= i11) {
                        System.arraycopy(bArr3, 0, bArr2, i10, i11);
                    } else {
                        byte[] bArr4 = new byte[(bArr2.length + i11) << 1];
                        System.arraycopy(bArr2, 0, bArr4, 0, i10);
                        System.arraycopy(bArr3, 0, bArr4, i10, i11);
                        bArr2 = bArr4;
                    }
                    i10 += i11;
                }
            }
            if (i10 == 0) {
                C4778g1.m28887a(fileInputStream);
                return "";
            }
            if (i10 <= 0) {
                bArr = new byte[0];
            } else {
                byte[] bArr5 = new byte[i10];
                System.arraycopy(bArr2, 0, bArr5, 0, i10);
                bArr = bArr5;
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            C4778g1.m28887a(fileInputStream);
            return str2;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            try {
                HiLog.m28808e("HASU", "read file error");
                C4778g1.m28887a(fileInputStream2);
                return "";
            } catch (Throwable th4) {
                fileInputStream = fileInputStream2;
                th2 = th4;
                FileInputStream fileInputStream3 = fileInputStream;
                th = th2;
                fileInputStream2 = fileInputStream3;
                C4778g1.m28887a(fileInputStream2);
                throw th;
            }
        } catch (Throwable th5) {
            th2 = th5;
            FileInputStream fileInputStream32 = fileInputStream;
            th = th2;
            fileInputStream2 = fileInputStream32;
            C4778g1.m28887a(fileInputStream2);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m28973a() {
        File file;
        try {
            file = new File(EnvUtils.getAppContext().getFilesDir().getCanonicalPath() + File.separator + "/hianalytics_");
        } catch (IOException unused) {
            HiLog.m28808e("ComponentManager", "delete component file error");
            file = null;
        }
        return m28974b(file);
    }

    /* renamed from: a */
    public final boolean m28977a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            HiLog.m28808e("ComponentManager", "create new file error");
            return false;
        }
    }
}
