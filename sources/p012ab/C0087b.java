package p012ab;

import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.drive.user.request.Keys;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.user.model.KeyDetailInfo;
import com.huawei.hicloud.base.drive.user.model.PublicKey;
import com.huawei.hicloud.request.userk.bean.EncryptBaseReq;
import com.huawei.hicloud.request.userk.bean.PublicKeyResp;
import com.huawei.hicloud.request.userk.bean.UserKeyResp;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import java.util.Iterator;
import p514o9.C11839m;
import p713vo.InterfaceC13474b;

/* renamed from: ab.b */
/* loaded from: classes3.dex */
public class C0087b {

    /* renamed from: a */
    public C0086a f330a;

    /* renamed from: b */
    public String f331b;

    /* renamed from: ab.b$b */
    public class b implements InterfaceC13474b {

        /* renamed from: a */
        public String f332a;

        /* renamed from: b */
        public boolean f333b;

        public /* synthetic */ b(C0087b c0087b, String str, a aVar) {
            this(str);
        }

        @Override // p713vo.InterfaceC13474b
        /* renamed from: a */
        public PublicKeyResp mo684a() throws C9721b {
            C11839m.m70688i("UserKeyStore", "getPublicKey");
            PublicKeyResp publicKeyResp = new PublicKeyResp();
            try {
                Keys.GetPublicKey publicKey = C0087b.this.f330a.m674a().getPublicKey();
                m687d(publicKey.getHeaders());
                if (this.f333b) {
                    publicKey.getHeaders().set("x-hw-tempKeyEncType", EncryptBaseReq.TYPE_EC_256);
                } else {
                    publicKey.setTempKeyEncType(EncryptBaseReq.TYPE_EC_256);
                }
                PublicKey publicKeyExecute = publicKey.execute();
                publicKeyResp.setPublicKey(publicKeyExecute.getPublicKey());
                publicKeyResp.setVersion(publicKeyExecute.getVersion());
                return publicKeyResp;
            } catch (C4616s e10) {
                C11839m.m70687e("UserKeyStore", "getPublicKey result: " + e10.toString());
                throw new C9721b(4312, e10.m28322f(), e10.m28319c(), "keys.publicKey", C1160a.m7253d(e10));
            } catch (IOException e11) {
                C11839m.m70687e("UserKeyStore", "getPublicKey:" + e11.toString());
                throw new C9721b(4313, "get drive public Key error:" + e11.toString());
            }
        }

        @Override // p713vo.InterfaceC13474b
        /* renamed from: b */
        public UserKeyResp mo685b(int i10, String str, int i11, String str2, int i12, String str3) throws C9721b {
            try {
                C11839m.m70688i("UserKeyStore", "getTrustCircleUserKey businessType = " + i10);
                Keys.List list = C0087b.this.f330a.m674a().list();
                m687d(list.getHeaders());
                if (this.f333b) {
                    list.getHeaders().set("x-hw-clientTrustMode", 2).set("x-hw-keyEncType", str).set("x-hw-tcisId", str2).set("x-hw-aad", str3).set("x-hw-taVersion", Integer.valueOf(i12)).set("x-hw-keyType", String.valueOf(i11));
                } else {
                    list.setClientTrustMode(2);
                    list.setKeyEncType(str);
                    list.setTcisId(str2);
                    list.setAad(str3);
                    list.setTaVersion(Integer.valueOf(i12));
                    list.getHeaders().set("x-hw-keyType", String.valueOf(i11));
                }
                list.setDataType(Integer.valueOf(i10));
                return C0087b.this.m683f(i11, list.execute());
            } catch (C4616s e10) {
                C11839m.m70687e("UserKeyStore", "getTrustCircleUserKey result" + e10.toString());
                throw new C9721b(4312, e10.m28322f(), e10.m28319c(), "keys.list", C1160a.m7253d(e10));
            } catch (IOException unused) {
                throw new C9721b(4313, "get drive user key error");
            }
        }

        @Override // p713vo.InterfaceC13474b
        /* renamed from: c */
        public UserKeyResp mo686c(int i10, String str, int i11, String str2, String str3) throws C9721b {
            try {
                C11839m.m70688i("UserKeyStore", "getUserKey businessType = " + i10);
                Keys.List list = C0087b.this.f330a.m674a().list();
                m687d(list.getHeaders());
                if (this.f333b) {
                    list.getHeaders().set("x-hw-clientTrustMode", 1).set("x-hw-keyEncType", str).set("x-hw-tempKeyEncType", EncryptBaseReq.TYPE_ECDH).set("x-hw-tempKey", str2).set("x-hw-keyVersion", str3).set("x-hw-keyType", String.valueOf(i11));
                } else {
                    list.setClientTrustMode(1);
                    list.setKeyEncType(str);
                    list.setTempKeyEncType(EncryptBaseReq.TYPE_ECDH);
                    list.setTempKey(str2);
                    list.setKeyVersion(str3);
                    list.getHeaders().set("x-hw-keyType", String.valueOf(i11));
                }
                list.setDataType(Integer.valueOf(i10));
                com.huawei.hicloud.base.drive.user.model.Keys keysExecute = list.execute();
                C11839m.m70688i("UserKeyStore", "getUserKey keys.list end");
                return C0087b.this.m683f(i11, keysExecute);
            } catch (C4616s e10) {
                C11839m.m70687e("UserKeyStore", "getUserKey result:" + e10.toString());
                throw new C9721b(4312, e10.m28322f(), e10.m28319c(), "keys.list", C1160a.m7253d(e10));
            } catch (IOException e11) {
                C11839m.m70687e("UserKeyStore", "getUserKey:" + e11.toString());
                throw new C9721b(4313, "get drive user key error:" + e11.toString());
            }
        }

        /* renamed from: d */
        public final void m687d(C4609l c4609l) {
            if (TextUtils.isEmpty(this.f332a)) {
                return;
            }
            c4609l.set("x-hw-thinsdkapp-version", this.f332a);
        }

        public b(String str) {
            this.f333b = C10028c.m62182c0().m62329g0();
            this.f332a = str;
        }
    }

    public C0087b(C0086a c0086a) {
        this(c0086a, null);
    }

    /* renamed from: c */
    public UserKeyObject m680c(String str, int i10, String str2) throws C9721b {
        return UserKeyUtils.getInstance().getSyncUser(new b(this.f331b), i10, str2, 1, str);
    }

    /* renamed from: d */
    public UserKeyObject m681d(String str, int i10, String str2) throws C9721b {
        return UserKeyUtils.getInstance().getSyncUser(new b(this.f331b), i10, str2, 3, str);
    }

    /* renamed from: e */
    public UserKeyObject m682e(String str, int i10, String str2) throws C9721b {
        return UserKeyUtils.getInstance().getSyncUser(new b(this.f331b), i10, str2, 3, str);
    }

    /* renamed from: f */
    public final UserKeyResp m683f(int i10, com.huawei.hicloud.base.drive.user.model.Keys keys) throws C9721b {
        int i11 = 1;
        if (i10 != 1) {
            i11 = 3;
            if (i10 != 3) {
                i11 = -1;
            }
        }
        UserKeyResp userKeyResp = new UserKeyResp();
        Iterator<KeyDetailInfo> it = keys.getKeys().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            KeyDetailInfo next = it.next();
            if (next.getKeyType() != null && next.getKeyType().intValue() == i11) {
                userKeyResp.setUserKey(next.getEncryptedKey());
                userKeyResp.setGuid(next.getKeyUuid());
                userKeyResp.setKeySHA256(next.getKeySHA256());
                break;
            }
        }
        return userKeyResp;
    }

    public C0087b(C0086a c0086a, String str) {
        this.f330a = c0086a;
        this.f331b = str;
    }
}
