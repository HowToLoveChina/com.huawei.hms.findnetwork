package tm;

import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: tm.a */
/* loaded from: classes6.dex */
public abstract class AbstractC13038a {

    /* renamed from: a */
    public static final List<String> f59353a;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ROOT");
        arrayList.add(NetworkService.Constants.CONFIG_SERVICE);
        arrayList.add("config-suffix");
        arrayList.add("terms");
        arrayList.add("banner");
        arrayList.add("opensource");
        arrayList.add("portal");
        arrayList.add("consumer");
        arrayList.add("cloudServiceAgreement");
        arrayList.add("clone");
        arrayList.add("robortim");
        arrayList.add("smartrobot");
        arrayList.add("generalconfig");
        arrayList.add("phonefinder");
        arrayList.add("casDomain");
        arrayList.add(Constants.SCHEME_MARKET);
        arrayList.add("uba");
        arrayList.add("termsBase");
        arrayList.add("cbsv3");
        arrayList.add("HIANALYTICS");
        f59353a = Collections.unmodifiableList(arrayList);
    }
}
