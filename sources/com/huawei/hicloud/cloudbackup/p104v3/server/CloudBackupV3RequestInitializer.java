package com.huawei.hicloud.cloudbackup.p104v3.server;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import ck.C1443a;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0228m0;
import p514o9.C11839m;
import p514o9.C11842p;
import p579qi.AbstractC12361b;
import p579qi.InterfaceC12362c;
import p583qm.C12379g;
import p709vj.C13452e;
import p846zj.C14306d;

/* loaded from: classes6.dex */
public class CloudBackupV3RequestInitializer implements InterfaceC12362c {
    private static final List<String> REQUIRED_KEYS = new ArrayList<String>() { // from class: com.huawei.hicloud.cloudbackup.v3.server.CloudBackupV3RequestInitializer.1
        public C48861() {
            add(JsbMapKeyNames.H5_USER_ID);
            add("x-hw-device-id");
        }
    };

    /* renamed from: com.huawei.hicloud.cloudbackup.v3.server.CloudBackupV3RequestInitializer$1 */
    public class C48861 extends ArrayList<String> {
        public C48861() {
            add(JsbMapKeyNames.H5_USER_ID);
            add("x-hw-device-id");
        }
    }

    private String getClientIp() throws SocketException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String hostAddress = null;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (inetAddressNextElement != null && !inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        hostAddress = inetAddressNextElement.getHostAddress();
                        break;
                    }
                }
            }
            return hostAddress;
        } catch (Exception unused) {
            return null;
        }
    }

    private void setHeader(C4609l c4609l, String str, Object obj) throws IOException {
        if (obj == null) {
            if (REQUIRED_KEYS.contains(str)) {
                throw new C12379g("http params invalid, key = " + str);
            }
            return;
        }
        if (!(obj instanceof String) || !C4633d0.m28404a((String) obj)) {
            c4609l.set(str, obj);
        } else if (REQUIRED_KEYS.contains(str)) {
            throw new C12379g("http params invalid, key = " + str);
        }
    }

    @Override // p579qi.InterfaceC12362c
    public void initialize(AbstractC12361b<?> abstractC12361b) throws IOException {
        String strEncode;
        C4609l headers = abstractC12361b.getHeaders();
        setHeader(headers, JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        setHeader(headers, "x-hw-app-package-name", "com.huawei.hidisk");
        setHeader(headers, "x-hw-app-id", "10055832");
        setHeader(headers, "x-hw-app-version", C1443a.f6213a);
        setHeader(headers, "x-hw-terminal", Build.MODEL);
        setHeader(headers, "x-hw-os", C0209d.m1315v());
        setHeader(headers, "x-hw-device-category", C11842p.m70762R0() ? "pad" : "phone");
        try {
            strEncode = URLEncoder.encode(BluetoothAdapter.getDefaultAdapter().getName(), Constants.UTF_8);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupV3RequestInitializer", "encode error: " + e10.getMessage());
            strEncode = null;
        }
        int iM1225Y = C0209d.m1225Y(C0213f.m1377a());
        setHeader(headers, "x-hw-device-name", strEncode);
        setHeader(headers, "x-hw-device-type", Integer.valueOf(C13452e.m80781L().m80974u()));
        setHeader(headers, "x-hw-device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
        setHeader(headers, "x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        setHeader(headers, "x-hw-os-brand", C0209d.m1276l0());
        setHeader(headers, "x-hw-network", C0209d.m1228Z(iM1225Y));
        setHeader(headers, "x-hw-client-ip", getClientIp());
        setHeader(headers, "x-hw-device-brand", C0209d.m1160D());
        setHeader(headers, "x-hw-device-manufacturer", C0209d.m1164E());
        setHeader(headers, "x-hw-account-brand-id", C14306d.m85201b());
        setHeader(headers, "x-hw-app-brand-id", C0209d.m1156C());
        setHeader(headers, "androidVer", C0209d.m1307t());
        setHeader(headers, "emuiVer", C0209d.m1186L());
        headers.m28228T("com.huawei.hidisk/16.0.0.300");
    }
}
