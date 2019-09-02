package cn.lqcnb.mall.common.utils.TencentSMSUtils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;

import java.io.IOException;

public class SMSUtils {
    public static String getLoginCode(String tel) {
        return BaseSMS.getSMSCode(tel,
                358891,4);
    }
    public static String getRegisterCode(String tel) {
        return BaseSMS.getSMSCode(tel,
                225482,4);
    }
    public static String getReSetCode(String tel) {
        return BaseSMS.getSMSCode(tel,
                258493,4);
    }
}
