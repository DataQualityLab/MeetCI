package interfaces;

import xml.MachineLearning;

import java.io.IOException;

/**
 * Created by Rathinakumar on 7/11/2015.
 */
public interface Adapter {
    public String trainNeuralNetwork(MachineLearning machineLearning, String saveLocation) throws IOException;
    public void testNeuralNetwork(String savedModel, String testDataFile, String output) throws IOException;
}
