//
//  ViewController.swift
//  Midterm
//
//  Created by Jared on 10/15/19.
//  Copyright © 2019 Jared. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    let avgCarSpeed:Float = 20 //miles per hour
    let avgCarMPG:Float = 24 //miles per gallon
    let avgBikeSpeed:Float = 10
    let avgBusSpeed:Float = 12
    
    
    var vehicleType = 0

    @IBOutlet weak var milesInput: UITextField!
    @IBOutlet weak var monthlySwitch: UISwitch!
    @IBOutlet weak var gallonSlider: UISlider!
    @IBOutlet weak var segControl: UISegmentedControl!
    @IBOutlet weak var tankGallonLabel: UILabel!
    
    @IBOutlet weak var totalTimeLabel: UILabel!
    @IBOutlet weak var totalGasLabel: UILabel!
    
    @IBOutlet weak var vehicleImage: UIImageView!
    
    func Alert(){
        let alert = UIAlertController(title: "Warning", message: "Your commute is over 50 miles", preferredStyle: UIAlertController.Style.alert)
        //Create UIAlertAction for OK and Cancel
        let okAction = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler:
        {action in //Within closures, the broader class must be addressed as self
            
        })
        alert.addAction(okAction)
        //Display the alert
        present(alert, animated: true, completion: nil)

    }
    
    func calculateCommute(){
        if (milesInput.text == nil){
            //ALERT
            return
        }
        if (!monthlySwitch.isOn){
            //Compute for vehicle type
            switch(vehicleType){
            case 0: //Car
                let miles = (milesInput.text! as NSString).floatValue
                let travelTimeHours = (miles / avgCarSpeed)
                let travelTimeMins = (travelTimeHours * 60)
                totalTimeLabel.text = String(format: "%.2f", travelTimeMins) + " mins"
                let remainingGas = gallonSlider.value
                let remainingDist = remainingGas * avgCarMPG
                if (remainingDist < miles){
                    let distDifference = miles - remainingDist
                    let gasNeeded = distDifference / avgCarMPG
                    totalGasLabel.text = String(format: "%.2f", gasNeeded) + " gallons"
                }
                else{
                    totalGasLabel.text = "0.00 gallons"
                }
                break
            case 1: //Bus
                let miles = (milesInput.text! as NSString).floatValue
                let travelTimeHours = (miles / avgBusSpeed)
                let travelTimeMins = (travelTimeHours * 60) + 10
                totalTimeLabel.text = String(format: "%.2f", travelTimeMins) + " mins"
                totalGasLabel.text = "0.00"
                break
            case 2: //Bike
                let miles = (milesInput.text! as NSString).floatValue
                let travelTimeHours = (miles / avgBikeSpeed)
                let travelTimeMins = (travelTimeHours * 60)
                totalTimeLabel.text = String(format: "%.2f", travelTimeMins) + " mins"
                totalGasLabel.text = "0.00"
                break
            default:
                break
            }
            
        }
        else{
            switch(vehicleType){
            case 0:
                let miles = (milesInput.text! as NSString).floatValue * 20
                let travelTimeHours = (miles / avgCarSpeed)//Hours of 20 days of travel
                totalTimeLabel.text = String(format: "%.2f", travelTimeHours) + " hours"
                let remainingGas = gallonSlider.value
                let remainingDist = remainingGas * avgCarMPG
                if (remainingDist < miles){
                    let distDifference = miles - remainingDist
                    let gasNeeded = distDifference / avgCarMPG
                    totalGasLabel.text = String(format: "%.2f", gasNeeded) + " gallons"
                }
                else{
                    totalGasLabel.text = "0.00 gallons"
                }
                break
            case 1:
                let miles = (milesInput.text! as NSString).floatValue
                let travelTimeHours = (miles / avgBusSpeed)
                let travelTimeMins = (travelTimeHours * 60) + 10
                let monthlyHours = (travelTimeMins * 20) / 60
                totalTimeLabel.text = String(format: "%.2f", monthlyHours) + " hours"
                totalGasLabel.text = "0.00"
                break
            case 2:
                let miles = (milesInput.text! as NSString).floatValue * 20
                let travelTimeHours = (miles / avgBikeSpeed)
                totalTimeLabel.text = String(format: "%.2f", travelTimeHours) + " hours"
                totalGasLabel.text = "0.00"
                break
            default:
                break
            }
            
        }

    }
    
    func updateGallons() {
        let gasAmount = gallonSlider.value
        tankGallonLabel.text = "Gas in tank: " + String(format: "%.2f", gasAmount) + " gals"

    }
    
    @IBAction func changeTankGallons(_ sender: UISlider) {
        updateGallons()
        calculateCommute()
    }
    
    @IBAction func showMonthly(_ sender: UISwitch) {
        calculateCommute()
    }
    
    @IBAction func changeVehicleType(_ sender: UISegmentedControl) {
        vehicleType = sender.selectedSegmentIndex
        calculateCommute()
        switch(vehicleType){
        case 0:
            vehicleImage.image = UIImage(named: "car_icon")
            break
        case 1:
            vehicleImage.image = UIImage(named: "bus_icon")
            break
        case 2:
            vehicleImage.image = UIImage(named: "bike_icon")
            break
        default:
            break
        }
    }
    
    @IBAction func commuteButton(_ sender: UIButton) {
        calculateCommute()
        let miles = (milesInput.text! as NSString).floatValue
        if (miles > 50){
            Alert()
        }
    }
    
    override func viewDidLoad() {
        updateGallons()
        
        milesInput.delegate = self
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    //Dismissing Keyboard
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        calculateCommute()
        let miles = (milesInput.text! as NSString).floatValue
        if (miles > 50){
            Alert()
        }
        return true
    }

    
}

