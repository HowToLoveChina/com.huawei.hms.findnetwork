package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.AvatarInfo;
import com.huawei.android.hicloud.drive.user.request.Users;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hicloud.base.drive.user.model.UserList;
import com.huawei.hicloud.base.drive.user.model.UsersListRequest;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p783xp.C13843a;

/* renamed from: t7.n0 */
/* loaded from: classes2.dex */
public class C12980n0 extends AbstractC12988v {

    /* renamed from: g */
    public List<String> f59117g;

    /* renamed from: h */
    public int f59118h = 20;

    public C12980n0(List<String> list) {
        this.f59117g = list;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        C1120a.m6675d("UserInfoQueryExecutor", "start UserInfoQueryExecutor: " + this.f59117g.toString());
        this.f59133f = new Bundle();
        ArrayList<AvatarInfo> arrayList = new ArrayList<>();
        int i10 = 0;
        while (i10 < this.f59117g.size()) {
            m77929r(this.f59117g, i10, arrayList);
            i10 += this.f59118h;
        }
        this.f59133f.putString("errMsg", Arrays.deepToString(this.f59117g.toArray()));
        C1120a.m6675d("UserInfoQueryExecutor", "avatarInfoUserList:" + arrayList.toString());
        this.f59133f.putParcelableArrayList("avatarInfoList", arrayList);
        return null;
    }

    /* renamed from: q */
    public final void m77928q() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        List<String> list = this.f59117g;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new AvatarInfo(it.next()));
            }
        }
        this.f59133f.putParcelableArrayList("avatarInfoList", arrayList);
    }

    /* renamed from: r */
    public final void m77929r(List<String> list, int i10, ArrayList<AvatarInfo> arrayList) {
        StringBuffer stringBuffer = new StringBuffer("userId in (");
        for (int i11 = i10; i11 < list.size() && i11 < this.f59118h + i10; i11++) {
            String str = list.get(i11);
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str);
                stringBuffer.append(",");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        C1120a.m6675d("UserInfoQueryExecutor", "queryParam:" + stringBuffer.toString());
        m77930s(stringBuffer.toString(), arrayList);
    }

    /* renamed from: s */
    public final void m77930s(String str, ArrayList<AvatarInfo> arrayList) {
        int iM6802l0;
        String string;
        try {
            try {
                UsersListRequest usersListRequest = new UsersListRequest();
                usersListRequest.setQueryParam(str);
                Users.List list = this.f61709c.m676c().list(usersListRequest);
                list.setHeader("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
                list.setHeader("x-hw-3rdapp-packagename", C13843a.m83054F(C0213f.m1377a()));
                list.setHeader("x-hw-3rdapp-version", C1122c.m6833t0(C0213f.m1377a()));
                list.setFields2("userList(displayName,profilePhotoLink,userId)");
                UserList userListExecute = list.execute();
                List<User> userList = userListExecute.getUserList();
                C1120a.m6675d("UserInfoQueryExecutor", "userList:" + userListExecute.toString());
                for (int i10 = 0; i10 < userList.size(); i10++) {
                    User user = userList.get(i10);
                    AvatarInfo avatarInfo = new AvatarInfo(user.getUserId());
                    if (!TextUtils.isEmpty(user.getDisplayName())) {
                        avatarInfo.setNickName(user.getDisplayName());
                        avatarInfo.setHeadPictureURL(user.getProfilePhotoLink());
                        avatarInfo.setUserId(user.getUserId());
                        arrayList.add(avatarInfo);
                    }
                }
            } catch (IOException e10) {
                m77928q();
                C1120a.m6676e("UserInfoQueryExecutor", "UserInfoQueryExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
            } catch (Exception e11) {
                m77928q();
                C1120a.m6676e("UserInfoQueryExecutor", "UserInfoQueryExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
            }
        } finally {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
        }
    }
}
