package com.baidu.geocoder.p064a;

import java.util.ArrayList;

/* renamed from: com.baidu.geocoder.a.f */
/* loaded from: classes.dex */
public class C1522f {

    /* renamed from: o */
    private static final String f6527o = "PoiDetail";

    /* renamed from: a */
    public String f6528a = "";

    /* renamed from: b */
    public String f6529b = "";

    /* renamed from: c */
    public String f6530c = "";

    /* renamed from: d */
    public double f6531d = 0.0d;

    /* renamed from: e */
    public double f6532e = 0.0d;

    /* renamed from: f */
    public String f6533f = "";

    /* renamed from: g */
    public String f6534g = "";

    /* renamed from: h */
    public String f6535h = "";

    /* renamed from: i */
    public String f6536i = "";

    /* renamed from: j */
    public String f6537j = "";

    /* renamed from: k */
    public String f6538k = "";

    /* renamed from: l */
    public String f6539l = "";

    /* renamed from: m */
    public String f6540m = "";

    /* renamed from: n */
    public ArrayList<C1524h> f6541n = new ArrayList<>();

    /* renamed from: a */
    public void m8646a() {
        this.f6528a = "";
        this.f6529b = "";
        this.f6530c = "";
        this.f6531d = 0.0d;
        this.f6532e = 0.0d;
        this.f6533f = "";
        this.f6534g = "";
        this.f6535h = "";
        this.f6536i = "";
        this.f6537j = "";
        this.f6538k = "";
        this.f6539l = "";
        this.f6540m = "";
        this.f6541n.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[Catch: JSONException -> 0x00a2, TryCatch #0 {JSONException -> 0x00a2, blocks: (B:23:0x0094, B:25:0x009c, B:29:0x00a5, B:31:0x00ab, B:32:0x00b1, B:34:0x00b7, B:35:0x00bd, B:37:0x00c3, B:39:0x00c9, B:41:0x00cf, B:42:0x00d5, B:44:0x00db, B:45:0x00e1, B:47:0x00e7, B:48:0x00ed, B:50:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0105, B:56:0x010b, B:57:0x0111, B:59:0x0117, B:60:0x011e, B:61:0x0123, B:63:0x0127, B:70:0x0139, B:72:0x0141, B:75:0x016a, B:76:0x0182, B:78:0x018a, B:79:0x01a2, B:81:0x01a8, B:82:0x01ae, B:84:0x01b6, B:86:0x01bc, B:88:0x01c4, B:90:0x01d3, B:92:0x01db, B:93:0x01e8, B:95:0x01f0, B:97:0x01f6, B:99:0x0206, B:133:0x02be, B:102:0x0219, B:104:0x0221, B:105:0x0228, B:107:0x0230, B:108:0x0237, B:110:0x023f, B:111:0x0246, B:113:0x024e, B:114:0x0257, B:116:0x025f, B:117:0x0268, B:119:0x0270, B:120:0x027d, B:122:0x0285, B:124:0x028d, B:126:0x0295, B:128:0x02a1, B:130:0x02a9, B:131:0x02b3, B:132:0x02b9, B:134:0x02c8, B:65:0x012d, B:67:0x0131, B:137:0x02cf), top: B:143:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5 A[Catch: JSONException -> 0x00a2, TryCatch #0 {JSONException -> 0x00a2, blocks: (B:23:0x0094, B:25:0x009c, B:29:0x00a5, B:31:0x00ab, B:32:0x00b1, B:34:0x00b7, B:35:0x00bd, B:37:0x00c3, B:39:0x00c9, B:41:0x00cf, B:42:0x00d5, B:44:0x00db, B:45:0x00e1, B:47:0x00e7, B:48:0x00ed, B:50:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0105, B:56:0x010b, B:57:0x0111, B:59:0x0117, B:60:0x011e, B:61:0x0123, B:63:0x0127, B:70:0x0139, B:72:0x0141, B:75:0x016a, B:76:0x0182, B:78:0x018a, B:79:0x01a2, B:81:0x01a8, B:82:0x01ae, B:84:0x01b6, B:86:0x01bc, B:88:0x01c4, B:90:0x01d3, B:92:0x01db, B:93:0x01e8, B:95:0x01f0, B:97:0x01f6, B:99:0x0206, B:133:0x02be, B:102:0x0219, B:104:0x0221, B:105:0x0228, B:107:0x0230, B:108:0x0237, B:110:0x023f, B:111:0x0246, B:113:0x024e, B:114:0x0257, B:116:0x025f, B:117:0x0268, B:119:0x0270, B:120:0x027d, B:122:0x0285, B:124:0x028d, B:126:0x0295, B:128:0x02a1, B:130:0x02a9, B:131:0x02b3, B:132:0x02b9, B:134:0x02c8, B:65:0x012d, B:67:0x0131, B:137:0x02cf), top: B:143:0x0094 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m8647a(org.json.JSONObject r25) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.geocoder.p064a.C1522f.m8647a(org.json.JSONObject):boolean");
    }
}
