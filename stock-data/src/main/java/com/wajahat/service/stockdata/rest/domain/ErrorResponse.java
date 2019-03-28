
package com.wajahat.service.stockdata.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * The type Error response.
 *
 * @author Wajahat Siddiqui
 */
@Builder
@Getter
@AllArgsConstructor
public class ErrorResponse {

    /**
     * Error code
     */
    private Integer code;

    /**
     * Message
     */
    private String message;
}
