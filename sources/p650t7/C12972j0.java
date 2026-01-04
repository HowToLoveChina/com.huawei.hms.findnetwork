package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import p031b7.C1120a;
import p031b7.C1122c;
import p546p6.C12106s;
import p546p6.EnumC12107t;

/* renamed from: t7.j0 */
/* loaded from: classes2.dex */
public class C12972j0 extends AbstractC12988v {

    /* renamed from: g */
    public String f59085g;

    /* renamed from: h */
    public int f59086h;

    public C12972j0(String str, int i10) {
        this.f59085g = str;
        this.f59086h = i10;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        C1120a.m6675d("SharePrivilegeExecutor", "SharePrivilegeExecutor update privilege: " + this.f59086h + "  shareId:" + this.f59085g);
        String string = "OK";
        this.f59133f = new Bundle();
        int iM6802l0 = 0;
        try {
            try {
                try {
                    C12106s c12106sM72509c = C12106s.m72509c();
                    EnumC12107t enumC12107t = EnumC12107t.SHARE_MODIFY_PRIVILEGE;
                    String sessionId = c12106sM72509c.m72513e(enumC12107t, true).getSessionId();
                    Album albumExecute = this.f61708b.m83547d().get(this.f59085g, "albumName,description,editedTime,favorite,localPath,resource,source,permissions(userId,displayName,status,role,userAccount,id),privilege").execute();
                    C1120a.m6675d("SharePrivilegeExecutor", "Album get:" + albumExecute.toString());
                    Album album = new Album();
                    album.setAlbumName(albumExecute.getAlbumName());
                    album.setDescription(albumExecute.getDescription());
                    album.setEditedTime(albumExecute.getEditedTime());
                    album.setFavorite(albumExecute.getFavorite());
                    album.setLocalPath(albumExecute.getLocalPath());
                    album.setResource(albumExecute.getResource());
                    album.setSource(albumExecute.getSource());
                    album.setPrivilege(Integer.valueOf(this.f59086h));
                    Albums.Update updateAddHeader = this.f61708b.m83547d().update(this.f59085g, album).addHeader("x-hw-lock", (Object) sessionId);
                    updateAddHeader.setRiskToken();
                    C1120a.m6675d("SharePrivilegeExecutor", "responseAlbum" + updateAddHeader.execute().toString());
                    this.f59133f.putString("shareId", this.f59085g);
                    this.f59133f.putInt("privilege", this.f59086h);
                    C12106s.m72509c().m72520l(enumC12107t);
                } catch (Exception e10) {
                    C1120a.m6676e("SharePrivilegeExecutor", "SharePrivilegeExecutor runTask Exception: " + e10.toString());
                    iM6802l0 = ConnectionResult.NETWORK_ERROR;
                    string = e10.toString();
                    C12106s.m72509c().m72520l(EnumC12107t.SHARE_MODIFY_PRIVILEGE);
                    this.f59133f.putInt("code", iM6802l0);
                    this.f59133f.putString("info", string);
                    return "";
                }
            } catch (IOException e11) {
                C1120a.m6676e("SharePrivilegeExecutor", "SharePrivilegeExecutor runTask IOException: " + e11.toString());
                if (e11 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e11);
                    string = e11.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e11);
                    string = e11.toString();
                }
                C12106s.m72509c().m72520l(EnumC12107t.SHARE_MODIFY_PRIVILEGE);
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            }
            this.f59133f.putInt("code", iM6802l0);
            this.f59133f.putString("info", string);
            return "";
        } catch (Throwable th2) {
            C12106s.m72509c().m72520l(EnumC12107t.SHARE_MODIFY_PRIVILEGE);
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            throw th2;
        }
    }
}
