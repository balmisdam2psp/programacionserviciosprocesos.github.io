// Prepare the MimeMessage
Message message = new MimeMessage(mailSession);
// Set From and subject email properties
message.setFrom(new InternetAddress("no-reply@gmail.com"));
message.setSubject("Sending Mail with pure Java Mail API ");

// Set to, cc & bcc recipients        
InternetAddress[] toEmailAddresses = 
        InternetAddress.parse("user1@gmail.com, user2@gmail.com");
InternetAddress[] ccEmailAddresses = 
        InternetAddress.parse("user21@gmail.com, user22@gmail.com");
InternetAddress[] bccEmailAddresses = 
        InternetAddress.parse("user31@gmail.com");
            
message.setRecipients(Message.RecipientType.TO,toEmailAddresses);
message.setRecipients(Message.RecipientType.CC,ccEmailAddresses);
message.setRecipients(Message.RecipientType.BCC,bccEmailAddresses);

/* Mail body with plain Text */
message.setText("Hello User," 
        + "\n\n If you read this, means mail sent with Java Mail API is successful");
