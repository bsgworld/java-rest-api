/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsg.rest.example;

import com.bsg.rest.HlrClient;
import com.bsg.rest.SmsClient;
import com.bsg.rest.ViberClient;
import com.bsg.rest.api.Balance;
import com.bsg.rest.api.MessageInfo;
import com.bsg.rest.api.PricesData;
import com.bsg.rest.api.hlr.HlrData;
import com.bsg.rest.api.hlr.HlrInfo;
import com.bsg.rest.api.hlr.HlrRequest;
import com.bsg.rest.api.sms.MultipleSmsData;
import com.bsg.rest.api.sms.MultipleSmsRequest;
import com.bsg.rest.api.sms.Phone;
import com.bsg.rest.api.sms.SingleSmsData;
import com.bsg.rest.api.sms.SmsTaskInfo;
import com.bsg.rest.api.viber.Message;
import com.bsg.rest.api.viber.Options;
import com.bsg.rest.api.viber.Recipient;
import com.bsg.rest.api.viber.SenderViber;
import com.bsg.rest.api.viber.ViberMessageData;
import com.bsg.rest.api.viber.ViberMessageRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import org.glassfish.jersey.message.internal.ReaderWriter;

/**
 *
 * @author Razel
 */
public class MainTest {

    public static class LoggingFilter implements ClientResponseFilter {

        private final Logger LOG = Logger.getLogger(LoggingFilter.class.getName());

        @Override
        public void filter(ClientRequestContext request, ClientResponseContext response) throws IOException {
            try (ByteArrayOutputStream responseOutStream = new ByteArrayOutputStream(); InputStream responseStream = response.getEntityStream()) {
                final StringBuilder responseString = new StringBuilder();
                try {
                    ReaderWriter.writeTo(responseStream, responseOutStream);

                    byte[] requestEntity = responseOutStream.toByteArray();
                    if (requestEntity.length == 0) {
                        responseString.append("").append("\n");
                    } else {
                        responseString.append(new String(requestEntity)).append("\n");
                    }
                    response.setEntityStream(new ByteArrayInputStream(requestEntity));

                } catch (IOException ex) {
                }
                LOG.log(Level.INFO, responseString.toString());
            }
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        try (SmsClient smsClient = new SmsClient("YOUR_API_KEY")) {
            //Log response
            smsClient.getJerseyClient().register(new LoggingFilter());
            //Sms prices
            PricesData smsPrices = smsClient.getSmsPrices(9);
            //Multiple sms
            MultipleSmsRequest multipleSmsRequest = new MultipleSmsRequest();
            multipleSmsRequest.setBody("Some text");
            multipleSmsRequest.setOriginator("me");
            multipleSmsRequest.setTariff(null);
            multipleSmsRequest.setValidity(1);
            List<Phone> phones = new ArrayList();
            phones.add(new Phone("79991234567", UUID.randomUUID().toString().substring(0, 13)));
            phones.add(new Phone("79991234568", UUID.randomUUID().toString().substring(0, 13)));
            multipleSmsRequest.setPhones(phones);
            MultipleSmsData data = smsClient.createSms(multipleSmsRequest);
            //Sms info by task id
            SmsTaskInfo smsTaskInfo = smsClient.getSmsTaskInfo(data.getTaskId());
            //Sms info by id
            MessageInfo smsInfo = smsClient.getSmsInfo(data.getSmses().get(0).getId());
            //Sms info by external id
            MessageInfo smsInfo2 = smsClient.getSmsInfoByReference(data.getSmses().get(0).getReference());
            //Single sms
            SingleSmsData singleSms = smsClient.createSms("me", "Some text", "79991234567", UUID.randomUUID().toString().substring(0, 13), 1, null);
        }
        try (ViberClient viberClient = new ViberClient("YOUR_API_KEY")) {
            //Log response
            viberClient.getJerseyClient().register(new LoggingFilter());
            //Viber prices
            PricesData viberPrices = viberClient.getViberPrices(9);
            //Viber message
            ViberMessageRequest viberMessageRequest = new ViberMessageRequest();
            viberMessageRequest.setTariff(null);
            viberMessageRequest.setValidity(1);
            Message message = new Message();
            List<Message> messages = new ArrayList<>();
            viberMessageRequest.setMessages(messages);
            message.setAlphaName("BSG");
            message.setIsPromotional(false);
            message.setText("111");
            message.setOptions(new Options(new SenderViber("1", "1", "1")));
            messages.add(message);
            List<Recipient> recipients = new ArrayList<>();
            Recipient recipient = new Recipient("79991234567", UUID.randomUUID().toString().substring(0, 13));
            recipients.add(recipient);
            message.setRecipients(recipients);
            ViberMessageData createViberMessage = viberClient.createViberMessage(viberMessageRequest);
            //Viber info by id
            MessageInfo viberMessageInfo = viberClient.getViberMessageInfo(createViberMessage.getViberMessages().get(0).getId());
            //Viber info by external id
            MessageInfo viberMessageInfo1 = viberClient.getViberMessageInfoByReference(createViberMessage.getViberMessages().get(0).getReference());
        }
        try (HlrClient restClient = new HlrClient("YOUR_API_KEY")) {
            //Log response
            restClient.getJerseyClient().register(new LoggingFilter());
            //Balance
            Balance balance = restClient.getBalance();
            //Hlr prices
            PricesData hlrPrices = restClient.getHlrPrices(9);
            //Create HLR
            HlrData hlr = restClient.createHlr("380972920000", UUID.randomUUID().toString().substring(0, 13), null, "http://someurl.com/callback");
            //Hlr info by ID
            HlrInfo hlrInfo = restClient.getHlrInfo(hlr.getHlrs().get(0).getId());
            //Hlr info by external ID
            HlrInfo hlrInfo2 = restClient.getHlrInfoByReference(hlr.getHlrs().get(0).getReference());
            //Hlr batch
            List<HlrRequest> hlrRequests = new ArrayList<>();
            hlrRequests.add(new HlrRequest("380972920001", UUID.randomUUID().toString().substring(0, 13), null, "http://someurl.com/callback"));
            hlrRequests.add(new HlrRequest("380972920001", UUID.randomUUID().toString().substring(0, 13), null, "http://someurl.com/callback"));
            HlrData createHlr = restClient.createHlr(hlrRequests);
        }
    }
}
