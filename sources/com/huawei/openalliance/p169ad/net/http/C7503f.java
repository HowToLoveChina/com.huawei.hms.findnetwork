package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.net.http.f */
/* loaded from: classes2.dex */
public class C7503f {

    /* renamed from: a */
    final String f34852a;

    /* renamed from: b */
    final String f34853b;

    /* renamed from: c */
    final int f34854c;

    /* renamed from: d */
    final List<String> f34855d;

    /* renamed from: e */
    final List<String> f34856e;

    /* renamed from: f */
    final String f34857f;

    /* renamed from: g */
    final boolean f34858g;

    /* renamed from: h */
    final String f34859h;

    /* renamed from: com.huawei.openalliance.ad.net.http.f$a */
    public static class a {

        /* renamed from: a */
        String f34860a;

        /* renamed from: b */
        String f34861b;

        /* renamed from: c */
        int f34862c;

        /* renamed from: d */
        final List<String> f34863d;

        /* renamed from: e */
        List<String> f34864e;

        /* renamed from: f */
        String f34865f;

        /* renamed from: g */
        boolean f34866g;

        /* renamed from: h */
        String f34867h;

        public a() {
            this.f34863d = new ArrayList();
            this.f34864e = new ArrayList();
            this.f34866g = false;
        }

        /* renamed from: a */
        public a m46072a(Context context, String str) {
            if (TextUtils.isEmpty(str) || !AbstractC7806cz.m48181j(str)) {
                str = C7124fh.m43316b(context).mo43324a(context, str);
            }
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.f34867h = str;
            Uri uri = Uri.parse(str);
            this.f34860a = uri.getScheme();
            this.f34861b = AbstractC7806cz.m48182k(str);
            this.f34862c = uri.getPort();
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null) {
                this.f34863d.addAll(pathSegments);
            }
            String encodedQuery = uri.getEncodedQuery();
            if (!TextUtils.isEmpty(encodedQuery)) {
                for (String str2 : encodedQuery.split("&")) {
                    this.f34864e.add(str2);
                }
            }
            this.f34865f = uri.getEncodedFragment();
            return this;
        }

        public a(boolean z10) {
            this.f34863d = new ArrayList();
            this.f34864e = new ArrayList();
            this.f34866g = z10;
        }

        /* renamed from: a */
        public a m46073a(List<String> list) {
            if (list != null) {
                this.f34864e.addAll(list);
            }
            return this;
        }

        /* renamed from: a */
        public C7503f m46074a() {
            return new C7503f(this);
        }
    }

    public C7503f(a aVar) {
        this.f34852a = aVar.f34860a;
        this.f34853b = aVar.f34861b;
        this.f34854c = aVar.f34862c;
        this.f34855d = aVar.f34863d;
        this.f34856e = aVar.f34864e;
        this.f34857f = aVar.f34865f;
        this.f34858g = aVar.f34866g;
        this.f34859h = aVar.f34867h;
    }

    /* renamed from: a */
    public boolean m46069a() {
        return this.f34858g;
    }

    /* renamed from: b */
    public String m46070b() {
        return this.f34859h;
    }

    /* renamed from: c */
    public String m46071c() {
        int size;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f34852a);
        sb2.append("://");
        sb2.append(this.f34853b);
        if (this.f34854c > 0) {
            sb2.append(':');
            sb2.append(this.f34854c);
        }
        sb2.append(C5929g4.f26852n);
        List<String> list = this.f34855d;
        if (list != null) {
            int size2 = list.size();
            for (int i10 = 0; i10 < size2; i10++) {
                sb2.append(this.f34855d.get(i10));
                sb2.append(C5929g4.f26852n);
            }
        }
        AbstractC7806cz.m48159a(sb2, C5929g4.f26852n);
        List<String> list2 = this.f34856e;
        if (list2 != null && (size = list2.size()) > 0) {
            sb2.append('?');
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append(this.f34856e.get(i11));
                sb2.append('&');
            }
            AbstractC7806cz.m48159a(sb2, '&');
        }
        if (!TextUtils.isEmpty(this.f34857f)) {
            sb2.append('#');
            sb2.append(this.f34857f);
        }
        return sb2.toString();
    }
}
