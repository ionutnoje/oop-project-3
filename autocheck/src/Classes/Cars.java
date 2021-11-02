package Classes;

import java.util.ArrayList;

public class Cars {

    private int _carId;
    private String _model;
    private String _problem;
    private int _status;
    private int _customerId;

    public Cars()
    {

    }

    public Cars(int _carId, String _model, String _problem, int _status, int _customerId)
    {
        this._carId = _carId;
        this._customerId = _customerId;
        this._problem = _problem;
        this._model = _model;
        this._status = _status;

    }


    void set_carId(int carId){
        this._carId = carId;
    }

    int get_carId(){
       return _carId;
    }

    void set_model(String model){
        this._model = model;
    }

    String get_model(){
        return _model;
    }

    void set_problem(String problem){
        this._problem = problem;
    }

    String get_problem(){
        return _problem;
    }

    void set_status(int status){
        this._status = status;
    }

    int get_status(){
        return _status;
    }

    void set_customerId(int customerId){
        this._customerId = customerId;
    }

    int get_customerId(){
        return _customerId;
    }


}
