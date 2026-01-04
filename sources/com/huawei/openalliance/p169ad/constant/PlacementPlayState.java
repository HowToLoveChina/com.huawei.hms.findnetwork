package com.huawei.openalliance.p169ad.constant;

import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* loaded from: classes2.dex */
public class PlacementPlayState {
    private static final String TAG = "PlacementPlayState";
    private State currentState;
    private final byte[] lock;

    public enum State {
        SINGLE_INST,
        MAIN_VIEW,
        BACKUP_VIEW
    }

    public PlacementPlayState() {
        this.currentState = State.SINGLE_INST;
        this.lock = new byte[0];
    }

    public State getCurrentState() {
        State state;
        synchronized (this.lock) {
            state = this.currentState;
        }
        return state;
    }

    public boolean isNotState(State state) {
        boolean z10;
        synchronized (this.lock) {
            z10 = !isState(state);
        }
        return z10;
    }

    public boolean isState(State state) {
        boolean z10;
        synchronized (this.lock) {
            z10 = state == this.currentState;
        }
        return z10;
    }

    public void switchToState(State state) {
        if (state == null) {
            return;
        }
        synchronized (this.lock) {
            AbstractC7185ho.m43821b(TAG, "switch to state: %s", state);
            this.currentState = state;
        }
    }

    public PlacementPlayState(State state) {
        State state2 = State.SINGLE_INST;
        this.lock = new byte[0];
        this.currentState = state;
    }
}
