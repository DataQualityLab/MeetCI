import numpy as np
import pickle
import  xml.etree.ElementTree as ET
import meetCI as ml
from sets import Set
from optparse import OptionParser
import os
import subprocess

#parsing the XML file

parser=OptionParser()
parser.add_option("-f", "--file", dest="filename",
                  help="write report to FILE", metavar="FILE")
parser.add_option("-q", "--quiet",
                  action="store_false", dest="verbose", default=True,
                  help="don't print status messages to stdout")
(options, args)=parser.parse_args()

file_name=options.filename

tree=ET.parse(file_name)
root=tree.getroot()

#need to figure out how to parse the xml and then call other stuff
s_MultiLayerPerceptron=Set(['Fann','pyBrain','Neuroph'])
s_RadialBasisFunctionNetwork=Set(['pyBrain','Neuroph'])
s_RecurrentNeuralNetworks=Set(['pyBrain'])
dict_lib={}
dict_lib['classification']=[s_MultiLayerPerceptron | s_RadialBasisFunctionNetwork]
dict_lib['prediction']=[s_RecurrentNeuralNetworks]
dict_lib['expertsystem']=Set(['Jess'])

dict_algorithm={}
dict_algorithm['classification']=['MultiLayerPerceptron','RadialBasisFunctionNetwork']
dict_algorithm['prediction']=['RecurrentNeuralNetwork']
dict_algorithm['expertsystem']=['Jess']              

#dict_all['ExpertSystems']=['Jess']

AI_type=root.find('MachineLearning')

if AI_type is None:
    print 'expertsystem'
    
else:
    
    for child in AI_type:
        problem_type=child.tag


    if problem_type=="classification":
        algorithm=root.find("MachineLearning/classification/algorithm")

        for child in algorithm:
            algorithm_name=child.tag

        if algorithm_name=='RadialBasisFunctionNetwork':
            
            if algorithm_name in dict_algorithm['classification']:
                print dict_lib['classification']
                print '\n'
                response=raw_input('Please type the name of the library which you would like to use for execution: \n')
                if response=='pyBrain':
                    from python.pyBrain.RBF import exec_algo
                    exec_algo(file_name,'OUTPUT')
                    
                elif response=='Neuroph':
                    # subprocess.call('./C/FANN-2.2.0-Source/examples/FANN_MLP_Iris')
                    p=os.popen('java -jar Java'+os.sep+'JavaPlugin.jar '+file_name+' OUTPUT','r')
                elif response=='Fann':
                    subprocess.call('.'+os.sep+'C'+os.sep+'FANN-2.2.0-Source'+os.sep+'examples'+os.sep+'FANN_MLP_Iris')

        elif algorithm_name=='MultiLayerPerceptron':
            if algorithm_name in dict_algorithm['classification']:
                print dict_lib['classification']
                print '\n'
                response=raw_input('Please type the name of the library which you would like to use for execution: \n')
                if response=='pyBrain':
                    from python.pyBrain.MLP import exec_algo
                    exec_algo(file_name,'OUTPUT')
                elif response=='Neuroph':
                    p=os.popen('java -jar Java'+os.sep+'JavaPlugin.jar '+file_name+' OUTPUT','r')
                elif response=='Fann':
                    subprocess.call('.'+os.sep+'C'+os.sep+'FANN-2.2.0-Source'+os.sep+'examples'+os.sep+'FANN_MLP_Iris')

             
    elif problem_type=="prediction":
        print 'hi'
        algorithm=root.find("MachineLearning/prediction/algorithm")
        for child in algorithm:
            algorithm_name=child.tag
            print algorithm_name
        if algorithm_name in dict_algorithm['prediction']:
            print dict_lib['prediction']
            print '\n'
            response=raw_input('Please type the name of the library which you would like to use for execution: \n')
            if response=='pyBrain':
                from python.pyBrain.RNN import exec_algo
                exec_algo(file_name,'OUTPUT')
    
     
             
              
print 'Execution completed'