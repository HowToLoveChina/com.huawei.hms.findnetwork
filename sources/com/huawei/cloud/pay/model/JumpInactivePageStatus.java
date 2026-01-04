package com.huawei.cloud.pay.model;

import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes5.dex */
public enum JumpInactivePageStatus {
    DATA_NOT_READY(0),
    PROTOCOL_CHECK_PASSED(1),
    DATA_READY(2),
    CAN_JUMP(3),
    JUMPED(7);

    private final int val;

    JumpInactivePageStatus(int i10) {
        this.val = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$update$0(int i10, JumpInactivePageStatus jumpInactivePageStatus) {
        return jumpInactivePageStatus.val == i10;
    }

    public JumpInactivePageStatus update(JumpInactivePageStatus jumpInactivePageStatus) {
        if (jumpInactivePageStatus == null) {
            return this;
        }
        JumpInactivePageStatus jumpInactivePageStatus2 = JUMPED;
        if (this == jumpInactivePageStatus2 || jumpInactivePageStatus == jumpInactivePageStatus2) {
            return jumpInactivePageStatus2;
        }
        final int i10 = this.val | jumpInactivePageStatus.val;
        return (JumpInactivePageStatus) Stream.of((Object[]) values()).filter(new Predicate() { // from class: com.huawei.cloud.pay.model.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return JumpInactivePageStatus.lambda$update$0(i10, (JumpInactivePageStatus) obj);
            }
        }).findFirst().orElse(null);
    }
}
