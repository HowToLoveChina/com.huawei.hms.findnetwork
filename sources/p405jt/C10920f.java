package p405jt;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import p434kt.AbstractC11149c;

/* renamed from: jt.f */
/* loaded from: classes2.dex */
public final class C10920f extends AbstractC10918d {

    /* renamed from: b */
    public File f51805b;

    /* renamed from: c */
    public static InterfaceC10925k m65999c() {
        return new C10924j(new C10920f());
    }

    /* renamed from: d */
    public static void m66000d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.w("FileLogNode", "Exception when closing the closeable.");
            }
        }
    }

    @Override // p405jt.InterfaceC10925k
    /* renamed from: a */
    public InterfaceC10925k mo66001a(String str, String str2) {
        String str3;
        if (str2 == null || str2.isEmpty()) {
            Log.e("FileLogNode", "Failed to initialize the file logger, parameter error.");
            return this;
        }
        if (this.f51805b == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    File canonicalFile = new File(str, "Log").getCanonicalFile();
                    if (!canonicalFile.isDirectory()) {
                        if (AbstractC11149c.m67063d(canonicalFile)) {
                        }
                    }
                    File file = new File(canonicalFile, str2 + ".log");
                    this.f51805b = file;
                    file.setReadable(true);
                    this.f51805b.setWritable(true);
                    this.f51805b.setExecutable(false, false);
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

    /* renamed from: e */
    public final boolean m66003e(String str) {
        String str2;
        if (this.f51805b.length() + str.length() <= 4194304) {
            return true;
        }
        File file = new File(this.f51805b.getPath() + ".bak");
        if (file.exists() && !file.delete()) {
            str2 = "Cannot rename log file to bak.";
        } else {
            if (this.f51805b.renameTo(file)) {
                return true;
            }
            str2 = "Failed to backup the log file.";
        }
        Log.w("FileLogNode", str2);
        return false;
    }

    /* renamed from: f */
    public final void m66004f(String str) throws Throwable {
        if (str == null || this.f51805b == null) {
            return;
        }
        String str2 = str + '\n';
        if (m66003e(str2)) {
            m66005g(str2);
        }
    }

    /* renamed from: g */
    public final void m66005g(String str) throws Throwable {
        Throwable th2;
        OutputStream bufferedOutputStream;
        OutputStreamWriter outputStreamWriter;
        OutputStream fileOutputStream;
        OutputStream outputStream = null;
        try {
            fileOutputStream = new FileOutputStream(this.f51805b, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, Constants.UTF_8);
                } catch (FileNotFoundException unused) {
                    outputStreamWriter = null;
                } catch (IOException unused2) {
                    outputStreamWriter = null;
                } catch (Throwable th3) {
                    th2 = th3;
                    outputStreamWriter = null;
                }
            } catch (FileNotFoundException unused3) {
                bufferedOutputStream = null;
                outputStreamWriter = null;
            } catch (IOException unused4) {
                bufferedOutputStream = null;
                outputStreamWriter = null;
            } catch (Throwable th4) {
                th2 = th4;
                outputStreamWriter = null;
                m66000d(outputStreamWriter);
                m66000d(outputStream);
                m66000d(fileOutputStream);
                throw th2;
            }
        } catch (FileNotFoundException unused5) {
            bufferedOutputStream = null;
            outputStreamWriter = null;
        } catch (IOException unused6) {
            bufferedOutputStream = null;
            outputStreamWriter = null;
        } catch (Throwable th5) {
            th2 = th5;
            bufferedOutputStream = null;
            outputStreamWriter = null;
            fileOutputStream = outputStream;
            outputStream = bufferedOutputStream;
            m66000d(outputStreamWriter);
            m66000d(outputStream);
            m66000d(fileOutputStream);
            throw th2;
        }
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
        } catch (FileNotFoundException unused7) {
            outputStream = fileOutputStream;
            try {
                Log.w("FileLogNode", "Exception when writing the log file.");
                fileOutputStream = outputStream;
                m66000d(outputStreamWriter);
                m66000d(bufferedOutputStream);
                m66000d(fileOutputStream);
            } catch (Throwable th6) {
                th2 = th6;
                fileOutputStream = outputStream;
                outputStream = bufferedOutputStream;
                m66000d(outputStreamWriter);
                m66000d(outputStream);
                m66000d(fileOutputStream);
                throw th2;
            }
        } catch (IOException unused8) {
            outputStream = fileOutputStream;
            Log.w("FileLogNode", "Exception when writing the log file.");
            fileOutputStream = outputStream;
            m66000d(outputStreamWriter);
            m66000d(bufferedOutputStream);
            m66000d(fileOutputStream);
        } catch (Throwable th7) {
            th2 = th7;
            outputStream = bufferedOutputStream;
            m66000d(outputStreamWriter);
            m66000d(outputStream);
            m66000d(fileOutputStream);
            throw th2;
        }
        m66000d(outputStreamWriter);
        m66000d(bufferedOutputStream);
        m66000d(fileOutputStream);
    }

    @Override // p405jt.InterfaceC10925k
    /* renamed from: a */
    public void mo66002a(C10927m c10927m, int i10, String str) throws Throwable {
        if (c10927m == null) {
            return;
        }
        m66004f(c10927m.m66032f() + c10927m.m66027a());
        InterfaceC10925k interfaceC10925k = this.f51802a;
        if (interfaceC10925k != null) {
            interfaceC10925k.mo66002a(c10927m, i10, str);
        }
    }
}
