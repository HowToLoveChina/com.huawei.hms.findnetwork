package ms;

import android.net.wifi.ScanResult;
import android.os.SystemClock;
import android.telephony.CellInfoNr;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthNr;
import android.text.TextUtils;
import android.util.Pair;
import as.C1016d;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.cell.CurrentCell;
import com.huawei.location.nlp.network.request.cell.HwCellInfo;
import com.huawei.location.nlp.network.request.cell.HwNeighborCellInfo;
import com.huawei.location.nlp.network.request.cell.NeighborCell;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import es.C9551p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p404js.InterfaceC10912a;

/* renamed from: ms.c */
/* loaded from: classes8.dex */
public class C11510c {

    /* renamed from: a */
    public InterfaceC10912a f53429a;

    /* renamed from: b */
    public long f53430b = 30000;

    /* renamed from: c */
    public boolean f53431c = C9551p.m59641e("android.telephony.CellInfoNr");

    public C11510c(InterfaceC10912a interfaceC10912a) {
        this.f53429a = interfaceC10912a;
    }

    /* renamed from: e */
    public static int m68707e(CellInfoNr cellInfoNr) {
        int dbm = cellInfoNr.getCellSignalStrength().getDbm();
        if (dbm != Integer.MAX_VALUE) {
            return dbm;
        }
        CellSignalStrength cellSignalStrength = cellInfoNr.getCellSignalStrength();
        if (!(cellSignalStrength instanceof CellSignalStrengthNr)) {
            return Integer.MAX_VALUE;
        }
        CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellSignalStrength;
        int ssRsrp = cellSignalStrengthNr.getSsRsrp();
        int ssRsrq = cellSignalStrengthNr.getSsRsrq();
        int ssSinr = cellSignalStrengthNr.getSsSinr();
        int csiRsrp = cellSignalStrengthNr.getCsiRsrp();
        int csiRsrq = cellSignalStrengthNr.getCsiRsrq();
        int csiSinr = cellSignalStrengthNr.getCsiSinr();
        if (ssRsrp != Integer.MAX_VALUE && ssRsrq != Integer.MAX_VALUE && ssSinr != Integer.MAX_VALUE) {
            return ssRsrp > 0 ? -ssRsrp : ssRsrp;
        }
        if (csiRsrp != Integer.MAX_VALUE && csiRsrq != Integer.MAX_VALUE && csiSinr != Integer.MAX_VALUE) {
            return csiRsrp > 0 ? -csiRsrp : csiRsrp;
        }
        C1016d.m6181a("ScanBase", "getCellSignalStrength error");
        return dbm;
    }

    /* renamed from: f */
    public static Pair m68708f(List list) throws NumberFormatException {
        String str;
        long j10;
        String str2;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        long mac = -1;
        long j11 = -1;
        while (it.hasNext()) {
            ScanResult scanResult = (ScanResult) it.next();
            String str3 = scanResult.BSSID;
            if (str3 == null) {
                str = "macStringToLong mac is null,return -1";
            } else {
                try {
                    j10 = Long.parseLong(str3.replace(":", ""), 16);
                } catch (NumberFormatException unused) {
                    str = "macStringToLong mac NumberFormatException";
                }
                long millis = TimeUnit.MICROSECONDS.toMillis(scanResult.timestamp);
                int i10 = scanResult.level;
                long j12 = scanResult.timestamp;
                int i11 = scanResult.frequency;
                if (j10 >= 1 || j10 > 281474976710654L) {
                    str2 = "isValidScanResult false mac";
                    C1016d.m6183c("ScanBase", str2);
                } else if (i10 >= 0 || i10 <= -120) {
                    str2 = "isValidScanResult false rssi";
                    C1016d.m6183c("ScanBase", str2);
                } else if (j12 <= 0) {
                    C1016d.m6183c("ScanBase", "isValidScanResult false boot");
                } else if ((i11 < 2400 || i11 > 2500) && (i11 < 4900 || i11 > 5850)) {
                    str2 = "isValidScanResult false frequency";
                    C1016d.m6183c("ScanBase", str2);
                } else {
                    if (millis > j11) {
                        j11 = millis;
                    }
                    arrayList.add(new WifiInfo(j10, i10, millis, i11));
                }
            }
            C1016d.m6183c("ScanBase", str);
            j10 = -1;
            long millis2 = TimeUnit.MICROSECONDS.toMillis(scanResult.timestamp);
            int i102 = scanResult.level;
            long j122 = scanResult.timestamp;
            int i112 = scanResult.frequency;
            if (j10 >= 1) {
            }
            str2 = "isValidScanResult false mac";
            C1016d.m6183c("ScanBase", str2);
        }
        C1016d.m6186f("ScanBase", "convertScanResult size is " + arrayList.size() + ", current time is " + SystemClock.elapsedRealtime() + ", bootTimeMax is " + j11);
        Pair pair = new Pair(Long.valueOf(j11), arrayList);
        StringBuilder sb2 = new StringBuilder("filterResult, wifiScanResult bootTime is ");
        sb2.append(pair.first);
        C1016d.m6186f("ScanBase", sb2.toString());
        if (((List) pair.second).size() > 120) {
            long jLongValue = ((Long) pair.first).longValue();
            List list2 = (List) pair.second;
            try {
                Collections.sort(list2, new C11509b());
            } catch (Exception unused2) {
                C1016d.m6183c("ScanBase", "sort exception");
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = list2.iterator();
            int frequency = -1;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WifiInfo wifiInfo = (WifiInfo) it2.next();
                if (jLongValue - wifiInfo.getTime() >= 8000000) {
                    it2.remove();
                }
                if (mac != wifiInfo.getMac() / 16 || frequency != wifiInfo.getFrequency()) {
                    arrayList2.add(wifiInfo);
                    mac = wifiInfo.getMac() / 16;
                    frequency = wifiInfo.getFrequency();
                }
                if (list2.size() + arrayList2.size() == 120) {
                    arrayList2.addAll(list2);
                    break;
                }
            }
        }
        return pair;
    }

    /* renamed from: g */
    public static void m68709g(HwCellInfo hwCellInfo, ArrayList arrayList, ArrayList arrayList2) {
        boolean z10;
        String str = hwCellInfo.getMcc() + "_" + hwCellInfo.getMnc();
        if (hwCellInfo.getRat() == 2 || hwCellInfo.getRat() == 3) {
            str = str + "_" + hwCellInfo.getChannelNumber();
            z10 = true;
        } else {
            z10 = false;
        }
        ArrayList arrayList3 = new ArrayList();
        if (arrayList.size() > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                HwNeighborCellInfo hwNeighborCellInfo = (HwNeighborCellInfo) arrayList.get(i10);
                String str2 = hwNeighborCellInfo.getMcc() + "_" + hwNeighborCellInfo.getMnc();
                if (z10) {
                    str2 = str2 + "_" + hwNeighborCellInfo.getChannelNumber();
                }
                if (str2.equals(str)) {
                    arrayList3.add(new NeighborCell(hwNeighborCellInfo.getChannelNumber(), hwNeighborCellInfo.getPhysicalIdentity(), hwNeighborCellInfo.getRssi()));
                }
                if (arrayList3.size() == 8) {
                    break;
                }
            }
        }
        CurrentCell currentCell = new CurrentCell();
        currentCell.setBoottime(hwCellInfo.getBoottime());
        currentCell.setMcc(hwCellInfo.getMcc());
        currentCell.setMnc(hwCellInfo.getMnc());
        currentCell.setLac(hwCellInfo.getLac());
        currentCell.setCellId(hwCellInfo.getCellId());
        currentCell.setRat(hwCellInfo.getRat());
        currentCell.setRssi(hwCellInfo.getRssi());
        arrayList2.add(new CellSourceInfo(currentCell, arrayList3));
    }

    /* renamed from: h */
    public static boolean m68710h(HwCellInfo hwCellInfo) {
        String str;
        if (hwCellInfo.getMcc() < 1 || hwCellInfo.getMcc() >= Integer.MAX_VALUE) {
            str = "hwCellInfo is invalid, mcc error";
        } else if (hwCellInfo.getMnc() < 0 || hwCellInfo.getMnc() >= Integer.MAX_VALUE) {
            str = "hwCellInfo is invalid, mnc error";
        } else if (hwCellInfo.getRssi() < -139 || hwCellInfo.getRssi() > -1) {
            str = "hwCellInfo is invalid, rssi error";
        } else {
            int rat = hwCellInfo.getRat();
            long cellId = hwCellInfo.getCellId();
            if (rat != 4 ? cellId < 1 || hwCellInfo.getCellId() >= 2147483647L : cellId < 1 || hwCellInfo.getCellId() >= Long.MAX_VALUE) {
                str = "hwCellInfo is invalid, cellId error";
            } else if (hwCellInfo.getRat() != 4 ? hwCellInfo.getLac() < 0 || hwCellInfo.getLac() > 65535 : hwCellInfo.getLac() < 0 || hwCellInfo.getLac() > 16777215) {
                str = "hwCellInfo is invalid, lac error";
            } else {
                if (hwCellInfo.getChannelNumber() >= 1 && hwCellInfo.getChannelNumber() < Integer.MAX_VALUE) {
                    return true;
                }
                str = "hwCellInfo is invalid, channelNumber error";
            }
        }
        C1016d.m6190j("ScanBase", str);
        return false;
    }

    /* renamed from: i */
    public static boolean m68711i(List<WifiInfo> list, List<WifiInfo> list2) {
        if (list2 == null || list2.isEmpty() || list.isEmpty()) {
            C1016d.m6183c("ScanBase", "wifi cache is null");
            return false;
        }
        if (list.size() != list2.size()) {
            return false;
        }
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list2.size(); i10++) {
            WifiInfo wifiInfo = list2.get(i10);
            map.put(String.valueOf(wifiInfo.getMac()), String.valueOf(wifiInfo.getRssi()));
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            WifiInfo wifiInfo2 = list.get(i11);
            String strValueOf = String.valueOf(wifiInfo2.getMac());
            if (!map.containsKey(strValueOf) || !TextUtils.equals((CharSequence) map.get(strValueOf), String.valueOf(wifiInfo2.getRssi()))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0406  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.Long, java.util.List<com.huawei.location.nlp.network.request.cell.CellSourceInfo>> m68712d(java.util.List<android.telephony.CellInfo> r25) {
        /*
            Method dump skipped, instructions count: 1132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.C11510c.m68712d(java.util.List):android.util.Pair");
    }
}
