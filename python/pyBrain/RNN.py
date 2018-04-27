import meetCI as ml
import numpy as np
from os import sep, makedirs
import time
from pybrain.structure import FeedForwardNetwork
from pybrain.structure import LinearLayer
from pybrain.structure import SigmoidLayer
from pybrain.structure import SoftmaxLayer
from pybrain.structure import FullConnection
from pybrain.supervised.trainers import BackpropTrainer
from pybrain.datasets import ClassificationDataSet
from pybrain.utilities import percentError
from pybrain.structure import RecurrentNetwork
import pickle

def  exec_algo(xml_file, output_location):
        rootObj=ml.parse(xml_file)
        file_name=rootObj.MachineLearning.prediction.datafile
        file=open(file_name)
        var_input=rootObj.MachineLearning.prediction.input
        var_output=rootObj.MachineLearning.prediction.output
        var_classes=rootObj.MachineLearning.prediction.classes

        DS=ClassificationDataSet(var_input,var_output,nb_classes=var_classes)
        #DS1=ClassificationDataSet(13,1,nb_classes=10)

        for line in file.readlines():
                data=[float(x) for x in line.strip().split(',') if x != '']
                inp=tuple(data[:var_input])
                output=tuple(data[var_input:])
                DS.addSample(inp,output)

        tstdata,trndata=DS.splitWithProportion(0)
        #trndatatest,tstdatatest=DS1.splitWithProportion(0)

        trdata=ClassificationDataSet(trndata.indim,1,nb_classes=10)
        #tsdata=ClassificationDataSet(DS1.indim,1,nb_classes=10)
        #tsdata1=ClassificationDataSet(DS1.indim,1,nb_classes=10)

        for i in xrange(trndata.getLength()):
                if (trndata.getSample(i)[1][0]!=100):
                        trdata.addSample(trndata.getSample(i)[0],trndata.getSample(i)[1])

        trdata._convertToOneOfMany()
        #tsdata._convertToOneOfMany()
        #tsdata1._convertToOneOfMany()
        print "%d" % (trdata.getLength())

        rnn=RecurrentNetwork()
        inputLayer=LinearLayer(trdata.indim)

        hiddenLayer=rootObj.MachineLearning.prediction.algorithm.RecurrentNeuralNetwork.hiddenLayerActivation
        hiddenNeurons=rootObj.MachineLearning.prediction.algorithm.RecurrentNeuralNetwork.hiddenNeurons

        if  hiddenLayer=='Sigmoid':
                hiddenLayer=SigmoidLayer(hiddenNeurons)
        elif hiddenLayer=='Softmax':
                hiddenLayer=SoftmaxLayer(hiddenNeurons)
        else:
                hiddenLayer=LinearLayer(hiddenNeurons)

        outputLayer=rootObj.MachineLearning.prediction.algorithm.RecurrentNeuralNetwork.outputLayerActivation

        if  outputLayer=='Sigmoid':
               outputLayer=SigmoidLayer(trdata.outdim)
        elif outputLayer=='Softmax':
                outputLayer=SoftmaxLayer(trdata.outdim)
        else:
                outputLayer=LinearLayer(trdata.outdim)

        rnn.addInputModule(inputLayer)
        rnn.addModule(hiddenLayer)
        rnn.addOutputModule(outputLayer)
        rnn_type=rootObj.MachineLearning.prediction.algorithm.RecurrentNeuralNetwork.RNN_Type
        in_to_hidden=FullConnection(inputLayer,hiddenLayer)
        hidden_to_outputLayer=FullConnection(hiddenLayer,outputLayer)
        rnn.addConnection(in_to_hidden)
        rnn.addConnection(hidden_to_outputLayer)

        if rnn_type=='Elman':
                hidden_to_hidden=FullConnection(hiddenLayer,hiddenLayer, name='c3')
                rnn.addRecurrentConnection(hidden_to_hidden)
        #hidden_to_hidden=FullConnection(hiddenLayer,hiddenLayer, name='c3')

        if rnn_type=='Jordan':
                output_to_hidden=FullConnection(outputLayer,hiddenLayer, name='c3')
                rnn.addRecurrentConnection(output_to_hidden)
                


        #rnn.addRecurrentConnection(hidden_to_hidden)
        momentum=rootObj.MachineLearning.prediction.algorithm.RecurrentNeuralNetwork.momentum
        weightdecay=rootObj.MachineLearning.prediction.algorithm.RecurrentNeuralNetwork.learningRate
        rnn.sortModules()
        trainer=BackpropTrainer(rnn,dataset=trdata,momentum=0.1,verbose=True,weightdecay=0.01)
        trainer.train();
        result=(percentError(trainer.testOnClassData(dataset=trdata),trdata['class']))
        #result1=percentError(trainer.testOnClassData(dataset=tsdata1),tsdata1['class'])

        print ('%f \n') % (100-result)
        #print ('%f \n') % (100-result1)

        ts=time.time()
        directory = output_location + sep + str(int(ts))
        makedirs(directory)
        fileObject=open(output_location + sep + str(int(ts)) + sep + 'pybrain_RNN','w')
        pickle.dump(trainer,fileObject)
        pickle.dump(rnn,fileObject)
        fileObject.close()