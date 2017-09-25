package Converter.Sensor;

import Converter.Coding.Common.BaseType;
import Converter.Coding.Common.Variable;
import Kwsn.Sensor;
import Pnml.Pnml;
import Pnml.Place;
import Pnml.Transition;
import Pnml.Arc;
import Pnml.ArcDirection;

public class SinkSensor extends BaseSensor {

    public SinkSensor (Pnml pnml, Sensor sensor) {
        //Initialize all information
        this.pnml = pnml;
        this.sensor = sensor;
        this.sensor.pnmlSensor = this;
        this.buffer = new Variable(BaseType.INT,"Buffer_"+this.sensor.Id,"0");
        this.queue = new Variable(BaseType.INT,"Queue_"+this.sensor.Id,"0");
        this.Type = SensorType.SINk;
    }

    /**
     * Convert sensor to pnml data
     */
    @Override
    public void convertToPnml() {

        this.InputPlace = new Place();
        this.InputPlace.id = "sink_in_"+this.sensor.Id;
        this.InputPlace.token = 0;
        this.InputPlace.label = "Sink input place";

        this.OutputPlace = new Place();
        this.OutputPlace.id = "sink_out_"+this.sensor.Id;
        this.OutputPlace.label = "Sink ouput place";

        this.Process = new Transition();
        this.Process.id = "Process";
        this.Process.label = "Sink process";


        Arc int_process = new Arc();
        int_process.id = "Sink_in";
        int_process.direction = ArcDirection.PLACE_TO_TRANSITION;
        int_process.place = this.InputPlace.id;
        int_process.transition = this.Process.id;
        int_process.weight = 1;

        Arc process_out = new Arc();
        process_out.id = "Sink_out";
        process_out.direction = ArcDirection.TRANSITION_TO_PLACE;
        process_out.place = this.OutputPlace.id;
        process_out.transition = this.Process.id;
        process_out.weight = 1;

        this.pnml.net.places.add(this.InputPlace);
        this.pnml.net.places.add(this.OutputPlace);

        this.pnml.net.transitions.add(this.Process);

        this.pnml.net.arcs.add(int_process);
        this.pnml.net.arcs.add(process_out);
    }
}
