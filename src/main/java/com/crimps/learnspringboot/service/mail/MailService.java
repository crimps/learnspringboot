package com.crimps.learnspringboot.service.mail;

/**
 * Created by crimps on 2017/11/16.
 */
public interface MailService {
    /**
     * 发送简单文本邮件
     * @param to 接收邮件用户
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMain(String to, String subject, String content);

    /**
     * 发送html文本邮件
     * @param to 接收邮件用户
     * @param subject 主题
     * @param content 内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附近邮件
     * @param to 接收邮件用户
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);
}
