# Menu

- **Ascend** - Context driven action
- **Descend** - Context driven action
- **Leave** - Context driven action
- **Player** - Leads to player submenu
  - Stats - Leads to stats display
  - Return - Leave player submenu and return to base menu
- **Inventory** - Leads to inventory submenu (list of items)
  - Items
    - Individual items - Leads to Use/Return submenu
    - Return - Leave item list and return to inventory menu
  - Equipment
    - Individual equipment - Leads to Equip/Unequip/Return submenu
    - Return - Leave equipment list and return to inventory menu
  - Return - Leave Inventory menu and return to base menu
- **Save**
- **Load**
- **Exit**

Assumptions:
- Probably need to save previous menu as a variable so that we can return to it
- Need a way of generating submenus that doesn't couple menus and actions together

