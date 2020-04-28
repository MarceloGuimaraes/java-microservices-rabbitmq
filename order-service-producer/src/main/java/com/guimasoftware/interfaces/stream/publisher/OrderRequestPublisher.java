package com.guimasoftware.interfaces.stream.publisher;

import com.guimasoftware.domain.OrderRequest;
import com.guimasoftware.interfaces.error.ApiException;
import com.guimasoftware.interfaces.stream.Channels;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderRequestPublisher {
    private final Channels channels;

    public void rabbitMQOutput(OrderRequest orderRequest) throws ApiException {
        if (log.isTraceEnabled()) {
            log.trace("OrderRequest Management event '{}' sent!", orderRequest);
        }

        boolean result = channels.orderRequestManagementOutput().send(MessageBuilder.withPayload(orderRequest).build());

        if (!result) {
            throw  ApiException.builder()
                    .code(ApiException.INTEGRATION_ERROR)
                    .reason("Could not publish the message in the specified queue.")
                    .build();
        }
    }
}
