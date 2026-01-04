package gw;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* renamed from: gw.c */
/* loaded from: classes9.dex */
public class C10057c {

    /* renamed from: a */
    public String f49053a;

    /* renamed from: b */
    public String f49054b;

    /* renamed from: c */
    public String f49055c;

    /* renamed from: d */
    public transient Map<Integer, Double> f49056d;

    /* renamed from: e */
    public double f49057e;

    public C10057c(String str, String str2, String str3, double d10) {
        this.f49053a = str;
        this.f49054b = str2;
        this.f49055c = str3;
        this.f49057e = d10;
    }

    /* renamed from: a */
    public double m62522a() {
        return this.f49057e;
    }

    /* renamed from: b */
    public Map<Integer, Double> m62523b() {
        m62525d();
        return this.f49056d;
    }

    /* renamed from: c */
    public String m62524c() {
        return this.f49054b;
    }

    /* renamed from: d */
    public final void m62525d() {
        if (this.f49056d != null) {
            return;
        }
        this.f49056d = new HashMap();
        if (!this.f49055c.contains(":")) {
            Log.i("UltrasoundTDCSV", "CSV file is old version: " + this.f49055c);
            for (int i10 = 2; i10 < 13; i10++) {
                this.f49056d.put(Integer.valueOf(i10), Double.valueOf(Double.parseDouble(this.f49055c)));
            }
            return;
        }
        for (String str : this.f49055c.split(";")) {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length >= 2) {
                this.f49056d.put(Integer.valueOf(Integer.parseInt(strArrSplit[0])), Double.valueOf(Double.parseDouble(strArrSplit[1])));
            }
        }
    }
}
