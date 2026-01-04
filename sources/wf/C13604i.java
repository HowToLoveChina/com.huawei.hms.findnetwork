package wf;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.http.PhoneFinderServer;
import com.huawei.android.remotecontrol.sharing.bean.ShareGrantInfo;
import com.huawei.android.remotecontrol.sharing.bean.SharingMemberItem;
import com.huawei.android.remotecontrol.sharing.bean.SystemConfigResponse;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p521og.C11881n;
import p575qe.C12347f;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: wf.i */
/* loaded from: classes4.dex */
public class C13604i {

    /* renamed from: f */
    public static volatile C13604i f61192f;

    /* renamed from: a */
    public volatile List<SharingMemberItem> f61193a;

    /* renamed from: b */
    public final Context f61194b;

    /* renamed from: c */
    public final PhoneFinderServer f61195c;

    /* renamed from: d */
    public long f61196d;

    /* renamed from: e */
    public long f61197e;

    public C13604i() {
        Context contextM74301m = C12347f.m74285n().m74301m();
        this.f61194b = contextM74301m;
        this.f61195c = new PhoneFinderServer(contextM74301m);
    }

    /* renamed from: e */
    public static C13604i m81782e() {
        if (f61192f == null) {
            synchronized (C13604i.class) {
                try {
                    if (f61192f == null) {
                        f61192f = new C13604i();
                    }
                } finally {
                }
            }
        }
        return f61192f;
    }

    /* renamed from: a */
    public long m81783a(SharingMemberItem sharingMemberItem, long j10) {
        return sharingMemberItem.getShareInterval() - (m81784b(j10) - sharingMemberItem.getShareStartTime());
    }

    /* renamed from: b */
    public long m81784b(long j10) {
        return (j10 - this.f61197e) + this.f61196d;
    }

    /* renamed from: c */
    public int m81785c() {
        try {
            this.f61195c.m26194d();
            return 0;
        } catch (Exception e10) {
            C13981a.m83989i("SharingInfoManger", "closeLocationShareSwitch error:" + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: d */
    public boolean m81786d(SharingMemberItem sharingMemberItem) {
        if (sharingMemberItem == null) {
            C13981a.m83988e("SharingInfoManger", "deleteShareGrant item is empty");
            return false;
        }
        ShareGrantInfo shareGrantInfo = new ShareGrantInfo();
        shareGrantInfo.setSenderName(C13452e.m80781L().m80900d());
        shareGrantInfo.setSenderDeviceType(AbstractC12139d.m72766e(this.f61194b).getDeviceType());
        shareGrantInfo.setSenderDeviceName(C13452e.m80781L().m80962r());
        shareGrantInfo.setSenderDeviceId(AbstractC12139d.m72766e(this.f61194b).getDeviceID());
        shareGrantInfo.setSenderUserId(AbstractC12139d.m72766e(this.f61194b).getUserID());
        shareGrantInfo.setReceiverUserId(sharingMemberItem.getUserId());
        shareGrantInfo.setRelationType(sharingMemberItem.getMemberType());
        try {
            boolean zM26196g = this.f61195c.m26196g(shareGrantInfo);
            C13981a.m83989i("SharingInfoManger", "deleteShareGrant result: " + zM26196g);
            return zM26196g;
        } catch (C9721b e10) {
            C13981a.m83988e("SharingInfoManger", "deleteShareGrant error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: f */
    public final ShareGrantInfo m81787f(String str, List<ShareGrantInfo> list, int i10) {
        for (ShareGrantInfo shareGrantInfo : list) {
            if (str.equals(shareGrantInfo.getReceiverUserId()) && i10 == shareGrantInfo.getRelationType()) {
                return shareGrantInfo;
            }
        }
        return null;
    }

    /* renamed from: g */
    public List<SharingMemberItem> m81788g() {
        try {
            List<SharingMemberItem> listM81791j = m81791j(this.f61195c.m26198i());
            if (C0209d.m1205R0(listM81791j)) {
                C13981a.m83988e("SharingInfoManger", "SharingMemberItems is empty");
                return null;
            }
            List<ShareGrantInfo> listM26200k = this.f61195c.m26200k();
            if (C0209d.m1205R0(listM26200k)) {
                C13981a.m83988e("SharingInfoManger", "grantInfo is empty");
                return listM81791j;
            }
            for (SharingMemberItem sharingMemberItem : listM81791j) {
                ShareGrantInfo shareGrantInfoM81787f = m81787f(sharingMemberItem.getUserId(), listM26200k, sharingMemberItem.getMemberType());
                if (shareGrantInfoM81787f != null) {
                    sharingMemberItem.setShareStartTime(shareGrantInfoM81787f.getShareStartTime());
                    sharingMemberItem.setShareInterval(shareGrantInfoM81787f.getShareInterval());
                    if (shareGrantInfoM81787f.getShareEndTime() == Long.MAX_VALUE) {
                        sharingMemberItem.setSharingOpen(true);
                        sharingMemberItem.setRemainingTime(Long.MAX_VALUE);
                    } else {
                        long jM81783a = m81783a(sharingMemberItem, System.currentTimeMillis());
                        if (jM81783a > 0) {
                            sharingMemberItem.setSharingOpen(true);
                            sharingMemberItem.setRemainingTime(jM81783a);
                        } else {
                            sharingMemberItem.setSharingOpen(false);
                            sharingMemberItem.setRemainingTime(-1L);
                        }
                    }
                }
            }
            this.f61193a = listM81791j;
            return listM81791j;
        } catch (Exception e10) {
            C13981a.m83988e("SharingInfoManger", "getSharingInfoWithoutCache error:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public void m81789h() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("serverTime");
            jSONArray.put("maxToFriendNum");
            jSONArray.put("maxFromFriendNum");
            jSONArray.put("maxShareToFriendNum");
            jSONArray.put("maxFromShareFriendNum");
            jSONObject.put("params", jSONArray);
            jSONObject.put("sceneId", 1);
            SystemConfigResponse systemConfigResponseM26201l = this.f61195c.m26201l(jSONObject.toString());
            if (systemConfigResponseM26201l == null || systemConfigResponseM26201l.getParams() == null) {
                return;
            }
            this.f61196d = systemConfigResponseM26201l.getParams().getServerTime();
            this.f61197e = System.currentTimeMillis();
        } catch (C9721b e10) {
            C13981a.m83988e("SharingInfoManger", "getSharingSystemConfig error: " + e10.getMessage());
        } catch (JSONException e11) {
            C13981a.m83988e("SharingInfoManger", "build jsonBody error " + e11.getMessage());
        }
    }

    /* renamed from: i */
    public int m81790i() {
        try {
            this.f61195c.m26203n();
            return 0;
        } catch (Exception e10) {
            C13981a.m83989i("SharingInfoManger", "openLocationShareSwitch error:" + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: j */
    public final List<SharingMemberItem> m81791j(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                SharingMemberItem sharingMemberItem = new SharingMemberItem();
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                sharingMemberItem.setAccountName(C11881n.m71362l(jSONObject, "friendAccountName"));
                sharingMemberItem.setUserId(C11881n.m71362l(jSONObject, "friendUserId"));
                sharingMemberItem.setAliasName(C11881n.m71362l(jSONObject, "friendAliasName"));
                sharingMemberItem.setMemberType(C0241z.m1686d(C11881n.m71362l(jSONObject, "relationType"), 2));
                sharingMemberItem.setIconUrl(C11881n.m71362l(jSONObject, "iconUrl"));
                arrayList.add(sharingMemberItem);
            } catch (JSONException e10) {
                C13981a.m83988e("SharingInfoManger", "parseSharingMembers JSONException:" + e10.getMessage());
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public int m81792k(SharingMemberItem sharingMemberItem) {
        if (sharingMemberItem == null) {
            C13981a.m83988e("SharingInfoManger", "setShareGrantTime item is empty");
            return 1;
        }
        ShareGrantInfo shareGrantInfo = new ShareGrantInfo();
        shareGrantInfo.setSenderUserId(AbstractC12139d.m72766e(this.f61194b).getUserID());
        shareGrantInfo.setSenderName(C13452e.m80781L().m80900d());
        shareGrantInfo.setSenderDeviceType(AbstractC12139d.m72766e(this.f61194b).getDeviceType());
        shareGrantInfo.setSenderDeviceId(AbstractC12139d.m72766e(this.f61194b).getDeviceID());
        String strM80962r = C13452e.m80781L().m80962r();
        if (TextUtils.isEmpty(strM80962r)) {
            strM80962r = C11881n.m71360j();
        }
        shareGrantInfo.setSenderDeviceName(strM80962r);
        shareGrantInfo.setReceiverUserId(sharingMemberItem.getUserId());
        shareGrantInfo.setShareStartTime(sharingMemberItem.getShareStartTime());
        shareGrantInfo.setShareInterval(sharingMemberItem.getShareInterval());
        long shareInterval = Long.MAX_VALUE;
        if (sharingMemberItem.getShareInterval() != Long.MAX_VALUE) {
            shareInterval = sharingMemberItem.getShareInterval() + sharingMemberItem.getShareStartTime();
        }
        shareGrantInfo.setShareEndTime(shareInterval);
        shareGrantInfo.setRelationType(sharingMemberItem.getMemberType());
        try {
            return this.f61195c.m26209t(shareGrantInfo);
        } catch (C9721b e10) {
            C13981a.m83988e("SharingInfoManger", "setShareTime error: " + e10.getMessage());
            return 1;
        }
    }
}
