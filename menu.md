# Menu

## LocationMenu
```
---------------------------
(This information is always present)
Location: Tower
HP: 100
Weapon: Sword
Armor: Steel
Gold: 100
---------------------------


Location Menu (this header changes based on current player location or menu choice)
-------------------------
1. Ascend (Option based on current player location)
2. Descend (Option based on current player location)
3. Exit (if floor 1) (Option based on current player location)
4. Inventory (Present in all (or most) menus)
5. Stats (Present in all (or most) menus)
6. Quit Game (Present in all (or most) menus)
```

## InventoryMenu
```
---------------------------
(This information is always present)
Location: Tower
HP: 100
Weapon: Sword
Armor: Steel
Gold: 100
---------------------------


Inventory Menu (this header changes based on current player location or menu choice)
-------------------------
1. Item 1
2. Item 2
3. Item 3
4. Back (Leads back to Location Menu)
```

## ItemMenu
```
---------------------------
(This information is always present)
Location: Tower
HP: 100
Weapon: Sword
Armor: Steel
Gold: 100
---------------------------


Item Menu (this header changes based on current player location or menu choice)
-------------------------

--------------------------
Item Name: Sword
Item Description: A sword
Stats: +2 attack
---------------------------

1. Equip/Unequip/Use (based on type of item and whether or not it's equipped)
2. Back (Leads back to Inventory Menu)
```

## StatsMenu
```
---------------------------
(This information is always present)
Location: Tower
HP: 100
Weapon: Sword
Armor: Steel
Gold: 100
---------------------------


Stats Menu (this changes based on current player location or menu choice)
-------------------------

--------------------------
HP: 100
Attack: 100
Defense: 100
---------------------------

1. Back (Leads back to Location Menu)
```

## Objects

* `InfoBanner`
  * Location
  * HP
  * Weapon
  * Armor
  * Gold

* `LocationMenu`
  * Location specific options
  * Player Options (Inventory, Stats)
  * Game Options (Quit Game)
  
* `InventoryMenu`
  * List of items
  * Back
  
* `ItemMenu`
  * ItemBanner
  * ItemOptions
  * Back
  
* `StatsMenu`
  * StatsBanner
  * Back
  
  

