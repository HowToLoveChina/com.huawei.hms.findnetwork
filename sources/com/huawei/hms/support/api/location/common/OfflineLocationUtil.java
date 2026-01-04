package com.huawei.hms.support.api.location.common;

import android.net.wifi.ScanResult;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthNr;
import as.C1016d;
import com.huawei.hms.support.api.entity.location.offlinelocation.HwCellInfo;
import com.huawei.hms.support.api.entity.location.offlinelocation.HwWifiInfo;
import es.C9551p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class OfflineLocationUtil {
    private static final int RAT_GSM = 1;
    private static final int RAT_LTE = 3;
    private static final int RAT_NR = 4;
    private static final int RAT_WCDMA = 2;
    private static final String TAG = "OfflineLocationUtil";
    private static AtomicBoolean isHasCellInfoNr;

    private static int getCellSignalStrength(CellInfoNr cellInfoNr) {
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
        C1016d.m6181a(TAG, "getCellSignalStrength error");
        return dbm;
    }

    private static HwCellInfo parseCellInfo(CellInfo cellInfo) {
        HwCellInfo hwCellInfo = new HwCellInfo();
        if (cellInfo instanceof CellInfoGsm) {
            parseCellInfoGsm((CellInfoGsm) cellInfo, hwCellInfo);
        } else if (cellInfo instanceof CellInfoWcdma) {
            parseCellInfoWcdma((CellInfoWcdma) cellInfo, hwCellInfo);
        } else if (cellInfo instanceof CellInfoLte) {
            parseCellInfoLte((CellInfoLte) cellInfo, hwCellInfo);
        } else {
            if (isHasCellInfoNr == null) {
                isHasCellInfoNr = new AtomicBoolean(C9551p.m59641e("android.telephony.CellInfoNr"));
            }
            if (isHasCellInfoNr.get() && (cellInfo instanceof CellInfoNr)) {
                parseCellInfoNr((CellInfoNr) cellInfo, hwCellInfo);
            }
        }
        hwCellInfo.setTimeStamp(cellInfo.getTimeStamp());
        hwCellInfo.setRegistered(cellInfo.isRegistered());
        return hwCellInfo;
    }

    private static void parseCellInfoGsm(CellInfoGsm cellInfoGsm, HwCellInfo hwCellInfo) {
        hwCellInfo.setMcc(cellInfoGsm.getCellIdentity().getMcc());
        hwCellInfo.setMnc(cellInfoGsm.getCellIdentity().getMnc());
        hwCellInfo.setLacOrTac(cellInfoGsm.getCellIdentity().getLac());
        hwCellInfo.setCellId(cellInfoGsm.getCellIdentity().getCid());
        hwCellInfo.setRat(1);
        hwCellInfo.setRssi(cellInfoGsm.getCellSignalStrength().getDbm());
        hwCellInfo.setChannelNumber(cellInfoGsm.getCellIdentity().getArfcn());
        hwCellInfo.setPhysicalIdentity(cellInfoGsm.getCellIdentity().getBsic());
    }

    private static void parseCellInfoLte(CellInfoLte cellInfoLte, HwCellInfo hwCellInfo) {
        hwCellInfo.setMcc(cellInfoLte.getCellIdentity().getMcc());
        hwCellInfo.setMnc(cellInfoLte.getCellIdentity().getMnc());
        hwCellInfo.setLacOrTac(cellInfoLte.getCellIdentity().getTac());
        hwCellInfo.setCellId(cellInfoLte.getCellIdentity().getCi());
        hwCellInfo.setRat(3);
        hwCellInfo.setRssi(cellInfoLte.getCellSignalStrength().getDbm());
        hwCellInfo.setPhysicalIdentity(cellInfoLte.getCellIdentity().getPci());
        hwCellInfo.setChannelNumber(cellInfoLte.getCellIdentity().getEarfcn());
    }

    private static void parseCellInfoNr(CellInfoNr cellInfoNr, HwCellInfo hwCellInfo) {
        CellIdentity cellIdentity = cellInfoNr.getCellIdentity();
        if (cellIdentity instanceof CellIdentityNr) {
            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
            try {
                hwCellInfo.setMcc(Integer.parseInt(cellIdentityNr.getMccString()));
                hwCellInfo.setMnc(Integer.parseInt(cellIdentityNr.getMncString()));
            } catch (NumberFormatException unused) {
                C1016d.m6183c(TAG, "parse cellInfoNr mcc/mnc failed");
            }
            hwCellInfo.setLacOrTac(cellIdentityNr.getTac());
            hwCellInfo.setCellId(cellIdentityNr.getNci());
            hwCellInfo.setRat(4);
            hwCellInfo.setPhysicalIdentity(cellIdentityNr.getPci());
            hwCellInfo.setChannelNumber(cellIdentityNr.getNrarfcn());
            hwCellInfo.setRssi(getCellSignalStrength(cellInfoNr));
        }
    }

    private static void parseCellInfoWcdma(CellInfoWcdma cellInfoWcdma, HwCellInfo hwCellInfo) {
        hwCellInfo.setMcc(cellInfoWcdma.getCellIdentity().getMcc());
        hwCellInfo.setMnc(cellInfoWcdma.getCellIdentity().getMnc());
        hwCellInfo.setLacOrTac(cellInfoWcdma.getCellIdentity().getLac());
        hwCellInfo.setCellId(cellInfoWcdma.getCellIdentity().getCid());
        hwCellInfo.setRat(2);
        hwCellInfo.setRssi(cellInfoWcdma.getCellSignalStrength().getDbm());
        hwCellInfo.setPhysicalIdentity(cellInfoWcdma.getCellIdentity().getPsc());
        hwCellInfo.setChannelNumber(cellInfoWcdma.getCellIdentity().getUarfcn());
    }

    public static List<HwCellInfo> transformCellInfo(List<CellInfo> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CellInfo> it = list.iterator();
        while (it.hasNext()) {
            HwCellInfo cellInfo = parseCellInfo(it.next());
            if (cellInfo != null) {
                arrayList.add(cellInfo);
            }
        }
        C1016d.m6186f(TAG, "transformCellInfo end,size is:" + arrayList.size());
        return arrayList;
    }

    public static List<HwWifiInfo> transformWifiInfo(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : list) {
            HwWifiInfo hwWifiInfo = new HwWifiInfo();
            try {
                hwWifiInfo.setBssid(scanResult.BSSID);
            } catch (NumberFormatException unused) {
                C1016d.m6183c(TAG, "parse bssid failed");
            }
            hwWifiInfo.setRssi(scanResult.level);
            hwWifiInfo.setFrequency(scanResult.frequency);
            hwWifiInfo.setTimestamp(scanResult.timestamp);
            arrayList.add(hwWifiInfo);
        }
        C1016d.m6186f(TAG, "transformWifiInfo end,size is:" + arrayList.size());
        return arrayList;
    }
}
