# Terraria 1.3.5 FishBot
Finally, a fishing bot that can be used on Mac (also works on Windows!)

Made in IntelliJ (GUI was made using the built-in form editor)

## Summary
This bot exploits a glitch in Terraria 1.3.1 and 1.3.5 that allows the player to cast multiple fishing lines at the same time, allowing for quick and efficient fishing.
In order for the glitch to work, the following needs to be true:
- A fishing rod needs to be in the hotbar and selected
- Autopause **must** be turned on
- A large stack of items (such as dirt) needs to be in the inventory

## Usage
The GUI provides the following input values:
- Cast __ lines at a time
- Repeat __ times
- [Run Script] after __ seconds

As well as the following checkboxes:
- Wait for empty stack
- Warn me before starting

## Running the Script
1. Fill in the appropriate values. Any value less than 1 will not be accepted.
2. Click *Run Script*. If *Warn me before starting* is checked, the script will start after the message box is closed.
3. Hover the mouse **over the large stack of items** and wait.
4. After a few seconds, the script will start and you can go do something else for a while.

## Other Notes
- Try to center the mouse pointer on the sprite of the item itself, not the number of items or the background, so that the program doesn't hang or end early.
- This program assumes Left-Click uses an item, Right-Click throws away an item, and Escape opens inventory. In other words, the default Terraria controls are used here.
- *Wait for empty stack* does exactly as it says, and it ignores the number of repeats. **Be careful when using this.**
- The glitch used by this bot may or may not be patched in a later version of Terraria.
- The GUI uses the font from Terraria (Andy Bold), which I had to install manually. You may have to do the same.

I hope my fellow Mac users can get as much out of this as I did. Happy Fishing!
