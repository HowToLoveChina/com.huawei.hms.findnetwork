package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.List;
import p031b7.C1120a;
import p031b7.C1122c;
import p709vj.C13452e;

/* renamed from: t7.k0 */
/* loaded from: classes2.dex */
public class C12974k0 extends AbstractC12988v {

    /* renamed from: g */
    public String f59093g;

    /* renamed from: h */
    public String f59094h;

    /* renamed from: i */
    public int f59095i;

    public C12974k0(String str, String str2, int i10) {
        this.f59093g = str;
        this.f59094h = str2;
        this.f59095i = i10;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        int iM6802l0;
        String string;
        C1120a.m6675d("ShareReportExecutor", "ShareReportExecutor result: " + this.f59095i + " albumId: " + this.f59093g);
        String str = "OK";
        this.f59133f = new Bundle();
        int i10 = 0;
        try {
            try {
                try {
                    String strM80971t0 = C13452e.m80781L().m80971t0();
                    List<Permission> permissions = this.f61708b.m83547d().get(this.f59093g, "permissions(userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege)").addHeader("x-hw-album-owner-Id", (Object) this.f59094h).execute().getPermissions();
                    if (permissions == null || permissions.size() == 0) {
                        C1120a.m6677i("ShareReportExecutor", "permissions is null");
                        i10 = -1;
                        str = "Fail";
                    } else {
                        for (Permission permission : permissions) {
                            if (!TextUtils.isEmpty(strM80971t0) && !TextUtils.isEmpty(permission.getUserId()) && strM80971t0.equals(permission.getUserId())) {
                                String id2 = permission.getId();
                                PermissionUpdateRequest permissionUpdateRequest = new PermissionUpdateRequest();
                                permissionUpdateRequest.setStatus(Integer.valueOf(this.f59095i == 0 ? 1 : 2));
                                this.f61708b.m83550g().update(permissionUpdateRequest).setAlbumId(this.f59093g).setPermissionId(id2).addHeader("x-hw-album-owner-Id", (Object) this.f59094h).execute();
                            }
                        }
                    }
                    this.f59133f.putString("shareId", this.f59093g);
                    this.f59133f.putString("ownerID", this.f59094h);
                    this.f59133f.putInt("ShareConfirmResult", this.f59095i);
                    this.f59133f.putInt("code", i10);
                    this.f59133f.putString("info", str);
                    return "";
                } catch (Exception e10) {
                    C1120a.m6676e("ShareReportExecutor", "ShareReportExecutor runTask Exception: " + e10.toString());
                    iM6802l0 = ConnectionResult.NETWORK_ERROR;
                    string = e10.toString();
                    this.f59133f.putInt("code", iM6802l0);
                    this.f59133f.putString("info", string);
                    return "";
                }
            } catch (IOException e11) {
                C1120a.m6676e("ShareReportExecutor", "ShareReportExecutor runTask IOException: " + e11.toString());
                if (e11 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e11);
                    string = e11.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e11);
                    string = e11.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            }
        } catch (Throwable th2) {
            this.f59133f.putInt("code", i10);
            this.f59133f.putString("info", str);
            throw th2;
        }
    }
}
