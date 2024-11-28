package designpattern.creational.factory;

public class TataCarFactory {
    private TataCarFactory(){

    }
    public static TataCar getInstance(String carType){
        if(carType != null){
            if( carType.equals("EVCar")){
                return new EVCar();
            }
            if(carType.equals("DieselCar")){
                return new DieselCar();
            }
        }

        return null;

    }
}
