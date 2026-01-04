package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

@DataKeep
/* loaded from: classes8.dex */
public class BluetoothInfo implements Comparable<BluetoothInfo> {
    private String address;
    private int bondState = 0;
    private String name;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(BluetoothInfo bluetoothInfo) {
        if (bluetoothInfo == null) {
            return -1;
        }
        return bluetoothInfo.bondState - this.bondState;
    }

    /* renamed from: b */
    public void m39875b(String str) {
        this.address = str;
    }

    /* renamed from: a */
    public String m39872a() {
        return this.address;
    }

    /* renamed from: a */
    public void m39873a(Integer num) {
        this.bondState = num.intValue();
    }

    /* renamed from: a */
    public void m39874a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.name = "";
        }
        this.name = AbstractC7806cz.m48185n(str);
    }
}
