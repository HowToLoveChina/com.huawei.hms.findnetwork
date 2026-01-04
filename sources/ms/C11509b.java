package ms;

import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.Comparator;

/* renamed from: ms.b */
/* loaded from: classes8.dex */
public final class C11509b implements Comparator<WifiInfo> {
    @Override // java.util.Comparator
    public final int compare(WifiInfo wifiInfo, WifiInfo wifiInfo2) {
        WifiInfo wifiInfo3 = wifiInfo;
        WifiInfo wifiInfo4 = wifiInfo2;
        if (wifiInfo3 != null || wifiInfo4 != null) {
            if (wifiInfo3 != null) {
                if (wifiInfo4 == null || wifiInfo3.getTime() > wifiInfo4.getTime() || (wifiInfo3.getTime() == wifiInfo4.getTime() && wifiInfo3.getRssi() > wifiInfo4.getRssi())) {
                    return -1;
                }
                if (wifiInfo3.getTime() != wifiInfo4.getTime() || wifiInfo3.getRssi() != wifiInfo4.getRssi()) {
                }
            }
            return 1;
        }
        return 0;
    }
}
