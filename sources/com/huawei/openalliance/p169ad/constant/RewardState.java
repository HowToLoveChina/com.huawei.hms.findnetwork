package com.huawei.openalliance.p169ad.constant;

import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* loaded from: classes2.dex */
public class RewardState {
    private static final String TAG = "RewardState";
    private final byte[] lock = new byte[0];
    private State currentState = State.IDLE;

    public enum State {
        IDLE(0),
        VIDEO_DISPLAYING(1),
        DIALOG_DISPLAYING(2),
        SWIPE_DISPLAYING(3),
        CLICK_WEBVIEW(4),
        END_WEBVIEW(5),
        END_MASKING(6),
        ENDCARD(7),
        HIDE(8);

        int code;

        State(int i10) {
            this.code = i10;
        }

        public int getCode() {
            return this.code;
        }

        @Override // java.lang.Enum
        public String toString() {
            return name() + "(" + this.code + ")";
        }
    }

    public boolean isState(State state) {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.currentState == state;
        }
        return z10;
    }

    public void switchToState(State state) {
        if (state == null) {
            return;
        }
        synchronized (this.lock) {
            AbstractC7185ho.m43821b(TAG, "switch to state: %s, preState: %s", state, this.currentState);
            this.currentState = state;
        }
    }
}
