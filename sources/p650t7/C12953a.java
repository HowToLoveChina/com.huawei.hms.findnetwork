package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.AccountCheckResult;
import com.huawei.android.hicloud.drive.user.request.Users;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.user.model.UserList;
import com.huawei.hicloud.base.drive.user.model.UsersListRequest;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p783xp.C13843a;

/* renamed from: t7.a */
/* loaded from: classes2.dex */
public class C12953a extends AbstractC12988v {

    /* renamed from: g */
    public List<String> f58997g;

    public C12953a(List<String> list) {
        this.f58997g = list;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        String string = "OK";
        this.f59133f = new Bundle();
        C1120a.m6675d("AccountCheckExecutor", "AccountCheckExecutor start");
        HashMap map = new HashMap();
        int iM6802l0 = 0;
        for (int i10 = 0; i10 < this.f58997g.size(); i10++) {
            try {
                try {
                    String str = "userAccount='" + this.f58997g.get(i10) + "'";
                    UsersListRequest usersListRequest = new UsersListRequest();
                    usersListRequest.setQueryParam(str);
                    Users.List list = this.f61709c.m676c().list(usersListRequest);
                    list.setHeader("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
                    list.setHeader("x-hw-3rdapp-packagename", C13843a.m83054F(C0213f.m1377a()));
                    list.setHeader("x-hw-3rdapp-version", C1122c.m6833t0(C0213f.m1377a()));
                    list.setFields2("userList(userId)");
                    UserList userListExecute = list.execute();
                    C1120a.m6675d("AccountCheckExecutor", "userList:" + userListExecute.toString());
                    for (int i11 = 0; i11 < userListExecute.size(); i11++) {
                        String userId = userListExecute.getUserList().get(i11).getUserId();
                        if (!TextUtils.isEmpty(userId) && !userId.equals("-1")) {
                            map.put(this.f58997g.get(i10), userId);
                        }
                    }
                } catch (IOException e10) {
                    C1120a.m6676e("AccountCheckExecutor", "AccountCheckExecutor runTask IOException: " + e10.toString());
                    if (e10 instanceof C4616s) {
                        iM6802l0 = C1122c.m6802l0((C4616s) e10);
                        string = e10.toString();
                    } else {
                        iM6802l0 = C1122c.m6845x0(e10);
                        string = e10.toString();
                    }
                } catch (Exception e11) {
                    C1120a.m6676e("AccountCheckExecutor", "AccountCheckExecutor runTask Exception: " + e11.toString());
                    iM6802l0 = ConnectionResult.NETWORK_ERROR;
                    string = e11.toString();
                }
            } finally {
                this.f59133f.putInt("code", 0);
                this.f59133f.putString("info", "OK");
            }
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        List<String> list2 = this.f58997g;
        if (list2 != null) {
            for (String str2 : list2) {
                C1120a.m6675d("AccountCheckExecutor", "userAccount:" + str2 + " userId:" + ((String) map.get(str2)));
                arrayList.add(new AccountCheckResult(str2, (String) map.get(str2)));
            }
        }
        if (this.f58997g != null) {
            this.f59133f.putStringArrayList("AccountList", new ArrayList<>(this.f58997g));
        }
        this.f59133f.putParcelableArrayList("AccountUidList", arrayList);
        return null;
    }
}
