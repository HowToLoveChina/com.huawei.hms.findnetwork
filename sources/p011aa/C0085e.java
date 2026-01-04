package p011aa;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.datamigration.bean.CutBaseResp;
import com.huawei.android.hicloud.datamigration.bean.DekInfo;
import com.huawei.android.hicloud.datamigration.bean.DekNode;
import com.huawei.android.hicloud.datamigration.bean.GetDeksResp;
import com.huawei.android.hicloud.datamigration.bean.GetPublicKeyResp;
import com.huawei.android.hicloud.datamigration.bean.LockTokenResp;
import com.huawei.android.hicloud.datamigration.bean.Progress;
import com.huawei.android.hicloud.datamigration.bean.QueryStatusResp;
import com.huawei.android.hicloud.datamigration.bean.UpdateDeksResp;
import com.huawei.android.hicloud.datamigration.bean.VerifyMigrationResp;
import com.huawei.android.hicloud.report.CloudCommonReport;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import fk.C9721b;
import gp.C10028c;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p365ic.C10466a;
import p422k9.C11019b;
import p429kk.C11060c;
import p448l9.C11262a;
import p514o9.C11829c;
import p514o9.C11839m;
import p525ok.C11908a;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12369f;
import p616rk.C12515a;
import p709vj.C13452e;
import p746wn.C13622a;
import p837z9.C14161b;
import p837z9.C14162c;
import p837z9.C14163d;

/* renamed from: aa.e */
/* loaded from: classes3.dex */
public class C0085e extends AbstractC12367d {

    /* renamed from: a */
    public Context f316a;

    /* renamed from: b */
    public String f317b;

    /* renamed from: c */
    public int f318c;

    /* renamed from: d */
    public int f319d;

    /* renamed from: e */
    public C14162c f320e;

    /* renamed from: f */
    public AbstractC12369f f321f;

    /* renamed from: g */
    public AbstractC12369f f322g;

    /* renamed from: h */
    public byte[] f323h;

    /* renamed from: i */
    public String f324i;

    /* renamed from: j */
    public Progress f325j;

    /* renamed from: k */
    public DekInfo f326k;

    /* renamed from: l */
    public PowerManager.WakeLock f327l;

    /* renamed from: m */
    public int f328m;

    /* renamed from: n */
    public C11060c f329n;

    public C0085e() {
        this.f318c = 120;
        this.f325j = null;
        this.f326k = null;
        this.f327l = null;
        this.f328m = 0;
        this.f316a = C0213f.m1377a();
    }

    /* renamed from: c */
    public final void m659c() {
        if (this.f327l == null) {
            PowerManager powerManager = (PowerManager) this.f316a.getSystemService("power");
            if (powerManager != null) {
                this.f327l = powerManager.newWakeLock(1, "SecretKeyCutTask");
            }
            PowerManager.WakeLock wakeLock = this.f327l;
            if (wakeLock != null) {
                wakeLock.acquire();
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        AbstractC12369f abstractC12369f;
        boolean zM80842P0;
        int iM62219H;
        try {
            try {
                try {
                    zM80842P0 = C13452e.m80781L().m80842P0();
                    iM62219H = C10028c.m62182c0().m62219H();
                } catch (C9721b e10) {
                    C11839m.m70687e("SecretKeyCutTask", e10.m60659c() + ", " + e10.getMessage());
                    m670o("fail", e10.m60659c());
                    m671p();
                    m668m();
                    AbstractC12369f abstractC12369f2 = this.f321f;
                    if (abstractC12369f2 != null) {
                        abstractC12369f2.cancel();
                        C12515a.m75110o().m75165a1(this.f321f);
                    }
                    abstractC12369f = this.f322g;
                    if (abstractC12369f != null) {
                    }
                }
            } catch (Exception e11) {
                C11839m.m70687e("SecretKeyCutTask", e11.getMessage());
                m670o("fail", 4001);
                m671p();
                m668m();
                AbstractC12369f abstractC12369f3 = this.f321f;
                if (abstractC12369f3 != null) {
                    abstractC12369f3.cancel();
                    C12515a.m75110o().m75165a1(this.f321f);
                }
                abstractC12369f = this.f322g;
                if (abstractC12369f != null) {
                }
            }
            if (zM80842P0 && iM62219H == 4) {
                this.f329n = CloudCommonReport.m17077a();
                this.f320e = new C14162c(this.f329n.m66661q());
                m670o("start", 0);
                C14163d.m84990g().m85015u(this.f316a.getApplicationContext());
                C14163d.m84990g().m85016v(this.f316a);
                m659c();
                m666k();
                m660d();
                m665j();
                int i10 = this.f319d;
                if (i10 == 2) {
                    C11839m.m70688i("SecretKeyCutTask", "when getLockToken, verify success next step is get config info again");
                    C11019b.m66371t().m66375B0(C0213f.m1377a());
                    return;
                }
                if (i10 == 1) {
                    m667l();
                    m668m();
                    AbstractC12369f abstractC12369f4 = this.f321f;
                    if (abstractC12369f4 != null) {
                        abstractC12369f4.cancel();
                        C12515a.m75110o().m75165a1(this.f321f);
                    }
                    AbstractC12369f abstractC12369f5 = this.f322g;
                    if (abstractC12369f5 != null) {
                        abstractC12369f5.cancel();
                        C12515a.m75110o().m75165a1(this.f322g);
                    }
                    m669n();
                    return;
                }
                m662f();
                m663g();
                m672q(0);
                m667l();
                m668m();
                AbstractC12369f abstractC12369f6 = this.f321f;
                if (abstractC12369f6 != null) {
                    abstractC12369f6.cancel();
                    C12515a.m75110o().m75165a1(this.f321f);
                }
                abstractC12369f = this.f322g;
                if (abstractC12369f != null) {
                    abstractC12369f.cancel();
                    C12515a.m75110o().m75165a1(this.f322g);
                }
                m669n();
                return;
            }
            C11839m.m70687e("SecretKeyCutTask", "account not login or data status is not 4, isLogin: " + zM80842P0 + ", data status: " + iM62219H);
            m668m();
            AbstractC12369f abstractC12369f7 = this.f321f;
            if (abstractC12369f7 != null) {
                abstractC12369f7.cancel();
                C12515a.m75110o().m75165a1(this.f321f);
            }
            AbstractC12369f abstractC12369f8 = this.f322g;
            if (abstractC12369f8 != null) {
                abstractC12369f8.cancel();
                C12515a.m75110o().m75165a1(this.f322g);
            }
            m669n();
        } finally {
            m668m();
            AbstractC12369f abstractC12369f9 = this.f321f;
            if (abstractC12369f9 != null) {
                abstractC12369f9.cancel();
                C12515a.m75110o().m75165a1(this.f321f);
            }
            AbstractC12369f abstractC12369f10 = this.f322g;
            if (abstractC12369f10 != null) {
                abstractC12369f10.cancel();
                C12515a.m75110o().m75165a1(this.f322g);
            }
            m669n();
        }
    }

    /* renamed from: d */
    public final void m660d() throws C9721b {
        C11839m.m70688i("SecretKeyCutTask", "applyLockToken");
        LockTokenResp lockTokenRespM84974f = this.f320e.m84974f();
        if (lockTokenRespM84974f == null) {
            throw new C9721b(4001, "applyLockToken fail.");
        }
        if (lockTokenRespM84974f.getCode() != 0) {
            throw new C9721b(lockTokenRespM84974f.getCode(), "applyLockToken fail, " + lockTokenRespM84974f.getInfo());
        }
        this.f317b = lockTokenRespM84974f.getLockToken();
        this.f318c = lockTokenRespM84974f.getExpire() >= 4 ? lockTokenRespM84974f.getExpire() : this.f318c;
        this.f319d = lockTokenRespM84974f.getVerifyStatus();
        C11839m.m70688i("SecretKeyCutTask", "get lockToken success");
        C11839m.m70686d("SecretKeyCutTask", "Token is " + this.f317b + ", expire = " + lockTokenRespM84974f.getExpire() + "verifyStatus = " + this.f319d);
    }

    /* renamed from: e */
    public final void m661e(DekInfo dekInfo, int i10) throws C9721b {
        C11839m.m70688i("SecretKeyCutTask", "encryptDataKeyByUserKey begin");
        if (dekInfo == null || dekInfo.getDekList() == null || i10 >= 3) {
            C11839m.m70689w("SecretKeyCutTask", "encryptDataKeyByUserKey error, retry is " + i10);
            return;
        }
        int i11 = "cloudbackup".equalsIgnoreCase(dekInfo.getService()) ? 19 : 0;
        C11839m.m70688i("SecretKeyCutTask", "encryptDataKeyByUserKey dek size= " + dekInfo.getDekList().size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (DekNode dekNode : dekInfo.getDekList()) {
            String strM64312c = C10466a.m64312c(dekNode.getDek(), this.f323h, C11829c.m70566c0(dekNode.getIv()));
            C11839m.m70686d("SecretKeyCutTask", "encryptDataKeyByUserKey decodeDek " + strM64312c);
            if (TextUtils.isEmpty(strM64312c)) {
                arrayList2.add(dekNode);
            } else {
                String strM64319j = C10466a.m64319j(strM64312c, i11, this.f329n.m66661q());
                C11839m.m70686d("SecretKeyCutTask", "encryptDataKeyByUserKey encodeByUserKey " + strM64319j);
                if (TextUtils.isEmpty(strM64319j)) {
                    C11839m.m70686d("SecretKeyCutTask", "encryptDataKeyByUserKey DekNode fail");
                    arrayList2.add(dekNode);
                } else {
                    dekNode.setDek(strM64319j);
                    C11839m.m70686d("SecretKeyCutTask", "encryptDataKeyByUserKey DekNode success");
                    arrayList.add(dekNode);
                }
            }
        }
        C11839m.m70688i("SecretKeyCutTask", "update dek Begin success size = " + arrayList.size() + ", fail size = " + arrayList2.size());
        if (arrayList.size() > 0) {
            dekInfo.setDekList(arrayList);
            m673r(dekInfo, i11, 0);
        }
    }

    /* renamed from: f */
    public final void m662f() throws NoSuchPaddingException, C9721b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        C11839m.m70688i("SecretKeyCutTask", "generateTempKey");
        try {
            this.f323h = C11908a.m71443b(16);
            GetPublicKeyResp getPublicKeyRespM84975g = this.f320e.m84975g();
            if (getPublicKeyRespM84975g == null) {
                throw new C9721b(4001, "generateTempKey Fail.");
            }
            if (getPublicKeyRespM84975g.getCode() != 0) {
                throw new C9721b(getPublicKeyRespM84975g.getCode(), "generateTempKey Fail, " + getPublicKeyRespM84975g.getInfo());
            }
            C11839m.m70686d("SecretKeyCutTask", "publicKeyResp key is " + getPublicKeyRespM84975g.getPk());
            try {
                RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C11829c.m70566c0(getPublicKeyRespM84975g.getPk())));
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                cipher.init(1, rSAPublicKey, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT));
                this.f324i = C11829c.m70571e(cipher.doFinal(this.f323h));
                C11839m.m70686d("SecretKeyCutTask", "temp public key is " + this.f324i);
            } catch (Exception unused) {
                C11839m.m70687e("SecretKeyCutTask", "generateTempKey Exception");
            }
        } catch (NoSuchAlgorithmException e10) {
            throw new C9721b(4001, "generateTempKey Fail." + e10.toString());
        }
    }

    /* renamed from: g */
    public final void m663g() throws C9721b {
        C11839m.m70688i("SecretKeyCutTask", "migrate data key begin");
        do {
            m664h(0);
            m661e(this.f326k, 0);
        } while (this.f325j != null);
        C11839m.m70688i("SecretKeyCutTask", "migrate data key end");
    }

    /* renamed from: h */
    public final void m664h(int i10) throws C9721b {
        GetDeksResp getDeksRespM84973d;
        C11839m.m70688i("SecretKeyCutTask", "getDekInfoFromServer retry time is " + i10);
        try {
            getDeksRespM84973d = this.f320e.m84973d(this.f325j, this.f324i, this.f317b);
        } catch (C9721b e10) {
            i10++;
            if (i10 >= 3) {
                throw e10;
            }
            m664h(i10);
            getDeksRespM84973d = null;
        }
        if (getDeksRespM84973d != null && getDeksRespM84973d.getCode() == 0) {
            this.f325j = getDeksRespM84973d.getProgress();
            this.f326k = getDeksRespM84973d.getDeks();
            return;
        }
        int i11 = i10 + 1;
        if (i11 < 3) {
            m664h(i11);
            return;
        }
        this.f325j = null;
        this.f326k = null;
        if (getDeksRespM84973d == null) {
            throw new C9721b(4001, "getDekInfo Fail.");
        }
        throw new C9721b(getDeksRespM84973d.getCode(), "getDekInfo Fail, " + getDeksRespM84973d.getInfo());
    }

    /* renamed from: j */
    public final void m665j() {
        int i10 = this.f318c;
        this.f321f = new C0083c(i10 / 4, i10 / 4, this.f317b, this.f329n.m66661q());
        C12515a.m75110o().m75172d(this.f321f);
    }

    /* renamed from: k */
    public final void m666k() {
        if (C0219i.m1463a() < 17) {
            C11839m.m70689w("SecretKeyCutTask", "emui version lower than 9.0, can not apply powerKit");
            return;
        }
        if (this.f322g == null) {
            this.f322g = new C0084d(0L, 1200000L);
        }
        C12515a.m75110o().m75172d(this.f322g);
    }

    /* renamed from: l */
    public final void m667l() throws C9721b {
        QueryStatusResp queryStatusRespM84983o = this.f320e.m84983o(this.f317b);
        if (queryStatusRespM84983o.getCode() != 0) {
            throw new C9721b(queryStatusRespM84983o.getCode(), "query first failed, " + queryStatusRespM84983o.getInfo());
        }
        int interval = queryStatusRespM84983o.getInterval();
        int retry = queryStatusRespM84983o.getRetry();
        int i10 = 0;
        for (int i11 = 0; i11 < retry; i11++) {
            SystemClock.sleep(interval * 1000);
            QueryStatusResp queryStatusRespM84983o2 = this.f320e.m84983o(this.f317b);
            C11839m.m70688i("SecretKeyCutTask", "verify result code = " + queryStatusRespM84983o2.getCode() + ", verify = " + queryStatusRespM84983o2.getVerifyStatus());
            if (queryStatusRespM84983o2.getCode() == 0) {
                if (queryStatusRespM84983o2.getVerifyStatus() == 2) {
                    C11839m.m70688i("SecretKeyCutTask", "verify success next step is get config info again");
                    C11019b.m66371t().m66375B0(C0213f.m1377a());
                    m670o("success", 0);
                    C14163d.m84990g().m84994D(this.f316a.getApplicationContext());
                    C14163d.m84990g().m84995E(this.f316a);
                    return;
                }
                if (queryStatusRespM84983o2.getVerifyStatus() == -1) {
                    C11839m.m70688i("SecretKeyCutTask", "verify fail wait for next migration");
                    return;
                } else if (queryStatusRespM84983o2.getVerifyStatus() == 0) {
                    i10++;
                    m672q(i10);
                }
            }
        }
        m670o("fail", 0);
    }

    /* renamed from: m */
    public final void m668m() {
        AbstractC12369f abstractC12369f = this.f321f;
        if (abstractC12369f != null) {
            abstractC12369f.cancel();
        }
        C11839m.m70688i("SecretKeyCutTask", "release LockToken");
        try {
            CutBaseResp cutBaseRespM84984p = this.f320e.m84984p(this.f317b);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("release result = ");
            sb2.append(cutBaseRespM84984p != null ? cutBaseRespM84984p.toString() : "null");
            C11839m.m70688i("SecretKeyCutTask", sb2.toString());
        } catch (C9721b unused) {
            C11839m.m70687e("SecretKeyCutTask", "release LockToken fail.");
        }
    }

    /* renamed from: n */
    public final void m669n() {
        PowerManager.WakeLock wakeLock = this.f327l;
        if (wakeLock != null) {
            wakeLock.release();
            this.f327l = null;
        }
    }

    /* renamed from: o */
    public void m670o(String str, int i10) {
        HashMap map = new HashMap();
        map.put("migration_state", str);
        this.f329n.m66664t("07002");
        this.f329n.m66665u("119_" + i10);
        C13622a.m81969o(this.f316a, this.f329n, map);
    }

    /* renamed from: p */
    public final void m671p() {
        if (C0209d.m1333z1(this.f316a)) {
            int i10 = this.f328m + 1;
            this.f328m = i10;
            if (i10 < 3) {
                new C11262a().m67603g(this.f316a, 3, new C14161b(), this.f328m);
            }
        }
    }

    /* renamed from: q */
    public final void m672q(int i10) throws C9721b {
        if (i10 >= 3) {
            C11839m.m70689w("SecretKeyCutTask", "startVerifyMigrationResult retry max, retry is " + i10);
            throw new C9721b(4000, "can not start verify!");
        }
        VerifyMigrationResp verifyMigrationRespM84989u = this.f320e.m84989u(this.f317b);
        if (verifyMigrationRespM84989u.getCode() == 0) {
            return;
        }
        throw new C9721b(verifyMigrationRespM84989u.getCode(), "verify failed, " + verifyMigrationRespM84989u.getInfo());
    }

    /* renamed from: r */
    public final void m673r(DekInfo dekInfo, int i10, int i11) throws C9721b {
        if (i11 >= 3) {
            C11839m.m70689w("SecretKeyCutTask", "update dek reach max");
            return;
        }
        UpdateDeksResp updateDeksRespM84988t = this.f320e.m84988t(dekInfo, i10, this.f317b);
        if (updateDeksRespM84988t != null) {
            int code = updateDeksRespM84988t.getCode();
            C11839m.m70686d("SecretKeyCutTask", "updateDeksResp code: " + code + ", info: " + updateDeksRespM84988t.getInfo());
            if (708 == code) {
                UserKeyUtils.getInstance().clearUserKeyByBusinessType(i10);
                throw new C9721b(code, "Migration error");
            }
        }
        DekInfo failList = updateDeksRespM84988t == null ? null : updateDeksRespM84988t.getFailList();
        if (failList == null || failList.getDekList() == null) {
            return;
        }
        m673r(failList, i10, i11 + 1);
    }

    public C0085e(int i10) {
        this.f318c = 120;
        this.f325j = null;
        this.f326k = null;
        this.f327l = null;
        this.f328m = 0;
        this.f316a = C0213f.m1377a();
        this.f328m = i10;
    }
}
