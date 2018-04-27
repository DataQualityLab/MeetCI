#include "fann.h"

int main()
{
    const unsigned int num_input = 2;
    const unsigned int num_output = 1;
    const unsigned int num_layers = 3;
    const unsigned int num_neurons_hidden = 3;
    const float desired_error = (const float) 0.001;
    const unsigned int max_epochs = 500000;
    const unsigned int epochs_between_reports = 1000;
    struct fann_train_data *data;
    unsigned int decimal_point;

    struct fann *ann = fann_create_standard(num_layers, num_input, num_neurons_hidden, num_output);

    fann_set_activation_function_hidden(ann, FANN_SIGMOID_SYMMETRIC);
    fann_set_activation_function_output(ann, FANN_SIGMOID_SYMMETRIC);

    fann_train_on_file(ann, "xor.data", max_epochs, epochs_between_reports, desired_error);

    fann_save(ann, "xor_float.net");

    decimal_point = fann_save_to_fixed(ann, "xor_fixed.net");
    data = fann_read_train_from_file("xor.data");
    fann_save_train_to_fixed(data, "xor_fixed.data", decimal_point);

    fann_destroy(ann);

    return 0;
}
