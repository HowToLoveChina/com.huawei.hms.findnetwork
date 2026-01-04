package dm;

import am.InterfaceC0272h1;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupFileTask;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10554e;
import im.C10564n;
import im.InterfaceC10570t;
import java.io.File;
import mm.AbstractC11494p;
import mm.C11486h;
import mm.InterfaceC11495q;
import p455ll.C11308a;
import p495nm.C11728i;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p848zl.C14337f;
import pl.C12161c;
import pl.C12164f;
import tl.C13029h;

/* renamed from: dm.d1 */
/* loaded from: classes6.dex */
public class C9196d1 extends CloudBackupFileTask {

    /* renamed from: a */
    public final C4879a f46139a;

    /* renamed from: b */
    public final InterfaceC0272h1 f46140b;

    /* renamed from: c */
    public final File f46141c;

    /* renamed from: d */
    public final String f46142d;

    /* renamed from: e */
    public final String f46143e;

    /* renamed from: f */
    public final String f46144f;

    /* renamed from: g */
    public final String f46145g;

    /* renamed from: h */
    public final String f46146h;

    /* renamed from: i */
    public final String f46147i;

    /* renamed from: j */
    public final int f46148j;

    /* renamed from: k */
    public final C12594t1 f46149k;

    /* renamed from: l */
    public final String f46150l;

    /* renamed from: m */
    public final String f46151m;

    /* renamed from: n */
    public final long f46152n;

    /* renamed from: o */
    public C10564n f46153o;

    /* renamed from: p */
    public C12164f f46154p;

    /* renamed from: q */
    public long f46155q;

    /* renamed from: r */
    public final String f46156r;

    /* renamed from: s */
    public final C11728i f46157s;

    public C9196d1(C4879a c4879a, InterfaceC0272h1 interfaceC0272h1, CloudBackupStatus cloudBackupStatus, File file, String str, C13029h c13029h, C11728i c11728i) {
        super(cloudBackupStatus.m29870d(), 0);
        this.f46139a = c4879a;
        this.f46146h = cloudBackupStatus.mo29357K();
        this.f46140b = interfaceC0272h1;
        this.f46141c = file;
        this.f46152n = file.lastModified();
        this.f46143e = c13029h.m78444J();
        this.f46144f = cloudBackupStatus.m29870d();
        this.f46147i = str;
        this.f46142d = c4879a.getLocation();
        this.f46150l = c13029h.m78465h();
        this.f46151m = C12590s0.m75786Q(c13029h);
        this.f46149k = C12594t1.m75990o();
        this.f46148j = cloudBackupStatus.m29861N();
        this.f46145g = cloudBackupStatus.mo29421n();
        this.f46156r = cloudBackupStatus.m29345E0();
        this.f46157s = c11728i;
    }

    /* renamed from: h */
    public static boolean m57764h(C12161c c12161c, String str, String str2) {
        return TextUtils.equals(str2, str) || TextUtils.isEmpty(c12161c.m72946B());
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        String strM63452a;
        Exception e10;
        C9721b e11;
        StringBuilder sb2;
        try {
            try {
                strM63452a = C10279b.m63452a(this.f46141c);
                try {
                    C11839m.m70688i("CloudBackupV3TarFileUpload", "appid = " + this.f46144f + ",file = " + strM63452a);
                    this.f46140b.onTaskBegin(null);
                } catch (C9721b e12) {
                    e11 = e12;
                    if (!C10278a.m63442h(strM63452a).exists()) {
                        e11 = new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file not found. file = " + strM63452a + e11.getMessage(), "upload");
                    }
                    C11839m.m70687e("CloudBackupV3TarFileUpload", "upload error. file = " + strM63452a + e11.getMessage());
                    this.f46140b.onTaskAbort(e11);
                    if (this.f46152n != this.f46141c.lastModified()) {
                        sb2 = new StringBuilder();
                        sb2.append("delete return v3 tarfileModifytime: ");
                        sb2.append(this.f46152n);
                        sb2.append(" ,current: ");
                        sb2.append(this.f46141c.lastModified());
                        C11839m.m70686d("CloudBackupV3TarFileUpload", sb2.toString());
                        return;
                    }
                    C12571m.m75547i(C10279b.m63452a(this.f46141c));
                    return;
                } catch (Exception e13) {
                    e10 = e13;
                    C11839m.m70687e("CloudBackupV3TarFileUpload", "upload error catch Exception. file = " + strM63452a + e10.getMessage());
                    this.f46140b.onTaskAbort(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e10.getMessage(), "UploadTask"));
                    if (this.f46152n != this.f46141c.lastModified()) {
                        sb2 = new StringBuilder();
                        sb2.append("delete return v3 tarfileModifytime: ");
                        sb2.append(this.f46152n);
                        sb2.append(" ,current: ");
                        sb2.append(this.f46141c.lastModified());
                        C11839m.m70686d("CloudBackupV3TarFileUpload", sb2.toString());
                        return;
                    }
                    C12571m.m75547i(C10279b.m63452a(this.f46141c));
                    return;
                }
            } catch (C9721b e14) {
                strM63452a = null;
                e11 = e14;
            } catch (Exception e15) {
                strM63452a = null;
                e10 = e15;
            }
            if (!TextUtils.isEmpty(strM63452a)) {
                C12164f c12164f = new C12164f(this.f46150l, this.f46144f, 0, this.f46148j);
                this.f46154p = c12164f;
                new C11486h(this.f46147i, this.f46144f, c12164f).execute(new InterfaceC11495q() { // from class: dm.b1
                    @Override // mm.InterfaceC11495q
                    /* renamed from: a */
                    public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws InterruptedException, C9721b {
                        this.f46075a.m57767k(abstractC11494p, i10);
                    }
                });
                m57765f(strM63452a, this.f46147i);
                this.f46140b.onReturnSize(false);
                this.f46140b.onTaskSuccess();
                this.f46141c.lastModified();
                C12571m.m75547i(C10279b.m63452a(this.f46141c));
                return;
            }
            this.f46140b.onTaskFail();
            if (this.f46152n == this.f46141c.lastModified()) {
                C12571m.m75547i(C10279b.m63452a(this.f46141c));
                return;
            }
            C11839m.m70686d("CloudBackupV3TarFileUpload", "delete return v3 tarfileModifytime: " + this.f46152n + " ,current: " + this.f46141c.lastModified());
        } catch (Throwable th2) {
            if (this.f46152n != this.f46141c.lastModified()) {
                C11839m.m70686d("CloudBackupV3TarFileUpload", "delete return v3 tarfileModifytime: " + this.f46152n + " ,current: " + this.f46141c.lastModified());
            } else {
                C12571m.m75547i(C10279b.m63452a(this.f46141c));
            }
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        abort();
        C10564n c10564n = this.f46153o;
        if (c10564n != null) {
            c10564n.mo64711f();
        }
        super.cancel(z10);
    }

    /* renamed from: f */
    public final void m57765f(String str, String str2) throws InterruptedException, C9721b {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C11308a c11308aM57768p = m57768p(str, 0);
        C12161c c12161c = new C12161c();
        c12161c.m72983g0(1);
        c12161c.m72998o0(4);
        c12161c.m72981f0(c11308aM57768p.m67895m());
        c12161c.m72958N(c11308aM57768p.m67883a());
        c12161c.m73002q0(c11308aM57768p.m67898p());
        c12161c.m72961Q(str2);
        c12161c.m72968X(String.valueOf(this.f46155q));
        this.f46149k.m75993C(this.f46144f, this.f46150l, c12161c, this.f46148j);
    }

    /* renamed from: i */
    public final /* synthetic */ void m57766i(long j10, AbstractC10554e abstractC10554e) {
        synchronized (CloudBackupFileTask.SIZE_LOCK) {
            try {
                if (this.abort) {
                    C11839m.m70688i("CloudBackupV3TarFileUpload", "uploader abort return");
                } else {
                    this.f46140b.mo1765a(increaseSize((abstractC10554e.m64747z() * j10) / 100));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        C4879a c4879a = this.f46139a;
        return c4879a != null ? c4879a.isAbort() : super.isAbort();
    }

    /* renamed from: k */
    public final void m57767k(AbstractC11494p abstractC11494p, int i10) throws InterruptedException, C9721b {
        int i11;
        File file;
        long j10 = 0;
        this.f46155q = 0L;
        int i12 = 1;
        int i13 = 1;
        while (i12 <= i10) {
            C12161c c12161c = (C12161c) abstractC11494p.query(i12);
            if (c12161c != null) {
                if (i13 % 100 == 0) {
                    this.f46139a.isCancel();
                }
                String strM76013p = this.f46149k.m76013p(c12161c, this.f46145g, this.f46148j, this.f46156r);
                File fileM63442h = C10278a.m63442h(strM76013p);
                String strM75797S2 = C12590s0.m75797S2(this.f46144f, this.f46145g, this.f46148j, strM76013p, this.f46156r);
                File fileM63442h2 = C10278a.m63442h(strM75797S2);
                this.f46155q += c12161c.m72951G();
                if (c12161c.m72951G() == j10) {
                    this.f46155q++;
                }
                try {
                    if (m57764h(c12161c, strM76013p, strM75797S2)) {
                        try {
                            i11 = 0;
                            file = fileM63442h2;
                            try {
                                this.f46149k.m75991A(fileM63442h2, fileM63442h, c12161c, this.f46142d, this.f46148j);
                            } catch (C9721b e10) {
                                e = e10;
                                this.f46149k.m76023z(file, c12161c, C12583q.m75665a(C10279b.m63452a(file), i11, this.f46148j), this.f46142d);
                                C11839m.m70687e("CloudBackupV3TarFileUpload", "setMetaHashInfo err: " + e.toString());
                                c12161c.m72998o0(i11);
                                c12161c.m73000p0(7L);
                                this.f46149k.m75999I(this.f46144f, this.f46150l, c12161c, this.f46147i, this.f46148j);
                                i13++;
                                i12++;
                                j10 = 0;
                            }
                        } catch (C9721b e11) {
                            e = e11;
                            i11 = 0;
                            file = fileM63442h2;
                        }
                    } else {
                        i11 = 0;
                    }
                    c12161c.m72998o0(i11);
                    c12161c.m73000p0(7L);
                    this.f46149k.m75999I(this.f46144f, this.f46150l, c12161c, this.f46147i, this.f46148j);
                } catch (C9721b e12) {
                    C11839m.m70687e("CloudBackupV3TarFileUpload", "setOriginFileInfo err: " + e12.toString());
                    if (fileM63442h.exists()) {
                        throw e12;
                    }
                    this.f46140b.mo1766b(c12161c);
                }
                i13++;
            }
            i12++;
            j10 = 0;
        }
    }

    /* renamed from: p */
    public final C11308a m57768p(String str, int i10) throws InterruptedException, C9721b {
        try {
            final long jM73096o0 = this.f46154p.m73096o0(this.f46144f, this.f46147i);
            File fileM63442h = C10278a.m63442h(str);
            C10321z c10321z = new C10321z(this.f46139a.m29713i0(), this.f46139a.m29636F0(), this.f46139a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46143e);
            c10321z.m63540D0(this.f46139a.m29761y0());
            String str2 = this.f46144f;
            int i11 = this.f46148j;
            String str3 = this.f46143e;
            String str4 = this.f46151m;
            String str5 = this.f46150l;
            C4879a c4879a = this.f46139a;
            C10564n c10564n = new C10564n(str2, i11, str3, c10321z, str4, str5, c4879a, fileM63442h, null, c4879a.m29699d1(), this.f46157s, this.f46146h);
            this.f46153o = c10564n;
            c10564n.m64772V(i10 > 0);
            this.f46153o.m64770T(new InterfaceC10570t() { // from class: dm.c1
                @Override // im.InterfaceC10570t
                /* renamed from: a */
                public final void mo57738a(AbstractC10554e abstractC10554e) {
                    this.f46124a.m57766i(jM73096o0, abstractC10554e);
                }
            });
            return this.f46153o.m64763M(i10);
        } catch (C9721b e10) {
            if (this.abort) {
                throw e10;
            }
            this.f46139a.isCancel();
            int i12 = i10 + 1;
            if (i12 > 2 || C14337f.m85500c().contains(Integer.valueOf(e10.m60659c()))) {
                throw e10;
            }
            SystemClock.sleep(500L);
            this.f46139a.isCancel();
            C11839m.m70688i("CloudBackupV3TarFileUpload", "upload file = " + str + ", retry = " + i12);
            return m57768p(str, i12);
        }
    }
}
