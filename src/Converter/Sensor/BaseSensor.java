package Converter.Sensor;

import Converter.Coding.Common.Variable;
import Kwsn.Sensor;
import Pnml.Pnml;
import Pnml.Place;
import Pnml.Transition;

public abstract class BaseSensor {
	/**
	 * 
	 */
	protected String Token;
    /**
     * Buffer variable of sensor
     */
    public Variable buffer;

    /**
     * Queue variable of sensor
     */
    public Variable queue;

    /**
     * Energy of sensor
     */
    public Variable InitiaiEnergy;

    /**
     * Energy consump after sensor working
     */
    public Variable EnergyConsump;

    /**
     * Place input of sensor
     */
    public Place InputPlace;

    /**
     * Place intermediate of sensor
     */
    public Place IntermediatePlace;

    /**
     * Place output of sensor
     */
    public Place OutputPlace;

    /**
     * Generate transition
     */
    public Transition Generate;

    /**
     * Send transition
     */
    public Transition Send;

    /**
     * Process transition
     */
    public Transition Process;

    /**
     * Type of sensor
     */
    public SensorType Type;

    /**
     * Pnml data used to output pnml file
     */
    protected Pnml pnml;

    /**
     * Original sensor information
     */
    protected Sensor sensor;

    /**
     * Abstract method used to convert pnml
     */
    public abstract void convertToPnml ();

    /**
     *
     * @return
     */
    public String getSensorName () {
        return this.sensor.Name;
    }
}
