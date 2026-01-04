package p650t7;

import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.Role;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0068f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1136q;
import p804ya.AbstractC13926c;

/* renamed from: t7.b0 */
/* loaded from: classes2.dex */
public class C12956b0 extends AbstractC12988v {

    /* renamed from: g */
    public ShareAlbumData f59009g;

    /* renamed from: h */
    public List<ShareReceiverData> f59010h;

    /* renamed from: i */
    public List<ShareReceiverData> f59011i = new ArrayList();

    /* renamed from: j */
    public List<ShareReceiverData> f59012j = new ArrayList();

    /* renamed from: k */
    public int f59013k = 1;

    /* renamed from: l */
    public String f59014l = "create error";

    /* renamed from: m */
    public CallbackHandler f59015m;

    /* renamed from: t7.b0$a */
    public class a extends AbstractC13926c<Permission> {

        /* renamed from: a */
        public ShareReceiverData f59016a;

        /* renamed from: b */
        public List<ShareReceiverData> f59017b;

        /* renamed from: c */
        public List<ShareReceiverData> f59018c;

        public a(ShareReceiverData shareReceiverData, List<ShareReceiverData> list, List<ShareReceiverData> list2) {
            this.f59016a = shareReceiverData;
            this.f59017b = list;
            this.f59018c = list2;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            ErrorResp.ErrorMsg errorMsg;
            C1120a.m6675d("PermissionAddExecutor", "permissions create fail userName: " + this.f59016a.getReceiverName());
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            if (errorDetail == null || errorDetail.isEmpty() || (errorMsg = errorDetail.get(0)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(errorMsg.getErrorCode())) {
                C12956b0.this.f59013k = C0241z.m1685c(errorMsg.getErrorCode());
            }
            if (TextUtils.isEmpty(errorMsg.getDescription())) {
                return;
            }
            C12956b0.this.f59014l = errorMsg.getDescription();
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c */
        public void onSuccess(Permission permission, C4609l c4609l) {
            this.f59018c.add(this.f59016a);
            this.f59017b.remove(this.f59016a);
            C1120a.m6675d("PermissionAddExecutor", "permissions.create success userAccount: " + this.f59016a.getReceiverAcc());
        }
    }

    /* renamed from: t7.b0$b */
    public static class b extends AbstractC13926c<Permission> {

        /* renamed from: a */
        public ShareReceiverData f59020a;

        /* renamed from: b */
        public List<ShareReceiverData> f59021b;

        /* renamed from: c */
        public List<ShareReceiverData> f59022c;

        public b(ShareReceiverData shareReceiverData, List<ShareReceiverData> list, List<ShareReceiverData> list2) {
            this.f59020a = shareReceiverData;
            this.f59021b = list;
            this.f59022c = list2;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            C1120a.m6675d("PermissionAddExecutor", "permissions update fail userName: " + this.f59020a.getReceiverName());
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c */
        public void onSuccess(Permission permission, C4609l c4609l) {
            this.f59022c.add(this.f59020a);
            this.f59021b.remove(this.f59020a);
            C1120a.m6675d("PermissionAddExecutor", "permissions.update success userAccount: " + this.f59020a.getReceiverAcc());
        }
    }

    public C12956b0(ShareAlbumData shareAlbumData, List<ShareReceiverData> list, CallbackHandler callbackHandler) {
        this.f59009g = shareAlbumData;
        this.f59010h = list;
        this.f59011i.addAll(list);
        this.f59015m = callbackHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x011e: MOVE (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:121:0x011e */
    /* JADX WARN: Removed duplicated region for block: B:131:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12956b0.mo77876l():java.lang.String");
    }

    /* renamed from: s */
    public final void m77889s(CloudPhotoBatch cloudPhotoBatch, ShareReceiverData shareReceiverData) throws IOException {
        PermissionCreateRequest permissionCreateRequest = new PermissionCreateRequest();
        if (!TextUtils.isEmpty(shareReceiverData.getReceiverAcc())) {
            permissionCreateRequest.setUserAccount(shareReceiverData.getReceiverAcc());
        }
        if (!TextUtils.isEmpty(shareReceiverData.getReceiverId())) {
            permissionCreateRequest.setUserId(shareReceiverData.getReceiverId());
        }
        permissionCreateRequest.setRole(Role.WRITER);
        permissionCreateRequest.setType("user");
        this.f61708b.m83550g().create(this.f59009g.getShareId(), permissionCreateRequest).addHeader("x-hw-trace-id", (Object) this.f61710d).queue(cloudPhotoBatch, new a(shareReceiverData, this.f59011i, this.f59012j));
    }

    /* renamed from: t */
    public final void m77890t(CloudPhotoBatch cloudPhotoBatch, List<Permission> list) throws Throwable {
        int size = this.f59010h.size();
        int i10 = 0;
        for (ShareReceiverData shareReceiverData : this.f59010h) {
            Permission permission = null;
            for (Permission permission2 : list) {
                if (permission2.getUserId().equals(shareReceiverData.getReceiverId())) {
                    permission = permission2;
                }
            }
            if (permission != null) {
                m77891u(cloudPhotoBatch, permission, shareReceiverData);
            } else {
                m77889s(cloudPhotoBatch, shareReceiverData);
            }
            i10++;
            if (i10 % C1136q.d.m7148l() == 0 || size == i10) {
                if (cloudPhotoBatch.size() > 0) {
                    cloudPhotoBatch.execute();
                    cloudPhotoBatch = this.f61708b.m83551h();
                    C0068f.m459d().m468l();
                }
            }
        }
    }

    /* renamed from: u */
    public final void m77891u(CloudPhotoBatch cloudPhotoBatch, Permission permission, ShareReceiverData shareReceiverData) throws IOException {
        String id2 = permission.getId();
        C1120a.m6675d("PermissionAddExecutor", "permissionId:" + id2);
        PermissionUpdateRequest permissionUpdateRequest = new PermissionUpdateRequest();
        permissionUpdateRequest.setRole(Role.WRITER);
        permissionUpdateRequest.setStatus(0);
        C1120a.m6675d("PermissionAddExecutor", "update permissionId:" + id2);
        this.f61708b.m83550g().update(permissionUpdateRequest).setAlbumId(this.f59009g.getShareId()).setPermissionId(id2).addHeader("x-hw-trace-id", (Object) this.f61710d).queue(cloudPhotoBatch, new b(shareReceiverData, this.f59011i, this.f59012j));
    }
}
