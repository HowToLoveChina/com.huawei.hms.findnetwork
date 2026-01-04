package com.huawei.openalliance.p169ad;

import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;

/* renamed from: com.huawei.openalliance.ad.bn */
/* loaded from: classes8.dex */
public abstract class AbstractC6970bn {
    /* renamed from: a */
    public static int m41050a(int i10) {
        if (i10 == -1) {
            return 1006;
        }
        if (i10 == 200) {
            return 1000;
        }
        if (i10 != 204) {
            if (i10 == 496) {
                return 1007;
            }
            if (i10 != 498 && i10 != 804) {
                if (i10 == 704) {
                    return FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST;
                }
                if (i10 == 705) {
                    return 1009;
                }
                if (i10 != 801) {
                    if (i10 != 802) {
                        if (i10 != 1000) {
                            if (i10 == 1001) {
                                return 1002;
                            }
                            if (i10 != 1100) {
                                if (i10 != 1101) {
                                    switch (i10) {
                                        case ErrorCode.ERROR_NATIVE_AD_NO /* 700 */:
                                            break;
                                        case 701:
                                            break;
                                        case 702:
                                            break;
                                        default:
                                            switch (i10) {
                                                case ErrorCode.ERROR_REWARD_AD_NO /* 900 */:
                                                    break;
                                                case 901:
                                                    break;
                                                case 902:
                                                    break;
                                                default:
                                                    return FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN;
                                            }
                                    }
                                }
                            }
                        }
                    }
                    return 1003;
                }
                return 1004;
            }
            return 1001;
        }
        return 1005;
    }
}
