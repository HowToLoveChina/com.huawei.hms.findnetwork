package com.huawei.android.hicloud.utils.hole;

import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.text.DecimalFormat;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class HoleUtil {

    /* renamed from: a */
    public static final DecimalFormat f19654a = new DecimalFormat("#.00");

    static {
        System.loadLibrary("hole");
    }

    /* renamed from: a */
    public static double m25923a(String str) throws C9721b {
        C11839m.m70686d("HoleUtil", "calculate hole rate start:" + str);
        double dProbe = probe(str);
        C11839m.m70688i("HoleUtil", "calculate hole rate end" + str + " holeRate: " + dProbe);
        if (dProbe != -1.0d) {
            return Double.parseDouble(f19654a.format(dProbe));
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Error while calculating the hole rate.");
    }

    /* renamed from: b */
    public static long m25924b(String str) throws C9721b {
        C11839m.m70688i("HoleUtil", "getHoleZippedSize start:" + str);
        long zippedSize = getZippedSize(str);
        C11839m.m70688i("HoleUtil", "getHoleZippedSize end, size: " + zippedSize);
        if (zippedSize != 0) {
            return zippedSize;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Error while getHoleZippedSize.");
    }

    /* renamed from: c */
    public static int m25925c(String str, String str2) throws C9721b {
        C11839m.m70688i("HoleUtil", "start Unzip file:" + str + ",destFile:" + str2);
        int iUnzipped = unzipped(str, str2);
        if (iUnzipped == -1) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "sparse unzipped failed:" + str);
        }
        C11839m.m70688i("HoleUtil", "sparse unZipped end,srcFile:" + str + ",result:" + iUnzipped);
        return iUnzipped;
    }

    /* renamed from: d */
    public static int m25926d(String str, String str2) throws C9721b {
        C11839m.m70688i("HoleUtil", "start zip file:" + str + ",destFile:" + str2);
        int iZipped = zipped(str, str2);
        if (iZipped == -1) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "sparse zipped failed:" + str);
        }
        C11839m.m70688i("HoleUtil", "sparseZipped end,srcFile:" + str + ",result:" + iZipped);
        return iZipped;
    }

    public static native long getZippedSize(String str);

    public static native double probe(String str);

    public static native int unzipped(String str, String str2);

    public static native int zipped(String str, String str2);
}
