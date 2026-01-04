package com.huawei.hms.network.file.core.util;

import com.huawei.hms.framework.common.CreateFileUtil;
import com.huawei.hms.framework.common.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/* renamed from: com.huawei.hms.network.file.core.util.c */
/* loaded from: classes8.dex */
public class C6253c {
    /* renamed from: a */
    public static File m36361a(String str) {
        if (str == null) {
            return null;
        }
        try {
            File fileNewFile = CreateFileUtil.newFile(str);
            return !fileNewFile.exists() ? new File(str) : fileNewFile;
        } catch (RuntimeException unused) {
            FLogger.m36355w("FileUtil", "newFile is runtimeException", new Object[0]);
            return new File(str);
        } catch (Throwable unused2) {
            FLogger.m36355w("FileUtil", "newFile is Throwable", new Object[0]);
            return new File(str);
        }
    }

    /* renamed from: b */
    public static FileInputStream m36363b(String str) {
        try {
            return CreateFileUtil.newFileInputStream(str);
        } catch (FileNotFoundException unused) {
            FLogger.m36355w("FileUtil", "newFileInputStream is fileNotFoundException", new Object[0]);
            return new FileInputStream(str);
        } catch (RuntimeException unused2) {
            FLogger.m36355w("FileUtil", "newFileInputStream is runtimeException", new Object[0]);
            return new FileInputStream(str);
        } catch (Throwable unused3) {
            FLogger.m36355w("FileUtil", "newFileInputStream is Throwable", new Object[0]);
            return new FileInputStream(str);
        }
    }

    /* renamed from: a */
    public static RandomAccessFile m36362a(String str, String str2) throws FileNotFoundException {
        if (str == null) {
            Logger.m32145w("FileUtil", "newRandomAccessFile  file is null");
            throw new FileNotFoundException("file is null");
        }
        try {
            return CreateFileUtil.newRandomAccessFile(str, str2);
        } catch (FileNotFoundException unused) {
            FLogger.m36355w("FileUtil", "newRandomAccessFile is fileNotFoundException", new Object[0]);
            return new RandomAccessFile(str, str2);
        } catch (RuntimeException unused2) {
            FLogger.m36355w("FileUtil", "newRandomAccessFile is runtimeException", new Object[0]);
            return new RandomAccessFile(str, str2);
        } catch (Throwable unused3) {
            FLogger.m36355w("FileUtil", "newRandomAccessFile is Throwable", new Object[0]);
            return new RandomAccessFile(str, str2);
        }
    }
}
