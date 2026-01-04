package p220d8;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.able.Requestable;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009a8.C0076n;
import p031b7.C1120a;
import p031b7.C1122c;
import p635s7.C12721a0;
import p635s7.C12723b0;
import p635s7.C12730f;
import p635s7.C12732g;
import p635s7.C12734h;
import p635s7.C12736i;
import p635s7.C12740k;
import p635s7.C12742l;
import p635s7.C12744m;
import p635s7.C12746n;
import p635s7.C12750p;
import p709vj.C13452e;
import p731w7.AbstractC13546m;
import p731w7.C13536c;

/* renamed from: d8.b */
/* loaded from: classes2.dex */
public class C9048b {

    /* renamed from: a */
    public Context f45713a;

    /* renamed from: b */
    public CallbackHandler f45714b;

    /* renamed from: c */
    public Requestable f45715c;

    /* renamed from: d */
    public AbstractC13546m<Bundle> f45716d = new a();

    /* renamed from: d8.b$a */
    public class a extends AbstractC13546m<Bundle> {
        public a() {
        }

        @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
        /* renamed from: a */
        public void mo15144a(int i10, Response<Bundle> response) {
            C1120a.m6676e("GeneralSyncServiceLogic", "Network Request or Business Failed, Id: " + i10);
            C9048b.this.m57048o(i10, true, response.get());
        }

        @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
        /* renamed from: e */
        public void mo15148e(int i10, Response<Bundle> response) {
            C1120a.m6675d("GeneralSyncServiceLogic", "Request Succeed, Id: " + i10);
            C9048b.this.m57047n(i10, response.get());
        }
    }

    public C9048b(Context context, CallbackHandler callbackHandler, Requestable requestable) {
        this.f45713a = context;
        this.f45715c = requestable;
        this.f45714b = callbackHandler;
    }

    /* renamed from: c */
    public void m57036c(List<FileData> list, String str, String str2, long j10, long j11) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            FileData next = it.next();
            if (next != null) {
                String strM6841w = C1122c.m6841w(next);
                C1120a.m6675d("GeneralSyncServiceLogic", "copyGeneralFiles tempFileKey: " + strM6841w);
                Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 2);
                if (numM15193q != null && numM15193q.intValue() > 10) {
                    arrayList.add(next);
                    sb2.append(C1122c.m6818p0(next.getFileName()));
                    sb2.append("_");
                    sb2.append(next.getAlbumId());
                    sb2.append(";");
                    it.remove();
                }
            }
        }
        C1120a.m6677i("GeneralSyncServiceLogic", "copyGeneralFiles currentCopyFiles: " + list.size());
        if (!arrayList.isEmpty()) {
            C1120a.m6677i("GeneralSyncServiceLogic", "copyGeneralFiles, copyRepeatFiles size: " + arrayList.size());
            new CommonOpsReport(this.f45713a).m15209C(str2, "repeat_copy", 1004, sb2.toString());
        }
        C1120a.m6677i("GeneralSyncServiceLogic", "copyGeneralFiles, end size: " + list.size());
        if (list.isEmpty()) {
            m57049p(str2, arrayList, 1004, "copy repeat");
            return;
        }
        int size = list.size();
        List<FileUpdatedResult> arrayList2 = new ArrayList<>();
        List<FileData> listM57050q = m57050q(str2, list, arrayList2, j10, j11);
        if (listM57050q != null) {
            this.f45715c.request(9035, str2, new C13536c(), new C12730f(this.f45713a, str2, listM57050q, str, arrayList2), this.f45716d);
            return;
        }
        C1120a.m6678w("GeneralSyncServiceLogic", "No need to copy " + size + " files!");
    }

    /* renamed from: d */
    public void m57037d(List<GeneralAlbumData> list, String str, String str2) {
        this.f45715c.request(9021, str2, new C13536c(), new C12732g(this.f45713a, str2, list, str), this.f45716d);
    }

    /* renamed from: e */
    public void m57038e(List<String> list, String str, String str2) {
        this.f45715c.request(9023, str2, new C13536c(), new C12734h(this.f45713a, str2, list, str), this.f45716d);
    }

    /* renamed from: f */
    public void m57039f(List<FileData> list, String str, String str2) {
        this.f45715c.request(9033, str2, new C13536c(), new C12736i(this.f45713a, str2, list, str), this.f45716d);
    }

    /* renamed from: g */
    public void m57040g(List<String> list, int i10, int i11, String str) {
        this.f45715c.request(9012, str, new C13536c(), new C12740k(this.f45713a, str, list, i10, i11), this.f45716d);
    }

    /* renamed from: h */
    public void m57041h(String str, List<String> list, int i10, int i11, String str2) {
        this.f45715c.request(9088, str, new C13536c(), new C12742l(this.f45713a, str, list, i10, i11, str2), this.f45716d);
    }

    /* renamed from: i */
    public void m57042i(List<String> list, long j10, int i10, String str, String str2) {
        this.f45715c.request(9013, str2, new C13536c(), new C12744m(this.f45713a, str2, list, j10, i10, str), this.f45716d);
    }

    /* renamed from: j */
    public void m57043j(String str, List<SimplifyInfo> list, boolean z10) {
        this.f45715c.request(9089, str, new C13536c(), new C12746n(this.f45713a, str, list, z10), this.f45716d);
    }

    /* renamed from: k */
    public void m57044k(String str) {
        this.f45715c.request(9011, str, new C13536c(), new C12750p(this.f45713a, str), this.f45716d);
    }

    /* renamed from: l */
    public void m57045l(List<GeneralAlbumData> list, String str, String str2) {
        this.f45715c.request(9022, str2, new C13536c(), new C12723b0(this.f45713a, str2, list, str), this.f45716d);
    }

    /* renamed from: m */
    public void m57046m(List<FileData> list, String str, String str2) {
        this.f45715c.request(9032, str2, new C13536c(), new C12721a0(this.f45713a, str2, list, str), this.f45716d);
    }

    /* renamed from: n */
    public final void m57047n(int i10, Bundle bundle) {
        m57048o(i10, false, bundle);
    }

    /* renamed from: o */
    public final void m57048o(int i10, boolean z10, Bundle bundle) {
        if (z10) {
            i10 += 100;
        }
        this.f45714b.sendMessage(i10, bundle);
    }

    /* renamed from: p */
    public final void m57049p(String str, List<FileData> list, int i10, String str2) {
        Bundle bundleM76552x = C12730f.m76552x(list, null, i10, str2);
        if (!TextUtils.isEmpty(str)) {
            bundleM76552x.putString("sessionId", str);
        }
        bundleM76552x.putParcelable("HttpResult", new HttpResult(200, i10, str2));
        m57048o(9035, true, bundleM76552x);
    }

    /* renamed from: q */
    public final List<FileData> m57050q(String str, List<FileData> list, List<FileUpdatedResult> list2, long j10, long j11) {
        long j12;
        String str2;
        String str3 = "GeneralSyncServiceLogic";
        if (C13452e.m80781L().m80791C0()) {
            C1120a.m6678w("GeneralSyncServiceLogic", "sync permission:The basic data service user cannot copy.");
            m57049p(str, list, FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "sync permission:The basic data service user cannot copy.");
            return null;
        }
        if (j10 == -1 || j11 == -1) {
            return list;
        }
        long j13 = j10 - j11;
        long size = 0;
        int i10 = 122;
        if (j13 < 5242880) {
            C1120a.m6678w("GeneralSyncServiceLogic", "Remaining space is lower than 5242880");
            Iterator<FileData> it = list.iterator();
            while (it.hasNext()) {
                size += it.next().getSize();
            }
            C0076n.m619a().m627i(size + j11);
            m57049p(str, list, 122, "Insufficient user space");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FileData fileData : list) {
            if (size + fileData.getSize() <= j13) {
                size += fileData.getSize();
                arrayList.add(fileData);
                j12 = j13;
                str2 = str3;
            } else {
                size += fileData.getSize();
                C1120a.m6675d(str3, "totalNeedSize: " + size + j11 + " totalFileSize: " + size);
                j12 = j13;
                str2 = str3;
                C0076n.m619a().m627i(size + j11);
                i10 = 122;
                list2.add(new FileUpdatedResult(fileData.getLocalId(), fileData.getUniqueId(), 122, "Insufficient user space"));
            }
            str3 = str2;
            j13 = j12;
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        m57049p(str, list, i10, "Insufficient user space");
        return null;
    }
}
