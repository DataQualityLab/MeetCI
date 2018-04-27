package parser;

import interfaces.Adapter;
import neuroph.MLP_Adapter;
import neuroph.RBF_Adapter;
import xml.Classification;
import xml.MachineLearning;

/**
 * Created by Rathinakumar on 7/15/2015.
 */
public class AdapterFactory {

    public static Adapter getAdapter(MachineLearning machineLearning)
    {
        if(machineLearning.getClassification() != null)
        {
            Classification.Algorithm algo = machineLearning.getClassification().getAlgorithm();
            if(algo.getMultiLayerPerceptron()!=null)
            {
                MLP_Adapter mlp = new MLP_Adapter();
                return mlp;
            }
            if(algo.getRadialBasisFunctionNetwork()!=null)
            {
                RBF_Adapter rbf = new RBF_Adapter();
                return rbf;
            }
        }
        return null;
    }
    
}
