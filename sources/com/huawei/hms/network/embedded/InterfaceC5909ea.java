package com.huawei.hms.network.embedded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.ea */
/* loaded from: classes8.dex */
public interface InterfaceC5909ea {

    /* renamed from: a */
    public static final InterfaceC5909ea f26708a = new a();

    /* renamed from: com.huawei.hms.network.embedded.ea$a */
    public class a implements InterfaceC5909ea {
        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: a */
        public void mo34137a(File file, File file2) throws IOException {
            mo34139b(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: b */
        public void mo34139b(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: c */
        public InterfaceC6183zb mo34140c(File file) throws FileNotFoundException {
            return C6040ob.m34948c(file);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: d */
        public long mo34141d(File file) {
            return file.length();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: e */
        public InterfaceC6170yb mo34142e(File file) throws FileNotFoundException {
            try {
                return C6040ob.m34944b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C6040ob.m34944b(file);
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: f */
        public void mo34143f(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    mo34143f(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: g */
        public InterfaceC6170yb mo34144g(File file) throws FileNotFoundException {
            try {
                return C6040ob.m34936a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C6040ob.m34936a(file);
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5909ea
        /* renamed from: a */
        public boolean mo34138a(File file) {
            return file.exists();
        }
    }

    /* renamed from: a */
    void mo34137a(File file, File file2) throws IOException;

    /* renamed from: a */
    boolean mo34138a(File file);

    /* renamed from: b */
    void mo34139b(File file) throws IOException;

    /* renamed from: c */
    InterfaceC6183zb mo34140c(File file) throws FileNotFoundException;

    /* renamed from: d */
    long mo34141d(File file);

    /* renamed from: e */
    InterfaceC6170yb mo34142e(File file) throws FileNotFoundException;

    /* renamed from: f */
    void mo34143f(File file) throws IOException;

    /* renamed from: g */
    InterfaceC6170yb mo34144g(File file) throws FileNotFoundException;
}
