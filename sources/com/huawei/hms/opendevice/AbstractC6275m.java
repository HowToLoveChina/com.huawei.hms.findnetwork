package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* renamed from: com.huawei.hms.opendevice.m */
/* loaded from: classes8.dex */
public abstract class AbstractC6275m {
    /* renamed from: a */
    public static void m36468a(File file) throws IOException {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() == null) {
            HMSLog.m36986e("StreamUtil", "parent file is null.");
            throw new IOException("parent file is null");
        }
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            HMSLog.m36986e("StreamUtil", "make parent dirs failed.");
            throw new IOException("make parent dirs failed");
        }
        if (file.createNewFile()) {
            return;
        }
        HMSLog.m36986e("StreamUtil", "create file failed.");
        throw new IOException("create file failed");
    }

    /* renamed from: a */
    public static String m36467a(String str) throws Throwable {
        InputStreamReader inputStreamReader;
        File file = new File(str);
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(file), Constants.UTF_8);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb2.append(line);
                        } catch (FileNotFoundException unused) {
                            bufferedReader = bufferedReader2;
                            HMSLog.m36986e("StreamUtil", "file not exist.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb2.toString();
                        } catch (IOException unused2) {
                            bufferedReader = bufferedReader2;
                            HMSLog.m36986e("StreamUtil", "read value IOException.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb2.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            throw th;
                        }
                    }
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                } catch (FileNotFoundException unused3) {
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
                inputStreamReader = null;
            } catch (IOException unused6) {
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
            return sb2.toString();
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
