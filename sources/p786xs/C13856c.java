package p786xs;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;
import p531or.C11991a;
import p688ur.C13241a;
import p688ur.C13243c;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import p785xr.C13852b;
import p785xr.C13853c;
import sr.C12847b;
import tr.C13058b;

/* renamed from: xs.c */
/* loaded from: classes8.dex */
public final class C13856c {
    /* renamed from: a */
    public static String m83165a(String str) {
        StringBuilder sb2;
        C13243c c13243cM79628b;
        String string;
        try {
            C13853c.a aVar = new C13853c.a();
            C13852b c13852b = new C13852b(String.valueOf(UUID.randomUUID()));
            String strM77149d = C12847b.m77149d("com.huawei.configserver");
            if (TextUtils.isEmpty(strM77149d)) {
                C1016d.m6186f("DownloadUtils", "Failed to obtain the domain name using GRS.");
                return null;
            }
            return new String(new HttpClientEx().m38437a(new C13851a.a("/servicesupport/updateserver/data/com.huawei.higeo_dataModule_SDMConfigV2?cityId=" + str).m83143m(strM77149d).m83146p(c13852b).m83147q("GET").m83144n(aVar.m83160e()).m83141k()).mo38438a(), Constants.UTF_8);
        } catch (IOException e10) {
            if (!(e10 instanceof C13241a)) {
                string = "IOException:" + C13243c.m79629a(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED) + "," + C13243c.m79630b(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED);
                C1016d.m6183c("DownloadUtils", string);
                return null;
            }
            C13241a c13241a = (C13241a) e10;
            sb2 = new StringBuilder("IOException:");
            sb2.append(c13241a.m79627b().f59923a);
            sb2.append(",");
            c13243cM79628b = c13241a.m79627b();
            sb2.append(c13243cM79628b.f59924b);
            string = sb2.toString();
            C1016d.m6183c("DownloadUtils", string);
            return null;
        } catch (C13244d e11) {
            string = "OnErrorException:code:" + e11.m79628b().f59923a + ",apiCode:" + e11.m79631c() + ",apiMsg:" + e11.m79632d();
            C1016d.m6183c("DownloadUtils", string);
            return null;
        } catch (C13245e e12) {
            sb2 = new StringBuilder("OnFailureException:");
            sb2.append(e12.m79628b().f59923a);
            sb2.append(",");
            c13243cM79628b = e12.m79628b();
            sb2.append(c13243cM79628b.f59924b);
            string = sb2.toString();
            C1016d.m6183c("DownloadUtils", string);
            return null;
        }
    }

    /* renamed from: b */
    public static synchronized boolean m83166b(String str, String str2, String str3, String str4) {
        C1016d.m6186f("DownloadUtils", "download zip files from the cloud");
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (new File(str).exists()) {
                C1016d.m6186f("DownloadUtils", "The file already exists.");
                return false;
            }
            String str5 = str + ".temp";
            File file = new File(str5);
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                C1016d.m6183c("DownloadUtils", "Failed to create the file directory.");
                return false;
            }
            if (file.exists()) {
                C1016d.m6183c("DownloadUtils", "The file is being downloaded.");
                return false;
            }
            try {
                URI uriCreate = URI.create(str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(uriCreate.getScheme());
                sb2.append(File.pathSeparator);
                String str6 = File.separator;
                sb2.append(str6);
                sb2.append(str6);
                sb2.append(uriCreate.getHost());
                byte[] bArrM83167c = m83167c(sb2.toString(), uriCreate.getPath());
                if (bArrM83167c.length <= 0) {
                    C1016d.m6181a("DownloadUtils", "zip file InputStream is null");
                    return false;
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                    try {
                        fileOutputStream.write(bArrM83167c, 0, bArrM83167c.length);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (IOException unused) {
                    C1016d.m6183c("FileUtils", "saveToSd createSdFile stream read write exception");
                }
                String strM83182a = C13860g.m83182a(str5, str3);
                if (!TextUtils.isEmpty(strM83182a) && strM83182a.equals(str4)) {
                    if (file.renameTo(new File(str))) {
                        C1016d.m6181a("DownloadUtils", "download file success");
                        C1016d.m6186f("DownloadUtils", "The zip file is downloaded successfully.");
                        return true;
                    }
                    file.delete();
                    C1016d.m6181a("DownloadUtils", "download file error");
                    return false;
                }
                file.delete();
                C1016d.m6181a("DownloadUtils", "Signature verification failed");
                return false;
            } catch (IllegalArgumentException unused2) {
                file.delete();
                C1016d.m6183c("DownloadUtils", "downloadUrl is illegal");
                return false;
            }
        }
        C1016d.m6183c("DownloadUtils", "The url or file path is abnormal.");
        return false;
    }

    /* renamed from: c */
    public static byte[] m83167c(String str, String str2) {
        StringBuilder sb2;
        String strM79632d;
        try {
            C13853c.a aVar = new C13853c.a();
            return new HttpClientEx(C11991a.m72145a(), new C13058b().m78786b(false)).m38437a(new C13851a.a(str2).m83143m(str).m83146p(new C13852b(String.valueOf(UUID.randomUUID()))).m83147q("GET").m83144n(aVar.m83160e()).m83141k()).mo38438a();
        } catch (C13244d e10) {
            sb2 = new StringBuilder("OnErrorException:code:");
            sb2.append(e10.m79628b().f59923a);
            sb2.append(",apiCode:");
            sb2.append(e10.m79631c());
            sb2.append(",apiMsg:");
            strM79632d = e10.m79632d();
            sb2.append(strM79632d);
            C1016d.m6183c("DownloadUtils", sb2.toString());
            return new byte[0];
        } catch (C13245e e11) {
            sb2 = new StringBuilder("OnFailureException:");
            sb2.append(e11.m79628b().f59923a);
            sb2.append(",");
            strM79632d = e11.m79628b().f59924b;
            sb2.append(strM79632d);
            C1016d.m6183c("DownloadUtils", sb2.toString());
            return new byte[0];
        }
    }
}
