package com.huawei.hms.network.file.p130a.p133k.p134b;

import com.huawei.hms.network.embedded.C5929g4;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.file.a.k.b.h */
/* loaded from: classes8.dex */
public class C6206h {

    /* renamed from: a */
    private String f29336a;

    /* renamed from: b */
    private List<C6199a> f29337b = new ArrayList();

    public C6206h(String str) {
        this.f29336a = str;
    }

    /* renamed from: a */
    public C6206h m36123a(C6199a c6199a) {
        this.f29337b.add(c6199a);
        return this;
    }

    /* renamed from: a */
    public String m36124a() {
        String str;
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append(this.f29336a);
        sb2.append(C5929g4.f26849k);
        for (C6199a c6199a : this.f29337b) {
            if (c6199a.f29325c != null) {
                sb2.append("PRIMARY KEY (");
                for (String str2 : c6199a.f29325c) {
                    sb2.append(str2);
                    sb2.append(",");
                }
                sb2.deleteCharAt(sb2.length() - 1);
                str = ")";
            } else {
                sb2.append(c6199a.f29323a);
                sb2.append(" ");
                sb2.append(c6199a.f29324b);
                if (c6199a.f29326d) {
                    sb2.append(" PRIMARY KEY");
                }
                if (c6199a.f29327e) {
                    str = " unique";
                } else {
                    sb2.append(",");
                }
            }
            sb2.append(str);
            sb2.append(",");
        }
        if (sb2.toString().endsWith(",")) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append(C5929g4.f26850l);
        return sb2.toString();
    }
}
