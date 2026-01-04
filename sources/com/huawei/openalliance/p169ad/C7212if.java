package com.huawei.openalliance.p169ad;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.huawei.openalliance.ad.if */
/* loaded from: classes8.dex */
class C7212if {
    /* renamed from: a */
    public static void m43926a(File file) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLastModified = file.lastModified();
        if (jLastModified == jCurrentTimeMillis) {
            jCurrentTimeMillis++;
        }
        if (file.setLastModified(jCurrentTimeMillis)) {
            return;
        }
        try {
            m43927b(file);
        } catch (IOException e10) {
            AbstractC7185ho.m43827d("DiskFiles", "Failed to manually update lastModifyTime to file %s with error %s", file.getName(), e10.getClass().getSimpleName());
        }
        if (jLastModified < jCurrentTimeMillis) {
            AbstractC7185ho.m43824c("DiskFiles", "Failed to manually update lastModifyTime to file %s", file.getName());
        }
    }

    /* renamed from: b */
    public static void m43927b(File file) throws IOException {
        long length = file.length();
        if (length < 1) {
            length = 0;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j10 = length - 1;
        randomAccessFile.seek(j10);
        byte b10 = randomAccessFile.readByte();
        randomAccessFile.seek(j10);
        randomAccessFile.write(b10);
        randomAccessFile.close();
    }
}
