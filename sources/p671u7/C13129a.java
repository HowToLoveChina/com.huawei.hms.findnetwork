package p671u7;

import android.database.SQLException;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GroupQueryResponse;
import com.huawei.android.hicloud.album.service.logic.callable.ReportRisksCallable;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.request.Changes;
import com.huawei.android.p069cg.request.response.ShareQueryResponse;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p635s7.C12757v;
import p649t6.C12943c;
import p701v6.C13360g;
import p709vj.C13452e;
import p765x7.C13719a;
import p804ya.C13924a;

/* renamed from: u7.a */
/* loaded from: classes2.dex */
public class C13129a {

    /* renamed from: u7.a$a */
    public class a extends TypeToken<Map<String, String>> {
    }

    /* renamed from: a */
    public static Album m78960a(GeneralAlbumData generalAlbumData) {
        Album album = new Album();
        album.setAlbumName(generalAlbumData.getAlbumName());
        album.setCreatedTime(new C4644l(generalAlbumData.getCreateTime()));
        album.setDescription("");
        album.setEditedTime(new C4644l(generalAlbumData.getTimestamp()));
        Boolean bool = Boolean.FALSE;
        album.setFavorite(bool);
        album.setId(generalAlbumData.getAlbumId());
        album.setLocalPath(generalAlbumData.getLpath());
        album.setRecycled(bool);
        album.setResource(PowerKitApplyUtil.GROUP_ALBUM);
        album.setSource(generalAlbumData.getSource());
        album.setProperties(m78968i(generalAlbumData.getExpandString()));
        album.setType(0);
        return album;
    }

    /* renamed from: b */
    public static Album m78961b(ShareAlbumData shareAlbumData) {
        Album album = new Album();
        album.setAlbumName(shareAlbumData.getShareName());
        album.setCreatedTime(new C4644l(System.currentTimeMillis()));
        album.setProperties(m78968i(shareAlbumData.getExpandString()));
        album.setDescription("");
        album.setEditedTime(new C4644l(System.currentTimeMillis()));
        Boolean bool = Boolean.FALSE;
        album.setFavorite(bool);
        album.setId(shareAlbumData.getShareId());
        album.setRecycled(bool);
        album.setResource(PowerKitApplyUtil.GROUP_ALBUM);
        album.setSource(Build.MODEL);
        album.setType(1);
        album.setPrivilege(0);
        album.setUserAccount(C13452e.m80781L().m80900d());
        if (Version.isSupportRiskReport()) {
            album.setOnlyFrdCanBeShared(Boolean.valueOf(shareAlbumData.getOnlyFrdCanBeShared() != 0));
        }
        return album;
    }

    /* renamed from: c */
    public static String m78962c(ShareAlbumData shareAlbumData, C13924a c13924a, Map<String, String> map) throws IOException {
        if (map != null && !TextUtils.isEmpty(map.get(shareAlbumData.getOwnerId()))) {
            return map.get(shareAlbumData.getOwnerId());
        }
        String bigStartCursor = c13924a.m83546c().getStartCursor().setFields2("startCursor").addHeader("x-hw-album-owner-Id", shareAlbumData.getOwnerId()).addHeader("x-hw-album-Id", shareAlbumData.getShareId()).execute().getBigStartCursor();
        if (map != null) {
            map.put(shareAlbumData.getOwnerId(), bigStartCursor);
        }
        return bigStartCursor;
    }

    /* renamed from: d */
    public static long m78963d(ShareAlbumData shareAlbumData, Album album, C13924a c13924a, C12943c c12943c, String str) throws Exception {
        String strM77764o = c12943c.m77764o(shareAlbumData.getShareId());
        if (TextUtils.isEmpty(strM77764o)) {
            c12943c.m77762m(shareAlbumData.getShareId(), shareAlbumData.getShareName(), album.getAlbumVersion(), str);
            return C0241z.m1688f(str);
        }
        if (strM77764o.equals(String.valueOf(-1L))) {
            c12943c.m77765p(shareAlbumData.getShareId(), shareAlbumData.getShareName(), album.getAlbumVersion(), str);
            return C0241z.m1688f(str);
        }
        if (strM77764o.equals(str)) {
            return C0241z.m1688f(strM77764o);
        }
        try {
            Changes.List kinds = c13924a.m83546c().list(C13719a.m82477e(strM77764o)).setPageSize(1).setFields2("newStartCursor,nextCursor,changes(changeType,mediaId,deleted)").setKinds(ReportRisksCallable.RISK_INFO_CREATE_KIND);
            C4609l headers = kinds.getHeaders();
            headers.put("x-hw-album-owner-Id", (Object) shareAlbumData.getOwnerId());
            headers.put("x-hw-album-Id", (Object) shareAlbumData.getShareId());
            ChangeList changeListExecute = kinds.execute();
            C1120a.m6675d("AlbumTransformation", "getShareFlversion changeList: " + changeListExecute.toString());
            List<Change> changes = changeListExecute.getChanges();
            if (changes == null || changes.isEmpty()) {
                return C0241z.m1688f(strM77764o);
            }
            c12943c.m77765p(shareAlbumData.getShareId(), shareAlbumData.getShareName(), album.getAlbumVersion(), str);
            return C0241z.m1688f(str);
        } catch (IOException e10) {
            C1120a.m6676e("AlbumTransformation", "getShareFlversion runTask IOException: " + e10.toString());
            if (!(e10 instanceof C4616s)) {
                throw e10;
            }
            C4616s c4616s = (C4616s) e10;
            int iM6802l0 = C1122c.m6802l0(c4616s);
            if ((c4616s.m28322f() != 410 || iM6802l0 != 4100) && (c4616s.m28322f() != 400 || iM6802l0 != 4002)) {
                throw e10;
            }
            C1120a.m6678w("AlbumTransformation", "getShareFlversion cursor invalid, reset");
            c12943c.m77765p(shareAlbumData.getShareId(), shareAlbumData.getShareName(), album.getAlbumVersion(), str);
            return C0241z.m1688f(str);
        }
    }

    /* renamed from: e */
    public static boolean m78964e(Album album, String str) throws Exception {
        long flversion;
        if (PowerKitApplyUtil.GROUP_ALBUM.equals(album.getResource())) {
            C13360g c13360g = new C13360g(PowerKitApplyUtil.GROUP_ALBUM, 2, C0213f.m1377a(), album.getId(), album.getAlbumOwnerId());
            c13360g.m80106e();
            ShareQueryResponse shareQueryResponseM80113o = c13360g.m80113o(ShareQueryResponse.class);
            if (shareQueryResponseM80113o == null || shareQueryResponseM80113o.getRecShareList() == null || shareQueryResponseM80113o.getRecShareList().isEmpty()) {
                C1120a.m6678w("AlbumTransformation", "getShareFlversionForV1 share error");
                return false;
            }
            flversion = shareQueryResponseM80113o.getRecShareList().get(0).getFlversion();
        } else {
            C12757v c12757v = new C12757v(C0213f.m1377a(), new String[]{album.getId()}, str);
            c12757v.m80106e();
            GroupQueryResponse groupQueryResponseM80113o = c12757v.m80113o(GroupQueryResponse.class);
            if (groupQueryResponseM80113o == null || groupQueryResponseM80113o.getGroupList() == null || groupQueryResponseM80113o.getGroupList().isEmpty()) {
                C1120a.m6678w("AlbumTransformation", "getShareFlversionForV1 group error");
                return false;
            }
            flversion = groupQueryResponseM80113o.getGroupList().get(0).getFlversion();
        }
        album.setFlversion(flversion);
        return true;
    }

    /* renamed from: f */
    public static long m78965f(Album album, ShareQueryResponse shareQueryResponse) {
        return album.getOwnedByMe().booleanValue() ? shareQueryResponse.getOwnShareList().get(0).getFlversion() : shareQueryResponse.getRecShareList().get(0).getFlversion();
    }

    /* renamed from: g */
    public static void m78966g(ShareAlbumData shareAlbumData, C12943c c12943c, String str, String str2) throws SQLException {
        if (TextUtils.isEmpty(c12943c.m77764o(shareAlbumData.getShareId()))) {
            c12943c.m77762m(shareAlbumData.getShareId(), shareAlbumData.getShareName(), str, str2);
        } else {
            c12943c.m77765p(shareAlbumData.getShareId(), shareAlbumData.getShareName(), str, str2);
        }
    }

    /* renamed from: h */
    public static boolean m78967h(Album album, ShareQueryResponse shareQueryResponse) {
        return album.getOwnedByMe().booleanValue() ? shareQueryResponse == null || shareQueryResponse.getOwnShareList() == null || shareQueryResponse.getOwnShareList().isEmpty() : shareQueryResponse == null || shareQueryResponse.getRecShareList() == null || shareQueryResponse.getRecShareList().isEmpty();
    }

    /* renamed from: i */
    public static Map<String, String> m78968i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (Map) new GsonBuilder().create().fromJson(str, new a().getType());
        } catch (Exception unused) {
            C1120a.m6676e("AlbumTransformation", "packageStringMap error");
            return null;
        }
    }

    /* renamed from: j */
    public static boolean m78969j(ShareAlbumData shareAlbumData, Album album, C13924a c13924a, boolean z10, Map<String, String> map) throws Exception {
        String strM78962c;
        long flversion;
        if ("1.0".equals(album.getAlbumVersion())) {
            if (PowerKitApplyUtil.GROUP_ALBUM.equals(album.getResource())) {
                C13360g c13360g = new C13360g(PowerKitApplyUtil.GROUP_ALBUM, album.getOwnedByMe().booleanValue() ? 1 : 2, C0213f.m1377a(), shareAlbumData.getShareId(), shareAlbumData.getOwnerId());
                c13360g.m80106e();
                ShareQueryResponse shareQueryResponseM80113o = c13360g.m80113o(ShareQueryResponse.class);
                if (m78967h(album, shareQueryResponseM80113o)) {
                    return false;
                }
                flversion = m78965f(album, shareQueryResponseM80113o);
            } else {
                C12757v c12757v = new C12757v(C0213f.m1377a(), new String[]{shareAlbumData.getShareId()}, null);
                c12757v.m80106e();
                GroupQueryResponse groupQueryResponseM80113o = c12757v.m80113o(GroupQueryResponse.class);
                if (groupQueryResponseM80113o == null || groupQueryResponseM80113o.getGroupList() == null || groupQueryResponseM80113o.getGroupList().isEmpty()) {
                    return false;
                }
                flversion = groupQueryResponseM80113o.getGroupList().get(0).getFlversion();
            }
            m78966g(shareAlbumData, new C12943c(), "1.0", String.valueOf(flversion));
            shareAlbumData.setFlversion(flversion);
            return true;
        }
        C12943c c12943c = new C12943c();
        String strM77763n = c12943c.m77763n(shareAlbumData.getShareId());
        if (!TextUtils.isEmpty(strM77763n) && strM77763n.equals("1.0")) {
            C1120a.m6676e("AlbumTransformation", "share album id not changed!");
            c12943c.m77759j(shareAlbumData.getShareId());
        }
        if (album.getOwnedByMe().booleanValue()) {
            strM78962c = C1136q.d.m7153q();
        } else {
            if (z10) {
                m78966g(shareAlbumData, c12943c, album.getAlbumVersion(), String.valueOf(-1L));
                shareAlbumData.setFlversion(-1L);
                return true;
            }
            strM78962c = m78962c(shareAlbumData, c13924a, map);
        }
        C1120a.m6675d("AlbumTransformation", "ownedByMe: " + album.getOwnedByMe() + ", hasNoPermission: " + z10 + ", shareVersion: " + strM78962c);
        shareAlbumData.setFlversion(m78963d(shareAlbumData, album, c13924a, c12943c, strM78962c));
        return true;
    }

    /* renamed from: k */
    public static GeneralAlbumData m78970k(Album album) {
        if (TextUtils.isEmpty(album.getId()) || album.getType() == null || album.getCreatedTime() == null) {
            return null;
        }
        GeneralAlbumData generalAlbumData = new GeneralAlbumData();
        generalAlbumData.setAlbumId(album.getId());
        generalAlbumData.setAlbumName(album.getAlbumName() == null ? "" : album.getAlbumName());
        generalAlbumData.setAlbumType(album.getType().toString());
        generalAlbumData.setCreateTime(album.getCreatedTime().m28458c());
        generalAlbumData.setSource(album.getSource());
        generalAlbumData.setLpath(album.getLocalPath());
        generalAlbumData.setExpandString(new JSONObject(album.getProperties()).toString());
        return generalAlbumData;
    }

    /* renamed from: l */
    public static ShareAlbumData m78971l(Album album, C13924a c13924a, int i10, Map<String, String> map) throws Exception {
        boolean z10;
        if (TextUtils.isEmpty(album.getId()) || album.getOwner() == null || album.getCreatedTime() == null) {
            return null;
        }
        ShareAlbumData shareAlbumData = new ShareAlbumData();
        shareAlbumData.setShareId(album.getId());
        shareAlbumData.setOwnerId(album.getOwner().getUserId());
        shareAlbumData.setShareName(album.getAlbumName() == null ? "" : album.getAlbumName());
        ArrayList arrayList = new ArrayList();
        List<Permission> permissions = album.getPermissions();
        if (permissions != null) {
            z10 = false;
            for (Permission permission : permissions) {
                if (permission.getUserId() != null) {
                    if (permission.getUserId().equals(shareAlbumData.getOwnerId())) {
                        if (!TextUtils.isEmpty(permission.getUserAccount())) {
                            shareAlbumData.setOwnerAcc(permission.getUserAccount());
                        }
                    } else if (permission.getUserId().equals(C13452e.m80781L().m80971t0()) && permission.getStatus() != null) {
                        z10 = permission.getStatus().intValue() != 1;
                    }
                }
                ShareReceiverData shareReceiverData = new ShareReceiverData();
                shareReceiverData.setReceiverId(permission.getUserId());
                shareReceiverData.setReceiverAcc(permission.getUserAccount());
                shareReceiverData.setStatus(permission.getStatus() == null ? 0 : permission.getStatus().intValue());
                shareReceiverData.setPrivilege(!permission.canUpload() ? 1 : 0);
                shareReceiverData.setShareId(album.getId());
                shareReceiverData.setReceiverName(permission.getDisplayName());
                arrayList.add(shareReceiverData);
            }
        } else {
            z10 = false;
        }
        shareAlbumData.setReceiverList(arrayList);
        shareAlbumData.setType(i10);
        shareAlbumData.setResource(album.getResource());
        shareAlbumData.setCreateTime(album.getCreatedTime().m28458c());
        shareAlbumData.setSource(album.getSource());
        if (!m78969j(shareAlbumData, album, c13924a, z10, map)) {
            return null;
        }
        shareAlbumData.setPrivilege(String.valueOf(album.getPrivilege()));
        if (Version.isSupportRiskReport()) {
            shareAlbumData.setOnlyFrdCanBeShared((album.getOnlyFrdCanBeShared() == null || !album.getOnlyFrdCanBeShared().booleanValue()) ? 0 : 1);
        }
        shareAlbumData.setExpandString(new JSONObject(album.getProperties()).toString());
        return shareAlbumData;
    }
}
