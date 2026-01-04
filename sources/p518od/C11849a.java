package p518od;

import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.cloud.pay.model.PresentLog;
import fk.C9721b;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p341hj.AbstractC10222e;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: od.a */
/* loaded from: classes3.dex */
public class C11849a extends AbstractC10222e {

    /* renamed from: b */
    public String f54864b;

    public C11849a(String str) {
        this.f54864b = str;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        List<PresentLog> presentLogs;
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06008"), "queryPresent", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                presentLogs = C9948a.m61631C().m61669f0(c11060cM66626a, this.f54864b).getPresentLogs();
            } catch (C9721b e10) {
                C1442a.m8291w("QueryPresentAndNotifyTask", "QueryPresentAndNotifyTask err. " + e10.m60659c() + " " + e10.getMessage());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060cM66626a.m66665u(sb2.toString());
                c11060cM66626a.m66635A(e10.getMessage());
            }
            if (presentLogs != null && !presentLogs.isEmpty()) {
                new BackupNotificationManager(C0213f.m1377a()).sendComplimentaryPackageNotify(presentLogs.get(0));
                return;
            }
            C1442a.m8289e("QueryPresentAndNotifyTask", "presentLogList is null or is empty.");
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }
}
