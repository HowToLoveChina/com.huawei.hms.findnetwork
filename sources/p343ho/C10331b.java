package p343ho;

import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import ck.C1443a;
import com.google.gson.Gson;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudParamMetaManager;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.request.appmashup.bean.C4984c;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mk.C11477c;
import p015ak.C0213f;
import p015ak.C0229n;
import p015ak.C0240y;
import p020ap.C1006a;
import p020ap.C1007b;
import p020ap.C1009d;
import p020ap.C1010e;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p264eo.InterfaceC9529b;
import p317go.C10025a;
import p514o9.C11827a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12312h0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: ho.b */
/* loaded from: classes6.dex */
public class C10331b extends AbstractC12367d {

    /* renamed from: a */
    public final C4984c f50003a;

    /* renamed from: b */
    public final InterfaceC9529b f50004b;

    /* renamed from: c */
    public final String f50005c;

    public C10331b(C4984c c4984c, InterfaceC9529b interfaceC9529b, String str) {
        this.f50003a = c4984c;
        this.f50004b = interfaceC9529b;
        this.f50005c = str;
    }

    /* renamed from: e */
    public static List<C4987f> m63602e(List<C4987f> list) {
        return (List) list.stream().filter(new Predicate() { // from class: ho.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10331b.m63603k((C4987f) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: k */
    public static /* synthetic */ boolean m63603k(C4987f c4987f) {
        String strM30026b = c4987f.m30026b();
        if (TextUtils.isEmpty(strM30026b)) {
            return false;
        }
        strM30026b.hashCode();
        if (strM30026b.equals(NotifyConstants.MashupKey.BC_SILENCEDEVICE_REMAINDAYS)) {
            return !TextUtils.equals("-1", c4987f.m30027c());
        }
        return true;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("AppMashupTask", "AppMashupTask start");
        ArrayList arrayList = new ArrayList();
        try {
            if (HiCloudParamMetaManager.LOACL_CLIENT.equals(this.f50003a.m30017d())) {
                List<String> listM30016c = this.f50003a.m30016c();
                if (listM30016c != null && !listM30016c.isEmpty()) {
                    Iterator<String> it = listM30016c.iterator();
                    while (it.hasNext()) {
                        C4987f c4987fM63606g = m63606g(it.next());
                        if (c4987fM63606g != null) {
                            arrayList.add(c4987fM63606g);
                        }
                    }
                }
            } else {
                List<C4987f> listM30024c = C10025a.m62170c().m62173d(this.f50003a, this.f50005c).m30024c();
                if (listM30024c == null || listM30024c.isEmpty()) {
                    C11839m.m70687e("AppMashupTask", "params is null or empty.");
                } else {
                    arrayList.addAll(m63602e(listM30024c));
                }
            }
            C11839m.m70688i("AppMashupTask", "AppMashupTask suceess");
            this.f50004b.mo59522a(arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("AppMashupTask", "AppMashupTask err : " + e10.m60659c() + " " + e10.getMessage());
            this.f50004b.mo59522a(arrayList);
        }
    }

    /* renamed from: d */
    public int m63604d() {
        if (C11842p.m70747M0(C0213f.m1377a())) {
            return 2;
        }
        return C11842p.m70762R0() ? 1 : 0;
    }

    /* renamed from: f */
    public final String m63605f() {
        return String.valueOf(C0229n.m1605d("/storage/emulated/0"));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: g */
    public C4987f m63606g(String str) {
        String strValueOf;
        C4987f c4987f;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1932124699:
                if (str.equals("cb.awayfrom.bak")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1577651708:
                if (str.equals("cnt.cur.album.feature")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1495150866:
                if (str.equals("cb.fea.app.wechat")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1449911440:
                if (str.equals("cnt.filemg.ver")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1433294042:
                if (str.equals("cb.fea.app")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1368704653:
                if (str.equals("cb.fea")) {
                    c10 = 5;
                    break;
                }
                break;
            case -1355775359:
                if (str.equals("cp.fea")) {
                    c10 = 6;
                    break;
                }
                break;
            case -1048237758:
                if (str.equals("cnt.term.useragreement")) {
                    c10 = 7;
                    break;
                }
                break;
            case -1012042872:
                if (str.equals("cnt.iap.ver")) {
                    c10 = '\b';
                    break;
                }
                break;
            case -992831606:
                if (str.equals("pf.fea")) {
                    c10 = '\t';
                    break;
                }
                break;
            case -852000786:
                if (str.equals("cnt.cur.ser.time")) {
                    c10 = '\n';
                    break;
                }
                break;
            case -791298403:
                if (str.equals("cnt.cloud.space.info.server")) {
                    c10 = 11;
                    break;
                }
                break;
            case -778622620:
                if (str.equals("cnt.term.privacystatement")) {
                    c10 = '\f';
                    break;
                }
                break;
            case -670154384:
                if (str.equals("cnt.device.modetype")) {
                    c10 = '\r';
                    break;
                }
                break;
            case -473613002:
                if (str.equals("cnt.device.mode")) {
                    c10 = 14;
                    break;
                }
                break;
            case -258069075:
                if (str.equals("cb.wait.bak.size")) {
                    c10 = 15;
                    break;
                }
                break;
            case -214947255:
                if (str.equals("cnt.cur.user.timezone")) {
                    c10 = 16;
                    break;
                }
                break;
            case -111455095:
                if (str.equals("cnt.user.name")) {
                    c10 = 17;
                    break;
                }
                break;
            case 14838810:
                if (str.equals("cb.fea.app.wechat.split")) {
                    c10 = 18;
                    break;
                }
                break;
            case 290773619:
                if (str.equals("cnt.device.visible.rect")) {
                    c10 = 19;
                    break;
                }
                break;
            case 310221789:
                if (str.equals("cnt.iap.appver")) {
                    c10 = 20;
                    break;
                }
                break;
            case 422819812:
                if (str.equals("cp.dsu.clear")) {
                    c10 = 21;
                    break;
                }
                break;
            case 431218946:
                if (str.equals("cp.dsu.local")) {
                    c10 = 22;
                    break;
                }
                break;
            case 462185716:
                if (str.equals("cnt.huaweipay.appver")) {
                    c10 = 23;
                    break;
                }
                break;
            case 660500372:
                if (str.equals("cb.fea.app.qq.split")) {
                    c10 = 24;
                    break;
                }
                break;
            case 926373278:
                if (str.equals("cnt.ver")) {
                    c10 = 25;
                    break;
                }
                break;
            case 942850803:
                if (str.equals("cb.fea.apps.status")) {
                    c10 = 26;
                    break;
                }
                break;
            case 1253997428:
                if (str.equals("bs.dsu.local.free")) {
                    c10 = 27;
                    break;
                }
                break;
            case 1769751418:
                if (str.equals("cp.qty.notuploaded")) {
                    c10 = 28;
                    break;
                }
                break;
            case 1815595439:
                if (str.equals("sync.fea")) {
                    c10 = 29;
                    break;
                }
                break;
            case 1893290268:
                if (str.equals("cb.bak.app.list")) {
                    c10 = 30;
                    break;
                }
                break;
            case 1984651220:
                if (str.equals("cnt.cloud.space.info")) {
                    c10 = 31;
                    break;
                }
                break;
        }
        strValueOf = "";
        switch (c10) {
            case 0:
                strValueOf = String.valueOf(C1007b.m5980s().m6034z());
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 1:
                InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                strValueOf = interfaceC9282a != null ? String.valueOf(interfaceC9282a.mo58392S(C0213f.m1377a())) : "";
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 2:
                strValueOf = m63607h(C1007b.m5980s().m6021l());
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 3:
                strValueOf = C0240y.m1680b(C0213f.m1377a(), NextRestoreConstants.PKG_NAME_FILE_MANAGER);
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 4:
                strValueOf = m63607h(C1007b.m5980s().m6019j());
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 5:
                strValueOf = m63607h(C10028c.m62182c0().m62388s("backup_key"));
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 6:
                strValueOf = m63607h(C1006a.m5936k().m5975v(C0213f.m1377a()));
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 7:
                strValueOf = C11827a.m70484i();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case '\b':
                strValueOf = C1009d.m6109e().m6116h();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case '\t':
                strValueOf = m63607h(C1010e.m6125b().m6138d(C0213f.m1377a()));
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case '\n':
                strValueOf = String.valueOf(C12312h0.m74027b().m74028c());
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 11:
                ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
                if (spaceProxy == null) {
                    NotifyLogger.m29914e("AppMashupTask", "proxy is null, return cloud space info is null");
                } else {
                    strValueOf = new Gson().toJson(spaceProxy.getModuleSizePercentByServer());
                }
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case '\f':
                strValueOf = C11827a.m70481f();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case '\r':
                strValueOf = Build.MODEL;
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 14:
                strValueOf = String.valueOf(m63604d());
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 15:
                strValueOf = String.valueOf(C1007b.m5980s().m6023n());
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 16:
                String strM80901d0 = C13452e.m80781L().m80901d0();
                strValueOf = TextUtils.isEmpty(strM80901d0) ? "" : C11477c.m68633c(strM80901d0);
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 17:
                c4987f = new C4987f(str, C13452e.m80781L().m80841P(), "0");
                break;
            case 18:
                strValueOf = C1007b.m5980s().m6032x("com.tencent.mm");
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 19:
                strValueOf = C11842p.m70746M(C0213f.m1377a()) + "&" + C11842p.m70749N(C0213f.m1377a());
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 20:
                strValueOf = C1009d.m6109e().m6113d();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 21:
                strValueOf = String.valueOf(C1006a.m5936k().m5967n(C0213f.m1377a().getApplicationContext()));
                c4987f = new C4987f(str, strValueOf, "1800");
                break;
            case 22:
                strValueOf = String.valueOf(m63609l() + m63610m());
                c4987f = new C4987f(str, strValueOf, "1800");
                break;
            case 23:
                strValueOf = C0240y.m1680b(C0213f.m1377a(), "com.huawei.wallet");
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 24:
                strValueOf = C1007b.m5980s().m6032x("com.tencent.mobileqq");
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 25:
                c4987f = new C4987f(str, C1443a.f6213a, "0");
                break;
            case 26:
                strValueOf = C1007b.m5980s().m6018i();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 27:
                strValueOf = m63605f();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 28:
                strValueOf = String.valueOf(C1006a.m5936k().m5965l(C0213f.m1377a().getApplicationContext()));
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 29:
                strValueOf = m63608j();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 30:
                strValueOf = C1007b.m5980s().m6022m();
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            case 31:
                ICloudSpaceProxy spaceProxy2 = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
                if (spaceProxy2 == null) {
                    NotifyLogger.m29914e("AppMashupTask", "spaceProxy is null, return cloud space info is null");
                } else {
                    strValueOf = new Gson().toJson(spaceProxy2.getModuleSizePercent());
                }
                c4987f = new C4987f(str, strValueOf, "0");
                break;
            default:
                c4987f = null;
                if (!str.startsWith("cb.wait.bak.size.module.")) {
                    C11839m.m70687e("AppMashupTask", "getLocalParam , key:" + str + " is not local key.");
                    break;
                } else {
                    String[] strArrSplit = str.split("cb.wait.bak.size.module.");
                    if (strArrSplit.length > 1) {
                        strValueOf = C1007b.m5980s().m6028t(strArrSplit[1]);
                        c4987f = new C4987f(str, strValueOf, "0");
                        break;
                    }
                }
                break;
        }
        C11839m.m70686d("AppMashupTask", "key:" + str + " , value : " + strValueOf);
        return c4987f;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.DATA_DICTIONARY;
    }

    /* renamed from: h */
    public final String m63607h(boolean z10) {
        return z10 ? "1" : "0";
    }

    /* renamed from: j */
    public final String m63608j() {
        HashMap map = new HashMap();
        List<String> allShownSyncServiceId = NotifyUtil.getAllShownSyncServiceId(C0213f.m1377a().getApplicationContext());
        if (!allShownSyncServiceId.isEmpty()) {
            for (String str : allShownSyncServiceId) {
                map.put(str, Boolean.valueOf("atlas".equals(str) ? C1006a.m5936k().m5975v(C0213f.m1377a()) : C10028c.m62183d0(C0213f.m1377a()).m62388s(str)));
            }
        }
        try {
            return new Gson().toJson(map);
        } catch (Exception e10) {
            C11839m.m70687e("AppMashupTask", "getSyncSwitchStatus err : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: l */
    public final long m63609l() {
        C11839m.m70688i("AppMashupTask", "queryImagesSize start");
        Cursor cursorQuery = null;
        long j10 = 0;
        try {
            try {
                cursorQuery = C0213f.m1377a().getApplicationContext().getContentResolver().query(MediaStore.Images.Media.getContentUri("external"), new String[]{"_id", "bucket_display_name", "_size"}, "_size > " + (C11829c.f54756b ? 1000 : 1024), null, "_id asc");
                if (cursorQuery != null) {
                    int columnIndex = cursorQuery.getColumnIndex("_size");
                    while (cursorQuery.moveToNext()) {
                        j10 += cursorQuery.getLong(columnIndex);
                    }
                }
                C11839m.m70688i("AppMashupTask", "queryImagesSize success:" + j10);
            } catch (Exception e10) {
                C11839m.m70687e("AppMashupTask", "queryImagesSize database error. " + e10.getMessage());
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return j10;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: m */
    public final long m63610m() {
        C11839m.m70688i("AppMashupTask", "queryVideosSize start");
        Cursor cursorQuery = null;
        long j10 = 0;
        try {
            try {
                cursorQuery = C0213f.m1377a().getApplicationContext().getContentResolver().query(MediaStore.Video.Media.getContentUri("external"), new String[]{"_id", "bucket_display_name", "_size"}, "_size > 1", null, "_id asc");
                if (cursorQuery != null) {
                    int columnIndex = cursorQuery.getColumnIndex("_size");
                    while (cursorQuery.moveToNext()) {
                        j10 += cursorQuery.getLong(columnIndex);
                    }
                }
                C11839m.m70688i("AppMashupTask", "queryVideosSize success: " + j10);
            } catch (Exception e10) {
                C11839m.m70687e("AppMashupTask", "queryVideosSize error. " + e10.getMessage());
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return j10;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }
}
