package gui;

/**
 * Created by nofuruct on 22.04.15.
 */
public class ControllerHolder {

    private static Controller controller;

    public static void setController(Controller controller){
        if(ControllerHolder.controller == null){
            ControllerHolder.controller = controller;
        }

    }

    public static Controller getController(){
        return controller;
    }


}
