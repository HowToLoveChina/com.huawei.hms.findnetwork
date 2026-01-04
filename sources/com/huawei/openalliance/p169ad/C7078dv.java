package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.google.flatbuffers.FlatBufferBuilder;
import com.huawei.hms.ads.data.Keyword;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.p169ad.beans.metadata.AdSlot30;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.AppExt;
import com.huawei.openalliance.p169ad.beans.metadata.CellInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Device;
import com.huawei.openalliance.p169ad.beans.metadata.DeviceExt;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.metadata.Network;
import com.huawei.openalliance.p169ad.beans.metadata.Options;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.CachedContent;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.SearchTerm;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ImpEXFb;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.dv */
/* loaded from: classes8.dex */
public class C7078dv {
    /* renamed from: a */
    public static float m42715a(Double d10) {
        if (d10 == null) {
            return -1111.0f;
        }
        return d10.floatValue();
    }

    /* renamed from: b */
    public static int[] m42732b(List<App> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                App app = list.get(i10);
                if (app != null) {
                    iArr[i10] = m42719a(app, flatBufferBuilder);
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: c */
    public static int[] m42734c(List<ImpEX> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                ImpEX impEX = list.get(i10);
                if (impEX != null) {
                    iArr[i10] = ImpEXFb.createImpEXFb(flatBufferBuilder, m42728a(impEX.m40188a(), flatBufferBuilder), m42728a(impEX.m40190b(), flatBufferBuilder));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: d */
    public static int[] m42735d(List<CachedContent> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                CachedContent cachedContent = list.get(i10);
                if (cachedContent != null) {
                    iArr[i10] = C8198vt.m50862a(flatBufferBuilder, m42728a(cachedContent.m40521a(), flatBufferBuilder), m42727a(cachedContent.m40522b()), C8198vt.m50863a(flatBufferBuilder, C7087ec.m42873a(cachedContent.m40523c(), flatBufferBuilder)));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: e */
    private static int[] m42736e(List<CellInfo> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                CellInfo cellInfo = list.get(i10);
                if (cellInfo != null) {
                    iArr[i10] = C8199vu.m50868a(flatBufferBuilder, m42728a(cellInfo.m39876a(), flatBufferBuilder), m42728a(cellInfo.m39878b(), flatBufferBuilder), Constants.FB_NUMBER_DEF, Constants.FB_NUMBER_DEF, 0, cellInfo.m39879c());
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: f */
    private static int[] m42737f(List<Keyword> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                Keyword keyword = list.get(i10);
                if (keyword != null) {
                    iArr[i10] = C8203vy.m50970a(flatBufferBuilder, m42727a(keyword.getType()), m42728a(keyword.getKeyword(), flatBufferBuilder), -1111.0f);
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: a */
    public static float m42716a(Float f10) {
        if (f10 == null) {
            return -1111.0f;
        }
        return f10.floatValue();
    }

    /* renamed from: b */
    public static int[] m42733b(Map<String, Integer> map, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (C7765bl.m47802a(map)) {
            iArr = null;
        } else {
            iArr = new int[map.size()];
            int i10 = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                iArr[i10] = C8193vo.m50793a(flatBufferBuilder, m42728a(entry.getKey(), flatBufferBuilder), m42727a(entry.getValue()));
                i10++;
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: a */
    public static int m42717a(SearchInfo searchInfo, FlatBufferBuilder flatBufferBuilder) {
        if (searchInfo == null) {
            return 0;
        }
        return C8208wc.m50991a(flatBufferBuilder, m42728a(searchInfo.getQuery(), flatBufferBuilder), C8208wc.m50992a(flatBufferBuilder, m42737f(searchInfo.getKeywords(), flatBufferBuilder)), m42728a(searchInfo.getChannel(), flatBufferBuilder), 0);
    }

    /* renamed from: a */
    public static int m42718a(AdSlot30 adSlot30, FlatBufferBuilder flatBufferBuilder) {
        if (adSlot30 == null) {
            return 0;
        }
        return C8195vq.m50809a(flatBufferBuilder, m42728a(adSlot30.m39502a(), flatBufferBuilder), adSlot30.m39508b(), adSlot30.m39512c(), adSlot30.m39515d(), adSlot30.m39518e(), m42727a(adSlot30.m39521f()), 0, m42727a(adSlot30.m39535n()), C8195vq.m50810a(flatBufferBuilder, C7087ec.m42873a(adSlot30.m39536o(), flatBufferBuilder)), C8195vq.m50813b(flatBufferBuilder, m42734c(adSlot30.m39527i(), flatBufferBuilder)), m42727a(adSlot30.m39537p()), m42727a(adSlot30.m39538q()), m42727a(adSlot30.m39539r()), 0, m42727a(adSlot30.m39525h()), m42727a(adSlot30.m39523g()), m42727a(adSlot30.m39529j()), m42727a(adSlot30.m39531k()), m42727a(adSlot30.m39533l()), m42727a(adSlot30.m39534m()), Constants.FB_NUMBER_DEF, Constants.FB_NUMBER_DEF, 0, 0, 0, 0, 0, Constants.FB_NUMBER_DEF, adSlot30.m39543v(), C8195vq.m50815c(flatBufferBuilder, m42735d(adSlot30.m39542u(), flatBufferBuilder)), m42716a(adSlot30.m39544w()), m42728a(adSlot30.m39545x(), flatBufferBuilder), C8195vq.m50817d(flatBufferBuilder, C7087ec.m42873a(adSlot30.m39546y(), flatBufferBuilder)), C8195vq.m50819e(flatBufferBuilder, C7087ec.m42873a(adSlot30.m39541t(), flatBufferBuilder)), m42728a(adSlot30.m39540s(), flatBufferBuilder));
    }

    /* renamed from: a */
    public static int m42719a(App app, FlatBufferBuilder flatBufferBuilder) {
        if (app == null) {
            return 0;
        }
        return C8197vs.m50846a(flatBufferBuilder, m42727a(app.m39712g()), m42728a(app.m39715j(), flatBufferBuilder), m42728a(app.m39697a(), flatBufferBuilder), m42728a(app.m39701b(), flatBufferBuilder), m42728a(app.m39704c(), flatBufferBuilder), m42728a(app.m39706d(), flatBufferBuilder), m42728a(app.m39708e(), flatBufferBuilder), m42728a(app.m39710f(), flatBufferBuilder), m42728a(app.m39714i() == null ? "" : app.m39714i().toString(), flatBufferBuilder), m42728a(app.m39713h(), flatBufferBuilder), m42727a(app.m39716k()), m42728a(app.m39718m(), flatBufferBuilder), m42720a(app.m39717l(), flatBufferBuilder), m42728a(app.m39719n(), flatBufferBuilder));
    }

    /* renamed from: a */
    public static int m42720a(AppExt appExt, FlatBufferBuilder flatBufferBuilder) {
        if (appExt == null) {
            return 0;
        }
        return C8196vr.m50843a(flatBufferBuilder, m42727a(appExt.m39859a()));
    }

    /* renamed from: a */
    public static int m42721a(Device device, FlatBufferBuilder flatBufferBuilder) {
        if (device == null) {
            return 0;
        }
        return C8201vw.m50908a(flatBufferBuilder, m42728a(device.m40098T(), flatBufferBuilder), m42728a(device.m40094P(), flatBufferBuilder), m42728a(device.m40095Q(), flatBufferBuilder), m42728a(device.m40096R(), flatBufferBuilder), m42727a(device.m40099U()), m42727a(device.m40112ab()), device.m40117ag(), device.m40105a(), m42728a(device.m40146n(), flatBufferBuilder), m42728a(device.m40121b(), flatBufferBuilder), m42728a(device.m40125c(), flatBufferBuilder), m42728a(device.m40128d(), flatBufferBuilder), m42728a(device.m40097S(), flatBufferBuilder), m42728a(device.m40100V(), flatBufferBuilder), m42728a(device.m40101W(), flatBufferBuilder), m42728a(device.m40130e(), flatBufferBuilder), device.m40132f(), device.m40134g(), m42728a(device.m40136h(), flatBufferBuilder), 0, m42728a(device.m40138i(), flatBufferBuilder), 0, m42728a(device.m40140j(), flatBufferBuilder), m42728a(device.m40142k(), flatBufferBuilder), 0, device.m40144l(), Constants.FB_NUMBER_DEF, device.m40145m(), m42728a(device.m40147o(), flatBufferBuilder), m42728a(device.m40148p(), flatBufferBuilder), 0, m42728a(device.m40113ac(), flatBufferBuilder), m42728a(device.m40149q(), flatBufferBuilder), 0, 0, m42728a(device.m40151s(), flatBufferBuilder), m42728a(device.m40152t(), flatBufferBuilder), m42728a(device.m40150r(), flatBufferBuilder), m42728a(device.m40154v(), flatBufferBuilder), m42728a(device.m40084F(), flatBufferBuilder), m42728a(device.m40155w(), flatBufferBuilder), m42728a(device.m40156x(), flatBufferBuilder), m42728a(device.m40083E(), flatBufferBuilder), m42728a(device.m40157y(), flatBufferBuilder), m42728a(device.m40158z(), flatBufferBuilder), m42728a(device.m40079A(), flatBufferBuilder), m42728a(device.m40153u(), flatBufferBuilder), m42728a(device.m40080B(), flatBufferBuilder), m42728a(device.m40089K(), flatBufferBuilder), m42728a(device.m40091M(), flatBufferBuilder), m42728a(device.m40081C(), flatBufferBuilder), m42728a(device.m40082D(), flatBufferBuilder), m42728a(device.m40090L(), flatBufferBuilder), m42727a(device.m40092N()), m42727a(device.m40093O()), m42729a(device.m40085G()), m42729a(device.m40086H()), m42729a(device.m40087I()), m42729a(device.m40088J()), 0, 0, 0, m42728a(device.m40104Z(), flatBufferBuilder), C8201vw.m50909a(flatBufferBuilder, C7087ec.m42873a(device.m40102X(), flatBufferBuilder)), C8201vw.m50931b(flatBufferBuilder, m42732b(device.m40118ah(), flatBufferBuilder)), m42727a(device.m40103Y()), m42728a(device.m40111aa() == null ? null : device.m40111aa().toString(), flatBufferBuilder), m42722a(device.m40114ad(), flatBufferBuilder), m42728a(device.m40115ae(), flatBufferBuilder), Constants.FB_NUMBER_DEF, m42727a(device.m40119ai()), Constants.FB_NUMBER_DEF, Constants.FB_NUMBER_DEF, C8201vw.m50934c(flatBufferBuilder, m42732b(device.m40116af(), flatBufferBuilder)), m42728a(device.m40120aj(), flatBufferBuilder));
    }

    /* renamed from: a */
    public static int m42722a(DeviceExt deviceExt, FlatBufferBuilder flatBufferBuilder) {
        if (deviceExt == null) {
            return 0;
        }
        return C8200vv.m50876a(flatBufferBuilder, C8200vv.m50877a(flatBufferBuilder, C7087ec.m42873a(deviceExt.m40159a(), flatBufferBuilder)), m42728a(deviceExt.m40162b(), flatBufferBuilder), m42728a(deviceExt.m40164c(), flatBufferBuilder));
    }

    /* renamed from: a */
    public static int m42723a(Location location, FlatBufferBuilder flatBufferBuilder) {
        if (location == null) {
            return 0;
        }
        return C8202vx.m50962a(flatBufferBuilder, m42729a(location.m40238d()), location.m40241g(), m42715a(location.m40235b()), m42715a(location.m40237c()), Constants.FB_NUMBER_DEF, m42727a(location.m40239e()));
    }

    /* renamed from: a */
    public static int m42724a(Network network, FlatBufferBuilder flatBufferBuilder) {
        if (network == null) {
            return 0;
        }
        return C8204vz.m50975a(flatBufferBuilder, network.m40359a(), Constants.FB_NUMBER_DEF, C8204vz.m50976a(flatBufferBuilder, m42736e(network.m40360b(), flatBufferBuilder)));
    }

    /* renamed from: a */
    public static int m42725a(Options options, FlatBufferBuilder flatBufferBuilder) {
        if (options == null) {
            return 0;
        }
        return C8206wa.m50982a(flatBufferBuilder, m42727a(options.m40372a()), m42727a(options.m40375b()), m42728a(options.m40377c(), flatBufferBuilder));
    }

    /* renamed from: a */
    public static int m42726a(SearchTerm searchTerm, FlatBufferBuilder flatBufferBuilder) {
        if (searchTerm == null) {
            return 0;
        }
        return C8207wb.m50987a(flatBufferBuilder, Constants.FB_NUMBER_DEF, m42728a(searchTerm.m44558a(), flatBufferBuilder));
    }

    /* renamed from: a */
    public static int m42727a(Integer num) {
        return num == null ? Constants.FB_NUMBER_DEF : num.intValue();
    }

    /* renamed from: a */
    public static int m42728a(String str, FlatBufferBuilder flatBufferBuilder) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return flatBufferBuilder.createString(C7087ec.m42868a(str));
    }

    /* renamed from: a */
    public static long m42729a(Long l10) {
        if (l10 == null) {
            return -1111L;
        }
        return l10.longValue();
    }

    /* renamed from: a */
    public static int[] m42730a(List<AdSlot30> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                AdSlot30 adSlot30 = list.get(i10);
                if (adSlot30 != null) {
                    iArr[i10] = m42718a(adSlot30, flatBufferBuilder);
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: a */
    public static int[] m42731a(Map<String, String> map, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (C7765bl.m47802a(map)) {
            iArr = null;
        } else {
            iArr = new int[map.size()];
            int i10 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                iArr[i10] = C8194vp.m50797a(flatBufferBuilder, m42728a(entry.getKey(), flatBufferBuilder), m42728a(entry.getValue(), flatBufferBuilder));
                i10++;
            }
        }
        return C7087ec.m42874a(iArr);
    }
}
