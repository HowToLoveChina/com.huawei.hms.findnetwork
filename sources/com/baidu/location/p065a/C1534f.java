package com.baidu.location.p065a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.geocoder.p064a.C1521e;
import com.baidu.location.LocationClient;
import com.baidu.location.provider.C1538a;
import com.baidu.location.provider.C1539b;
import com.baidu.location.provider.C1541d;
import com.baidu.location.provider.C1544g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

/* renamed from: com.baidu.location.a.f */
/* loaded from: classes.dex */
public class C1534f {

    /* renamed from: A */
    public static float f6642A = 0.75f;

    /* renamed from: B */
    public static float f6643B = 0.0f;

    /* renamed from: C */
    public static float f6644C = 0.1f;

    /* renamed from: D */
    public static int f6645D = 30;

    /* renamed from: E */
    public static int f6646E = 100;

    /* renamed from: F */
    public static float f6647F = 6.0f;

    /* renamed from: G */
    public static float f6648G = 10.0f;

    /* renamed from: H */
    public static int f6649H = 60;

    /* renamed from: I */
    public static int f6650I = 70;

    /* renamed from: J */
    public static int f6651J = 6;

    /* renamed from: K */
    public static double f6652K = 3.141592653589793d;

    /* renamed from: L */
    private static String f6653L = "huaweinlp";

    /* renamed from: M */
    private static SimpleDateFormat f6654M = new SimpleDateFormat("HH:mm");

    /* renamed from: a */
    public static boolean f6655a = false;

    /* renamed from: b */
    public static final String f6656b = "huawei";

    /* renamed from: c */
    public static final String f6657c = "nl.nl1103";

    /* renamed from: d */
    public static final String f6658d = "akDSfxLye7Plv8dYTiHIUYguSRcyjGEs";

    /* renamed from: e */
    public static final String f6659e = "n817";

    /* renamed from: f */
    public static final String f6660f = "SDKHW5.5.10:buildn817:";

    /* renamed from: g */
    public static final String f6661g = "https://loc.map.baidu.com/sdk.php";

    /* renamed from: h */
    public static final String f6662h = "https://newclient.map.baidu.com/client/infopass/infopass/mecp";

    /* renamed from: i */
    public static int f6663i = 600000;

    /* renamed from: j */
    public static final String f6664j = "https://api.map.baidu.com/geocoder/v2/";

    /* renamed from: k */
    public static final String f6665k = "NOSK";

    /* renamed from: l */
    public static final String f6666l = "5.5";

    /* renamed from: m */
    public static final String f6667m = "nl.nl1103.v5.5.n817";

    /* renamed from: n */
    public static String f6668n = "no";

    /* renamed from: o */
    public static boolean f6669o = false;

    /* renamed from: p */
    public static boolean f6670p = false;

    /* renamed from: q */
    public static boolean f6671q = false;

    /* renamed from: r */
    public static int f6672r = 3;

    /* renamed from: s */
    public static String f6673s = "huaweinlp";

    /* renamed from: t */
    public static int f6674t = 12000;

    /* renamed from: u */
    public static String f6675u = "";

    /* renamed from: v */
    public static float f6676v = 2.0f;

    /* renamed from: w */
    public static float f6677w = 10.0f;

    /* renamed from: x */
    public static float f6678x = 50.0f;

    /* renamed from: y */
    public static float f6679y = 200.0f;

    /* renamed from: z */
    public static int f6680z = 16;

    /* renamed from: a */
    public static C1521e m8711a(double d10, double d11) {
        double d12 = d11 - 0.0065d;
        double d13 = d10 - 0.006d;
        double dSqrt = Math.sqrt((d12 * d12) + (d13 * d13)) - (Math.sin(f6652K * d13) * 2.0E-5d);
        double dAtan2 = Math.atan2(d13, d12) - (Math.cos(d12 * f6652K) * 3.0E-6d);
        return new C1521e(dSqrt * Math.sin(dAtan2), Math.cos(dAtan2) * dSqrt);
    }

    /* renamed from: b */
    public static String m8721b() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                String path = Environment.getExternalStorageDirectory().getPath();
                File file = new File(path + "/baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return path;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m8724c() {
        String strM8721b = m8721b();
        if (strM8721b == null) {
            return null;
        }
        return strM8721b + "/baidu/tempdata";
    }

    /* renamed from: d */
    public static String m8726d() {
        return Build.MODEL;
    }

    /* renamed from: e */
    public static String m8727e() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    /* renamed from: f */
    public static String m8728f() {
        return "Android" + Build.VERSION.SDK;
    }

    /* renamed from: g */
    public static String m8729g() {
        Context context = LocationClient.mContext;
        if (context == null) {
            return "3.1";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "3.1";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(1:4)(2:6|(1:8)(10:9|(1:11)(1:13)|12|14|27|15|25|16|23|24))|5|14|27|15|25|16|23|24|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0081, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
    
        r0.printStackTrace();
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m8730h() throws java.text.ParseException {
        /*
            double r0 = java.lang.Math.random()
            r2 = 4633500329122463744(0x404d800000000000, double:59.0)
            double r0 = r0 * r2
            int r0 = (int) r0
            double r1 = java.lang.Math.random()
            r3 = 4618441417868443648(0x4018000000000000, double:6.0)
            double r1 = r1 * r3
            int r1 = (int) r1
            java.lang.String r2 = "0"
            if (r0 > 0) goto L2c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = ":05"
        L24:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L68
        L2c:
            r3 = 59
            if (r0 <= r3) goto L3e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = ":59"
            goto L24
        L3e:
            r3 = 10
            if (r0 < r3) goto L5a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
        L4f:
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            goto L68
        L5a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = ":0"
            goto L4f
        L68:
            r1 = 0
            java.text.SimpleDateFormat r2 = com.baidu.location.p065a.C1534f.f6654M     // Catch: java.lang.Exception -> L81
            java.util.Date r3 = new java.util.Date     // Catch: java.lang.Exception -> L81
            r3.<init>()     // Catch: java.lang.Exception -> L81
            java.lang.String r3 = r2.format(r3)     // Catch: java.lang.Exception -> L81
            java.util.Date r2 = r2.parse(r3)     // Catch: java.lang.Exception -> L81
            java.text.SimpleDateFormat r3 = com.baidu.location.p065a.C1534f.f6654M     // Catch: java.lang.Exception -> L7f
            java.util.Date r1 = r3.parse(r0)     // Catch: java.lang.Exception -> L7f
            goto L86
        L7f:
            r0 = move-exception
            goto L83
        L81:
            r0 = move-exception
            r2 = r1
        L83:
            r0.printStackTrace()
        L86:
            boolean r0 = m8720a(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p065a.C1534f.m8730h():boolean");
    }

    /* renamed from: i */
    public static String m8731i() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet6Address)) {
                        if (f6655a) {
                            Log.i(f6653L, "ipv6 util = " + inetAddressNextElement.getHostAddress());
                        }
                        if (inetAddressNextElement.getHostAddress() != null && !inetAddressNextElement.getHostAddress().startsWith("fe80:")) {
                            return inetAddressNextElement.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException unused) {
            return "";
        } catch (Throwable th2) {
            if (f6655a) {
                th2.printStackTrace();
            }
            return "";
        }
    }

    /* renamed from: a */
    public static String m8712a() {
        Calendar calendar = Calendar.getInstance();
        int i10 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i10), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    /* renamed from: b */
    public static void m8722b(String str) {
        Toast.makeText(LocationClient.mContext, str, 0).show();
    }

    /* renamed from: c */
    public static void m8725c(String str) {
        if (f6655a) {
            Log.d(f6653L, "" + str);
        }
    }

    /* renamed from: d */
    public String m8732d(String str) throws Throwable {
        String str2;
        File file = new File(str);
        BufferedReader bufferedReader = null;
        String str3 = null;
        bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        str3 = str3 + line;
                    } catch (IOException e10) {
                        e = e10;
                        str2 = str3;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException unused3) {
                }
                return str3;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e11) {
            e = e11;
            str2 = null;
        }
    }

    /* renamed from: a */
    public static String m8713a(C1538a c1538a, C1544g c1544g, Location location, String str) {
        String strM8793a;
        String strM8838a;
        String strM8880a;
        String strM8795b;
        StringBuffer stringBuffer = new StringBuffer();
        if (c1538a != null && (strM8795b = C1539b.m8784a().m8795b(c1538a)) != null) {
            stringBuffer.append(strM8795b);
        }
        if (c1544g != null) {
            try {
                strM8880a = c1544g.m8880a(5);
            } catch (Exception unused) {
                strM8880a = null;
            }
            if (strM8880a != null) {
                stringBuffer.append(strM8880a);
            }
        }
        if (location != null && (strM8838a = C1541d.m8838a(location)) != null) {
            stringBuffer.append(strM8838a);
        }
        String strM8715a = m8715a(false);
        if (strM8715a != null) {
            stringBuffer.append(strM8715a);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        if (c1538a != null && (strM8793a = C1539b.m8784a().m8793a(c1538a)) != null && strM8793a.length() + stringBuffer.length() < 750) {
            stringBuffer.append(strM8793a);
        }
        String string = stringBuffer.toString();
        if (f6655a) {
            Log.d(f6673s, "util format : " + string);
        }
        return string;
    }

    /* renamed from: b */
    public static void m8723b(boolean z10) {
        f6655a = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf A[Catch: Exception -> 0x00bb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bb, blocks: (B:41:0x009c, B:43:0x00b2, B:46:0x00b8, B:49:0x00bd, B:51:0x00c3, B:53:0x00c7, B:55:0x00cb, B:56:0x00cf), top: B:63:0x009c }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m8714a(com.baidu.location.provider.C1538a r3, com.baidu.location.provider.C1544g r4, android.location.Location r5, java.lang.String r6, int r7) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r1 = 1024(0x400, float:1.435E-42)
            r0.<init>(r1)
            if (r3 == 0) goto L16
            com.baidu.location.provider.b r1 = com.baidu.location.provider.C1539b.m8784a()
            java.lang.String r1 = r1.m8795b(r3)
            if (r1 == 0) goto L16
            r0.append(r1)
        L16:
            if (r4 == 0) goto L28
            if (r7 != 0) goto L1f
            java.lang.String r1 = r4.m8885c()
            goto L23
        L1f:
            java.lang.String r1 = r4.m8889e()
        L23:
            if (r1 == 0) goto L28
            r0.append(r1)
        L28:
            if (r5 == 0) goto L33
            java.lang.String r1 = com.baidu.location.provider.C1541d.m8838a(r5)
            if (r1 == 0) goto L33
            r0.append(r1)
        L33:
            r1 = 1
            if (r7 != 0) goto L38
            r7 = r1
            goto L39
        L38:
            r7 = 0
        L39:
            java.lang.String r7 = m8715a(r7)
            if (r7 == 0) goto L42
            r0.append(r7)
        L42:
            if (r6 == 0) goto L47
            r0.append(r6)
        L47:
            com.baidu.location.provider.Battery r6 = com.baidu.location.provider.Battery.m8741a()
            java.lang.String r6 = r6.m8746c()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L5d
            java.lang.String r7 = "&bc="
            r0.append(r7)
            r0.append(r6)
        L5d:
            if (r3 == 0) goto L79
            com.baidu.location.provider.b r6 = com.baidu.location.provider.C1539b.m8784a()
            java.lang.String r3 = r6.m8793a(r3)
            if (r3 == 0) goto L79
            int r6 = r3.length()
            int r7 = r0.length()
            int r6 = r6 + r7
            r7 = 750(0x2ee, float:1.051E-42)
            if (r6 >= r7) goto L79
            r0.append(r3)
        L79:
            java.lang.String r3 = r0.toString()
            boolean r6 = com.baidu.location.p065a.C1534f.f6655a
            if (r6 == 0) goto L97
            java.lang.String r6 = com.baidu.location.p065a.C1534f.f6673s
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "util format : "
            r7.append(r0)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r6, r7)
        L97:
            r6 = 3
            if (r5 == 0) goto Lcf
            if (r4 == 0) goto Lcf
            float r5 = r5.getSpeed()     // Catch: java.lang.Exception -> Lbb
            int r7 = r4.m8890f()     // Catch: java.lang.Exception -> Lbb
            int r0 = r4.m8882b()     // Catch: java.lang.Exception -> Lbb
            boolean r4 = r4.m8891g()     // Catch: java.lang.Exception -> Lbb
            float r2 = com.baidu.location.p065a.C1534f.f6647F     // Catch: java.lang.Exception -> Lbb
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 >= 0) goto Lbd
            int r2 = com.baidu.location.p065a.C1534f.f6649H     // Catch: java.lang.Exception -> Lbb
            if (r7 < r2) goto Lb8
            if (r4 == 0) goto Lbd
        Lb8:
            com.baidu.location.p065a.C1534f.f6672r = r1     // Catch: java.lang.Exception -> Lbb
            goto Ldb
        Lbb:
            r4 = move-exception
            goto Ld2
        Lbd:
            float r4 = com.baidu.location.p065a.C1534f.f6648G     // Catch: java.lang.Exception -> Lbb
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 >= 0) goto Lcf
            int r4 = com.baidu.location.p065a.C1534f.f6650I     // Catch: java.lang.Exception -> Lbb
            if (r7 < r4) goto Lcb
            int r4 = com.baidu.location.p065a.C1534f.f6651J     // Catch: java.lang.Exception -> Lbb
            if (r0 <= r4) goto Lcf
        Lcb:
            r4 = 2
            com.baidu.location.p065a.C1534f.f6672r = r4     // Catch: java.lang.Exception -> Lbb
            goto Ldb
        Lcf:
            com.baidu.location.p065a.C1534f.f6672r = r6     // Catch: java.lang.Exception -> Lbb
            goto Ldb
        Ld2:
            boolean r5 = com.baidu.location.p065a.C1534f.f6655a
            if (r5 == 0) goto Ld9
            r4.printStackTrace()
        Ld9:
            com.baidu.location.p065a.C1534f.f6672r = r6
        Ldb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p065a.C1534f.m8714a(com.baidu.location.provider.a, com.baidu.location.provider.g, android.location.Location, java.lang.String, int):java.lang.String");
    }

    /* renamed from: a */
    public static String m8715a(boolean z10) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append("5.5");
        if (z10) {
            if (f6668n.equals("all")) {
                stringBuffer.append("&addr=all");
            }
            if (f6669o || f6670p || f6671q) {
                stringBuffer.append("&sema=");
                if (f6669o) {
                    stringBuffer.append("aptag|");
                }
                if (f6670p) {
                    stringBuffer.append("poiregion|");
                }
                if (f6671q) {
                    stringBuffer.append("regular");
                }
            }
        }
        if (z10) {
            stringBuffer.append("&coor=wgs84");
        }
        stringBuffer.append("&im=");
        stringBuffer.append((String) null);
        stringBuffer.append("&fw=");
        stringBuffer.append("5.5");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("11");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        if (z10) {
            stringBuffer.append("&sv=");
            String strSubstring = Build.VERSION.RELEASE;
            if (strSubstring != null && strSubstring.length() > 6) {
                strSubstring = strSubstring.substring(0, 6);
            }
            stringBuffer.append(strSubstring);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static void m8716a(float f10) {
        if (f6655a) {
            Log.d(f6653L, "" + f10);
        }
    }

    /* renamed from: a */
    public static void m8717a(int i10) {
        if (f6655a) {
            Log.d(f6653L, "" + i10);
        }
    }

    /* renamed from: a */
    public static void m8718a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f6653L = str;
    }

    /* renamed from: a */
    public static boolean m8719a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m8720a(Date date, Date date2) {
        if (date == null || date2 == null) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.after(calendar2);
    }
}
