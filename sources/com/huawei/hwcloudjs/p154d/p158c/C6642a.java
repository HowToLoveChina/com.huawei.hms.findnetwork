package com.huawei.hwcloudjs.p154d.p158c;

import com.huawei.hwcloudjs.p160e.p163b.AbstractC6654c;
import com.huawei.hwcloudjs.p160e.p163b.AbstractC6655d;

/* renamed from: com.huawei.hwcloudjs.d.c.a */
/* loaded from: classes8.dex */
public class C6642a extends AbstractC6654c<a> {

    /* renamed from: b */
    private static C6642a f30849b = new C6642a();

    /* renamed from: com.huawei.hwcloudjs.d.c.a$a */
    public static final class a extends AbstractC6655d {

        /* renamed from: a */
        private int f30850a;

        /* renamed from: b */
        private int[] f30851b;

        /* renamed from: a */
        public void m37826a(int i10) {
            this.f30850a = i10;
        }

        /* renamed from: b */
        public int m37829b() {
            return this.f30850a;
        }

        /* renamed from: a */
        public void m37827a(int[] iArr) {
            if (iArr != null) {
                this.f30851b = (int[]) iArr.clone();
            }
        }

        /* renamed from: a */
        public int[] m37828a() {
            int[] iArr = this.f30851b;
            return iArr != null ? (int[]) iArr.clone() : new int[0];
        }
    }

    /* renamed from: a */
    public static C6642a m37825a() {
        return f30849b;
    }
}
