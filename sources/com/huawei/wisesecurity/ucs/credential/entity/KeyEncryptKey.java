package com.huawei.wisesecurity.ucs.credential.entity;

import android.content.Context;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import cw.C8957b;
import cw.C8958c;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p239dw.C9320b;
import p239dw.C9338k;
import p239dw.C9339k0;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12036c;
import p535ov.InterfaceC12044k;
import p857zv.Exception_C14389c;

/* loaded from: classes9.dex */
public class KeyEncryptKey {
    private static final int KEK_ALG_GCM = 1;
    private static final String TAG = "KeyEncryptKey";

    @InterfaceC12036c(max = 5, min = 0)
    private int alg;

    @InterfaceC12036c(max = 1, min = 0)
    private int kekAlg;

    @InterfaceC12044k
    private String key;

    /* renamed from: v1 */
    private int f45392v1;

    /* renamed from: v2 */
    private int f45393v2;
    private int version;

    private void checkC1Version(Context context) throws Exception_C14389c {
        if (this.f45393v2 != C8957b.m56703b("Local-C1-Version", -1, context)) {
            throw new Exception_C14389c(1020L, "kek V2 with C1 version check fail,  please reapply the credential.");
        }
    }

    private void checkSoVersion() throws Exception_C14389c {
        if (this.f45392v1 != ((int) UcsLib.ucsGetSoVersion())) {
            throw new Exception_C14389c(1020L, "kek V1 with so version check fail,  please reapply the credential.");
        }
    }

    private void checkVersion(Context context, int i10) throws Exception_C14389c, IOException {
        UcsLib.checkNativeLibrary();
        if (i10 == 3 || i10 == 6 || i10 == 7) {
            return;
        }
        checkSoVersion();
        checkC1Version(context);
        updateRootKey(context);
    }

    public static KeyEncryptKey fromString(Context context, String str) throws Exception_C14389c, IOException {
        try {
            KeyEncryptKey keyEncryptKey = new KeyEncryptKey();
            JSONObject jSONObject = new JSONObject(C8958c.m56710b(str, 0));
            keyEncryptKey.version = jSONObject.getInt("version");
            keyEncryptKey.alg = jSONObject.getInt("alg");
            keyEncryptKey.kekAlg = jSONObject.getInt("kekAlg");
            keyEncryptKey.key = jSONObject.getString("key");
            keyEncryptKey.f45392v1 = jSONObject.optInt("v1");
            keyEncryptKey.f45393v2 = jSONObject.optInt(InterfaceC5323b.f24693t);
            C11756a.m70079b(keyEncryptKey);
            keyEncryptKey.checkVersion(context, keyEncryptKey.version);
            if (keyEncryptKey.kekAlg == 1) {
                return keyEncryptKey;
            }
            throw new Exception_C14389c(1020L, "unsupported kek alg");
        } catch (C10626e e10) {
            StringBuilder sbM58651a = C9320b.m58651a("kek param invalid : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1001L, sbM58651a.toString());
        } catch (JSONException e11) {
            StringBuilder sbM58651a2 = C9320b.m58651a("kek param is not a valid json string : ");
            sbM58651a2.append(e11.getMessage());
            throw new Exception_C14389c(1001L, sbM58651a2.toString());
        }
    }

    private void updateRootKey(Context context) throws Exception_C14389c, IOException {
        if (UcsLib.isRootKeyUpdated()) {
            return;
        }
        C9339k0.m58692a(context, new C9338k());
    }

    public int getAlg() {
        return this.alg;
    }

    public int getKekAlg() {
        return this.kekAlg;
    }

    public String getKey() {
        return this.key;
    }

    public int getV1() {
        return this.f45392v1;
    }

    public int getV2() {
        return this.f45393v2;
    }

    public int getVersion() {
        return this.version;
    }
}
