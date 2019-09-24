//
//  ViewController.swift
//  Lab3
//
//  Created by Jared on 9/23/19.
//  Copyright © 2019 Jared. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var beatlesImage: UIImageView!
    @IBOutlet weak var segControl: UISegmentedControl!
    @IBOutlet weak var capSwitch: UISwitch!
    @IBOutlet weak var colorSwitch: UISwitch!
    @IBOutlet weak var fontLabel: UILabel!
    
    func updateInfo(){
        if segControl.selectedSegmentIndex==0{
            titleLabel.text = "Young Beatles"
            beatlesImage.image = UIImage(named: "beatles1")
        }
        else if segControl.selectedSegmentIndex==1{
            titleLabel.text = "Not so young Beatles"
            beatlesImage.image = UIImage(named: "beatles2")
        }
    }
    
    func updateCaps(){
        if capSwitch.isOn { titleLabel.text=titleLabel.text?.uppercased()
        } else { titleLabel.text=titleLabel.text?.lowercased()
        }
    }
    
    func updateColor(){
        if colorSwitch.isOn { titleLabel.textColor = UIColor.red
        } else { titleLabel.textColor = UIColor.black
        }
    }
    
    @IBAction func changeHeader(_ sender: UISegmentedControl) {
        updateInfo()
        updateCaps()
    }
    
    @IBAction func capitalize(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func changeColor(_ sender: UISwitch) {
        updateColor()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize = sender.value
        fontLabel.text = String(format: "%.0f", fontSize)
        let fontSizeCGFloat = CGFloat(fontSize)
        titleLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

