//
//  ViewController.swift
//  FortuneCookie
//
//  Created by Jared on 10/4/19.
//  Copyright © 2019 Jared. All rights reserved.
//

// ONLINE CODE SOURCES
//https://codewithchris.com/uipickerview-example/
//https://www.youtube.com/watch?v=QozQ3RYlBSA
//
//Fortunes Source:
//https://joshmadison.com/2008/04/20/fortune-cookie-fortunes/


import UIKit
import AVFoundation
import AudioToolbox

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    @IBOutlet weak var cookieButton: UIButton!
    @IBOutlet weak var optionsButton: UIBarButtonItem!
    @IBOutlet weak var shareButton: UIBarButtonItem!

    @IBOutlet weak var luckyNumber: UILabel!
    @IBOutlet weak var fortuneLabel: UILabel!
    
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var pickerView: UIView!
    
    var fortuneType:Int = 0
    var pickerData: [String] = [String]()
    
    var allFortunes:[Fortune] = []
    var lastFortune:Fortune = Fortune("Text","Type")
    
    func loadFortunes(){
        for f in fortuneData{
            //Assign fortune text and type from fortuneData[][] array
            let fortune = Fortune(f[0],f[1])
            allFortunes.append(fortune)
        }
    }
    
    func createFortune(){
        if (!pickerView.isHidden) {
            pickerView.isHidden = true
        }
        
        let number = Int.random(in: 1...64)
        luckyNumber.text = "Lucky Number: " + String(number)
        
        var fortune = allFortunes[Int.random(in: 0...allFortunes.count-1)]
        if (picker.selectedRow(inComponent: 0) != 0 || fortune.fortuneText == lastFortune.fortuneText) {
            var loops = 0
            while ((picker.selectedRow(inComponent: 0) != 0 && fortune.fortuneType != pickerData[picker.selectedRow(inComponent: 0)]) || fortune.fortuneText == lastFortune.fortuneText) {
                fortune = allFortunes[Int.random(in: 0...allFortunes.count-1)]
                loops += 1
            }
            if loops > 100{
                print("While loop error")
                return
            }
        }
        fortuneLabel.text = fortune.fortuneText
        lastFortune = fortune
    }
    
    func playFortuneSound(){
        AudioServicesPlaySystemSound(1109) //Play Sound
        AudioServicesPlaySystemSound(kSystemSoundID_Vibrate) //Vibrate
    }
    
    @IBAction func generateFortune(_ sender: Any) {
        createFortune()
        playFortuneSound()
    }
    
    @IBAction func showOptions(_ sender: Any) {
        if pickerView.isHidden{
            pickerView.isHidden = false
        } else {
            pickerView.isHidden = true
        }
    }
    
    @IBAction func shareFortune(_ sender: Any) {
        if (luckyNumber.text != "Lucky Number: #" && fortuneLabel.text != "Fotune goes here"){
            let endMessage = "\nCreated using FortuneCook"
            let myNumber = "("+luckyNumber.text!+")"
            let activityVC = UIActivityViewController(activityItems:
                [fortuneLabel.text!,myNumber,endMessage], applicationActivities: nil)
            self.present(activityVC, animated: true, completion: nil)
        }
        else {
            //Create UIAlertController
            let alert = UIAlertController(title: "Oops!", message: "Must generate a fortune before sharing", preferredStyle: UIAlertController.Style.alert)
            //Create UIAlertAction for OK and Cancel
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler:
            {action in //Within closures, the broader class must be addressed as self
                self.createFortune()
            })
            alert.addAction(okAction)
            //Display the alert
            present(alert, animated: true, completion: nil)
        }
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        pickerView.isHidden = true
        
        self.picker.delegate = self
        self.picker.dataSource = self
        
        pickerData = allTypes
        
        fortuneType = picker.selectedRow(inComponent: 0)
        
        loadFortunes()
        
    }

    //Picker Delegate Functions
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return pickerData.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return pickerData[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        fortuneType = picker.selectedRow(inComponent: 0)
        print(fortuneType)
    }

}

