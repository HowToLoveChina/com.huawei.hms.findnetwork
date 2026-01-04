package p005a4;

import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.Arrays;

/* renamed from: a4.e */
/* loaded from: classes.dex */
public class C0025e {
    /* renamed from: a */
    public static byte[] m100a(byte[] bArr) {
        if (bArr.length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
        bArrCopyOf[bArr.length] = -128;
        return bArrCopyOf;
    }

    /* renamed from: b */
    public static byte[] m101b(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i10 = 0; i10 < 16; i10++) {
            byte b10 = (byte) ((bArr[i10] << 1) & Constant.ERROR_ROAD_AREA_INVALID);
            bArr2[i10] = b10;
            if (i10 < 15) {
                bArr2[i10] = (byte) (((byte) ((bArr[i10 + 1] >> 7) & 1)) | b10);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & SyncType.RISK_MANAGEMENT_MANUALLY)) ^ bArr2[15]);
        return bArr2;
    }
}
