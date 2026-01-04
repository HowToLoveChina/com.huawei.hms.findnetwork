package je;

import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.util.FileUtil;
import com.huawei.cloud.services.drive.model.File;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import gl.C9961b;
import gp.C10028c;
import me.C11444a;
import p015ak.C0209d;
import p252e9.C9428e;
import p292fn.C9733f;
import p514o9.C11839m;

/* renamed from: je.x */
/* loaded from: classes3.dex */
public class C10810x {
    /* renamed from: a */
    public static long m65805a() {
        return C9428e.m59118h().m59132o();
    }

    /* renamed from: b */
    public static long m65806b() {
        return C9961b.m61788i().m61805s();
    }

    /* renamed from: c */
    public static int m65807c(String str, String str2) {
        if ("application/vnd.huawei-apps.folder".equals(str)) {
            return 0;
        }
        return C11444a.m68560d(str2, false).m68565a();
    }

    /* renamed from: d */
    public static boolean m65808d(long j10) {
        return !C0209d.m1269j1() && m65811g(j10, C10028c.m62182c0().m62290X()) && m65814j();
    }

    /* renamed from: e */
    public static boolean m65809e(long j10) {
        return !C0209d.m1269j1() && m65811g(j10, C10028c.m62182c0().m62298Z()) && m65814j();
    }

    /* renamed from: f */
    public static boolean m65810f(long j10) {
        return m65811g(j10, C10028c.m62182c0().m62294Y());
    }

    /* renamed from: g */
    public static boolean m65811g(long j10, long j11) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return j10 - j11 >= ((long) hiCloudSysParamMapM60757p.getSpaceCleanExpireTime()) * 60000;
        }
        C11839m.m70689w("SpaceCleanupUtil", "isSpaceCleanDataSavePeriod configMap is null");
        return j10 - j11 >= 1800000;
    }

    /* renamed from: h */
    public static boolean m65812h(long j10, long j11) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return j10 - j11 >= ((long) hiCloudSysParamMapM60757p.getSpaceCleanRedRemindPeriod()) * 86400000;
        }
        C11839m.m70689w("SpaceCleanupUtil", "isRedRemindPeriod configMap is null");
        return j10 - j11 >= 604800000;
    }

    /* renamed from: i */
    public static boolean m65813i(long j10) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return j10 >= ((long) hiCloudSysParamMapM60757p.getSpaceCleanRedRemindSpace()) * 1048576;
        }
        C11839m.m70689w("SpaceCleanupUtil", "isRedRemindSpaceSize configMap is null");
        return j10 >= 52428800;
    }

    /* renamed from: j */
    public static boolean m65814j() {
        return "V2.0".equalsIgnoreCase(C10028c.m62182c0().m62287W0());
    }

    /* renamed from: k */
    public static boolean m65815k(long j10, long j11) {
        return j10 - j11 >= 86400000;
    }

    /* renamed from: l */
    public static FileModel m65816l(File file) {
        FileModel fileModel = new FileModel();
        fileModel.setFileId(file.getId());
        fileModel.setFileName(file.getFileName());
        if (file.getEditedTime() != null) {
            fileModel.setModifyTime(file.getEditedTime().m28459e());
        } else {
            fileModel.setModifyTime("");
        }
        if (file.getParentFolder() == null || file.getParentFolder().size() <= 0) {
            fileModel.setFileParent("");
        } else {
            fileModel.setFileParent(file.getParentFolder().get(0));
        }
        fileModel.setFileCategory(FileUtil.m16356f(m65807c(file.getMimeType(), file.getFileName())));
        fileModel.setFileSize(file.getSize() == null ? 0L : file.getSize().longValue());
        fileModel.setFileMD5(file.get("md5") instanceof String ? (String) file.get("md5") : "");
        fileModel.setIsCloudExist("1");
        fileModel.setFileParentName("");
        fileModel.setThumbnailPath("");
        return fileModel;
    }
}
