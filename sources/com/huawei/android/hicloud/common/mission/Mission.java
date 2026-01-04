package com.huawei.android.hicloud.common.mission;

import java.util.stream.Stream;
import nu.C11754g;
import p282f9.EnumC9677c;

/* loaded from: classes3.dex */
public interface Mission extends Comparable<Mission> {
    static Stream<Mission> get() {
        return C11754g.m70076k(Mission.class).sorted();
    }

    /* renamed from: e0 */
    void mo15610e0();

    /* renamed from: f0 */
    default void mo15611f0() {
    }

    @Override // java.lang.Comparable
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    default int compareTo(Mission mission) {
        return identity().compareTo(mission.identity());
    }

    /* renamed from: h0 */
    boolean mo15613h0();

    EnumC9677c identity();

    /* renamed from: k0 */
    default void m15614k0() {
        if (mo15613h0()) {
            mo15610e0();
        } else {
            mo15611f0();
        }
    }
}
