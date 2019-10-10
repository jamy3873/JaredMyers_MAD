//
//  FortuneData.swift
//  FortuneCookie
//
//  Created by Jared on 10/6/19.
//  Copyright © 2019 Jared. All rights reserved.
//

import Foundation

class Fortune{
    var fortuneText:String
    var fortuneType:String
    
    init(_ text:String,_ type:String){
        fortuneText = text
        fortuneType = type
    }
}

var allTypes:[String] = ["All", "Finances", "Health", "Relationships", "Wisdom"]

var fortuneData:[[String]] = [
    ["A beautiful, smart, and loving person will be coming into your life",allTypes[3]],
    ["Do not make extra work for yourself",allTypes[2]],
    ["Go take a rest; you deserve it",allTypes[2]],
    ["In order to take, one must first give",allTypes[3]],
    ["Things don’t just happen; they happen just",allTypes[4]],
    ["Well done is better than well said",allTypes[4]],
    ["You are admired by everyone for your talent and ability",allTypes[3]],
    ["You have a friendly heart and are well admired",allTypes[3]],
    ["You will be successful in your work",allTypes[1]],
    ["You will enjoy good health",allTypes[2]],
    ["You will make change for the better",allTypes[3]],
    ["Someone you care about seeks reconciliation",allTypes[3]],
    ["Sift through your past to get a better idea of the present",allTypes[4]],
    ["Stand tall. Don’t look down upon yourself",allTypes[2]],
    ["Nature, time and patience are the three great physicians",allTypes[4]],
    ["New people will bring you new realizations, especially about big issues",allTypes[3]],
    ["Meditation with an old enemy is advised",allTypes[4]],
    ["If you wish to see the best in others, show the best of yourself",allTypes[3]],
    ["For hate is never conquered by hate. Hate is conquered by love",allTypes[3]],
    ["Don’t worry; prosperity will knock on your door soon",allTypes[1]],
    ["Change is happening in your life, so go with the flow",allTypes[2]],
    ["An important person will offer you support",allTypes[3]],
    ["Accept something that you cannot change, and you will feel better",allTypes[4]],
    ["Because you demand more from yourself, others respect you deeply",allTypes[3]],
    ["Bide your time, for success is near",allTypes[1]],
    ["Dedicate yourself with a calm mind to the task at hand",allTypes[2]],
    ["Everywhere you choose to go, friendly faces will greet you",allTypes[3]],
    ["Happiness begins with facing life with a smile and a wink",allTypes[3]],
    ["Long life is in store for you",allTypes[2]],
    ["Stand tall. Don’t look down upon yourself",allTypes[2]],
    ["The sure way to predict the future is to invent it",allTypes[4]],
    ]




