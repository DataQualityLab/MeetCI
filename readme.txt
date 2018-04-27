MeetCI software user giude:

	MeetCI is a software framework for executing MachineLearning and ExpertSystem problems 
without conerning about library specific implmentations. Current version of MeetCI supports 
Neuroph -JAVA, pyBrain - Python and FANN - C++. The project also includes a middleware module,
which interacts with the user and deligates the task to the library specific adapter. The adapter
executes the problem in the chosen library and saves the output (trained model for machine Learnning and dump file 
for Expert system problems) in the OUTPUT directory inside the project. Sample datasets and XML problem 
definitions are provided for evaluation purposes.

Download the project:
	Download the project from the link "" and store it in your local disc.
The root directory will be MeetCI, under which the following folders will be present.
C 	 	- contains the source code/executable files for the C++ module
		  (currently support FANN library)
Java 	- contains the source code/executable files for the Java module
		  (currently support Neuroph library)
python 	- contains the source code/executable files for the Python module
		  (currently support pyBrain library)

OUTPUT	- holds the out of each execution (trained model for MachineLearning problem and evaluation dump file for
			the expert system problem)
TrainingFiles - contains sample datasets for machinelearning and expertsystems 
TestingFiles  - contains sample datasets for testing the machine Learning trained models
XMLFiles	  - contains the sample XML (problem description) document for evaluation purposes.

	The rest of the files under MeetCI contribute to the Middelware module.
	
Requirements:
	Once the project is in place, make sure the following language specific requirements are met. 
The main interfacing(middleware) is done in Python and so, the python requirement is mandatory. 
Java and C++ requirements are optional, based on the need for your use (if you dont want to use 
Java libraries, you can skip the process for Java).

requirements for Python:
	
requirements for Java:
	Java 1.7
	JAXB(usually comes with JDK for Java 1.6 and ablove)
	(note: All other libraries are included as part of the project)
	
requirements for C++:


How to run:(written for Windows)

Goto the MeetCI (root) directory and open a command prompt for the location.
The general format of executing the software is given below with user provided data marked between
{}

G:\MachineLearning\MeetCI>python main.py -f {XML file_path}
[Set(['pyBrain', 'Neuroph', 'Fann'])]
Please type the name of the library which you would like to use for execution:
{choose library}
Execution completed

For a concrete example of the same execution,

G:\MachineLearning\MeetCI>python main.py -f XMLfiles\RBF1.xml
[Set(['pyBrain', 'Neuroph', 'Fann'])]


Please type the name of the library which you would like to use for execution:
Neuroph
Execution completed

after this you will find the trained model (for machine learning) or execution dump file (expertsystem)
under MeetCI/OUTPUT directory.


The software is a proof of concept for a library agnostic execution environment. The code base is 
constantly updated.