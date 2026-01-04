package com.huawei.hms.ads.jsb;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes8.dex */
public class JsbConfig {

    /* renamed from: a */
    private boolean f23231a;

    /* renamed from: b */
    private String f23232b;

    /* renamed from: c */
    private String f23233c;

    /* renamed from: d */
    private boolean f23234d;

    @OuterVisible
    public static final class Builder {

        /* renamed from: a */
        private boolean f23235a = true;

        /* renamed from: b */
        private String f23236b;

        /* renamed from: c */
        private String f23237c;

        /* renamed from: d */
        private boolean f23238d;

        @OuterVisible
        public final JsbConfig build() {
            return new JsbConfig(this);
        }

        @OuterVisible
        public final Builder enableLog(boolean z10) {
            this.f23238d = z10;
            return this;
        }

        @OuterVisible
        public final Builder enableUserInfo(boolean z10) {
            this.f23235a = z10;
            return this;
        }

        @OuterVisible
        public final Builder initGrs(String str) {
            this.f23236b = str;
            return this;
        }

        @OuterVisible
        public final Builder initGrs(String str, String str2) {
            this.f23236b = str;
            this.f23237c = str2;
            return this;
        }
    }

    private JsbConfig(Builder builder) {
        this.f23231a = true;
        this.f23231a = builder.f23235a;
        this.f23232b = builder.f23236b;
        this.f23233c = builder.f23237c;
        this.f23234d = builder.f23238d;
    }

    /* renamed from: a */
    public boolean m30335a() {
        return this.f23231a;
    }

    /* renamed from: b */
    public String m30336b() {
        return this.f23232b;
    }

    /* renamed from: c */
    public String m30337c() {
        return this.f23233c;
    }

    /* renamed from: d */
    public boolean m30338d() {
        return this.f23234d;
    }
}
