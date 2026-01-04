package p842zf;

import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import java.util.function.Consumer;
import p227dg.C9120m0;
import p575qe.C12347f;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: zf.g */
/* loaded from: classes4.dex */
public class C14299g implements FindNetworkSoundCallback {

    /* renamed from: a */
    public boolean f63546a = false;

    /* renamed from: b */
    public int f63547b = 1;

    /* renamed from: c */
    public Consumer<Integer> f63548c;

    /* renamed from: d */
    public String f63549d;

    public C14299g(String str, Consumer<Integer> consumer) {
        this.f63548c = consumer;
        this.f63549d = str;
    }

    /* renamed from: a */
    public int m85165a() {
        return this.f63547b;
    }

    /* renamed from: b */
    public void m85166b(int i10) {
        this.f63547b = i10;
    }

    /* renamed from: c */
    public void m85167c(boolean z10) {
        this.f63546a = z10;
    }

    @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
    public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
        C13981a.m83989i("TrackedTagSoundCallback", "TagSoundCallback fail" + findNetworkConfigResult.getRespCode());
        m85167c(false);
        m85166b(findNetworkConfigResult.getRespCode());
        new C12797b().m76784j(C12347f.m74285n().m74301m(), "TrackedTagSoundCallback", "", "TagSoundCallback fail, code = " + m85165a() + ", sn = " + C9120m0.m57351R(this.f63549d), "", "tracked_tag_sound", "", "tracked_tag_sound", true);
        this.f63548c.accept(Integer.valueOf(m85165a()));
    }

    @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
    public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
        C13981a.m83989i("TrackedTagSoundCallback", "TagSoundCallback finished");
    }

    @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
    public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
        C13981a.m83989i("TrackedTagSoundCallback", "TagSoundCallback success" + findNetworkConfigResult.getRespCode());
        m85167c(true);
        m85166b(findNetworkConfigResult.getRespCode());
        new C12797b().m76784j(C12347f.m74285n().m74301m(), "TrackedTagSoundCallback", "", "TagSoundCallback success, code = " + m85165a() + ", sn = " + C9120m0.m57351R(this.f63549d), "", "tracked_tag_sound", "", "tracked_tag_sound", true);
        this.f63548c.accept(Integer.valueOf(m85165a()));
    }

    @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
    public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
        C13981a.m83989i("TrackedTagSoundCallback", "TagSoundCallback onUpdate");
        m85166b(findNetworkConfigResult.getRespCode());
        new C12797b().m76784j(C12347f.m74285n().m74301m(), "TrackedTagSoundCallback", "", "TagSoundCallback onUpdate, code = " + m85165a() + ", sn = " + C9120m0.m57351R(this.f63549d), "", "tracked_tag_sound", "", "tracked_tag_sound", true);
        this.f63548c.accept(Integer.valueOf(m85165a()));
    }
}
