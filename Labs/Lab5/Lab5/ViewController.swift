//
//  ViewController.swift
//  Lab5
//
//  Created by Jared on 10/17/19.
//  Copyright © 2019 Jared. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var shoppingListLabel: UILabel!
    
    var list = ShoppingList()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func unwindSegue(_ segue:UIStoryboardSegue){
        shoppingListLabel.text = ""
        for i in 0..<list.items.count {
            shoppingListLabel.text! += list.items[i][0] + "\t $" + list.items[i][1] + "\n"
        }
    }
}

