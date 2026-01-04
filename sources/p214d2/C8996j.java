package p214d2;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p003a2.InterfaceC0007b;
import p759x1.C13684i;
import p759x1.InterfaceC13679d;

/* renamed from: d2.j */
/* loaded from: classes.dex */
public class C8996j implements InterfaceC13679d<InputStream> {

    /* renamed from: a */
    public final InterfaceC0007b f45614a;

    public C8996j(InterfaceC0007b interfaceC0007b) {
        this.f45614a = interfaceC0007b;
    }

    @Override // p759x1.InterfaceC13679d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean mo56815b(InputStream inputStream, File file, C13684i c13684i) throws Throwable {
        byte[] bArr = (byte[]) this.f45614a.mo10c(65536, byte[].class);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i10 = inputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i10);
                    } catch (IOException e10) {
                        e = e10;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.f45614a.put(bArr);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        this.f45614a.put(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                this.f45614a.put(bArr);
                return true;
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
