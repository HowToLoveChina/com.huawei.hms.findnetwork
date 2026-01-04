package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.dl */
/* loaded from: classes8.dex */
public class C7023dl {

    /* renamed from: a */
    private volatile long f32225a;

    /* renamed from: b */
    private volatile int f32226b;

    /* renamed from: c */
    private File f32227c;

    /* renamed from: d */
    private InterfaceC7025dn f32228d;

    /* renamed from: e */
    private C7022dk f32229e;

    /* renamed from: f */
    private volatile long f32230f = 345600000;

    /* renamed from: com.huawei.openalliance.ad.dl$a */
    public static class a implements Comparator<File> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    public C7023dl(File file, long j10, int i10) {
        this.f32227c = file;
        this.f32225a = j10;
        this.f32226b = i10;
        AbstractC7731ae.m47468g(file);
    }

    /* renamed from: a */
    private int m41977a(File[] fileArr) {
        int i10 = 0;
        for (File file : fileArr) {
            if (file.isFile()) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public int m42002h() {
        File[] fileArrListFiles = this.f32227c.listFiles();
        if (fileArrListFiles != null) {
            return m41977a(fileArrListFiles);
        }
        return 0;
    }

    /* renamed from: b */
    public long m42011b() {
        return this.f32225a;
    }

    /* renamed from: c */
    public int m42014c() {
        return this.f32226b;
    }

    /* renamed from: a */
    private long m41978a(File file, Set<String> set) {
        if (!AbstractC7760bg.m47767a(set) && set.contains(file.getName())) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("FileDiskCache", "file %s in blackList, don't delete", file.getName());
            }
            return 0L;
        }
        AbstractC7185ho.m43818a("FileDiskCache", "remove old exceeded file, modify time: %d file: %s", Long.valueOf(file.lastModified()), file.getName());
        long length = file.length();
        if (!AbstractC7731ae.m47449a(file)) {
            return 0L;
        }
        AbstractC7185ho.m43821b("FileDiskCache", "file %s deleted", file.getName());
        m41987a(file.getName(), true, (Integer) 0);
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public Set<String> m41997e() {
        InterfaceC7025dn interfaceC7025dn;
        List<String> listM41971e = this.f32229e.m41971e();
        return (AbstractC7760bg.m47767a(listM41971e) || (interfaceC7025dn = this.f32228d) == null) ? new HashSet() : interfaceC7025dn.mo41944a(listM41971e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m41999f() {
        AbstractC7185ho.m43820b("FileDiskCache", "clearAllExpiredFiles valid time: " + this.f32230f);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File[] fileArrListFiles = this.f32227c.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile() && file.lastModified() < jCurrentTimeMillis - this.f32230f) {
                    AbstractC7185ho.m43818a("FileDiskCache", "remove old expired file, modify time: %d file: %s", Long.valueOf(file.lastModified()), AbstractC7819dl.m48375a(AbstractC7731ae.m47469h(file)));
                    if (AbstractC7731ae.m47449a(file)) {
                        AbstractC7185ho.m43817a("FileDiskCache", "file delete success");
                        m41987a(file.getName(), true, (Integer) 1);
                    }
                }
                if (file.isDirectory() && ((Constants.NORMAL_CACHE.equals(this.f32229e.m41972f()) && file.getName().startsWith(MetaCreativeType.f32139AR)) || Constants.WEBVIEW_CACHE.equals(this.f32229e.m41972f()))) {
                    AbstractC7185ho.m43818a("FileDiskCache", "delete file: %s", AbstractC7819dl.m48375a(file.getName()));
                    AbstractC7731ae.m47455b(file);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public long m42001g() {
        File[] fileArrListFiles = this.f32227c.listFiles();
        long length = 0;
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
    public String m42012b(String str) {
        try {
            return new File(this.f32227c, str).getCanonicalPath();
        } catch (IOException e10) {
            AbstractC7185ho.m43823c("FileDiskCache", "getFilePath " + e10.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: d */
    public void m42016d() {
        AbstractC7731ae.m47455b(this.f32227c);
    }

    /* renamed from: d */
    private void m41995d(final String str) {
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.dl.2
            @Override // java.lang.Runnable
            public void run() {
                Set setM41997e = C7023dl.this.m41997e();
                if (!AbstractC7806cz.m48165b(str)) {
                    setM41997e.add(str);
                }
                C7023dl.this.m41999f();
                long jM42001g = C7023dl.this.m42001g();
                AbstractC7185ho.m43821b("FileDiskCache", "cacheType: %s current used size: %s maxSize: %s", C7023dl.this.f32229e.m41972f(), Long.valueOf(jM42001g), Long.valueOf(C7023dl.this.f32225a));
                if (jM42001g > C7023dl.this.f32225a) {
                    C7023dl.this.m41982a(jM42001g, (Set<String>) setM41997e);
                }
                int iM42002h = C7023dl.this.m42002h();
                AbstractC7185ho.m43821b("FileDiskCache", "cacheType: %s current used num: %s maxNum: %s", C7023dl.this.f32229e.m41972f(), Integer.valueOf(iM42002h), Integer.valueOf(C7023dl.this.f32226b));
                if (iM42002h > C7023dl.this.f32226b) {
                    C7023dl.this.m41981a(iM42002h, (Set<String>) setM41997e);
                }
            }
        }, AbstractC7834m.a.DISK_CACHE, false);
    }

    /* renamed from: a */
    public File m42003a() {
        return this.f32227c;
    }

    /* renamed from: b */
    public void m42013b(long j10) {
        this.f32230f = j10 * 60000;
    }

    /* renamed from: c */
    public void m42015c(final String str) {
        AbstractC7185ho.m43820b("FileDiskCache", "remove key " + str);
        AbstractC7731ae.m47466e(new File(this.f32227c, str));
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.dl.1
            @Override // java.lang.Runnable
            public void run() {
                C7023dl.this.m41987a(str, true, (Integer) 2);
            }
        }, AbstractC7834m.a.DISK_CACHE, false);
    }

    /* renamed from: b */
    private void m41990b(long j10, List<ContentResource> list, Set<String> set) {
        AbstractC7185ho.m43820b("FileDiskCache", "delete sorted content resource files");
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        for (ContentResource contentResource : list) {
            File file = new File(this.f32227c, contentResource.m41621a());
            C7022dk c7022dk = this.f32229e;
            boolean zM41963a = c7022dk == null ? false : c7022dk.m41963a(contentResource.m41621a());
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("FileDiskCache", "deleteFromSortedContentResources, isAccessed: %s", Boolean.valueOf(zM41963a));
            }
            if (!zM41963a && file.exists()) {
                j10 -= m41978a(file, set);
                AbstractC7185ho.m43818a("FileDiskCache", "current size: %d", Long.valueOf(j10));
                if (j10 <= this.f32225a) {
                    AbstractC7185ho.m43820b("FileDiskCache", "used cache space is lower than max size");
                    return;
                }
            } else if (zM41963a) {
                AbstractC7185ho.m43821b("FileDiskCache", "file %s is using, not delete", contentResource.m41621a());
            } else {
                AbstractC7185ho.m43821b("FileDiskCache", "file %s not exist, delete table entry", contentResource.m41621a());
                m41987a(contentResource.m41621a(), false, (Integer) null);
            }
        }
    }

    /* renamed from: a */
    public void m42004a(int i10) {
        AbstractC7185ho.m43818a("FileDiskCache", "set max num: %d", Integer.valueOf(i10));
        this.f32226b = i10;
    }

    /* renamed from: a */
    private void m41980a(int i10, List<ContentResource> list, Set<String> set) {
        AbstractC7185ho.m43820b("FileDiskCache", "delete sorted content resource files for num");
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        for (ContentResource contentResource : list) {
            File file = new File(this.f32227c, contentResource.m41621a());
            C7022dk c7022dk = this.f32229e;
            boolean zM41963a = c7022dk == null ? false : c7022dk.m41963a(contentResource.m41621a());
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("FileDiskCache", "deleteFromSortedContentResources, isAccessed: %s", Boolean.valueOf(zM41963a));
            }
            if (!zM41963a && file.exists()) {
                if (m41978a(file, set) > 0) {
                    i10--;
                }
                AbstractC7185ho.m43818a("FileDiskCache", "cachetype: %s current num: %d", this.f32229e.m41972f(), Integer.valueOf(i10));
                if (i10 <= this.f32226b) {
                    AbstractC7185ho.m43820b("FileDiskCache", "used cache num is lower than max num");
                    return;
                }
            } else if (zM41963a) {
                AbstractC7185ho.m43821b("FileDiskCache", "file %s is using, not delete", contentResource.m41621a());
            } else {
                AbstractC7185ho.m43821b("FileDiskCache", "file %s not exist, delete table entry", contentResource.m41621a());
                m41987a(contentResource.m41621a(), false, (Integer) null);
            }
        }
    }

    /* renamed from: b */
    private boolean m41992b(int i10, List<ContentResource> list, Set<String> set) {
        AbstractC7185ho.m43820b("FileDiskCache", "delete files not recorded for num");
        File[] fileArrListFiles = this.f32227c.listFiles();
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new a());
            for (File file : fileArrListFiles) {
                if (file.isFile() && !m41989a(file.getName(), list)) {
                    if (m41978a(file, set) > 0) {
                        i10--;
                    }
                    AbstractC7185ho.m43818a("FileDiskCache", "cachetype: %s current num: %d", this.f32229e.m41972f(), Integer.valueOf(i10));
                    if (i10 <= this.f32226b) {
                        AbstractC7185ho.m43820b("FileDiskCache", "used num is lower than max num");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m41981a(int i10, Set<String> set) {
        InterfaceC7025dn interfaceC7025dn = this.f32228d;
        List<ContentResource> listMo41943a = interfaceC7025dn != null ? interfaceC7025dn.mo41943a() : null;
        if (m41992b(i10, listMo41943a, set)) {
            AbstractC7185ho.m43820b("FileDiskCache", "there is enough space in disk cache");
        } else {
            m41980a(m42002h(), listMo41943a, set);
        }
    }

    /* renamed from: a */
    public void m42005a(long j10) {
        AbstractC7185ho.m43818a("FileDiskCache", "set max size: %d", Long.valueOf(j10));
        this.f32225a = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m41982a(long j10, Set<String> set) {
        InterfaceC7025dn interfaceC7025dn = this.f32228d;
        List<ContentResource> listMo41943a = interfaceC7025dn != null ? interfaceC7025dn.mo41943a() : null;
        if (m41988a(j10, listMo41943a, set)) {
            AbstractC7185ho.m43820b("FileDiskCache", "there is enough space in disk cache");
        } else {
            m41990b(m42001g(), listMo41943a, set);
        }
    }

    /* renamed from: a */
    public void m42006a(C7022dk c7022dk) {
        if (c7022dk != null) {
            this.f32229e = c7022dk;
        }
    }

    /* renamed from: a */
    public void m42007a(InterfaceC7025dn interfaceC7025dn) {
        this.f32228d = interfaceC7025dn;
    }

    /* renamed from: a */
    public void m42008a(String str) {
        File file = new File(this.f32227c, str);
        if (file.exists()) {
            AbstractC7731ae.m47461c(file);
            InterfaceC7025dn interfaceC7025dn = this.f32228d;
            if (interfaceC7025dn != null) {
                interfaceC7025dn.mo41946a(str, System.currentTimeMillis());
            }
        }
    }

    /* renamed from: a */
    public void m42009a(String str, int i10) {
        InterfaceC7025dn interfaceC7025dn;
        if (!new File(this.f32227c, str).exists() || (interfaceC7025dn = this.f32228d) == null) {
            return;
        }
        interfaceC7025dn.mo41945a(str, i10);
    }

    /* renamed from: a */
    private void m41986a(String str, ContentResource contentResource) {
        InterfaceC7025dn interfaceC7025dn = this.f32228d;
        if (interfaceC7025dn != null) {
            interfaceC7025dn.mo41947a(str, contentResource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m41987a(String str, boolean z10, Integer num) {
        InterfaceC7025dn interfaceC7025dn = this.f32228d;
        if (interfaceC7025dn != null) {
            interfaceC7025dn.mo41948a(str, z10, num);
        }
    }

    /* renamed from: a */
    private boolean m41988a(long j10, List<ContentResource> list, Set<String> set) {
        AbstractC7185ho.m43820b("FileDiskCache", "delete files not recorded");
        File[] fileArrListFiles = this.f32227c.listFiles();
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new a());
            for (File file : fileArrListFiles) {
                if (file.isFile() && !m41989a(file.getName(), list)) {
                    j10 -= m41978a(file, set);
                    AbstractC7185ho.m43818a("FileDiskCache", "cachetype: %s current size: %d", this.f32229e.m41972f(), Long.valueOf(j10));
                    if (j10 <= this.f32225a) {
                        AbstractC7185ho.m43820b("FileDiskCache", "used cache space is lower than max size");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m42010a(String str, File file, ContentResource contentResource) {
        boolean z10;
        AbstractC7185ho.m43820b("FileDiskCache", "put file: " + str);
        File file2 = new File(this.f32227c, str);
        if (AbstractC7731ae.m47450a(file, file2)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean lastModified = file2.setLastModified(jCurrentTimeMillis);
            if (contentResource != null) {
                contentResource.m41623a(jCurrentTimeMillis);
            }
            AbstractC7185ho.m43820b("FileDiskCache", "set last modify result: " + lastModified);
            m41986a(str, contentResource);
            z10 = true;
        } else {
            z10 = false;
        }
        if (contentResource == null || contentResource.m41637f() != 1) {
            str = null;
        }
        m41995d(str);
        return z10;
    }

    /* renamed from: a */
    private static boolean m41989a(String str, List<ContentResource> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return false;
        }
        Iterator<ContentResource> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().m41621a(), str)) {
                return true;
            }
        }
        return false;
    }
}
