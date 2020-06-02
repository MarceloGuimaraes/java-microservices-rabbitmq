package com.guimasoftware.application;

import com.guimasoftware.domain.OrderRequest;
import com.guimasoftware.interfaces.error.ApiErrorMessage;
import com.guimasoftware.interfaces.error.ApiException;
import com.guimasoftware.interfaces.error.GenericApiException;
import com.guimasoftware.interfaces.stream.publisher.OrderRequestPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderRequestService {

    private final OrderRequestPublisher publisher;

    private static final String ERROR_QUEUE_SENDING = "Error sending message to queue";

    public void auditToQueue(OrderRequest orderRequest) {
        try {
            //Send message to queue.
            publisher.rabbitMQOutput(orderRequest);

        } catch (ApiException ex) {
            String errorMessage = String.format("%s: %s", ERROR_QUEUE_SENDING, ex.getMessage());
            log.error(errorMessage, ex);

            throw GenericApiException.builder()
                    .statusCode(HttpStatus.BAD_GATEWAY)
                    .message(errorMessage)
                    .reason(ApiErrorMessage.UNKNOWN_ERROR)
                    .build();
        } catch (Exception ex) {
            throw GenericApiException
                    .builder()
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ApiErrorMessage.UNKNOWN_ERROR)
                    .build();
        }
    }
}
