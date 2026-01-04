package com.huawei.openalliance.p169ad.media;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public class MediaState {

    /* renamed from: a */
    private State f34606a = State.IDLE;

    /* renamed from: b */
    private final byte[] f34607b = new byte[0];

    /* renamed from: com.huawei.openalliance.ad.media.MediaState$1 */
    public static /* synthetic */ class C74671 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34608a;

        static {
            int[] iArr = new int[State.values().length];
            f34608a = iArr;
            try {
                iArr[State.PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34608a[State.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34608a[State.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34608a[State.PLAYBACK_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @OuterVisible
    public enum State {
        END(-2),
        ERROR(-1),
        IDLE(0),
        INITIALIZED(1),
        PREPARING(2),
        PREPARED(3),
        PLAYING(4),
        PAUSED(5),
        PLAYBACK_COMPLETED(6);

        int code;

        State(int i10) {
            this.code = i10;
        }

        @OuterVisible
        public int getCode() {
            return this.code;
        }

        @Override // java.lang.Enum
        public String toString() {
            return name() + "(" + this.code + ")";
        }
    }

    @OuterVisible
    public MediaState() {
    }

    /* renamed from: a */
    public void m45810a(State state) {
        if (state == null) {
            return;
        }
        synchronized (this.f34607b) {
            try {
                if (this.f34606a != State.END) {
                    AbstractC7185ho.m43821b("MediaState", "switchToState: %s", state);
                    this.f34606a = state;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @OuterVisible
    public int getStateCode() {
        int code;
        synchronized (this.f34607b) {
            code = this.f34606a.getCode();
        }
        return code;
    }

    @OuterVisible
    public boolean isNotState(State state) {
        return !isState(state);
    }

    @OuterVisible
    public boolean isState(State state) {
        boolean z10;
        synchronized (this.f34607b) {
            z10 = this.f34606a == state;
        }
        return z10;
    }

    public String toString() {
        String string;
        synchronized (this.f34607b) {
            string = this.f34606a.toString();
        }
        return string;
    }

    /* renamed from: a */
    public boolean m45811a() {
        boolean z10;
        synchronized (this.f34607b) {
            int i10 = C74671.f34608a[this.f34606a.ordinal()];
            z10 = true;
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
                z10 = false;
            }
        }
        return z10;
    }
}
