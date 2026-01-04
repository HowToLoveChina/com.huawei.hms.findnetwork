package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* renamed from: com.huawei.openalliance.ad.hn */
/* loaded from: classes8.dex */
public final class C7184hn extends AbstractC7183hm {

    /* renamed from: b */
    private File f33087b;

    private C7184hn() {
    }

    /* renamed from: a */
    public static InterfaceC7199ht m43804a() {
        return new C7188hr(new C7184hn());
    }

    /* renamed from: b */
    private boolean m43807b(String str) {
        String str2;
        if (this.f33087b.length() + str.length() <= 4194304) {
            return true;
        }
        File file = new File(this.f33087b.getPath() + ".bak");
        if (file.exists() && !file.delete()) {
            str2 = "Cannot rename log file to bak.";
        } else {
            if (this.f33087b.renameTo(file)) {
                return true;
            }
            str2 = "Failed to backup the log file.";
        }
        Log.w("FileLogNode", str2);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.huawei.openalliance.ad.hn] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* renamed from: c */
    private void m43808c(String str) throws Throwable {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.f33087b, true);
                try {
                    this = new BufferedOutputStream(fileOutputStream);
                    try {
                        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter((OutputStream) this, Constants.UTF_8);
                        try {
                            outputStreamWriter2.write(str);
                            outputStreamWriter2.flush();
                            m43805a(outputStreamWriter2);
                            this = this;
                        } catch (FileNotFoundException unused) {
                            outputStreamWriter = outputStreamWriter2;
                            Log.w("FileLogNode", "Exception when writing the log file.");
                            m43805a(outputStreamWriter);
                            this = this;
                            m43805a((Closeable) this);
                            m43805a(fileOutputStream);
                        } catch (IOException unused2) {
                            outputStreamWriter = outputStreamWriter2;
                            Log.w("FileLogNode", "Exception when writing the log file.");
                            m43805a(outputStreamWriter);
                            this = this;
                            m43805a((Closeable) this);
                            m43805a(fileOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            outputStreamWriter = outputStreamWriter2;
                            m43805a(outputStreamWriter);
                            m43805a((Closeable) this);
                            m43805a(fileOutputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException | IOException unused3) {
                    }
                } catch (FileNotFoundException unused4) {
                    this = 0;
                } catch (IOException unused5) {
                    this = 0;
                } catch (Throwable th3) {
                    th = th3;
                    this = 0;
                }
            } catch (FileNotFoundException unused6) {
                this = 0;
                fileOutputStream = null;
            } catch (IOException unused7) {
                this = 0;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                this = 0;
                fileOutputStream = null;
            }
            m43805a((Closeable) this);
            m43805a(fileOutputStream);
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7199ht
    /* renamed from: a */
    public InterfaceC7199ht mo43809a(String str, String str2) {
        String str3;
        if (str2 == null || str2.isEmpty()) {
            Log.e("FileLogNode", "Failed to initialize the file logger, parameter error.");
            return this;
        }
        if (this.f33087b == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    File canonicalFile = new File(str, "Log").getCanonicalFile();
                    if (!canonicalFile.isDirectory()) {
                        if (AbstractC7731ae.m47468g(canonicalFile)) {
                        }
                    }
                    File file = new File(canonicalFile, str2 + ".log");
                    this.f33087b = file;
                    file.setReadable(true);
                    this.f33087b.setWritable(true);
                    this.f33087b.setExecutable(false, false);
                    return this;
                }
            } catch (IOException unused) {
                str3 = "file path error. ioex";
                Log.e("FileLogNode", str3);
                Log.w("FileLogNode", "the file logger has been created already.");
                return this;
            } catch (Throwable th2) {
                str3 = "file path error. " + th2.getClass().getSimpleName();
                Log.e("FileLogNode", str3);
                Log.w("FileLogNode", "the file logger has been created already.");
                return this;
            }
        }
        Log.w("FileLogNode", "the file logger has been created already.");
        return this;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7199ht
    /* renamed from: a */
    public void mo43810a(C7201hv c7201hv, int i10, String str) throws Throwable {
        if (c7201hv == null) {
            return;
        }
        m43806a(c7201hv.m43881a() + c7201hv.m43882b());
        InterfaceC7199ht interfaceC7199ht = this.f33086a;
        if (interfaceC7199ht != null) {
            interfaceC7199ht.mo43810a(c7201hv, i10, str);
        }
    }

    /* renamed from: a */
    private static void m43805a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.w("FileLogNode", "Exception when closing the closeable.");
            }
        }
    }

    /* renamed from: a */
    private void m43806a(String str) throws Throwable {
        if (str == null || this.f33087b == null) {
            return;
        }
        String str2 = str + '\n';
        if (m43807b(str2)) {
            m43808c(str2);
        }
    }
}
