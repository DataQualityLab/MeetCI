import meetCI as ml
import numpy as np
import time
from os import sep, makedirs
from pybrain.structure import FeedForwardNetwork
from pybrain.structure import LinearLayer
from pybrain.structure import GaussianLayer
from pybrain.structure import FullConnection
from pybrain.supervised.trainers import BackpropTrainer
from pybrain.datasets import ClassificationDataSet
from pybrain.utilities import percentError
from pybrain.tools.shortcuts import buildNetwork
import pickle

def exec_algo(xml_file, output_location):
                
        rootObj=ml.parse(xml_file)

        #Getting the root element so that we get the subclasses and its members and member function

        file=open(rootObj.MachineLearning.classification.datafile)

        var_inp=rootObj.MachineLearning.classification.input
        var_out=rootObj.MachineLearning.classification.output
        classes=rootObj.MachineLearning.classification.classes

        DS=ClassificationDataSet(var_inp,var_out,nb_classes=classes)

        for line in file.readlines():
                data=[float(x) for x in line.strip().split(',') if x != '']
                inp=tuple(data[:var_inp])
                output=tuple(data[var_inp:])
                DS.addSample(inp,output)

        split=rootObj.MachineLearning.classification.split
        tstdata,trndata=DS.splitWithProportion(split)
        trdata=ClassificationDataSet(trndata.indim,var_out,nb_classes=classes)
        tsdata=ClassificationDataSet(tstdata.indim,var_out,nb_classes=classes)

        for i in xrange(trndata.getLength()):
            trdata.addSample(trndata.getSample(i)[0],trndata.getSample(i)[1])

        for i in xrange(tstdata.getLength()):
            tsdata.addSample(tstdata.getSample(i)[0],tstdata.getSample(i)[1])


        trdata._convertToOneOfMany()
        tsdata._convertToOneOfMany()

        hiddenNeurons=rootObj.MachineLearning.classification.algorithm.RadialBasisFunctionNetwork.hiddenNeurons
        fnn=FeedForwardNetwork()
        inputLayer=LinearLayer(trdata.indim)
        hiddenLayer=GaussianLayer(hiddenNeurons)
        outputLayer=LinearLayer(trdata.outdim)

        fnn.addInputModule(inputLayer)
        fnn.addModule(hiddenLayer)
        fnn.addOutputModule(outputLayer)

        in_to_hidden=FullConnection(inputLayer,hiddenLayer)
        hidden_to_outputLayer=FullConnection(hiddenLayer,outputLayer)

        fnn.addConnection(in_to_hidden)
        fnn.addConnection(hidden_to_outputLayer)

        fnn.sortModules()
        learningrate=rootObj.MachineLearning.classification.algorithm.RadialBasisFunctionNetwork.learningRate
        momentum=rootObj.MachineLearning.classification.algorithm.RadialBasisFunctionNetwork.momentum
        epochs=rootObj.MachineLearning.classification.algorithm.RadialBasisFunctionNetwork.epochs
        trainer=BackpropTrainer(fnn,dataset=trdata, verbose=True, learningrate=learningrate, momentum=momentum)
        trainer.trainEpochs(epochs=epochs)
        #trainer.train()
        #trainer.trainUntilConvergence(dataset=trdata, maxEpochs=500, verbose=True, continueEpochs=10, validationProportion=0.25)

        trresult=percentError(trainer.testOnClassData(),trdata['class'])

        #testingResult=percentError(trainer.testOnClassData(dataset=tsdata),tsdata['class'])

        #print "Training accuracy : %f , Testing Accuracy: %f" % (100-trresult,100-testingResult)

        print "Training accuracy : %f " % (100-trresult)
        ts=time.time()
        directory = output_location + sep + str(int(ts)) ;
        makedirs(directory)
        fileObject=open(output_location + sep + str(int(ts)) + sep + 'pybrain_RBF','w')
        pickle.dump(trainer,fileObject)
        pickle.dump(fnn,fileObject)
        fileObject.close()