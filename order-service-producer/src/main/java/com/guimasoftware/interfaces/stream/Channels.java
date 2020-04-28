package com.guimasoftware.interfaces.stream;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {

    String ORDER_REGISTRATION_CHANNEL = "orderRegistrationChannel";

    @Output(Channels.ORDER_REGISTRATION_CHANNEL)
    MessageChannel orderRequestManagementOutput();
}
