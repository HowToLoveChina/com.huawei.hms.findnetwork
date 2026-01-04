package com.huawei.android.hicloud.album.service.utils;

import android.content.Context;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.CompressInfo;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.MobileHwJpgCompressSo;
import com.huawei.hicloud.bean.PictureCompressConfig;
import com.huawei.hicloud.bean.PictureCompressConfigWrapper;
import com.huawei.hicloud.bean.Rules;
import com.huawei.hicloud.download.C4896a;
import com.huawei.openalliance.p169ad.constant.MimeType;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p219d7.C9045a;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p527on.C11976a;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes2.dex */
public class CompressUtil {

    /* renamed from: a */
    public static boolean f11649a = false;

    /* renamed from: a */
    public static void m15279a(String... strArr) {
        for (String str : strArr) {
            C1120a.m6675d("CompressUtil", "clearPath: " + new File(str).delete());
        }
    }

    /* renamed from: b */
    public static HashMap<String, CompressInfo> m15280b(FileInfo fileInfo, HashMap<String, String> map, String str) {
        Context contextM1377a;
        LinkedHashMap linkedHashMap;
        HashMap<String, CompressInfo> map2 = new HashMap<>();
        if (!CloudAlbumSettings.m14363h().m14375k()) {
            return map2;
        }
        String localRealPath = fileInfo.getLocalRealPath();
        if (m15286h(localRealPath, fileInfo.getSize())) {
            StringBuilder sb2 = new StringBuilder();
            C11060c c11060cM66626a = C11058a.m66626a(str, "upload_compress_info", C13452e.m80781L().m80971t0());
            try {
                try {
                    String strM6759a1 = C1122c.m6759a1(fileInfo.getAlbumId());
                    m15290l(strM6759a1);
                    C1120a.m6675d("CompressUtil", "compress folder: " + strM6759a1);
                    String strM6763b1 = C1122c.m6763b1(fileInfo);
                    m15279a(strM6763b1);
                    C1120a.m6675d("CompressUtil", "localRealPath: " + localRealPath);
                    C1120a.m6677i("CompressUtil", "compress before size: " + new File(localRealPath).length());
                    int iM15281c = m15281c(localRealPath, strM6763b1);
                    C1120a.m6675d("CompressUtil", "compressLocalRealPath: " + strM6763b1);
                    C1120a.m6677i("CompressUtil", "compress end code: " + iM15281c);
                    map.put("compress code", String.valueOf(iM15281c));
                    sb2.append("compress code: ");
                    sb2.append(iM15281c);
                    c11060cM66626a.m66665u(String.valueOf(iM15281c));
                    if (iM15281c == 0) {
                        CompressInfo compressInfo = new CompressInfo();
                        compressInfo.setType(6);
                        File file = new File(strM6763b1);
                        compressInfo.setCompressedSize(Long.valueOf(file.length()));
                        C1120a.m6677i("CompressUtil", "compress end size: " + file.length());
                        compressInfo.setEncoding("lic");
                        compressInfo.setCompressFile(file);
                        map2.put("content", compressInfo);
                        sb2.append(", ");
                        sb2.append(compressInfo.toReportString());
                    }
                    c11060cM66626a.m66635A("upload compress fileName: " + fileInfo.getFileName() + ", albumId: " + fileInfo.getAlbumId() + ", " + sb2.toString());
                    contextM1377a = C0213f.m1377a();
                    linkedHashMap = new LinkedHashMap();
                } catch (Exception e10) {
                    c11060cM66626a.m66665u("101_0:1");
                    C1120a.m6676e("CompressUtil", "compress error: " + e10.toString());
                    sb2.append("compress error: ");
                    sb2.append(e10.toString());
                    c11060cM66626a.m66635A("upload compress fileName: " + fileInfo.getFileName() + ", albumId: " + fileInfo.getAlbumId() + ", " + sb2.toString());
                    contextM1377a = C0213f.m1377a();
                    linkedHashMap = new LinkedHashMap();
                }
                C13622a.m81969o(contextM1377a, c11060cM66626a, linkedHashMap);
            } catch (Throwable th2) {
                c11060cM66626a.m66635A("upload compress fileName: " + fileInfo.getFileName() + ", albumId: " + fileInfo.getAlbumId() + ", " + sb2.toString());
                C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, new LinkedHashMap());
                throw th2;
            }
        }
        return map2;
    }

    /* renamed from: c */
    public static int m15281c(String str, String str2) {
        try {
            if (m15288j()) {
                return compressJPEG(str, str2);
            }
            return -2;
        } catch (Throwable th2) {
            C1120a.m6676e("CompressUtil", "compressJPEGProxy error: " + th2);
            return -2;
        }
    }

    private static native int compressJPEG(String str, String str2);

    /* renamed from: d */
    public static int m15282d(String str, String str2) {
        try {
            if (m15288j()) {
                return deCompressJPEG(str, str2);
            }
            return -2;
        } catch (Throwable th2) {
            C1120a.m6676e("CompressUtil", "deCompressJPEGProxy error: " + th2);
            return -2;
        }
    }

    private static native int deCompressJPEG(String str, String str2);

    /* renamed from: e */
    public static boolean m15283e(String str, File file) {
        String strM15285g = m15285g();
        if (TextUtils.isEmpty(strM15285g)) {
            C1120a.m6678w("CompressUtil", "downloadSo soConfig isEmpty");
            return false;
        }
        try {
            MobileHwJpgCompressSo mobileHwJpgCompressSo = (MobileHwJpgCompressSo) new Gson().fromJson(strM15285g, MobileHwJpgCompressSo.class);
            if (mobileHwJpgCompressSo == null) {
                C1120a.m6678w("CompressUtil", "downloadSo mobileHwJpgCompressSo is null");
                return false;
            }
            String str2 = str + "_tmp";
            File file2 = new File(str2);
            if (file2.exists()) {
                C1120a.m6677i("CompressUtil", "downloadSo delete tempFile: " + file2.delete());
            }
            String url = mobileHwJpgCompressSo.getUrl();
            String hash = mobileHwJpgCompressSo.getHash();
            if (TextUtils.isEmpty(hash)) {
                C1120a.m6676e("CompressUtil", "downloadSo hash isEmpty");
                return false;
            }
            try {
                C11976a.m72086g(url, new C4896a(str2, 0L), null);
                try {
                    if (hash.equals(C2798b.m16328i(C10278a.m63442h(str2)))) {
                        if (!file2.exists()) {
                            return false;
                        }
                        C1120a.m6677i("CompressUtil", "downloadSo download success");
                        return file2.renameTo(file);
                    }
                    C1120a.m6676e("CompressUtil", "downloadSo hash not equal)");
                    if (!file2.delete()) {
                        C1120a.m6676e("CompressUtil", "downloadSo hash not equal, delete tmp soFile failed");
                    }
                    return false;
                } catch (C9721b e10) {
                    C1120a.m6676e("CompressUtil", "downloadSo check hash error: " + e10);
                    return false;
                }
            } catch (C9721b e11) {
                C1120a.m6676e("CompressUtil", "downloadSo catch error " + e11);
                return false;
            }
        } catch (Exception e12) {
            C1120a.m6678w("CompressUtil", "downloadSo download error: " + e12);
            return false;
        }
    }

    /* renamed from: f */
    public static ArrayList<Rules> m15284f(HiCloudSysParamMap hiCloudSysParamMap) {
        PictureCompressConfigWrapper pictureCompressConfigWrapper;
        try {
            pictureCompressConfigWrapper = (PictureCompressConfigWrapper) new Gson().fromJson(hiCloudSysParamMap.getPictureCompressConfig(), PictureCompressConfigWrapper.class);
        } catch (Exception unused) {
            C1120a.m6678w("CompressUtil", "isCompressConditionAllow compressConfig is invalid");
            pictureCompressConfigWrapper = null;
        }
        if (pictureCompressConfigWrapper == null) {
            C1120a.m6678w("CompressUtil", "isCompressConditionAllow pictureCompressConfigWrapper is null");
            return null;
        }
        PictureCompressConfig pictureCompressConfig = pictureCompressConfigWrapper.getPictureCompressConfig();
        if (pictureCompressConfig == null) {
            C1120a.m6678w("CompressUtil", "isCompressConditionAllow pictureCompressConfig is null");
            return null;
        }
        ArrayList<Rules> rules = pictureCompressConfig.getRules();
        if (rules != null) {
            return rules;
        }
        C1120a.m6678w("CompressUtil", "isCompressConditionAllow rules is null");
        return null;
    }

    /* renamed from: g */
    public static String m15285g() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return hiCloudSysParamMapM60757p.getMobileHwJpgCompressSo();
        }
        C1120a.m6678w("CompressUtil", "downloadSo configMap is null");
        return null;
    }

    /* renamed from: h */
    public static boolean m15286h(String str, long j10) throws Throwable {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C1120a.m6678w("CompressUtil", "isCompressConditionAllow configMap is null");
            return false;
        }
        ArrayList<Rules> arrayListM15284f = m15284f(hiCloudSysParamMapM60757p);
        if (arrayListM15284f == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Rules> it = arrayListM15284f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Rules next = it.next();
            if (next != null) {
                String gradeCode = next.getGradeCode();
                C1120a.m6675d("CompressUtil", "gradeCode: " + gradeCode + ", rule: " + next.toString());
                if (gradeCode.contains(C13452e.m80781L().m80790C()) && next.getEncoding().equals("lic") && !m15287i(next.getMimeType())) {
                    arrayList.add(next);
                    break;
                }
            }
        }
        if (arrayList.isEmpty()) {
            C1120a.m6678w("CompressUtil", "isCompressConditionAllow matchRules isEmpty");
            return false;
        }
        Rules rules = (Rules) arrayList.get(0);
        C1120a.m6675d("CompressUtil", "matchRule: " + rules.toString());
        if (m15291m(str, j10, rules)) {
            return false;
        }
        boolean zM6811n1 = C1122c.m6811n1(str);
        C1120a.m6675d("CompressUtil", "isJPEG: " + zM6811n1);
        return zM6811n1;
    }

    /* renamed from: i */
    public static boolean m15287i(String str) {
        return TextUtils.isEmpty(str) || !str.contains(MimeType.JPEG);
    }

    /* renamed from: j */
    public static synchronized boolean m15288j() throws Throwable {
        C1120a.m6677i("CompressUtil", "loadAlbumLib: " + f11649a);
        File filesDir = C0213f.m1378b().getFilesDir();
        String str = filesDir + File.separator + "liblienc.so";
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            if (f11649a) {
                return true;
            }
            m15289k(filesDir);
            return true;
        }
        if (!m15283e(str, file)) {
            return false;
        }
        m15289k(filesDir);
        return true;
    }

    /* renamed from: k */
    public static void m15289k(File file) throws Throwable {
        C9045a.m57014a(C0213f.m1377a().getApplicationContext().getClassLoader(), file);
        System.loadLibrary("lienc");
        System.loadLibrary("album-lib");
        f11649a = true;
    }

    /* renamed from: l */
    public static synchronized void m15290l(String... strArr) {
        try {
            for (String str : strArr) {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    C1120a.m6675d("CompressUtil", "makeDir delete: " + file.delete());
                }
                if (!file.exists()) {
                    C1120a.m6675d("CompressUtil", "compress mkdirs: " + file.mkdirs());
                }
                File fileM63442h = C10278a.m63442h(C10279b.m63452a(file) + "/.nomedia");
                if (!fileM63442h.exists()) {
                    try {
                        if (!fileM63442h.createNewFile()) {
                            C1120a.m6676e("CompressUtil", "makeDir:create .nomedia file error!");
                        }
                    } catch (IOException e10) {
                        C1120a.m6676e("CompressUtil", "makeDir:create .nomedia file error!error message:" + e10.getMessage());
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: m */
    public static boolean m15291m(String str, long j10, Rules rules) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("ImageWidth", 0);
            C1120a.m6675d("CompressUtil", "filePath: " + str + "， width: " + attributeInt + ", size: " + j10);
            return attributeInt > rules.getMaxWResolution() || j10 < rules.getMinFileSize();
        } catch (IOException e10) {
            C1120a.m6676e("CompressUtil", "getExifInterface error: " + e10.toString());
            return true;
        }
    }
}
