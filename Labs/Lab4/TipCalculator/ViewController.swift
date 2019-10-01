//
//  ViewController.swift
//  TipCalculator
//
//  Created by Jared on 9/26/19.
//  Copyright © 2019 Jared. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var checkAmount: UITextField!
    @IBOutlet weak var tipPercent: UITextField!
    @IBOutlet weak var peopleLabel: UILabel!
    @IBOutlet weak var peopleStepper: UIStepper!
    @IBOutlet weak var tipDue: UILabel!
    @IBOutlet weak var totalDue: UILabel!
    @IBOutlet weak var totalPerPerson: UILabel!
    
    @IBAction func updatePeople(_ sender: UIStepper) {
        if peopleStepper.value==1 {
            peopleLabel.text = "1 person"
        } else {
            peopleLabel.text = String(format: "%.0f", peopleStepper.value) + " people"
        }
        updateTipTotals()
    }
    
    func updateTipTotals() {
        var amount: Float
        var pct: Float
        
        //Get check and tip values
        if checkAmount.text!.isEmpty {
            amount = 0.0
        } else {
            amount = Float(checkAmount.text!)!
        }
        if tipPercent.text!.isEmpty {
            pct = 0.0
        } else {
            pct = Float(tipPercent.text!)!/100
        }
        
        //Calculate total and total per person
        let numberOfPeople = peopleStepper.value
        let tip = amount * pct
        let total = amount + tip
        var personTotal: Float = 0.0
        if numberOfPeople > 0 {
            personTotal = total / Float(numberOfPeople)
        } else { //Handle 0 person error
            //Create UIAlertController
            let alert = UIAlertController(title: "Warning", message: "The number of people must be greater than 0", preferredStyle: UIAlertController.Style.alert)
            //Create UIAlertAction for OK and Cancel
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler:
                {action in //Within closures, the broader class must be addressed as self
                self.peopleStepper.value = 1
                self.peopleLabel.text? = "1 person"
                self.updateTipTotals()
            })
            alert.addAction(okAction)
            //Display the alert
            present(alert, animated: true, completion: nil)
        }
        
        //Format results as currency strings
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle = NumberFormatter.Style.currency
        tipDue.text = currencyFormatter.string(from: NSNumber(value: tip))
        totalDue.text = currencyFormatter.string(from: NSNumber(value: total))
        totalPerPerson.text = currencyFormatter.string(from: NSNumber(value: personTotal))
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTipTotals()
    }

    override func viewDidLoad() {
        
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        checkAmount.delegate = self
        tipPercent.delegate = self
    }


}

