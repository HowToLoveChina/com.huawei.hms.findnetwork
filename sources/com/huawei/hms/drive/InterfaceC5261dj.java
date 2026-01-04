package com.huawei.hms.drive;

import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.hms.drive.dj */
/* loaded from: classes8.dex */
public interface InterfaceC5261dj {

    /* renamed from: a */
    public static final InterfaceC5261dj f24450a = new InterfaceC5261dj() { // from class: com.huawei.hms.drive.dj.1
        @Override // com.huawei.hms.drive.InterfaceC5261dj
        /* renamed from: a */
        public void mo31640a(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // com.huawei.hms.drive.InterfaceC5261dj
        /* renamed from: b */
        public boolean mo31642b(File file) {
            return file.exists();
        }

        @Override // com.huawei.hms.drive.InterfaceC5261dj
        /* renamed from: c */
        public long mo31643c(File file) {
            return file.length();
        }

        @Override // com.huawei.hms.drive.InterfaceC5261dj
        /* renamed from: a */
        public void mo31641a(File file, File file2) throws IOException {
            mo31640a(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    /* renamed from: a */
    void mo31640a(File file) throws IOException;

    /* renamed from: a */
    void mo31641a(File file, File file2) throws IOException;

    /* renamed from: b */
    boolean mo31642b(File file);

    /* renamed from: c */
    long mo31643c(File file);
}
