import meetCI as ml
import numpy as np
from os import pathsep
from os import sep, makedirs
from pybrain.structure import FeedForwardNetwork
from pybrain.structure import LinearLayer
from pybrain.structure import SigmoidLayer
from pybrain.structure import SoftmaxLayer
from pybrain.structure import FullConnection
from pybrain.supervised.trainers import BackpropTrainer
from pybrain.datasets import ClassificationDataSet
from pybrain.utilities import percentError
from pybrain.tools.shortcuts import buildNetwork
import pickle
import time

def exec_algo(xml_file, output_location):
    rootObj=ml.parse(xml_file)
                     
        #Getting the root element so that we get the subclasses and its members and member function
    xmlParamDetails = rootObj.MachineLearning.classification


        #Gather param values from the XML parsed object
    file=open(xmlParamDetails.datafile)
    var_inp=xmlParamDetails.input
    var_out=xmlParamDetails.output
    classes=xmlParamDetails.classes
    split=xmlParamDetails.split
    learningrate=xmlParamDetails.algorithm.MultiLayerPerceptron.learningRate
    momentum=xmlParamDetails.algorithm.MultiLayerPerceptron.momentum
    epochs=xmlParamDetails.algorithm.MultiLayerPerceptron.epochs
    hiddenNeurons=int(xmlParamDetails.algorithm.MultiLayerPerceptron.hiddenLayers)
    hiddenLayer=xmlParamDetails.algorithm.MultiLayerPerceptron.hiddenLayerActivation
    outputLayer=xmlParamDetails.algorithm.MultiLayerPerceptron.outputLayerActivation
    delimiter=xmlParamDetails.delimiter

    DS=ClassificationDataSet(var_inp,var_out,nb_classes=classes)

    for line in file.readlines():
                data=[float(x) for x in line.strip().split(',') if x != '']
                inp=tuple(data[:var_inp])
                output=tuple(data[var_inp:])
                DS.addSample(inp,output)


    tstdata,trndata=DS.splitWithProportion(split)
    trdata=ClassificationDataSet(trndata.indim,var_out,nb_classes=classes)
    tsdata=ClassificationDataSet(tstdata.indim,var_out,nb_classes=classes)

    for i in xrange(trndata.getLength()):
            trdata.addSample(trndata.getSample(i)[0],trndata.getSample(i)[1])

    for i in xrange(tstdata.getLength()):
            tsdata.addSample(tstdata.getSample(i)[0],tstdata.getSample(i)[1])


    trdata._convertToOneOfMany()
    tsdata._convertToOneOfMany()



     
    fnn=FeedForwardNetwork()
    inputLayer=LinearLayer(trdata.indim)

        
    if  hiddenLayer=='Sigmoid':
            hiddenLayer=SigmoidLayer(hiddenNeurons)
    elif hiddenLayer=='Softmax':
            hiddenLayer=SoftmaxLayer(hiddenNeurons)
    else:
            hiddenLayer=LinearLayer(hiddenNeurons)



    if  outputLayer=='Sigmoid':
           outputLayer=SigmoidLayer(trdata.outdim)
    elif outputLayer=='Softmax':
            outputLayer=SoftmaxLayer(trdata.outdim)
    else:
            outputLayer=LinearLayer(trdata.outdim)

    fnn.addInputModule(inputLayer)
    fnn.addModule(hiddenLayer)
    fnn.addOutputModule(outputLayer)

    in_to_hidden=FullConnection(inputLayer,hiddenLayer)
    hidden_to_outputLayer=FullConnection(hiddenLayer,outputLayer)
    fnn.addConnection(in_to_hidden)
    fnn.addConnection(hidden_to_outputLayer)
    fnn.sortModules()


    trainer=BackpropTrainer(fnn,dataset=trdata, verbose=True, learningrate=learningrate, momentum=momentum)
    trainer.trainEpochs(epochs=epochs)

    trresult=percentError(trainer.testOnClassData(),trdata['class'])

    print("Training accuracy : %f " % (100-trresult))

    ts=time.time()
    directory = output_location + sep + str(int(ts))
    makedirs(directory)
    fileObject=open(output_location + sep + str(int(ts)) + sep + 'pybrain_MLP','w')
    pickle.dump(trainer,fileObject)
    pickle.dump(fnn,fileObject)
    fileObject.close()