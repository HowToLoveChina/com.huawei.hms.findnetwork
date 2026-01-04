package com.baidu.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.geocoder.p064a.C1521e;
import com.baidu.geocoder.p064a.C1523g;
import com.baidu.location.p065a.C1534f;
import com.baidu.location.provider.C1540c;
import com.baidu.location.provider.C1542e;
import com.baidu.location.provider.C1543f;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LocationClient {
    private static final String FILE_COUNT = "PREFERENCEV1";
    private static final String FILE_TIME = "PREFERENCETIME";
    private static final String KEY_TIME = "createTime";
    private static final int TIMEOUT = 180000;
    private static final int TIMEUPLOAD = 10800000;
    public static Context mContext;
    private C1540c firstLocRequest;
    private String lastCell;
    private long lastTime;
    private Location mLastLoc;
    private String resultEntity;
    private BDLocation tempLocation;
    private int reTryConnTime = 3;
    private List<ScanResult> lastScanResult = new ArrayList();
    private boolean first = true;
    private LocationManager locationManager = null;
    private ArrayList<String> upDataList = null;
    private boolean uploading = false;

    /* renamed from: ip */
    private final String f6557ip = "loc.map.baidu.com";

    /* renamed from: com.baidu.location.LocationClient$1 */
    public class C15261 extends Thread {

        /* renamed from: a */
        final /* synthetic */ String f6558a;

        public C15261(String str) {
            str = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:1003:0x064f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1006:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:764:0x046b A[Catch: all -> 0x046f, TRY_LEAVE, TryCatch #56 {all -> 0x046f, blocks: (B:762:0x0456, B:764:0x046b, B:792:0x04c3, B:794:0x04d8, B:819:0x0525, B:821:0x053a, B:846:0x0588, B:848:0x059d, B:873:0x05eb, B:875:0x0600), top: B:967:0x0456 }] */
        /* JADX WARN: Removed duplicated region for block: B:770:0x047c  */
        /* JADX WARN: Removed duplicated region for block: B:791:0x04be A[PHI: r2 r11 r13 r18 r20
  0x04be: PHI (r2v24 java.io.IOException) = 
  (r2v5 java.io.IOException)
  (r2v9 java.io.IOException)
  (r2v13 java.io.IOException)
  (r2v17 java.io.IOException)
  (r2v29 java.io.IOException)
 binds: [B:817:0x0522, B:871:0x05e7, B:844:0x0584, B:898:0x0649, B:790:0x04bc] A[DONT_GENERATE, DONT_INLINE]
  0x04be: PHI (r11v9 boolean) = (r11v5 boolean), (r11v6 boolean), (r11v7 boolean), (r11v8 boolean), (r11v11 boolean) binds: [B:817:0x0522, B:871:0x05e7, B:844:0x0584, B:898:0x0649, B:790:0x04bc] A[DONT_GENERATE, DONT_INLINE]
  0x04be: PHI (r13v10 javax.net.ssl.HttpsURLConnection) = 
  (r13v4 javax.net.ssl.HttpsURLConnection)
  (r13v5 javax.net.ssl.HttpsURLConnection)
  (r13v6 javax.net.ssl.HttpsURLConnection)
  (r13v7 javax.net.ssl.HttpsURLConnection)
  (r13v12 javax.net.ssl.HttpsURLConnection)
 binds: [B:817:0x0522, B:871:0x05e7, B:844:0x0584, B:898:0x0649, B:790:0x04bc] A[DONT_GENERATE, DONT_INLINE]
  0x04be: PHI (r18v13 java.lang.String) = 
  (r18v5 java.lang.String)
  (r18v7 java.lang.String)
  (r18v9 java.lang.String)
  (r18v11 java.lang.String)
  (r18v15 java.lang.String)
 binds: [B:817:0x0522, B:871:0x05e7, B:844:0x0584, B:898:0x0649, B:790:0x04bc] A[DONT_GENERATE, DONT_INLINE]
  0x04be: PHI (r20v13 java.util.HashMap) = 
  (r20v5 java.util.HashMap)
  (r20v7 java.util.HashMap)
  (r20v9 java.util.HashMap)
  (r20v11 java.util.HashMap)
  (r20v15 java.util.HashMap)
 binds: [B:817:0x0522, B:871:0x05e7, B:844:0x0584, B:898:0x0649, B:790:0x04bc] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:794:0x04d8 A[Catch: all -> 0x046f, TRY_LEAVE, TryCatch #56 {all -> 0x046f, blocks: (B:762:0x0456, B:764:0x046b, B:792:0x04c3, B:794:0x04d8, B:819:0x0525, B:821:0x053a, B:846:0x0588, B:848:0x059d, B:873:0x05eb, B:875:0x0600), top: B:967:0x0456 }] */
        /* JADX WARN: Removed duplicated region for block: B:797:0x04e2  */
        /* JADX WARN: Removed duplicated region for block: B:821:0x053a A[Catch: all -> 0x046f, TRY_LEAVE, TryCatch #56 {all -> 0x046f, blocks: (B:762:0x0456, B:764:0x046b, B:792:0x04c3, B:794:0x04d8, B:819:0x0525, B:821:0x053a, B:846:0x0588, B:848:0x059d, B:873:0x05eb, B:875:0x0600), top: B:967:0x0456 }] */
        /* JADX WARN: Removed duplicated region for block: B:824:0x0544  */
        /* JADX WARN: Removed duplicated region for block: B:848:0x059d A[Catch: all -> 0x046f, TRY_LEAVE, TryCatch #56 {all -> 0x046f, blocks: (B:762:0x0456, B:764:0x046b, B:792:0x04c3, B:794:0x04d8, B:819:0x0525, B:821:0x053a, B:846:0x0588, B:848:0x059d, B:873:0x05eb, B:875:0x0600), top: B:967:0x0456 }] */
        /* JADX WARN: Removed duplicated region for block: B:851:0x05a7  */
        /* JADX WARN: Removed duplicated region for block: B:875:0x0600 A[Catch: all -> 0x046f, TRY_LEAVE, TryCatch #56 {all -> 0x046f, blocks: (B:762:0x0456, B:764:0x046b, B:792:0x04c3, B:794:0x04d8, B:819:0x0525, B:821:0x053a, B:846:0x0588, B:848:0x059d, B:873:0x05eb, B:875:0x0600), top: B:967:0x0456 }] */
        /* JADX WARN: Removed duplicated region for block: B:878:0x060a  */
        /* JADX WARN: Removed duplicated region for block: B:902:0x0657 A[LOOP:1: B:521:0x0091->B:902:0x0657, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:905:0x0667  */
        /* JADX WARN: Removed duplicated region for block: B:931:0x066c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:933:0x04e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:937:0x0685 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:939:0x0481 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:941:0x0500 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:943:0x0576 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:945:0x0514 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:947:0x060f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:955:0x0699 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:957:0x049a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:959:0x05ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:961:0x04ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:965:0x0628 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:969:0x05c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:971:0x063c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:973:0x0549 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:979:0x0562 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:981:0x05d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1717
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.C15261.run():void");
        }
    }

    /* renamed from: com.baidu.location.LocationClient$2 */
    public class C15272 extends Thread {

        /* renamed from: a */
        final /* synthetic */ String f6560a;

        public C15272(String str) {
            str = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:238:0x0179, code lost:
        
            if (r5 == null) goto L207;
         */
        /* JADX WARN: Code restructure failed: missing block: B:239:0x017b, code lost:
        
            r5.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:250:0x01ad, code lost:
        
            if (r5 == null) goto L207;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:228:0x0164 A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #5 {all -> 0x0168, blocks: (B:226:0x0148, B:228:0x0164, B:241:0x017f, B:243:0x019b), top: B:278:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:233:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:243:0x019b A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #5 {all -> 0x0168, blocks: (B:226:0x0148, B:228:0x0164, B:241:0x017f, B:243:0x019b), top: B:278:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:245:0x01a0  */
        /* JADX WARN: Removed duplicated region for block: B:255:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:274:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:276:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:279:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:281:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:285:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:289:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:294:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v19, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r3v26 */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v25 */
        /* JADX WARN: Type inference failed for: r5v26 */
        /* JADX WARN: Type inference failed for: r5v27 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.io.ByteArrayOutputStream] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.io.ByteArrayOutputStream] */
        /* JADX WARN: Type inference failed for: r5v6 */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 467
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.C15272.run():void");
        }
    }

    public LocationClient(Context context) {
        mContext = context.getApplicationContext();
        C1542e.m8851a().m8852b();
    }

    private void bdLocation2Location(Location location, BDLocation bDLocation, boolean z10) {
        String str = "";
        if (bDLocation != null && z10) {
            try {
                this.lastTime = System.currentTimeMillis();
                if (this.mLastLoc == null) {
                    this.mLastLoc = new Location("network");
                }
                this.mLastLoc.setProvider("network");
                this.mLastLoc.setAccuracy(bDLocation.getRadius());
                this.mLastLoc.setLatitude(bDLocation.getLatitude());
                this.mLastLoc.setLongitude(bDLocation.getLongitude());
                this.mLastLoc.setTime(System.currentTimeMillis());
                String networkLocationType = bDLocation.getNetworkLocationType();
                if (TextUtils.equals("wf", networkLocationType)) {
                    str = C6661f.f30885g;
                } else if (TextUtils.equals("cl", networkLocationType)) {
                    str = "cell";
                }
                if (!TextUtils.isEmpty(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("networkLocationType", str);
                    this.mLastLoc.setExtras(bundle);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        if (location != null) {
            location.setProvider("network");
            location.setAccuracy(bDLocation.getRadius());
            location.setLatitude(bDLocation.getLatitude());
            location.setLongitude(bDLocation.getLongitude());
            location.setTime(System.currentTimeMillis());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("networkLocationType", str);
            location.setExtras(bundle2);
        }
    }

    private boolean getLastLocation(Location location, boolean z10) {
        String str;
        if (location == null || this.mLastLoc == null) {
            return false;
        }
        if (z10) {
            C1534f.m8725c("准备取上一次基站定位结果");
            C1534f.m8725c("匹配前lastCell：" + this.lastCell);
            C1540c c1540c = this.firstLocRequest;
            if (c1540c == null || c1540c.m8823b() == null) {
                str = "cell没取到";
            } else {
                C1534f.m8725c("当前Cell：" + this.firstLocRequest.m8823b().m8776i());
                if (TextUtils.equals(this.lastCell, this.firstLocRequest.m8823b().m8776i())) {
                    C1534f.m8725c("准备取上一次wifi定位结果");
                    C1534f.m8725c("匹配前lastScanResult：" + this.lastScanResult.size());
                    C1540c c1540c2 = this.firstLocRequest;
                    if (c1540c2 == null || c1540c2.m8821a() == null) {
                        str = "wifi没取到";
                    } else {
                        C1534f.m8725c("当前ScanResult：" + this.firstLocRequest.m8821a().getScanResults().size());
                        if (!isSameRate(this.lastScanResult, this.firstLocRequest.m8821a().getScanResults(), 0.75f)) {
                            str = "wifi不相似";
                        }
                    }
                } else {
                    str = "cell不匹配";
                }
            }
            C1534f.m8725c(str);
            return false;
        }
        if (System.currentTimeMillis() - this.lastTime > PreConnectManager.CONNECT_SUCCESS_INTERNAL) {
            return false;
        }
        C1534f.m8725c("准备取上一次3分内定位结果");
        location.setProvider("network");
        location.setAccuracy(this.mLastLoc.getAccuracy());
        location.setLatitude(this.mLastLoc.getLatitude());
        location.setLongitude(this.mLastLoc.getLongitude());
        location.setTime(this.mLastLoc.getTime());
        location.setExtras(this.mLastLoc.getExtras());
        return true;
    }

    private boolean getSysLocation(Location location) {
        String str;
        if (location == null) {
            return false;
        }
        if (this.locationManager == null) {
            this.locationManager = (LocationManager) mContext.getSystemService(JsbMapKeyNames.H5_LOC);
        }
        Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
        if (lastKnownLocation == null || System.currentTimeMillis() - lastKnownLocation.getTime() > PreConnectManager.CONNECT_SUCCESS_INTERNAL) {
            lastKnownLocation = this.locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null || System.currentTimeMillis() - lastKnownLocation.getTime() > PreConnectManager.CONNECT_SUCCESS_INTERNAL) {
                return false;
            }
            str = "准备取系统passive定位结果";
        } else {
            str = "准备取系统GPS定位结果";
        }
        C1534f.m8725c(str);
        location2Location(location, lastKnownLocation);
        return true;
    }

    private static boolean isLocationCorrect(Location location) {
        if (location == null) {
            return false;
        }
        try {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            boolean zEquals = "gps".equals(location.getProvider());
            boolean zHasAccuracy = location.hasAccuracy();
            if ((Math.abs(longitude) >= 0.1d || Math.abs(latitude) >= 0.1d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d) {
                if (zEquals && zHasAccuracy && location.getAccuracy() < -1.0E-8f) {
                    return false;
                }
                if ((zEquals || !zHasAccuracy || location.getAccuracy() > 0.0f) && !Double.isNaN(latitude)) {
                    return !Double.isNaN(longitude);
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean isSameRate(List<ScanResult> list, List<ScanResult> list2, float f10) {
        String str;
        String str2;
        if (list != null && list2 != null) {
            if (list == list2) {
                str2 = "(tmpList == tmpListOld)";
            } else {
                int size = list.size();
                int size2 = list2.size();
                float f11 = size + size2;
                if (size == 0 && size2 == 0) {
                    str2 = "((newCnt == 0) && (oldCnt == 0))";
                } else if (size == 0 || size2 == 0) {
                    str = "((newCnt == 0) || (oldCnt == 0))";
                } else {
                    int i10 = 0;
                    for (int i11 = 0; i11 < size; i11++) {
                        String str3 = list.get(i11).BSSID;
                        if (str3 != null) {
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size2) {
                                    break;
                                }
                                if (str3.equals(list2.get(i12).BSSID)) {
                                    i10++;
                                    break;
                                }
                                i12++;
                            }
                        }
                    }
                    C1534f.m8725c(String.format(Locale.CHINA, "same %d,total %f,rate %f...", Integer.valueOf(i10), Float.valueOf(f11), Float.valueOf(f10)));
                    float f12 = i10 * 2;
                    if (f12 >= f10 * f11) {
                        str2 = "wifi相似返回了true：" + (f12 / f11);
                    } else {
                        str = "wifi相似返回了false";
                    }
                }
            }
            C1534f.m8725c(str2);
            return true;
        }
        str = "(tmpList == null) || (tmpListOld == null)";
        C1534f.m8725c(str);
        return false;
    }

    private void location2Location(Location location, Location location2) {
        if (location2 == null || location == null) {
            return;
        }
        try {
            location.setProvider("network");
            location.setAccuracy(location2.getAccuracy());
            location.setLatitude(location2.getLatitude());
            location.setLongitude(location2.getLongitude());
            location.setTime(location2.getTime());
            String str = "";
            if (location2.getAccuracy() <= 100.0f && location.getAccuracy() >= 0.0f) {
                str = C6661f.f30885g;
            } else if (location2.getAccuracy() > 100.0f) {
                str = "cell";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("networkLocationType", str);
            location.setExtras(bundle);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private BDLocation requestNLPNormal(String str, int i10) throws InterruptedException {
        BDLocation bDLocation = new BDLocation();
        this.tempLocation = bDLocation;
        bDLocation.setLocType(-2);
        C15261 c15261 = new Thread() { // from class: com.baidu.location.LocationClient.1

            /* renamed from: a */
            final /* synthetic */ String f6558a;

            public C15261(String str2) {
                str = str2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                /*
                    Method dump skipped, instructions count: 1717
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.C15261.run():void");
            }
        };
        c15261.start();
        try {
            c15261.join(30000L);
            if (TextUtils.isEmpty(this.resultEntity)) {
                this.tempLocation.setLocType(8);
            } else {
                BDLocation bDLocation2 = new BDLocation(this.resultEntity);
                this.tempLocation = bDLocation2;
                if (bDLocation2.getLocType() == 161) {
                    C1534f.m8725c("" + this.resultEntity);
                    return this.tempLocation;
                }
            }
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
            this.tempLocation.setLocType(9);
        }
        return this.tempLocation;
    }

    private boolean startOfflineLocation(Location location) {
        if (this.first) {
            C1543f.m8855a(mContext).m8873a();
            this.first = false;
        }
        if (this.firstLocRequest == null) {
            this.firstLocRequest = C1540c.m8807a(mContext);
        }
        BDLocation bDLocationM8870a = C1543f.m8855a(mContext).m8870a(this.firstLocRequest);
        C1534f.m8725c("离线定位准备");
        if (bDLocationM8870a == null || !(bDLocationM8870a.getLocType() == 161 || bDLocationM8870a.getLocType() == 66)) {
            C1534f.m8725c("离线定位失败");
            return false;
        }
        C1534f.m8725c("开始离线定位：" + bDLocationM8870a.getLocType());
        C1534f.m8725c("离线定位返回结果");
        bdLocation2Location(location, bDLocationM8870a, false);
        return true;
    }

    private void upload(String str) {
        new Thread() { // from class: com.baidu.location.LocationClient.2

            /* renamed from: a */
            final /* synthetic */ String f6560a;

            public C15272(String str2) {
                str = str2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                /*
                    Method dump skipped, instructions count: 467
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.C15272.run():void");
            }
        }.start();
    }

    public void destroy() {
        C1542e.m8851a().m8853c();
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int requestLocation(android.location.Location r8, int r9) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.requestLocation(android.location.Location, int):int");
    }

    public void setUuid(String str) {
        C1534f.f6675u = str;
    }

    public double[] wgs842bd09(double d10, double d11) {
        C1521e c1521e = new C1521e(d10, d11);
        C1521e c1521eM8648a = C1523g.m8648a(c1521e.m8642a(), c1521e.m8644b());
        if (c1521eM8648a == null) {
            return null;
        }
        C1521e c1521eM8651c = C1523g.m8651c(c1521eM8648a.m8642a(), c1521eM8648a.m8644b());
        return new double[]{c1521eM8651c.m8642a(), c1521eM8651c.m8644b()};
    }
}
