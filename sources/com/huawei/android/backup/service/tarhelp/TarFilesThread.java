package com.huawei.android.backup.service.tarhelp;

import android.content.Context;
import android.os.Process;
import com.huawei.android.backup.filelogic.utils.C2111d;
import gy.C10067f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import p328h6.AbstractC10110j;
import p328h6.C10103c;
import p328h6.C10107g;
import p328h6.C10108h;
import p328h6.C10109i;
import p699v4.C13334c;
import p699v4.C13339h;
import p699v4.C13345n;

/* loaded from: classes.dex */
public class TarFilesThread extends Thread {

    /* renamed from: a */
    public volatile int f9704a = -1;

    /* renamed from: b */
    public volatile boolean f9705b = true;

    /* renamed from: c */
    public Context f9706c;

    public TarFilesThread(Context context) {
        this.f9706c = context;
    }

    /* renamed from: a */
    public final void m13108a(Context context, C10108h c10108h) throws Throwable {
        if (c10108h.m62945b().isEmpty()) {
            return;
        }
        String strM62944a = c10108h.m62944a();
        int size = c10108h.m62945b().size();
        String strM62953C = AbstractC10110j.m62953C(c10108h);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C10103c.m62919e());
        String str = File.separator;
        sb2.append(str);
        sb2.append(strM62944a);
        sb2.append(str);
        sb2.append("packaged");
        String str2 = sb2.toString() + str + strM62953C;
        File file = new File(str2);
        AbstractC10110j.m62976r(file);
        int iM13111e = m13111e(c10108h, file);
        if (!C10103c.m62920g(context).m62923b(strM62944a, new C10107g(str2, size, file.length(), null))) {
            C2111d.m12648d("TarFilesThread", "fail add tar , path is " + str2);
        } else if (c10108h.m62946c() == C10103c.m62920g(context).m62924d(strM62944a)) {
            C2111d.m12653i("TarFilesThread", "taskId is " + c10108h.m62946c() + " ," + strM62944a + " tar is finish!!!");
            AbstractC10110j.m62957G(context, strM62944a);
        }
        if (iM13111e != 0 || file.delete()) {
            return;
        }
        C2111d.m12648d("TarFilesThread", "desFile delete fail");
    }

    /* renamed from: c */
    public final boolean m13109c() throws InterruptedException {
        boolean z10 = true;
        try {
            String str = C10103c.m62918c()[0];
            if (C13334c.m79968a(str, 314572800L)) {
                return true;
            }
            C2111d.m12653i("TarFilesThread", "space is not enough ,requestSize is 314572800 ,freeSize is " + C13345n.m80064c(str) + " ,will sleep 1000ms");
            try {
                Thread.sleep(1000L);
                return false;
            } catch (InterruptedException unused) {
                z10 = false;
                C2111d.m12648d("TarFilesThread", "sleep interrupt");
                return z10;
            } catch (Exception unused2) {
                z10 = false;
                C2111d.m12648d("TarFilesThread", "Exception happen ");
                return z10;
            }
        } catch (InterruptedException unused3) {
        } catch (Exception unused4) {
        }
    }

    /* renamed from: d */
    public final void m13110d(C10067f c10067f) throws IOException {
        if (c10067f != null) {
            try {
                c10067f.flush();
            } catch (IOException unused) {
                C2111d.m12648d("TarFilesThread", "TarArchiveOutputStream flush fail");
            }
        }
        C13339h.m80014a(c10067f);
    }

    /* renamed from: e */
    public final int m13111e(C10108h c10108h, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        C10067f c10067f = null;
        int i10 = 0;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    C10067f c10067f2 = new C10067f(fileOutputStream);
                    try {
                        c10067f2.m62642F(3);
                        Iterator<String> it = c10108h.m62945b().iterator();
                        while (it.hasNext()) {
                            File file2 = new File(it.next());
                            if (AbstractC10110j.m62960b(file2, c10067f2, file2.getParent() + File.separator)) {
                                i10++;
                            }
                        }
                        m13110d(c10067f2);
                    } catch (FileNotFoundException unused) {
                        c10067f = c10067f2;
                        C2111d.m12648d("TarFilesThread", "archiveFiles File not existed ");
                        m13110d(c10067f);
                        C13339h.m80014a(fileOutputStream);
                        return i10;
                    } catch (IOException unused2) {
                        c10067f = c10067f2;
                        C2111d.m12648d("TarFilesThread", "archiveFiles IOException");
                        m13110d(c10067f);
                        C13339h.m80014a(fileOutputStream);
                        return i10;
                    } catch (Throwable th2) {
                        th = th2;
                        c10067f = c10067f2;
                        m13110d(c10067f);
                        C13339h.m80014a(fileOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException unused3) {
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
                fileOutputStream = null;
            } catch (IOException unused6) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            C13339h.m80014a(fileOutputStream);
            return i10;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: f */
    public int m13112f() {
        return this.f9704a;
    }

    /* renamed from: g */
    public boolean m13113g() {
        return this.f9705b;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        C10108h c10108hM62950a;
        this.f9704a = Process.myTid();
        while (this.f9705b) {
            if (m13109c() && (c10108hM62950a = C10109i.m62949b().m62950a()) != null) {
                if (C10103c.m62920g(this.f9706c).m62925f(c10108hM62950a.m62944a())) {
                    C2111d.m12654j("TarFilesThread", "[DftpState] abandon upload jam module, module is ", c10108hM62950a.m62944a());
                } else {
                    m13108a(this.f9706c, c10108hM62950a);
                }
            }
        }
    }
}
