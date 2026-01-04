package com.huawei.hms.network.file.p130a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.C6224b;
import com.huawei.hms.network.file.core.C6225c;
import com.huawei.hms.network.file.core.C6227e;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.C6239j;
import com.huawei.hms.network.file.core.task.C6241l;
import com.huawei.hms.network.file.core.task.ITaskResult;
import com.huawei.hms.network.file.core.task.InterfaceC6232c;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.C6253c;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.network.file.p130a.p131j.p132a.C6196b;
import com.huawei.hms.network.file.p130a.p133k.p134b.C6203e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.hms.network.file.a.b */
/* loaded from: classes8.dex */
public class C6186b implements InterfaceC6232c<GetRequest, C6188d, C6189e> {

    /* renamed from: a */
    C6203e f29268a;

    /* renamed from: b */
    GlobalRequestConfig f29269b;

    /* renamed from: c */
    C6225c f29270c;

    /* renamed from: d */
    String f29271d;

    /* renamed from: e */
    String f29272e;

    /* renamed from: com.huawei.hms.network.file.a.b$a */
    public static class a {

        /* renamed from: a */
        private int f29273a = 0;

        /* renamed from: a */
        public int m36013a() {
            return this.f29273a;
        }

        /* renamed from: b */
        public void m36014b() {
            this.f29273a |= 1;
        }
    }

    public C6186b(Context context, String str, GlobalRequestConfig globalRequestConfig, String str2) {
        this.f29269b = globalRequestConfig;
        this.f29270c = new C6225c(context, globalRequestConfig, str);
        this.f29271d = str;
        this.f29272e = str2;
        C6203e c6203eM36092a = C6203e.m36092a(context);
        this.f29268a = c6203eM36092a;
        if (c6203eM36092a.m36100a()) {
            return;
        }
        FLogger.m36351e("DownloadRequestHandler", "create DB RunTimeException init DB failed!");
        this.f29268a = null;
    }

    /* renamed from: a */
    private int m35978a(GetRequest getRequest, long j10, a aVar) {
        if (getRequest.getConfig() != null) {
            boolean zIsEnableSlice = getRequest.isEnableSlice();
            long speedLimit = getRequest.getSpeedLimit();
            if (!zIsEnableSlice || speedLimit > 0) {
                return 1;
            }
        }
        int iM36186e = C6224b.m36186e();
        if (j10 < iM36186e) {
            return 1;
        }
        int iM36075a = C6196b.m36073b().m36075a(j10, 1000L);
        if (iM36075a > 0) {
            FLogger.m36353i("DownloadRequestHandler", "getSliceNum use predictSliceNum:" + iM36075a, new Object[0]);
            aVar.m36014b();
        } else {
            iM36075a = C6224b.m36185d();
        }
        FLogger.m36353i("DownloadRequestHandler", "getConfigSliceNum sliceThreshold:" + iM36186e + ",sliceNum:" + iM36075a, new Object[0]);
        return iM36075a;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b */
    public C6189e mo36001b() {
        return new C6189e(this.f29269b, this.f29270c.m36194a());
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: c */
    public C6227e<GetRequest> mo36008c(long j10) {
        C6227e<GetRequest> c6227eM36104c;
        C6203e c6203e = this.f29268a;
        if (c6203e == null || (c6227eM36104c = c6203e.m36104c(j10, this.f29271d)) == null) {
            return null;
        }
        if (!AbstractC6240k.m36320d(c6227eM36104c.m36211b())) {
            FLogger.m36350d("DownloadRequestHandler", "getCachedRequest:" + c6227eM36104c.m36210a(), new Object[0]);
            return c6227eM36104c;
        }
        FLogger.m36353i("DownloadRequestHandler", "getCachedRequest request is finished, delete it:" + j10 + ",status:" + c6227eM36104c.m36211b(), new Object[0]);
        this.f29268a.m36093a(j10, this.f29271d);
        return null;
    }

    /* renamed from: d */
    public void m36012d(long j10) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return;
        }
        String strM36093a = c6203e.m36093a(j10, this.f29271d);
        this.f29268a.m36101b(j10, this.f29271d);
        Utils.deleteFile(C6188d.m36018a(j10, strM36093a));
    }

    /* renamed from: c */
    private List<C6188d> m35983c(List<C6188d> list) {
        ArrayList arrayList = new ArrayList();
        for (C6188d c6188d : list) {
            if (c6188d.mo36239c() > 0) {
                arrayList.add(new C6188d(c6188d.m36341p(), c6188d.mo36239c() - 1, c6188d.m36019A(), c6188d.m36031y(), c6188d.m36032z(), c6188d.m36345t(), c6188d.mo36241f()));
            } else {
                arrayList.add(c6188d);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Result mo35984a(GetRequest getRequest) {
        return (Utils.isUrlValid(getRequest.getUrl()) && Utils.isUrlValid(getRequest.getBackupUrls())) ? Result.RESULT_SUCCESS : new Result(Constants.ErrorCode.REQUEST_URL_EMPTY);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b */
    public List<C6188d> mo36002b(long j10) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return null;
        }
        List<C6188d> listM36105d = c6203e.m36105d(j10, this.f29271d);
        C6227e<GetRequest> c6227eMo36008c = mo36008c(j10);
        if (c6227eMo36008c == null) {
            FLogger.m36355w("DownloadRequestHandler", "getCachedTasks requestInfo not exist:" + j10, new Object[0]);
        } else {
            if (m35981b(j10, listM36105d) || c6227eMo36008c.m36210a() == null) {
                if (c6227eMo36008c.m36210a() != null) {
                    a aVar = new a();
                    m35978a((GetRequest) c6227eMo36008c.m36210a(), ((GetRequest) c6227eMo36008c.m36210a()).getFileSize(), aVar);
                    Iterator<C6188d> it = listM36105d.iterator();
                    while (it.hasNext()) {
                        it.next().m36327b(aVar.m36013a());
                    }
                }
                return listM36105d;
            }
            Utils.deleteFile(C6188d.m36018a(j10, ((GetRequest) c6227eMo36008c.m36210a()).getFilePath()));
            this.f29268a.m36101b(j10, this.f29271d);
        }
        return Collections.emptyList();
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ ITaskResult mo35986a(Request request, List list) {
        return m35987a((GetRequest) request, (List<C6188d>) list);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<C6188d> mo36009c(GetRequest getRequest) {
        List<C6188d> listM35979a = m35979a(getRequest, getRequest.getFileSize());
        m35995a(getRequest.getId(), listM35979a);
        return listM35979a;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: c */
    public void mo36010c() {
        this.f29270c.m36199f();
    }

    /* renamed from: a */
    public ITaskResult m35987a(GetRequest getRequest, List<C6188d> list) throws IOException {
        FLogger.m36350d("DownloadRequestHandler", "download compose start", new Object[0]);
        C6188d c6188d = (C6188d) AbstractC6240k.m36317a(list);
        String strM36020B = c6188d.m36020B();
        File fileM36361a = C6253c.m36361a(strM36020B);
        if (!fileM36361a.exists()) {
            FLogger.m36351e("DownloadRequestHandler", "download compose tmpfile not exist");
            return new C6241l(Constants.ErrorCode.TASK_COMPOSE_TMPFILE_ERROR);
        }
        m35980a(getRequest, strM36020B);
        File fileM36361a2 = C6253c.m36361a(c6188d.m36032z());
        if (!fileM36361a.renameTo(fileM36361a2)) {
            FLogger.m36351e("DownloadRequestHandler", "download compose rename file failed!");
            if (fileM36361a2.isDirectory()) {
                FLogger.m36355w("DownloadRequestHandler", "The download file path is a directory. Please add the file name to the download file path!", new Object[0]);
            }
            return new C6241l(Constants.ErrorCode.TASK_COMPOSE_TMPFILE_ERROR);
        }
        FLogger.m36350d("DownloadRequestHandler", "download compose success", new Object[0]);
        C6241l c6241l = new C6241l(Constants.ErrorCode.SUCCESS);
        c6241l.setTask(c6188d);
        if (c6188d.m36346u() != null) {
            c6241l.setRawResponse(c6188d.m36346u().getRawResponse());
        } else {
            FLogger.m36351e("DownloadRequestHandler", "resultResult is null:" + getRequest.getId());
        }
        return c6241l;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo36004b(GetRequest getRequest) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return;
        }
        c6203e.m36098a(getRequest, this.f29271d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.network.file.core.task.InterfaceC6236g m35988a(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1575355461(0xffffffffa219fbbb, float:-2.0868632E-18)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L49
            r1 = -1267495076(0xffffffffb4738f5c, float:-2.2683292E-7)
            if (r0 == r1) goto L3f
            if (r0 == 0) goto L35
            switch(r0) {
                case 3273: goto L2b;
                case 3274: goto L21;
                case 3275: goto L17;
                default: goto L16;
            }
        L16:
            goto L53
        L17:
            java.lang.String r0 = "h3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = 4
            goto L54
        L21:
            java.lang.String r0 = "h2"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = r4
            goto L54
        L2b:
            java.lang.String r0 = "h1"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = 0
            goto L54
        L35:
            java.lang.String r0 = ""
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = 5
            goto L54
        L3f:
            java.lang.String r0 = "h3_pcc"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = r3
            goto L54
        L49:
            java.lang.String r0 = "h3_pcc_multipath"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = r2
            goto L54
        L53:
            r6 = -1
        L54:
            if (r6 == 0) goto Laf
            if (r6 == r4) goto L98
            if (r6 == r3) goto L81
            if (r6 == r2) goto L6a
            com.huawei.hms.network.file.a.e r6 = new com.huawei.hms.network.file.a.e
            com.huawei.hms.network.file.api.GlobalRequestConfig r0 = r5.f29269b
            com.huawei.hms.network.file.core.c r5 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r5 = r5.m36194a()
            r6.<init>(r0, r5)
            return r6
        L6a:
            com.huawei.hms.network.file.core.c r6 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36198e()
            com.huawei.hms.network.file.a.e r0 = new com.huawei.hms.network.file.a.e
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29269b
            if (r6 == 0) goto L77
            goto L7d
        L77:
            com.huawei.hms.network.file.core.c r5 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        L7d:
            r0.<init>(r1, r6)
            return r0
        L81:
            com.huawei.hms.network.file.core.c r6 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36197d()
            com.huawei.hms.network.file.a.e r0 = new com.huawei.hms.network.file.a.e
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29269b
            if (r6 == 0) goto L8e
            goto L94
        L8e:
            com.huawei.hms.network.file.core.c r5 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        L94:
            r0.<init>(r1, r6)
            return r0
        L98:
            com.huawei.hms.network.file.core.c r6 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36196c()
            com.huawei.hms.network.file.a.e r0 = new com.huawei.hms.network.file.a.e
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29269b
            if (r6 == 0) goto La5
            goto Lab
        La5:
            com.huawei.hms.network.file.core.c r5 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        Lab:
            r0.<init>(r1, r6)
            return r0
        Laf:
            com.huawei.hms.network.file.core.c r6 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36195b()
            com.huawei.hms.network.file.a.e r0 = new com.huawei.hms.network.file.a.e
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29269b
            if (r6 == 0) goto Lbc
            goto Lc2
        Lbc:
            com.huawei.hms.network.file.core.c r5 = r5.f29270c
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        Lc2:
            r0.<init>(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.p130a.C6186b.m35988a(java.lang.String):com.huawei.hms.network.file.core.task.g");
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public C6239j mo35989a() {
        return new C6187c(this);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo36005b(GetRequest getRequest, InterfaceC6234e.a aVar) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return;
        }
        c6203e.m36097a(getRequest, aVar, this.f29271d);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ List mo35990a(Request request, List list, long j10) {
        return m35991a((GetRequest) request, (List<C6188d>) list, j10);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b */
    public void mo36007b(List<C6188d> list) {
        if (this.f29268a == null) {
            return;
        }
        this.f29268a.m36099a(m35983c(list), this.f29271d);
    }

    /* renamed from: a */
    private List<C6188d> m35979a(GetRequest getRequest, long j10) {
        C6186b c6186b = this;
        a aVar = new a();
        int iM35978a = c6186b.m35978a(getRequest, j10, aVar);
        long j11 = j10 / iM35978a;
        ArrayList arrayList = new ArrayList();
        String filePath = "";
        int i10 = 0;
        while (i10 < iM35978a) {
            long j12 = i10 * j11;
            long j13 = i10 == iM35978a + (-1) ? j10 - 1 : (j12 + j11) - 1;
            long offset = getRequest.getOffset() + j12;
            long offset2 = j13 < 0 ? -1L : j13 + getRequest.getOffset();
            if (TextUtils.isEmpty(filePath)) {
                filePath = getRequest.getFilePath();
                if (TextUtils.isEmpty(filePath)) {
                    filePath = c6186b.f29272e + "hwdownloadfile_" + getRequest.getId();
                }
            }
            String str = filePath;
            ArrayList arrayList2 = arrayList;
            C6188d c6188d = new C6188d(getRequest, 0L, offset, offset2, str, iM35978a);
            c6188d.m36327b(aVar.m36013a());
            arrayList2.add(c6188d);
            i10++;
            arrayList = arrayList2;
            filePath = str;
            c6186b = this;
        }
        return arrayList;
    }

    /* renamed from: b */
    private boolean m35981b(long j10, List<C6188d> list) {
        if (Utils.isEmpty(list)) {
            return true;
        }
        C6227e<GetRequest> c6227eMo36008c = mo36008c(j10);
        if (c6227eMo36008c == null) {
            FLogger.m36355w("DownloadRequestHandler", "checkAndFillDownloadTasks requestInfo not exist:" + j10, new Object[0]);
            return false;
        }
        int size = list.size();
        String filePath = null;
        for (C6188d c6188d : list) {
            c6188d.mo36233a((C6188d) c6227eMo36008c.m36210a());
            c6188d.m36025b(((GetRequest) c6227eMo36008c.m36210a()).getFileSize());
            c6188d.m36027e(size);
            if (Utils.isBlank(c6188d.m36032z())) {
                if (Utils.isBlank(filePath)) {
                    filePath = ((GetRequest) c6227eMo36008c.m36210a()).getFilePath();
                    c6188d.m36028f(filePath);
                    FLogger.m36355w("DownloadRequestHandler", "checkDownloadTasks fix filePath:" + filePath, new Object[0]);
                } else {
                    c6188d.m36028f(filePath);
                }
            }
            if (!C6253c.m36361a(c6188d.m36020B()).exists()) {
                FLogger.m36355w("DownloadRequestHandler", "cached task tmpFile not exist taskid:" + c6188d.mo36241f(), new Object[0]);
                return false;
            }
            if (c6188d.m36031y() > 0 && c6188d.m36019A() > c6188d.m36031y()) {
                FLogger.m36355w("DownloadRequestHandler", "task pos invfalid:" + c6188d, new Object[0]);
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private boolean m35982b(GetRequest getRequest, String str) throws Throwable {
        String sha256 = getRequest.getSha256();
        if (Utils.isBlank(sha256)) {
            FLogger.m36355w("DownloadRequestHandler", "checkDownloadedFile warning: file sha256 is null", new Object[0]);
            return true;
        }
        String fileHashData = Utils.getFileHashData(str, "SHA-256");
        if (sha256.equalsIgnoreCase(fileHashData)) {
            return true;
        }
        FLogger.m36355w("DownloadRequestHandler", "file sha256 check failed expect:" + StringUtils.anonymizeMessage(sha256) + ", actual:" + StringUtils.anonymizeMessage(fileHashData), new Object[0]);
        return false;
    }

    /* renamed from: a */
    public List<C6188d> m35991a(GetRequest getRequest, List<C6188d> list, long j10) {
        int iM36186e = C6224b.m36186e();
        if (j10 < iM36186e) {
            FLogger.m36353i("DownloadRequestHandler", "onTaskChange no need slice again for size:" + j10 + ",sliceThreshold:" + iM36186e, new Object[0]);
        } else {
            List<C6188d> listM35979a = m35979a(getRequest, j10);
            if (!Utils.isEmpty(listM35979a) && listM35979a.size() > 1) {
                m35997a(listM35979a.get(0), list.get(0));
                List<C6188d> listSubList = listM35979a.subList(1, listM35979a.size());
                ArrayList arrayList = new ArrayList();
                arrayList.add(list.get(0));
                arrayList.addAll(listSubList);
                C6203e c6203e = this.f29268a;
                if (c6203e != null) {
                    c6203e.m36102b(getRequest.getId(), arrayList, this.f29271d);
                }
                return listSubList;
            }
            FLogger.m36353i("DownloadRequestHandler", "onTaskChange newTasks size is too small", new Object[0]);
        }
        return Collections.emptyList();
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public List<GetRequest> mo35992a(boolean z10) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return null;
        }
        List<C6227e<GetRequest>> listM36094a = c6203e.m36094a(this.f29271d);
        ArrayList arrayList = new ArrayList();
        if (!Utils.isEmpty(listM36094a)) {
            for (C6227e<GetRequest> c6227e : listM36094a) {
                if (!z10 || !AbstractC6240k.m36320d(c6227e.m36211b())) {
                    arrayList.add((GetRequest) c6227e.m36210a());
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public Set<Long> mo35993a(int i10) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return null;
        }
        return c6203e.m36095a(this.f29271d, i10);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public void mo35994a(long j10) {
        FLogger.m36353i("DownloadRequestHandler", "onRequestCanceled:" + j10, new Object[0]);
        m36012d(j10);
    }

    /* renamed from: a */
    public void m35995a(long j10, List<C6188d> list) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return;
        }
        c6203e.m36096a(j10, list, this.f29271d);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public void mo35996a(long j10, boolean z10) {
        C6203e c6203e = this.f29268a;
        if (c6203e == null) {
            return;
        }
        c6203e.m36101b(j10, this.f29271d);
        if (z10) {
            return;
        }
        String strM36093a = this.f29268a.m36093a(j10, this.f29271d);
        if (Utils.isBlank(strM36093a)) {
            return;
        }
        Utils.deleteFile(C6188d.m36018a(j10, strM36093a));
    }

    /* renamed from: a */
    public void m35997a(C6188d c6188d, C6188d c6188d2) {
        c6188d2.m36023a(c6188d.m36019A(), c6188d.m36031y());
        c6188d2.m36027e(c6188d.m36345t());
        c6188d2.m36327b(c6188d.m36337k());
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo35998a(GetRequest getRequest, InterfaceC6234e.a aVar) {
        if (this.f29268a == null) {
            return;
        }
        if (aVar == InterfaceC6234e.a.INVALID) {
            FLogger.m36353i("DownloadRequestHandler", "onRequestStatusChanged delete request data," + getRequest.getId() + ",status:" + aVar, new Object[0]);
            m36012d(getRequest.getId());
            return;
        }
        FLogger.m36353i("DownloadRequestHandler", "onRequestStatusChanged update, " + getRequest.getId() + ",status:" + aVar, new Object[0]);
        this.f29268a.m36103b(getRequest, aVar, this.f29271d);
    }

    /* renamed from: a */
    private void m35980a(GetRequest getRequest, String str) throws IOException {
        try {
            try {
                RandomAccessFile randomAccessFileM36362a = C6253c.m36362a(str, "r");
                if (getRequest.getFileSize() > 0 && randomAccessFileM36362a.length() != getRequest.getFileSize()) {
                    String str2 = " fileSize= " + randomAccessFileM36362a.length() + " vs " + getRequest.getFileSize();
                    FLogger.m36351e("DownloadRequestHandler", "file length error:" + str2);
                    throw new FileManagerException(Constants.ErrorCode.FILE_SIZE_ERROR, str2);
                }
                if (!m35982b(getRequest, str)) {
                    FLogger.m36351e("DownloadRequestHandler", "downloadTask : " + getRequest.getId() + "check file hash failed");
                    throw new FileManagerException(Constants.ErrorCode.CHECK_FILE_HASH_FAILED);
                }
                FLogger.m36353i("DownloadRequestHandler", "downloadTask id: " + getRequest.getId() + " checkDownloadedFile succeed", new Object[0]);
                Utils.close(randomAccessFileM36362a);
            } catch (IOException unused) {
                throw new FileManagerException(Constants.ErrorCode.FILE_IO_EXCEPTION);
            }
        } catch (Throwable th2) {
            Utils.close(null);
            throw th2;
        }
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public boolean mo36000a(List<C6188d> list) {
        AbstractC6240k abstractC6240kM36317a = AbstractC6240k.m36317a(list);
        if (C6253c.m36361a(((C6188d) Utils.cast(abstractC6240kM36317a)).m36020B()).exists()) {
            return true;
        }
        FLogger.m36355w("DownloadRequestHandler", "task tmpFile not exist taskid:" + abstractC6240kM36317a.mo36241f(), new Object[0]);
        return false;
    }
}
