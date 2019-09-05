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
    
    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag == 1{
            artwork.image = UIImage(named: "painting")
        }
        else if sender.tag == 2{
            artwork.image = UIImage(named: "drawing")
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

