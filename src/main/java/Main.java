import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static final String IMAGE_FILE = "C:\\Users\\conno\\Desktop\\College\\DataScience\\VRJava\\src\\main\\resources\\random\\dog.jpg";

    public static void main(String[] args) throws FileNotFoundException {
        String apikey = "co4lniNrsR7Y6g9VxYuELTf1nKZiwz60ltBuZrpMh4OI";
        String version = "2018-03-19";


        IamAuthenticator authenticator = new IamAuthenticator(apikey);
        VisualRecognition service = new VisualRecognition("2018-03-19", authenticator);

        System.out.println("Classify an image");
        ClassifyOptions options = new ClassifyOptions.Builder()
                .imagesFile(new File(IMAGE_FILE)) // replace with path to file
                .build();
        ClassifiedImages result = service.classify(options).execute().getResult();
        System.out.println(result);
    }
}
