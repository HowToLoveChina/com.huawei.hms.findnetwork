package p618rm;

import android.os.Bundle;
import android.util.Pair;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncAppBackupPolicy;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1006a;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9284c;
import p292fn.C9733f;
import p514o9.C11839m;
import p617rl.C12526j;
import p709vj.C13452e;

/* renamed from: rm.u1 */
/* loaded from: classes6.dex */
public class C12597u1 {

    /* renamed from: rm.u1$a */
    public class a extends HashMap<String, Pair<Integer, Integer>> {
        public a() {
            put(HNConstants.DataType.MEDIA, Pair.create(Integer.valueOf(R$string.gallery_item_title), Integer.valueOf(C0209d.m1293p1() ? R$drawable.ic_cloud_album_ink : C0209d.m1269j1() ? R$drawable.ic_cloud_album_honor : R$drawable.ic_cloud_album)));
            Integer numValueOf = Integer.valueOf(R$string.contact);
            int i10 = (!C0209d.m1293p1() && C0209d.m1269j1()) ? R$drawable.ic_contacts_honor : R$drawable.ic_contacts;
            put("addressbook", Pair.create(numValueOf, Integer.valueOf(i10)));
            put("calendar", Pair.create(Integer.valueOf(R$string.calendar_sync_item), Integer.valueOf(C0209d.m1293p1() ? R$drawable.icon_calendar_ink : C0209d.m1269j1() ? R$drawable.icon_calendar_honor : R$drawable.icon_calendar)));
            put("notepad", Pair.create(Integer.valueOf(R$string.notepad_app_name), Integer.valueOf(C0209d.m1293p1() ? R$drawable.ic_memorandum_ink : C0209d.m1269j1() ? R$drawable.ic_memorandum_honor : R$drawable.ic_memorandum)));
            put("browser", Pair.create(Integer.valueOf(R$string.browser), Integer.valueOf(C0209d.m1293p1() ? R$drawable.ic_hicloud_browser_list_new_ink : C0209d.m1269j1() ? R$drawable.ic_hicloud_browser_list_new_honor : R$drawable.ic_hicloud_browser_list_new)));
            put("wlan", Pair.create(Integer.valueOf(C0209d.m1262h2() ? R$string.wlan_sync : R$string.wifi_sync), Integer.valueOf(C0209d.m1293p1() ? R$drawable.ic_wifi_ink : R$drawable.ic_wifi)));
        }
    }

    /* renamed from: rm.u1$b */
    public class b extends HashMap<String, String> {
        public b() {
            put(NotifyUtil.HI_NOTE_SYNC_TYPE, NotifyUtil.HINOTE_PKG_NAME);
        }
    }

    /* renamed from: a */
    public static Map<String, Integer> m76025a() {
        HashMap map = new HashMap();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("SyncSwitchUtil", "getCloudAlbumSwitchStatus error, cloudAlbumRouterImpl is null");
            return map;
        }
        boolean zMo58417d = interfaceC9282a.mo58417d(C0213f.m1377a());
        map.put(HNConstants.DataType.MEDIA, Integer.valueOf(zMo58417d ? 1 : 0));
        C11839m.m70688i("SyncSwitchUtil", "getCloudAlbumSwitchStatus albumSwitch: " + zMo58417d);
        return map;
    }

    /* renamed from: b */
    public static List<String> m76026b() {
        ArrayList arrayList = new ArrayList();
        boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupSyncAppExclusive");
        Map<String, Integer> mapM76030f = m76030f();
        for (Map.Entry<String, SyncAppBackupPolicy> entry : m76029e().entrySet()) {
            String key = entry.getKey();
            SyncAppBackupPolicy value = entry.getValue();
            String syncAppName = value.getSyncAppName();
            if (zM60720O && mapM76030f.containsKey(syncAppName) && value.getPolicy() == 1 && 1 == mapM76030f.getOrDefault(syncAppName, 0).intValue()) {
                C11839m.m70688i("SyncSwitchUtil", "getFilterSyncAppExclusive appId: " + key + ", syncAppName: " + syncAppName + " status is open");
                arrayList.add(key);
            }
        }
        if (mapM76030f.getOrDefault(HNConstants.DataType.MEDIA, 0).intValue() == 1) {
            arrayList.add(HNConstants.DataType.MEDIA);
        }
        return arrayList;
    }

    /* renamed from: c */
    public static Map<String, Pair<Integer, Integer>> m76027c() {
        return new a();
    }

    /* renamed from: d */
    public static Map<String, String> m76028d() {
        return new b();
    }

    /* renamed from: e */
    public static Map<String, SyncAppBackupPolicy> m76029e() {
        Map<String, SyncAppBackupPolicy> mapM75355P0 = new C12526j().m75355P0();
        C11839m.m70688i("SyncSwitchUtil", "getSyncAppBackupPolicy: " + mapM75355P0.toString());
        return mapM75355P0;
    }

    /* renamed from: f */
    public static Map<String, Integer> m76030f() {
        HashMap map = new HashMap();
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c == null) {
            C11839m.m70689w("SyncSwitchUtil", "getSyncSwitchStatus error, cloudSyncRouter is null");
            return map;
        }
        Map<String, Integer> mapMo17086D0 = interfaceC9284c.mo17086D0();
        mapMo17086D0.putAll(m76025a());
        C11839m.m70688i("SyncSwitchUtil", "getSyncSwitchStatus " + mapMo17086D0.toString());
        return mapMo17086D0;
    }

    /* renamed from: g */
    public static void m76031g(boolean z10) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("SyncSwitchUtil", "setCloudAlbumSwitchStatus cloudAlbumRouterImpl is null, status: " + z10);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", z10);
        interfaceC9282a.mo58396U(C0213f.m1377a(), bundle, 18);
        C11839m.m70688i("SyncSwitchUtil", "setCloudAlbumSwitchStatus status: " + z10);
    }

    /* renamed from: h */
    public static int m76032h(String str, int i10) {
        C11839m.m70688i("SyncSwitchUtil", "setSyncSwitchStatus syncType: " + str + ", status: " + i10);
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c == null) {
            C11839m.m70689w("SyncSwitchUtil", "setSyncSwitchStatus error, cloudSyncRouter is null");
            return -1;
        }
        List<String> listM6036A = C1008c.m6035v().m6036A(C0213f.m1377a());
        C11839m.m70688i("SyncSwitchUtil", "setSyncSwitchStatus getSyncDataBaseListFromSp: " + listM6036A);
        boolean zM5973t = C1006a.m5936k().m5973t();
        if (C13452e.m80781L().m80791C0() && !zM5973t && !listM6036A.contains(str) && i10 == 1) {
            C11839m.m70687e("SyncSwitchUtil", "isBasicBusiness, setSyncSwitchStatus syncType invalid: " + str);
            return 1;
        }
        int iMo17115b0 = interfaceC9284c.mo17115b0(str, i10, PowerKitApplyUtil.GROUP_CLOUDBACKUP);
        C11839m.m70688i("SyncSwitchUtil", "setSyncSwitchStatus syncType: " + str + ", status: " + i10 + ", result: " + iMo17115b0);
        return iMo17115b0;
    }
}
