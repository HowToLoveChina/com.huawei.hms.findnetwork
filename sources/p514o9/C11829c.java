package p514o9;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hihonor.android.app.ActivityManagerEx;
import com.hihonor.android.os.SystemPropertiesEx;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.android.os.BuildEx;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HonorVersionInfo;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.bean.WebViewAllowBean;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.HiCloudWebViewPolicyManager;
import com.huawei.hicloud.notification.manager.LocalMsgProcessor;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4992a;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$plurals;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.RoundingMode;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import mu.C11526c;
import no.C11739b;
import okhttp3.HttpRequestBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0216g0;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0234s;
import p015ak.C0236u;
import p015ak.C0241z;
import p035bk.C1248a;
import p052cb.C1412i;
import p292fn.C9733f;
import p335hd.C10144g;
import p336he.C10159j;
import p364ib.C10465b;
import p422k9.C11019b;
import p429kk.C11058a;
import p429kk.C11060c;
import p449ld.C11271a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import p846zj.C14303a;
import pk.C12158a;
import ro.C12612a;
import sk.C12806c;
import tm.C13040c;
import to.C13049a;

/* renamed from: o9.c */
/* loaded from: classes3.dex */
public class C11829c {

    /* renamed from: a */
    public static final String f54755a = "HUAWEI" + Build.MODEL;

    /* renamed from: b */
    public static final boolean f54756b;

    /* renamed from: c */
    public static final Pattern f54757c;

    /* renamed from: d */
    public static volatile ThreadPoolExecutor f54758d;

    /* renamed from: e */
    public static final ReentrantLock f54759e;

    /* renamed from: f */
    public static boolean f54760f;

    /* renamed from: g */
    public static final CopyOnWriteArrayList<String> f54761g;

    /* renamed from: h */
    public static boolean f54762h;

    /* renamed from: i */
    public static int f54763i;

    /* renamed from: j */
    public static Date f54764j;

    /* renamed from: o9.c$a */
    public class a implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        public final /* synthetic */ Window f54765a;

        public a(Window window) {
            this.f54765a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70636z1(this.f54765a);
        }
    }

    /* renamed from: o9.c$b */
    public class b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        public final /* synthetic */ Window f54766a;

        public b(Window window) {
            this.f54766a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70636z1(this.f54766a);
        }
    }

    /* renamed from: o9.c$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f54767a;

        public c(String str) {
            this.f54767a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("extra_current_activity", this.f54767a);
            C13230i.m79504I().m79567R("event_click_back", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "event_click_back", "1", "100", linkedHashMapM79497A);
        }
    }

    static {
        f54756b = C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 14;
        f54757c = Pattern.compile("(\\d*)\\.[0][0] (\\w*)");
        f54759e = new ReentrantLock();
        f54760f = false;
        f54761g = new CopyOnWriteArrayList<>();
        f54762h = false;
        f54763i = 0;
    }

    /* renamed from: A */
    public static void m70498A() {
        try {
            m70603o1(C13040c.m78609F().m78659m(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getBackUpHost error " + e10.getMessage());
        }
    }

    /* renamed from: A0 */
    public static boolean m70499A0(Activity activity) {
        int iM1566u;
        return (activity == null || (iM1566u = C0224k0.m1566u(activity)) == -1 || iM1566u != 102) ? false : true;
    }

    /* renamed from: A1 */
    public static void m70500A1(Window window) {
        if (m70605p0()) {
            window.getDecorView().setSystemUiVisibility(4866);
        } else {
            window.getDecorView().setSystemUiVisibility(13058);
        }
    }

    /* renamed from: B */
    public static Bitmap m70501B(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CommonUtil", "getBitmapFromFile filePath is null");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        C1248a.m7473d(str, options);
        if (options.outHeight <= 0 || options.outWidth <= 0) {
            return null;
        }
        options.inJustDecodeBounds = false;
        return C1248a.m7473d(str, options);
    }

    /* renamed from: B0 */
    public static boolean m70502B0(Activity activity) {
        int iM1566u;
        if (activity == null || (iM1566u = C0224k0.m1566u(activity)) == -1) {
            return false;
        }
        return iM1566u == 100 || iM1566u == 101;
    }

    /* renamed from: B1 */
    public static void m70503B1(Window window) {
        if (window == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(2818);
    }

    /* renamed from: C */
    public static String m70504C(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (context == null) {
            C11839m.m70687e("CommonUtil", "getCallerPackageName, context is null.");
            return null;
        }
        try {
            Object objInvoke = ActivityManager.class.getMethod("getService", new Class[0]).invoke(null, new Object[0]);
            return context.getPackageManager().getPackagesForUid(((Integer) objInvoke.getClass().getMethod("getLaunchedFromUid", IBinder.class).invoke(objInvoke, (IBinder) Activity.class.getMethod("getActivityToken", new Class[0]).invoke(context, new Object[0]))).intValue())[0];
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getCallerPackageName occur err = " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: C0 */
    public static boolean m70505C0() {
        long jM85188d = C14303a.m85185a().m85188d();
        long jM85187c = C14303a.m85185a().m85187c();
        C11839m.m70688i("CommonUtil", "isInRange redPointCount: " + jM85187c + ", redPointUpdateTime: " + jM85188d);
        return jM85187c < 6 && System.currentTimeMillis() - jM85188d > 864000000;
    }

    /* renamed from: C1 */
    public static void m70506C1() {
        int i10 = f54763i - 1;
        f54763i = i10;
        if (i10 <= 0) {
            C13230i.m79504I().m79574U0("cloud_is_background", f54764j);
            C13230i.m79504I().m79581a0(0);
            C0216g0.m1402e(C0213f.m1377a()).m1404B();
        }
    }

    /* renamed from: D */
    public static void m70507D() {
        try {
            m70603o1(C13040c.m78609F().m78669v(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getCloudServiceAgreementUrl exception: " + e10.getMessage());
        }
    }

    /* renamed from: D0 */
    public static boolean m70508D0() {
        return C0209d.m1202Q0() && !C0209d.m1250e2(C0213f.m1377a()) && (C0209d.m1285n1() || C0209d.m1269j1()) && !C0236u.m1652c();
    }

    /* renamed from: D1 */
    public static boolean m70509D1() {
        return (!C0209d.m1202Q0() || C0209d.m1250e2(C0213f.m1377a()) || (!C0209d.m1285n1() && !C0209d.m1269j1()) || C0236u.m1652c() || (C13452e.m80781L().m80842P0() && C10028c.m62182c0().m62221H1() && C10028c.m62182c0().m62395t1("is_already_configed_NV4"))) ? false : true;
    }

    /* renamed from: E */
    public static void m70510E() {
        try {
            m70603o1(C13040c.m78609F().m78672y(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getConsumerHost exception: " + e10.getMessage());
        }
    }

    /* renamed from: E0 */
    public static boolean m70511E0(Context context) {
        return C11842p.m70868u(context) > 1;
    }

    /* renamed from: E1 */
    public static boolean m70512E1() {
        return C0209d.m1285n1() && m70509D1();
    }

    /* renamed from: F */
    public static DisplayMetrics m70513F(Context context) {
        if (context == null) {
            context = C0213f.m1377a();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: F0 */
    public static boolean m70514F0() {
        return f54762h;
    }

    /* renamed from: F1 */
    public static void m70515F1(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CommonUtil", "safeReportEvent eventID is illegal");
            return;
        }
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            C11839m.m70687e("CommonUtil", "safeReportEvent map is illegal");
            return;
        }
        try {
            C13230i.m79520c1(str, linkedHashMap, z10);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "safeReportEvent error: " + e10.toString());
        }
    }

    /* renamed from: G */
    public static String m70516G(long j10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        if (contextM1377a.getResources().getConfiguration().getLayoutDirection() != 1) {
            return m70625w(new Date(j10));
        }
        return "\u202b" + DateFormat.getDateFormat(contextM1377a).format(new Date(j10)) + ' ' + new SimpleDateFormat("HH:mm").format(new Date(j10)) + "\u202b";
    }

    /* renamed from: G0 */
    public static boolean m70517G0() {
        return m70573e1() && m70505C0();
    }

    /* renamed from: G1 */
    public static boolean m70518G1(byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(publicKeyGeneratePublic);
            signature.update(bArr);
            return signature.verify(bArr3);
        } catch (InvalidKeyException e10) {
            C11839m.m70687e("CommonUtil", "push error: " + e10.toString());
            return false;
        } catch (NoSuchAlgorithmException e11) {
            C11839m.m70687e("CommonUtil", "push error: " + e11.toString());
            return false;
        } catch (SignatureException e12) {
            C11839m.m70687e("CommonUtil", "push error: " + e12.toString());
            return false;
        } catch (InvalidKeySpecException e13) {
            C11839m.m70687e("CommonUtil", "push error: " + e13.toString());
            return false;
        }
    }

    /* renamed from: H */
    public static String m70519H(Date date, String str) {
        CharSequence charSequence = DateFormat.format(str, date);
        return charSequence instanceof String ? (String) charSequence : "";
    }

    /* renamed from: H0 */
    public static boolean m70520H0(String str) {
        return "pad".equals(str) || "tablet".equals(str);
    }

    /* renamed from: H1 */
    public static boolean m70521H1(byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Signature signature = Signature.getInstance("SHA256WithRSA/PSS");
            signature.initVerify(publicKeyGeneratePublic);
            signature.update(bArr);
            return signature.verify(bArr3);
        } catch (InvalidKeyException e10) {
            C11839m.m70687e("CommonUtil", "push error: " + e10.toString());
            return false;
        } catch (NoSuchAlgorithmException e11) {
            C11839m.m70687e("CommonUtil", "push error: " + e11.toString());
            return false;
        } catch (SignatureException e12) {
            C11839m.m70687e("CommonUtil", "push error: " + e12.toString());
            return false;
        } catch (InvalidKeySpecException e13) {
            C11839m.m70687e("CommonUtil", "push error: " + e13.toString());
            return false;
        }
    }

    /* renamed from: I */
    public static String m70522I(Context context, Intent intent) {
        String str;
        if (context != null && intent != null) {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities.size() == 0) {
                return "";
            }
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (str = activityInfo.packageName) != null) {
                    if (NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D.equals(str)) {
                        return NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D;
                    }
                    if (NextRestoreConstants.PKG_NAME_GALLERY_DATA.equals(str)) {
                        return NextRestoreConstants.PKG_NAME_GALLERY_DATA;
                    }
                }
            }
        }
        return "";
    }

    /* renamed from: I0 */
    public static boolean m70523I0(Context context) {
        if (context == null) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null && telephonyManager.isSmsCapable();
    }

    /* renamed from: I1 */
    public static int m70524I1(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            try {
                int iCompareTo = Integer.valueOf(strArrSplit[i10]).compareTo(Integer.valueOf(strArrSplit2[i10]));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            } catch (NumberFormatException e10) {
                C11839m.m70687e("CommonUtil", "compareVersion e = " + e10.toString() + " ,version1 = " + str + " ,version2 = " + str2);
                return strArrSplit[i10].compareTo(strArrSplit2[i10]);
            }
        }
        return strArrSplit.length - strArrSplit2.length;
    }

    /* renamed from: J */
    public static ArrayList<String> m70525J() throws JSONException {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70687e("CommonUtil", "checkHostBySysParam, hiCloudSysParamMap is null");
            return new ArrayList<>();
        }
        String webViewUrlHostAllowList = hiCloudSysParamMapM60757p.getWebViewUrlHostAllowList();
        if (TextUtils.isEmpty(webViewUrlHostAllowList)) {
            C11839m.m70687e("CommonUtil", "checkHostBySysParam, hostAllowList is null");
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(webViewUrlHostAllowList);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                }
            }
            return arrayList;
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "checkHostBySysParam catch exception: " + e10.toString());
            return new ArrayList<>();
        }
    }

    /* renamed from: J0 */
    public static boolean m70526J0() {
        if (!m70626w0()) {
            C11839m.m70688i("CommonUtil", "isFamilyShareMember familyShare function disable.");
            return false;
        }
        try {
            FamilyShareInfoResult familyShareInfoResult = (FamilyShareInfoResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78730c0(), FamilyShareInfoResult.class);
            if (familyShareInfoResult == null) {
                C11839m.m70688i("CommonUtil", "ifamilyShareInfoResult null");
                return false;
            }
            if (familyShareInfoResult.getSpaceShareEnable() != 1) {
                return false;
            }
            int spaceShareRole = familyShareInfoResult.getSpaceShareRole();
            return spaceShareRole == 2 || spaceShareRole == 1;
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "isFamilyShareMember error : " + e10.toString());
            return true;
        }
    }

    /* renamed from: K */
    public static ArrayList<String> m70527K() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = f54761g;
        if (!copyOnWriteArrayList.isEmpty()) {
            return new ArrayList<>(copyOnWriteArrayList);
        }
        m70539Q();
        m70541R();
        m70537P();
        m70545T();
        m70553X();
        m70498A();
        m70510E();
        m70507D();
        copyOnWriteArrayList.add("cloudDrive");
        return new ArrayList<>(copyOnWriteArrayList);
    }

    /* renamed from: K0 */
    public static boolean m70528K0() {
        return C10028c.m62182c0().m62395t1("funcfg_manage_storage");
    }

    /* renamed from: L */
    public static String[] m70529L() {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList<String> arrayListM70525J = m70525J();
            if (arrayListM70525J.size() > 0) {
                C11839m.m70688i("CommonUtil", "getHostWhiteList sysParamHost size = " + arrayListM70525J.size());
                arrayList.addAll(arrayListM70525J);
            }
            ArrayList<String> arrayListM70527K = m70527K();
            if (arrayListM70527K.size() > 0) {
                C11839m.m70688i("CommonUtil", "getHostWhiteList localHost size = " + arrayListM70527K.size());
                arrayList.addAll(arrayListM70527K);
            }
            C11839m.m70688i("CommonUtil", "getHostWhiteList all host size = " + arrayList.size());
            return arrayList.size() > 0 ? (String[]) arrayList.toArray(new String[arrayList.size()]) : new String[0];
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "catch exception: " + e10.toString());
            return new String[0];
        }
    }

    /* renamed from: L0 */
    public static boolean m70530L0() {
        return true;
    }

    /* renamed from: M */
    public static String m70531M(Object obj) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.getDefault());
        String strValueOf = String.valueOf(obj);
        try {
            return numberInstance.format(obj);
        } catch (Exception unused) {
            C11839m.m70687e("CommonUtil", "getLocaleFormatNum params invalid error");
            return strValueOf;
        }
    }

    /* renamed from: M0 */
    public static boolean m70532M0() {
        return C13452e.m80781L().m80803F0().booleanValue();
    }

    /* renamed from: N */
    public static String m70533N() {
        String strM80942m = C13452e.m80781L().m80942m();
        return TextUtils.isEmpty(strM80942m) ? "" : strM80942m.toLowerCase(Locale.US);
    }

    /* renamed from: N0 */
    public static boolean m70534N0(Context context, String str) {
        try {
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "isSupportHmsUnifyAgreement exception:" + e10.toString());
        }
        if (!"CN".equals(str)) {
            C11839m.m70688i("CommonUtil", "isSupportHmsUnifyAgreement, not china account");
            return false;
        }
        if (context == null) {
            C11839m.m70687e("CommonUtil", "isSupportHmsUnifyAgreement");
            return false;
        }
        Intent intent = new Intent("com.huawei.hwid.AgreeUpdate");
        C0209d.m1302r2(intent, "com.huawei.hwid");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    /* renamed from: O */
    public static String m70535O(String str) throws ParseException {
        String[] strArr = {"yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd HH:mm:ss"};
        Date date = null;
        for (int i10 = 0; i10 < 3; i10++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[i10], Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException e10) {
                C11839m.m70687e("CommonUtil", "getFormatTimeBySystem(String): " + e10.toString());
            }
            if (date != null) {
                return m70516G(date.getTime());
            }
        }
        return m70516G(new Date().getTime());
    }

    /* renamed from: O0 */
    public static boolean m70536O0() {
        boolean zM66400T = C11019b.m66371t().m66400T();
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe");
        C11839m.m70688i("CommonUtil", "moveToNext isSupportAntiTheft=" + zM66400T + ", isPhoneFinderEnable=" + zM62395t1);
        return zM66400T && zM62395t1;
    }

    /* renamed from: P */
    public static void m70537P() {
        try {
            m70603o1(C13040c.m78609F().m78620L(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getOpenSourceHost error " + e10.getMessage());
        }
    }

    /* renamed from: P0 */
    public static boolean m70538P0() {
        String strM80942m = C13452e.m80781L().m80942m();
        boolean zEqualsIgnoreCase = !TextUtils.isEmpty(strM80942m) ? "CN".equalsIgnoreCase(strM80942m) : false;
        boolean zM80795D0 = C13452e.m80781L().m80795D0();
        boolean zM1202Q0 = C0209d.m1202Q0();
        C11839m.m70688i("CommonUtil", "is support download app activities, is china user=" + zEqualsIgnoreCase + ", isChildAccount=" + zM80795D0 + ", is china device=" + zM1202Q0);
        return zEqualsIgnoreCase && zM1202Q0 && !zM80795D0;
    }

    /* renamed from: Q */
    public static void m70539Q() {
        try {
            m70603o1(C13040c.m78609F().m78621M(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getOperationHost error " + e10.getMessage());
        }
    }

    /* renamed from: Q0 */
    public static Boolean m70540Q0(String str) {
        return TextUtils.isEmpty(str) ? Boolean.FALSE : Boolean.valueOf(str.startsWith("4044"));
    }

    /* renamed from: R */
    public static void m70541R() {
        try {
            m70603o1(C13040c.m78609F().m78625Q(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getPortalHost error " + e10.getMessage());
        }
    }

    /* renamed from: R0 */
    public static boolean m70542R0(String str) {
        if (!m70540Q0(str).booleanValue() || "4044".equals(str)) {
            return false;
        }
        try {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length <= 1) {
                return false;
            }
            long jM1688f = C0241z.m1688f(strArrSplit[1]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            return jCurrentTimeMillis >= jM1688f && jCurrentTimeMillis - jM1688f <= C5863b6.g.f26453g;
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "isThumbnailNotExistInTime Exception:" + e10.toString());
            return true;
        }
    }

    /* renamed from: S */
    public static Intent m70543S(String str, String str2, boolean z10, RecommendCard recommendCard) {
        if (C0213f.m1377a() == null) {
            C11839m.m70687e("CommonUtil", "intent is null");
            return null;
        }
        Intent commonGotoIntentWithType = GeneralRedirectUtil.getCommonGotoIntentWithType(str, str2, z10, recommendCard);
        if (commonGotoIntentWithType == null) {
            return null;
        }
        if (NotifyConstants.TYPE_DEEPLINK.equals(str) || NotifyConstants.HICLOUD_KA.equals(str)) {
            commonGotoIntentWithType.putExtra(RecommendCardConstants.IS_FROM_RECOMMEND_CARD, true);
        }
        return commonGotoIntentWithType;
    }

    /* renamed from: S0 */
    public static boolean m70544S0(Uri uri) {
        if (uri == null || TextUtils.isEmpty(uri.toString())) {
            C11839m.m70687e("CommonUtil", "isValidExternalPath uri is empty");
            return false;
        }
        String lowerCase = uri.toString().toLowerCase(Locale.ROOT);
        if (!lowerCase.startsWith("file://") && !lowerCase.startsWith("content://")) {
            return true;
        }
        if (!lowerCase.contains("/data/data/com.huawei.hidisk") && !lowerCase.contains("/data/user/0/com.huawei.hidisk") && !lowerCase.contains("/data/user_de/0/com.huawei.hidisk")) {
            return true;
        }
        C11839m.m70687e("CommonUtil", "uri is not valid");
        return false;
    }

    /* renamed from: T */
    public static void m70545T() {
        try {
            m70603o1(C13040c.m78609F().m78626R(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getRoborttimHost error " + e10.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: T0 */
    public static boolean m70546T0(Context context) {
        if (context == null) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null && telephonyManager.isVoiceCapable();
    }

    /* renamed from: U */
    public static String m70547U(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(99)) == null) {
            return null;
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            String className = runningTaskInfo.topActivity.getClassName();
            if (runningTaskInfo.topActivity.getPackageName().equals("com.huawei.hidisk") && className.startsWith("com.huawei.android.clone.activity.receiver")) {
                return className;
            }
        }
        return "";
    }

    /* renamed from: U0 */
    public static void m70548U0(Context context, String str, String str2) {
        m70550V0(context, str, str2, false);
    }

    /* renamed from: V */
    public static int m70549V(Context context) {
        return m70513F(context).widthPixels;
    }

    /* renamed from: V0 */
    public static void m70550V0(Context context, String str, String str2, boolean z10) {
        if (str == null) {
            C11839m.m70687e("CommonUtil", "jumpToInstructions url null");
            return;
        }
        if (context == null) {
            C11839m.m70687e("CommonUtil", "context is null");
            return;
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, context.getPackageName());
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("is_support_orientation", true);
        intent.putExtra("is_orientation_unspecified", true);
        intent.putExtra("is_support_dark_mode", true);
        if (z10) {
            intent.putExtra("is_check_lang_case", true);
        }
        PackageManager packageManager = context.getPackageManager();
        if (intent.resolveActivity(packageManager) == null) {
            C11839m.m70688i("CommonUtil", "can not jump to findmyphone webview, jump to browser");
            intent = new HiCloudSafeIntent(new Intent());
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (intent.resolveActivity(packageManager) == null) {
                C11839m.m70688i("CommonUtil", "can not jump to browser");
                return;
            }
        }
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("CommonUtil", "startActivity exception");
        }
    }

    /* renamed from: W */
    public static String m70551W(long j10) {
        Context contextM1377a = C0213f.m1377a();
        return contextM1377a == null ? "" : contextM1377a.getResources().getString(R$string.iw_ltr_arab_escape, m70616t(contextM1377a, m70607q(j10)));
    }

    /* renamed from: W0 */
    public static void m70552W0(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || intent.resolveActivity(packageManager) == null) {
                return;
            }
            context.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "jump to link error, e = " + e10.getMessage());
        }
    }

    /* renamed from: X */
    public static void m70553X() {
        try {
            m70603o1(C13040c.m78609F().m78632X(), f54761g);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "getSmartbotHost error " + e10.getMessage());
        }
    }

    /* renamed from: X0 */
    public static void m70554X0(Context context, String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setAction(NotifyConstants.Action.HICLOUD_PURE_PAGE_WEBVIEW_ACTION);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            if (!(context instanceof Activity)) {
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            intent.putExtra("url", str2);
            intent.putExtra("title", str);
            intent.putExtra("isEnableJs", true);
            context.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "jumpToStaticWebView error, e = " + e10.getMessage());
        }
    }

    /* renamed from: Y */
    public static String m70555Y(Context context, long j10, boolean z10, DecimalFormat decimalFormat, boolean z11) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        float f10 = j10;
        int i10 = (z10 || !f54756b) ? 1024 : 1000;
        int i11 = R$string.hidisk_file_size_b;
        if (f10 > 900.0f) {
            i11 = R$string.hidisk_file_size_kb;
            f10 /= i10;
        }
        if (f10 > 900.0f) {
            f10 /= i10;
            i11 = R$string.hidisk_file_size_mb;
        }
        if (f10 > 900.0f) {
            f10 /= i10;
            i11 = R$string.hidisk_file_size_gb;
        }
        String strM70531M = decimalFormat.format(f10);
        try {
            strM70531M = m70531M(C0241z.m1683a(strM70531M, Double.valueOf(0.0d)));
        } catch (NumberFormatException unused) {
        }
        String strM70619u = m70619u(context.getString(i11, strM70531M));
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals("sw")) {
            strM70619u = "\u202b" + strM70619u + "\u202c";
        }
        if (z11 || !language.equalsIgnoreCase(Constants.URDU_LANG)) {
            return strM70619u;
        }
        return "\u200f\u200e" + strM70619u;
    }

    /* renamed from: Y0 */
    public static boolean m70556Y0(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            boolean zIsInMultiWindowMode = activity.isInMultiWindowMode();
            boolean zM70502B0 = m70502B0(activity);
            if (zIsInMultiWindowMode || zM70502B0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Z */
    public static String m70557Z(long j10, Calendar calendar, boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        boolean zIs24HourFormat = DateFormat.is24HourFormat(contextM1377a);
        calendar.setTimeInMillis(System.currentTimeMillis());
        long j11 = calendar.get(1);
        long j12 = calendar.get(2) + 1;
        long j13 = calendar.get(5);
        long j14 = calendar.get(11);
        long j15 = calendar.get(12);
        long j16 = calendar.get(13);
        calendar.add(5, -1);
        long j17 = calendar.get(5);
        long j18 = calendar.get(2) + 1;
        long j19 = calendar.get(1);
        calendar.setTimeInMillis(j10);
        long j20 = calendar.get(1);
        long j21 = calendar.get(2) + 1;
        long j22 = calendar.get(5);
        long j23 = calendar.get(11);
        long j24 = calendar.get(12);
        long j25 = calendar.get(13);
        boolean z11 = j19 == j20 && j18 == j21 && j17 == j22;
        long j26 = 60;
        long j27 = (j14 * j26) + j15;
        long j28 = (j23 * j26) + j24;
        long j29 = ((j27 * j26) + j16) - ((j28 * j26) + j25);
        if (j20 != j11 && !z11) {
            return m70628x(calendar.getTime());
        }
        if ((j21 != j12 || (j22 != j13 && j22 != j13 - 1)) && !z11) {
            return z10 ? m70613s(calendar.getTime()) : m70628x(calendar.getTime());
        }
        if (z11) {
            return contextM1377a.getResources().getString(R$string.yesterday);
        }
        if (j27 - j28 >= j26) {
            return zIs24HourFormat ? new SimpleDateFormat(contextM1377a.getResources().getString(R$string.time_format)).format(calendar.getTime()) : C10159j.m63337m(contextM1377a, calendar.getTime());
        }
        if (j29 < j26) {
            return contextM1377a.getResources().getString(R$string.just_now);
        }
        int i10 = (int) (j29 / j26);
        return contextM1377a.getResources().getQuantityString(R$plurals.mins_ago, i10, Integer.valueOf(i10));
    }

    /* renamed from: Z0 */
    public static void m70558Z0(Context context, HonorVersionInfo honorVersionInfo) {
        if (context == null || context.getResources() == null) {
            return;
        }
        m70586j();
        String string = UUID.randomUUID().toString();
        HonorVersionInfo.Info info = honorVersionInfo.getInfo();
        new LocalMsgProcessor().processLocalTextMessage(string, info.getTitle(), info.getDetail(), System.currentTimeMillis());
        C13452e.m80781L().m80923h2(string);
    }

    /* renamed from: a */
    public static void m70559a(HttpRequestBuilder.a aVar) {
        aVar.addHeader("x-hw-auth-version", "1");
    }

    /* renamed from: a0 */
    public static String m70560a0(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("CommonUtil", "checkUrlByWhiteList url is null ");
            return "";
        }
        String str2 = str.split("\\?")[0];
        String strM68805b = C11526c.m68805b(str2);
        if (!TextUtils.isEmpty(strM68805b)) {
            return strM68805b;
        }
        try {
            return new URI(str2).getHost();
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "checkUrlByWhiteList uri & url error " + e10.getMessage());
            return strM68805b;
        }
    }

    /* renamed from: a1 */
    public static void m70561a1() {
        m70564b1(C0213f.m1377a());
    }

    /* renamed from: b */
    public static void m70562b(StringBuilder sb2, String str) {
        if (sb2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        sb2.append(":");
        sb2.append(Uri.encode(str));
    }

    /* renamed from: b0 */
    public static boolean m70563b0(Context context) {
        return C12806c.m76815f(context);
    }

    /* renamed from: b1 */
    public static void m70564b1(Context context) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null || C13452e.m80781L().m80861U() != null) {
            return;
        }
        String strM1632j = C0234s.m1632j();
        C11839m.m70688i("CommonUtil", "notifyNewVersionUpgraded, current language = " + strM1632j);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07069"), "07069", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B("notifyNewVersionUpgraded");
        c11060cM66626a.m66665u("0");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("current_language", strM1632j);
        C13622a.m81969o(context, c11060cM66626a, linkedHashMapM79497A);
        String string = UUID.randomUUID().toString();
        new LocalMsgProcessor().processLocalTextMessage(string, resources.getString(R$string.new_version_upgraded_msg_title), resources.getString(R$string.new_version_upgraded_msg_content), System.currentTimeMillis());
        C13452e.m80781L().m80993y2(string);
    }

    /* renamed from: c */
    public static String m70565c(String str, String str2, String str3, String str4, String str5) {
        return str + ":" + str2 + ":" + str3 + ":" + str4 + ":" + Uri.encode(str5);
    }

    /* renamed from: c0 */
    public static byte[] m70566c0(String str) {
        if (str == null || str.isEmpty() || str.length() % 2 != 0) {
            throw new IllegalArgumentException("Illegal Argument in hex to bytes");
        }
        byte[] bArr = new byte[str.length() / 2];
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 2;
            bArr[i10 / 2] = (byte) C0241z.m1687e(str.substring(i10, i11), 16, 0);
            i10 = i11;
        }
        return bArr;
    }

    /* renamed from: c1 */
    public static void m70567c1() {
        if (C13452e.m80781L().m80869W() == null) {
            C12515a.m75110o().m75172d(new C10144g(UUID.randomUUID().toString()));
        }
    }

    /* renamed from: d */
    public static List<String> m70568d(List<Map<String, Object>> list, List<String> list2) {
        for (Map<String, Object> map : list) {
            String str = "/Hicloud/" + map.get("name") + "/media/recording";
            String str2 = "/Hicloud/" + map.get("name") + "/sysdata/notepad.db";
            String str3 = "/Hicloud/" + map.get("name") + "/sysdata/notepadRes.zip";
            String str4 = "/Hicloud/" + map.get("name") + "/sysdata/phonemanager.db";
            list2.add(str);
            list2.add(str2);
            list2.add(str3);
            list2.add(str4);
        }
        list2.add("/Sync/note");
        list2.add("/Sync/contact");
        return list2;
    }

    /* renamed from: d0 */
    public static void m70569d0(CommonDialogInterface commonDialogInterface) {
        Window window;
        View decorView;
        if (commonDialogInterface == null || (window = commonDialogInterface.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setOnSystemUiVisibilityChangeListener(new b(window));
    }

    /* renamed from: d1 */
    public static void m70570d1(Activity activity, int i10) {
        C11839m.m70688i("CommonUtil", "open permissionUIManager");
        try {
            if (activity == null) {
                C11839m.m70687e("CommonUtil", "open permissionUIManager context null");
                return;
            }
            Intent data = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", activity.getPackageName(), null));
            data.addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            activity.startActivityForResult(data, i10);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "open permissionUIManager err = " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public static String m70571e(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            throw new IllegalArgumentException("Illegal argument in bytes to hex");
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
                sb2.append(hexString);
            } else {
                sb2.append(hexString);
            }
        }
        return sb2.toString().toUpperCase(Locale.US);
    }

    /* renamed from: e0 */
    public static void m70572e0(Dialog dialog) {
        Window window;
        View decorView;
        if (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setOnSystemUiVisibilityChangeListener(new a(window));
    }

    /* renamed from: e1 */
    public static boolean m70573e1() {
        return (C0209d.m1202Q0() || C0209d.m1250e2(C0213f.m1377a())) ? false : true;
    }

    /* renamed from: f */
    public static boolean m70574f(Context context) throws PackageManager.NameNotFoundException {
        boolean z10 = false;
        if (context == null) {
            C11839m.m70689w("CommonUtil", "context is null");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(C13843a.m83090l(), 16384);
            if (packageInfo != null) {
                if (packageInfo.versionCode < 110301004) {
                    z10 = true;
                }
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
            C11839m.m70687e("CommonUtil", "checkAppMarketVersion exception." + e10.toString());
        }
        C11839m.m70686d("CommonUtil", "checkAppMarketVersion result:" + z10);
        return z10;
    }

    /* renamed from: f0 */
    public static void m70575f0() {
        if (f54763i <= 0) {
            f54764j = new Date();
        }
        f54763i++;
    }

    /* renamed from: f1 */
    public static Date m70576f1(String str, String str2) {
        try {
            return new SimpleDateFormat(str).parse(str2);
        } catch (ParseException e10) {
            C11839m.m70687e("CommonUtil", "formatTimeByPattern error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public static boolean m70577g(String str, String[] strArr) {
        C11839m.m70688i("CommonUtil", "enter checkUrlByWhiteList");
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("CommonUtil", "checkUrlByWhiteList url is null ");
            return false;
        }
        String str2 = str.split("\\?")[0];
        String strM68805b = C11526c.m68805b(str2);
        if (TextUtils.isEmpty(strM68805b)) {
            try {
                strM68805b = new URI(str2).getHost();
            } catch (Exception e10) {
                C11839m.m70687e("CommonUtil", "checkUrlByWhiteList uri & url error " + e10.getMessage());
                return false;
            }
        }
        if (TextUtils.isEmpty(strM68805b)) {
            C11839m.m70687e("CommonUtil", "checkUrlByWhiteList host is null, false");
            return false;
        }
        if (strArr.length <= 0) {
            C11839m.m70687e("CommonUtil", "checkUrlByWhiteList hostWhiteList is empty, false");
            return false;
        }
        for (String str3 : strArr) {
            if (!TextUtils.isEmpty(str3)) {
                if (strM68805b.equals(str3)) {
                    return true;
                }
                if (strM68805b.endsWith("." + str3)) {
                    return true;
                }
            }
        }
        C11839m.m70687e("CommonUtil", "checkUrlByWhiteList host not equals, return false, host = " + strM68805b);
        return false;
    }

    /* renamed from: g0 */
    public static void m70578g0(Context context) {
        String strM1328y0 = C0209d.m1328y0(context);
        long jM1359i = C0212e0.m1359i(context, "hianlytics_url", "init_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - jM1359i > 86400000;
        if (m70635z0(context) && !TextUtils.isEmpty(strM1328y0) && z10) {
            C13040c.m78609F().m78652i0(context, strM1328y0, false);
            C0212e0.m1370t(context, "hianlytics_url", "init_time", jCurrentTimeMillis);
        }
        if (!m70635z0(context) || TextUtils.isEmpty(strM1328y0)) {
            return;
        }
        C13230i.m79504I().m79562M(context, z10);
    }

    /* renamed from: g1 */
    public static void m70579g1(String str) {
        C12515a.m75110o().m75175e(new c(str), false);
    }

    /* renamed from: h */
    public static boolean m70580h(String str, String[] strArr) {
        C11839m.m70688i("CommonUtil", "enter checkUrlHost");
        boolean zM60731Z = C9733f.m60705z().m60731Z();
        WebViewAllowBean webViewPolicyBean = HiCloudWebViewPolicyManager.getInstance().getWebViewPolicyBean();
        if (zM60731Z && webViewPolicyBean != null) {
            return HiCloudWebViewPolicyManager.getInstance().checkUrlHost(str);
        }
        C11839m.m70688i("CommonUtil", "!webViewHierarchicalTrustlist or webViewPolicyBean is null");
        return m70577g(str, strArr);
    }

    /* renamed from: h0 */
    public static boolean m70581h0(Class cls, Context context) {
        if (cls == null || context == null) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (activityManager != null ? activityManager.getRunningTasks(1).get(0).topActivity.getClassName() : "").equals(cls.getName());
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "isActivityTop exception, " + e10.toString());
            return false;
        }
    }

    /* renamed from: h1 */
    public static void m70582h1(Context context, String str) {
        Bundle bundle = new Bundle();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        bundle.putBoolean("oobe_contact", c10028cM62182c0.m62388s("addressbook"));
        bundle.putBoolean("oobe_calendar", c10028cM62182c0.m62388s("calendar"));
        bundle.putBoolean("oobe_gellery", c10028cM62182c0.m62388s("uploadphotokey"));
        bundle.putBoolean("oobe_notepad", c10028cM62182c0.m62388s("notepad"));
        bundle.putBoolean("oobe_browser", c10028cM62182c0.m62388s("browser"));
        bundle.putBoolean("oobe_wlan", c10028cM62182c0.m62388s("wlan"));
        bundle.putBoolean("oobe_backup", c10028cM62182c0.m62388s("backup_key"));
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("channel_of_open_switch", str);
        }
        C11019b.m66371t().m66386H(context, bundle);
    }

    /* renamed from: i */
    public static boolean m70583i(String str, String[] strArr, String str2) {
        C11839m.m70688i("CommonUtil", "enter checkUrlHostOrPath");
        boolean zM60731Z = C9733f.m60705z().m60731Z();
        WebViewAllowBean webViewPolicyBean = HiCloudWebViewPolicyManager.getInstance().getWebViewPolicyBean();
        if (zM60731Z && webViewPolicyBean != null) {
            return HiCloudWebViewPolicyManager.getInstance().checkUrlByWebViewPolicy(str2, str);
        }
        C11839m.m70688i("CommonUtil", "!webViewHierarchicalTrustlist or webViewPolicyBean is null");
        return m70577g(str, strArr);
    }

    /* renamed from: i0 */
    public static boolean m70584i0(Context context) {
        String strM80951o0 = C13452e.m80781L().m80951o0();
        return !TextUtils.isEmpty(strM80951o0) ? strM80951o0.equals("dra") : m70587j0(context);
    }

    /* renamed from: i1 */
    public static void m70585i1(Window window) {
        if (C0224k0.a.m1574c("ro.config.hw_tint", false) || C0219i.m1463a() > 17) {
            m70500A1(window);
        } else {
            m70636z1(window);
        }
    }

    /* renamed from: j */
    public static void m70586j() {
        String strM80818J = C13452e.m80781L().m80818J();
        if (TextUtils.isEmpty(strM80818J)) {
            return;
        }
        new LocalMsgProcessor().deleteLocalTextMessage(strM80818J);
    }

    /* renamed from: j0 */
    public static boolean m70587j0(Context context) throws Throwable {
        try {
            String strM1290o2 = C0209d.m1290o2(context.getAssets().open("grs_sdk_global_route_config.json"));
            if (TextUtils.isEmpty(strM1290o2)) {
                C11839m.m70687e("CommonUtil", "get grsConfigStr null");
                return false;
            }
            try {
                String string = new JSONObject(strM1290o2).getJSONObject("countryGroups").getJSONObject("DR2").getString("countries");
                String strM80942m = C13452e.m80781L().m80942m();
                if (!TextUtils.isEmpty(strM80942m) && !TextUtils.isEmpty(string)) {
                    if (string.contains(strM80942m)) {
                        return true;
                    }
                }
            } catch (Exception e10) {
                C11839m.m70687e("CommonUtil", "parse grsConfigStr error: " + e10.toString());
            }
            return false;
        } catch (IOException e11) {
            C11839m.m70687e("CommonUtil", "get grsConfigStr error: " + e11.toString());
            return false;
        }
    }

    /* renamed from: j1 */
    public static void m70588j1(Window window) {
        if (C0224k0.a.m1574c("ro.config.hw_tint", false) || C0219i.m1463a() > 17) {
            m70500A1(window);
        } else {
            m70503B1(window);
        }
    }

    /* renamed from: k */
    public static void m70589k() {
        String strM80861U = C13452e.m80781L().m80861U();
        if (TextUtils.isEmpty(strM80861U)) {
            return;
        }
        new LocalMsgProcessor().deleteLocalTextMessage(strM80861U);
    }

    /* renamed from: k0 */
    public static boolean m70590k0() {
        return C0234s.m1636n().equalsIgnoreCase("zh");
    }

    /* renamed from: k1 */
    public static void m70591k1(Activity activity) throws IllegalAccessException, IllegalArgumentException {
        if (activity == null) {
            C11839m.m70687e("CommonUtil", "setCutoutMode activity null");
            return;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, 1);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "setCutoutMode exception:" + e10.toString());
        }
        activity.getWindow().setAttributes(attributes);
    }

    /* renamed from: l */
    public static int m70592l() {
        return ARImageMetadata.CONTROL_SCENE_MODE;
    }

    /* renamed from: l0 */
    public static boolean m70593l0(String str) throws ClassNotFoundException {
        Class<?> cls;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
            C11839m.m70687e("CommonUtil", "isClassSupport");
            cls = null;
        }
        return cls != null;
    }

    /* renamed from: l1 */
    public static void m70594l1(Context context, Dialog dialog) throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !m70563b0(context)) {
            return;
        }
        if (context == null || dialog == null) {
            C11839m.m70687e("CommonUtil", "setCutoutMode context or activity null");
            return;
        }
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        try {
            attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, 1);
        } catch (Exception e10) {
            C11839m.m70687e("CommonUtil", "setCutoutMode exception:" + e10.toString());
        }
        dialog.getWindow().setAttributes(attributes);
    }

    /* renamed from: m */
    public static void m70595m(String str, String str2, C11739b c11739b) throws C9721b {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "ownloadFile failed, DownloadReq info is illegal.");
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile == null) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "get file parent path failed.");
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "file parent create failed.");
        }
        String strM72864a = C12158a.m72864a(str2, Constants.UTF_8);
        if (TextUtils.isEmpty(strM72864a)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "url is null or empty after urldecoder");
        }
        C12612a.m76107g(strM72864a, c11739b, null);
    }

    /* renamed from: m0 */
    public static boolean m70596m0(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(99)) == null || runningTasks.size() <= 0) {
            return false;
        }
        return runningTasks.get(0).topActivity.getPackageName().equals("com.huawei.hidisk");
    }

    /* renamed from: m1 */
    public static void m70597m1(boolean z10) {
        f54760f = z10;
    }

    /* renamed from: n */
    public static void m70598n(String str, String str2, AbstractC4992a abstractC4992a) {
        String strM72864a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70687e("CommonUtil", "downloadFile failed, DownloadReq info is illegal.");
            return;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile == null) {
            C11839m.m70687e("CommonUtil", "get local parent path failed.");
            return;
        }
        if (!parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
            C11839m.m70687e("CommonUtil", "local parent create failed.");
            return;
        }
        try {
            strM72864a = C12158a.m72864a(str2, Constants.UTF_8);
        } catch (C9721b unused) {
            C11839m.m70687e("CommonUtil", "url decode exception");
            strM72864a = null;
        }
        if (TextUtils.isEmpty(strM72864a)) {
            C11839m.m70687e("CommonUtil", "url is null or empty after URLDecoder");
            return;
        }
        try {
            C12612a.m76107g(strM72864a, abstractC4992a, null);
        } catch (C9721b e10) {
            C11839m.m70687e("CommonUtil", "catch error " + e10.toString());
        }
    }

    /* renamed from: n0 */
    public static boolean m70599n0(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /* renamed from: n1 */
    public static void m70600n1(Dialog dialog, boolean z10, boolean z11) {
        if (z10) {
            C11839m.m70686d("CommonUtil", "isSettingLater: " + z10);
            return;
        }
        if (dialog == null) {
            C11839m.m70686d("CommonUtil", "mDialog == null");
            return;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            C11839m.m70686d("CommonUtil", "dialogWindow == null");
        } else if (z11) {
            m70585i1(window);
            m70572e0(dialog);
            C11840n.m70694e(dialog);
        }
    }

    /* renamed from: o */
    public static void m70601o(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (f54758d == null || f54758d.isShutdown()) {
            try {
                ReentrantLock reentrantLock = f54759e;
                reentrantLock.lock();
                if (f54758d == null || f54758d.isShutdown()) {
                    f54758d = new ThreadPoolExecutor(6, 6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(C11842p.m70771U0() ? 50 : 30), new ThreadPoolExecutor.DiscardOldestPolicy());
                }
                reentrantLock.unlock();
            } catch (Throwable th2) {
                f54759e.unlock();
                throw th2;
            }
        }
        f54758d.execute(runnable);
    }

    /* renamed from: o0 */
    public static boolean m70602o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(C13452e.m80781L().m80971t0());
    }

    /* renamed from: o1 */
    public static void m70603o1(String str, List<String> list) throws Exception {
        String strM68805b = C11526c.m68805b(str);
        if (TextUtils.isEmpty(strM68805b)) {
            return;
        }
        list.add(strM68805b);
    }

    /* renamed from: p */
    public static void m70604p() {
        C11839m.m70688i("CommonUtil", "followPublicUser start!");
        C12515a.m75110o().m75172d(new C11271a("followPublicUid"));
    }

    /* renamed from: p0 */
    public static boolean m70605p0() {
        if (C0209d.m1277l1()) {
            return "dark".equals(SystemPropertiesEx.get("persist.deep.theme_" + ActivityManagerEx.getCurrentUser()));
        }
        return "dark".equals(com.huawei.android.os.SystemPropertiesEx.get("persist.deep.theme_" + com.huawei.android.app.ActivityManagerEx.getCurrentUser()));
    }

    /* renamed from: p1 */
    public static void m70606p1(boolean z10) {
        f54762h = z10;
    }

    /* renamed from: q */
    public static long m70607q(long j10) {
        return j10;
    }

    /* renamed from: q0 */
    public static boolean m70608q0() {
        return "dark".equals(C0224k0.a.m1572a("persist.deep.theme_0"));
    }

    /* renamed from: q1 */
    public static void m70609q1(Context context, Window window) {
        if (window == null || context == null) {
            return;
        }
        window.setNavigationBarColor(context.getResources().getColor(R$color.pay_activity_harmony_bg));
    }

    /* renamed from: r */
    public static String m70610r(Context context, long j10, boolean z10) {
        if (context == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.##");
        return m70555Y(context, j10, z10, decimalFormat, false);
    }

    /* renamed from: r0 */
    public static boolean m70611r0() {
        return C0219i.m1463a() < 23 || C10028c.m62182c0().m62229J() || C0224k0.m1565t();
    }

    /* renamed from: r1 */
    public static void m70612r1(Context context) {
        if (context == null) {
            C11839m.m70687e("CommonUtil", "setNet context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.WIRELESS_SETTINGS");
        intent.putExtra("use_emui_ui", true);
        try {
            if (!(context instanceof Activity)) {
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            C11839m.m70687e("CommonUtil", "startActivity: setNet failed");
        }
    }

    /* renamed from: s */
    public static String m70613s(Date date) {
        return date == null ? "" : DateUtils.formatDateTime(C0213f.m1377a(), date.getTime(), m70592l());
    }

    /* renamed from: s0 */
    public static boolean m70614s0() {
        return C0209d.m1277l1() ? m70593l0("com.hihonor.android.widget.TimeAxisWidget") && m70593l0("com.hihonor.android.app.WallpaperManagerEx") && m70593l0("com.huawei.android.app.ActionBarEx") && m70593l0("com.hihonor.android.widget.SubTabWidget") : m70593l0("huawei.android.widget.TimeAxisWidget") && m70593l0("com.huawei.android.app.WallpaperManagerEx") && m70593l0("com.huawei.android.app.ActionBarEx") && m70593l0("huawei.android.widget.SubTabWidget");
    }

    /* renamed from: s1 */
    public static void m70615s1(Context context, int i10) {
        if (context == null) {
            C11839m.m70687e("CommonUtil", "context is null");
            return;
        }
        if (i10 != 1) {
            m70612r1(context);
            return;
        }
        Intent intent = new Intent("com.android.net.wifi.SETUP_WIFI_NETWORK");
        C0209d.m1302r2(intent, "com.android.settings");
        intent.putExtra("extra_prefs_show_button_bar", true);
        intent.putExtra("extra_show_fake_status_bar", true);
        intent.putExtra("firstRun", true);
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("CommonUtil", "startActivity: WIFI failed");
        }
    }

    /* renamed from: t */
    public static String m70616t(Context context, long j10) {
        return m70610r(context, j10, true);
    }

    /* renamed from: t0 */
    public static boolean m70617t0() {
        return C0234s.m1636n().equalsIgnoreCase(FaqConstants.DEFAULT_ISO_LANGUAGE);
    }

    /* renamed from: t1 */
    public static boolean m70618t1(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(NotifyConstants.HICLOUD_BACKUP);
        arrayList.add("hicloud_cloudPhoto");
        arrayList.add("hicloud_sync_addressbook");
        arrayList.add("hicloud_sync_notepad");
        arrayList.add("hicloud_sync_calendar");
        arrayList.add("hicloud_sync_browser");
        arrayList.add("hicloud_sync_wlan");
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(context);
        ArrayList arrayList2 = new ArrayList();
        if (shownSyncServiceItems.size() > 0) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            while (it.hasNext()) {
                SyncConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        arrayList2.add("hicloud_sync_" + id2);
                    }
                }
            }
        }
        C11839m.m70688i("CommonUtil", "setSettingSwitchOff list = " + arrayList.toString());
        boolean z10 = false;
        if (C0209d.m1310t2(context, arrayList, 0) && C0209d.m1310t2(context, arrayList2, -1)) {
            z10 = true;
        }
        C11839m.m70688i("CommonUtil", "setSettingSwitchOff result = " + z10);
        return z10;
    }

    /* renamed from: u */
    public static String m70619u(String str) {
        if (str == null) {
            return null;
        }
        return f54757c.matcher(str).matches() ? str.replace(".00", "") : str;
    }

    /* renamed from: u0 */
    public static boolean m70620u0(Context context) {
        String strM80951o0 = C13452e.m80781L().m80951o0();
        return !TextUtils.isEmpty(strM80951o0) ? strM80951o0.equals("dre") : m70623v0(context);
    }

    /* renamed from: u1 */
    public static boolean m70621u1(Context context) {
        C11839m.m70688i("CommonUtil", "setSettingsLogOff");
        if (context != null) {
            return C0209d.m1334z2(context, "hicloud_login", 0) && m70618t1(context);
        }
        C11839m.m70687e("CommonUtil", "setSettingsLogOff context is null");
        return false;
    }

    /* renamed from: v */
    public static String m70622v(String str, long j10) {
        return new SimpleDateFormat(str).format(Long.valueOf(j10));
    }

    /* renamed from: v0 */
    public static boolean m70623v0(Context context) throws Throwable {
        try {
            String strM1290o2 = C0209d.m1290o2(context.getAssets().open("grs_sdk_global_route_config.json"));
            if (TextUtils.isEmpty(strM1290o2)) {
                C11839m.m70687e("CommonUtil", "get grsConfigStr null");
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(strM1290o2).getJSONObject("countryGroups");
                String str = jSONObject.getJSONObject("DR3").getString("countries") + "," + jSONObject.getJSONObject("DR4").getString("countries");
                C11839m.m70686d("CommonUtil", "get grsConfigStr europeCountries: " + str);
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains(C13452e.m80781L().m80942m())) {
                        return true;
                    }
                }
            } catch (Exception e10) {
                C11839m.m70687e("CommonUtil", "parse grsConfigStr error: " + e10.toString());
            }
            return false;
        } catch (IOException e11) {
            C11839m.m70687e("CommonUtil", "get grsConfigStr error: " + e11.toString());
            return false;
        }
    }

    /* renamed from: v1 */
    public static void m70624v1(Context context, Window window) {
        Resources resources;
        if (window == null || context == null || (resources = context.getResources()) == null) {
            return;
        }
        int i10 = R$color.pay_activity_harmony_bg;
        window.setStatusBarColor(resources.getColor(i10));
        window.setNavigationBarColor(resources.getColor(i10));
    }

    /* renamed from: w */
    public static String m70625w(Date date) {
        return m70590k0() ? m70519H(date, "yyyy/MM/dd HH:mm:ss") : m70617t0() ? m70519H(date, "dd/MM/yyyy HH:mm:ss") : java.text.DateFormat.getDateTimeInstance().format(new Date(date.getTime()));
    }

    /* renamed from: w0 */
    public static boolean m70626w0() {
        return C10028c.m62182c0().m62395t1("funcfg_familyShare");
    }

    /* renamed from: w1 */
    public static void m70627w1(Context context, Window window) {
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(context.getResources().getColor(R$color.pay_activity_harmony_bg));
    }

    /* renamed from: x */
    public static String m70628x(Date date) {
        return m70590k0() ? m70519H(date, "yyyy/MM/dd") : m70617t0() ? m70519H(date, "dd/MM/yyyy") : DateFormat.getDateFormat(C0213f.m1377a()).format(date);
    }

    /* renamed from: x0 */
    public static boolean m70629x0(boolean z10) throws C1412i {
        if (!m70626w0()) {
            C11839m.m70688i("CommonUtil", "isFamilyShareMember familyShare function disable.");
            return false;
        }
        try {
            C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
            return C10465b.m64302l((FamilyShareInfoResult) new Gson().fromJson(z10 ? c13049a.m78730c0() : c13049a.m78751o(), FamilyShareInfoResult.class));
        } catch (JsonSyntaxException | C9721b e10) {
            C11839m.m70687e("CommonUtil", "isFamilyShareMember error : " + e10.toString());
            throw new C1412i(1001, "get familyshare info error.");
        }
    }

    /* renamed from: x1 */
    public static void m70630x1(Context context, Window window) {
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(context.getResources().getColor(R$color.honor_activity_bg));
    }

    /* renamed from: y */
    public static boolean m70631y(Context context) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        return m70534N0(context, C13452e.m80781L().m80942m()) ? c10028cM62183d0.m62395t1("hms_agr_force_query") : c10028cM62183d0.m62395t1("agr_force_query");
    }

    /* renamed from: y0 */
    public static boolean m70632y0() {
        return f54760f;
    }

    /* renamed from: y1 */
    public static void m70633y1(Context context, Window window) {
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(context.getResources().getColor(R$color.hicloud_activity_bg));
    }

    /* renamed from: z */
    public static long m70634z(Context context) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        return m70534N0(context, C13452e.m80781L().m80942m()) ? c10028cM62183d0.m62247N("hms_agr_query_time") : c10028cM62183d0.m62247N("agr_query_time");
    }

    /* renamed from: z0 */
    public static boolean m70635z0(Context context) {
        return !(context != null ? C0214f0.m1382b(context, "init_client", 0).getBoolean("first_boot", true) : true);
    }

    /* renamed from: z1 */
    public static void m70636z1(Window window) {
        if (window == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(2818);
        window.addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
    }
}
