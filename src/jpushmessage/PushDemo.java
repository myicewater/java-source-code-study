package jpushmessage;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
/**
 * 利用激光推送的demo，简单易操作
 * @author 朱素海
 *
 */
public class PushDemo {

	public static void main(String[] args) throws APIConnectionException, APIRequestException {
		// TODO Auto-generated method stub

		JPushClient pc = new JPushClient("8bb496ee3e861eab7fff7a4b", "01ab60d2477b0e0367590e11");
		//推送消息
		//PushResult pr = pc.sendMessageAll("推送消息测试，锄禾日当区");
		//推送通知
		//PushResult pr = pc.sendNotificationAll("旱地和稀土");
		
		PushResult pr = pc.sendPush("日照香炉生紫烟");
		System.out.println(pr.toString());
		if(pr.isResultOK()){
			System.out.println("推送成功！");
		}else{
			System.out.println("推送失败");
		}
		
		
	}

}
