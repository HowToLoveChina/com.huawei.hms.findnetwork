package com.huawei.location.sdm;

import as.C1016d;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.C6769i;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p588qr.C12390b;

/* loaded from: classes8.dex */
public final class Config {

    /* renamed from: a */
    public Configurations f31400a;

    public static class Configurations extends ConfigBaseResponse {

        @SerializedName("EPHEMERIS_VALID_TIME")
        private long ephemerisValidTime = 3600;

        @SerializedName("TILE_DAILY_MAX_NUM")
        private int tileDailyMaxNum = 25;

        @SerializedName("TILE_MAX_NUM")
        private int tileMaxNum = 30;

        @SerializedName("SMOOTH_COUNT_ENTER")
        private int smoothEnter = 3;

        @SerializedName("SMOOTH_COUNT_EXIT")
        private int smoothExit = 10;

        @SerializedName("AR_WALK_SPEED")
        private int arWalkSpeed = 3;

        @SerializedName("DEVICE_LIST")
        private List<String> deviceList = new ArrayList();

        private Configurations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean valid() {
            String str;
            long j10 = this.ephemerisValidTime;
            if (j10 > 7200 || j10 < 600) {
                str = "ephemerisValidTime error";
            } else {
                int i10 = this.tileDailyMaxNum;
                if (i10 <= 200 && i10 >= 0) {
                    return true;
                }
                str = "tileDailyMaxNum error";
            }
            C1016d.m6181a("Config", str);
            return false;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Configurations{ephemerisValidTime=");
            sb2.append(this.ephemerisValidTime);
            sb2.append(", tileDailyMaxNum=");
            return C6769i.m38373a(sb2, this.tileDailyMaxNum, '}');
        }
    }

    /* renamed from: a */
    public final boolean m38493a() {
        String str;
        Configurations configurations = (Configurations) C12390b.m74456g().m74460d("sdm", Configurations.class);
        this.f31400a = configurations;
        if (configurations == null) {
            str = "failed to get config";
        } else {
            if (configurations.valid()) {
                C1016d.m6181a("Config", "configurations:" + this.f31400a.toString());
                long unused = this.f31400a.ephemerisValidTime;
                return true;
            }
            str = "config not valid";
        }
        C1016d.m6183c("Config", str);
        return false;
    }

    /* renamed from: b */
    public final int m38494b() {
        return this.f31400a.tileDailyMaxNum;
    }

    /* renamed from: c */
    public final int m38495c() {
        return this.f31400a.tileMaxNum;
    }

    /* renamed from: d */
    public final int m38496d() {
        return this.f31400a.smoothExit;
    }

    /* renamed from: e */
    public final int m38497e() {
        return this.f31400a.arWalkSpeed;
    }

    /* renamed from: f */
    public final int m38498f() {
        return this.f31400a.smoothEnter;
    }

    /* renamed from: g */
    public final boolean m38499g(String str, String str2) {
        String str3 = str + "_" + str2;
        Iterator it = this.f31400a.deviceList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str3)) {
                return true;
            }
        }
        return false;
    }
}
