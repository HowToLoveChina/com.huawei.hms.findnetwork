package p009a8;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaAssetAttribute;
import com.huawei.android.p069cg.p072vo.FileInfo;
import hk.C10278a;
import java.io.File;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1131l;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: a8.d */
/* loaded from: classes2.dex */
public class C0066d {
    /* renamed from: a */
    public static boolean m437a(String str, Asset asset, int i10, String str2, String str3) {
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            String str4 = str2 + " downloadAssetValid downloadFile not exist";
            m442f(str4, str2, str3);
            C1120a.m6676e("PhotoFileCheckUtil", str4);
            return false;
        }
        if (i10 != 0) {
            String strM441e = m441e(asset, i10);
            if (!TextUtils.isEmpty(strM441e)) {
                String strM16327h = C2798b.m16327h(fileM63442h);
                return m439c(strM441e.equalsIgnoreCase(strM16327h), str2 + " " + i10 + " downloadAssetValid sha256=" + strM441e + " not equals fileSha256=" + strM16327h, str2, str3);
            }
            Long lM440d = m440d(asset, i10);
            if (lM440d != null) {
                long length = fileM63442h.length();
                return m439c(lM440d.longValue() == length, str2 + " " + i10 + " downloadAssetValid size=" + lM440d + " not equals fileSize=" + length, str2, str3);
            }
        } else {
            if (!TextUtils.isEmpty(asset.getResource().getSha256())) {
                String sha256 = asset.getResource().getSha256();
                String strM16327h2 = C2798b.m16327h(fileM63442h);
                return m439c(sha256.equalsIgnoreCase(strM16327h2), str2 + " " + i10 + " downloadAssetValid sha256=" + sha256 + " not equals fileSha256=" + strM16327h2, str2, str3);
            }
            if (asset.getResource().getLength() != null) {
                Long length2 = asset.getResource().getLength();
                long length3 = fileM63442h.length();
                return m439c(length2.longValue() == length3, str2 + " " + i10 + " downloadAssetValid size=" + length2 + " not equals fileSize=" + length3, str2, str3);
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m438b(String str, FileInfo fileInfo, int i10, String str2) throws Throwable {
        if (fileInfo != null && !fileInfo.isLostData() && i10 == 0) {
            File fileM63442h = C10278a.m63442h(str);
            String strM6814o0 = C1122c.m6814o0(fileInfo);
            if (!fileM63442h.exists()) {
                String str3 = strM6814o0 + " downloadProxyValid downloadFile not exist ";
                m442f(str3, strM6814o0, str2);
                C1120a.m6676e("PhotoFileCheckUtil", str3);
                return false;
            }
            if (!TextUtils.isEmpty(fileInfo.getSha256())) {
                String sha256 = fileInfo.getSha256();
                String strM16327h = C2798b.m16327h(fileM63442h);
                return m439c(sha256.equalsIgnoreCase(strM16327h), strM6814o0 + " downloadProxyValid sha256=" + sha256 + " not equals fileSha256=" + strM16327h, strM6814o0, str2);
            }
            if (!TextUtils.isEmpty(fileInfo.getHashId())) {
                String hashId = fileInfo.getHashId();
                String strM6920b = C1131l.m6920b(fileM63442h);
                return m439c(hashId.equalsIgnoreCase(strM6920b), strM6814o0 + " downloadProxyValid hashId=" + hashId + " not equals fileHashId=" + strM6920b, strM6814o0, str2);
            }
            if (fileInfo.getDownloadCheckSize() != null) {
                long jLongValue = fileInfo.getDownloadCheckSize().longValue();
                long length = fileM63442h.length();
                return m439c(jLongValue == length, strM6814o0 + " downloadProxyValid size=" + jLongValue + " not equals fileSize=" + length, strM6814o0, str2);
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m439c(boolean z10, String str, String str2, String str3) {
        if (z10) {
            return true;
        }
        m442f(str, str2, str3);
        C1120a.m6676e("PhotoFileCheckUtil", str);
        return false;
    }

    /* renamed from: d */
    public static Long m440d(Asset asset, int i10) {
        MediaAssetAttribute attributes = asset.getResource().getAttributes();
        if (attributes == null || attributes.getLength() == null) {
            attributes = asset.getAttributes();
        }
        if (attributes == null || attributes.getLength() == null) {
            return null;
        }
        return i10 == 2 ? attributes.getLength().getSmall() : attributes.getLength().getLarge();
    }

    /* renamed from: e */
    public static String m441e(Asset asset, int i10) {
        MediaAssetAttribute attributes = asset.getResource().getAttributes();
        if (attributes == null || attributes.getSha256() == null) {
            attributes = asset.getAttributes();
        }
        if (attributes == null || attributes.getSha256() == null) {
            return null;
        }
        return i10 == 2 ? attributes.getSha256().getSmall() : attributes.getSha256().getLarge();
    }

    /* renamed from: f */
    public static void m442f(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = C11058a.m66627b("04004");
        }
        C11060c c11060cM66626a = C11058a.m66626a(str3, "downloadInvalid", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0:1");
        c11060cM66626a.m66635A(str);
        c11060cM66626a.m66638D(str2);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
    }
}
