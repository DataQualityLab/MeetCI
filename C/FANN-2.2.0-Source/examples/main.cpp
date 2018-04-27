/* 
 * File:   main.cpp
 * Author: Jude Sauer & Ben Miller-Jacobson
 *
 * Created on December 24, 2012, 1:56 AM
 */

#include <cstdlib>
#include <fann.h>
#include <fann_cpp.h>
#include <floatfann.h>

using namespace std;

int test() {
	float calc_out;

	struct fann *ann = fann_create_from_file("fann.net");

	calc_out = fann_test_data(ann, fann_read_train_from_file("/home/user/Desktop/fxcm/EURUSD2011.test")); //test file

	printf("\ntest result: %f\n", calc_out);

	fann_destroy(ann);
	return 0;
}

int main(int argc, char** argv) {
	const unsigned int num_input = 10;
	const unsigned int num_output = 2;
	const unsigned int num_layers = 3; //one hidden layer
	const unsigned int num_neurons_hidden = 5; //adjusted hidden neuron count
	const float desired_error = (const float) 0.02; //98% accuracy
	const unsigned int max_epochs = 500;
	const unsigned int epochs_between_reports = 50; //debug every 50 epochs

	struct fann *ann = fann_create_standard(num_layers, num_input, num_neurons_hidden, num_output);

	fann_set_activation_function_hidden(ann, FANN_SIGMOID_SYMMETRIC);
	fann_set_activation_function_output(ann, FANN_SIGMOID_SYMMETRIC);

	fann_train_on_file(ann, "/home/user/Desktop/fxcm/EURUSD2011.train", max_epochs, epochs_between_reports, desired_error);

	fann_save(ann, "fann.net"); //trained network result file

	fann_destroy(ann);
        
        test(); //test on the trained network

	return 0;
}
