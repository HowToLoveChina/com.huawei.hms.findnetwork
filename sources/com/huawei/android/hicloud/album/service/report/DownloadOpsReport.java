package com.huawei.android.hicloud.album.service.report;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.report.ExtraData;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import p031b7.C1122c;
import p783xp.C13843a;

/* loaded from: classes2.dex */
public class DownloadOpsReport extends OpsReport {
    public DownloadOpsReport(Context context) {
        super(context);
    }

    /* renamed from: A */
    public final String m15215A(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!m15217C(str3, str2)) {
            return "113_" + str2 + ":1";
        }
        return "113_" + str2 + "_OBS:1";
    }

    /* renamed from: B */
    public final String m15216B(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str) ? m15217C(str2, str) ? str2.replace("_OBS", "") : TextUtils.isEmpty(str2) ? "download exception" : str2 : str3;
    }

    /* renamed from: C */
    public final boolean m15217C(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str2.contains("404") && !TextUtils.isEmpty(str) && str.contains("_OBS");
    }

    /* renamed from: D */
    public void m15218D(int i10, String str, String str2, int i11, FileInfo fileInfo, String str3, String str4, String str5) {
        m15220F(i10, str, str4, str5, null);
        m15271s("04004");
        m15272t(str3);
        ExtraData extraData = new ExtraData(this.f11631a, ExtraData.EnumC2434b.DOWNLOAD);
        if (TextUtils.isEmpty(str2)) {
            str2 = OpsReport.m15261l("04004");
        }
        extraData.m15242u(str2);
        extraData.m15226e("download_thumbnail");
        extraData.m15240s(i11);
        extraData.m15225d(!TextUtils.isEmpty(fileInfo.getAlbumId()) ? fileInfo.getAlbumId() : fileInfo.getShareId());
        extraData.m15243v(fileInfo.getUniqueId());
        extraData.m15234m(fileInfo.getUploadTime());
        extraData.m15232k(C1122c.m6818p0(fileInfo.getFileName()));
        extraData.m15230i("NMD");
        m15221G(extraData, fileInfo, i11);
        m15270r(extraData);
        super.m15266n();
    }

    /* renamed from: E */
    public void m15219E(String str, String str2, long j10, int i10, String str3, FileInfo fileInfo, String str4, String str5, long j11, int i11, String str6, String str7, String str8, String str9, boolean z10) {
        m15268p(C13843a.m83101w(str));
        m15276x(C1122c.m6728Q0(m15264c()));
        m15278z(str2);
        m15277y(j10);
        m15220F(i10, str3, str6, str7, str8);
        m15271s("04004");
        m15272t(fileInfo.getFileId());
        ExtraData extraData = new ExtraData(this.f11631a, ExtraData.EnumC2434b.DOWNLOAD);
        extraData.m15237p(String.valueOf(z10 ? 1 : 0));
        if (CloudAlbumSettings.m14363h().m14386v()) {
            extraData.m15235n(String.valueOf(CloudAlbumSettings.m14363h().m14379o() ? 1 : 0));
        }
        extraData.m15242u(TextUtils.isEmpty(str5) ? OpsReport.m15261l("04004") : str5);
        extraData.m15226e("download");
        extraData.m15240s(i11);
        extraData.m15225d(!TextUtils.isEmpty(fileInfo.getAlbumId()) ? fileInfo.getAlbumId() : fileInfo.getShareId());
        extraData.m15243v(fileInfo.getUniqueId());
        extraData.m15234m(fileInfo.getUploadTime());
        extraData.m15232k(C1122c.m6818p0(fileInfo.getFileName()));
        extraData.m15228g(j11);
        extraData.m15239r(str4);
        extraData.m15238q(str9);
        extraData.m15233l(String.valueOf(fileInfo.getFileType()));
        m15221G(extraData, fileInfo, i11);
        m15270r(extraData);
        super.m15266n();
    }

    /* renamed from: F */
    public final void m15220F(int i10, String str, String str2, String str3, String str4) {
        String strM15215A;
        String strM15216B;
        String str5;
        if (i10 != 200 && i10 != 206) {
            if (404 != i10 || TextUtils.isEmpty(str4)) {
                if (m15217C(str, String.valueOf(i10))) {
                    str = str.replace("_OBS", "");
                    str5 = "113_" + i10 + "_OBS:1";
                } else {
                    str5 = "113_" + i10 + ":1";
                }
            } else if (m15217C(str, String.valueOf(i10))) {
                str = str.replace("_OBS", "");
                str5 = "113_" + i10 + "_" + str4 + "_OBS:1";
            } else {
                str5 = "113_" + i10 + "_" + str4 + ":1";
            }
            strM15216B = m15216B(str2, str3, str);
            strM15215A = m15215A(str5, str2, str3);
        } else if (TextUtils.isEmpty(str2)) {
            strM15215A = "0:1";
            strM15216B = "OK";
        } else {
            strM15215A = "113_" + i10 + "_" + str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "download exception";
            }
            strM15216B = str3;
        }
        m15275w(strM15215A);
        m15269q(strM15216B);
    }

    /* renamed from: G */
    public final void m15221G(ExtraData extraData, FileInfo fileInfo, int i10) {
        String fileId = fileInfo.getFileId();
        String strValueOf = String.valueOf(0);
        if (i10 == 1) {
            fileId = fileInfo.getLcdFileId();
            strValueOf = String.valueOf(1);
            if (TextUtils.isEmpty(fileId) && fileInfo.getFileType() == 4 && !TextUtils.isEmpty(fileInfo.getVideoThumbId())) {
                fileId = fileInfo.getVideoThumbId();
                strValueOf = String.valueOf(3);
            }
        } else if (i10 == 2) {
            fileId = fileInfo.getThumbFileId();
            strValueOf = String.valueOf(2);
            if (TextUtils.isEmpty(fileId) && fileInfo.getFileType() == 4 && !TextUtils.isEmpty(fileInfo.getVideoThumbId())) {
                fileId = fileInfo.getVideoThumbId();
                strValueOf = String.valueOf(3);
            }
        }
        extraData.m15230i(fileId);
        extraData.m15245x(fileInfo.getVideoThumbId());
        extraData.m15231j(strValueOf);
    }
}
