package com.huawei.hicloud.base.slice;

import java.io.File;

/* loaded from: classes6.dex */
public class FileLengthGetter implements LengthGetter<File> {
    @Override // com.huawei.hicloud.base.slice.LengthGetter
    public long getLength(int i10, File file) {
        return file.length();
    }
}
