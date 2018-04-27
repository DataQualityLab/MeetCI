#!/usr/bin/env python

#
# Generated Sat Jul 18 17:11:29 2015 by generateDS.py version 2.16a.
#
# Command line options:
#   ('-o', 'meetCI.py')
#   ('-s', 'meetCI_sub.py')
#
# Command line arguments:
#   meetCI.xsd
#
# Command line:
#   generateDS.py -o "meetCI.py" -s "meetCI_sub.py" meetCI.xsd
#
# Current working directory (os.getcwd()):
#   generateDS-2.16a0
#

import sys
from lxml import etree as etree_

import ??? as supermod

def parsexml_(infile, parser=None, **kwargs):
    if parser is None:
        # Use the lxml ElementTree compatible parser so that, e.g.,
        #   we ignore comments.
        parser = etree_.ETCompatXMLParser()
    doc = etree_.parse(infile, parser=parser, **kwargs)
    return doc

#
# Globals
#

ExternalEncoding = 'ascii'

#
# Data representation classes
#


class MeetCISub(supermod.MeetCI):
    def __init__(self, MachineLearning=None, ExpertSystem=None):
        super(MeetCISub, self).__init__(MachineLearning, ExpertSystem, )
supermod.MeetCI.subclass = MeetCISub
# end class MeetCISub


class MachineLearningSub(supermod.MachineLearning):
    def __init__(self, classification=None, prediction=None):
        super(MachineLearningSub, self).__init__(classification, prediction, )
supermod.MachineLearning.subclass = MachineLearningSub
# end class MachineLearningSub


class MultiLayerPerceptronSub(supermod.MultiLayerPerceptron):
    def __init__(self, inputLayerActivation='Linear', hiddenLayerActivation=None, hiddenLayers=None, outputLayerActivation=None, momentum=None, epochs=None, learningRate=None):
        super(MultiLayerPerceptronSub, self).__init__(inputLayerActivation, hiddenLayerActivation, hiddenLayers, outputLayerActivation, momentum, epochs, learningRate, )
supermod.MultiLayerPerceptron.subclass = MultiLayerPerceptronSub
# end class MultiLayerPerceptronSub


class RadialBasisFunctionNetworkSub(supermod.RadialBasisFunctionNetwork):
    def __init__(self, hiddenNeurons=None, outputLayerActivation=None, momentum=None, epochs=None, learningRate=None):
        super(RadialBasisFunctionNetworkSub, self).__init__(hiddenNeurons, outputLayerActivation, momentum, epochs, learningRate, )
supermod.RadialBasisFunctionNetwork.subclass = RadialBasisFunctionNetworkSub
# end class RadialBasisFunctionNetworkSub


class RecurrentNeuralNetworkSub(supermod.RecurrentNeuralNetwork):
    def __init__(self, RNN_Type=None, hiddenLayerActivation=None, hiddenNeurons=None, outputLayerActivation=None, epochs=None, momentum=None, learningRate=None):
        super(RecurrentNeuralNetworkSub, self).__init__(RNN_Type, hiddenLayerActivation, hiddenNeurons, outputLayerActivation, epochs, momentum, learningRate, )
supermod.RecurrentNeuralNetwork.subclass = RecurrentNeuralNetworkSub
# end class RecurrentNeuralNetworkSub


class RandomForestSub(supermod.RandomForest):
    def __init__(self, nTrees=None, maxDepth=None, maxLeafNodes=None, minSamplesSplit=None, minSamplesLeaf=None, minFractionLeaf=None):
        super(RandomForestSub, self).__init__(nTrees, maxDepth, maxLeafNodes, minSamplesSplit, minSamplesLeaf, minFractionLeaf, )
supermod.RandomForest.subclass = RandomForestSub
# end class RandomForestSub


class SupportVectorMachineSub(supermod.SupportVectorMachine):
    def __init__(self, kernel=None, degree=None, gamma=None, coef=None, tol=None, maxIter=None):
        super(SupportVectorMachineSub, self).__init__(kernel, degree, gamma, coef, tol, maxIter, )
supermod.SupportVectorMachine.subclass = SupportVectorMachineSub
# end class SupportVectorMachineSub


class classificationSub(supermod.classification):
    def __init__(self, datafile=None, input=None, output=None, classes=None, split=None, delimiter=None, algorithm=None):
        super(classificationSub, self).__init__(datafile, input, output, classes, split, delimiter, algorithm, )
supermod.classification.subclass = classificationSub
# end class classificationSub


class predictionSub(supermod.prediction):
    def __init__(self, datafile=None, input=None, output=None, classes=None, split=None, delimiter=None, algorithm=None):
        super(predictionSub, self).__init__(datafile, input, output, classes, split, delimiter, algorithm, )
supermod.prediction.subclass = predictionSub
# end class predictionSub


class clauseTypeSub(supermod.clauseType):
    def __init__(self, extensiontype_=None):
        super(clauseTypeSub, self).__init__(extensiontype_, )
supermod.clauseType.subclass = clauseTypeSub
# end class clauseTypeSub


class greaterThanTypeSub(supermod.greaterThanType):
    def __init__(self, value2=None, value1=None):
        super(greaterThanTypeSub, self).__init__(value2, value1, )
supermod.greaterThanType.subclass = greaterThanTypeSub
# end class greaterThanTypeSub


class greaterThanOrEqualTypeSub(supermod.greaterThanOrEqualType):
    def __init__(self, value2=None, value1=None):
        super(greaterThanOrEqualTypeSub, self).__init__(value2, value1, )
supermod.greaterThanOrEqualType.subclass = greaterThanOrEqualTypeSub
# end class greaterThanOrEqualTypeSub


class lessThanTypeSub(supermod.lessThanType):
    def __init__(self, value2=None, value1=None):
        super(lessThanTypeSub, self).__init__(value2, value1, )
supermod.lessThanType.subclass = lessThanTypeSub
# end class lessThanTypeSub


class lessThanOrEqualTypeSub(supermod.lessThanOrEqualType):
    def __init__(self, value2=None, value1=None):
        super(lessThanOrEqualTypeSub, self).__init__(value2, value1, )
supermod.lessThanOrEqualType.subclass = lessThanOrEqualTypeSub
# end class lessThanOrEqualTypeSub


class equalTypeSub(supermod.equalType):
    def __init__(self, value2=None, value1=None):
        super(equalTypeSub, self).__init__(value2, value1, )
supermod.equalType.subclass = equalTypeSub
# end class equalTypeSub


class notEqualTypeSub(supermod.notEqualType):
    def __init__(self, value2=None, value1=None):
        super(notEqualTypeSub, self).__init__(value2, value1, )
supermod.notEqualType.subclass = notEqualTypeSub
# end class notEqualTypeSub


class betweenTypeSub(supermod.betweenType):
    def __init__(self, max=None, value=None, min=None):
        super(betweenTypeSub, self).__init__(max, value, min, )
supermod.betweenType.subclass = betweenTypeSub
# end class betweenTypeSub


class notBetweenTypeSub(supermod.notBetweenType):
    def __init__(self, max=None, value=None, min=None):
        super(notBetweenTypeSub, self).__init__(max, value, min, )
supermod.notBetweenType.subclass = notBetweenTypeSub
# end class notBetweenTypeSub


class orTypeSub(supermod.orType):
    def __init__(self, clause=None):
        super(orTypeSub, self).__init__(clause, )
supermod.orType.subclass = orTypeSub
# end class orTypeSub


class andTypeSub(supermod.andType):
    def __init__(self, clause=None):
        super(andTypeSub, self).__init__(clause, )
supermod.andType.subclass = andTypeSub
# end class andTypeSub


class factTypeSub(supermod.factType):
    def __init__(self, name=None, extensiontype_=None):
        super(factTypeSub, self).__init__(name, extensiontype_, )
supermod.factType.subclass = factTypeSub
# end class factTypeSub


class predicateTypeSub(supermod.predicateType):
    def __init__(self, name=None, value=None):
        super(predicateTypeSub, self).__init__(name, value, )
supermod.predicateType.subclass = predicateTypeSub
# end class predicateTypeSub


class structTypeSub(supermod.structType):
    def __init__(self, name=None, comment=None, field=None):
        super(structTypeSub, self).__init__(name, comment, field, )
supermod.structType.subclass = structTypeSub
# end class structTypeSub


class instanceTypeSub(supermod.instanceType):
    def __init__(self, name=None, type_=None, comment=None, field=None):
        super(instanceTypeSub, self).__init__(name, type_, comment, field, )
supermod.instanceType.subclass = instanceTypeSub
# end class instanceTypeSub


class actionTypeSub(supermod.actionType):
    def __init__(self, extensiontype_=None):
        super(actionTypeSub, self).__init__(extensiontype_, )
supermod.actionType.subclass = actionTypeSub
# end class actionTypeSub


class setTypeSub(supermod.setType):
    def __init__(self, name=None, value=None):
        super(setTypeSub, self).__init__(name, value, )
supermod.setType.subclass = setTypeSub
# end class setTypeSub


class runRuleTypeSub(supermod.runRuleType):
    def __init__(self, name=None, argument=None):
        super(runRuleTypeSub, self).__init__(name, argument, )
supermod.runRuleType.subclass = runRuleTypeSub
# end class runRuleTypeSub


class ExpertSystemSub(supermod.ExpertSystem):
    def __init__(self, comment=None, fact=None, rule=None):
        super(ExpertSystemSub, self).__init__(comment, fact, rule, )
supermod.ExpertSystem.subclass = ExpertSystemSub
# end class ExpertSystemSub


class algorithmTypeSub(supermod.algorithmType):
    def __init__(self, RadialBasisFunctionNetwork=None, MultiLayerPerceptron=None):
        super(algorithmTypeSub, self).__init__(RadialBasisFunctionNetwork, MultiLayerPerceptron, )
supermod.algorithmType.subclass = algorithmTypeSub
# end class algorithmTypeSub


class algorithmType4Sub(supermod.algorithmType4):
    def __init__(self, RecurrentNeuralNetwork=None):
        super(algorithmType4Sub, self).__init__(RecurrentNeuralNetwork, )
supermod.algorithmType4.subclass = algorithmType4Sub
# end class algorithmType4Sub


class fieldTypeSub(supermod.fieldType):
    def __init__(self, initialValue=None, type_=None, name=None):
        super(fieldTypeSub, self).__init__(initialValue, type_, name, )
supermod.fieldType.subclass = fieldTypeSub
# end class fieldTypeSub


class fieldType5Sub(supermod.fieldType5):
    def __init__(self, name=None, value=None):
        super(fieldType5Sub, self).__init__(name, value, )
supermod.fieldType5.subclass = fieldType5Sub
# end class fieldType5Sub


class argumentTypeSub(supermod.argumentType):
    def __init__(self, name=None, value=None):
        super(argumentTypeSub, self).__init__(name, value, )
supermod.argumentType.subclass = argumentTypeSub
# end class argumentTypeSub


class ruleTypeSub(supermod.ruleType):
    def __init__(self, name=None, comment=None, parameter=None, if_=None, then=None, else_=None):
        super(ruleTypeSub, self).__init__(name, comment, parameter, if_, then, else_, )
supermod.ruleType.subclass = ruleTypeSub
# end class ruleTypeSub


class parameterTypeSub(supermod.parameterType):
    def __init__(self, type_=None, name=None):
        super(parameterTypeSub, self).__init__(type_, name, )
supermod.parameterType.subclass = parameterTypeSub
# end class parameterTypeSub


class ifTypeSub(supermod.ifType):
    def __init__(self, clause=None):
        super(ifTypeSub, self).__init__(clause, )
supermod.ifType.subclass = ifTypeSub
# end class ifTypeSub


class thenTypeSub(supermod.thenType):
    def __init__(self, action=None):
        super(thenTypeSub, self).__init__(action, )
supermod.thenType.subclass = thenTypeSub
# end class thenTypeSub


class elseTypeSub(supermod.elseType):
    def __init__(self, action=None):
        super(elseTypeSub, self).__init__(action, )
supermod.elseType.subclass = elseTypeSub
# end class elseTypeSub


def get_root_tag(node):
    tag = supermod.Tag_pattern_.match(node.tag).groups()[-1]
    rootClass = None
    rootClass = supermod.GDSClassesMapping.get(tag)
    if rootClass is None and hasattr(supermod, tag):
        rootClass = getattr(supermod, tag)
    return tag, rootClass


def parse(inFilename, silence=False):
    parser = None
    doc = parsexml_(inFilename, parser)
    rootNode = doc.getroot()
    rootTag, rootClass = get_root_tag(rootNode)
    if rootClass is None:
        rootTag = 'MeetCI'
        rootClass = supermod.MeetCI
    rootObj = rootClass.factory()
    rootObj.build(rootNode)
    # Enable Python to collect the space used by the DOM.
    doc = None
    if not silence:
        sys.stdout.write('<?xml version="1.0" ?>\n')
        rootObj.export(
            sys.stdout, 0, name_=rootTag,
            namespacedef_='',
            pretty_print=True)
    return rootObj


def parseEtree(inFilename, silence=False):
    parser = None
    doc = parsexml_(inFilename, parser)
    rootNode = doc.getroot()
    rootTag, rootClass = get_root_tag(rootNode)
    if rootClass is None:
        rootTag = 'MeetCI'
        rootClass = supermod.MeetCI
    rootObj = rootClass.factory()
    rootObj.build(rootNode)
    # Enable Python to collect the space used by the DOM.
    doc = None
    mapping = {}
    rootElement = rootObj.to_etree(None, name_=rootTag, mapping_=mapping)
    reverse_mapping = rootObj.gds_reverse_node_mapping(mapping)
    if not silence:
        content = etree_.tostring(
            rootElement, pretty_print=True,
            xml_declaration=True, encoding="utf-8")
        sys.stdout.write(content)
        sys.stdout.write('\n')
    return rootObj, rootElement, mapping, reverse_mapping


def parseString(inString, silence=False):
    from StringIO import StringIO
    parser = None
    doc = parsexml_(StringIO(inString), parser)
    rootNode = doc.getroot()
    rootTag, rootClass = get_root_tag(rootNode)
    if rootClass is None:
        rootTag = 'MeetCI'
        rootClass = supermod.MeetCI
    rootObj = rootClass.factory()
    rootObj.build(rootNode)
    # Enable Python to collect the space used by the DOM.
    doc = None
    if not silence:
        sys.stdout.write('<?xml version="1.0" ?>\n')
        rootObj.export(
            sys.stdout, 0, name_=rootTag,
            namespacedef_='')
    return rootObj


def parseLiteral(inFilename, silence=False):
    parser = None
    doc = parsexml_(inFilename, parser)
    rootNode = doc.getroot()
    rootTag, rootClass = get_root_tag(rootNode)
    if rootClass is None:
        rootTag = 'MeetCI'
        rootClass = supermod.MeetCI
    rootObj = rootClass.factory()
    rootObj.build(rootNode)
    # Enable Python to collect the space used by the DOM.
    doc = None
    if not silence:
        sys.stdout.write('#from ??? import *\n\n')
        sys.stdout.write('import ??? as model_\n\n')
        sys.stdout.write('rootObj = model_.rootClass(\n')
        rootObj.exportLiteral(sys.stdout, 0, name_=rootTag)
        sys.stdout.write(')\n')
    return rootObj


USAGE_TEXT = """
Usage: python ???.py <infilename>
"""


def usage():
    print(USAGE_TEXT)
    sys.exit(1)


def main():
    args = sys.argv[1:]
    if len(args) != 1:
        usage()
    infilename = args[0]
    parse(infilename)


if __name__ == '__main__':
    #import pdb; pdb.set_trace()
    main()
