package p222da;

import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import no.C11739b;
import p015ak.C0227m;
import p052cb.C1414k;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: da.c */
/* loaded from: classes3.dex */
public class C9059c extends AbstractRunnableC12516b {

    /* renamed from: a */
    public String f45754a;

    /* renamed from: b */
    public String f45755b;

    /* renamed from: c */
    public String f45756c;

    /* renamed from: d */
    public CountDownLatch f45757d;

    public C9059c(String str, String str2, String str3) {
        this.f45754a = str;
        this.f45755b = str2;
        this.f45756c = str3;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        File file;
        try {
            try {
                C11839m.m70686d("HiCloudActivesPictureTask", "HiCloudActivesPictureTask start");
                C11829c.m70598n(this.f45754a, this.f45755b, new C11739b(this.f45754a, 0L));
                file = new File(this.f45754a);
            } catch (Exception e10) {
                C11839m.m70687e("HiCloudActivesPictureTask", e10.toString());
                CountDownLatch countDownLatch = this.f45757d;
                if (countDownLatch != null) {
                }
            }
            if (!file.exists()) {
                throw new C1414k("download picture to local failed. picUrl = " + this.f45755b + " destPath = " + this.f45754a);
            }
            try {
                if (!TextUtils.isEmpty(this.f45756c) && !this.f45756c.equals(generateFileHash(this.f45754a)) && file.delete()) {
                    C11839m.m70687e("HiCloudActivesPictureTask", "picture hash not equals, delete file successed");
                }
            } catch (Exception e11) {
                C11839m.m70687e("HiCloudActivesPictureTask", "picture hash exception:" + e11.toString());
            }
        } finally {
            CountDownLatch countDownLatch2 = this.f45757d;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            C11839m.m70686d("HiCloudActivesPictureTask", "HiCloudActivesPictureTask end");
        }
    }

    public final String generateFileHash(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudActivesPictureTask", "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    public String getDestPath() {
        return this.f45754a;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.BANNER_DOWNLOAD_FIX;
    }

    public String getPicUrl() {
        return this.f45755b;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    public void setCount(CountDownLatch countDownLatch) {
        this.f45757d = countDownLatch;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}
