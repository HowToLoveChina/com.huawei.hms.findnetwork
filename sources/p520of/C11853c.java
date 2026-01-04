package p520of;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4343a;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.secure.android.common.util.SafeBase64;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0227m;
import p521og.C11877j;
import p575qe.C12347f;
import p809yg.C13981a;

/* renamed from: of.c */
/* loaded from: classes4.dex */
public class C11853c {

    /* renamed from: a */
    public volatile boolean f54876a;

    /* renamed from: of.c$b */
    public static class b implements Handler.Callback {

        /* renamed from: a */
        public Map<String, Object> f54877a;

        /* renamed from: b */
        public CountDownLatch f54878b;

        public b(Map<String, Object> map, CountDownLatch countDownLatch) {
            this.f54877a = map;
            this.f54878b = countDownLatch;
        }

        /* renamed from: a */
        public final void m70974a(String str, Map<String, Object> map) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            String string;
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str);
                string = jSONObject.has("clientTAKey") ? jSONObject.getString("clientTAKey") : null;
            } catch (JSONException unused) {
                string = null;
            }
            try {
            } catch (JSONException unused2) {
                C13981a.m83988e("ClientTAKeyGetManager", "JSONException");
                if (TextUtils.isEmpty(string)) {
                }
                C13981a.m83988e("ClientTAKeyGetManager", "parseResponse clientTaKey or clientTaKeySha256 is empty");
                C11853c.m70968g().m70973i(false);
                return;
            }
            String string2 = jSONObject.has("clientTAKeySha256") ? jSONObject.getString("clientTAKeySha256") : null;
            if (!TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                C13981a.m83988e("ClientTAKeyGetManager", "parseResponse clientTaKey or clientTaKeySha256 is empty");
                C11853c.m70968g().m70973i(false);
                return;
            }
            byte[] bArrM70977c = c.m70977c(c.m70975a(string), c.m70979e(map));
            String str2 = bArrM70977c != null ? new String(bArrM70977c, StandardCharsets.UTF_8) : null;
            if (!C11853c.m70967c(str2, string2)) {
                C13981a.m83988e("ClientTAKeyGetManager", "checkTaKey false");
                C11853c.m70968g().m70973i(false);
                return;
            }
            Context contextM74301m = C12347f.m74285n().m74301m();
            C11877j.m71314w0(contextM74301m, str2);
            C11877j.m71316x0(contextM74301m, string2);
            C13981a.m83989i("ClientTAKeyGetManager", "checkTaKey success");
            C11853c.m70968g().m70973i(true);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            C13981a.m83989i("ClientTAKeyGetManager", "handle callback");
            Bundle data = message.getData();
            if (data != null) {
                String string = data.getString("result");
                String string2 = data.getString("response_info");
                C13981a.m83989i("ClientTAKeyGetManager", "resultCode:" + string);
                if ("200".equals(string)) {
                    m70974a(string2, this.f54877a);
                }
            }
            CountDownLatch countDownLatch = this.f54878b;
            if (countDownLatch == null) {
                return true;
            }
            countDownLatch.countDown();
            return true;
        }
    }

    /* renamed from: of.c$c */
    public static class c {
        /* renamed from: a */
        public static byte[] m70975a(String str) {
            return SafeBase64.decode(str, 2);
        }

        /* renamed from: b */
        public static String m70976b(byte[] bArr) {
            return SafeBase64.encodeToString(bArr, 2);
        }

        /* renamed from: c */
        public static byte[] m70977c(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                cipher.init(2, m70978d(bArr2), new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (Exception e10) {
                C13981a.m83988e("ClientTAKeyGetManager", "Exception: " + e10.getMessage());
                return new byte[0];
            }
        }

        /* renamed from: d */
        public static PrivateKey m70978d(byte[] bArr) throws Exception {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
        }

        /* renamed from: e */
        public static byte[] m70979e(Map<String, Object> map) {
            try {
                Key key = (Key) map.get("RSAPrivateKey");
                if (key != null) {
                    return key.getEncoded();
                }
            } catch (Exception e10) {
                C13981a.m83988e("ClientTAKeyGetManager", "Exception: " + e10.getMessage());
            }
            return new byte[0];
        }

        /* renamed from: f */
        public static byte[] m70980f(Map<String, Object> map) {
            try {
                Key key = (Key) map.get("RSAPublicKey");
                if (key != null) {
                    return key.getEncoded();
                }
            } catch (Exception e10) {
                C13981a.m83988e("ClientTAKeyGetManager", "Exception: " + e10.getMessage());
            }
            return new byte[0];
        }

        /* renamed from: g */
        public static Map<String, Object> m70981g() throws NoSuchAlgorithmException {
            HashMap map = new HashMap(2);
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                keyPairGenerator.initialize(3072);
                KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
                RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
                RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) keyPairGenerateKeyPair.getPrivate();
                map.put("RSAPublicKey", rSAPublicKey);
                map.put("RSAPrivateKey", rSAPrivateKey);
            } catch (Exception e10) {
                C13981a.m83988e("ClientTAKeyGetManager", "Exception: " + e10.getMessage());
            }
            return map;
        }
    }

    /* renamed from: of.c$d */
    public static class d {

        /* renamed from: a */
        public static final C11853c f54879a = new C11853c();
    }

    /* renamed from: c */
    public static boolean m70967c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C13981a.m83990w("ClientTAKeyGetManager", "checkSha256 clientTaKey or clientTaKeySha256 is empty");
            return false;
        }
        String strM1593f = C0227m.m1593f(str);
        if (!TextUtils.isEmpty(strM1593f) && strM1593f.equals(str2)) {
            return true;
        }
        C13981a.m83988e("ClientTAKeyGetManager", "checkSha256 false");
        return false;
    }

    /* renamed from: g */
    public static C11853c m70968g() {
        return d.f54879a;
    }

    /* renamed from: d */
    public final String m70969d(Map<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tmpPublicKey", c.m70976b(c.m70980f(map)));
        } catch (Exception e10) {
            C13981a.m83988e("ClientTAKeyGetManager", "encaseRequestInfo Exception: " + e10.getMessage());
        }
        return jSONObject.toString();
    }

    /* renamed from: e */
    public final void m70970e(Context context, CountDownLatch countDownLatch) throws JSONException, NoSuchAlgorithmException {
        C13981a.m83989i("ClientTAKeyGetManager", "getClientTaKey");
        RequestModeConfig.getInstance().setMode(Integer.valueOf(NotifyErr.NOTIFY_MALFORMEDURL), false);
        Map<String, Object> mapM70981g = c.m70981g();
        String strM70969d = m70969d(mapM70981g);
        C4346d.m26227f(NotifyErr.NOTIFY_MALFORMEDURL, strM70969d, new b(mapM70981g, countDownLatch), context, "", new C4343a(context, "", null, strM70969d, NotifyErr.NOTIFY_MALFORMEDURL, ""));
    }

    /* renamed from: f */
    public synchronized boolean m70971f(Context context) {
        try {
            C13981a.m83989i("ClientTAKeyGetManager", "checkClientTaKey");
            if (m70972h(context)) {
                m70973i(true);
            } else {
                m70973i(false);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                m70970e(context, countDownLatch);
                try {
                    C13981a.m83987d("ClientTAKeyGetManager", "CountDownLatch await: " + countDownLatch.await(30L, TimeUnit.SECONDS));
                } catch (InterruptedException unused) {
                    C13981a.m83988e("ClientTAKeyGetManager", "CountDownLatch exception");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f54876a;
    }

    /* renamed from: h */
    public boolean m70972h(Context context) {
        if (m70967c(C11877j.m71290o(context), C11877j.m71293p(context))) {
            return true;
        }
        C13981a.m83990w("ClientTAKeyGetManager", "ta key is empty");
        return false;
    }

    /* renamed from: i */
    public final void m70973i(boolean z10) {
        C13981a.m83987d("ClientTAKeyGetManager", "setClientTaKeyValid: " + z10);
        this.f54876a = z10;
    }

    public C11853c() {
        this.f54876a = false;
    }
}
