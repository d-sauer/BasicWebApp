package org.basewebapp;

@Deprecated
public class Car {
    public Engine engine;
    
    public String warningMessage;
    
    public String getWarningMessage() {
        return warningMessage;
    }
    
    public void accelerate() {
        engine.increseRmp();
        
        if (engine.getRpm() > 5000)
            setWarningMessage("Slow Down!");
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    public Car(Engine engine) {
        this.engine = engine;
    }
}
