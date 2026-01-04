package sl;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.File;
import com.huawei.hicloud.notification.constants.HNConstants;
import p514o9.C11839m;
import p618rm.C12583q;
import pl.C12161c;

/* renamed from: sl.d */
/* loaded from: classes6.dex */
public class C12813d {

    /* renamed from: a */
    public String f58524a = "";

    /* renamed from: b */
    public int f58525b = 0;

    /* renamed from: c */
    public String f58526c = "";

    /* renamed from: d */
    public String f58527d = "";

    /* renamed from: e */
    public String f58528e = "";

    /* renamed from: f */
    public String f58529f = "";

    /* renamed from: g */
    public String f58530g = "";

    /* renamed from: h */
    public long f58531h = 0;

    /* renamed from: i */
    public String f58532i = "";

    /* renamed from: j */
    public String f58533j = "";

    /* renamed from: k */
    public String f58534k = "";

    /* renamed from: a */
    public String m76889a() {
        return this.f58524a;
    }

    /* renamed from: b */
    public String m76890b() {
        return this.f58529f;
    }

    /* renamed from: c */
    public String m76891c() {
        return this.f58526c;
    }

    /* renamed from: d */
    public String m76892d() {
        return this.f58532i;
    }

    /* renamed from: e */
    public String m76893e() {
        return this.f58533j;
    }

    /* renamed from: f */
    public String m76894f() {
        return this.f58534k;
    }

    /* renamed from: g */
    public long m76895g() {
        return this.f58531h;
    }

    /* renamed from: h */
    public String m76896h() {
        return this.f58528e;
    }

    /* renamed from: i */
    public String m76897i() {
        return this.f58530g;
    }

    /* renamed from: j */
    public String m76898j() {
        return this.f58527d;
    }

    /* renamed from: k */
    public int m76899k() {
        return this.f58525b;
    }

    /* renamed from: l */
    public void m76900l(String str) {
        this.f58524a = str;
    }

    /* renamed from: m */
    public void m76901m(String str) {
        this.f58529f = str;
    }

    /* renamed from: n */
    public void m76902n(String str) {
        this.f58526c = str;
    }

    /* renamed from: o */
    public void m76903o(String str) {
        this.f58532i = str;
    }

    /* renamed from: p */
    public void m76904p(String str) {
        this.f58533j = str;
    }

    /* renamed from: q */
    public void m76905q(String str) {
        this.f58534k = str;
    }

    /* renamed from: r */
    public void m76906r(long j10) {
        this.f58531h = j10;
    }

    /* renamed from: s */
    public void m76907s(String str) {
        this.f58528e = str;
    }

    /* renamed from: t */
    public void m76908t(String str) {
        this.f58530g = str;
    }

    /* renamed from: u */
    public void m76909u(String str) {
        this.f58527d = str;
    }

    /* renamed from: v */
    public void m76910v(int i10) {
        this.f58525b = i10;
    }

    /* renamed from: w */
    public void m76911w(C12161c c12161c, int i10) {
        m76908t(c12161c.m72945A());
        m76909u(c12161c.m72950F());
        m76902n(c12161c.m72991l());
        m76906r(c12161c.m73006u());
        m76900l(c12161c.m72974c());
        m76910v(i10);
    }

    /* renamed from: x */
    public void m76912x(File file) {
        String strSubstring;
        String sha256 = file.getSha256();
        String localPath = file.getLocalPath();
        m76908t(sha256);
        m76900l(file.getAppPackageName());
        if (!TextUtils.isEmpty(file.getCloudPath())) {
            if (TextUtils.equals(m76889a(), HNConstants.DataType.MEDIA)) {
                String[] strArrSplit = file.getCloudPath().split("/");
                if (strArrSplit.length < 2) {
                    C11839m.m70688i("CloudBackupLostFile", "updateByServerFileInfo cloudserverpath content < 2");
                    return;
                }
                strSubstring = strArrSplit[strArrSplit.length - 2] + "/" + strArrSplit[strArrSplit.length - 1];
            } else {
                int iLastIndexOf = file.getCloudPath().lastIndexOf("/") + 1;
                if (iLastIndexOf < 0) {
                    iLastIndexOf = 0;
                }
                strSubstring = file.getCloudPath().substring(iLastIndexOf);
            }
            m76901m(strSubstring);
        }
        if (!TextUtils.isEmpty(file.getId())) {
            m76907s(file.getId());
        }
        if (TextUtils.isEmpty(localPath)) {
            return;
        }
        String strM75648B = C12583q.m75648B(localPath);
        if (ICBUtil.hasEmojiCharacter(localPath)) {
            localPath = ICBUtil.getEncodedPath(localPath);
        }
        m76902n(localPath.substring(strM75648B.length()));
        m76909u(strM75648B);
    }

    /* renamed from: y */
    public void m76913y(SnapshotBackupMeta snapshotBackupMeta) {
        m76908t(snapshotBackupMeta.getHash1());
        m76909u(snapshotBackupMeta.getRoot());
        m76902n(snapshotBackupMeta.getData());
        m76906r(snapshotBackupMeta.getDateModify());
        m76900l(snapshotBackupMeta.getAppId());
    }
}
