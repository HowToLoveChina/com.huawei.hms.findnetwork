package p783xp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hicloud.base.R$bool;
import com.huawei.hicloud.base.R$string;
import com.huawei.hicloud.base.bean.SpaceFormatSplit;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0234s;
import p038bq.C1271a;
import p038bq.C1272b;
import p399jk.AbstractC10896a;

/* renamed from: xp.a */
/* loaded from: classes8.dex */
public final class C13843a {

    /* renamed from: a */
    public static final Pattern f62092a = Pattern.compile("(\\d*)\\.[0][0] (\\w*)");

    /* renamed from: b */
    public static String f62093b = "";

    /* renamed from: c */
    public static String f62094c = "";

    /* renamed from: d */
    public static String f62095d = "";

    /* renamed from: e */
    public static String f62096e = "";

    /* renamed from: f */
    public static String f62097f = "";

    /* renamed from: g */
    public static boolean f62098g = true;

    /* renamed from: xp.a$a */
    public static class a {

        /* renamed from: a */
        public static final Uri f62099a = Uri.parse("content://com.huawei.provider.NotePad.cloudSync");

        /* renamed from: b */
        public static final Uri f62100b = Uri.parse("content://com.hihonor.provider.NotePad.cloudSync");

        /* renamed from: c */
        public static final Uri f62101c = Uri.parse("content://com.huawei.gallery.provider");

        /* renamed from: d */
        public static final Uri f62102d = Uri.parse("content://com.hihonor.gallery.provider");

        /* renamed from: e */
        public static final Uri f62103e = Uri.parse("content://com.huawei.gallery3d.photoshare.provider");

        /* renamed from: f */
        public static final Uri f62104f = Uri.parse("content://com.hihonor.gallery3d.photoshare.provider");
    }

    /* renamed from: A */
    public static String m83049A() {
        return C0209d.m1269j1() ? "com.hihonor.mms" : NextRestoreConstants.PKG_NAME_SMS;
    }

    /* renamed from: B */
    public static String m83050B(Context context) {
        if (!TextUtils.isEmpty(f62095d)) {
            return f62095d;
        }
        if (C0209d.m1269j1()) {
            f62095d = "com.hihonor.notepad";
        } else {
            f62095d = m83059K(context, NextRestoreConstants.PKG_NAME_MEMO, "com.example.android.notepad");
        }
        return f62095d;
    }

    /* renamed from: C */
    public static Uri m83051C() {
        return C0209d.m1277l1() ? a.f62100b : a.f62099a;
    }

    /* renamed from: D */
    public static String m83052D() {
        return C0209d.m1277l1() ? "com.hihonor.provider.NotePad.cloudSync" : "com.huawei.provider.NotePad.cloudSync";
    }

    /* renamed from: E */
    public static Uri m83053E() {
        return C0209d.m1277l1() ? a.f62104f : a.f62103e;
    }

    /* renamed from: F */
    public static String m83054F(Context context) {
        if (!TextUtils.isEmpty(f62093b)) {
            return f62093b;
        }
        if (C0209d.m1269j1()) {
            f62093b = "com.hihonor.photos";
        } else {
            f62093b = m83060L(context, NextRestoreConstants.PKG_NAME_GALLERY_DATA, NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D);
        }
        return f62093b;
    }

    /* renamed from: G */
    public static int m83055G(Context context) {
        return m83098t(context).widthPixels;
    }

    /* renamed from: H */
    public static String m83056H(String str) {
        StringBuilder sbM83057I;
        if (f62098g) {
            try {
                C1272b.m7543a();
                throw null;
            } catch (Throwable unused) {
                f62098g = false;
                sbM83057I = m83057I(str);
            }
        } else {
            sbM83057I = m83057I(str);
        }
        return sbM83057I.toString();
    }

    /* renamed from: I */
    public static StringBuilder m83057I(String str) {
        ArrayList<C1272b.c> arrayListM7540b;
        StringBuilder sb2 = new StringBuilder();
        try {
            arrayListM7540b = C1271a.m7538c().m7540b(str);
        } catch (Throwable th2) {
            AbstractC10896a.m65886e("CommonBaseUtil", "OldTransliteratUtil getSortNameBuilder error: " + th2.toString());
            sb2.append(str);
            arrayListM7540b = null;
        }
        if (arrayListM7540b != null) {
            Iterator<C1272b.c> it = arrayListM7540b.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().f5713c);
                sb2.append(" ");
            }
        }
        return sb2;
    }

    /* renamed from: J */
    public static String m83058J(Context context) {
        if (!TextUtils.isEmpty(f62097f)) {
            return f62097f;
        }
        if (C0209d.m1269j1()) {
            f62097f = "com.hihonor.soundrecorder";
        } else {
            f62097f = m83059K(context, NextRestoreConstants.PKG_NAME_SOUND_RECORDER, "com.android.soundrecorder");
        }
        return f62097f;
    }

    /* renamed from: K */
    public static String m83059K(Context context, String str, String str2) {
        if (C0219i.m1463a() >= 21) {
            return m83061M(context, str, str2);
        }
        AbstractC10896a.m65887i("CommonBaseUtil", "return old packagename");
        return str2;
    }

    /* renamed from: L */
    public static String m83060L(Context context, String str, String str2) {
        if (C0219i.m1463a() >= 23) {
            return m83061M(context, str, str2);
        }
        AbstractC10896a.m65887i("CommonBaseUtil", "less then 10.1,return old packagename");
        return str2;
    }

    /* renamed from: M */
    public static String m83061M(Context context, String str, String str2) {
        if (context == null) {
            AbstractC10896a.m65888w("CommonBaseUtil", "getSpecifiedPackageName error : context is null");
            return "";
        }
        try {
        } catch (Exception e10) {
            AbstractC10896a.m65886e("CommonBaseUtil", "isApplicationAvailble exception : " + e10.toString());
        }
        return C0209d.m1184K0(context, str) ? str : C0209d.m1184K0(context, str2) ? str2 : "";
    }

    /* renamed from: N */
    public static String m83062N(String str) {
        return C0209d.m1277l1() ? ("addressbook".equals(str) || "notepad".equals(str) || "calendar".equals(str)) ? "com.hihonor.android.cloudSync.intent.STARTSYNC" : "com.huawei.android.hicloud.intent.STARTSYNC" : "com.huawei.android.hicloud.intent.STARTSYNC";
    }

    /* renamed from: O */
    public static String m83063O(String str) {
        return C0209d.m1277l1() ? ("addressbook".equals(str) || "notepad".equals(str) || "calendar".equals(str)) ? "com.hihonor.android.cloudSync.intent.STOPSYNC" : "com.huawei.android.hicloud.intent.STOPSYNC" : "com.huawei.android.hicloud.intent.STOPSYNC";
    }

    /* renamed from: P */
    public static String m83064P() {
        return C0209d.m1269j1() ? "com.hihonor.systemmanager" : "com.huawei.systemmanager";
    }

    /* renamed from: Q */
    public static String m83065Q(Context context, Date date) {
        if (DateFormat.is24HourFormat(context)) {
            return ((String) DateFormat.format("HH:mm", date)) + " ";
        }
        if (!m83067S()) {
            return (String) DateFormat.format("h:mm a", date);
        }
        return ((String) DateFormat.format("a h:mm", date)) + " ";
    }

    /* renamed from: R */
    public static boolean m83066R() {
        String strM1636n = C0234s.m1636n();
        return "zh".equalsIgnoreCase(strM1636n) || "bo".equalsIgnoreCase(strM1636n) || "ug".equalsIgnoreCase(strM1636n);
    }

    /* renamed from: S */
    public static boolean m83067S() {
        return C0234s.m1636n().equalsIgnoreCase("zh");
    }

    /* renamed from: T */
    public static boolean m83068T() {
        return C0234s.m1636n().equalsIgnoreCase(FaqConstants.DEFAULT_ISO_LANGUAGE);
    }

    /* renamed from: U */
    public static boolean m83069U(String str) {
        return NextRestoreConstants.PKG_NAME_MEMO.equals(str) || "com.example.android.notepad".equals(str) || "com.hihonor.notepad".equals(str);
    }

    /* renamed from: V */
    public static boolean m83070V(Context context) {
        if (context == null) {
            return false;
        }
        String language = context.getResources().getConfiguration().locale.getLanguage();
        return language.endsWith(Constants.AR_CACHE) || language.endsWith("fa") || language.endsWith("iw") || language.endsWith(Constants.URDU_LANG) || language.endsWith("ug");
    }

    /* renamed from: W */
    public static boolean m83071W(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* renamed from: X */
    public static boolean m83072X(long j10, long j11, TimeZone timeZone) {
        long j12 = j10 - j11;
        return j12 < 86400000 && j12 > -86400000 && m83082d0(j10, timeZone) == m83082d0(j11, timeZone);
    }

    /* renamed from: Y */
    public static boolean m83073Y(Context context) {
        String str;
        String str2;
        List<ResolveInfo> listQueryBroadcastReceivers;
        if (context == null) {
            return false;
        }
        if (C0209d.m1293p1()) {
            AbstractC10896a.m65888w("CommonBaseUtil", "ink screen Not support contacts sync ability");
            return false;
        }
        if (C0209d.m1277l1()) {
            str = "com.hihonor.contacts.sync";
            str2 = "com.hihonor.android.cloudSync.intent.STARTSYNC";
        } else {
            str = "com.huawei.contacts.sync";
            str2 = "com.huawei.android.hicloud.intent.STARTSYNC";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null && (listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(new Intent(str2), 0)) != null) {
            Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && str.equals(activityInfo.packageName)) {
                    return true;
                }
            }
        }
        AbstractC10896a.m65888w("CommonBaseUtil", "Not support sync ability: " + str);
        return false;
    }

    /* renamed from: Z */
    public static boolean m83074Z(Context context) {
        if (context == null) {
            AbstractC10896a.m65886e("CommonBaseUtil", "isSupportLocalClean context is null");
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.filemanager.space.clean");
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    /* renamed from: a */
    public static String m83075a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new String(Base64.encode(str.getBytes(Charset.forName(Constants.UTF_8)), 2), "ASCII");
        } catch (UnsupportedEncodingException e10) {
            AbstractC10896a.m65886e("CommonBaseUtil", "ASC encode error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: a0 */
    public static boolean m83076a0(Context context) {
        if (context == null) {
            return false;
        }
        return context.getResources().getBoolean(R$bool.hisync_config_land_capable);
    }

    /* renamed from: b */
    public static String m83077b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new String(Base64.encode(str.getBytes(Charset.forName(Constants.UTF_8)), 2), str2);
        } catch (UnsupportedEncodingException e10) {
            AbstractC10896a.m65886e("CommonBaseUtil", "encode error: " + e10.toString());
            return "";
        }
    }

    /* renamed from: b0 */
    public static boolean m83078b0(Context context, String str) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        if (context != null && str != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(new Intent("com.huawei.android.hicloud.intent.STARTSYNC"), 0)) != null) {
                Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null && str.equals(activityInfo.packageName)) {
                        return true;
                    }
                }
            }
            AbstractC10896a.m65888w("CommonBaseUtil", "Not support sync ability: " + str);
        }
        return false;
    }

    /* renamed from: c */
    public static byte[] m83079c(Bitmap bitmap, int i10) {
        return m83081d(bitmap, i10, Bitmap.CompressFormat.JPEG);
    }

    /* renamed from: c0 */
    public static int m83080c0(Context context, Intent intent) {
        if (context == null) {
            return 0;
        }
        return context.getPackageManager().queryIntentActivities(intent, 0).size();
    }

    /* renamed from: d */
    public static byte[] m83081d(Bitmap bitmap, int i10, Bitmap.CompressFormat compressFormat) {
        if (i10 == -1 || (bitmap != null && bitmap.getWidth() == i10 && bitmap.getHeight() == i10)) {
            return m83084f(bitmap, compressFormat);
        }
        float f10 = i10;
        Matrix matrix = new Matrix();
        matrix.setScale(f10 / bitmap.getWidth(), f10 / bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        byte[] bArrM83084f = m83084f(bitmapCreateBitmap, compressFormat);
        bitmapCreateBitmap.recycle();
        return bArrM83084f;
    }

    /* renamed from: d0 */
    public static long m83082d0(long j10, TimeZone timeZone) {
        return (timeZone.getOffset(j10) + j10) / 86400000;
    }

    /* renamed from: e */
    public static byte[] m83083e(Bitmap bitmap, int i10, Bitmap.CompressFormat compressFormat) throws IOException {
        if (bitmap == null) {
            AbstractC10896a.m65886e("CommonBaseUtil", "error, bitmap is null");
            return new byte[0];
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
            try {
                bitmap.compress(compressFormat, i10, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException e10) {
            AbstractC10896a.m65886e("CommonBaseUtil", "compressToBytes IOException " + e10.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: f */
    public static byte[] m83084f(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return m83083e(bitmap, 90, compressFormat);
    }

    /* renamed from: g */
    public static void m83085g(String str) {
        File[] fileArrListFiles;
        AbstractC10896a.m65887i("CommonBaseUtil", "deleteFilesInFolder, delete pictures in folder");
        File file = new File(str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!file2.isDirectory() && !file2.delete()) {
                    AbstractC10896a.m65886e("CommonBaseUtil", "deleteFilesInFolder, del file failed, file name is " + file2.getPath());
                }
            }
        }
    }

    /* renamed from: h */
    public static String m83086h(Context context, long j10) {
        String string;
        if (context == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.##");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        float f10 = j10;
        int i10 = R$string.cloudbackup_Emotion_B;
        if (f10 > 900.0f) {
            i10 = R$string.cloudbackup_Emotion_KB;
            f10 /= 1024;
        }
        if (f10 > 900.0f) {
            f10 /= 1024;
            i10 = R$string.cloudbackup_Emotion_MB;
        }
        if (f10 > 900.0f) {
            f10 /= 1024;
            i10 = R$string.cloudbackup_Emotion_GB;
        }
        try {
            string = context.getString(i10, m83104z(Double.valueOf(decimalFormat.format(f10))));
        } catch (Exception unused) {
            AbstractC10896a.m65886e("CommonBaseUtil", "formatSpace exception");
            string = context.getString(i10, decimalFormat.format(f10));
        }
        return m83087i(string);
    }

    /* renamed from: i */
    public static String m83087i(String str) {
        if (str == null) {
            return null;
        }
        return f62092a.matcher(str).matches() ? str.replace(".00", "") : str;
    }

    /* renamed from: j */
    public static SpaceFormatSplit m83088j(Context context, long j10) {
        if (context == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.##");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        float f10 = j10;
        int i10 = R$string.cloudbackup_Emotion_B;
        if (f10 > 900.0f) {
            i10 = R$string.cloudbackup_Emotion_KB;
            f10 /= 1024;
        }
        if (f10 > 900.0f) {
            f10 /= 1024;
            i10 = R$string.cloudbackup_Emotion_MB;
        }
        if (f10 > 900.0f) {
            f10 /= 1024;
            i10 = R$string.cloudbackup_Emotion_GB;
        }
        SpaceFormatSplit spaceFormatSplit = new SpaceFormatSplit();
        double d10 = f10;
        try {
            String strM83087i = m83087i(m83104z(Double.valueOf(decimalFormat.format(d10))));
            String string = context.getString(i10, "");
            spaceFormatSplit.setSize(strM83087i);
            spaceFormatSplit.setUnit(string);
        } catch (Exception unused) {
            AbstractC10896a.m65886e("CommonBaseUtil", "formatSpace exception");
            String str = decimalFormat.format(d10);
            spaceFormatSplit.setUnit(context.getString(i10, ""));
            spaceFormatSplit.setSize(str);
        }
        return spaceFormatSplit;
    }

    /* renamed from: k */
    public static String m83089k(Context context, long j10) {
        Date date = new Date(j10);
        String str = m83067S() ? (String) DateFormat.format("yyyy/M/d", date) : m83068T() ? (String) DateFormat.format("dd/MM/yyyy", date) : DateFormat.getDateFormat(context).format(new Date(j10));
        String strM83065Q = m83065Q(context, date);
        if (context.getResources().getConfiguration().getLayoutDirection() != 1) {
            return str + ' ' + strM83065Q;
        }
        return "\u202b" + str + ' ' + strM83065Q + "\u202b";
    }

    /* renamed from: l */
    public static String m83090l() {
        return "com.huawei.appmarket";
    }

    /* renamed from: m */
    public static String m83091m() {
        return Constants.HW_BROWSER_PACKAGE;
    }

    /* renamed from: n */
    public static String m83092n(Context context) {
        if (m83078b0(context, m83091m())) {
            return m83091m();
        }
        return null;
    }

    /* renamed from: o */
    public static String m83093o(Context context) {
        if (!TextUtils.isEmpty(f62096e)) {
            return f62096e;
        }
        if (C0209d.m1269j1()) {
            f62096e = "com.hihonor.calendar";
        } else {
            f62096e = m83059K(context, NextRestoreConstants.PKG_NAME_CALENDAR, "com.android.calendar");
        }
        return f62096e;
    }

    /* renamed from: p */
    public static String m83094p(Context context) {
        if (!TextUtils.isEmpty(f62094c)) {
            return f62094c;
        }
        if (C0209d.m1269j1()) {
            f62094c = "com.hihonor.contacts";
        } else {
            f62094c = m83059K(context, "com.huawei.contacts", "com.android.contacts");
        }
        return f62094c;
    }

    /* renamed from: q */
    public static String m83095q() {
        return C0209d.m1277l1() ? "com.hihonor.contacts.sync.cloudSync" : "com.huawei.contacts.sync.cloudSync";
    }

    /* renamed from: r */
    public static String m83096r() {
        return C0209d.m1277l1() ? "com.hihonor.contacts.sync" : "com.huawei.contacts.sync";
    }

    /* renamed from: s */
    public static String m83097s() {
        return C0209d.m1273k1() ? "com.hihonor.systemmanager" : "com.huawei.systemmanager";
    }

    /* renamed from: t */
    public static DisplayMetrics m83098t(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: u */
    public static List<String> m83099u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.hihonor.filemanager");
        arrayList.add(NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        return arrayList;
    }

    /* renamed from: v */
    public static Uri m83100v() {
        return C0209d.m1277l1() ? a.f62102d : a.f62101c;
    }

    /* renamed from: w */
    public static String m83101w(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iIndexOf = str.indexOf("://");
        if (iIndexOf != -1) {
            str = str.substring(iIndexOf + 3);
        }
        int iIndexOf2 = str.indexOf("/");
        if (iIndexOf2 != -1) {
            str = str.substring(0, iIndexOf2);
        }
        int iIndexOf3 = str.indexOf(":");
        return iIndexOf3 != -1 ? str.substring(0, iIndexOf3) : str;
    }

    /* renamed from: x */
    public static String m83102x() {
        return C0209d.m1277l1() ? "androidhnext:style/Theme.Magic" : "androidhwext:style/Theme.Emui";
    }

    /* renamed from: y */
    public static String m83103y(Context context) {
        if (context != null) {
            return (C0209d.m1269j1() && C0209d.m1184K0(context, "com.hihonor.systemmanager")) ? "com.hihonor.systemmanager" : "com.huawei.systemmanager";
        }
        AbstractC10896a.m65886e("CommonBaseUtil", "getInstalledSystemMangerPackageName context is null");
        return m83097s();
    }

    /* renamed from: z */
    public static String m83104z(Object obj) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.getDefault());
        String strValueOf = String.valueOf(obj);
        try {
            return numberInstance.format(obj);
        } catch (Exception unused) {
            AbstractC10896a.m65886e("CommonBaseUtil", "getLocaleFormatNum params invalid error");
            return strValueOf;
        }
    }
}
