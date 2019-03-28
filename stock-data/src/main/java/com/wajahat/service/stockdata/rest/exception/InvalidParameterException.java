/**
 * Project: Quaduron
 *
 * Copyright (c) 2017 DMC R&D Center, SAMSUNG ELECTRONICS Co.,LTD.
 * (Maetan dong)129, Samsung-ro Yeongtong-gu, Suwon-si. Gyeonggi-do 443-742, Korea
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Samsung Electronics, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you entered
 * into with Samsung Electronics.
 */

package com.wajahat.service.stockdata.rest.exception;

/**
 * The type Invalid parameter exception.
 *
 * @author Wajahat Siddiqui
 */
public class InvalidParameterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Invalid parameter exception.
     * @param message - the message to be presented
     */
    public InvalidParameterException(String message) {
        super(message);
    }
}
