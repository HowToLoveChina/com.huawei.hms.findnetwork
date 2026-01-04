package p618rm;

import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import fk.C9721b;
import java.util.List;
import p514o9.C11839m;

/* renamed from: rm.w1 */
/* loaded from: classes6.dex */
public abstract class AbstractC12603w1<T> {

    /* renamed from: a */
    public CacheTask f58003a;

    public AbstractC12603w1(CacheTask cacheTask) {
        this.f58003a = cacheTask;
    }

    /* renamed from: a */
    public abstract List<T> mo76057a(int i10) throws C9721b;

    /* renamed from: b */
    public abstract int mo76058b() throws C9721b;

    /* renamed from: c */
    public abstract void mo76059c(String str, String str2, int i10);

    /* renamed from: d */
    public void m76060d(String str, String str2, int i10, String str3) throws InterruptedException, C9721b {
        mo76059c(str, str2, i10);
        int iMo76058b = mo76058b();
        if (iMo76058b == 0) {
            return;
        }
        C11839m.m70688i("Update3rdDataMetas", "update 3rd metas hash start.");
        int i11 = 0;
        while (i11 < iMo76058b) {
            this.f58003a.isCancel();
            int iMin = Math.min(iMo76058b - i11, 3000);
            List<T> listMo76057a = mo76057a(iMin);
            if (listMo76057a != null && !listMo76057a.isEmpty()) {
                mo76061e(listMo76057a, str3);
                listMo76057a.clear();
            }
            i11 += iMin;
        }
        C11839m.m70688i("Update3rdDataMetas", "update 3rd metas hash end.");
    }

    /* renamed from: e */
    public abstract void mo76061e(List<T> list, String str) throws C9721b;
}
