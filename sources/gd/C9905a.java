package gd;

import android.text.TextUtils;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import hk.C10278a;
import java.io.File;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;
import za.C14165b;

/* renamed from: gd.a */
/* loaded from: classes3.dex */
public class C9905a {
    /* renamed from: a */
    public static boolean m61496a(String str, Asset asset, String str2, String str3, String str4) {
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            String str5 = "syncType = " + str2 + ", " + str3 + " downloadAssetValid downloadFile not exist";
            m61498c(str5, str3, str4);
            C11839m.m70687e("SyncFileCheckUtil", str5);
            return false;
        }
        Resource resource = asset.getResource();
        if (resource == null) {
            String str6 = "syncType = " + str2 + ", " + str3 + " resource is null";
            m61498c(str6, str3, str4);
            C11839m.m70687e("SyncFileCheckUtil", str6);
            return false;
        }
        String sha256 = resource.getSha256();
        if (TextUtils.isEmpty(sha256)) {
            Long length = resource.getLength();
            if (length == null) {
                return true;
            }
            long length2 = fileM63442h.length();
            return m61497b(length.longValue() == length2, "syncType = " + str2 + ", " + str3 + " downloadAssetValid size = " + length + " not equals fileSize = " + length2, str3, str4);
        }
        String strM85038k = C14165b.m85038k(fileM63442h);
        String strM85039l = C14165b.m85039l(str);
        return m61497b(sha256.equalsIgnoreCase(strM85038k) || sha256.equalsIgnoreCase(strM85039l) || sha256.equalsIgnoreCase("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"), "syncType = " + str2 + ", " + str3 + " downloadAssetValid sha256 = " + sha256 + " not equals fileSha256 = " + strM85039l + ", and not equals fileHash = " + strM85038k, str3, str4);
    }

    /* renamed from: b */
    public static boolean m61497b(boolean z10, String str, String str2, String str3) {
        if (z10) {
            return true;
        }
        m61498c(str, str2, str3);
        C11839m.m70687e("SyncFileCheckUtil", str);
        return false;
    }

    /* renamed from: c */
    public static void m61498c(String str, String str2, String str3) {
        C11060c c11060cM66626a = C11058a.m66626a(str3, "downloadInvalid", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66635A(str);
        c11060cM66626a.m66638D(str2);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
    }
}
