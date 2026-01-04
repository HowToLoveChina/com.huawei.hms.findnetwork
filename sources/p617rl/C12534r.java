package p617rl;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.SplitAppSetting;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p292fn.C9733f;
import p514o9.C11839m;
import p815ym.AbstractC14026a;

/* renamed from: rl.r */
/* loaded from: classes6.dex */
public class C12534r {

    /* renamed from: c */
    public static final HashMap<String, Integer> f57864c = new a();

    /* renamed from: a */
    public List<SplitAppSetting> f57865a;

    /* renamed from: b */
    public final HashMap<String, Boolean> f57866b = new HashMap<>();

    /* renamed from: rl.r$a */
    public class a extends HashMap<String, Integer> {
        public a() {
            put("1", 1);
            put("3", 2);
            put("2", 4);
        }
    }

    /* renamed from: g */
    public static C12534r m75443g() {
        return new C12534r().m75449k();
    }

    /* renamed from: h */
    public static boolean m75444h(String str) {
        return "2".equals(str);
    }

    /* renamed from: o */
    public static /* synthetic */ String m75445o(String str) {
        return str;
    }

    /* renamed from: p */
    public static /* synthetic */ Boolean m75446p(boolean z10, String str) {
        return Boolean.valueOf(z10);
    }

    /* renamed from: i */
    public final boolean m75447i(int i10, String str) {
        Integer num = f57864c.get(str);
        return (num == null || (num.intValue() & i10) == 0) ? false : true;
    }

    /* renamed from: j */
    public final List<String> m75448j(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(CloudBackupConstant.Command.PMS_CMD_BACKUP);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    arrayList.add(jSONArray.getJSONObject(i10).getString("bundle"));
                } catch (JSONException e10) {
                    C11839m.m70689w("SplitAppSettingHelper", "getSplitAppPublishAppIds error: " + e10);
                }
            }
        } catch (Throwable th2) {
            C11839m.m70689w("SplitAppSettingHelper", "getSplitAppPublishAppIds error: " + th2);
        }
        return arrayList;
    }

    /* renamed from: k */
    public final C12534r m75449k() {
        if (C9733f.m60705z().m60720O("backupSupportSplitApp")) {
            m75450l();
            this.f57865a = new C12526j().m75349M0();
        } else {
            C11839m.m70688i("SplitAppSettingHelper", "init not support splitApp");
        }
        return this;
    }

    /* renamed from: l */
    public final void m75450l() {
        String strM60762u = C9733f.m60705z().m60762u("backupSplitAppsPublish");
        if (TextUtils.isEmpty(strM60762u)) {
            return;
        }
        List<String> listM75448j = m75448j(strM60762u);
        if (AbstractC14026a.m84159a(listM75448j)) {
            return;
        }
        final boolean zM60720O = C9733f.m60705z().m60720O("backupSplitAppsPublish");
        this.f57866b.putAll((Map) listM75448j.stream().collect(Collectors.toMap(new Function() { // from class: rl.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12534r.m75445o((String) obj);
            }
        }, new Function() { // from class: rl.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12534r.m75446p(zM60720O, (String) obj);
            }
        })));
    }

    /* renamed from: m */
    public boolean m75451m(final String str, final String str2) {
        if (C0209d.m1269j1()) {
            C11839m.m70689w("SplitAppSettingHelper", "isSupportBackup isHonorProduct");
            return false;
        }
        if (m75444h(str2)) {
            return false;
        }
        Boolean bool = this.f57866b.get(str);
        if (bool != null && !bool.booleanValue()) {
            return false;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Optional.ofNullable(this.f57865a).ifPresent(new Consumer() { // from class: rl.o
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f57854a.m75454r(atomicBoolean, str, str2, (List) obj);
            }
        });
        C11839m.m70686d("SplitAppSettingHelper", "isSupportBackup appId: " + str + " ,bakCategory: " + str2 + " ,result: " + atomicBoolean);
        return atomicBoolean.get();
    }

    /* renamed from: n */
    public boolean m75452n(final String str, final String str2) {
        if (C0209d.m1269j1()) {
            C11839m.m70689w("SplitAppSettingHelper", "isSupportRestore isHonorProduct");
            return false;
        }
        if (m75444h(str2) || !SplitAppUtil.isSystemSupportSplitRestore() || !SplitAppUtil.isInConfigured(str)) {
            return false;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Optional.ofNullable(this.f57865a).ifPresent(new Consumer() { // from class: rl.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f57849a.m75456t(atomicBoolean, str, str2, (List) obj);
            }
        });
        C11839m.m70688i("SplitAppSettingHelper", "isSupportRestore appId: " + str + " ,cakCategory: " + str2 + " ,result: " + atomicBoolean);
        return atomicBoolean.get();
    }

    /* renamed from: q */
    public final /* synthetic */ boolean m75453q(String str, String str2, SplitAppSetting splitAppSetting) {
        return (TextUtils.equals(splitAppSetting.getBundleName(), str) || TextUtils.equals("*", splitAppSetting.getBundleName())) && m75447i(splitAppSetting.getBackup().intValue(), str2);
    }

    /* renamed from: r */
    public final /* synthetic */ void m75454r(AtomicBoolean atomicBoolean, final String str, final String str2, List list) {
        atomicBoolean.set(list.stream().anyMatch(new Predicate() { // from class: rl.q
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f57861a.m75453q(str, str2, (SplitAppSetting) obj);
            }
        }));
    }

    /* renamed from: s */
    public final /* synthetic */ boolean m75455s(String str, String str2, SplitAppSetting splitAppSetting) {
        return (TextUtils.equals(splitAppSetting.getBundleName(), str) || TextUtils.equals("*", splitAppSetting.getBundleName())) && m75447i(splitAppSetting.getRestore().intValue(), str2);
    }

    /* renamed from: t */
    public final /* synthetic */ void m75456t(AtomicBoolean atomicBoolean, final String str, final String str2, List list) {
        atomicBoolean.set(list.stream().anyMatch(new Predicate() { // from class: rl.p
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f57858a.m75455s(str, str2, (SplitAppSetting) obj);
            }
        }));
    }
}
