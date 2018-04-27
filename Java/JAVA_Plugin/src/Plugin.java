import interfaces.Adapter;
import parser.AdapterFactory;
import parser.MeetCI_XMLParser;
import xess.jess.JessPlugin;
import xml.MachineLearning;
import xml.MeetCI;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Rathinakumar on 7/18/2015.
 */
public class Plugin {
    public static void main(String[] args) throws JAXBException, IOException {
        String xmlFile= args[0];//"src\\examples\\xess_siblings_enhanced.xml";//
        String outputLocation = args[1];//"src\\output";
        File xml = new File(xmlFile);
        String outptut = "";

        MeetCI meetCI = MeetCI_XMLParser.parse(xmlFile);
        if(meetCI.getMachineLearning()!=null) {
            MachineLearning machineLearning = meetCI.getMachineLearning();
            System.out.println(meetCI);
            Adapter adapter = AdapterFactory.getAdapter(machineLearning);
            outptut = adapter.trainNeuralNetwork(machineLearning, outputLocation);
        }
        else if(meetCI.getExpertSystem()!=null)
        {
            JessPlugin jessPlugin = new JessPlugin();
            outptut = jessPlugin.process(xmlFile, outputLocation);
        }

        System.out.println("output generated are stored under: "+ outputLocation);
        //testing
/*        adapter.testNeuralNetwork("C:\\Users\\Rathinakumar\\IdeaProjects\\JavaPlugin\\src\\output\\MLP_1437005328918\\MLP",
                "C:\\Users\\Rathinakumar\\IdeaProjects\\JavaPlugin\\src\\data\\Iris.csv",
                "C:\\Users\\Rathinakumar\\IdeaProjects\\JavaPlugin\\src\\output\\MLP_1437005328918\\testResult.txt");*/

    }
}
