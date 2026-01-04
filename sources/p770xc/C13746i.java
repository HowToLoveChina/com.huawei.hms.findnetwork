package p770xc;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.sync.bean.ReportInfo;
import com.huawei.android.hicloud.sync.bean.ReportSyncInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import je.C10812z;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13226e;

/* renamed from: xc.i */
/* loaded from: classes3.dex */
public class C13746i extends AbstractC12367d {

    /* renamed from: a */
    public Context f61796a;

    /* renamed from: b */
    public String f61797b;

    /* renamed from: c */
    public String f61798c;

    /* renamed from: d */
    public String f61799d;

    /* renamed from: e */
    public String f61800e;

    /* renamed from: f */
    public String f61801f;

    /* renamed from: g */
    public String f61802g;

    /* renamed from: xc.i$b */
    public static class b extends TypeToken<ArrayList<ReportInfo>> {
        public b() {
        }
    }

    public C13746i(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f61796a = context;
        this.f61797b = str;
        this.f61798c = str2;
        this.f61799d = str3;
        this.f61800e = str4;
        this.f61801f = str5;
        this.f61802g = str6;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        int i10;
        int i11;
        if (this.f61796a == null) {
            C11839m.m70688i("ReportTask", "report error: context is null");
            return;
        }
        String str = this.f61799d;
        if (str == null || str.isEmpty()) {
            C11839m.m70689w("ReportTask", "report error: reportJson is null or empty");
            return;
        }
        C11839m.m70688i("ReportTask", "reportEvent: syncType = " + this.f61797b + ", reportJson = " + this.f61799d);
        ArrayList arrayList = null;
        try {
            arrayList = (ArrayList) new Gson().fromJson(this.f61799d, new b().getType());
        } catch (JsonSyntaxException e10) {
            C11839m.m70688i("ReportTask", "ReportInfo err " + e10.getMessage());
        }
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ReportInfo reportInfo = (ReportInfo) it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("business_id", reportInfo.getBusinessId());
            linkedHashMap.put("returnCode", reportInfo.getReturnCode());
            linkedHashMap.put("syncInfo", reportInfo.getSyncInfo());
            linkedHashMap.putAll(C10812z.m65833b(this.f61798c));
            C10812z.m65846o(this.f61796a, this.f61797b, 0, "", this.f61800e, this.f61801f, this.f61802g, linkedHashMap, false);
            if ("json".equals(reportInfo.getSyncInfoType()) && "local_local_changes".equals(reportInfo.getBusinessId())) {
                try {
                    ReportSyncInfo reportSyncInfo = (ReportSyncInfo) new Gson().fromJson(reportInfo.getSyncInfo(), ReportSyncInfo.class);
                    int localIdNum = reportSyncInfo.getLocalIdNum();
                    int localETagNum = reportSyncInfo.getLocalETagNum();
                    int addedNum = reportSyncInfo.getAddedNum() + reportSyncInfo.getRecycleAddedNum();
                    int addedNum2 = reportSyncInfo.getAddedNum() - addedNum;
                    int deletedNum = reportSyncInfo.getDeletedNum();
                    int i12 = (localETagNum + addedNum) - localIdNum;
                    if (i12 != deletedNum) {
                        i11 = deletedNum;
                        i10 = i12;
                    } else {
                        i10 = deletedNum;
                        i11 = 0;
                    }
                    C13226e.m79491f1().m79570S0(this.f61797b, reportSyncInfo.getDataType(), localIdNum, localETagNum, addedNum, i10, i11, addedNum2);
                } catch (JsonSyntaxException e11) {
                    C11839m.m70688i("ReportTask", "LOCAL_CHANGES err " + e11.getMessage());
                }
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_FIX;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public void release() {
        super.release();
        C12515a.m75110o().m75165a1(this);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
