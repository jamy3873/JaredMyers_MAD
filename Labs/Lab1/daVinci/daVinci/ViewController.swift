//
//  ViewController.swift
//  daVinci
//
//  Created by Jared Paul Myers on 9/3/19.
//  Copyright © 2019 Jared Myers. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var artwork: UIImageView!
    @IBOutlet weak var label: UILabel!
    let portrait = UIImage(named: "davinci")
    let painting1 = UIImage(named: "painting")
    let painting2 = UIImage(named: "drawing")
    
    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag == 1{
            if artwork.image==portrait{
                artwork.image = painting1
            } else if artwork.image==painting1 {
                artwork.image = painting2
            }
            else {
                artwork.image = portrait
            }
                    }
        else if sender.tag == 2{
            if label.text=="Leonardo daVinci"{
                label.text = "A Renaissance Painter"
            } else {
                label.text = "Leonardo daVinci"
            }
            
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }


}

