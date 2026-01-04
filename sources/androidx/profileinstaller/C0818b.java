package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.C0819c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;
import p695v0.C13314b;
import p695v0.C13315c;
import p695v0.C13322j;
import p695v0.C13323k;

/* renamed from: androidx.profileinstaller.b */
/* loaded from: classes.dex */
public class C0818b {

    /* renamed from: a */
    public final AssetManager f4257a;

    /* renamed from: b */
    public final Executor f4258b;

    /* renamed from: c */
    public final C0819c.c f4259c;

    /* renamed from: e */
    public final File f4261e;

    /* renamed from: f */
    public final String f4262f;

    /* renamed from: g */
    public final String f4263g;

    /* renamed from: h */
    public final String f4264h;

    /* renamed from: j */
    public C13314b[] f4266j;

    /* renamed from: k */
    public byte[] f4267k;

    /* renamed from: i */
    public boolean f4265i = false;

    /* renamed from: d */
    public final byte[] f4260d = m5068d();

    public C0818b(AssetManager assetManager, Executor executor, C0819c.c cVar, String str, String str2, String str3, File file) {
        this.f4257a = assetManager;
        this.f4258b = executor;
        this.f4259c = cVar;
        this.f4262f = str;
        this.f4263g = str2;
        this.f4264h = str3;
        this.f4261e = file;
    }

    /* renamed from: d */
    public static byte[] m5068d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            return C13323k.f60092a;
        }
        if (i10 == 29 || i10 == 30) {
            return C13323k.f60093b;
        }
        return null;
    }

    /* renamed from: k */
    public static boolean m5069k() {
        return Build.VERSION.SDK_INT >= 31;
    }

    /* renamed from: b */
    public final C0818b m5070b(C13314b[] c13314bArr, byte[] bArr) throws IOException {
        InputStream inputStreamM5075h;
        try {
            inputStreamM5075h = m5075h(this.f4257a, this.f4264h);
        } catch (FileNotFoundException e10) {
            this.f4259c.mo5052b(9, e10);
        } catch (IOException e11) {
            this.f4259c.mo5052b(7, e11);
        } catch (IllegalStateException e12) {
            this.f4266j = null;
            this.f4259c.mo5052b(8, e12);
        }
        if (inputStreamM5075h == null) {
            if (inputStreamM5075h != null) {
                inputStreamM5075h.close();
            }
            return null;
        }
        try {
            this.f4266j = C13322j.m79867r(inputStreamM5075h, C13322j.m79865p(inputStreamM5075h, C13322j.f60091b), bArr, c13314bArr);
            inputStreamM5075h.close();
            return this;
        } catch (Throwable th2) {
            try {
                inputStreamM5075h.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: c */
    public final void m5071c() {
        if (!this.f4265i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    /* renamed from: e */
    public boolean m5072e() {
        if (this.f4260d == null) {
            m5078l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f4261e.exists()) {
            try {
                if (!this.f4261e.createNewFile()) {
                    m5078l(4, null);
                    return false;
                }
            } catch (IOException unused) {
                m5078l(4, null);
                return false;
            }
        } else if (!this.f4261e.canWrite()) {
            m5078l(4, null);
            return false;
        }
        this.f4265i = true;
        return true;
    }

    /* renamed from: f */
    public final InputStream m5073f(AssetManager assetManager) {
        try {
            return m5075h(assetManager, this.f4263g);
        } catch (FileNotFoundException e10) {
            this.f4259c.mo5052b(6, e10);
            return null;
        } catch (IOException e11) {
            this.f4259c.mo5052b(7, e11);
            return null;
        }
    }

    /* renamed from: g */
    public final /* synthetic */ void m5074g(int i10, Object obj) {
        this.f4259c.mo5052b(i10, obj);
    }

    /* renamed from: h */
    public final InputStream m5075h(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f4259c.mo5051a(5, null);
            }
            return null;
        }
    }

    /* renamed from: i */
    public C0818b m5076i() {
        C0818b c0818bM5070b;
        m5071c();
        if (this.f4260d == null) {
            return this;
        }
        InputStream inputStreamM5073f = m5073f(this.f4257a);
        if (inputStreamM5073f != null) {
            this.f4266j = m5077j(inputStreamM5073f);
        }
        C13314b[] c13314bArr = this.f4266j;
        return (c13314bArr == null || !m5069k() || (c0818bM5070b = m5070b(c13314bArr, this.f4260d)) == null) ? this : c0818bM5070b;
    }

    /* renamed from: j */
    public final C13314b[] m5077j(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    try {
                        C13314b[] c13314bArrM79873x = C13322j.m79873x(inputStream, C13322j.m79865p(inputStream, C13322j.f60090a), this.f4262f);
                        try {
                            inputStream.close();
                            return c13314bArrM79873x;
                        } catch (IOException e10) {
                            this.f4259c.mo5052b(7, e10);
                            return c13314bArrM79873x;
                        }
                    } catch (IOException e11) {
                        this.f4259c.mo5052b(7, e11);
                        inputStream.close();
                        return null;
                    }
                } catch (IllegalStateException e12) {
                    this.f4259c.mo5052b(8, e12);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e13) {
                this.f4259c.mo5052b(7, e13);
                return null;
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e14) {
                this.f4259c.mo5052b(7, e14);
            }
            throw th2;
        }
    }

    /* renamed from: l */
    public final void m5078l(final int i10, final Object obj) {
        this.f4258b.execute(new Runnable() { // from class: v0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f60064a.m5074g(i10, obj);
            }
        });
    }

    /* renamed from: m */
    public C0818b m5079m() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        C13314b[] c13314bArr = this.f4266j;
        byte[] bArr = this.f4260d;
        if (c13314bArr != null && bArr != null) {
            m5071c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e10) {
                this.f4259c.mo5052b(7, e10);
            } catch (IllegalStateException e11) {
                this.f4259c.mo5052b(8, e11);
            }
            try {
                C13322j.m79838F(byteArrayOutputStream, bArr);
                if (!C13322j.m79835C(byteArrayOutputStream, bArr, c13314bArr)) {
                    this.f4259c.mo5052b(5, null);
                    this.f4266j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f4267k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f4266j = null;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        return this;
    }

    /* renamed from: n */
    public boolean m5080n() {
        byte[] bArr = this.f4267k;
        if (bArr == null) {
            return false;
        }
        m5071c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f4261e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock fileLockTryLock = channel.tryLock();
                            try {
                                C13315c.m79824l(byteArrayInputStream, fileOutputStream, fileLockTryLock);
                                m5078l(1, null);
                                if (fileLockTryLock != null) {
                                    fileLockTryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (FileNotFoundException e10) {
                m5078l(6, e10);
                return false;
            } catch (IOException e11) {
                m5078l(7, e11);
                return false;
            }
        } finally {
            this.f4267k = null;
            this.f4266j = null;
        }
    }
}
