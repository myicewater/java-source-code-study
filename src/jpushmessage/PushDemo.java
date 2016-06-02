package jpushmessage;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
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
		
		//PushResult pr = pc.sendPush("日照香炉生紫烟");
	
		
		//PushPayload pushPayload = PushPayload.alertAll("新的世界");
		
		Notification notification = Notification.newBuilder()
				.addPlatformNotification(AndroidNotification.newBuilder().setAlert("android alert谈谈谈").setTitle("android端的标题").setBuilderId(1).build())
				.addPlatformNotification(IosNotification.newBuilder().setAlert("ios 端的谈谈谈").setBadge(2).setSound("didi").setContentAvailable(true).build())
				.build();
				
				
		
		PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("18311494736"))
                .setNotification(notification)
                .build();
		
		System.out.println(pushPayload.toJSON());
		PushResult pr = pc.sendPush(pushPayload);
				
		
		System.out.println(pr.toString());
		if(pr.isResultOK()){
			System.out.println("推送成功！");
		}else{
			System.out.println("推送失败");
		}
		
		
	}

}
