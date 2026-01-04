package er;

import android.telephony.CellIdentity;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthNr;
import android.text.TextUtils;
import as.C1016d;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.C6769i;
import cr.C8944a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: er.b */
/* loaded from: classes8.dex */
public final class C9534b {

    /* renamed from: a */
    @SerializedName("MCC")
    private int f47395a;

    /* renamed from: b */
    @SerializedName("MNC")
    private int f47396b;

    /* renamed from: c */
    @SerializedName("LAC")
    private int f47397c;

    /* renamed from: d */
    @SerializedName("CELLID")
    private long f47398d;

    /* renamed from: e */
    @SerializedName("SIGNALSTRENGTH")
    private int f47399e;

    /* renamed from: f */
    @SerializedName("RAT")
    private int f47400f;

    /* renamed from: g */
    @SerializedName("CHANNELNUM")
    private int f47401g;

    /* renamed from: h */
    @SerializedName("PHYSICAL_IDENTITY")
    private int f47402h;

    /* renamed from: i */
    @SerializedName("BOOTTIME")
    private long f47403i;

    /* renamed from: b */
    public static void m59533b(C9534b c9534b, ArrayList arrayList) {
        c9534b.f47400f = 9;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C9534b c9534b2 = (C9534b) it.next();
            int i10 = c9534b2.f47400f;
            if (i10 == 4 || i10 == 3) {
                c9534b2.f47400f = 9;
            }
        }
    }

    /* renamed from: e */
    public static boolean m59534e(C9534b c9534b, ArrayList arrayList) {
        if (c9534b.f47400f == 3) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((C9534b) it.next()).f47400f == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void m59535a(C8944a c8944a) {
        if (!m59536c(c8944a)) {
            C1016d.m6181a("LocCellInfo", "set cell param failed");
            return;
        }
        int i10 = this.f47397c;
        if (i10 == Integer.MAX_VALUE) {
            i10 = -1;
        }
        this.f47397c = i10;
        if (!(c8944a.m56665a() instanceof CellInfoNr)) {
            this.f47398d = ((int) this.f47398d) != Integer.MAX_VALUE ? r6 : -1;
        } else {
            long j10 = this.f47398d;
            if (j10 == Long.MAX_VALUE) {
                j10 = -1;
            }
            this.f47398d = j10;
        }
    }

    /* renamed from: c */
    public final boolean m59536c(C8944a c8944a) {
        CellInfo cellInfoM56665a = c8944a.m56665a();
        if (cellInfoM56665a instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfoM56665a;
            if (cellInfoGsm != null) {
                this.f47395a = cellInfoGsm.getCellIdentity().getMcc();
                this.f47396b = cellInfoGsm.getCellIdentity().getMnc();
                this.f47397c = cellInfoGsm.getCellIdentity().getLac();
                this.f47398d = cellInfoGsm.getCellIdentity().getCid();
                this.f47399e = cellInfoGsm.getCellSignalStrength().getDbm();
                this.f47401g = cellInfoGsm.getCellIdentity().getArfcn();
                this.f47402h = cellInfoGsm.getCellIdentity().getBsic();
                this.f47400f = 1;
            }
        } else if (cellInfoM56665a instanceof CellInfoWcdma) {
            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfoM56665a;
            if (cellInfoWcdma != null) {
                this.f47395a = cellInfoWcdma.getCellIdentity().getMcc();
                this.f47396b = cellInfoWcdma.getCellIdentity().getMnc();
                this.f47397c = cellInfoWcdma.getCellIdentity().getLac();
                this.f47398d = cellInfoWcdma.getCellIdentity().getCid();
                this.f47399e = cellInfoWcdma.getCellSignalStrength().getDbm();
                this.f47401g = cellInfoWcdma.getCellIdentity().getUarfcn();
                this.f47402h = cellInfoWcdma.getCellIdentity().getPsc();
                this.f47400f = 2;
            }
        } else if (cellInfoM56665a instanceof CellInfoLte) {
            CellInfoLte cellInfoLte = (CellInfoLte) cellInfoM56665a;
            if (cellInfoLte != null) {
                this.f47395a = cellInfoLte.getCellIdentity().getMcc();
                this.f47396b = cellInfoLte.getCellIdentity().getMnc();
                this.f47397c = cellInfoLte.getCellIdentity().getTac();
                this.f47398d = cellInfoLte.getCellIdentity().getCi();
                this.f47399e = cellInfoLte.getCellSignalStrength().getDbm();
                this.f47401g = cellInfoLte.getCellIdentity().getEarfcn();
                this.f47402h = cellInfoLte.getCellIdentity().getPci();
                this.f47400f = 3;
            }
        } else {
            if (!(cellInfoM56665a instanceof CellInfoNr)) {
                C1016d.m6183c("LocCellInfo", "unknown cellInfo");
                return false;
            }
            CellInfoNr cellInfoNr = (CellInfoNr) cellInfoM56665a;
            if (cellInfoNr != null) {
                CellIdentity cellIdentity = cellInfoNr.getCellIdentity();
                if (cellIdentity instanceof CellIdentityNr) {
                    CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
                    String mccString = cellIdentityNr.getMccString();
                    String mncString = cellIdentityNr.getMncString();
                    this.f47399e = Integer.MAX_VALUE;
                    int dbm = cellInfoNr.getCellSignalStrength().getDbm();
                    this.f47399e = dbm;
                    if (dbm == Integer.MAX_VALUE) {
                        CellSignalStrength cellSignalStrength = cellInfoNr.getCellSignalStrength();
                        if (cellSignalStrength instanceof CellSignalStrengthNr) {
                            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellSignalStrength;
                            int ssRsrp = cellSignalStrengthNr.getSsRsrp();
                            int ssRsrq = cellSignalStrengthNr.getSsRsrq();
                            int ssSinr = cellSignalStrengthNr.getSsSinr();
                            int csiRsrp = cellSignalStrengthNr.getCsiRsrp();
                            int csiRsrq = cellSignalStrengthNr.getCsiRsrq();
                            int csiSinr = cellSignalStrengthNr.getCsiSinr();
                            if (ssRsrp != Integer.MAX_VALUE && ssRsrq != Integer.MAX_VALUE && ssSinr != Integer.MAX_VALUE) {
                                if (ssRsrp > 0) {
                                    ssRsrp = -ssRsrp;
                                }
                                this.f47399e = ssRsrp;
                            } else if (csiRsrp != Integer.MAX_VALUE && csiRsrq != Integer.MAX_VALUE && csiSinr != Integer.MAX_VALUE) {
                                if (csiRsrp > 0) {
                                    csiRsrp = -csiRsrp;
                                }
                                this.f47399e = csiRsrp;
                            }
                        }
                    }
                    if (this.f47399e != Integer.MAX_VALUE) {
                        if (!TextUtils.isEmpty(mccString)) {
                            this.f47395a = Integer.parseInt(mccString);
                        }
                        if (!TextUtils.isEmpty(mncString)) {
                            this.f47396b = Integer.parseInt(mncString);
                        }
                        this.f47398d = cellIdentityNr.getNci();
                        this.f47397c = cellIdentityNr.getTac();
                        this.f47401g = cellIdentityNr.getNrarfcn();
                        this.f47402h = cellIdentityNr.getPci();
                        this.f47400f = 4;
                    }
                }
            }
        }
        this.f47403i = c8944a.m56666b() / 1000000;
        return true;
    }

    /* renamed from: d */
    public final boolean m59537d(C9534b c9534b) {
        return c9534b != null && this.f47395a == c9534b.f47395a && this.f47396b == c9534b.f47396b;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("LocCellInfo{mcc=");
        sb2.append(this.f47395a);
        sb2.append(", mnc=");
        sb2.append(this.f47396b);
        sb2.append(", lac=");
        sb2.append(this.f47397c);
        sb2.append(", signalStrength=");
        sb2.append(this.f47399e);
        sb2.append(", bootTime=");
        sb2.append(this.f47403i);
        sb2.append(", Rat=");
        sb2.append(this.f47400f);
        sb2.append(", channelNum=");
        return C6769i.m38373a(sb2, this.f47401g, '}');
    }
}
