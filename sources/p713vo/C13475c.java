package p713vo;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hicloud.request.userk.bean.EncryptBaseReq;
import com.huawei.hicloud.request.userk.bean.KeyInfo;
import com.huawei.hicloud.request.userk.bean.PublicKeyReq;
import com.huawei.hicloud.request.userk.bean.PublicKeyResp;
import com.huawei.hicloud.request.userk.bean.QueryKeyReq;
import com.huawei.hicloud.request.userk.bean.QueryKeyResp;
import com.huawei.hicloud.request.userk.bean.TrustCircleUserKeyReq;
import com.huawei.hicloud.request.userk.bean.UserKeyReq;
import com.huawei.hicloud.request.userk.bean.UserKeyResp;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.secure.android.common.util.SafeBase64;
import fk.C9720a;
import fk.C9721b;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.LinkedHashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import p015ak.C0213f;
import p015ak.C0227m;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p525ok.C11908a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p746wn.C13622a;
import p782xo.C13842a;
import tm.C13040c;

/* renamed from: vo.c */
/* loaded from: classes6.dex */
public class C13475c implements InterfaceC13474b {

    /* renamed from: b */
    public static final Gson f60695b = new Gson();

    /* renamed from: a */
    public String f60696a;

    public C13475c(String str) {
        this.f60696a = str;
    }

    @Override // p713vo.InterfaceC13474b
    /* renamed from: a */
    public PublicKeyResp mo684a() throws C9721b {
        try {
            return (PublicKeyResp) m81142f(m81148l(new PublicKeyReq()), PublicKeyResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("UserKeyService", "getPublicKey, json exception is: " + e10.toString());
            throw new C9721b(4107, "json err");
        }
    }

    @Override // p713vo.InterfaceC13474b
    /* renamed from: b */
    public UserKeyResp mo685b(int i10, String str, int i11, String str2, int i12, String str3) throws C9721b {
        try {
            return (UserKeyResp) m81142f(m81148l(new TrustCircleUserKeyReq(i10, str, str2, i12, str3)), UserKeyResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("UserKeyService", "getTrustCircleUserKey, json exception is: " + e10.toString());
            throw new C9721b(4107, "json err");
        }
    }

    @Override // p713vo.InterfaceC13474b
    /* renamed from: c */
    public UserKeyResp mo686c(int i10, String str, int i11, String str2, String str3) throws C9721b {
        try {
            return (UserKeyResp) m81142f(m81148l(new UserKeyReq(i10, str, str2, str3)), UserKeyResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("UserKeyService", "getUserKey, json exception is: " + e10.toString());
            throw new C9721b(4107, "json err");
        }
    }

    /* renamed from: d */
    public final String m81140d(byte[] bArr, byte[] bArr2) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null || bArr.length == 0) {
            C11839m.m70687e("UserKeyService", "key is empty");
            return "";
        }
        if (bArr2 == null || bArr2.length == 0) {
            C11839m.m70687e("UserKeyService", "data is empty");
            return "";
        }
        try {
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(2, privateKeyGeneratePrivate, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            byte[] bArrDoFinal = cipher.doFinal(bArr2);
            if (bArrDoFinal != null && bArrDoFinal.length != 0) {
                return new String(bArrDoFinal, StandardCharsets.UTF_8);
            }
            C11839m.m70687e("UserKeyService", "secretKey is empty");
            return "";
        } catch (Exception e10) {
            C11839m.m70687e("UserKeyService", "dealKey exception: " + e10.toString());
            return "";
        }
    }

    /* renamed from: e */
    public final String m81141e(QueryKeyResp queryKeyResp, KeyPair keyPair) {
        try {
            String strM81144h = m81144h(queryKeyResp);
            if (TextUtils.isEmpty(strM81144h)) {
                C11839m.m70687e("UserKeyService", "resp key is empty");
                return "";
            }
            String[] strArrSplit = strM81144h.split(":");
            if (strArrSplit.length == 0) {
                C11839m.m70687e("UserKeyService", "keyArray is empty");
                return "";
            }
            PrivateKey privateKey = keyPair.getPrivate();
            if (privateKey == null) {
                C11839m.m70687e("UserKeyService", "generatePrivateKey is null");
                return "";
            }
            byte[] encoded = privateKey.getEncoded();
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(m81140d(encoded, SafeBase64.decode(str, 2)));
                }
            }
            return sb2.toString();
        } catch (Exception e10) {
            C11839m.m70687e("UserKeyService", "dealKey exception: " + e10.toString());
            return "";
        }
    }

    /* renamed from: f */
    public final <T> T m81142f(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f60695b.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(4107, "json err " + str, "UserKeyService");
        }
    }

    /* renamed from: g */
    public final KeyPair m81143g() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(3072, C11908a.m71442a());
        return keyPairGenerator.generateKeyPair();
    }

    /* renamed from: h */
    public final String m81144h(QueryKeyResp queryKeyResp) {
        KeyInfo keyInfoM81145i = m81145i(queryKeyResp);
        return keyInfoM81145i == null ? "" : keyInfoM81145i.getKey();
    }

    /* renamed from: i */
    public final KeyInfo m81145i(QueryKeyResp queryKeyResp) {
        if (queryKeyResp == null) {
            C11839m.m70687e("UserKeyService", "queryKeyResp is null");
            return null;
        }
        KeyInfo keyInfo = queryKeyResp.getKeyInfo();
        if (keyInfo != null) {
            return keyInfo;
        }
        C11839m.m70687e("UserKeyService", "respKeyInfo is null");
        return null;
    }

    /* renamed from: j */
    public final String m81146j(QueryKeyResp queryKeyResp) {
        KeyInfo keyInfoM81145i = m81145i(queryKeyResp);
        return keyInfoM81145i == null ? "" : keyInfoM81145i.getKeySHA256();
    }

    /* renamed from: k */
    public final String m81147k() throws C9721b {
        return C13040c.m78609F().m78648g0();
    }

    /* renamed from: l */
    public final String m81148l(EncryptBaseReq encryptBaseReq) throws Throwable {
        String info = encryptBaseReq.getInfo();
        new CheckAppStatus().checkAllSendToFile();
        String str = this.f60696a;
        C11060c c11060cM66626a = C11058a.m66626a((str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.f60696a, info, C13452e.m80781L().m80971t0());
        try {
            return m81155s(info, encryptBaseReq.toString(), c11060cM66626a);
        } catch (C9721b e10) {
            C9721b c9721bM81156t = this.m81156t(info, e10);
            C11839m.m70687e("UserKeyService", "cmd=" + info + c9721bM81156t.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("108_");
            sb2.append(c9721bM81156t.m60659c());
            c11060cM66626a.m66665u(sb2.toString());
            c11060cM66626a.m66635A(e10.getMessage());
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            throw c9721bM81156t;
        }
    }

    /* renamed from: m */
    public final String m81149m(QueryKeyReq queryKeyReq) throws Throwable {
        String info = queryKeyReq.getInfo();
        new CheckAppStatus().checkAllSendToFile();
        String str = this.f60696a;
        C11060c c11060cM66626a = C11058a.m66626a((str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.f60696a, info, C13452e.m80781L().m80971t0());
        try {
            return m81155s(info, queryKeyReq.toString(), c11060cM66626a);
        } catch (C9721b e10) {
            C9721b c9721bM81156t = this.m81156t(info, e10);
            C11839m.m70687e("UserKeyService", "cmd=" + info + c9721bM81156t.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("122_");
            sb2.append(c9721bM81156t.m60659c());
            c11060cM66626a.m66665u(sb2.toString());
            c11060cM66626a.m66635A(e10.getMessage());
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            throw c9721bM81156t;
        }
    }

    /* renamed from: n */
    public final boolean m81150n(int i10, int i11, QueryKeyResp queryKeyResp, String str) {
        if (!TextUtils.isEmpty(str) && str.length() % 2 != 0) {
            String str2 = "server key length is error, length is: " + str.length() + ", dataType: " + i10 + ", keyType: " + i11;
            C11839m.m70687e("UserKeyService", str2);
            m81154r(str2, i10, i11);
        }
        String strM81146j = m81146j(queryKeyResp);
        if (TextUtils.isEmpty(strM81146j)) {
            return true;
        }
        C11839m.m70688i("UserKeyService", "keySHA256 not empty, dataType: " + i10 + ", keyType: " + i11);
        String strM1593f = C0227m.m1593f(str);
        if (TextUtils.isEmpty(strM1593f)) {
            C11839m.m70687e("UserKeyService", "calKeySHA256 is empty, dataType: " + i10 + ", keyType: " + i11);
            return true;
        }
        if (strM1593f.equals(strM81146j)) {
            C11839m.m70688i("UserKeyService", "keySHA256 equal, dataType: " + i10 + ", keyType: " + i11);
            return true;
        }
        String str3 = "server keySHA256 not equal, dataType: " + i10 + ", keyType: " + i11;
        m81154r(str3, i10, i11);
        C11839m.m70687e("UserKeyService", str3);
        return false;
    }

    /* renamed from: o */
    public final String m81151o(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("UserKey", str);
        } catch (C13194k e10) {
            C11839m.m70687e("UserKeyService", "onAccessToken: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("UserKeyService", "onAccessToken: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: p */
    public final QueryKeyResp m81152p(int i10, int i11, String str) throws C9721b {
        C9720a.m60653b(str, "publicKey is empty");
        try {
            return (QueryKeyResp) m81142f(m81149m(new QueryKeyReq(9, "QueryKeyReq", i10, i11, str)), QueryKeyResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("UserKeyService", "queryKey, json exception is: " + e10.toString());
            throw new C9721b(4107, "json err");
        }
    }

    /* renamed from: q */
    public String m81153q(int i10, int i11) {
        if (!C13842a.m83010i().m83025c()) {
            C11839m.m70688i("UserKeyService", "query key fail within 30s, dataType: " + i10 + ", keyType: " + i11);
            return "";
        }
        try {
            KeyPair keyPairM81143g = m81143g();
            PublicKey publicKey = keyPairM81143g.getPublic();
            if (publicKey == null) {
                C11839m.m70687e("UserKeyService", "generatePublicKey is null");
                return "";
            }
            byte[] encoded = publicKey.getEncoded();
            if (encoded != null && encoded.length != 0) {
                QueryKeyResp queryKeyRespM81152p = m81152p(i10, i11, SafeBase64.encodeToString(encoded, 2));
                C13842a.m83010i().m83026d();
                String strM81141e = m81141e(queryKeyRespM81152p, keyPairM81143g);
                return !m81150n(i10, i11, queryKeyRespM81152p, strM81141e) ? "" : strM81141e;
            }
            C11839m.m70687e("UserKeyService", "encodePublicKey is empty");
            return "";
        } catch (Exception e10) {
            C11839m.m70687e("UserKeyService", "queryKey exception: " + e10.toString() + ", dataType: " + i10 + ", keyType: " + i11);
            C13842a.m83010i().m83020J();
            return "";
        }
    }

    /* renamed from: r */
    public void m81154r(String str, int i10, int i11) {
        C11060c c11060cM66626a = C11058a.m66626a(this.f60696a, "QueryKeyReq", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reportInfo", str);
        linkedHashMap.put("dataType", String.valueOf(i10));
        linkedHashMap.put("keyType", String.valueOf(i11));
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f6, code lost:
    
        throw new fk.C9721b(4101, r11 + "response is null", r11);
     */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m81155s(java.lang.String r11, java.lang.String r12, p429kk.C11060c r13) throws fk.C9721b {
        /*
            r10 = this;
            java.lang.String r0 = "user key error, result="
            java.lang.String r1 = "UserKeyService"
            java.lang.String r2 = r10.m81147k()
            r3 = 0
        L9:
            java.lang.String r4 = r10.m81151o(r11)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r5.<init>()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r5.append(r2)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r6 = " "
            r5.append(r6)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r5.append(r11)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r6 = " x-hw-trace-id = "
            r5.append(r6)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r6 = r13.m66661q()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r5.append(r6)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            p514o9.C11839m.m70688i(r1, r5)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r5.<init>()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r6 = "user key request:"
            r5.append(r6)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r5.append(r12)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            p514o9.C11839m.m70686d(r1, r5)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            wo.a r5 = new wo.a     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r6 = r13.m66661q()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r5.<init>(r4, r11, r12, r6)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.Object r5 = ro.C12612a.m76107g(r2, r5, r13)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r6.<init>()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r7 = "user key response:"
            r6.append(r7)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r6.append(r5)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            p514o9.C11839m.m70686d(r1, r6)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            if (r5 == 0) goto Lde
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            if (r6 != 0) goto Lde
            java.lang.Class<com.huawei.hicloud.request.userk.bean.EncryptBaseResp> r6 = com.huawei.hicloud.request.userk.bean.EncryptBaseResp.class
            java.lang.Object r6 = r10.m81142f(r5, r6)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            com.huawei.hicloud.request.userk.bean.EncryptBaseResp r6 = (com.huawei.hicloud.request.userk.bean.EncryptBaseResp) r6     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            int r7 = r6.getResult()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            if (r7 == 0) goto Ldd
            r5 = 402(0x192, float:5.63E-43)
            r8 = 4107(0x100b, float:5.755E-42)
            if (r7 != r5) goto Lac
            java.lang.String r5 = " [AT OPERATION] user key error, need request new accessToken."
            p514o9.C11839m.m70689w(r1, r5)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            int r5 = r3 + 1
            r9 = 2
            if (r3 >= r9) goto La2
            xo.a r3 = p782xo.C13842a.m83010i()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r3.m83026d()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            uj.l r3 = p681uj.C13195l.m79272J()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r3.m79325o0(r4)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r3 = r5
            goto L9
        L9e:
            r10 = move-exception
            goto Lf7
        La0:
            r10 = move-exception
            goto L103
        La2:
            fk.b r10 = new fk.b     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r12 = r6.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r10.<init>(r8, r7, r12)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            throw r10     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
        Lac:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r10.<init>()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r10.append(r0)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r12 = r6.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r10.append(r12)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            p514o9.C11839m.m70687e(r1, r10)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            fk.b r10 = new fk.b     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r12.<init>()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r12.append(r0)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r13 = r6.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r12.append(r13)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r13 = "SyncUserProtocol"
            r10.<init>(r8, r12, r13)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            throw r10     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
        Ldd:
            return r5
        Lde:
            fk.b r10 = new fk.b     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r12.<init>()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r12.append(r11)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r13 = "response is null"
            r12.append(r13)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            r13 = 4101(0x1005, float:5.747E-42)
            r10.<init>(r13, r12, r11)     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
            throw r10     // Catch: java.lang.Exception -> L9e fk.C9721b -> La0
        Lf7:
            fk.b r12 = new fk.b
            r13 = 4000(0xfa0, float:5.605E-42)
            java.lang.String r10 = r10.getMessage()
            r12.<init>(r13, r10, r11)
            throw r12
        L103:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p713vo.C13475c.m81155s(java.lang.String, java.lang.String, kk.c):java.lang.String");
    }

    /* renamed from: t */
    public final C9721b m81156t(String str, C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c != 1102 && iM60659c != 1107 && iM60659c != 1199 && iM60659c != 1201) {
            if (iM60659c == 4000) {
                return new C9721b(4107, c9721b.m60663g(), c9721b.getMessage(), str);
            }
            if (iM60659c != 4101 && iM60659c != 4107) {
                if (iM60659c == 9005) {
                    return new C9721b(4105, c9721b.getMessage(), str);
                }
                switch (iM60659c) {
                    case ConnectionResult.NETWORK_ERROR /* 9000 */:
                        return new C9721b(4106, c9721b.m60663g(), c9721b.getMessage(), str);
                    case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                        return new C9721b(4102, c9721b.getMessage(), str);
                    case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                        return new C9721b(4103, c9721b.getMessage(), str);
                    case 9003:
                        return new C9721b(4104, c9721b.getMessage(), str);
                    default:
                        return new C9721b(4108, c9721b.getMessage(), str);
                }
            }
        }
        return c9721b;
    }
}
