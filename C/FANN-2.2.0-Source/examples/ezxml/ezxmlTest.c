#include "ezxml.c"

int main() {

	printf("Reading XML.. .. ..\n");
	ezxml_t f1 = ezxml_parse_file("test.xml"), classification, temp, algo, temp2;
	 
	classification = ezxml_child(f1, "classification");
	
	temp = ezxml_child(classification, "datafile");
	printf("Datafile is ");	
	printf("%s", temp->txt);
	printf("\n");

	temp = ezxml_child(classification, "input");
	printf("I/P is ");	
	printf("%s", temp->txt);
	printf("\n");

	temp = ezxml_child(classification, "output");
	printf("O/P is ");	
	printf("%s", temp->txt);
	printf("\n");

	temp = ezxml_child(classification, "numberOfLayers");
	printf("# of Neurons is ");	
	printf("%s", temp->txt);
	printf("\n");

	temp = ezxml_child(classification, "algorithm");
	algo = ezxml_child(temp, "MultiLayerPerceptron");
	temp2 = ezxml_child(algo, "hiddenLayerActivation");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "hiddenActivationSteepness");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "outputLayerActivation");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "outputActivationSteepness");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "trainStopFuction");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "hiddenNeurons");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "desiredError");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "maxEpochs");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	temp2 = ezxml_child(algo, "epochsBetweenReports");
	printf("Activation Func. is ");	
	printf("%s", temp2->txt);
	printf("\n");

	ezxml_free(f1); 

	return 0;
}
