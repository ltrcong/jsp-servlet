package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;

@WebServlet("/SendEmailController")
public class SendEmailController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public SendEmailController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// Thông tin tài khoản email
        String host = "your_email_host";
        String username = "letrongcong3@gmail.com";
        String password = "11062003cong";
        
        // Thông tin đăng ký tài khoản
        String tenkh = request.getParameter("ten_kh");
        String email = request.getParameter("email_kh");
        
        // Cài đặt các thuộc tính để kết nối với máy chủ email
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        
        // Tạo một phiên làm việc với máy chủ email
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            // Tạo đối tượng MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Thiết lập người gửi và người nhận
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            // Thiết lập tiêu đề và nội dung
            message.setSubject("Registration Successful");
            message.setText("Dear " + tenkh + ",\n\n"
                            + "Thank you for registering. Your account has been successfully created.");

            // Gửi email
            Transport.send(message);

            // Hiển thị thông báo đăng ký thành công
            response.getWriter().println("Registration successful! An email has been sent to " + email);
        } catch (MessagingException e) {
            // Xử lý ngoại lệ nếu gặp lỗi khi gửi email
            e.printStackTrace();
            response.getWriter().println("Error sending email. Please try again later.");
        }
	}

}
