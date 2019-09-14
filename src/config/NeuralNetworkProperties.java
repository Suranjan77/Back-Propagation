package config;

/**
 * Configuration Properties and Constants describing Neural Network
 *
 * @author Suranjan Poudel
 */
public interface NeuralNetworkProperties {
    double LEARNING_RATE=0.001;
    int NUMBER_OF_LAYERS=3;
    int INPUT_LAYER_NODES=2;
    int HIDDEN_LAYER_NODES=5;
    int OUTPUT_LAYER_NODES=2;
    int NUMBER_OF_EPOCHS=100;
}
