package com.huawei.android.hicloud.sync.protocol;

import com.huawei.android.hicloud.security.bean.DataEncryptReq;
import com.huawei.android.hicloud.security.bean.EncryptedData;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0227m;
import p365ic.C10466a;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.protocol.d */
/* loaded from: classes3.dex */
public class C2925d {

    /* renamed from: a */
    public String f12954a = null;

    /* renamed from: b */
    public String f12955b = null;

    /* renamed from: c */
    public Map<String, Object> f12956c = new HashMap();

    /* renamed from: d */
    public String f12957d = null;

    /* renamed from: e */
    public boolean f12958e;

    /* renamed from: a */
    public String m17748a() {
        return this.f12957d;
    }

    /* renamed from: b */
    public String m17749b() {
        return this.f12954a;
    }

    /* renamed from: c */
    public String m17750c() {
        return this.f12955b;
    }

    /* renamed from: d */
    public Map<String, Object> m17751d() {
        return this.f12956c;
    }

    /* renamed from: e */
    public boolean m17752e() {
        return this.f12958e;
    }

    /* renamed from: f */
    public String m17753f(String str, String str2) throws C9722c {
        int iM62373p = C10028c.m62182c0().m62373p();
        if (iM62373p == 0) {
            this.f12958e = false;
            this.f12957d = str;
            this.f12956c.put(HicloudH5ConfigManager.KEY_HASH, C0227m.m1593f(str));
        } else if (iM62373p == 1) {
            this.f12958e = true;
            DataEncryptReq dataEncryptReq = new DataEncryptReq();
            dataEncryptReq.setSrcData(str);
            try {
                EncryptedData encryptedDataM64323n = C10466a.m64323n(dataEncryptReq);
                C11839m.m70686d("NodeInfoReq", "setEncryptedData: src data is " + str);
                this.f12957d = encryptedDataM64323n.getData();
                this.f12956c.put(SyncProtocol.Constant.DEK, encryptedDataM64323n.getEdek());
                this.f12956c.put(HicloudH5ConfigManager.KEY_HASH, C0227m.m1593f(str));
                return encryptedDataM64323n.getKeyGuid();
            } catch (C9721b e10) {
                String str3 = "Encrypt data fail, errorCode = " + e10.m60659c() + ", msg = " + e10.getMessage();
                C11839m.m70687e("NodeInfoReq", str3);
                throw new C9722c(2013, str3, str2, "local_upload");
            }
        }
        return null;
    }

    /* renamed from: g */
    public void m17754g(String str) {
        this.f12954a = str;
    }

    /* renamed from: h */
    public void m17755h(String str) {
        this.f12955b = str;
    }
}
