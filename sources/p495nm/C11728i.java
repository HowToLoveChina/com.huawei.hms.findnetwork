package p495nm;

import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicy;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p514o9.C11839m;

/* renamed from: nm.i */
/* loaded from: classes6.dex */
public class C11728i {

    /* renamed from: a */
    public final C11735p f54253a;

    /* renamed from: b */
    public SCompressionPolicy f54254b;

    /* renamed from: c */
    public final Set<String> f54255c = ConcurrentHashMap.newKeySet();

    /* renamed from: d */
    public boolean f54256d;

    /* renamed from: e */
    public boolean f54257e;

    public C11728i(C11735p c11735p) {
        this.f54253a = c11735p;
    }

    /* renamed from: a */
    public void m69974a(String str) {
        if (str == null) {
            C11839m.m70689w("CompressParams", "add normal upload file error,filePath is null");
            return;
        }
        this.f54255c.add(str);
        C11839m.m70688i("CompressParams", "add normal upload file end:" + str + ",currentSize:" + this.f54255c.size());
    }

    /* renamed from: b */
    public SCompressionPolicy m69975b() {
        return this.f54254b;
    }

    /* renamed from: c */
    public C11735p m69976c() {
        return this.f54253a;
    }

    /* renamed from: d */
    public boolean m69977d(String str) {
        return this.f54255c.contains(str);
    }

    /* renamed from: e */
    public boolean m69978e() {
        return this.f54257e;
    }

    /* renamed from: f */
    public void m69979f(String str) {
        if (str == null) {
            C11839m.m70689w("CompressParams", "remove normal upload file error,filePath is null");
            return;
        }
        this.f54255c.remove(str);
        C11839m.m70688i("CompressParams", "remove normal upload file end:" + str + ",currentSize:" + this.f54255c.size());
    }

    /* renamed from: g */
    public void m69980g(SCompressionPolicy sCompressionPolicy) {
        this.f54254b = sCompressionPolicy;
    }

    /* renamed from: h */
    public void m69981h(boolean z10) {
        this.f54256d = z10;
    }

    /* renamed from: i */
    public void m69982i(boolean z10) {
        this.f54257e = z10;
    }
}
