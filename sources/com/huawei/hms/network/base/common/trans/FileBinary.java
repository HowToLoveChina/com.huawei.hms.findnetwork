package com.huawei.hms.network.base.common.trans;

import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public class FileBinary implements Binary {
    public static final String HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM = "application/octet-stream";

    /* renamed from: b */
    private static final String f26228b = "FileBinary";

    /* renamed from: a */
    private File f26229a;

    public FileBinary(File file) {
        this(file, file == null ? "" : file.getName());
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.f26229a);
    }

    @Override // com.huawei.hms.network.base.common.trans.Binary
    public long getLength() {
        return this.f26229a.length();
    }

    @Override // com.huawei.hms.network.base.common.trans.Binary
    public void onWriteBinary(OutputStream outputStream) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                inputStream = getInputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        return;
                    } else {
                        outputStream.write(bArr, 0, i10);
                    }
                }
            } catch (IOException e10) {
                Logger.m32145w(f26228b, "the file is reading but has error!");
                throw e10;
            }
        } finally {
            IoUtils.closeSecure(inputStream);
        }
    }

    public FileBinary(File file, String str) {
        if (file != null) {
            this.f26229a = file;
            return;
        }
        throw new IllegalArgumentException("File is null: " + str);
    }
}
