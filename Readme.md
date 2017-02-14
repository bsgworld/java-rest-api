# com.bsg.rest

Библиотека позволяет работать с REST сервисом BSG. Поддерживается автоматическая сериализация/десериализация в Java объекты

## Requirements

Java 1.7+	

## Installation

Эта библиотека сопровождается файлом pom.xml, что позволяет использовать Maven для его инсталляции в локальный репозиторий.

mvn install:install-file -Dfile=RestClient-1.0.jar

Так же можно установить его, загрузив исходные коды пакета в виде Zip архива или клонировав этот репозиторий. Все компоненты этой библиотеки загружают зависимости автоматически.

Для использования библиотеки необходимо добавить в pom.xml dependencies

        <dependency>
            <groupId>com.bsg</groupId>
            <artifactId>RestClient</artifactId>
            <version>1.0</version>
        </dependency>
		
## Dependencies

* https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations 2.8.6+
* https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind 2.8.6+
* https://mvnrepository.com/artifact/org.glassfish.jersey.core/jersey-client 2.25+
* https://mvnrepository.com/artifact/org.glassfish.jersey.media/jersey-media-json-jackson 2.25+

## Example

```java
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
```

## Support

Если у вас возникли сложности или вопросы по использованию пакета, создайте обсуждение в данном репозитории или напишите на электронную почту.

## Documentation	

Документацию API можно получить из исходных кодов пакета
