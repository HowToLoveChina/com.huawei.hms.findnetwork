package p216d4;

import com.huawei.ads.adsrec.p066db.table.AdCreativeContentRecord;
import com.huawei.ads.adsrec.p066db.table.AdEventRecord;
import com.huawei.ads.adsrec.p066db.table.AdIECImpRecord;
import com.huawei.ads.adsrec.p066db.table.AdSlotMapRecord;
import com.huawei.ads.adsrec.p066db.table.DsContentRelRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import p384j4.AbstractC10707f;

/* renamed from: d4.o */
/* loaded from: classes.dex */
public interface InterfaceC9026o {

    /* renamed from: a */
    public static final String f45665a = "update " + AdSlotMapRecord.class.getSimpleName() + " set adShown=1 where " + SdkCfgSha256Record.PKGNAME + "=? and slotId=? and contentId=?";

    /* renamed from: b */
    public static final String f45666b = "update " + AdSlotMapRecord.class.getSimpleName() + " set adClicked=1 where " + SdkCfgSha256Record.PKGNAME + "=? and slotId=? and contentId=?";

    /* renamed from: c */
    public static final String f45667c;

    /* renamed from: d */
    public static final String f45668d;

    /* renamed from: e */
    public static final String f45669e;

    /* renamed from: f */
    public static final String f45670f;

    /* renamed from: g */
    public static final String f45671g;

    /* renamed from: h */
    public static final String f45672h;

    /* renamed from: i */
    public static final String f45673i;

    /* renamed from: j */
    public static final String f45674j;

    /* renamed from: k */
    public static final String f45675k;

    /* renamed from: l */
    public static final String f45676l;

    /* renamed from: m */
    public static final String f45677m;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("update ");
        sb2.append(AdIECImpRecord.class.getSimpleName());
        sb2.append(" set ");
        sb2.append("showCount");
        sb2.append("=0,");
        sb2.append(ContentRecord.LAST_SHOW_TIME);
        sb2.append("=0,");
        sb2.append("updateTime");
        sb2.append("=?  where ");
        sb2.append("pkgName=? and contentId=?");
        f45667c = sb2.toString();
        f45668d = "select c.* \nfrom (\n    select * \n    from " + AdSlotMapRecord.class.getSimpleName() + " as asmr \n    inner join " + AdCreativeContentRecord.class.getSimpleName() + " as accr \n    on asmr.contentId = accr.contentId\n    where asmr.pkgName=? and asmr.slotId=? and asmr.startTime<=? and asmr.endTime>? \n        and asmr.adShown=? \n) c left outer join " + AdIECImpRecord.class.getSimpleName() + " as aiir \non c.pkgName=aiir.pkgName and c.contentId=aiir.contentId \nwhere (aiir.showCount<? or aiir.showCount is null) and (aiir.lastShowTime<? or aiir.lastShowTime is null) order by c.startTime desc";
        f45669e = "select c.* from (\n    select * from " + AdSlotMapRecord.class.getSimpleName() + " as asmr \n    inner join " + AdCreativeContentRecord.class.getSimpleName() + " as accr \n    on asmr.contentId = accr.contentId\n    where asmr.pkgName=? and asmr.slotId=? and asmr.startTime<=? and asmr.endTime>? \n        and asmr.adClicked=? \n) c left outer join " + AdIECImpRecord.class.getSimpleName() + " as aiir \non c.pkgName=aiir.pkgName and c.contentId=aiir.contentId \nwhere (aiir.showCount<? or aiir.showCount is null) and (aiir.lastShowTime<? or aiir.lastShowTime is null) order by c.startTime desc";
        f45670f = "select c.* from (\n    select * from " + AdSlotMapRecord.class.getSimpleName() + " as asmr \n    inner join " + AdCreativeContentRecord.class.getSimpleName() + " as accr \n    on asmr.contentId = accr.contentId\n    where asmr.pkgName=? and asmr.slotId=? and asmr.startTime<=? and asmr.endTime>? \n) c left outer join " + AdIECImpRecord.class.getSimpleName() + " as aiir \non c.pkgName=aiir.pkgName and c.contentId=aiir.contentId \nwhere (aiir.showCount<? or aiir.showCount is null) and (aiir.lastShowTime<? or aiir.lastShowTime is null) order by random()";
        f45671g = "select c.* from (\n    select * \n    from " + AdSlotMapRecord.class.getSimpleName() + " as asmr \n    inner join " + AdCreativeContentRecord.class.getSimpleName() + " as accr \n    on asmr.contentId=accr.contentId\n    where asmr.pkgName=? and asmr.slotId=? and asmr.startTime<=? and asmr.endTime>? \n        and (asmr.adShown=0 or asmr.adClicked=0) \n) c left outer join " + AdIECImpRecord.class.getSimpleName() + " as aiir \non c.pkgName=aiir.pkgName and c.contentId=aiir.contentId \nwhere (aiir.showCount<? or aiir.showCount is null) and (aiir.lastShowTime<? or aiir.lastShowTime is null) order by c.adShown asc, c.startTime desc";
        f45672h = "select c.* from ( select * \n    from " + AdSlotMapRecord.class.getSimpleName() + " as asmr \n    inner join " + AdCreativeContentRecord.class.getSimpleName() + " as accr \n    on asmr.contentId = accr.contentId\n    where asmr.pkgName=? and asmr.slotId=? and asmr.startTime<=? and asmr.endTime>? \n        and (asmr.adShown=0 or asmr.adClicked=0) \n) c left outer join " + AdIECImpRecord.class.getSimpleName() + " as aiir \non c.pkgName=aiir.pkgName and c.contentId=aiir.contentId \nwhere (aiir.showCount<? or aiir.showCount is null) and (aiir.lastShowTime<? or aiir.lastShowTime is null) order by c.adShown desc, c.startTime desc";
        f45673i = "insert into " + AdIECImpRecord.class.getSimpleName() + "(" + SdkCfgSha256Record.PKGNAME + ",contentId,lastRecallTime,updateTime) values(?,?,?,?);";
        f45674j = "update " + AdIECImpRecord.class.getSimpleName() + " set lastRecallTime=?,updateTime=? where " + SdkCfgSha256Record.PKGNAME + "=? and contentId=?;";
        String strM65380e = AbstractC10707f.m65380e(InterfaceC9029p0.f45681a);
        f45675k = strM65380e;
        f45676l = "select DCR.* from " + DsContentRelRecord.class.getSimpleName() + " as DCR where DCR.updateTime >? and DCR.updateTime <=? and DCR.industryId2nd =? and DCR.dspId =? and exists (select 1 from " + AdEventRecord.class.getSimpleName() + " as AR where AR.contentId = DCR.contentId and AR.clientRequestId = DCR.clientRequestId and AR.eventType in " + strM65380e + ");";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("select DCR.* from ");
        sb3.append(DsContentRelRecord.class.getSimpleName());
        sb3.append(" as DCR where DCR.");
        sb3.append("updateTime");
        sb3.append(" >? and DCR.");
        sb3.append("updateTime");
        sb3.append(" <=? and DCR.");
        sb3.append("dspId");
        sb3.append(" =? and exists (select 1 from ");
        sb3.append(AdEventRecord.class.getSimpleName());
        sb3.append(" as AR where AR.");
        sb3.append("contentId");
        sb3.append(" = DCR.");
        sb3.append("contentId");
        sb3.append(" and AR.");
        sb3.append("clientRequestId");
        sb3.append(" = DCR.");
        sb3.append("clientRequestId");
        sb3.append(" and AR.");
        sb3.append("eventType");
        sb3.append(" in ");
        sb3.append(strM65380e);
        sb3.append(");");
        f45677m = sb3.toString();
    }
}
