package p236dt;

import as.C1016d;
import com.huawei.location.lite.common.util.filedownload.C6795a;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6799e;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6800f;
import es.C9540e;
import es.C9549n;
import et.InterfaceC9556a;
import java.io.File;
import p237du.AbstractC9308a;
import p296ft.C9770a;
import p346hs.C10337b;

/* renamed from: dt.b */
/* loaded from: classes8.dex */
public final class C9307b {

    /* renamed from: a */
    public C9549n f46664a;

    /* renamed from: b */
    public String f46665b;

    /* renamed from: c */
    public InterfaceC9556a f46666c;

    /* renamed from: dt.b$a */
    public class a implements InterfaceC6799e {
        public a() {
        }

        @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
        public final void onFail(int i10, String str) {
            C9307b c9307b;
            boolean z10;
            if (i10 == 10005) {
                C9307b.this.f46664a.m59626d("libVdr_last_time", System.currentTimeMillis());
                c9307b = C9307b.this;
                z10 = true;
            } else {
                c9307b = C9307b.this;
                z10 = false;
            }
            C9307b.m58605f(c9307b, z10);
            C1016d.m6183c("VdrFileManager", "download error errorCode:" + i10 + " errorDesc:" + str);
        }

        @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
        public final void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
            if (downLoadFileBean == null) {
                C9307b.m58605f(C9307b.this, false);
            } else {
                C1016d.m6186f("VdrFileManager", "libVdr download Success");
                C9307b.m58604e(C9307b.this, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
            }
        }
    }

    /* renamed from: dt.b$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("Loc-VDR-CheckPlugin" + hashCode());
            C9307b.this.m58606c();
        }
    }

    /* renamed from: e */
    public static void m58604e(C9307b c9307b, File file, String str, String str2) {
        c9307b.getClass();
        synchronized (C9307b.class) {
            try {
                boolean zM58613e = AbstractC9308a.m58613e(file, str);
                StringBuilder sb2 = new StringBuilder();
                String str3 = C9770a.f48054a;
                sb2.append(str3);
                sb2.append(File.separator);
                sb2.append("libVdr.7z");
                String string = sb2.toString();
                if (!zM58613e) {
                    C1016d.m6186f("VdrFileManager", "file is not integrity");
                    new File(string).delete();
                    InterfaceC9556a interfaceC9556a = c9307b.f46666c;
                    if (interfaceC9556a != null) {
                        interfaceC9556a.handleLoadResult(false);
                    }
                } else {
                    if (new C10337b().mo63648a(string, str3)) {
                        InterfaceC9556a interfaceC9556a2 = c9307b.f46666c;
                        if (interfaceC9556a2 != null) {
                            interfaceC9556a2.handleLoadResult(true);
                        }
                        c9307b.f46664a.m59627e("libVdr_version_num", str2);
                        c9307b.f46664a.m59626d("libVdr_last_time", System.currentTimeMillis());
                        C1016d.m6186f("VdrFileManager", "vdr unzip plugin success!");
                        new File(string).delete();
                        return;
                    }
                    C1016d.m6186f("VdrFileManager", "unzip file fail!");
                    new File(string).delete();
                    InterfaceC9556a interfaceC9556a3 = c9307b.f46666c;
                    if (interfaceC9556a3 != null) {
                        interfaceC9556a3.handleLoadResult(false);
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: f */
    public static void m58605f(C9307b c9307b, boolean z10) {
        InterfaceC9556a interfaceC9556a = c9307b.f46666c;
        if (interfaceC9556a != null) {
            interfaceC9556a.handleLoadResult(z10);
        }
    }

    /* renamed from: c */
    public final void m58606c() {
        synchronized (C9307b.class) {
            try {
                C9549n c9549n = new C9549n("sp_libVdrSo_filename");
                this.f46664a = c9549n;
                long jCurrentTimeMillis = System.currentTimeMillis() - c9549n.m59623a("libVdr_last_time");
                this.f46665b = this.f46664a.m59624b("libVdr_version_num");
                File file = new File(C9770a.f48055b);
                C1016d.m6186f("VdrFileManager", "the file isFileExist is " + file.exists());
                if (!file.exists() || jCurrentTimeMillis >= 604800000) {
                    C1016d.m6186f("VdrFileManager", "libVdr file is not exists or determine whether the libVdr file needs to be updated ");
                    DownloadFileParam downloadFileParam = new DownloadFileParam();
                    downloadFileParam.setFileName("libVdr.7z");
                    downloadFileParam.setSaveFilePath(C9770a.f48054a);
                    downloadFileParam.setServiceType("Vdr");
                    downloadFileParam.setSubType("libVdr");
                    new C6795a(downloadFileParam, new InterfaceC6800f() { // from class: dt.a
                        @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6800f
                        /* renamed from: a */
                        public final boolean mo38290a(DownLoadFileBean downLoadFileBean) {
                            return this.f46663a.m58608h(downLoadFileBean);
                        }
                    }).m38476c(new a());
                } else {
                    C1016d.m6186f("VdrFileManager", "libVdr file is exists and is not need update");
                    InterfaceC9556a interfaceC9556a = this.f46666c;
                    if (interfaceC9556a != null) {
                        interfaceC9556a.handleLoadResult(true);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public final void m58607g(InterfaceC9556a interfaceC9556a) {
        this.f46666c = interfaceC9556a;
        C9540e.m59581d().m59582a(new b());
    }

    /* renamed from: h */
    public final boolean m58608h(DownLoadFileBean downLoadFileBean) {
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        File file = new File(C9770a.f48055b);
        C1016d.m6186f("VdrFileManager", "the file isFileExist is " + file.exists());
        if (file.exists()) {
            String str = this.f46665b;
            C1016d.m6186f("VdrFileManager", "versionNumFromServer is: " + version + ", versionNumSp is: " + str);
            if (version.compareTo(str) <= 0) {
                return false;
            }
        }
        return true;
    }
}
