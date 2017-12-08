package de.arbeitsagentur.pi.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import com.havemester.po.module.test.MessageImpl;
import com.havemester.po.module.test.ModuleContextImpl;
import com.havemester.po.module.test.XMLPayloadImpl;
import com.havemester.po.module.utils.DynamicConfigurationHelper;
import com.havemester.po.utils.StreamConversion;

import com.sap.aii.af.lib.mp.module.ModuleContext;
import com.sap.aii.af.lib.mp.module.ModuleData;
import com.sap.engine.interfaces.messaging.api.Message;
import com.sap.engine.interfaces.messaging.api.MessageClass;
import com.sap.engine.interfaces.messaging.api.MessageDirection;
import com.sap.engine.interfaces.messaging.api.MessagePropertyKey;
import com.sap.engine.interfaces.messaging.api.XMLPayload;

import de.arbeitsagentur.pi.af.modules.CashBA.CashBASignature;


public class CashBATest {

	public static void main(String[] args) {
		try {
			CashBASignature CashBA = new CashBASignature();
			
			ModuleContext moduleContext = new ModuleContextImpl(null, null);
			ModuleData    moduleData    = new ModuleData();
			
			Hashtable<String,String> parameters = new Hashtable<String,String>();
			
			
			Message message = new MessageImpl ("SenderParty", "SenderService", "Interface",
					   "ReceiverParty", "ReceiverService",
					   MessageClass.APPLICATION_MESSAGE, MessageDirection.INBOUND,
					   "005056B777881ED491EE4E73A55ACD5D",
					   "SOAP", "");
			
			// get payload from file
			InputStream           is = new FileInputStream(new File("TestDaten/badiv-invalidate.txt"));
//			InputStream           is = new FileInputStream(new File("TestDaten/badiv.txt"));
			ByteArrayOutputStream os = StreamConversion.toByteArrayOutputStream(is);
	
			// set XML payload as the main document of the message
			XMLPayload payload = new XMLPayloadImpl();
			payload.setContent(os.toByteArray(), "UTF-8");
			message.setDocument(payload);
	
			// set message as the module data
			moduleData.setPrincipalData(message);
	
			parameters.put("key", "6b3fb3abef828c7d10b5a905a49c988105621395");
			parameters.put("division", "4711");
			parameters.put("host", "api.barzahlen.de");
//			parameters.put("port", "443");
			parameters.put("method", "POST");
			parameters.put("path", "/v2/slips/slp-d90ab05c-69f2-4e87-9972-97b3275a0ccd");
			parameters.put("query", "?test");

			// set module parameters
			moduleContext = new ModuleContextImpl("ChannelID", parameters);
			
			// process module
			moduleData = CashBA.process(moduleContext, moduleData);
			message = (Message) moduleData.getPrincipalData();
			
			DynamicConfigurationHelper dynamicConfiguration = new DynamicConfigurationHelper(message);

			System.out.println();
			
			System.out.println("Payload: " + message.getDocument().getContentType());
			if (message.getDocument().getText().length() == 0) {
				System.out.println("<Empty payload>");
			} else {
				System.out.println(message.getDocument().getText());
			}
			
			System.out.println();
			System.out.println("Dynamic Configuration:");
			
			for (MessagePropertyKey mpk: dynamicConfiguration.getAll()) {
				System.out.println (mpk.getPropertyNamespace() + " - " + mpk.getPropertyName() + " - " +
						dynamicConfiguration.get(mpk));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
