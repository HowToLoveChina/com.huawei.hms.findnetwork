package p848zl;

import com.huawei.android.p073ds.R$string;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: zl.f */
/* loaded from: classes6.dex */
public class C14337f {

    /* renamed from: a */
    public static final Map<Integer, Integer> f63675a = Collections.unmodifiableMap(new a());

    /* renamed from: b */
    public static final List<Integer> f63676b;

    /* renamed from: c */
    public static final List<Integer> f63677c;

    /* renamed from: d */
    public static final List<Integer> f63678d;

    /* renamed from: zl.f$a */
    public class a extends HashMap<Integer, Integer> {
        public a() {
            put(1005, Integer.valueOf(R$string.cloud_backup_failed_notification_battery2));
            put(1007, Integer.valueOf(R$string.cloud_backup_failed_notification_localspace));
            put(1006, Integer.valueOf(R$string.cloud_backup_failed_notification_screen2));
            put(1002, Integer.valueOf(R$string.cloud_backup_failed_notification_network2));
        }
    }

    static {
        Integer numValueOf = Integer.valueOf(SNSCode.Status.HWID_UNLOGIN);
        f63676b = Collections.unmodifiableList(Arrays.asList(numValueOf, Integer.valueOf(SNSCode.Status.GET_FRIEND_LIST_FAIL), 1002, 3900, 3927, 3933, 3934));
        f63677c = Collections.unmodifiableList(Arrays.asList(1036, 3113));
        f63678d = Collections.unmodifiableList(Arrays.asList(1002, 1005, 1006, Integer.valueOf(PlayerConstants.ErrorCode.SWITCH_PLAYMODE_AUDIO_FAILED), 1007, numValueOf, 0));
    }

    /* renamed from: a */
    public static final List<Integer> m85498a() {
        return f63678d;
    }

    /* renamed from: b */
    public static Map<Integer, Integer> m85499b() {
        return f63675a;
    }

    /* renamed from: c */
    public static List<Integer> m85500c() {
        return f63676b;
    }
}
