package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.u */
/* loaded from: classes8.dex */
public class C5569u {

    /* renamed from: a */
    private List<C5518b1> f25313a;

    /* renamed from: b */
    private String f25314b;

    /* renamed from: c */
    private String f25315c;

    /* renamed from: d */
    private String f25316d;

    public C5569u(List<C5518b1> list, String str, String str2, String str3) {
        this.f25313a = list;
        this.f25314b = str;
        this.f25315c = str2;
        this.f25316d = str3;
    }

    /* renamed from: a */
    public void m32779a() {
        if (!"_default_config_tag".equals(this.f25315c)) {
            m32778a(this.f25313a, this.f25315c, this.f25314b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (C5518b1 c5518b1 : this.f25313a) {
            String strM32456c = c5518b1.m32456c();
            if (TextUtils.isEmpty(strM32456c) || "oper".equals(strM32456c)) {
                arrayList4.add(c5518b1);
            } else if ("maint".equals(strM32456c)) {
                arrayList.add(c5518b1);
            } else if ("preins".equals(strM32456c)) {
                arrayList2.add(c5518b1);
            } else if ("diffprivacy".equals(strM32456c)) {
                arrayList3.add(c5518b1);
            }
        }
        m32778a(arrayList4, "oper", "_default_config_tag");
        m32778a(arrayList, "maint", "_default_config_tag");
        m32778a(arrayList2, "preins", "_default_config_tag");
        m32778a(arrayList3, "diffprivacy", "_default_config_tag");
    }

    /* renamed from: a */
    private void m32778a(List<C5518b1> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = i10 * 500;
            List<C5518b1> listSubList = list.subList(i11, Math.min(list.size(), i11 + 500));
            String strReplace = UUID.randomUUID().toString().replace("-", "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jM32427b = AbstractC5515a1.m32427b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (C5518b1 c5518b1 : listSubList) {
                if (!C5520c0.m32467a(c5518b1.m32454b(), jCurrentTimeMillis, jM32427b)) {
                    arrayList.add(c5518b1);
                }
            }
            if (arrayList.size() > 0) {
                new C5547l0(str2, str, this.f25316d, arrayList, strReplace).m32625a();
            } else {
                C5571v.m32796e("hmsSdk", "No data to report handler");
            }
        }
    }
}
