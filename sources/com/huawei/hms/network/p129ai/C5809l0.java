package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.CreateFileUtil;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.huawei.hms.network.ai.l0 */
/* loaded from: classes8.dex */
public class C5809l0 {

    /* renamed from: a */
    public static final String f25963a = "AIModelZipUtils";

    /* renamed from: a */
    public static boolean m33423a(String str, String str2, String str3) throws IOException {
        Logger.m32143v(f25963a, "model download write file success,unzip start");
        FileInputStream fileInputStreamNewSafeFileInputStream = CreateFileUtil.newSafeFileInputStream(str);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStreamNewSafeFileInputStream);
        File fileNewSafeFile = CreateFileUtil.newSafeFile(str2);
        if (!fileNewSafeFile.exists()) {
            fileNewSafeFile.mkdir();
        }
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null || i10 >= 30) {
                break;
            }
            String name = nextEntry.getName();
            if (name.endsWith(".model")) {
                Logger.m32143v(f25963a, "unzip file model:" + name);
                FileOutputStream fileOutputStreamNewSafeFileOutputStream = CreateFileUtil.newSafeFileOutputStream(CreateFileUtil.newSafeFile(str2 + str3));
                byte[] bArr = new byte[2048];
                while (true) {
                    int i11 = zipInputStream.read(bArr);
                    if (i11 == -1) {
                        break;
                    }
                    fileOutputStreamNewSafeFileOutputStream.write(bArr, 0, i11);
                    fileOutputStreamNewSafeFileOutputStream.flush();
                }
                IoUtils.closeSecure((OutputStream) fileOutputStreamNewSafeFileOutputStream);
                z10 = true;
            }
            i10++;
        }
        IoUtils.closeSecure((InputStream) fileInputStreamNewSafeFileInputStream);
        IoUtils.closeSecure((InputStream) zipInputStream);
        CreateFileUtil.deleteSecure(str);
        Logger.m32143v(f25963a, "unzip file success:" + z10 + " entries:" + i10);
        return z10;
    }
}
