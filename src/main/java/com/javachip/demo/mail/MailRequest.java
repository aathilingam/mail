package com.javachip.demo.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author javachip
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailRequest {
    private String from;
    private String to; // comma separated emailIds
    private String subject;
    private String message;
}
