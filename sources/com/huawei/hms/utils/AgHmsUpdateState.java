package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class AgHmsUpdateState {

    /* renamed from: c */
    private static final Object f30145c = new Object();

    /* renamed from: d */
    private static volatile AgHmsUpdateState f30146d;

    /* renamed from: a */
    private HmsCheckedState f30147a = HmsCheckedState.UNCHECKED;

    /* renamed from: b */
    private int f30148b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f30146d == null) {
            synchronized (f30145c) {
                try {
                    if (f30146d == null) {
                        f30146d = new AgHmsUpdateState();
                    }
                } finally {
                }
            }
        }
        return f30146d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f30147a;
    }

    public int getTargetVersionCode() {
        return this.f30148b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f30148b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() != HmsCheckedState.NEED_UPDATE) {
            return;
        }
        setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        setTargetVersionCode(0);
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.m36986e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f30147a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i10) {
        this.f30148b = i10;
    }
}
