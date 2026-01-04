package ss;

import as.C1016d;
import com.huawei.location.lite.common.util.filedownload.C6795a;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import es.C9540e;
import es.C9549n;
import java.io.File;
import p237du.AbstractC9308a;
import p346hs.C10337b;
import rs.C12621a;

/* renamed from: ss.c */
/* loaded from: classes8.dex */
public final class C12850c {

    /* renamed from: a */
    public C9549n f58590a;

    /* renamed from: b */
    public String f58591b;

    /* renamed from: ss.c$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("Loc-SDM-CheckPlugin" + hashCode());
            C12850c.m77157d(C12850c.this);
        }
    }

    /* renamed from: d */
    public static void m77157d(C12850c c12850c) {
        c12850c.getClass();
        synchronized (C12850c.class) {
            try {
                C9549n c9549n = new C9549n("sp_libSdmSo_filename");
                c12850c.f58590a = c9549n;
                long jCurrentTimeMillis = System.currentTimeMillis() - c9549n.m59623a("libSdm_last_time");
                c12850c.f58591b = c12850c.f58590a.m59624b("libSdm_version_num");
                File file = new File(C12621a.f58056b);
                C1016d.m6186f("SdmFileManager", "the file isFileExist is " + file.exists());
                if (!file.exists() || jCurrentTimeMillis >= 604800000) {
                    C1016d.m6186f("SdmFileManager", "libSdm file is not exists or determine whether the libSdm file needs to be updated ");
                    DownloadFileParam downloadFileParam = new DownloadFileParam();
                    downloadFileParam.setFileName("libSdm.7z");
                    downloadFileParam.setSaveFilePath(C12621a.f58055a);
                    downloadFileParam.setServiceType("Sdm");
                    downloadFileParam.setSubType("libSdm");
                    new C6795a(downloadFileParam, new C12849b(c12850c)).m38476c(new C12848a(c12850c));
                } else {
                    C1016d.m6186f("SdmFileManager", "libSdm file is exists and is not need update");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public static void m77158e(C12850c c12850c, File file, String str, String str2) {
        c12850c.getClass();
        synchronized (C12850c.class) {
            try {
                boolean zM58613e = AbstractC9308a.m58613e(file, str);
                StringBuilder sb2 = new StringBuilder();
                String str3 = C12621a.f58055a;
                sb2.append(str3);
                sb2.append(File.separator);
                sb2.append("libSdm.7z");
                String string = sb2.toString();
                if (!zM58613e) {
                    C1016d.m6186f("SdmFileManager", "file is not integrity");
                    new File(string).delete();
                } else if (new C10337b().mo63648a(string, str3)) {
                    c12850c.f58590a.m59627e("libSdm_version_num", str2);
                    c12850c.f58590a.m59626d("libSdm_last_time", System.currentTimeMillis());
                    C1016d.m6186f("SdmFileManager", "unzip plugin success!");
                    new File(string).delete();
                } else {
                    C1016d.m6186f("SdmFileManager", "unzip file fail!");
                    new File(string).delete();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public final void m77159c() {
        C9540e.m59581d().m59582a(new a());
    }
}
