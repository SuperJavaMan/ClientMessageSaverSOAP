package com.messagessaver.clientmessagessaver;

import com.messagessaver.clientmessagessaver.configuration.SOAPConnector;
import com.messagessaver.clientmessagessaver.generated.AddMessageRequest;
import com.messagessaver.clientmessagessaver.generated.GetAllMessagesRequest;
import com.messagessaver.clientmessagessaver.generated.GetAllMessagesResponse;
import com.messagessaver.clientmessagessaver.generated.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClientmessagesaverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientmessagesaverApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Oleg";
            if(args.length>0){
                name = args[0];
            }

            String URL = "http://localhost:8080/api/messages/details";

//            AddMessageRequest addMessageRequest = new AddMessageRequest();
//            Message message = new Message();
//            message.setAuthor("Vasya");
//            message.setBody("Tututu");
//            soapConnector.callWebService(URL, addMessageRequest);

            GetAllMessagesRequest request = new GetAllMessagesRequest();
            GetAllMessagesResponse response = (GetAllMessagesResponse) soapConnector.callWebService(URL, request);
            List<Message> messageList = response.getMessage();
            for (Message msg : messageList) {
                System.out.println(msg.getAuthor());
                System.out.println(msg.getBody());
                System.out.println();
            }
        };
    }
}
