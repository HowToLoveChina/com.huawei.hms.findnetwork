package p694v;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: v.n */
/* loaded from: classes.dex */
public final class C13312n implements Iterable<Intent> {

    /* renamed from: a */
    public final ArrayList<Intent> f60062a = new ArrayList<>();

    /* renamed from: b */
    public final Context f60063b;

    /* renamed from: v.n$a */
    public interface a {
        /* renamed from: l */
        Intent mo2046l();
    }

    public C13312n(Context context) {
        this.f60063b = context;
    }

    /* renamed from: d */
    public static C13312n m79807d(Context context) {
        return new C13312n(context);
    }

    /* renamed from: a */
    public C13312n m79808a(Intent intent) {
        this.f60062a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public C13312n m79809b(Activity activity) {
        Intent intentMo2046l = activity instanceof a ? ((a) activity).mo2046l() : null;
        if (intentMo2046l == null) {
            intentMo2046l = C13302d.m79770a(activity);
        }
        if (intentMo2046l != null) {
            ComponentName component = intentMo2046l.getComponent();
            if (component == null) {
                component = intentMo2046l.resolveActivity(this.f60063b.getPackageManager());
            }
            m79810c(component);
            m79808a(intentMo2046l);
        }
        return this;
    }

    /* renamed from: c */
    public C13312n m79810c(ComponentName componentName) {
        int size = this.f60062a.size();
        try {
            Intent intentM79771b = C13302d.m79771b(this.f60063b, componentName);
            while (intentM79771b != null) {
                this.f60062a.add(size, intentM79771b);
                intentM79771b = C13302d.m79771b(this.f60063b, intentM79771b.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    /* renamed from: e */
    public void m79811e() {
        m79812f(null);
    }

    /* renamed from: f */
    public void m79812f(Bundle bundle) {
        if (this.f60062a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f60062a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.f60063b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        this.f60063b.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f60062a.iterator();
    }
}
