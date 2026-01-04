package com.huawei.hms.network.file.p136b;

import android.text.TextUtils;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.InterfaceC6235f;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.upload.api.FileEntity;
import com.huawei.hms.network.httpclient.RequestBody;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.file.b.c */
/* loaded from: classes8.dex */
public class C6216c extends RequestBody {

    /* renamed from: a */
    private final C6219f f29348a;

    /* renamed from: b */
    private InterfaceC6235f f29349b;

    /* renamed from: c */
    List<FileEntity> f29350c;

    /* renamed from: d */
    long f29351d;

    public C6216c(C6219f c6219f, List<FileEntity> list, InterfaceC6235f interfaceC6235f) {
        this.f29348a = c6219f;
        this.f29349b = interfaceC6235f;
        m36146a(list);
    }

    /* renamed from: a */
    private void m36145a(FileEntity fileEntity, boolean z10) throws IOException {
        if (z10) {
            if (!new File(fileEntity.getFile().getPath()).exists()) {
                throw new FileManagerException(Constants.ErrorCode.FILE_UPLOAD_NO_EXIST.getErrorCode(), "upload file is no exists");
            }
            return;
        }
        try {
            try {
                Utils.close(RequestManager.getAppContext().getContentResolver().openInputStream(fileEntity.getUri()));
            } catch (FileNotFoundException unused) {
                throw new FileManagerException(Constants.ErrorCode.FILE_UPLOAD_NO_EXIST.getErrorCode(), "upload file is no exists for uri");
            }
        } catch (Throwable th2) {
            Utils.close(null);
            throw th2;
        }
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public long contentLength() {
        return this.f29351d;
    }

    @Override // com.huawei.hms.network.httpclient.RequestBody
    public String contentType() {
        Map<String, String> headers = this.f29348a.m36341p().getHeaders();
        return (headers.isEmpty() || TextUtils.isEmpty(headers.get("Content-Type"))) ? FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM : headers.get("Content-Type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x022a, code lost:
    
        r26.f29349b.mo36245a((com.huawei.hms.network.file.core.task.InterfaceC6235f) r26.f29348a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0232, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0233, code lost:
    
        r8 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0236, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0238, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x023b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:183:? -> B:141:0x023e). Please report as a decompilation issue!!! */
    @Override // com.huawei.hms.network.httpclient.RequestBody
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeTo(java.io.OutputStream r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.p136b.C6216c.writeTo(java.io.OutputStream):void");
    }

    /* renamed from: a */
    private void m36146a(List<FileEntity> list) {
        this.f29350c = new ArrayList();
        this.f29351d = 0L;
        if (Utils.isEmpty(list)) {
            return;
        }
        this.f29350c.addAll(list);
        Iterator<FileEntity> it = this.f29350c.iterator();
        while (it.hasNext()) {
            this.f29351d += it.next().getUploadSize();
        }
    }
}
