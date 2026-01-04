package p650t7;

import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.callable.ReportRisksCallable;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.CloudAlbumVersion;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.util.List;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1136q;
import p804ya.AbstractC13926c;

/* renamed from: t7.b */
/* loaded from: classes2.dex */
public class C12955b extends AbstractC13926c<ChangeList> {

    /* renamed from: a */
    public String f59005a;

    /* renamed from: b */
    public CloudAlbumVersion f59006b;

    /* renamed from: c */
    public String f59007c;

    /* renamed from: d */
    public List<ErrorResp.Error> f59008d;

    public C12955b(String str, CloudAlbumVersion cloudAlbumVersion, String str2, List<ErrorResp.Error> list) {
        this.f59005a = str;
        this.f59006b = cloudAlbumVersion;
        this.f59007c = str2;
        this.f59008d = list;
    }

    @Override // p804ya.AbstractC13926c
    /* renamed from: a */
    public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
        if (error == null) {
            return;
        }
        this.f59008d.add(error);
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ChangeList changeList, C4609l c4609l) {
        C1120a.m6675d("BatchChangesListCallback", this.f59005a + " changeList: " + changeList.toString());
        if (ReportRisksCallable.RISK_INFO_CREATE_KIND.equals(this.f59005a)) {
            List<Change> changes = changeList.getChanges();
            if ((changes == null || changes.isEmpty()) && TextUtils.isEmpty(changeList.getNextCursor())) {
                this.f59006b.setLatestVersion(C0241z.m1688f(C1136q.d.m7145i()));
                SyncSessionManager.m15153t().m15167N(C1136q.d.m7145i());
                C1120a.m6677i("BatchChangesListCallback", "no need update latestVersion: " + C1136q.d.m7145i());
                return;
            }
            this.f59006b.setLatestVersion(C0241z.m1688f(this.f59007c));
            SyncSessionManager.m15153t().m15167N(this.f59007c);
            C1136q.d.m7125B(this.f59007c);
            C1120a.m6677i("BatchChangesListCallback", "need update latestVersion: " + this.f59007c);
            return;
        }
        if ("Album".equals(this.f59005a)) {
            List<Change> changes2 = changeList.getChanges();
            if ((changes2 == null || changes2.isEmpty()) && TextUtils.isEmpty(changeList.getNextCursor())) {
                this.f59006b.setAlbumListVersion(C1136q.d.m7139c());
                C1120a.m6677i("BatchChangesListCallback", "no need update albumListVersion: " + C1136q.d.m7139c());
                return;
            }
            this.f59006b.setAlbumListVersion(this.f59007c);
            C1136q.d.m7159w(this.f59007c);
            C1120a.m6677i("BatchChangesListCallback", "need update albumListVersion: " + this.f59007c);
        }
    }
}
