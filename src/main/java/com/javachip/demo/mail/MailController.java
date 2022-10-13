package com.javachip.demo.mail;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author javachip
 */
@Api(tags = {"Email"})
@AllArgsConstructor
@RestController
@RequestMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class MailController {

    private final JavaMailSender mailSender;

    @PostMapping(value = "/send")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> send(@RequestBody final MailRequest request) {
        final MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setFrom(request.getFrom());
            message.addRecipients(MimeMessage.RecipientType.TO, request.getTo());
            message.setContent(request.getMessage(), "text/html");
            message.setSubject(request.getSubject());
        } catch (final MessagingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        mailSender.send(message);
        log.info("Successfully sent email, details={}", request);
        return ResponseEntity.noContent().build();
    }
}