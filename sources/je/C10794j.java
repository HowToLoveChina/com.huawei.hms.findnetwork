package je;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bn.C1266d;
import ck.C1443a;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.ToolEcologyActivity;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import mu.C11526c;
import p015ak.C0209d;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import tm.C13040c;

/* renamed from: je.j */
/* loaded from: classes3.dex */
public class C10794j {
    /* renamed from: a */
    public static boolean m65674a(String str, ArrayList<String> arrayList, String str2, String str3) {
        String str4;
        ArrayList<String> arrayListM65678e = m65678e();
        if (arrayListM65678e.size() > 0) {
            C11839m.m70688i("EcologyUtil", "checkEcologyUrlByWhiteList localHost size = " + arrayListM65678e.size());
            arrayList.addAll(arrayListM65678e);
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String strM68805b = C11526c.m68805b(next);
            if (TextUtils.isEmpty(strM68805b)) {
                try {
                    URI uri = new URI(next);
                    String host = uri.getHost();
                    String scheme = uri.getScheme();
                    strM68805b = host;
                    str4 = scheme;
                } catch (Exception e10) {
                    C11839m.m70687e("EcologyUtil", "checkEcologyUrlByWhiteList whiteDomain uri & url error " + e10.getMessage());
                }
            } else {
                str4 = null;
                if (strM68805b.startsWith("*")) {
                    strM68805b = strM68805b.replaceFirst("\\*", "");
                }
            }
            if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
                if (str2 != null) {
                    if (str2.endsWith("." + next) || str2.equals(next) || str2.equals(strM68805b) || (strM68805b != null && str2.endsWith(strM68805b))) {
                        return true;
                    }
                } else {
                    continue;
                }
            } else if (str2 != null && str2.equals(strM68805b) && str3 != null && str3.equals(str4)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m65675b(String str, ArrayList<String> arrayList, boolean z10) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("EcologyUtil", "checkEcologyUrlByWhiteList url is null ");
            return false;
        }
        String str3 = str.split("\\?")[0];
        String strM68805b = C11526c.m68805b(str3);
        if (TextUtils.isEmpty(strM68805b)) {
            try {
                URI uri = new URI(str3);
                String host = uri.getHost();
                String scheme = uri.getScheme();
                strM68805b = host;
                str2 = scheme;
            } catch (Exception e10) {
                C11839m.m70687e("EcologyUtil", "checkEcologyUrlByWhiteList uri & url error " + e10.getMessage());
                return false;
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(strM68805b)) {
            C11839m.m70687e("EcologyUtil", "checkEcologyUrlByWhiteList host is null, false");
            return false;
        }
        if (z10) {
            C11839m.m70688i("EcologyUtil", "checkEcologyUrlByWhiteList tool ecology");
            return true;
        }
        if (arrayList != null && arrayList.size() > 0) {
            return m65674a(str, arrayList, strM68805b, str2);
        }
        C11839m.m70687e("EcologyUtil", "checkEcologyUrlByWhiteList hostWhiteList is empty");
        return true;
    }

    /* renamed from: c */
    public static boolean m65676c(String str) {
        return m65675b(str, null, true);
    }

    /* renamed from: d */
    public static String m65677d(Uri uri) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        try {
            Iterator<String> it = uri.getQueryParameterNames().iterator();
            while (it.hasNext()) {
                builderBuildUpon.appendQueryParameter(it.next(), "");
            }
            return builderBuildUpon.build().toString();
        } catch (Exception unused) {
            C11839m.m70687e("EcologyUtil", "UnsupportedOperationException occurred");
            return "";
        }
    }

    /* renamed from: e */
    public static ArrayList<String> m65678e() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            C11829c.m70603o1(C13040c.m78609F().m78624P(), arrayList);
        } catch (Exception e10) {
            C11839m.m70687e("EcologyUtil", "getEcologyHostLocal error " + e10.getMessage());
        }
        return arrayList;
    }

    /* renamed from: f */
    public static String m65679f() {
        StringBuilder sb2 = new StringBuilder();
        try {
            String strM78624P = C13040c.m78609F().m78624P();
            String strM1638p = C0234s.m1638p();
            sb2.append(strM78624P);
            sb2.append("/drivemarket?");
            sb2.append("channel=");
            sb2.append("mobile");
            sb2.append("&");
            sb2.append(Constants.LANGUAGE_ASSIGN_STR);
            sb2.append(strM1638p);
            sb2.append("&");
            sb2.append("appVersion=");
            sb2.append(C1443a.f6213a);
            sb2.append("&");
            sb2.append("manuBrand=");
            sb2.append(C0209d.m1164E());
            sb2.append("&");
            sb2.append("timestamp=");
            sb2.append(System.currentTimeMillis());
        } catch (Exception e10) {
            C11839m.m70687e("EcologyUtil", "getEcologyUrl error" + e10.getMessage());
        }
        return sb2.toString();
    }

    /* renamed from: g */
    public static boolean m65680g(Context context, String str) {
        PackageManager packageManager;
        boolean z10 = false;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            z10 = packageManager.getApplicationInfo(str, 128).metaData.getBoolean("isSupportSpaceClearDeeplink", false);
            C11839m.m70688i("EcologyUtil", "getIsSupportSpaceClearDeeplink, packageName: " + str + ", getIsSupportSpaceClearDeeplink = " + z10);
            return z10;
        } catch (Exception e10) {
            C11839m.m70687e("EcologyUtil", "getIsSupportSpaceClearDeeplink, " + e10.toString());
            return z10;
        }
    }

    /* renamed from: h */
    public static void m65681h(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70687e("EcologyUtil", "goToBrowserDownload context or url is Empty");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("EcologyUtil", "onDownloadStart Exception =" + e10.getMessage());
        }
    }

    /* renamed from: i */
    public static boolean m65682i(Context context, String str) {
        URI uri;
        try {
            uri = new URI(str);
        } catch (Exception e10) {
            C11839m.m70687e("EcologyUtil", "isFileManagerDeeplink error " + e10.getMessage());
        }
        if (!TextUtils.equals("hifilemanager", uri.getScheme()) || !TextUtils.equals("filemanager", uri.getHost()) || !TextUtils.equals("/openActivity", uri.getPath())) {
            return false;
        }
        String query = uri.getQuery();
        if (!TextUtils.isEmpty(query)) {
            String[] strArrSplit = query.split("&");
            if (strArrSplit.length > 0) {
                if (TextUtils.equals("distributeId=10", strArrSplit[0])) {
                    if (m65680g(context, NextRestoreConstants.PKG_NAME_FILE_MANAGER)) {
                        C11839m.m70688i("EcologyUtil", "filemanager support space clear deeplink");
                        return true;
                    }
                    C11839m.m70688i("EcologyUtil", "filemanager too low, not support space clear deeplink");
                    C11841o.m70707c(context, R$string.low_version_prompt, 0);
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public static boolean m65683j() {
        boolean z10 = C11842p.m70738J0() || C11842p.m70762R0() || C0209d.m1293p1();
        C11839m.m70688i("EcologyUtil", "isShieldModel =" + z10);
        return z10;
    }

    /* renamed from: k */
    public static boolean m65684k(int i10) {
        String strM78624P;
        C11839m.m70688i("EcologyUtil", "isSupportEcology ecologyFlag =" + i10);
        try {
            strM78624P = C13040c.m78609F().m78624P();
        } catch (C9721b e10) {
            C11839m.m70687e("EcologyUtil", "isSupportEcology ecologyUrl =" + e10.getMessage());
            strM78624P = "";
        }
        return (i10 != 1 || m65683j() || TextUtils.isEmpty(strM78624P)) ? false : true;
    }

    /* renamed from: l */
    public static boolean m65685l(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("EcologyUtil", "url is empty");
            return false;
        }
        Uri uri = Uri.parse(str);
        if (uri == null) {
            C11839m.m70687e("EcologyUtil", "uri is null");
            return false;
        }
        String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            return true;
        }
        C11839m.m70687e("EcologyUtil", "illegal scheme:" + scheme);
        return false;
    }

    /* renamed from: m */
    public static void m65686m(Activity activity, String str) {
        if (activity == null || str == null) {
            return;
        }
        C11839m.m70688i("EcologyUtil", "jump to third app");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            activity.startActivityIfNeeded(intent, -1);
        } catch (ActivityNotFoundException unused) {
            C11839m.m70687e("EcologyUtil", "ActivityNotFoundException:" + str);
        }
    }

    /* renamed from: n */
    public static void m65687n(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70688i("EcologyUtil", "jumpToMarketTool appType or openUrl is empty");
            return;
        }
        if ("quick".equals(str)) {
            C1266d.m7525d(context).m7528e(str2);
            return;
        }
        try {
            Intent intent = new Intent();
            if ("web".equals(str)) {
                intent = new Intent(context, (Class<?>) ToolEcologyActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("isEnableJs", true);
            } else if (NotifyConstants.TYPE_DEEPLINK.equals(str)) {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                m65682i(context, str2);
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e("EcologyUtil", "jumpToMarketTool activity not found" + e10.getMessage());
            C11841o.m70707c(context, R$string.low_version_prompt, 0);
        } catch (Exception e11) {
            C11839m.m70687e("EcologyUtil", "jumpToMarketTool error" + e11.getMessage());
        }
    }

    /* renamed from: o */
    public static Intent m65688o(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("EcologyUtil", "jumpToMarketTool mode is empty");
            return null;
        }
        try {
            return m65689p(context, str2, str3, m65684k(0));
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e("EcologyUtil", "jumpToMarketTool activity not found" + e10.getMessage());
            C11841o.m70707c(context, R$string.low_version_prompt, 0);
            return null;
        } catch (Exception e11) {
            C11839m.m70687e("EcologyUtil", "jumpToMarketTool error" + e11.getMessage());
            return null;
        }
    }

    /* renamed from: p */
    public static Intent m65689p(Context context, String str, String str2, boolean z10) {
        C11839m.m70687e("EcologyUtil", "jumpToMarketTool procTools appType = " + str + ", openUrl = " + str2 + ", toolEcologySwitch = " + z10);
        if (z10 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if ("quick".equals(str)) {
                Intent intent = new Intent(context, (Class<?>) MainActivity.class);
                intent.putExtra("url", str2);
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                return intent;
            }
            if ("web".equals(str)) {
                Intent intent2 = new Intent(context, (Class<?>) ToolEcologyActivity.class);
                intent2.putExtra("url", str2);
                intent2.putExtra("isEnableJs", true);
                intent2.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                return intent2;
            }
            if (NotifyConstants.TYPE_DEEPLINK.equals(str)) {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent3.addCategory("android.intent.category.BROWSABLE");
                intent3.setComponent(null);
                intent3.setSelector(null);
                m65682i(context, str2);
                return intent3;
            }
            C11839m.m70688i("EcologyUtil", "procPushjumpToMarket proTools invalid type, return null");
        }
        return null;
    }
}
