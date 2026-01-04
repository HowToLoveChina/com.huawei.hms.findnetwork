package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.huawei.openalliance.ad.il */
/* loaded from: classes8.dex */
public class C7218il implements InterfaceC7207ia {

    /* renamed from: a */
    private final C7205hz f33211a;

    /* renamed from: b */
    private final InterfaceC7025dn f33212b;

    public C7218il(C7205hz c7205hz, InterfaceC7025dn interfaceC7025dn) {
        this.f33211a = c7205hz;
        this.f33212b = interfaceC7025dn;
    }

    /* renamed from: a */
    private ContentResource m43942a(String str, String str2, String str3) {
        ContentResource contentResource = new ContentResource();
        contentResource.m41622a(3);
        contentResource.m41630c(str2);
        contentResource.m41627b(str3);
        contentResource.m41624a(str);
        contentResource.m41629c(1);
        contentResource.m41632d(2);
        return contentResource;
    }

    /* renamed from: c */
    private String m43944c(String str) {
        return "cache_" + AbstractC7801cu.m48126a(str);
    }

    /* renamed from: b */
    public long m43948b() {
        File fileM43893a = this.f33211a.m43893a();
        long length = 0;
        if (fileM43893a == null) {
            return 0L;
        }
        File[] fileArrListFiles = fileM43893a.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    length += file.length();
                }
            }
        }
        return length;
    }

    /* renamed from: b */
    private String m43943b(String str, String str2) {
        return "temp_" + str2 + AbstractC7801cu.m48126a(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7207ia
    /* renamed from: a */
    public C7317ir mo43900a(String str, String str2) {
        File file = new File(this.f33211a.m43893a(), m43943b(str, str2));
        try {
            if (file.exists()) {
                AbstractC7185ho.m43820b("DiskManager", "temporary resource file is exists");
                return new C7317ir(file.getName(), new FileOutputStream(file, true), file.length());
            }
            if (file.createNewFile()) {
                AbstractC7185ho.m43820b("DiskManager", "Successfully created temporary resource file");
                return new C7317ir(file.getName(), new FileOutputStream(file), 0L);
            }
            AbstractC7185ho.m43826d("DiskManager", "Failed created new temporary resource file");
            return null;
        } catch (IOException unused) {
            AbstractC7185ho.m43826d("DiskManager", "Failed created temporary resource file");
            return null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7207ia
    /* renamed from: a */
    public File mo43901a(String str, C7317ir c7317ir) {
        return m43945a(str, c7317ir, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7207ia
    /* renamed from: b */
    public void mo43905b(String str) {
        File file = new File(this.f33211a.m43893a(), m43944c(str));
        if (file.exists()) {
            if (file.delete()) {
                this.f33212b.mo41948a(file.getName(), false, null);
            } else {
                AbstractC7185ho.m43826d("DiskManager", "delete damaged cache file failed.");
            }
            AbstractC7185ho.m43820b("DiskManager", "successful delete damaged cache file");
        }
    }

    /* renamed from: a */
    public File m43945a(String str, C7317ir c7317ir, String str2, String str3) throws IOException {
        AbstractC7185ho.m43820b("DiskManager", "try to save cache file");
        try {
            c7317ir.m45094b().close();
        } catch (IOException unused) {
            AbstractC7185ho.m43826d("DiskManager", "Failed to close the tempResource");
        }
        File file = new File(this.f33211a.m43893a(), c7317ir.m45093a());
        String strM43944c = m43944c(str);
        File file2 = new File(this.f33211a.m43893a(), strM43944c);
        if (file2.exists()) {
            AbstractC7185ho.m43821b("DiskManager", "Old cache file %s exists.", file2.getName());
            AbstractC7185ho.m43818a("DiskManager", "del temp file result: %s", Boolean.valueOf(file.delete()));
            return file2;
        }
        if (file.renameTo(file2)) {
            AbstractC7185ho.m43818a("DiskManager", "Cache file %s completed", file2.getName());
            this.f33212b.mo41947a(strM43944c, m43942a(strM43944c, str2, str3));
        } else {
            AbstractC7185ho.m43824c("DiskManager", "Failed to save the cached file %s", file2.getName());
        }
        return file2;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7207ia
    /* renamed from: a */
    public String mo43902a(String str) {
        AbstractC7185ho.m43817a("DiskManager", "try to get cache file for " + AbstractC7819dl.m48375a(str));
        File file = new File(this.f33211a.m43893a(), m43944c(str));
        if (!file.exists()) {
            AbstractC7185ho.m43818a("DiskManager", "The requested cache file for url %s does not exist", AbstractC7819dl.m48375a(str));
            return "";
        }
        m43947a(file);
        return "file://" + AbstractC7731ae.m47469h(file);
    }

    /* renamed from: a */
    public void m43946a() {
        if (this.f33211a.m43897d() + 86400000 < AbstractC7741ao.m47566c()) {
            AbstractC7185ho.m43820b("DiskManager", "clear old native cache.");
            this.f33211a.m43894a(AbstractC7741ao.m47566c());
            AbstractC7731ae.m47445a(this.f33211a.m43895b(), 604800000L);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7207ia
    /* renamed from: a */
    public void mo43903a(long j10, C7317ir c7317ir) {
        long jM43948b = m43948b();
        long jM43896c = this.f33211a.m43896c();
        if (jM43948b >= jM43896c) {
            AbstractC7185ho.m43821b("DiskManager", "clear native cache, used: %s, max: %s", Long.valueOf(jM43948b), Long.valueOf(jM43896c));
            File file = new File(this.f33211a.m43893a(), c7317ir.m45093a());
            ArrayList arrayList = new ArrayList();
            arrayList.add(file);
            AbstractC7731ae.m47443a(this.f33211a.m43893a(), j10 * 3, arrayList);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7207ia
    /* renamed from: a */
    public void mo43904a(C7317ir c7317ir) {
        File file = (this.f33211a == null || c7317ir == null) ? null : new File(this.f33211a.m43893a(), c7317ir.m45093a());
        if (file == null || !file.exists()) {
            return;
        }
        if (file.delete()) {
            AbstractC7185ho.m43820b("DiskManager", "Successfully deleted file that failed to cache");
        } else {
            AbstractC7185ho.m43826d("DiskManager", "Failed to delete temporary file");
        }
    }

    /* renamed from: a */
    public void m43947a(File file) {
        C7212if.m43926a(file);
        this.f33212b.mo41946a(file.getName(), System.currentTimeMillis());
    }
}
