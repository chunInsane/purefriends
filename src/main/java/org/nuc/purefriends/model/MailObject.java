package org.nuc.purefriends.model;

/**
 * Created by zhangliang on 15/11/13.
 */
public class MailObject {

    private String subject;
    private String body;
    private String toAddresses;//逗号分隔符地址列表
    private String ccAddresses;
    private String hostname;
    private MailAuthentication mailAuthentication;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getToAddresses() {
        return toAddresses;
    }

    public void setToAddresses(String toAddresses) {
        this.toAddresses = toAddresses;
    }

    public String getCcAddresses() {
        return ccAddresses;
    }

    public void setCcAddresses(String ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    public MailAuthentication getMailAuthentication() {
        return mailAuthentication;
    }

    public void setMailAuthentication(MailAuthentication mailAuthentication) {
        this.mailAuthentication = mailAuthentication;
    }

    public static class MailAuthentication {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
