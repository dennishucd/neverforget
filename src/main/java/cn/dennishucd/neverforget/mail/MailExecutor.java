package cn.dennishucd.neverforget.mail;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MailExecutor {
	static ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> sendemail = new Callable<String>() {
			public String call() throws Exception {
				String hello = "send mail success!";
				System.out.println(hello);
				return "执行成功！";
			}
		};

		
		ScheduledFuture<String> ss = ses.schedule(sendemail, 5, TimeUnit.SECONDS);
		System.out.println(ss.get());
	}
}
