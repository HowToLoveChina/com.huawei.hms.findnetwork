package com.huawei.hicloud.report.uba;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11060c;
import p459lp.C11326d;
import p527on.C11976a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p781xn.C13837a;
import p781xn.C13838b;
import p781xn.C13839c;
import p781xn.C13840d;
import p781xn.C13841e;
import tm.C13040c;
import vn.C13470b;

/* loaded from: classes6.dex */
public class UBAAnalyze {

    /* renamed from: f */
    public static long f22775f;

    /* renamed from: g */
    public static long f22776g;

    /* renamed from: t */
    public static long f22789t;

    /* renamed from: a */
    public NetWorkChangeReceiver f22791a;

    /* renamed from: b */
    public OMConfigUpdateReceiver f22792b;

    /* renamed from: c */
    public static final UBAAnalyze f22772c = new UBAAnalyze();

    /* renamed from: d */
    public static int f22773d = 0;

    /* renamed from: e */
    public static long f22774e = 0;

    /* renamed from: h */
    public static List<String> f22777h = new ArrayList();

    /* renamed from: i */
    public static List<String> f22778i = new ArrayList();

    /* renamed from: j */
    public static List<String> f22779j = new ArrayList();

    /* renamed from: k */
    public static Map<String, String> f22780k = new HashMap();

    /* renamed from: l */
    public static int f22781l = 50;

    /* renamed from: m */
    public static long f22782m = 60;

    /* renamed from: n */
    public static long f22783n = 3600;

    /* renamed from: o */
    public static long f22784o = 259200;

    /* renamed from: p */
    public static boolean f22785p = true;

    /* renamed from: q */
    public static int f22786q = 500;

    /* renamed from: r */
    public static long f22787r = 0;

    /* renamed from: s */
    public static int f22788s = 0;

    /* renamed from: u */
    public static ArrayList<String> f22790u = new ArrayList<>();

    public static class NetWorkChangeReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws JSONException {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction()) && C0209d.m1333z1(context)) {
                AbstractC10896a.m65885d("UBAAnalyze", "NetWorkConnect");
                UBAAnalyze.m29942C();
            }
        }
    }

    public static class OMConfigUpdateReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws JSONException {
            if (intent == null) {
                AbstractC10896a.m65886e("UBAAnalyze", "in OMConfigUpdateReceiver, intent is null");
                return;
            }
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p != null) {
                UBAAnalyze.m29993o0(hiCloudSysParamMapM60757p);
            }
        }
    }

    /* renamed from: com.huawei.hicloud.report.uba.UBAAnalyze$b */
    public static class C4979b extends AbstractC12367d {

        /* renamed from: a */
        public JSONObject f22793a;

        /* renamed from: b */
        public String f22794b;

        /* renamed from: c */
        public String f22795c;

        public C4979b(JSONObject jSONObject, String str, String str2) {
            this.f22793a = jSONObject;
            this.f22794b = str;
            this.f22795c = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            JSONObject jSONObject;
            JSONObject jSONObject2 = this.f22793a;
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = jSONObject2.getJSONArray(Event.EventConstants.EVENTS);
                    if (jSONArray != null && jSONArray.length() != 0) {
                        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                            if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject(Constants.MULTIPLE_SIGN)) != null) {
                                String string = jSONObject.getString("u");
                                if (!TextUtils.isEmpty(string)) {
                                    Iterator it = UBAAnalyze.f22790u.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            String str = (String) it.next();
                                            if (string.equals(str)) {
                                                UBAAnalyze.m29986k0(str, this.f22795c);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return;
                } catch (Exception e10) {
                    AbstractC10896a.m65886e("UBAAnalyze", "checkConcernedEventXU exception: " + e10.toString());
                }
            }
            if (TextUtils.isEmpty(this.f22794b)) {
                return;
            }
            try {
                Iterator it2 = UBAAnalyze.f22790u.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    if (this.f22794b.equals(str2)) {
                        UBAAnalyze.m29986k0(str2, this.f22795c);
                        return;
                    }
                }
            } catch (Exception e11) {
                AbstractC10896a.m65886e("UBAAnalyze", "checkConcernedEventXU exception: " + e11.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.STOCK_ACTIVE_CLICK_OPEN;
        }
    }

    /* renamed from: com.huawei.hicloud.report.uba.UBAAnalyze$c */
    public static class C4980c extends SQLiteOpenHelper {
        public C4980c(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
            super(context, str, cursorFactory, i10);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS uba (No INTEGER PRIMARY KEY,e TEXT NOT NULL,t BIGINT NOT NULL,q INTEGER NOT NULL,v INTEGER NOT NULL,u TEXT NOT NULL,tp TEXT,chl TEXT,ex TEXT," + VideoPlayFlag.PLAY_IN_ALL + " TEXT,d INTEGER);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            AbstractC10896a.m65887i("UBAAnalyze", "Upgrading database from version " + i10 + " to " + i11);
        }
    }

    /* renamed from: com.huawei.hicloud.report.uba.UBAAnalyze$d */
    public static class C4981d {

        /* renamed from: a */
        public C11060c f22796a;

        public /* synthetic */ C4981d(C4978a c4978a) {
            this();
        }

        /* renamed from: a */
        public final void m30009a() {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07018"), "07018", C13452e.m80781L().m80971t0());
            this.f22796a = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }

        /* renamed from: b */
        public void m30010b(Map<String, String> map) {
            try {
                C13622a.m81969o(C0213f.m1377a(), this.f22796a, map);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAFailInfoReporter", "UBAFailInfo report exception:" + e10.toString());
            }
        }

        public C4981d() {
            m30009a();
        }
    }

    /* renamed from: A */
    public static boolean m29940A(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return "deviceid".equals(lowerCase) || C6148x2.DEVICE_ID.equals(lowerCase) || "device-id".equals(lowerCase);
    }

    /* renamed from: B */
    public static boolean m29941B(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return "userid".equals(lowerCase) || "user_id".equals(lowerCase) || "user-id".equals(lowerCase) || "uid".equals(lowerCase);
    }

    /* renamed from: C */
    public static void m29942C() throws JSONException {
        if (!m30006z()) {
            AbstractC10896a.m65885d("UBAAnalyze", "country code not cn");
            return;
        }
        m30005y();
        if (!f22785p) {
            AbstractC10896a.m65885d("UBAAnalyze", "UBARepFlag is false");
        } else {
            C12515a.m75110o().m75175e(new C13841e(), false);
        }
    }

    /* renamed from: D */
    public static void m29943D(String str, String str2) {
        if (m29974e(str, str2)) {
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", new LinkedHashMap(), 0, 0), false);
        }
    }

    /* renamed from: E */
    public static void m29944E(String str, String str2, int i10) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("operationType", String.valueOf(i10));
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: F */
    public static void m29945F(String str, String str2, String str3, String str4) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("key", str3);
            linkedHashMap.put("value", str4);
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: G */
    public static void m29946G(String str, String str2, String str3, String str4, String str5) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("key", str3);
            linkedHashMap.put("value", str4);
            linkedHashMap.put("gradeCode", str5);
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: H */
    public static void m29947H(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        if (m29974e(str, str2)) {
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: I */
    public static void m29948I(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        if (m29974e(str, str2)) {
            linkedHashMap.put("anonymous_report", "anonymous_report");
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: J */
    public static void m29949J(String str, String str2, String str3, String str4) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(str3, str4);
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: K */
    public static void m29950K(String str, String str2, String str3, String str4) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("value", str3);
            linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
            linkedHashMap.put("phone_type", Build.MODEL);
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: L */
    public static void m29951L(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("value", str3);
            linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
            linkedHashMap.put("phone_type", Build.MODEL);
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap.put("salChannel", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap.put("srcChannel", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                linkedHashMap.put("activityCode", str7);
            }
            if (TextUtils.isEmpty(str8)) {
                linkedHashMap.put("pkg_name", str8);
            }
            C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: M */
    public static void m29952M(String str, String str2, JSONObject jSONObject) {
        if (m29974e(str, str2) && jSONObject != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        linkedHashMap.put(next, jSONObject.getString(next));
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    return;
                }
                C12515a.m75110o().m75175e(new C13841e(str, str2, "", "", linkedHashMap, 0, 0), false);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAAnalyze", "onEventWithJson error occur: " + e10.getMessage());
            }
        }
    }

    /* renamed from: N */
    public static void m29953N(String str, long j10, String str2, String str3, String str4, LinkedHashMap<String, String> linkedHashMap) {
        if (m29974e(str, str2)) {
            C12515a.m75110o().m75175e(new C13841e(str, j10, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: O */
    public static void m29954O(String str, String str2, String str3, String str4) {
        if (m29974e(str, str2)) {
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, new LinkedHashMap(), 0, 0), false);
        }
    }

    /* renamed from: P */
    public static void m29955P(String str, String str2, String str3, String str4, int i10) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("operationType", String.valueOf(i10));
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: Q */
    public static void m29956Q(String str, String str2, String str3, String str4, String str5) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("gradeCode", str5);
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: R */
    public static void m29957R(String str, String str2, String str3, String str4, String str5, String str6) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(str5, str6);
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: S */
    public static void m29958S(String str, String str2, String str3, String str4, LinkedHashMap<String, String> linkedHashMap) {
        if (m29974e(str, str2)) {
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: T */
    public static void m29959T(String str, String str2, String str3, String str4, String str5, String str6) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("value", str5);
            linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str6);
            linkedHashMap.put("phone_type", Build.MODEL);
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: U */
    public static void m29960U(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("value", str5);
            linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str6);
            linkedHashMap.put("phone_type", Build.MODEL);
            linkedHashMap.put("gradeCode", str7);
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: V */
    public static void m29961V(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("value", str5);
            linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str6);
            linkedHashMap.put("salChannel", str7);
            linkedHashMap.put("srcChannel", str8);
            linkedHashMap.put("activityCode", str9);
            linkedHashMap.put("phone_type", Build.MODEL);
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: W */
    public static void m29962W(String str, String str2, String str3, String str4, String str5, String str6, boolean z10, int i10) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("value", str5);
            linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str6);
            linkedHashMap.put("phone_type", Build.MODEL);
            linkedHashMap.put("isAutoOpen", C13222a.m79466h(z10));
            linkedHashMap.put("sourceType", C13222a.m79467i(i10));
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: X */
    public static void m29963X(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (m29974e(str, str2) && jSONObject != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        linkedHashMap.put(next, jSONObject.getString(next));
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    return;
                }
                C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAAnalyze", "onPageEventWithJson error occur: " + e10.getMessage());
            }
        }
    }

    /* renamed from: Y */
    public static void m29964Y(String str, String str2, String str3, String str4, int i10) {
        if (m29974e(str, str2)) {
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, new LinkedHashMap(), 2, i10), false);
        }
    }

    /* renamed from: Z */
    public static void m29965Z(String str, String str2, String str3, String str4, String str5, String str6, int i10) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap.put("type", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str6);
            }
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 2, i10), false);
        }
    }

    /* renamed from: a0 */
    public static void m29967a0(String str, String str2, String str3, String str4) {
        if (m29974e(str, str2)) {
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, new LinkedHashMap(), 1, 0), false);
        }
    }

    /* renamed from: b0 */
    public static void m29969b0(String str, String str2, String str3, String str4, String str5, String str6) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap.put("type", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str6);
            }
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 1, 0), false);
        }
    }

    /* renamed from: c0 */
    public static void m29971c0(String str, String str2, String str3, String str4, String str5, String str6) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap.put("type", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap.put("status", str6);
            }
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: d */
    public static void m29972d() throws InterruptedException {
        int iNextInt = new Random().nextInt(120);
        AbstractC10896a.m65887i("UBAAnalyze", "checkDelay delay: " + iNextInt);
        if (iNextInt > 0) {
            try {
                Thread.sleep(iNextInt * 1000);
            } catch (InterruptedException unused) {
                AbstractC10896a.m65886e("UBAAnalyze", "checkDelay InterruptedException");
            }
        }
    }

    /* renamed from: d0 */
    public static void m29973d0(String str, String str2, String str3, String str4, String str5, String str6, int i10) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap.put("type", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap.put("status", str6);
            }
            linkedHashMap.put("operationType", String.valueOf(i10));
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: e */
    public static boolean m29974e(String str, String str2) throws JSONException {
        if (!m30006z()) {
            AbstractC10896a.m65885d("UBAAnalyze", "country code not cn");
            return false;
        }
        m30005y();
        if (!f22785p) {
            AbstractC10896a.m65885d("UBAAnalyze", "UBARepFlag is false");
            return false;
        }
        if (!m29989m(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        AbstractC10896a.m65885d("UBAAnalyze", "eventXU is empty");
        return false;
    }

    /* renamed from: e0 */
    public static void m29975e0(String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap.put("type", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap.put("status", str6);
            }
            linkedHashMap.put("operationType", String.valueOf(i10));
            linkedHashMap.put("openingMode", String.valueOf(i11));
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: f */
    public static boolean m29976f() {
        if (C0209d.m1333z1(C0213f.m1377a())) {
            return f22774e >= ((long) f22786q) || System.currentTimeMillis() - f22776g >= f22783n * 1000;
        }
        return false;
    }

    /* renamed from: f0 */
    public static void m29977f0(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap.put("type", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap.put("status", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                linkedHashMap.put("gradeCode", str7);
            }
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap, 0, 0), false);
        }
    }

    /* renamed from: g */
    public static boolean m29978g() {
        return f22773d >= f22781l || System.currentTimeMillis() - f22775f >= f22782m * 1000;
    }

    /* renamed from: g0 */
    public static void m29979g0(String str, String str2, String str3, String str4, String str5, String str6, LinkedHashMap linkedHashMap) {
        if (m29974e(str, str2)) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (!TextUtils.isEmpty(str5)) {
                linkedHashMap2.put("type", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                linkedHashMap2.put("status", str6);
            }
            if (linkedHashMap != null) {
                linkedHashMap2.putAll(linkedHashMap);
            }
            C12515a.m75110o().m75175e(new C13841e(str, str2, str3, str4, linkedHashMap2, 0, 0), false);
        }
    }

    /* renamed from: h */
    public static void m29980h(String str, String str2) {
        ArrayList<String> arrayList;
        if (TextUtils.isEmpty(str) || (arrayList = f22790u) == null || arrayList.size() == 0) {
            return;
        }
        C12515a.m75110o().m75175e(new C4979b(null, str, str2), false);
    }

    /* renamed from: h0 */
    public static boolean m29981h0(int i10, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("code")) {
                AbstractC10896a.m65886e("UBAAnalyze", "not contain RESPONSE_CODE_STR");
            } else {
                String string = jSONObject.getString("code");
                if (string.equals("10000001")) {
                    AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, illegal parameter");
                    f22780k.put("RESPONSE_CODE", "400 10000001");
                } else {
                    if (string.equals("10000010")) {
                        AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, authentication failed");
                        f22780k.put("RESPONSE_CODE", "400 10000010");
                        return true;
                    }
                    if (string.equals("10000011")) {
                        AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, body is empty");
                        f22780k.put("RESPONSE_CODE", "400 10000011");
                    } else if (string.equals("10000014")) {
                        AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, body content is empty");
                        f22780k.put("RESPONSE_CODE", "400 10000014");
                    } else {
                        if (string.equals("13010006")) {
                            AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, Content is illegal (too large)");
                            f22780k.put("RESPONSE_CODE", "400 13010006");
                            return true;
                        }
                        if (string.equals("13010007")) {
                            AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, some parameters in the body are illegal");
                            f22780k.put("RESPONSE_CODE", "400 13010007");
                        } else {
                            AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, responseCode is 400, body code undefined: " + string);
                            f22780k.put("RESPONSE_CODE", "400 " + string);
                        }
                    }
                }
            }
            if (jSONObject.isNull("failList")) {
                AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, all events report fail");
                return false;
            }
            String string2 = jSONObject.getString("failList");
            AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, some events report fail: " + string2);
            f22780k.put("fail body", string2);
            return false;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UBAAnalyze", "in processResponseCode400, Exception error: " + e10.toString());
            f22780k.put("Exception", e10.toString());
            return false;
        }
    }

    /* renamed from: i */
    public static void m29982i(JSONObject jSONObject, String str) {
        ArrayList<String> arrayList;
        if (jSONObject == null || (arrayList = f22790u) == null || arrayList.size() == 0) {
            return;
        }
        C12515a.m75110o().m75175e(new C4979b(jSONObject, "", str), false);
    }

    /* renamed from: i0 */
    public static void m29983i0() {
        long j10 = f22787r;
        if (j10 < AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL) {
            f22787r = j10 + 1800000;
        }
        AbstractC10896a.m65885d("UBAAnalyze", "ubaReportFailPeriod: " + f22787r);
        if (!f22780k.containsKey("fail body")) {
            f22780k.put("fail body", "all events");
        }
        new C4981d().m30010b(f22780k);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x009e A[ORIG_RETURN, RETURN] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m29984j() throws java.lang.Throwable {
        /*
            java.lang.String r0 = "in checkCurrentCacheNum, Exception error: "
            java.lang.String r1 = "UBAAnalyze"
            android.content.Context r2 = p015ak.C0213f.m1378b()
            r3 = 0
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r5.<init>()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r5.append(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.lang.String r2 = "/uba_cache.log"
            r5.append(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r2 != 0) goto L35
            java.lang.String r2 = "in checkCurrentCacheNum, uba cache file not exist"
            p399jk.AbstractC10896a.m65885d(r1, r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            return r3
        L30:
            r2 = move-exception
            goto La0
        L33:
            r2 = move-exception
            goto L77
        L35:
            java.io.LineNumberReader r2 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r6.<init>(r7, r5)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
        L46:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L73
            if (r4 == 0) goto L4d
            goto L46
        L4d:
            int r4 = r2.getLineNumber()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L73
            com.huawei.hicloud.report.uba.UBAAnalyze.f22773d = r4     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L73
            r2.close()     // Catch: java.lang.Exception -> L57
            goto L9a
        L57:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L5d:
            r4.append(r0)
            java.lang.String r0 = r2.toString()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            p399jk.AbstractC10896a.m65886e(r1, r0)
            goto L9a
        L6f:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto La0
        L73:
            r4 = move-exception
            r8 = r4
            r4 = r2
            r2 = r8
        L77:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r5.<init>()     // Catch: java.lang.Throwable -> L30
            r5.append(r0)     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L30
            r5.append(r2)     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L30
            p399jk.AbstractC10896a.m65886e(r1, r2)     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L9a
            r4.close()     // Catch: java.lang.Exception -> L93
            goto L9a
        L93:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L5d
        L9a:
            int r0 = com.huawei.hicloud.report.uba.UBAAnalyze.f22773d
            if (r0 <= 0) goto L9f
            r3 = 1
        L9f:
            return r3
        La0:
            if (r4 == 0) goto Lbd
            r4.close()     // Catch: java.lang.Exception -> La6
            goto Lbd
        La6:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r3.toString()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            p399jk.AbstractC10896a.m65886e(r1, r0)
        Lbd:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.report.uba.UBAAnalyze.m29984j():boolean");
    }

    /* renamed from: k */
    public static boolean m29985k() {
        SQLiteDatabase readableDatabase = null;
        C4980c c4980c = new C4980c(C0213f.m1378b(), "uba.db", null, 1);
        try {
            try {
                readableDatabase = c4980c.getReadableDatabase();
                f22774e = DatabaseUtils.queryNumEntries(readableDatabase, "uba");
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAAnalyze", "in checkCurrentDataBaseNum, Exception error: " + e10.toString());
                if (readableDatabase != null) {
                }
            }
            return f22774e > 0;
        } finally {
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            c4980c.close();
        }
    }

    /* renamed from: k0 */
    public static void m29986k0(String str, String str2) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07050"), "07050", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key", str);
        linkedHashMap.put("msg", str2);
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: l */
    public static boolean m29987l() {
        AbstractC10896a.m65885d("UBAAnalyze", "checkReportFailTime, lastReportTime: " + f22776g + ", ubaReportFailPeriod: " + f22787r);
        return System.currentTimeMillis() - f22776g > f22787r;
    }

    /* renamed from: l0 */
    public static void m29988l0() throws Throwable {
        LinkedHashMap<String, JSONObject> linkedHashMapM30002v = m30002v();
        if (linkedHashMapM30002v == null || linkedHashMapM30002v.isEmpty()) {
            AbstractC10896a.m65885d("UBAAnalyze", "in reportData, jsonObject is null");
            return;
        }
        if (C11326d.m68054p()) {
            AbstractC10896a.m65887i("UBAAnalyze", "reportData, need delay");
            m29972d();
        }
        AbstractC10896a.m65887i("UBAAnalyze", "reportData key_non_anonymous");
        JSONObject jSONObject = linkedHashMapM30002v.get("key_non_anonymous");
        if (jSONObject != null) {
            m29998r(new C13839c(jSONObject), false, jSONObject);
        }
        AbstractC10896a.m65887i("UBAAnalyze", "reportData key_anonymous");
        JSONObject jSONObject2 = linkedHashMapM30002v.get("key_anonymous");
        if (jSONObject2 != null) {
            m29998r(new C13837a(jSONObject2), true, jSONObject2);
        }
    }

    /* renamed from: m */
    public static boolean m29989m(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65885d("UBAAnalyze", "eventE is empty");
            return false;
        }
        boolean zM81126b = C13470b.m81125a().m81126b();
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        if (zM62221H1 && zM81126b) {
            return true;
        }
        AbstractC10896a.m65885d("UBAAnalyze", "isHiCloudDataAnalyzeOn: " + zM81126b + ", isAgreedHiCloudTerms: " + zM62221H1);
        return false;
    }

    /* renamed from: n */
    public static void m29990n() {
        AbstractC10896a.m65885d("UBAAnalyze", "cleanCache");
        try {
            File file = new File(C0213f.m1378b().getFilesDir() + "/uba_cache.log");
            if (file.exists()) {
                if (!file.delete()) {
                    AbstractC10896a.m65886e("UBAAnalyze", "in cleanCache, delete cache file error");
                } else if (file.createNewFile()) {
                    f22773d = 0;
                } else {
                    AbstractC10896a.m65886e("UBAAnalyze", "in cleanCache, create cache file error");
                    f22773d = 0;
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UBAAnalyze", "in cleanCache, Exception error: " + e10.toString());
        }
    }

    /* renamed from: n0 */
    public static void m29991n0(String str, String str2) {
        f22780k.put(str, str2);
    }

    /* renamed from: o */
    public static void m29992o(List list) {
        AbstractC10896a.m65885d("UBAAnalyze", "cleanDataBase");
        SQLiteDatabase writableDatabase = null;
        C4980c c4980c = new C4980c(C0213f.m1378b(), "uba.db", null, 1);
        try {
            try {
                writableDatabase = c4980c.getWritableDatabase();
                for (int i10 = 0; i10 < list.size(); i10++) {
                    writableDatabase.execSQL("DELETE FROM uba WHERE No=" + list.get(i10));
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAAnalyze", "cleanDataBase error: " + e10.toString());
                f22774e = DatabaseUtils.queryNumEntries(writableDatabase, "uba");
                if (writableDatabase != null) {
                }
            }
        } finally {
            f22774e = DatabaseUtils.queryNumEntries(writableDatabase, "uba");
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            c4980c.close();
        }
    }

    /* renamed from: o0 */
    public static void m29993o0(HiCloudSysParamMap hiCloudSysParamMap) throws JSONException {
        f22781l = hiCloudSysParamMap.getUBACacheSum();
        f22782m = hiCloudSysParamMap.getUBACacheTime();
        f22783n = hiCloudSysParamMap.getUBARepPeriod();
        f22784o = hiCloudSysParamMap.getUBARepOutdatetime();
        f22785p = hiCloudSysParamMap.getUBARepFlag();
        f22786q = hiCloudSysParamMap.getUBARepMaxNum();
        String ubaConcernedKeyList = hiCloudSysParamMap.getUbaConcernedKeyList();
        if (!TextUtils.isEmpty(ubaConcernedKeyList)) {
            try {
                JSONArray jSONArray = new JSONArray(ubaConcernedKeyList);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    String string = jSONArray.getString(i10);
                    if (!TextUtils.isEmpty(string)) {
                        f22790u.add(string);
                    }
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAAnalyze", "ifConcernedUbaListEmpty exception: " + e10.toString());
            }
        }
        AbstractC10896a.m65885d("UBAAnalyze", "get config from file, UBACacheSum: " + f22781l + ", UBACacheTime: " + f22782m + ", UBARepPeriod: " + f22783n + ", UBARepOutdatetime: " + f22784o + ", UBARepFlag: " + f22785p + ", UBARepMaxNum: " + f22786q);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c5  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m29994p() throws java.lang.Throwable {
        /*
            java.lang.String r0 = "uba"
            android.content.Context r1 = p015ak.C0213f.m1378b()
            long r2 = com.huawei.hicloud.report.uba.UBAAnalyze.f22774e
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            java.lang.String r3 = "UBAAnalyze"
            if (r2 != 0) goto L16
            java.lang.String r0 = "in cleanExpiredData, currentDataBaseNum is 0"
            p399jk.AbstractC10896a.m65885d(r3, r0)
            return
        L16:
            java.util.List<java.lang.String> r2 = com.huawei.hicloud.report.uba.UBAAnalyze.f22779j
            r2.clear()
            com.huawei.hicloud.report.uba.UBAAnalyze$c r2 = new com.huawei.hicloud.report.uba.UBAAnalyze$c
            java.lang.String r4 = "uba.db"
            r5 = 1
            r6 = 0
            r2.<init>(r1, r4, r6, r5)
            android.database.sqlite.SQLiteDatabase r1 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L79
            java.lang.String r4 = "SELECT * FROM uba"
            android.database.Cursor r6 = r1.rawQuery(r4, r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
        L2e:
            boolean r4 = r6.moveToNext()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            if (r4 == 0) goto L66
            java.lang.String r4 = "t"
            int r4 = r6.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            long r4 = r6.getLong(r4)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            long r7 = r7 - r4
            long r4 = com.huawei.hicloud.report.uba.UBAAnalyze.f22784o     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            r9 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r9
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 <= 0) goto L2e
            java.util.List<java.lang.String> r4 = com.huawei.hicloud.report.uba.UBAAnalyze.f22779j     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            java.lang.String r5 = "No"
            int r5 = r6.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            java.lang.String r5 = r6.getString(r5)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            r4.add(r5)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L61
            goto L2e
        L5c:
            r3 = move-exception
            r11 = r6
            r6 = r1
            r1 = r11
            goto Lb8
        L61:
            r4 = move-exception
            r11 = r6
            r6 = r1
            r1 = r11
            goto L7b
        L66:
            long r4 = android.database.DatabaseUtils.queryNumEntries(r1, r0)
            com.huawei.hicloud.report.uba.UBAAnalyze.f22774e = r4
            r6.close()
            r1.close()
        L72:
            r2.close()
            goto La4
        L76:
            r3 = move-exception
            r1 = r6
            goto Lb8
        L79:
            r4 = move-exception
            r1 = r6
        L7b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb7
            r5.<init>()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r7 = "in cleanExpiredData, database error: "
            r5.append(r7)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lb7
            r5.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> Lb7
            p399jk.AbstractC10896a.m65886e(r3, r4)     // Catch: java.lang.Throwable -> Lb7
            long r4 = android.database.DatabaseUtils.queryNumEntries(r6, r0)
            com.huawei.hicloud.report.uba.UBAAnalyze.f22774e = r4
            if (r1 == 0) goto L9e
            r1.close()
        L9e:
            if (r6 == 0) goto L72
            r6.close()
            goto L72
        La4:
            java.util.List<java.lang.String> r0 = com.huawei.hicloud.report.uba.UBAAnalyze.f22779j
            int r0 = r0.size()
            if (r0 <= 0) goto Lb6
            java.lang.String r0 = "clean up outdated data"
            p399jk.AbstractC10896a.m65885d(r3, r0)
            java.util.List<java.lang.String> r0 = com.huawei.hicloud.report.uba.UBAAnalyze.f22779j
            m29992o(r0)
        Lb6:
            return
        Lb7:
            r3 = move-exception
        Lb8:
            long r4 = android.database.DatabaseUtils.queryNumEntries(r6, r0)
            com.huawei.hicloud.report.uba.UBAAnalyze.f22774e = r4
            if (r1 == 0) goto Lc3
            r1.close()
        Lc3:
            if (r6 == 0) goto Lc8
            r6.close()
        Lc8:
            r2.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.report.uba.UBAAnalyze.m29994p():void");
    }

    /* renamed from: p0 */
    public static void m29995p0(JSONObject jSONObject, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        StringBuilder sb2;
        JSONObject jSONObject2;
        OutputStreamWriter outputStreamWriter = null;
        try {
            File file = new File(C0213f.m1378b().getFilesDir() + "/uba_cache.log");
            if (file.exists()) {
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                AbstractC10896a.m65885d("UBAAnalyze", "in writeCache, uba cache file not exist");
                if (!file.createNewFile()) {
                    AbstractC10896a.m65886e("UBAAnalyze", "in writeCache, create cache file error");
                    return;
                }
                fileOutputStream = new FileOutputStream(file);
            }
            try {
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
                    try {
                        outputStreamWriter2.write(jSONObject.toString());
                        outputStreamWriter2.write(System.lineSeparator());
                        if (f22773d == Integer.MAX_VALUE) {
                            f22773d = 0;
                        }
                        f22773d++;
                        m29980h(str, "writeCache");
                        if (C1443a.f6214b.booleanValue()) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                            JSONObject jSONObject4 = jSONObject3.getJSONObject(Constants.MULTIPLE_SIGN);
                            if (jSONObject4 != null && (jSONObject2 = jSONObject4.getJSONObject("ex")) != null) {
                                C13230i.m79518b1(jSONObject2);
                                jSONObject4.put("ex", jSONObject2);
                                jSONObject3.put(Constants.MULTIPLE_SIGN, jSONObject4);
                            }
                            AbstractC10896a.m65885d("UBAAnalyze", "writeCache: " + jSONObject3.toString());
                        }
                        try {
                            outputStreamWriter2.close();
                        } catch (Exception e10) {
                            AbstractC10896a.m65886e("UBAAnalyze", "in writeCache, Exception error: " + e10.toString());
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e11) {
                            e = e11;
                            sb2 = new StringBuilder();
                            sb2.append("in writeCache, fileOutputStream Exception error: ");
                            sb2.append(e.toString());
                            AbstractC10896a.m65886e("UBAAnalyze", sb2.toString());
                        }
                    } catch (Exception e12) {
                        e = e12;
                        outputStreamWriter = outputStreamWriter2;
                        AbstractC10896a.m65886e("UBAAnalyze", "in writeCache, Exception error: " + e.toString());
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception e13) {
                                AbstractC10896a.m65886e("UBAAnalyze", "in writeCache, Exception error: " + e13.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e14) {
                                e = e14;
                                sb2 = new StringBuilder();
                                sb2.append("in writeCache, fileOutputStream Exception error: ");
                                sb2.append(e.toString());
                                AbstractC10896a.m65886e("UBAAnalyze", sb2.toString());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception e15) {
                                AbstractC10896a.m65886e("UBAAnalyze", "in writeCache, Exception error: " + e15.toString());
                            }
                        }
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (Exception e16) {
                            AbstractC10896a.m65886e("UBAAnalyze", "in writeCache, fileOutputStream Exception error: " + e16.toString());
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: q */
    public static void m29996q() {
        f22787r = 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00e1 A[PHI: r6
  0x00e1: PHI (r6v8 android.database.sqlite.SQLiteDatabase) = 
  (r6v7 android.database.sqlite.SQLiteDatabase)
  (r6v9 android.database.sqlite.SQLiteDatabase)
  (r6v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:180:0x014c, B:149:0x00dc, B:150:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.BufferedReader] */
    /* renamed from: q0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m29997q0() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.report.uba.UBAAnalyze.m29997q0():void");
    }

    /* renamed from: r */
    public static void m29998r(C13838b c13838b, boolean z10, JSONObject jSONObject) {
        int i10 = 0;
        boolean z11 = false;
        while (true) {
            if (i10 >= 3) {
                break;
            }
            try {
                f22780k.clear();
                C11976a.m72085f(C13040c.m78609F().m78640c0(), c13838b, 0, null);
                AbstractC10896a.m65887i("UBAAnalyze", i10 + "th attempt to report, response success");
                z11 = true;
                if (z10) {
                    m29992o(f22778i);
                } else {
                    m29992o(f22777h);
                }
                m29982i(jSONObject, i10 + "th attempt to report, RESPONSE_CODE: 200");
                break;
            } catch (C9721b e10) {
                AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, Exception error: " + e10.toString());
                f22780k.put("Exception", e10.toString());
                int iM60663g = e10.m60663g();
                String message = e10.getMessage();
                m29982i(jSONObject, i10 + "th attempt to report, RESPONSE_CODE: " + iM60663g + ", RESPONSE_MESSAGE: " + message);
                if (iM60663g == 400) {
                    if (!m29981h0(i10, message)) {
                        if (z10) {
                            m29992o(f22778i);
                        } else {
                            m29992o(f22777h);
                        }
                    }
                } else if (iM60663g == 500) {
                    AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, unknown mistake");
                    f22780k.put("RESPONSE_CODE", String.valueOf(500));
                } else if (iM60663g == 503) {
                    AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, flow controlled");
                    f22780k.put("RESPONSE_CODE", String.valueOf(503));
                } else {
                    AbstractC10896a.m65886e("UBAAnalyze", i10 + "th attempt to report, responseCode undefined: " + iM60663g);
                    f22780k.put("RESPONSE_CODE", String.valueOf(iM60663g));
                }
                i10++;
            }
        }
        if (f22779j.size() > 0) {
            AbstractC10896a.m65885d("UBAAnalyze", "clean up outdated data");
            m29992o(f22779j);
        }
        if (z11) {
            f22787r = 0L;
        } else {
            m29983i0();
        }
        f22776g = System.currentTimeMillis();
        AbstractC10896a.m65885d("UBAAnalyze", "lastReportTime: " + f22776g);
    }

    /* renamed from: s */
    public static ContentValues m29999s(int i10, JSONObject jSONObject) throws JSONException {
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("No", Integer.valueOf(i10));
            contentValues.put("e", jSONObject.getString("e"));
            contentValues.put("t", Long.valueOf(jSONObject.getLong("t")));
            contentValues.put("q", Integer.valueOf(jSONObject.getInt("q")));
            contentValues.put("v", Integer.valueOf(jSONObject.getInt("v")));
            if (jSONObject.isNull(Constants.MULTIPLE_SIGN)) {
                contentValues.put("u", "");
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.MULTIPLE_SIGN);
                contentValues.put("u", jSONObject2.getString("u"));
                if (!jSONObject2.isNull("tp")) {
                    contentValues.put("tp", jSONObject2.getString("tp"));
                }
                if (!jSONObject2.isNull("chl")) {
                    contentValues.put("chl", jSONObject2.getString("chl"));
                }
                if (!jSONObject2.isNull("ex")) {
                    contentValues.put("ex", jSONObject2.getJSONObject("ex").toString());
                }
                if (!jSONObject2.isNull(VideoPlayFlag.PLAY_IN_ALL)) {
                    contentValues.put(VideoPlayFlag.PLAY_IN_ALL, jSONObject2.getString(VideoPlayFlag.PLAY_IN_ALL));
                }
                if (!jSONObject2.isNull("d")) {
                    contentValues.put("d", Integer.valueOf(jSONObject2.getInt("d")));
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UBAAnalyze", "in generateContentValues, Exception error: " + e10.toString());
        }
        return contentValues;
    }

    /* renamed from: t */
    public static LinkedHashMap<String, JSONObject> m30000t(C13840d c13840d) throws JSONException {
        LinkedHashMap<String, JSONObject> linkedHashMap = new LinkedHashMap<>();
        String strM82990a = c13840d.m82990a();
        long jM82992c = c13840d.m82992c();
        int iM82991b = c13840d.m82991b();
        int iM82993d = c13840d.m82993d();
        String strM82999j = c13840d.m82999j();
        String strM82998i = c13840d.m82998i();
        String strM82995f = c13840d.m82995f();
        JSONObject jSONObjectM82997h = c13840d.m82997h();
        String strM82994e = c13840d.m82994e();
        int iM82996g = c13840d.m82996g();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        boolean zHas = false;
        try {
            jSONObject.put("e", strM82990a);
            jSONObject.put("t", jM82992c);
            jSONObject.put("q", iM82991b);
            jSONObject.put("v", iM82993d);
            jSONObject2.put("u", strM82999j);
            if (strM82998i != null) {
                jSONObject2.put("tp", strM82998i);
            }
            if (strM82995f != null) {
                jSONObject2.put("chl", strM82995f);
            }
            if (jSONObjectM82997h != null) {
                zHas = jSONObjectM82997h.has("anonymous_report");
                jSONObject2.put("ex", jSONObjectM82997h);
            }
            if (jSONObjectM82997h != null && !zHas) {
                if (jSONObjectM82997h.has(C6148x2.DEVICE_ID)) {
                    jSONObjectM82997h.put(C6148x2.DEVICE_ID, C0209d.m1209S1(C13452e.m80781L().m80954p()));
                }
                if (jSONObjectM82997h.has("device-id")) {
                    jSONObjectM82997h.put("device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
                }
                if (jSONObjectM82997h.has("deviceId")) {
                    jSONObjectM82997h.put("deviceId", C0209d.m1209S1(C13452e.m80781L().m80954p()));
                }
                if (jSONObjectM82997h.has("deviceID")) {
                    jSONObjectM82997h.put("deviceID", C0209d.m1209S1(C13452e.m80781L().m80954p()));
                }
                if (jSONObjectM82997h.has("DEVICE-ID")) {
                    jSONObjectM82997h.put("DEVICE-ID", C0209d.m1209S1(C13452e.m80781L().m80954p()));
                }
                if (jSONObjectM82997h.has("DEVICE_ID")) {
                    jSONObjectM82997h.put("DEVICE_ID", C0209d.m1209S1(C13452e.m80781L().m80954p()));
                }
                if (jSONObjectM82997h.has("device_type")) {
                    jSONObjectM82997h.put("device_type", C0209d.m1209S1(C13452e.m80781L().m80970t()));
                }
                if (jSONObjectM82997h.has("device-type")) {
                    jSONObjectM82997h.put("device-type", C0209d.m1209S1(C13452e.m80781L().m80970t()));
                }
                if (jSONObjectM82997h.has(JsbMapKeyNames.H5_DEVICE_TYPE)) {
                    jSONObjectM82997h.put(JsbMapKeyNames.H5_DEVICE_TYPE, C0209d.m1209S1(C13452e.m80781L().m80970t()));
                }
                if (jSONObjectM82997h.has("DEVICE_TYPE")) {
                    jSONObjectM82997h.put("DEVICE_TYPE", C0209d.m1209S1(C13452e.m80781L().m80970t()));
                }
                if (jSONObjectM82997h.has("DEVICE-TYPE")) {
                    jSONObjectM82997h.put("DEVICE-TYPE", C0209d.m1209S1(C13452e.m80781L().m80970t()));
                }
                jSONObject2.put("ex", jSONObjectM82997h);
            }
            if (strM82994e != null) {
                jSONObject2.put(VideoPlayFlag.PLAY_IN_ALL, strM82994e);
            }
            if (iM82996g != 0) {
                jSONObject2.put("d", iM82996g);
            }
            jSONObject.put(Constants.MULTIPLE_SIGN, jSONObject2);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UBAAnalyze", "in generateDecryptJSONObject, Exception error: " + e10.toString());
            jSONObject = null;
        }
        if (jSONObject == null) {
            return linkedHashMap;
        }
        if (zHas) {
            linkedHashMap.put("key_anonymous", jSONObject);
            return linkedHashMap;
        }
        linkedHashMap.put("key_non_anonymous", jSONObject);
        return linkedHashMap;
    }

    /* renamed from: u */
    public static JSONObject m30001u(C13840d c13840d, boolean z10) throws JSONException {
        String strM82990a = c13840d.m82990a();
        int iM82991b = c13840d.m82991b();
        long jM82992c = c13840d.m82992c();
        int iM82993d = c13840d.m82993d();
        String strM82999j = c13840d.m82999j();
        String strM82995f = c13840d.m82995f();
        String strM82998i = c13840d.m82998i();
        String strM82994e = c13840d.m82994e();
        JSONObject jSONObjectM82997h = c13840d.m82997h();
        int iM82996g = c13840d.m82996g();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("e", strM82990a);
            jSONObject.put("t", jM82992c);
            jSONObject.put("q", iM82991b);
            jSONObject.put("v", iM82993d);
            jSONObject2.put("u", strM82999j);
            if (strM82998i != null) {
                jSONObject2.put("tp", strM82998i);
            }
            if (strM82995f != null) {
                jSONObject2.put("chl", strM82995f);
            }
            if (jSONObjectM82997h != null) {
                if (!z10) {
                    if (jSONObjectM82997h.has(C6148x2.DEVICE_ID)) {
                        jSONObjectM82997h.put(C6148x2.DEVICE_ID, "");
                    }
                    if (jSONObjectM82997h.has("device-id")) {
                        jSONObjectM82997h.put("device-id", "");
                    }
                    if (jSONObjectM82997h.has("deviceId")) {
                        jSONObjectM82997h.put("deviceId", "");
                    }
                    if (jSONObjectM82997h.has("deviceID")) {
                        jSONObjectM82997h.put("deviceID", "");
                    }
                    if (jSONObjectM82997h.has("DEVICE-ID")) {
                        jSONObjectM82997h.put("DEVICE-ID", "");
                    }
                    if (jSONObjectM82997h.has("DEVICE_ID")) {
                        jSONObjectM82997h.put("DEVICE_ID", "");
                    }
                    if (jSONObjectM82997h.has("device_type")) {
                        jSONObjectM82997h.put("device_type", "");
                    }
                    if (jSONObjectM82997h.has("device-type")) {
                        jSONObjectM82997h.put("device-type", "");
                    }
                    if (jSONObjectM82997h.has(JsbMapKeyNames.H5_DEVICE_TYPE)) {
                        jSONObjectM82997h.put(JsbMapKeyNames.H5_DEVICE_TYPE, "");
                    }
                    if (jSONObjectM82997h.has("DEVICE_TYPE")) {
                        jSONObjectM82997h.put("DEVICE_TYPE", "");
                    }
                    if (jSONObjectM82997h.has("DEVICE-TYPE")) {
                        jSONObjectM82997h.put("DEVICE-TYPE", "");
                    }
                }
                jSONObject2.put("ex", jSONObjectM82997h);
            }
            if (iM82996g != 0) {
                jSONObject2.put("d", iM82996g);
            }
            if (strM82994e != null) {
                jSONObject2.put(VideoPlayFlag.PLAY_IN_ALL, strM82994e);
            }
            jSONObject.put(Constants.MULTIPLE_SIGN, jSONObject2);
            return jSONObject;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UBAAnalyze", "in generateEncryptJSONObject, Exception error: " + e10.toString());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x019c  */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor, android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> m30002v() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.report.uba.UBAAnalyze.m30002v():java.util.LinkedHashMap");
    }

    /* renamed from: w */
    public static synchronized int m30003w() {
        int i10 = f22788s;
        if (i10 == 999999) {
            f22788s = 0;
            return 999999;
        }
        f22788s = i10 + 1;
        return i10;
    }

    /* renamed from: x */
    public static UBAAnalyze m30004x() {
        return f22772c;
    }

    /* renamed from: y */
    public static void m30005y() throws JSONException {
        if (System.currentTimeMillis() - f22789t >= C5863b6.g.f26453g) {
            f22789t = System.currentTimeMillis();
            AbstractC10896a.m65885d("UBAAnalyze", "lastGetConfigTime: " + f22789t);
            if (!C10028c.m62182c0().m62395t1("is_already_configed_NV4")) {
                AbstractC10896a.m65888w("UBAAnalyze", "no config");
                return;
            }
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p != null) {
                m29993o0(hiCloudSysParamMapM60757p);
            }
        }
    }

    /* renamed from: z */
    public static boolean m30006z() {
        return C13452e.m80781L().m80842P0() ? "CN".equals(C13452e.m80781L().m80942m()) : "CN".equals(C0209d.m1328y0(C0213f.m1377a()));
    }

    /* renamed from: j0 */
    public void m30007j0() {
        this.f22791a = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        C0213f.m1377a().registerReceiver(this.f22791a, intentFilter, "com.huawei.cg.permission.SERVICE", null);
    }

    /* renamed from: m0 */
    public void m30008m0() {
        this.f22792b = new OMConfigUpdateReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.intent.omconfigupdate");
        C13108a.m78878b(C0213f.m1377a()).m78880c(this.f22792b, intentFilter);
    }
}
