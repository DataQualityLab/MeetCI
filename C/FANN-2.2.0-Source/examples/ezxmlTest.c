#include "ezxml.c"
#include <stdio.h>
#include "fann.h"

int FANN_API test_callback(struct fann *ann, struct fann_train_data *train,
	unsigned int max_epochs, unsigned int epochs_between_reports, 
	float desired_error, unsigned int epochs)
{
	printf("Epochs     %8d. MSE: %.5f. Desired-MSE: %.5f\n", epochs, fann_get_MSE(ann), desired_error);
	return 0;
}

int main() {

	printf("Reading XML.. .. ..\n");
	ezxml_t f1 = ezxml_parse_file("test.xml"), classification, temp, algo, temp2;
	 
	classification = ezxml_child(f1, "classification");
	temp = ezxml_child(classification, "algorithm");
	algo = ezxml_child(temp, "MultiLayerPerceptron");

	const unsigned int num_input = atoi(ezxml_child(classification, "input")->txt);
	const unsigned int num_output = atoi(ezxml_child(classification, "output")->txt);
	const unsigned int num_layers = atoi(ezxml_child(classification, "numberOfLayers")->txt);
	const unsigned int num_neurons_hidden = atoi(ezxml_child(algo, "hiddenNeurons")->txt);
	const float desired_error = (const float) (atof(ezxml_child(algo, "desiredError")->txt));
	const unsigned int max_epochs = atoi(ezxml_child(algo, "maxEpochs")->txt);
	const unsigned int epochs_between_reports = atoi(ezxml_child(algo, "epochsBetweenReports")->txt);

	fann_type *calc_out;
	
	struct fann *ann;
	struct fann_train_data *data;

	unsigned int i = 0;
	unsigned int decimal_point;

	printf("Creating network.\n");
	ann = fann_create_standard(num_layers, num_input, num_neurons_hidden, num_output);

	data = fann_read_train_from_file(ezxml_child(classification, "datafile")->txt);

	fann_set_activation_steepness_hidden(ann, atoi(ezxml_child(algo, "hiddenActivationSteepness")->txt));
	fann_set_activation_steepness_output(ann, atoi(ezxml_child(algo, "outputActivationSteepness")->txt));

	fann_set_activation_function_hidden(ann, FANN_SIGMOID_SYMMETRIC);
	fann_set_activation_function_output(ann, FANN_SIGMOID_SYMMETRIC);
	
	temp2 = ezxml_child(algo, "trainStopFuction");
	const char *stopFunc = temp2->txt;
	if(stopFunc == "FANN_STOPFUNC_BIT"){
		fann_set_train_stop_function(ann, FANN_STOPFUNC_BIT);
	} else {
		fann_set_train_stop_function(ann, FANN_STOPFUNC_MSE);
	}
	fann_set_bit_fail_limit(ann, 0.01f);

	fann_set_training_algorithm(ann, FANN_TRAIN_RPROP);

	fann_init_weights(ann, data);
	
	printf("Training network.\n");
	fann_train_on_data(ann, data, max_epochs, epochs_between_reports, desired_error);

	printf("Testing network. %f\n", fann_test_data(ann, data));

	for(i = 0; i < fann_length_train_data(data); i++)
	{
		calc_out = fann_run(ann, data->input[i]);
		printf("Test Results (%f,%f,%f) -> %f, should be %f, difference=%f\n",
			   data->input[i][0], data->input[i][1], data->input[i][2], calc_out[0], data->output[i][0],
			   fann_abs(calc_out[0] - data->output[i][0]));
	}

	printf("Saving network.\n");

	fann_save(ann, "xor_float.net");

	decimal_point = fann_save_to_fixed(ann, "xor_fixed.net");
	fann_save_train_to_fixed(data, "xor_fixed.data", decimal_point);

	printf("Cleaning up.\n");
	fann_destroy_train(data);
	fann_destroy(ann);

	ezxml_free(f1);

	return 0;
}
