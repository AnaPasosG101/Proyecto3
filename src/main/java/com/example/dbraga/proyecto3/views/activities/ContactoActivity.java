package com.example.dbraga.proyecto3.views.activities;

import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dbraga.proyecto3.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {

    //Espacio para correo de Gmail y contraseña
    private static final String EMAIL_SEND="*********";
    private static final String PASSWD_SEND="********";

    private TextInputEditText emailPetitionTIET, msgPetitionTIET;
    private Button enviarComentarioButton;

    private Session session;

    private String email ;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        emailPetitionTIET = (TextInputEditText)findViewById(R.id.email_petition);
        msgPetitionTIET = (TextInputEditText)findViewById(R.id.msg_petition);

        enviarComentarioButton = (Button) findViewById(R.id.enviarComentarioButton);
        enviarComentarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailPetitionTIET.getText().toString();
                msg = msgPetitionTIET.getText().toString();




                StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.user", EMAIL_SEND);
                properties.put("mail.transport.protocol","smtp");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.debug", "true");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");
                properties.put("mail.smtp.socketFactory.fallback", "false");

                session=Session.getDefaultInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_SEND,PASSWD_SEND);
                    }
                });

                if (session!=null){
                    session.setDebug(true);
                    Message message = new MimeMessage(session);
                    try {
                        message.setFrom(new InternetAddress(EMAIL_SEND));
                        message.setSubject("No response");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                        message.setText(msg);
                        Transport.send(message);


                    } catch (MessagingException e) {
                        if(e.getMessage()!=null)
                        Log.d("Dbra",e.getMessage());

                    }


                }

            }
        });


    }
}
