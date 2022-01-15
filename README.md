# Relativity-Simulator
  This project I started last summer(2020 after Freshman) may help one understand the consequences of the special relativity theory, by setting the speed of light to an adjustablye understandably-slow value: 100px per second.
# First folder, lorentz_on_matrix:
  Lets the user draw a 2d shape on one of the two time-location graph's, which show identical universes viewed by two reference frames with a constant velocity difference. This way it helps understand the analogy of how we are like photons of a 4D space, as we speed up in regular dimensions, we slow down in time dimension.
### How to use
Using the\
```  ...\Special Relativity\Lorentz\classes>java Lorentz```
 on windows terminal, will open two windows stacked on top of each other, which show identical universes viewed by two reference frames with a constant velocity difference. Use your mouse to draw a movement on vertical axis: time, horisontal axis: location. Observe time and length contramption, and impassability of the speed of light(45 degree angle).\
Simply closing one of the two windows will stop the program.
![alt text](https://github.com/seco-lorem/RelativitySimulator/blob/main/RelativitySimulatorGame/design-todo-readMe/Demo.png)
# Second folder, RelativitySimulatorGame:
  Lets the user control the speed of a reference frame and view a fixed portion of the space containing 3 randomly created creatures from that frame of reference. Uses the same lorentz algorithm with the other one.\
  I had further feature intentions but haven't really worked on it for 1 year and am not thinking of. These features include:\
-Use mouse to select-deselect a creature.\
-Use space to create an observable event at any time instance.\
-Observe the creatures move by themselves according to pre-defined Movement class objects.\
-Observe the static grids\
-Set a selected creature as the reference frame.\
-Take control of a creature.\
-Use esc button to toggle if the game is paused.(Currently pausing works but not continue)
### How to use
Do not directly double click the jar file, instead run in an environment where you can view a log. For example on windows, use:\
```java -jar 1DRelativitySimulator.jar```
in the according directiory on a terminal. It will take 1 second for the creatures to render.
\nUse left and right buttons to controll the speed of the reference frame. Note that I've fixed the portion of the universe around the objects so that the player does not get lost in high speeds. But you can still observe the time and length contramption.\
Use ```esc```, to stop the game and analyse the log on terminal.
#### Design
![Design](https://github.com/seco-lorem/RelativitySimulator/blob/main/RelativitySimulatorGame/design-todo-readMe/Design.png)
