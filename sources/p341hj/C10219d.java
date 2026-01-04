package p341hj;

import android.database.SQLException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.cloud.pay.model.AdAppsReportReq;
import com.huawei.hicloud.bean.AppHistoryBean;
import com.huawei.hicloud.notification.p106db.operator.AppHistoryOperator;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import p015ak.C0212e0;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;
import p815ym.AbstractC14026a;

/* renamed from: hj.d */
/* loaded from: classes5.dex */
public class C10219d extends AbstractC10222e {

    /* renamed from: d */
    public String f49554d;

    /* renamed from: b */
    public AppHistoryOperator f49552b = new AppHistoryOperator();

    /* renamed from: e */
    public List<String> f49555e = new ArrayList();

    /* renamed from: c */
    public int f49553c = 0;

    /* renamed from: hj.d$a */
    public class a extends TypeToken<List<AppHistoryBean>> {
        public a() {
        }
    }

    public C10219d(String str) {
        this.f49554d = str;
    }

    /* renamed from: k */
    public static /* synthetic */ String m63366k(String str) {
        return "'" + str + "'";
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() throws SQLException {
        List<AdAppsReportReq.AdAppInfo> listM63368j;
        C1442a.m8290i("AdAppsReportTask", "AdAppsReport start");
        try {
            this.f49552b.batchInsert((List) new Gson().fromJson(this.f49554d, new a().getType()));
        } catch (JsonSyntaxException e10) {
            C1442a.m8291w("AdAppsReportTask", "AdAppsReport runTask json exception is: " + e10.getMessage());
        }
        if (System.currentTimeMillis() - C0212e0.m1359i(C0213f.m1377a(), "key_report_ad_app_time", "key_report_ad_app_time", 0L) < 86400000) {
            C1442a.m8291w("AdAppsReportTask", "AdAppsReport reported only once a day！");
            return;
        }
        int historyCount = (int) this.f49552b.getHistoryCount();
        int i10 = (historyCount / 100) + (historyCount % 100 == 0 ? 0 : 1);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07066"), "reportAdApps", C13452e.m80781L().m80971t0());
        C1442a.m8290i("AdAppsReportTask", "historyCount:  " + historyCount + ", pageCount:" + i10);
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            int i12 = i11 * 100;
            this.f49553c = i12;
            try {
                try {
                    listM63368j = m63368j(100, i12);
                } catch (C9721b e11) {
                    C1442a.m8289e("AdAppsReportTask", "AdAppsReportT err. " + e11.m60659c() + " " + e11.getMessage());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("114_");
                    sb2.append(e11.m60659c());
                    c11060cM66626a.m66665u(sb2.toString());
                    c11060cM66626a.m66635A(e11.getMessage());
                }
                if (listM63368j.isEmpty()) {
                    C1442a.m8291w("AdAppsReportTask", "buildQuestList adAppInfos is empty ! start + " + this.f49553c);
                    break;
                }
                C0212e0.m1370t(C0213f.m1377a(), "key_report_ad_app_time", "key_report_ad_app_time", System.currentTimeMillis());
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                if (C9948a.m61631C().m61679k0(c11060cM66626a, listM63368j).getResultCode() == 0) {
                    C1442a.m8290i("AdAppsReportTask", "AdAppsReport success! ");
                    m63367i(listM63368j);
                }
                i11++;
            } finally {
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            }
        }
        if (AbstractC14026a.m84159a(this.f49555e)) {
            C1442a.m8291w("AdAppsReportTask", "AdAppsReport no success!");
        } else {
            this.f49552b.batchDeleteReport((String) this.f49555e.stream().map(new Function() { // from class: hj.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C10219d.m63366k((String) obj);
                }
            }).collect(Collectors.joining(",")));
            C1442a.m8290i("AdAppsReportTask", "AdAppsReport end");
        }
    }

    /* renamed from: i */
    public final void m63367i(List<AdAppsReportReq.AdAppInfo> list) {
        Iterator<AdAppsReportReq.AdAppInfo> it = list.iterator();
        while (it.hasNext()) {
            this.f49555e.add(it.next().getPackageName());
        }
    }

    /* renamed from: j */
    public final List<AdAppsReportReq.AdAppInfo> m63368j(int i10, int i11) throws Throwable {
        List<AppHistoryBean> historyByPage = this.f49552b.getHistoryByPage(i10, i11);
        ArrayList arrayList = new ArrayList();
        for (AppHistoryBean appHistoryBean : historyByPage) {
            arrayList.add(new AdAppsReportReq.AdAppInfo(appHistoryBean.getAppId(), appHistoryBean.getTime()));
        }
        return arrayList;
    }
}
