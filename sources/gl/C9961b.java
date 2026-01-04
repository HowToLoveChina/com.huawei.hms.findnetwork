package gl;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.gson.reflect.TypeToken;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove;
import com.huawei.hicloud.cloudbackup.store.manager.BackupDevicesDBHelper;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0241z;
import p292fn.C9733f;
import p429kk.C11058a;
import p514o9.C11839m;
import p618rm.C12540b1;
import p709vj.C13452e;
import p814yl.C13998b0;

/* renamed from: gl.b */
/* loaded from: classes6.dex */
public class C9961b {

    /* renamed from: f */
    public static volatile C9961b f48774f;

    /* renamed from: a */
    public final C13998b0 f48775a = new C13998b0();

    /* renamed from: b */
    public volatile List<CBSDevice> f48776b;

    /* renamed from: c */
    public volatile int f48777c;

    /* renamed from: d */
    public volatile long f48778d;

    /* renamed from: e */
    public volatile long f48779e;

    /* renamed from: gl.b$a */
    public class a extends TypeToken<List<Object>> {
        public a() {
        }
    }

    /* renamed from: i */
    public static C9961b m61788i() {
        if (f48774f == null) {
            synchronized (C9961b.class) {
                try {
                    if (f48774f == null) {
                        f48774f = new C9961b();
                    }
                } finally {
                }
            }
        }
        return f48774f;
    }

    /* renamed from: m */
    public static /* synthetic */ boolean m61789m(String str, CBSDevice cBSDevice) {
        return cBSDevice != null && StringUtil.equals(str, cBSDevice.getDeviceId());
    }

    /* renamed from: b */
    public final long m61790b(List<CBSDevice> list) {
        if (C0209d.m1205R0(list)) {
            C11839m.m70688i("CloudBackUpClearClient", "itemList is empty");
            return 0L;
        }
        Iterator<CBSDevice> it = list.iterator();
        long jM1689g = 0;
        while (it.hasNext()) {
            jM1689g += C0241z.m1689g(it.next().getDeviceSpace(), 0L);
        }
        return jM1689g;
    }

    /* renamed from: c */
    public synchronized void m61791c(final String str) {
        try {
            if (!C0209d.m1205R0(this.f48776b)) {
                this.f48776b.removeIf(new Predicate() { // from class: gl.a
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C9961b.m61789m(str, (CBSDevice) obj);
                    }
                });
            }
            m61811y(this.f48776b);
            BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29558t(str);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: d */
    public void m61792d(CBSDevice cBSDevice, int i10) throws C9721b {
        this.f48775a.m84126W(cBSDevice.getBackupDeviceId(), C11058a.m66627b("02007"), m61796h(), 1, i10);
        CloudBackupService.getInstance().deleteLocalCache(cBSDevice.getDeviceId());
    }

    /* renamed from: e */
    public void m61793e(CBSDevice cBSDevice, int i10, int i11) throws C9721b {
        this.f48775a.m84126W(cBSDevice.getBackupDeviceId(), C11058a.m66627b("02007"), i11, 1, i10);
        CloudBackupService.getInstance().deleteLocalCache(cBSDevice.getDeviceId());
    }

    /* renamed from: f */
    public synchronized long m61794f(long j10) {
        this.f48779e += j10;
        if (this.f48779e <= 0) {
            return 0L;
        }
        return Math.min(this.f48779e, this.f48778d);
    }

    /* renamed from: g */
    public final long m61795g(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getLong("sp_space_clear_backup_size_cache", 0L);
        }
        return 0L;
    }

    /* renamed from: h */
    public int m61796h() {
        int spaceCleanRemoveDeviceNoBackTime;
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null || (spaceCleanRemoveDeviceNoBackTime = hiCloudSysParamMapM60757p.getSpaceCleanRemoveDeviceNoBackTime()) < 0) {
            return 3;
        }
        return spaceCleanRemoveDeviceNoBackTime;
    }

    /* renamed from: j */
    public int m61797j() {
        return this.f48777c;
    }

    /* renamed from: k */
    public List<HashMap<String, String>> m61798k() {
        ArrayList arrayList = new ArrayList();
        try {
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            String versionRangeSupportCloseBackup = hiCloudSysParamMapM60757p != null ? hiCloudSysParamMapM60757p.getVersionRangeSupportCloseBackup() : null;
            if (TextUtils.isEmpty(versionRangeSupportCloseBackup)) {
                C11839m.m70688i("CloudBackUpClearClient", "getVersionRangeSupportCloseBackup: default");
                HashMap map = new HashMap();
                map.put("start", String.valueOf(120200102));
                map.put("end", String.valueOf(Integer.MAX_VALUE));
                arrayList.add(map);
            } else {
                for (Object obj : (List) C12540b1.m75484b(versionRangeSupportCloseBackup, new a().getType())) {
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        HashMap map3 = new HashMap();
                        map3.put("start", (String) map2.get("start"));
                        map3.put("end", (String) map2.get("end"));
                        arrayList.add(map3);
                    }
                }
            }
            return arrayList;
        } catch (Exception unused) {
            C11839m.m70687e("CloudBackUpClearClient", "getVersionRangeSupportCloseBackup exception");
            return null;
        }
    }

    /* renamed from: l */
    public synchronized void m61799l() {
        C11839m.m70688i("CloudBackUpClearClient", "invalidCbsDeviceCache");
        this.f48777c = 0;
        this.f48776b = null;
        m61808v(C0213f.m1377a());
        BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29556b(C0213f.m1377a());
    }

    /* renamed from: n */
    public final void m61800n(CBSDevice cBSDevice, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    cBSDevice.setDeviceType(C0241z.m1685c(next));
                    cBSDevice.setDeviceId(jSONObject.getString(next));
                }
            }
        } catch (Exception unused) {
            C11839m.m70688i("CloudBackUpClearClient", "parseDevice error");
        }
    }

    /* renamed from: o */
    public Pair<List<CBSDevice>, Long> m61801o(String str) throws C9721b, SQLException {
        C11839m.m70688i("CloudBackUpClearClient", "queryDeviceDeleteList");
        try {
            Pair<List<CBSDevice>, Long> pairM61803q = m61803q(str);
            List<CBSDevice> list = (List) pairM61803q.first;
            BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29560v();
            BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29557s();
            BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29562y(list);
            return pairM61803q;
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackUpClearClient", "getDeviceDeleteList fail:" + e10.getMessage());
            throw e10;
        }
    }

    /* renamed from: p */
    public List<CBSDevice> m61802p() throws C9721b, SQLException {
        C11839m.m70688i("CloudBackUpClearClient", "queryDeviceDeleteList");
        try {
            List<CBSDevice> listM61804r = m61804r(m61796h());
            BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29560v();
            BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29557s();
            BackupDevicesDBHelper.m29555w(C0213f.m1377a()).m29562y(listM61804r);
            m61811y(listM61804r);
            this.f48776b = listM61804r;
            return listM61804r;
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackUpClearClient", "getDeviceDeleteList fail:" + e10.getMessage());
            m61811y(null);
            this.f48776b = null;
            throw e10;
        }
    }

    /* renamed from: q */
    public final Pair<List<CBSDevice>, Long> m61803q(String str) throws C9721b {
        Pair<List<Remove.Device4Del>, Long> pairM84133d0 = this.f48775a.m84133d0("device4Dels,nextCursor", false, C11058a.m66627b("02022"), 1, str);
        List<Remove.Device4Del> list = (List) pairM84133d0.first;
        if (C0209d.m1205R0(list)) {
            return new Pair<>(new ArrayList(), -1L);
        }
        C11839m.m70688i("CloudBackUpClearClient", "queryDeviceDeleteListV3,size:" + list.size());
        String strM80950o = C13452e.m80781L().m80950o();
        ArrayList arrayList = new ArrayList();
        for (Remove.Device4Del device4Del : list) {
            if ("0".equals(device4Del.getDeviceSpace())) {
                C11839m.m70688i("CloudBackUpClearClient", "not show device that space is zero");
            } else {
                CBSDevice cBSDevice = new CBSDevice();
                cBSDevice.setBakUpdateTime(String.valueOf(device4Del.getBakUpdateTime().m28458c()));
                cBSDevice.setDeviceCategory(device4Del.getDeviceCategory());
                cBSDevice.setDeviceSpace(device4Del.getDeviceSpace());
                cBSDevice.setDevDisplayName(device4Del.getDeviceDisplayName());
                cBSDevice.setBackupDeviceId(device4Del.getBackupDeviceId());
                cBSDevice.setAppVersion(device4Del.getAppVersion());
                cBSDevice.setTerminalType(device4Del.getTerminalType());
                m61800n(cBSDevice, device4Del.getDevice());
                if (TextUtils.isEmpty(strM80950o) || !strM80950o.equals(cBSDevice.getDeviceId())) {
                    arrayList.add(cBSDevice);
                } else {
                    C11839m.m70688i("CloudBackUpClearClient", "remove current device");
                }
            }
        }
        return new Pair<>(arrayList, (Long) pairM84133d0.second);
    }

    /* renamed from: r */
    public final List<CBSDevice> m61804r(int i10) throws C9721b {
        List<Remove.Device4Del> listM84135f0 = this.f48775a.m84135f0("device4Dels,nextCursor", false, C11058a.m66627b("02022"), i10, 1);
        if (C0209d.m1205R0(listM84135f0)) {
            return new ArrayList();
        }
        C11839m.m70688i("CloudBackUpClearClient", "queryDeviceDeleteListV3,size:" + listM84135f0.size());
        String strM80950o = C13452e.m80781L().m80950o();
        ArrayList arrayList = new ArrayList();
        for (Remove.Device4Del device4Del : listM84135f0) {
            if ("0".equals(device4Del.getDeviceSpace())) {
                C11839m.m70688i("CloudBackUpClearClient", "not show device that space is zero");
            } else {
                CBSDevice cBSDevice = new CBSDevice();
                cBSDevice.setBakUpdateTime(String.valueOf(device4Del.getBakUpdateTime().m28458c()));
                cBSDevice.setDeviceCategory(device4Del.getDeviceCategory());
                cBSDevice.setDeviceSpace(device4Del.getDeviceSpace());
                cBSDevice.setDevDisplayName(device4Del.getDeviceDisplayName());
                cBSDevice.setBackupDeviceId(device4Del.getBackupDeviceId());
                cBSDevice.setAppVersion(device4Del.getAppVersion());
                cBSDevice.setTerminalType(device4Del.getTerminalType());
                m61800n(cBSDevice, device4Del.getDevice());
                if (TextUtils.isEmpty(strM80950o) || !strM80950o.equals(cBSDevice.getDeviceId())) {
                    arrayList.add(cBSDevice);
                } else {
                    C11839m.m70688i("CloudBackUpClearClient", "remove current device");
                }
            }
        }
        return arrayList;
    }

    /* renamed from: s */
    public long m61805s() {
        return m61795g(C0213f.m1377a());
    }

    /* renamed from: t */
    public Pair<List<CBSDevice>, Long> m61806t(String str) {
        C11839m.m70688i("CloudBackUpClearClient", "queryList");
        Pair<List<CBSDevice>, Long> pair = new Pair<>(null, -1L);
        try {
            return m61801o(str);
        } catch (C9721b unused) {
            C11839m.m70687e("CloudBackUpClearClient", "queryList error");
            return pair;
        }
    }

    /* renamed from: u */
    public List<CBSDevice> m61807u() {
        C11839m.m70688i("CloudBackUpClearClient", "queryList");
        try {
            return m61802p();
        } catch (C9721b unused) {
            C11839m.m70687e("CloudBackUpClearClient", "queryList error");
            return null;
        }
    }

    /* renamed from: v */
    public final void m61808v(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            sharedPreferencesM1382b.edit().remove("sp_space_clear_backup_size_cache").commit();
        }
    }

    /* renamed from: w */
    public final void m61809w(Context context, long j10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            sharedPreferencesM1382b.edit().putLong("sp_space_clear_backup_size_cache", j10).commit();
        }
    }

    /* renamed from: x */
    public synchronized void m61810x(QuotaSpaceInfo quotaSpaceInfo) {
        try {
            if (quotaSpaceInfo != null) {
                this.f48778d = quotaSpaceInfo.getTotal();
                this.f48779e = quotaSpaceInfo.getAvailable();
            } else {
                this.f48778d = 0L;
                this.f48779e = 0L;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: y */
    public final void m61811y(List<CBSDevice> list) {
        if (list != null) {
            this.f48777c = list.size();
            m61809w(C0213f.m1377a(), m61790b(list));
        } else {
            this.f48777c = 0;
            m61809w(C0213f.m1377a(), 0L);
        }
    }
}
