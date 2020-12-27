package com.voicecall;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

/*
 * Voice call application using Twilio services: https://www.twilio.com/
 * using three account parameters Account SID, Auth ID, and twilio number
 * http://demo.twilio.com/docs/voice.xml just demo account URL can be replaced with real one
 */

@SpringBootApplication
public class VoicecallApplication implements ApplicationRunner {

	private final static String SIP_URL = "http://demo.twilio.com/docs/voice.xml";

	public static void main(String[] args) {
		SpringApplication.run(VoicecallApplication.class, args);
	}
	
	
	// InIT method for Twilio

	static {
		Twilio.init(ConstStrings.getAccountSid(), ConstStrings.getAuthId());
	}
	
	// Runner method implemented from ApplicationRunner

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Call.creator(new PhoneNumber(ConstStrings.getToNumber()), new PhoneNumber(ConstStrings.getFromNumber()),
				new URI(SIP_URL)).create();

	}

}
