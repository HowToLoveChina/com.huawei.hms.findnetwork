package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.io.Serializable;

@DataKeep
@OuterVisible
/* loaded from: classes2.dex */
public class AdvertiserInfo implements Serializable, Comparable {
    private static final long serialVersionUID = -3124209648823884395L;
    private String key;
    private Integer seq;
    private String value;

    /* renamed from: a */
    public void m44334a(Integer num) {
        this.seq = num;
    }

    /* renamed from: b */
    public void m44336b(String str) {
        this.value = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof AdvertiserInfo) && ((AdvertiserInfo) obj).getSeq().intValue() <= getSeq().intValue()) ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdvertiserInfo)) {
            return false;
        }
        AdvertiserInfo advertiserInfo = (AdvertiserInfo) obj;
        Integer num = this.seq;
        if (num == null) {
            if (advertiserInfo.seq != null) {
                return false;
            }
        } else if (!num.equals(advertiserInfo.seq)) {
            return false;
        }
        return true;
    }

    @OuterVisible
    public String getKey() {
        return this.key;
    }

    @OuterVisible
    public Integer getSeq() {
        return this.seq;
    }

    @OuterVisible
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        Integer num = this.seq;
        return super.hashCode() & (num != null ? num.hashCode() : -1);
    }

    /* renamed from: a */
    public void m44335a(String str) {
        this.key = str;
    }
}
