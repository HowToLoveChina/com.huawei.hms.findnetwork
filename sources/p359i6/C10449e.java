package p359i6;

import android.content.Context;
import android.os.HardwarePropertiesManager;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: i6.e */
/* loaded from: classes.dex */
public class C10449e extends AbstractC10448d {

    /* renamed from: d */
    public HardwarePropertiesManager f50413d;

    public C10449e(Context context) {
        this.f50413d = null;
        if (context == null) {
            C2111d.m12646b("WindowTemp", "Context is null, return");
            return;
        }
        HardwarePropertiesManager hardwarePropertiesManager = (HardwarePropertiesManager) context.getSystemService("hardware_properties");
        this.f50413d = hardwarePropertiesManager;
        if (hardwarePropertiesManager == null) {
            C2111d.m12648d("WindowTemp", "Failed to get HARDWARE_PROPERTIES_SERVICE");
        }
    }

    @Override // p359i6.AbstractC10448d
    /* renamed from: b */
    public float mo64241b() {
        HardwarePropertiesManager hardwarePropertiesManager = this.f50413d;
        float f10 = -1000.0f;
        if (hardwarePropertiesManager != null) {
            try {
                float[] deviceTemperatures = hardwarePropertiesManager.getDeviceTemperatures(2, 0);
                if (deviceTemperatures != null && deviceTemperatures.length != 0) {
                    f10 = deviceTemperatures[0];
                }
                C2111d.m12654j("WindowTemp", "batteryTemp is ", Float.valueOf(f10));
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("WindowTemp", "IllegalArgumentException when get batteryTemp");
            } catch (Exception unused2) {
                C2111d.m12648d("WindowTemp", "Exception when get batteryTemp");
            }
        }
        return f10;
    }

    @Override // p359i6.AbstractC10448d
    /* renamed from: d */
    public boolean mo64242d() {
        return mo64241b() != -1000.0f;
    }
}
