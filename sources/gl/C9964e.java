package gl;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove;
import com.huawei.hicloud.cloudbackup.server.model.BaseRequest;
import com.huawei.hicloud.cloudbackup.server.model.DeviceDeleteListReq;
import com.huawei.hicloud.cloudbackup.server.model.UpdateDeleteSwitchReq;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import fk.C9721b;
import il.C10542o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p252e9.C9426c;
import p400jl.C10897a;
import p429kk.C11058a;
import p458lo.C11322a;
import p514o9.C11839m;
import p814yl.C13998b0;

/* renamed from: gl.e */
/* loaded from: classes6.dex */
public class C9964e {

    /* renamed from: f */
    public static volatile C9964e f48782f;

    /* renamed from: b */
    public volatile String f48784b;

    /* renamed from: c */
    public volatile boolean f48785c;

    /* renamed from: d */
    public final C10897a f48786d = new C10897a(C11058a.m66627b("02018"));

    /* renamed from: e */
    public final C13998b0 f48787e = new C13998b0();

    /* renamed from: a */
    public volatile List<CBSDevice> f48783a = new ArrayList();

    /* renamed from: f */
    public static C9964e m61814f() {
        if (f48782f == null) {
            synchronized (C9964e.class) {
                try {
                    if (f48782f == null) {
                        f48782f = new C9964e();
                    }
                } finally {
                }
            }
        }
        return f48782f;
    }

    /* renamed from: h */
    public static /* synthetic */ boolean m61815h(String str, CBSDevice cBSDevice) {
        return cBSDevice != null && StringUtil.equals(str, cBSDevice.getDeviceId());
    }

    /* renamed from: i */
    public static /* synthetic */ boolean m61816i(CBSDevice cBSDevice) {
        return cBSDevice != null && "0".equals(cBSDevice.getDeviceSpace());
    }

    /* renamed from: c */
    public synchronized void m61817c(final String str) {
        if (C0209d.m1205R0(this.f48783a)) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "cbsDeviceListCache is empty");
        } else {
            this.f48783a.removeIf(new Predicate() { // from class: gl.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C9964e.m61815h(str, (CBSDevice) obj);
                }
            });
        }
    }

    /* renamed from: d */
    public void m61818d(CBSDevice cBSDevice) throws C9721b {
        String strM66627b = C11058a.m66627b("02007");
        m61819e();
        if ("1".equals(this.f48784b)) {
            new C11322a(strM66627b).m68031o(cBSDevice.getDeviceId(), cBSDevice.getDeviceType());
        } else {
            this.f48787e.m84125V(cBSDevice.getBackupDeviceId(), strM66627b);
        }
        CloudBackupService.getInstance().deleteLocalCache(cBSDevice.getDeviceId());
    }

    /* renamed from: e */
    public final void m61819e() throws C9721b {
        if (TextUtils.isEmpty(this.f48784b)) {
            this.f48784b = new C10542o().m64664F0(this.f48787e, C11058a.m66627b("02016"));
        }
        C11839m.m70688i("CloudBackUpDeviceClearClient", "bakSourceStrategy:" + this.f48784b);
    }

    /* renamed from: g */
    public synchronized void m61820g() {
        C11839m.m70688i("CloudBackUpDeviceClearClient", "invalidCbsDeviceCache");
        this.f48784b = "";
        if (C0209d.m1205R0(this.f48783a)) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "cbsDeviceListCache is empty");
        } else {
            this.f48783a.clear();
        }
    }

    /* renamed from: j */
    public final void m61821j(CBSDevice cBSDevice, String str) {
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
            C11839m.m70688i("CloudBackUpDeviceClearClient", "parseDevice error");
        }
    }

    /* renamed from: k */
    public List<CBSDevice> m61822k(boolean z10) {
        if (!C0209d.m1205R0(this.f48783a)) {
            return this.f48783a;
        }
        try {
            m61825n(z10);
            return this.f48783a;
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "getDeviceDeleteList fail:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: l */
    public final List<CBSDevice> m61823l(boolean z10, int i10) throws C9721b {
        List<CBSDevice> devices = this.f48786d.m65891c(new DeviceDeleteListReq(z10, i10)).getDevices();
        devices.removeIf(new Predicate() { // from class: gl.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9964e.m61816i((CBSDevice) obj);
            }
        });
        return devices;
    }

    /* renamed from: m */
    public final List<CBSDevice> m61824m(boolean z10, int i10) throws C9721b {
        List<Remove.Device4Del> listM84134e0 = this.f48787e.m84134e0("device4Dels,nextCursor", z10, C11058a.m66627b("02018"), i10);
        if (C0209d.m1205R0(listM84134e0)) {
            return null;
        }
        C11839m.m70688i("CloudBackUpDeviceClearClient", "queryDeviceDeleteListV3,size:" + listM84134e0.size());
        ArrayList arrayList = new ArrayList();
        for (Remove.Device4Del device4Del : listM84134e0) {
            if ("0".equals(device4Del.getDeviceSpace())) {
                C11839m.m70688i("CloudBackUpDeviceClearClient", "not show device that space is zero");
            } else {
                CBSDevice cBSDevice = new CBSDevice();
                cBSDevice.setBakUpdateTime(String.valueOf(device4Del.getBakUpdateTime().m28458c()));
                cBSDevice.setDeviceCategory(device4Del.getDeviceCategory());
                cBSDevice.setDeviceSpace(device4Del.getDeviceSpace());
                cBSDevice.setDevDisplayName(device4Del.getDeviceDisplayName());
                cBSDevice.setBackupDeviceId(device4Del.getBackupDeviceId());
                m61821j(cBSDevice, device4Del.getDevice());
                arrayList.add(cBSDevice);
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    public List<CBSDevice> m61825n(boolean z10) throws C9721b {
        if (this.f48786d == null || this.f48787e == null) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "CloudBackupServer is null");
            return null;
        }
        m61819e();
        int iM59112e = C9426c.m59108d().m59112e();
        if ("1".equals(this.f48784b)) {
            this.f48783a = m61823l(z10, iM59112e);
        } else {
            this.f48783a = m61824m(z10, iM59112e);
        }
        return this.f48783a;
    }

    /* renamed from: o */
    public List<CBSDevice> m61826o(boolean z10, int i10) throws C9721b {
        if (this.f48786d == null || this.f48787e == null) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "CloudBackupServer is null");
            return null;
        }
        m61819e();
        new ArrayList();
        return "1".equals(this.f48784b) ? m61823l(z10, i10) : m61824m(z10, i10);
    }

    /* renamed from: p */
    public boolean m61827p() {
        if (this.f48786d == null || this.f48787e == null) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "Cloud Backup Server is null");
            return false;
        }
        try {
            m61819e();
            boolean z10 = true;
            if ("1".equals(this.f48784b)) {
                if (this.f48786d.m65892d(new BaseRequest(-1, "queryDeviceDeleteSwitch")).getClearSwitch() != 1) {
                    z10 = false;
                }
                this.f48785c = z10;
            } else {
                if (this.f48787e.m84107J0(C11058a.m66627b("02019")) != 1) {
                    z10 = false;
                }
                this.f48785c = z10;
            }
            C11839m.m70688i("CloudBackUpDeviceClearClient", "queryDeviceDeleteSwitch:" + this.f48785c);
            C9426c.m59108d().m59115h(this.f48785c);
            return this.f48785c;
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "queryDeviceDeleteSwitch fail:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: q */
    public boolean m61828q(boolean z10) {
        if (this.f48786d == null || this.f48787e == null) {
            C11839m.m70688i("CloudBackUpDeviceClearClient", "Cloud backup server is null");
            return false;
        }
        try {
            m61819e();
            int iM59112e = C9426c.m59108d().m59112e();
            if ("1".equals(this.f48784b)) {
                this.f48786d.m65904p(new UpdateDeleteSwitchReq(z10 ? 1 : 0, iM59112e));
            } else {
                this.f48787e.m84121Q0(z10 ? 1 : 0, iM59112e, C11058a.m66627b("02020"));
            }
            C11839m.m70688i("CloudBackUpDeviceClearClient", "setDeviceDeleteSwitch:" + z10);
            C9426c.m59108d().m59115h(z10);
            if (z10) {
                C9426c.m59108d().m59110b();
            }
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackUpDeviceClearClient", "setDeviceDeleteSwitch fail:" + e10.getMessage());
            C9426c.m59108d().m59115h(!z10);
            return false;
        }
    }
}
