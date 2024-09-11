Need a way of saving and loading game state

High level things to save:
1. Menu
2. State of locations
3. Player attributes
4. Inventory

- Save current menuDeque?
	- How to represent menuDeque in external file
	- Instead of current menuDeque, save location and, upon load, generate a new menu for that location?
- Save individual files for locations?
	- Start with a simple `visited?` flag
