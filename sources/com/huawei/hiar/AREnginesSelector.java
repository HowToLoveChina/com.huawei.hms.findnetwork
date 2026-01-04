package com.huawei.hiar;

import android.content.Context;

@Deprecated
/* loaded from: classes5.dex */
public class AREnginesSelector {
    private static final String LIBRARY_NAME = "huawei_arengine_jni";
    private static final String TAG = "AREnginesSelector";

    @Deprecated
    public enum AREnginesAvaliblity {
        UNKNOWN_AVALIBLITY(-1),
        HWAR_NONE_ENGINES_SUPPORTED(0),
        HWAR_ENGINE_SUPPORTED(1);

        final int nativeCode;

        AREnginesAvaliblity(int i10) {
            this.nativeCode = i10;
        }

        public static AREnginesAvaliblity forNumber(int i10) {
            for (AREnginesAvaliblity aREnginesAvaliblity : values()) {
                if (aREnginesAvaliblity.nativeCode == i10) {
                    return aREnginesAvaliblity;
                }
            }
            return UNKNOWN_AVALIBLITY;
        }

        public int getKeyValues() {
            return this.nativeCode;
        }
    }

    @Deprecated
    public enum AREnginesType {
        UNKNOWN_TYPE(-1),
        HWAR_NONE(0),
        HWAR_ENGINE(1);

        final int nativeCode;

        AREnginesType(int i10) {
            this.nativeCode = i10;
        }

        public static AREnginesType forNumber(int i10) {
            for (AREnginesType aREnginesType : values()) {
                if (aREnginesType.nativeCode == i10) {
                    return aREnginesType;
                }
            }
            return UNKNOWN_TYPE;
        }
    }

    private AREnginesSelector() {
    }

    @Deprecated
    public static AREnginesAvaliblity checkAllAvailableEngines(Context context) {
        return AREnginesAvaliblity.forNumber(1);
    }

    @Deprecated
    public static AREnginesType getCreatedEngine() {
        return AREnginesType.forNumber(1);
    }

    @Deprecated
    public static AREnginesType setAREngine(AREnginesType aREnginesType) {
        return AREnginesType.forNumber(1);
    }
}
