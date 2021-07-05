package pages;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class GetLinkFromEmail {

  //https://myaccount.google.com/lesssecureapps
  public static String linkFromLetter;

  public static void main(String[] args) {
    String expectedSubject = "is your Issuu verification code";
    String username = "test.job.ak@gmail.com";// change accordingly
    String password = "462Alina9430";// change accordingly


    //Start!
    linkFromLetter = getBodyFromEmail();
    System.err.println("Link from letter: " + linkFromLetter);

  }

  public static String getBodyFromEmail() {
    String expectedSubject = "is your Issuu verification code";
    String user = "test.job.ak@gmail.com";// change accordingly
    String password = "462Alina9430";// change accordingly
    String linkFromLetter = "";
    try {
      Session emailSession = Session.getDefaultInstance(new Properties());
      Store store = emailSession.getStore("imaps");
      store.connect("imap.googlemail.com", 993, user, password);

      Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_WRITE);

      Message[] messages = emailFolder.search(
              new FlagTerm(new Flags(Flags.Flag.SEEN), false));

      System.out.println("messages.length---" + messages.length);

      for (int i = 0, n = messages.length; i < n; i++) {
        Message message = messages[i];
        System.out.println("---------------------------------");
        System.out.println("Email Number " + (i + 1));
        System.out.println("Subject: " + message.getSubject());
        System.out.println("From: " + message.getFrom()[0]);

        message.setFlag(Flags.Flag.SEEN, true);

        String subject = message.getSubject();
        if(subject.contains(expectedSubject)){
          String body = getTextFromMessage(message);
         // linkFromLetter = getLinkFromBody(body);
          linkFromLetter = subject.split(" ")[0];
          break;
        }
      }

      emailFolder.close(false);
      store.close();

    } catch (NoSuchProviderException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("Error");
      e.printStackTrace();
    }
    System.out.println("Here is a code: "+linkFromLetter);
    return linkFromLetter;
  }

  private static String getTextFromMimeMultipart(
          MimeMultipart mimeMultipart)  throws MessagingException, IOException {
    String result = "";
    int count = mimeMultipart.getCount();
    for (int i = 0; i < count; i++) {
      BodyPart bodyPart = mimeMultipart.getBodyPart(i);
      if (bodyPart.isMimeType("text/plain")) {
        result = result + "\n" + bodyPart.getContent();
        break; // without break same text appears twice in my tests
      } else if (bodyPart.isMimeType("text/html")) {
        String html = (String) bodyPart.getContent();
        result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
      } else if (bodyPart.getContent() instanceof MimeMultipart){
        result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
      }
    }
    return result;
  }

  private static String getTextFromMessage(Message message) throws IOException, MessagingException {
    String result = "";
    if (message.isMimeType("text/plain")) {
      result = message.getContent().toString();
    } else if (message.isMimeType("multipart/*")) {
      MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
      result = getTextFromMimeMultipart(mimeMultipart);
    }
    return result;
  }

  private static String getLinkFromBody(String body){
    return Arrays.stream(body.split("[\\n]+"))
            .filter(e ->  new String(e).contains("http"))
            .findFirst()
            .orElse("There is no link");
  }
}
