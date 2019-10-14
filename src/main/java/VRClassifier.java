import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.Classifiers;
import com.ibm.watson.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.Classifier;
import com.ibm.watson.visual_recognition.v3.model.ListClassifiersOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VRClassifier {
    private static final String beagle = "C:\\Users\\conno\\Desktop\\College\\DataScience\\VRJava\\src\\main\\resources\\zips\\beagle.zip";
    private static final String goldenRetriever = "C:\\Users\\conno\\Desktop\\College\\DataScience\\VRJava\\src\\main\\resources\\zips\\golden-retriever.zip";
    private static final String husky = "C:\\Users\\conno\\Desktop\\College\\DataScience\\VRJava\\src\\main\\resources\\zips\\husky.zip";
    private static final String cat = "C:\\Users\\conno\\Desktop\\College\\DataScience\\VRJava\\src\\main\\resources\\zips\\cats.zip";

    public static void main(String[] args) throws FileNotFoundException {
        String apikey = "co4lniNrsR7Y6g9VxYuELTf1nKZiwz60ltBuZrpMh4OI";

        IamAuthenticator authenticator = new IamAuthenticator(apikey);
        VisualRecognition service = new VisualRecognition("2018-03-19", authenticator);

        CreateClassifierOptions createClassifierOptions = new CreateClassifierOptions.Builder()
                .name("dogs")
                .addPositiveExamples("beagle", new FileInputStream(beagle))
                .addPositiveExamples("goldenretriever",new FileInputStream(goldenRetriever))
                .addPositiveExamples("husky", new FileInputStream(husky))
                .negativeExamples(new FileInputStream(cat))
                .negativeExamplesFilename("cats")
                .build();

        Classifier dogs = service.createClassifier(createClassifierOptions).execute().getResult();
        System.out.println(dogs);

        System.out.println("==========CLASSIFIERS==========");
        ListClassifiersOptions listClassifiersOptions = new ListClassifiersOptions.Builder()
                .verbose(true)
                .build();
        Classifiers classifiers = service.listClassifiers(listClassifiersOptions).execute().getResult();
        System.out.println(classifiers);
    }
}
