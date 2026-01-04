package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionList;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p804ya.AbstractC13926c;

/* renamed from: t7.c0 */
/* loaded from: classes2.dex */
public class C12958c0 extends AbstractC12988v {

    /* renamed from: g */
    public ShareAlbumData f59025g;

    /* renamed from: h */
    public List<ShareReceiverData> f59026h;

    /* renamed from: i */
    public List<ShareReceiverData> f59027i = new ArrayList();

    /* renamed from: j */
    public List<ShareReceiverData> f59028j;

    /* renamed from: k */
    public int f59029k;

    /* renamed from: l */
    public CallbackHandler f59030l;

    /* renamed from: t7.c0$a */
    public static class a extends AbstractC13926c<Void> {

        /* renamed from: a */
        public ShareReceiverData f59031a;

        /* renamed from: b */
        public List<ShareReceiverData> f59032b;

        /* renamed from: c */
        public List<ShareReceiverData> f59033c;

        public a(ShareReceiverData shareReceiverData, List<ShareReceiverData> list, List<ShareReceiverData> list2) {
            this.f59031a = shareReceiverData;
            this.f59032b = list;
            this.f59033c = list2;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            C1120a.m6675d("PermissionDeleteExecutor", "permissions delete fail userName: " + this.f59031a.getReceiverName());
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c */
        public void onSuccess(Void r12, C4609l c4609l) throws IOException {
            this.f59032b.remove(this.f59031a);
            this.f59033c.add(this.f59031a);
        }
    }

    public C12958c0(ShareAlbumData shareAlbumData, List<ShareReceiverData> list, int i10, CallbackHandler callbackHandler) {
        ArrayList arrayList = new ArrayList();
        this.f59028j = arrayList;
        this.f59025g = shareAlbumData;
        this.f59026h = list;
        arrayList.addAll(list);
        this.f59029k = i10;
        this.f59030l = callbackHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12, types: [int] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        String string;
        int i10;
        String str;
        String str2;
        String str3 = "x-hw-album-owner-Id";
        ?? r32 = "code";
        C1120a.m6675d("PermissionDeleteExecutor", "PermissionDeleteExecutor start delReceiverList: " + this.f59026h.toString() + " shareAlbumData: " + this.f59025g.toString());
        ?? r42 = "OK";
        ?? bundle = new Bundle();
        this.f59133f = bundle;
        try {
            try {
                ArrayList<Permission> arrayList = new ArrayList();
                String str4 = null;
                while (true) {
                    PermissionList permissionListExecute = this.f61708b.m83550g().list(this.f59025g.getShareId()).setFields2("nextCursor,permissions(userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege)").addHeader("x-hw-album-owner-Id", (Object) this.f59025g.getOwnerId()).setCursor(str4).execute();
                    List<Permission> permissions = permissionListExecute.getPermissions();
                    if (permissions != null) {
                        arrayList.addAll(permissions);
                    }
                    String nextCursor = permissionListExecute.getNextCursor();
                    C1120a.m6675d("PermissionDeleteExecutor", "permissionList: " + permissionListExecute.toString());
                    if (TextUtils.isEmpty(nextCursor)) {
                        break;
                    }
                    str4 = nextCursor;
                }
                if (arrayList.size() == 0) {
                    C1120a.m6677i("PermissionDeleteExecutor", "permissions is null");
                    i10 = -1;
                    str2 = "Fail";
                } else {
                    CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
                    int size = this.f59026h.size();
                    int i11 = 0;
                    for (ShareReceiverData shareReceiverData : this.f59026h) {
                        for (Permission permission : arrayList) {
                            if (permission.getUserId().equals(shareReceiverData.getReceiverId())) {
                                C1120a.m6675d("PermissionDeleteExecutor", "Permissions delete shareId:" + this.f59025g.getShareId() + " permission getId：" + permission.getId());
                                str = str3;
                                this.f61708b.m83550g().delete(this.f59025g.getShareId(), permission.getId()).addHeader(str3, (Object) this.f59025g.getOwnerId()).addHeader("x-hw-trace-id", (Object) this.f61710d).queue(cloudPhotoBatchM83551h, new a(shareReceiverData, this.f59028j, this.f59027i));
                            } else {
                                str = str3;
                            }
                            str3 = str;
                        }
                        String str5 = str3;
                        i11++;
                        if ((i11 % C1136q.d.m7148l() == 0 || size == i11) && cloudPhotoBatchM83551h.size() > 0) {
                            cloudPhotoBatchM83551h.execute();
                            CloudPhotoBatch cloudPhotoBatchM83551h2 = this.f61708b.m83551h();
                            C0068f.m459d().m468l();
                            cloudPhotoBatchM83551h = cloudPhotoBatchM83551h2;
                        }
                        str3 = str5;
                    }
                    i10 = 0;
                    str2 = r42;
                }
                this.f59133f.putInt("code", i10);
                this.f59133f.putString("info", str2);
            } catch (IOException e10) {
                try {
                    C1120a.m6676e("PermissionDeleteExecutor", "PermissionDeleteExecutor runTask IOException: " + e10.toString());
                    if (e10 instanceof C4616s) {
                        int iM6806m0 = C1122c.m6806m0((C4616s) e10, false);
                        string = e10.toString();
                        bundle = iM6806m0;
                    } else {
                        int iM6845x0 = C1122c.m6845x0(e10);
                        string = e10.toString();
                        bundle = iM6845x0;
                    }
                    r42 = this.f59133f;
                    r42.putInt("code", bundle);
                    r32 = this.f59133f;
                    r32.putString("info", string);
                    m77894q();
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    bundle = 0;
                    this.f59133f.putInt(r32, bundle);
                    this.f59133f.putString("info", r42);
                    throw th;
                }
            } catch (Exception e11) {
                C1120a.m6676e("PermissionDeleteExecutor", "PermissionDeleteExecutor runTask Exception: " + e11.toString());
                bundle = 9000;
                string = e11.toString();
                r42 = this.f59133f;
                r42.putInt("code", bundle);
                r32 = this.f59133f;
                r32.putString("info", string);
                m77894q();
                return "";
            } catch (Throwable th3) {
                th = th3;
                bundle = 0;
                this.f59133f.putInt(r32, bundle);
                this.f59133f.putString("info", r42);
                throw th;
            }
            m77894q();
            return "";
        } catch (Throwable th4) {
            th = th4;
            this.f59133f.putInt(r32, bundle);
            this.f59133f.putString("info", r42);
            throw th;
        }
    }

    /* renamed from: q */
    public final void m77894q() {
        if (this.f59028j.size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("code", -1);
            bundle.putInt("modifyShareType", this.f59029k);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.addAll(this.f59028j);
            bundle.putParcelable("ShareInfo", this.f59025g);
            bundle.putParcelableArrayList("UpdataShareReceiver", arrayList);
            bundle.putParcelable("HttpResult", new HttpResult(200, -1, "delete error"));
            if (this.f59028j.size() == this.f59026h.size() && this.f59027i.size() == 0) {
                this.f59133f = bundle;
            } else {
                int i10 = this.f59029k;
                if (1 == i10) {
                    this.f59030l.sendMessage(9072, bundle);
                } else if (2 == i10) {
                    this.f59030l.sendMessage(9075, bundle);
                }
            }
        }
        if (this.f59027i.size() > 0) {
            this.f59133f.putInt("modifyShareType", this.f59029k);
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f59027i);
            this.f59133f.putParcelable("ShareInfo", this.f59025g);
            this.f59133f.putParcelableArrayList("UpdataShareReceiver", arrayList2);
        }
    }
}
