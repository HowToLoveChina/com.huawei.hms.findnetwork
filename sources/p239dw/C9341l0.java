package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import cw.C8957b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p857zv.C14389c;

/* renamed from: dw.l0 */
/* loaded from: classes9.dex */
public class C9341l0 {

    /* renamed from: a */
    public NetworkCapability f46747a;

    /* renamed from: b */
    public Context f46748b;

    /* renamed from: c */
    public InterfaceC9323c0 f46749c;

    public C9341l0(Context context, InterfaceC9323c0 interfaceC9323c0, NetworkCapability networkCapability) {
        this.f46748b = context;
        this.f46747a = networkCapability;
        this.f46749c = interfaceC9323c0;
    }

    /* renamed from: a */
    public final void m58697a(NetworkResponse networkResponse, C9338k c9338k) throws C14389c, IOException {
        if (!networkResponse.isSuccessful()) {
            if (networkResponse.getCode() != 304) {
                C1029b.m6234e("KeyComponentManger", "file data update failed And statusCode = {0}", Integer.valueOf(networkResponse.getCode()));
                return;
            }
            C1029b.m6234e("KeyComponentManger", "file data has not modified!", new Object[0]);
            C8957b.m56707f(c9338k.m58689a(), System.currentTimeMillis(), this.f46748b);
            C9339k0.m58692a(this.f46748b, c9338k);
            return;
        }
        C9339k0.m58693b(this.f46748b, networkResponse.getBody());
        Context context = this.f46748b;
        Map<String, List<String>> headers = networkResponse.getHeaders();
        C1029b.m6230a("LocalCDNFile", "Update local meta data : ucscomponent", new Object[0]);
        if (headers.containsKey(SyncProtocol.Constant.ETAG)) {
            C1029b.m6230a("LocalCDNFile", "Update local meta data -etag: ucscomponent", new Object[0]);
            C8957b.m56708g("ETag_ucscomponent", headers.get(SyncProtocol.Constant.ETAG).get(0), context);
        }
        if (headers.containsKey("last-modified")) {
            C1029b.m6230a("LocalCDNFile", "Update local meta data -last-modified: ucscomponent", new Object[0]);
            C8957b.m56708g("Last-Modified_ucscomponent", headers.get("last-modified").get(0), context);
        }
        C8957b.m56707f(c9338k.m58689a(), System.currentTimeMillis(), this.f46748b);
        String str = this.f46748b.createDeviceProtectedStorageContext().getFilesDir() + "/ucscomponent.jws";
        C8957b.m56708g("ucscomponent.jws", str, this.f46748b);
        String body = networkResponse.getBody();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            try {
                fileOutputStream.write(body.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Write file data failed : ");
            sbM58651a.append(e10.getMessage());
            C1029b.m6231b("KeyComponentLocalHandler", sbM58651a.toString(), new Object[0]);
            StringBuilder sbM58651a2 = C9320b.m58651a("Write file data failed : ");
            sbM58651a2.append(e10.getMessage());
            throw new C14389c(1011L, sbM58651a2.toString());
        }
    }

    /* renamed from: b */
    public synchronized void m58698b(boolean z10, C9338k c9338k) throws C14389c {
        try {
            C1029b.m6234e("KeyComponentManger", "start download C1 file from Service", new Object[0]);
            try {
                Map map = new HashMap();
                if (!z10) {
                    map = c9338k.m58690b(this.f46748b);
                }
                String strMo58659a = this.f46749c.mo58659a("ucscomponent", "ucscomponent.jws");
                C1029b.m6234e("KeyComponentManger", "updateFileFromCDN domain is {0}", strMo58659a);
                m58697a(this.f46747a.get(new NetworkRequest(strMo58659a, map)), c9338k);
                C1029b.m6234e("KeyComponentManger", "updateFileFromCDN OK", new Object[0]);
            } catch (IOException e10) {
                StringBuilder sbM58651a = C9320b.m58651a("Update file data get IOException，exception: ");
                sbM58651a.append(e10.getMessage());
                String string = sbM58651a.toString();
                throw C9344n.m58700a("KeyComponentManger", string, new Object[0], 1010L, string);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
