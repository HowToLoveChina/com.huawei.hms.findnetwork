package gw;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import p348hw.C10346a;
import p348hw.C10355j;

/* renamed from: gw.a */
/* loaded from: classes9.dex */
public class C10055a {

    /* renamed from: c */
    public static final String f49025c = Build.MANUFACTURER;

    /* renamed from: d */
    public static final String f49026d = Build.MODEL;

    /* renamed from: e */
    public static final String f49027e = Build.PRODUCT;

    /* renamed from: f */
    public static final String f49028f = Build.DISPLAY;

    /* renamed from: g */
    public static final String f49029g = Build.VERSION.INCREMENTAL;

    /* renamed from: h */
    public static final String f49030h;

    /* renamed from: i */
    public static final String f49031i;

    /* renamed from: j */
    public static final String f49032j;

    /* renamed from: k */
    public static final String f49033k;

    /* renamed from: l */
    public static volatile C10055a f49034l;

    /* renamed from: a */
    public String f49035a;

    /* renamed from: b */
    public String f49036b;

    /* renamed from: gw.a$a */
    public static class a {

        /* renamed from: a */
        public boolean f49037a;

        /* renamed from: b */
        public int f49038b;

        /* renamed from: c */
        public int f49039c;

        /* renamed from: d */
        public int f49040d;

        /* renamed from: e */
        public C10056b f49041e;

        public a(boolean z10, int i10, int i11, C10056b c10056b) {
            this.f49037a = z10;
            this.f49038b = i10;
            this.f49039c = i11;
            this.f49041e = c10056b;
        }

        /* renamed from: a */
        public int m62505a() {
            return this.f49040d;
        }

        /* renamed from: b */
        public int m62506b() {
            return this.f49039c;
        }

        /* renamed from: c */
        public int m62507c() {
            return this.f49038b;
        }

        /* renamed from: d */
        public C10056b m62508d() {
            return this.f49041e;
        }

        /* renamed from: e */
        public boolean m62509e() {
            return this.f49037a;
        }

        /* renamed from: f */
        public void m62510f(int i10) {
            this.f49040d = i10;
        }

        /* renamed from: g */
        public void m62511g(boolean z10) {
            this.f49037a = z10;
        }

        /* renamed from: h */
        public void m62512h(int i10) {
            this.f49039c = i10;
        }

        /* renamed from: i */
        public void m62513i(int i10) {
            this.f49038b = i10;
        }

        /* renamed from: j */
        public void m62514j(C10056b c10056b) {
            this.f49041e = c10056b;
        }

        public String toString() {
            return "isContain:" + this.f49037a + "\nosIDp = " + this.f49038b + "\nosIDn = " + this.f49039c;
        }
    }

    /* renamed from: gw.a$b */
    public static class b {

        /* renamed from: a */
        public boolean f49042a;

        /* renamed from: b */
        public C10057c f49043b;

        public b(boolean z10, C10057c c10057c) {
            this.f49042a = z10;
            this.f49043b = c10057c;
        }

        /* renamed from: a */
        public C10057c m62515a() {
            return this.f49043b;
        }

        /* renamed from: b */
        public boolean m62516b() {
            return this.f49042a;
        }

        /* renamed from: c */
        public void m62517c(boolean z10) {
            this.f49042a = z10;
        }

        /* renamed from: d */
        public void m62518d(C10057c c10057c) {
            this.f49043b = c10057c;
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ultrasound");
        String str = File.separator;
        sb2.append(str);
        sb2.append("ultrasound-CoreConfig.csv");
        f49030h = sb2.toString();
        f49031i = "ultrasound" + str + "ultrasound-TDConfig.csv";
        f49032j = "ultrasound" + str + "ultrasound-PCConfig.csv";
        f49033k = "ultrasound" + str + "ultrasound-NCConfig.csv";
    }

    /* renamed from: i */
    public static C10055a m62496i() {
        if (f49034l == null) {
            synchronized (C10055a.class) {
                try {
                    if (f49034l == null) {
                        f49034l = new C10055a();
                    }
                } finally {
                }
            }
        }
        return f49034l;
    }

    /* renamed from: a */
    public a m62497a(Context context) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String line;
        a aVar = new a(false, 0, 0, null);
        String str = f49027e;
        if (str == null) {
            C10355j.m63763a("UltrasoundCSVHandler", "current phone model is null.");
            return aVar;
        }
        if (context == null) {
            C10355j.m63763a("UltrasoundCSVHandler", "context is null.");
            return aVar;
        }
        Locale locale = new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE, "US");
        try {
            inputStreamReader = new InputStreamReader(context.getAssets().open(f49030h), StandardCharsets.UTF_8);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    bufferedReader.readLine();
                    line = bufferedReader.readLine();
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException | NumberFormatException e10) {
            C10355j.m63763a("UltrasoundCSVHandler", "checkCSVContainResult error occurs, error message: " + e10.getMessage());
        }
        if (line == null) {
            C10355j.m63763a("UltrasoundCSVHandler", "unable to get version info of this preset file.");
            bufferedReader.close();
            inputStreamReader.close();
            return aVar;
        }
        String[] strArrSplit = line.split(",");
        if (strArrSplit.length != 2) {
            C10355j.m63763a("UltrasoundCSVHandler", "info of version line is incorrect.");
            bufferedReader.close();
            inputStreamReader.close();
            return aVar;
        }
        String str2 = strArrSplit[1];
        String line2 = bufferedReader.readLine();
        new ArrayMap();
        StringBuilder sb2 = new StringBuilder();
        String str3 = f49025c;
        sb2.append(str3);
        String str4 = f49026d;
        sb2.append(str4);
        String string = sb2.toString();
        String str5 = str3 + str;
        C10355j.m63764b("UltrasoundCSVHandler", "currentModel: " + str4);
        C10355j.m63764b("UltrasoundCSVHandler", "currentProduct: " + str);
        while (line2 != null) {
            String[] strArrSplit2 = line2.split(",");
            if (strArrSplit2.length == 20) {
                String str6 = strArrSplit2[0] + strArrSplit2[1];
                boolean zEquals = string.toUpperCase(locale).equals(str6.toUpperCase(locale));
                boolean zEquals2 = str5.toUpperCase(locale).equals(str6.toUpperCase(locale));
                if (!zEquals && !zEquals2) {
                    line2 = bufferedReader.readLine();
                }
                this.f49035a = zEquals ? f49026d : f49027e;
                C10355j.m63764b("UltrasoundCSVHandler", "find OEM and Model in CoreCSV file with current phone Model.");
                aVar.m62511g(true);
                aVar.m62513i(Integer.parseInt(strArrSplit2[17]));
                aVar.m62512h(Integer.parseInt(strArrSplit2[18]));
                aVar.m62510f(Integer.parseInt(strArrSplit2[19]));
                bufferedReader.close();
                inputStreamReader.close();
                return aVar;
            }
            line2 = bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStreamReader.close();
        return aVar;
    }

    /* renamed from: b */
    public b m62498b(Context context, String str, int i10) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String line;
        b bVar = new b(false, null);
        Locale locale = new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE, "US");
        C10355j.m63764b("UltrasoundCSVHandler", "Current Phone is: " + f49027e);
        try {
            inputStreamReader = new InputStreamReader(context.getAssets().open(f49031i), StandardCharsets.UTF_8);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    bufferedReader.readLine();
                    line = bufferedReader.readLine();
                } finally {
                }
            } finally {
            }
        } catch (IOException | NumberFormatException e10) {
            C10355j.m63763a("UltrasoundCSVHandler", "checkIsDevicesMatch error occurs, error message: " + e10.getMessage());
        }
        if (line == null) {
            C10355j.m63763a("UltrasoundCSVHandler", "unable to get version info of this ultrasound-TDConfig file.");
            bufferedReader.close();
            inputStreamReader.close();
            return bVar;
        }
        if (line.split(",").length != 2) {
            C10355j.m63763a("UltrasoundCSVHandler", "TDConfig file info of version line is incorrect.");
            bufferedReader.close();
            inputStreamReader.close();
            return bVar;
        }
        String line2 = bufferedReader.readLine();
        String str2 = str + "-" + i10;
        while (true) {
            if (line2 == null) {
                break;
            }
            String[] strArrSplit = line2.split(",");
            if (strArrSplit.length == 4) {
                String str3 = strArrSplit[0];
                String str4 = strArrSplit[1];
                if (this.f49035a.toUpperCase(locale).equals(str3.toUpperCase(locale)) && str2.equals(str4)) {
                    C10057c c10057c = new C10057c(str3, str4, strArrSplit[2], Double.parseDouble(strArrSplit[3]));
                    bVar.m62517c(true);
                    bVar.m62518d(c10057c);
                    C10355j.m63764b("UltrasoundCSVHandler", "find target device property in TD-CSV file with current phone model.");
                    break;
                }
                line2 = bufferedReader.readLine();
            } else {
                line2 = bufferedReader.readLine();
            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        return bVar;
    }

    /* renamed from: c */
    public boolean m62499c(String str, String str2, String str3) throws NumberFormatException {
        boolean z10;
        boolean z11;
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        String[] strArrSplit3 = str3.split("\\.");
        if (str.equals(str2) || str.equals(str3)) {
            return false;
        }
        if (str2.equals("XXX") && str3.equals("XXX")) {
            return true;
        }
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = Integer.parseInt(strArrSplit[i10]);
            int i12 = Integer.parseInt(strArrSplit2[i10]);
            if (i11 < i12) {
                z10 = false;
                break;
            }
            if (i11 > i12) {
                break;
            }
        }
        z10 = true;
        int iMin2 = Math.min(strArrSplit.length, strArrSplit3.length);
        for (int i13 = 0; i13 < iMin2; i13++) {
            int i14 = Integer.parseInt(strArrSplit[i13]);
            int i15 = Integer.parseInt(strArrSplit3[i13]);
            if (i14 < i15) {
                break;
            }
            if (i14 > i15) {
                z11 = false;
                break;
            }
        }
        z11 = true;
        return (z10 && z11) ? false : true;
    }

    /* renamed from: d */
    public boolean m62500d(String str, String str2) throws NumberFormatException {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = Integer.parseInt(strArrSplit[i10]);
            int i12 = Integer.parseInt(strArrSplit2[i10]);
            if (i11 > i12) {
                break;
            }
            if (i11 < i12) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public boolean m62501e(Context context, int i10) throws IOException {
        InputStreamReader inputStreamReader;
        if (i10 == 0) {
            return true;
        }
        boolean zM62499c = false;
        if (i10 == -1) {
            C10355j.m63763a("UltrasoundCSVHandler", "mOSIDn is default value -1.");
            return false;
        }
        try {
            inputStreamReader = new InputStreamReader(context.getAssets().open(f49033k), StandardCharsets.UTF_8);
        } catch (IOException | NumberFormatException e10) {
            C10355j.m63763a("UltrasoundCSVHandler", "checkOSnVer error occurs, error message: " + e10.getMessage());
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                bufferedReader.readLine();
                String line = bufferedReader.readLine();
                if (line == null) {
                    C10355j.m63763a("UltrasoundCSVHandler", "unable to get version info of this ultrasound-NCConfig file.");
                    bufferedReader.close();
                    inputStreamReader.close();
                    return false;
                }
                if (line.split(",").length != 2) {
                    C10355j.m63763a("UltrasoundCSVHandler", "NCConfig file info of version line is incorrect.");
                    bufferedReader.close();
                    inputStreamReader.close();
                    return false;
                }
                String line2 = bufferedReader.readLine();
                while (true) {
                    if (line2 == null) {
                        break;
                    }
                    String[] strArrSplit = line2.split(",");
                    if (strArrSplit.length != 3) {
                        line2 = bufferedReader.readLine();
                    } else {
                        String str = strArrSplit[0];
                        String str2 = strArrSplit[1];
                        String str3 = strArrSplit[2];
                        if (i10 == Integer.parseInt(str)) {
                            zM62499c = m62499c(this.f49036b, str2, str3);
                            C10355j.m63764b("UltrasoundCSVHandler", "find and check target device OS Ver in NC-CSV file with current phone model and check result:" + zM62499c);
                            break;
                        }
                        line2 = bufferedReader.readLine();
                    }
                }
                bufferedReader.close();
                inputStreamReader.close();
                return zM62499c;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                inputStreamReader.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x015e  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m62502f(android.content.Context r17, int r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gw.C10055a.m62502f(android.content.Context, int):boolean");
    }

    /* renamed from: g */
    public boolean m62503g(String str) {
        return str.equals("ELE-AL00") || str.equals("ELE-TL00") || str.equals("VOG-AL00") || str.equals("VOG-AL10") || str.equals("VOG-TL00");
    }

    /* renamed from: h */
    public a m62504h(Context context, int i10) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String line;
        String str;
        String str2;
        String str3;
        String str4;
        a aVar = new a(false, 0, 0, null);
        if (f49027e == null) {
            C10355j.m63763a("UltrasoundCSVHandler", "current phone model is null.");
            return aVar;
        }
        if (context == null) {
            C10355j.m63763a("UltrasoundCSVHandler", "context is null.");
            return aVar;
        }
        new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE, "US");
        try {
            inputStreamReader = new InputStreamReader(context.getAssets().open(f49030h), StandardCharsets.UTF_8);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    bufferedReader.readLine();
                    line = bufferedReader.readLine();
                } finally {
                }
            } finally {
            }
        } catch (IOException | NumberFormatException e10) {
            C10355j.m63763a("UltrasoundCSVHandler", "getCoreCSVData error occurs, error message: " + e10.getMessage());
        }
        if (line == null) {
            C10355j.m63763a("UltrasoundCSVHandler", "unable to get version info of this preset file.");
            bufferedReader.close();
            inputStreamReader.close();
            return aVar;
        }
        String[] strArrSplit = line.split(",");
        if (strArrSplit.length != 2) {
            C10355j.m63763a("UltrasoundCSVHandler", "info of version line is incorrect.");
            bufferedReader.close();
            inputStreamReader.close();
            return aVar;
        }
        String str5 = strArrSplit[1];
        String line2 = bufferedReader.readLine();
        ArrayMap arrayMap = new ArrayMap();
        String str6 = "";
        String str7 = "";
        while (true) {
            if (line2 == null) {
                str = "0";
                str2 = "";
                str3 = str7;
                str4 = "false";
                break;
            }
            String[] strArrSplit2 = line2.split(",");
            if (strArrSplit2.length != 20) {
                line2 = bufferedReader.readLine();
            } else {
                str7 = strArrSplit2[3];
                if (this.f49035a.equals(strArrSplit2[1]) && i10 == Integer.parseInt(str7)) {
                    ArrayList arrayList = new ArrayList();
                    int i11 = 0;
                    String str8 = strArrSplit2[0];
                    String str9 = strArrSplit2[1];
                    String str10 = strArrSplit2[2];
                    str = strArrSplit2[4];
                    for (int i12 = 4; i11 < i12; i12 = 4) {
                        C10346a c10346a = new C10346a();
                        int i13 = i11 * 3;
                        c10346a.m63711e(strArrSplit2[i13 + 5]);
                        c10346a.m63712f(strArrSplit2[i13 + 6]);
                        c10346a.m63710d(strArrSplit2[i13 + 7]);
                        arrayList.add(i11, c10346a);
                        i11++;
                    }
                    arrayMap.put(Integer.valueOf(Integer.parseInt(strArrSplit2[3])), arrayList);
                    C10355j.m63764b("UltrasoundCSVHandler", "get target ultrasound property in CoreCSV file with current phone model. currentPhone is " + this.f49035a + "coordinates size is:" + arrayList.size());
                    aVar.m62511g(true);
                    aVar.m62513i(Integer.parseInt(strArrSplit2[17]));
                    aVar.m62512h(Integer.parseInt(strArrSplit2[18]));
                    aVar.m62510f(Integer.parseInt(strArrSplit2[19]));
                    str6 = str9;
                    str3 = str7;
                    str4 = str10;
                    str2 = str8;
                }
                line2 = bufferedReader.readLine();
            }
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str6) && !arrayMap.isEmpty()) {
            aVar.m62514j(new C10056b(str5, str2, str6, str4, str3, str, -1, -1, arrayMap));
        }
        bufferedReader.close();
        inputStreamReader.close();
        return aVar;
    }
}
