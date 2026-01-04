package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Message;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import p512o7.C11824a;
import p671u7.C13129a;

/* renamed from: t6.h */
/* loaded from: classes2.dex */
public class C12948h extends AbstractC12949i<Message> {
    public C12948h() {
        super(C11824a.m70445b());
    }

    /* renamed from: i */
    public void m77838i(ArrayList<Message> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m77841l(it.next()));
        }
        m77848b("INSERT OR IGNORE INTO t_message(albumId,applicantId,createdTime,expirationTime,messageId,messageType,parameters,receiverId,receiverName,senderId,senderName,read,auditStatus,albumName) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ", arrayList2);
    }

    /* renamed from: j */
    public void m77839j() throws SQLException {
        m77847a("DELETE FROM t_message ", null);
    }

    /* renamed from: k */
    public final ArrayList<Message> m77840k(ArrayList<Message> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Message> arrayList2 = new ArrayList<>();
        C12941a c12941a = new C12941a();
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            if (next != null && next.getExpirationTime() != null && !TextUtils.isEmpty(next.getAlbumId()) && (c12941a.m77726A(next.getAlbumId(), false) != null || next.getMessageType().intValue() == 7)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    /* renamed from: l */
    public final String[] m77841l(Message message) {
        String[] strArr = new String[14];
        strArr[0] = StringUtil.emptyIfBlank(message.getAlbumId());
        strArr[1] = StringUtil.emptyIfBlank(message.getApplicantId());
        strArr[2] = StringUtil.emptyIfBlank(String.valueOf(message.getCreatedTime() == null ? 0L : message.getCreatedTime().m28458c()));
        strArr[3] = StringUtil.emptyIfBlank(String.valueOf(message.getExpirationTime() != null ? message.getExpirationTime().m28458c() : 0L));
        strArr[4] = StringUtil.emptyIfBlank(message.getMessageId());
        strArr[5] = StringUtil.emptyIfBlank(String.valueOf(message.getMessageType() != null ? message.getMessageType().intValue() : 0));
        strArr[6] = StringUtil.emptyIfBlank(new JSONObject(message.getProperties()).toString());
        strArr[7] = StringUtil.emptyIfBlank(message.getReceiverId());
        strArr[8] = StringUtil.emptyIfBlank(message.getReceiverName());
        strArr[9] = StringUtil.emptyIfBlank(message.getSenderId());
        strArr[10] = StringUtil.emptyIfBlank(message.getSenderName());
        strArr[11] = StringUtil.emptyIfBlank(String.valueOf(message.isRead() ? 1 : 0));
        strArr[12] = StringUtil.emptyIfBlank(String.valueOf(message.getAuditStatus()));
        strArr[13] = StringUtil.emptyIfBlank(message.getAlbumName());
        return strArr;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Message mo77732c(Cursor cursor) {
        Message message = new Message();
        message.setAlbumId(cursor.getString(0));
        message.setApplicantId(cursor.getString(1));
        message.setCreatedTime(new C4644l(cursor.getLong(2)));
        message.setExpirationTime(new C4644l(cursor.getLong(3)));
        message.setMessageId(cursor.getString(4));
        message.setMessageType(Integer.valueOf(cursor.getInt(5)));
        message.setProperties(C13129a.m78968i(cursor.getString(6)));
        message.setReceiverId(cursor.getString(7));
        message.setReceiverName(cursor.getString(8));
        message.setSenderId(cursor.getString(9));
        message.setSenderName(cursor.getString(10));
        message.setRead(cursor.getInt(11) == 1);
        message.setAuditStatus(Integer.parseInt(cursor.getString(12)));
        message.setAlbumName(cursor.getString(13));
        return message;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Message mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: o */
    public ArrayList<Message> m77844o() {
        return m77840k(m77851g("SELECT albumId,applicantId,createdTime,expirationTime,messageId,messageType,parameters,receiverId,receiverName,senderId,senderName,read,auditStatus,albumName FROM t_message order by createdTime desc ", null));
    }

    /* renamed from: p */
    public Message m77845p(String str) throws Throwable {
        ArrayList<Message> arrayListM77851g = m77851g("SELECT albumId,applicantId,createdTime,expirationTime,messageId,messageType,parameters,receiverId,receiverName,senderId,senderName,read,auditStatus,albumName FROM t_message WHERE messageId = ? ", new String[]{str});
        Message next = null;
        if (arrayListM77851g != null) {
            Iterator<Message> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        return next;
    }

    /* renamed from: q */
    public void m77846q(boolean z10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m77847a("UPDATE t_message SET read = ? WHERE messageId = ? ", new String[]{String.valueOf(z10 ? 1 : 0), str});
    }
}
