package p604r7;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.android.hicloud.album.service.logic.callable.ReportRisksCallable;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Applicant;
import com.huawei.android.hicloud.drive.cloudphoto.model.ApplicantCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.ApplicantList;
import com.huawei.android.hicloud.drive.cloudphoto.model.ApplicantUpdateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.InformCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.InformRecord;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.drive.cloudphoto.model.InviterCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionList;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.Role;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.hicloud.drive.cloudphoto.request.Applicants;
import com.huawei.android.hicloud.drive.cloudphoto.request.Inviters;
import com.huawei.android.hicloud.drive.cloudphoto.request.Permissions;
import com.huawei.android.hicloud.drive.cloudphoto.request.Risks;
import com.huawei.android.hicloud.drive.user.request.Risks;
import com.huawei.android.hicloud.drive.user.request.Users;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.user.model.RisksRecordList;
import com.huawei.hicloud.base.drive.user.model.RisksRequst;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hicloud.base.drive.user.model.UsersListRequest;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p012ab.C0086a;
import p015ak.C0213f;
import p015ak.C0227m;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1125f;
import p283fa.C9678a;
import p283fa.C9679b;
import p546p6.C12088a;
import p546p6.C12095h;
import p616rk.C12515a;
import p649t6.C12941a;
import p649t6.C12947g;
import p709vj.C13452e;
import p731w7.C13535b;
import p804ya.C13924a;
import p804ya.C13925b;

/* renamed from: r7.b */
/* loaded from: classes2.dex */
public class C12469b {

    /* renamed from: r7.b$b */
    public static class b {

        /* renamed from: a */
        public static C12469b f57401a = new C12469b();
    }

    public /* synthetic */ C12469b(a aVar) {
        this();
    }

    /* renamed from: l */
    public static C12469b m74746l() {
        return b.f57401a;
    }

    /* renamed from: o */
    public static /* synthetic */ void m74747o() {
        C12473f.m74865c().m74869f(2);
    }

    /* renamed from: b */
    public void m74748b(Inviter inviter, Map<String, String> map) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "createApplicant cloudPhoto is null ");
            return;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        String inviterId = inviter.getInviterId();
        try {
            try {
                ApplicantCreateRequest applicantCreateRequest = new ApplicantCreateRequest();
                applicantCreateRequest.setInviteId(inviter.getInviterId());
                applicantCreateRequest.setKinship(inviter.getKinship());
                applicantCreateRequest.setPrivilege(inviter.getPrivilege());
                applicantCreateRequest.setProperties(map);
                applicantCreateRequest.setRemark(inviter.getRemark());
                applicantCreateRequest.setType("user");
                applicantCreateRequest.setUserAccount(C13452e.m80781L().m80900d());
                Applicants.Create fields2 = c13924aM60445d.m83548e().create(applicantCreateRequest).setFields2("applicantId");
                fields2.setAlbumClientHeader(strM6755Z0);
                fields2.setRiskToken();
                C1120a.m6675d("AlbumClientRequest", "get applicant " + fields2.execute().toString());
            } catch (IOException e10) {
                String str = inviterId + ", " + e10.toString();
                throw e10;
            } catch (Exception e11) {
                String str2 = inviterId + ", " + e11.toString();
                throw e11;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Applicant.create", 0, inviterId);
        }
    }

    /* renamed from: c */
    public Inviter m74749c(String str, String str2, String str3, String str4, String str5, boolean z10) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "createInviterCode cloudPhoto is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                C1120a.m6675d("AlbumClientRequest", "createInviterCode " + str);
                InviterCreateRequest inviterCreateRequest = new InviterCreateRequest();
                inviterCreateRequest.setAlbumId(str);
                inviterCreateRequest.setKinship(str2);
                inviterCreateRequest.setRemark(str3);
                inviterCreateRequest.setPrivilege(str4);
                inviterCreateRequest.setRole(Role.WRITER);
                inviterCreateRequest.setUserId(C13452e.m80781L().m80971t0());
                inviterCreateRequest.setSource(str5);
                inviterCreateRequest.setVerify(Boolean.valueOf(z10));
                Inviters.Create fields2 = c13924aM60445d.m83553j().create(inviterCreateRequest).setFields2("inviterId");
                fields2.addHeader("x-hw-album-owner-Id", C13452e.m80781L().m80971t0());
                fields2.setAlbumClientHeader(strM6755Z0);
                fields2.setRiskToken();
                Inviter inviterExecute = fields2.execute();
                C1120a.m6675d("AlbumClientRequest", "inviter " + inviterExecute.toString());
                return inviterExecute;
            } catch (IOException e10) {
                String str6 = str + ", " + e10.toString();
                throw e10;
            } catch (Exception e11) {
                String str7 = str + ", " + e11.toString();
                throw e11;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Inviter.create", 0, str);
        }
    }

    /* renamed from: d */
    public Album m74750d(Album album) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "createShareAlbum cloudPhoto is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                String str = "/Photoshare/" + album.getAlbumName() + System.currentTimeMillis();
                String str2 = "md5" + C0227m.m1592e(str);
                Album album2 = new Album();
                album2.setAlbumName(album.getAlbumName());
                album2.setBabyInfo(album.getBabyInfo());
                album2.setCreatedTime(new C4644l(System.currentTimeMillis()));
                album2.setDescription("");
                album2.setEditedTime(album2.getCreatedTime());
                Boolean bool = Boolean.FALSE;
                album2.setFavorite(bool);
                album2.setId(str2);
                album2.setKinship(album.getKinship());
                album2.setLocalPath(str);
                album2.setPrivilege(0);
                album2.setProperties(album.getProperties());
                album2.setRecycled(bool);
                album2.setResource(PowerKitApplyUtil.GROUP_ALBUM);
                album2.setShareType(album.getShareType());
                album2.setSource(Build.MODEL);
                album2.setType(1);
                album2.setUserAccount(C13452e.m80781L().m80900d());
                C12088a c12088aM72266c = C12088a.m72266c();
                C12088a.c cVar = C12088a.c.ALBUM_CLIENT_SHARE_CREATE_ALBUM;
                String sessionId = c12088aM72266c.m72270e(cVar, true).getSessionId();
                Albums.Create createAddHeader = c13924aM60445d.m83547d().create(album2, "id,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions(userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege),privilege,properties,resource,shareType,source,type,recycled").addHeader("x-hw-lock", (Object) sessionId);
                createAddHeader.setAlbumClientHeader(strM6755Z0);
                createAddHeader.setRiskToken();
                Album albumExecute = createAddHeader.execute();
                C1120a.m6675d("AlbumClientRequest", "album " + albumExecute.toString());
                album.setId(albumExecute.getId());
                ArrayList<Album> arrayList = new ArrayList<>();
                arrayList.add(albumExecute);
                new C12941a().m77735j(arrayList);
                if (album.getHeadPic() != null && album.getHeadPic().exists()) {
                    C13925b c13925b = new C13925b(strM6755Z0, albumExecute, album.getHeadPic(), sessionId);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("thumbType", "babyHeadPic");
                    map.put("albumId", albumExecute.getId());
                    c13925b.m83570h(map);
                    String str3 = C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/headPic/" + (albumExecute.getId() + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT);
                    String absolutePath = album.getHeadPic().getAbsolutePath();
                    C1120a.m6675d("AlbumClientRequest", "createShareAlbum cachePath: " + str3 + ", babyHeadPic: " + absolutePath);
                    C1125f.m6885f(absolutePath, str3, false);
                }
                C12088a.m72266c().m72275j(cVar);
                new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Albums.create", 0, "OK");
                return albumExecute;
            } catch (IOException e10) {
                e10.toString();
                throw e10;
            } catch (Exception e11) {
                e11.toString();
                throw e11;
            }
        } catch (Throwable th2) {
            C12088a.m72266c().m72275j(C12088a.c.ALBUM_CLIENT_SHARE_CREATE_ALBUM);
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Albums.create", 0, "OK");
            throw th2;
        }
    }

    /* renamed from: e */
    public void m74751e(String str, String str2, String str3) throws IOException {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "deletePermission cloudPhoto is null ");
            return;
        }
        List<Permission> listM74761q = m74761q(str, str2);
        if (listM74761q == null || listM74761q.size() == 0) {
            C1120a.m6677i("AlbumClientRequest", "permissions is null");
            return;
        }
        Iterator<Permission> it = listM74761q.iterator();
        while (it.hasNext()) {
            Permission next = it.next();
            if (next.getUserId().equals(str3)) {
                String strM6755Z0 = C1122c.m6755Z0("04019");
                String id2 = next.getId();
                int i10 = 0;
                try {
                    try {
                        C1120a.m6675d("AlbumClientRequest", "deletePermission albumId:" + str + " permission getId：" + next.getId());
                        Permissions.Delete deleteAddHeader = c13924aM60445d.m83550g().delete(str, next.getId()).addHeader("x-hw-album-owner-Id", (Object) str2);
                        deleteAddHeader.setAlbumClientHeader(strM6755Z0);
                        deleteAddHeader.execute();
                        it.remove();
                        C1120a.m6675d("AlbumClientRequest", "deletePermission success");
                        m74768x(str, listM74761q);
                        return;
                    } catch (IOException e10) {
                        i10 = 4312;
                        id2 = id2 + ", " + e10.toString();
                        throw e10;
                    }
                } finally {
                    new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Permissions.delete", i10, id2);
                }
            }
        }
    }

    /* renamed from: f */
    public void m74752f(Album album) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "deleteShareAlbum cloudPhoto is null ");
            return;
        }
        ArrayList<Album> arrayList = new ArrayList<>();
        arrayList.add(album);
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                C12088a c12088aM72266c = C12088a.m72266c();
                C12088a.c cVar = C12088a.c.ALBUM_CLIENT_SHARE_DELETE_ALBUM;
                Albums.Delete deleteMode = c13924aM60445d.m83547d().delete(album.getId()).addHeader("x-hw-lock", (Object) c12088aM72266c.m72270e(cVar, true).getSessionId()).setDeleteMode(true);
                deleteMode.setAlbumClientHeader(strM6755Z0);
                deleteMode.execute();
                new C12941a().m77734i(arrayList);
                C12515a.m75110o().m75175e(new C12095h(arrayList), false);
                C12088a.m72266c().m72275j(cVar);
                new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Albums.delete", 0, "OK");
            } catch (IOException e10) {
                C1120a.m6676e("AlbumClientRequest", "deleteShareAlbum IOException " + e10.toString());
                e10.toString();
                throw e10;
            } catch (Exception e11) {
                C1120a.m6676e("AlbumClientRequest", "deleteShareAlbum Exception " + e11.toString());
                e11.toString();
                throw e11;
            }
        } catch (Throwable th2) {
            C12088a.m72266c().m72275j(C12088a.c.ALBUM_CLIENT_SHARE_DELETE_ALBUM);
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Albums.delete", 0, "OK");
            throw th2;
        }
    }

    /* renamed from: g */
    public void m74753g(ArrayList<Media> arrayList) {
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setOpType(4);
        }
        new C12947g().m77826n(arrayList);
        C13535b.m81436a().m81438c(new Runnable() { // from class: r7.a
            @Override // java.lang.Runnable
            public final void run() {
                C12469b.m74747o();
            }
        }, 30000L);
    }

    /* renamed from: h */
    public Album m74754h(String str, String str2) throws IOException {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "getAlbum cloudPhoto is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                Albums.Get getAddHeader = c13924aM60445d.m83547d().get(str, "id,albumOwnerId,privilege,permissions(id,userId,privilege),properties").addHeader("x-hw-album-owner-Id", (Object) str2);
                getAddHeader.setAlbumClientHeader(strM6755Z0);
                Album albumExecute = getAddHeader.execute();
                C1120a.m6675d("AlbumClientRequest", "getAlbum: " + albumExecute.toString());
                new C12941a().m77729D(albumExecute);
                return albumExecute;
            } catch (IOException e10) {
                e10.toString();
                throw e10;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Albums.get", 0, "OK");
        }
    }

    /* renamed from: i */
    public RisksRecordList m74755i() throws IOException {
        C0086a c0086aM60455e = C9679b.m60452d().m60455e();
        if (c0086aM60455e == null) {
            C1120a.m6676e("AlbumClientRequest", "getDisplayName userClient is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                Risks.AppealRecord appealRecord = c0086aM60455e.m675b().getAppealRecord();
                appealRecord.setHeader("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
                appealRecord.setHeader("x-hw-3rdapp-packagename", "com.huawei.hidisk");
                appealRecord.setHeader("x-hw-3rdapp-version", "16.0.0.300");
                appealRecord.setHeader("x-hw-trace-id", strM6755Z0);
                return appealRecord.execute();
            } catch (IOException e10) {
                String str = ", " + e10.toString();
                throw e10;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Risks.appeal.list", 0, "");
        }
    }

    /* renamed from: j */
    public Applicant m74756j(String str) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "getApplicant cloudPhoto is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                C1120a.m6675d("AlbumClientRequest", "get applicant " + str);
                Applicants.Get fields2 = c13924aM60445d.m83548e().get(str).setFields2("albumId,auditStatus,expirationTime,userId,userAccount,applicantId,source,remark,privilege,properties,kinship,createdTime");
                fields2.setAlbumClientHeader(strM6755Z0);
                return fields2.execute();
            } catch (IOException e10) {
                String str2 = str + ", " + e10.toString();
                throw e10;
            } catch (Exception e11) {
                String str3 = str + ", " + e11.toString();
                throw e11;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Applicant.get", 0, str);
        }
    }

    /* renamed from: k */
    public String m74757k(String str) throws IOException {
        C0086a c0086aM60455e = C9679b.m60452d().m60455e();
        if (c0086aM60455e == null) {
            C1120a.m6676e("AlbumClientRequest", "getDisplayName userClient is null ");
            return "";
        }
        UsersListRequest usersListRequest = new UsersListRequest();
        usersListRequest.setQueryParam("userId in (" + str + ")");
        Users.List list = c0086aM60455e.m676c().list(usersListRequest);
        list.setHeader("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
        list.setHeader("x-hw-3rdapp-packagename", "com.huawei.hidisk");
        list.setHeader("x-hw-3rdapp-version", "16.0.0.300");
        list.setHeader("x-hw-trace-id", C1122c.m6755Z0("04019"));
        list.setFields2("userList(displayName,userId)");
        List<User> userList = list.execute().getUserList();
        if (userList != null && !userList.isEmpty()) {
            User user = userList.get(0);
            if (!TextUtils.isEmpty(user.getUserId()) && !TextUtils.isEmpty(user.getDisplayName()) && user.getUserId().equals(str)) {
                return user.getDisplayName();
            }
        }
        return "";
    }

    /* renamed from: m */
    public Inviter m74758m(String str) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "getInviter cloudPhoto is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                C1120a.m6675d("AlbumClientRequest", "get inviter id " + str);
                Inviters.Get fields2 = c13924aM60445d.m83553j().get().setFields2("albumId,albumName,albumUserId,babyAvatar,babySex,inviterId,joined,kinship,members,privilege,remark,shareType,showImages,source,userId");
                fields2.setAlbumClientHeader(strM6755Z0);
                fields2.addHeader("x-hw-inviter-id", (Object) str);
                Inviter inviterExecute = fields2.execute();
                C1120a.m6675d("AlbumClientRequest", "get inviter " + inviterExecute.toString());
                return inviterExecute;
            } catch (IOException e10) {
                String str2 = str + ", " + e10.toString();
                throw e10;
            } catch (Exception e11) {
                String str3 = str + ", " + e11.toString();
                throw e11;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Inviter.get", 0, str);
        }
    }

    /* renamed from: n */
    public Permission m74759n(String str, String str2, String str3) throws IOException {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "getPermission cloudPhoto is null ");
            return null;
        }
        Permissions.Get getAddHeader = c13924aM60445d.m83550g().get(str, str3).setFields2("userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege").addHeader("x-hw-album-owner-Id", (Object) str2);
        getAddHeader.setAlbumClientHeader(C1122c.m6755Z0("04019"));
        Permission permissionExecute = getAddHeader.execute();
        C1120a.m6675d("AlbumClientRequest", "getPermission: " + permissionExecute.toString());
        return permissionExecute;
    }

    /* renamed from: p */
    public List<Applicant> m74760p(String str, HashMap<String, Integer> map) {
        String str2;
        CommonOpsReport commonOpsReport;
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        String nextCursor = null;
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "listApplicant cloudPhoto is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String strM6755Z0 = C1122c.m6755Z0("04019");
        int i10 = 4312;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                C1120a.m6675d("AlbumClientRequest", "list applicant " + str);
                Applicants.List fields2 = c13924aM60445d.m83548e().list().setFields2("nextCursor,applicants(albumId,auditStatus,expirationTime,userId,userAccount,applicantId,source,remark,privilege,properties,kinship,createdTime)");
                fields2.setAlbumClientHeader(strM6755Z0);
                if (!TextUtils.isEmpty(str)) {
                    fields2.addHeader("x-hw-album-Id", (Object) str);
                }
                do {
                    ApplicantList applicantListExecute = fields2.setCursor(nextCursor).execute();
                    C1120a.m6675d("AlbumClientRequest", "applicantList: " + applicantListExecute.toString());
                    List<Applicant> applicants = applicantListExecute.getApplicants();
                    if (applicants != null) {
                        C1120a.m6677i("AlbumClientRequest", "applicants size: " + applicants.size());
                        for (Applicant applicant : applicants) {
                            if (applicant != null) {
                                arrayList.add(applicant);
                            }
                        }
                    }
                    nextCursor = applicantListExecute.getNextCursor();
                } while (!TextUtils.isEmpty(nextCursor));
                new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Applicant.list", 0, str);
            } catch (C4616s e10) {
                C1120a.m6676e("AlbumClientRequest", "listApplicant HttpResponseException " + e10.toString());
                if (map != null) {
                    map.put("code", 4312);
                }
                str2 = str + ", " + e10.toString();
                commonOpsReport = new CommonOpsReport(C0213f.m1377a());
                commonOpsReport.m15209C(strM6755Z0, "Applicant.list", 4312, str2);
                return arrayList;
            } catch (Exception e11) {
                C1120a.m6676e("AlbumClientRequest", "listApplicant Exception " + e11.toString());
                str2 = str + ", " + e11.toString();
                commonOpsReport = new CommonOpsReport(C0213f.m1377a());
                commonOpsReport.m15209C(strM6755Z0, "Applicant.list", 4312, str2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            i10 = 0;
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Applicant.list", i10, str);
            throw th;
        }
    }

    /* renamed from: q */
    public List<Permission> m74761q(String str, String str2) throws IOException {
        return m74762r(str, str2, null);
    }

    /* renamed from: r */
    public List<Permission> m74762r(String str, String str2, HashMap<String, Integer> map) throws IOException {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        String nextCursor = null;
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "updatePermission cloudPhoto is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                ArrayList arrayList = new ArrayList();
                do {
                    Permissions.List cursor = c13924aM60445d.m83550g().list(str).setFields2("nextCursor,permissions(userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege)").setCursor(nextCursor);
                    cursor.setAlbumClientHeader(strM6755Z0);
                    cursor.addHeader("x-hw-album-owner-Id", (Object) str2);
                    PermissionList permissionListExecute = cursor.execute();
                    arrayList.addAll(C1122c.m6709K(permissionListExecute.getPermissions()));
                    C1120a.m6675d("AlbumClientRequest", " permissionsListResult: " + arrayList.toString());
                    nextCursor = permissionListExecute.getNextCursor();
                } while (!TextUtils.isEmpty(nextCursor));
                return arrayList;
            } catch (IOException e10) {
                String str3 = str + ", " + e10.toString();
                if (map != null) {
                    map.put("code", 4312);
                }
                throw e10;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Permissions.list", 0, str);
        }
    }

    /* renamed from: s */
    public void m74763s(String str, List<String> list, String str2, String str3) throws IOException {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "riskInformCreate cloudPhoto is null ");
            return;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        int i10 = 0;
        try {
            try {
                InformCreateRequest informCreateRequest = new InformCreateRequest();
                ArrayList arrayList = new ArrayList();
                InformRecord informRecord = new InformRecord();
                informRecord.setFileId(str);
                informRecord.setOwnerId(str2);
                if (TextUtils.isEmpty(str3)) {
                    informRecord.setRiskLabels(list);
                    informRecord.setScene(3);
                } else {
                    informRecord.setReason(str3);
                    informRecord.setScene(7);
                }
                arrayList.add(informRecord);
                informCreateRequest.setRecordList(arrayList);
                informCreateRequest.setUserId(C13452e.m80781L().m80971t0());
                informCreateRequest.setCreatedTime(new C4644l(System.currentTimeMillis()));
                Risks.InformCreate informCreate = c13924aM60445d.m83559p().informCreate(informCreateRequest);
                informCreate.setAlbumClientHeader(strM6755Z0);
                informCreate.setRiskToken();
                informCreate.setKind(ReportRisksCallable.RISK_INFO_CREATE_KIND).execute();
                new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Risks.inform.create", 0, str);
            } catch (IOException e10) {
                i10 = 4312;
                str = str + ", " + e10.toString();
                throw e10;
            }
        } catch (Throwable th2) {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Risks.inform.create", i10, str);
            throw th2;
        }
    }

    /* renamed from: t */
    public void m74764t(String str) throws IOException {
        C0086a c0086aM60455e = C9679b.m60452d().m60455e();
        if (c0086aM60455e == null) {
            C1120a.m6676e("AlbumClientRequest", "getDisplayName userClient is null ");
            return;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                RisksRequst risksRequst = new RisksRequst();
                risksRequst.setReason(str);
                risksRequst.setType("account");
                Risks.Appeal appealSubmitAccountAppeal = c0086aM60455e.m675b().submitAccountAppeal(risksRequst);
                appealSubmitAccountAppeal.setHeader("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
                appealSubmitAccountAppeal.setHeader("x-hw-3rdapp-packagename", "com.huawei.hidisk");
                appealSubmitAccountAppeal.setHeader("x-hw-3rdapp-version", "16.0.0.300");
                appealSubmitAccountAppeal.setHeader("x-hw-trace-id", strM6755Z0);
                appealSubmitAccountAppeal.execute();
            } catch (IOException e10) {
                String str2 = ", " + e10.toString();
                throw e10;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Risks.appeal.create", 0, "");
        }
    }

    /* renamed from: u */
    public Album m74765u(Album album) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "createShareAlbum cloudPhoto is null ");
            return null;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                try {
                    Album album2 = new Album();
                    album2.setAlbumName(album.getAlbumName());
                    album2.setAppSettings(album.getAppSettings());
                    album2.setBabyInfo(album.getBabyInfo());
                    album2.setBackgroundImage(album.getBackgroundImage());
                    album2.setCoverImage(album.getCoverImage());
                    album2.setDescription(album.getDescription());
                    album2.setEditedTime(new C4644l(System.currentTimeMillis()));
                    album2.setFavorite(album.getFavorite());
                    album2.setPrivilege(album.getPrivilege());
                    album2.setProperties(album.getProperties());
                    album2.setResource(PowerKitApplyUtil.GROUP_ALBUM);
                    album2.setShareType(album.getShareType());
                    album2.setSource(Build.MODEL);
                    album2.setType(1);
                    Albums.Update fields2 = c13924aM60445d.m83547d().update(album.getId(), album2).setFields2("id,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions(userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege),privilege,properties,resource,shareType,source,type,recycled");
                    C12088a c12088aM72266c = C12088a.m72266c();
                    C12088a.c cVar = C12088a.c.ALBUM_CLIENT_SHARE_UPDATE_ALBUM;
                    Albums.Update updateAddHeader = fields2.addHeader("x-hw-lock", (Object) c12088aM72266c.m72270e(cVar, true).getSessionId());
                    updateAddHeader.setAlbumClientHeader(strM6755Z0);
                    updateAddHeader.setRiskToken();
                    Album albumExecute = updateAddHeader.execute();
                    C1120a.m6675d("AlbumClientRequest", "album " + albumExecute.toString());
                    albumExecute.setDefaultAlbum(album.isDefaultAlbum());
                    albumExecute.setTopAlbum(album.isTopAlbum());
                    albumExecute.setNextCursor(album.getNextCursor());
                    albumExecute.setFlversion(album.getFlversion());
                    ArrayList<Album> arrayList = new ArrayList<>();
                    arrayList.add(albumExecute);
                    new C12941a().m77736k(arrayList);
                    C12088a.m72266c().m72275j(cVar);
                    new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Albums.update.patchmetadata", 0, "OK");
                    return albumExecute;
                } catch (Exception e10) {
                    e10.toString();
                    throw e10;
                }
            } catch (IOException e11) {
                e11.toString();
                throw e11;
            }
        } catch (Throwable th2) {
            C12088a.m72266c().m72275j(C12088a.c.ALBUM_CLIENT_SHARE_UPDATE_ALBUM);
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Albums.update.patchmetadata", 0, "OK");
            throw th2;
        }
    }

    /* renamed from: v */
    public void m74766v(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "updateApplicant cloudPhoto is null ");
            return;
        }
        String strM6755Z0 = C1122c.m6755Z0("04019");
        try {
            try {
                ApplicantUpdateRequest applicantUpdateRequest = new ApplicantUpdateRequest();
                applicantUpdateRequest.setStatus(str3);
                applicantUpdateRequest.setRemark(str5);
                applicantUpdateRequest.setPrivilege(str6);
                applicantUpdateRequest.setRole(Role.WRITER);
                applicantUpdateRequest.setKinship(str7);
                Applicants.Update update = c13924aM60445d.m83548e().update(applicantUpdateRequest);
                update.setApplicantId(str4);
                update.setAlbumClientHeader(strM6755Z0);
                update.execute();
                C1120a.m6675d("AlbumClientRequest", "updateApplicant success");
                if ("accept".equals(str3)) {
                    m74768x(str, m74761q(str, str2));
                }
            } catch (IOException e10) {
                String str8 = str4 + ", " + e10.toString();
                throw e10;
            } catch (Exception e11) {
                String str9 = str4 + ", " + e11.toString();
                throw e11;
            }
        } finally {
            new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Applicant.update", 0, str4);
        }
    }

    /* renamed from: w */
    public Permission m74767w(String str, String str2, String str3, PermissionUpdateRequest permissionUpdateRequest) throws IOException {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("AlbumClientRequest", "updatePermission cloudPhoto is null ");
            return null;
        }
        List<Permission> listM74761q = m74761q(str, str2);
        if (listM74761q == null || listM74761q.size() == 0) {
            C1120a.m6677i("AlbumClientRequest", "permissions is null");
        } else {
            int i10 = 0;
            for (int i11 = 0; i11 < listM74761q.size(); i11++) {
                Permission permission = listM74761q.get(i11);
                if (permission.getUserId().equals(str3)) {
                    String strM6755Z0 = C1122c.m6755Z0("04019");
                    String id2 = permission.getId();
                    try {
                        try {
                            C1120a.m6675d("AlbumClientRequest", "updatePermission albumId:" + str + " permission.getId：" + permission.getId());
                            String id3 = permission.getId();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("update permissionId:");
                            sb2.append(id3);
                            C1120a.m6675d("AlbumClientRequest", sb2.toString());
                            Permissions.Update updateAddHeader = c13924aM60445d.m83550g().update(permissionUpdateRequest).setAlbumId(str).setPermissionId(id3).addHeader("x-hw-album-owner-Id", (Object) str2);
                            updateAddHeader.setAlbumClientHeader(strM6755Z0);
                            updateAddHeader.setRiskToken();
                            updateAddHeader.setFields2("userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege");
                            Permission permissionExecute = updateAddHeader.execute();
                            C1120a.m6675d("AlbumClientRequest", "updatePermission success: " + permissionExecute.toString());
                            listM74761q.set(i11, permissionExecute);
                            m74768x(str, listM74761q);
                            return permissionExecute;
                        } catch (IOException e10) {
                            i10 = 4312;
                            id2 = id2 + ", " + e10.toString();
                            throw e10;
                        }
                    } finally {
                        new CommonOpsReport(C0213f.m1377a()).m15209C(strM6755Z0, "Share.Permissions.update", i10, id2);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: x */
    public final void m74768x(String str, List<Permission> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        C12941a c12941a = new C12941a();
        Album album = new Album();
        album.setId(str);
        album.setPermissions(list);
        ArrayList<Album> arrayList = new ArrayList<>();
        arrayList.add(album);
        c12941a.m77737l(arrayList);
        C1120a.m6677i("AlbumClientRequest", "updatePermissionToDB success");
    }

    public C12469b() {
    }
}
