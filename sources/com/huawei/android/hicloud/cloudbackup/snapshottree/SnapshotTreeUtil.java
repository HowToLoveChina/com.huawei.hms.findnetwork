package com.huawei.android.hicloud.cloudbackup.snapshottree;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mk.C11476b;
import p015ak.C0241z;
import p848zl.C14333b;

/* loaded from: classes2.dex */
public class SnapshotTreeUtil {
    private static void checkCloudPathLength(SnapshotBackupMeta snapshotBackupMeta, String str) {
        int length;
        String cloudPath = snapshotBackupMeta.getCloudPath();
        try {
            length = cloudPath.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException unused) {
            length = cloudPath.getBytes(Charset.defaultCharset()).length;
        }
        if (length > 250) {
            cloudPath = str + "_" + str;
        }
        snapshotBackupMeta.setCloudPath(cloudPath);
    }

    private static void dealGalleryMetaNode(File file, String str, String str2, SnapshotBackupMeta snapshotBackupMeta, String str3) {
        String str4 = C11476b.m68626h(str) + '_' + str2;
        if (str.endsWith(str3 + "/gallery/gallery.db")) {
            str4 = file.getName() + '_' + str2;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (snapshotBackupMeta.isEncoded()) {
            fileM63442h = C10278a.m63442h(ICBUtil.getDecodedPath(str));
        }
        snapshotBackupMeta.setCloudPath(C11476b.m68626h(fileM63442h.getParent()) + File.separator + str4);
    }

    public static List<SnapshotBackupMeta> getAppinfoMetas(CBSAppInfo cBSAppInfo) throws C9721b {
        ArrayList arrayList = new ArrayList();
        if (cBSAppInfo == null || TextUtils.isEmpty(cBSAppInfo.getExtend()) || TextUtils.isEmpty(cBSAppInfo.getApkPath())) {
            return arrayList;
        }
        SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
        SnapshotBackupMeta snapshotBackupMeta2 = new SnapshotBackupMeta();
        String extend = cBSAppInfo.getExtend();
        HashMap map = new HashMap();
        for (String str : extend.split("&")) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        String apkPath = cBSAppInfo.getApkPath();
        String iconPath = cBSAppInfo.getIconPath();
        String theString = ICBUtil.getTheString("", (String) map.get(SnapshotBackupMeta.KEY_STRING_APP_NAME));
        String theString2 = ICBUtil.getTheString("", (String) map.get(SnapshotBackupMeta.KEY_STRING_APP_VERSION));
        String theString3 = ICBUtil.getTheString("0", (String) map.get(SnapshotBackupMeta.KEY_STRING_APP_SIZE));
        String theString4 = ICBUtil.getTheString("", (String) map.get(SnapshotBackupMeta.KEY_STRING_APP_SLICE_PATH));
        try {
            String str2 = File.separator;
            String strSubstring = SafeString.substring(apkPath, 0, apkPath.lastIndexOf(str2));
            String strSubstring2 = SafeString.substring(strSubstring, strSubstring.lastIndexOf(str2) + 1);
            String strSubstring3 = SafeString.substring(apkPath, apkPath.lastIndexOf(str2) + 1);
            String strSubstring4 = SafeString.substring(strSubstring3, strSubstring3.lastIndexOf(95) + 1);
            snapshotBackupMeta.setRoot(ICBUtil.RELATIVE_SDATA_PATH + str2);
            String str3 = cBSAppInfo.getAppId() + ".apk";
            snapshotBackupMeta.setName(str3);
            snapshotBackupMeta.setData(cBSAppInfo.getAppId() + str2 + str3);
            snapshotBackupMeta.setAppType((long) cBSAppInfo.getApkType());
            snapshotBackupMeta.setType(0L);
            if (isEncrypt()) {
                snapshotBackupMeta.setHash2(strSubstring4);
            } else {
                snapshotBackupMeta.setHash1(strSubstring4);
            }
            snapshotBackupMeta.setCloudHash(strSubstring4);
            snapshotBackupMeta.setSize(C0241z.m1688f(theString3));
            snapshotBackupMeta.setCloudPath(strSubstring3);
            snapshotBackupMeta.setCloudSize(C0241z.m1688f(theString3));
            StringBuilder sb2 = new StringBuilder(SnapshotBackupMeta.KEY_STRING_APP_NAME);
            sb2.append("=");
            sb2.append(theString);
            sb2.append("&");
            sb2.append(SnapshotBackupMeta.KEY_STRING_APP_VERSION);
            sb2.append("=");
            sb2.append(theString2);
            sb2.append("&");
            sb2.append(SnapshotBackupMeta.KEY_STRING_APP_VERSION_CODE);
            sb2.append("=");
            sb2.append(strSubstring2);
            snapshotBackupMeta.setAppSlice(theString4);
            snapshotBackupMeta.setExtend(sb2.toString());
            arrayList.add(snapshotBackupMeta);
            if (!TextUtils.isEmpty(iconPath)) {
                String strSubstring5 = SafeString.substring(iconPath, iconPath.lastIndexOf(str2) + 1);
                String strSubstring6 = SafeString.substring(strSubstring5, strSubstring5.lastIndexOf(95) + 1);
                snapshotBackupMeta2.setRoot(ICBUtil.RELATIVE_SDATA_PATH + str2);
                String str4 = cBSAppInfo.getAppId() + ".icon";
                snapshotBackupMeta2.setName(str4);
                snapshotBackupMeta2.setData(cBSAppInfo.getAppId() + str2 + str4);
                snapshotBackupMeta2.setAppType((long) cBSAppInfo.getApkType());
                snapshotBackupMeta2.setType(6L);
                if (isEncrypt()) {
                    snapshotBackupMeta2.setHash2(strSubstring6);
                } else {
                    snapshotBackupMeta2.setHash1(strSubstring6);
                }
                snapshotBackupMeta2.setCloudHash(strSubstring6);
                snapshotBackupMeta2.setCloudPath(strSubstring5);
                snapshotBackupMeta2.setExtend(sb2.toString());
                arrayList.add(snapshotBackupMeta2);
            }
            return arrayList;
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getLeafNodeBackupMetas error." + e10.getMessage(), "get apk info");
        }
    }

    public static String getLocalPath(SnapshotBackupMeta snapshotBackupMeta, String str) {
        String str2 = snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData();
        return snapshotBackupMeta.getCloudEncoded() == 1 ? ICBUtil.convertToAbsolutePath(ICBUtil.getDecodedPath(str2), str) : ICBUtil.convertToAbsolutePath(str2, str);
    }

    private static boolean isAppData(String str, String str2) {
        if (C14333b.m85477l().contains(str2)) {
            return false;
        }
        String str3 = str2 + ".apk";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(".icon");
        return (str.endsWith(str3) || str.endsWith(sb2.toString()) || str.endsWith("info.xml")) ? false : true;
    }

    private static boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    public static void setCloudPath(File file, SnapshotBackupMeta snapshotBackupMeta, String str, String str2) {
        String cloudHash = snapshotBackupMeta.getCloudHash();
        String name = snapshotBackupMeta.getName();
        String appId = snapshotBackupMeta.getAppId();
        if (HNConstants.DataType.MEDIA.equals(appId)) {
            dealGalleryMetaNode(file, str, cloudHash, snapshotBackupMeta, str2);
        } else if (isAppData(str, appId)) {
            snapshotBackupMeta.setCloudPath(C11476b.m68626h(str) + '_' + cloudHash);
        } else if ("music".equals(appId)) {
            snapshotBackupMeta.setCloudPath(C11476b.m68626h(str) + '_' + cloudHash);
        } else {
            snapshotBackupMeta.setCloudPath(name + '_' + cloudHash);
        }
        checkCloudPathLength(snapshotBackupMeta, cloudHash);
    }

    public static void setMetaHashInfo(File file, SnapshotBackupMeta snapshotBackupMeta, String str) throws C9721b {
        Md5AndHash md5AndHashM68622d = C11476b.m68622d(file);
        String md5 = md5AndHashM68622d.getMD5();
        String hash = md5AndHashM68622d.getHash();
        snapshotBackupMeta.setHash1(md5);
        snapshotBackupMeta.setHash2(hash);
        if (isEncrypt()) {
            md5 = hash;
        }
        snapshotBackupMeta.setCloudHash(md5);
        setCloudPath(file, snapshotBackupMeta, ICBUtil.getRelativePath(C10279b.m63452a(file), str), str);
    }

    public static void setMetaHashInfo(File file, File file2, SnapshotBackupMeta snapshotBackupMeta, String str) throws C9721b {
        Md5AndHash md5AndHashM68622d = C11476b.m68622d(file2);
        String md5 = md5AndHashM68622d.getMD5();
        String hash = md5AndHashM68622d.getHash();
        snapshotBackupMeta.setHash1(md5);
        snapshotBackupMeta.setHash2(hash);
        if (isEncrypt()) {
            md5 = hash;
        }
        snapshotBackupMeta.setCloudHash(md5);
        setCloudPath(file, snapshotBackupMeta, ICBUtil.getRelativePath(C10279b.m63452a(file), str), str);
    }
}
