package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.z */
/* loaded from: classes2.dex */
public class C7847z {

    /* renamed from: b */
    private long f36216b;

    /* renamed from: a */
    private int f36215a = 0;

    /* renamed from: c */
    private Comparator<File> f36217c = new Comparator<File>() { // from class: com.huawei.openalliance.ad.utils.z.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            if (file.lastModified() < file2.lastModified()) {
                return -1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : 1;
        }
    };

    /* renamed from: a */
    private void m48622a(File file) {
        m48623a(file, null);
    }

    /* renamed from: a */
    public void m48624a(File file, long j10, List<File> list) {
        if (file == null || !file.exists() || !file.isDirectory() || j10 <= 0) {
            return;
        }
        this.f36216b = j10;
        AbstractC7185ho.m43821b("DirCleaner", "cleanDir total: sizeToClean: %s", Long.valueOf(j10));
        m48623a(file, list);
    }

    /* renamed from: a */
    private void m48623a(File file, List<File> list) {
        int i10 = this.f36215a + 1;
        this.f36215a = i10;
        if (i10 > 10) {
            AbstractC7185ho.m43820b("DirCleaner", "exceeds max depth");
            return;
        }
        if (file.isDirectory()) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("DirCleaner", "clean dir: %s", AbstractC7819dl.m48375a(AbstractC7731ae.m47469h(file)));
            }
            File[] fileArrListFiles = file.listFiles();
            if (AbstractC7760bg.m47769a(fileArrListFiles)) {
                return;
            }
            List<File> listAsList = Arrays.asList(fileArrListFiles);
            Collections.sort(listAsList, this.f36217c);
            for (File file2 : listAsList) {
                if (file2.isDirectory()) {
                    m48622a(file2);
                } else {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("DirCleaner", "clean file: %s", AbstractC7819dl.m48375a(AbstractC7731ae.m47469h(file)));
                    }
                    if (AbstractC7760bg.m47767a(list) || !list.contains(file2)) {
                        this.f36216b -= file2.length();
                        AbstractC7731ae.m47449a(file2);
                        if (this.f36216b <= 0) {
                            return;
                        }
                    } else {
                        AbstractC7185ho.m43820b("DirCleaner", "white list file, skip clean");
                    }
                }
            }
        }
    }
}
