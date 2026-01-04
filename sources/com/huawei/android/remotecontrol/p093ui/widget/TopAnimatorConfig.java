package com.huawei.android.remotecontrol.p093ui.widget;

/* loaded from: classes4.dex */
public class TopAnimatorConfig {
    static final float[] WAVE_SCALE = {1.0f, 3.2f};
    static final float[] WAVE_ALPHA = {1.0f, 0.0f};

    public interface AnimatorType {
        public static final String ALPHA = "alpha";
        public static final String SCALE_X = "scaleX";
        public static final String SCALE_Y = "scaleY";
    }

    public interface Duration {
        public static final long DROP_DURATION = 200;
        public static final long JUMP_DURATION = 300;
        public static final long REVEAL_DURATION = 400;
        public static final long SQUAT_DURATION = 200;
        public static final long WAVE_ALPHA_DURATION = 1500;
        public static final long WAVE_SCALE_DELAY_DURATION = 500;
        public static final long WAVE_SCALE_DURATION = 1500;
    }

    public interface WaveColor {
        public static final int BLUE = 0;
        public static final int GREEN = 2;
        public static final int RED = 1;
    }
}
