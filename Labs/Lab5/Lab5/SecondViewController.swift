//
//  SecondViewController.swift
//  Lab5
//
//  Created by Jared on 10/17/19.
//  Copyright © 2019 Jared. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet weak var itemText: UITextField!
    @IBOutlet weak var priceText: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneItem" {
            let scene = segue.destination as! ViewController
            if (!itemText.text!.isEmpty && !priceText.text!.isEmpty) {
                scene.list.items.append([itemText.text!,priceText.text!])
            }
            else {
                
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        itemText.delegate = self
        priceText.delegate = self
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
}
