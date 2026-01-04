package com.huawei.android.hicloud.cloudbackup.process.util;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p015ak.C0209d;
import p015ak.C0224k0;
import p292fn.C9733f;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12568l;
import p618rm.C12571m;
import p618rm.C12583q;
import p682ul.C13219m;
import p711vl.C13466f;
import p815ym.AbstractC14026a;
import tl.C13026e;

/* loaded from: classes2.dex */
public class SplitAppUtil {
    public static final String EMULATED = "/emulated/";
    public static final String HW_CLONE_APP_LIST = "/system/emui/base/xml/hw_clone_app_list.xml";
    public static final String HW_CLONE_APP_LIST_PACKAGE = "package";
    public static final String HW_CLONE_APP_LIST_PACKAGE_NAME = "name";
    public static final String MNT_ANDROIDWRITABLE = "/mnt/androidwritable/";
    public static final String SPLIT_APP_NOTIFY_NOT_SHOW = "1";
    public static final String SPLIT_APP_NOTIFY_SHOW = "0";
    public static final String SPLIT_APP_SUFFIX = "@";
    public static final String STORAGE_EMULATED = "/storage/emulated/";
    private static final String TAG = "SplitAppUtil";
    public static List<String> splitConfigureList;

    public static void checkAppTwinStatus(String str, int i10) throws C9721b {
        List<Integer> listM75535d = C12568l.m75535d();
        if (!AbstractC14026a.m84159a(listM75535d) && !listM75535d.contains(Integer.valueOf(i10))) {
            throw new C9721b(1048, "uid changed appId: " + str + " ,uid: " + i10 + " ,new: " + listM75535d);
        }
        if (C12568l.m75534c(i10).contains(str)) {
            return;
        }
        C11839m.m70688i(TAG, "checkCurBackupStatus is delete, appId = " + str + ", uid = " + i10);
        throw new C9721b(1998, "appTwin is not exist, appId = " + str + ", uid" + i10);
    }

    public static void deleteDir(File file) {
        if (file == null) {
            C11839m.m70689w(TAG, "deleteDir waitDeleteFile is null");
            return;
        }
        if (C11835i.m70642f(file)) {
            return;
        }
        String str = C12583q.m75681q() + File.separator + UUID.randomUUID();
        C11839m.m70688i(TAG, "deleteDir error, move to temp dir delete: " + file.renameTo(C10278a.m63442h(str)) + " ,path: " + C10279b.m63452a(file));
        C12571m.m75542d(str);
    }

    private static List<String> getConfiguredClonesXml() throws XmlPullParserException, IOException {
        List<String> list = splitConfigureList;
        if (list != null) {
            return list;
        }
        splitConfigureList = new ArrayList();
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new FileReader(HW_CLONE_APP_LIST));
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 0) {
                    C11839m.m70688i(TAG, "getConfiguredClonesXml start");
                } else if (eventType == 2) {
                    C11839m.m70688i(TAG, "getConfiguredClonesXml tag," + xmlPullParserNewPullParser.getName());
                    if ("package".equals(xmlPullParserNewPullParser.getName().trim())) {
                        splitConfigureList.add(xmlPullParserNewPullParser.getAttributeValue(null, "name"));
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "getConfiguredClonesXml: error," + e10.getMessage());
        }
        C11839m.m70686d(TAG, "getConfiguredClonesXml list:" + splitConfigureList);
        return splitConfigureList;
    }

    public static String getNewAppName(String str, String str2) {
        if (!hasSplitAppSuffix(str)) {
            return str2;
        }
        return str2 + str.substring(str.lastIndexOf(SPLIT_APP_SUFFIX) + 1);
    }

    public static String getSplitAppId(String str, String str2) {
        return str + SPLIT_APP_SUFFIX + str2;
    }

    public static String getSplitAppName(String str, String str2) {
        if (!isSplitApp(str2)) {
            return str;
        }
        return str + str2;
    }

    public static String getSplitAppType(String str) {
        return (String) getSplitOriAppIdAndSplitApkType(str).second;
    }

    public static String getSplitNotifyShowStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i(TAG, "getSplitNotifyShowStatus: appId is null");
            return "1";
        }
        if (!isSplitInCloneFile().contains(str)) {
            C11839m.m70688i(TAG, "getSplitNotifyShowStatus: split is not open");
            return "1";
        }
        boolean zIsSupportSplitBackUp = SplitAppSettingSingleInstance.getInstance().isSupportSplitBackUp(str, "1");
        C11839m.m70688i(TAG, "getSplitNotifyShowStatus: supportSplitApp is:" + zIsSupportSplitBackUp);
        if (!zIsSupportSplitBackUp) {
            return "1";
        }
        boolean z10 = false;
        boolean zM81075b = C13466f.m81073d().m81075b("has_entered_option_page", false);
        C11839m.m70688i(TAG, "getSplitNotifyShowStatus: isEntered is:" + zM81075b);
        if (zM81075b) {
            return "1";
        }
        List listM81076c = C13466f.m81073d().m81076c("record_the_opened_splits");
        C11839m.m70686d(TAG, "getSplitNotifyShowStatus: openedList" + listM81076c);
        if (listM81076c.contains(str)) {
            C11839m.m70688i(TAG, "getSplitNotifyShowStatus: openedList has app");
            return "1";
        }
        List<BackupOptionItem> listM78368C = new C13026e(false).m78368C(str);
        if (listM78368C != null && !listM78368C.isEmpty()) {
            Iterator<BackupOptionItem> it = listM78368C.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BackupOptionItem next = it.next();
                C11839m.m70688i(TAG, "getSplitNotifyShowStatus:item appId:" + next.getAppId() + ",backupSwitch," + next.getBackupSwitch());
                if (next.getBackupSwitch()) {
                    z10 = true;
                    break;
                }
            }
        }
        C11839m.m70688i(TAG, "getSplitNotifyShowStatus: switch isOpen," + z10);
        return z10 ? "1" : "0";
    }

    public static String getSplitOriAppId(String str) {
        return (String) getSplitOriAppIdAndSplitApkType(str).first;
    }

    public static Pair<String, String> getSplitOriAppIdAndSplitApkType(String str) {
        String strSubstring;
        Exception e10;
        String strSubstring2 = "";
        if (hasSplitAppSuffix(str)) {
            try {
                int iLastIndexOf = str.lastIndexOf(SPLIT_APP_SUFFIX);
                strSubstring = str.substring(0, iLastIndexOf);
                try {
                    strSubstring2 = str.substring(iLastIndexOf + 1);
                } catch (Exception e11) {
                    e10 = e11;
                    C11839m.m70689w(TAG, "getSplitOriAppIdAndSplitApkType error: " + e10);
                    str = strSubstring;
                    return new Pair<>(str, strSubstring2);
                }
            } catch (Exception e12) {
                strSubstring = str;
                e10 = e12;
            }
            str = strSubstring;
        }
        return new Pair<>(str, strSubstring2);
    }

    public static boolean hasSplitAppSuffix(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains(SPLIT_APP_SUFFIX);
        }
        C11839m.m70688i(TAG, "hasSplitAppSuffix: appId is null");
        return false;
    }

    public static Map<String, C13219m<String, Integer, Integer>> init3rdAppTwinsList(Collection<String> collection, Function<String, Boolean> function) {
        HashMap map = new HashMap();
        if (collection == null || function == null || !C9733f.m60705z().m60720O("backupSupportSplitApp")) {
            return map;
        }
        int i10 = 0;
        for (Integer num : C12568l.m75535d()) {
            if (num.intValue() != 0) {
                i10++;
                for (String str : C12568l.m75534c(num.intValue())) {
                    if (function.apply(str).booleanValue() && collection.contains(str)) {
                        map.put(getSplitAppId(str, String.valueOf(i10)), new C13219m(str, Integer.valueOf(i10), num));
                        BaseLogger.m28734i(TAG, "init app twin list: uid: " + num, ", appId: " + str);
                    }
                }
            }
        }
        return map;
    }

    public static boolean isInConfigured(String str) {
        boolean zContains = getConfiguredClonesXml().contains(str);
        C11839m.m70688i(TAG, "isInConfigured: " + zContains);
        return zContains;
    }

    public static boolean isSplitApp(String str) {
        return (TextUtils.isEmpty(str) || "0".equals(str)) ? false : true;
    }

    private static List<String> isSplitInCloneFile() {
        ArrayList arrayList = new ArrayList();
        for (Integer num : C12568l.m75535d()) {
            if (num.intValue() != 0) {
                for (String str : C12568l.m75534c(num.intValue())) {
                    arrayList.add(str);
                    BaseLogger.m28734i(TAG, "isSplitInCloneFile:uid: " + num, ", appId: " + str);
                }
            }
        }
        C11839m.m70686d(TAG, "isSplitInCloneFile list:" + arrayList);
        return arrayList;
    }

    public static boolean isSystemSupportSplitRestore() {
        boolean zM1574c = C0224k0.a.m1574c("ro.config.hw_support_clone_app", false);
        C11839m.m70688i(TAG, "isSystemSupportSplitRestore: " + zM1574c);
        return zM1574c;
    }

    public static boolean isTwinApp(String str, String str2) {
        if (str != null) {
            try {
                if (str.isEmpty() || Integer.parseInt(str) < 1 || str2 == null) {
                    return false;
                }
                return !str2.isEmpty();
            } catch (Exception e10) {
                C11839m.m70688i(TAG, "isTwinApp error: " + e10.getMessage());
            }
        }
        return false;
    }

    public static boolean notSupportSplitAndroidScanVersion() {
        return C0209d.m1179I1();
    }

    public static String splitAppAndroidDataPathToOriginPath(String str) {
        String strReplaceFirst;
        int iIndexOf;
        if (str == null || !str.startsWith(MNT_ANDROIDWRITABLE) || (iIndexOf = (strReplaceFirst = str.replaceFirst(MNT_ANDROIDWRITABLE, "")).indexOf("/")) <= 0) {
            return str;
        }
        String str2 = strReplaceFirst.substring(0, iIndexOf) + EMULATED;
        if (!strReplaceFirst.startsWith(str2)) {
            return str;
        }
        return STORAGE_EMULATED + strReplaceFirst.replaceFirst(str2, "");
    }

    public static String splitAppDestAndroidDataPathToWritePath(String str, int i10) {
        String strReplaceFirst;
        int iIndexOf;
        if (i10 == 0 || str == null || !str.startsWith(STORAGE_EMULATED) || (iIndexOf = (strReplaceFirst = str.replaceFirst(STORAGE_EMULATED, "")).indexOf("/")) <= 0) {
            return str;
        }
        return MNT_ANDROIDWRITABLE + strReplaceFirst.substring(0, iIndexOf) + EMULATED + strReplaceFirst;
    }
}
