package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import as.C1016d;
import com.huawei.location.lite.common.chain.AbstractC6777a;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.InterfaceC6778b;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import p531or.C11991a;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import p785xr.C13852b;
import p785xr.C13853c;
import tr.C13058b;

/* renamed from: com.huawei.location.lite.common.util.filedownload.c */
/* loaded from: classes8.dex */
public class C6797c extends C6796b {

    /* renamed from: d */
    public InterfaceC6800f f31394d;

    @Override // com.huawei.location.lite.common.util.filedownload.C6796b, com.huawei.location.lite.common.chain.InterfaceC6778b
    /* renamed from: a */
    public void mo38411a(InterfaceC6778b.a aVar) {
        int i10;
        String str;
        super.mo38411a(aVar);
        Parcelable parcelableM38398c = this.f31391a.m38427c().m38398c("download_entity");
        if (parcelableM38398c instanceof DownLoadFileBean) {
            DownLoadFileBean downLoadFileBean = (DownLoadFileBean) parcelableM38398c;
            InterfaceC6800f interfaceC6800f = this.f31394d;
            if (interfaceC6800f == null || interfaceC6800f.mo38290a(downLoadFileBean)) {
                m38481f(downLoadFileBean);
                return;
            } else {
                i10 = 10005;
                str = "business not need download file";
            }
        } else {
            i10 = 10003;
            str = "The data format error";
        }
        m38477b(i10, str);
    }

    /* renamed from: c */
    public final void m38478c(byte[] bArr) {
        DownloadFileParam downloadFileParam;
        if (bArr == null || bArr.length <= 0 || (downloadFileParam = this.f31393c) == null) {
            C1016d.m6183c("DownloadFileTask", "responseBody is null");
        } else {
            this.f31391a.m38435k(AbstractC6777a.m38409d(new Data.C6776a().m38402c(this.f31391a.m38427c()).m38401b("download_file", m38482g(downloadFileParam.getSaveFilePath(), this.f31393c.getFileName(), bArr)).m38400a()), this.f31392b);
        }
    }

    /* renamed from: d */
    public final StringBuilder m38479d(URI uri) {
        StringBuilder sb2 = new StringBuilder(0);
        sb2.append(uri.getPath());
        if (!TextUtils.isEmpty(uri.getQuery())) {
            sb2.append(Constants.QUESTION_STR);
            sb2.append(uri.getQuery());
        }
        return sb2;
    }

    /* renamed from: e */
    public final boolean m38480e(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !URLUtil.isHttpsUrl(str)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public final void m38481f(DownLoadFileBean downLoadFileBean) {
        StringBuilder sb2;
        String strM79632d;
        C13245e c13245e;
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        String url = downLoadFileBean.getFileAccessInfo().getUrl();
        String fileSha256 = downLoadFileBean.getFileAccessInfo().getFileSha256();
        if (TextUtils.isEmpty(version) || TextUtils.isEmpty(url) || TextUtils.isEmpty(fileSha256)) {
            m38477b(10004, "download url format error with empty data");
            return;
        }
        if (!m38480e(url, fileSha256)) {
            m38477b(10004, "download url not https or sha256 error");
            return;
        }
        try {
            URI uri = new URI(url);
            if (!m38484i(uri)) {
                m38477b(10004, "download url format error");
                return;
            }
            StringBuilder sb3 = new StringBuilder(0);
            sb3.append(uri.getScheme());
            sb3.append("://");
            sb3.append(uri.getHost());
            StringBuilder sbM38479d = m38479d(uri);
            C13851a.a aVarM83147q = new C13851a.a(sbM38479d.toString()).m83146p(new C13852b(UUID.randomUUID().toString())).m83144n(new C13853c.a().m83160e()).m83143m(sb3.toString()).m83147q("GET");
            try {
                m38478c(new HttpClientEx(C11991a.m72146b(), new C13058b().m78787c(false)).m38437a(aVarM83147q.m83141k()).mo38438a());
            } catch (C13244d e10) {
                sb2 = new StringBuilder("apiErrorCode====");
                sb2.append(e10.m79631c());
                sb2.append("apiErrorMsg=====");
                strM79632d = e10.m79632d();
                c13245e = e10;
                sb2.append(strM79632d);
                C1016d.m6183c("DownloadFileTask", sb2.toString());
                m38477b(c13245e.m79628b().f59923a, c13245e.m79628b().f59924b);
            } catch (C13245e e11) {
                sb2 = new StringBuilder("errorCode====");
                sb2.append(e11.m79628b().f59923a);
                sb2.append("errorMsg=====");
                strM79632d = e11.m79628b().f59924b;
                c13245e = e11;
                sb2.append(strM79632d);
                C1016d.m6183c("DownloadFileTask", sb2.toString());
                m38477b(c13245e.m79628b().f59923a, c13245e.m79628b().f59924b);
            }
        } catch (URISyntaxException unused) {
            m38477b(10004, "download url MalformedURLException");
            C1016d.m6183c("DownloadFileTask", "MalformedURLException");
        }
    }

    /* renamed from: g */
    public final File m38482g(String str, String str2, byte[] bArr) throws IOException {
        File file = new File(str, str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("DownloadFileTask", "saveToSd createSdFile stream read write exception");
        }
        return file;
    }

    /* renamed from: h */
    public void m38483h(InterfaceC6800f interfaceC6800f) {
        this.f31394d = interfaceC6800f;
    }

    /* renamed from: i */
    public final boolean m38484i(URI uri) {
        String str;
        if (uri == null) {
            str = "uri is null";
        } else if (TextUtils.isEmpty(uri.getScheme())) {
            str = "uri scheme is undefined";
        } else if (TextUtils.isEmpty(uri.getHost())) {
            str = "uri host is undefined";
        } else {
            if (!TextUtils.isEmpty(uri.getPath())) {
                return true;
            }
            str = "uri path is undefined";
        }
        C1016d.m6183c("DownloadFileTask", str);
        return false;
    }
}
