package bf;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.secure.android.common.util.SafeBase64;
import eg.AbstractC9474c;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0224k0;
import p521og.C11870c;
import p521og.C11877j;
import p575qe.C12347f;
import p576qf.InterfaceC12348a;
import p616rk.C12515a;
import p709vj.C13452e;
import p783xp.AbstractC13844b;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;
import ug.C13171a;

/* renamed from: bf.a */
/* loaded from: classes4.dex */
public class C1175a {

    /* renamed from: a */
    public static volatile String f5565a = "";

    /* renamed from: b */
    public static String f5566b;

    /* renamed from: bf.a$a */
    public class a extends AbstractC9474c {

        /* renamed from: a */
        public final /* synthetic */ Context f5567a;

        /* renamed from: b */
        public final /* synthetic */ int f5568b;

        /* renamed from: c */
        public final /* synthetic */ String f5569c;

        public a(Context context, int i10, String str) {
            this.f5567a = context;
            this.f5568b = i10;
            this.f5569c = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            int iM71212I = C11877j.m71212I(this.f5567a);
            int i10 = this.f5568b;
            if (i10 != 0 && i10 == iM71212I) {
                C13981a.m83989i("AntiTheftDataManager", "read data from Anti same size");
                return;
            }
            new C12797b().m76784j(this.f5567a, "AntiTheftDataManager", "001_1003", this.f5569c + ";last read data size:" + iM71212I, null, "01011", null, "readTaData", true);
            C11877j.m71223N0(this.f5567a, this.f5568b);
        }
    }

    /* renamed from: bf.a$b */
    public class b extends AbstractC9474c {

        /* renamed from: a */
        public final /* synthetic */ String f5570a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC12348a f5571b;

        public b(String str, InterfaceC12348a interfaceC12348a) {
            this.f5570a = str;
            this.f5571b = interfaceC12348a;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            int iM7399u = C1175a.m7399u(this.f5570a);
            if (iM7399u > 0) {
                InterfaceC12348a interfaceC12348a = this.f5571b;
                if (interfaceC12348a != null) {
                    interfaceC12348a.onResult(true);
                    return;
                }
                return;
            }
            new C12797b().m76784j(C12347f.m74285n().m74301m(), "AntiTheftDataManager", "001_1004", "async write anti data fail, return value " + iM7399u, null, "01011", null, "taWriteError", true);
            InterfaceC12348a interfaceC12348a2 = this.f5571b;
            if (interfaceC12348a2 != null) {
                interfaceC12348a2.onResult(!C13171a.m79197c());
            }
        }
    }

    /* renamed from: bf.a$c */
    public class c extends AbstractC9474c {

        /* renamed from: a */
        public final /* synthetic */ String f5572a;

        /* renamed from: b */
        public final /* synthetic */ String f5573b;

        /* renamed from: c */
        public final /* synthetic */ String f5574c;

        /* renamed from: d */
        public final /* synthetic */ String f5575d;

        /* renamed from: e */
        public final /* synthetic */ String f5576e;

        /* renamed from: f */
        public final /* synthetic */ InterfaceC12348a f5577f;

        public c(String str, String str2, String str3, String str4, String str5, InterfaceC12348a interfaceC12348a) {
            this.f5572a = str;
            this.f5573b = str2;
            this.f5574c = str3;
            this.f5575d = str4;
            this.f5576e = str5;
            this.f5577f = interfaceC12348a;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            String str;
            C12796a c12796a = new C12796a();
            String str2 = "success";
            int iIntValue = -1;
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    Class<?> cls = Class.forName("com.huawei.android.os.TokenBuffer");
                    Object objNewInstance = cls.newInstance();
                    C13981a.m83989i("AntiTheftDataManager", "tokenBufferInstance");
                    cls.getDeclaredMethod("setSocid", String.class).invoke(objNewInstance, this.f5572a);
                    cls.getDeclaredMethod("setUid", String.class).invoke(objNewInstance, this.f5573b);
                    cls.getDeclaredMethod("setVersion", String.class).invoke(objNewInstance, this.f5574c);
                    cls.getDeclaredMethod("setStatus", String.class).invoke(objNewInstance, this.f5575d);
                    cls.getDeclaredMethod("setSignature", String.class).invoke(objNewInstance, this.f5576e);
                    C13981a.m83989i("AntiTheftDataManager", "create tokenBuffer success");
                    iIntValue = ((Integer) Class.forName("com.huawei.android.os.AntiTheftManagerEx").getDeclaredMethod("saveToken", cls).invoke(null, objNewInstance)).intValue();
                    str2 = "save token result:" + iIntValue + ",retry time:" + i10;
                    C13981a.m83989i("AntiTheftDataManager", str2);
                } catch (ClassNotFoundException e10) {
                    str = "save token ClassNotFoundException: " + e10.toString();
                    C13981a.m83988e("AntiTheftDataManager", str);
                } catch (Exception e11) {
                    str2 = "save token Exception: " + e11.toString();
                    C13981a.m83988e("AntiTheftDataManager", str2);
                }
                if (iIntValue == 0) {
                    break;
                }
                C13981a.m83989i("AntiTheftDataManager", "write token time:" + i10);
            }
            str = str2;
            InterfaceC12348a interfaceC12348a = this.f5577f;
            if (interfaceC12348a != null) {
                interfaceC12348a.onResult(iIntValue == 0);
            }
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3018", str, "01072", "01072", null, "setActiveToken", null);
        }
    }

    /* renamed from: b */
    public static void m7380b(Context context, String str, int i10) {
        C12515a.m75110o().m75175e(new a(context, i10, str), false);
    }

    /* renamed from: c */
    public static boolean m7381c(AccountInfo accountInfo) {
        try {
            if (accountInfo == null) {
                C13981a.m83989i("AntiTheftDataManager", "accountInfo null");
                return false;
            }
            if (TextUtils.isEmpty(accountInfo.getUserID())) {
                C13981a.m83989i("AntiTheftDataManager", "accountInfo.u-id is empty");
                return false;
            }
            if (!TextUtils.isEmpty(accountInfo.getDeviceID())) {
                return true;
            }
            C13981a.m83989i("AntiTheftDataManager", "accountInfo.dev-Id is empty");
            return false;
        } catch (Exception e10) {
            C13981a.m83988e("AntiTheftDataManager", "checkAccountInfo exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m7382d(String str) {
        try {
            return m7381c((AccountInfo) new Gson().fromJson(str, AccountInfo.class));
        } catch (Exception e10) {
            C13981a.m83988e("AntiTheftDataManager", "checkAccountInfo exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: e */
    public static void m7383e(Context context) {
        C13981a.m83989i("AntiTheftDataManager", "clean all data");
        if (!C13171a.m79199e()) {
            C11877j.m71251b(context);
        } else if (C0224k0.m1532B(context)) {
            if (C13171a.m79203i() == -1) {
                C13981a.m83988e("AntiTheftDataManager", "wipe ta failed");
            }
            f5565a = "";
            C11877j.m71251b(context);
        }
    }

    /* renamed from: f */
    public static void m7384f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        C12796a c12796a = new C12796a();
        try {
            Class.forName("com.huawei.android.os.AntiTheftManagerEx").getMethod("deleteAntiTheftAuthenticationKey", Integer.TYPE).invoke(null, 3);
            str = "success";
        } catch (Exception e10) {
            BaseLogger.m28732e("AntiTheftDataManager", "AntiTheftManagerEx deleteAntiTheftAuthenticationKey failed", e10.getMessage());
            str = "exception," + e10.toString();
        }
        c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3015", "deleteAntiTheftAuthenticationKey:" + str, "01067", "01067", null, "deleteAntiTheftAuthenticationKey", null);
    }

    /* renamed from: g */
    public static boolean m7385g(boolean z10) {
        C13981a.m83989i("AntiTheftDataManager", "start getAuthFlag");
        try {
            String str = (String) Class.forName("com.huawei.android.os.AntiTheftManagerEx").getMethod("getAuthFlag", new Class[0]).invoke(null, new Object[0]);
            if (TextUtils.isEmpty(str)) {
                C13981a.m83990w("AntiTheftDataManager", "getAuthFlag is empty");
                return false;
            }
            String strM83105a = AbstractC13844b.m83105a(SafeBase64.decode(str, 0));
            if (!TextUtils.isEmpty(strM83105a)) {
                return strM83105a.startsWith("a5a55a5a");
            }
            C13981a.m83990w("AntiTheftDataManager", "getAuthFlag flag byte is empty");
            return false;
        } catch (Exception e10) {
            BaseLogger.m28732e("AntiTheftDataManager", "AntiTheftManagerEx getAuthFlag failed", e10.getMessage());
            C12796a c12796a = new C12796a();
            String str2 = z10 ? "01011" : "01012";
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3009", "getAuthFlag exception:" + e10.toString(), str2, str2, null, "getAuthFlag", null);
            return true;
        }
    }

    /* renamed from: h */
    public static byte[] m7386h() {
        C12796a c12796a = new C12796a();
        try {
            byte[] bArr = (byte[]) Class.forName("com.huawei.android.os.AntiTheftManagerEx").getMethod("getAntiTheftConfig", new Class[0]).invoke(null, new Object[0]);
            if (bArr != null && bArr.length >= 2) {
                return bArr;
            }
            C13981a.m83989i("AntiTheftDataManager", "getConfig, config length less 2");
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3012", "getAntiTheftConfig fail:configs.length < 2", "01064", "01064", null, "getAntiTheftConfig", null);
            return new byte[0];
        } catch (Exception e10) {
            BaseLogger.m28732e("AntiTheftDataManager", "AntiTheftManagerEx getConfig failed", e10.getMessage());
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3012", "getAntiTheftConfig exception:" + e10.toString(), "01064", "01064", null, "getAntiTheftConfig", null);
            return null;
        }
    }

    /* renamed from: i */
    public static String m7387i() {
        C12796a c12796a = new C12796a();
        try {
            String str = (String) Class.forName("com.huawei.android.os.AntiTheftManagerEx").getMethod("getFactoryVersion", new Class[0]).invoke(null, new Object[0]);
            if (TextUtils.isEmpty(str)) {
                C13981a.m83990w("AntiTheftDataManager", "getFactoryVersion returned empty bytes");
                c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3014", "getFactoryVersion failed: version is empty", "01066", "01066", null, "getFactoryVersion", null);
                return "";
            }
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3014", "getFactoryVersion success:" + str, "01066", "01066", null, "getFactoryVersion", null);
            return str;
        } catch (Exception e10) {
            BaseLogger.m28732e("AntiTheftDataManager", "AntiTheftManagerEx getFactoryVersion failed", e10.getMessage());
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3014", "getFactoryVersion failed:" + e10.toString(), "01066", "01066", null, "getFactoryVersion", null);
            return null;
        }
    }

    /* renamed from: j */
    public static String m7388j() {
        if (m7385g(true)) {
            C13981a.m83989i("AntiTheftDataManager", "has auth flag, not report publicKey");
            return "v1";
        }
        JSONArray jSONArrayM7393o = m7393o();
        if (jSONArrayM7393o == null || jSONArrayM7393o.length() == 0) {
            C13981a.m83989i("AntiTheftDataManager", "socid null, not report publicKey");
            return "v1";
        }
        byte[] bArrM7386h = m7386h();
        if (bArrM7386h == null || bArrM7386h.length < 2) {
            C13981a.m83989i("AntiTheftDataManager", "configs null, not report publicKey");
            return InterfaceC5323b.f24693t;
        }
        if (bArrM7386h[0] > 2) {
            return InterfaceC5323b.f24694u;
        }
        C13981a.m83989i("AntiTheftDataManager", "rom version not supported");
        return InterfaceC5323b.f24693t;
    }

    /* renamed from: k */
    public static boolean m7389k(Context context) {
        if (context != null) {
            return C13171a.m79199e() ? C13171a.m79195a() : "com.huawei.android.ds".equals(context.getPackageName()) ? C11877j.m71302s(context) : C11877j.m71302s(context);
        }
        C13981a.m83988e("AntiTheftDataManager", "getPhoneFinderSwitch null context");
        return false;
    }

    /* renamed from: l */
    public static boolean m7390l(Context context, String str) {
        if (context == null) {
            C13981a.m83988e("AntiTheftDataManager", "getPhoneFinderSwitch null context");
            return false;
        }
        if (!C13171a.m79199e()) {
            return C11877j.m71302s(context);
        }
        boolean zM79195a = C13171a.m79195a();
        if (zM79195a && C13452e.m80781L().m80842P0()) {
            String userID = AbstractC12139d.m72766e(context).getUserID();
            if (!TextUtils.isEmpty(str) && !str.equals(userID)) {
                C13981a.m83990w("AntiTheftDataManager", "uid not match");
                return false;
            }
        }
        return zM79195a;
    }

    /* renamed from: m */
    public static byte[] m7391m() {
        C12796a c12796a = new C12796a();
        try {
            C13981a.m83989i("AntiTheftDataManager", "getPublicKey");
            byte[] bArr = (byte[]) Class.forName("com.huawei.android.os.AntiTheftManagerEx").getMethod("getAntiTheftAuthenticationPublicKey", new Class[0]).invoke(null, new Object[0]);
            if (bArr != null && bArr.length != 0) {
                return bArr;
            }
            C13981a.m83990w("AntiTheftDataManager", "getPublicKey returned empty bytes");
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3013", "getPublicKey failed: pk is null or empty", "01065", "01065", null, "getPublicKey", null);
            return new byte[0];
        } catch (Exception e10) {
            BaseLogger.m28732e("AntiTheftDataManager", "AntiTheftManagerEx getPublicKey failed", e10.getMessage());
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3013", "getPublicKey exception:" + e10.toString(), "01065", "01065", null, "getPublicKey", null);
            return null;
        }
    }

    /* renamed from: n */
    public static String m7392n() {
        return f5566b;
    }

    /* renamed from: o */
    public static JSONArray m7393o() {
        C13981a.m83989i("AntiTheftDataManager", "start getSocId");
        JSONArray jSONArray = new JSONArray();
        C12796a c12796a = new C12796a();
        try {
            String[] strArr = (String[]) Class.forName("com.huawei.android.os.AntiTheftManagerEx").getMethod("getSocCerts", new Class[0]).invoke(null, new Object[0]);
            if (strArr == null) {
                C13981a.m83988e("AntiTheftDataManager", "AntiTheftManagerEx getSocCerts invalid");
                c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3016", "getSocId is null:", "01068", "01068", null, "getSocId", null);
                return jSONArray;
            }
            for (String str : strArr) {
                jSONArray.put(str);
            }
            return jSONArray;
        } catch (Exception e10) {
            BaseLogger.m28732e("AntiTheftDataManager", "AntiTheftManagerEx getSocCerts failed", e10.getMessage());
            c12796a.m76773f(C12347f.m74285n().m74301m(), "001_3016", "getSocId is Exception:" + e10.toString(), "01068", "01068", null, "getSocId", null);
            return null;
        }
    }

    /* renamed from: p */
    public static String m7394p() {
        C13981a.m83989i("AntiTheftDataManager", "get socIdOrigin");
        String strM83105a = "";
        try {
            byte[] bArr = (byte[]) Class.forName("com.huawei.android.os.AntiTheftManagerEx").getMethod("getSocId", new Class[0]).invoke(null, new Object[0]);
            if (bArr == null || bArr.length == 0) {
                C13981a.m83988e("AntiTheftDataManager", "AntiTheftManagerEx getSocIdOrigin null");
            } else {
                strM83105a = AbstractC13844b.m83105a(bArr);
                if (!TextUtils.isEmpty(strM83105a)) {
                    strM83105a = strM83105a.toUpperCase(Locale.US);
                }
            }
        } catch (Exception e10) {
            BaseLogger.m28732e("AntiTheftDataManager", "AntiTheftManagerEx getSocIdOrigin failed", e10.getMessage());
        }
        if (!C11870c.m71157e(strM83105a)) {
            new C12796a().m76773f(C0213f.m1377a(), "001_3016", "getSocIdOrigin is null", "01075", "01075", null, "getSocIdOrigin", null);
        }
        return strM83105a;
    }

    /* renamed from: q */
    public static boolean m7395q(Context context, String str) {
        if (!C13171a.m79199e() || !C13171a.m79195a()) {
            return false;
        }
        String userID = AbstractC12139d.m72766e(context).getUserID();
        if (TextUtils.isEmpty(str)) {
            C13981a.m83989i("AntiTheftDataManager", "cloudUserId is empty");
            return false;
        }
        if (str.equals(userID)) {
            C13981a.m83987d("AntiTheftDataManager", "switchState is valid");
            return false;
        }
        C13981a.m83990w("AntiTheftDataManager", "uid not match");
        return true;
    }

    /* renamed from: r */
    public static String m7396r(Context context) {
        String str;
        String str2;
        C13981a.m83989i("AntiTheftDataManager", "read data from Anti begin");
        if (!TextUtils.isEmpty(f5565a) && m7382d(f5565a)) {
            C13981a.m83989i("AntiTheftDataManager", "read data from dataStringForWrite cache");
            return f5565a;
        }
        byte[] bArrM79200f = C13171a.m79200f();
        if (bArrM79200f != null) {
            try {
                str = new String(bArrM79200f, StandardCharsets.UTF_8);
            } catch (UnsupportedCharsetException e10) {
                C13981a.m83988e("AntiTheftDataManager", "read data from Anti UnsupportedEncodingException:" + e10.getMessage());
                String str3 = "read data exception:" + e10.getMessage();
                f5566b = str3;
                m7380b(context, str3, 0);
            }
        } else {
            str = "";
        }
        if (bArrM79200f == null) {
            str2 = "read data from Anti theft is null";
        } else {
            str2 = "read data from Anti size:" + bArrM79200f.length;
        }
        f5566b = str2;
        m7380b(context, str2, bArrM79200f != null ? bArrM79200f.length : 0);
        C13981a.m83989i("AntiTheftDataManager", "read data from Anti theft:" + f5566b);
        return str;
    }

    /* renamed from: s */
    public static void m7397s(JSONObject jSONObject, InterfaceC12348a interfaceC12348a) {
        C13981a.m83989i("AntiTheftDataManager", "save lock credential");
        String strM26237h = C4347e.m26237h(jSONObject, "socId");
        String strM26237h2 = C4347e.m26237h(jSONObject, "uid");
        String strM26237h3 = C4347e.m26237h(jSONObject, "status");
        C12515a.m75110o().m75175e(new c(strM26237h, strM26237h2, C4347e.m26237h(jSONObject, "version"), strM26237h3, C4347e.m26237h(jSONObject, "signature"), interfaceC12348a), false);
    }

    /* renamed from: t */
    public static void m7398t(boolean z10, Context context) {
        C13981a.m83989i("AntiTheftDataManager", "set find my phone Switch to: " + z10);
        if (C13171a.m79199e()) {
            C13171a.m79202h(z10);
            C13981a.m83989i("AntiTheftDataManager", "setPhoneFinderSwitch clearUISwitchToFile");
            C11877j.a.m71321a(context);
        } else if ("com.huawei.android.ds".equals(context.getPackageName())) {
            C13981a.m83989i("AntiTheftDataManager", "setPhoneFinderSwitch writeHisyncSwitchToFile");
            C11877j.a.m71322b(z10, context);
        } else {
            C13981a.m83989i("AntiTheftDataManager", "setPhoneFinderSwitch writeSwitchToFile");
            C11877j.a.m71323c(z10, context);
        }
        C11877j.m71271h1(context, z10);
    }

    /* renamed from: u */
    public static int m7399u(String str) {
        int iM79204j;
        C13981a.m83989i("AntiTheftDataManager", "write data to Anti theft");
        try {
            iM79204j = C13171a.m79204j(str.getBytes(StandardCharsets.UTF_8));
        } catch (UnsupportedCharsetException e10) {
            C13981a.m83988e("AntiTheftDataManager", "write data to Anti UnsupportedEncodingException:" + e10.getMessage());
            iM79204j = 0;
        }
        C13981a.m83989i("AntiTheftDataManager", "write data to Anti return code =" + iM79204j);
        return iM79204j;
    }

    /* renamed from: v */
    public static void m7400v(String str, InterfaceC12348a interfaceC12348a) {
        C13981a.m83989i("AntiTheftDataManager", "write data to Anti async begin.");
        f5565a = str;
        C12515a.m75110o().m75175e(new b(str, interfaceC12348a), false);
    }
}
