package neuroph;

import interfaces.Adapter;
import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.NeuronProperties;
import org.neuroph.util.TransferFunctionType;
import xml.MachineLearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Rathinakumar on 7/11/2015.
 */
public class MLP_Adapter implements Adapter {

    @Override
    public String trainNeuralNetwork(MachineLearning machineLearning, String saveLocation) throws IOException {
        // TODO Auto-generated method stub
        // get the path to file with data
        /*
        	DONE <xs:element name="datafile" type="xs:string"/>
			<xs:element name="input" type="xs:int"/>
			<xs:element name="output" type="xs:int"/>
			<xs:element name="classes" type="xs:int"/>
			<xs:element name="split" type="xs:decimal"/>
			<xs:element name="delimiter" type="xs:string"/>
         */

        xml.Classification xmlClassification = machineLearning.getClassification();
        xml.MultiLayerPerceptron xmlMLP = xmlClassification.getAlgorithm().getMultiLayerPerceptron();



        String inputFileName = xmlClassification.getDatafile();
        inputFileName = (new File(inputFileName)).getAbsolutePath();
        int inputNeurons = xmlClassification.getInput();
        int outputNeurons = xmlClassification.getOutput();
        String hiddenLayers = xmlMLP.getHiddenLayers();

        String delimiter = xmlClassification.getDelimiter();

        double learningRate = Double.parseDouble(xmlMLP.getLearningRate().toString());
        String inputLayerActivation = xmlMLP.getInputLayerActivation().toUpperCase();
        String outputLayerActivation = xmlMLP.getOutputLayerActivation().toUpperCase();
        String hiddenLayerActivation = xmlMLP.getHiddenLayerActivation().toUpperCase();
        int epochs = xmlMLP.getEpochs();

        int classes = xmlClassification.getClasses();
        //double momentum = Double.parseDouble(xmlMLP.getMomentum().toString());


        NeuronProperties inputProperties = new NeuronProperties(),
                outputProperties = new NeuronProperties(),
                hiddenProperties = new NeuronProperties();


        outputProperties.setProperty("transferFunction", TransferFunctionType.valueOf(outputLayerActivation).getTypeClass());
        hiddenProperties.setProperty("transferFunction", TransferFunctionType.valueOf(hiddenLayerActivation).getTypeClass());

        //inputProperties.setProperty("transferFunction", new TransferFunctionType(inputLayerActivation));
        //Layer inputLayer = new Layer(inputNeurons, inputProperties),
          Layer outputLayer = new Layer(outputNeurons, outputProperties);

        // create MultiLayerPerceptron neural network
        MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(TransferFunctionType.valueOf(inputLayerActivation.toUpperCase()), inputNeurons, outputNeurons);
        //neuralNet.addLayer(inputLayer);
        for(String n : hiddenLayers.split(","))
            neuralNet.addLayer(neuralNet.getLayersCount() - 1, new Layer(Integer.parseInt(n), hiddenProperties));
        //neuralNet.addLayer(outputLayer);

        // create training set from file
        DataSet trainDataSet = DataSet.createFromFile(inputFileName, inputNeurons, outputNeurons, delimiter, false);
        // train the network with training set

        neuralNet.getLearningRule().setLearningRate(learningRate);
        neuralNet.getLearningRule().setMaxIterations(epochs);


        neuralNet.learn(trainDataSet);


/*
        System.out.println("Done training.");
        System.out.println("Testing network...");*/
        return saveModel(neuralNet, saveLocation);
    }

    private String saveModel(MultiLayerPerceptron neuralNet, String saveLocation)
    {
        File outputDir = new File(saveLocation+File.separator+System.currentTimeMillis());
        String saveFile = "";
        if(outputDir.mkdir())
        {
            String modelName = "Neuroph_MLP";
            saveFile = outputDir.getAbsolutePath().concat(File.separator + modelName);
            neuralNet.save(saveFile);
            System.out.println("saving to " + saveFile);
        }
        return saveFile;
    }

    public void testNeuralNetwork(String savedModel, String testDataFile, String output) throws IOException {
        File file = new File(savedModel);
        MultiLayerPerceptron model = (MultiLayerPerceptron) NeuralNetwork.load(new FileInputStream(file));
        DataSet testDataSet = DataSet.createFromFile(testDataFile, model.getInputsCount(), model.getOutputsCount(), ",", false);

        FileWriter outputFile = new FileWriter(new File(output));

        for(DataSetRow testSetRow : testDataSet.getRows()) {
            model.setInput(testSetRow.getInput());
            model.calculate();
            double[] networkOutput = model.getOutput();
            outputFile.write("Input: " + Arrays.toString(testSetRow.getInput()) + "\n");
            outputFile.write(" Output: " + Arrays.toString(networkOutput) + "\n");
        }
        outputFile.flush();
    }

}
